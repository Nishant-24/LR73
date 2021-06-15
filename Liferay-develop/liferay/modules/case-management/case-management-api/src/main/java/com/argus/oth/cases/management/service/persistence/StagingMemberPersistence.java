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

import com.argus.oth.cases.management.exception.NoSuchStagingMemberException;
import com.argus.oth.cases.management.model.StagingMember;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingMemberUtil
 * @generated
 */
@ProviderType
public interface StagingMemberPersistence
	extends BasePersistence<StagingMember> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingMemberUtil} to access the staging member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the staging member where externalMemberId = &#63; or throws a <code>NoSuchStagingMemberException</code> if it could not be found.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching staging member
	 * @throws NoSuchStagingMemberException if a matching staging member could not be found
	 */
	public StagingMember findByExternalMemberId(long externalMemberId)
		throws NoSuchStagingMemberException;

	/**
	 * Returns the staging member where externalMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching staging member, or <code>null</code> if a matching staging member could not be found
	 */
	public StagingMember fetchByExternalMemberId(long externalMemberId);

	/**
	 * Returns the staging member where externalMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging member, or <code>null</code> if a matching staging member could not be found
	 */
	public StagingMember fetchByExternalMemberId(
		long externalMemberId, boolean useFinderCache);

	/**
	 * Removes the staging member where externalMemberId = &#63; from the database.
	 *
	 * @param externalMemberId the external member ID
	 * @return the staging member that was removed
	 */
	public StagingMember removeByExternalMemberId(long externalMemberId)
		throws NoSuchStagingMemberException;

	/**
	 * Returns the number of staging members where externalMemberId = &#63;.
	 *
	 * @param externalMemberId the external member ID
	 * @return the number of matching staging members
	 */
	public int countByExternalMemberId(long externalMemberId);

	/**
	 * Caches the staging member in the entity cache if it is enabled.
	 *
	 * @param stagingMember the staging member
	 */
	public void cacheResult(StagingMember stagingMember);

	/**
	 * Caches the staging members in the entity cache if it is enabled.
	 *
	 * @param stagingMembers the staging members
	 */
	public void cacheResult(java.util.List<StagingMember> stagingMembers);

	/**
	 * Creates a new staging member with the primary key. Does not add the staging member to the database.
	 *
	 * @param stagingMemberId the primary key for the new staging member
	 * @return the new staging member
	 */
	public StagingMember create(long stagingMemberId);

	/**
	 * Removes the staging member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member that was removed
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	public StagingMember remove(long stagingMemberId)
		throws NoSuchStagingMemberException;

	public StagingMember updateImpl(StagingMember stagingMember);

	/**
	 * Returns the staging member with the primary key or throws a <code>NoSuchStagingMemberException</code> if it could not be found.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	public StagingMember findByPrimaryKey(long stagingMemberId)
		throws NoSuchStagingMemberException;

	/**
	 * Returns the staging member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member, or <code>null</code> if a staging member with the primary key could not be found
	 */
	public StagingMember fetchByPrimaryKey(long stagingMemberId);

	/**
	 * Returns all the staging members.
	 *
	 * @return the staging members
	 */
	public java.util.List<StagingMember> findAll();

	/**
	 * Returns a range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @return the range of staging members
	 */
	public java.util.List<StagingMember> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging members
	 */
	public java.util.List<StagingMember> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingMember>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging members
	 */
	public java.util.List<StagingMember> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingMember>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging members from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging members.
	 *
	 * @return the number of staging members
	 */
	public int countAll();

}