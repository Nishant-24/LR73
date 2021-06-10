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
 * This class is a wrapper for {@link AuthProcedure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthProcedure
 * @generated
 */
public class AuthProcedureWrapper
	extends BaseModelWrapper<AuthProcedure>
	implements AuthProcedure, ModelWrapper<AuthProcedure> {

	public AuthProcedureWrapper(AuthProcedure authProcedure) {
		super(authProcedure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authProcedureId", getAuthProcedureId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalAuthorizationId", getExternalAuthorizationId());
		attributes.put("authNumber", getAuthNumber());
		attributes.put("medicalCodeId", getMedicalCodeId());
		attributes.put("description", getDescription());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authProcedureId = (Long)attributes.get("authProcedureId");

		if (authProcedureId != null) {
			setAuthProcedureId(authProcedureId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalAuthorizationId = (Long)attributes.get(
			"externalAuthorizationId");

		if (externalAuthorizationId != null) {
			setExternalAuthorizationId(externalAuthorizationId);
		}

		String authNumber = (String)attributes.get("authNumber");

		if (authNumber != null) {
			setAuthNumber(authNumber);
		}

		String medicalCodeId = (String)attributes.get("medicalCodeId");

		if (medicalCodeId != null) {
			setMedicalCodeId(medicalCodeId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	}

	/**
	 * Returns the auth number of this auth procedure.
	 *
	 * @return the auth number of this auth procedure
	 */
	@Override
	public String getAuthNumber() {
		return model.getAuthNumber();
	}

	/**
	 * Returns the auth procedure ID of this auth procedure.
	 *
	 * @return the auth procedure ID of this auth procedure
	 */
	@Override
	public long getAuthProcedureId() {
		return model.getAuthProcedureId();
	}

	/**
	 * Returns the create date of this auth procedure.
	 *
	 * @return the create date of this auth procedure
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this auth procedure.
	 *
	 * @return the description of this auth procedure
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external authorization ID of this auth procedure.
	 *
	 * @return the external authorization ID of this auth procedure
	 */
	@Override
	public long getExternalAuthorizationId() {
		return model.getExternalAuthorizationId();
	}

	/**
	 * Returns the external created date of this auth procedure.
	 *
	 * @return the external created date of this auth procedure
	 */
	@Override
	public Date getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this auth procedure.
	 *
	 * @return the external modified date of this auth procedure
	 */
	@Override
	public Date getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the medical code ID of this auth procedure.
	 *
	 * @return the medical code ID of this auth procedure
	 */
	@Override
	public String getMedicalCodeId() {
		return model.getMedicalCodeId();
	}

	/**
	 * Returns the modified date of this auth procedure.
	 *
	 * @return the modified date of this auth procedure
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this auth procedure.
	 *
	 * @return the primary key of this auth procedure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the auth number of this auth procedure.
	 *
	 * @param authNumber the auth number of this auth procedure
	 */
	@Override
	public void setAuthNumber(String authNumber) {
		model.setAuthNumber(authNumber);
	}

	/**
	 * Sets the auth procedure ID of this auth procedure.
	 *
	 * @param authProcedureId the auth procedure ID of this auth procedure
	 */
	@Override
	public void setAuthProcedureId(long authProcedureId) {
		model.setAuthProcedureId(authProcedureId);
	}

	/**
	 * Sets the create date of this auth procedure.
	 *
	 * @param createDate the create date of this auth procedure
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this auth procedure.
	 *
	 * @param description the description of this auth procedure
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external authorization ID of this auth procedure.
	 *
	 * @param externalAuthorizationId the external authorization ID of this auth procedure
	 */
	@Override
	public void setExternalAuthorizationId(long externalAuthorizationId) {
		model.setExternalAuthorizationId(externalAuthorizationId);
	}

	/**
	 * Sets the external created date of this auth procedure.
	 *
	 * @param externalCreatedDate the external created date of this auth procedure
	 */
	@Override
	public void setExternalCreatedDate(Date externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this auth procedure.
	 *
	 * @param externalModifiedDate the external modified date of this auth procedure
	 */
	@Override
	public void setExternalModifiedDate(Date externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the medical code ID of this auth procedure.
	 *
	 * @param medicalCodeId the medical code ID of this auth procedure
	 */
	@Override
	public void setMedicalCodeId(String medicalCodeId) {
		model.setMedicalCodeId(medicalCodeId);
	}

	/**
	 * Sets the modified date of this auth procedure.
	 *
	 * @param modifiedDate the modified date of this auth procedure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this auth procedure.
	 *
	 * @param primaryKey the primary key of this auth procedure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AuthProcedureWrapper wrap(AuthProcedure authProcedure) {
		return new AuthProcedureWrapper(authProcedure);
	}

}