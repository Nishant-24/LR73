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

import com.argus.oth.cases.management.model.CasesGroupItem;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cases group item service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.CasesGroupItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesGroupItemPersistence
 * @generated
 */
public class CasesGroupItemUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CasesGroupItem casesGroupItem) {
		getPersistence().clearCache(casesGroupItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CasesGroupItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CasesGroupItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CasesGroupItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CasesGroupItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CasesGroupItem update(CasesGroupItem casesGroupItem) {
		return getPersistence().update(casesGroupItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CasesGroupItem update(
		CasesGroupItem casesGroupItem, ServiceContext serviceContext) {

		return getPersistence().update(casesGroupItem, serviceContext);
	}

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or throws a <code>NoSuchCasesGroupItemException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	public static CasesGroupItem findByE_U_T(
			long externalCaseId, long userId, String type)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().findByE_U_T(externalCaseId, userId, type);
	}

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public static CasesGroupItem fetchByE_U_T(
		long externalCaseId, long userId, String type) {

		return getPersistence().fetchByE_U_T(externalCaseId, userId, type);
	}

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public static CasesGroupItem fetchByE_U_T(
		long externalCaseId, long userId, String type, boolean useFinderCache) {

		return getPersistence().fetchByE_U_T(
			externalCaseId, userId, type, useFinderCache);
	}

	/**
	 * Removes the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the cases group item that was removed
	 */
	public static CasesGroupItem removeByE_U_T(
			long externalCaseId, long userId, String type)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().removeByE_U_T(externalCaseId, userId, type);
	}

	/**
	 * Returns the number of cases group items where externalCaseId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching cases group items
	 */
	public static int countByE_U_T(
		long externalCaseId, long userId, String type) {

		return getPersistence().countByE_U_T(externalCaseId, userId, type);
	}

	/**
	 * Returns all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group items
	 */
	public static List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type) {

		return getPersistence().findByG_U_T(groupId, userId, type);
	}

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
	public static List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end) {

		return getPersistence().findByG_U_T(groupId, userId, type, start, end);
	}

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
	public static List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return getPersistence().findByG_U_T(
			groupId, userId, type, start, end, orderByComparator);
	}

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
	public static List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_T(
			groupId, userId, type, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static CasesGroupItem findByG_U_T_First(
			long groupId, long userId, String type,
			OrderByComparator<CasesGroupItem> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().findByG_U_T_First(
			groupId, userId, type, orderByComparator);
	}

	/**
	 * Returns the first cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public static CasesGroupItem fetchByG_U_T_First(
		long groupId, long userId, String type,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return getPersistence().fetchByG_U_T_First(
			groupId, userId, type, orderByComparator);
	}

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
	public static CasesGroupItem findByG_U_T_Last(
			long groupId, long userId, String type,
			OrderByComparator<CasesGroupItem> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().findByG_U_T_Last(
			groupId, userId, type, orderByComparator);
	}

	/**
	 * Returns the last cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	public static CasesGroupItem fetchByG_U_T_Last(
		long groupId, long userId, String type,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return getPersistence().fetchByG_U_T_Last(
			groupId, userId, type, orderByComparator);
	}

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
	public static CasesGroupItem[] findByG_U_T_PrevAndNext(
			long casesGroupItemId, long groupId, long userId, String type,
			OrderByComparator<CasesGroupItem> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().findByG_U_T_PrevAndNext(
			casesGroupItemId, groupId, userId, type, orderByComparator);
	}

	/**
	 * Removes all the cases group items where groupId = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 */
	public static void removeByG_U_T(long groupId, long userId, String type) {
		getPersistence().removeByG_U_T(groupId, userId, type);
	}

	/**
	 * Returns the number of cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching cases group items
	 */
	public static int countByG_U_T(long groupId, long userId, String type) {
		return getPersistence().countByG_U_T(groupId, userId, type);
	}

	/**
	 * Caches the cases group item in the entity cache if it is enabled.
	 *
	 * @param casesGroupItem the cases group item
	 */
	public static void cacheResult(CasesGroupItem casesGroupItem) {
		getPersistence().cacheResult(casesGroupItem);
	}

	/**
	 * Caches the cases group items in the entity cache if it is enabled.
	 *
	 * @param casesGroupItems the cases group items
	 */
	public static void cacheResult(List<CasesGroupItem> casesGroupItems) {
		getPersistence().cacheResult(casesGroupItems);
	}

	/**
	 * Creates a new cases group item with the primary key. Does not add the cases group item to the database.
	 *
	 * @param casesGroupItemId the primary key for the new cases group item
	 * @return the new cases group item
	 */
	public static CasesGroupItem create(long casesGroupItemId) {
		return getPersistence().create(casesGroupItemId);
	}

	/**
	 * Removes the cases group item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item that was removed
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	public static CasesGroupItem remove(long casesGroupItemId)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().remove(casesGroupItemId);
	}

	public static CasesGroupItem updateImpl(CasesGroupItem casesGroupItem) {
		return getPersistence().updateImpl(casesGroupItem);
	}

	/**
	 * Returns the cases group item with the primary key or throws a <code>NoSuchCasesGroupItemException</code> if it could not be found.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	public static CasesGroupItem findByPrimaryKey(long casesGroupItemId)
		throws com.argus.oth.cases.management.exception.
			NoSuchCasesGroupItemException {

		return getPersistence().findByPrimaryKey(casesGroupItemId);
	}

	/**
	 * Returns the cases group item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item, or <code>null</code> if a cases group item with the primary key could not be found
	 */
	public static CasesGroupItem fetchByPrimaryKey(long casesGroupItemId) {
		return getPersistence().fetchByPrimaryKey(casesGroupItemId);
	}

	/**
	 * Returns all the cases group items.
	 *
	 * @return the cases group items
	 */
	public static List<CasesGroupItem> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CasesGroupItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CasesGroupItem> findAll(
		int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CasesGroupItem> findAll(
		int start, int end, OrderByComparator<CasesGroupItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cases group items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cases group items.
	 *
	 * @return the number of cases group items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CasesGroupItemPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CasesGroupItemPersistence, CasesGroupItemPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CasesGroupItemPersistence.class);

		ServiceTracker<CasesGroupItemPersistence, CasesGroupItemPersistence>
			serviceTracker =
				new ServiceTracker
					<CasesGroupItemPersistence, CasesGroupItemPersistence>(
						bundle.getBundleContext(),
						CasesGroupItemPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}