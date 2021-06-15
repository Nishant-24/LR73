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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Claim service. Represents a row in the &quot;OTH_Claim&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.argus.oth.cases.management.model.impl.ClaimImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Claim
 * @generated
 */
@ProviderType
public interface ClaimModel extends BaseModel<Claim>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a claim model instance should use the {@link Claim} interface instead.
	 */

	/**
	 * Returns the primary key of this claim.
	 *
	 * @return the primary key of this claim
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this claim.
	 *
	 * @param primaryKey the primary key of this claim
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the claim ID of this claim.
	 *
	 * @return the claim ID of this claim
	 */
	public long getClaimId();

	/**
	 * Sets the claim ID of this claim.
	 *
	 * @param claimId the claim ID of this claim
	 */
	public void setClaimId(long claimId);

	/**
	 * Returns the group ID of this claim.
	 *
	 * @return the group ID of this claim
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this claim.
	 *
	 * @param groupId the group ID of this claim
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this claim.
	 *
	 * @return the company ID of this claim
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this claim.
	 *
	 * @param companyId the company ID of this claim
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this claim.
	 *
	 * @return the create date of this claim
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this claim.
	 *
	 * @param createDate the create date of this claim
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this claim.
	 *
	 * @return the modified date of this claim
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this claim.
	 *
	 * @param modifiedDate the modified date of this claim
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the external claim ID of this claim.
	 *
	 * @return the external claim ID of this claim
	 */
	public long getExternalClaimId();

	/**
	 * Sets the external claim ID of this claim.
	 *
	 * @param externalClaimId the external claim ID of this claim
	 */
	public void setExternalClaimId(long externalClaimId);

	/**
	 * Returns the claim ref of this claim.
	 *
	 * @return the claim ref of this claim
	 */
	@AutoEscape
	public String getClaimRef();

	/**
	 * Sets the claim ref of this claim.
	 *
	 * @param claimRef the claim ref of this claim
	 */
	public void setClaimRef(String claimRef);

	/**
	 * Returns the authorization number of this claim.
	 *
	 * @return the authorization number of this claim
	 */
	@AutoEscape
	public String getAuthorizationNumber();

	/**
	 * Sets the authorization number of this claim.
	 *
	 * @param authorizationNumber the authorization number of this claim
	 */
	public void setAuthorizationNumber(String authorizationNumber);

	/**
	 * Returns the service from of this claim.
	 *
	 * @return the service from of this claim
	 */
	public Date getServiceFrom();

	/**
	 * Sets the service from of this claim.
	 *
	 * @param serviceFrom the service from of this claim
	 */
	public void setServiceFrom(Date serviceFrom);

	/**
	 * Returns the service thru of this claim.
	 *
	 * @return the service thru of this claim
	 */
	public Date getServiceThru();

	/**
	 * Sets the service thru of this claim.
	 *
	 * @param serviceThru the service thru of this claim
	 */
	public void setServiceThru(Date serviceThru);

	/**
	 * Returns the provider of this claim.
	 *
	 * @return the provider of this claim
	 */
	@AutoEscape
	public String getProvider();

	/**
	 * Sets the provider of this claim.
	 *
	 * @param provider the provider of this claim
	 */
	public void setProvider(String provider);

	/**
	 * Returns the prioritized bill of this claim.
	 *
	 * @return the prioritized bill of this claim
	 */
	@AutoEscape
	public String getPrioritizedBill();

	/**
	 * Sets the prioritized bill of this claim.
	 *
	 * @param prioritizedBill the prioritized bill of this claim
	 */
	public void setPrioritizedBill(String prioritizedBill);

	/**
	 * Returns the diag codes combined of this claim.
	 *
	 * @return the diag codes combined of this claim
	 */
	@AutoEscape
	public String getDiagCodesCombined();

	/**
	 * Sets the diag codes combined of this claim.
	 *
	 * @param diagCodesCombined the diag codes combined of this claim
	 */
	public void setDiagCodesCombined(String diagCodesCombined);

	/**
	 * Returns the provider state of this claim.
	 *
	 * @return the provider state of this claim
	 */
	@AutoEscape
	public String getProviderState();

	/**
	 * Sets the provider state of this claim.
	 *
	 * @param providerState the provider state of this claim
	 */
	public void setProviderState(String providerState);

	/**
	 * Returns the tpm received date of this claim.
	 *
	 * @return the tpm received date of this claim
	 */
	public Date getTpmReceivedDate();

	/**
	 * Sets the tpm received date of this claim.
	 *
	 * @param tpmReceivedDate the tpm received date of this claim
	 */
	public void setTpmReceivedDate(Date tpmReceivedDate);

	/**
	 * Returns the claim turnaround of this claim.
	 *
	 * @return the claim turnaround of this claim
	 */
	public long getClaimTurnaround();

	/**
	 * Sets the claim turnaround of this claim.
	 *
	 * @param claimTurnaround the claim turnaround of this claim
	 */
	public void setClaimTurnaround(long claimTurnaround);

	/**
	 * Returns the bill type of this claim.
	 *
	 * @return the bill type of this claim
	 */
	@AutoEscape
	public String getBillType();

	/**
	 * Sets the bill type of this claim.
	 *
	 * @param billType the bill type of this claim
	 */
	public void setBillType(String billType);

	/**
	 * Returns the provider network of this claim.
	 *
	 * @return the provider network of this claim
	 */
	@AutoEscape
	public String getProviderNetwork();

	/**
	 * Sets the provider network of this claim.
	 *
	 * @param providerNetwork the provider network of this claim
	 */
	public void setProviderNetwork(String providerNetwork);

	/**
	 * Returns the repriced network of this claim.
	 *
	 * @return the repriced network of this claim
	 */
	@AutoEscape
	public String getRepricedNetwork();

	/**
	 * Sets the repriced network of this claim.
	 *
	 * @param repricedNetwork the repriced network of this claim
	 */
	public void setRepricedNetwork(String repricedNetwork);

	/**
	 * Returns the status sort order of this claim.
	 *
	 * @return the status sort order of this claim
	 */
	public long getStatusSortOrder();

	/**
	 * Sets the status sort order of this claim.
	 *
	 * @param statusSortOrder the status sort order of this claim
	 */
	public void setStatusSortOrder(long statusSortOrder);

	/**
	 * Returns the paid date of this claim.
	 *
	 * @return the paid date of this claim
	 */
	public Date getPaidDate();

	/**
	 * Sets the paid date of this claim.
	 *
	 * @param paidDate the paid date of this claim
	 */
	public void setPaidDate(Date paidDate);

	/**
	 * Returns the paid amount of this claim.
	 *
	 * @return the paid amount of this claim
	 */
	public double getPaidAmount();

	/**
	 * Sets the paid amount of this claim.
	 *
	 * @param paidAmount the paid amount of this claim
	 */
	public void setPaidAmount(double paidAmount);

	/**
	 * Returns the claim status of this claim.
	 *
	 * @return the claim status of this claim
	 */
	@AutoEscape
	public String getClaimStatus();

	/**
	 * Sets the claim status of this claim.
	 *
	 * @param claimStatus the claim status of this claim
	 */
	public void setClaimStatus(String claimStatus);

	/**
	 * Returns the row processed of this claim.
	 *
	 * @return the row processed of this claim
	 */
	@AutoEscape
	public String getRowProcessed();

	/**
	 * Sets the row processed of this claim.
	 *
	 * @param rowProcessed the row processed of this claim
	 */
	public void setRowProcessed(String rowProcessed);

}