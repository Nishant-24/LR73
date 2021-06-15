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

import com.argus.oth.cases.management.exception.NoSuchClaimDetailException;
import com.argus.oth.cases.management.model.ClaimDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimDetailUtil
 * @generated
 */
@ProviderType
public interface ClaimDetailPersistence extends BasePersistence<ClaimDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimDetailUtil} to access the claim detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the claim detail where lineId = &#63; or throws a <code>NoSuchClaimDetailException</code> if it could not be found.
	 *
	 * @param lineId the line ID
	 * @return the matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public ClaimDetail findByLineId(long lineId)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the claim detail where lineId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lineId the line ID
	 * @return the matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public ClaimDetail fetchByLineId(long lineId);

	/**
	 * Returns the claim detail where lineId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lineId the line ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public ClaimDetail fetchByLineId(long lineId, boolean useFinderCache);

	/**
	 * Removes the claim detail where lineId = &#63; from the database.
	 *
	 * @param lineId the line ID
	 * @return the claim detail that was removed
	 */
	public ClaimDetail removeByLineId(long lineId)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the number of claim details where lineId = &#63;.
	 *
	 * @param lineId the line ID
	 * @return the number of matching claim details
	 */
	public int countByLineId(long lineId);

	/**
	 * Returns all the claim details where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @return the matching claim details
	 */
	public java.util.List<ClaimDetail> findByExternalClaimId(
		long externalClaimId);

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
	public java.util.List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end);

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
	public java.util.List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

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
	public java.util.List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public ClaimDetail findByExternalClaimId_First(
			long externalClaimId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
				orderByComparator)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the first claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public ClaimDetail fetchByExternalClaimId_First(
		long externalClaimId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

	/**
	 * Returns the last claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public ClaimDetail findByExternalClaimId_Last(
			long externalClaimId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
				orderByComparator)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the last claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public ClaimDetail fetchByExternalClaimId_Last(
		long externalClaimId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

	/**
	 * Returns the claim details before and after the current claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param claimDetailId the primary key of the current claim detail
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public ClaimDetail[] findByExternalClaimId_PrevAndNext(
			long claimDetailId, long externalClaimId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
				orderByComparator)
		throws NoSuchClaimDetailException;

	/**
	 * Removes all the claim details where externalClaimId = &#63; from the database.
	 *
	 * @param externalClaimId the external claim ID
	 */
	public void removeByExternalClaimId(long externalClaimId);

	/**
	 * Returns the number of claim details where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @return the number of matching claim details
	 */
	public int countByExternalClaimId(long externalClaimId);

	/**
	 * Returns all the claim details where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching claim details
	 */
	public java.util.List<ClaimDetail> findByRowProcessed(String rowProcessed);

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
	public java.util.List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end);

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
	public java.util.List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

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
	public java.util.List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public ClaimDetail findByRowProcessed_First(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
				orderByComparator)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the first claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public ClaimDetail fetchByRowProcessed_First(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

	/**
	 * Returns the last claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	public ClaimDetail findByRowProcessed_Last(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
				orderByComparator)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the last claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	public ClaimDetail fetchByRowProcessed_Last(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

	/**
	 * Returns the claim details before and after the current claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param claimDetailId the primary key of the current claim detail
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public ClaimDetail[] findByRowProcessed_PrevAndNext(
			long claimDetailId, String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
				orderByComparator)
		throws NoSuchClaimDetailException;

	/**
	 * Removes all the claim details where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(String rowProcessed);

	/**
	 * Returns the number of claim details where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching claim details
	 */
	public int countByRowProcessed(String rowProcessed);

	/**
	 * Caches the claim detail in the entity cache if it is enabled.
	 *
	 * @param claimDetail the claim detail
	 */
	public void cacheResult(ClaimDetail claimDetail);

	/**
	 * Caches the claim details in the entity cache if it is enabled.
	 *
	 * @param claimDetails the claim details
	 */
	public void cacheResult(java.util.List<ClaimDetail> claimDetails);

	/**
	 * Creates a new claim detail with the primary key. Does not add the claim detail to the database.
	 *
	 * @param claimDetailId the primary key for the new claim detail
	 * @return the new claim detail
	 */
	public ClaimDetail create(long claimDetailId);

	/**
	 * Removes the claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail that was removed
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public ClaimDetail remove(long claimDetailId)
		throws NoSuchClaimDetailException;

	public ClaimDetail updateImpl(ClaimDetail claimDetail);

	/**
	 * Returns the claim detail with the primary key or throws a <code>NoSuchClaimDetailException</code> if it could not be found.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	public ClaimDetail findByPrimaryKey(long claimDetailId)
		throws NoSuchClaimDetailException;

	/**
	 * Returns the claim detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail, or <code>null</code> if a claim detail with the primary key could not be found
	 */
	public ClaimDetail fetchByPrimaryKey(long claimDetailId);

	/**
	 * Returns all the claim details.
	 *
	 * @return the claim details
	 */
	public java.util.List<ClaimDetail> findAll();

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
	public java.util.List<ClaimDetail> findAll(int start, int end);

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
	public java.util.List<ClaimDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator);

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
	public java.util.List<ClaimDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim details.
	 *
	 * @return the number of claim details
	 */
	public int countAll();

}