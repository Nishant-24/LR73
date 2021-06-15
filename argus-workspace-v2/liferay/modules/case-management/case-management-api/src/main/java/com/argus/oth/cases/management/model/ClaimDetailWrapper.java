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
 * This class is a wrapper for {@link ClaimDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimDetail
 * @generated
 */
public class ClaimDetailWrapper
	extends BaseModelWrapper<ClaimDetail>
	implements ClaimDetail, ModelWrapper<ClaimDetail> {

	public ClaimDetailWrapper(ClaimDetail claimDetail) {
		super(claimDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("claimDetailId", getClaimDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
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
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long claimDetailId = (Long)attributes.get("claimDetailId");

		if (claimDetailId != null) {
			setClaimDetailId(claimDetailId);
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

		Long lineId = (Long)attributes.get("lineId");

		if (lineId != null) {
			setLineId(lineId);
		}

		Long externalClaimId = (Long)attributes.get("externalClaimId");

		if (externalClaimId != null) {
			setExternalClaimId(externalClaimId);
		}

		Date serviceFrom = (Date)attributes.get("serviceFrom");

		if (serviceFrom != null) {
			setServiceFrom(serviceFrom);
		}

		Date serviceThru = (Date)attributes.get("serviceThru");

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

		Date paidDate = (Date)attributes.get("paidDate");

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

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the charged amount of this claim detail.
	 *
	 * @return the charged amount of this claim detail
	 */
	@Override
	public double getChargedAmount() {
		return model.getChargedAmount();
	}

	/**
	 * Returns the claim amount of this claim detail.
	 *
	 * @return the claim amount of this claim detail
	 */
	@Override
	public double getClaimAmount() {
		return model.getClaimAmount();
	}

	/**
	 * Returns the claim detail ID of this claim detail.
	 *
	 * @return the claim detail ID of this claim detail
	 */
	@Override
	public long getClaimDetailId() {
		return model.getClaimDetailId();
	}

	/**
	 * Returns the company ID of this claim detail.
	 *
	 * @return the company ID of this claim detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the coverage of this claim detail.
	 *
	 * @return the coverage of this claim detail
	 */
	@Override
	public String getCoverage() {
		return model.getCoverage();
	}

	/**
	 * Returns the create date of this claim detail.
	 *
	 * @return the create date of this claim detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external claim ID of this claim detail.
	 *
	 * @return the external claim ID of this claim detail
	 */
	@Override
	public long getExternalClaimId() {
		return model.getExternalClaimId();
	}

	/**
	 * Returns the group ID of this claim detail.
	 *
	 * @return the group ID of this claim detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the line ID of this claim detail.
	 *
	 * @return the line ID of this claim detail
	 */
	@Override
	public long getLineId() {
		return model.getLineId();
	}

	/**
	 * Returns the line status of this claim detail.
	 *
	 * @return the line status of this claim detail
	 */
	@Override
	public String getLineStatus() {
		return model.getLineStatus();
	}

	/**
	 * Returns the modified date of this claim detail.
	 *
	 * @return the modified date of this claim detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid amount of this claim detail.
	 *
	 * @return the paid amount of this claim detail
	 */
	@Override
	public double getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the paid date of this claim detail.
	 *
	 * @return the paid date of this claim detail
	 */
	@Override
	public Date getPaidDate() {
		return model.getPaidDate();
	}

	/**
	 * Returns the primary key of this claim detail.
	 *
	 * @return the primary key of this claim detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure code of this claim detail.
	 *
	 * @return the procedure code of this claim detail
	 */
	@Override
	public String getProcedureCode() {
		return model.getProcedureCode();
	}

	/**
	 * Returns the repriced amount of this claim detail.
	 *
	 * @return the repriced amount of this claim detail
	 */
	@Override
	public double getRepricedAmount() {
		return model.getRepricedAmount();
	}

	/**
	 * Returns the result codes of this claim detail.
	 *
	 * @return the result codes of this claim detail
	 */
	@Override
	public String getResultCodes() {
		return model.getResultCodes();
	}

	/**
	 * Returns the rev code of this claim detail.
	 *
	 * @return the rev code of this claim detail
	 */
	@Override
	public String getRevCode() {
		return model.getRevCode();
	}

	/**
	 * Returns the row processed of this claim detail.
	 *
	 * @return the row processed of this claim detail
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the savings amount of this claim detail.
	 *
	 * @return the savings amount of this claim detail
	 */
	@Override
	public double getSavingsAmount() {
		return model.getSavingsAmount();
	}

	/**
	 * Returns the service from of this claim detail.
	 *
	 * @return the service from of this claim detail
	 */
	@Override
	public Date getServiceFrom() {
		return model.getServiceFrom();
	}

	/**
	 * Returns the service thru of this claim detail.
	 *
	 * @return the service thru of this claim detail
	 */
	@Override
	public Date getServiceThru() {
		return model.getServiceThru();
	}

	/**
	 * Returns the units of this claim detail.
	 *
	 * @return the units of this claim detail
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
	 * Sets the charged amount of this claim detail.
	 *
	 * @param chargedAmount the charged amount of this claim detail
	 */
	@Override
	public void setChargedAmount(double chargedAmount) {
		model.setChargedAmount(chargedAmount);
	}

	/**
	 * Sets the claim amount of this claim detail.
	 *
	 * @param claimAmount the claim amount of this claim detail
	 */
	@Override
	public void setClaimAmount(double claimAmount) {
		model.setClaimAmount(claimAmount);
	}

	/**
	 * Sets the claim detail ID of this claim detail.
	 *
	 * @param claimDetailId the claim detail ID of this claim detail
	 */
	@Override
	public void setClaimDetailId(long claimDetailId) {
		model.setClaimDetailId(claimDetailId);
	}

	/**
	 * Sets the company ID of this claim detail.
	 *
	 * @param companyId the company ID of this claim detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the coverage of this claim detail.
	 *
	 * @param coverage the coverage of this claim detail
	 */
	@Override
	public void setCoverage(String coverage) {
		model.setCoverage(coverage);
	}

	/**
	 * Sets the create date of this claim detail.
	 *
	 * @param createDate the create date of this claim detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external claim ID of this claim detail.
	 *
	 * @param externalClaimId the external claim ID of this claim detail
	 */
	@Override
	public void setExternalClaimId(long externalClaimId) {
		model.setExternalClaimId(externalClaimId);
	}

	/**
	 * Sets the group ID of this claim detail.
	 *
	 * @param groupId the group ID of this claim detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the line ID of this claim detail.
	 *
	 * @param lineId the line ID of this claim detail
	 */
	@Override
	public void setLineId(long lineId) {
		model.setLineId(lineId);
	}

	/**
	 * Sets the line status of this claim detail.
	 *
	 * @param lineStatus the line status of this claim detail
	 */
	@Override
	public void setLineStatus(String lineStatus) {
		model.setLineStatus(lineStatus);
	}

	/**
	 * Sets the modified date of this claim detail.
	 *
	 * @param modifiedDate the modified date of this claim detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid amount of this claim detail.
	 *
	 * @param paidAmount the paid amount of this claim detail
	 */
	@Override
	public void setPaidAmount(double paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the paid date of this claim detail.
	 *
	 * @param paidDate the paid date of this claim detail
	 */
	@Override
	public void setPaidDate(Date paidDate) {
		model.setPaidDate(paidDate);
	}

	/**
	 * Sets the primary key of this claim detail.
	 *
	 * @param primaryKey the primary key of this claim detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure code of this claim detail.
	 *
	 * @param procedureCode the procedure code of this claim detail
	 */
	@Override
	public void setProcedureCode(String procedureCode) {
		model.setProcedureCode(procedureCode);
	}

	/**
	 * Sets the repriced amount of this claim detail.
	 *
	 * @param repricedAmount the repriced amount of this claim detail
	 */
	@Override
	public void setRepricedAmount(double repricedAmount) {
		model.setRepricedAmount(repricedAmount);
	}

	/**
	 * Sets the result codes of this claim detail.
	 *
	 * @param resultCodes the result codes of this claim detail
	 */
	@Override
	public void setResultCodes(String resultCodes) {
		model.setResultCodes(resultCodes);
	}

	/**
	 * Sets the rev code of this claim detail.
	 *
	 * @param revCode the rev code of this claim detail
	 */
	@Override
	public void setRevCode(String revCode) {
		model.setRevCode(revCode);
	}

	/**
	 * Sets the row processed of this claim detail.
	 *
	 * @param rowProcessed the row processed of this claim detail
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the savings amount of this claim detail.
	 *
	 * @param savingsAmount the savings amount of this claim detail
	 */
	@Override
	public void setSavingsAmount(double savingsAmount) {
		model.setSavingsAmount(savingsAmount);
	}

	/**
	 * Sets the service from of this claim detail.
	 *
	 * @param serviceFrom the service from of this claim detail
	 */
	@Override
	public void setServiceFrom(Date serviceFrom) {
		model.setServiceFrom(serviceFrom);
	}

	/**
	 * Sets the service thru of this claim detail.
	 *
	 * @param serviceThru the service thru of this claim detail
	 */
	@Override
	public void setServiceThru(Date serviceThru) {
		model.setServiceThru(serviceThru);
	}

	/**
	 * Sets the units of this claim detail.
	 *
	 * @param units the units of this claim detail
	 */
	@Override
	public void setUnits(int units) {
		model.setUnits(units);
	}

	@Override
	protected ClaimDetailWrapper wrap(ClaimDetail claimDetail) {
		return new ClaimDetailWrapper(claimDetail);
	}

}