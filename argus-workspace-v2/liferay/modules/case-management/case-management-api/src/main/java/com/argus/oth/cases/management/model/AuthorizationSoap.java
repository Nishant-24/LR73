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
 * This class is used by SOAP remote services, specifically {@link com.argus.oth.cases.management.service.http.AuthorizationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuthorizationSoap implements Serializable {

	public static AuthorizationSoap toSoapModel(Authorization model) {
		AuthorizationSoap soapModel = new AuthorizationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAuthorizationId(model.getAuthorizationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setCaseId(model.getCaseId());
		soapModel.setExternalAuthorizationId(
			model.getExternalAuthorizationId());
		soapModel.setMemberId(model.getMemberId());
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
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setEffectiveFrom(model.getEffectiveFrom());
		soapModel.setEffectiveThru(model.getEffectiveThru());
		soapModel.setProcessStatus(model.getProcessStatus());
		soapModel.setFailureDescription(model.getFailureDescription());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static AuthorizationSoap[] toSoapModels(Authorization[] models) {
		AuthorizationSoap[] soapModels = new AuthorizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorizationSoap[][] toSoapModels(Authorization[][] models) {
		AuthorizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorizationSoap[] toSoapModels(List<Authorization> models) {
		List<AuthorizationSoap> soapModels = new ArrayList<AuthorizationSoap>(
			models.size());

		for (Authorization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorizationSoap[soapModels.size()]);
	}

	public AuthorizationSoap() {
	}

	public long getPrimaryKey() {
		return _authorizationId;
	}

	public void setPrimaryKey(long pk) {
		setAuthorizationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAuthorizationId() {
		return _authorizationId;
	}

	public void setAuthorizationId(long authorizationId) {
		_authorizationId = authorizationId;
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

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public long getCaseId() {
		return _caseId;
	}

	public void setCaseId(long caseId) {
		_caseId = caseId;
	}

	public long getExternalAuthorizationId() {
		return _externalAuthorizationId;
	}

	public void setExternalAuthorizationId(long externalAuthorizationId) {
		_externalAuthorizationId = externalAuthorizationId;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
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

	public Date getStatusChangeDate() {
		return _statusChangeDate;
	}

	public void setStatusChangeDate(Date statusChangeDate) {
		_statusChangeDate = statusChangeDate;
	}

	public Date getReceivedDate() {
		return _receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
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

	public Date getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(Date externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	public Date getEffectiveFrom() {
		return _effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		_effectiveFrom = effectiveFrom;
	}

	public Date getEffectiveThru() {
		return _effectiveThru;
	}

	public void setEffectiveThru(Date effectiveThru) {
		_effectiveThru = effectiveThru;
	}

	public String getProcessStatus() {
		return _processStatus;
	}

	public void setProcessStatus(String processStatus) {
		_processStatus = processStatus;
	}

	public String getFailureDescription() {
		return _failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		_failureDescription = failureDescription;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private String _uuid;
	private long _authorizationId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _modifiedUserId;
	private long _caseId;
	private long _externalAuthorizationId;
	private long _memberId;
	private String _description;
	private String _rtcAuthorizationStatus;
	private String _authStatus;
	private Date _statusChangeDate;
	private Date _receivedDate;
	private String _authNumber;
	private String _category;
	private String _rtcAuthorizationType;
	private String _facility;
	private String _procedureCode;
	private String _comments;
	private Date _externalModifiedDate;
	private Date _effectiveFrom;
	private Date _effectiveThru;
	private String _processStatus;
	private String _failureDescription;
	private String _rowProcessed;

}