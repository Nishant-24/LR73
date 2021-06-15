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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Client. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.ClientLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClientLocalService
 * @generated
 */
public class ClientLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.ClientLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the client to the database. Also notifies the appropriate model listeners.
	 *
	 * @param client the client
	 * @return the client that was added
	 */
	public static com.argus.oth.cases.management.model.Client addClient(
		com.argus.oth.cases.management.model.Client client) {

		return getService().addClient(client);
	}

	public static void addClient(
		long groupId, long externalClientPk, long externalClientId,
		String clientName, String telephonyNumber,
		java.util.Date externalModifiedDate, java.util.Date externalCreatedDate,
		String randomString) {

		getService().addClient(
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
	public static com.argus.oth.cases.management.model.Client createClient(
		long clientId) {

		return getService().createClient(clientId);
	}

	public static void deleteAllClients() {
		getService().deleteAllClients();
	}

	/**
	 * Deletes the client from the database. Also notifies the appropriate model listeners.
	 *
	 * @param client the client
	 * @return the client that was removed
	 */
	public static com.argus.oth.cases.management.model.Client deleteClient(
		com.argus.oth.cases.management.model.Client client) {

		return getService().deleteClient(client);
	}

	/**
	 * Deletes the client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client
	 * @return the client that was removed
	 * @throws PortalException if a client with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Client deleteClient(
			long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteClient(clientId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteUnprocessed(String randomString) {
		getService().deleteUnprocessed(randomString);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.argus.oth.cases.management.model.Client fetchClient(
		long clientId) {

		return getService().fetchClient(clientId);
	}

	public static com.argus.oth.cases.management.model.Client
		fetchClientByExternalClientId(long externalClientId) {

		return getService().fetchClientByExternalClientId(externalClientId);
	}

	public static com.argus.oth.cases.management.model.Client
		fetchClientByExternalClientPk(long externalClientPk) {

		return getService().fetchClientByExternalClientPk(externalClientPk);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the client with the primary key.
	 *
	 * @param clientId the primary key of the client
	 * @return the client
	 * @throws PortalException if a client with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Client getClient(
			long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClient(clientId);
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
	public static java.util.List<com.argus.oth.cases.management.model.Client>
		getClients(int start, int end) {

		return getService().getClients(start, end);
	}

	/**
	 * Returns the number of clients.
	 *
	 * @return the number of clients
	 */
	public static int getClientsCount() {
		return getService().getClientsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the client in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param client the client
	 * @return the client that was updated
	 */
	public static com.argus.oth.cases.management.model.Client updateClient(
		com.argus.oth.cases.management.model.Client client) {

		return getService().updateClient(client);
	}

	public static ClientLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientLocalService, ClientLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientLocalService.class);

		ServiceTracker<ClientLocalService, ClientLocalService> serviceTracker =
			new ServiceTracker<ClientLocalService, ClientLocalService>(
				bundle.getBundleContext(), ClientLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}