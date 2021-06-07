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
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.base.AuthorizationLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PwdGenerator;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the authorization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.AuthorizationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Authorization", service = AopService.class)
public class AuthorizationLocalServiceImpl extends AuthorizationLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.AuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.AuthorizationLocalServiceUtil</code>.
	 */
	public void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId, String description,
		String rtcAuthorizationStatus, String authStatus, Date statusChangeDate, Date receivedDate, String authNumber,
		String category, String rtcAuthorizationType, String facility, String procedureCode, String comments,
		Date externalModifiedDate, Date effectiveFrom, Date effectiveThru, String randomString) {

		addAuthorization(
			groupId, caseId, externalAuthorizationId, memberId, description, rtcAuthorizationStatus, authStatus,
			statusChangeDate, receivedDate, authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, externalModifiedDate, effectiveFrom, effectiveThru, ProcessStatusType.SUCCESS.toString(),
			StringPool.BLANK, randomString);
	}

	public void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId, String description,
		String rtcAuthorizationStatus, String authStatus, Date statusChangeDate, Date receivedDate, String authNumber,
		String category, String rtcAuthorizationType, String facility, String procedureCode, String comments,
		Date externalModifiedDate, Date effectiveFrom, Date effectiveThru, String processStatus,
		String failureDescription, String randomString) {

		long id = counterLocalService.increment(Authorization.class.getName());

		Authorization authorization = createAuthorization(id);

		Group group = groupLocalService.fetchGroup(groupId);

		if (Objects.nonNull(group)) {
			authorization.setCompanyId(group.getCompanyId());
		}

		authorization.setGroupId(groupId);
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
		authorization.setComments(comments);
		authorization.setExternalModifiedDate(externalModifiedDate);
		authorization.setEffectiveFrom(effectiveFrom);
		authorization.setEffectiveThru(effectiveThru);
		authorization.setProcessStatus(processStatus);
		authorization.setFailureDescription(failureDescription);
		authorization.setRowProcessed(randomString);

		addAuthorization(authorization);

		try {
			User dataAdminUser = _userLocalService.fetchUserByScreenName(
				authorization.getCompanyId(), OTHConstants.DATA_ADMIN_USER_SCREEN_NAME);

			resourceLocalService.addResources(
				authorization.getCompanyId(), authorization.getGroupId(), dataAdminUser.getUserId(),
				Authorization.class.getName(), id, false, true, true);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	public Authorization deleteAuthorization(Authorization authorization) {
		if (Objects.nonNull(authorization)) {
			_removeResource(authorization);
		}

		return super.deleteAuthorization(authorization);
	}

	@Override
	public Authorization deleteAuthorization(long authorizationId) throws PortalException {
		Authorization authorization = authorizationPersistence.fetchByPrimaryKey(authorizationId);

		return deleteAuthorization(authorization);
	}

	public void deleteUnprocessed(String randomString) {
		List<Authorization> unprocessedAuthorizations = authorizationPersistence.findByRowProcessed_ProcessStatus(
			randomString, ProcessStatusType.FAILURE.name());

		for (Authorization authorization : unprocessedAuthorizations) {
			_log.info(
				String.format(
					OTHConstants.DELETE_LOG_STRING_FORMAT, Authorization.class.getSimpleName(),
					authorization.getExternalAuthorizationId(), authorization.getAuthorizationId()));

			deleteAuthorization(authorization);
		}
	}

	public Authorization fetchAuthorizationByExternalAuthorizationId(long externalAuthorizationId) {
		return authorizationPersistence.fetchByExternalAuthorizationId(externalAuthorizationId);
	}

	public List<Authorization> getAuthorizationsByAuthNumber(String authNumber) {
		return authorizationPersistence.findByAuthNumber(authNumber);
	}

	public List<Authorization> getAuthorizationsByCaseId(long caseId) {
		return authorizationPersistence.findByCaseId(caseId);
	}

	public List<Authorization> getAuthorizationsByCaseId(long caseId, int start, int end) {
		if ((start == 0) && (end == 0)) {
			return authorizationPersistence.findByCaseId(caseId);
		}

		return authorizationPersistence.findByCaseId(caseId, start, end);
	}

	public Authorization updateAuthorization(
		long authorizationId, long externalAuthorizationId, long memberId, String rtcAuthorizationStatus,
		String authStatus, Date statusChangeDate, Date receivedDate, String authNumber, String category,
		String rtcAuthorizationType, String facility, String procedureCode, String comments, Date externalModifiedDate,
		Date effectiveFrom, Date effectiveThru) {

		Authorization authorization = authorizationPersistence.fetchByPrimaryKey(authorizationId);

		if (Objects.isNull(authorization)) {
			return null;
		}

		authorization.setExternalAuthorizationId(externalAuthorizationId);
		authorization.setMemberId(memberId);
		authorization.setRtcAuthorizationStatus(rtcAuthorizationStatus);
		authorization.setAuthStatus(authStatus);
		authorization.setStatusChangeDate(statusChangeDate);
		authorization.setReceivedDate(receivedDate);
		authorization.setAuthNumber(authNumber);
		authorization.setCategory(category);
		authorization.setRtcAuthorizationType(rtcAuthorizationType);
		authorization.setFacility(facility);
		authorization.setProcedureCode(procedureCode);
		authorization.setComments(comments);
		authorization.setExternalModifiedDate(externalModifiedDate);
		authorization.setEffectiveFrom(effectiveFrom);
		authorization.setEffectiveThru(effectiveThru);
		authorization.setRowProcessed(PwdGenerator.getPassword(8));

		return authorizationPersistence.update(authorization);
	}

	public Authorization updateAuthorization(
		long authorizationId, long externalAuthorizationId, String processStatus, String failureDescription) {

		Authorization authorization = authorizationPersistence.fetchByPrimaryKey(authorizationId);

		if (Objects.isNull(authorization)) {
			return null;
		}

		authorization.setExternalAuthorizationId(externalAuthorizationId);
		authorization.setProcessStatus(processStatus);
		authorization.setFailureDescription(failureDescription);
		authorization.setRowProcessed(PwdGenerator.getPassword(8));

		return authorizationPersistence.update(authorization);
	}

	private void _removeResource(Authorization authorization) {
		try {
			resourceLocalService.deleteResource(
				authorization.getCompanyId(), Authorization.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				authorization.getAuthorizationId());
		}
		catch (PortalException pe) {
			_log.warn(pe.getMessage(), pe);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AuthorizationLocalServiceImpl.class);

	@Reference
	private UserLocalService _userLocalService;

}