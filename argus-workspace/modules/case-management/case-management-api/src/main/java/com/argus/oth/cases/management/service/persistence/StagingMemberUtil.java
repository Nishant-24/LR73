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

import com.argus.oth.cases.management.model.StagingMember;

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
 * The persistence utility for the staging member service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingMemberPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingMemberPersistence
 * @generated
 */
public class StagingMemberUtil {

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
	public static void clearCache(StagingMember stagingMember) {
		getPersistence().clearCache(stagingMember);
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
	public static Map<Serializable, StagingMember> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingMember> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingMember update(StagingMember stagingMember) {
		return getPersistence().update(stagingMember);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingMember update(
		StagingMember stagingMember, ServiceContext serviceContext) {

		return getPersistence().update(stagingMember, serviceContext);
	}

	/**
	 * Returns the staging member where externalMemberId = &#63; or throws a <code>NoSuchStagingMemberException</code> if it could not be found.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching staging member
	 * @throws NoSuchStagingMemberException if a matching staging member could not be found
	 */
	public static StagingMember findByExternalMemberId(long externalMemberId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingMemberException {

		return getPersistence().findByExternalMemberId(externalMemberId);
	}

	/**
	 * Returns the staging member where externalMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching staging member, or <code>null</code> if a matching staging member could not be found
	 */
	public static StagingMember fetchByExternalMemberId(long externalMemberId) {
		return getPersistence().fetchByExternalMemberId(externalMemberId);
	}

	/**
	 * Returns the staging member where externalMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging member, or <code>null</code> if a matching staging member could not be found
	 */
	public static StagingMember fetchByExternalMemberId(
		long externalMemberId, boolean useFinderCache) {

		return getPersistence().fetchByExternalMemberId(
			externalMemberId, useFinderCache);
	}

	/**
	 * Removes the staging member where externalMemberId = &#63; from the database.
	 *
	 * @param externalMemberId the external member ID
	 * @return the staging member that was removed
	 */
	public static StagingMember removeByExternalMemberId(long externalMemberId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingMemberException {

		return getPersistence().removeByExternalMemberId(externalMemberId);
	}

	/**
	 * Returns the number of staging members where externalMemberId = &#63;.
	 *
	 * @param externalMemberId the external member ID
	 * @return the number of matching staging members
	 */
	public static int countByExternalMemberId(long externalMemberId) {
		return getPersistence().countByExternalMemberId(externalMemberId);
	}

	/**
	 * Caches the staging member in the entity cache if it is enabled.
	 *
	 * @param stagingMember the staging member
	 */
	public static void cacheResult(StagingMember stagingMember) {
		getPersistence().cacheResult(stagingMember);
	}

	/**
	 * Caches the staging members in the entity cache if it is enabled.
	 *
	 * @param stagingMembers the staging members
	 */
	public static void cacheResult(List<StagingMember> stagingMembers) {
		getPersistence().cacheResult(stagingMembers);
	}

	/**
	 * Creates a new staging member with the primary key. Does not add the staging member to the database.
	 *
	 * @param stagingMemberId the primary key for the new staging member
	 * @return the new staging member
	 */
	public static StagingMember create(long stagingMemberId) {
		return getPersistence().create(stagingMemberId);
	}

	/**
	 * Removes the staging member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member that was removed
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	public static StagingMember remove(long stagingMemberId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingMemberException {

		return getPersistence().remove(stagingMemberId);
	}

	public static StagingMember updateImpl(StagingMember stagingMember) {
		return getPersistence().updateImpl(stagingMember);
	}

	/**
	 * Returns the staging member with the primary key or throws a <code>NoSuchStagingMemberException</code> if it could not be found.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	public static StagingMember findByPrimaryKey(long stagingMemberId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingMemberException {

		return getPersistence().findByPrimaryKey(stagingMemberId);
	}

	/**
	 * Returns the staging member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member, or <code>null</code> if a staging member with the primary key could not be found
	 */
	public static StagingMember fetchByPrimaryKey(long stagingMemberId) {
		return getPersistence().fetchByPrimaryKey(stagingMemberId);
	}

	/**
	 * Returns all the staging members.
	 *
	 * @return the staging members
	 */
	public static List<StagingMember> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @return the range of staging members
	 */
	public static List<StagingMember> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging members
	 */
	public static List<StagingMember> findAll(
		int start, int end,
		OrderByComparator<StagingMember> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging members
	 */
	public static List<StagingMember> findAll(
		int start, int end, OrderByComparator<StagingMember> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging members from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging members.
	 *
	 * @return the number of staging members
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingMemberPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingMemberPersistence, StagingMemberPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingMemberPersistence.class);

		ServiceTracker<StagingMemberPersistence, StagingMemberPersistence>
			serviceTracker =
				new ServiceTracker
					<StagingMemberPersistence, StagingMemberPersistence>(
						bundle.getBundleContext(),
						StagingMemberPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}