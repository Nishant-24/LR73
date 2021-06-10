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

package com.argus.oth.cases.management.model.impl;

import com.argus.oth.cases.management.model.Task;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Task in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskCacheModel implements CacheModel<Task>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskCacheModel)) {
			return false;
		}

		TaskCacheModel taskCacheModel = (TaskCacheModel)object;

		if (taskId == taskCacheModel.taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdUserId=");
		sb.append(createdUserId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", caseId=");
		sb.append(caseId);
		sb.append(", externalTaskId=");
		sb.append(externalTaskId);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", taskStatus=");
		sb.append(taskStatus);
		sb.append(", description=");
		sb.append(description);
		sb.append(", processStatus=");
		sb.append(processStatus);
		sb.append(", failureDescription=");
		sb.append(failureDescription);
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Task toEntityModel() {
		TaskImpl taskImpl = new TaskImpl();

		if (uuid == null) {
			taskImpl.setUuid("");
		}
		else {
			taskImpl.setUuid(uuid);
		}

		taskImpl.setTaskId(taskId);
		taskImpl.setGroupId(groupId);
		taskImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			taskImpl.setCreateDate(null);
		}
		else {
			taskImpl.setCreateDate(new Date(createDate));
		}

		taskImpl.setCreatedUserId(createdUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			taskImpl.setModifiedDate(null);
		}
		else {
			taskImpl.setModifiedDate(new Date(modifiedDate));
		}

		taskImpl.setCaseId(caseId);
		taskImpl.setExternalTaskId(externalTaskId);

		if (priority == null) {
			taskImpl.setPriority("");
		}
		else {
			taskImpl.setPriority(priority);
		}

		if (startDate == Long.MIN_VALUE) {
			taskImpl.setStartDate(null);
		}
		else {
			taskImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			taskImpl.setEndDate(null);
		}
		else {
			taskImpl.setEndDate(new Date(endDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			taskImpl.setDueDate(null);
		}
		else {
			taskImpl.setDueDate(new Date(dueDate));
		}

		if (taskStatus == null) {
			taskImpl.setTaskStatus("");
		}
		else {
			taskImpl.setTaskStatus(taskStatus);
		}

		if (description == null) {
			taskImpl.setDescription("");
		}
		else {
			taskImpl.setDescription(description);
		}

		if (processStatus == null) {
			taskImpl.setProcessStatus("");
		}
		else {
			taskImpl.setProcessStatus(processStatus);
		}

		if (failureDescription == null) {
			taskImpl.setFailureDescription("");
		}
		else {
			taskImpl.setFailureDescription(failureDescription);
		}

		if (rowProcessed == null) {
			taskImpl.setRowProcessed("");
		}
		else {
			taskImpl.setRowProcessed(rowProcessed);
		}

		taskImpl.resetOriginalValues();

		return taskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		taskId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdUserId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		caseId = objectInput.readLong();

		externalTaskId = objectInput.readLong();
		priority = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		dueDate = objectInput.readLong();
		taskStatus = objectInput.readUTF();
		description = objectInput.readUTF();
		processStatus = objectInput.readUTF();
		failureDescription = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(taskId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdUserId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(caseId);

		objectOutput.writeLong(externalTaskId);

		if (priority == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(priority);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(dueDate);

		if (taskStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taskStatus);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (processStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processStatus);
		}

		if (failureDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(failureDescription);
		}

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public String uuid;
	public long taskId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdUserId;
	public long modifiedDate;
	public long caseId;
	public long externalTaskId;
	public String priority;
	public long startDate;
	public long endDate;
	public long dueDate;
	public String taskStatus;
	public String description;
	public String processStatus;
	public String failureDescription;
	public String rowProcessed;

}