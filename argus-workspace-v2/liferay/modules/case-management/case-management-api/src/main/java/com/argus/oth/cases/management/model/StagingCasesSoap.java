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
public class StagingCasesSoap implements Serializable {

	public static StagingCasesSoap toSoapModel(StagingCases model) {
		StagingCasesSoap soapModel = new StagingCasesSoap();

		soapModel.setStagingCaseId(model.getStagingCaseId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setExternalClientPk(model.getExternalClientPk());
		soapModel.setClientGroupId(model.getClientGroupId());
		soapModel.setCaseNumber(model.getCaseNumber());
		soapModel.setCaseStartDate(model.getCaseStartDate());
		soapModel.setCaseEndDate(model.getCaseEndDate());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setPrimaryDiagCode(model.getPrimaryDiagCode());
		soapModel.setPrimaryCode(model.getPrimaryCode());
		soapModel.setStatus(model.getStatus());
		soapModel.setEstimateEntryDate(model.getEstimateEntryDate());
		soapModel.setCaseManager(model.getCaseManager());
		soapModel.setConsentReceivedDate(model.getConsentReceivedDate());
		soapModel.setMedicalPlan(model.getMedicalPlan());
		soapModel.setCostEstimate(model.getCostEstimate());
		soapModel.setLastUpdated(model.getLastUpdated());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());
		soapModel.setChargedAmount(model.getChargedAmount());
		soapModel.setPaidAmount(model.getPaidAmount());
		soapModel.setRepricedAmount(model.getRepricedAmount());
		soapModel.setSavingsAmount(model.getSavingsAmount());
		soapModel.setSavingsPercent(model.getSavingsPercent());
		soapModel.setTreatingPhysician(model.getTreatingPhysician());
		soapModel.setPrimaryFacility(model.getPrimaryFacility());
		soapModel.setRowProcessed(model.isRowProcessed());

		return soapModel;
	}

	public static StagingCasesSoap[] toSoapModels(StagingCases[] models) {
		StagingCasesSoap[] soapModels = new StagingCasesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingCasesSoap[][] toSoapModels(StagingCases[][] models) {
		StagingCasesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StagingCasesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingCasesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingCasesSoap[] toSoapModels(List<StagingCases> models) {
		List<StagingCasesSoap> soapModels = new ArrayList<StagingCasesSoap>(
			models.size());

		for (StagingCases model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StagingCasesSoap[soapModels.size()]);
	}

	public StagingCasesSoap() {
	}

	public long getPrimaryKey() {
		return _stagingCaseId;
	}

	public void setPrimaryKey(long pk) {
		setStagingCaseId(pk);
	}

	public long getStagingCaseId() {
		return _stagingCaseId;
	}

	public void setStagingCaseId(long stagingCaseId) {
		_stagingCaseId = stagingCaseId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(String externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public String getExternalClientPk() {
		return _externalClientPk;
	}

	public void setExternalClientPk(String externalClientPk) {
		_externalClientPk = externalClientPk;
	}

	public String getClientGroupId() {
		return _clientGroupId;
	}

	public void setClientGroupId(String clientGroupId) {
		_clientGroupId = clientGroupId;
	}

	public String getCaseNumber() {
		return _caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		_caseNumber = caseNumber;
	}

	public String getCaseStartDate() {
		return _caseStartDate;
	}

	public void setCaseStartDate(String caseStartDate) {
		_caseStartDate = caseStartDate;
	}

	public String getCaseEndDate() {
		return _caseEndDate;
	}

	public void setCaseEndDate(String caseEndDate) {
		_caseEndDate = caseEndDate;
	}

	public String getMemberId() {
		return _memberId;
	}

	public void setMemberId(String memberId) {
		_memberId = memberId;
	}

	public String getPrimaryDiagCode() {
		return _primaryDiagCode;
	}

	public void setPrimaryDiagCode(String primaryDiagCode) {
		_primaryDiagCode = primaryDiagCode;
	}

	public String getPrimaryCode() {
		return _primaryCode;
	}

	public void setPrimaryCode(String primaryCode) {
		_primaryCode = primaryCode;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getEstimateEntryDate() {
		return _estimateEntryDate;
	}

	public void setEstimateEntryDate(String estimateEntryDate) {
		_estimateEntryDate = estimateEntryDate;
	}

	public String getCaseManager() {
		return _caseManager;
	}

	public void setCaseManager(String caseManager) {
		_caseManager = caseManager;
	}

	public String getConsentReceivedDate() {
		return _consentReceivedDate;
	}

	public void setConsentReceivedDate(String consentReceivedDate) {
		_consentReceivedDate = consentReceivedDate;
	}

	public String getMedicalPlan() {
		return _medicalPlan;
	}

	public void setMedicalPlan(String medicalPlan) {
		_medicalPlan = medicalPlan;
	}

	public String getCostEstimate() {
		return _costEstimate;
	}

	public void setCostEstimate(String costEstimate) {
		_costEstimate = costEstimate;
	}

	public String getLastUpdated() {
		return _lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		_lastUpdated = lastUpdated;
	}

	public String getExternalCreatedDate() {
		return _externalCreatedDate;
	}

	public void setExternalCreatedDate(String externalCreatedDate) {
		_externalCreatedDate = externalCreatedDate;
	}

	public String getChargedAmount() {
		return _chargedAmount;
	}

	public void setChargedAmount(String chargedAmount) {
		_chargedAmount = chargedAmount;
	}

	public String getPaidAmount() {
		return _paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		_paidAmount = paidAmount;
	}

	public String getRepricedAmount() {
		return _repricedAmount;
	}

	public void setRepricedAmount(String repricedAmount) {
		_repricedAmount = repricedAmount;
	}

	public String getSavingsAmount() {
		return _savingsAmount;
	}

	public void setSavingsAmount(String savingsAmount) {
		_savingsAmount = savingsAmount;
	}

	public String getSavingsPercent() {
		return _savingsPercent;
	}

	public void setSavingsPercent(String savingsPercent) {
		_savingsPercent = savingsPercent;
	}

	public String getTreatingPhysician() {
		return _treatingPhysician;
	}

	public void setTreatingPhysician(String treatingPhysician) {
		_treatingPhysician = treatingPhysician;
	}

	public String getPrimaryFacility() {
		return _primaryFacility;
	}

	public void setPrimaryFacility(String primaryFacility) {
		_primaryFacility = primaryFacility;
	}

	public boolean getRowProcessed() {
		return _rowProcessed;
	}

	public boolean isRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(boolean rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _stagingCaseId;
	private Date _createDate;
	private String _externalCaseId;
	private String _externalClientPk;
	private String _clientGroupId;
	private String _caseNumber;
	private String _caseStartDate;
	private String _caseEndDate;
	private String _memberId;
	private String _primaryDiagCode;
	private String _primaryCode;
	private String _status;
	private String _estimateEntryDate;
	private String _caseManager;
	private String _consentReceivedDate;
	private String _medicalPlan;
	private String _costEstimate;
	private String _lastUpdated;
	private String _externalCreatedDate;
	private String _chargedAmount;
	private String _paidAmount;
	private String _repricedAmount;
	private String _savingsAmount;
	private String _savingsPercent;
	private String _treatingPhysician;
	private String _primaryFacility;
	private boolean _rowProcessed;

}