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
 * This class is a wrapper for {@link Client}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Client
 * @generated
 */
public class ClientWrapper
	extends BaseModelWrapper<Client> implements Client, ModelWrapper<Client> {

	public ClientWrapper(Client client) {
		super(client);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientId", getClientId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalClientPk", getExternalClientPk());
		attributes.put("externalClientId", getExternalClientId());
		attributes.put("clientName", getClientName());
		attributes.put("telephonyNumber", getTelephonyNumber());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
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

		Long externalClientPk = (Long)attributes.get("externalClientPk");

		if (externalClientPk != null) {
			setExternalClientPk(externalClientPk);
		}

		Long externalClientId = (Long)attributes.get("externalClientId");

		if (externalClientId != null) {
			setExternalClientId(externalClientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String telephonyNumber = (String)attributes.get("telephonyNumber");

		if (telephonyNumber != null) {
			setTelephonyNumber(telephonyNumber);
		}

		Date externalModifiedDate = (Date)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		Date externalCreatedDate = (Date)attributes.get("externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the client ID of this client.
	 *
	 * @return the client ID of this client
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the client name of this client.
	 *
	 * @return the client name of this client
	 */
	@Override
	public String getClientName() {
		return model.getClientName();
	}

	/**
	 * Returns the company ID of this client.
	 *
	 * @return the company ID of this client
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this client.
	 *
	 * @return the create date of this client
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external client ID of this client.
	 *
	 * @return the external client ID of this client
	 */
	@Override
	public long getExternalClientId() {
		return model.getExternalClientId();
	}

	/**
	 * Returns the external client pk of this client.
	 *
	 * @return the external client pk of this client
	 */
	@Override
	public long getExternalClientPk() {
		return model.getExternalClientPk();
	}

	/**
	 * Returns the external created date of this client.
	 *
	 * @return the external created date of this client
	 */
	@Override
	public Date getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this client.
	 *
	 * @return the external modified date of this client
	 */
	@Override
	public Date getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the group ID of this client.
	 *
	 * @return the group ID of this client
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this client.
	 *
	 * @return the modified date of this client
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this client.
	 *
	 * @return the primary key of this client
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the row processed of this client.
	 *
	 * @return the row processed of this client
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the telephony number of this client.
	 *
	 * @return the telephony number of this client
	 */
	@Override
	public String getTelephonyNumber() {
		return model.getTelephonyNumber();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the client ID of this client.
	 *
	 * @param clientId the client ID of this client
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the client name of this client.
	 *
	 * @param clientName the client name of this client
	 */
	@Override
	public void setClientName(String clientName) {
		model.setClientName(clientName);
	}

	/**
	 * Sets the company ID of this client.
	 *
	 * @param companyId the company ID of this client
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this client.
	 *
	 * @param createDate the create date of this client
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external client ID of this client.
	 *
	 * @param externalClientId the external client ID of this client
	 */
	@Override
	public void setExternalClientId(long externalClientId) {
		model.setExternalClientId(externalClientId);
	}

	/**
	 * Sets the external client pk of this client.
	 *
	 * @param externalClientPk the external client pk of this client
	 */
	@Override
	public void setExternalClientPk(long externalClientPk) {
		model.setExternalClientPk(externalClientPk);
	}

	/**
	 * Sets the external created date of this client.
	 *
	 * @param externalCreatedDate the external created date of this client
	 */
	@Override
	public void setExternalCreatedDate(Date externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this client.
	 *
	 * @param externalModifiedDate the external modified date of this client
	 */
	@Override
	public void setExternalModifiedDate(Date externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the group ID of this client.
	 *
	 * @param groupId the group ID of this client
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this client.
	 *
	 * @param modifiedDate the modified date of this client
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this client.
	 *
	 * @param primaryKey the primary key of this client
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the row processed of this client.
	 *
	 * @param rowProcessed the row processed of this client
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the telephony number of this client.
	 *
	 * @param telephonyNumber the telephony number of this client
	 */
	@Override
	public void setTelephonyNumber(String telephonyNumber) {
		model.setTelephonyNumber(telephonyNumber);
	}

	@Override
	protected ClientWrapper wrap(Client client) {
		return new ClientWrapper(client);
	}

}