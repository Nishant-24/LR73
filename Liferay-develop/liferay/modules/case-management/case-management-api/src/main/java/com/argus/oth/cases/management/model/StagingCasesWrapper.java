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
 * This class is a wrapper for {@link StagingCases}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingCases
 * @generated
 */
public class StagingCasesWrapper
	extends BaseModelWrapper<StagingCases>
	implements ModelWrapper<StagingCases>, StagingCases {

	public StagingCasesWrapper(StagingCases stagingCases) {
		super(stagingCases);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingCaseId", getStagingCaseId());
		attributes.put("createDate", getCreateDate());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("externalClientPk", getExternalClientPk());
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
		attributes.put("rowProcessed", isRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingCaseId = (Long)attributes.get("stagingCaseId");

		if (stagingCaseId != null) {
			setStagingCaseId(stagingCaseId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String externalCaseId = (String)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		String externalClientPk = (String)attributes.get("externalClientPk");

		if (externalClientPk != null) {
			setExternalClientPk(externalClientPk);
		}

		String clientGroupId = (String)attributes.get("clientGroupId");

		if (clientGroupId != null) {
			setClientGroupId(clientGroupId);
		}

		String caseNumber = (String)attributes.get("caseNumber");

		if (caseNumber != null) {
			setCaseNumber(caseNumber);
		}

		String caseStartDate = (String)attributes.get("caseStartDate");

		if (caseStartDate != null) {
			setCaseStartDate(caseStartDate);
		}

		String caseEndDate = (String)attributes.get("caseEndDate");

		if (caseEndDate != null) {
			setCaseEndDate(caseEndDate);
		}

		String memberId = (String)attributes.get("memberId");

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

		String estimateEntryDate = (String)attributes.get("estimateEntryDate");

		if (estimateEntryDate != null) {
			setEstimateEntryDate(estimateEntryDate);
		}

		String caseManager = (String)attributes.get("caseManager");

		if (caseManager != null) {
			setCaseManager(caseManager);
		}

		String consentReceivedDate = (String)attributes.get(
			"consentReceivedDate");

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

		String lastUpdated = (String)attributes.get("lastUpdated");

		if (lastUpdated != null) {
			setLastUpdated(lastUpdated);
		}

		String externalCreatedDate = (String)attributes.get(
			"externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}

		String chargedAmount = (String)attributes.get("chargedAmount");

		if (chargedAmount != null) {
			setChargedAmount(chargedAmount);
		}

		String paidAmount = (String)attributes.get("paidAmount");

		if (paidAmount != null) {
			setPaidAmount(paidAmount);
		}

		String repricedAmount = (String)attributes.get("repricedAmount");

		if (repricedAmount != null) {
			setRepricedAmount(repricedAmount);
		}

		String savingsAmount = (String)attributes.get("savingsAmount");

		if (savingsAmount != null) {
			setSavingsAmount(savingsAmount);
		}

		String savingsPercent = (String)attributes.get("savingsPercent");

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

		Boolean rowProcessed = (Boolean)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the case end date of this staging cases.
	 *
	 * @return the case end date of this staging cases
	 */
	@Override
	public String getCaseEndDate() {
		return model.getCaseEndDate();
	}

	/**
	 * Returns the case manager of this staging cases.
	 *
	 * @return the case manager of this staging cases
	 */
	@Override
	public String getCaseManager() {
		return model.getCaseManager();
	}

	/**
	 * Returns the case number of this staging cases.
	 *
	 * @return the case number of this staging cases
	 */
	@Override
	public String getCaseNumber() {
		return model.getCaseNumber();
	}

	/**
	 * Returns the case start date of this staging cases.
	 *
	 * @return the case start date of this staging cases
	 */
	@Override
	public String getCaseStartDate() {
		return model.getCaseStartDate();
	}

	/**
	 * Returns the charged amount of this staging cases.
	 *
	 * @return the charged amount of this staging cases
	 */
	@Override
	public String getChargedAmount() {
		return model.getChargedAmount();
	}

	/**
	 * Returns the client group ID of this staging cases.
	 *
	 * @return the client group ID of this staging cases
	 */
	@Override
	public String getClientGroupId() {
		return model.getClientGroupId();
	}

	/**
	 * Returns the consent received date of this staging cases.
	 *
	 * @return the consent received date of this staging cases
	 */
	@Override
	public String getConsentReceivedDate() {
		return model.getConsentReceivedDate();
	}

	/**
	 * Returns the cost estimate of this staging cases.
	 *
	 * @return the cost estimate of this staging cases
	 */
	@Override
	public String getCostEstimate() {
		return model.getCostEstimate();
	}

	/**
	 * Returns the create date of this staging cases.
	 *
	 * @return the create date of this staging cases
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the estimate entry date of this staging cases.
	 *
	 * @return the estimate entry date of this staging cases
	 */
	@Override
	public String getEstimateEntryDate() {
		return model.getEstimateEntryDate();
	}

	/**
	 * Returns the external case ID of this staging cases.
	 *
	 * @return the external case ID of this staging cases
	 */
	@Override
	public String getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the external client pk of this staging cases.
	 *
	 * @return the external client pk of this staging cases
	 */
	@Override
	public String getExternalClientPk() {
		return model.getExternalClientPk();
	}

	/**
	 * Returns the external created date of this staging cases.
	 *
	 * @return the external created date of this staging cases
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the last updated of this staging cases.
	 *
	 * @return the last updated of this staging cases
	 */
	@Override
	public String getLastUpdated() {
		return model.getLastUpdated();
	}

	/**
	 * Returns the medical plan of this staging cases.
	 *
	 * @return the medical plan of this staging cases
	 */
	@Override
	public String getMedicalPlan() {
		return model.getMedicalPlan();
	}

	/**
	 * Returns the member ID of this staging cases.
	 *
	 * @return the member ID of this staging cases
	 */
	@Override
	public String getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the paid amount of this staging cases.
	 *
	 * @return the paid amount of this staging cases
	 */
	@Override
	public String getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the primary code of this staging cases.
	 *
	 * @return the primary code of this staging cases
	 */
	@Override
	public String getPrimaryCode() {
		return model.getPrimaryCode();
	}

	/**
	 * Returns the primary diag code of this staging cases.
	 *
	 * @return the primary diag code of this staging cases
	 */
	@Override
	public String getPrimaryDiagCode() {
		return model.getPrimaryDiagCode();
	}

	/**
	 * Returns the primary facility of this staging cases.
	 *
	 * @return the primary facility of this staging cases
	 */
	@Override
	public String getPrimaryFacility() {
		return model.getPrimaryFacility();
	}

	/**
	 * Returns the primary key of this staging cases.
	 *
	 * @return the primary key of this staging cases
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the repriced amount of this staging cases.
	 *
	 * @return the repriced amount of this staging cases
	 */
	@Override
	public String getRepricedAmount() {
		return model.getRepricedAmount();
	}

	/**
	 * Returns the row processed of this staging cases.
	 *
	 * @return the row processed of this staging cases
	 */
	@Override
	public boolean getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the savings amount of this staging cases.
	 *
	 * @return the savings amount of this staging cases
	 */
	@Override
	public String getSavingsAmount() {
		return model.getSavingsAmount();
	}

	/**
	 * Returns the savings percent of this staging cases.
	 *
	 * @return the savings percent of this staging cases
	 */
	@Override
	public String getSavingsPercent() {
		return model.getSavingsPercent();
	}

	/**
	 * Returns the staging case ID of this staging cases.
	 *
	 * @return the staging case ID of this staging cases
	 */
	@Override
	public long getStagingCaseId() {
		return model.getStagingCaseId();
	}

	/**
	 * Returns the status of this staging cases.
	 *
	 * @return the status of this staging cases
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the treating physician of this staging cases.
	 *
	 * @return the treating physician of this staging cases
	 */
	@Override
	public String getTreatingPhysician() {
		return model.getTreatingPhysician();
	}

	/**
	 * Returns <code>true</code> if this staging cases is row processed.
	 *
	 * @return <code>true</code> if this staging cases is row processed; <code>false</code> otherwise
	 */
	@Override
	public boolean isRowProcessed() {
		return model.isRowProcessed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the case end date of this staging cases.
	 *
	 * @param caseEndDate the case end date of this staging cases
	 */
	@Override
	public void setCaseEndDate(String caseEndDate) {
		model.setCaseEndDate(caseEndDate);
	}

	/**
	 * Sets the case manager of this staging cases.
	 *
	 * @param caseManager the case manager of this staging cases
	 */
	@Override
	public void setCaseManager(String caseManager) {
		model.setCaseManager(caseManager);
	}

	/**
	 * Sets the case number of this staging cases.
	 *
	 * @param caseNumber the case number of this staging cases
	 */
	@Override
	public void setCaseNumber(String caseNumber) {
		model.setCaseNumber(caseNumber);
	}

	/**
	 * Sets the case start date of this staging cases.
	 *
	 * @param caseStartDate the case start date of this staging cases
	 */
	@Override
	public void setCaseStartDate(String caseStartDate) {
		model.setCaseStartDate(caseStartDate);
	}

	/**
	 * Sets the charged amount of this staging cases.
	 *
	 * @param chargedAmount the charged amount of this staging cases
	 */
	@Override
	public void setChargedAmount(String chargedAmount) {
		model.setChargedAmount(chargedAmount);
	}

	/**
	 * Sets the client group ID of this staging cases.
	 *
	 * @param clientGroupId the client group ID of this staging cases
	 */
	@Override
	public void setClientGroupId(String clientGroupId) {
		model.setClientGroupId(clientGroupId);
	}

	/**
	 * Sets the consent received date of this staging cases.
	 *
	 * @param consentReceivedDate the consent received date of this staging cases
	 */
	@Override
	public void setConsentReceivedDate(String consentReceivedDate) {
		model.setConsentReceivedDate(consentReceivedDate);
	}

	/**
	 * Sets the cost estimate of this staging cases.
	 *
	 * @param costEstimate the cost estimate of this staging cases
	 */
	@Override
	public void setCostEstimate(String costEstimate) {
		model.setCostEstimate(costEstimate);
	}

	/**
	 * Sets the create date of this staging cases.
	 *
	 * @param createDate the create date of this staging cases
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the estimate entry date of this staging cases.
	 *
	 * @param estimateEntryDate the estimate entry date of this staging cases
	 */
	@Override
	public void setEstimateEntryDate(String estimateEntryDate) {
		model.setEstimateEntryDate(estimateEntryDate);
	}

	/**
	 * Sets the external case ID of this staging cases.
	 *
	 * @param externalCaseId the external case ID of this staging cases
	 */
	@Override
	public void setExternalCaseId(String externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the external client pk of this staging cases.
	 *
	 * @param externalClientPk the external client pk of this staging cases
	 */
	@Override
	public void setExternalClientPk(String externalClientPk) {
		model.setExternalClientPk(externalClientPk);
	}

	/**
	 * Sets the external created date of this staging cases.
	 *
	 * @param externalCreatedDate the external created date of this staging cases
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the last updated of this staging cases.
	 *
	 * @param lastUpdated the last updated of this staging cases
	 */
	@Override
	public void setLastUpdated(String lastUpdated) {
		model.setLastUpdated(lastUpdated);
	}

	/**
	 * Sets the medical plan of this staging cases.
	 *
	 * @param medicalPlan the medical plan of this staging cases
	 */
	@Override
	public void setMedicalPlan(String medicalPlan) {
		model.setMedicalPlan(medicalPlan);
	}

	/**
	 * Sets the member ID of this staging cases.
	 *
	 * @param memberId the member ID of this staging cases
	 */
	@Override
	public void setMemberId(String memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the paid amount of this staging cases.
	 *
	 * @param paidAmount the paid amount of this staging cases
	 */
	@Override
	public void setPaidAmount(String paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the primary code of this staging cases.
	 *
	 * @param primaryCode the primary code of this staging cases
	 */
	@Override
	public void setPrimaryCode(String primaryCode) {
		model.setPrimaryCode(primaryCode);
	}

	/**
	 * Sets the primary diag code of this staging cases.
	 *
	 * @param primaryDiagCode the primary diag code of this staging cases
	 */
	@Override
	public void setPrimaryDiagCode(String primaryDiagCode) {
		model.setPrimaryDiagCode(primaryDiagCode);
	}

	/**
	 * Sets the primary facility of this staging cases.
	 *
	 * @param primaryFacility the primary facility of this staging cases
	 */
	@Override
	public void setPrimaryFacility(String primaryFacility) {
		model.setPrimaryFacility(primaryFacility);
	}

	/**
	 * Sets the primary key of this staging cases.
	 *
	 * @param primaryKey the primary key of this staging cases
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the repriced amount of this staging cases.
	 *
	 * @param repricedAmount the repriced amount of this staging cases
	 */
	@Override
	public void setRepricedAmount(String repricedAmount) {
		model.setRepricedAmount(repricedAmount);
	}

	/**
	 * Sets whether this staging cases is row processed.
	 *
	 * @param rowProcessed the row processed of this staging cases
	 */
	@Override
	public void setRowProcessed(boolean rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the savings amount of this staging cases.
	 *
	 * @param savingsAmount the savings amount of this staging cases
	 */
	@Override
	public void setSavingsAmount(String savingsAmount) {
		model.setSavingsAmount(savingsAmount);
	}

	/**
	 * Sets the savings percent of this staging cases.
	 *
	 * @param savingsPercent the savings percent of this staging cases
	 */
	@Override
	public void setSavingsPercent(String savingsPercent) {
		model.setSavingsPercent(savingsPercent);
	}

	/**
	 * Sets the staging case ID of this staging cases.
	 *
	 * @param stagingCaseId the staging case ID of this staging cases
	 */
	@Override
	public void setStagingCaseId(long stagingCaseId) {
		model.setStagingCaseId(stagingCaseId);
	}

	/**
	 * Sets the status of this staging cases.
	 *
	 * @param status the status of this staging cases
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the treating physician of this staging cases.
	 *
	 * @param treatingPhysician the treating physician of this staging cases
	 */
	@Override
	public void setTreatingPhysician(String treatingPhysician) {
		model.setTreatingPhysician(treatingPhysician);
	}

	@Override
	protected StagingCasesWrapper wrap(StagingCases stagingCases) {
		return new StagingCasesWrapper(stagingCases);
	}

}