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
public class DataRequestSoap implements Serializable {

	public static DataRequestSoap toSoapModel(DataRequest model) {
		DataRequestSoap soapModel = new DataRequestSoap();

		soapModel.setDataRequestId(model.getDataRequestId());
		soapModel.setClientId(model.getClientId());
		soapModel.setCaseId(model.getCaseId());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setType(model.getType());
		soapModel.setLastUpdatedDate(model.getLastUpdatedDate());

		return soapModel;
	}

	public static DataRequestSoap[] toSoapModels(DataRequest[] models) {
		DataRequestSoap[] soapModels = new DataRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataRequestSoap[][] toSoapModels(DataRequest[][] models) {
		DataRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataRequestSoap[] toSoapModels(List<DataRequest> models) {
		List<DataRequestSoap> soapModels = new ArrayList<DataRequestSoap>(
			models.size());

		for (DataRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataRequestSoap[soapModels.size()]);
	}

	public DataRequestSoap() {
	}

	public long getPrimaryKey() {
		return _dataRequestId;
	}

	public void setPrimaryKey(long pk) {
		setDataRequestId(pk);
	}

	public long getDataRequestId() {
		return _dataRequestId;
	}

	public void setDataRequestId(long dataRequestId) {
		_dataRequestId = dataRequestId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getCaseId() {
		return _caseId;
	}

	public void setCaseId(long caseId) {
		_caseId = caseId;
	}

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public Date getLastUpdatedDate() {
		return _lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		_lastUpdatedDate = lastUpdatedDate;
	}

	private long _dataRequestId;
	private long _clientId;
	private long _caseId;
	private long _externalCaseId;
	private String _type;
	private Date _lastUpdatedDate;

}