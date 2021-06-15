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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StagingMemberLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingMemberLocalService
 * @generated
 */
public class StagingMemberLocalServiceWrapper
	implements ServiceWrapper<StagingMemberLocalService>,
			   StagingMemberLocalService {

	public StagingMemberLocalServiceWrapper(
		StagingMemberLocalService stagingMemberLocalService) {

		_stagingMemberLocalService = stagingMemberLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingMemberLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingMemberLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember addStagingMember(
		long externalMemberId, long clientId, long clientGroupId,
		String memberNumber, String memberFirstName, String memberLastName,
		String memberDOB, String certificationNumber, String rxNumber,
		String externalModifiedDate, String externalCreatedDate) {

		return _stagingMemberLocalService.addStagingMember(
			externalMemberId, clientId, clientGroupId, memberNumber,
			memberFirstName, memberLastName, memberDOB, certificationNumber,
			rxNumber, externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Adds the staging member to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMember the staging member
	 * @return the staging member that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember addStagingMember(
		com.argus.oth.cases.management.model.StagingMember stagingMember) {

		return _stagingMemberLocalService.addStagingMember(stagingMember);
	}

	/**
	 * Creates a new staging member with the primary key. Does not add the staging member to the database.
	 *
	 * @param stagingMemberId the primary key for the new staging member
	 * @return the new staging member
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember
		createStagingMember(long stagingMemberId) {

		return _stagingMemberLocalService.createStagingMember(stagingMemberId);
	}

	@Override
	public void deleteAllStagingMembers() {
		_stagingMemberLocalService.deleteAllStagingMembers();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingMemberLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member that was removed
	 * @throws PortalException if a staging member with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember
			deleteStagingMember(long stagingMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingMemberLocalService.deleteStagingMember(stagingMemberId);
	}

	/**
	 * Deletes the staging member from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMember the staging member
	 * @return the staging member that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember
		deleteStagingMember(
			com.argus.oth.cases.management.model.StagingMember stagingMember) {

		return _stagingMemberLocalService.deleteStagingMember(stagingMember);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingMemberLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingMemberLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stagingMemberLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stagingMemberLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingMemberLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stagingMemberLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingMember
		fetchStagingMember(long stagingMemberId) {

		return _stagingMemberLocalService.fetchStagingMember(stagingMemberId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingMemberLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.argus.oth.cases.management.model.StagingMember
		getByExternalMemberId(long externalMemberId) {

		return _stagingMemberLocalService.getByExternalMemberId(
			externalMemberId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingMemberLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingMemberLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingMemberLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging member with the primary key.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member
	 * @throws PortalException if a staging member with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember getStagingMember(
			long stagingMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingMemberLocalService.getStagingMember(stagingMemberId);
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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.StagingMember>
		getStagingMembers(int start, int end) {

		return _stagingMemberLocalService.getStagingMembers(start, end);
	}

	/**
	 * Returns the number of staging members.
	 *
	 * @return the number of staging members
	 */
	@Override
	public int getStagingMembersCount() {
		return _stagingMemberLocalService.getStagingMembersCount();
	}

	/**
	 * Updates the staging member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMember the staging member
	 * @return the staging member that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingMember
		updateStagingMember(
			com.argus.oth.cases.management.model.StagingMember stagingMember) {

		return _stagingMemberLocalService.updateStagingMember(stagingMember);
	}

	@Override
	public StagingMemberLocalService getWrappedService() {
		return _stagingMemberLocalService;
	}

	@Override
	public void setWrappedService(
		StagingMemberLocalService stagingMemberLocalService) {

		_stagingMemberLocalService = stagingMemberLocalService;
	}

	private StagingMemberLocalService _stagingMemberLocalService;

}