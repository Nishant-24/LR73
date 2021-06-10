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
 * This class is a wrapper for {@link DataRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataRequest
 * @generated
 */
public class DataRequestWrapper
	extends BaseModelWrapper<DataRequest>
	implements DataRequest, ModelWrapper<DataRequest> {

	public DataRequestWrapper(DataRequest dataRequest) {
		super(dataRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataRequestId", getDataRequestId());
		attributes.put("clientId", getClientId());
		attributes.put("caseId", getCaseId());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("type", getType());
		attributes.put("lastUpdatedDate", getLastUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataRequestId = (Long)attributes.get("dataRequestId");

		if (dataRequestId != null) {
			setDataRequestId(dataRequestId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
		}

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date lastUpdatedDate = (Date)attributes.get("lastUpdatedDate");

		if (lastUpdatedDate != null) {
			setLastUpdatedDate(lastUpdatedDate);
		}
	}

	/**
	 * Returns the case ID of this data request.
	 *
	 * @return the case ID of this data request
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the client ID of this data request.
	 *
	 * @return the client ID of this data request
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the data request ID of this data request.
	 *
	 * @return the data request ID of this data request
	 */
	@Override
	public long getDataRequestId() {
		return model.getDataRequestId();
	}

	/**
	 * Returns the external case ID of this data request.
	 *
	 * @return the external case ID of this data request
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the last updated date of this data request.
	 *
	 * @return the last updated date of this data request
	 */
	@Override
	public Date getLastUpdatedDate() {
		return model.getLastUpdatedDate();
	}

	/**
	 * Returns the primary key of this data request.
	 *
	 * @return the primary key of this data request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this data request.
	 *
	 * @return the type of this data request
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the case ID of this data request.
	 *
	 * @param caseId the case ID of this data request
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the client ID of this data request.
	 *
	 * @param clientId the client ID of this data request
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the data request ID of this data request.
	 *
	 * @param dataRequestId the data request ID of this data request
	 */
	@Override
	public void setDataRequestId(long dataRequestId) {
		model.setDataRequestId(dataRequestId);
	}

	/**
	 * Sets the external case ID of this data request.
	 *
	 * @param externalCaseId the external case ID of this data request
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the last updated date of this data request.
	 *
	 * @param lastUpdatedDate the last updated date of this data request
	 */
	@Override
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		model.setLastUpdatedDate(lastUpdatedDate);
	}

	/**
	 * Sets the primary key of this data request.
	 *
	 * @param primaryKey the primary key of this data request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this data request.
	 *
	 * @param type the type of this data request
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected DataRequestWrapper wrap(DataRequest dataRequest) {
		return new DataRequestWrapper(dataRequest);
	}

}