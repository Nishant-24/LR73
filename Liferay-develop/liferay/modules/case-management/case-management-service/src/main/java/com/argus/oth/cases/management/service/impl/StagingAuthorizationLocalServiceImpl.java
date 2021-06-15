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

import com.argus.oth.cases.management.model.StagingAuthorization;
import com.argus.oth.cases.management.service.base.StagingAuthorizationLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging stagingAuthorization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingAuthorizationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthorizationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.StagingAuthorization", service = AopService.class
)
public class StagingAuthorizationLocalServiceImpl extends StagingAuthorizationLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingAuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingAuthorizationLocalServiceUtil</code>.
	 */
	public void addStagingAuthorization(
		long stagingAuthorizationId, long caseId, long externalMemberId, String description,
		String rtcAuthorizationStatus, String authStatus, String statusChangeDate, String receivedDate,
		String authNumber, String category, String rtcAuthorizationType, String facility, String procedureCode,
		String comments, String effectiveFrom, String effectiveThru, String externalCreateDate,
		String externalModifiedDate) {

		long id = counterLocalService.increment(StagingAuthorization.class.getName());

		StagingAuthorization stagingAuthorization = createStagingAuthorization(id);

		stagingAuthorization.setExternalAuthorizationId(stagingAuthorizationId);
		stagingAuthorization.setCreateDate(new Date());
		stagingAuthorization.setExternalCaseId(caseId);
		stagingAuthorization.setExternalMemberId(externalMemberId);
		stagingAuthorization.setDescription(description);
		stagingAuthorization.setRtcAuthorizationStatus(rtcAuthorizationStatus);
		stagingAuthorization.setAuthStatus(authStatus);
		stagingAuthorization.setStatusChangeDate(statusChangeDate);
		stagingAuthorization.setReceivedDate(receivedDate);
		stagingAuthorization.setAuthNumber(authNumber);
		stagingAuthorization.setCategory(category);
		stagingAuthorization.setRtcAuthorizationType(rtcAuthorizationType);
		stagingAuthorization.setFacility(facility);
		stagingAuthorization.setProcedureCode(procedureCode);
		stagingAuthorization.setComments(comments);
		stagingAuthorization.setEffectiveFrom(effectiveFrom);
		stagingAuthorization.setEffectiveThru(effectiveThru);
		stagingAuthorization.setExternalCreateDate(externalCreateDate);
		stagingAuthorization.setExternalModifiedDate(externalModifiedDate);

		addStagingAuthorization(stagingAuthorization);
	}

	public void deleteAllStagingAuthorizations() {
		for (StagingAuthorization stagingAuthorization : stagingAuthorizationPersistence.findAll()) {
			deleteStagingAuthorization(stagingAuthorization);
		}
	}

}