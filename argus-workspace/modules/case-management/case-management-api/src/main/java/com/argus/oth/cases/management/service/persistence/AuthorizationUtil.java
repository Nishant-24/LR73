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

import com.argus.oth.cases.management.model.Authorization;

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
 * The persistence utility for the authorization service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.AuthorizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationPersistence
 * @generated
 */
public class AuthorizationUtil {

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
	public static void clearCache(Authorization authorization) {
		getPersistence().clearCache(authorization);
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
	public static Map<Serializable, Authorization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Authorization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Authorization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Authorization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Authorization update(Authorization authorization) {
		return getPersistence().update(authorization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Authorization update(
		Authorization authorization, ServiceContext serviceContext) {

		return getPersistence().update(authorization, serviceContext);
	}

	/**
	 * Returns all the authorizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching authorizations
	 */
	public static List<Authorization> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the authorizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	public static List<Authorization> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByUuid_First(
			String uuid, OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByUuid_First(
		String uuid, OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByUuid_Last(
			String uuid, OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByUuid_Last(
		String uuid, OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where uuid = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization[] findByUuid_PrevAndNext(
			long authorizationId, String uuid,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUuid_PrevAndNext(
			authorizationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the authorizations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of authorizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching authorizations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByUUID_G(String uuid, long groupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the authorization where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the authorization that was removed
	 */
	public static Authorization removeByUUID_G(String uuid, long groupId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of authorizations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching authorizations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching authorizations
	 */
	public static List<Authorization> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	public static List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization[] findByUuid_C_PrevAndNext(
			long authorizationId, String uuid, long companyId,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			authorizationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the authorizations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching authorizations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the authorizations where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the matching authorizations
	 */
	public static List<Authorization> findByAuthNumber(String authNumber) {
		return getPersistence().findByAuthNumber(authNumber);
	}

	/**
	 * Returns a range of all the authorizations where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	public static List<Authorization> findByAuthNumber(
		String authNumber, int start, int end) {

		return getPersistence().findByAuthNumber(authNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the authorizations where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findByAuthNumber(
			authNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the authorizations where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAuthNumber(
			authNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByAuthNumber_First(
			String authNumber,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByAuthNumber_First(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the first authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByAuthNumber_First(
		String authNumber, OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByAuthNumber_First(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByAuthNumber_Last(
			String authNumber,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByAuthNumber_Last(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByAuthNumber_Last(
		String authNumber, OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByAuthNumber_Last(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization[] findByAuthNumber_PrevAndNext(
			long authorizationId, String authNumber,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByAuthNumber_PrevAndNext(
			authorizationId, authNumber, orderByComparator);
	}

	/**
	 * Removes all the authorizations where authNumber = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 */
	public static void removeByAuthNumber(String authNumber) {
		getPersistence().removeByAuthNumber(authNumber);
	}

	/**
	 * Returns the number of authorizations where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the number of matching authorizations
	 */
	public static int countByAuthNumber(String authNumber) {
		return getPersistence().countByAuthNumber(authNumber);
	}

	/**
	 * Returns all the authorizations where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @return the matching authorizations
	 */
	public static List<Authorization> findByCaseId(long caseId) {
		return getPersistence().findByCaseId(caseId);
	}

	/**
	 * Returns a range of all the authorizations where caseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	public static List<Authorization> findByCaseId(
		long caseId, int start, int end) {

		return getPersistence().findByCaseId(caseId, start, end);
	}

	/**
	 * Returns an ordered range of all the authorizations where caseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByCaseId(
		long caseId, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findByCaseId(
			caseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the authorizations where caseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByCaseId(
		long caseId, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCaseId(
			caseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByCaseId_First(
			long caseId, OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByCaseId_First(caseId, orderByComparator);
	}

	/**
	 * Returns the first authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByCaseId_First(
		long caseId, OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByCaseId_First(caseId, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByCaseId_Last(
			long caseId, OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByCaseId_Last(caseId, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByCaseId_Last(
		long caseId, OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByCaseId_Last(caseId, orderByComparator);
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where caseId = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization[] findByCaseId_PrevAndNext(
			long authorizationId, long caseId,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByCaseId_PrevAndNext(
			authorizationId, caseId, orderByComparator);
	}

	/**
	 * Removes all the authorizations where caseId = &#63; from the database.
	 *
	 * @param caseId the case ID
	 */
	public static void removeByCaseId(long caseId) {
		getPersistence().removeByCaseId(caseId);
	}

	/**
	 * Returns the number of authorizations where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @return the number of matching authorizations
	 */
	public static int countByCaseId(long caseId) {
		return getPersistence().countByCaseId(caseId);
	}

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByExternalAuthorizationId(
			long externalAuthorizationId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByExternalAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByExternalAuthorizationId(
		long externalAuthorizationId) {

		return getPersistence().fetchByExternalAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByExternalAuthorizationId(
		long externalAuthorizationId, boolean useFinderCache) {

		return getPersistence().fetchByExternalAuthorizationId(
			externalAuthorizationId, useFinderCache);
	}

	/**
	 * Removes the authorization where externalAuthorizationId = &#63; from the database.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the authorization that was removed
	 */
	public static Authorization removeByExternalAuthorizationId(
			long externalAuthorizationId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().removeByExternalAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns the number of authorizations where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the number of matching authorizations
	 */
	public static int countByExternalAuthorizationId(
		long externalAuthorizationId) {

		return getPersistence().countByExternalAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the matching authorizations
	 */
	public static List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);
	}

	/**
	 * Returns a range of all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	public static List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	public static List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByRowProcessed_ProcessStatus_First(
			String rowProcessed, String processStatus,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByRowProcessed_ProcessStatus_First(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the first authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByRowProcessed_ProcessStatus_First(
		String rowProcessed, String processStatus,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByRowProcessed_ProcessStatus_First(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public static Authorization findByRowProcessed_ProcessStatus_Last(
			String rowProcessed, String processStatus,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByRowProcessed_ProcessStatus_Last(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the last authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static Authorization fetchByRowProcessed_ProcessStatus_Last(
		String rowProcessed, String processStatus,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().fetchByRowProcessed_ProcessStatus_Last(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization[] findByRowProcessed_ProcessStatus_PrevAndNext(
			long authorizationId, String rowProcessed, String processStatus,
			OrderByComparator<Authorization> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByRowProcessed_ProcessStatus_PrevAndNext(
			authorizationId, rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Removes all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 */
	public static void removeByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		getPersistence().removeByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);
	}

	/**
	 * Returns the number of authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the number of matching authorizations
	 */
	public static int countByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		return getPersistence().countByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);
	}

	/**
	 * Caches the authorization in the entity cache if it is enabled.
	 *
	 * @param authorization the authorization
	 */
	public static void cacheResult(Authorization authorization) {
		getPersistence().cacheResult(authorization);
	}

	/**
	 * Caches the authorizations in the entity cache if it is enabled.
	 *
	 * @param authorizations the authorizations
	 */
	public static void cacheResult(List<Authorization> authorizations) {
		getPersistence().cacheResult(authorizations);
	}

	/**
	 * Creates a new authorization with the primary key. Does not add the authorization to the database.
	 *
	 * @param authorizationId the primary key for the new authorization
	 * @return the new authorization
	 */
	public static Authorization create(long authorizationId) {
		return getPersistence().create(authorizationId);
	}

	/**
	 * Removes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization remove(long authorizationId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().remove(authorizationId);
	}

	public static Authorization updateImpl(Authorization authorization) {
		return getPersistence().updateImpl(authorization);
	}

	/**
	 * Returns the authorization with the primary key or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public static Authorization findByPrimaryKey(long authorizationId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthorizationException {

		return getPersistence().findByPrimaryKey(authorizationId);
	}

	/**
	 * Returns the authorization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization, or <code>null</code> if a authorization with the primary key could not be found
	 */
	public static Authorization fetchByPrimaryKey(long authorizationId) {
		return getPersistence().fetchByPrimaryKey(authorizationId);
	}

	/**
	 * Returns all the authorizations.
	 *
	 * @return the authorizations
	 */
	public static List<Authorization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of authorizations
	 */
	public static List<Authorization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of authorizations
	 */
	public static List<Authorization> findAll(
		int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of authorizations
	 */
	public static List<Authorization> findAll(
		int start, int end, OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the authorizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuthorizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuthorizationPersistence, AuthorizationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthorizationPersistence.class);

		ServiceTracker<AuthorizationPersistence, AuthorizationPersistence>
			serviceTracker =
				new ServiceTracker
					<AuthorizationPersistence, AuthorizationPersistence>(
						bundle.getBundleContext(),
						AuthorizationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}