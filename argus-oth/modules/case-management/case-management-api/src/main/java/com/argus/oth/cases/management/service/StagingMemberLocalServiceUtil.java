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

package com.argus.oth.cases.management.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StagingMember. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingMemberLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingMemberLocalService
 * @generated
 */
public class StagingMemberLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingMemberLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingMemberLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingMemberLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.StagingMember
		addStagingMember(
			long externalMemberId, long clientId, long clientGroupId,
			String memberNumber, String memberFirstName, String memberLastName,
			String memberDOB, String certificationNumber, String rxNumber,
			String externalModifiedDate, String externalCreatedDate) {

		return getService().addStagingMember(
			externalMemberId, clientId, clientGroupId, memberNumber,
			memberFirstName, memberLastName, memberDOB, certificationNumber,
			rxNumber, externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Adds the staging member to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingMemberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingMember the staging member
	 * @return the staging member that was added
	 */
	public static com.argus.oth.cases.management.model.StagingMember
		addStagingMember(
			com.argus.oth.cases.management.model.StagingMember stagingMember) {

		return getService().addStagingMember(stagingMember);
	}

	/**
	 * Creates a new staging member with the primary key. Does not add the staging member to the database.
	 *
	 * @param stagingMemberId the primary key for the new staging member
	 * @return the new staging member
	 */
	public static com.argus.oth.cases.management.model.StagingMember
		createStagingMember(long stagingMemberId) {

		return getService().createStagingMember(stagingMemberId);
	}

	public static void deleteAllStagingMembers() {
		getService().deleteAllStagingMembers();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingMemberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member that was removed
	 * @throws PortalException if a staging member with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingMember
			deleteStagingMember(long stagingMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingMember(stagingMemberId);
	}

	/**
	 * Deletes the staging member from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingMemberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingMember the staging member
	 * @return the staging member that was removed
	 */
	public static com.argus.oth.cases.management.model.StagingMember
		deleteStagingMember(
			com.argus.oth.cases.management.model.StagingMember stagingMember) {

		return getService().deleteStagingMember(stagingMember);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.argus.oth.cases.management.model.StagingMember
		fetchStagingMember(long stagingMemberId) {

		return getService().fetchStagingMember(stagingMemberId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.argus.oth.cases.management.model.StagingMember
		getByExternalMemberId(long externalMemberId) {

		return getService().getByExternalMemberId(externalMemberId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging member with the primary key.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member
	 * @throws PortalException if a staging member with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingMember
			getStagingMember(long stagingMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingMember(stagingMemberId);
	}

	/**
	 * Returns a range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @return the range of staging members
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.StagingMember> getStagingMembers(
			int start, int end) {

		return getService().getStagingMembers(start, end);
	}

	/**
	 * Returns the number of staging members.
	 *
	 * @return the number of staging members
	 */
	public static int getStagingMembersCount() {
		return getService().getStagingMembersCount();
	}

	/**
	 * Updates the staging member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingMemberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingMember the staging member
	 * @return the staging member that was updated
	 */
	public static com.argus.oth.cases.management.model.StagingMember
		updateStagingMember(
			com.argus.oth.cases.management.model.StagingMember stagingMember) {

		return getService().updateStagingMember(stagingMember);
	}

	public static StagingMemberLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingMemberLocalService, StagingMemberLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingMemberLocalService.class);

		ServiceTracker<StagingMemberLocalService, StagingMemberLocalService>
			serviceTracker =
				new ServiceTracker
					<StagingMemberLocalService, StagingMemberLocalService>(
						bundle.getBundleContext(),
						StagingMemberLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}