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

import com.argus.oth.cases.management.exception.NoSuchAuthorizationException;
import com.argus.oth.cases.management.model.Authorization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the authorization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationUtil
 * @generated
 */
@ProviderType
public interface AuthorizationPersistence
	extends BasePersistence<Authorization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorizationUtil} to access the authorization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the authorizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching authorizations
	 */
	public java.util.List<Authorization> findByUuid(String uuid);

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
	public java.util.List<Authorization> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Authorization> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public java.util.List<Authorization> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where uuid = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public Authorization[] findByUuid_PrevAndNext(
			long authorizationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Removes all the authorizations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of authorizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching authorizations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the authorization where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the authorization that was removed
	 */
	public Authorization removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the number of authorizations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching authorizations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching authorizations
	 */
	public java.util.List<Authorization> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public java.util.List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public Authorization[] findByUuid_C_PrevAndNext(
			long authorizationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Removes all the authorizations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching authorizations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the authorizations where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the matching authorizations
	 */
	public java.util.List<Authorization> findByAuthNumber(String authNumber);

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
	public java.util.List<Authorization> findByAuthNumber(
		String authNumber, int start, int end);

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
	public java.util.List<Authorization> findByAuthNumber(
		String authNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public java.util.List<Authorization> findByAuthNumber(
		String authNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByAuthNumber_First(
			String authNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the first authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByAuthNumber_First(
		String authNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the last authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByAuthNumber_Last(
			String authNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the last authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByAuthNumber_Last(
		String authNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public Authorization[] findByAuthNumber_PrevAndNext(
			long authorizationId, String authNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Removes all the authorizations where authNumber = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 */
	public void removeByAuthNumber(String authNumber);

	/**
	 * Returns the number of authorizations where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the number of matching authorizations
	 */
	public int countByAuthNumber(String authNumber);

	/**
	 * Returns all the authorizations where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @return the matching authorizations
	 */
	public java.util.List<Authorization> findByCaseId(long caseId);

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
	public java.util.List<Authorization> findByCaseId(
		long caseId, int start, int end);

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
	public java.util.List<Authorization> findByCaseId(
		long caseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public java.util.List<Authorization> findByCaseId(
		long caseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByCaseId_First(
			long caseId,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the first authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByCaseId_First(
		long caseId,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the last authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByCaseId_Last(
			long caseId,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the last authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByCaseId_Last(
		long caseId,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where caseId = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public Authorization[] findByCaseId_PrevAndNext(
			long authorizationId, long caseId,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Removes all the authorizations where caseId = &#63; from the database.
	 *
	 * @param caseId the case ID
	 */
	public void removeByCaseId(long caseId);

	/**
	 * Returns the number of authorizations where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @return the number of matching authorizations
	 */
	public int countByCaseId(long caseId);

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByExternalAuthorizationId(
			long externalAuthorizationId)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByExternalAuthorizationId(
		long externalAuthorizationId);

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByExternalAuthorizationId(
		long externalAuthorizationId, boolean useFinderCache);

	/**
	 * Removes the authorization where externalAuthorizationId = &#63; from the database.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the authorization that was removed
	 */
	public Authorization removeByExternalAuthorizationId(
			long externalAuthorizationId)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the number of authorizations where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the number of matching authorizations
	 */
	public int countByExternalAuthorizationId(long externalAuthorizationId);

	/**
	 * Returns all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the matching authorizations
	 */
	public java.util.List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus);

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
	public java.util.List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end);

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
	public java.util.List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public java.util.List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByRowProcessed_ProcessStatus_First(
			String rowProcessed, String processStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the first authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByRowProcessed_ProcessStatus_First(
		String rowProcessed, String processStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

	/**
	 * Returns the last authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	public Authorization findByRowProcessed_ProcessStatus_Last(
			String rowProcessed, String processStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the last authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public Authorization fetchByRowProcessed_ProcessStatus_Last(
		String rowProcessed, String processStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public Authorization[] findByRowProcessed_ProcessStatus_PrevAndNext(
			long authorizationId, String rowProcessed, String processStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Authorization>
				orderByComparator)
		throws NoSuchAuthorizationException;

	/**
	 * Removes all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 */
	public void removeByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus);

	/**
	 * Returns the number of authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the number of matching authorizations
	 */
	public int countByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus);

	/**
	 * Caches the authorization in the entity cache if it is enabled.
	 *
	 * @param authorization the authorization
	 */
	public void cacheResult(Authorization authorization);

	/**
	 * Caches the authorizations in the entity cache if it is enabled.
	 *
	 * @param authorizations the authorizations
	 */
	public void cacheResult(java.util.List<Authorization> authorizations);

	/**
	 * Creates a new authorization with the primary key. Does not add the authorization to the database.
	 *
	 * @param authorizationId the primary key for the new authorization
	 * @return the new authorization
	 */
	public Authorization create(long authorizationId);

	/**
	 * Removes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public Authorization remove(long authorizationId)
		throws NoSuchAuthorizationException;

	public Authorization updateImpl(Authorization authorization);

	/**
	 * Returns the authorization with the primary key or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	public Authorization findByPrimaryKey(long authorizationId)
		throws NoSuchAuthorizationException;

	/**
	 * Returns the authorization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization, or <code>null</code> if a authorization with the primary key could not be found
	 */
	public Authorization fetchByPrimaryKey(long authorizationId);

	/**
	 * Returns all the authorizations.
	 *
	 * @return the authorizations
	 */
	public java.util.List<Authorization> findAll();

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
	public java.util.List<Authorization> findAll(int start, int end);

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
	public java.util.List<Authorization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator);

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
	public java.util.List<Authorization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Authorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the authorizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	public int countAll();

}