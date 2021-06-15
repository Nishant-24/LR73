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

import com.argus.oth.cases.management.model.StagingCases;

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
 * The persistence utility for the staging cases service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingCasesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingCasesPersistence
 * @generated
 */
public class StagingCasesUtil {

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
	public static void clearCache(StagingCases stagingCases) {
		getPersistence().clearCache(stagingCases);
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
	public static Map<Serializable, StagingCases> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingCases> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingCases> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingCases> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingCases> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingCases update(StagingCases stagingCases) {
		return getPersistence().update(stagingCases);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingCases update(
		StagingCases stagingCases, ServiceContext serviceContext) {

		return getPersistence().update(stagingCases, serviceContext);
	}

	/**
	 * Returns the staging cases where externalCaseId = &#63; or throws a <code>NoSuchStagingCasesException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	public static StagingCases findByExternalCaseId(String externalCaseId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().findByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the staging cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public static StagingCases fetchByExternalCaseId(String externalCaseId) {
		return getPersistence().fetchByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the staging cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public static StagingCases fetchByExternalCaseId(
		String externalCaseId, boolean useFinderCache) {

		return getPersistence().fetchByExternalCaseId(
			externalCaseId, useFinderCache);
	}

	/**
	 * Removes the staging cases where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @return the staging cases that was removed
	 */
	public static StagingCases removeByExternalCaseId(String externalCaseId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().removeByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the number of staging caseses where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching staging caseses
	 */
	public static int countByExternalCaseId(String externalCaseId) {
		return getPersistence().countByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns all the staging caseses where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching staging caseses
	 */
	public static List<StagingCases> findByRowProcessed(boolean rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of matching staging caseses
	 */
	public static List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging caseses
	 */
	public static List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingCases> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging caseses
	 */
	public static List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingCases> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	public static StagingCases findByRowProcessed_First(
			boolean rowProcessed,
			OrderByComparator<StagingCases> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public static StagingCases fetchByRowProcessed_First(
		boolean rowProcessed,
		OrderByComparator<StagingCases> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	public static StagingCases findByRowProcessed_Last(
			boolean rowProcessed,
			OrderByComparator<StagingCases> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public static StagingCases fetchByRowProcessed_Last(
		boolean rowProcessed,
		OrderByComparator<StagingCases> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the staging caseses before and after the current staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param stagingCaseId the primary key of the current staging cases
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	public static StagingCases[] findByRowProcessed_PrevAndNext(
			long stagingCaseId, boolean rowProcessed,
			OrderByComparator<StagingCases> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			stagingCaseId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the staging caseses where rowProcessed = &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(boolean rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of staging caseses where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching staging caseses
	 */
	public static int countByRowProcessed(boolean rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the staging cases in the entity cache if it is enabled.
	 *
	 * @param stagingCases the staging cases
	 */
	public static void cacheResult(StagingCases stagingCases) {
		getPersistence().cacheResult(stagingCases);
	}

	/**
	 * Caches the staging caseses in the entity cache if it is enabled.
	 *
	 * @param stagingCaseses the staging caseses
	 */
	public static void cacheResult(List<StagingCases> stagingCaseses) {
		getPersistence().cacheResult(stagingCaseses);
	}

	/**
	 * Creates a new staging cases with the primary key. Does not add the staging cases to the database.
	 *
	 * @param stagingCaseId the primary key for the new staging cases
	 * @return the new staging cases
	 */
	public static StagingCases create(long stagingCaseId) {
		return getPersistence().create(stagingCaseId);
	}

	/**
	 * Removes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	public static StagingCases remove(long stagingCaseId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().remove(stagingCaseId);
	}

	public static StagingCases updateImpl(StagingCases stagingCases) {
		return getPersistence().updateImpl(stagingCases);
	}

	/**
	 * Returns the staging cases with the primary key or throws a <code>NoSuchStagingCasesException</code> if it could not be found.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	public static StagingCases findByPrimaryKey(long stagingCaseId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingCasesException {

		return getPersistence().findByPrimaryKey(stagingCaseId);
	}

	/**
	 * Returns the staging cases with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases, or <code>null</code> if a staging cases with the primary key could not be found
	 */
	public static StagingCases fetchByPrimaryKey(long stagingCaseId) {
		return getPersistence().fetchByPrimaryKey(stagingCaseId);
	}

	/**
	 * Returns all the staging caseses.
	 *
	 * @return the staging caseses
	 */
	public static List<StagingCases> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of staging caseses
	 */
	public static List<StagingCases> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging caseses
	 */
	public static List<StagingCases> findAll(
		int start, int end, OrderByComparator<StagingCases> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging caseses
	 */
	public static List<StagingCases> findAll(
		int start, int end, OrderByComparator<StagingCases> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging caseses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging caseses.
	 *
	 * @return the number of staging caseses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingCasesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingCasesPersistence, StagingCasesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingCasesPersistence.class);

		ServiceTracker<StagingCasesPersistence, StagingCasesPersistence>
			serviceTracker =
				new ServiceTracker
					<StagingCasesPersistence, StagingCasesPersistence>(
						bundle.getBundleContext(),
						StagingCasesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}