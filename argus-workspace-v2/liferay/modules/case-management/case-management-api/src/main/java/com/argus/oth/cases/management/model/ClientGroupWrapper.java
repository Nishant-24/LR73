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
 * This class is a wrapper for {@link ClientGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientGroup
 * @generated
 */
public class ClientGroupWrapper
	extends BaseModelWrapper<ClientGroup>
	implements ClientGroup, ModelWrapper<ClientGroup> {

	public ClientGroupWrapper(ClientGroup clientGroup) {
		super(clientGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientGroupId", getClientGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalClientGroupId", getExternalClientGroupId());
		attributes.put("clientId", getClientId());
		attributes.put("clientGroup", getClientGroup());
		attributes.put("clientGroupName", getClientGroupName());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientGroupId = (Long)attributes.get("clientGroupId");

		if (clientGroupId != null) {
			setClientGroupId(clientGroupId);
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

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the client group of this client group.
	 *
	 * @return the client group of this client group
	 */
	@Override
	public String getClientGroup() {
		return model.getClientGroup();
	}

	/**
	 * Returns the client group ID of this client group.
	 *
	 * @return the client group ID of this client group
	 */
	@Override
	public long getClientGroupId() {
		return model.getClientGroupId();
	}

	/**
	 * Returns the client group name of this client group.
	 *
	 * @return the client group name of this client group
	 */
	@Override
	public String getClientGroupName() {
		return model.getClientGroupName();
	}

	/**
	 * Returns the client ID of this client group.
	 *
	 * @return the client ID of this client group
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the company ID of this client group.
	 *
	 * @return the company ID of this client group
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this client group.
	 *
	 * @return the create date of this client group
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external client group ID of this client group.
	 *
	 * @return the external client group ID of this client group
	 */
	@Override
	public long getExternalClientGroupId() {
		return model.getExternalClientGroupId();
	}

	/**
	 * Returns the group ID of this client group.
	 *
	 * @return the group ID of this client group
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this client group.
	 *
	 * @return the modified date of this client group
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this client group.
	 *
	 * @return the primary key of this client group
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the row processed of this client group.
	 *
	 * @return the row processed of this client group
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the client group of this client group.
	 *
	 * @param clientGroup the client group of this client group
	 */
	@Override
	public void setClientGroup(String clientGroup) {
		model.setClientGroup(clientGroup);
	}

	/**
	 * Sets the client group ID of this client group.
	 *
	 * @param clientGroupId the client group ID of this client group
	 */
	@Override
	public void setClientGroupId(long clientGroupId) {
		model.setClientGroupId(clientGroupId);
	}

	/**
	 * Sets the client group name of this client group.
	 *
	 * @param clientGroupName the client group name of this client group
	 */
	@Override
	public void setClientGroupName(String clientGroupName) {
		model.setClientGroupName(clientGroupName);
	}

	/**
	 * Sets the client ID of this client group.
	 *
	 * @param clientId the client ID of this client group
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the company ID of this client group.
	 *
	 * @param companyId the company ID of this client group
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this client group.
	 *
	 * @param createDate the create date of this client group
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external client group ID of this client group.
	 *
	 * @param externalClientGroupId the external client group ID of this client group
	 */
	@Override
	public void setExternalClientGroupId(long externalClientGroupId) {
		model.setExternalClientGroupId(externalClientGroupId);
	}

	/**
	 * Sets the group ID of this client group.
	 *
	 * @param groupId the group ID of this client group
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this client group.
	 *
	 * @param modifiedDate the modified date of this client group
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this client group.
	 *
	 * @param primaryKey the primary key of this client group
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the row processed of this client group.
	 *
	 * @param rowProcessed the row processed of this client group
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	@Override
	protected ClientGroupWrapper wrap(ClientGroup clientGroup) {
		return new ClientGroupWrapper(clientGroup);
	}

}