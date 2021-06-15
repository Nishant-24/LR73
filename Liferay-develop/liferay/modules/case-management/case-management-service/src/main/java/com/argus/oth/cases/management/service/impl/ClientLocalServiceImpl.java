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

import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.base.ClientLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the client local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.ClientLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see ClientLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Client", service = AopService.class)
public class ClientLocalServiceImpl extends ClientLocalServiceBaseImpl {

	public void addClient(
		long groupId, long externalClientPk, long externalClientId, String clientName, String telephonyNumber,
		Date externalModifiedDate, Date externalCreatedDate, String randomString) {

		long id = counterLocalService.increment(Client.class.getName());

		Client client = createClient(id);

		Group group = groupLocalService.fetchGroup(groupId);

		if (group != null) {
			client.setCompanyId(group.getCompanyId());
		}

		client.setGroupId(groupId);
		client.setCreateDate(new Date());
		client.setModifiedDate(new Date());

		client.setExternalClientPk(externalClientPk);
		client.setExternalClientId(externalClientId);
		client.setClientName(clientName);
		client.setTelephonyNumber(telephonyNumber);
		client.setExternalModifiedDate(externalModifiedDate);
		client.setExternalCreatedDate(externalCreatedDate);
		client.setRowProcessed(randomString);

		addClient(client);
	}

	public void deleteAllClients() {
		for (Client client : clientPersistence.findAll()) {
			deleteClient(client);
		}
	}

	public void deleteUnprocessed(String randomString) {
		for (Client client : clientPersistence.findByRowProcessed(randomString)) {
			_log.info(
				String.format(
					OTHConstants.DELETE_LOG_STRING_FORMAT, Client.class.getSimpleName(), client.getExternalClientId(),
					client.getClientId()));

			deleteClient(client);
		}
	}

	public Client fetchClientByExternalClientId(long externalClientId) {
		return clientPersistence.fetchByExternalClientId(externalClientId);
	}

	public Client fetchClientByExternalClientPk(long externalClientPk) {
		return clientPersistence.fetchByExternalClientPk(externalClientPk);
	}

	private static final Log _log = LogFactoryUtil.getLog(ClientLocalServiceImpl.class);

}