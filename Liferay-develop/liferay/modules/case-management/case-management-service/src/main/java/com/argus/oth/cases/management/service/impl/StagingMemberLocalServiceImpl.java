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

import com.argus.oth.cases.management.model.StagingMember;
import com.argus.oth.cases.management.service.base.StagingMemberLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingMemberLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingMemberLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.StagingMember", service = AopService.class)
public class StagingMemberLocalServiceImpl extends StagingMemberLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingMemberLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingMemberLocalServiceUtil</code>.
	 */
	public StagingMember addStagingMember(
		long externalMemberId, long clientId, long clientGroupId, String memberNumber, String memberFirstName,
		String memberLastName, String memberDOB, String certificationNumber, String rxNumber,
		String externalModifiedDate, String externalCreatedDate) {

		long stagingMemberId = counterLocalService.increment(StagingMember.class.getName());

		StagingMember stagingMember = stagingMemberPersistence.create(stagingMemberId);

		stagingMember.setExternalMemberId(externalMemberId);
		stagingMember.setClientId(clientId);
		stagingMember.setClientGroupId(clientGroupId);
		stagingMember.setMemberNumber(memberNumber);
		stagingMember.setMemberFirstName(memberFirstName);
		stagingMember.setMemberLastName(memberLastName);
		stagingMember.setMemberDOB(memberDOB);
		stagingMember.setCertificationNumber(certificationNumber);
		stagingMember.setRxNumber(rxNumber);
		stagingMember.setExternalModifiedDate(externalModifiedDate);
		stagingMember.setExternalCreatedDate(externalCreatedDate);

		stagingMember.setCreateDate(new Date());

		return addStagingMember(stagingMember);
	}

	public void deleteAllStagingMembers() {
		for (StagingMember stagingMember : stagingMemberPersistence.findAll()) {
			deleteStagingMember(stagingMember);
		}
	}

	public StagingMember getByExternalMemberId(long externalMemberId) {
		return stagingMemberPersistence.fetchByExternalMemberId(externalMemberId);
	}

}