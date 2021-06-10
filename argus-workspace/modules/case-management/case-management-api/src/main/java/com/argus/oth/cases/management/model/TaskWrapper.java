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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
public class TaskWrapper
	extends BaseModelWrapper<Task> implements ModelWrapper<Task>, Task {

	public TaskWrapper(Task task) {
		super(task);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdUserId", getCreatedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("caseId", getCaseId());
		attributes.put("externalTaskId", getExternalTaskId());
		attributes.put("priority", getPriority());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("taskStatus", getTaskStatus());
		attributes.put("description", getDescription());
		attributes.put("processStatus", getProcessStatus());
		attributes.put("failureDescription", getFailureDescription());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdUserId = (Long)attributes.get("createdUserId");

		if (createdUserId != null) {
			setCreatedUserId(createdUserId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
		}

		Long externalTaskId = (Long)attributes.get("externalTaskId");

		if (externalTaskId != null) {
			setExternalTaskId(externalTaskId);
		}

		String priority = (String)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String taskStatus = (String)attributes.get("taskStatus");

		if (taskStatus != null) {
			setTaskStatus(taskStatus);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String processStatus = (String)attributes.get("processStatus");

		if (processStatus != null) {
			setProcessStatus(processStatus);
		}

		String failureDescription = (String)attributes.get(
			"failureDescription");

		if (failureDescription != null) {
			setFailureDescription(failureDescription);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the case ID of this task.
	 *
	 * @return the case ID of this task
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the company ID of this task.
	 *
	 * @return the company ID of this task
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this task.
	 *
	 * @return the create date of this task
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created user ID of this task.
	 *
	 * @return the created user ID of this task
	 */
	@Override
	public long getCreatedUserId() {
		return model.getCreatedUserId();
	}

	/**
	 * Returns the created user uuid of this task.
	 *
	 * @return the created user uuid of this task
	 */
	@Override
	public String getCreatedUserUuid() {
		return model.getCreatedUserUuid();
	}

	/**
	 * Returns the description of this task.
	 *
	 * @return the description of this task
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the due date of this task.
	 *
	 * @return the due date of this task
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the end date of this task.
	 *
	 * @return the end date of this task
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the external task ID of this task.
	 *
	 * @return the external task ID of this task
	 */
	@Override
	public long getExternalTaskId() {
		return model.getExternalTaskId();
	}

	/**
	 * Returns the failure description of this task.
	 *
	 * @return the failure description of this task
	 */
	@Override
	public String getFailureDescription() {
		return model.getFailureDescription();
	}

	/**
	 * Returns the group ID of this task.
	 *
	 * @return the group ID of this task
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this task.
	 *
	 * @return the modified date of this task
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this task.
	 *
	 * @return the primary key of this task
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this task.
	 *
	 * @return the priority of this task
	 */
	@Override
	public String getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the process status of this task.
	 *
	 * @return the process status of this task
	 */
	@Override
	public String getProcessStatus() {
		return model.getProcessStatus();
	}

	/**
	 * Returns the row processed of this task.
	 *
	 * @return the row processed of this task
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the start date of this task.
	 *
	 * @return the start date of this task
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the task ID of this task.
	 *
	 * @return the task ID of this task
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the task status of this task.
	 *
	 * @return the task status of this task
	 */
	@Override
	public String getTaskStatus() {
		return model.getTaskStatus();
	}

	/**
	 * Returns the uuid of this task.
	 *
	 * @return the uuid of this task
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the case ID of this task.
	 *
	 * @param caseId the case ID of this task
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the company ID of this task.
	 *
	 * @param companyId the company ID of this task
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this task.
	 *
	 * @param createDate the create date of this task
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created user ID of this task.
	 *
	 * @param createdUserId the created user ID of this task
	 */
	@Override
	public void setCreatedUserId(long createdUserId) {
		model.setCreatedUserId(createdUserId);
	}

	/**
	 * Sets the created user uuid of this task.
	 *
	 * @param createdUserUuid the created user uuid of this task
	 */
	@Override
	public void setCreatedUserUuid(String createdUserUuid) {
		model.setCreatedUserUuid(createdUserUuid);
	}

	/**
	 * Sets the description of this task.
	 *
	 * @param description the description of this task
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the due date of this task.
	 *
	 * @param dueDate the due date of this task
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the end date of this task.
	 *
	 * @param endDate the end date of this task
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the external task ID of this task.
	 *
	 * @param externalTaskId the external task ID of this task
	 */
	@Override
	public void setExternalTaskId(long externalTaskId) {
		model.setExternalTaskId(externalTaskId);
	}

	/**
	 * Sets the failure description of this task.
	 *
	 * @param failureDescription the failure description of this task
	 */
	@Override
	public void setFailureDescription(String failureDescription) {
		model.setFailureDescription(failureDescription);
	}

	/**
	 * Sets the group ID of this task.
	 *
	 * @param groupId the group ID of this task
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this task.
	 *
	 * @param modifiedDate the modified date of this task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this task.
	 *
	 * @param primaryKey the primary key of this task
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this task.
	 *
	 * @param priority the priority of this task
	 */
	@Override
	public void setPriority(String priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the process status of this task.
	 *
	 * @param processStatus the process status of this task
	 */
	@Override
	public void setProcessStatus(String processStatus) {
		model.setProcessStatus(processStatus);
	}

	/**
	 * Sets the row processed of this task.
	 *
	 * @param rowProcessed the row processed of this task
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the start date of this task.
	 *
	 * @param startDate the start date of this task
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the task ID of this task.
	 *
	 * @param taskId the task ID of this task
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the task status of this task.
	 *
	 * @param taskStatus the task status of this task
	 */
	@Override
	public void setTaskStatus(String taskStatus) {
		model.setTaskStatus(taskStatus);
	}

	/**
	 * Sets the uuid of this task.
	 *
	 * @param uuid the uuid of this task
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TaskWrapper wrap(Task task) {
		return new TaskWrapper(task);
	}

}