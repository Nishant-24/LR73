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

import com.argus.oth.cases.management.exception.NoSuchClientGroupException;
import com.argus.oth.cases.management.model.ClientGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the client group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientGroupUtil
 * @generated
 */
@ProviderType
public interface ClientGroupPersistence extends BasePersistence<ClientGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientGroupUtil} to access the client group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the client group where externalClientGroupId = &#63; or throws a <code>NoSuchClientGroupException</code> if it could not be found.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	public ClientGroup findByExternalClientGroupId(long externalClientGroupId)
		throws NoSuchClientGroupException;

	/**
	 * Returns the client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public ClientGroup fetchByExternalClientGroupId(long externalClientGroupId);

	/**
	 * Returns the client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public ClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId, boolean useFinderCache);

	/**
	 * Removes the client group where externalClientGroupId = &#63; from the database.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the client group that was removed
	 */
	public ClientGroup removeByExternalClientGroupId(long externalClientGroupId)
		throws NoSuchClientGroupException;

	/**
	 * Returns the number of client groups where externalClientGroupId = &#63;.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the number of matching client groups
	 */
	public int countByExternalClientGroupId(long externalClientGroupId);

	/**
	 * Returns all the client groups where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching client groups
	 */
	public java.util.List<ClientGroup> findByRowProcessed(String rowProcessed);

	/**
	 * Returns a range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of matching client groups
	 */
	public java.util.List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end);

	/**
	 * Returns an ordered range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client groups
	 */
	public java.util.List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client groups
	 */
	public java.util.List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	public ClientGroup findByRowProcessed_First(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
				orderByComparator)
		throws NoSuchClientGroupException;

	/**
	 * Returns the first client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public ClientGroup fetchByRowProcessed_First(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
			orderByComparator);

	/**
	 * Returns the last client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	public ClientGroup findByRowProcessed_Last(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
				orderByComparator)
		throws NoSuchClientGroupException;

	/**
	 * Returns the last client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client group, or <code>null</code> if a matching client group could not be found
	 */
	public ClientGroup fetchByRowProcessed_Last(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
			orderByComparator);

	/**
	 * Returns the client groups before and after the current client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param clientGroupId the primary key of the current client group
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	public ClientGroup[] findByRowProcessed_PrevAndNext(
			long clientGroupId, String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
				orderByComparator)
		throws NoSuchClientGroupException;

	/**
	 * Removes all the client groups where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(String rowProcessed);

	/**
	 * Returns the number of client groups where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching client groups
	 */
	public int countByRowProcessed(String rowProcessed);

	/**
	 * Caches the client group in the entity cache if it is enabled.
	 *
	 * @param clientGroup the client group
	 */
	public void cacheResult(ClientGroup clientGroup);

	/**
	 * Caches the client groups in the entity cache if it is enabled.
	 *
	 * @param clientGroups the client groups
	 */
	public void cacheResult(java.util.List<ClientGroup> clientGroups);

	/**
	 * Creates a new client group with the primary key. Does not add the client group to the database.
	 *
	 * @param clientGroupId the primary key for the new client group
	 * @return the new client group
	 */
	public ClientGroup create(long clientGroupId);

	/**
	 * Removes the client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group that was removed
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	public ClientGroup remove(long clientGroupId)
		throws NoSuchClientGroupException;

	public ClientGroup updateImpl(ClientGroup clientGroup);

	/**
	 * Returns the client group with the primary key or throws a <code>NoSuchClientGroupException</code> if it could not be found.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	public ClientGroup findByPrimaryKey(long clientGroupId)
		throws NoSuchClientGroupException;

	/**
	 * Returns the client group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group, or <code>null</code> if a client group with the primary key could not be found
	 */
	public ClientGroup fetchByPrimaryKey(long clientGroupId);

	/**
	 * Returns all the client groups.
	 *
	 * @return the client groups
	 */
	public java.util.List<ClientGroup> findAll();

	/**
	 * Returns a range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of client groups
	 */
	public java.util.List<ClientGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of client groups
	 */
	public java.util.List<ClientGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of client groups
	 */
	public java.util.List<ClientGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the client groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of client groups.
	 *
	 * @return the number of client groups
	 */
	public int countAll();

}