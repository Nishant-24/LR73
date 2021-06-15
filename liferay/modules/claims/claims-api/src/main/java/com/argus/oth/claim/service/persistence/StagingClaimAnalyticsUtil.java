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

package com.argus.oth.claim.service.persistence;

import com.argus.oth.claim.model.StagingClaimAnalytics;

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
 * The persistence utility for the staging claim analytics service. This utility wraps <code>com.argus.oth.claim.service.persistence.impl.StagingClaimAnalyticsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimAnalyticsPersistence
 * @generated
 */
public class StagingClaimAnalyticsUtil {

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
	public static void clearCache(StagingClaimAnalytics stagingClaimAnalytics) {
		getPersistence().clearCache(stagingClaimAnalytics);
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
	public static Map<Serializable, StagingClaimAnalytics> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingClaimAnalytics> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingClaimAnalytics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingClaimAnalytics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingClaimAnalytics> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingClaimAnalytics update(
		StagingClaimAnalytics stagingClaimAnalytics) {

		return getPersistence().update(stagingClaimAnalytics);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingClaimAnalytics update(
		StagingClaimAnalytics stagingClaimAnalytics,
		ServiceContext serviceContext) {

		return getPersistence().update(stagingClaimAnalytics, serviceContext);
	}

	/**
	 * Caches the staging claim analytics in the entity cache if it is enabled.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 */
	public static void cacheResult(
		StagingClaimAnalytics stagingClaimAnalytics) {

		getPersistence().cacheResult(stagingClaimAnalytics);
	}

	/**
	 * Caches the staging claim analyticses in the entity cache if it is enabled.
	 *
	 * @param stagingClaimAnalyticses the staging claim analyticses
	 */
	public static void cacheResult(
		List<StagingClaimAnalytics> stagingClaimAnalyticses) {

		getPersistence().cacheResult(stagingClaimAnalyticses);
	}

	/**
	 * Creates a new staging claim analytics with the primary key. Does not add the staging claim analytics to the database.
	 *
	 * @param stagingClaimAnalyticsId the primary key for the new staging claim analytics
	 * @return the new staging claim analytics
	 */
	public static StagingClaimAnalytics create(long stagingClaimAnalyticsId) {
		return getPersistence().create(stagingClaimAnalyticsId);
	}

	/**
	 * Removes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	public static StagingClaimAnalytics remove(long stagingClaimAnalyticsId)
		throws com.argus.oth.claim.exception.
			NoSuchStagingClaimAnalyticsException {

		return getPersistence().remove(stagingClaimAnalyticsId);
	}

	public static StagingClaimAnalytics updateImpl(
		StagingClaimAnalytics stagingClaimAnalytics) {

		return getPersistence().updateImpl(stagingClaimAnalytics);
	}

	/**
	 * Returns the staging claim analytics with the primary key or throws a <code>NoSuchStagingClaimAnalyticsException</code> if it could not be found.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	public static StagingClaimAnalytics findByPrimaryKey(
			long stagingClaimAnalyticsId)
		throws com.argus.oth.claim.exception.
			NoSuchStagingClaimAnalyticsException {

		return getPersistence().findByPrimaryKey(stagingClaimAnalyticsId);
	}

	/**
	 * Returns the staging claim analytics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics, or <code>null</code> if a staging claim analytics with the primary key could not be found
	 */
	public static StagingClaimAnalytics fetchByPrimaryKey(
		long stagingClaimAnalyticsId) {

		return getPersistence().fetchByPrimaryKey(stagingClaimAnalyticsId);
	}

	/**
	 * Returns all the staging claim analyticses.
	 *
	 * @return the staging claim analyticses
	 */
	public static List<StagingClaimAnalytics> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @return the range of staging claim analyticses
	 */
	public static List<StagingClaimAnalytics> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claim analyticses
	 */
	public static List<StagingClaimAnalytics> findAll(
		int start, int end,
		OrderByComparator<StagingClaimAnalytics> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claim analyticses
	 */
	public static List<StagingClaimAnalytics> findAll(
		int start, int end,
		OrderByComparator<StagingClaimAnalytics> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging claim analyticses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging claim analyticses.
	 *
	 * @return the number of staging claim analyticses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingClaimAnalyticsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClaimAnalyticsPersistence, StagingClaimAnalyticsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingClaimAnalyticsPersistence.class);

		ServiceTracker
			<StagingClaimAnalyticsPersistence, StagingClaimAnalyticsPersistence>
				serviceTracker =
					new ServiceTracker
						<StagingClaimAnalyticsPersistence,
						 StagingClaimAnalyticsPersistence>(
							 bundle.getBundleContext(),
							 StagingClaimAnalyticsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}