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
public class StagingClaimDetailSoap implements Serializable {

	public static StagingClaimDetailSoap toSoapModel(StagingClaimDetail model) {
		StagingClaimDetailSoap soapModel = new StagingClaimDetailSoap();

		soapModel.setStagingClaimDetailId(model.getStagingClaimDetailId());
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
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());

		return soapModel;
	}

	public static StagingClaimDetailSoap[] toSoapModels(
		StagingClaimDetail[] models) {

		StagingClaimDetailSoap[] soapModels =
			new StagingClaimDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingClaimDetailSoap[][] toSoapModels(
		StagingClaimDetail[][] models) {

		StagingClaimDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingClaimDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingClaimDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingClaimDetailSoap[] toSoapModels(
		List<StagingClaimDetail> models) {

		List<StagingClaimDetailSoap> soapModels =
			new ArrayList<StagingClaimDetailSoap>(models.size());

		for (StagingClaimDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingClaimDetailSoap[soapModels.size()]);
	}

	public StagingClaimDetailSoap() {
	}

	public long getPrimaryKey() {
		return _stagingClaimDetailId;
	}

	public void setPrimaryKey(long pk) {
		setStagingClaimDetailId(pk);
	}

	public long getStagingClaimDetailId() {
		return _stagingClaimDetailId;
	}

	public void setStagingClaimDetailId(long stagingClaimDetailId) {
		_stagingClaimDetailId = stagingClaimDetailId;
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

	public String getServiceFrom() {
		return _serviceFrom;
	}

	public void setServiceFrom(String serviceFrom) {
		_serviceFrom = serviceFrom;
	}

	public String getServiceThru() {
		return _serviceThru;
	}

	public void setServiceThru(String serviceThru) {
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

	public String getPaidDate() {
		return _paidDate;
	}

	public void setPaidDate(String paidDate) {
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

	public String getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(String externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	public String getExternalCreatedDate() {
		return _externalCreatedDate;
	}

	public void setExternalCreatedDate(String externalCreatedDate) {
		_externalCreatedDate = externalCreatedDate;
	}

	private long _stagingClaimDetailId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _lineId;
	private long _externalClaimId;
	private String _serviceFrom;
	private String _serviceThru;
	private String _resultCodes;
	private String _procedureCode;
	private double _chargedAmount;
	private double _repricedAmount;
	private double _claimAmount;
	private String _paidDate;
	private double _paidAmount;
	private double _savingsAmount;
	private int _units;
	private String _coverage;
	private String _lineStatus;
	private String _revCode;
	private String _externalModifiedDate;
	private String _externalCreatedDate;

}