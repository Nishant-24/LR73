/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.service.AuthProcedureLocalService;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.cases.management.service.base.AuthorizationServiceBaseImpl;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.enums.DataRequestType;
import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.common.invoker.ThresholdInvoker;
import com.argus.oth.integration.mulesoft.CaseAuthorizationMuleSoftIntegration;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import io.swagger.client.model.CaseAuthorization;
import io.swagger.client.model.Items4;
import io.swagger.client.model.Type2;
import io.swagger.client.model.Type3;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the authorization remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.AuthorizationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jaclyn Ong
 * @see AuthorizationServiceBaseImpl
 */
@Component(
	property = {"json.web.service.context.name=oth", "json.web.service.context.path=Authorization"},
	service = AopService.class
)
public class AuthorizationServiceImpl extends AuthorizationServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.argus.oth.cases.management.service.AuthorizationServiceUtil</code> to access the authorization remote service.
	 */
	public JSONObject authorize(
			Authorization authorization, String rtcAuthorizationStatus, String processStatus, long modifiedUserId,
			String comments)
		throws Exception {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Authorization.class.getCanonicalName(), authorization.getCompanyId(), OTHConstants.AUTHORIZE)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, Authorization.class.getName(), 0, OTHConstants.AUTHORIZE);
		}

		User modifiedUser = _userLocalService.fetchUser(modifiedUserId);

		if (Objects.isNull(modifiedUser)) {
			if (_log.isErrorEnabled()) {
				_log.error("User with userId " + modifiedUserId + " cannot be found");
			}

			return null;
		}

		authorization.setModifiedUserId(modifiedUserId);

		Date modifiedUTCDate = _dateFormatter.convertToUTC(new Date());

		authorization.setModifiedDate(modifiedUTCDate);

		authorization.setStatusChangeDate(modifiedUTCDate);

		authorization.setRtcAuthorizationStatus(rtcAuthorizationStatus);

		ReferenceTypeCode authStatusReferenceTypeCode = _referenceTypeCodeLocalService.fetchByKey(
			rtcAuthorizationStatus);

		authorization.setAuthStatus(authStatusReferenceTypeCode.getDescription());

		String existingComments = authorization.getComments();

		String formattedNewComment = _getFormattedComment(
			_getComment(comments, rtcAuthorizationStatus), modifiedUser, modifiedUTCDate);

		String fullComments = _getFullComments(existingComments, formattedNewComment);

		authorization.setComments(fullComments);

		authorization.setProcessStatus(processStatus);

		authorization.setRowProcessed(PwdGenerator.getPassword(8));

		authorization = authorizationPersistence.update(authorization);

		return _callPatchAuthorizationMuleSoftEndpoint(authorization, formattedNewComment);
	}

	public List<Authorization> getAuthorizationsByCaseId(long caseId, long externalCaseId, int start, int end)
		throws Exception {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Authorization.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), ActionKeys.VIEW)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, Authorization.class.getName(), 0, ActionKeys.VIEW);
		}

		_thresholdInvoker.invokeByCase(
			caseId, DataRequestType.AUTHORIZATION, _getIntegrationFunction(externalCaseId),
			response -> _processAuthorizationUpdates(caseId, response));

		return authorizationLocalService.getAuthorizationsByCaseId(caseId, start, end);
	}

	private JSONObject _callPatchAuthorizationMuleSoftEndpoint(Authorization authorization, String formattedNewComment)
		throws Exception {

		Cases cases = _casesLocalService.fetchCases(authorization.getCaseId());

		if (Objects.isNull(cases)) {
			if (_log.isErrorEnabled()) {
				_log.error("Case with caseId " + authorization.getCaseId() + " cannot be found");
			}

			return null;
		}

		String finalFormattedComment = StringUtil.replace(
			formattedNewComment, OTHConstants.HTML_NEW_LINE, StringPool.NEW_LINE);

		JSONObject authorizationResponse = _caseAuthorizationMuleSoftIntegration.patchCaseAuthorizations(
			PortalUUIDUtil.generate(), authorization.getExternalAuthorizationId(), cases.getExternalCaseId(),
			authorization.getUuid(), authorization.getRtcAuthorizationStatus(), finalFormattedComment,
			authorization.getModifiedUserId(), authorization.getStatusChangeDate());

		_dataRequestLocalService.setDataRequestLastUpdatedDate(
			cases.getClientId(), cases.getCaseId(), cases.getExternalCaseId(), DataRequestType.AUTHORIZATION.name());

		return authorizationResponse;
	}

	private String _getComment(String comment, String rtcAuthorizationStatus) {
		if (Validator.isBlank(comment)) {
			if (rtcAuthorizationStatus.equalsIgnoreCase(OTHConstants.AUTHORIZATION_APPROVED_STATUS_KEY)) {
				return _DEFAULT_APPROVED_COMMENT;
			}
			else if (rtcAuthorizationStatus.equalsIgnoreCase(OTHConstants.AUTHORIZATION_DENIED_STATUS_KEY)) {
				return _DEFAULT_DECLINED_COMMENT;
			}
		}

		return comment;
	}

	private String _getFormattedComment(String newComment, User user, Date statusChangeDate) {
		StringBundler commentSB = new StringBundler();

		commentSB.append(user.getFullName());
		commentSB.append(StringPool.SPACE);
		commentSB.append(StringPool.DASH);
		commentSB.append(StringPool.SPACE);
		commentSB.append(user.getEmailAddress());
		commentSB.append(StringPool.SPACE);
		commentSB.append(StringPool.DASH);
		commentSB.append(StringPool.SPACE);
		commentSB.append(_dateFormatter.getFormattedDateTime(statusChangeDate, user.getTimeZone(), StringPool.BLANK));
		commentSB.append(StringPool.COLON);
		commentSB.append(OTHConstants.HTML_NEW_LINE);
		commentSB.append(StringUtil.replace(newComment, StringPool.NEW_LINE, OTHConstants.HTML_NEW_LINE));

		return commentSB.toString();
	}

	private String _getFullComments(String existingComments, String formattedNewComment) {
		StringBundler commentsSB = new StringBundler();

		commentsSB.append(existingComments);
		commentsSB.append(OTHConstants.HTML_NEW_LINE);
		commentsSB.append(OTHConstants.HTML_NEW_LINE);
		commentsSB.append(formattedNewComment);

		return commentsSB.toString();
	}

	private Function<String, List<CaseAuthorization>> _getIntegrationFunction(long externalCaseId) {
		return lastUpdatedDateString -> {
			try {
				return _caseAuthorizationMuleSoftIntegration.getCaseAuthorizations(
					PortalUUIDUtil.generate(), externalCaseId, lastUpdatedDateString);
			}
			catch (Exception e) {
				if (_log.isErrorEnabled()) {
					_log.error("Failed to get authorizations from MuleSoft", e);
				}

				return new ArrayList<>();
			}
		};
	}

	private void _processAuthorizationUpdates(long caseId, List<CaseAuthorization> caseAuthorizations) {
		for (CaseAuthorization caseAuthorization : caseAuthorizations) {
			BigDecimal authorizationId = caseAuthorization.getAuthorizationId();

			long externalAuthorizationId = authorizationId.longValue();

			Date effectiveFrom = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseAuthorization.getEffectiveFromDate());

			Date effectiveThru = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseAuthorization.getEffectiveToDate());

			Date receivedDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseAuthorization.getReceiveDate());

			Date statusChangeDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseAuthorization.getStatusChangeDate());

			Date externalModifiedDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(
				caseAuthorization.getModifiedDateTime());

			Type2 member = caseAuthorization.getAuthorizationMember();
			Type3 authorizationType = caseAuthorization.getAuthorizationType();
			Type3 authorizationCategory = caseAuthorization.getAuthorizationCategory();
			Type3 authorizationStatus = caseAuthorization.getAuthorizationStatus();

			String authorizationNumber = caseAuthorization.getAuthorizationNumber();
			String facility = caseAuthorization.getFacility();

			String finalFormattedComments = StringPool.BLANK;

			if (!Validator.isBlank(caseAuthorization.getComments())) {
				finalFormattedComments = StringUtil.replace(
					caseAuthorization.getComments(), StringPool.NEW_LINE, OTHConstants.HTML_NEW_LINE);
			}

			String rtcAuthorizationType = StringPool.BLANK;
			String category = StringPool.BLANK;
			String rtcAuthorizationStatus = StringPool.BLANK;
			String authStatus = StringPool.BLANK;

			long memberId = 0L;

			Authorization existingAuthorization = authorizationLocalService.fetchAuthorizationByExternalAuthorizationId(
				externalAuthorizationId);

			long groupId = _othCommonHelper.getOTHPortalGroupId();

			if (Objects.nonNull(existingAuthorization) && (groupId != existingAuthorization.getGroupId())) {
				groupId = existingAuthorization.getGroupId();
			}

			Cases cases = _casesLocalService.fetchCases(caseId);

			long clientId = 0;

			if (Objects.nonNull(cases)) {
				clientId = cases.getClientId();
			}

			long clientGroupId = 0;

			if (Objects.nonNull(cases)) {
				clientGroupId = cases.getClientGroupId();
			}

			if (Objects.nonNull(member)) {
				Member updatedMember = _memberLocalService.upsertMember(groupId, clientId, clientGroupId, member);

				memberId = updatedMember.getMemberId();
			}

			if (Objects.nonNull(authorizationType)) {
				rtcAuthorizationType = authorizationType.getKey();

				_upsertReferenceTypeCode(groupId, authorizationType);
			}

			if (Objects.nonNull(authorizationCategory)) {
				category = authorizationCategory.getDescription();
			}

			if (Objects.nonNull(authorizationStatus)) {
				rtcAuthorizationStatus = authorizationStatus.getKey();

				authStatus = authorizationStatus.getDescription();

				_upsertReferenceTypeCode(groupId, authorizationStatus);
			}

			String procedureCodeString = _updateProcedureCodes(
				caseAuthorization.getProcedureCodes(), externalAuthorizationId, authorizationNumber);

			if (Objects.isNull(existingAuthorization)) {
				authorizationLocalService.addAuthorization(
					_othCommonHelper.getOTHPortalGroupId(), caseId, externalAuthorizationId, memberId, null,
					rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate, authorizationNumber, category,
					rtcAuthorizationType, facility, procedureCodeString, finalFormattedComments, externalModifiedDate,
					effectiveFrom, effectiveThru, ProcessStatusType.SUCCESS.toString(), StringPool.BLANK,
					PwdGenerator.getPassword(8));

				continue;
			}

			authorizationLocalService.updateAuthorization(
				existingAuthorization.getAuthorizationId(), externalAuthorizationId, memberId, rtcAuthorizationStatus,
				authStatus, statusChangeDate, receivedDate, authorizationNumber, category, rtcAuthorizationType,
				facility, procedureCodeString, finalFormattedComments, externalModifiedDate, effectiveFrom,
				effectiveThru);
		}
	}

	private String _updateProcedureCodes(List<Items4> procedureCodes, long externalAuthorizationId, String authNumber) {
		_authProcedureLocalService.deleteByAuthNumber(authNumber);

		if (Objects.isNull(procedureCodes)) {
			return StringPool.BLANK;
		}

		StringBundler procedureCodeSB = new StringBundler();

		int lastIndex = procedureCodes.size() - 1;

		for (int i = 0; i < procedureCodes.size(); i++) {
			Items4 authProcedure = procedureCodes.get(i);

			_authProcedureLocalService.addAuthProcedure(
				externalAuthorizationId, authNumber, authProcedure.getCode(), authProcedure.getDescription(), null,
				null);

			procedureCodeSB.append(authProcedure.getDescription());

			if (i < lastIndex) {
				procedureCodeSB.append(StringPool.PIPE);
			}
		}

		return procedureCodeSB.toString();
	}

	private void _upsertReferenceTypeCode(long groupId, Type3 referenceTypeCode) {
		ReferenceTypeCode existingReferenceTypeCode = _referenceTypeCodeLocalService.fetchByKey(
			referenceTypeCode.getKey());

		BigDecimal externalReferenceTypeCodeIdBD = referenceTypeCode.getId();

		long externalReferenceTypeCodeId = externalReferenceTypeCodeIdBD.longValue();

		if (Objects.isNull(existingReferenceTypeCode)) {
			_referenceTypeCodeLocalService.addReferenceTypeCode(
				groupId, externalReferenceTypeCodeId, referenceTypeCode.getType(), referenceTypeCode.getKey(),
				referenceTypeCode.getDescription(), null, null, PwdGenerator.getPassword(8));

			return;
		}

		existingReferenceTypeCode.setDescription(referenceTypeCode.getDescription());

		_referenceTypeCodeLocalService.updateReferenceTypeCode(existingReferenceTypeCode);
	}

	private static final String _DEFAULT_APPROVED_COMMENT = "Approved";

	private static final String _DEFAULT_DECLINED_COMMENT = "Declined";

	private static final Log _log = LogFactoryUtil.getLog(AuthorizationServiceImpl.class);

	@Reference
	private AuthProcedureLocalService _authProcedureLocalService;

	@Reference
	private CaseAuthorizationMuleSoftIntegration _caseAuthorizationMuleSoftIntegration;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private DataRequestLocalService _dataRequestLocalService;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private MemberLocalService _memberLocalService;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private ReferenceTypeCodeLocalService _referenceTypeCodeLocalService;

	@Reference
	private ThresholdInvoker<CaseAuthorization> _thresholdInvoker;

	@Reference
	private UserLocalService _userLocalService;

}