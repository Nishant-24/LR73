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

import com.argus.oth.account.management.model.AMAnalyticsTelephony;

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
 * The persistence utility for the am analytics telephony service. This utility wraps <code>com.argus.oth.account.management.service.persistence.impl.AMAnalyticsTelephonyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsTelephonyPersistence
 * @generated
 */
public class AMAnalyticsTelephonyUtil {

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
	public static void clearCache(AMAnalyticsTelephony amAnalyticsTelephony) {
		getPersistence().clearCache(amAnalyticsTelephony);
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
	public static Map<Serializable, AMAnalyticsTelephony> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMAnalyticsTelephony> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMAnalyticsTelephony> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMAnalyticsTelephony> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMAnalyticsTelephony> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMAnalyticsTelephony update(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		return getPersistence().update(amAnalyticsTelephony);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMAnalyticsTelephony update(
		AMAnalyticsTelephony amAnalyticsTelephony,
		ServiceContext serviceContext) {

		return getPersistence().update(amAnalyticsTelephony, serviceContext);
	}

	/**
	 * Caches the am analytics telephony in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsTelephony the am analytics telephony
	 */
	public static void cacheResult(AMAnalyticsTelephony amAnalyticsTelephony) {
		getPersistence().cacheResult(amAnalyticsTelephony);
	}

	/**
	 * Caches the am analytics telephonies in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsTelephonies the am analytics telephonies
	 */
	public static void cacheResult(
		List<AMAnalyticsTelephony> amAnalyticsTelephonies) {

		getPersistence().cacheResult(amAnalyticsTelephonies);
	}

	/**
	 * Creates a new am analytics telephony with the primary key. Does not add the am analytics telephony to the database.
	 *
	 * @param amAnalyticsTelephonyId the primary key for the new am analytics telephony
	 * @return the new am analytics telephony
	 */
	public static AMAnalyticsTelephony create(long amAnalyticsTelephonyId) {
		return getPersistence().create(amAnalyticsTelephonyId);
	}

	/**
	 * Removes the am analytics telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony that was removed
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	public static AMAnalyticsTelephony remove(long amAnalyticsTelephonyId)
		throws com.argus.oth.account.management.exception.
			NoSuchAMAnalyticsTelephonyException {

		return getPersistence().remove(amAnalyticsTelephonyId);
	}

	public static AMAnalyticsTelephony updateImpl(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		return getPersistence().updateImpl(amAnalyticsTelephony);
	}

	/**
	 * Returns the am analytics telephony with the primary key or throws a <code>NoSuchAMAnalyticsTelephonyException</code> if it could not be found.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	public static AMAnalyticsTelephony findByPrimaryKey(
			long amAnalyticsTelephonyId)
		throws com.argus.oth.account.management.exception.
			NoSuchAMAnalyticsTelephonyException {

		return getPersistence().findByPrimaryKey(amAnalyticsTelephonyId);
	}

	/**
	 * Returns the am analytics telephony with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony, or <code>null</code> if a am analytics telephony with the primary key could not be found
	 */
	public static AMAnalyticsTelephony fetchByPrimaryKey(
		long amAnalyticsTelephonyId) {

		return getPersistence().fetchByPrimaryKey(amAnalyticsTelephonyId);
	}

	/**
	 * Returns all the am analytics telephonies.
	 *
	 * @return the am analytics telephonies
	 */
	public static List<AMAnalyticsTelephony> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @return the range of am analytics telephonies
	 */
	public static List<AMAnalyticsTelephony> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics telephonies
	 */
	public static List<AMAnalyticsTelephony> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsTelephony> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics telephonies
	 */
	public static List<AMAnalyticsTelephony> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsTelephony> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the am analytics telephonies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of am analytics telephonies.
	 *
	 * @return the number of am analytics telephonies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AMAnalyticsTelephonyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AMAnalyticsTelephonyPersistence, AMAnalyticsTelephonyPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AMAnalyticsTelephonyPersistence.class);

		ServiceTracker
			<AMAnalyticsTelephonyPersistence, AMAnalyticsTelephonyPersistence>
				serviceTracker =
					new ServiceTracker
						<AMAnalyticsTelephonyPersistence,
						 AMAnalyticsTelephonyPersistence>(
							 bundle.getBundleContext(),
							 AMAnalyticsTelephonyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}