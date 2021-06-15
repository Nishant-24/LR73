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
public class MemberSoap implements Serializable {

	public static MemberSoap toSoapModel(Member model) {
		MemberSoap soapModel = new MemberSoap();

		soapModel.setMemberId(model.getMemberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
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
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static MemberSoap[] toSoapModels(Member[] models) {
		MemberSoap[] soapModels = new MemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[][] toSoapModels(Member[][] models) {
		MemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[] toSoapModels(List<Member> models) {
		List<MemberSoap> soapModels = new ArrayList<MemberSoap>(models.size());

		for (Member model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberSoap[soapModels.size()]);
	}

	public MemberSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
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

	public Date getMemberDOB() {
		return _memberDOB;
	}

	public void setMemberDOB(Date memberDOB) {
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

	private long _memberId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalMemberId;
	private long _clientId;
	private long _clientGroupId;
	private String _memberNumber;
	private String _memberFirstName;
	private String _memberLastName;
	private Date _memberDOB;
	private String _certificationNumber;
	private String _rxNumber;
	private Date _externalModifiedDate;
	private Date _externalCreatedDate;
	private String _rowProcessed;

}