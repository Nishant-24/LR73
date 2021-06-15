package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingClient;
import com.argus.oth.cases.management.service.StagingClientLocalService;

import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ClientFileLoadStagingService.class)
public class ClientFileLoadStagingService extends BaseFileLoadStagingService<StagingClient> {

	@Override
	public void cleanup() {
		_stagingClientLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "Client";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClientID"
		).put(
			1, "Client"
		).put(
			2, "ClientName"
		).put(
			3, "ThreecxTelNr"
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
	protected StagingClient getStagingModel(String[] fields) {
		StagingClient stagingClient = _stagingClientLocalService.createStagingClient(0);

		stagingClient.setExternalClientPk(fields[0]);
		stagingClient.setClientId(fields[1]);
		stagingClient.setClientName(fields[2]);
		stagingClient.setTelephonyNumber(fields[3]);
		stagingClient.setExternalModifiedDate(fields[4]);
		stagingClient.setExternalCreatedDate(fields[5]);

		return stagingClient;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingClient.class.getName();
	}

	@Override
	protected void insert(StagingClient stagingClient) {
		_stagingClientLocalService.addStagingClient(
			stagingClient.getExternalClientPk(), stagingClient.getClientId(), stagingClient.getClientName(),
			stagingClient.getTelephonyNumber(), stagingClient.getExternalModifiedDate(),
			stagingClient.getExternalCreatedDate());
	}

	@Reference
	private StagingClientLocalService _stagingClientLocalService;

}