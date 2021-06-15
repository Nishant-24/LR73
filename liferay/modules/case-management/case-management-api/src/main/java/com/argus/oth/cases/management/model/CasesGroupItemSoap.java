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
public class CasesGroupItemSoap implements Serializable {

	public static CasesGroupItemSoap toSoapModel(CasesGroupItem model) {
		CasesGroupItemSoap soapModel = new CasesGroupItemSoap();

		soapModel.setCasesGroupItemId(model.getCasesGroupItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static CasesGroupItemSoap[] toSoapModels(CasesGroupItem[] models) {
		CasesGroupItemSoap[] soapModels = new CasesGroupItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CasesGroupItemSoap[][] toSoapModels(
		CasesGroupItem[][] models) {

		CasesGroupItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CasesGroupItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CasesGroupItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CasesGroupItemSoap[] toSoapModels(
		List<CasesGroupItem> models) {

		List<CasesGroupItemSoap> soapModels = new ArrayList<CasesGroupItemSoap>(
			models.size());

		for (CasesGroupItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CasesGroupItemSoap[soapModels.size()]);
	}

	public CasesGroupItemSoap() {
	}

	public long getPrimaryKey() {
		return _casesGroupItemId;
	}

	public void setPrimaryKey(long pk) {
		setCasesGroupItemId(pk);
	}

	public long getCasesGroupItemId() {
		return _casesGroupItemId;
	}

	public void setCasesGroupItemId(long casesGroupItemId) {
		_casesGroupItemId = casesGroupItemId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _casesGroupItemId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _externalCaseId;
	private String _type;

}