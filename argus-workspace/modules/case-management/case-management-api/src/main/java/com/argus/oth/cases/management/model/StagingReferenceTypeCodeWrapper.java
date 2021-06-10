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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StagingReferenceTypeCode}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingReferenceTypeCode
 * @generated
 */
public class StagingReferenceTypeCodeWrapper
	extends BaseModelWrapper<StagingReferenceTypeCode>
	implements ModelWrapper<StagingReferenceTypeCode>,
			   StagingReferenceTypeCode {

	public StagingReferenceTypeCodeWrapper(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		super(stagingReferenceTypeCode);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"stagingReferenceTypeCodeId", getStagingReferenceTypeCodeId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put(
			"externalReferenceTypeCodeId", getExternalReferenceTypeCodeId());
		attributes.put("type", getType());
		attributes.put("key", getKey());
		attributes.put("description", getDescription());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingReferenceTypeCodeId = (Long)attributes.get(
			"stagingReferenceTypeCodeId");

		if (stagingReferenceTypeCodeId != null) {
			setStagingReferenceTypeCodeId(stagingReferenceTypeCodeId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalReferenceTypeCodeId = (Long)attributes.get(
			"externalReferenceTypeCodeId");

		if (externalReferenceTypeCodeId != null) {
			setExternalReferenceTypeCodeId(externalReferenceTypeCodeId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String externalModifiedDate = (String)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		String externalCreatedDate = (String)attributes.get(
			"externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}
	}

	/**
	 * Returns the create date of this staging reference type code.
	 *
	 * @return the create date of this staging reference type code
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this staging reference type code.
	 *
	 * @return the description of this staging reference type code
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external created date of this staging reference type code.
	 *
	 * @return the external created date of this staging reference type code
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this staging reference type code.
	 *
	 * @return the external modified date of this staging reference type code
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the external reference type code ID of this staging reference type code.
	 *
	 * @return the external reference type code ID of this staging reference type code
	 */
	@Override
	public long getExternalReferenceTypeCodeId() {
		return model.getExternalReferenceTypeCodeId();
	}

	/**
	 * Returns the key of this staging reference type code.
	 *
	 * @return the key of this staging reference type code
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the modified date of this staging reference type code.
	 *
	 * @return the modified date of this staging reference type code
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this staging reference type code.
	 *
	 * @return the primary key of this staging reference type code
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the staging reference type code ID of this staging reference type code.
	 *
	 * @return the staging reference type code ID of this staging reference type code
	 */
	@Override
	public long getStagingReferenceTypeCodeId() {
		return model.getStagingReferenceTypeCodeId();
	}

	/**
	 * Returns the type of this staging reference type code.
	 *
	 * @return the type of this staging reference type code
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this staging reference type code.
	 *
	 * @param createDate the create date of this staging reference type code
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this staging reference type code.
	 *
	 * @param description the description of this staging reference type code
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external created date of this staging reference type code.
	 *
	 * @param externalCreatedDate the external created date of this staging reference type code
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this staging reference type code.
	 *
	 * @param externalModifiedDate the external modified date of this staging reference type code
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the external reference type code ID of this staging reference type code.
	 *
	 * @param externalReferenceTypeCodeId the external reference type code ID of this staging reference type code
	 */
	@Override
	public void setExternalReferenceTypeCodeId(
		long externalReferenceTypeCodeId) {

		model.setExternalReferenceTypeCodeId(externalReferenceTypeCodeId);
	}

	/**
	 * Sets the key of this staging reference type code.
	 *
	 * @param key the key of this staging reference type code
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the modified date of this staging reference type code.
	 *
	 * @param modifiedDate the modified date of this staging reference type code
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this staging reference type code.
	 *
	 * @param primaryKey the primary key of this staging reference type code
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the staging reference type code ID of this staging reference type code.
	 *
	 * @param stagingReferenceTypeCodeId the staging reference type code ID of this staging reference type code
	 */
	@Override
	public void setStagingReferenceTypeCodeId(long stagingReferenceTypeCodeId) {
		model.setStagingReferenceTypeCodeId(stagingReferenceTypeCodeId);
	}

	/**
	 * Sets the type of this staging reference type code.
	 *
	 * @param type the type of this staging reference type code
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected StagingReferenceTypeCodeWrapper wrap(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		return new StagingReferenceTypeCodeWrapper(stagingReferenceTypeCode);
	}

}