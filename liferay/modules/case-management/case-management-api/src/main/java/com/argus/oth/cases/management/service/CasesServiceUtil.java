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
 * Provides the remote service utility for Cases. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.CasesServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CasesService
 * @generated
 */
public class CasesServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.CasesServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.argus.oth.cases.management.model.Cases fetchCaseByCaseId(
			long caseId)
		throws Exception {

		return getService().fetchCaseByCaseId(caseId);
	}

	public static com.argus.oth.cases.management.model.Cases
		fetchCaseByExternalCaseId(long externalCaseId) {

		return getService().fetchCaseByExternalCaseId(externalCaseId);
	}

	public static com.argus.oth.cases.management.model.Cases fetchCases(
		long caseId) {

		return getService().fetchCases(caseId);
	}

	public static java.util.List<com.argus.oth.cases.management.model.Cases>
			getCasesByG_C(long groupId, long clientId)
		throws Exception {

		return getService().getCasesByG_C(groupId, clientId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CasesService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CasesService, CasesService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CasesService.class);

		ServiceTracker<CasesService, CasesService> serviceTracker =
			new ServiceTracker<CasesService, CasesService>(
				bundle.getBundleContext(), CasesService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}