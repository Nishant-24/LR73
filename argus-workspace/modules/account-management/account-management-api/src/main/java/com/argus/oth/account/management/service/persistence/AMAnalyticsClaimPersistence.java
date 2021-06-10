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

import com.argus.oth.account.management.exception.NoSuchAMAnalyticsClaimException;
import com.argus.oth.account.management.model.AMAnalyticsClaim;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the am analytics claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsClaimUtil
 * @generated
 */
@ProviderType
public interface AMAnalyticsClaimPersistence
	extends BasePersistence<AMAnalyticsClaim> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMAnalyticsClaimUtil} to access the am analytics claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the am analytics claim in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 */
	public void cacheResult(AMAnalyticsClaim amAnalyticsClaim);

	/**
	 * Caches the am analytics claims in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsClaims the am analytics claims
	 */
	public void cacheResult(java.util.List<AMAnalyticsClaim> amAnalyticsClaims);

	/**
	 * Creates a new am analytics claim with the primary key. Does not add the am analytics claim to the database.
	 *
	 * @param amAnalyticsClaimId the primary key for the new am analytics claim
	 * @return the new am analytics claim
	 */
	public AMAnalyticsClaim create(long amAnalyticsClaimId);

	/**
	 * Removes the am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim that was removed
	 * @throws NoSuchAMAnalyticsClaimException if a am analytics claim with the primary key could not be found
	 */
	public AMAnalyticsClaim remove(long amAnalyticsClaimId)
		throws NoSuchAMAnalyticsClaimException;

	public AMAnalyticsClaim updateImpl(AMAnalyticsClaim amAnalyticsClaim);

	/**
	 * Returns the am analytics claim with the primary key or throws a <code>NoSuchAMAnalyticsClaimException</code> if it could not be found.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim
	 * @throws NoSuchAMAnalyticsClaimException if a am analytics claim with the primary key could not be found
	 */
	public AMAnalyticsClaim findByPrimaryKey(long amAnalyticsClaimId)
		throws NoSuchAMAnalyticsClaimException;

	/**
	 * Returns the am analytics claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim, or <code>null</code> if a am analytics claim with the primary key could not be found
	 */
	public AMAnalyticsClaim fetchByPrimaryKey(long amAnalyticsClaimId);

	/**
	 * Returns all the am analytics claims.
	 *
	 * @return the am analytics claims
	 */
	public java.util.List<AMAnalyticsClaim> findAll();

	/**
	 * Returns a range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @return the range of am analytics claims
	 */
	public java.util.List<AMAnalyticsClaim> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics claims
	 */
	public java.util.List<AMAnalyticsClaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMAnalyticsClaim>
			orderByComparator);

	/**
	 * Returns an ordered range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics claims
	 */
	public java.util.List<AMAnalyticsClaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMAnalyticsClaim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the am analytics claims from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of am analytics claims.
	 *
	 * @return the number of am analytics claims
	 */
	public int countAll();

}