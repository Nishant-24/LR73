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

import com.argus.oth.cases.management.exception.NoSuchStagingClaimDetailException;
import com.argus.oth.cases.management.model.StagingClaimDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging claim detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetailUtil
 * @generated
 */
@ProviderType
public interface StagingClaimDetailPersistence
	extends BasePersistence<StagingClaimDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingClaimDetailUtil} to access the staging claim detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging claim detail in the entity cache if it is enabled.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 */
	public void cacheResult(StagingClaimDetail stagingClaimDetail);

	/**
	 * Caches the staging claim details in the entity cache if it is enabled.
	 *
	 * @param stagingClaimDetails the staging claim details
	 */
	public void cacheResult(
		java.util.List<StagingClaimDetail> stagingClaimDetails);

	/**
	 * Creates a new staging claim detail with the primary key. Does not add the staging claim detail to the database.
	 *
	 * @param stagingClaimDetailId the primary key for the new staging claim detail
	 * @return the new staging claim detail
	 */
	public StagingClaimDetail create(long stagingClaimDetailId);

	/**
	 * Removes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	public StagingClaimDetail remove(long stagingClaimDetailId)
		throws NoSuchStagingClaimDetailException;

	public StagingClaimDetail updateImpl(StagingClaimDetail stagingClaimDetail);

	/**
	 * Returns the staging claim detail with the primary key or throws a <code>NoSuchStagingClaimDetailException</code> if it could not be found.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	public StagingClaimDetail findByPrimaryKey(long stagingClaimDetailId)
		throws NoSuchStagingClaimDetailException;

	/**
	 * Returns the staging claim detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail, or <code>null</code> if a staging claim detail with the primary key could not be found
	 */
	public StagingClaimDetail fetchByPrimaryKey(long stagingClaimDetailId);

	/**
	 * Returns all the staging claim details.
	 *
	 * @return the staging claim details
	 */
	public java.util.List<StagingClaimDetail> findAll();

	/**
	 * Returns a range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @return the range of staging claim details
	 */
	public java.util.List<StagingClaimDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claim details
	 */
	public java.util.List<StagingClaimDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClaimDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claim details
	 */
	public java.util.List<StagingClaimDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClaimDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging claim details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging claim details.
	 *
	 * @return the number of staging claim details
	 */
	public int countAll();

}