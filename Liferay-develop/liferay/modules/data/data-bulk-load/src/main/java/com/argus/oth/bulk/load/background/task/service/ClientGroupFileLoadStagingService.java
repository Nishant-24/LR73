package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingClientGroup;
import com.argus.oth.cases.management.service.StagingClientGroupLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = ClientGroupFileLoadStagingService.class)
public class ClientGroupFileLoadStagingService extends BaseFileLoadStagingService<StagingClientGroup> {

	@Override
	public void cleanup() {
		_stagingClientGroupLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "ClientGroup";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClientGroupID"
		).put(
			1, "ClientID"
		).put(
			2, "ClientGroup"
		).put(
			3, "ClientGroupName"
		).put(
			4, "ModifiedDate"
		).put(
			getMaxFieldArrayPosition(), "CreatedDate"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 6;
	}

	@Override
	protected StagingClientGroup getStagingModel(String[] fields) {
		StagingClientGroup stagingClientGroup = _stagingClientGroupLocalService.createStagingClientGroup(0);

		stagingClientGroup.setExternalClientGroupId(GetterUtil.getLong(fields[0]));
		stagingClientGroup.setClientId(GetterUtil.getLong(fields[1]));
		stagingClientGroup.setClientGroup(fields[2]);
		stagingClientGroup.setClientGroupName(fields[3]);
		stagingClientGroup.setExternalModifiedDate(fields[4]);
		stagingClientGroup.setExternalCreatedDate(fields[5]);

		return stagingClientGroup;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingClientGroup.class.getName();
	}

	@Override
	protected void insert(StagingClientGroup stagingClientGroup) {
		_stagingClientGroupLocalService.addStagingClientGroup(
			stagingClientGroup.getExternalClientGroupId(), stagingClientGroup.getClientId(),
			stagingClientGroup.getClientGroup(), stagingClientGroup.getClientGroupName(),
			stagingClientGroup.getExternalModifiedDate(), stagingClientGroup.getExternalCreatedDate());
	}

	@Reference
	private StagingClientGroupLocalService _stagingClientGroupLocalService;

}