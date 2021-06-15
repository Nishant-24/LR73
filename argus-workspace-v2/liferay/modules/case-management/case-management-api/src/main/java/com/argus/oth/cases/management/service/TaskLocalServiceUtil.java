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
 * Provides the local service utility for Task. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.TaskLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalService
 * @generated
 */
public class TaskLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.TaskLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.argus.oth.cases.management.model.Task addTask(
		long groupId, long caseId, String description, java.util.Date startDate,
		java.util.Date endDate, java.util.Date dueDate, long externalTaskId,
		String priority, String status, String randomString) {

		return getService().addTask(
			groupId, caseId, description, startDate, endDate, dueDate,
			externalTaskId, priority, status, randomString);
	}

	public static com.argus.oth.cases.management.model.Task addTask(
		String uuid, long groupId, long caseId, String description,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date dueDate, long externalTaskId, String priority,
		String status, String processStatus, String failureDescription,
		long createdUserId, String randomString) {

		return getService().addTask(
			uuid, groupId, caseId, description, startDate, endDate, dueDate,
			externalTaskId, priority, status, processStatus, failureDescription,
			createdUserId, randomString);
	}

	/**
	 * Adds the task to the database. Also notifies the appropriate model listeners.
	 *
	 * @param task the task
	 * @return the task that was added
	 */
	public static com.argus.oth.cases.management.model.Task addTask(
		com.argus.oth.cases.management.model.Task task) {

		return getService().addTask(task);
	}

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	public static com.argus.oth.cases.management.model.Task createTask(
		long taskId) {

		return getService().createTask(taskId);
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
	 * Deletes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws PortalException if a task with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Task deleteTask(
			long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTask(taskId);
	}

	/**
	 * Deletes the task from the database. Also notifies the appropriate model listeners.
	 *
	 * @param task the task
	 * @return the task that was removed
	 */
	public static com.argus.oth.cases.management.model.Task deleteTask(
		com.argus.oth.cases.management.model.Task task) {

		return getService().deleteTask(task);
	}

	public static void deleteUnprocessed(String randomString) {
		getService().deleteUnprocessed(randomString);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.TaskModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.TaskModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.Task fetchTask(
		long taskId) {

		return getService().fetchTask(taskId);
	}

	public static com.argus.oth.cases.management.model.Task
		fetchTaskByExternalTaskId(long externalTaskId) {

		return getService().fetchTaskByExternalTaskId(externalTaskId);
	}

	/**
	 * Returns the task matching the UUID and group.
	 *
	 * @param uuid the task's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task, or <code>null</code> if a matching task could not be found
	 */
	public static com.argus.oth.cases.management.model.Task
		fetchTaskByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchTaskByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Returns the task with the primary key.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws PortalException if a task with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Task getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTask(taskId);
	}

	/**
	 * Returns the task matching the UUID and group.
	 *
	 * @param uuid the task's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task
	 * @throws PortalException if a matching task could not be found
	 */
	public static com.argus.oth.cases.management.model.Task
			getTaskByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of tasks
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Task>
		getTasks(int start, int end) {

		return getService().getTasks(start, end);
	}

	public static java.util.List<com.argus.oth.cases.management.model.Task>
		getTasksByC_NotP(
			long caseId, String processStatus, int start, int end) {

		return getService().getTasksByC_NotP(caseId, processStatus, start, end);
	}

	public static java.util.List<com.argus.oth.cases.management.model.Task>
		getTasksByE_P(long externalTaskId, String processStatus) {

		return getService().getTasksByE_P(externalTaskId, processStatus);
	}

	/**
	 * Returns all the tasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the tasks
	 * @param companyId the primary key of the company
	 * @return the matching tasks, or an empty list if no matches were found
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Task>
		getTasksByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getTasksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of tasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the tasks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tasks, or an empty list if no matches were found
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Task>
		getTasksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.argus.oth.cases.management.model.Task> orderByComparator) {

		return getService().getTasksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	public static int getTasksCount() {
		return getService().getTasksCount();
	}

	public static com.argus.oth.cases.management.model.Task updateTask(
		long taskId, long externalTaskId, String processStatus,
		String failureDescription) {

		return getService().updateTask(
			taskId, externalTaskId, processStatus, failureDescription);
	}

	public static com.argus.oth.cases.management.model.Task updateTask(
		long taskId, String description, java.util.Date startDate,
		java.util.Date endDate, java.util.Date dueDate, String priority,
		String status, String processStatus) {

		return getService().updateTask(
			taskId, description, startDate, endDate, dueDate, priority, status,
			processStatus);
	}

	/**
	 * Updates the task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param task the task
	 * @return the task that was updated
	 */
	public static com.argus.oth.cases.management.model.Task updateTask(
		com.argus.oth.cases.management.model.Task task) {

		return getService().updateTask(task);
	}

	public static TaskLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskLocalService, TaskLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskLocalService.class);

		ServiceTracker<TaskLocalService, TaskLocalService> serviceTracker =
			new ServiceTracker<TaskLocalService, TaskLocalService>(
				bundle.getBundleContext(), TaskLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}