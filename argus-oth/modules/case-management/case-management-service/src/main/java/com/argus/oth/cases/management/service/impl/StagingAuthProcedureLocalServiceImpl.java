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

import com.argus.oth.cases.management.model.StagingAuthProcedure;
import com.argus.oth.cases.management.service.base.StagingAuthProcedureLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging auth procedure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingAuthProcedureLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthProcedureLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.StagingAuthProcedure", service = AopService.class
)
public class StagingAuthProcedureLocalServiceImpl extends StagingAuthProcedureLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingAuthProcedureLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingAuthProcedureLocalServiceUtil</code>.
	 */
	public StagingAuthProcedure addStagingAuthProcedure(
		long externalAuthorizationId, String authNumber, String medicalCodeId, String description,
		String externalModifiedDate, String externalCreatedDate) {

		long stagingAuthProcedureId = counterLocalService.increment(StagingAuthProcedure.class.getName());

		StagingAuthProcedure stagingAuthProcedure = createStagingAuthProcedure(stagingAuthProcedureId);

		Date currentDate = new Date();

		stagingAuthProcedure.setCreateDate(currentDate);
		stagingAuthProcedure.setModifiedDate(currentDate);

		stagingAuthProcedure.setExternalAuthorizationId(externalAuthorizationId);
		stagingAuthProcedure.setAuthNumber(authNumber);
		stagingAuthProcedure.setMedicalCodeId(medicalCodeId);
		stagingAuthProcedure.setDescription(description);
		stagingAuthProcedure.setExternalModifiedDate(externalModifiedDate);
		stagingAuthProcedure.setExternalCreatedDate(externalCreatedDate);

		return stagingAuthProcedurePersistence.update(stagingAuthProcedure);
	}

	public void deleteAll() {
		for (StagingAuthProcedure stagingAuthProcedure : stagingAuthProcedurePersistence.findAll()) {
			deleteStagingAuthProcedure(stagingAuthProcedure);
		}
	}

}