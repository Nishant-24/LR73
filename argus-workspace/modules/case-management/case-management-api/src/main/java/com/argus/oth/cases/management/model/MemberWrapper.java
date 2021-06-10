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
 * This class is a wrapper for {@link Member}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Member
 * @generated
 */
public class MemberWrapper
	extends BaseModelWrapper<Member> implements Member, ModelWrapper<Member> {

	public MemberWrapper(Member member) {
		super(member);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberId", getMemberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
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
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
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

		Date memberDOB = (Date)attributes.get("memberDOB");

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

		Date externalModifiedDate = (Date)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		Date externalCreatedDate = (Date)attributes.get("externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the certification number of this member.
	 *
	 * @return the certification number of this member
	 */
	@Override
	public String getCertificationNumber() {
		return model.getCertificationNumber();
	}

	/**
	 * Returns the client group ID of this member.
	 *
	 * @return the client group ID of this member
	 */
	@Override
	public long getClientGroupId() {
		return model.getClientGroupId();
	}

	/**
	 * Returns the client ID of this member.
	 *
	 * @return the client ID of this member
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the company ID of this member.
	 *
	 * @return the company ID of this member
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this member.
	 *
	 * @return the create date of this member
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external created date of this member.
	 *
	 * @return the external created date of this member
	 */
	@Override
	public Date getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external member ID of this member.
	 *
	 * @return the external member ID of this member
	 */
	@Override
	public long getExternalMemberId() {
		return model.getExternalMemberId();
	}

	/**
	 * Returns the external modified date of this member.
	 *
	 * @return the external modified date of this member
	 */
	@Override
	public Date getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the group ID of this member.
	 *
	 * @return the group ID of this member
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the member dob of this member.
	 *
	 * @return the member dob of this member
	 */
	@Override
	public Date getMemberDOB() {
		return model.getMemberDOB();
	}

	/**
	 * Returns the member first name of this member.
	 *
	 * @return the member first name of this member
	 */
	@Override
	public String getMemberFirstName() {
		return model.getMemberFirstName();
	}

	/**
	 * Returns the member ID of this member.
	 *
	 * @return the member ID of this member
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the member last name of this member.
	 *
	 * @return the member last name of this member
	 */
	@Override
	public String getMemberLastName() {
		return model.getMemberLastName();
	}

	/**
	 * Returns the member number of this member.
	 *
	 * @return the member number of this member
	 */
	@Override
	public String getMemberNumber() {
		return model.getMemberNumber();
	}

	/**
	 * Returns the modified date of this member.
	 *
	 * @return the modified date of this member
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this member.
	 *
	 * @return the primary key of this member
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the row processed of this member.
	 *
	 * @return the row processed of this member
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the rx number of this member.
	 *
	 * @return the rx number of this member
	 */
	@Override
	public String getRxNumber() {
		return model.getRxNumber();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the certification number of this member.
	 *
	 * @param certificationNumber the certification number of this member
	 */
	@Override
	public void setCertificationNumber(String certificationNumber) {
		model.setCertificationNumber(certificationNumber);
	}

	/**
	 * Sets the client group ID of this member.
	 *
	 * @param clientGroupId the client group ID of this member
	 */
	@Override
	public void setClientGroupId(long clientGroupId) {
		model.setClientGroupId(clientGroupId);
	}

	/**
	 * Sets the client ID of this member.
	 *
	 * @param clientId the client ID of this member
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the company ID of this member.
	 *
	 * @param companyId the company ID of this member
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this member.
	 *
	 * @param createDate the create date of this member
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external created date of this member.
	 *
	 * @param externalCreatedDate the external created date of this member
	 */
	@Override
	public void setExternalCreatedDate(Date externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external member ID of this member.
	 *
	 * @param externalMemberId the external member ID of this member
	 */
	@Override
	public void setExternalMemberId(long externalMemberId) {
		model.setExternalMemberId(externalMemberId);
	}

	/**
	 * Sets the external modified date of this member.
	 *
	 * @param externalModifiedDate the external modified date of this member
	 */
	@Override
	public void setExternalModifiedDate(Date externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the group ID of this member.
	 *
	 * @param groupId the group ID of this member
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the member dob of this member.
	 *
	 * @param memberDOB the member dob of this member
	 */
	@Override
	public void setMemberDOB(Date memberDOB) {
		model.setMemberDOB(memberDOB);
	}

	/**
	 * Sets the member first name of this member.
	 *
	 * @param memberFirstName the member first name of this member
	 */
	@Override
	public void setMemberFirstName(String memberFirstName) {
		model.setMemberFirstName(memberFirstName);
	}

	/**
	 * Sets the member ID of this member.
	 *
	 * @param memberId the member ID of this member
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the member last name of this member.
	 *
	 * @param memberLastName the member last name of this member
	 */
	@Override
	public void setMemberLastName(String memberLastName) {
		model.setMemberLastName(memberLastName);
	}

	/**
	 * Sets the member number of this member.
	 *
	 * @param memberNumber the member number of this member
	 */
	@Override
	public void setMemberNumber(String memberNumber) {
		model.setMemberNumber(memberNumber);
	}

	/**
	 * Sets the modified date of this member.
	 *
	 * @param modifiedDate the modified date of this member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this member.
	 *
	 * @param primaryKey the primary key of this member
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the row processed of this member.
	 *
	 * @param rowProcessed the row processed of this member
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the rx number of this member.
	 *
	 * @param rxNumber the rx number of this member
	 */
	@Override
	public void setRxNumber(String rxNumber) {
		model.setRxNumber(rxNumber);
	}

	@Override
	protected MemberWrapper wrap(Member member) {
		return new MemberWrapper(member);
	}

}