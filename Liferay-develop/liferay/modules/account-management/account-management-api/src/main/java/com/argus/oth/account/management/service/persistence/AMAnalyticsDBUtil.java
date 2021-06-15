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

import com.argus.oth.account.management.model.AMAnalyticsDB;

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
 * The persistence utility for the am analytics db service. This utility wraps <code>com.argus.oth.account.management.service.persistence.impl.AMAnalyticsDBPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsDBPersistence
 * @generated
 */
public class AMAnalyticsDBUtil {

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
	public static void clearCache(AMAnalyticsDB amAnalyticsDB) {
		getPersistence().clearCache(amAnalyticsDB);
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
	public static Map<Serializable, AMAnalyticsDB> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMAnalyticsDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMAnalyticsDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMAnalyticsDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMAnalyticsDB> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMAnalyticsDB update(AMAnalyticsDB amAnalyticsDB) {
		return getPersistence().update(amAnalyticsDB);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMAnalyticsDB update(
		AMAnalyticsDB amAnalyticsDB, ServiceContext serviceContext) {

		return getPersistence().update(amAnalyticsDB, serviceContext);
	}

	/**
	 * Returns the am analytics db where clientId = &#63; or throws a <code>NoSuchAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param clientId the client ID
	 * @return the matching am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a matching am analytics db could not be found
	 */
	public static AMAnalyticsDB findByClientId(long clientId)
		throws com.argus.oth.account.management.exception.
			NoSuchAMAnalyticsDBException {

		return getPersistence().findByClientId(clientId);
	}

	/**
	 * Returns the am analytics db where clientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientId the client ID
	 * @return the matching am analytics db, or <code>null</code> if a matching am analytics db could not be found
	 */
	public static AMAnalyticsDB fetchByClientId(long clientId) {
		return getPersistence().fetchByClientId(clientId);
	}

	/**
	 * Returns the am analytics db where clientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientId the client ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching am analytics db, or <code>null</code> if a matching am analytics db could not be found
	 */
	public static AMAnalyticsDB fetchByClientId(
		long clientId, boolean useFinderCache) {

		return getPersistence().fetchByClientId(clientId, useFinderCache);
	}

	/**
	 * Removes the am analytics db where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @return the am analytics db that was removed
	 */
	public static AMAnalyticsDB removeByClientId(long clientId)
		throws com.argus.oth.account.management.exception.
			NoSuchAMAnalyticsDBException {

		return getPersistence().removeByClientId(clientId);
	}

	/**
	 * Returns the number of am analytics dbs where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching am analytics dbs
	 */
	public static int countByClientId(long clientId) {
		return getPersistence().countByClientId(clientId);
	}

	/**
	 * Caches the am analytics db in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsDB the am analytics db
	 */
	public static void cacheResult(AMAnalyticsDB amAnalyticsDB) {
		getPersistence().cacheResult(amAnalyticsDB);
	}

	/**
	 * Caches the am analytics dbs in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsDBs the am analytics dbs
	 */
	public static void cacheResult(List<AMAnalyticsDB> amAnalyticsDBs) {
		getPersistence().cacheResult(amAnalyticsDBs);
	}

	/**
	 * Creates a new am analytics db with the primary key. Does not add the am analytics db to the database.
	 *
	 * @param amAnalyticsDbId the primary key for the new am analytics db
	 * @return the new am analytics db
	 */
	public static AMAnalyticsDB create(long amAnalyticsDbId) {
		return getPersistence().create(amAnalyticsDbId);
	}

	/**
	 * Removes the am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db that was removed
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	public static AMAnalyticsDB remove(long amAnalyticsDbId)
		throws com.argus.oth.account.management.exception.
			NoSuchAMAnalyticsDBException {

		return getPersistence().remove(amAnalyticsDbId);
	}

	public static AMAnalyticsDB updateImpl(AMAnalyticsDB amAnalyticsDB) {
		return getPersistence().updateImpl(amAnalyticsDB);
	}

	/**
	 * Returns the am analytics db with the primary key or throws a <code>NoSuchAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	public static AMAnalyticsDB findByPrimaryKey(long amAnalyticsDbId)
		throws com.argus.oth.account.management.exception.
			NoSuchAMAnalyticsDBException {

		return getPersistence().findByPrimaryKey(amAnalyticsDbId);
	}

	/**
	 * Returns the am analytics db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db, or <code>null</code> if a am analytics db with the primary key could not be found
	 */
	public static AMAnalyticsDB fetchByPrimaryKey(long amAnalyticsDbId) {
		return getPersistence().fetchByPrimaryKey(amAnalyticsDbId);
	}

	/**
	 * Returns all the am analytics dbs.
	 *
	 * @return the am analytics dbs
	 */
	public static List<AMAnalyticsDB> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @return the range of am analytics dbs
	 */
	public static List<AMAnalyticsDB> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics dbs
	 */
	public static List<AMAnalyticsDB> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsDB> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics dbs
	 */
	public static List<AMAnalyticsDB> findAll(
		int start, int end, OrderByComparator<AMAnalyticsDB> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the am analytics dbs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of am analytics dbs.
	 *
	 * @return the number of am analytics dbs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AMAnalyticsDBPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AMAnalyticsDBPersistence, AMAnalyticsDBPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMAnalyticsDBPersistence.class);

		ServiceTracker<AMAnalyticsDBPersistence, AMAnalyticsDBPersistence>
			serviceTracker =
				new ServiceTracker
					<AMAnalyticsDBPersistence, AMAnalyticsDBPersistence>(
						bundle.getBundleContext(),
						AMAnalyticsDBPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}