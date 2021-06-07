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
 * This class is a wrapper for {@link StagingMember}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingMember
 * @generated
 */
public class StagingMemberWrapper
	extends BaseModelWrapper<StagingMember>
	implements ModelWrapper<StagingMember>, StagingMember {

	public StagingMemberWrapper(StagingMember stagingMember) {
		super(stagingMember);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingMemberId", getStagingMemberId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalMemberId", getExternalMemberId());
		attributes.put("clientId", getClientId());
		attributes.put("clientGroupId", getClientGroupId());
		attributes.put("memberNumber", getMemberNumber());
		attributes.put("memberFirstName", getMemberFirstName());
		attributes.put("memberLastName", getMemberLastName());
		attributes.put("memberDOB", getMemberDOB());
		attributes.put("certificationNumber", getCertificationNumber());
		attributes.put("rxNumber", getRxNumber());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingMemberId = (Long)attributes.get("stagingMemberId");

		if (stagingMemberId != null) {
			setStagingMemberId(stagingMemberId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalMemberId = (Long)attributes.get("externalMemberId");

		if (externalMemberId != null) {
			setExternalMemberId(externalMemberId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long clientGroupId = (Long)attributes.get("clientGroupId");

		if (clientGroupId != null) {
			setClientGroupId(clientGroupId);
		}

		String memberNumber = (String)attributes.get("memberNumber");

		if (memberNumber != null) {
			setMemberNumber(memberNumber);
		}

		String memberFirstName = (String)attributes.get("memberFirstName");

		if (memberFirstName != null) {
			setMemberFirstName(memberFirstName);
		}

		String memberLastName = (String)attributes.get("memberLastName");

		if (memberLastName != null) {
			setMemberLastName(memberLastName);
		}

		String memberDOB = (String)attributes.get("memberDOB");

		if (memberDOB != null) {
			setMemberDOB(memberDOB);
		}

		String certificationNumber = (String)attributes.get(
			"certificationNumber");

		if (certificationNumber != null) {
			setCertificationNumber(certificationNumber);
		}

		String rxNumber = (String)attributes.get("rxNumber");

		if (rxNumber != null) {
			setRxNumber(rxNumber);
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
	 * Returns the certification number of this staging member.
	 *
	 * @return the certification number of this staging member
	 */
	@Override
	public String getCertificationNumber() {
		return model.getCertificationNumber();
	}

	/**
	 * Returns the client group ID of this staging member.
	 *
	 * @return the client group ID of this staging member
	 */
	@Override
	public long getClientGroupId() {
		return model.getClientGroupId();
	}

	/**
	 * Returns the client ID of this staging member.
	 *
	 * @return the client ID of this staging member
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the create date of this staging member.
	 *
	 * @return the create date of this staging member
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external created date of this staging member.
	 *
	 * @return the external created date of this staging member
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external member ID of this staging member.
	 *
	 * @return the external member ID of this staging member
	 */
	@Override
	public long getExternalMemberId() {
		return model.getExternalMemberId();
	}

	/**
	 * Returns the external modified date of this staging member.
	 *
	 * @return the external modified date of this staging member
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the member dob of this staging member.
	 *
	 * @return the member dob of this staging member
	 */
	@Override
	public String getMemberDOB() {
		return model.getMemberDOB();
	}

	/**
	 * Returns the member first name of this staging member.
	 *
	 * @return the member first name of this staging member
	 */
	@Override
	public String getMemberFirstName() {
		return model.getMemberFirstName();
	}

	/**
	 * Returns the member last name of this staging member.
	 *
	 * @return the member last name of this staging member
	 */
	@Override
	public String getMemberLastName() {
		return model.getMemberLastName();
	}

	/**
	 * Returns the member number of this staging member.
	 *
	 * @return the member number of this staging member
	 */
	@Override
	public String getMemberNumber() {
		return model.getMemberNumber();
	}

	/**
	 * Returns the modified date of this staging member.
	 *
	 * @return the modified date of this staging member
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this staging member.
	 *
	 * @return the primary key of this staging member
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rx number of this staging member.
	 *
	 * @return the rx number of this staging member
	 */
	@Override
	public String getRxNumber() {
		return model.getRxNumber();
	}

	/**
	 * Returns the staging member ID of this staging member.
	 *
	 * @return the staging member ID of this staging member
	 */
	@Override
	public long getStagingMemberId() {
		return model.getStagingMemberId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the certification number of this staging member.
	 *
	 * @param certificationNumber the certification number of this staging member
	 */
	@Override
	public void setCertificationNumber(String certificationNumber) {
		model.setCertificationNumber(certificationNumber);
	}

	/**
	 * Sets the client group ID of this staging member.
	 *
	 * @param clientGroupId the client group ID of this staging member
	 */
	@Override
	public void setClientGroupId(long clientGroupId) {
		model.setClientGroupId(clientGroupId);
	}

	/**
	 * Sets the client ID of this staging member.
	 *
	 * @param clientId the client ID of this staging member
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the create date of this staging member.
	 *
	 * @param createDate the create date of this staging member
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external created date of this staging member.
	 *
	 * @param externalCreatedDate the external created date of this staging member
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external member ID of this staging member.
	 *
	 * @param externalMemberId the external member ID of this staging member
	 */
	@Override
	public void setExternalMemberId(long externalMemberId) {
		model.setExternalMemberId(externalMemberId);
	}

	/**
	 * Sets the external modified date of this staging member.
	 *
	 * @param externalModifiedDate the external modified date of this staging member
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the member dob of this staging member.
	 *
	 * @param memberDOB the member dob of this staging member
	 */
	@Override
	public void setMemberDOB(String memberDOB) {
		model.setMemberDOB(memberDOB);
	}

	/**
	 * Sets the member first name of this staging member.
	 *
	 * @param memberFirstName the member first name of this staging member
	 */
	@Override
	public void setMemberFirstName(String memberFirstName) {
		model.setMemberFirstName(memberFirstName);
	}

	/**
	 * Sets the member last name of this staging member.
	 *
	 * @param memberLastName the member last name of this staging member
	 */
	@Override
	public void setMemberLastName(String memberLastName) {
		model.setMemberLastName(memberLastName);
	}

	/**
	 * Sets the member number of this staging member.
	 *
	 * @param memberNumber the member number of this staging member
	 */
	@Override
	public void setMemberNumber(String memberNumber) {
		model.setMemberNumber(memberNumber);
	}

	/**
	 * Sets the modified date of this staging member.
	 *
	 * @param modifiedDate the modified date of this staging member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this staging member.
	 *
	 * @param primaryKey the primary key of this staging member
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rx number of this staging member.
	 *
	 * @param rxNumber the rx number of this staging member
	 */
	@Override
	public void setRxNumber(String rxNumber) {
		model.setRxNumber(rxNumber);
	}

	/**
	 * Sets the staging member ID of this staging member.
	 *
	 * @param stagingMemberId the staging member ID of this staging member
	 */
	@Override
	public void setStagingMemberId(long stagingMemberId) {
		model.setStagingMemberId(stagingMemberId);
	}

	@Override
	protected StagingMemberWrapper wrap(StagingMember stagingMember) {
		return new StagingMemberWrapper(stagingMember);
	}

}