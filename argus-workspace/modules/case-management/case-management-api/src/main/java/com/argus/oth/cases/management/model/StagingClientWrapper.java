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
 * This class is a wrapper for {@link StagingClient}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClient
 * @generated
 */
public class StagingClientWrapper
	extends BaseModelWrapper<StagingClient>
	implements ModelWrapper<StagingClient>, StagingClient {

	public StagingClientWrapper(StagingClient stagingClient) {
		super(stagingClient);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingClientId", getStagingClientId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalClientPk", getExternalClientPk());
		attributes.put("clientId", getClientId());
		attributes.put("clientName", getClientName());
		attributes.put("telephonyNumber", getTelephonyNumber());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());
		attributes.put("rowProcessed", isRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingClientId = (Long)attributes.get("stagingClientId");

		if (stagingClientId != null) {
			setStagingClientId(stagingClientId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String externalClientPk = (String)attributes.get("externalClientPk");

		if (externalClientPk != null) {
			setExternalClientPk(externalClientPk);
		}

		String clientId = (String)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String telephonyNumber = (String)attributes.get("telephonyNumber");

		if (telephonyNumber != null) {
			setTelephonyNumber(telephonyNumber);
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

		Boolean rowProcessed = (Boolean)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the client ID of this staging client.
	 *
	 * @return the client ID of this staging client
	 */
	@Override
	public String getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the client name of this staging client.
	 *
	 * @return the client name of this staging client
	 */
	@Override
	public String getClientName() {
		return model.getClientName();
	}

	/**
	 * Returns the create date of this staging client.
	 *
	 * @return the create date of this staging client
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external client pk of this staging client.
	 *
	 * @return the external client pk of this staging client
	 */
	@Override
	public String getExternalClientPk() {
		return model.getExternalClientPk();
	}

	/**
	 * Returns the external created date of this staging client.
	 *
	 * @return the external created date of this staging client
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this staging client.
	 *
	 * @return the external modified date of this staging client
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the modified date of this staging client.
	 *
	 * @return the modified date of this staging client
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this staging client.
	 *
	 * @return the primary key of this staging client
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the row processed of this staging client.
	 *
	 * @return the row processed of this staging client
	 */
	@Override
	public boolean getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the staging client ID of this staging client.
	 *
	 * @return the staging client ID of this staging client
	 */
	@Override
	public long getStagingClientId() {
		return model.getStagingClientId();
	}

	/**
	 * Returns the telephony number of this staging client.
	 *
	 * @return the telephony number of this staging client
	 */
	@Override
	public String getTelephonyNumber() {
		return model.getTelephonyNumber();
	}

	/**
	 * Returns <code>true</code> if this staging client is row processed.
	 *
	 * @return <code>true</code> if this staging client is row processed; <code>false</code> otherwise
	 */
	@Override
	public boolean isRowProcessed() {
		return model.isRowProcessed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the client ID of this staging client.
	 *
	 * @param clientId the client ID of this staging client
	 */
	@Override
	public void setClientId(String clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the client name of this staging client.
	 *
	 * @param clientName the client name of this staging client
	 */
	@Override
	public void setClientName(String clientName) {
		model.setClientName(clientName);
	}

	/**
	 * Sets the create date of this staging client.
	 *
	 * @param createDate the create date of this staging client
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external client pk of this staging client.
	 *
	 * @param externalClientPk the external client pk of this staging client
	 */
	@Override
	public void setExternalClientPk(String externalClientPk) {
		model.setExternalClientPk(externalClientPk);
	}

	/**
	 * Sets the external created date of this staging client.
	 *
	 * @param externalCreatedDate the external created date of this staging client
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this staging client.
	 *
	 * @param externalModifiedDate the external modified date of this staging client
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the modified date of this staging client.
	 *
	 * @param modifiedDate the modified date of this staging client
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this staging client.
	 *
	 * @param primaryKey the primary key of this staging client
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this staging client is row processed.
	 *
	 * @param rowProcessed the row processed of this staging client
	 */
	@Override
	public void setRowProcessed(boolean rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the staging client ID of this staging client.
	 *
	 * @param stagingClientId the staging client ID of this staging client
	 */
	@Override
	public void setStagingClientId(long stagingClientId) {
		model.setStagingClientId(stagingClientId);
	}

	/**
	 * Sets the telephony number of this staging client.
	 *
	 * @param telephonyNumber the telephony number of this staging client
	 */
	@Override
	public void setTelephonyNumber(String telephonyNumber) {
		model.setTelephonyNumber(telephonyNumber);
	}

	@Override
	protected StagingClientWrapper wrap(StagingClient stagingClient) {
		return new StagingClientWrapper(stagingClient);
	}

}