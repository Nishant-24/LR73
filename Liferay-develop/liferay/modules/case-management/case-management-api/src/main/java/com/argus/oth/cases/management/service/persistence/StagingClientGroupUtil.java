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

import com.argus.oth.cases.management.model.StagingClientGroup;

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
 * The persistence utility for the staging client group service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingClientGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientGroupPersistence
 * @generated
 */
public class StagingClientGroupUtil {

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
	public static void clearCache(StagingClientGroup stagingClientGroup) {
		getPersistence().clearCache(stagingClientGroup);
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
	public static Map<Serializable, StagingClientGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingClientGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingClientGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingClientGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingClientGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingClientGroup update(
		StagingClientGroup stagingClientGroup) {

		return getPersistence().update(stagingClientGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingClientGroup update(
		StagingClientGroup stagingClientGroup, ServiceContext serviceContext) {

		return getPersistence().update(stagingClientGroup, serviceContext);
	}

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or throws a <code>NoSuchStagingClientGroupException</code> if it could not be found.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching staging client group
	 * @throws NoSuchStagingClientGroupException if a matching staging client group could not be found
	 */
	public static StagingClientGroup findByExternalClientGroupId(
			long externalClientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientGroupException {

		return getPersistence().findByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching staging client group, or <code>null</code> if a matching staging client group could not be found
	 */
	public static StagingClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId) {

		return getPersistence().fetchByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging client group, or <code>null</code> if a matching staging client group could not be found
	 */
	public static StagingClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId, boolean useFinderCache) {

		return getPersistence().fetchByExternalClientGroupId(
			externalClientGroupId, useFinderCache);
	}

	/**
	 * Removes the staging client group where externalClientGroupId = &#63; from the database.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the staging client group that was removed
	 */
	public static StagingClientGroup removeByExternalClientGroupId(
			long externalClientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientGroupException {

		return getPersistence().removeByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Returns the number of staging client groups where externalClientGroupId = &#63;.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the number of matching staging client groups
	 */
	public static int countByExternalClientGroupId(long externalClientGroupId) {
		return getPersistence().countByExternalClientGroupId(
			externalClientGroupId);
	}

	/**
	 * Caches the staging client group in the entity cache if it is enabled.
	 *
	 * @param stagingClientGroup the staging client group
	 */
	public static void cacheResult(StagingClientGroup stagingClientGroup) {
		getPersistence().cacheResult(stagingClientGroup);
	}

	/**
	 * Caches the staging client groups in the entity cache if it is enabled.
	 *
	 * @param stagingClientGroups the staging client groups
	 */
	public static void cacheResult(
		List<StagingClientGroup> stagingClientGroups) {

		getPersistence().cacheResult(stagingClientGroups);
	}

	/**
	 * Creates a new staging client group with the primary key. Does not add the staging client group to the database.
	 *
	 * @param stagingClientGroupId the primary key for the new staging client group
	 * @return the new staging client group
	 */
	public static StagingClientGroup create(long stagingClientGroupId) {
		return getPersistence().create(stagingClientGroupId);
	}

	/**
	 * Removes the staging client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group that was removed
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	public static StagingClientGroup remove(long stagingClientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientGroupException {

		return getPersistence().remove(stagingClientGroupId);
	}

	public static StagingClientGroup updateImpl(
		StagingClientGroup stagingClientGroup) {

		return getPersistence().updateImpl(stagingClientGroup);
	}

	/**
	 * Returns the staging client group with the primary key or throws a <code>NoSuchStagingClientGroupException</code> if it could not be found.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	public static StagingClientGroup findByPrimaryKey(long stagingClientGroupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClientGroupException {

		return getPersistence().findByPrimaryKey(stagingClientGroupId);
	}

	/**
	 * Returns the staging client group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group, or <code>null</code> if a staging client group with the primary key could not be found
	 */
	public static StagingClientGroup fetchByPrimaryKey(
		long stagingClientGroupId) {

		return getPersistence().fetchByPrimaryKey(stagingClientGroupId);
	}

	/**
	 * Returns all the staging client groups.
	 *
	 * @return the staging client groups
	 */
	public static List<StagingClientGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @return the range of staging client groups
	 */
	public static List<StagingClientGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging client groups
	 */
	public static List<StagingClientGroup> findAll(
		int start, int end,
		OrderByComparator<StagingClientGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging client groups
	 */
	public static List<StagingClientGroup> findAll(
		int start, int end,
		OrderByComparator<StagingClientGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging client groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging client groups.
	 *
	 * @return the number of staging client groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingClientGroupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClientGroupPersistence, StagingClientGroupPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingClientGroupPersistence.class);

		ServiceTracker
			<StagingClientGroupPersistence, StagingClientGroupPersistence>
				serviceTracker =
					new ServiceTracker
						<StagingClientGroupPersistence,
						 StagingClientGroupPersistence>(
							 bundle.getBundleContext(),
							 StagingClientGroupPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}