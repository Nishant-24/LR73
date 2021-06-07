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
 * Provides a wrapper for {@link StagingClientGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientGroupLocalService
 * @generated
 */
public class StagingClientGroupLocalServiceWrapper
	implements ServiceWrapper<StagingClientGroupLocalService>,
			   StagingClientGroupLocalService {

	public StagingClientGroupLocalServiceWrapper(
		StagingClientGroupLocalService stagingClientGroupLocalService) {

		_stagingClientGroupLocalService = stagingClientGroupLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClientGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingClientGroupLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
		addStagingClientGroup(
			long externalClientGroupId, long clientId, String clientGroup,
			String clientGroupName, String modifiedDate, String createdDate) {

		return _stagingClientGroupLocalService.addStagingClientGroup(
			externalClientGroupId, clientId, clientGroup, clientGroupName,
			modifiedDate, createdDate);
	}

	/**
	 * Adds the staging client group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClientGroup the staging client group
	 * @return the staging client group that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
		addStagingClientGroup(
			com.argus.oth.cases.management.model.StagingClientGroup
				stagingClientGroup) {

		return _stagingClientGroupLocalService.addStagingClientGroup(
			stagingClientGroup);
	}

	/**
	 * Creates a new staging client group with the primary key. Does not add the staging client group to the database.
	 *
	 * @param stagingClientGroupId the primary key for the new staging client group
	 * @return the new staging client group
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
		createStagingClientGroup(long stagingClientGroupId) {

		return _stagingClientGroupLocalService.createStagingClientGroup(
			stagingClientGroupId);
	}

	@Override
	public void deleteAll() {
		_stagingClientGroupLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClientGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group that was removed
	 * @throws PortalException if a staging client group with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
			deleteStagingClientGroup(long stagingClientGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClientGroupLocalService.deleteStagingClientGroup(
			stagingClientGroupId);
	}

	/**
	 * Deletes the staging client group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClientGroup the staging client group
	 * @return the staging client group that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
		deleteStagingClientGroup(
			com.argus.oth.cases.management.model.StagingClientGroup
				stagingClientGroup) {

		return _stagingClientGroupLocalService.deleteStagingClientGroup(
			stagingClientGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingClientGroupLocalService.dynamicQuery();
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

		return _stagingClientGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClientGroupModelImpl</code>.
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

		return _stagingClientGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClientGroupModelImpl</code>.
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

		return _stagingClientGroupLocalService.dynamicQuery(
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

		return _stagingClientGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stagingClientGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
		fetchStagingClientGroup(long stagingClientGroupId) {

		return _stagingClientGroupLocalService.fetchStagingClientGroup(
			stagingClientGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingClientGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingClientGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingClientGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClientGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging client group with the primary key.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group
	 * @throws PortalException if a staging client group with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
			getStagingClientGroup(long stagingClientGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClientGroupLocalService.getStagingClientGroup(
			stagingClientGroupId);
	}

	/**
	 * Returns a range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @return the range of staging client groups
	 */
	@Override
	public java.util.List
		<com.argus.oth.cases.management.model.StagingClientGroup>
			getStagingClientGroups(int start, int end) {

		return _stagingClientGroupLocalService.getStagingClientGroups(
			start, end);
	}

	/**
	 * Returns the number of staging client groups.
	 *
	 * @return the number of staging client groups
	 */
	@Override
	public int getStagingClientGroupsCount() {
		return _stagingClientGroupLocalService.getStagingClientGroupsCount();
	}

	/**
	 * Updates the staging client group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClientGroup the staging client group
	 * @return the staging client group that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClientGroup
		updateStagingClientGroup(
			com.argus.oth.cases.management.model.StagingClientGroup
				stagingClientGroup) {

		return _stagingClientGroupLocalService.updateStagingClientGroup(
			stagingClientGroup);
	}

	@Override
	public StagingClientGroupLocalService getWrappedService() {
		return _stagingClientGroupLocalService;
	}

	@Override
	public void setWrappedService(
		StagingClientGroupLocalService stagingClientGroupLocalService) {

		_stagingClientGroupLocalService = stagingClientGroupLocalService;
	}

	private StagingClientGroupLocalService _stagingClientGroupLocalService;

}