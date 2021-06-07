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

import com.argus.oth.cases.management.exception.NoSuchCasesException;
import com.argus.oth.cases.management.model.Cases;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cases service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesUtil
 * @generated
 */
@ProviderType
public interface CasesPersistence extends BasePersistence<Cases> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CasesUtil} to access the cases persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the caseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching caseses
	 */
	public java.util.List<Cases> findByUuid(String uuid);

	/**
	 * Returns a range of all the caseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	public java.util.List<Cases> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the first cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the last cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the last cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the caseses before and after the current cases in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Removes all the caseses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of caseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching caseses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByUUID_G(String uuid, long groupId)
		throws NoSuchCasesException;

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the cases where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cases that was removed
	 */
	public Cases removeByUUID_G(String uuid, long groupId)
		throws NoSuchCasesException;

	/**
	 * Returns the number of caseses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching caseses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching caseses
	 */
	public java.util.List<Cases> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	public java.util.List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the first cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the last cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the last cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the caseses before and after the current cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Removes all the caseses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching caseses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the cases where externalCaseId = &#63; or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByExternalCaseId(long externalCaseId)
		throws NoSuchCasesException;

	/**
	 * Returns the cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByExternalCaseId(long externalCaseId);

	/**
	 * Returns the cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByExternalCaseId(
		long externalCaseId, boolean useFinderCache);

	/**
	 * Removes the cases where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @return the cases that was removed
	 */
	public Cases removeByExternalCaseId(long externalCaseId)
		throws NoSuchCasesException;

	/**
	 * Returns the number of caseses where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching caseses
	 */
	public int countByExternalCaseId(long externalCaseId);

	/**
	 * Returns all the caseses where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching caseses
	 */
	public java.util.List<Cases> findByClientId(long clientId);

	/**
	 * Returns a range of all the caseses where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	public java.util.List<Cases> findByClientId(
		long clientId, int start, int end);

	/**
	 * Returns an ordered range of all the caseses where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByClientId(
		long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caseses where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByClientId(
		long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByClientId_First(
			long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the first cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByClientId_First(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the last cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByClientId_Last(
			long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the last cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByClientId_Last(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the caseses before and after the current cases in the ordered set where clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases[] findByClientId_PrevAndNext(
			long caseId, long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Removes all the caseses where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	public void removeByClientId(long clientId);

	/**
	 * Returns the number of caseses where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching caseses
	 */
	public int countByClientId(long clientId);

	/**
	 * Returns all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the matching caseses
	 */
	public java.util.List<Cases> findByG_C(long groupId, long clientId);

	/**
	 * Returns a range of all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	public java.util.List<Cases> findByG_C(
		long groupId, long clientId, int start, int end);

	/**
	 * Returns an ordered range of all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByG_C(
		long groupId, long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByG_C(
		long groupId, long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByG_C_First(
			long groupId, long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the first cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByG_C_First(
		long groupId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the last cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByG_C_Last(
			long groupId, long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the last cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByG_C_Last(
		long groupId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the caseses before and after the current cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases[] findByG_C_PrevAndNext(
			long caseId, long groupId, long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns all the caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the matching caseses that the user has permission to view
	 */
	public java.util.List<Cases> filterFindByG_C(long groupId, long clientId);

	/**
	 * Returns a range of all the caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses that the user has permission to view
	 */
	public java.util.List<Cases> filterFindByG_C(
		long groupId, long clientId, int start, int end);

	/**
	 * Returns an ordered range of all the caseses that the user has permissions to view where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses that the user has permission to view
	 */
	public java.util.List<Cases> filterFindByG_C(
		long groupId, long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the caseses before and after the current cases in the ordered set of caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases[] filterFindByG_C_PrevAndNext(
			long caseId, long groupId, long clientId,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Removes all the caseses where groupId = &#63; and clientId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 */
	public void removeByG_C(long groupId, long clientId);

	/**
	 * Returns the number of caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the number of matching caseses
	 */
	public int countByG_C(long groupId, long clientId);

	/**
	 * Returns the number of caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the number of matching caseses that the user has permission to view
	 */
	public int filterCountByG_C(long groupId, long clientId);

	/**
	 * Returns all the caseses where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching caseses
	 */
	public java.util.List<Cases> findByRowProcessed(String rowProcessed);

	/**
	 * Returns a range of all the caseses where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	public java.util.List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end);

	/**
	 * Returns an ordered range of all the caseses where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caseses where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	public java.util.List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByRowProcessed_First(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the first cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByRowProcessed_First(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the last cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public Cases findByRowProcessed_Last(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Returns the last cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public Cases fetchByRowProcessed_Last(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns the caseses before and after the current cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases[] findByRowProcessed_PrevAndNext(
			long caseId, String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Cases>
				orderByComparator)
		throws NoSuchCasesException;

	/**
	 * Removes all the caseses where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(String rowProcessed);

	/**
	 * Returns the number of caseses where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching caseses
	 */
	public int countByRowProcessed(String rowProcessed);

	/**
	 * Caches the cases in the entity cache if it is enabled.
	 *
	 * @param cases the cases
	 */
	public void cacheResult(Cases cases);

	/**
	 * Caches the caseses in the entity cache if it is enabled.
	 *
	 * @param caseses the caseses
	 */
	public void cacheResult(java.util.List<Cases> caseses);

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	public Cases create(long caseId);

	/**
	 * Removes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases that was removed
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases remove(long caseId) throws NoSuchCasesException;

	public Cases updateImpl(Cases cases);

	/**
	 * Returns the cases with the primary key or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public Cases findByPrimaryKey(long caseId) throws NoSuchCasesException;

	/**
	 * Returns the cases with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases, or <code>null</code> if a cases with the primary key could not be found
	 */
	public Cases fetchByPrimaryKey(long caseId);

	/**
	 * Returns all the caseses.
	 *
	 * @return the caseses
	 */
	public java.util.List<Cases> findAll();

	/**
	 * Returns a range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of caseses
	 */
	public java.util.List<Cases> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of caseses
	 */
	public java.util.List<Cases> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of caseses
	 */
	public java.util.List<Cases> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the caseses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	public int countAll();

}