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
public class StagingReferenceTypeCodeSoap implements Serializable {

	public static StagingReferenceTypeCodeSoap toSoapModel(
		StagingReferenceTypeCode model) {

		StagingReferenceTypeCodeSoap soapModel =
			new StagingReferenceTypeCodeSoap();

		soapModel.setStagingReferenceTypeCodeId(
			model.getStagingReferenceTypeCodeId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalReferenceTypeCodeId(
			model.getExternalReferenceTypeCodeId());
		soapModel.setType(model.getType());
		soapModel.setKey(model.getKey());
		soapModel.setDescription(model.getDescription());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());

		return soapModel;
	}

	public static StagingReferenceTypeCodeSoap[] toSoapModels(
		StagingReferenceTypeCode[] models) {

		StagingReferenceTypeCodeSoap[] soapModels =
			new StagingReferenceTypeCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingReferenceTypeCodeSoap[][] toSoapModels(
		StagingReferenceTypeCode[][] models) {

		StagingReferenceTypeCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingReferenceTypeCodeSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new StagingReferenceTypeCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingReferenceTypeCodeSoap[] toSoapModels(
		List<StagingReferenceTypeCode> models) {

		List<StagingReferenceTypeCodeSoap> soapModels =
			new ArrayList<StagingReferenceTypeCodeSoap>(models.size());

		for (StagingReferenceTypeCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingReferenceTypeCodeSoap[soapModels.size()]);
	}

	public StagingReferenceTypeCodeSoap() {
	}

	public long getPrimaryKey() {
		return _stagingReferenceTypeCodeId;
	}

	public void setPrimaryKey(long pk) {
		setStagingReferenceTypeCodeId(pk);
	}

	public long getStagingReferenceTypeCodeId() {
		return _stagingReferenceTypeCodeId;
	}

	public void setStagingReferenceTypeCodeId(long stagingReferenceTypeCodeId) {
		_stagingReferenceTypeCodeId = stagingReferenceTypeCodeId;
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

	private long _stagingReferenceTypeCodeId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalReferenceTypeCodeId;
	private String _type;
	private String _key;
	private String _description;
	private String _externalModifiedDate;
	private String _externalCreatedDate;

}