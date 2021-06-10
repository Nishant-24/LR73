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

import com.argus.oth.cases.management.exception.NoSuchStagingClaimException;
import com.argus.oth.cases.management.model.StagingClaim;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimUtil
 * @generated
 */
@ProviderType
public interface StagingClaimPersistence extends BasePersistence<StagingClaim> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingClaimUtil} to access the staging claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging claim in the entity cache if it is enabled.
	 *
	 * @param stagingClaim the staging claim
	 */
	public void cacheResult(StagingClaim stagingClaim);

	/**
	 * Caches the staging claims in the entity cache if it is enabled.
	 *
	 * @param stagingClaims the staging claims
	 */
	public void cacheResult(java.util.List<StagingClaim> stagingClaims);

	/**
	 * Creates a new staging claim with the primary key. Does not add the staging claim to the database.
	 *
	 * @param stagingClaimId the primary key for the new staging claim
	 * @return the new staging claim
	 */
	public StagingClaim create(long stagingClaimId);

	/**
	 * Removes the staging claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim that was removed
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	public StagingClaim remove(long stagingClaimId)
		throws NoSuchStagingClaimException;

	public StagingClaim updateImpl(StagingClaim stagingClaim);

	/**
	 * Returns the staging claim with the primary key or throws a <code>NoSuchStagingClaimException</code> if it could not be found.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	public StagingClaim findByPrimaryKey(long stagingClaimId)
		throws NoSuchStagingClaimException;

	/**
	 * Returns the staging claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim, or <code>null</code> if a staging claim with the primary key could not be found
	 */
	public StagingClaim fetchByPrimaryKey(long stagingClaimId);

	/**
	 * Returns all the staging claims.
	 *
	 * @return the staging claims
	 */
	public java.util.List<StagingClaim> findAll();

	/**
	 * Returns a range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @return the range of staging claims
	 */
	public java.util.List<StagingClaim> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claims
	 */
	public java.util.List<StagingClaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClaim>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claims
	 */
	public java.util.List<StagingClaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClaim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging claims from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging claims.
	 *
	 * @return the number of staging claims
	 */
	public int countAll();

}