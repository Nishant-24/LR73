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
 * This class is a wrapper for {@link ReferenceTypeCode}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferenceTypeCode
 * @generated
 */
public class ReferenceTypeCodeWrapper
	extends BaseModelWrapper<ReferenceTypeCode>
	implements ModelWrapper<ReferenceTypeCode>, ReferenceTypeCode {

	public ReferenceTypeCodeWrapper(ReferenceTypeCode referenceTypeCode) {
		super(referenceTypeCode);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("referenceTypeCodeId", getReferenceTypeCodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put(
			"externalReferenceTypeCodeId", getExternalReferenceTypeCodeId());
		attributes.put("type", getType());
		attributes.put("key", getKey());
		attributes.put("description", getDescription());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long referenceTypeCodeId = (Long)attributes.get("referenceTypeCodeId");

		if (referenceTypeCodeId != null) {
			setReferenceTypeCodeId(referenceTypeCodeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the company ID of this reference type code.
	 *
	 * @return the company ID of this reference type code
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this reference type code.
	 *
	 * @return the create date of this reference type code
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this reference type code.
	 *
	 * @return the description of this reference type code
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external reference type code ID of this reference type code.
	 *
	 * @return the external reference type code ID of this reference type code
	 */
	@Override
	public long getExternalReferenceTypeCodeId() {
		return model.getExternalReferenceTypeCodeId();
	}

	/**
	 * Returns the group ID of this reference type code.
	 *
	 * @return the group ID of this reference type code
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the key of this reference type code.
	 *
	 * @return the key of this reference type code
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the modified date of this reference type code.
	 *
	 * @return the modified date of this reference type code
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this reference type code.
	 *
	 * @return the primary key of this reference type code
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference type code ID of this reference type code.
	 *
	 * @return the reference type code ID of this reference type code
	 */
	@Override
	public long getReferenceTypeCodeId() {
		return model.getReferenceTypeCodeId();
	}

	/**
	 * Returns the row processed of this reference type code.
	 *
	 * @return the row processed of this reference type code
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the type of this reference type code.
	 *
	 * @return the type of this reference type code
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
	 * Sets the company ID of this reference type code.
	 *
	 * @param companyId the company ID of this reference type code
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this reference type code.
	 *
	 * @param createDate the create date of this reference type code
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this reference type code.
	 *
	 * @param description the description of this reference type code
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external reference type code ID of this reference type code.
	 *
	 * @param externalReferenceTypeCodeId the external reference type code ID of this reference type code
	 */
	@Override
	public void setExternalReferenceTypeCodeId(
		long externalReferenceTypeCodeId) {

		model.setExternalReferenceTypeCodeId(externalReferenceTypeCodeId);
	}

	/**
	 * Sets the group ID of this reference type code.
	 *
	 * @param groupId the group ID of this reference type code
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the key of this reference type code.
	 *
	 * @param key the key of this reference type code
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the modified date of this reference type code.
	 *
	 * @param modifiedDate the modified date of this reference type code
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this reference type code.
	 *
	 * @param primaryKey the primary key of this reference type code
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference type code ID of this reference type code.
	 *
	 * @param referenceTypeCodeId the reference type code ID of this reference type code
	 */
	@Override
	public void setReferenceTypeCodeId(long referenceTypeCodeId) {
		model.setReferenceTypeCodeId(referenceTypeCodeId);
	}

	/**
	 * Sets the row processed of this reference type code.
	 *
	 * @param rowProcessed the row processed of this reference type code
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the type of this reference type code.
	 *
	 * @param type the type of this reference type code
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected ReferenceTypeCodeWrapper wrap(
		ReferenceTypeCode referenceTypeCode) {

		return new ReferenceTypeCodeWrapper(referenceTypeCode);
	}

}