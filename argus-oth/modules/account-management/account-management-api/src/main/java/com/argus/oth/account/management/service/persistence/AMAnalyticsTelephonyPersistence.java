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

import com.argus.oth.account.management.exception.NoSuchAMAnalyticsTelephonyException;
import com.argus.oth.account.management.model.AMAnalyticsTelephony;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the am analytics telephony service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsTelephonyUtil
 * @generated
 */
@ProviderType
public interface AMAnalyticsTelephonyPersistence
	extends BasePersistence<AMAnalyticsTelephony> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMAnalyticsTelephonyUtil} to access the am analytics telephony persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the am analytics telephony in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsTelephony the am analytics telephony
	 */
	public void cacheResult(AMAnalyticsTelephony amAnalyticsTelephony);

	/**
	 * Caches the am analytics telephonies in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsTelephonies the am analytics telephonies
	 */
	public void cacheResult(
		java.util.List<AMAnalyticsTelephony> amAnalyticsTelephonies);

	/**
	 * Creates a new am analytics telephony with the primary key. Does not add the am analytics telephony to the database.
	 *
	 * @param amAnalyticsTelephonyId the primary key for the new am analytics telephony
	 * @return the new am analytics telephony
	 */
	public AMAnalyticsTelephony create(long amAnalyticsTelephonyId);

	/**
	 * Removes the am analytics telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony that was removed
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	public AMAnalyticsTelephony remove(long amAnalyticsTelephonyId)
		throws NoSuchAMAnalyticsTelephonyException;

	public AMAnalyticsTelephony updateImpl(
		AMAnalyticsTelephony amAnalyticsTelephony);

	/**
	 * Returns the am analytics telephony with the primary key or throws a <code>NoSuchAMAnalyticsTelephonyException</code> if it could not be found.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	public AMAnalyticsTelephony findByPrimaryKey(long amAnalyticsTelephonyId)
		throws NoSuchAMAnalyticsTelephonyException;

	/**
	 * Returns the am analytics telephony with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony, or <code>null</code> if a am analytics telephony with the primary key could not be found
	 */
	public AMAnalyticsTelephony fetchByPrimaryKey(long amAnalyticsTelephonyId);

	/**
	 * Returns all the am analytics telephonies.
	 *
	 * @return the am analytics telephonies
	 */
	public java.util.List<AMAnalyticsTelephony> findAll();

	/**
	 * Returns a range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @return the range of am analytics telephonies
	 */
	public java.util.List<AMAnalyticsTelephony> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics telephonies
	 */
	public java.util.List<AMAnalyticsTelephony> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMAnalyticsTelephony>
			orderByComparator);

	/**
	 * Returns an ordered range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics telephonies
	 */
	public java.util.List<AMAnalyticsTelephony> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMAnalyticsTelephony>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the am analytics telephonies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of am analytics telephonies.
	 *
	 * @return the number of am analytics telephonies
	 */
	public int countAll();

}