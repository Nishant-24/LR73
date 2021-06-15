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
public class AuthProcedureSoap implements Serializable {

	public static AuthProcedureSoap toSoapModel(AuthProcedure model) {
		AuthProcedureSoap soapModel = new AuthProcedureSoap();

		soapModel.setAuthProcedureId(model.getAuthProcedureId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalAuthorizationId(
			model.getExternalAuthorizationId());
		soapModel.setAuthNumber(model.getAuthNumber());
		soapModel.setMedicalCodeId(model.getMedicalCodeId());
		soapModel.setDescription(model.getDescription());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());

		return soapModel;
	}

	public static AuthProcedureSoap[] toSoapModels(AuthProcedure[] models) {
		AuthProcedureSoap[] soapModels = new AuthProcedureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthProcedureSoap[][] toSoapModels(AuthProcedure[][] models) {
		AuthProcedureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthProcedureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthProcedureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthProcedureSoap[] toSoapModels(List<AuthProcedure> models) {
		List<AuthProcedureSoap> soapModels = new ArrayList<AuthProcedureSoap>(
			models.size());

		for (AuthProcedure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthProcedureSoap[soapModels.size()]);
	}

	public AuthProcedureSoap() {
	}

	public long getPrimaryKey() {
		return _authProcedureId;
	}

	public void setPrimaryKey(long pk) {
		setAuthProcedureId(pk);
	}

	public long getAuthProcedureId() {
		return _authProcedureId;
	}

	public void setAuthProcedureId(long authProcedureId) {
		_authProcedureId = authProcedureId;
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

	public long getExternalAuthorizationId() {
		return _externalAuthorizationId;
	}

	public void setExternalAuthorizationId(long externalAuthorizationId) {
		_externalAuthorizationId = externalAuthorizationId;
	}

	public String getAuthNumber() {
		return _authNumber;
	}

	public void setAuthNumber(String authNumber) {
		_authNumber = authNumber;
	}

	public String getMedicalCodeId() {
		return _medicalCodeId;
	}

	public void setMedicalCodeId(String medicalCodeId) {
		_medicalCodeId = medicalCodeId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _authProcedureId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalAuthorizationId;
	private String _authNumber;
	private String _medicalCodeId;
	private String _description;
	private Date _externalModifiedDate;
	private Date _externalCreatedDate;

}