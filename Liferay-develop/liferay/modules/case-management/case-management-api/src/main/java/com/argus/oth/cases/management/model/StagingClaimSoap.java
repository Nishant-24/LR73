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
public class StagingClaimSoap implements Serializable {

	public static StagingClaimSoap toSoapModel(StagingClaim model) {
		StagingClaimSoap soapModel = new StagingClaimSoap();

		soapModel.setStagingClaimId(model.getStagingClaimId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalClaimId(model.getExternalClaimId());
		soapModel.setClaimRef(model.getClaimRef());
		soapModel.setAuthorizationNumber(model.getAuthorizationNumber());
		soapModel.setServiceFrom(model.getServiceFrom());
		soapModel.setServiceThru(model.getServiceThru());
		soapModel.setProvider(model.getProvider());
		soapModel.setPrioritizedBill(model.getPrioritizedBill());
		soapModel.setDiagCodesCombined(model.getDiagCodesCombined());
		soapModel.setProviderState(model.getProviderState());
		soapModel.setTpmReceivedDate(model.getTpmReceivedDate());
		soapModel.setClaimTurnaround(model.getClaimTurnaround());
		soapModel.setBillType(model.getBillType());
		soapModel.setProviderNetwork(model.getProviderNetwork());
		soapModel.setRepricedNetwork(model.getRepricedNetwork());
		soapModel.setStatusSortOrder(model.getStatusSortOrder());
		soapModel.setPaidDate(model.getPaidDate());
		soapModel.setPaidAmount(model.getPaidAmount());
		soapModel.setClaimStatus(model.getClaimStatus());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setExternalCreatedDate(model.getExternalCreatedDate());

		return soapModel;
	}

	public static StagingClaimSoap[] toSoapModels(StagingClaim[] models) {
		StagingClaimSoap[] soapModels = new StagingClaimSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingClaimSoap[][] toSoapModels(StagingClaim[][] models) {
		StagingClaimSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StagingClaimSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingClaimSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingClaimSoap[] toSoapModels(List<StagingClaim> models) {
		List<StagingClaimSoap> soapModels = new ArrayList<StagingClaimSoap>(
			models.size());

		for (StagingClaim model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StagingClaimSoap[soapModels.size()]);
	}

	public StagingClaimSoap() {
	}

	public long getPrimaryKey() {
		return _stagingClaimId;
	}

	public void setPrimaryKey(long pk) {
		setStagingClaimId(pk);
	}

	public long getStagingClaimId() {
		return _stagingClaimId;
	}

	public void setStagingClaimId(long stagingClaimId) {
		_stagingClaimId = stagingClaimId;
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

	public long getExternalClaimId() {
		return _externalClaimId;
	}

	public void setExternalClaimId(long externalClaimId) {
		_externalClaimId = externalClaimId;
	}

	public String getClaimRef() {
		return _claimRef;
	}

	public void setClaimRef(String claimRef) {
		_claimRef = claimRef;
	}

	public String getAuthorizationNumber() {
		return _authorizationNumber;
	}

	public void setAuthorizationNumber(String authorizationNumber) {
		_authorizationNumber = authorizationNumber;
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

	public String getProvider() {
		return _provider;
	}

	public void setProvider(String provider) {
		_provider = provider;
	}

	public String getPrioritizedBill() {
		return _prioritizedBill;
	}

	public void setPrioritizedBill(String prioritizedBill) {
		_prioritizedBill = prioritizedBill;
	}

	public String getDiagCodesCombined() {
		return _diagCodesCombined;
	}

	public void setDiagCodesCombined(String diagCodesCombined) {
		_diagCodesCombined = diagCodesCombined;
	}

	public String getProviderState() {
		return _providerState;
	}

	public void setProviderState(String providerState) {
		_providerState = providerState;
	}

	public String getTpmReceivedDate() {
		return _tpmReceivedDate;
	}

	public void setTpmReceivedDate(String tpmReceivedDate) {
		_tpmReceivedDate = tpmReceivedDate;
	}

	public long getClaimTurnaround() {
		return _claimTurnaround;
	}

	public void setClaimTurnaround(long claimTurnaround) {
		_claimTurnaround = claimTurnaround;
	}

	public String getBillType() {
		return _billType;
	}

	public void setBillType(String billType) {
		_billType = billType;
	}

	public String getProviderNetwork() {
		return _providerNetwork;
	}

	public void setProviderNetwork(String providerNetwork) {
		_providerNetwork = providerNetwork;
	}

	public String getRepricedNetwork() {
		return _repricedNetwork;
	}

	public void setRepricedNetwork(String repricedNetwork) {
		_repricedNetwork = repricedNetwork;
	}

	public long getStatusSortOrder() {
		return _statusSortOrder;
	}

	public void setStatusSortOrder(long statusSortOrder) {
		_statusSortOrder = statusSortOrder;
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

	public String getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		_claimStatus = claimStatus;
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

	private long _stagingClaimId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalClaimId;
	private String _claimRef;
	private String _authorizationNumber;
	private String _serviceFrom;
	private String _serviceThru;
	private String _provider;
	private String _prioritizedBill;
	private String _diagCodesCombined;
	private String _providerState;
	private String _tpmReceivedDate;
	private long _claimTurnaround;
	private String _billType;
	private String _providerNetwork;
	private String _repricedNetwork;
	private long _statusSortOrder;
	private String _paidDate;
	private double _paidAmount;
	private String _claimStatus;
	private String _externalModifiedDate;
	private String _externalCreatedDate;

}