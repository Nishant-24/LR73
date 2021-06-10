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
 * This class is used by SOAP remote services, specifically {@link com.argus.oth.cases.management.service.http.ClientServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClientSoap implements Serializable {

	public static ClientSoap toSoapModel(Client model) {
		ClientSoap soapModel = new ClientSoap();

		soapModel.setClientId(model.getClientId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalClientPk(model.getExternalClientPk());
		soapModel.setExternalClientId(model.getExternalClientId());
		soapModel.setClientName(model.getClientName());
		soapModel.setTelephonyNumber(model.getTelephonyNumber());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static ClientSoap[] toSoapModels(Client[] models) {
		ClientSoap[] soapModels = new ClientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientSoap[][] toSoapModels(Client[][] models) {
		ClientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientSoap[] toSoapModels(List<Client> models) {
		List<ClientSoap> soapModels = new ArrayList<ClientSoap>(models.size());

		for (Client model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientSoap[soapModels.size()]);
	}

	public ClientSoap() {
	}

	public long getPrimaryKey() {
		return _clientId;
	}

	public void setPrimaryKey(long pk) {
		setClientId(pk);
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getExternalClientPk() {
		return _externalClientPk;
	}

	public void setExternalClientPk(long externalClientPk) {
		_externalClientPk = externalClientPk;
	}

	public long getExternalClientId() {
		return _externalClientId;
	}

	public void setExternalClientId(long externalClientId) {
		_externalClientId = externalClientId;
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

	public Date getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(Date externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	public Date getExternalCreatedDate() {
		return _externalCreatedDate;
	}

	public void setExternalCreatedDate(Date externalCreatedDate) {
		_externalCreatedDate = externalCreatedDate;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _clientId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalClientPk;
	private long _externalClientId;
	private String _clientName;
	private String _telephonyNumber;
	private Date _externalModifiedDate;
	private Date _externalCreatedDate;
	private String _rowProcessed;

}