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
 * This class is a wrapper for {@link StagingClientGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientGroup
 * @generated
 */
public class StagingClientGroupWrapper
	extends BaseModelWrapper<StagingClientGroup>
	implements ModelWrapper<StagingClientGroup>, StagingClientGroup {

	public StagingClientGroupWrapper(StagingClientGroup stagingClientGroup) {
		super(stagingClientGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingClientGroupId", getStagingClientGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalClientGroupId", getExternalClientGroupId());
		attributes.put("clientId", getClientId());
		attributes.put("clientGroup", getClientGroup());
		attributes.put("clientGroupName", getClientGroupName());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingClientGroupId = (Long)attributes.get(
			"stagingClientGroupId");

		if (stagingClientGroupId != null) {
			setStagingClientGroupId(stagingClientGroupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalClientGroupId = (Long)attributes.get(
			"externalClientGroupId");

		if (externalClientGroupId != null) {
			setExternalClientGroupId(externalClientGroupId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientGroup = (String)attributes.get("clientGroup");

		if (clientGroup != null) {
			setClientGroup(clientGroup);
		}

		String clientGroupName = (String)attributes.get("clientGroupName");

		if (clientGroupName != null) {
			setClientGroupName(clientGroupName);
		}

		String externalModifiedDate = (String)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		String externalCreatedDate = (String)attributes.get(
			"externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}
	}

	/**
	 * Returns the client group of this staging client group.
	 *
	 * @return the client group of this staging client group
	 */
	@Override
	public String getClientGroup() {
		return model.getClientGroup();
	}

	/**
	 * Returns the client group name of this staging client group.
	 *
	 * @return the client group name of this staging client group
	 */
	@Override
	public String getClientGroupName() {
		return model.getClientGroupName();
	}

	/**
	 * Returns the client ID of this staging client group.
	 *
	 * @return the client ID of this staging client group
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the create date of this staging client group.
	 *
	 * @return the create date of this staging client group
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external client group ID of this staging client group.
	 *
	 * @return the external client group ID of this staging client group
	 */
	@Override
	public long getExternalClientGroupId() {
		return model.getExternalClientGroupId();
	}

	/**
	 * Returns the external created date of this staging client group.
	 *
	 * @return the external created date of this staging client group
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this staging client group.
	 *
	 * @return the external modified date of this staging client group
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the modified date of this staging client group.
	 *
	 * @return the modified date of this staging client group
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this staging client group.
	 *
	 * @return the primary key of this staging client group
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the staging client group ID of this staging client group.
	 *
	 * @return the staging client group ID of this staging client group
	 */
	@Override
	public long getStagingClientGroupId() {
		return model.getStagingClientGroupId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the client group of this staging client group.
	 *
	 * @param clientGroup the client group of this staging client group
	 */
	@Override
	public void setClientGroup(String clientGroup) {
		model.setClientGroup(clientGroup);
	}

	/**
	 * Sets the client group name of this staging client group.
	 *
	 * @param clientGroupName the client group name of this staging client group
	 */
	@Override
	public void setClientGroupName(String clientGroupName) {
		model.setClientGroupName(clientGroupName);
	}

	/**
	 * Sets the client ID of this staging client group.
	 *
	 * @param clientId the client ID of this staging client group
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the create date of this staging client group.
	 *
	 * @param createDate the create date of this staging client group
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external client group ID of this staging client group.
	 *
	 * @param externalClientGroupId the external client group ID of this staging client group
	 */
	@Override
	public void setExternalClientGroupId(long externalClientGroupId) {
		model.setExternalClientGroupId(externalClientGroupId);
	}

	/**
	 * Sets the external created date of this staging client group.
	 *
	 * @param externalCreatedDate the external created date of this staging client group
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this staging client group.
	 *
	 * @param externalModifiedDate the external modified date of this staging client group
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the modified date of this staging client group.
	 *
	 * @param modifiedDate the modified date of this staging client group
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this staging client group.
	 *
	 * @param primaryKey the primary key of this staging client group
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the staging client group ID of this staging client group.
	 *
	 * @param stagingClientGroupId the staging client group ID of this staging client group
	 */
	@Override
	public void setStagingClientGroupId(long stagingClientGroupId) {
		model.setStagingClientGroupId(stagingClientGroupId);
	}

	@Override
	protected StagingClientGroupWrapper wrap(
		StagingClientGroup stagingClientGroup) {

		return new StagingClientGroupWrapper(stagingClientGroup);
	}

}