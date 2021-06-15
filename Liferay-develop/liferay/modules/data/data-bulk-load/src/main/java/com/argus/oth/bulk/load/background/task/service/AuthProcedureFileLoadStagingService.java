package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingAuthProcedure;
import com.argus.oth.cases.management.service.StagingAuthProcedureLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = AuthProcedureFileLoadStagingService.class)
public class AuthProcedureFileLoadStagingService extends BaseFileLoadStagingService<StagingAuthProcedure> {

	@Override
	public void cleanup() {
		_stagingAuthProcedureLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "AuthProcedure";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "MemberAuthorizationId"
		).put(
			1, "AuthNumber"
		).put(
			2, "MedicalCodeUd"
		).put(
			3, "Description"
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
	protected StagingAuthProcedure getStagingModel(String[] fields) {
		StagingAuthProcedure stagingAuthProcedure = _stagingAuthProcedureLocalService.createStagingAuthProcedure(0);

		stagingAuthProcedure.setExternalAuthorizationId(GetterUtil.getLong(fields[0]));
		stagingAuthProcedure.setAuthNumber(fields[1]);
		stagingAuthProcedure.setMedicalCodeId(fields[2]);
		stagingAuthProcedure.setDescription(fields[3]);
		stagingAuthProcedure.setExternalModifiedDate(fields[4]);
		stagingAuthProcedure.setExternalCreatedDate(fields[5]);

		return stagingAuthProcedure;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingAuthProcedure.class.getName();
	}

	@Override
	protected void insert(StagingAuthProcedure stagingAuthProcedure) {
		_stagingAuthProcedureLocalService.addStagingAuthProcedure(
			stagingAuthProcedure.getExternalAuthorizationId(), stagingAuthProcedure.getAuthNumber(),
			stagingAuthProcedure.getMedicalCodeId(), stagingAuthProcedure.getDescription(),
			stagingAuthProcedure.getExternalModifiedDate(), stagingAuthProcedure.getExternalCreatedDate());
	}

	@Reference
	private StagingAuthProcedureLocalService _stagingAuthProcedureLocalService;

}