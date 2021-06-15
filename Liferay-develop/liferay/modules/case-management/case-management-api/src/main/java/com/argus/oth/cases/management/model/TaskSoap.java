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

package com.argus.oth.cases.management.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.argus.oth.cases.management.service.http.TaskServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskSoap implements Serializable {

	public static TaskSoap toSoapModel(Task model) {
		TaskSoap soapModel = new TaskSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedUserId(model.getCreatedUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCaseId(model.getCaseId());
		soapModel.setExternalTaskId(model.getExternalTaskId());
		soapModel.setPriority(model.getPriority());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setTaskStatus(model.getTaskStatus());
		soapModel.setDescription(model.getDescription());
		soapModel.setProcessStatus(model.getProcessStatus());
		soapModel.setFailureDescription(model.getFailureDescription());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static TaskSoap[] toSoapModels(Task[] models) {
		TaskSoap[] soapModels = new TaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskSoap[][] toSoapModels(Task[][] models) {
		TaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskSoap[] toSoapModels(List<Task> models) {
		List<TaskSoap> soapModels = new ArrayList<TaskSoap>(models.size());

		for (Task model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskSoap[soapModels.size()]);
	}

	public TaskSoap() {
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long pk) {
		setTaskId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedUserId() {
		return _createdUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		_createdUserId = createdUserId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCaseId() {
		return _caseId;
	}

	public void setCaseId(long caseId) {
		_caseId = caseId;
	}

	public long getExternalTaskId() {
		return _externalTaskId;
	}

	public void setExternalTaskId(long externalTaskId) {
		_externalTaskId = externalTaskId;
	}

	public String getPriority() {
		return _priority;
	}

	public void setPriority(String priority) {
		_priority = priority;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public String getTaskStatus() {
		return _taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		_taskStatus = taskStatus;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getProcessStatus() {
		return _processStatus;
	}

	public void setProcessStatus(String processStatus) {
		_processStatus = processStatus;
	}

	public String getFailureDescription() {
		return _failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		_failureDescription = failureDescription;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private String _uuid;
	private long _taskId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _createdUserId;
	private Date _modifiedDate;
	private long _caseId;
	private long _externalTaskId;
	private String _priority;
	private Date _startDate;
	private Date _endDate;
	private Date _dueDate;
	private String _taskStatus;
	private String _description;
	private String _processStatus;
	private String _failureDescription;
	private String _rowProcessed;

}