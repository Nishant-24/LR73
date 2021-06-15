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
 * This class is a wrapper for {@link StagingClaim}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaim
 * @generated
 */
public class StagingClaimWrapper
	extends BaseModelWrapper<StagingClaim>
	implements ModelWrapper<StagingClaim>, StagingClaim {

	public StagingClaimWrapper(StagingClaim stagingClaim) {
		super(stagingClaim);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingClaimId", getStagingClaimId());
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
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("externalCreatedDate", getExternalCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingClaimId = (Long)attributes.get("stagingClaimId");

		if (stagingClaimId != null) {
			setStagingClaimId(stagingClaimId);
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

		String serviceFrom = (String)attributes.get("serviceFrom");

		if (serviceFrom != null) {
			setServiceFrom(serviceFrom);
		}

		String serviceThru = (String)attributes.get("serviceThru");

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

		String tpmReceivedDate = (String)attributes.get("tpmReceivedDate");

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

		String paidDate = (String)attributes.get("paidDate");

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

		String externalModifiedDate = (String)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		String externalCreatedDate = (String)attributes.get(
			"externalCreatedDate");

		if (externalCreatedDate != null) {
			setExternalCreatedDate(externalCreatedDate);
		}
	}

	/**
	 * Returns the authorization number of this staging claim.
	 *
	 * @return the authorization number of this staging claim
	 */
	@Override
	public String getAuthorizationNumber() {
		return model.getAuthorizationNumber();
	}

	/**
	 * Returns the bill type of this staging claim.
	 *
	 * @return the bill type of this staging claim
	 */
	@Override
	public String getBillType() {
		return model.getBillType();
	}

	/**
	 * Returns the claim ref of this staging claim.
	 *
	 * @return the claim ref of this staging claim
	 */
	@Override
	public String getClaimRef() {
		return model.getClaimRef();
	}

	/**
	 * Returns the claim status of this staging claim.
	 *
	 * @return the claim status of this staging claim
	 */
	@Override
	public String getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the claim turnaround of this staging claim.
	 *
	 * @return the claim turnaround of this staging claim
	 */
	@Override
	public long getClaimTurnaround() {
		return model.getClaimTurnaround();
	}

	/**
	 * Returns the create date of this staging claim.
	 *
	 * @return the create date of this staging claim
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the diag codes combined of this staging claim.
	 *
	 * @return the diag codes combined of this staging claim
	 */
	@Override
	public String getDiagCodesCombined() {
		return model.getDiagCodesCombined();
	}

	/**
	 * Returns the external claim ID of this staging claim.
	 *
	 * @return the external claim ID of this staging claim
	 */
	@Override
	public long getExternalClaimId() {
		return model.getExternalClaimId();
	}

	/**
	 * Returns the external created date of this staging claim.
	 *
	 * @return the external created date of this staging claim
	 */
	@Override
	public String getExternalCreatedDate() {
		return model.getExternalCreatedDate();
	}

	/**
	 * Returns the external modified date of this staging claim.
	 *
	 * @return the external modified date of this staging claim
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the modified date of this staging claim.
	 *
	 * @return the modified date of this staging claim
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid amount of this staging claim.
	 *
	 * @return the paid amount of this staging claim
	 */
	@Override
	public double getPaidAmount() {
		return model.getPaidAmount();
	}

	/**
	 * Returns the paid date of this staging claim.
	 *
	 * @return the paid date of this staging claim
	 */
	@Override
	public String getPaidDate() {
		return model.getPaidDate();
	}

	/**
	 * Returns the primary key of this staging claim.
	 *
	 * @return the primary key of this staging claim
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prioritized bill of this staging claim.
	 *
	 * @return the prioritized bill of this staging claim
	 */
	@Override
	public String getPrioritizedBill() {
		return model.getPrioritizedBill();
	}

	/**
	 * Returns the provider of this staging claim.
	 *
	 * @return the provider of this staging claim
	 */
	@Override
	public String getProvider() {
		return model.getProvider();
	}

	/**
	 * Returns the provider network of this staging claim.
	 *
	 * @return the provider network of this staging claim
	 */
	@Override
	public String getProviderNetwork() {
		return model.getProviderNetwork();
	}

	/**
	 * Returns the provider state of this staging claim.
	 *
	 * @return the provider state of this staging claim
	 */
	@Override
	public String getProviderState() {
		return model.getProviderState();
	}

	/**
	 * Returns the repriced network of this staging claim.
	 *
	 * @return the repriced network of this staging claim
	 */
	@Override
	public String getRepricedNetwork() {
		return model.getRepricedNetwork();
	}

	/**
	 * Returns the service from of this staging claim.
	 *
	 * @return the service from of this staging claim
	 */
	@Override
	public String getServiceFrom() {
		return model.getServiceFrom();
	}

	/**
	 * Returns the service thru of this staging claim.
	 *
	 * @return the service thru of this staging claim
	 */
	@Override
	public String getServiceThru() {
		return model.getServiceThru();
	}

	/**
	 * Returns the staging claim ID of this staging claim.
	 *
	 * @return the staging claim ID of this staging claim
	 */
	@Override
	public long getStagingClaimId() {
		return model.getStagingClaimId();
	}

	/**
	 * Returns the status sort order of this staging claim.
	 *
	 * @return the status sort order of this staging claim
	 */
	@Override
	public long getStatusSortOrder() {
		return model.getStatusSortOrder();
	}

	/**
	 * Returns the tpm received date of this staging claim.
	 *
	 * @return the tpm received date of this staging claim
	 */
	@Override
	public String getTpmReceivedDate() {
		return model.getTpmReceivedDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the authorization number of this staging claim.
	 *
	 * @param authorizationNumber the authorization number of this staging claim
	 */
	@Override
	public void setAuthorizationNumber(String authorizationNumber) {
		model.setAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Sets the bill type of this staging claim.
	 *
	 * @param billType the bill type of this staging claim
	 */
	@Override
	public void setBillType(String billType) {
		model.setBillType(billType);
	}

	/**
	 * Sets the claim ref of this staging claim.
	 *
	 * @param claimRef the claim ref of this staging claim
	 */
	@Override
	public void setClaimRef(String claimRef) {
		model.setClaimRef(claimRef);
	}

	/**
	 * Sets the claim status of this staging claim.
	 *
	 * @param claimStatus the claim status of this staging claim
	 */
	@Override
	public void setClaimStatus(String claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the claim turnaround of this staging claim.
	 *
	 * @param claimTurnaround the claim turnaround of this staging claim
	 */
	@Override
	public void setClaimTurnaround(long claimTurnaround) {
		model.setClaimTurnaround(claimTurnaround);
	}

	/**
	 * Sets the create date of this staging claim.
	 *
	 * @param createDate the create date of this staging claim
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the diag codes combined of this staging claim.
	 *
	 * @param diagCodesCombined the diag codes combined of this staging claim
	 */
	@Override
	public void setDiagCodesCombined(String diagCodesCombined) {
		model.setDiagCodesCombined(diagCodesCombined);
	}

	/**
	 * Sets the external claim ID of this staging claim.
	 *
	 * @param externalClaimId the external claim ID of this staging claim
	 */
	@Override
	public void setExternalClaimId(long externalClaimId) {
		model.setExternalClaimId(externalClaimId);
	}

	/**
	 * Sets the external created date of this staging claim.
	 *
	 * @param externalCreatedDate the external created date of this staging claim
	 */
	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		model.setExternalCreatedDate(externalCreatedDate);
	}

	/**
	 * Sets the external modified date of this staging claim.
	 *
	 * @param externalModifiedDate the external modified date of this staging claim
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the modified date of this staging claim.
	 *
	 * @param modifiedDate the modified date of this staging claim
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid amount of this staging claim.
	 *
	 * @param paidAmount the paid amount of this staging claim
	 */
	@Override
	public void setPaidAmount(double paidAmount) {
		model.setPaidAmount(paidAmount);
	}

	/**
	 * Sets the paid date of this staging claim.
	 *
	 * @param paidDate the paid date of this staging claim
	 */
	@Override
	public void setPaidDate(String paidDate) {
		model.setPaidDate(paidDate);
	}

	/**
	 * Sets the primary key of this staging claim.
	 *
	 * @param primaryKey the primary key of this staging claim
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prioritized bill of this staging claim.
	 *
	 * @param prioritizedBill the prioritized bill of this staging claim
	 */
	@Override
	public void setPrioritizedBill(String prioritizedBill) {
		model.setPrioritizedBill(prioritizedBill);
	}

	/**
	 * Sets the provider of this staging claim.
	 *
	 * @param provider the provider of this staging claim
	 */
	@Override
	public void setProvider(String provider) {
		model.setProvider(provider);
	}

	/**
	 * Sets the provider network of this staging claim.
	 *
	 * @param providerNetwork the provider network of this staging claim
	 */
	@Override
	public void setProviderNetwork(String providerNetwork) {
		model.setProviderNetwork(providerNetwork);
	}

	/**
	 * Sets the provider state of this staging claim.
	 *
	 * @param providerState the provider state of this staging claim
	 */
	@Override
	public void setProviderState(String providerState) {
		model.setProviderState(providerState);
	}

	/**
	 * Sets the repriced network of this staging claim.
	 *
	 * @param repricedNetwork the repriced network of this staging claim
	 */
	@Override
	public void setRepricedNetwork(String repricedNetwork) {
		model.setRepricedNetwork(repricedNetwork);
	}

	/**
	 * Sets the service from of this staging claim.
	 *
	 * @param serviceFrom the service from of this staging claim
	 */
	@Override
	public void setServiceFrom(String serviceFrom) {
		model.setServiceFrom(serviceFrom);
	}

	/**
	 * Sets the service thru of this staging claim.
	 *
	 * @param serviceThru the service thru of this staging claim
	 */
	@Override
	public void setServiceThru(String serviceThru) {
		model.setServiceThru(serviceThru);
	}

	/**
	 * Sets the staging claim ID of this staging claim.
	 *
	 * @param stagingClaimId the staging claim ID of this staging claim
	 */
	@Override
	public void setStagingClaimId(long stagingClaimId) {
		model.setStagingClaimId(stagingClaimId);
	}

	/**
	 * Sets the status sort order of this staging claim.
	 *
	 * @param statusSortOrder the status sort order of this staging claim
	 */
	@Override
	public void setStatusSortOrder(long statusSortOrder) {
		model.setStatusSortOrder(statusSortOrder);
	}

	/**
	 * Sets the tpm received date of this staging claim.
	 *
	 * @param tpmReceivedDate the tpm received date of this staging claim
	 */
	@Override
	public void setTpmReceivedDate(String tpmReceivedDate) {
		model.setTpmReceivedDate(tpmReceivedDate);
	}

	@Override
	protected StagingClaimWrapper wrap(StagingClaim stagingClaim) {
		return new StagingClaimWrapper(stagingClaim);
	}

}