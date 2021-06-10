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

import com.argus.oth.cases.management.model.StagingAuthProcedure;

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
 * The persistence utility for the staging auth procedure service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingAuthProcedurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthProcedurePersistence
 * @generated
 */
public class StagingAuthProcedureUtil {

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
	public static void clearCache(StagingAuthProcedure stagingAuthProcedure) {
		getPersistence().clearCache(stagingAuthProcedure);
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
	public static Map<Serializable, StagingAuthProcedure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingAuthProcedure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingAuthProcedure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingAuthProcedure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingAuthProcedure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingAuthProcedure update(
		StagingAuthProcedure stagingAuthProcedure) {

		return getPersistence().update(stagingAuthProcedure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingAuthProcedure update(
		StagingAuthProcedure stagingAuthProcedure,
		ServiceContext serviceContext) {

		return getPersistence().update(stagingAuthProcedure, serviceContext);
	}

	/**
	 * Caches the staging auth procedure in the entity cache if it is enabled.
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 */
	public static void cacheResult(StagingAuthProcedure stagingAuthProcedure) {
		getPersistence().cacheResult(stagingAuthProcedure);
	}

	/**
	 * Caches the staging auth procedures in the entity cache if it is enabled.
	 *
	 * @param stagingAuthProcedures the staging auth procedures
	 */
	public static void cacheResult(
		List<StagingAuthProcedure> stagingAuthProcedures) {

		getPersistence().cacheResult(stagingAuthProcedures);
	}

	/**
	 * Creates a new staging auth procedure with the primary key. Does not add the staging auth procedure to the database.
	 *
	 * @param stagingAuthProcedureId the primary key for the new staging auth procedure
	 * @return the new staging auth procedure
	 */
	public static StagingAuthProcedure create(long stagingAuthProcedureId) {
		return getPersistence().create(stagingAuthProcedureId);
	}

	/**
	 * Removes the staging auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure that was removed
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	public static StagingAuthProcedure remove(long stagingAuthProcedureId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthProcedureException {

		return getPersistence().remove(stagingAuthProcedureId);
	}

	public static StagingAuthProcedure updateImpl(
		StagingAuthProcedure stagingAuthProcedure) {

		return getPersistence().updateImpl(stagingAuthProcedure);
	}

	/**
	 * Returns the staging auth procedure with the primary key or throws a <code>NoSuchStagingAuthProcedureException</code> if it could not be found.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	public static StagingAuthProcedure findByPrimaryKey(
			long stagingAuthProcedureId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthProcedureException {

		return getPersistence().findByPrimaryKey(stagingAuthProcedureId);
	}

	/**
	 * Returns the staging auth procedure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure, or <code>null</code> if a staging auth procedure with the primary key could not be found
	 */
	public static StagingAuthProcedure fetchByPrimaryKey(
		long stagingAuthProcedureId) {

		return getPersistence().fetchByPrimaryKey(stagingAuthProcedureId);
	}

	/**
	 * Returns all the staging auth procedures.
	 *
	 * @return the staging auth procedures
	 */
	public static List<StagingAuthProcedure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @return the range of staging auth procedures
	 */
	public static List<StagingAuthProcedure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging auth procedures
	 */
	public static List<StagingAuthProcedure> findAll(
		int start, int end,
		OrderByComparator<StagingAuthProcedure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging auth procedures
	 */
	public static List<StagingAuthProcedure> findAll(
		int start, int end,
		OrderByComparator<StagingAuthProcedure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging auth procedures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging auth procedures.
	 *
	 * @return the number of staging auth procedures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingAuthProcedurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAuthProcedurePersistence, StagingAuthProcedurePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAuthProcedurePersistence.class);

		ServiceTracker
			<StagingAuthProcedurePersistence, StagingAuthProcedurePersistence>
				serviceTracker =
					new ServiceTracker
						<StagingAuthProcedurePersistence,
						 StagingAuthProcedurePersistence>(
							 bundle.getBundleContext(),
							 StagingAuthProcedurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}