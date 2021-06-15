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

import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;

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
 * The persistence utility for the staging am analytics claim service. This utility wraps <code>com.argus.oth.account.management.service.persistence.impl.StagingAMAnalyticsClaimPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsClaimPersistence
 * @generated
 */
public class StagingAMAnalyticsClaimUtil {

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
	public static void clearCache(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {

		getPersistence().clearCache(stagingAMAnalyticsClaim);
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
	public static Map<Serializable, StagingAMAnalyticsClaim> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingAMAnalyticsClaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingAMAnalyticsClaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingAMAnalyticsClaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingAMAnalyticsClaim> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingAMAnalyticsClaim update(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {

		return getPersistence().update(stagingAMAnalyticsClaim);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingAMAnalyticsClaim update(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim,
		ServiceContext serviceContext) {

		return getPersistence().update(stagingAMAnalyticsClaim, serviceContext);
	}

	/**
	 * Caches the staging am analytics claim in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 */
	public static void cacheResult(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {

		getPersistence().cacheResult(stagingAMAnalyticsClaim);
	}

	/**
	 * Caches the staging am analytics claims in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsClaims the staging am analytics claims
	 */
	public static void cacheResult(
		List<StagingAMAnalyticsClaim> stagingAMAnalyticsClaims) {

		getPersistence().cacheResult(stagingAMAnalyticsClaims);
	}

	/**
	 * Creates a new staging am analytics claim with the primary key. Does not add the staging am analytics claim to the database.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key for the new staging am analytics claim
	 * @return the new staging am analytics claim
	 */
	public static StagingAMAnalyticsClaim create(
		long stagingAMAnalyticsClaimId) {

		return getPersistence().create(stagingAMAnalyticsClaimId);
	}

	/**
	 * Removes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	public static StagingAMAnalyticsClaim remove(long stagingAMAnalyticsClaimId)
		throws com.argus.oth.account.management.exception.
			NoSuchStagingAMAnalyticsClaimException {

		return getPersistence().remove(stagingAMAnalyticsClaimId);
	}

	public static StagingAMAnalyticsClaim updateImpl(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {

		return getPersistence().updateImpl(stagingAMAnalyticsClaim);
	}

	/**
	 * Returns the staging am analytics claim with the primary key or throws a <code>NoSuchStagingAMAnalyticsClaimException</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	public static StagingAMAnalyticsClaim findByPrimaryKey(
			long stagingAMAnalyticsClaimId)
		throws com.argus.oth.account.management.exception.
			NoSuchStagingAMAnalyticsClaimException {

		return getPersistence().findByPrimaryKey(stagingAMAnalyticsClaimId);
	}

	/**
	 * Returns the staging am analytics claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim, or <code>null</code> if a staging am analytics claim with the primary key could not be found
	 */
	public static StagingAMAnalyticsClaim fetchByPrimaryKey(
		long stagingAMAnalyticsClaimId) {

		return getPersistence().fetchByPrimaryKey(stagingAMAnalyticsClaimId);
	}

	/**
	 * Returns all the staging am analytics claims.
	 *
	 * @return the staging am analytics claims
	 */
	public static List<StagingAMAnalyticsClaim> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @return the range of staging am analytics claims
	 */
	public static List<StagingAMAnalyticsClaim> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging am analytics claims
	 */
	public static List<StagingAMAnalyticsClaim> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsClaim> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging am analytics claims
	 */
	public static List<StagingAMAnalyticsClaim> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsClaim> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging am analytics claims from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging am analytics claims.
	 *
	 * @return the number of staging am analytics claims
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingAMAnalyticsClaimPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAMAnalyticsClaimPersistence, StagingAMAnalyticsClaimPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAMAnalyticsClaimPersistence.class);

		ServiceTracker
			<StagingAMAnalyticsClaimPersistence,
			 StagingAMAnalyticsClaimPersistence> serviceTracker =
				new ServiceTracker
					<StagingAMAnalyticsClaimPersistence,
					 StagingAMAnalyticsClaimPersistence>(
						 bundle.getBundleContext(),
						 StagingAMAnalyticsClaimPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}