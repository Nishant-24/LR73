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

import com.argus.oth.cases.management.model.ClientGroup;
import com.argus.oth.cases.management.service.base.ClientGroupLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the client group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.ClientGroupLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientGroupLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.ClientGroup", service = AopService.class)
public class ClientGroupLocalServiceImpl extends ClientGroupLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.ClientGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.ClientGroupLocalServiceUtil</code>.
	 */
	public ClientGroup addClientGroup(
		long groupId, long externalClientGroupId, long clientId, String clientGroup, String clientGroupName,
		Date modifiedDate, Date createdDate, String randomString) {

		long clientGroupId = counterLocalService.increment(ClientGroup.class.getName());

		ClientGroup clientGroupObj = clientGroupPersistence.create(clientGroupId);

		clientGroupObj.setGroupId(groupId);
		clientGroupObj.setExternalClientGroupId(externalClientGroupId);
		clientGroupObj.setClientId(clientId);
		clientGroupObj.setClientGroup(clientGroup);
		clientGroupObj.setClientGroupName(clientGroupName);
		clientGroupObj.setModifiedDate(modifiedDate);
		clientGroupObj.setCreateDate(createdDate);
		clientGroupObj.setRowProcessed(randomString);

		return addClientGroup(clientGroupObj);
	}

	public void deleteUnprocessed(String randomString) {
		for (ClientGroup clientGroup : clientGroupPersistence.findByRowProcessed(randomString)) {
			_log.info(
				String.format(
					OTHConstants.DELETE_LOG_STRING_FORMAT, ClientGroup.class.getSimpleName(),
					clientGroup.getExternalClientGroupId(), clientGroup.getClientGroupId()));

			deleteClientGroup(clientGroup);
		}
	}

	public ClientGroup fetchByExternalClientGroupId(long externalClientGroupId) {
		return clientGroupPersistence.fetchByExternalClientGroupId(externalClientGroupId);
	}

	private static final Log _log = LogFactoryUtil.getLog(ClientGroupLocalServiceImpl.class);

}