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

import com.argus.oth.cases.management.model.AuthProcedure;

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
 * The persistence utility for the auth procedure service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.AuthProcedurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthProcedurePersistence
 * @generated
 */
public class AuthProcedureUtil {

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
	public static void clearCache(AuthProcedure authProcedure) {
		getPersistence().clearCache(authProcedure);
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
	public static Map<Serializable, AuthProcedure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AuthProcedure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuthProcedure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuthProcedure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AuthProcedure update(AuthProcedure authProcedure) {
		return getPersistence().update(authProcedure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AuthProcedure update(
		AuthProcedure authProcedure, ServiceContext serviceContext) {

		return getPersistence().update(authProcedure, serviceContext);
	}

	/**
	 * Returns all the auth procedures where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the matching auth procedures
	 */
	public static List<AuthProcedure> findByAuthNumber(String authNumber) {
		return getPersistence().findByAuthNumber(authNumber);
	}

	/**
	 * Returns a range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of matching auth procedures
	 */
	public static List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end) {

		return getPersistence().findByAuthNumber(authNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auth procedures
	 */
	public static List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().findByAuthNumber(
			authNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auth procedures
	 */
	public static List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAuthNumber(
			authNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public static AuthProcedure findByAuthNumber_First(
			String authNumber,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByAuthNumber_First(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the first auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public static AuthProcedure fetchByAuthNumber_First(
		String authNumber, OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().fetchByAuthNumber_First(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the last auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public static AuthProcedure findByAuthNumber_Last(
			String authNumber,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByAuthNumber_Last(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the last auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public static AuthProcedure fetchByAuthNumber_Last(
		String authNumber, OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().fetchByAuthNumber_Last(
			authNumber, orderByComparator);
	}

	/**
	 * Returns the auth procedures before and after the current auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authProcedureId the primary key of the current auth procedure
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public static AuthProcedure[] findByAuthNumber_PrevAndNext(
			long authProcedureId, String authNumber,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByAuthNumber_PrevAndNext(
			authProcedureId, authNumber, orderByComparator);
	}

	/**
	 * Removes all the auth procedures where authNumber = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 */
	public static void removeByAuthNumber(String authNumber) {
		getPersistence().removeByAuthNumber(authNumber);
	}

	/**
	 * Returns the number of auth procedures where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the number of matching auth procedures
	 */
	public static int countByAuthNumber(String authNumber) {
		return getPersistence().countByAuthNumber(authNumber);
	}

	/**
	 * Returns all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching auth procedures
	 */
	public static List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId) {

		return getPersistence().findByExtAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns a range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of matching auth procedures
	 */
	public static List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end) {

		return getPersistence().findByExtAuthorizationId(
			externalAuthorizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auth procedures
	 */
	public static List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().findByExtAuthorizationId(
			externalAuthorizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auth procedures
	 */
	public static List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByExtAuthorizationId(
			externalAuthorizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public static AuthProcedure findByExtAuthorizationId_First(
			long externalAuthorizationId,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByExtAuthorizationId_First(
			externalAuthorizationId, orderByComparator);
	}

	/**
	 * Returns the first auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public static AuthProcedure fetchByExtAuthorizationId_First(
		long externalAuthorizationId,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().fetchByExtAuthorizationId_First(
			externalAuthorizationId, orderByComparator);
	}

	/**
	 * Returns the last auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public static AuthProcedure findByExtAuthorizationId_Last(
			long externalAuthorizationId,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByExtAuthorizationId_Last(
			externalAuthorizationId, orderByComparator);
	}

	/**
	 * Returns the last auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public static AuthProcedure fetchByExtAuthorizationId_Last(
		long externalAuthorizationId,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().fetchByExtAuthorizationId_Last(
			externalAuthorizationId, orderByComparator);
	}

	/**
	 * Returns the auth procedures before and after the current auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param authProcedureId the primary key of the current auth procedure
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public static AuthProcedure[] findByExtAuthorizationId_PrevAndNext(
			long authProcedureId, long externalAuthorizationId,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByExtAuthorizationId_PrevAndNext(
			authProcedureId, externalAuthorizationId, orderByComparator);
	}

	/**
	 * Removes all the auth procedures where externalAuthorizationId = &#63; from the database.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 */
	public static void removeByExtAuthorizationId(
		long externalAuthorizationId) {

		getPersistence().removeByExtAuthorizationId(externalAuthorizationId);
	}

	/**
	 * Returns the number of auth procedures where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the number of matching auth procedures
	 */
	public static int countByExtAuthorizationId(long externalAuthorizationId) {
		return getPersistence().countByExtAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or throws a <code>NoSuchAuthProcedureException</code> if it could not be found.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public static AuthProcedure findByA_M(
			String authNumber, String medicalCodeId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByA_M(authNumber, medicalCodeId);
	}

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public static AuthProcedure fetchByA_M(
		String authNumber, String medicalCodeId) {

		return getPersistence().fetchByA_M(authNumber, medicalCodeId);
	}

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public static AuthProcedure fetchByA_M(
		String authNumber, String medicalCodeId, boolean useFinderCache) {

		return getPersistence().fetchByA_M(
			authNumber, medicalCodeId, useFinderCache);
	}

	/**
	 * Removes the auth procedure where authNumber = &#63; and medicalCodeId = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the auth procedure that was removed
	 */
	public static AuthProcedure removeByA_M(
			String authNumber, String medicalCodeId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().removeByA_M(authNumber, medicalCodeId);
	}

	/**
	 * Returns the number of auth procedures where authNumber = &#63; and medicalCodeId = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the number of matching auth procedures
	 */
	public static int countByA_M(String authNumber, String medicalCodeId) {
		return getPersistence().countByA_M(authNumber, medicalCodeId);
	}

	/**
	 * Caches the auth procedure in the entity cache if it is enabled.
	 *
	 * @param authProcedure the auth procedure
	 */
	public static void cacheResult(AuthProcedure authProcedure) {
		getPersistence().cacheResult(authProcedure);
	}

	/**
	 * Caches the auth procedures in the entity cache if it is enabled.
	 *
	 * @param authProcedures the auth procedures
	 */
	public static void cacheResult(List<AuthProcedure> authProcedures) {
		getPersistence().cacheResult(authProcedures);
	}

	/**
	 * Creates a new auth procedure with the primary key. Does not add the auth procedure to the database.
	 *
	 * @param authProcedureId the primary key for the new auth procedure
	 * @return the new auth procedure
	 */
	public static AuthProcedure create(long authProcedureId) {
		return getPersistence().create(authProcedureId);
	}

	/**
	 * Removes the auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure that was removed
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public static AuthProcedure remove(long authProcedureId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().remove(authProcedureId);
	}

	public static AuthProcedure updateImpl(AuthProcedure authProcedure) {
		return getPersistence().updateImpl(authProcedure);
	}

	/**
	 * Returns the auth procedure with the primary key or throws a <code>NoSuchAuthProcedureException</code> if it could not be found.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public static AuthProcedure findByPrimaryKey(long authProcedureId)
		throws com.argus.oth.cases.management.exception.
			NoSuchAuthProcedureException {

		return getPersistence().findByPrimaryKey(authProcedureId);
	}

	/**
	 * Returns the auth procedure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure, or <code>null</code> if a auth procedure with the primary key could not be found
	 */
	public static AuthProcedure fetchByPrimaryKey(long authProcedureId) {
		return getPersistence().fetchByPrimaryKey(authProcedureId);
	}

	/**
	 * Returns all the auth procedures.
	 *
	 * @return the auth procedures
	 */
	public static List<AuthProcedure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of auth procedures
	 */
	public static List<AuthProcedure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auth procedures
	 */
	public static List<AuthProcedure> findAll(
		int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auth procedures
	 */
	public static List<AuthProcedure> findAll(
		int start, int end, OrderByComparator<AuthProcedure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the auth procedures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of auth procedures.
	 *
	 * @return the number of auth procedures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuthProcedurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuthProcedurePersistence, AuthProcedurePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthProcedurePersistence.class);

		ServiceTracker<AuthProcedurePersistence, AuthProcedurePersistence>
			serviceTracker =
				new ServiceTracker
					<AuthProcedurePersistence, AuthProcedurePersistence>(
						bundle.getBundleContext(),
						AuthProcedurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}