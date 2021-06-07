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
public class ClientGroupSoap implements Serializable {

	public static ClientGroupSoap toSoapModel(ClientGroup model) {
		ClientGroupSoap soapModel = new ClientGroupSoap();

		soapModel.setClientGroupId(model.getClientGroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalClientGroupId(model.getExternalClientGroupId());
		soapModel.setClientId(model.getClientId());
		soapModel.setClientGroup(model.getClientGroup());
		soapModel.setClientGroupName(model.getClientGroupName());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static ClientGroupSoap[] toSoapModels(ClientGroup[] models) {
		ClientGroupSoap[] soapModels = new ClientGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientGroupSoap[][] toSoapModels(ClientGroup[][] models) {
		ClientGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientGroupSoap[] toSoapModels(List<ClientGroup> models) {
		List<ClientGroupSoap> soapModels = new ArrayList<ClientGroupSoap>(
			models.size());

		for (ClientGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientGroupSoap[soapModels.size()]);
	}

	public ClientGroupSoap() {
	}

	public long getPrimaryKey() {
		return _clientGroupId;
	}

	public void setPrimaryKey(long pk) {
		setClientGroupId(pk);
	}

	public long getClientGroupId() {
		return _clientGroupId;
	}

	public void setClientGroupId(long clientGroupId) {
		_clientGroupId = clientGroupId;
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

	public long getExternalClientGroupId() {
		return _externalClientGroupId;
	}

	public void setExternalClientGroupId(long externalClientGroupId) {
		_externalClientGroupId = externalClientGroupId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getClientGroup() {
		return _clientGroup;
	}

	public void setClientGroup(String clientGroup) {
		_clientGroup = clientGroup;
	}

	public String getClientGroupName() {
		return _clientGroupName;
	}

	public void setClientGroupName(String clientGroupName) {
		_clientGroupName = clientGroupName;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _clientGroupId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalClientGroupId;
	private long _clientId;
	private String _clientGroup;
	private String _clientGroupName;
	private String _rowProcessed;

}