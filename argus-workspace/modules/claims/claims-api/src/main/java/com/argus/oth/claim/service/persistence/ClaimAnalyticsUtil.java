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

import com.argus.oth.claim.model.ClaimAnalytics;

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
 * The persistence utility for the claim analytics service. This utility wraps <code>com.argus.oth.claim.service.persistence.impl.ClaimAnalyticsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalyticsPersistence
 * @generated
 */
public class ClaimAnalyticsUtil {

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
	public static void clearCache(ClaimAnalytics claimAnalytics) {
		getPersistence().clearCache(claimAnalytics);
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
	public static Map<Serializable, ClaimAnalytics> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClaimAnalytics> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClaimAnalytics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClaimAnalytics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClaimAnalytics update(ClaimAnalytics claimAnalytics) {
		return getPersistence().update(claimAnalytics);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClaimAnalytics update(
		ClaimAnalytics claimAnalytics, ServiceContext serviceContext) {

		return getPersistence().update(claimAnalytics, serviceContext);
	}

	/**
	 * Returns all the claim analyticses where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByExternalClientId(
		long externalClientId) {

		return getPersistence().findByExternalClientId(externalClientId);
	}

	/**
	 * Returns a range of all the claim analyticses where externalClientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end) {

		return getPersistence().findByExternalClientId(
			externalClientId, start, end);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().findByExternalClientId(
			externalClientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByExternalClientId(
			externalClientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics findByExternalClientId_First(
			long externalClientId,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByExternalClientId_First(
			externalClientId, orderByComparator);
	}

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics fetchByExternalClientId_First(
		long externalClientId,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().fetchByExternalClientId_First(
			externalClientId, orderByComparator);
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics findByExternalClientId_Last(
			long externalClientId,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByExternalClientId_Last(
			externalClientId, orderByComparator);
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics fetchByExternalClientId_Last(
		long externalClientId,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().fetchByExternalClientId_Last(
			externalClientId, orderByComparator);
	}

	/**
	 * Returns the claim analyticses before and after the current claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param claimAnalyticsId the primary key of the current claim analytics
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public static ClaimAnalytics[] findByExternalClientId_PrevAndNext(
			long claimAnalyticsId, long externalClientId,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByExternalClientId_PrevAndNext(
			claimAnalyticsId, externalClientId, orderByComparator);
	}

	/**
	 * Removes all the claim analyticses where externalClientId = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 */
	public static void removeByExternalClientId(long externalClientId) {
		getPersistence().removeByExternalClientId(externalClientId);
	}

	/**
	 * Returns the number of claim analyticses where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the number of matching claim analyticses
	 */
	public static int countByExternalClientId(long externalClientId) {
		return getPersistence().countByExternalClientId(externalClientId);
	}

	/**
	 * Returns all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @return the matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus) {

		return getPersistence().findByE_C(externalClientId, claimStatus);
	}

	/**
	 * Returns a range of all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end) {

		return getPersistence().findByE_C(
			externalClientId, claimStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().findByE_C(
			externalClientId, claimStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim analyticses
	 */
	public static List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByE_C(
			externalClientId, claimStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics findByE_C_First(
			long externalClientId, String claimStatus,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByE_C_First(
			externalClientId, claimStatus, orderByComparator);
	}

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics fetchByE_C_First(
		long externalClientId, String claimStatus,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().fetchByE_C_First(
			externalClientId, claimStatus, orderByComparator);
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics findByE_C_Last(
			long externalClientId, String claimStatus,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByE_C_Last(
			externalClientId, claimStatus, orderByComparator);
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public static ClaimAnalytics fetchByE_C_Last(
		long externalClientId, String claimStatus,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().fetchByE_C_Last(
			externalClientId, claimStatus, orderByComparator);
	}

	/**
	 * Returns the claim analyticses before and after the current claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param claimAnalyticsId the primary key of the current claim analytics
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public static ClaimAnalytics[] findByE_C_PrevAndNext(
			long claimAnalyticsId, long externalClientId, String claimStatus,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByE_C_PrevAndNext(
			claimAnalyticsId, externalClientId, claimStatus, orderByComparator);
	}

	/**
	 * Removes all the claim analyticses where externalClientId = &#63; and claimStatus = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 */
	public static void removeByE_C(long externalClientId, String claimStatus) {
		getPersistence().removeByE_C(externalClientId, claimStatus);
	}

	/**
	 * Returns the number of claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @return the number of matching claim analyticses
	 */
	public static int countByE_C(long externalClientId, String claimStatus) {
		return getPersistence().countByE_C(externalClientId, claimStatus);
	}

	/**
	 * Caches the claim analytics in the entity cache if it is enabled.
	 *
	 * @param claimAnalytics the claim analytics
	 */
	public static void cacheResult(ClaimAnalytics claimAnalytics) {
		getPersistence().cacheResult(claimAnalytics);
	}

	/**
	 * Caches the claim analyticses in the entity cache if it is enabled.
	 *
	 * @param claimAnalyticses the claim analyticses
	 */
	public static void cacheResult(List<ClaimAnalytics> claimAnalyticses) {
		getPersistence().cacheResult(claimAnalyticses);
	}

	/**
	 * Creates a new claim analytics with the primary key. Does not add the claim analytics to the database.
	 *
	 * @param claimAnalyticsId the primary key for the new claim analytics
	 * @return the new claim analytics
	 */
	public static ClaimAnalytics create(long claimAnalyticsId) {
		return getPersistence().create(claimAnalyticsId);
	}

	/**
	 * Removes the claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics that was removed
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public static ClaimAnalytics remove(long claimAnalyticsId)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().remove(claimAnalyticsId);
	}

	public static ClaimAnalytics updateImpl(ClaimAnalytics claimAnalytics) {
		return getPersistence().updateImpl(claimAnalytics);
	}

	/**
	 * Returns the claim analytics with the primary key or throws a <code>NoSuchClaimAnalyticsException</code> if it could not be found.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public static ClaimAnalytics findByPrimaryKey(long claimAnalyticsId)
		throws com.argus.oth.claim.exception.NoSuchClaimAnalyticsException {

		return getPersistence().findByPrimaryKey(claimAnalyticsId);
	}

	/**
	 * Returns the claim analytics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics, or <code>null</code> if a claim analytics with the primary key could not be found
	 */
	public static ClaimAnalytics fetchByPrimaryKey(long claimAnalyticsId) {
		return getPersistence().fetchByPrimaryKey(claimAnalyticsId);
	}

	/**
	 * Returns all the claim analyticses.
	 *
	 * @return the claim analyticses
	 */
	public static List<ClaimAnalytics> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of claim analyticses
	 */
	public static List<ClaimAnalytics> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim analyticses
	 */
	public static List<ClaimAnalytics> findAll(
		int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim analyticses
	 */
	public static List<ClaimAnalytics> findAll(
		int start, int end, OrderByComparator<ClaimAnalytics> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claim analyticses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claim analyticses.
	 *
	 * @return the number of claim analyticses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClaimAnalyticsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimAnalyticsPersistence, ClaimAnalyticsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ClaimAnalyticsPersistence.class);

		ServiceTracker<ClaimAnalyticsPersistence, ClaimAnalyticsPersistence>
			serviceTracker =
				new ServiceTracker
					<ClaimAnalyticsPersistence, ClaimAnalyticsPersistence>(
						bundle.getBundleContext(),
						ClaimAnalyticsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}