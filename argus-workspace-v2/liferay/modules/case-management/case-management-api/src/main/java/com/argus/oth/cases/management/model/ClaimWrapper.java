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
 * This class is a wrapper for {@link Claim}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Claim
 * @generated
 */
public class ClaimWrapper
	extends BaseModelWrapper<Claim> implements Claim, ModelWrapper<Claim> {

	public ClaimWrapper(Claim claim) {
		super(claim);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("claimId", getClaimId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalClaimId", getExternalClaimId());
		attributes.put("claimRef", getClaimRef());
		attributes.put("authorizationNumber", getAuthorizationNumber());
		attributes.put("serviceFrom", getServiceFrom());
		attributes.put("serviceThru", getServiceThru());
		attributes.put("provider", getProvider());
		attributes.put("prioritizedBill", getPrioritizedBill());
		attributes.put("diagCodesCombined", getDiagCodesCombined());
		attributes.put("providerState", getProviderState());
		attributes.put("tpmReceivedDate", getTpmReceivedDate());
		attributes.put("claimTurnaround", getClaimTurnaround());
		attributes.put("billType", getBillType());
		attributes.put("providerNetwork", getProviderNetwork());
		attributes.put("repricedNetwork", getRepricedNetwork());
		attributes.put("statusSortOrder", getStatusSortOrder());
		attributes.put("paidDate", getPaidDate());
		attributes.put("paidAmount", getPaidAmount());
		attributes.put("claimStatus", getClaimStatus());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long claimId = (Long)attributes.get("claimId");

		if (claimId != null) {
			setClaimId(claimId);
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

		Long externalClaimId = (Long)attributes.get("externalClaimId");

		if (externalClaimId != null) {
			setExternalClaimId(externalClaimId);
		}

		String claimRef = (String)attributes.get("claimRef");

		if (claimRef != null) {
			setClaimRef(claimRef);
		}

		String authorizationNumber = (String)attributes.get(
			"authorizationNumber");

		if (authorizationNumber != null) {
			setAuthorizationNumber(authorizationNumber);
		}

		Date serviceFrom = (Date)attributes.get("serviceFrom");

		if (serviceFrom != null) {
			setServiceFrom(serviceFrom);
		}

		Date serviceThru = (Date)attributes.get("serviceThru");

		if (serviceThru != null) {
			setServiceThru(serviceThru);
		}

		String provider = (String)attributes.get("provider");

		if (provider != null) {
			setProvider(provider);
		}

		String prioritizedBill = (String)attributes.get("prioritizedBill");

		if (prioritizedBill != null) {
			setPrioritizedBill(prioritizedBill);
		}

		String diagCodesCombined = (String)attributes.get("diagCodesCombined");

		if (diagCodesCombined != null) {
			setDiagCodesCombined(diagCodesCombined);
		}

		String providerState = (String)attributes.get("providerState");

		if (providerState != null) {
			setProviderState(providerState);
		}

		Date tpmReceivedDate = (Date)attributes.get("tpmReceivedDate");

		if (tpmReceivedDate != null) {
			setTpmReceivedDate(tpmReceivedDate);
		}

		Long claimTurnaround = (Long)attributes.get("claimTurnaround");

		if (claimTurnaround != null) {
			setClaimTurnaround(claimTurnaround);
		}

		String billType = (String)attributes.get("billType");

		if (billType != null) {
			setBillType(billType);
		}

		String providerNetwork = (String)attributes.get("providerNetwork");

		if (providerNetwork != null) {
			setProviderNetwork(providerNetwork);
		}

		String repricedNetwork = (String)attributes.get("repricedNetwork");

		if (repricedNetwork != null) {
			setRepricedNetwork(repricedNetwork);
		}

		Long statusSortOrder = (Long)attributes.get("statusSortOrder");

		if (statusSortOrder != null) {
			setStatusSortOrder(statusSortOrder);
		}

		Date paidDate = (Date)attributes.get("paidDate");

		if (paidDate != null) {
			setPaidDate(paidDate);
		}

		Double paidAmount = (Double)attributes.get("paidAmount");

		if (paidAmount != null) {
			setPaidAmount(paidAmount);
		}

		String claimStatus = (String)attributes.get("claimStatus");

		if (claimStatus != null) {
			setClaimStatus(claimStatus);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the authorization number of this claim.
	 *
	 * @return the authorization number of this claim
	 */
	@Override
	public String getAuthorizationNumber() {
		return model.getAuthorizationNumber();
	}

	/**
	 * Returns the bill type of this claim.
	 *
	 * @return the bill type of this claim
	 */
	@Override
	public String getBillType() {
		return model.getBillType();
	}

	/**
	 * Returns the claim ID of this claim.
	 *
	 * @return the claim ID of this claim
	 */
	@Override
	public long getClaimId() {
		return model.getClaimId();
	}

	/**
	 * Returns the claim ref of this claim.
	 *
	 * @return the claim ref of this claim
	 */
	@Override
	public String getClaimRef() {
		return model.getClaimRef();
	}

	/**
	 * Returns the claim status of this claim.
	 *
	 * @return the claim status of this claim
	 */
	@Override
	public String getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the claim turnaround of this claim.
	 *
	 * @return the claim turnaround of this claim
	 */
	@Override
	public long getClaimTurnaround() {
		return model.getClaimTurnaround();
	}

	/**
	 * Returns the company ID of this claim.
	 *
	 * @return the company ID of this claim
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this claim.
	 *
	 * @return the create date of this claim
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the diag codes combined of this claim.
	 *
	 * @return the diag codes combined of this claim
	 */
	@Override
	public String getDiagCodesCombined() {
		return model.getDiagCodesCombined();
	}

	/**
	 * Returns the external claim ID of this claim.
	 *
	 * @return the external claim ID of this claim
	 */
	@Override
	public long getExternalClaimId() {
		return model.getExternalClaimId();
	}

	/**
	 * Returns the group ID of this claim.
	 *
	 * @return the group ID of this claim
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this claim.
	 *
	 * @return the modified date of this claim
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid amount of this claim.
	 *
	 * @return the paid amount of this claim
	 */
	@Override
	public double getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the paid date of this claim.
	 *
	 * @return the paid date of this claim
	 */
	@Override
	public Date getPaidDate() {
		return model.getPaidDate();
	}

	/**
	 * Returns the primary key of this claim.
	 *
	 * @return the primary key of this claim
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prioritized bill of this claim.
	 *
	 * @return the prioritized bill of this claim
	 */
	@Override
	public String getPrioritizedBill() {
		return model.getPrioritizedBill();
	}

	/**
	 * Returns the provider of this claim.
	 *
	 * @return the provider of this claim
	 */
	@Override
	public String getProvider() {
		return model.getProvider();
	}

	/**
	 * Returns the provider network of this claim.
	 *
	 * @return the provider network of this claim
	 */
	@Override
	public String getProviderNetwork() {
		return model.getProviderNetwork();
	}

	/**
	 * Returns the provider state of this claim.
	 *
	 * @return the provider state of this claim
	 */
	@Override
	public String getProviderState() {
		return model.getProviderState();
	}

	/**
	 * Returns the repriced network of this claim.
	 *
	 * @return the repriced network of this claim
	 */
	@Override
	public String getRepricedNetwork() {
		return model.getRepricedNetwork();
	}

	/**
	 * Returns the row processed of this claim.
	 *
	 * @return the row processed of this claim
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the service from of this claim.
	 *
	 * @return the service from of this claim
	 */
	@Override
	public Date getServiceFrom() {
		return model.getServiceFrom();
	}

	/**
	 * Returns the service thru of this claim.
	 *
	 * @return the service thru of this claim
	 */
	@Override
	public Date getServiceThru() {
		return model.getServiceThru();
	}

	/**
	 * Returns the status sort order of this claim.
	 *
	 * @return the status sort order of this claim
	 */
	@Override
	public long getStatusSortOrder() {
		return model.getStatusSortOrder();
	}

	/**
	 * Returns the tpm received date of this claim.
	 *
	 * @return the tpm received date of this claim
	 */
	@Override
	public Date getTpmReceivedDate() {
		return model.getTpmReceivedDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the authorization number of this claim.
	 *
	 * @param authorizationNumber the authorization number of this claim
	 */
	@Override
	public void setAuthorizationNumber(String authorizationNumber) {
		model.setAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Sets the bill type of this claim.
	 *
	 * @param billType the bill type of this claim
	 */
	@Override
	public void setBillType(String billType) {
		model.setBillType(billType);
	}

	/**
	 * Sets the claim ID of this claim.
	 *
	 * @param claimId the claim ID of this claim
	 */
	@Override
	public void setClaimId(long claimId) {
		model.setClaimId(claimId);
	}

	/**
	 * Sets the claim ref of this claim.
	 *
	 * @param claimRef the claim ref of this claim
	 */
	@Override
	public void setClaimRef(String claimRef) {
		model.setClaimRef(claimRef);
	}

	/**
	 * Sets the claim status of this claim.
	 *
	 * @param claimStatus the claim status of this claim
	 */
	@Override
	public void setClaimStatus(String claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the claim turnaround of this claim.
	 *
	 * @param claimTurnaround the claim turnaround of this claim
	 */
	@Override
	public void setClaimTurnaround(long claimTurnaround) {
		model.setClaimTurnaround(claimTurnaround);
	}

	/**
	 * Sets the company ID of this claim.
	 *
	 * @param companyId the company ID of this claim
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this claim.
	 *
	 * @param createDate the create date of this claim
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the diag codes combined of this claim.
	 *
	 * @param diagCodesCombined the diag codes combined of this claim
	 */
	@Override
	public void setDiagCodesCombined(String diagCodesCombined) {
		model.setDiagCodesCombined(diagCodesCombined);
	}

	/**
	 * Sets the external claim ID of this claim.
	 *
	 * @param externalClaimId the external claim ID of this claim
	 */
	@Override
	public void setExternalClaimId(long externalClaimId) {
		model.setExternalClaimId(externalClaimId);
	}

	/**
	 * Sets the group ID of this claim.
	 *
	 * @param groupId the group ID of this claim
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this claim.
	 *
	 * @param modifiedDate the modified date of this claim
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid amount of this claim.
	 *
	 * @param paidAmount the paid amount of this claim
	 */
	@Override
	public void setPaidAmount(double paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the paid date of this claim.
	 *
	 * @param paidDate the paid date of this claim
	 */
	@Override
	public void setPaidDate(Date paidDate) {
		model.setPaidDate(paidDate);
	}

	/**
	 * Sets the primary key of this claim.
	 *
	 * @param primaryKey the primary key of this claim
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prioritized bill of this claim.
	 *
	 * @param prioritizedBill the prioritized bill of this claim
	 */
	@Override
	public void setPrioritizedBill(String prioritizedBill) {
		model.setPrioritizedBill(prioritizedBill);
	}

	/**
	 * Sets the provider of this claim.
	 *
	 * @param provider the provider of this claim
	 */
	@Override
	public void setProvider(String provider) {
		model.setProvider(provider);
	}

	/**
	 * Sets the provider network of this claim.
	 *
	 * @param providerNetwork the provider network of this claim
	 */
	@Override
	public void setProviderNetwork(String providerNetwork) {
		model.setProviderNetwork(providerNetwork);
	}

	/**
	 * Sets the provider state of this claim.
	 *
	 * @param providerState the provider state of this claim
	 */
	@Override
	public void setProviderState(String providerState) {
		model.setProviderState(providerState);
	}

	/**
	 * Sets the repriced network of this claim.
	 *
	 * @param repricedNetwork the repriced network of this claim
	 */
	@Override
	public void setRepricedNetwork(String repricedNetwork) {
		model.setRepricedNetwork(repricedNetwork);
	}

	/**
	 * Sets the row processed of this claim.
	 *
	 * @param rowProcessed the row processed of this claim
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the service from of this claim.
	 *
	 * @param serviceFrom the service from of this claim
	 */
	@Override
	public void setServiceFrom(Date serviceFrom) {
		model.setServiceFrom(serviceFrom);
	}

	/**
	 * Sets the service thru of this claim.
	 *
	 * @param serviceThru the service thru of this claim
	 */
	@Override
	public void setServiceThru(Date serviceThru) {
		model.setServiceThru(serviceThru);
	}

	/**
	 * Sets the status sort order of this claim.
	 *
	 * @param statusSortOrder the status sort order of this claim
	 */
	@Override
	public void setStatusSortOrder(long statusSortOrder) {
		model.setStatusSortOrder(statusSortOrder);
	}

	/**
	 * Sets the tpm received date of this claim.
	 *
	 * @param tpmReceivedDate the tpm received date of this claim
	 */
	@Override
	public void setTpmReceivedDate(Date tpmReceivedDate) {
		model.setTpmReceivedDate(tpmReceivedDate);
	}

	@Override
	protected ClaimWrapper wrap(Claim claim) {
		return new ClaimWrapper(claim);
	}

}