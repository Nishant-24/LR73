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

import com.argus.oth.account.management.exception.NoSuchStagingAMAnalyticsClaimException;
import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging am analytics claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsClaimUtil
 * @generated
 */
@ProviderType
public interface StagingAMAnalyticsClaimPersistence
	extends BasePersistence<StagingAMAnalyticsClaim> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingAMAnalyticsClaimUtil} to access the staging am analytics claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging am analytics claim in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 */
	public void cacheResult(StagingAMAnalyticsClaim stagingAMAnalyticsClaim);

	/**
	 * Caches the staging am analytics claims in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsClaims the staging am analytics claims
	 */
	public void cacheResult(
		java.util.List<StagingAMAnalyticsClaim> stagingAMAnalyticsClaims);

	/**
	 * Creates a new staging am analytics claim with the primary key. Does not add the staging am analytics claim to the database.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key for the new staging am analytics claim
	 * @return the new staging am analytics claim
	 */
	public StagingAMAnalyticsClaim create(long stagingAMAnalyticsClaimId);

	/**
	 * Removes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	public StagingAMAnalyticsClaim remove(long stagingAMAnalyticsClaimId)
		throws NoSuchStagingAMAnalyticsClaimException;

	public StagingAMAnalyticsClaim updateImpl(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim);

	/**
	 * Returns the staging am analytics claim with the primary key or throws a <code>NoSuchStagingAMAnalyticsClaimException</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	public StagingAMAnalyticsClaim findByPrimaryKey(
			long stagingAMAnalyticsClaimId)
		throws NoSuchStagingAMAnalyticsClaimException;

	/**
	 * Returns the staging am analytics claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim, or <code>null</code> if a staging am analytics claim with the primary key could not be found
	 */
	public StagingAMAnalyticsClaim fetchByPrimaryKey(
		long stagingAMAnalyticsClaimId);

	/**
	 * Returns all the staging am analytics claims.
	 *
	 * @return the staging am analytics claims
	 */
	public java.util.List<StagingAMAnalyticsClaim> findAll();

	/**
	 * Returns a range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @return the range of staging am analytics claims
	 */
	public java.util.List<StagingAMAnalyticsClaim> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging am analytics claims
	 */
	public java.util.List<StagingAMAnalyticsClaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<StagingAMAnalyticsClaim> orderByComparator);

	/**
	 * Returns an ordered range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging am analytics claims
	 */
	public java.util.List<StagingAMAnalyticsClaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<StagingAMAnalyticsClaim> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging am analytics claims from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging am analytics claims.
	 *
	 * @return the number of staging am analytics claims
	 */
	public int countAll();

}