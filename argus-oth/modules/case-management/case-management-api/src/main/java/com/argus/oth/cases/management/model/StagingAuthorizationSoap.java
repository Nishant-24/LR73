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
public class StagingAuthorizationSoap implements Serializable {

	public static StagingAuthorizationSoap toSoapModel(
		StagingAuthorization model) {

		StagingAuthorizationSoap soapModel = new StagingAuthorizationSoap();

		soapModel.setStagingAuthorizationId(model.getStagingAuthorizationId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setExternalAuthorizationId(
			model.getExternalAuthorizationId());
		soapModel.setExternalMemberId(model.getExternalMemberId());
		soapModel.setDescription(model.getDescription());
		soapModel.setRtcAuthorizationStatus(model.getRtcAuthorizationStatus());
		soapModel.setAuthStatus(model.getAuthStatus());
		soapModel.setStatusChangeDate(model.getStatusChangeDate());
		soapModel.setReceivedDate(model.getReceivedDate());
		soapModel.setAuthNumber(model.getAuthNumber());
		soapModel.setCategory(model.getCategory());
		soapModel.setRtcAuthorizationType(model.getRtcAuthorizationType());
		soapModel.setFacility(model.getFacility());
		soapModel.setProcedureCode(model.getProcedureCode());
		soapModel.setComments(model.getComments());
		soapModel.setEffectiveFrom(model.getEffectiveFrom());
		soapModel.setEffectiveThru(model.getEffectiveThru());
		soapModel.setExternalCreateDate(model.getExternalCreateDate());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());

		return soapModel;
	}

	public static StagingAuthorizationSoap[] toSoapModels(
		StagingAuthorization[] models) {

		StagingAuthorizationSoap[] soapModels =
			new StagingAuthorizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingAuthorizationSoap[][] toSoapModels(
		StagingAuthorization[][] models) {

		StagingAuthorizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingAuthorizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingAuthorizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingAuthorizationSoap[] toSoapModels(
		List<StagingAuthorization> models) {

		List<StagingAuthorizationSoap> soapModels =
			new ArrayList<StagingAuthorizationSoap>(models.size());

		for (StagingAuthorization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingAuthorizationSoap[soapModels.size()]);
	}

	public StagingAuthorizationSoap() {
	}

	public long getPrimaryKey() {
		return _stagingAuthorizationId;
	}

	public void setPrimaryKey(long pk) {
		setStagingAuthorizationId(pk);
	}

	public long getStagingAuthorizationId() {
		return _stagingAuthorizationId;
	}

	public void setStagingAuthorizationId(long stagingAuthorizationId) {
		_stagingAuthorizationId = stagingAuthorizationId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public long getExternalAuthorizationId() {
		return _externalAuthorizationId;
	}

	public void setExternalAuthorizationId(long externalAuthorizationId) {
		_externalAuthorizationId = externalAuthorizationId;
	}

	public long getExternalMemberId() {
		return _externalMemberId;
	}

	public void setExternalMemberId(long externalMemberId) {
		_externalMemberId = externalMemberId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getRtcAuthorizationStatus() {
		return _rtcAuthorizationStatus;
	}

	public void setRtcAuthorizationStatus(String rtcAuthorizationStatus) {
		_rtcAuthorizationStatus = rtcAuthorizationStatus;
	}

	public String getAuthStatus() {
		return _authStatus;
	}

	public void setAuthStatus(String authStatus) {
		_authStatus = authStatus;
	}

	public String getStatusChangeDate() {
		return _statusChangeDate;
	}

	public void setStatusChangeDate(String statusChangeDate) {
		_statusChangeDate = statusChangeDate;
	}

	public String getReceivedDate() {
		return _receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		_receivedDate = receivedDate;
	}

	public String getAuthNumber() {
		return _authNumber;
	}

	public void setAuthNumber(String authNumber) {
		_authNumber = authNumber;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getRtcAuthorizationType() {
		return _rtcAuthorizationType;
	}

	public void setRtcAuthorizationType(String rtcAuthorizationType) {
		_rtcAuthorizationType = rtcAuthorizationType;
	}

	public String getFacility() {
		return _facility;
	}

	public void setFacility(String facility) {
		_facility = facility;
	}

	public String getProcedureCode() {
		return _procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		_procedureCode = procedureCode;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getEffectiveFrom() {
		return _effectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom) {
		_effectiveFrom = effectiveFrom;
	}

	public String getEffectiveThru() {
		return _effectiveThru;
	}

	public void setEffectiveThru(String effectiveThru) {
		_effectiveThru = effectiveThru;
	}

	public String getExternalCreateDate() {
		return _externalCreateDate;
	}

	public void setExternalCreateDate(String externalCreateDate) {
		_externalCreateDate = externalCreateDate;
	}

	public String getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(String externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	private long _stagingAuthorizationId;
	private Date _createDate;
	private long _externalCaseId;
	private long _externalAuthorizationId;
	private long _externalMemberId;
	private String _description;
	private String _rtcAuthorizationStatus;
	private String _authStatus;
	private String _statusChangeDate;
	private String _receivedDate;
	private String _authNumber;
	private String _category;
	private String _rtcAuthorizationType;
	private String _facility;
	private String _procedureCode;
	private String _comments;
	private String _effectiveFrom;
	private String _effectiveThru;
	private String _externalCreateDate;
	private String _externalModifiedDate;

}