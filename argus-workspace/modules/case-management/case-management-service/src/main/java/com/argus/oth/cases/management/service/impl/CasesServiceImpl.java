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

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.base.CasesServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the cases remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.CasesService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesServiceBaseImpl
 */
@Component(
	property = {"json.web.service.context.name=oth", "json.web.service.context.path=Cases"}, service = AopService.class
)
public class CasesServiceImpl extends CasesServiceBaseImpl {

	public Cases fetchCaseByCaseId(long caseId) throws Exception {
		_checkPermission(ActionKeys.VIEW);

		return casesLocalService.fetchCases(caseId);
	}

	public Cases fetchCaseByExternalCaseId(long externalCaseId) {
		_checkPermissionQuietly(ActionKeys.VIEW);

		return casesLocalService.fetchCaseByExternalCaseId(externalCaseId);
	}

	public Cases fetchCases(long caseId) {
		_checkPermissionQuietly(ActionKeys.VIEW);

		return casesLocalService.fetchCases(caseId);
	}

	public List<Cases> getCasesByG_C(long groupId, long clientId) throws Exception {
		_checkPermission(ActionKeys.VIEW);

		return casesLocalService.getCasesByG_C(groupId, clientId);
	}

	private void _checkPermission(String actionKey) throws PrincipalException {
		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Cases.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), actionKey)) {

			throw new PrincipalException.MustHavePermission(permissionChecker, Cases.class.getName(), 0, actionKey);
		}
	}

	private void _checkPermissionQuietly(String actionKey) {
		try {
			_checkPermission(actionKey);
		}
		catch (PrincipalException e) {
			throw new RuntimeException(e);
		}
	}

}