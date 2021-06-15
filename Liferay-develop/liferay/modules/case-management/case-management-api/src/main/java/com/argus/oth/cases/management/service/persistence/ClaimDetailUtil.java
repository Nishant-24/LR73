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

import com.argus.oth.cases.management.model.ClaimDetail;

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
 * The persistence utility for the claim detail service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.ClaimDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimDetailPersistence
 * @generated
 */
public class ClaimDetailUtil {

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
	public static void clearCache(ClaimDetail claimDetail) {
		getPersistence().clearCache(claimDetail);
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
	public static Map<Serializable, ClaimDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClaimDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClaimDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClaimDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClaimDetail update(ClaimDetail claimDetail) {
		return getPersistence().update(claimDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClaimDetail update(
		ClaimDetail claimDetail, ServiceContext serviceContext) {

		return getPersistence().update(claimDetail, serviceContext);
	}

	/**
	 * Returns the claim detail where lineId = &#63; or throws a <code>NoSuchClaimDetailException</code> if it could not be found.
	 *
	 * @param lineId the line ID
	 * @return the matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public static ClaimDetail findByLineId(long lineId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByLineId(lineId);
	}

	/**
	 * Returns the claim detail where lineId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lineId the line ID
	 * @return the matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public static ClaimDetail fetchByLineId(long lineId) {
		return getPersistence().fetchByLineId(lineId);
	}

	/**
	 * Returns the claim detail where lineId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lineId the line ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public static ClaimDetail fetchByLineId(
		long lineId, boolean useFinderCache) {

		return getPersistence().fetchByLineId(lineId, useFinderCache);
	}

	/**
	 * Removes the claim detail where lineId = &#63; from the database.
	 *
	 * @param lineId the line ID
	 * @return the claim detail that was removed
	 */
	public static ClaimDetail removeByLineId(long lineId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().removeByLineId(lineId);
	}

	/**
	 * Returns the number of claim details where lineId = &#63;.
	 *
	 * @param lineId the line ID
	 * @return the number of matching claim details
	 */
	public static int countByLineId(long lineId) {
		return getPersistence().countByLineId(lineId);
	}

	/**
	 * Returns all the claim details where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @return the matching claim details
	 */
	public static List<ClaimDetail> findByExternalClaimId(
		long externalClaimId) {

		return getPersistence().findByExternalClaimId(externalClaimId);
	}

	/**
	 * Returns a range of all the claim details where externalClaimId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param externalClaimId the external claim ID
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of matching claim details
	 */
	public static List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end) {

		return getPersistence().findByExternalClaimId(
			externalClaimId, start, end);
	}

	/**
	 * Returns an ordered range of all the claim details where externalClaimId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param externalClaimId the external claim ID
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim details
	 */
	public static List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().findByExternalClaimId(
			externalClaimId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim details where externalClaimId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param externalClaimId the external claim ID
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim details
	 */
	public static List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByExternalClaimId(
			externalClaimId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public static ClaimDetail findByExternalClaimId_First(
			long externalClaimId,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByExternalClaimId_First(
			externalClaimId, orderByComparator);
	}

	/**
	 * Returns the first claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public static ClaimDetail fetchByExternalClaimId_First(
		long externalClaimId,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().fetchByExternalClaimId_First(
			externalClaimId, orderByComparator);
	}

	/**
	 * Returns the last claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public static ClaimDetail findByExternalClaimId_Last(
			long externalClaimId,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByExternalClaimId_Last(
			externalClaimId, orderByComparator);
	}

	/**
	 * Returns the last claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public static ClaimDetail fetchByExternalClaimId_Last(
		long externalClaimId,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().fetchByExternalClaimId_Last(
			externalClaimId, orderByComparator);
	}

	/**
	 * Returns the claim details before and after the current claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param claimDetailId the primary key of the current claim detail
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public static ClaimDetail[] findByExternalClaimId_PrevAndNext(
			long claimDetailId, long externalClaimId,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByExternalClaimId_PrevAndNext(
			claimDetailId, externalClaimId, orderByComparator);
	}

	/**
	 * Removes all the claim details where externalClaimId = &#63; from the database.
	 *
	 * @param externalClaimId the external claim ID
	 */
	public static void removeByExternalClaimId(long externalClaimId) {
		getPersistence().removeByExternalClaimId(externalClaimId);
	}

	/**
	 * Returns the number of claim details where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @return the number of matching claim details
	 */
	public static int countByExternalClaimId(long externalClaimId) {
		return getPersistence().countByExternalClaimId(externalClaimId);
	}

	/**
	 * Returns all the claim details where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching claim details
	 */
	public static List<ClaimDetail> findByRowProcessed(String rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the claim details where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of matching claim details
	 */
	public static List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the claim details where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim details
	 */
	public static List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim details where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim details
	 */
	public static List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public static ClaimDetail findByRowProcessed_First(
			String rowProcessed,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public static ClaimDetail fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public static ClaimDetail findByRowProcessed_Last(
			String rowProcessed,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public static ClaimDetail fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the claim details before and after the current claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param claimDetailId the primary key of the current claim detail
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public static ClaimDetail[] findByRowProcessed_PrevAndNext(
			long claimDetailId, String rowProcessed,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			claimDetailId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the claim details where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(String rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of claim details where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching claim details
	 */
	public static int countByRowProcessed(String rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the claim detail in the entity cache if it is enabled.
	 *
	 * @param claimDetail the claim detail
	 */
	public static void cacheResult(ClaimDetail claimDetail) {
		getPersistence().cacheResult(claimDetail);
	}

	/**
	 * Caches the claim details in the entity cache if it is enabled.
	 *
	 * @param claimDetails the claim details
	 */
	public static void cacheResult(List<ClaimDetail> claimDetails) {
		getPersistence().cacheResult(claimDetails);
	}

	/**
	 * Creates a new claim detail with the primary key. Does not add the claim detail to the database.
	 *
	 * @param claimDetailId the primary key for the new claim detail
	 * @return the new claim detail
	 */
	public static ClaimDetail create(long claimDetailId) {
		return getPersistence().create(claimDetailId);
	}

	/**
	 * Removes the claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail that was removed
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public static ClaimDetail remove(long claimDetailId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().remove(claimDetailId);
	}

	public static ClaimDetail updateImpl(ClaimDetail claimDetail) {
		return getPersistence().updateImpl(claimDetail);
	}

	/**
	 * Returns the claim detail with the primary key or throws a <code>NoSuchClaimDetailException</code> if it could not be found.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public static ClaimDetail findByPrimaryKey(long claimDetailId)
		throws com.argus.oth.cases.management.exception.
			NoSuchClaimDetailException {

		return getPersistence().findByPrimaryKey(claimDetailId);
	}

	/**
	 * Returns the claim detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail, or <code>null</code> if a claim detail with the primary key could not be found
	 */
	public static ClaimDetail fetchByPrimaryKey(long claimDetailId) {
		return getPersistence().fetchByPrimaryKey(claimDetailId);
	}

	/**
	 * Returns all the claim details.
	 *
	 * @return the claim details
	 */
	public static List<ClaimDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of claim details
	 */
	public static List<ClaimDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim details
	 */
	public static List<ClaimDetail> findAll(
		int start, int end, OrderByComparator<ClaimDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim details
	 */
	public static List<ClaimDetail> findAll(
		int start, int end, OrderByComparator<ClaimDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claim details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claim details.
	 *
	 * @return the number of claim details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClaimDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimDetailPersistence, ClaimDetailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimDetailPersistence.class);

		ServiceTracker<ClaimDetailPersistence, ClaimDetailPersistence>
			serviceTracker =
				new ServiceTracker
					<ClaimDetailPersistence, ClaimDetailPersistence>(
						bundle.getBundleContext(), ClaimDetailPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}