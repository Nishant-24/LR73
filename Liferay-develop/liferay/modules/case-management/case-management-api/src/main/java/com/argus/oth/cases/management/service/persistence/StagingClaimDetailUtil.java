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

import com.argus.oth.cases.management.model.StagingClaimDetail;

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
 * The persistence utility for the staging claim detail service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingClaimDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetailPersistence
 * @generated
 */
public class StagingClaimDetailUtil {

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
	public static void clearCache(StagingClaimDetail stagingClaimDetail) {
		getPersistence().clearCache(stagingClaimDetail);
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
	public static Map<Serializable, StagingClaimDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingClaimDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingClaimDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingClaimDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingClaimDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingClaimDetail update(
		StagingClaimDetail stagingClaimDetail) {

		return getPersistence().update(stagingClaimDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingClaimDetail update(
		StagingClaimDetail stagingClaimDetail, ServiceContext serviceContext) {

		return getPersistence().update(stagingClaimDetail, serviceContext);
	}

	/**
	 * Caches the staging claim detail in the entity cache if it is enabled.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 */
	public static void cacheResult(StagingClaimDetail stagingClaimDetail) {
		getPersistence().cacheResult(stagingClaimDetail);
	}

	/**
	 * Caches the staging claim details in the entity cache if it is enabled.
	 *
	 * @param stagingClaimDetails the staging claim details
	 */
	public static void cacheResult(
		List<StagingClaimDetail> stagingClaimDetails) {

		getPersistence().cacheResult(stagingClaimDetails);
	}

	/**
	 * Creates a new staging claim detail with the primary key. Does not add the staging claim detail to the database.
	 *
	 * @param stagingClaimDetailId the primary key for the new staging claim detail
	 * @return the new staging claim detail
	 */
	public static StagingClaimDetail create(long stagingClaimDetailId) {
		return getPersistence().create(stagingClaimDetailId);
	}

	/**
	 * Removes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	public static StagingClaimDetail remove(long stagingClaimDetailId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClaimDetailException {

		return getPersistence().remove(stagingClaimDetailId);
	}

	public static StagingClaimDetail updateImpl(
		StagingClaimDetail stagingClaimDetail) {

		return getPersistence().updateImpl(stagingClaimDetail);
	}

	/**
	 * Returns the staging claim detail with the primary key or throws a <code>NoSuchStagingClaimDetailException</code> if it could not be found.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	public static StagingClaimDetail findByPrimaryKey(long stagingClaimDetailId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingClaimDetailException {

		return getPersistence().findByPrimaryKey(stagingClaimDetailId);
	}

	/**
	 * Returns the staging claim detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail, or <code>null</code> if a staging claim detail with the primary key could not be found
	 */
	public static StagingClaimDetail fetchByPrimaryKey(
		long stagingClaimDetailId) {

		return getPersistence().fetchByPrimaryKey(stagingClaimDetailId);
	}

	/**
	 * Returns all the staging claim details.
	 *
	 * @return the staging claim details
	 */
	public static List<StagingClaimDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @return the range of staging claim details
	 */
	public static List<StagingClaimDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claim details
	 */
	public static List<StagingClaimDetail> findAll(
		int start, int end,
		OrderByComparator<StagingClaimDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claim details
	 */
	public static List<StagingClaimDetail> findAll(
		int start, int end,
		OrderByComparator<StagingClaimDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging claim details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging claim details.
	 *
	 * @return the number of staging claim details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingClaimDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClaimDetailPersistence, StagingClaimDetailPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingClaimDetailPersistence.class);

		ServiceTracker
			<StagingClaimDetailPersistence, StagingClaimDetailPersistence>
				serviceTracker =
					new ServiceTracker
						<StagingClaimDetailPersistence,
						 StagingClaimDetailPersistence>(
							 bundle.getBundleContext(),
							 StagingClaimDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}