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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Authorization. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.AuthorizationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationService
 * @generated
 */
public class AuthorizationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.AuthorizationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>AuthorizationServiceUtil</code> to access the authorization remote service.
	 */
	public static com.liferay.portal.kernel.json.JSONObject authorize(
			com.argus.oth.cases.management.model.Authorization authorization,
			String rtcAuthorizationStatus, String processStatus,
			long modifiedUserId, String comments)
		throws Exception {

		return getService().authorize(
			authorization, rtcAuthorizationStatus, processStatus,
			modifiedUserId, comments);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
				getAuthorizationsByCaseId(
					long caseId, long externalCaseId, int start, int end)
			throws Exception {

		return getService().getAuthorizationsByCaseId(
			caseId, externalCaseId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AuthorizationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AuthorizationService, AuthorizationService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthorizationService.class);

		ServiceTracker<AuthorizationService, AuthorizationService>
			serviceTracker =
				new ServiceTracker<AuthorizationService, AuthorizationService>(
					bundle.getBundleContext(), AuthorizationService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}