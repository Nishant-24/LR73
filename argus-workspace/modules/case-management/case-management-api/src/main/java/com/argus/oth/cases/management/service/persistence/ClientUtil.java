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

import com.argus.oth.cases.management.model.Client;

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
 * The persistence utility for the client service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.ClientPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientPersistence
 * @generated
 */
public class ClientUtil {

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
	public static void clearCache(Client client) {
		getPersistence().clearCache(client);
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
	public static Map<Serializable, Client> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Client> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Client> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Client> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Client> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Client update(Client client) {
		return getPersistence().update(client);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Client update(Client client, ServiceContext serviceContext) {
		return getPersistence().update(client, serviceContext);
	}

	/**
	 * Returns the client where externalClientPk = &#63; or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param externalClientPk the external client pk
	 * @return the matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public static Client findByExternalClientPk(long externalClientPk)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().findByExternalClientPk(externalClientPk);
	}

	/**
	 * Returns the client where externalClientPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientPk the external client pk
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public static Client fetchByExternalClientPk(long externalClientPk) {
		return getPersistence().fetchByExternalClientPk(externalClientPk);
	}

	/**
	 * Returns the client where externalClientPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientPk the external client pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public static Client fetchByExternalClientPk(
		long externalClientPk, boolean useFinderCache) {

		return getPersistence().fetchByExternalClientPk(
			externalClientPk, useFinderCache);
	}

	/**
	 * Removes the client where externalClientPk = &#63; from the database.
	 *
	 * @param externalClientPk the external client pk
	 * @return the client that was removed
	 */
	public static Client removeByExternalClientPk(long externalClientPk)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().removeByExternalClientPk(externalClientPk);
	}

	/**
	 * Returns the number of clients where externalClientPk = &#63;.
	 *
	 * @param externalClientPk the external client pk
	 * @return the number of matching clients
	 */
	public static int countByExternalClientPk(long externalClientPk) {
		return getPersistence().countByExternalClientPk(externalClientPk);
	}

	/**
	 * Returns the client where externalClientId = &#63; or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public static Client findByExternalClientId(long externalClientId)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().findByExternalClientId(externalClientId);
	}

	/**
	 * Returns the client where externalClientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public static Client fetchByExternalClientId(long externalClientId) {
		return getPersistence().fetchByExternalClientId(externalClientId);
	}

	/**
	 * Returns the client where externalClientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientId the external client ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public static Client fetchByExternalClientId(
		long externalClientId, boolean useFinderCache) {

		return getPersistence().fetchByExternalClientId(
			externalClientId, useFinderCache);
	}

	/**
	 * Removes the client where externalClientId = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 * @return the client that was removed
	 */
	public static Client removeByExternalClientId(long externalClientId)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().removeByExternalClientId(externalClientId);
	}

	/**
	 * Returns the number of clients where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the number of matching clients
	 */
	public static int countByExternalClientId(long externalClientId) {
		return getPersistence().countByExternalClientId(externalClientId);
	}

	/**
	 * Returns all the clients where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching clients
	 */
	public static List<Client> findByRowProcessed(String rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the clients where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @return the range of matching clients
	 */
	public static List<Client> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the clients where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clients
	 */
	public static List<Client> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Client> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clients where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clients
	 */
	public static List<Client> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Client> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public static Client findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Client> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client, or <code>null</code> if a matching client could not be found
	 */
	public static Client fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Client> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public static Client findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Client> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client, or <code>null</code> if a matching client could not be found
	 */
	public static Client fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Client> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the clients before and after the current client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param clientId the primary key of the current client
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	public static Client[] findByRowProcessed_PrevAndNext(
			long clientId, String rowProcessed,
			OrderByComparator<Client> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			clientId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the clients where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(String rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of clients where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching clients
	 */
	public static int countByRowProcessed(String rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the client in the entity cache if it is enabled.
	 *
	 * @param client the client
	 */
	public static void cacheResult(Client client) {
		getPersistence().cacheResult(client);
	}

	/**
	 * Caches the clients in the entity cache if it is enabled.
	 *
	 * @param clients the clients
	 */
	public static void cacheResult(List<Client> clients) {
		getPersistence().cacheResult(clients);
	}

	/**
	 * Creates a new client with the primary key. Does not add the client to the database.
	 *
	 * @param clientId the primary key for the new client
	 * @return the new client
	 */
	public static Client create(long clientId) {
		return getPersistence().create(clientId);
	}

	/**
	 * Removes the client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client
	 * @return the client that was removed
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	public static Client remove(long clientId)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().remove(clientId);
	}

	public static Client updateImpl(Client client) {
		return getPersistence().updateImpl(client);
	}

	/**
	 * Returns the client with the primary key or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client
	 * @return the client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	public static Client findByPrimaryKey(long clientId)
		throws com.argus.oth.cases.management.exception.NoSuchClientException {

		return getPersistence().findByPrimaryKey(clientId);
	}

	/**
	 * Returns the client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client
	 * @return the client, or <code>null</code> if a client with the primary key could not be found
	 */
	public static Client fetchByPrimaryKey(long clientId) {
		return getPersistence().fetchByPrimaryKey(clientId);
	}

	/**
	 * Returns all the clients.
	 *
	 * @return the clients
	 */
	public static List<Client> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @return the range of clients
	 */
	public static List<Client> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clients
	 */
	public static List<Client> findAll(
		int start, int end, OrderByComparator<Client> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clients
	 */
	public static List<Client> findAll(
		int start, int end, OrderByComparator<Client> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clients from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clients.
	 *
	 * @return the number of clients
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClientPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientPersistence, ClientPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientPersistence.class);

		ServiceTracker<ClientPersistence, ClientPersistence> serviceTracker =
			new ServiceTracker<ClientPersistence, ClientPersistence>(
				bundle.getBundleContext(), ClientPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}