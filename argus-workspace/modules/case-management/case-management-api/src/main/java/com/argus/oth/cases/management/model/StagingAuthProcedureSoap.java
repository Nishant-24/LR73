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
public class StagingAuthProcedureSoap implements Serializable {

	public static StagingAuthProcedureSoap toSoapModel(
		StagingAuthProcedure model) {

		StagingAuthProcedureSoap soapModel = new StagingAuthProcedureSoap();

		soapModel.setStagingAuthProcedureId(model.getStagingAuthProcedureId());
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

	public static StagingAuthProcedureSoap[] toSoapModels(
		StagingAuthProcedure[] models) {

		StagingAuthProcedureSoap[] soapModels =
			new StagingAuthProcedureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingAuthProcedureSoap[][] toSoapModels(
		StagingAuthProcedure[][] models) {

		StagingAuthProcedureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingAuthProcedureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingAuthProcedureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingAuthProcedureSoap[] toSoapModels(
		List<StagingAuthProcedure> models) {

		List<StagingAuthProcedureSoap> soapModels =
			new ArrayList<StagingAuthProcedureSoap>(models.size());

		for (StagingAuthProcedure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingAuthProcedureSoap[soapModels.size()]);
	}

	public StagingAuthProcedureSoap() {
	}

	public long getPrimaryKey() {
		return _stagingAuthProcedureId;
	}

	public void setPrimaryKey(long pk) {
		setStagingAuthProcedureId(pk);
	}

	public long getStagingAuthProcedureId() {
		return _stagingAuthProcedureId;
	}

	public void setStagingAuthProcedureId(long stagingAuthProcedureId) {
		_stagingAuthProcedureId = stagingAuthProcedureId;
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

	private long _stagingAuthProcedureId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalAuthorizationId;
	private String _authNumber;
	private String _medicalCodeId;
	private String _description;
	private String _externalModifiedDate;
	private String _externalCreatedDate;

}