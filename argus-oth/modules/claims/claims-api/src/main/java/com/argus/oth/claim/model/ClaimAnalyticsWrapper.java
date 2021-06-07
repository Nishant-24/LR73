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

package com.argus.oth.claim.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClaimAnalytics}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalytics
 * @generated
 */
public class ClaimAnalyticsWrapper
	extends BaseModelWrapper<ClaimAnalytics>
	implements ClaimAnalytics, ModelWrapper<ClaimAnalytics> {

	public ClaimAnalyticsWrapper(ClaimAnalytics claimAnalytics) {
		super(claimAnalytics);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("claimAnalyticsId", getClaimAnalyticsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalClientId", getExternalClientId());
		attributes.put("clientName", getClientName());
		attributes.put("claimNumber", getClaimNumber());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("claimStatus", getClaimStatus());
		attributes.put("receivedDate", getReceivedDate());
		attributes.put("serviceDate", getServiceDate());
		attributes.put("paidDate", getPaidDate());
		attributes.put("externalMemberId", getExternalMemberId());
		attributes.put("memberName", getMemberName());
		attributes.put("providerName", getProviderName());
		attributes.put("billType", getBillType());
		attributes.put("primaryDiagnosis", getPrimaryDiagnosis());
		attributes.put("chargedAmount", getChargedAmount());
		attributes.put("paidAmount", getPaidAmount());
		attributes.put("repricedAmount", getRepricedAmount());
		attributes.put("savingsAmount", getSavingsAmount());
		attributes.put("chargedPercent", getChargedPercent());
		attributes.put("repricedPercent", getRepricedPercent());
		attributes.put("savingsPercent", getSavingsPercent());
		attributes.put("chargedRange", getChargedRange());
		attributes.put("paidRange", getPaidRange());
		attributes.put("repricedRange", getRepricedRange());
		attributes.put("savingsRange", getSavingsRange());
		attributes.put("claimAging", getClaimAging());
		attributes.put("procedureCodes", getProcedureCodes());
		attributes.put("resultCodes", getResultCodes());
		attributes.put("diagnosisCodes", getDiagnosisCodes());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("financialExposure", getFinancialExposure());
		attributes.put("repricedNetwork", getRepricedNetwork());
		attributes.put("clientGroupName", getClientGroupName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long claimAnalyticsId = (Long)attributes.get("claimAnalyticsId");

		if (claimAnalyticsId != null) {
			setClaimAnalyticsId(claimAnalyticsId);
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

		Long externalClientId = (Long)attributes.get("externalClientId");

		if (externalClientId != null) {
			setExternalClientId(externalClientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String claimNumber = (String)attributes.get("claimNumber");

		if (claimNumber != null) {
			setClaimNumber(claimNumber);
		}

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		String claimStatus = (String)attributes.get("claimStatus");

		if (claimStatus != null) {
			setClaimStatus(claimStatus);
		}

		Date receivedDate = (Date)attributes.get("receivedDate");

		if (receivedDate != null) {
			setReceivedDate(receivedDate);
		}

		Date serviceDate = (Date)attributes.get("serviceDate");

		if (serviceDate != null) {
			setServiceDate(serviceDate);
		}

		Date paidDate = (Date)attributes.get("paidDate");

		if (paidDate != null) {
			setPaidDate(paidDate);
		}

		Long externalMemberId = (Long)attributes.get("externalMemberId");

		if (externalMemberId != null) {
			setExternalMemberId(externalMemberId);
		}

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		String providerName = (String)attributes.get("providerName");

		if (providerName != null) {
			setProviderName(providerName);
		}

		String billType = (String)attributes.get("billType");

		if (billType != null) {
			setBillType(billType);
		}

		String primaryDiagnosis = (String)attributes.get("primaryDiagnosis");

		if (primaryDiagnosis != null) {
			setPrimaryDiagnosis(primaryDiagnosis);
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

		Double chargedPercent = (Double)attributes.get("chargedPercent");

		if (chargedPercent != null) {
			setChargedPercent(chargedPercent);
		}

		Double repricedPercent = (Double)attributes.get("repricedPercent");

		if (repricedPercent != null) {
			setRepricedPercent(repricedPercent);
		}

		Double savingsPercent = (Double)attributes.get("savingsPercent");

		if (savingsPercent != null) {
			setSavingsPercent(savingsPercent);
		}

		String chargedRange = (String)attributes.get("chargedRange");

		if (chargedRange != null) {
			setChargedRange(chargedRange);
		}

		String paidRange = (String)attributes.get("paidRange");

		if (paidRange != null) {
			setPaidRange(paidRange);
		}

		String repricedRange = (String)attributes.get("repricedRange");

		if (repricedRange != null) {
			setRepricedRange(repricedRange);
		}

		String savingsRange = (String)attributes.get("savingsRange");

		if (savingsRange != null) {
			setSavingsRange(savingsRange);
		}

		Long claimAging = (Long)attributes.get("claimAging");

		if (claimAging != null) {
			setClaimAging(claimAging);
		}

		String procedureCodes = (String)attributes.get("procedureCodes");

		if (procedureCodes != null) {
			setProcedureCodes(procedureCodes);
		}

		String resultCodes = (String)attributes.get("resultCodes");

		if (resultCodes != null) {
			setResultCodes(resultCodes);
		}

		String diagnosisCodes = (String)attributes.get("diagnosisCodes");

		if (diagnosisCodes != null) {
			setDiagnosisCodes(diagnosisCodes);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Double financialExposure = (Double)attributes.get("financialExposure");

		if (financialExposure != null) {
			setFinancialExposure(financialExposure);
		}

		String repricedNetwork = (String)attributes.get("repricedNetwork");

		if (repricedNetwork != null) {
			setRepricedNetwork(repricedNetwork);
		}

		String clientGroupName = (String)attributes.get("clientGroupName");

		if (clientGroupName != null) {
			setClientGroupName(clientGroupName);
		}
	}

	/**
	 * Returns the bill type of this claim analytics.
	 *
	 * @return the bill type of this claim analytics
	 */
	@Override
	public String getBillType() {
		return model.getBillType();
	}

	/**
	 * Returns the charged amount of this claim analytics.
	 *
	 * @return the charged amount of this claim analytics
	 */
	@Override
	public double getChargedAmount() {
		return model.getChargedAmount();
	}

	/**
	 * Returns the charged percent of this claim analytics.
	 *
	 * @return the charged percent of this claim analytics
	 */
	@Override
	public double getChargedPercent() {
		return model.getChargedPercent();
	}

	/**
	 * Returns the charged range of this claim analytics.
	 *
	 * @return the charged range of this claim analytics
	 */
	@Override
	public String getChargedRange() {
		return model.getChargedRange();
	}

	/**
	 * Returns the claim aging of this claim analytics.
	 *
	 * @return the claim aging of this claim analytics
	 */
	@Override
	public long getClaimAging() {
		return model.getClaimAging();
	}

	/**
	 * Returns the claim analytics ID of this claim analytics.
	 *
	 * @return the claim analytics ID of this claim analytics
	 */
	@Override
	public long getClaimAnalyticsId() {
		return model.getClaimAnalyticsId();
	}

	/**
	 * Returns the claim number of this claim analytics.
	 *
	 * @return the claim number of this claim analytics
	 */
	@Override
	public String getClaimNumber() {
		return model.getClaimNumber();
	}

	/**
	 * Returns the claim status of this claim analytics.
	 *
	 * @return the claim status of this claim analytics
	 */
	@Override
	public String getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the client group name of this claim analytics.
	 *
	 * @return the client group name of this claim analytics
	 */
	@Override
	public String getClientGroupName() {
		return model.getClientGroupName();
	}

	/**
	 * Returns the client name of this claim analytics.
	 *
	 * @return the client name of this claim analytics
	 */
	@Override
	public String getClientName() {
		return model.getClientName();
	}

	/**
	 * Returns the company ID of this claim analytics.
	 *
	 * @return the company ID of this claim analytics
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this claim analytics.
	 *
	 * @return the country of this claim analytics
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this claim analytics.
	 *
	 * @return the create date of this claim analytics
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the diagnosis codes of this claim analytics.
	 *
	 * @return the diagnosis codes of this claim analytics
	 */
	@Override
	public String getDiagnosisCodes() {
		return model.getDiagnosisCodes();
	}

	/**
	 * Returns the external case ID of this claim analytics.
	 *
	 * @return the external case ID of this claim analytics
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the external client ID of this claim analytics.
	 *
	 * @return the external client ID of this claim analytics
	 */
	@Override
	public long getExternalClientId() {
		return model.getExternalClientId();
	}

	/**
	 * Returns the external member ID of this claim analytics.
	 *
	 * @return the external member ID of this claim analytics
	 */
	@Override
	public long getExternalMemberId() {
		return model.getExternalMemberId();
	}

	/**
	 * Returns the financial exposure of this claim analytics.
	 *
	 * @return the financial exposure of this claim analytics
	 */
	@Override
	public double getFinancialExposure() {
		return model.getFinancialExposure();
	}

	/**
	 * Returns the group ID of this claim analytics.
	 *
	 * @return the group ID of this claim analytics
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the member name of this claim analytics.
	 *
	 * @return the member name of this claim analytics
	 */
	@Override
	public String getMemberName() {
		return model.getMemberName();
	}

	/**
	 * Returns the modified date of this claim analytics.
	 *
	 * @return the modified date of this claim analytics
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid amount of this claim analytics.
	 *
	 * @return the paid amount of this claim analytics
	 */
	@Override
	public double getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the paid date of this claim analytics.
	 *
	 * @return the paid date of this claim analytics
	 */
	@Override
	public Date getPaidDate() {
		return model.getPaidDate();
	}

	/**
	 * Returns the paid range of this claim analytics.
	 *
	 * @return the paid range of this claim analytics
	 */
	@Override
	public String getPaidRange() {
		return model.getPaidRange();
	}

	/**
	 * Returns the primary diagnosis of this claim analytics.
	 *
	 * @return the primary diagnosis of this claim analytics
	 */
	@Override
	public String getPrimaryDiagnosis() {
		return model.getPrimaryDiagnosis();
	}

	/**
	 * Returns the primary key of this claim analytics.
	 *
	 * @return the primary key of this claim analytics
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure codes of this claim analytics.
	 *
	 * @return the procedure codes of this claim analytics
	 */
	@Override
	public String getProcedureCodes() {
		return model.getProcedureCodes();
	}

	/**
	 * Returns the provider name of this claim analytics.
	 *
	 * @return the provider name of this claim analytics
	 */
	@Override
	public String getProviderName() {
		return model.getProviderName();
	}

	/**
	 * Returns the received date of this claim analytics.
	 *
	 * @return the received date of this claim analytics
	 */
	@Override
	public Date getReceivedDate() {
		return model.getReceivedDate();
	}

	/**
	 * Returns the repriced amount of this claim analytics.
	 *
	 * @return the repriced amount of this claim analytics
	 */
	@Override
	public double getRepricedAmount() {
		return model.getRepricedAmount();
	}

	/**
	 * Returns the repriced network of this claim analytics.
	 *
	 * @return the repriced network of this claim analytics
	 */
	@Override
	public String getRepricedNetwork() {
		return model.getRepricedNetwork();
	}

	/**
	 * Returns the repriced percent of this claim analytics.
	 *
	 * @return the repriced percent of this claim analytics
	 */
	@Override
	public double getRepricedPercent() {
		return model.getRepricedPercent();
	}

	/**
	 * Returns the repriced range of this claim analytics.
	 *
	 * @return the repriced range of this claim analytics
	 */
	@Override
	public String getRepricedRange() {
		return model.getRepricedRange();
	}

	/**
	 * Returns the result codes of this claim analytics.
	 *
	 * @return the result codes of this claim analytics
	 */
	@Override
	public String getResultCodes() {
		return model.getResultCodes();
	}

	/**
	 * Returns the savings amount of this claim analytics.
	 *
	 * @return the savings amount of this claim analytics
	 */
	@Override
	public double getSavingsAmount() {
		return model.getSavingsAmount();
	}

	/**
	 * Returns the savings percent of this claim analytics.
	 *
	 * @return the savings percent of this claim analytics
	 */
	@Override
	public double getSavingsPercent() {
		return model.getSavingsPercent();
	}

	/**
	 * Returns the savings range of this claim analytics.
	 *
	 * @return the savings range of this claim analytics
	 */
	@Override
	public String getSavingsRange() {
		return model.getSavingsRange();
	}

	/**
	 * Returns the service date of this claim analytics.
	 *
	 * @return the service date of this claim analytics
	 */
	@Override
	public Date getServiceDate() {
		return model.getServiceDate();
	}

	/**
	 * Returns the state of this claim analytics.
	 *
	 * @return the state of this claim analytics
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bill type of this claim analytics.
	 *
	 * @param billType the bill type of this claim analytics
	 */
	@Override
	public void setBillType(String billType) {
		model.setBillType(billType);
	}

	/**
	 * Sets the charged amount of this claim analytics.
	 *
	 * @param chargedAmount the charged amount of this claim analytics
	 */
	@Override
	public void setChargedAmount(double chargedAmount) {
		model.setChargedAmount(chargedAmount);
	}

	/**
	 * Sets the charged percent of this claim analytics.
	 *
	 * @param chargedPercent the charged percent of this claim analytics
	 */
	@Override
	public void setChargedPercent(double chargedPercent) {
		model.setChargedPercent(chargedPercent);
	}

	/**
	 * Sets the charged range of this claim analytics.
	 *
	 * @param chargedRange the charged range of this claim analytics
	 */
	@Override
	public void setChargedRange(String chargedRange) {
		model.setChargedRange(chargedRange);
	}

	/**
	 * Sets the claim aging of this claim analytics.
	 *
	 * @param claimAging the claim aging of this claim analytics
	 */
	@Override
	public void setClaimAging(long claimAging) {
		model.setClaimAging(claimAging);
	}

	/**
	 * Sets the claim analytics ID of this claim analytics.
	 *
	 * @param claimAnalyticsId the claim analytics ID of this claim analytics
	 */
	@Override
	public void setClaimAnalyticsId(long claimAnalyticsId) {
		model.setClaimAnalyticsId(claimAnalyticsId);
	}

	/**
	 * Sets the claim number of this claim analytics.
	 *
	 * @param claimNumber the claim number of this claim analytics
	 */
	@Override
	public void setClaimNumber(String claimNumber) {
		model.setClaimNumber(claimNumber);
	}

	/**
	 * Sets the claim status of this claim analytics.
	 *
	 * @param claimStatus the claim status of this claim analytics
	 */
	@Override
	public void setClaimStatus(String claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the client group name of this claim analytics.
	 *
	 * @param clientGroupName the client group name of this claim analytics
	 */
	@Override
	public void setClientGroupName(String clientGroupName) {
		model.setClientGroupName(clientGroupName);
	}

	/**
	 * Sets the client name of this claim analytics.
	 *
	 * @param clientName the client name of this claim analytics
	 */
	@Override
	public void setClientName(String clientName) {
		model.setClientName(clientName);
	}

	/**
	 * Sets the company ID of this claim analytics.
	 *
	 * @param companyId the company ID of this claim analytics
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this claim analytics.
	 *
	 * @param country the country of this claim analytics
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this claim analytics.
	 *
	 * @param createDate the create date of this claim analytics
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the diagnosis codes of this claim analytics.
	 *
	 * @param diagnosisCodes the diagnosis codes of this claim analytics
	 */
	@Override
	public void setDiagnosisCodes(String diagnosisCodes) {
		model.setDiagnosisCodes(diagnosisCodes);
	}

	/**
	 * Sets the external case ID of this claim analytics.
	 *
	 * @param externalCaseId the external case ID of this claim analytics
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the external client ID of this claim analytics.
	 *
	 * @param externalClientId the external client ID of this claim analytics
	 */
	@Override
	public void setExternalClientId(long externalClientId) {
		model.setExternalClientId(externalClientId);
	}

	/**
	 * Sets the external member ID of this claim analytics.
	 *
	 * @param externalMemberId the external member ID of this claim analytics
	 */
	@Override
	public void setExternalMemberId(long externalMemberId) {
		model.setExternalMemberId(externalMemberId);
	}

	/**
	 * Sets the financial exposure of this claim analytics.
	 *
	 * @param financialExposure the financial exposure of this claim analytics
	 */
	@Override
	public void setFinancialExposure(double financialExposure) {
		model.setFinancialExposure(financialExposure);
	}

	/**
	 * Sets the group ID of this claim analytics.
	 *
	 * @param groupId the group ID of this claim analytics
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the member name of this claim analytics.
	 *
	 * @param memberName the member name of this claim analytics
	 */
	@Override
	public void setMemberName(String memberName) {
		model.setMemberName(memberName);
	}

	/**
	 * Sets the modified date of this claim analytics.
	 *
	 * @param modifiedDate the modified date of this claim analytics
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid amount of this claim analytics.
	 *
	 * @param paidAmount the paid amount of this claim analytics
	 */
	@Override
	public void setPaidAmount(double paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the paid date of this claim analytics.
	 *
	 * @param paidDate the paid date of this claim analytics
	 */
	@Override
	public void setPaidDate(Date paidDate) {
		model.setPaidDate(paidDate);
	}

	/**
	 * Sets the paid range of this claim analytics.
	 *
	 * @param paidRange the paid range of this claim analytics
	 */
	@Override
	public void setPaidRange(String paidRange) {
		model.setPaidRange(paidRange);
	}

	/**
	 * Sets the primary diagnosis of this claim analytics.
	 *
	 * @param primaryDiagnosis the primary diagnosis of this claim analytics
	 */
	@Override
	public void setPrimaryDiagnosis(String primaryDiagnosis) {
		model.setPrimaryDiagnosis(primaryDiagnosis);
	}

	/**
	 * Sets the primary key of this claim analytics.
	 *
	 * @param primaryKey the primary key of this claim analytics
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure codes of this claim analytics.
	 *
	 * @param procedureCodes the procedure codes of this claim analytics
	 */
	@Override
	public void setProcedureCodes(String procedureCodes) {
		model.setProcedureCodes(procedureCodes);
	}

	/**
	 * Sets the provider name of this claim analytics.
	 *
	 * @param providerName the provider name of this claim analytics
	 */
	@Override
	public void setProviderName(String providerName) {
		model.setProviderName(providerName);
	}

	/**
	 * Sets the received date of this claim analytics.
	 *
	 * @param receivedDate the received date of this claim analytics
	 */
	@Override
	public void setReceivedDate(Date receivedDate) {
		model.setReceivedDate(receivedDate);
	}

	/**
	 * Sets the repriced amount of this claim analytics.
	 *
	 * @param repricedAmount the repriced amount of this claim analytics
	 */
	@Override
	public void setRepricedAmount(double repricedAmount) {
		model.setRepricedAmount(repricedAmount);
	}

	/**
	 * Sets the repriced network of this claim analytics.
	 *
	 * @param repricedNetwork the repriced network of this claim analytics
	 */
	@Override
	public void setRepricedNetwork(String repricedNetwork) {
		model.setRepricedNetwork(repricedNetwork);
	}

	/**
	 * Sets the repriced percent of this claim analytics.
	 *
	 * @param repricedPercent the repriced percent of this claim analytics
	 */
	@Override
	public void setRepricedPercent(double repricedPercent) {
		model.setRepricedPercent(repricedPercent);
	}

	/**
	 * Sets the repriced range of this claim analytics.
	 *
	 * @param repricedRange the repriced range of this claim analytics
	 */
	@Override
	public void setRepricedRange(String repricedRange) {
		model.setRepricedRange(repricedRange);
	}

	/**
	 * Sets the result codes of this claim analytics.
	 *
	 * @param resultCodes the result codes of this claim analytics
	 */
	@Override
	public void setResultCodes(String resultCodes) {
		model.setResultCodes(resultCodes);
	}

	/**
	 * Sets the savings amount of this claim analytics.
	 *
	 * @param savingsAmount the savings amount of this claim analytics
	 */
	@Override
	public void setSavingsAmount(double savingsAmount) {
		model.setSavingsAmount(savingsAmount);
	}

	/**
	 * Sets the savings percent of this claim analytics.
	 *
	 * @param savingsPercent the savings percent of this claim analytics
	 */
	@Override
	public void setSavingsPercent(double savingsPercent) {
		model.setSavingsPercent(savingsPercent);
	}

	/**
	 * Sets the savings range of this claim analytics.
	 *
	 * @param savingsRange the savings range of this claim analytics
	 */
	@Override
	public void setSavingsRange(String savingsRange) {
		model.setSavingsRange(savingsRange);
	}

	/**
	 * Sets the service date of this claim analytics.
	 *
	 * @param serviceDate the service date of this claim analytics
	 */
	@Override
	public void setServiceDate(Date serviceDate) {
		model.setServiceDate(serviceDate);
	}

	/**
	 * Sets the state of this claim analytics.
	 *
	 * @param state the state of this claim analytics
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	@Override
	protected ClaimAnalyticsWrapper wrap(ClaimAnalytics claimAnalytics) {
		return new ClaimAnalyticsWrapper(claimAnalytics);
	}

}