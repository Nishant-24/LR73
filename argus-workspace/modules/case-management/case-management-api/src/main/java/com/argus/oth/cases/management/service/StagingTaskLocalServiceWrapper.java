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
 * Provides a wrapper for {@link StagingTaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingTaskLocalService
 * @generated
 */
public class StagingTaskLocalServiceWrapper
	implements ServiceWrapper<StagingTaskLocalService>,
			   StagingTaskLocalService {

	public StagingTaskLocalServiceWrapper(
		StagingTaskLocalService stagingTaskLocalService) {

		_stagingTaskLocalService = stagingTaskLocalService;
	}

	@Override
	public void addStagingTask(
		long externalCaseId, String completedFlag, String description,
		String startDate, String endDate, String dueDate,
		String externalCreateDate, String externalModifiedDate,
		long externalTaskId, String priority, String status) {

		_stagingTaskLocalService.addStagingTask(
			externalCaseId, completedFlag, description, startDate, endDate,
			dueDate, externalCreateDate, externalModifiedDate, externalTaskId,
			priority, status);
	}

	/**
	 * Adds the staging task to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingTask the staging task
	 * @return the staging task that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingTask addStagingTask(
		com.argus.oth.cases.management.model.StagingTask stagingTask) {

		return _stagingTaskLocalService.addStagingTask(stagingTask);
	}

	/**
	 * Creates a new staging task with the primary key. Does not add the staging task to the database.
	 *
	 * @param taskId the primary key for the new staging task
	 * @return the new staging task
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingTask createStagingTask(
		long taskId) {

		return _stagingTaskLocalService.createStagingTask(taskId);
	}

	@Override
	public void deleteAllStagingTasks() {
		_stagingTaskLocalService.deleteAllStagingTasks();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingTaskLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task that was removed
	 * @throws PortalException if a staging task with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingTask deleteStagingTask(
			long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingTaskLocalService.deleteStagingTask(taskId);
	}

	/**
	 * Deletes the staging task from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingTask the staging task
	 * @return the staging task that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingTask deleteStagingTask(
		com.argus.oth.cases.management.model.StagingTask stagingTask) {

		return _stagingTaskLocalService.deleteStagingTask(stagingTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingTaskLocalService.dynamicQuery();
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

		return _stagingTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingTaskModelImpl</code>.
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

		return _stagingTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingTaskModelImpl</code>.
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

		return _stagingTaskLocalService.dynamicQuery(
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

		return _stagingTaskLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stagingTaskLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingTask fetchStagingTask(
		long taskId) {

		return _stagingTaskLocalService.fetchStagingTask(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingTaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingTaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingTaskLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging task with the primary key.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task
	 * @throws PortalException if a staging task with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingTask getStagingTask(
			long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingTaskLocalService.getStagingTask(taskId);
	}

	/**
	 * Returns a range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @return the range of staging tasks
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.StagingTask>
		getStagingTasks(int start, int end) {

		return _stagingTaskLocalService.getStagingTasks(start, end);
	}

	/**
	 * Returns the number of staging tasks.
	 *
	 * @return the number of staging tasks
	 */
	@Override
	public int getStagingTasksCount() {
		return _stagingTaskLocalService.getStagingTasksCount();
	}

	/**
	 * Updates the staging task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingTaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingTask the staging task
	 * @return the staging task that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingTask updateStagingTask(
		com.argus.oth.cases.management.model.StagingTask stagingTask) {

		return _stagingTaskLocalService.updateStagingTask(stagingTask);
	}

	@Override
	public StagingTaskLocalService getWrappedService() {
		return _stagingTaskLocalService;
	}

	@Override
	public void setWrappedService(
		StagingTaskLocalService stagingTaskLocalService) {

		_stagingTaskLocalService = stagingTaskLocalService;
	}

	private StagingTaskLocalService _stagingTaskLocalService;

}