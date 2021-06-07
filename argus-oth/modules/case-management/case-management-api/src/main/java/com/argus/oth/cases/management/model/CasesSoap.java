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
 * This class is used by SOAP remote services, specifically {@link com.argus.oth.cases.management.service.http.CasesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CasesSoap implements Serializable {

	public static CasesSoap toSoapModel(Cases model) {
		CasesSoap soapModel = new CasesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCaseId(model.getCaseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setClientId(model.getClientId());
		soapModel.setClientName(model.getClientName());
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
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static CasesSoap[] toSoapModels(Cases[] models) {
		CasesSoap[] soapModels = new CasesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CasesSoap[][] toSoapModels(Cases[][] models) {
		CasesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CasesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CasesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CasesSoap[] toSoapModels(List<Cases> models) {
		List<CasesSoap> soapModels = new ArrayList<CasesSoap>(models.size());

		for (Cases model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CasesSoap[soapModels.size()]);
	}

	public CasesSoap() {
	}

	public long getPrimaryKey() {
		return _caseId;
	}

	public void setPrimaryKey(long pk) {
		setCaseId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCaseId() {
		return _caseId;
	}

	public void setCaseId(long caseId) {
		_caseId = caseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public long getClientGroupId() {
		return _clientGroupId;
	}

	public void setClientGroupId(long clientGroupId) {
		_clientGroupId = clientGroupId;
	}

	public String getCaseNumber() {
		return _caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		_caseNumber = caseNumber;
	}

	public Date getCaseStartDate() {
		return _caseStartDate;
	}

	public void setCaseStartDate(Date caseStartDate) {
		_caseStartDate = caseStartDate;
	}

	public Date getCaseEndDate() {
		return _caseEndDate;
	}

	public void setCaseEndDate(Date caseEndDate) {
		_caseEndDate = caseEndDate;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
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

	public Date getEstimateEntryDate() {
		return _estimateEntryDate;
	}

	public void setEstimateEntryDate(Date estimateEntryDate) {
		_estimateEntryDate = estimateEntryDate;
	}

	public String getCaseManager() {
		return _caseManager;
	}

	public void setCaseManager(String caseManager) {
		_caseManager = caseManager;
	}

	public Date getConsentReceivedDate() {
		return _consentReceivedDate;
	}

	public void setConsentReceivedDate(Date consentReceivedDate) {
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

	public Date getLastUpdated() {
		return _lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		_lastUpdated = lastUpdated;
	}

	public Date getExternalCreatedDate() {
		return _externalCreatedDate;
	}

	public void setExternalCreatedDate(Date externalCreatedDate) {
		_externalCreatedDate = externalCreatedDate;
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

	public double getSavingsPercent() {
		return _savingsPercent;
	}

	public void setSavingsPercent(double savingsPercent) {
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

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private String _uuid;
	private long _caseId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalCaseId;
	private long _clientId;
	private String _clientName;
	private long _clientGroupId;
	private String _caseNumber;
	private Date _caseStartDate;
	private Date _caseEndDate;
	private long _memberId;
	private String _primaryDiagCode;
	private String _primaryCode;
	private String _status;
	private Date _estimateEntryDate;
	private String _caseManager;
	private Date _consentReceivedDate;
	private String _medicalPlan;
	private String _costEstimate;
	private Date _lastUpdated;
	private Date _externalCreatedDate;
	private double _chargedAmount;
	private double _paidAmount;
	private double _repricedAmount;
	private double _savingsAmount;
	private double _savingsPercent;
	private String _treatingPhysician;
	private String _primaryFacility;
	private String _rowProcessed;

}