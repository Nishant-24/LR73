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

import com.argus.oth.account.management.exception.NoSuchStagingAMATelephonyException;
import com.argus.oth.account.management.model.StagingAMATelephony;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging ama telephony service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMATelephonyUtil
 * @generated
 */
@ProviderType
public interface StagingAMATelephonyPersistence
	extends BasePersistence<StagingAMATelephony> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingAMATelephonyUtil} to access the staging ama telephony persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging ama telephony in the entity cache if it is enabled.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 */
	public void cacheResult(StagingAMATelephony stagingAMATelephony);

	/**
	 * Caches the staging ama telephonies in the entity cache if it is enabled.
	 *
	 * @param stagingAMATelephonies the staging ama telephonies
	 */
	public void cacheResult(
		java.util.List<StagingAMATelephony> stagingAMATelephonies);

	/**
	 * Creates a new staging ama telephony with the primary key. Does not add the staging ama telephony to the database.
	 *
	 * @param stagingAMATelephonyId the primary key for the new staging ama telephony
	 * @return the new staging ama telephony
	 */
	public StagingAMATelephony create(long stagingAMATelephonyId);

	/**
	 * Removes the staging ama telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony that was removed
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	public StagingAMATelephony remove(long stagingAMATelephonyId)
		throws NoSuchStagingAMATelephonyException;

	public StagingAMATelephony updateImpl(
		StagingAMATelephony stagingAMATelephony);

	/**
	 * Returns the staging ama telephony with the primary key or throws a <code>NoSuchStagingAMATelephonyException</code> if it could not be found.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	public StagingAMATelephony findByPrimaryKey(long stagingAMATelephonyId)
		throws NoSuchStagingAMATelephonyException;

	/**
	 * Returns the staging ama telephony with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony, or <code>null</code> if a staging ama telephony with the primary key could not be found
	 */
	public StagingAMATelephony fetchByPrimaryKey(long stagingAMATelephonyId);

	/**
	 * Returns all the staging ama telephonies.
	 *
	 * @return the staging ama telephonies
	 */
	public java.util.List<StagingAMATelephony> findAll();

	/**
	 * Returns a range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @return the range of staging ama telephonies
	 */
	public java.util.List<StagingAMATelephony> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging ama telephonies
	 */
	public java.util.List<StagingAMATelephony> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAMATelephony>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging ama telephonies
	 */
	public java.util.List<StagingAMATelephony> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAMATelephony>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging ama telephonies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging ama telephonies.
	 *
	 * @return the number of staging ama telephonies
	 */
	public int countAll();

}