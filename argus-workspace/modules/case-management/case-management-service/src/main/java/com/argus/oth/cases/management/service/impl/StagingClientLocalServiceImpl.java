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

import com.argus.oth.cases.management.model.StagingClient;
import com.argus.oth.cases.management.model.impl.StagingClientModelImpl;
import com.argus.oth.cases.management.service.base.StagingClientLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging client local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingClientLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see StagingClientLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.StagingClient", service = AopService.class)
public class StagingClientLocalServiceImpl extends StagingClientLocalServiceBaseImpl {

	public void addStagingClient(
		String externalClientPk, String clientId, String clientName, String telephonyNumber,
		String externalModifiedDate, String externalCreatedDate) {

		long id = counterLocalService.increment(StagingClient.class.getName());

		StagingClient stagingClient = createStagingClient(id);

		stagingClient.setCreateDate(new Date());
		stagingClient.setModifiedDate(new Date());

		stagingClient.setExternalClientPk(externalClientPk);
		stagingClient.setClientId(clientId);
		stagingClient.setClientName(clientName);
		stagingClient.setTelephonyNumber(telephonyNumber);
		stagingClient.setExternalModifiedDate(externalModifiedDate);
		stagingClient.setExternalCreatedDate(externalCreatedDate);

		addStagingClient(stagingClient);
	}

	public void deleteAll() {
		BulkHelper.bulkDeleteAll(stagingClientPersistence.getCurrentSession(), StagingClientModelImpl.TABLE_NAME);
	}

	public List<StagingClient> getStagingClientsByClientId(String clientId) {
		return stagingClientPersistence.findByClientId(clientId);
	}

	public List<StagingClient> getStagingClientsByRowProcessed(boolean rowProcessed) {
		return stagingClientPersistence.findByRowProcessed(rowProcessed);
	}

}