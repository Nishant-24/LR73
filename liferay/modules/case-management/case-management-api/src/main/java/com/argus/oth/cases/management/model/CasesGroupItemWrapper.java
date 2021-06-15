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
 * This class is a wrapper for {@link CasesGroupItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesGroupItem
 * @generated
 */
public class CasesGroupItemWrapper
	extends BaseModelWrapper<CasesGroupItem>
	implements CasesGroupItem, ModelWrapper<CasesGroupItem> {

	public CasesGroupItemWrapper(CasesGroupItem casesGroupItem) {
		super(casesGroupItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("casesGroupItemId", getCasesGroupItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long casesGroupItemId = (Long)attributes.get("casesGroupItemId");

		if (casesGroupItemId != null) {
			setCasesGroupItemId(casesGroupItemId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the cases group item ID of this cases group item.
	 *
	 * @return the cases group item ID of this cases group item
	 */
	@Override
	public long getCasesGroupItemId() {
		return model.getCasesGroupItemId();
	}

	/**
	 * Returns the company ID of this cases group item.
	 *
	 * @return the company ID of this cases group item
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this cases group item.
	 *
	 * @return the create date of this cases group item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external case ID of this cases group item.
	 *
	 * @return the external case ID of this cases group item
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the group ID of this cases group item.
	 *
	 * @return the group ID of this cases group item
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this cases group item.
	 *
	 * @return the modified date of this cases group item
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cases group item.
	 *
	 * @return the primary key of this cases group item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this cases group item.
	 *
	 * @return the type of this cases group item
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this cases group item.
	 *
	 * @return the user ID of this cases group item
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this cases group item.
	 *
	 * @return the user uuid of this cases group item
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cases group item ID of this cases group item.
	 *
	 * @param casesGroupItemId the cases group item ID of this cases group item
	 */
	@Override
	public void setCasesGroupItemId(long casesGroupItemId) {
		model.setCasesGroupItemId(casesGroupItemId);
	}

	/**
	 * Sets the company ID of this cases group item.
	 *
	 * @param companyId the company ID of this cases group item
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this cases group item.
	 *
	 * @param createDate the create date of this cases group item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external case ID of this cases group item.
	 *
	 * @param externalCaseId the external case ID of this cases group item
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the group ID of this cases group item.
	 *
	 * @param groupId the group ID of this cases group item
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this cases group item.
	 *
	 * @param modifiedDate the modified date of this cases group item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cases group item.
	 *
	 * @param primaryKey the primary key of this cases group item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this cases group item.
	 *
	 * @param type the type of this cases group item
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this cases group item.
	 *
	 * @param userId the user ID of this cases group item
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this cases group item.
	 *
	 * @param userUuid the user uuid of this cases group item
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CasesGroupItemWrapper wrap(CasesGroupItem casesGroupItem) {
		return new CasesGroupItemWrapper(casesGroupItem);
	}

}