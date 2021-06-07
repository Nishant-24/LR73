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

import com.argus.oth.claim.exception.NoSuchStagingClaimAnalyticsException;
import com.argus.oth.claim.model.StagingClaimAnalytics;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging claim analytics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimAnalyticsUtil
 * @generated
 */
@ProviderType
public interface StagingClaimAnalyticsPersistence
	extends BasePersistence<StagingClaimAnalytics> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingClaimAnalyticsUtil} to access the staging claim analytics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging claim analytics in the entity cache if it is enabled.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 */
	public void cacheResult(StagingClaimAnalytics stagingClaimAnalytics);

	/**
	 * Caches the staging claim analyticses in the entity cache if it is enabled.
	 *
	 * @param stagingClaimAnalyticses the staging claim analyticses
	 */
	public void cacheResult(
		java.util.List<StagingClaimAnalytics> stagingClaimAnalyticses);

	/**
	 * Creates a new staging claim analytics with the primary key. Does not add the staging claim analytics to the database.
	 *
	 * @param stagingClaimAnalyticsId the primary key for the new staging claim analytics
	 * @return the new staging claim analytics
	 */
	public StagingClaimAnalytics create(long stagingClaimAnalyticsId);

	/**
	 * Removes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	public StagingClaimAnalytics remove(long stagingClaimAnalyticsId)
		throws NoSuchStagingClaimAnalyticsException;

	public StagingClaimAnalytics updateImpl(
		StagingClaimAnalytics stagingClaimAnalytics);

	/**
	 * Returns the staging claim analytics with the primary key or throws a <code>NoSuchStagingClaimAnalyticsException</code> if it could not be found.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	public StagingClaimAnalytics findByPrimaryKey(long stagingClaimAnalyticsId)
		throws NoSuchStagingClaimAnalyticsException;

	/**
	 * Returns the staging claim analytics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics, or <code>null</code> if a staging claim analytics with the primary key could not be found
	 */
	public StagingClaimAnalytics fetchByPrimaryKey(
		long stagingClaimAnalyticsId);

	/**
	 * Returns all the staging claim analyticses.
	 *
	 * @return the staging claim analyticses
	 */
	public java.util.List<StagingClaimAnalytics> findAll();

	/**
	 * Returns a range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @return the range of staging claim analyticses
	 */
	public java.util.List<StagingClaimAnalytics> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claim analyticses
	 */
	public java.util.List<StagingClaimAnalytics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClaimAnalytics>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claim analyticses
	 */
	public java.util.List<StagingClaimAnalytics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClaimAnalytics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging claim analyticses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging claim analyticses.
	 *
	 * @return the number of staging claim analyticses
	 */
	public int countAll();

}