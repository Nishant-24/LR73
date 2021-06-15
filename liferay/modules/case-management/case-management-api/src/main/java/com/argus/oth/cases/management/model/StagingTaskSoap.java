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
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingTaskSoap implements Serializable {

	public static StagingTaskSoap toSoapModel(StagingTask model) {
		StagingTaskSoap soapModel = new StagingTaskSoap();

		soapModel.setTaskId(model.getTaskId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setExternalTaskId(model.getExternalTaskId());
		soapModel.setPriority(model.getPriority());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setTaskStatus(model.getTaskStatus());
		soapModel.setDescription(model.getDescription());
		soapModel.setCompletedFlag(model.getCompletedFlag());
		soapModel.setExternalCreateDate(model.getExternalCreateDate());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());

		return soapModel;
	}

	public static StagingTaskSoap[] toSoapModels(StagingTask[] models) {
		StagingTaskSoap[] soapModels = new StagingTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingTaskSoap[][] toSoapModels(StagingTask[][] models) {
		StagingTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StagingTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingTaskSoap[] toSoapModels(List<StagingTask> models) {
		List<StagingTaskSoap> soapModels = new ArrayList<StagingTaskSoap>(
			models.size());

		for (StagingTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StagingTaskSoap[soapModels.size()]);
	}

	public StagingTaskSoap() {
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long pk) {
		setTaskId(pk);
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
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

	public String getStartDate() {
		return _startDate;
	}

	public void setStartDate(String startDate) {
		_startDate = startDate;
	}

	public String getEndDate() {
		return _endDate;
	}

	public void setEndDate(String endDate) {
		_endDate = endDate;
	}

	public String getDueDate() {
		return _dueDate;
	}

	public void setDueDate(String dueDate) {
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

	public String getCompletedFlag() {
		return _completedFlag;
	}

	public void setCompletedFlag(String completedFlag) {
		_completedFlag = completedFlag;
	}

	public String getExternalCreateDate() {
		return _externalCreateDate;
	}

	public void setExternalCreateDate(String externalCreateDate) {
		_externalCreateDate = externalCreateDate;
	}

	public String getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(String externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	private long _taskId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalCaseId;
	private long _externalTaskId;
	private String _priority;
	private String _startDate;
	private String _endDate;
	private String _dueDate;
	private String _taskStatus;
	private String _description;
	private String _completedFlag;
	private String _externalCreateDate;
	private String _externalModifiedDate;

}