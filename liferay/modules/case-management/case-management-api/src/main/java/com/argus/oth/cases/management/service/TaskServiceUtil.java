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
 * Provides the remote service utility for Task. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.TaskServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskService
 * @generated
 */
public class TaskServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>TaskServiceUtil</code> to access the task remote service.
	 */
	public static com.liferay.portal.kernel.json.JSONObject addTask(
			String uuid, long groupId, long caseId, String descriptionKey,
			String startDateString, java.util.Date endDate,
			java.util.Date dueDate, long externalTaskId, String priorityKey,
			String status, String processStatus, String failureDescription,
			long createdUserId)
		throws Exception {

		return getService().addTask(
			uuid, groupId, caseId, descriptionKey, startDateString, endDate,
			dueDate, externalTaskId, priorityKey, status, processStatus,
			failureDescription, createdUserId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.argus.oth.cases.management.model.Task>
			getTasksByCaseId(long caseId, int start, int end)
		throws Exception {

		return getService().getTasksByCaseId(caseId, start, end);
	}

	public static TaskService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskService, TaskService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskService.class);

		ServiceTracker<TaskService, TaskService> serviceTracker =
			new ServiceTracker<TaskService, TaskService>(
				bundle.getBundleContext(), TaskService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}