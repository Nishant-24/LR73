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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StagingTask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingTask
 * @generated
 */
public class StagingTaskWrapper
	extends BaseModelWrapper<StagingTask>
	implements ModelWrapper<StagingTask>, StagingTask {

	public StagingTaskWrapper(StagingTask stagingTask) {
		super(stagingTask);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("externalTaskId", getExternalTaskId());
		attributes.put("priority", getPriority());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("taskStatus", getTaskStatus());
		attributes.put("description", getDescription());
		attributes.put("completedFlag", getCompletedFlag());
		attributes.put("externalCreateDate", getExternalCreateDate());
		attributes.put("externalModifiedDate", getExternalModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		Long externalTaskId = (Long)attributes.get("externalTaskId");

		if (externalTaskId != null) {
			setExternalTaskId(externalTaskId);
		}

		String priority = (String)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String startDate = (String)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String dueDate = (String)attributes.get("dueDate");

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

		String completedFlag = (String)attributes.get("completedFlag");

		if (completedFlag != null) {
			setCompletedFlag(completedFlag);
		}

		String externalCreateDate = (String)attributes.get(
			"externalCreateDate");

		if (externalCreateDate != null) {
			setExternalCreateDate(externalCreateDate);
		}

		String externalModifiedDate = (String)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}
	}

	/**
	 * Returns the completed flag of this staging task.
	 *
	 * @return the completed flag of this staging task
	 */
	@Override
	public String getCompletedFlag() {
		return model.getCompletedFlag();
	}

	/**
	 * Returns the create date of this staging task.
	 *
	 * @return the create date of this staging task
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this staging task.
	 *
	 * @return the description of this staging task
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the due date of this staging task.
	 *
	 * @return the due date of this staging task
	 */
	@Override
	public String getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the end date of this staging task.
	 *
	 * @return the end date of this staging task
	 */
	@Override
	public String getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the external case ID of this staging task.
	 *
	 * @return the external case ID of this staging task
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the external create date of this staging task.
	 *
	 * @return the external create date of this staging task
	 */
	@Override
	public String getExternalCreateDate() {
		return model.getExternalCreateDate();
	}

	/**
	 * Returns the external modified date of this staging task.
	 *
	 * @return the external modified date of this staging task
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the external task ID of this staging task.
	 *
	 * @return the external task ID of this staging task
	 */
	@Override
	public long getExternalTaskId() {
		return model.getExternalTaskId();
	}

	/**
	 * Returns the modified date of this staging task.
	 *
	 * @return the modified date of this staging task
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this staging task.
	 *
	 * @return the primary key of this staging task
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this staging task.
	 *
	 * @return the priority of this staging task
	 */
	@Override
	public String getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the start date of this staging task.
	 *
	 * @return the start date of this staging task
	 */
	@Override
	public String getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the task ID of this staging task.
	 *
	 * @return the task ID of this staging task
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the task status of this staging task.
	 *
	 * @return the task status of this staging task
	 */
	@Override
	public String getTaskStatus() {
		return model.getTaskStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the completed flag of this staging task.
	 *
	 * @param completedFlag the completed flag of this staging task
	 */
	@Override
	public void setCompletedFlag(String completedFlag) {
		model.setCompletedFlag(completedFlag);
	}

	/**
	 * Sets the create date of this staging task.
	 *
	 * @param createDate the create date of this staging task
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this staging task.
	 *
	 * @param description the description of this staging task
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the due date of this staging task.
	 *
	 * @param dueDate the due date of this staging task
	 */
	@Override
	public void setDueDate(String dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the end date of this staging task.
	 *
	 * @param endDate the end date of this staging task
	 */
	@Override
	public void setEndDate(String endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the external case ID of this staging task.
	 *
	 * @param externalCaseId the external case ID of this staging task
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the external create date of this staging task.
	 *
	 * @param externalCreateDate the external create date of this staging task
	 */
	@Override
	public void setExternalCreateDate(String externalCreateDate) {
		model.setExternalCreateDate(externalCreateDate);
	}

	/**
	 * Sets the external modified date of this staging task.
	 *
	 * @param externalModifiedDate the external modified date of this staging task
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the external task ID of this staging task.
	 *
	 * @param externalTaskId the external task ID of this staging task
	 */
	@Override
	public void setExternalTaskId(long externalTaskId) {
		model.setExternalTaskId(externalTaskId);
	}

	/**
	 * Sets the modified date of this staging task.
	 *
	 * @param modifiedDate the modified date of this staging task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this staging task.
	 *
	 * @param primaryKey the primary key of this staging task
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this staging task.
	 *
	 * @param priority the priority of this staging task
	 */
	@Override
	public void setPriority(String priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the start date of this staging task.
	 *
	 * @param startDate the start date of this staging task
	 */
	@Override
	public void setStartDate(String startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the task ID of this staging task.
	 *
	 * @param taskId the task ID of this staging task
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the task status of this staging task.
	 *
	 * @param taskStatus the task status of this staging task
	 */
	@Override
	public void setTaskStatus(String taskStatus) {
		model.setTaskStatus(taskStatus);
	}

	@Override
	protected StagingTaskWrapper wrap(StagingTask stagingTask) {
		return new StagingTaskWrapper(stagingTask);
	}

}