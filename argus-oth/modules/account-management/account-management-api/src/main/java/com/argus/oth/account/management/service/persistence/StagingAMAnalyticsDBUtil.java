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

import com.argus.oth.account.management.model.StagingAMAnalyticsDB;

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
 * The persistence utility for the staging am analytics db service. This utility wraps <code>com.argus.oth.account.management.service.persistence.impl.StagingAMAnalyticsDBPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsDBPersistence
 * @generated
 */
public class StagingAMAnalyticsDBUtil {

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
	public static void clearCache(StagingAMAnalyticsDB stagingAMAnalyticsDB) {
		getPersistence().clearCache(stagingAMAnalyticsDB);
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
	public static Map<Serializable, StagingAMAnalyticsDB> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingAMAnalyticsDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingAMAnalyticsDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingAMAnalyticsDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingAMAnalyticsDB> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingAMAnalyticsDB update(
		StagingAMAnalyticsDB stagingAMAnalyticsDB) {

		return getPersistence().update(stagingAMAnalyticsDB);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingAMAnalyticsDB update(
		StagingAMAnalyticsDB stagingAMAnalyticsDB,
		ServiceContext serviceContext) {

		return getPersistence().update(stagingAMAnalyticsDB, serviceContext);
	}

	/**
	 * Caches the staging am analytics db in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 */
	public static void cacheResult(StagingAMAnalyticsDB stagingAMAnalyticsDB) {
		getPersistence().cacheResult(stagingAMAnalyticsDB);
	}

	/**
	 * Caches the staging am analytics dbs in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsDBs the staging am analytics dbs
	 */
	public static void cacheResult(
		List<StagingAMAnalyticsDB> stagingAMAnalyticsDBs) {

		getPersistence().cacheResult(stagingAMAnalyticsDBs);
	}

	/**
	 * Creates a new staging am analytics db with the primary key. Does not add the staging am analytics db to the database.
	 *
	 * @param stagingAMAnalyticsDbId the primary key for the new staging am analytics db
	 * @return the new staging am analytics db
	 */
	public static StagingAMAnalyticsDB create(long stagingAMAnalyticsDbId) {
		return getPersistence().create(stagingAMAnalyticsDbId);
	}

	/**
	 * Removes the staging am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db that was removed
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	public static StagingAMAnalyticsDB remove(long stagingAMAnalyticsDbId)
		throws com.argus.oth.account.management.exception.
			NoSuchStagingAMAnalyticsDBException {

		return getPersistence().remove(stagingAMAnalyticsDbId);
	}

	public static StagingAMAnalyticsDB updateImpl(
		StagingAMAnalyticsDB stagingAMAnalyticsDB) {

		return getPersistence().updateImpl(stagingAMAnalyticsDB);
	}

	/**
	 * Returns the staging am analytics db with the primary key or throws a <code>NoSuchStagingAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	public static StagingAMAnalyticsDB findByPrimaryKey(
			long stagingAMAnalyticsDbId)
		throws com.argus.oth.account.management.exception.
			NoSuchStagingAMAnalyticsDBException {

		return getPersistence().findByPrimaryKey(stagingAMAnalyticsDbId);
	}

	/**
	 * Returns the staging am analytics db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db, or <code>null</code> if a staging am analytics db with the primary key could not be found
	 */
	public static StagingAMAnalyticsDB fetchByPrimaryKey(
		long stagingAMAnalyticsDbId) {

		return getPersistence().fetchByPrimaryKey(stagingAMAnalyticsDbId);
	}

	/**
	 * Returns all the staging am analytics dbs.
	 *
	 * @return the staging am analytics dbs
	 */
	public static List<StagingAMAnalyticsDB> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @return the range of staging am analytics dbs
	 */
	public static List<StagingAMAnalyticsDB> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging am analytics dbs
	 */
	public static List<StagingAMAnalyticsDB> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsDB> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging am analytics dbs
	 */
	public static List<StagingAMAnalyticsDB> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsDB> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging am analytics dbs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging am analytics dbs.
	 *
	 * @return the number of staging am analytics dbs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingAMAnalyticsDBPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAMAnalyticsDBPersistence, StagingAMAnalyticsDBPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAMAnalyticsDBPersistence.class);

		ServiceTracker
			<StagingAMAnalyticsDBPersistence, StagingAMAnalyticsDBPersistence>
				serviceTracker =
					new ServiceTracker
						<StagingAMAnalyticsDBPersistence,
						 StagingAMAnalyticsDBPersistence>(
							 bundle.getBundleContext(),
							 StagingAMAnalyticsDBPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}