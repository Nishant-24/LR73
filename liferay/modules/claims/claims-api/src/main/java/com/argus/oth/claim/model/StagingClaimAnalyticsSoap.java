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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingClaimAnalyticsSoap implements Serializable {

	public static StagingClaimAnalyticsSoap toSoapModel(
		StagingClaimAnalytics model) {

		StagingClaimAnalyticsSoap soapModel = new StagingClaimAnalyticsSoap();

		soapModel.setStagingClaimAnalyticsId(
			model.getStagingClaimAnalyticsId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalClientId(model.getExternalClientId());
		soapModel.setClientName(model.getClientName());
		soapModel.setClaimNumber(model.getClaimNumber());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setClaimStatus(model.getClaimStatus());
		soapModel.setReceivedDate(model.getReceivedDate());
		soapModel.setServiceDate(model.getServiceDate());
		soapModel.setPaidDate(model.getPaidDate());
		soapModel.setExternalMemberId(model.getExternalMemberId());
		soapModel.setMemberName(model.getMemberName());
		soapModel.setProviderName(model.getProviderName());
		soapModel.setBillType(model.getBillType());
		soapModel.setPrimaryDiagnosis(model.getPrimaryDiagnosis());
		soapModel.setChargedAmount(model.getChargedAmount());
		soapModel.setPaidAmount(model.getPaidAmount());
		soapModel.setRepricedAmount(model.getRepricedAmount());
		soapModel.setSavingsAmount(model.getSavingsAmount());
		soapModel.setChargedPercent(model.getChargedPercent());
		soapModel.setRepricedPercent(model.getRepricedPercent());
		soapModel.setSavingsPercent(model.getSavingsPercent());
		soapModel.setChargedRange(model.getChargedRange());
		soapModel.setPaidRange(model.getPaidRange());
		soapModel.setRepricedRange(model.getRepricedRange());
		soapModel.setSavingsRange(model.getSavingsRange());
		soapModel.setClaimAging(model.getClaimAging());
		soapModel.setProcedureCodes(model.getProcedureCodes());
		soapModel.setResultCodes(model.getResultCodes());
		soapModel.setDiagnosisCodes(model.getDiagnosisCodes());
		soapModel.setCountry(model.getCountry());
		soapModel.setState(model.getState());
		soapModel.setFinancialExposure(model.getFinancialExposure());
		soapModel.setRepricedNetwork(model.getRepricedNetwork());
		soapModel.setClientGroupName(model.getClientGroupName());

		return soapModel;
	}

	public static StagingClaimAnalyticsSoap[] toSoapModels(
		StagingClaimAnalytics[] models) {

		StagingClaimAnalyticsSoap[] soapModels =
			new StagingClaimAnalyticsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingClaimAnalyticsSoap[][] toSoapModels(
		StagingClaimAnalytics[][] models) {

		StagingClaimAnalyticsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingClaimAnalyticsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingClaimAnalyticsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingClaimAnalyticsSoap[] toSoapModels(
		List<StagingClaimAnalytics> models) {

		List<StagingClaimAnalyticsSoap> soapModels =
			new ArrayList<StagingClaimAnalyticsSoap>(models.size());

		for (StagingClaimAnalytics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingClaimAnalyticsSoap[soapModels.size()]);
	}

	public StagingClaimAnalyticsSoap() {
	}

	public long getPrimaryKey() {
		return _stagingClaimAnalyticsId;
	}

	public void setPrimaryKey(long pk) {
		setStagingClaimAnalyticsId(pk);
	}

	public long getStagingClaimAnalyticsId() {
		return _stagingClaimAnalyticsId;
	}

	public void setStagingClaimAnalyticsId(long stagingClaimAnalyticsId) {
		_stagingClaimAnalyticsId = stagingClaimAnalyticsId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getExternalClientId() {
		return _externalClientId;
	}

	public void setExternalClientId(long externalClientId) {
		_externalClientId = externalClientId;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public String getClaimNumber() {
		return _claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		_claimNumber = claimNumber;
	}

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public String getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		_claimStatus = claimStatus;
	}

	public String getReceivedDate() {
		return _receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		_receivedDate = receivedDate;
	}

	public String getServiceDate() {
		return _serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		_serviceDate = serviceDate;
	}

	public String getPaidDate() {
		return _paidDate;
	}

	public void setPaidDate(String paidDate) {
		_paidDate = paidDate;
	}

	public long getExternalMemberId() {
		return _externalMemberId;
	}

	public void setExternalMemberId(long externalMemberId) {
		_externalMemberId = externalMemberId;
	}

	public String getMemberName() {
		return _memberName;
	}

	public void setMemberName(String memberName) {
		_memberName = memberName;
	}

	public String getProviderName() {
		return _providerName;
	}

	public void setProviderName(String providerName) {
		_providerName = providerName;
	}

	public String getBillType() {
		return _billType;
	}

	public void setBillType(String billType) {
		_billType = billType;
	}

	public String getPrimaryDiagnosis() {
		return _primaryDiagnosis;
	}

	public void setPrimaryDiagnosis(String primaryDiagnosis) {
		_primaryDiagnosis = primaryDiagnosis;
	}

	public double getChargedAmount() {
		return _chargedAmount;
	}

	public void setChargedAmount(double chargedAmount) {
		_chargedAmount = chargedAmount;
	}

	public double getPaidAmount() {
		return _paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		_paidAmount = paidAmount;
	}

	public double getRepricedAmount() {
		return _repricedAmount;
	}

	public void setRepricedAmount(double repricedAmount) {
		_repricedAmount = repricedAmount;
	}

	public double getSavingsAmount() {
		return _savingsAmount;
	}

	public void setSavingsAmount(double savingsAmount) {
		_savingsAmount = savingsAmount;
	}

	public double getChargedPercent() {
		return _chargedPercent;
	}

	public void setChargedPercent(double chargedPercent) {
		_chargedPercent = chargedPercent;
	}

	public double getRepricedPercent() {
		return _repricedPercent;
	}

	public void setRepricedPercent(double repricedPercent) {
		_repricedPercent = repricedPercent;
	}

	public double getSavingsPercent() {
		return _savingsPercent;
	}

	public void setSavingsPercent(double savingsPercent) {
		_savingsPercent = savingsPercent;
	}

	public String getChargedRange() {
		return _chargedRange;
	}

	public void setChargedRange(String chargedRange) {
		_chargedRange = chargedRange;
	}

	public String getPaidRange() {
		return _paidRange;
	}

	public void setPaidRange(String paidRange) {
		_paidRange = paidRange;
	}

	public String getRepricedRange() {
		return _repricedRange;
	}

	public void setRepricedRange(String repricedRange) {
		_repricedRange = repricedRange;
	}

	public String getSavingsRange() {
		return _savingsRange;
	}

	public void setSavingsRange(String savingsRange) {
		_savingsRange = savingsRange;
	}

	public long getClaimAging() {
		return _claimAging;
	}

	public void setClaimAging(long claimAging) {
		_claimAging = claimAging;
	}

	public String getProcedureCodes() {
		return _procedureCodes;
	}

	public void setProcedureCodes(String procedureCodes) {
		_procedureCodes = procedureCodes;
	}

	public String getResultCodes() {
		return _resultCodes;
	}

	public void setResultCodes(String resultCodes) {
		_resultCodes = resultCodes;
	}

	public String getDiagnosisCodes() {
		return _diagnosisCodes;
	}

	public void setDiagnosisCodes(String diagnosisCodes) {
		_diagnosisCodes = diagnosisCodes;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public double getFinancialExposure() {
		return _financialExposure;
	}

	public void setFinancialExposure(double financialExposure) {
		_financialExposure = financialExposure;
	}

	public String getRepricedNetwork() {
		return _repricedNetwork;
	}

	public void setRepricedNetwork(String repricedNetwork) {
		_repricedNetwork = repricedNetwork;
	}

	public String getClientGroupName() {
		return _clientGroupName;
	}

	public void setClientGroupName(String clientGroupName) {
		_clientGroupName = clientGroupName;
	}

	private long _stagingClaimAnalyticsId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalClientId;
	private String _clientName;
	private String _claimNumber;
	private long _externalCaseId;
	private String _claimStatus;
	private String _receivedDate;
	private String _serviceDate;
	private String _paidDate;
	private long _externalMemberId;
	private String _memberName;
	private String _providerName;
	private String _billType;
	private String _primaryDiagnosis;
	private double _chargedAmount;
	private double _paidAmount;
	private double _repricedAmount;
	private double _savingsAmount;
	private double _chargedPercent;
	private double _repricedPercent;
	private double _savingsPercent;
	private String _chargedRange;
	private String _paidRange;
	private String _repricedRange;
	private String _savingsRange;
	private long _claimAging;
	private String _procedureCodes;
	private String _resultCodes;
	private String _diagnosisCodes;
	private String _country;
	private String _state;
	private double _financialExposure;
	private String _repricedNetwork;
	private String _clientGroupName;

}