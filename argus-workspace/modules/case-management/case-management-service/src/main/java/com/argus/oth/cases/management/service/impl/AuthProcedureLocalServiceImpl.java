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

import com.argus.oth.cases.management.model.AuthProcedure;
import com.argus.oth.cases.management.service.base.AuthProcedureLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the auth procedure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.AuthProcedureLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthProcedureLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.AuthProcedure", service = AopService.class)
public class AuthProcedureLocalServiceImpl extends AuthProcedureLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.AuthProcedureLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.AuthProcedureLocalServiceUtil</code>.
	 */
	public AuthProcedure addAuthProcedure(
		long externalAuthorizationId, String authNumber, String medicalCodeId, String description,
		Date externalModifiedDate, Date externalCreatedDate) {

		long authProcedureId = counterLocalService.increment(AuthProcedure.class.getName());

		AuthProcedure authProcedure = createAuthProcedure(authProcedureId);

		Date currentDate = new Date();

		authProcedure.setCreateDate(currentDate);
		authProcedure.setModifiedDate(currentDate);

		authProcedure.setExternalAuthorizationId(externalAuthorizationId);
		authProcedure.setAuthNumber(authNumber);
		authProcedure.setMedicalCodeId(medicalCodeId);
		authProcedure.setDescription(description);
		authProcedure.setExternalModifiedDate(externalModifiedDate);
		authProcedure.setExternalCreatedDate(externalCreatedDate);

		return authProcedurePersistence.update(authProcedure);
	}

	public void deleteAll() {
		for (AuthProcedure authProcedure : authProcedurePersistence.findAll()) {
			deleteAuthProcedure(authProcedure);
		}
	}

	public void deleteByAuthNumber(String authNumber) {
		List<AuthProcedure> authProcedures = fetchAuthProceduresByAuthNumber(authNumber);

		for (AuthProcedure authProcedure : authProcedures) {
			deleteAuthProcedure(authProcedure);
		}
	}

	public AuthProcedure fetchAuthProcedureByA_M(String authNumber, String medicalCodeId) {
		return authProcedurePersistence.fetchByA_M(authNumber, medicalCodeId);
	}

	public List<AuthProcedure> fetchAuthProceduresByAuthNumber(String authNumber) {
		return authProcedurePersistence.findByAuthNumber(authNumber);
	}

}