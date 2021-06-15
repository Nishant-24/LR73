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

import com.argus.oth.account.management.exception.NoSuchStagingAMAnalyticsDBException;
import com.argus.oth.account.management.model.StagingAMAnalyticsDB;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging am analytics db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsDBUtil
 * @generated
 */
@ProviderType
public interface StagingAMAnalyticsDBPersistence
	extends BasePersistence<StagingAMAnalyticsDB> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingAMAnalyticsDBUtil} to access the staging am analytics db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging am analytics db in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 */
	public void cacheResult(StagingAMAnalyticsDB stagingAMAnalyticsDB);

	/**
	 * Caches the staging am analytics dbs in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsDBs the staging am analytics dbs
	 */
	public void cacheResult(
		java.util.List<StagingAMAnalyticsDB> stagingAMAnalyticsDBs);

	/**
	 * Creates a new staging am analytics db with the primary key. Does not add the staging am analytics db to the database.
	 *
	 * @param stagingAMAnalyticsDbId the primary key for the new staging am analytics db
	 * @return the new staging am analytics db
	 */
	public StagingAMAnalyticsDB create(long stagingAMAnalyticsDbId);

	/**
	 * Removes the staging am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db that was removed
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	public StagingAMAnalyticsDB remove(long stagingAMAnalyticsDbId)
		throws NoSuchStagingAMAnalyticsDBException;

	public StagingAMAnalyticsDB updateImpl(
		StagingAMAnalyticsDB stagingAMAnalyticsDB);

	/**
	 * Returns the staging am analytics db with the primary key or throws a <code>NoSuchStagingAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	public StagingAMAnalyticsDB findByPrimaryKey(long stagingAMAnalyticsDbId)
		throws NoSuchStagingAMAnalyticsDBException;

	/**
	 * Returns the staging am analytics db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db, or <code>null</code> if a staging am analytics db with the primary key could not be found
	 */
	public StagingAMAnalyticsDB fetchByPrimaryKey(long stagingAMAnalyticsDbId);

	/**
	 * Returns all the staging am analytics dbs.
	 *
	 * @return the staging am analytics dbs
	 */
	public java.util.List<StagingAMAnalyticsDB> findAll();

	/**
	 * Returns a range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @return the range of staging am analytics dbs
	 */
	public java.util.List<StagingAMAnalyticsDB> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging am analytics dbs
	 */
	public java.util.List<StagingAMAnalyticsDB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAMAnalyticsDB>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging am analytics dbs
	 */
	public java.util.List<StagingAMAnalyticsDB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAMAnalyticsDB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging am analytics dbs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging am analytics dbs.
	 *
	 * @return the number of staging am analytics dbs
	 */
	public int countAll();

}