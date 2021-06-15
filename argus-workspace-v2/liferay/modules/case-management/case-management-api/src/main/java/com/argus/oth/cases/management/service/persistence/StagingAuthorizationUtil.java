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

import com.argus.oth.cases.management.model.StagingAuthorization;

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
 * The persistence utility for the staging authorization service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingAuthorizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthorizationPersistence
 * @generated
 */
public class StagingAuthorizationUtil {

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
	public static void clearCache(StagingAuthorization stagingAuthorization) {
		getPersistence().clearCache(stagingAuthorization);
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
	public static Map<Serializable, StagingAuthorization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingAuthorization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingAuthorization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingAuthorization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingAuthorization update(
		StagingAuthorization stagingAuthorization) {

		return getPersistence().update(stagingAuthorization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingAuthorization update(
		StagingAuthorization stagingAuthorization,
		ServiceContext serviceContext) {

		return getPersistence().update(stagingAuthorization, serviceContext);
	}

	/**
	 * Returns all the staging authorizations where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging authorizations
	 */
	public static List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId) {

		return getPersistence().findByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns a range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of matching staging authorizations
	 */
	public static List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end) {

		return getPersistence().findByExternalCaseId(
			externalCaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging authorizations
	 */
	public static List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return getPersistence().findByExternalCaseId(
			externalCaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging authorizations
	 */
	public static List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByExternalCaseId(
			externalCaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging authorization
	 * @throws NoSuchStagingAuthorizationException if a matching staging authorization could not be found
	 */
	public static StagingAuthorization findByExternalCaseId_First(
			long externalCaseId,
			OrderByComparator<StagingAuthorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthorizationException {

		return getPersistence().findByExternalCaseId_First(
			externalCaseId, orderByComparator);
	}

	/**
	 * Returns the first staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging authorization, or <code>null</code> if a matching staging authorization could not be found
	 */
	public static StagingAuthorization fetchByExternalCaseId_First(
		long externalCaseId,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return getPersistence().fetchByExternalCaseId_First(
			externalCaseId, orderByComparator);
	}

	/**
	 * Returns the last staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging authorization
	 * @throws NoSuchStagingAuthorizationException if a matching staging authorization could not be found
	 */
	public static StagingAuthorization findByExternalCaseId_Last(
			long externalCaseId,
			OrderByComparator<StagingAuthorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthorizationException {

		return getPersistence().findByExternalCaseId_Last(
			externalCaseId, orderByComparator);
	}

	/**
	 * Returns the last staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging authorization, or <code>null</code> if a matching staging authorization could not be found
	 */
	public static StagingAuthorization fetchByExternalCaseId_Last(
		long externalCaseId,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return getPersistence().fetchByExternalCaseId_Last(
			externalCaseId, orderByComparator);
	}

	/**
	 * Returns the staging authorizations before and after the current staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param stagingAuthorizationId the primary key of the current staging authorization
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	public static StagingAuthorization[] findByExternalCaseId_PrevAndNext(
			long stagingAuthorizationId, long externalCaseId,
			OrderByComparator<StagingAuthorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthorizationException {

		return getPersistence().findByExternalCaseId_PrevAndNext(
			stagingAuthorizationId, externalCaseId, orderByComparator);
	}

	/**
	 * Removes all the staging authorizations where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 */
	public static void removeByExternalCaseId(long externalCaseId) {
		getPersistence().removeByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the number of staging authorizations where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching staging authorizations
	 */
	public static int countByExternalCaseId(long externalCaseId) {
		return getPersistence().countByExternalCaseId(externalCaseId);
	}

	/**
	 * Caches the staging authorization in the entity cache if it is enabled.
	 *
	 * @param stagingAuthorization the staging authorization
	 */
	public static void cacheResult(StagingAuthorization stagingAuthorization) {
		getPersistence().cacheResult(stagingAuthorization);
	}

	/**
	 * Caches the staging authorizations in the entity cache if it is enabled.
	 *
	 * @param stagingAuthorizations the staging authorizations
	 */
	public static void cacheResult(
		List<StagingAuthorization> stagingAuthorizations) {

		getPersistence().cacheResult(stagingAuthorizations);
	}

	/**
	 * Creates a new staging authorization with the primary key. Does not add the staging authorization to the database.
	 *
	 * @param stagingAuthorizationId the primary key for the new staging authorization
	 * @return the new staging authorization
	 */
	public static StagingAuthorization create(long stagingAuthorizationId) {
		return getPersistence().create(stagingAuthorizationId);
	}

	/**
	 * Removes the staging authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization that was removed
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	public static StagingAuthorization remove(long stagingAuthorizationId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthorizationException {

		return getPersistence().remove(stagingAuthorizationId);
	}

	public static StagingAuthorization updateImpl(
		StagingAuthorization stagingAuthorization) {

		return getPersistence().updateImpl(stagingAuthorization);
	}

	/**
	 * Returns the staging authorization with the primary key or throws a <code>NoSuchStagingAuthorizationException</code> if it could not be found.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	public static StagingAuthorization findByPrimaryKey(
			long stagingAuthorizationId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingAuthorizationException {

		return getPersistence().findByPrimaryKey(stagingAuthorizationId);
	}

	/**
	 * Returns the staging authorization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization, or <code>null</code> if a staging authorization with the primary key could not be found
	 */
	public static StagingAuthorization fetchByPrimaryKey(
		long stagingAuthorizationId) {

		return getPersistence().fetchByPrimaryKey(stagingAuthorizationId);
	}

	/**
	 * Returns all the staging authorizations.
	 *
	 * @return the staging authorizations
	 */
	public static List<StagingAuthorization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of staging authorizations
	 */
	public static List<StagingAuthorization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging authorizations
	 */
	public static List<StagingAuthorization> findAll(
		int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging authorizations
	 */
	public static List<StagingAuthorization> findAll(
		int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging authorizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging authorizations.
	 *
	 * @return the number of staging authorizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingAuthorizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAuthorizationPersistence, StagingAuthorizationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAuthorizationPersistence.class);

		ServiceTracker
			<StagingAuthorizationPersistence, StagingAuthorizationPersistence>
				serviceTracker =
					new ServiceTracker
						<StagingAuthorizationPersistence,
						 StagingAuthorizationPersistence>(
							 bundle.getBundleContext(),
							 StagingAuthorizationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}