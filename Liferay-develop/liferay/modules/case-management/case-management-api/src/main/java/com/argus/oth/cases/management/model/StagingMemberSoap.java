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
public class StagingMemberSoap implements Serializable {

	public static StagingMemberSoap toSoapModel(StagingMember model) {
		StagingMemberSoap soapModel = new StagingMemberSoap();

		soapModel.setStagingMemberId(model.getStagingMemberId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalMemberId(model.getExternalMemberId());
		soapModel.setClientId(model.getClientId());
		soapModel.setClientGroupId(model.getClientGroupId());
		soapModel.setMemberNumber(model.getMemberNumber());
		soapModel.setMemberFirstName(model.getMemberFirstName());
		soapModel.setMemberLastName(model.getMemberLastName());
		soapModel.setMemberDOB(model.getMemberDOB());
		soapModel.setCertificationNumber(model.getCertificationNumber());
		soapModel.setRxNumber(model.getRxNumber());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());

		return soapModel;
	}

	public static StagingMemberSoap[] toSoapModels(StagingMember[] models) {
		StagingMemberSoap[] soapModels = new StagingMemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingMemberSoap[][] toSoapModels(StagingMember[][] models) {
		StagingMemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StagingMemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingMemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingMemberSoap[] toSoapModels(List<StagingMember> models) {
		List<StagingMemberSoap> soapModels = new ArrayList<StagingMemberSoap>(
			models.size());

		for (StagingMember model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StagingMemberSoap[soapModels.size()]);
	}

	public StagingMemberSoap() {
	}

	public long getPrimaryKey() {
		return _stagingMemberId;
	}

	public void setPrimaryKey(long pk) {
		setStagingMemberId(pk);
	}

	public long getStagingMemberId() {
		return _stagingMemberId;
	}

	public void setStagingMemberId(long stagingMemberId) {
		_stagingMemberId = stagingMemberId;
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

	public long getExternalMemberId() {
		return _externalMemberId;
	}

	public void setExternalMemberId(long externalMemberId) {
		_externalMemberId = externalMemberId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getClientGroupId() {
		return _clientGroupId;
	}

	public void setClientGroupId(long clientGroupId) {
		_clientGroupId = clientGroupId;
	}

	public String getMemberNumber() {
		return _memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		_memberNumber = memberNumber;
	}

	public String getMemberFirstName() {
		return _memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		_memberFirstName = memberFirstName;
	}

	public String getMemberLastName() {
		return _memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		_memberLastName = memberLastName;
	}

	public String getMemberDOB() {
		return _memberDOB;
	}

	public void setMemberDOB(String memberDOB) {
		_memberDOB = memberDOB;
	}

	public String getCertificationNumber() {
		return _certificationNumber;
	}

	public void setCertificationNumber(String certificationNumber) {
		_certificationNumber = certificationNumber;
	}

	public String getRxNumber() {
		return _rxNumber;
	}

	public void setRxNumber(String rxNumber) {
		_rxNumber = rxNumber;
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

	private long _stagingMemberId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalMemberId;
	private long _clientId;
	private long _clientGroupId;
	private String _memberNumber;
	private String _memberFirstName;
	private String _memberLastName;
	private String _memberDOB;
	private String _certificationNumber;
	private String _rxNumber;
	private String _externalModifiedDate;
	private String _externalCreatedDate;

}