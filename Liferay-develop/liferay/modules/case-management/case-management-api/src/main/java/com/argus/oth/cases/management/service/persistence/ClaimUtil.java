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

import com.argus.oth.cases.management.model.Claim;

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
 * The persistence utility for the claim service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.ClaimPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimPersistence
 * @generated
 */
public class ClaimUtil {

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
	public static void clearCache(Claim claim) {
		getPersistence().clearCache(claim);
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
	public static Map<Serializable, Claim> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Claim> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Claim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Claim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Claim> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Claim update(Claim claim) {
		return getPersistence().update(claim);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Claim update(Claim claim, ServiceContext serviceContext) {
		return getPersistence().update(claim, serviceContext);
	}

	/**
	 * Returns the claim where claimRef = &#63; or throws a <code>NoSuchClaimException</code> if it could not be found.
	 *
	 * @param claimRef the claim ref
	 * @return the matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public static Claim findByClaimRef(String claimRef)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByClaimRef(claimRef);
	}

	/**
	 * Returns the claim where claimRef = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimRef the claim ref
	 * @return the matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public static Claim fetchByClaimRef(String claimRef) {
		return getPersistence().fetchByClaimRef(claimRef);
	}

	/**
	 * Returns the claim where claimRef = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimRef the claim ref
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public static Claim fetchByClaimRef(
		String claimRef, boolean useFinderCache) {

		return getPersistence().fetchByClaimRef(claimRef, useFinderCache);
	}

	/**
	 * Removes the claim where claimRef = &#63; from the database.
	 *
	 * @param claimRef the claim ref
	 * @return the claim that was removed
	 */
	public static Claim removeByClaimRef(String claimRef)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().removeByClaimRef(claimRef);
	}

	/**
	 * Returns the number of claims where claimRef = &#63;.
	 *
	 * @param claimRef the claim ref
	 * @return the number of matching claims
	 */
	public static int countByClaimRef(String claimRef) {
		return getPersistence().countByClaimRef(claimRef);
	}

	/**
	 * Returns all the claims where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @return the matching claims
	 */
	public static List<Claim> findByAuthorizationNumber(
		String authorizationNumber) {

		return getPersistence().findByAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Returns a range of all the claims where authorizationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param authorizationNumber the authorization number
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of matching claims
	 */
	public static List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end) {

		return getPersistence().findByAuthorizationNumber(
			authorizationNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the claims where authorizationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param authorizationNumber the authorization number
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claims
	 */
	public static List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end,
		OrderByComparator<Claim> orderByComparator) {

		return getPersistence().findByAuthorizationNumber(
			authorizationNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claims where authorizationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param authorizationNumber the authorization number
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claims
	 */
	public static List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end,
		OrderByComparator<Claim> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAuthorizationNumber(
			authorizationNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public static Claim findByAuthorizationNumber_First(
			String authorizationNumber,
			OrderByComparator<Claim> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByAuthorizationNumber_First(
			authorizationNumber, orderByComparator);
	}

	/**
	 * Returns the first claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public static Claim fetchByAuthorizationNumber_First(
		String authorizationNumber,
		OrderByComparator<Claim> orderByComparator) {

		return getPersistence().fetchByAuthorizationNumber_First(
			authorizationNumber, orderByComparator);
	}

	/**
	 * Returns the last claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public static Claim findByAuthorizationNumber_Last(
			String authorizationNumber,
			OrderByComparator<Claim> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByAuthorizationNumber_Last(
			authorizationNumber, orderByComparator);
	}

	/**
	 * Returns the last claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public static Claim fetchByAuthorizationNumber_Last(
		String authorizationNumber,
		OrderByComparator<Claim> orderByComparator) {

		return getPersistence().fetchByAuthorizationNumber_Last(
			authorizationNumber, orderByComparator);
	}

	/**
	 * Returns the claims before and after the current claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param claimId the primary key of the current claim
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public static Claim[] findByAuthorizationNumber_PrevAndNext(
			long claimId, String authorizationNumber,
			OrderByComparator<Claim> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByAuthorizationNumber_PrevAndNext(
			claimId, authorizationNumber, orderByComparator);
	}

	/**
	 * Removes all the claims where authorizationNumber = &#63; from the database.
	 *
	 * @param authorizationNumber the authorization number
	 */
	public static void removeByAuthorizationNumber(String authorizationNumber) {
		getPersistence().removeByAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Returns the number of claims where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @return the number of matching claims
	 */
	public static int countByAuthorizationNumber(String authorizationNumber) {
		return getPersistence().countByAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Returns all the claims where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching claims
	 */
	public static List<Claim> findByRowProcessed(String rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the claims where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of matching claims
	 */
	public static List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the claims where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claims
	 */
	public static List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Claim> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claims where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claims
	 */
	public static List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Claim> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public static Claim findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Claim> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public static Claim fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Claim> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public static Claim findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Claim> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public static Claim fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Claim> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the claims before and after the current claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param claimId the primary key of the current claim
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public static Claim[] findByRowProcessed_PrevAndNext(
			long claimId, String rowProcessed,
			OrderByComparator<Claim> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			claimId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the claims where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(String rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of claims where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching claims
	 */
	public static int countByRowProcessed(String rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the claim in the entity cache if it is enabled.
	 *
	 * @param claim the claim
	 */
	public static void cacheResult(Claim claim) {
		getPersistence().cacheResult(claim);
	}

	/**
	 * Caches the claims in the entity cache if it is enabled.
	 *
	 * @param claims the claims
	 */
	public static void cacheResult(List<Claim> claims) {
		getPersistence().cacheResult(claims);
	}

	/**
	 * Creates a new claim with the primary key. Does not add the claim to the database.
	 *
	 * @param claimId the primary key for the new claim
	 * @return the new claim
	 */
	public static Claim create(long claimId) {
		return getPersistence().create(claimId);
	}

	/**
	 * Removes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim that was removed
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public static Claim remove(long claimId)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().remove(claimId);
	}

	public static Claim updateImpl(Claim claim) {
		return getPersistence().updateImpl(claim);
	}

	/**
	 * Returns the claim with the primary key or throws a <code>NoSuchClaimException</code> if it could not be found.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public static Claim findByPrimaryKey(long claimId)
		throws com.argus.oth.cases.management.exception.NoSuchClaimException {

		return getPersistence().findByPrimaryKey(claimId);
	}

	/**
	 * Returns the claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim, or <code>null</code> if a claim with the primary key could not be found
	 */
	public static Claim fetchByPrimaryKey(long claimId) {
		return getPersistence().fetchByPrimaryKey(claimId);
	}

	/**
	 * Returns all the claims.
	 *
	 * @return the claims
	 */
	public static List<Claim> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of claims
	 */
	public static List<Claim> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claims
	 */
	public static List<Claim> findAll(
		int start, int end, OrderByComparator<Claim> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claims
	 */
	public static List<Claim> findAll(
		int start, int end, OrderByComparator<Claim> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claims from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claims.
	 *
	 * @return the number of claims
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClaimPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClaimPersistence, ClaimPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimPersistence.class);

		ServiceTracker<ClaimPersistence, ClaimPersistence> serviceTracker =
			new ServiceTracker<ClaimPersistence, ClaimPersistence>(
				bundle.getBundleContext(), ClaimPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}