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

import com.argus.oth.claim.exception.NoSuchClaimAnalyticsException;
import com.argus.oth.claim.model.ClaimAnalytics;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim analytics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalyticsUtil
 * @generated
 */
@ProviderType
public interface ClaimAnalyticsPersistence
	extends BasePersistence<ClaimAnalytics> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimAnalyticsUtil} to access the claim analytics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the claim analyticses where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching claim analyticses
	 */
	public java.util.List<ClaimAnalytics> findByExternalClientId(
		long externalClientId);

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
	public java.util.List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end);

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
	public java.util.List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

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
	public java.util.List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public ClaimAnalytics findByExternalClientId_First(
			long externalClientId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
				orderByComparator)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public ClaimAnalytics fetchByExternalClientId_First(
		long externalClientId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public ClaimAnalytics findByExternalClientId_Last(
			long externalClientId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
				orderByComparator)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public ClaimAnalytics fetchByExternalClientId_Last(
		long externalClientId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

	/**
	 * Returns the claim analyticses before and after the current claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param claimAnalyticsId the primary key of the current claim analytics
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public ClaimAnalytics[] findByExternalClientId_PrevAndNext(
			long claimAnalyticsId, long externalClientId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
				orderByComparator)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Removes all the claim analyticses where externalClientId = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 */
	public void removeByExternalClientId(long externalClientId);

	/**
	 * Returns the number of claim analyticses where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the number of matching claim analyticses
	 */
	public int countByExternalClientId(long externalClientId);

	/**
	 * Returns all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @return the matching claim analyticses
	 */
	public java.util.List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus);

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
	public java.util.List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end);

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
	public java.util.List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

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
	public java.util.List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public ClaimAnalytics findByE_C_First(
			long externalClientId, String claimStatus,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
				orderByComparator)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public ClaimAnalytics fetchByE_C_First(
		long externalClientId, String claimStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	public ClaimAnalytics findByE_C_Last(
			long externalClientId, String claimStatus,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
				orderByComparator)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	public ClaimAnalytics fetchByE_C_Last(
		long externalClientId, String claimStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

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
	public ClaimAnalytics[] findByE_C_PrevAndNext(
			long claimAnalyticsId, long externalClientId, String claimStatus,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
				orderByComparator)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Removes all the claim analyticses where externalClientId = &#63; and claimStatus = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 */
	public void removeByE_C(long externalClientId, String claimStatus);

	/**
	 * Returns the number of claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @return the number of matching claim analyticses
	 */
	public int countByE_C(long externalClientId, String claimStatus);

	/**
	 * Caches the claim analytics in the entity cache if it is enabled.
	 *
	 * @param claimAnalytics the claim analytics
	 */
	public void cacheResult(ClaimAnalytics claimAnalytics);

	/**
	 * Caches the claim analyticses in the entity cache if it is enabled.
	 *
	 * @param claimAnalyticses the claim analyticses
	 */
	public void cacheResult(java.util.List<ClaimAnalytics> claimAnalyticses);

	/**
	 * Creates a new claim analytics with the primary key. Does not add the claim analytics to the database.
	 *
	 * @param claimAnalyticsId the primary key for the new claim analytics
	 * @return the new claim analytics
	 */
	public ClaimAnalytics create(long claimAnalyticsId);

	/**
	 * Removes the claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics that was removed
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public ClaimAnalytics remove(long claimAnalyticsId)
		throws NoSuchClaimAnalyticsException;

	public ClaimAnalytics updateImpl(ClaimAnalytics claimAnalytics);

	/**
	 * Returns the claim analytics with the primary key or throws a <code>NoSuchClaimAnalyticsException</code> if it could not be found.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	public ClaimAnalytics findByPrimaryKey(long claimAnalyticsId)
		throws NoSuchClaimAnalyticsException;

	/**
	 * Returns the claim analytics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics, or <code>null</code> if a claim analytics with the primary key could not be found
	 */
	public ClaimAnalytics fetchByPrimaryKey(long claimAnalyticsId);

	/**
	 * Returns all the claim analyticses.
	 *
	 * @return the claim analyticses
	 */
	public java.util.List<ClaimAnalytics> findAll();

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
	public java.util.List<ClaimAnalytics> findAll(int start, int end);

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
	public java.util.List<ClaimAnalytics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator);

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
	public java.util.List<ClaimAnalytics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAnalytics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim analyticses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim analyticses.
	 *
	 * @return the number of claim analyticses
	 */
	public int countAll();

}