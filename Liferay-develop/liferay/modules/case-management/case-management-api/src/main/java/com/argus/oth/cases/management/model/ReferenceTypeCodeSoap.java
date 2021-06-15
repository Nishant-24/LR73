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
public class ReferenceTypeCodeSoap implements Serializable {

	public static ReferenceTypeCodeSoap toSoapModel(ReferenceTypeCode model) {
		ReferenceTypeCodeSoap soapModel = new ReferenceTypeCodeSoap();

		soapModel.setReferenceTypeCodeId(model.getReferenceTypeCodeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalReferenceTypeCodeId(
			model.getExternalReferenceTypeCodeId());
		soapModel.setType(model.getType());
		soapModel.setKey(model.getKey());
		soapModel.setDescription(model.getDescription());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static ReferenceTypeCodeSoap[] toSoapModels(
		ReferenceTypeCode[] models) {

		ReferenceTypeCodeSoap[] soapModels =
			new ReferenceTypeCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReferenceTypeCodeSoap[][] toSoapModels(
		ReferenceTypeCode[][] models) {

		ReferenceTypeCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ReferenceTypeCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReferenceTypeCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReferenceTypeCodeSoap[] toSoapModels(
		List<ReferenceTypeCode> models) {

		List<ReferenceTypeCodeSoap> soapModels =
			new ArrayList<ReferenceTypeCodeSoap>(models.size());

		for (ReferenceTypeCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReferenceTypeCodeSoap[soapModels.size()]);
	}

	public ReferenceTypeCodeSoap() {
	}

	public long getPrimaryKey() {
		return _referenceTypeCodeId;
	}

	public void setPrimaryKey(long pk) {
		setReferenceTypeCodeId(pk);
	}

	public long getReferenceTypeCodeId() {
		return _referenceTypeCodeId;
	}

	public void setReferenceTypeCodeId(long referenceTypeCodeId) {
		_referenceTypeCodeId = referenceTypeCodeId;
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

	public long getExternalReferenceTypeCodeId() {
		return _externalReferenceTypeCodeId;
	}

	public void setExternalReferenceTypeCodeId(
		long externalReferenceTypeCodeId) {

		_externalReferenceTypeCodeId = externalReferenceTypeCodeId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _referenceTypeCodeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalReferenceTypeCodeId;
	private String _type;
	private String _key;
	private String _description;
	private String _rowProcessed;

}