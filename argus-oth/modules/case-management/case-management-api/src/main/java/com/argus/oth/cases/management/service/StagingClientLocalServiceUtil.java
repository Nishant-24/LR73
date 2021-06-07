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
 * Provides the local service utility for StagingClient. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingClientLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientLocalService
 * @generated
 */
public class StagingClientLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingClientLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the staging client to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClient the staging client
	 * @return the staging client that was added
	 */
	public static com.argus.oth.cases.management.model.StagingClient
		addStagingClient(
			com.argus.oth.cases.management.model.StagingClient stagingClient) {

		return getService().addStagingClient(stagingClient);
	}

	public static void addStagingClient(
		String externalClientPk, String clientId, String clientName,
		String telephonyNumber, String externalModifiedDate,
		String externalCreatedDate) {

		getService().addStagingClient(
			externalClientPk, clientId, clientName, telephonyNumber,
			externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Creates a new staging client with the primary key. Does not add the staging client to the database.
	 *
	 * @param stagingClientId the primary key for the new staging client
	 * @return the new staging client
	 */
	public static com.argus.oth.cases.management.model.StagingClient
		createStagingClient(long stagingClientId) {

		return getService().createStagingClient(stagingClientId);
	}

	public static void deleteAll() {
		getService().deleteAll();
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

	/**
	 * Deletes the staging client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client that was removed
	 * @throws PortalException if a staging client with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingClient
			deleteStagingClient(long stagingClientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingClient(stagingClientId);
	}

	/**
	 * Deletes the staging client from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClient the staging client
	 * @return the staging client that was removed
	 */
	public static com.argus.oth.cases.management.model.StagingClient
		deleteStagingClient(
			com.argus.oth.cases.management.model.StagingClient stagingClient) {

		return getService().deleteStagingClient(stagingClient);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClientModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClientModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.StagingClient
		fetchStagingClient(long stagingClientId) {

		return getService().fetchStagingClient(stagingClientId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the staging client with the primary key.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client
	 * @throws PortalException if a staging client with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingClient
			getStagingClient(long stagingClientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingClient(stagingClientId);
	}

	/**
	 * Returns a range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of staging clients
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.StagingClient> getStagingClients(
			int start, int end) {

		return getService().getStagingClients(start, end);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.StagingClient>
			getStagingClientsByClientId(String clientId) {

		return getService().getStagingClientsByClientId(clientId);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.StagingClient>
			getStagingClientsByRowProcessed(boolean rowProcessed) {

		return getService().getStagingClientsByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of staging clients.
	 *
	 * @return the number of staging clients
	 */
	public static int getStagingClientsCount() {
		return getService().getStagingClientsCount();
	}

	/**
	 * Updates the staging client in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClient the staging client
	 * @return the staging client that was updated
	 */
	public static com.argus.oth.cases.management.model.StagingClient
		updateStagingClient(
			com.argus.oth.cases.management.model.StagingClient stagingClient) {

		return getService().updateStagingClient(stagingClient);
	}

	public static StagingClientLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClientLocalService, StagingClientLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingClientLocalService.class);

		ServiceTracker<StagingClientLocalService, StagingClientLocalService>
			serviceTracker =
				new ServiceTracker
					<StagingClientLocalService, StagingClientLocalService>(
						bundle.getBundleContext(),
						StagingClientLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}