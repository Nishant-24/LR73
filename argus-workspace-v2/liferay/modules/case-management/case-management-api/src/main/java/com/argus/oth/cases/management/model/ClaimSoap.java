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
public class ClaimSoap implements Serializable {

	public static ClaimSoap toSoapModel(Claim model) {
		ClaimSoap soapModel = new ClaimSoap();

		soapModel.setClaimId(model.getClaimId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
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
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static ClaimSoap[] toSoapModels(Claim[] models) {
		ClaimSoap[] soapModels = new ClaimSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClaimSoap[][] toSoapModels(Claim[][] models) {
		ClaimSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClaimSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClaimSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClaimSoap[] toSoapModels(List<Claim> models) {
		List<ClaimSoap> soapModels = new ArrayList<ClaimSoap>(models.size());

		for (Claim model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClaimSoap[soapModels.size()]);
	}

	public ClaimSoap() {
	}

	public long getPrimaryKey() {
		return _claimId;
	}

	public void setPrimaryKey(long pk) {
		setClaimId(pk);
	}

	public long getClaimId() {
		return _claimId;
	}

	public void setClaimId(long claimId) {
		_claimId = claimId;
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

	public Date getTpmReceivedDate() {
		return _tpmReceivedDate;
	}

	public void setTpmReceivedDate(Date tpmReceivedDate) {
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

	public String getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		_claimStatus = claimStatus;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private long _claimId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalClaimId;
	private String _claimRef;
	private String _authorizationNumber;
	private Date _serviceFrom;
	private Date _serviceThru;
	private String _provider;
	private String _prioritizedBill;
	private String _diagCodesCombined;
	private String _providerState;
	private Date _tpmReceivedDate;
	private long _claimTurnaround;
	private String _billType;
	private String _providerNetwork;
	private String _repricedNetwork;
	private long _statusSortOrder;
	private Date _paidDate;
	private double _paidAmount;
	private String _claimStatus;
	private String _rowProcessed;

}