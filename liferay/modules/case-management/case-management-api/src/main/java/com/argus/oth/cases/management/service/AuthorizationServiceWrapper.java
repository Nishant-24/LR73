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

package com.argus.oth.cases.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuthorizationService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationService
 * @generated
 */
public class AuthorizationServiceWrapper
	implements AuthorizationService, ServiceWrapper<AuthorizationService> {

	public AuthorizationServiceWrapper(
		AuthorizationService authorizationService) {

		_authorizationService = authorizationService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>AuthorizationServiceUtil</code> to access the authorization remote service.
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject authorize(
			com.argus.oth.cases.management.model.Authorization authorization,
			String rtcAuthorizationStatus, String processStatus,
			long modifiedUserId, String comments)
		throws Exception {

		return _authorizationService.authorize(
			authorization, rtcAuthorizationStatus, processStatus,
			modifiedUserId, comments);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
			getAuthorizationsByCaseId(
				long caseId, long externalCaseId, int start, int end)
		throws Exception {

		return _authorizationService.getAuthorizationsByCaseId(
			caseId, externalCaseId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _authorizationService.getOSGiServiceIdentifier();
	}

	@Override
	public AuthorizationService getWrappedService() {
		return _authorizationService;
	}

	@Override
	public void setWrappedService(AuthorizationService authorizationService) {
		_authorizationService = authorizationService;
	}

	private AuthorizationService _authorizationService;

}