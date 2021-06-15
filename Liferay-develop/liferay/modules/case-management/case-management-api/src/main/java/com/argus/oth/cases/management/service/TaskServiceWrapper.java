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
 * Provides a wrapper for {@link TaskService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskService
 * @generated
 */
public class TaskServiceWrapper
	implements ServiceWrapper<TaskService>, TaskService {

	public TaskServiceWrapper(TaskService taskService) {
		_taskService = taskService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>TaskServiceUtil</code> to access the task remote service.
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject addTask(
			String uuid, long groupId, long caseId, String descriptionKey,
			String startDateString, java.util.Date endDate,
			java.util.Date dueDate, long externalTaskId, String priorityKey,
			String status, String processStatus, String failureDescription,
			long createdUserId)
		throws Exception {

		return _taskService.addTask(
			uuid, groupId, caseId, descriptionKey, startDateString, endDate,
			dueDate, externalTaskId, priorityKey, status, processStatus,
			failureDescription, createdUserId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Task>
			getTasksByCaseId(long caseId, int start, int end)
		throws Exception {

		return _taskService.getTasksByCaseId(caseId, start, end);
	}

	@Override
	public TaskService getWrappedService() {
		return _taskService;
	}

	@Override
	public void setWrappedService(TaskService taskService) {
		_taskService = taskService;
	}

	private TaskService _taskService;

}