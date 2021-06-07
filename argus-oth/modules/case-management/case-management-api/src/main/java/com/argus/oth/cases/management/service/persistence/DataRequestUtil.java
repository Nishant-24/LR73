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

package com.argus.oth.cases.management.service.persistence;

import com.argus.oth.cases.management.model.DataRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the data request service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.DataRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataRequestPersistence
 * @generated
 */
public class DataRequestUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DataRequest dataRequest) {
		getPersistence().clearCache(dataRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DataRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataRequest update(DataRequest dataRequest) {
		return getPersistence().update(dataRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataRequest update(
		DataRequest dataRequest, ServiceContext serviceContext) {

		return getPersistence().update(dataRequest, serviceContext);
	}

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the matching data request
	 * @throws NoSuchDataRequestException if a matching data request could not be found
	 */
	public static DataRequest findByClientId_Type(long clientId, String type)
		throws com.argus.oth.cases.management.exception.
			NoSuchDataRequestException {

		return getPersistence().findByClientId_Type(clientId, type);
	}

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public static DataRequest fetchByClientId_Type(long clientId, String type) {
		return getPersistence().fetchByClientId_Type(clientId, type);
	}

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public static DataRequest fetchByClientId_Type(
		long clientId, String type, boolean useFinderCache) {

		return getPersistence().fetchByClientId_Type(
			clientId, type, useFinderCache);
	}

	/**
	 * Removes the data request where clientId = &#63; and type = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the data request that was removed
	 */
	public static DataRequest removeByClientId_Type(long clientId, String type)
		throws com.argus.oth.cases.management.exception.
			NoSuchDataRequestException {

		return getPersistence().removeByClientId_Type(clientId, type);
	}

	/**
	 * Returns the number of data requests where clientId = &#63; and type = &#63;.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the number of matching data requests
	 */
	public static int countByClientId_Type(long clientId, String type) {
		return getPersistence().countByClientId_Type(clientId, type);
	}

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the matching data request
	 * @throws NoSuchDataRequestException if a matching data request could not be found
	 */
	public static DataRequest findByExtCaseId_Type(
			long externalCaseId, String type)
		throws com.argus.oth.cases.management.exception.
			NoSuchDataRequestException {

		return getPersistence().findByExtCaseId_Type(externalCaseId, type);
	}

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public static DataRequest fetchByExtCaseId_Type(
		long externalCaseId, String type) {

		return getPersistence().fetchByExtCaseId_Type(externalCaseId, type);
	}

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public static DataRequest fetchByExtCaseId_Type(
		long externalCaseId, String type, boolean useFinderCache) {

		return getPersistence().fetchByExtCaseId_Type(
			externalCaseId, type, useFinderCache);
	}

	/**
	 * Removes the data request where externalCaseId = &#63; and type = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the data request that was removed
	 */
	public static DataRequest removeByExtCaseId_Type(
			long externalCaseId, String type)
		throws com.argus.oth.cases.management.exception.
			NoSuchDataRequestException {

		return getPersistence().removeByExtCaseId_Type(externalCaseId, type);
	}

	/**
	 * Returns the number of data requests where externalCaseId = &#63; and type = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the number of matching data requests
	 */
	public static int countByExtCaseId_Type(long externalCaseId, String type) {
		return getPersistence().countByExtCaseId_Type(externalCaseId, type);
	}

	/**
	 * Caches the data request in the entity cache if it is enabled.
	 *
	 * @param dataRequest the data request
	 */
	public static void cacheResult(DataRequest dataRequest) {
		getPersistence().cacheResult(dataRequest);
	}

	/**
	 * Caches the data requests in the entity cache if it is enabled.
	 *
	 * @param dataRequests the data requests
	 */
	public static void cacheResult(List<DataRequest> dataRequests) {
		getPersistence().cacheResult(dataRequests);
	}

	/**
	 * Creates a new data request with the primary key. Does not add the data request to the database.
	 *
	 * @param dataRequestId the primary key for the new data request
	 * @return the new data request
	 */
	public static DataRequest create(long dataRequestId) {
		return getPersistence().create(dataRequestId);
	}

	/**
	 * Removes the data request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request that was removed
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	public static DataRequest remove(long dataRequestId)
		throws com.argus.oth.cases.management.exception.
			NoSuchDataRequestException {

		return getPersistence().remove(dataRequestId);
	}

	public static DataRequest updateImpl(DataRequest dataRequest) {
		return getPersistence().updateImpl(dataRequest);
	}

	/**
	 * Returns the data request with the primary key or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	public static DataRequest findByPrimaryKey(long dataRequestId)
		throws com.argus.oth.cases.management.exception.
			NoSuchDataRequestException {

		return getPersistence().findByPrimaryKey(dataRequestId);
	}

	/**
	 * Returns the data request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request, or <code>null</code> if a data request with the primary key could not be found
	 */
	public static DataRequest fetchByPrimaryKey(long dataRequestId) {
		return getPersistence().fetchByPrimaryKey(dataRequestId);
	}

	/**
	 * Returns all the data requests.
	 *
	 * @return the data requests
	 */
	public static List<DataRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @return the range of data requests
	 */
	public static List<DataRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data requests
	 */
	public static List<DataRequest> findAll(
		int start, int end, OrderByComparator<DataRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data requests
	 */
	public static List<DataRequest> findAll(
		int start, int end, OrderByComparator<DataRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data requests.
	 *
	 * @return the number of data requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataRequestPersistence, DataRequestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataRequestPersistence.class);

		ServiceTracker<DataRequestPersistence, DataRequestPersistence>
			serviceTracker =
				new ServiceTracker
					<DataRequestPersistence, DataRequestPersistence>(
						bundle.getBundleContext(), DataRequestPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}