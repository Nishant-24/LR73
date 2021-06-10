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

import com.argus.oth.cases.management.model.Cases;

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
 * The persistence utility for the cases service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.CasesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesPersistence
 * @generated
 */
public class CasesUtil {

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
	public static void clearCache(Cases cases) {
		getPersistence().clearCache(cases);
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
	public static Map<Serializable, Cases> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cases> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cases> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cases> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cases update(Cases cases) {
		return getPersistence().update(cases);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cases update(Cases cases, ServiceContext serviceContext) {
		return getPersistence().update(cases, serviceContext);
	}

	/**
	 * Returns all the caseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching caseses
	 */
	public static List<Cases> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Cases> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Cases> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Cases> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByUuid_First(
			String uuid, OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByUuid_First(
		String uuid, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByUuid_Last(
			String uuid, OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByUuid_Last(
		String uuid, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public static Cases[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUuid_PrevAndNext(
			caseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the caseses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of caseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching caseses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByUUID_G(String uuid, long groupId)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the cases where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cases that was removed
	 */
	public static Cases removeByUUID_G(String uuid, long groupId)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of caseses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching caseses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching caseses
	 */
	public static List<Cases> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Cases[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			caseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the caseses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching caseses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the cases where externalCaseId = &#63; or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByExternalCaseId(long externalCaseId)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByExternalCaseId(long externalCaseId) {
		return getPersistence().fetchByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByExternalCaseId(
		long externalCaseId, boolean useFinderCache) {

		return getPersistence().fetchByExternalCaseId(
			externalCaseId, useFinderCache);
	}

	/**
	 * Removes the cases where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @return the cases that was removed
	 */
	public static Cases removeByExternalCaseId(long externalCaseId)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().removeByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns the number of caseses where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching caseses
	 */
	public static int countByExternalCaseId(long externalCaseId) {
		return getPersistence().countByExternalCaseId(externalCaseId);
	}

	/**
	 * Returns all the caseses where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching caseses
	 */
	public static List<Cases> findByClientId(long clientId) {
		return getPersistence().findByClientId(clientId);
	}

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
	public static List<Cases> findByClientId(
		long clientId, int start, int end) {

		return getPersistence().findByClientId(clientId, start, end);
	}

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
	public static List<Cases> findByClientId(
		long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findByClientId(
			clientId, start, end, orderByComparator);
	}

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
	public static List<Cases> findByClientId(
		long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByClientId(
			clientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByClientId_First(
			long clientId, OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByClientId_First(
			clientId, orderByComparator);
	}

	/**
	 * Returns the first cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByClientId_First(
		long clientId, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByClientId_First(
			clientId, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByClientId_Last(
			long clientId, OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByClientId_Last(
			clientId, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByClientId_Last(
		long clientId, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByClientId_Last(
			clientId, orderByComparator);
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public static Cases[] findByClientId_PrevAndNext(
			long caseId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByClientId_PrevAndNext(
			caseId, clientId, orderByComparator);
	}

	/**
	 * Removes all the caseses where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	public static void removeByClientId(long clientId) {
		getPersistence().removeByClientId(clientId);
	}

	/**
	 * Returns the number of caseses where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching caseses
	 */
	public static int countByClientId(long clientId) {
		return getPersistence().countByClientId(clientId);
	}

	/**
	 * Returns all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the matching caseses
	 */
	public static List<Cases> findByG_C(long groupId, long clientId) {
		return getPersistence().findByG_C(groupId, clientId);
	}

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
	public static List<Cases> findByG_C(
		long groupId, long clientId, int start, int end) {

		return getPersistence().findByG_C(groupId, clientId, start, end);
	}

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
	public static List<Cases> findByG_C(
		long groupId, long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findByG_C(
			groupId, clientId, start, end, orderByComparator);
	}

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
	public static List<Cases> findByG_C(
		long groupId, long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_C(
			groupId, clientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByG_C_First(
			long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByG_C_First(
			groupId, clientId, orderByComparator);
	}

	/**
	 * Returns the first cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByG_C_First(
		long groupId, long clientId,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByG_C_First(
			groupId, clientId, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByG_C_Last(
			long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByG_C_Last(
			groupId, clientId, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByG_C_Last(
		long groupId, long clientId,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByG_C_Last(
			groupId, clientId, orderByComparator);
	}

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
	public static Cases[] findByG_C_PrevAndNext(
			long caseId, long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByG_C_PrevAndNext(
			caseId, groupId, clientId, orderByComparator);
	}

	/**
	 * Returns all the caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the matching caseses that the user has permission to view
	 */
	public static List<Cases> filterFindByG_C(long groupId, long clientId) {
		return getPersistence().filterFindByG_C(groupId, clientId);
	}

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
	public static List<Cases> filterFindByG_C(
		long groupId, long clientId, int start, int end) {

		return getPersistence().filterFindByG_C(groupId, clientId, start, end);
	}

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
	public static List<Cases> filterFindByG_C(
		long groupId, long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().filterFindByG_C(
			groupId, clientId, start, end, orderByComparator);
	}

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
	public static Cases[] filterFindByG_C_PrevAndNext(
			long caseId, long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().filterFindByG_C_PrevAndNext(
			caseId, groupId, clientId, orderByComparator);
	}

	/**
	 * Removes all the caseses where groupId = &#63; and clientId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 */
	public static void removeByG_C(long groupId, long clientId) {
		getPersistence().removeByG_C(groupId, clientId);
	}

	/**
	 * Returns the number of caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the number of matching caseses
	 */
	public static int countByG_C(long groupId, long clientId) {
		return getPersistence().countByG_C(groupId, clientId);
	}

	/**
	 * Returns the number of caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the number of matching caseses that the user has permission to view
	 */
	public static int filterCountByG_C(long groupId, long clientId) {
		return getPersistence().filterCountByG_C(groupId, clientId);
	}

	/**
	 * Returns all the caseses where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching caseses
	 */
	public static List<Cases> findByRowProcessed(String rowProcessed) {
		return getPersistence().findByRowProcessed(rowProcessed);
	}

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
	public static List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

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
	public static List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

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
	public static List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	public static Cases findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public static Cases[] findByRowProcessed_PrevAndNext(
			long caseId, String rowProcessed,
			OrderByComparator<Cases> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			caseId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the caseses where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(String rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of caseses where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching caseses
	 */
	public static int countByRowProcessed(String rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Caches the cases in the entity cache if it is enabled.
	 *
	 * @param cases the cases
	 */
	public static void cacheResult(Cases cases) {
		getPersistence().cacheResult(cases);
	}

	/**
	 * Caches the caseses in the entity cache if it is enabled.
	 *
	 * @param caseses the caseses
	 */
	public static void cacheResult(List<Cases> caseses) {
		getPersistence().cacheResult(caseses);
	}

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	public static Cases create(long caseId) {
		return getPersistence().create(caseId);
	}

	/**
	 * Removes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases that was removed
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public static Cases remove(long caseId)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().remove(caseId);
	}

	public static Cases updateImpl(Cases cases) {
		return getPersistence().updateImpl(cases);
	}

	/**
	 * Returns the cases with the primary key or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	public static Cases findByPrimaryKey(long caseId)
		throws com.argus.oth.cases.management.exception.NoSuchCasesException {

		return getPersistence().findByPrimaryKey(caseId);
	}

	/**
	 * Returns the cases with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases, or <code>null</code> if a cases with the primary key could not be found
	 */
	public static Cases fetchByPrimaryKey(long caseId) {
		return getPersistence().fetchByPrimaryKey(caseId);
	}

	/**
	 * Returns all the caseses.
	 *
	 * @return the caseses
	 */
	public static List<Cases> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Cases> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Cases> findAll(
		int start, int end, OrderByComparator<Cases> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Cases> findAll(
		int start, int end, OrderByComparator<Cases> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the caseses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CasesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CasesPersistence, CasesPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CasesPersistence.class);

		ServiceTracker<CasesPersistence, CasesPersistence> serviceTracker =
			new ServiceTracker<CasesPersistence, CasesPersistence>(
				bundle.getBundleContext(), CasesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}