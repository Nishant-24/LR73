package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.model.StagingClient;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.service.StagingClientLocalService;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.Client",
		"staging.model.name=com.argus.oth.cases.management.model.StagingClient"
	},
	service = AopService.class
)
public class ClientLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingClient> {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean load(String randomString) {
		//todo: move to validate
		Long groupId = getGroupId();

		if (groupId == null) {
			return false;
		}

		List<StagingClient> stagingClientList = _stagingClientLocalService.getStagingClientsByRowProcessed(false);

		for (StagingClient stagingClient : stagingClientList) {
			_upsertClient(groupId, stagingClient, randomString);
		}

		return true;
	}

	@Override
	public boolean validate(StagingClient stagingClient) {
		Long externalClientPk = parseLong(stagingClient.getExternalClientPk());
		Long clientId = parseLong(stagingClient.getClientId());

		if ((externalClientPk == null) || (clientId == null)) {
			logError("Failed to parse, skipping upsert");

			return false;
		}

		if ((externalClientPk == 0L) || (clientId == 0L) || Validator.isBlank(stagingClient.getClientName())) {
			logError("Missing required field, skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "Client";
	}

	private void _upsertClient(long groupId, StagingClient stagingClient, String randomString) {
		logDebug("Upserting Client (client ID: " + stagingClient.getClientId() + ")");

		Long externalClientPk = parseLong(stagingClient.getExternalClientPk());
		Long clientId = parseLong(stagingClient.getClientId());
		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingClient.getExternalModifiedDate());
		Date externalCreatedDate = parseDate_yyyyMMddHHmmsss(stagingClient.getExternalCreatedDate());

		stagingClient.setRowProcessed(true);

		_stagingClientLocalService.updateStagingClient(stagingClient);

		if (!validate(stagingClient)) {
			return;
		}

		Client client = _clientLocalService.fetchClientByExternalClientId(clientId);

		if (client == null) {
			_clientLocalService.addClient(
				groupId, externalClientPk, clientId, stagingClient.getClientName(), stagingClient.getTelephonyNumber(),
				externalModifiedDate, externalCreatedDate, randomString);
		}
		else {
			client.setExternalClientPk(externalClientPk);
			client.setClientName(stagingClient.getClientName());
			client.setTelephonyNumber(stagingClient.getTelephonyNumber());
			client.setExternalModifiedDate(externalModifiedDate);
			client.setExternalCreatedDate(externalCreatedDate);
			client.setRowProcessed(randomString);

			_clientLocalService.updateClient(client);
		}
	}

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private StagingClientLocalService _stagingClientLocalService;

}