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

import com.argus.oth.cases.management.model.ReferenceTypeCode;

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
 * The persistence utility for the reference type code service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.ReferenceTypeCodePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferenceTypeCodePersistence
 * @generated
 */
public class ReferenceTypeCodeUtil {

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
	public static void clearCache(ReferenceTypeCode referenceTypeCode) {
		getPersistence().clearCache(referenceTypeCode);
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
	public static Map<Serializable, ReferenceTypeCode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ReferenceTypeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReferenceTypeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReferenceTypeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ReferenceTypeCode update(
		ReferenceTypeCode referenceTypeCode) {

		return getPersistence().update(referenceTypeCode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ReferenceTypeCode update(
		ReferenceTypeCode referenceTypeCode, ServiceContext serviceContext) {

		return getPersistence().update(referenceTypeCode, serviceContext);
	}

	/**
	 * Returns the reference type code where key = &#63; or throws a <code>NoSuchReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode findByKey(String key)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByKey(key);
	}

	/**
	 * Returns the reference type code where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode fetchByKey(String key) {
		return getPersistence().fetchByKey(key);
	}

	/**
	 * Returns the reference type code where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode fetchByKey(
		String key, boolean useFinderCache) {

		return getPersistence().fetchByKey(key, useFinderCache);
	}

	/**
	 * Removes the reference type code where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the reference type code that was removed
	 */
	public static ReferenceTypeCode removeByKey(String key)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().removeByKey(key);
	}

	/**
	 * Returns the number of reference type codes where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching reference type codes
	 */
	public static int countByKey(String key) {
		return getPersistence().countByKey(key);
	}

	/**
	 * Returns all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed) {

		return getPersistence().findByRowProcessed(rowProcessed);
	}

	/**
	 * Returns a range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return getPersistence().findByRowProcessed(rowProcessed, start, end);
	}

	/**
	 * Returns an ordered range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRowProcessed(
			rowProcessed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode findByRowProcessed_First(
			String rowProcessed,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the first reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode fetchByRowProcessed_First(
		String rowProcessed,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().fetchByRowProcessed_First(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode findByRowProcessed_Last(
			String rowProcessed,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the last reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode fetchByRowProcessed_Last(
		String rowProcessed,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);
	}

	/**
	 * Returns the reference type codes before and after the current reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param referenceTypeCodeId the primary key of the current reference type code
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public static ReferenceTypeCode[] findByRowProcessed_PrevAndNext(
			long referenceTypeCodeId, String rowProcessed,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByRowProcessed_PrevAndNext(
			referenceTypeCodeId, rowProcessed, orderByComparator);
	}

	/**
	 * Removes all the reference type codes where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public static void removeByRowProcessed(String rowProcessed) {
		getPersistence().removeByRowProcessed(rowProcessed);
	}

	/**
	 * Returns the number of reference type codes where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching reference type codes
	 */
	public static int countByRowProcessed(String rowProcessed) {
		return getPersistence().countByRowProcessed(rowProcessed);
	}

	/**
	 * Returns all the reference type codes where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByType(String type) {
		return getPersistence().findByType(type);
	}

	/**
	 * Returns a range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByType(
		String type, int start, int end) {

		return getPersistence().findByType(type, start, end);
	}

	/**
	 * Returns an ordered range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByType(
		String type, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reference type codes
	 */
	public static List<ReferenceTypeCode> findByType(
		String type, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode findByType_First(
			String type, OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	 * Returns the first reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode fetchByType_First(
		String type, OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	 * Returns the last reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode findByType_Last(
			String type, OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	 * Returns the last reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public static ReferenceTypeCode fetchByType_Last(
		String type, OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	 * Returns the reference type codes before and after the current reference type code in the ordered set where type = &#63;.
	 *
	 * @param referenceTypeCodeId the primary key of the current reference type code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public static ReferenceTypeCode[] findByType_PrevAndNext(
			long referenceTypeCodeId, String type,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByType_PrevAndNext(
			referenceTypeCodeId, type, orderByComparator);
	}

	/**
	 * Removes all the reference type codes where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeByType(String type) {
		getPersistence().removeByType(type);
	}

	/**
	 * Returns the number of reference type codes where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching reference type codes
	 */
	public static int countByType(String type) {
		return getPersistence().countByType(type);
	}

	/**
	 * Caches the reference type code in the entity cache if it is enabled.
	 *
	 * @param referenceTypeCode the reference type code
	 */
	public static void cacheResult(ReferenceTypeCode referenceTypeCode) {
		getPersistence().cacheResult(referenceTypeCode);
	}

	/**
	 * Caches the reference type codes in the entity cache if it is enabled.
	 *
	 * @param referenceTypeCodes the reference type codes
	 */
	public static void cacheResult(List<ReferenceTypeCode> referenceTypeCodes) {
		getPersistence().cacheResult(referenceTypeCodes);
	}

	/**
	 * Creates a new reference type code with the primary key. Does not add the reference type code to the database.
	 *
	 * @param referenceTypeCodeId the primary key for the new reference type code
	 * @return the new reference type code
	 */
	public static ReferenceTypeCode create(long referenceTypeCodeId) {
		return getPersistence().create(referenceTypeCodeId);
	}

	/**
	 * Removes the reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code that was removed
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public static ReferenceTypeCode remove(long referenceTypeCodeId)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().remove(referenceTypeCodeId);
	}

	public static ReferenceTypeCode updateImpl(
		ReferenceTypeCode referenceTypeCode) {

		return getPersistence().updateImpl(referenceTypeCode);
	}

	/**
	 * Returns the reference type code with the primary key or throws a <code>NoSuchReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public static ReferenceTypeCode findByPrimaryKey(long referenceTypeCodeId)
		throws com.argus.oth.cases.management.exception.
			NoSuchReferenceTypeCodeException {

		return getPersistence().findByPrimaryKey(referenceTypeCodeId);
	}

	/**
	 * Returns the reference type code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code, or <code>null</code> if a reference type code with the primary key could not be found
	 */
	public static ReferenceTypeCode fetchByPrimaryKey(
		long referenceTypeCodeId) {

		return getPersistence().fetchByPrimaryKey(referenceTypeCodeId);
	}

	/**
	 * Returns all the reference type codes.
	 *
	 * @return the reference type codes
	 */
	public static List<ReferenceTypeCode> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of reference type codes
	 */
	public static List<ReferenceTypeCode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reference type codes
	 */
	public static List<ReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reference type codes
	 */
	public static List<ReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the reference type codes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of reference type codes.
	 *
	 * @return the number of reference type codes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReferenceTypeCodePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ReferenceTypeCodePersistence, ReferenceTypeCodePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ReferenceTypeCodePersistence.class);

		ServiceTracker
			<ReferenceTypeCodePersistence, ReferenceTypeCodePersistence>
				serviceTracker =
					new ServiceTracker
						<ReferenceTypeCodePersistence,
						 ReferenceTypeCodePersistence>(
							 bundle.getBundleContext(),
							 ReferenceTypeCodePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}