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

import com.argus.oth.cases.management.model.StagingTask;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingTaskCacheModel
	implements CacheModel<StagingTask>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingTaskCacheModel)) {
			return false;
		}

		StagingTaskCacheModel stagingTaskCacheModel =
			(StagingTaskCacheModel)object;

		if (taskId == stagingTaskCacheModel.taskId) {
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
		StringBundler sb = new StringBundler(29);

		sb.append("{taskId=");
		sb.append(taskId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
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
		sb.append(", completedFlag=");
		sb.append(completedFlag);
		sb.append(", externalCreateDate=");
		sb.append(externalCreateDate);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingTask toEntityModel() {
		StagingTaskImpl stagingTaskImpl = new StagingTaskImpl();

		stagingTaskImpl.setTaskId(taskId);

		if (createDate == Long.MIN_VALUE) {
			stagingTaskImpl.setCreateDate(null);
		}
		else {
			stagingTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingTaskImpl.setModifiedDate(null);
		}
		else {
			stagingTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingTaskImpl.setExternalCaseId(externalCaseId);
		stagingTaskImpl.setExternalTaskId(externalTaskId);

		if (priority == null) {
			stagingTaskImpl.setPriority("");
		}
		else {
			stagingTaskImpl.setPriority(priority);
		}

		if (startDate == null) {
			stagingTaskImpl.setStartDate("");
		}
		else {
			stagingTaskImpl.setStartDate(startDate);
		}

		if (endDate == null) {
			stagingTaskImpl.setEndDate("");
		}
		else {
			stagingTaskImpl.setEndDate(endDate);
		}

		if (dueDate == null) {
			stagingTaskImpl.setDueDate("");
		}
		else {
			stagingTaskImpl.setDueDate(dueDate);
		}

		if (taskStatus == null) {
			stagingTaskImpl.setTaskStatus("");
		}
		else {
			stagingTaskImpl.setTaskStatus(taskStatus);
		}

		if (description == null) {
			stagingTaskImpl.setDescription("");
		}
		else {
			stagingTaskImpl.setDescription(description);
		}

		if (completedFlag == null) {
			stagingTaskImpl.setCompletedFlag("");
		}
		else {
			stagingTaskImpl.setCompletedFlag(completedFlag);
		}

		if (externalCreateDate == null) {
			stagingTaskImpl.setExternalCreateDate("");
		}
		else {
			stagingTaskImpl.setExternalCreateDate(externalCreateDate);
		}

		if (externalModifiedDate == null) {
			stagingTaskImpl.setExternalModifiedDate("");
		}
		else {
			stagingTaskImpl.setExternalModifiedDate(externalModifiedDate);
		}

		stagingTaskImpl.resetOriginalValues();

		return stagingTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalCaseId = objectInput.readLong();

		externalTaskId = objectInput.readLong();
		priority = objectInput.readUTF();
		startDate = objectInput.readUTF();
		endDate = objectInput.readUTF();
		dueDate = objectInput.readUTF();
		taskStatus = objectInput.readUTF();
		description = objectInput.readUTF();
		completedFlag = objectInput.readUTF();
		externalCreateDate = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taskId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalCaseId);

		objectOutput.writeLong(externalTaskId);

		if (priority == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(priority);
		}

		if (startDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startDate);
		}

		if (endDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endDate);
		}

		if (dueDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dueDate);
		}

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

		if (completedFlag == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(completedFlag);
		}

		if (externalCreateDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCreateDate);
		}

		if (externalModifiedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalModifiedDate);
		}
	}

	public long taskId;
	public long createDate;
	public long modifiedDate;
	public long externalCaseId;
	public long externalTaskId;
	public String priority;
	public String startDate;
	public String endDate;
	public String dueDate;
	public String taskStatus;
	public String description;
	public String completedFlag;
	public String externalCreateDate;
	public String externalModifiedDate;

}