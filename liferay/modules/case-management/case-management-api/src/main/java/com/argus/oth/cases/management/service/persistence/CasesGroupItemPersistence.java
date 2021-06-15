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

import com.argus.oth.cases.management.exception.NoSuchCasesGroupItemException;
import com.argus.oth.cases.management.model.CasesGroupItem;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cases group item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesGroupItemUtil
 * @generated
 */
@ProviderType
public interface CasesGroupItemPersistence
	extends BasePersistence<CasesGroupItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CasesGroupItemUtil} to access the cases group item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or throws a <code>NoSuchCasesGroupItemException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	public CasesGroupItem findByE_U_T(
			long externalCaseId, long userId, String type)
		throws NoSuchCasesGroupItemException;

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public CasesGroupItem fetchByE_U_T(
		long externalCaseId, long userId, String type);

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public CasesGroupItem fetchByE_U_T(
		long externalCaseId, long userId, String type, boolean useFinderCache);

	/**
	 * Removes the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the cases group item that was removed
	 */
	public CasesGroupItem removeByE_U_T(
			long externalCaseId, long userId, String type)
		throws NoSuchCasesGroupItemException;

	/**
	 * Returns the number of cases group items where externalCaseId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching cases group items
	 */
	public int countByE_U_T(long externalCaseId, long userId, String type);

	/**
	 * Returns all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group items
	 */
	public java.util.List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type);

	/**
	 * Returns a range of all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @return the range of matching cases group items
	 */
	public java.util.List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cases group items
	 */
	public java.util.List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cases group items
	 */
	public java.util.List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	public CasesGroupItem findByG_U_T_First(
			long groupId, long userId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
				orderByComparator)
		throws NoSuchCasesGroupItemException;

	/**
	 * Returns the first cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public CasesGroupItem fetchByG_U_T_First(
		long groupId, long userId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
			orderByComparator);

	/**
	 * Returns the last cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	public CasesGroupItem findByG_U_T_Last(
			long groupId, long userId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
				orderByComparator)
		throws NoSuchCasesGroupItemException;

	/**
	 * Returns the last cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public CasesGroupItem fetchByG_U_T_Last(
		long groupId, long userId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
			orderByComparator);

	/**
	 * Returns the cases group items before and after the current cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param casesGroupItemId the primary key of the current cases group item
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases group item
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	public CasesGroupItem[] findByG_U_T_PrevAndNext(
			long casesGroupItemId, long groupId, long userId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
				orderByComparator)
		throws NoSuchCasesGroupItemException;

	/**
	 * Removes all the cases group items where groupId = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 */
	public void removeByG_U_T(long groupId, long userId, String type);

	/**
	 * Returns the number of cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching cases group items
	 */
	public int countByG_U_T(long groupId, long userId, String type);

	/**
	 * Caches the cases group item in the entity cache if it is enabled.
	 *
	 * @param casesGroupItem the cases group item
	 */
	public void cacheResult(CasesGroupItem casesGroupItem);

	/**
	 * Caches the cases group items in the entity cache if it is enabled.
	 *
	 * @param casesGroupItems the cases group items
	 */
	public void cacheResult(java.util.List<CasesGroupItem> casesGroupItems);

	/**
	 * Creates a new cases group item with the primary key. Does not add the cases group item to the database.
	 *
	 * @param casesGroupItemId the primary key for the new cases group item
	 * @return the new cases group item
	 */
	public CasesGroupItem create(long casesGroupItemId);

	/**
	 * Removes the cases group item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item that was removed
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	public CasesGroupItem remove(long casesGroupItemId)
		throws NoSuchCasesGroupItemException;

	public CasesGroupItem updateImpl(CasesGroupItem casesGroupItem);

	/**
	 * Returns the cases group item with the primary key or throws a <code>NoSuchCasesGroupItemException</code> if it could not be found.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	public CasesGroupItem findByPrimaryKey(long casesGroupItemId)
		throws NoSuchCasesGroupItemException;

	/**
	 * Returns the cases group item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item, or <code>null</code> if a cases group item with the primary key could not be found
	 */
	public CasesGroupItem fetchByPrimaryKey(long casesGroupItemId);

	/**
	 * Returns all the cases group items.
	 *
	 * @return the cases group items
	 */
	public java.util.List<CasesGroupItem> findAll();

	/**
	 * Returns a range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @return the range of cases group items
	 */
	public java.util.List<CasesGroupItem> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cases group items
	 */
	public java.util.List<CasesGroupItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cases group items
	 */
	public java.util.List<CasesGroupItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasesGroupItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cases group items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cases group items.
	 *
	 * @return the number of cases group items
	 */
	public int countAll();

}