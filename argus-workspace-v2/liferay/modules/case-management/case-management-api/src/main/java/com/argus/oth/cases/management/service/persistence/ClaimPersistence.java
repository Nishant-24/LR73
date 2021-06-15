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

import com.argus.oth.cases.management.exception.NoSuchClaimException;
import com.argus.oth.cases.management.model.Claim;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimUtil
 * @generated
 */
@ProviderType
public interface ClaimPersistence extends BasePersistence<Claim> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimUtil} to access the claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the claim where claimRef = &#63; or throws a <code>NoSuchClaimException</code> if it could not be found.
	 *
	 * @param claimRef the claim ref
	 * @return the matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public Claim findByClaimRef(String claimRef) throws NoSuchClaimException;

	/**
	 * Returns the claim where claimRef = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimRef the claim ref
	 * @return the matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public Claim fetchByClaimRef(String claimRef);

	/**
	 * Returns the claim where claimRef = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimRef the claim ref
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public Claim fetchByClaimRef(String claimRef, boolean useFinderCache);

	/**
	 * Removes the claim where claimRef = &#63; from the database.
	 *
	 * @param claimRef the claim ref
	 * @return the claim that was removed
	 */
	public Claim removeByClaimRef(String claimRef) throws NoSuchClaimException;

	/**
	 * Returns the number of claims where claimRef = &#63;.
	 *
	 * @param claimRef the claim ref
	 * @return the number of matching claims
	 */
	public int countByClaimRef(String claimRef);

	/**
	 * Returns all the claims where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @return the matching claims
	 */
	public java.util.List<Claim> findByAuthorizationNumber(
		String authorizationNumber);

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
	public java.util.List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end);

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
	public java.util.List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

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
	public java.util.List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public Claim findByAuthorizationNumber_First(
			String authorizationNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Claim>
				orderByComparator)
		throws NoSuchClaimException;

	/**
	 * Returns the first claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public Claim fetchByAuthorizationNumber_First(
		String authorizationNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

	/**
	 * Returns the last claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public Claim findByAuthorizationNumber_Last(
			String authorizationNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Claim>
				orderByComparator)
		throws NoSuchClaimException;

	/**
	 * Returns the last claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public Claim fetchByAuthorizationNumber_Last(
		String authorizationNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

	/**
	 * Returns the claims before and after the current claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param claimId the primary key of the current claim
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public Claim[] findByAuthorizationNumber_PrevAndNext(
			long claimId, String authorizationNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Claim>
				orderByComparator)
		throws NoSuchClaimException;

	/**
	 * Removes all the claims where authorizationNumber = &#63; from the database.
	 *
	 * @param authorizationNumber the authorization number
	 */
	public void removeByAuthorizationNumber(String authorizationNumber);

	/**
	 * Returns the number of claims where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @return the number of matching claims
	 */
	public int countByAuthorizationNumber(String authorizationNumber);

	/**
	 * Returns all the claims where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching claims
	 */
	public java.util.List<Claim> findByRowProcessed(String rowProcessed);

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
	public java.util.List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end);

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
	public java.util.List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

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
	public java.util.List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public Claim findByRowProcessed_First(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Claim>
				orderByComparator)
		throws NoSuchClaimException;

	/**
	 * Returns the first claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public Claim fetchByRowProcessed_First(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

	/**
	 * Returns the last claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	public Claim findByRowProcessed_Last(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Claim>
				orderByComparator)
		throws NoSuchClaimException;

	/**
	 * Returns the last claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim, or <code>null</code> if a matching claim could not be found
	 */
	public Claim fetchByRowProcessed_Last(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

	/**
	 * Returns the claims before and after the current claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param claimId the primary key of the current claim
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public Claim[] findByRowProcessed_PrevAndNext(
			long claimId, String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Claim>
				orderByComparator)
		throws NoSuchClaimException;

	/**
	 * Removes all the claims where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(String rowProcessed);

	/**
	 * Returns the number of claims where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching claims
	 */
	public int countByRowProcessed(String rowProcessed);

	/**
	 * Caches the claim in the entity cache if it is enabled.
	 *
	 * @param claim the claim
	 */
	public void cacheResult(Claim claim);

	/**
	 * Caches the claims in the entity cache if it is enabled.
	 *
	 * @param claims the claims
	 */
	public void cacheResult(java.util.List<Claim> claims);

	/**
	 * Creates a new claim with the primary key. Does not add the claim to the database.
	 *
	 * @param claimId the primary key for the new claim
	 * @return the new claim
	 */
	public Claim create(long claimId);

	/**
	 * Removes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim that was removed
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public Claim remove(long claimId) throws NoSuchClaimException;

	public Claim updateImpl(Claim claim);

	/**
	 * Returns the claim with the primary key or throws a <code>NoSuchClaimException</code> if it could not be found.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	public Claim findByPrimaryKey(long claimId) throws NoSuchClaimException;

	/**
	 * Returns the claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim, or <code>null</code> if a claim with the primary key could not be found
	 */
	public Claim fetchByPrimaryKey(long claimId);

	/**
	 * Returns all the claims.
	 *
	 * @return the claims
	 */
	public java.util.List<Claim> findAll();

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
	public java.util.List<Claim> findAll(int start, int end);

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
	public java.util.List<Claim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator);

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
	public java.util.List<Claim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Claim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claims from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claims.
	 *
	 * @return the number of claims
	 */
	public int countAll();

}