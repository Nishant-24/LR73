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

import com.argus.oth.cases.management.model.StagingClient;

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
 * The persistence utility for the staging client service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingClientPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientPersistence
 * @generated
 */
public class StagingClientUtil {

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
	public static void clearCache(StagingClient stagingClient) {
		getPersistence().clearCache(stagingClient);
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
	public static Map<Serializable, StagingClient> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingClient> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingClient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingClient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingClient update(StagingClient stagingClient) {
		return getPersistence().update(stagingClient);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingClient update(
		StagingClient stagingClient, ServiceContext serviceContext) {

		return getPersistence().update(stagingClient, serviceContext);
	}

	/**
	 * Returns all the staging clients where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching staging clients
	 */
	public static List<StagingClient> findByClientId(String clientId) {
		return getPersistence().findByClientId(clientId);
	}

	/**
	 * Returns a range of all the staging clients where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of matching staging clients
	 */
	public static List<StagingClient> findByClientId(
		String clientId, int start, int end) {

		return getPersistence().findByClientId(clientId, start, end);
	}

	/**
	 * Returns an ordered range of all the staging clients where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging clients
	 */
	public static List<StagingClient> findByClientId(
		String clientId, int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().findByClientId(
			clientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging clients where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging clients
	 */
	public static List<StagingClient> findByClientId(
		String clientId, int start, int end,
		OrderByComparator<StagingClient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByClientId(
			clientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public static StagingClient findByClientId_First(
			String clientId, OrderByComparator<StagingClient> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByClientId_First(
			clientId, orderByComparator);
	}

	/**
	 * Returns the first staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public static StagingClient fetchByClientId_First(
		String clientId, OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().fetchByClientId_First(
			clientId, orderByComparator);
	}

	/**
	 * Returns the last staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public static StagingClient findByClientId_Last(
			String clientId, OrderByComparator<StagingClient> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByClientId_Last(
			clientId, orderByComparator);
	}

	/**
	 * Returns the last staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public static StagingClient fetchByClientId_Last(
		String clientId, OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().fetchByClientId_Last(
			clientId, orderByComparator);
	}

	/**
	 * Returns the staging clients before and after the current staging client in the ordered set where clientId = &#63;.
	 *
	 * @param stagingClientId the primary key of the current staging client
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public static StagingClient[] findByClientId_PrevAndNext(
			long stagingClientId, String clientId,
			OrderByComparator<StagingClient> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByClientId_PrevAndNext(
			stagingClientId, clientId, orderByComparator);
	}

	/**
	 * Removes all the staging clients where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	public static void removeByClientId(String clientId) {
		getPersistence().removeByClientId(clientId);
	}

	/**
	 * Returns the number of staging clients where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching staging clients
	 */
	public static int countByClientId(String clientId) {
		return getPersistence().countByClientId(clientId);
	}

	/**
	 * Returns all the staging clients where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching staging clients
	 */
	public static List<StagingClient> findByRowProcessed(boolean rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the staging clients where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of matching staging clients
	 */
	public static List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the staging clients where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging clients
	 */
	public static List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging clients where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging clients
	 */
	public static List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingClient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public static StagingClient findByRowProcessed_First(
			boolean rowProcessed,
			OrderByComparator<StagingClient> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public static StagingClient fetchByRowProcessed_First(
		boolean rowProcessed,
		OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public static StagingClient findByRowProcessed_Last(
			boolean rowProcessed,
			OrderByComparator<StagingClient> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public static StagingClient fetchByRowProcessed_Last(
		boolean rowProcessed,
		OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the staging clients before and after the current staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param stagingClientId the primary key of the current staging client
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public static StagingClient[] findByRowProcessed_PrevAndNext(
			long stagingClientId, boolean rowProcessed,
			OrderByComparator<StagingClient> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			stagingClientId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the staging clients where rowProcessed = &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(boolean rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of staging clients where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching staging clients
	 */
	public static int countByRowProcessed(boolean rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the staging client in the entity cache if it is enabled.
	 *
	 * @param stagingClient the staging client
	 */
	public static void cacheResult(StagingClient stagingClient) {
		getPersistence().cacheResult(stagingClient);
	}

	/**
	 * Caches the staging clients in the entity cache if it is enabled.
	 *
	 * @param stagingClients the staging clients
	 */
	public static void cacheResult(List<StagingClient> stagingClients) {
		getPersistence().cacheResult(stagingClients);
	}

	/**
	 * Creates a new staging client with the primary key. Does not add the staging client to the database.
	 *
	 * @param stagingClientId the primary key for the new staging client
	 * @return the new staging client
	 */
	public static StagingClient create(long stagingClientId) {
		return getPersistence().create(stagingClientId);
	}

	/**
	 * Removes the staging client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client that was removed
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public static StagingClient remove(long stagingClientId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().remove(stagingClientId);
	}

	public static StagingClient updateImpl(StagingClient stagingClient) {
		return getPersistence().updateImpl(stagingClient);
	}

	/**
	 * Returns the staging client with the primary key or throws a <code>NoSuchStagingClientException</code> if it could not be found.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public static StagingClient findByPrimaryKey(long stagingClientId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientException {

		return getPersistence().findByPrimaryKey(stagingClientId);
	}

	/**
	 * Returns the staging client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client, or <code>null</code> if a staging client with the primary key could not be found
	 */
	public static StagingClient fetchByPrimaryKey(long stagingClientId) {
		return getPersistence().fetchByPrimaryKey(stagingClientId);
	}

	/**
	 * Returns all the staging clients.
	 *
	 * @return the staging clients
	 */
	public static List<StagingClient> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of staging clients
	 */
	public static List<StagingClient> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging clients
	 */
	public static List<StagingClient> findAll(
		int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging clients
	 */
	public static List<StagingClient> findAll(
		int start, int end, OrderByComparator<StagingClient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging clients from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging clients.
	 *
	 * @return the number of staging clients
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingClientPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClientPersistence, StagingClientPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingClientPersistence.class);

		ServiceTracker<StagingClientPersistence, StagingClientPersistence>
			serviceTracker =
				new ServiceTracker
					<StagingClientPersistence, StagingClientPersistence>(
						bundle.getBundleContext(),
						StagingClientPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}