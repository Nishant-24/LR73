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

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Task;
import com.argus.oth.cases.management.model.impl.TaskModelImpl;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.base.TaskLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.TaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Task", service = AopService.class)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	public Task addTask(
		long groupId, long caseId, String description, Date startDate, Date endDate, Date dueDate, long externalTaskId,
		String priority, String status, String randomString) {

		return addTask(
			null, groupId, caseId, description, startDate, endDate, dueDate, externalTaskId, priority, status,
			ProcessStatusType.SUCCESS.toString(), StringPool.BLANK, 0, randomString);
	}

	public Task addTask(
		String uuid, long groupId, long caseId, String description, Date startDate, Date endDate, Date dueDate,
		long externalTaskId, String priority, String status, String processStatus, String failureDescription,
		long createdUserId, String randomString) {

		long id = counterLocalService.increment(Task.class.getName());

		Task task = createTask(id);

		if (!Validator.isBlank(uuid)) {
			task.setUuid(uuid);
		}

		Group group = groupLocalService.fetchGroup(groupId);

		if (Objects.nonNull(group)) {
			task.setCompanyId(group.getCompanyId());
		}

		task.setGroupId(groupId);
		task.setCaseId(caseId);
		task.setCreateDate(new Date());
		task.setCreatedUserId(createdUserId);
		task.setDescription(description);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setDueDate(dueDate);
		task.setExternalTaskId(externalTaskId);
		task.setPriority(priority);
		task.setTaskStatus(status);
		task.setProcessStatus(processStatus);
		task.setFailureDescription(failureDescription);
		task.setRowProcessed(randomString);

		task = addTask(task);

		try {
			User dataAdminUser = _userLocalService.fetchUserByScreenName(
				task.getCompanyId(), OTHConstants.DATA_ADMIN_USER_SCREEN_NAME);

			resourceLocalService.addResources(
				task.getCompanyId(), task.getGroupId(), dataAdminUser.getUserId(), Task.class.getName(), id, false,
				true, true);
		}
		catch (Exception e) {
			_log.error(e);
		}

		return task;
	}

	@Override
	public Task deleteTask(long taskId) throws PortalException {
		Task task = taskPersistence.fetchByPrimaryKey(taskId);

		return deleteTask(task);
	}

	@Override
	public Task deleteTask(Task task) {
		if (Objects.nonNull(task)) {
			_removeResources(task);
		}

		return super.deleteTask(task);
	}

	public void deleteUnprocessed(String randomString) {
		BulkHelper.bulkDelete(
			taskPersistence.getCurrentSession(), TaskModelImpl.TABLE_NAME, randomString,
			ProcessStatusType.FAILURE.name());
	}

	public Task fetchTaskByExternalTaskId(long externalTaskId) {
		return taskPersistence.fetchByExternalTaskId(externalTaskId);
	}

	public List<Task> getTasksByC_NotP(long caseId, String processStatus, int start, int end) {
		if ((start == 0) && (end == 0)) {
			return taskPersistence.findByC_NotP(caseId, processStatus);
		}

		return taskPersistence.findByC_NotP(caseId, processStatus, start, end);
	}

	public List<Task> getTasksByE_P(long externalTaskId, String processStatus) {
		return taskPersistence.findByE_P(externalTaskId, processStatus);
	}

	public Task updateTask(long taskId, long externalTaskId, String processStatus, String failureDescription) {
		Task task = taskPersistence.fetchByPrimaryKey(taskId);

		if (Objects.isNull(task)) {
			return null;
		}

		task.setExternalTaskId(externalTaskId);
		task.setProcessStatus(processStatus);
		task.setFailureDescription(failureDescription);
		task.setRowProcessed(PwdGenerator.getPassword(8));

		return taskPersistence.update(task);
	}

	public Task updateTask(
		long taskId, String description, Date startDate, Date endDate, Date dueDate, String priority, String status,
		String processStatus) {

		Task task = taskPersistence.fetchByPrimaryKey(taskId);

		if (Objects.isNull(task)) {
			return null;
		}

		task.setDescription(description);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setDueDate(dueDate);
		task.setPriority(priority);
		task.setTaskStatus(status);
		task.setProcessStatus(processStatus);
		task.setRowProcessed(PwdGenerator.getPassword(8));

		return taskPersistence.update(task);
	}

	private void _removeResources(Task task) {
		try {
			resourceLocalService.deleteResource(
				task.getCompanyId(), Task.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, task.getTaskId());
		}
		catch (PortalException pe) {
			_log.warn(pe.getMessage(), pe);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(TaskLocalServiceImpl.class);

	@Reference
	private UserLocalService _userLocalService;

}