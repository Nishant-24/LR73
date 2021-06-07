package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingAuthorization;
import com.argus.oth.cases.management.service.StagingAuthorizationLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = AuthorizationFileLoadStagingService.class)
public class AuthorizationFileLoadStagingService extends BaseFileLoadStagingService<StagingAuthorization> {

	@Override
	public void cleanup() {
		_stagingAuthorizationLocalService.deleteAllStagingAuthorizations();
	}

	@Override
	public String getEntityName() {
		return "Authorization";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "MemberAuthorizationID"
		).put(
			1, "CaseID"
		).put(
			2, "MemberID"
		).put(
			3, "AuthNumber"
		).put(
			6, "Facility"
		).put(
			7, "ReceiveDate"
		).put(
			8, "ProcCodes"
		).put(
			10, "AuthStatus"
		).put(
			12, "ModifiedDate"
		).put(
			13, "CreatedDate"
		).put(
			14, "RTCAuthorizationStatus"
		).put(
			15, "RTCAuthorizationType"
		).put(
			17, "Category"
		).put(
			18, "Comments"
		).put(
			20, "EffectiveFrom"
		).put(
			21, "EffectiveThru"
		).put(
			getMaxFieldArrayPosition(), "StatusChangeDate"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 25;
	}

	@Override
	protected StagingAuthorization getStagingModel(String[] fields) {
		StagingAuthorization stagingAuthorization = _stagingAuthorizationLocalService.createStagingAuthorization(0);

		stagingAuthorization.setExternalAuthorizationId(GetterUtil.getLong(fields[0]));
		stagingAuthorization.setExternalCaseId(GetterUtil.getLong(fields[1]));
		stagingAuthorization.setExternalMemberId(GetterUtil.getLong(fields[2]));
		stagingAuthorization.setDescription(fields[8]);
		stagingAuthorization.setRtcAuthorizationStatus(fields[14]);
		stagingAuthorization.setAuthStatus(fields[10]);
		stagingAuthorization.setStatusChangeDate(fields[24]);
		stagingAuthorization.setReceivedDate(fields[7]);
		stagingAuthorization.setAuthNumber(fields[3]);
		stagingAuthorization.setCategory(fields[17]);
		stagingAuthorization.setRtcAuthorizationType(fields[15]);
		stagingAuthorization.setFacility(fields[6]);
		stagingAuthorization.setProcedureCode(fields[8]);
		stagingAuthorization.setComments(fields[18]);
		stagingAuthorization.setEffectiveFrom(fields[20]);
		stagingAuthorization.setEffectiveThru(fields[21]);
		stagingAuthorization.setExternalCreateDate(fields[13]);
		stagingAuthorization.setExternalModifiedDate(fields[12]);

		return stagingAuthorization;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingAuthorization.class.getName();
	}

	@Override
	protected void insert(StagingAuthorization stagingAuthorization) {
		_stagingAuthorizationLocalService.addStagingAuthorization(
			stagingAuthorization.getExternalAuthorizationId(), stagingAuthorization.getExternalCaseId(),
			stagingAuthorization.getExternalMemberId(), stagingAuthorization.getDescription(),
			stagingAuthorization.getRtcAuthorizationStatus(), stagingAuthorization.getAuthStatus(),
			stagingAuthorization.getStatusChangeDate(), stagingAuthorization.getReceivedDate(),
			stagingAuthorization.getAuthNumber(), stagingAuthorization.getCategory(),
			stagingAuthorization.getRtcAuthorizationType(), stagingAuthorization.getFacility(),
			stagingAuthorization.getProcedureCode(), stagingAuthorization.getComments(),
			stagingAuthorization.getEffectiveFrom(), stagingAuthorization.getEffectiveThru(),
			stagingAuthorization.getExternalCreateDate(), stagingAuthorization.getExternalModifiedDate());
	}

	@Reference
	private StagingAuthorizationLocalService _stagingAuthorizationLocalService;

}