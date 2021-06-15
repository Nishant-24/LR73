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

import com.argus.oth.account.management.exception.NoSuchAMAnalyticsDBException;
import com.argus.oth.account.management.model.AMAnalyticsDB;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the am analytics db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsDBUtil
 * @generated
 */
@ProviderType
public interface AMAnalyticsDBPersistence
	extends BasePersistence<AMAnalyticsDB> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMAnalyticsDBUtil} to access the am analytics db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the am analytics db where clientId = &#63; or throws a <code>NoSuchAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param clientId the client ID
	 * @return the matching am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a matching am analytics db could not be found
	 */
	public AMAnalyticsDB findByClientId(long clientId)
		throws NoSuchAMAnalyticsDBException;

	/**
	 * Returns the am analytics db where clientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientId the client ID
	 * @return the matching am analytics db, or <code>null</code> if a matching am analytics db could not be found
	 */
	public AMAnalyticsDB fetchByClientId(long clientId);

	/**
	 * Returns the am analytics db where clientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientId the client ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching am analytics db, or <code>null</code> if a matching am analytics db could not be found
	 */
	public AMAnalyticsDB fetchByClientId(long clientId, boolean useFinderCache);

	/**
	 * Removes the am analytics db where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @return the am analytics db that was removed
	 */
	public AMAnalyticsDB removeByClientId(long clientId)
		throws NoSuchAMAnalyticsDBException;

	/**
	 * Returns the number of am analytics dbs where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching am analytics dbs
	 */
	public int countByClientId(long clientId);

	/**
	 * Caches the am analytics db in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsDB the am analytics db
	 */
	public void cacheResult(AMAnalyticsDB amAnalyticsDB);

	/**
	 * Caches the am analytics dbs in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsDBs the am analytics dbs
	 */
	public void cacheResult(java.util.List<AMAnalyticsDB> amAnalyticsDBs);

	/**
	 * Creates a new am analytics db with the primary key. Does not add the am analytics db to the database.
	 *
	 * @param amAnalyticsDbId the primary key for the new am analytics db
	 * @return the new am analytics db
	 */
	public AMAnalyticsDB create(long amAnalyticsDbId);

	/**
	 * Removes the am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db that was removed
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	public AMAnalyticsDB remove(long amAnalyticsDbId)
		throws NoSuchAMAnalyticsDBException;

	public AMAnalyticsDB updateImpl(AMAnalyticsDB amAnalyticsDB);

	/**
	 * Returns the am analytics db with the primary key or throws a <code>NoSuchAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	public AMAnalyticsDB findByPrimaryKey(long amAnalyticsDbId)
		throws NoSuchAMAnalyticsDBException;

	/**
	 * Returns the am analytics db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db, or <code>null</code> if a am analytics db with the primary key could not be found
	 */
	public AMAnalyticsDB fetchByPrimaryKey(long amAnalyticsDbId);

	/**
	 * Returns all the am analytics dbs.
	 *
	 * @return the am analytics dbs
	 */
	public java.util.List<AMAnalyticsDB> findAll();

	/**
	 * Returns a range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @return the range of am analytics dbs
	 */
	public java.util.List<AMAnalyticsDB> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics dbs
	 */
	public java.util.List<AMAnalyticsDB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMAnalyticsDB>
			orderByComparator);

	/**
	 * Returns an ordered range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics dbs
	 */
	public java.util.List<AMAnalyticsDB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMAnalyticsDB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the am analytics dbs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of am analytics dbs.
	 *
	 * @return the number of am analytics dbs
	 */
	public int countAll();

}