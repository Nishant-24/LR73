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
 * Provides the local service utility for DataRequest. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.DataRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataRequestLocalService
 * @generated
 */
public class DataRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.DataRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data request to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequest the data request
	 * @return the data request that was added
	 */
	public static com.argus.oth.cases.management.model.DataRequest
		addDataRequest(
			com.argus.oth.cases.management.model.DataRequest dataRequest) {

		return getService().addDataRequest(dataRequest);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>DataRequestLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>DataRequestLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.DataRequest
		addDataRequest(
			long clientId, long caseId, long externalCaseId, String type,
			java.util.Date lastUpdatedDate) {

		return getService().addDataRequest(
			clientId, caseId, externalCaseId, type, lastUpdatedDate);
	}

	/**
	 * Creates a new data request with the primary key. Does not add the data request to the database.
	 *
	 * @param dataRequestId the primary key for the new data request
	 * @return the new data request
	 */
	public static com.argus.oth.cases.management.model.DataRequest
		createDataRequest(long dataRequestId) {

		return getService().createDataRequest(dataRequestId);
	}

	/**
	 * Deletes the data request from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequest the data request
	 * @return the data request that was removed
	 */
	public static com.argus.oth.cases.management.model.DataRequest
		deleteDataRequest(
			com.argus.oth.cases.management.model.DataRequest dataRequest) {

		return getService().deleteDataRequest(dataRequest);
	}

	/**
	 * Deletes the data request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request that was removed
	 * @throws PortalException if a data request with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.DataRequest
			deleteDataRequest(long dataRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataRequest(dataRequestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.DataRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.DataRequestModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.DataRequest
		fetchByClientId_Type(long clientId, String type) {

		return getService().fetchByClientId_Type(clientId, type);
	}

	public static com.argus.oth.cases.management.model.DataRequest
		fetchByExternalCaseId_Type(long externalCaseId, String type) {

		return getService().fetchByExternalCaseId_Type(externalCaseId, type);
	}

	public static com.argus.oth.cases.management.model.DataRequest
		fetchDataRequest(long dataRequestId) {

		return getService().fetchDataRequest(dataRequestId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data request with the primary key.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request
	 * @throws PortalException if a data request with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.DataRequest
			getDataRequest(long dataRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataRequest(dataRequestId);
	}

	/**
	 * Returns a range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @return the range of data requests
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.DataRequest> getDataRequests(
			int start, int end) {

		return getService().getDataRequests(start, end);
	}

	/**
	 * Returns the number of data requests.
	 *
	 * @return the number of data requests
	 */
	public static int getDataRequestsCount() {
		return getService().getDataRequestsCount();
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

	public static com.argus.oth.cases.management.model.DataRequest
		setDataRequestLastUpdatedDate(
			long clientId, long caseId, long externalCaseId, String type) {

		return getService().setDataRequestLastUpdatedDate(
			clientId, caseId, externalCaseId, type);
	}

	/**
	 * Updates the data request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequest the data request
	 * @return the data request that was updated
	 */
	public static com.argus.oth.cases.management.model.DataRequest
		updateDataRequest(
			com.argus.oth.cases.management.model.DataRequest dataRequest) {

		return getService().updateDataRequest(dataRequest);
	}

	public static com.argus.oth.cases.management.model.DataRequest
		updateDataRequest(
			long clientId, long caseId, long externalCaseId, String type,
			java.util.Date lastUpdatedDate) {

		return getService().updateDataRequest(
			clientId, caseId, externalCaseId, type, lastUpdatedDate);
	}

	public static DataRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataRequestLocalService, DataRequestLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataRequestLocalService.class);

		ServiceTracker<DataRequestLocalService, DataRequestLocalService>
			serviceTracker =
				new ServiceTracker
					<DataRequestLocalService, DataRequestLocalService>(
						bundle.getBundleContext(),
						DataRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}