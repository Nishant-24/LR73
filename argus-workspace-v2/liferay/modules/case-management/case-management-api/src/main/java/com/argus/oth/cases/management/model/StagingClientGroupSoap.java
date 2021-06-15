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
public class StagingClientGroupSoap implements Serializable {

	public static StagingClientGroupSoap toSoapModel(StagingClientGroup model) {
		StagingClientGroupSoap soapModel = new StagingClientGroupSoap();

		soapModel.setStagingClientGroupId(model.getStagingClientGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalClientGroupId(model.getExternalClientGroupId());
		soapModel.setClientId(model.getClientId());
		soapModel.setClientGroup(model.getClientGroup());
		soapModel.setClientGroupName(model.getClientGroupName());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());

		return soapModel;
	}

	public static StagingClientGroupSoap[] toSoapModels(
		StagingClientGroup[] models) {

		StagingClientGroupSoap[] soapModels =
			new StagingClientGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingClientGroupSoap[][] toSoapModels(
		StagingClientGroup[][] models) {

		StagingClientGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingClientGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingClientGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingClientGroupSoap[] toSoapModels(
		List<StagingClientGroup> models) {

		List<StagingClientGroupSoap> soapModels =
			new ArrayList<StagingClientGroupSoap>(models.size());

		for (StagingClientGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingClientGroupSoap[soapModels.size()]);
	}

	public StagingClientGroupSoap() {
	}

	public long getPrimaryKey() {
		return _stagingClientGroupId;
	}

	public void setPrimaryKey(long pk) {
		setStagingClientGroupId(pk);
	}

	public long getStagingClientGroupId() {
		return _stagingClientGroupId;
	}

	public void setStagingClientGroupId(long stagingClientGroupId) {
		_stagingClientGroupId = stagingClientGroupId;
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

	private long _stagingClientGroupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalClientGroupId;
	private long _clientId;
	private String _clientGroup;
	private String _clientGroupName;
	private String _externalModifiedDate;
	private String _externalCreatedDate;

}