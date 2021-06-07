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
public class ClaimDetailSoap implements Serializable {

	public static ClaimDetailSoap toSoapModel(ClaimDetail model) {
		ClaimDetailSoap soapModel = new ClaimDetailSoap();

		soapModel.setClaimDetailId(model.getClaimDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLineId(model.getLineId());
		soapModel.setExternalClaimId(model.getExternalClaimId());
		soapModel.setServiceFrom(model.getServiceFrom());
		soapModel.setServiceThru(model.getServiceThru());
		soapModel.setResultCodes(model.getResultCodes());
		soapModel.setProcedureCode(model.getProcedureCode());
		soapModel.setChargedAmount(model.getChargedAmount());
		soapModel.setRepricedAmount(model.getRepricedAmount());
		soapModel.setClaimAmount(model.getClaimAmount());
		soapModel.setPaidDate(model.getPaidDate());
		soapModel.setPaidAmount(model.getPaidAmount());
		soapModel.setSavingsAmount(model.getSavingsAmount());
		soapModel.setUnits(model.getUnits());
		soapModel.setCoverage(model.getCoverage());
		soapModel.setLineStatus(model.getLineStatus());
		soapModel.setRevCode(model.getRevCode());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static ClaimDetailSoap[] toSoapModels(ClaimDetail[] models) {
		ClaimDetailSoap[] soapModels = new ClaimDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClaimDetailSoap[][] toSoapModels(ClaimDetail[][] models) {
		ClaimDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClaimDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClaimDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClaimDetailSoap[] toSoapModels(List<ClaimDetail> models) {
		List<ClaimDetailSoap> soapModels = new ArrayList<ClaimDetailSoap>(
			models.size());

		for (ClaimDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClaimDetailSoap[soapModels.size()]);
	}

	public ClaimDetailSoap() {
	}

	public long getPrimaryKey() {
		return _claimDetailId;
	}

	public void setPrimaryKey(long pk) {
		setClaimDetailId(pk);
	}

	public long getClaimDetailId() {
		return _claimDetailId;
	}

	public void setClaimDetailId(long claimDetailId) {
		_claimDetailId = claimDetailId;
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

	public long getLineId() {
		return _lineId;
	}

	public void setLineId(long lineId) {
		_lineId = lineId;
	}

	public long getExternalClaimId() {
		return _externalClaimId;
	}

	public void setExternalClaimId(long externalClaimId) {
		_externalClaimId = externalClaimId;
	}

	public Date getServiceFrom() {
		return _serviceFrom;
	}

	public void setServiceFrom(Date serviceFrom) {
		_serviceFrom = serviceFrom;
	}

	public Date getServiceThru() {
		return _serviceThru;
	}

	public void setServiceThru(Date serviceThru) {
		_serviceThru = serviceThru;
	}

	public String getResultCodes() {
		return _resultCodes;
	}

	public void setResultCodes(String resultCodes) {
		_resultCodes = resultCodes;
	}

	public String getProcedureCode() {
		return _procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		_procedureCode = procedureCode;
	}

	public double getChargedAmount() {
		return _chargedAmount;
	}

	public void setChargedAmount(double chargedAmount) {
		_chargedAmount = chargedAmount;
	}

	public double getRepricedAmount() {
		return _repricedAmount;
	}

	public void setRepricedAmount(double repricedAmount) {
		_repricedAmount = repricedAmount;
	}

	public double getClaimAmount() {
		return _claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		_claimAmount = claimAmount;
	}

	public Date getPaidDate() {
		return _paidDate;
	}

	public void setPaidDate(Date paidDate) {
		_paidDate = paidDate;
	}

	public double getPaidAmount() {
		return _paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		_paidAmount = paidAmount;
	}

	public double getSavingsAmount() {
		return _savingsAmount;
	}

	public void setSavingsAmount(double savingsAmount) {
		_savingsAmount = savingsAmount;
	}

	public int getUnits() {
		return _units;
	}

	public void setUnits(int units) {
		_units = units;
	}

	public String getCoverage() {
		return _coverage;
	}

	public void setCoverage(String coverage) {
		_coverage = coverage;
	}

	public String getLineStatus() {
		return _lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		_lineStatus = lineStatus;
	}

	public String getRevCode() {
		return _revCode;
	}

	public void setRevCode(String revCode) {
		_revCode = revCode;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _claimDetailId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _lineId;
	private long _externalClaimId;
	private Date _serviceFrom;
	private Date _serviceThru;
	private String _resultCodes;
	private String _procedureCode;
	private double _chargedAmount;
	private double _repricedAmount;
	private double _claimAmount;
	private Date _paidDate;
	private double _paidAmount;
	private double _savingsAmount;
	private int _units;
	private String _coverage;
	private String _lineStatus;
	private String _revCode;
	private String _rowProcessed;

}