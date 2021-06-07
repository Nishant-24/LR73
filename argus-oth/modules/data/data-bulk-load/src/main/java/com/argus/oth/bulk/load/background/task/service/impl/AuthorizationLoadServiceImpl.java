package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.model.StagingAuthorization;
import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.model.StagingMember;
import com.argus.oth.cases.management.service.AuthorizationLocalService;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.StagingAuthorizationLocalService;
import com.argus.oth.cases.management.service.StagingCasesLocalService;
import com.argus.oth.cases.management.service.StagingMemberLocalService;
import com.argus.oth.common.enums.DataRequestType;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.Authorization",
		"staging.model.name=com.argus.oth.cases.management.model.StagingAuthorization"
	},
	service = AopService.class
)
public class AuthorizationLoadServiceImpl
	extends BaseLoadService implements AopService, LoadService<StagingAuthorization> {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean load(String randomString) {
		List<StagingAuthorization> stagingAuthorizationList =
			_stagingAuthorizationLocalService.getStagingAuthorizations(-1, -1);

		for (StagingAuthorization stagingAuthorization : stagingAuthorizationList) {
			_upsertAuthorization(stagingAuthorization, randomString);
		}

		return true;
	}

	@Override
	public boolean validate(StagingAuthorization stagingAuthorization) {
		long externalAuthorizationId = stagingAuthorization.getExternalAuthorizationId();

		StagingCases cases = _stagingCasesLocalService.getStagingCasesByExternalCaseId(
			String.valueOf(stagingAuthorization.getExternalCaseId()));

		StagingMember member = _stagingMemberLocalService.getByExternalMemberId(
			stagingAuthorization.getExternalMemberId());

		if ((cases == null) || (member == null)) {
			logError("Missing required field for Authorization ID " + externalAuthorizationId + ", skipping upsert");

			return false;
		}

		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingAuthorization.getExternalModifiedDate());

		if ((externalModifiedDate != null) && (minDate.compareTo(externalModifiedDate) == 0)) {
			logError(
				"Error parsing externalModifiedDate, Authorization ID " + externalAuthorizationId +
					", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "Authorization";
	}

	private void _upsertAuthorization(
		long caseId, long externalAuthorizationId, long memberId, String description, String rtcAuthorizationStatus,
		String authStatus, Date statusChangeDate, Date receivedDate, String authNumber, String category,
		String rtcAuthorizationType, String facility, String procedureCode, String comments, Date externalModifiedDate,
		Date effectiveFrom, Date effectiveThru, String randomString) {

		Authorization authorization = _authorizationLocalService.fetchAuthorizationByExternalAuthorizationId(
			externalAuthorizationId);

		String processedComments = processText(comments);

		if (authorization == null) {
			_authorizationLocalService.addAuthorization(
				getGroupId(), caseId, externalAuthorizationId, memberId, description, rtcAuthorizationStatus,
				authStatus, statusChangeDate, receivedDate, authNumber, category, rtcAuthorizationType, facility,
				procedureCode, processedComments, externalModifiedDate, effectiveFrom, effectiveThru, randomString);
		}
		else {
			authorization.setCreateDate(new Date());
			authorization.setCaseId(caseId);
			authorization.setExternalAuthorizationId(externalAuthorizationId);
			authorization.setMemberId(memberId);
			authorization.setDescription(description);
			authorization.setRtcAuthorizationStatus(rtcAuthorizationStatus);
			authorization.setAuthStatus(authStatus);
			authorization.setStatusChangeDate(statusChangeDate);
			authorization.setReceivedDate(receivedDate);
			authorization.setAuthNumber(authNumber);
			authorization.setCategory(category);
			authorization.setRtcAuthorizationType(rtcAuthorizationType);
			authorization.setFacility(facility);
			authorization.setProcedureCode(procedureCode);
			authorization.setComments(processedComments);
			authorization.setExternalModifiedDate(externalModifiedDate);
			authorization.setEffectiveFrom(effectiveFrom);
			authorization.setEffectiveThru(effectiveThru);
			authorization.setRowProcessed(randomString);
			authorization.setProcessStatus(ProcessStatusType.SUCCESS.name());

			_authorizationLocalService.updateAuthorization(authorization);
		}
	}

	private void _upsertAuthorization(StagingAuthorization stagingAuthorization, String randomString) {
		long authorizationId = stagingAuthorization.getExternalAuthorizationId();

		long externalCaseId = stagingAuthorization.getExternalCaseId();
		long externalMemberId = stagingAuthorization.getExternalMemberId();

		logDebug("Upserting authorization (ID: " + authorizationId + "; external case ID: " + externalCaseId + ")");

		if (!validate(stagingAuthorization)) {
			logError("Authorization " + authorizationId + ", invalid skipping upsert");

			return;
		}

		Cases cases = _casesLocalService.fetchCaseByExternalCaseId(externalCaseId);
		Member member = _memberLocalService.fetchByExternalMemberId(externalMemberId);

		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingAuthorization.getExternalModifiedDate());

		Date statusChangeDate = parseDate_yyyyMMddHHmmsss(stagingAuthorization.getStatusChangeDate());
		Date receivedDate = parseDate_yyyyMMddHHmmsss(stagingAuthorization.getReceivedDate());
		Date effectiveFrom = parseDate_yyyyMMddHHmmsss(stagingAuthorization.getEffectiveFrom());
		Date effectiveThru = parseDate_yyyyMMddHHmmsss(stagingAuthorization.getEffectiveThru());

		_upsertAuthorization(
			cases.getCaseId(), authorizationId, member.getMemberId(), stagingAuthorization.getDescription(),
			stagingAuthorization.getRtcAuthorizationStatus(), stagingAuthorization.getAuthStatus(), statusChangeDate,
			receivedDate, stagingAuthorization.getAuthNumber(), stagingAuthorization.getCategory(),
			stagingAuthorization.getRtcAuthorizationType(), stagingAuthorization.getFacility(),
			stagingAuthorization.getProcedureCode(), stagingAuthorization.getComments(), externalModifiedDate,
			effectiveFrom, effectiveThru, randomString);

		setDataRequestLastUpdatedDate(
			cases.getClientId(), cases.getCaseId(), cases.getExternalCaseId(), DataRequestType.AUTHORIZATION);
	}

	@Reference
	private AuthorizationLocalService _authorizationLocalService;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private MemberLocalService _memberLocalService;

	@Reference
	private StagingAuthorizationLocalService _stagingAuthorizationLocalService;

	@Reference
	private StagingCasesLocalService _stagingCasesLocalService;

	@Reference
	private StagingMemberLocalService _stagingMemberLocalService;

}