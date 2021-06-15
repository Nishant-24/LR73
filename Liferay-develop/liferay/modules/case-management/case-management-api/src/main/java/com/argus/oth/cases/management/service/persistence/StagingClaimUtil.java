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

import com.argus.oth.cases.management.model.StagingClaim;

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
 * The persistence utility for the staging claim service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingClaimPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimPersistence
 * @generated
 */
public class StagingClaimUtil {

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
	public static void clearCache(StagingClaim stagingClaim) {
		getPersistence().clearCache(stagingClaim);
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
	public static Map<Serializable, StagingClaim> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingClaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingClaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingClaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingClaim> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingClaim update(StagingClaim stagingClaim) {
		return getPersistence().update(stagingClaim);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingClaim update(
		StagingClaim stagingClaim, ServiceContext serviceContext) {

		return getPersistence().update(stagingClaim, serviceContext);
	}

	/**
	 * Caches the staging claim in the entity cache if it is enabled.
	 *
	 * @param stagingClaim the staging claim
	 */
	public static void cacheResult(StagingClaim stagingClaim) {
		getPersistence().cacheResult(stagingClaim);
	}

	/**
	 * Caches the staging claims in the entity cache if it is enabled.
	 *
	 * @param stagingClaims the staging claims
	 */
	public static void cacheResult(List<StagingClaim> stagingClaims) {
		getPersistence().cacheResult(stagingClaims);
	}

	/**
	 * Creates a new staging claim with the primary key. Does not add the staging claim to the database.
	 *
	 * @param stagingClaimId the primary key for the new staging claim
	 * @return the new staging claim
	 */
	public static StagingClaim create(long stagingClaimId) {
		return getPersistence().create(stagingClaimId);
	}

	/**
	 * Removes the staging claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim that was removed
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	public static StagingClaim remove(long stagingClaimId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClaimException {

		return getPersistence().remove(stagingClaimId);
	}

	public static StagingClaim updateImpl(StagingClaim stagingClaim) {
		return getPersistence().updateImpl(stagingClaim);
	}

	/**
	 * Returns the staging claim with the primary key or throws a <code>NoSuchStagingClaimException</code> if it could not be found.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	public static StagingClaim findByPrimaryKey(long stagingClaimId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClaimException {

		return getPersistence().findByPrimaryKey(stagingClaimId);
	}

	/**
	 * Returns the staging claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim, or <code>null</code> if a staging claim with the primary key could not be found
	 */
	public static StagingClaim fetchByPrimaryKey(long stagingClaimId) {
		return getPersistence().fetchByPrimaryKey(stagingClaimId);
	}

	/**
	 * Returns all the staging claims.
	 *
	 * @return the staging claims
	 */
	public static List<StagingClaim> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @return the range of staging claims
	 */
	public static List<StagingClaim> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claims
	 */
	public static List<StagingClaim> findAll(
		int start, int end, OrderByComparator<StagingClaim> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claims
	 */
	public static List<StagingClaim> findAll(
		int start, int end, OrderByComparator<StagingClaim> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging claims from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging claims.
	 *
	 * @return the number of staging claims
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingClaimPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClaimPersistence, StagingClaimPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingClaimPersistence.class);

		ServiceTracker<StagingClaimPersistence, StagingClaimPersistence>
			serviceTracker =
				new ServiceTracker
					<StagingClaimPersistence, StagingClaimPersistence>(
						bundle.getBundleContext(),
						StagingClaimPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}