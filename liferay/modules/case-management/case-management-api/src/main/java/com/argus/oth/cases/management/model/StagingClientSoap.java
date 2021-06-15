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
public class StagingClientSoap implements Serializable {

	public static StagingClientSoap toSoapModel(StagingClient model) {
		StagingClientSoap soapModel = new StagingClientSoap();

		soapModel.setStagingClientId(model.getStagingClientId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalClientPk(model.getExternalClientPk());
		soapModel.setClientId(model.getClientId());
		soapModel.setClientName(model.getClientName());
		soapModel.setTelephonyNumber(model.getTelephonyNumber());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());
		soapModel.setRowProcessed(model.isRowProcessed());

		return soapModel;
	}

	public static StagingClientSoap[] toSoapModels(StagingClient[] models) {
		StagingClientSoap[] soapModels = new StagingClientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingClientSoap[][] toSoapModels(StagingClient[][] models) {
		StagingClientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StagingClientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingClientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingClientSoap[] toSoapModels(List<StagingClient> models) {
		List<StagingClientSoap> soapModels = new ArrayList<StagingClientSoap>(
			models.size());

		for (StagingClient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StagingClientSoap[soapModels.size()]);
	}

	public StagingClientSoap() {
	}

	public long getPrimaryKey() {
		return _stagingClientId;
	}

	public void setPrimaryKey(long pk) {
		setStagingClientId(pk);
	}

	public long getStagingClientId() {
		return _stagingClientId;
	}

	public void setStagingClientId(long stagingClientId) {
		_stagingClientId = stagingClientId;
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

	public String getExternalClientPk() {
		return _externalClientPk;
	}

	public void setExternalClientPk(String externalClientPk) {
		_externalClientPk = externalClientPk;
	}

	public String getClientId() {
		return _clientId;
	}

	public void setClientId(String clientId) {
		_clientId = clientId;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public String getTelephonyNumber() {
		return _telephonyNumber;
	}

	public void setTelephonyNumber(String telephonyNumber) {
		_telephonyNumber = telephonyNumber;
	}

	public String getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(String externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	public String getExternalCreatedDate() {
		return _externalCreatedDate;
	}

	public void setExternalCreatedDate(String externalCreatedDate) {
		_externalCreatedDate = externalCreatedDate;
	}

	public boolean getRowProcessed() {
		return _rowProcessed;
	}

	public boolean isRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(boolean rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _stagingClientId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _externalClientPk;
	private String _clientId;
	private String _clientName;
	private String _telephonyNumber;
	private String _externalModifiedDate;
	private String _externalCreatedDate;
	private boolean _rowProcessed;

}