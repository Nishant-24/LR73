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
 * This class is a wrapper for {@link Cases}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Cases
 * @generated
 */
public class CasesWrapper
	extends BaseModelWrapper<Cases> implements Cases, ModelWrapper<Cases> {

	public CasesWrapper(Cases cases) {
		super(cases);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("caseId", getCaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("clientId", getClientId());
		attributes.put("clientName", getClientName());
		attributes.put("clientGroupId", getClientGroupId());
		attributes.put("caseNumber", getCaseNumber());
		attributes.put("caseStartDate", getCaseStartDate());
		attributes.put("caseEndDate", getCaseEndDate());
		attributes.put("memberId", getMemberId());
		attributes.put("primaryDiagCode", getPrimaryDiagCode());
		attributes.put("primaryCode", getPrimaryCode());
		attributes.put("status", getStatus());
		attributes.put("estimateEntryDate", getEstimateEntryDate());
		attributes.put("caseManager", getCaseManager());
		attributes.put("consentReceivedDate", getConsentReceivedDate());
		attributes.put("medicalPlan", getMedicalPlan());
		attributes.put("costEstimate", getCostEstimate());
		attributes.put("lastUpdated", getLastUpdated());
		attributes.put("externalCreatedDate", getExternalCreatedDate());
		attributes.put("chargedAmount", getChargedAmount());
		attributes.put("paidAmount", getPaidAmount());
		attributes.put("repricedAmount", getRepricedAmount());
		attributes.put("savingsAmount", getSavingsAmount());
		attributes.put("savingsPercent", getSavingsPercent());
		attributes.put("treatingPhysician", getTreatingPhysician());
		attributes.put("primaryFacility", getPrimaryFacility());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
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

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		Long clientGroupId = (Long)attributes.get("clientGroupId");

		if (clientGroupId != null) {
			setClientGroupId(clientGroupId);
		}

		String caseNumber = (String)attributes.get("caseNumber");

		if (caseNumber != null) {
			setCaseNumber(caseNumber);
		}

		Date caseStartDate = (Date)attributes.get("caseStartDate");

		if (caseStartDate != null) {
			setCaseStartDate(caseStartDate);
		}

		Date caseEndDate = (Date)attributes.get("caseEndDate");

		if (caseEndDate != null) {
			setCaseEndDate(caseEndDate);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String primaryDiagCode = (String)attributes.get("primaryDiagCode");

		if (primaryDiagCode != null) {
			setPrimaryDiagCode(primaryDiagCode);
		}

		String primaryCode = (String)attributes.get("primaryCode");

		if (primaryCode != null) {
			setPrimaryCode(primaryCode);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date estimateEntryDate = (Date)attributes.get("estimateEntryDate");

		if (estimateEntryDate != null) {
			setEstimateEntryDate(estimateEntryDate);
		}

		String caseManager = (String)attributes.get("caseManager");

		if (caseManager != null) {
			setCaseManager(caseManager);
		}

		Date consentReceivedDate = (Date)attributes.get("consentReceivedDate");

		if (consentReceivedDate != null) {
			setConsentReceivedDate(consentReceivedDate);
		}

		String medicalPlan = (String)attributes.get("medicalPlan");

		if (medicalPlan != null) {
			setMedicalPlan(medicalPlan);
		}

		String costEstimate = (String)attributes.get("costEstimate");

		if (costEstimate != null) {
			setCostEstimate(costEstimate);
		}

		Date lastUpdated = (Date)attributes.get("lastUpdated");

		if (lastUpdated != null) {
			setLastUpdated(lastUpdated);
		}

		Date externalCreatedDate = (Date)attributes.get("externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}

		Double chargedAmount = (Double)attributes.get("chargedAmount");

		if (chargedAmount != null) {
			setChargedAmount(chargedAmount);
		}

		Double paidAmount = (Double)attributes.get("paidAmount");

		if (paidAmount != null) {
			setPaidAmount(paidAmount);
		}

		Double repricedAmount = (Double)attributes.get("repricedAmount");

		if (repricedAmount != null) {
			setRepricedAmount(repricedAmount);
		}

		Double savingsAmount = (Double)attributes.get("savingsAmount");

		if (savingsAmount != null) {
			setSavingsAmount(savingsAmount);
		}

		Double savingsPercent = (Double)attributes.get("savingsPercent");

		if (savingsPercent != null) {
			setSavingsPercent(savingsPercent);
		}

		String treatingPhysician = (String)attributes.get("treatingPhysician");

		if (treatingPhysician != null) {
			setTreatingPhysician(treatingPhysician);
		}

		String primaryFacility = (String)attributes.get("primaryFacility");

		if (primaryFacility != null) {
			setPrimaryFacility(primaryFacility);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the case end date of this cases.
	 *
	 * @return the case end date of this cases
	 */
	@Override
	public Date getCaseEndDate() {
		return model.getCaseEndDate();
	}

	/**
	 * Returns the case ID of this cases.
	 *
	 * @return the case ID of this cases
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the case manager of this cases.
	 *
	 * @return the case manager of this cases
	 */
	@Override
	public String getCaseManager() {
		return model.getCaseManager();
	}

	/**
	 * Returns the case number of this cases.
	 *
	 * @return the case number of this cases
	 */
	@Override
	public String getCaseNumber() {
		return model.getCaseNumber();
	}

	/**
	 * Returns the case start date of this cases.
	 *
	 * @return the case start date of this cases
	 */
	@Override
	public Date getCaseStartDate() {
		return model.getCaseStartDate();
	}

	/**
	 * Returns the charged amount of this cases.
	 *
	 * @return the charged amount of this cases
	 */
	@Override
	public double getChargedAmount() {
		return model.getChargedAmount();
	}

	/**
	 * Returns the client group ID of this cases.
	 *
	 * @return the client group ID of this cases
	 */
	@Override
	public long getClientGroupId() {
		return model.getClientGroupId();
	}

	/**
	 * Returns the client ID of this cases.
	 *
	 * @return the client ID of this cases
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the client name of this cases.
	 *
	 * @return the client name of this cases
	 */
	@Override
	public String getClientName() {
		return model.getClientName();
	}

	/**
	 * Returns the company ID of this cases.
	 *
	 * @return the company ID of this cases
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the consent received date of this cases.
	 *
	 * @return the consent received date of this cases
	 */
	@Override
	public Date getConsentReceivedDate() {
		return model.getConsentReceivedDate();
	}

	/**
	 * Returns the cost estimate of this cases.
	 *
	 * @return the cost estimate of this cases
	 */
	@Override
	public String getCostEstimate() {
		return model.getCostEstimate();
	}

	/**
	 * Returns the create date of this cases.
	 *
	 * @return the create date of this cases
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the estimate entry date of this cases.
	 *
	 * @return the estimate entry date of this cases
	 */
	@Override
	public Date getEstimateEntryDate() {
		return model.getEstimateEntryDate();
	}

	/**
	 * Returns the external case ID of this cases.
	 *
	 * @return the external case ID of this cases
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the external created date of this cases.
	 *
	 * @return the external created date of this cases
	 */
	@Override
	public Date getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the group ID of this cases.
	 *
	 * @return the group ID of this cases
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last updated of this cases.
	 *
	 * @return the last updated of this cases
	 */
	@Override
	public Date getLastUpdated() {
		return model.getLastUpdated();
	}

	/**
	 * Returns the medical plan of this cases.
	 *
	 * @return the medical plan of this cases
	 */
	@Override
	public String getMedicalPlan() {
		return model.getMedicalPlan();
	}

	/**
	 * Returns the member ID of this cases.
	 *
	 * @return the member ID of this cases
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the modified date of this cases.
	 *
	 * @return the modified date of this cases
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid amount of this cases.
	 *
	 * @return the paid amount of this cases
	 */
	@Override
	public double getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the primary code of this cases.
	 *
	 * @return the primary code of this cases
	 */
	@Override
	public String getPrimaryCode() {
		return model.getPrimaryCode();
	}

	/**
	 * Returns the primary diag code of this cases.
	 *
	 * @return the primary diag code of this cases
	 */
	@Override
	public String getPrimaryDiagCode() {
		return model.getPrimaryDiagCode();
	}

	/**
	 * Returns the primary facility of this cases.
	 *
	 * @return the primary facility of this cases
	 */
	@Override
	public String getPrimaryFacility() {
		return model.getPrimaryFacility();
	}

	/**
	 * Returns the primary key of this cases.
	 *
	 * @return the primary key of this cases
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the repriced amount of this cases.
	 *
	 * @return the repriced amount of this cases
	 */
	@Override
	public double getRepricedAmount() {
		return model.getRepricedAmount();
	}

	/**
	 * Returns the row processed of this cases.
	 *
	 * @return the row processed of this cases
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the savings amount of this cases.
	 *
	 * @return the savings amount of this cases
	 */
	@Override
	public double getSavingsAmount() {
		return model.getSavingsAmount();
	}

	/**
	 * Returns the savings percent of this cases.
	 *
	 * @return the savings percent of this cases
	 */
	@Override
	public double getSavingsPercent() {
		return model.getSavingsPercent();
	}

	/**
	 * Returns the status of this cases.
	 *
	 * @return the status of this cases
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the treating physician of this cases.
	 *
	 * @return the treating physician of this cases
	 */
	@Override
	public String getTreatingPhysician() {
		return model.getTreatingPhysician();
	}

	/**
	 * Returns the uuid of this cases.
	 *
	 * @return the uuid of this cases
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
	 * Sets the case end date of this cases.
	 *
	 * @param caseEndDate the case end date of this cases
	 */
	@Override
	public void setCaseEndDate(Date caseEndDate) {
		model.setCaseEndDate(caseEndDate);
	}

	/**
	 * Sets the case ID of this cases.
	 *
	 * @param caseId the case ID of this cases
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the case manager of this cases.
	 *
	 * @param caseManager the case manager of this cases
	 */
	@Override
	public void setCaseManager(String caseManager) {
		model.setCaseManager(caseManager);
	}

	/**
	 * Sets the case number of this cases.
	 *
	 * @param caseNumber the case number of this cases
	 */
	@Override
	public void setCaseNumber(String caseNumber) {
		model.setCaseNumber(caseNumber);
	}

	/**
	 * Sets the case start date of this cases.
	 *
	 * @param caseStartDate the case start date of this cases
	 */
	@Override
	public void setCaseStartDate(Date caseStartDate) {
		model.setCaseStartDate(caseStartDate);
	}

	/**
	 * Sets the charged amount of this cases.
	 *
	 * @param chargedAmount the charged amount of this cases
	 */
	@Override
	public void setChargedAmount(double chargedAmount) {
		model.setChargedAmount(chargedAmount);
	}

	/**
	 * Sets the client group ID of this cases.
	 *
	 * @param clientGroupId the client group ID of this cases
	 */
	@Override
	public void setClientGroupId(long clientGroupId) {
		model.setClientGroupId(clientGroupId);
	}

	/**
	 * Sets the client ID of this cases.
	 *
	 * @param clientId the client ID of this cases
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the client name of this cases.
	 *
	 * @param clientName the client name of this cases
	 */
	@Override
	public void setClientName(String clientName) {
		model.setClientName(clientName);
	}

	/**
	 * Sets the company ID of this cases.
	 *
	 * @param companyId the company ID of this cases
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the consent received date of this cases.
	 *
	 * @param consentReceivedDate the consent received date of this cases
	 */
	@Override
	public void setConsentReceivedDate(Date consentReceivedDate) {
		model.setConsentReceivedDate(consentReceivedDate);
	}

	/**
	 * Sets the cost estimate of this cases.
	 *
	 * @param costEstimate the cost estimate of this cases
	 */
	@Override
	public void setCostEstimate(String costEstimate) {
		model.setCostEstimate(costEstimate);
	}

	/**
	 * Sets the create date of this cases.
	 *
	 * @param createDate the create date of this cases
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the estimate entry date of this cases.
	 *
	 * @param estimateEntryDate the estimate entry date of this cases
	 */
	@Override
	public void setEstimateEntryDate(Date estimateEntryDate) {
		model.setEstimateEntryDate(estimateEntryDate);
	}

	/**
	 * Sets the external case ID of this cases.
	 *
	 * @param externalCaseId the external case ID of this cases
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the external created date of this cases.
	 *
	 * @param externalCreatedDate the external created date of this cases
	 */
	@Override
	public void setExternalCreatedDate(Date externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the group ID of this cases.
	 *
	 * @param groupId the group ID of this cases
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last updated of this cases.
	 *
	 * @param lastUpdated the last updated of this cases
	 */
	@Override
	public void setLastUpdated(Date lastUpdated) {
		model.setLastUpdated(lastUpdated);
	}

	/**
	 * Sets the medical plan of this cases.
	 *
	 * @param medicalPlan the medical plan of this cases
	 */
	@Override
	public void setMedicalPlan(String medicalPlan) {
		model.setMedicalPlan(medicalPlan);
	}

	/**
	 * Sets the member ID of this cases.
	 *
	 * @param memberId the member ID of this cases
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the modified date of this cases.
	 *
	 * @param modifiedDate the modified date of this cases
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid amount of this cases.
	 *
	 * @param paidAmount the paid amount of this cases
	 */
	@Override
	public void setPaidAmount(double paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the primary code of this cases.
	 *
	 * @param primaryCode the primary code of this cases
	 */
	@Override
	public void setPrimaryCode(String primaryCode) {
		model.setPrimaryCode(primaryCode);
	}

	/**
	 * Sets the primary diag code of this cases.
	 *
	 * @param primaryDiagCode the primary diag code of this cases
	 */
	@Override
	public void setPrimaryDiagCode(String primaryDiagCode) {
		model.setPrimaryDiagCode(primaryDiagCode);
	}

	/**
	 * Sets the primary facility of this cases.
	 *
	 * @param primaryFacility the primary facility of this cases
	 */
	@Override
	public void setPrimaryFacility(String primaryFacility) {
		model.setPrimaryFacility(primaryFacility);
	}

	/**
	 * Sets the primary key of this cases.
	 *
	 * @param primaryKey the primary key of this cases
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the repriced amount of this cases.
	 *
	 * @param repricedAmount the repriced amount of this cases
	 */
	@Override
	public void setRepricedAmount(double repricedAmount) {
		model.setRepricedAmount(repricedAmount);
	}

	/**
	 * Sets the row processed of this cases.
	 *
	 * @param rowProcessed the row processed of this cases
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the savings amount of this cases.
	 *
	 * @param savingsAmount the savings amount of this cases
	 */
	@Override
	public void setSavingsAmount(double savingsAmount) {
		model.setSavingsAmount(savingsAmount);
	}

	/**
	 * Sets the savings percent of this cases.
	 *
	 * @param savingsPercent the savings percent of this cases
	 */
	@Override
	public void setSavingsPercent(double savingsPercent) {
		model.setSavingsPercent(savingsPercent);
	}

	/**
	 * Sets the status of this cases.
	 *
	 * @param status the status of this cases
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the treating physician of this cases.
	 *
	 * @param treatingPhysician the treating physician of this cases
	 */
	@Override
	public void setTreatingPhysician(String treatingPhysician) {
		model.setTreatingPhysician(treatingPhysician);
	}

	/**
	 * Sets the uuid of this cases.
	 *
	 * @param uuid the uuid of this cases
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
	protected CasesWrapper wrap(Cases cases) {
		return new CasesWrapper(cases);
	}

}