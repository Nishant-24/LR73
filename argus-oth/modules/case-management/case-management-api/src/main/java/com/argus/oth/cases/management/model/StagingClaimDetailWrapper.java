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
 * This class is a wrapper for {@link StagingClaimDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetail
 * @generated
 */
public class StagingClaimDetailWrapper
	extends BaseModelWrapper<StagingClaimDetail>
	implements ModelWrapper<StagingClaimDetail>, StagingClaimDetail {

	public StagingClaimDetailWrapper(StagingClaimDetail stagingClaimDetail) {
		super(stagingClaimDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingClaimDetailId", getStagingClaimDetailId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lineId", getLineId());
		attributes.put("externalClaimId", getExternalClaimId());
		attributes.put("serviceFrom", getServiceFrom());
		attributes.put("serviceThru", getServiceThru());
		attributes.put("resultCodes", getResultCodes());
		attributes.put("procedureCode", getProcedureCode());
		attributes.put("chargedAmount", getChargedAmount());
		attributes.put("repricedAmount", getRepricedAmount());
		attributes.put("claimAmount", getClaimAmount());
		attributes.put("paidDate", getPaidDate());
		attributes.put("paidAmount", getPaidAmount());
		attributes.put("savingsAmount", getSavingsAmount());
		attributes.put("units", getUnits());
		attributes.put("coverage", getCoverage());
		attributes.put("lineStatus", getLineStatus());
		attributes.put("revCode", getRevCode());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingClaimDetailId = (Long)attributes.get(
			"stagingClaimDetailId");

		if (stagingClaimDetailId != null) {
			setStagingClaimDetailId(stagingClaimDetailId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long lineId = (Long)attributes.get("lineId");

		if (lineId != null) {
			setLineId(lineId);
		}

		Long externalClaimId = (Long)attributes.get("externalClaimId");

		if (externalClaimId != null) {
			setExternalClaimId(externalClaimId);
		}

		String serviceFrom = (String)attributes.get("serviceFrom");

		if (serviceFrom != null) {
			setServiceFrom(serviceFrom);
		}

		String serviceThru = (String)attributes.get("serviceThru");

		if (serviceThru != null) {
			setServiceThru(serviceThru);
		}

		String resultCodes = (String)attributes.get("resultCodes");

		if (resultCodes != null) {
			setResultCodes(resultCodes);
		}

		String procedureCode = (String)attributes.get("procedureCode");

		if (procedureCode != null) {
			setProcedureCode(procedureCode);
		}

		Double chargedAmount = (Double)attributes.get("chargedAmount");

		if (chargedAmount != null) {
			setChargedAmount(chargedAmount);
		}

		Double repricedAmount = (Double)attributes.get("repricedAmount");

		if (repricedAmount != null) {
			setRepricedAmount(repricedAmount);
		}

		Double claimAmount = (Double)attributes.get("claimAmount");

		if (claimAmount != null) {
			setClaimAmount(claimAmount);
		}

		String paidDate = (String)attributes.get("paidDate");

		if (paidDate != null) {
			setPaidDate(paidDate);
		}

		Double paidAmount = (Double)attributes.get("paidAmount");

		if (paidAmount != null) {
			setPaidAmount(paidAmount);
		}

		Double savingsAmount = (Double)attributes.get("savingsAmount");

		if (savingsAmount != null) {
			setSavingsAmount(savingsAmount);
		}

		Integer units = (Integer)attributes.get("units");

		if (units != null) {
			setUnits(units);
		}

		String coverage = (String)attributes.get("coverage");

		if (coverage != null) {
			setCoverage(coverage);
		}

		String lineStatus = (String)attributes.get("lineStatus");

		if (lineStatus != null) {
			setLineStatus(lineStatus);
		}

		String revCode = (String)attributes.get("revCode");

		if (revCode != null) {
			setRevCode(revCode);
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
	 * Returns the charged amount of this staging claim detail.
	 *
	 * @return the charged amount of this staging claim detail
	 */
	@Override
	public double getChargedAmount() {
		return model.getChargedAmount();
	}

	/**
	 * Returns the claim amount of this staging claim detail.
	 *
	 * @return the claim amount of this staging claim detail
	 */
	@Override
	public double getClaimAmount() {
		return model.getClaimAmount();
	}

	/**
	 * Returns the coverage of this staging claim detail.
	 *
	 * @return the coverage of this staging claim detail
	 */
	@Override
	public String getCoverage() {
		return model.getCoverage();
	}

	/**
	 * Returns the create date of this staging claim detail.
	 *
	 * @return the create date of this staging claim detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external claim ID of this staging claim detail.
	 *
	 * @return the external claim ID of this staging claim detail
	 */
	@Override
	public long getExternalClaimId() {
		return model.getExternalClaimId();
	}

	/**
	 * Returns the external created date of this staging claim detail.
	 *
	 * @return the external created date of this staging claim detail
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this staging claim detail.
	 *
	 * @return the external modified date of this staging claim detail
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the line ID of this staging claim detail.
	 *
	 * @return the line ID of this staging claim detail
	 */
	@Override
	public long getLineId() {
		return model.getLineId();
	}

	/**
	 * Returns the line status of this staging claim detail.
	 *
	 * @return the line status of this staging claim detail
	 */
	@Override
	public String getLineStatus() {
		return model.getLineStatus();
	}

	/**
	 * Returns the modified date of this staging claim detail.
	 *
	 * @return the modified date of this staging claim detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid amount of this staging claim detail.
	 *
	 * @return the paid amount of this staging claim detail
	 */
	@Override
	public double getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the paid date of this staging claim detail.
	 *
	 * @return the paid date of this staging claim detail
	 */
	@Override
	public String getPaidDate() {
		return model.getPaidDate();
	}

	/**
	 * Returns the primary key of this staging claim detail.
	 *
	 * @return the primary key of this staging claim detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure code of this staging claim detail.
	 *
	 * @return the procedure code of this staging claim detail
	 */
	@Override
	public String getProcedureCode() {
		return model.getProcedureCode();
	}

	/**
	 * Returns the repriced amount of this staging claim detail.
	 *
	 * @return the repriced amount of this staging claim detail
	 */
	@Override
	public double getRepricedAmount() {
		return model.getRepricedAmount();
	}

	/**
	 * Returns the result codes of this staging claim detail.
	 *
	 * @return the result codes of this staging claim detail
	 */
	@Override
	public String getResultCodes() {
		return model.getResultCodes();
	}

	/**
	 * Returns the rev code of this staging claim detail.
	 *
	 * @return the rev code of this staging claim detail
	 */
	@Override
	public String getRevCode() {
		return model.getRevCode();
	}

	/**
	 * Returns the savings amount of this staging claim detail.
	 *
	 * @return the savings amount of this staging claim detail
	 */
	@Override
	public double getSavingsAmount() {
		return model.getSavingsAmount();
	}

	/**
	 * Returns the service from of this staging claim detail.
	 *
	 * @return the service from of this staging claim detail
	 */
	@Override
	public String getServiceFrom() {
		return model.getServiceFrom();
	}

	/**
	 * Returns the service thru of this staging claim detail.
	 *
	 * @return the service thru of this staging claim detail
	 */
	@Override
	public String getServiceThru() {
		return model.getServiceThru();
	}

	/**
	 * Returns the staging claim detail ID of this staging claim detail.
	 *
	 * @return the staging claim detail ID of this staging claim detail
	 */
	@Override
	public long getStagingClaimDetailId() {
		return model.getStagingClaimDetailId();
	}

	/**
	 * Returns the units of this staging claim detail.
	 *
	 * @return the units of this staging claim detail
	 */
	@Override
	public int getUnits() {
		return model.getUnits();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the charged amount of this staging claim detail.
	 *
	 * @param chargedAmount the charged amount of this staging claim detail
	 */
	@Override
	public void setChargedAmount(double chargedAmount) {
		model.setChargedAmount(chargedAmount);
	}

	/**
	 * Sets the claim amount of this staging claim detail.
	 *
	 * @param claimAmount the claim amount of this staging claim detail
	 */
	@Override
	public void setClaimAmount(double claimAmount) {
		model.setClaimAmount(claimAmount);
	}

	/**
	 * Sets the coverage of this staging claim detail.
	 *
	 * @param coverage the coverage of this staging claim detail
	 */
	@Override
	public void setCoverage(String coverage) {
		model.setCoverage(coverage);
	}

	/**
	 * Sets the create date of this staging claim detail.
	 *
	 * @param createDate the create date of this staging claim detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external claim ID of this staging claim detail.
	 *
	 * @param externalClaimId the external claim ID of this staging claim detail
	 */
	@Override
	public void setExternalClaimId(long externalClaimId) {
		model.setExternalClaimId(externalClaimId);
	}

	/**
	 * Sets the external created date of this staging claim detail.
	 *
	 * @param externalCreatedDate the external created date of this staging claim detail
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this staging claim detail.
	 *
	 * @param externalModifiedDate the external modified date of this staging claim detail
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the line ID of this staging claim detail.
	 *
	 * @param lineId the line ID of this staging claim detail
	 */
	@Override
	public void setLineId(long lineId) {
		model.setLineId(lineId);
	}

	/**
	 * Sets the line status of this staging claim detail.
	 *
	 * @param lineStatus the line status of this staging claim detail
	 */
	@Override
	public void setLineStatus(String lineStatus) {
		model.setLineStatus(lineStatus);
	}

	/**
	 * Sets the modified date of this staging claim detail.
	 *
	 * @param modifiedDate the modified date of this staging claim detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid amount of this staging claim detail.
	 *
	 * @param paidAmount the paid amount of this staging claim detail
	 */
	@Override
	public void setPaidAmount(double paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the paid date of this staging claim detail.
	 *
	 * @param paidDate the paid date of this staging claim detail
	 */
	@Override
	public void setPaidDate(String paidDate) {
		model.setPaidDate(paidDate);
	}

	/**
	 * Sets the primary key of this staging claim detail.
	 *
	 * @param primaryKey the primary key of this staging claim detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure code of this staging claim detail.
	 *
	 * @param procedureCode the procedure code of this staging claim detail
	 */
	@Override
	public void setProcedureCode(String procedureCode) {
		model.setProcedureCode(procedureCode);
	}

	/**
	 * Sets the repriced amount of this staging claim detail.
	 *
	 * @param repricedAmount the repriced amount of this staging claim detail
	 */
	@Override
	public void setRepricedAmount(double repricedAmount) {
		model.setRepricedAmount(repricedAmount);
	}

	/**
	 * Sets the result codes of this staging claim detail.
	 *
	 * @param resultCodes the result codes of this staging claim detail
	 */
	@Override
	public void setResultCodes(String resultCodes) {
		model.setResultCodes(resultCodes);
	}

	/**
	 * Sets the rev code of this staging claim detail.
	 *
	 * @param revCode the rev code of this staging claim detail
	 */
	@Override
	public void setRevCode(String revCode) {
		model.setRevCode(revCode);
	}

	/**
	 * Sets the savings amount of this staging claim detail.
	 *
	 * @param savingsAmount the savings amount of this staging claim detail
	 */
	@Override
	public void setSavingsAmount(double savingsAmount) {
		model.setSavingsAmount(savingsAmount);
	}

	/**
	 * Sets the service from of this staging claim detail.
	 *
	 * @param serviceFrom the service from of this staging claim detail
	 */
	@Override
	public void setServiceFrom(String serviceFrom) {
		model.setServiceFrom(serviceFrom);
	}

	/**
	 * Sets the service thru of this staging claim detail.
	 *
	 * @param serviceThru the service thru of this staging claim detail
	 */
	@Override
	public void setServiceThru(String serviceThru) {
		model.setServiceThru(serviceThru);
	}

	/**
	 * Sets the staging claim detail ID of this staging claim detail.
	 *
	 * @param stagingClaimDetailId the staging claim detail ID of this staging claim detail
	 */
	@Override
	public void setStagingClaimDetailId(long stagingClaimDetailId) {
		model.setStagingClaimDetailId(stagingClaimDetailId);
	}

	/**
	 * Sets the units of this staging claim detail.
	 *
	 * @param units the units of this staging claim detail
	 */
	@Override
	public void setUnits(int units) {
		model.setUnits(units);
	}

	@Override
	protected StagingClaimDetailWrapper wrap(
		StagingClaimDetail stagingClaimDetail) {

		return new StagingClaimDetailWrapper(stagingClaimDetail);
	}

}