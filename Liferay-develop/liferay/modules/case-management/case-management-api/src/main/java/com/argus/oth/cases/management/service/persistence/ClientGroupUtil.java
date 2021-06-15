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

import com.argus.oth.cases.management.model.ClientGroup;

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
 * The persistence utility for the client group service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.ClientGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientGroupPersistence
 * @generated
 */
public class ClientGroupUtil {

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
	public static void clearCache(ClientGroup clientGroup) {
		getPersistence().clearCache(clientGroup);
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
	public static Map<Serializable, ClientGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClientGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClientGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClientGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClientGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClientGroup update(ClientGroup clientGroup) {
		return getPersistence().update(clientGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClientGroup update(
		ClientGroup clientGroup, ServiceContext serviceContext) {

		return getPersistence().update(clientGroup, serviceContext);
	}

	/**
	 * Returns the client group where externalClientGroupId = &#63; or throws a <code>NoSuchClientGroupException</code> if it could not be found.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	public static ClientGroup findByExternalClientGroupId(
			long externalClientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().findByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns the client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public static ClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId) {

		return getPersistence().fetchByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns the client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public static ClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId, boolean useFinderCache) {

		return getPersistence().fetchByExternalClientGroupId(
			externalClientGroupId, useFinderCache);
	}

	/**
	 * Removes the client group where externalClientGroupId = &#63; from the database.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the client group that was removed
	 */
	public static ClientGroup removeByExternalClientGroupId(
			long externalClientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().removeByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns the number of client groups where externalClientGroupId = &#63;.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the number of matching client groups
	 */
	public static int countByExternalClientGroupId(long externalClientGroupId) {
		return getPersistence().countByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns all the client groups where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching client groups
	 */
	public static List<ClientGroup> findByRowProcessed(String rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of matching client groups
	 */
	public static List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client groups
	 */
	public static List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClientGroup> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client groups
	 */
	public static List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClientGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	public static ClientGroup findByRowProcessed_First(
			String rowProcessed,
			OrderByComparator<ClientGroup> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public static ClientGroup fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<ClientGroup> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	public static ClientGroup findByRowProcessed_Last(
			String rowProcessed,
			OrderByComparator<ClientGroup> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public static ClientGroup fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<ClientGroup> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the client groups before and after the current client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param clientGroupId the primary key of the current client group
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	public static ClientGroup[] findByRowProcessed_PrevAndNext(
			long clientGroupId, String rowProcessed,
			OrderByComparator<ClientGroup> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			clientGroupId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the client groups where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(String rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of client groups where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching client groups
	 */
	public static int countByRowProcessed(String rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the client group in the entity cache if it is enabled.
	 *
	 * @param clientGroup the client group
	 */
	public static void cacheResult(ClientGroup clientGroup) {
		getPersistence().cacheResult(clientGroup);
	}

	/**
	 * Caches the client groups in the entity cache if it is enabled.
	 *
	 * @param clientGroups the client groups
	 */
	public static void cacheResult(List<ClientGroup> clientGroups) {
		getPersistence().cacheResult(clientGroups);
	}

	/**
	 * Creates a new client group with the primary key. Does not add the client group to the database.
	 *
	 * @param clientGroupId the primary key for the new client group
	 * @return the new client group
	 */
	public static ClientGroup create(long clientGroupId) {
		return getPersistence().create(clientGroupId);
	}

	/**
	 * Removes the client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group that was removed
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	public static ClientGroup remove(long clientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().remove(clientGroupId);
	}

	public static ClientGroup updateImpl(ClientGroup clientGroup) {
		return getPersistence().updateImpl(clientGroup);
	}

	/**
	 * Returns the client group with the primary key or throws a <code>NoSuchClientGroupException</code> if it could not be found.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	public static ClientGroup findByPrimaryKey(long clientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClientGroupException {

		return getPersistence().findByPrimaryKey(clientGroupId);
	}

	/**
	 * Returns the client group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group, or <code>null</code> if a client group with the primary key could not be found
	 */
	public static ClientGroup fetchByPrimaryKey(long clientGroupId) {
		return getPersistence().fetchByPrimaryKey(clientGroupId);
	}

	/**
	 * Returns all the client groups.
	 *
	 * @return the client groups
	 */
	public static List<ClientGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of client groups
	 */
	public static List<ClientGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of client groups
	 */
	public static List<ClientGroup> findAll(
		int start, int end, OrderByComparator<ClientGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of client groups
	 */
	public static List<ClientGroup> findAll(
		int start, int end, OrderByComparator<ClientGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the client groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of client groups.
	 *
	 * @return the number of client groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClientGroupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClientGroupPersistence, ClientGroupPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientGroupPersistence.class);

		ServiceTracker<ClientGroupPersistence, ClientGroupPersistence>
			serviceTracker =
				new ServiceTracker
					<ClientGroupPersistence, ClientGroupPersistence>(
						bundle.getBundleContext(), ClientGroupPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}