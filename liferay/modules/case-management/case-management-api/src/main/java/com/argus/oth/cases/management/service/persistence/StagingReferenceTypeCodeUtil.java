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

import com.argus.oth.cases.management.model.StagingReferenceTypeCode;

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
 * The persistence utility for the staging reference type code service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingReferenceTypeCodePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingReferenceTypeCodePersistence
 * @generated
 */
public class StagingReferenceTypeCodeUtil {

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
	public static void clearCache(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		getPersistence().clearCache(stagingReferenceTypeCode);
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
	public static Map<Serializable, StagingReferenceTypeCode>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingReferenceTypeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingReferenceTypeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingReferenceTypeCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingReferenceTypeCode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingReferenceTypeCode update(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		return getPersistence().update(stagingReferenceTypeCode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingReferenceTypeCode update(
		StagingReferenceTypeCode stagingReferenceTypeCode,
		ServiceContext serviceContext) {

		return getPersistence().update(
			stagingReferenceTypeCode, serviceContext);
	}

	/**
	 * Caches the staging reference type code in the entity cache if it is enabled.
	 *
	 * @param stagingReferenceTypeCode the staging reference type code
	 */
	public static void cacheResult(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		getPersistence().cacheResult(stagingReferenceTypeCode);
	}

	/**
	 * Caches the staging reference type codes in the entity cache if it is enabled.
	 *
	 * @param stagingReferenceTypeCodes the staging reference type codes
	 */
	public static void cacheResult(
		List<StagingReferenceTypeCode> stagingReferenceTypeCodes) {

		getPersistence().cacheResult(stagingReferenceTypeCodes);
	}

	/**
	 * Creates a new staging reference type code with the primary key. Does not add the staging reference type code to the database.
	 *
	 * @param stagingReferenceTypeCodeId the primary key for the new staging reference type code
	 * @return the new staging reference type code
	 */
	public static StagingReferenceTypeCode create(
		long stagingReferenceTypeCodeId) {

		return getPersistence().create(stagingReferenceTypeCodeId);
	}

	/**
	 * Removes the staging reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code that was removed
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	public static StagingReferenceTypeCode remove(
			long stagingReferenceTypeCodeId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingReferenceTypeCodeException {

		return getPersistence().remove(stagingReferenceTypeCodeId);
	}

	public static StagingReferenceTypeCode updateImpl(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		return getPersistence().updateImpl(stagingReferenceTypeCode);
	}

	/**
	 * Returns the staging reference type code with the primary key or throws a <code>NoSuchStagingReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	public static StagingReferenceTypeCode findByPrimaryKey(
			long stagingReferenceTypeCodeId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingReferenceTypeCodeException {

		return getPersistence().findByPrimaryKey(stagingReferenceTypeCodeId);
	}

	/**
	 * Returns the staging reference type code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code, or <code>null</code> if a staging reference type code with the primary key could not be found
	 */
	public static StagingReferenceTypeCode fetchByPrimaryKey(
		long stagingReferenceTypeCodeId) {

		return getPersistence().fetchByPrimaryKey(stagingReferenceTypeCodeId);
	}

	/**
	 * Returns all the staging reference type codes.
	 *
	 * @return the staging reference type codes
	 */
	public static List<StagingReferenceTypeCode> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @return the range of staging reference type codes
	 */
	public static List<StagingReferenceTypeCode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging reference type codes
	 */
	public static List<StagingReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<StagingReferenceTypeCode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging reference type codes
	 */
	public static List<StagingReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<StagingReferenceTypeCode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging reference type codes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging reference type codes.
	 *
	 * @return the number of staging reference type codes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingReferenceTypeCodePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingReferenceTypeCodePersistence,
		 StagingReferenceTypeCodePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingReferenceTypeCodePersistence.class);

		ServiceTracker
			<StagingReferenceTypeCodePersistence,
			 StagingReferenceTypeCodePersistence> serviceTracker =
				new ServiceTracker
					<StagingReferenceTypeCodePersistence,
					 StagingReferenceTypeCodePersistence>(
						 bundle.getBundleContext(),
						 StagingReferenceTypeCodePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}