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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClientService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientService
 * @generated
 */
public class ClientServiceWrapper
	implements ClientService, ServiceWrapper<ClientService> {

	public ClientServiceWrapper(ClientService clientService) {
		_clientService = clientService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientService.getOSGiServiceIdentifier();
	}

	@Override
	public ClientService getWrappedService() {
		return _clientService;
	}

	@Override
	public void setWrappedService(ClientService clientService) {
		_clientService = clientService;
	}

	private ClientService _clientService;

}