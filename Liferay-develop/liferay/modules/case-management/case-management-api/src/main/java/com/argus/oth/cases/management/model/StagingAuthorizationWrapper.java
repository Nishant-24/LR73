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
 * This class is a wrapper for {@link StagingAuthorization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthorization
 * @generated
 */
public class StagingAuthorizationWrapper
	extends BaseModelWrapper<StagingAuthorization>
	implements ModelWrapper<StagingAuthorization>, StagingAuthorization {

	public StagingAuthorizationWrapper(
		StagingAuthorization stagingAuthorization) {

		super(stagingAuthorization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingAuthorizationId", getStagingAuthorizationId());
		attributes.put("createDate", getCreateDate());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("externalAuthorizationId", getExternalAuthorizationId());
		attributes.put("externalMemberId", getExternalMemberId());
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
		attributes.put("effectiveFrom", getEffectiveFrom());
		attributes.put("effectiveThru", getEffectiveThru());
		attributes.put("externalCreateDate", getExternalCreateDate());
		attributes.put("externalModifiedDate", getExternalModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingAuthorizationId = (Long)attributes.get(
			"stagingAuthorizationId");

		if (stagingAuthorizationId != null) {
			setStagingAuthorizationId(stagingAuthorizationId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		Long externalAuthorizationId = (Long)attributes.get(
			"externalAuthorizationId");

		if (externalAuthorizationId != null) {
			setExternalAuthorizationId(externalAuthorizationId);
		}

		Long externalMemberId = (Long)attributes.get("externalMemberId");

		if (externalMemberId != null) {
			setExternalMemberId(externalMemberId);
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

		String statusChangeDate = (String)attributes.get("statusChangeDate");

		if (statusChangeDate != null) {
			setStatusChangeDate(statusChangeDate);
		}

		String receivedDate = (String)attributes.get("receivedDate");

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

		String effectiveFrom = (String)attributes.get("effectiveFrom");

		if (effectiveFrom != null) {
			setEffectiveFrom(effectiveFrom);
		}

		String effectiveThru = (String)attributes.get("effectiveThru");

		if (effectiveThru != null) {
			setEffectiveThru(effectiveThru);
		}

		String externalCreateDate = (String)attributes.get(
			"externalCreateDate");

		if (externalCreateDate != null) {
			setExternalCreateDate(externalCreateDate);
		}

		String externalModifiedDate = (String)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}
	}

	/**
	 * Returns the auth number of this staging authorization.
	 *
	 * @return the auth number of this staging authorization
	 */
	@Override
	public String getAuthNumber() {
		return model.getAuthNumber();
	}

	/**
	 * Returns the auth status of this staging authorization.
	 *
	 * @return the auth status of this staging authorization
	 */
	@Override
	public String getAuthStatus() {
		return model.getAuthStatus();
	}

	/**
	 * Returns the category of this staging authorization.
	 *
	 * @return the category of this staging authorization
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the comments of this staging authorization.
	 *
	 * @return the comments of this staging authorization
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the create date of this staging authorization.
	 *
	 * @return the create date of this staging authorization
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this staging authorization.
	 *
	 * @return the description of this staging authorization
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the effective from of this staging authorization.
	 *
	 * @return the effective from of this staging authorization
	 */
	@Override
	public String getEffectiveFrom() {
		return model.getEffectiveFrom();
	}

	/**
	 * Returns the effective thru of this staging authorization.
	 *
	 * @return the effective thru of this staging authorization
	 */
	@Override
	public String getEffectiveThru() {
		return model.getEffectiveThru();
	}

	/**
	 * Returns the external authorization ID of this staging authorization.
	 *
	 * @return the external authorization ID of this staging authorization
	 */
	@Override
	public long getExternalAuthorizationId() {
		return model.getExternalAuthorizationId();
	}

	/**
	 * Returns the external case ID of this staging authorization.
	 *
	 * @return the external case ID of this staging authorization
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the external create date of this staging authorization.
	 *
	 * @return the external create date of this staging authorization
	 */
	@Override
	public String getExternalCreateDate() {
		return model.getExternalCreateDate();
	}

	/**
	 * Returns the external member ID of this staging authorization.
	 *
	 * @return the external member ID of this staging authorization
	 */
	@Override
	public long getExternalMemberId() {
		return model.getExternalMemberId();
	}

	/**
	 * Returns the external modified date of this staging authorization.
	 *
	 * @return the external modified date of this staging authorization
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the facility of this staging authorization.
	 *
	 * @return the facility of this staging authorization
	 */
	@Override
	public String getFacility() {
		return model.getFacility();
	}

	/**
	 * Returns the primary key of this staging authorization.
	 *
	 * @return the primary key of this staging authorization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure code of this staging authorization.
	 *
	 * @return the procedure code of this staging authorization
	 */
	@Override
	public String getProcedureCode() {
		return model.getProcedureCode();
	}

	/**
	 * Returns the received date of this staging authorization.
	 *
	 * @return the received date of this staging authorization
	 */
	@Override
	public String getReceivedDate() {
		return model.getReceivedDate();
	}

	/**
	 * Returns the rtc authorization status of this staging authorization.
	 *
	 * @return the rtc authorization status of this staging authorization
	 */
	@Override
	public String getRtcAuthorizationStatus() {
		return model.getRtcAuthorizationStatus();
	}

	/**
	 * Returns the rtc authorization type of this staging authorization.
	 *
	 * @return the rtc authorization type of this staging authorization
	 */
	@Override
	public String getRtcAuthorizationType() {
		return model.getRtcAuthorizationType();
	}

	/**
	 * Returns the staging authorization ID of this staging authorization.
	 *
	 * @return the staging authorization ID of this staging authorization
	 */
	@Override
	public long getStagingAuthorizationId() {
		return model.getStagingAuthorizationId();
	}

	/**
	 * Returns the status change date of this staging authorization.
	 *
	 * @return the status change date of this staging authorization
	 */
	@Override
	public String getStatusChangeDate() {
		return model.getStatusChangeDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the auth number of this staging authorization.
	 *
	 * @param authNumber the auth number of this staging authorization
	 */
	@Override
	public void setAuthNumber(String authNumber) {
		model.setAuthNumber(authNumber);
	}

	/**
	 * Sets the auth status of this staging authorization.
	 *
	 * @param authStatus the auth status of this staging authorization
	 */
	@Override
	public void setAuthStatus(String authStatus) {
		model.setAuthStatus(authStatus);
	}

	/**
	 * Sets the category of this staging authorization.
	 *
	 * @param category the category of this staging authorization
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the comments of this staging authorization.
	 *
	 * @param comments the comments of this staging authorization
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the create date of this staging authorization.
	 *
	 * @param createDate the create date of this staging authorization
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this staging authorization.
	 *
	 * @param description the description of this staging authorization
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the effective from of this staging authorization.
	 *
	 * @param effectiveFrom the effective from of this staging authorization
	 */
	@Override
	public void setEffectiveFrom(String effectiveFrom) {
		model.setEffectiveFrom(effectiveFrom);
	}

	/**
	 * Sets the effective thru of this staging authorization.
	 *
	 * @param effectiveThru the effective thru of this staging authorization
	 */
	@Override
	public void setEffectiveThru(String effectiveThru) {
		model.setEffectiveThru(effectiveThru);
	}

	/**
	 * Sets the external authorization ID of this staging authorization.
	 *
	 * @param externalAuthorizationId the external authorization ID of this staging authorization
	 */
	@Override
	public void setExternalAuthorizationId(long externalAuthorizationId) {
		model.setExternalAuthorizationId(externalAuthorizationId);
	}

	/**
	 * Sets the external case ID of this staging authorization.
	 *
	 * @param externalCaseId the external case ID of this staging authorization
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the external create date of this staging authorization.
	 *
	 * @param externalCreateDate the external create date of this staging authorization
	 */
	@Override
	public void setExternalCreateDate(String externalCreateDate) {
		model.setExternalCreateDate(externalCreateDate);
	}

	/**
	 * Sets the external member ID of this staging authorization.
	 *
	 * @param externalMemberId the external member ID of this staging authorization
	 */
	@Override
	public void setExternalMemberId(long externalMemberId) {
		model.setExternalMemberId(externalMemberId);
	}

	/**
	 * Sets the external modified date of this staging authorization.
	 *
	 * @param externalModifiedDate the external modified date of this staging authorization
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the facility of this staging authorization.
	 *
	 * @param facility the facility of this staging authorization
	 */
	@Override
	public void setFacility(String facility) {
		model.setFacility(facility);
	}

	/**
	 * Sets the primary key of this staging authorization.
	 *
	 * @param primaryKey the primary key of this staging authorization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure code of this staging authorization.
	 *
	 * @param procedureCode the procedure code of this staging authorization
	 */
	@Override
	public void setProcedureCode(String procedureCode) {
		model.setProcedureCode(procedureCode);
	}

	/**
	 * Sets the received date of this staging authorization.
	 *
	 * @param receivedDate the received date of this staging authorization
	 */
	@Override
	public void setReceivedDate(String receivedDate) {
		model.setReceivedDate(receivedDate);
	}

	/**
	 * Sets the rtc authorization status of this staging authorization.
	 *
	 * @param rtcAuthorizationStatus the rtc authorization status of this staging authorization
	 */
	@Override
	public void setRtcAuthorizationStatus(String rtcAuthorizationStatus) {
		model.setRtcAuthorizationStatus(rtcAuthorizationStatus);
	}

	/**
	 * Sets the rtc authorization type of this staging authorization.
	 *
	 * @param rtcAuthorizationType the rtc authorization type of this staging authorization
	 */
	@Override
	public void setRtcAuthorizationType(String rtcAuthorizationType) {
		model.setRtcAuthorizationType(rtcAuthorizationType);
	}

	/**
	 * Sets the staging authorization ID of this staging authorization.
	 *
	 * @param stagingAuthorizationId the staging authorization ID of this staging authorization
	 */
	@Override
	public void setStagingAuthorizationId(long stagingAuthorizationId) {
		model.setStagingAuthorizationId(stagingAuthorizationId);
	}

	/**
	 * Sets the status change date of this staging authorization.
	 *
	 * @param statusChangeDate the status change date of this staging authorization
	 */
	@Override
	public void setStatusChangeDate(String statusChangeDate) {
		model.setStatusChangeDate(statusChangeDate);
	}

	@Override
	protected StagingAuthorizationWrapper wrap(
		StagingAuthorization stagingAuthorization) {

		return new StagingAuthorizationWrapper(stagingAuthorization);
	}

}