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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Authorization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Authorization
 * @generated
 */
public class AuthorizationWrapper
	extends BaseModelWrapper<Authorization>
	implements Authorization, ModelWrapper<Authorization> {

	public AuthorizationWrapper(Authorization authorization) {
		super(authorization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("authorizationId", getAuthorizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("caseId", getCaseId());
		attributes.put("externalAuthorizationId", getExternalAuthorizationId());
		attributes.put("memberId", getMemberId());
		attributes.put("description", getDescription());
		attributes.put("rtcAuthorizationStatus", getRtcAuthorizationStatus());
		attributes.put("authStatus", getAuthStatus());
		attributes.put("statusChangeDate", getStatusChangeDate());
		attributes.put("receivedDate", getReceivedDate());
		attributes.put("authNumber", getAuthNumber());
		attributes.put("category", getCategory());
		attributes.put("rtcAuthorizationType", getRtcAuthorizationType());
		attributes.put("facility", getFacility());
		attributes.put("procedureCode", getProcedureCode());
		attributes.put("comments", getComments());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("effectiveFrom", getEffectiveFrom());
		attributes.put("effectiveThru", getEffectiveThru());
		attributes.put("processStatus", getProcessStatus());
		attributes.put("failureDescription", getFailureDescription());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long authorizationId = (Long)attributes.get("authorizationId");

		if (authorizationId != null) {
			setAuthorizationId(authorizationId);
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

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
		}

		Long externalAuthorizationId = (Long)attributes.get(
			"externalAuthorizationId");

		if (externalAuthorizationId != null) {
			setExternalAuthorizationId(externalAuthorizationId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String rtcAuthorizationStatus = (String)attributes.get(
			"rtcAuthorizationStatus");

		if (rtcAuthorizationStatus != null) {
			setRtcAuthorizationStatus(rtcAuthorizationStatus);
		}

		String authStatus = (String)attributes.get("authStatus");

		if (authStatus != null) {
			setAuthStatus(authStatus);
		}

		Date statusChangeDate = (Date)attributes.get("statusChangeDate");

		if (statusChangeDate != null) {
			setStatusChangeDate(statusChangeDate);
		}

		Date receivedDate = (Date)attributes.get("receivedDate");

		if (receivedDate != null) {
			setReceivedDate(receivedDate);
		}

		String authNumber = (String)attributes.get("authNumber");

		if (authNumber != null) {
			setAuthNumber(authNumber);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String rtcAuthorizationType = (String)attributes.get(
			"rtcAuthorizationType");

		if (rtcAuthorizationType != null) {
			setRtcAuthorizationType(rtcAuthorizationType);
		}

		String facility = (String)attributes.get("facility");

		if (facility != null) {
			setFacility(facility);
		}

		String procedureCode = (String)attributes.get("procedureCode");

		if (procedureCode != null) {
			setProcedureCode(procedureCode);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Date externalModifiedDate = (Date)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		Date effectiveFrom = (Date)attributes.get("effectiveFrom");

		if (effectiveFrom != null) {
			setEffectiveFrom(effectiveFrom);
		}

		Date effectiveThru = (Date)attributes.get("effectiveThru");

		if (effectiveThru != null) {
			setEffectiveThru(effectiveThru);
		}

		String processStatus = (String)attributes.get("processStatus");

		if (processStatus != null) {
			setProcessStatus(processStatus);
		}

		String failureDescription = (String)attributes.get(
			"failureDescription");

		if (failureDescription != null) {
			setFailureDescription(failureDescription);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the auth number of this authorization.
	 *
	 * @return the auth number of this authorization
	 */
	@Override
	public String getAuthNumber() {
		return model.getAuthNumber();
	}

	/**
	 * Returns the authorization ID of this authorization.
	 *
	 * @return the authorization ID of this authorization
	 */
	@Override
	public long getAuthorizationId() {
		return model.getAuthorizationId();
	}

	/**
	 * Returns the auth status of this authorization.
	 *
	 * @return the auth status of this authorization
	 */
	@Override
	public String getAuthStatus() {
		return model.getAuthStatus();
	}

	/**
	 * Returns the case ID of this authorization.
	 *
	 * @return the case ID of this authorization
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the category of this authorization.
	 *
	 * @return the category of this authorization
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the comments of this authorization.
	 *
	 * @return the comments of this authorization
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the company ID of this authorization.
	 *
	 * @return the company ID of this authorization
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this authorization.
	 *
	 * @return the create date of this authorization
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this authorization.
	 *
	 * @return the description of this authorization
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the effective from of this authorization.
	 *
	 * @return the effective from of this authorization
	 */
	@Override
	public Date getEffectiveFrom() {
		return model.getEffectiveFrom();
	}

	/**
	 * Returns the effective thru of this authorization.
	 *
	 * @return the effective thru of this authorization
	 */
	@Override
	public Date getEffectiveThru() {
		return model.getEffectiveThru();
	}

	/**
	 * Returns the external authorization ID of this authorization.
	 *
	 * @return the external authorization ID of this authorization
	 */
	@Override
	public long getExternalAuthorizationId() {
		return model.getExternalAuthorizationId();
	}

	/**
	 * Returns the external modified date of this authorization.
	 *
	 * @return the external modified date of this authorization
	 */
	@Override
	public Date getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the facility of this authorization.
	 *
	 * @return the facility of this authorization
	 */
	@Override
	public String getFacility() {
		return model.getFacility();
	}

	/**
	 * Returns the failure description of this authorization.
	 *
	 * @return the failure description of this authorization
	 */
	@Override
	public String getFailureDescription() {
		return model.getFailureDescription();
	}

	/**
	 * Returns the group ID of this authorization.
	 *
	 * @return the group ID of this authorization
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the member ID of this authorization.
	 *
	 * @return the member ID of this authorization
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the modified date of this authorization.
	 *
	 * @return the modified date of this authorization
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified user ID of this authorization.
	 *
	 * @return the modified user ID of this authorization
	 */
	@Override
	public long getModifiedUserId() {
		return model.getModifiedUserId();
	}

	/**
	 * Returns the modified user uuid of this authorization.
	 *
	 * @return the modified user uuid of this authorization
	 */
	@Override
	public String getModifiedUserUuid() {
		return model.getModifiedUserUuid();
	}

	/**
	 * Returns the primary key of this authorization.
	 *
	 * @return the primary key of this authorization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure code of this authorization.
	 *
	 * @return the procedure code of this authorization
	 */
	@Override
	public String getProcedureCode() {
		return model.getProcedureCode();
	}

	/**
	 * Returns the process status of this authorization.
	 *
	 * @return the process status of this authorization
	 */
	@Override
	public String getProcessStatus() {
		return model.getProcessStatus();
	}

	/**
	 * Returns the received date of this authorization.
	 *
	 * @return the received date of this authorization
	 */
	@Override
	public Date getReceivedDate() {
		return model.getReceivedDate();
	}

	/**
	 * Returns the row processed of this authorization.
	 *
	 * @return the row processed of this authorization
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the rtc authorization status of this authorization.
	 *
	 * @return the rtc authorization status of this authorization
	 */
	@Override
	public String getRtcAuthorizationStatus() {
		return model.getRtcAuthorizationStatus();
	}

	/**
	 * Returns the rtc authorization type of this authorization.
	 *
	 * @return the rtc authorization type of this authorization
	 */
	@Override
	public String getRtcAuthorizationType() {
		return model.getRtcAuthorizationType();
	}

	/**
	 * Returns the status change date of this authorization.
	 *
	 * @return the status change date of this authorization
	 */
	@Override
	public Date getStatusChangeDate() {
		return model.getStatusChangeDate();
	}

	/**
	 * Returns the uuid of this authorization.
	 *
	 * @return the uuid of this authorization
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the auth number of this authorization.
	 *
	 * @param authNumber the auth number of this authorization
	 */
	@Override
	public void setAuthNumber(String authNumber) {
		model.setAuthNumber(authNumber);
	}

	/**
	 * Sets the authorization ID of this authorization.
	 *
	 * @param authorizationId the authorization ID of this authorization
	 */
	@Override
	public void setAuthorizationId(long authorizationId) {
		model.setAuthorizationId(authorizationId);
	}

	/**
	 * Sets the auth status of this authorization.
	 *
	 * @param authStatus the auth status of this authorization
	 */
	@Override
	public void setAuthStatus(String authStatus) {
		model.setAuthStatus(authStatus);
	}

	/**
	 * Sets the case ID of this authorization.
	 *
	 * @param caseId the case ID of this authorization
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the category of this authorization.
	 *
	 * @param category the category of this authorization
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the comments of this authorization.
	 *
	 * @param comments the comments of this authorization
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the company ID of this authorization.
	 *
	 * @param companyId the company ID of this authorization
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this authorization.
	 *
	 * @param createDate the create date of this authorization
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this authorization.
	 *
	 * @param description the description of this authorization
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the effective from of this authorization.
	 *
	 * @param effectiveFrom the effective from of this authorization
	 */
	@Override
	public void setEffectiveFrom(Date effectiveFrom) {
		model.setEffectiveFrom(effectiveFrom);
	}

	/**
	 * Sets the effective thru of this authorization.
	 *
	 * @param effectiveThru the effective thru of this authorization
	 */
	@Override
	public void setEffectiveThru(Date effectiveThru) {
		model.setEffectiveThru(effectiveThru);
	}

	/**
	 * Sets the external authorization ID of this authorization.
	 *
	 * @param externalAuthorizationId the external authorization ID of this authorization
	 */
	@Override
	public void setExternalAuthorizationId(long externalAuthorizationId) {
		model.setExternalAuthorizationId(externalAuthorizationId);
	}

	/**
	 * Sets the external modified date of this authorization.
	 *
	 * @param externalModifiedDate the external modified date of this authorization
	 */
	@Override
	public void setExternalModifiedDate(Date externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the facility of this authorization.
	 *
	 * @param facility the facility of this authorization
	 */
	@Override
	public void setFacility(String facility) {
		model.setFacility(facility);
	}

	/**
	 * Sets the failure description of this authorization.
	 *
	 * @param failureDescription the failure description of this authorization
	 */
	@Override
	public void setFailureDescription(String failureDescription) {
		model.setFailureDescription(failureDescription);
	}

	/**
	 * Sets the group ID of this authorization.
	 *
	 * @param groupId the group ID of this authorization
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the member ID of this authorization.
	 *
	 * @param memberId the member ID of this authorization
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the modified date of this authorization.
	 *
	 * @param modifiedDate the modified date of this authorization
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified user ID of this authorization.
	 *
	 * @param modifiedUserId the modified user ID of this authorization
	 */
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		model.setModifiedUserId(modifiedUserId);
	}

	/**
	 * Sets the modified user uuid of this authorization.
	 *
	 * @param modifiedUserUuid the modified user uuid of this authorization
	 */
	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		model.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	 * Sets the primary key of this authorization.
	 *
	 * @param primaryKey the primary key of this authorization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure code of this authorization.
	 *
	 * @param procedureCode the procedure code of this authorization
	 */
	@Override
	public void setProcedureCode(String procedureCode) {
		model.setProcedureCode(procedureCode);
	}

	/**
	 * Sets the process status of this authorization.
	 *
	 * @param processStatus the process status of this authorization
	 */
	@Override
	public void setProcessStatus(String processStatus) {
		model.setProcessStatus(processStatus);
	}

	/**
	 * Sets the received date of this authorization.
	 *
	 * @param receivedDate the received date of this authorization
	 */
	@Override
	public void setReceivedDate(Date receivedDate) {
		model.setReceivedDate(receivedDate);
	}

	/**
	 * Sets the row processed of this authorization.
	 *
	 * @param rowProcessed the row processed of this authorization
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the rtc authorization status of this authorization.
	 *
	 * @param rtcAuthorizationStatus the rtc authorization status of this authorization
	 */
	@Override
	public void setRtcAuthorizationStatus(String rtcAuthorizationStatus) {
		model.setRtcAuthorizationStatus(rtcAuthorizationStatus);
	}

	/**
	 * Sets the rtc authorization type of this authorization.
	 *
	 * @param rtcAuthorizationType the rtc authorization type of this authorization
	 */
	@Override
	public void setRtcAuthorizationType(String rtcAuthorizationType) {
		model.setRtcAuthorizationType(rtcAuthorizationType);
	}

	/**
	 * Sets the status change date of this authorization.
	 *
	 * @param statusChangeDate the status change date of this authorization
	 */
	@Override
	public void setStatusChangeDate(Date statusChangeDate) {
		model.setStatusChangeDate(statusChangeDate);
	}

	/**
	 * Sets the uuid of this authorization.
	 *
	 * @param uuid the uuid of this authorization
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AuthorizationWrapper wrap(Authorization authorization) {
		return new AuthorizationWrapper(authorization);
	}

}