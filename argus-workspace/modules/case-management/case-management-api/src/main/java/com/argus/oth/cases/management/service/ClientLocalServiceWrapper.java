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
 * Provides a wrapper for {@link ClientLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientLocalService
 * @generated
 */
public class ClientLocalServiceWrapper
	implements ClientLocalService, ServiceWrapper<ClientLocalService> {

	public ClientLocalServiceWrapper(ClientLocalService clientLocalService) {
		_clientLocalService = clientLocalService;
	}

	/**
	 * Adds the client to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param client the client
	 * @return the client that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.Client addClient(
		com.argus.oth.cases.management.model.Client client) {

		return _clientLocalService.addClient(client);
	}

	@Override
	public void addClient(
		long groupId, long externalClientPk, long externalClientId,
		String clientName, String telephonyNumber,
		java.util.Date externalModifiedDate, java.util.Date externalCreatedDate,
		String randomString) {

		_clientLocalService.addClient(
			groupId, externalClientPk, externalClientId, clientName,
			telephonyNumber, externalModifiedDate, externalCreatedDate,
			randomString);
	}

	/**
	 * Creates a new client with the primary key. Does not add the client to the database.
	 *
	 * @param clientId the primary key for the new client
	 * @return the new client
	 */
	@Override
	public com.argus.oth.cases.management.model.Client createClient(
		long clientId) {

		return _clientLocalService.createClient(clientId);
	}

	@Override
	public void deleteAllClients() {
		_clientLocalService.deleteAllClients();
	}

	/**
	 * Deletes the client from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param client the client
	 * @return the client that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.Client deleteClient(
		com.argus.oth.cases.management.model.Client client) {

		return _clientLocalService.deleteClient(client);
	}

	/**
	 * Deletes the client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientId the primary key of the client
	 * @return the client that was removed
	 * @throws PortalException if a client with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Client deleteClient(
			long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientLocalService.deleteClient(clientId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteUnprocessed(String randomString) {
		_clientLocalService.deleteUnprocessed(randomString);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clientLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _clientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClientModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _clientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClientModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _clientLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _clientLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _clientLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.Client fetchClient(
		long clientId) {

		return _clientLocalService.fetchClient(clientId);
	}

	@Override
	public com.argus.oth.cases.management.model.Client
		fetchClientByExternalClientId(long externalClientId) {

		return _clientLocalService.fetchClientByExternalClientId(
			externalClientId);
	}

	@Override
	public com.argus.oth.cases.management.model.Client
		fetchClientByExternalClientPk(long externalClientPk) {

		return _clientLocalService.fetchClientByExternalClientPk(
			externalClientPk);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clientLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the client with the primary key.
	 *
	 * @param clientId the primary key of the client
	 * @return the client
	 * @throws PortalException if a client with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Client getClient(long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientLocalService.getClient(clientId);
	}

	/**
	 * Returns a range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @return the range of clients
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Client>
		getClients(int start, int end) {

		return _clientLocalService.getClients(start, end);
	}

	/**
	 * Returns the number of clients.
	 *
	 * @return the number of clients
	 */
	@Override
	public int getClientsCount() {
		return _clientLocalService.getClientsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clientLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the client in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param client the client
	 * @return the client that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.Client updateClient(
		com.argus.oth.cases.management.model.Client client) {

		return _clientLocalService.updateClient(client);
	}

	@Override
	public ClientLocalService getWrappedService() {
		return _clientLocalService;
	}

	@Override
	public void setWrappedService(ClientLocalService clientLocalService) {
		_clientLocalService = clientLocalService;
	}

	private ClientLocalService _clientLocalService;

}