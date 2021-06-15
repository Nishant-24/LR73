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

package com.argus.oth.account.management.service.persistence;

import com.argus.oth.account.management.model.StagingAMATelephony;

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
 * The persistence utility for the staging ama telephony service. This utility wraps <code>com.argus.oth.account.management.service.persistence.impl.StagingAMATelephonyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMATelephonyPersistence
 * @generated
 */
public class StagingAMATelephonyUtil {

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
	public static void clearCache(StagingAMATelephony stagingAMATelephony) {
		getPersistence().clearCache(stagingAMATelephony);
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
	public static Map<Serializable, StagingAMATelephony> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingAMATelephony> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingAMATelephony> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingAMATelephony> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingAMATelephony> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingAMATelephony update(
		StagingAMATelephony stagingAMATelephony) {

		return getPersistence().update(stagingAMATelephony);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingAMATelephony update(
		StagingAMATelephony stagingAMATelephony,
		ServiceContext serviceContext) {

		return getPersistence().update(stagingAMATelephony, serviceContext);
	}

	/**
	 * Caches the staging ama telephony in the entity cache if it is enabled.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 */
	public static void cacheResult(StagingAMATelephony stagingAMATelephony) {
		getPersistence().cacheResult(stagingAMATelephony);
	}

	/**
	 * Caches the staging ama telephonies in the entity cache if it is enabled.
	 *
	 * @param stagingAMATelephonies the staging ama telephonies
	 */
	public static void cacheResult(
		List<StagingAMATelephony> stagingAMATelephonies) {

		getPersistence().cacheResult(stagingAMATelephonies);
	}

	/**
	 * Creates a new staging ama telephony with the primary key. Does not add the staging ama telephony to the database.
	 *
	 * @param stagingAMATelephonyId the primary key for the new staging ama telephony
	 * @return the new staging ama telephony
	 */
	public static StagingAMATelephony create(long stagingAMATelephonyId) {
		return getPersistence().create(stagingAMATelephonyId);
	}

	/**
	 * Removes the staging ama telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony that was removed
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	public static StagingAMATelephony remove(long stagingAMATelephonyId)
		throws com.argus.oth.account.management.exception.
			NoSuchStagingAMATelephonyException {

		return getPersistence().remove(stagingAMATelephonyId);
	}

	public static StagingAMATelephony updateImpl(
		StagingAMATelephony stagingAMATelephony) {

		return getPersistence().updateImpl(stagingAMATelephony);
	}

	/**
	 * Returns the staging ama telephony with the primary key or throws a <code>NoSuchStagingAMATelephonyException</code> if it could not be found.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	public static StagingAMATelephony findByPrimaryKey(
			long stagingAMATelephonyId)
		throws com.argus.oth.account.management.exception.
			NoSuchStagingAMATelephonyException {

		return getPersistence().findByPrimaryKey(stagingAMATelephonyId);
	}

	/**
	 * Returns the staging ama telephony with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony, or <code>null</code> if a staging ama telephony with the primary key could not be found
	 */
	public static StagingAMATelephony fetchByPrimaryKey(
		long stagingAMATelephonyId) {

		return getPersistence().fetchByPrimaryKey(stagingAMATelephonyId);
	}

	/**
	 * Returns all the staging ama telephonies.
	 *
	 * @return the staging ama telephonies
	 */
	public static List<StagingAMATelephony> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @return the range of staging ama telephonies
	 */
	public static List<StagingAMATelephony> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging ama telephonies
	 */
	public static List<StagingAMATelephony> findAll(
		int start, int end,
		OrderByComparator<StagingAMATelephony> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging ama telephonies
	 */
	public static List<StagingAMATelephony> findAll(
		int start, int end,
		OrderByComparator<StagingAMATelephony> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging ama telephonies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging ama telephonies.
	 *
	 * @return the number of staging ama telephonies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingAMATelephonyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAMATelephonyPersistence, StagingAMATelephonyPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAMATelephonyPersistence.class);

		ServiceTracker
			<StagingAMATelephonyPersistence, StagingAMATelephonyPersistence>
				serviceTracker =
					new ServiceTracker
						<StagingAMATelephonyPersistence,
						 StagingAMATelephonyPersistence>(
							 bundle.getBundleContext(),
							 StagingAMATelephonyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}