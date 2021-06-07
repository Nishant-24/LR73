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

import com.argus.oth.cases.management.model.StagingClientGroup;
import com.argus.oth.cases.management.service.base.StagingClientGroupLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging client group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingClientGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientGroupLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.StagingClientGroup", service = AopService.class
)
public class StagingClientGroupLocalServiceImpl extends StagingClientGroupLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingClientGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingClientGroupLocalServiceUtil</code>.
	 */
	public StagingClientGroup addStagingClientGroup(
		long externalClientGroupId, long clientId, String clientGroup, String clientGroupName, String modifiedDate,
		String createdDate) {

		long stagingClientGroupId = counterLocalService.increment(StagingClientGroup.class.getName());

		StagingClientGroup stagingClientGroup = stagingClientGroupPersistence.create(stagingClientGroupId);

		stagingClientGroup.setExternalClientGroupId(externalClientGroupId);
		stagingClientGroup.setClientId(clientId);
		stagingClientGroup.setClientGroup(clientGroup);
		stagingClientGroup.setClientGroupName(clientGroupName);
		stagingClientGroup.setExternalModifiedDate(modifiedDate);
		stagingClientGroup.setExternalCreatedDate(createdDate);

		return addStagingClientGroup(stagingClientGroup);
	}

	public void deleteAll() {
		for (StagingClientGroup stagingClientGroup : stagingClientGroupPersistence.findAll()) {
			deleteStagingClientGroup(stagingClientGroup);
		}
	}

}