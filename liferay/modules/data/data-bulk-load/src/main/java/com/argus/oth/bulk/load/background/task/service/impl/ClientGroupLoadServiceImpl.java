package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.model.ClientGroup;
import com.argus.oth.cases.management.model.StagingClientGroup;
import com.argus.oth.cases.management.service.ClientGroupLocalService;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.service.StagingClientGroupLocalService;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.ClientGroup",
		"staging.model.name=com.argus.oth.cases.management.model.StagingClientGroup"
	},
	service = AopService.class
)
public class ClientGroupLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingClientGroup> {

	@Override
	public boolean validate(StagingClientGroup stagingClientGroup) {
		long externalClientGroupId = stagingClientGroup.getExternalClientGroupId();

		logDebug("Upserting clientGroup (ID: " + externalClientGroupId + ")");

		if (blankNullOrNullString(stagingClientGroup.getClientGroupName())) {
			logError("Missing required field for Client Group ID " + externalClientGroupId + ", skipping upsert");

			return false;
		}

		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingClientGroup.getExternalCreatedDate());

		if (dateParseFailed(createdDate)) {
			logError("Error parsing createdDate, Client Group ID " + externalClientGroupId + ", skipping upsert");

			return false;
		}

		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingClientGroup.getExternalModifiedDate());

		if (dateParseFailed(modifiedDate)) {
			logError("Error parsing modifiedDate, Client Group ID " + externalClientGroupId + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "ClientGroup";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingClientGroup> stagingClientGroups = _stagingClientGroupLocalService.getStagingClientGroups(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (StagingClientGroup stagingClientGroup : stagingClientGroups) {
			_upsertClientGroup(stagingClientGroup, randomString);
		}

		return true;
	}

	private Client _getClient(long externalClientPk) {
		return _clientLocalService.fetchClientByExternalClientPk(externalClientPk);
	}

	private void _upsertClientGroup(StagingClientGroup stagingClientGroup, String randomString) {
		long externalClientGroupId = stagingClientGroup.getExternalClientGroupId();

		logDebug("Upserting clientGroup (ID: " + externalClientGroupId + ")");

		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingClientGroup.getExternalModifiedDate());
		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingClientGroup.getExternalCreatedDate());

		long externalClientPK = stagingClientGroup.getClientId();

		if (!validate(stagingClientGroup)) {
			logError("ClientGroup " + externalClientGroupId + ", invalid skipping upsert");

			return;
		}

		Client client = _getClient(externalClientPK);

		if (client == null) {
			logError(
				"Unable to look up Client ID based on External Client PK " + externalClientPK + ", skipping upsert");

			return;
		}

		long externalClientId = client.getExternalClientId();

		ClientGroup clientGroup = _clientGroupLocalService.fetchByExternalClientGroupId(
			stagingClientGroup.getExternalClientGroupId());

		long groupId = getGroupId();

		if (Objects.isNull(clientGroup)) {
			_clientGroupLocalService.addClientGroup(
				groupId, stagingClientGroup.getExternalClientGroupId(), externalClientId,
				stagingClientGroup.getClientGroup(), stagingClientGroup.getClientGroupName(), modifiedDate, createdDate,
				randomString);
		}
		else {
			clientGroup.setGroupId(groupId);
			clientGroup.setClientId(externalClientId);
			clientGroup.setClientGroup(stagingClientGroup.getClientGroup());
			clientGroup.setClientGroupName(stagingClientGroup.getClientGroupName());
			clientGroup.setModifiedDate(modifiedDate);
			clientGroup.setCreateDate(createdDate);
			clientGroup.setRowProcessed(randomString);

			_clientGroupLocalService.updateClientGroup(clientGroup);
		}
	}

	@Reference
	private ClientGroupLocalService _clientGroupLocalService;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private StagingClientGroupLocalService _stagingClientGroupLocalService;

}