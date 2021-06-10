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

import com.argus.oth.cases.management.model.StagingTask;
import com.argus.oth.cases.management.model.impl.StagingTaskModelImpl;
import com.argus.oth.cases.management.service.base.StagingTaskLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingTaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingTaskLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.StagingTask", service = AopService.class)
public class StagingTaskLocalServiceImpl extends StagingTaskLocalServiceBaseImpl {

	public void addStagingTask(
		long externalCaseId, String completedFlag, String description, String startDate, String endDate, String dueDate,
		String externalCreateDate, String externalModifiedDate, long externalTaskId, String priority, String status) {

		long id = counterLocalService.increment(StagingTask.class.getName());

		StagingTask task = createStagingTask(id);

		task.setExternalCaseId(externalCaseId);
		task.setCompletedFlag(completedFlag);
		task.setCreateDate(new Date());
		task.setDescription(description);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setDueDate(dueDate);
		task.setExternalCreateDate(externalCreateDate);
		task.setExternalModifiedDate(externalModifiedDate);
		task.setExternalTaskId(externalTaskId);
		task.setPriority(priority);
		task.setTaskStatus(status);

		addStagingTask(task);
	}

	public void deleteAllStagingTasks() {
		BulkHelper.bulkDeleteAll(stagingTaskPersistence.getCurrentSession(), StagingTaskModelImpl.TABLE_NAME);
	}

}