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

import com.argus.oth.cases.management.exception.NoSuchStagingClientGroupException;
import com.argus.oth.cases.management.model.StagingClientGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging client group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientGroupUtil
 * @generated
 */
@ProviderType
public interface StagingClientGroupPersistence
	extends BasePersistence<StagingClientGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingClientGroupUtil} to access the staging client group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or throws a <code>NoSuchStagingClientGroupException</code> if it could not be found.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching staging client group
	 * @throws NoSuchStagingClientGroupException if a matching staging client group could not be found
	 */
	public StagingClientGroup findByExternalClientGroupId(
			long externalClientGroupId)
		throws NoSuchStagingClientGroupException;

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching staging client group, or <code>null</code> if a matching staging client group could not be found
	 */
	public StagingClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId);

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging client group, or <code>null</code> if a matching staging client group could not be found
	 */
	public StagingClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId, boolean useFinderCache);

	/**
	 * Removes the staging client group where externalClientGroupId = &#63; from the database.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the staging client group that was removed
	 */
	public StagingClientGroup removeByExternalClientGroupId(
			long externalClientGroupId)
		throws NoSuchStagingClientGroupException;

	/**
	 * Returns the number of staging client groups where externalClientGroupId = &#63;.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the number of matching staging client groups
	 */
	public int countByExternalClientGroupId(long externalClientGroupId);

	/**
	 * Caches the staging client group in the entity cache if it is enabled.
	 *
	 * @param stagingClientGroup the staging client group
	 */
	public void cacheResult(StagingClientGroup stagingClientGroup);

	/**
	 * Caches the staging client groups in the entity cache if it is enabled.
	 *
	 * @param stagingClientGroups the staging client groups
	 */
	public void cacheResult(
		java.util.List<StagingClientGroup> stagingClientGroups);

	/**
	 * Creates a new staging client group with the primary key. Does not add the staging client group to the database.
	 *
	 * @param stagingClientGroupId the primary key for the new staging client group
	 * @return the new staging client group
	 */
	public StagingClientGroup create(long stagingClientGroupId);

	/**
	 * Removes the staging client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group that was removed
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	public StagingClientGroup remove(long stagingClientGroupId)
		throws NoSuchStagingClientGroupException;

	public StagingClientGroup updateImpl(StagingClientGroup stagingClientGroup);

	/**
	 * Returns the staging client group with the primary key or throws a <code>NoSuchStagingClientGroupException</code> if it could not be found.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	public StagingClientGroup findByPrimaryKey(long stagingClientGroupId)
		throws NoSuchStagingClientGroupException;

	/**
	 * Returns the staging client group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group, or <code>null</code> if a staging client group with the primary key could not be found
	 */
	public StagingClientGroup fetchByPrimaryKey(long stagingClientGroupId);

	/**
	 * Returns all the staging client groups.
	 *
	 * @return the staging client groups
	 */
	public java.util.List<StagingClientGroup> findAll();

	/**
	 * Returns a range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @return the range of staging client groups
	 */
	public java.util.List<StagingClientGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging client groups
	 */
	public java.util.List<StagingClientGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClientGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging client groups
	 */
	public java.util.List<StagingClientGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClientGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging client groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging client groups.
	 *
	 * @return the number of staging client groups
	 */
	public int countAll();

}