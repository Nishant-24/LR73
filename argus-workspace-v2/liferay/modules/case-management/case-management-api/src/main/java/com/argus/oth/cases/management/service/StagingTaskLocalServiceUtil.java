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
 * Provides the local service utility for StagingTask. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingTaskLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingTaskLocalService
 * @generated
 */
public class StagingTaskLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingTaskLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addStagingTask(
		long externalCaseId, String completedFlag, String description,
		String startDate, String endDate, String dueDate,
		String externalCreateDate, String externalModifiedDate,
		long externalTaskId, String priority, String status) {

		getService().addStagingTask(
			externalCaseId, completedFlag, description, startDate, endDate,
			dueDate, externalCreateDate, externalModifiedDate, externalTaskId,
			priority, status);
	}

	/**
	 * Adds the staging task to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingTask the staging task
	 * @return the staging task that was added
	 */
	public static com.argus.oth.cases.management.model.StagingTask
		addStagingTask(
			com.argus.oth.cases.management.model.StagingTask stagingTask) {

		return getService().addStagingTask(stagingTask);
	}

	/**
	 * Creates a new staging task with the primary key. Does not add the staging task to the database.
	 *
	 * @param taskId the primary key for the new staging task
	 * @return the new staging task
	 */
	public static com.argus.oth.cases.management.model.StagingTask
		createStagingTask(long taskId) {

		return getService().createStagingTask(taskId);
	}

	public static void deleteAllStagingTasks() {
		getService().deleteAllStagingTasks();
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
	 * Deletes the staging task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task that was removed
	 * @throws PortalException if a staging task with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingTask
			deleteStagingTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingTask(taskId);
	}

	/**
	 * Deletes the staging task from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingTask the staging task
	 * @return the staging task that was removed
	 */
	public static com.argus.oth.cases.management.model.StagingTask
		deleteStagingTask(
			com.argus.oth.cases.management.model.StagingTask stagingTask) {

		return getService().deleteStagingTask(stagingTask);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingTaskModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingTaskModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.StagingTask
		fetchStagingTask(long taskId) {

		return getService().fetchStagingTask(taskId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the staging task with the primary key.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task
	 * @throws PortalException if a staging task with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingTask
			getStagingTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingTask(taskId);
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
	public static java.util.List
		<com.argus.oth.cases.management.model.StagingTask> getStagingTasks(
			int start, int end) {

		return getService().getStagingTasks(start, end);
	}

	/**
	 * Returns the number of staging tasks.
	 *
	 * @return the number of staging tasks
	 */
	public static int getStagingTasksCount() {
		return getService().getStagingTasksCount();
	}

	/**
	 * Updates the staging task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingTask the staging task
	 * @return the staging task that was updated
	 */
	public static com.argus.oth.cases.management.model.StagingTask
		updateStagingTask(
			com.argus.oth.cases.management.model.StagingTask stagingTask) {

		return getService().updateStagingTask(stagingTask);
	}

	public static StagingTaskLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingTaskLocalService, StagingTaskLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingTaskLocalService.class);

		ServiceTracker<StagingTaskLocalService, StagingTaskLocalService>
			serviceTracker =
				new ServiceTracker
					<StagingTaskLocalService, StagingTaskLocalService>(
						bundle.getBundleContext(),
						StagingTaskLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}