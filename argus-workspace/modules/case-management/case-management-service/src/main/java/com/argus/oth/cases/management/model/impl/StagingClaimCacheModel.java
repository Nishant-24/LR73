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

package com.argus.oth.cases.management.model.impl;

import com.argus.oth.cases.management.model.StagingClaim;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingClaim in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingClaimCacheModel
	implements CacheModel<StagingClaim>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingClaimCacheModel)) {
			return false;
		}

		StagingClaimCacheModel stagingClaimCacheModel =
			(StagingClaimCacheModel)object;

		if (stagingClaimId == stagingClaimCacheModel.stagingClaimId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingClaimId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{stagingClaimId=");
		sb.append(stagingClaimId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalClaimId=");
		sb.append(externalClaimId);
		sb.append(", claimRef=");
		sb.append(claimRef);
		sb.append(", authorizationNumber=");
		sb.append(authorizationNumber);
		sb.append(", serviceFrom=");
		sb.append(serviceFrom);
		sb.append(", serviceThru=");
		sb.append(serviceThru);
		sb.append(", provider=");
		sb.append(provider);
		sb.append(", prioritizedBill=");
		sb.append(prioritizedBill);
		sb.append(", diagCodesCombined=");
		sb.append(diagCodesCombined);
		sb.append(", providerState=");
		sb.append(providerState);
		sb.append(", tpmReceivedDate=");
		sb.append(tpmReceivedDate);
		sb.append(", claimTurnaround=");
		sb.append(claimTurnaround);
		sb.append(", billType=");
		sb.append(billType);
		sb.append(", providerNetwork=");
		sb.append(providerNetwork);
		sb.append(", repricedNetwork=");
		sb.append(repricedNetwork);
		sb.append(", statusSortOrder=");
		sb.append(statusSortOrder);
		sb.append(", paidDate=");
		sb.append(paidDate);
		sb.append(", paidAmount=");
		sb.append(paidAmount);
		sb.append(", claimStatus=");
		sb.append(claimStatus);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", externalCreatedDate=");
		sb.append(externalCreatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingClaim toEntityModel() {
		StagingClaimImpl stagingClaimImpl = new StagingClaimImpl();

		stagingClaimImpl.setStagingClaimId(stagingClaimId);

		if (createDate == Long.MIN_VALUE) {
			stagingClaimImpl.setCreateDate(null);
		}
		else {
			stagingClaimImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingClaimImpl.setModifiedDate(null);
		}
		else {
			stagingClaimImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingClaimImpl.setExternalClaimId(externalClaimId);

		if (claimRef == null) {
			stagingClaimImpl.setClaimRef("");
		}
		else {
			stagingClaimImpl.setClaimRef(claimRef);
		}

		if (authorizationNumber == null) {
			stagingClaimImpl.setAuthorizationNumber("");
		}
		else {
			stagingClaimImpl.setAuthorizationNumber(authorizationNumber);
		}

		if (serviceFrom == null) {
			stagingClaimImpl.setServiceFrom("");
		}
		else {
			stagingClaimImpl.setServiceFrom(serviceFrom);
		}

		if (serviceThru == null) {
			stagingClaimImpl.setServiceThru("");
		}
		else {
			stagingClaimImpl.setServiceThru(serviceThru);
		}

		if (provider == null) {
			stagingClaimImpl.setProvider("");
		}
		else {
			stagingClaimImpl.setProvider(provider);
		}

		if (prioritizedBill == null) {
			stagingClaimImpl.setPrioritizedBill("");
		}
		else {
			stagingClaimImpl.setPrioritizedBill(prioritizedBill);
		}

		if (diagCodesCombined == null) {
			stagingClaimImpl.setDiagCodesCombined("");
		}
		else {
			stagingClaimImpl.setDiagCodesCombined(diagCodesCombined);
		}

		if (providerState == null) {
			stagingClaimImpl.setProviderState("");
		}
		else {
			stagingClaimImpl.setProviderState(providerState);
		}

		if (tpmReceivedDate == null) {
			stagingClaimImpl.setTpmReceivedDate("");
		}
		else {
			stagingClaimImpl.setTpmReceivedDate(tpmReceivedDate);
		}

		stagingClaimImpl.setClaimTurnaround(claimTurnaround);

		if (billType == null) {
			stagingClaimImpl.setBillType("");
		}
		else {
			stagingClaimImpl.setBillType(billType);
		}

		if (providerNetwork == null) {
			stagingClaimImpl.setProviderNetwork("");
		}
		else {
			stagingClaimImpl.setProviderNetwork(providerNetwork);
		}

		if (repricedNetwork == null) {
			stagingClaimImpl.setRepricedNetwork("");
		}
		else {
			stagingClaimImpl.setRepricedNetwork(repricedNetwork);
		}

		stagingClaimImpl.setStatusSortOrder(statusSortOrder);

		if (paidDate == null) {
			stagingClaimImpl.setPaidDate("");
		}
		else {
			stagingClaimImpl.setPaidDate(paidDate);
		}

		stagingClaimImpl.setPaidAmount(paidAmount);

		if (claimStatus == null) {
			stagingClaimImpl.setClaimStatus("");
		}
		else {
			stagingClaimImpl.setClaimStatus(claimStatus);
		}

		if (externalModifiedDate == null) {
			stagingClaimImpl.setExternalModifiedDate("");
		}
		else {
			stagingClaimImpl.setExternalModifiedDate(externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingClaimImpl.setExternalCreatedDate("");
		}
		else {
			stagingClaimImpl.setExternalCreatedDate(externalCreatedDate);
		}

		stagingClaimImpl.resetOriginalValues();

		return stagingClaimImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingClaimId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClaimId = objectInput.readLong();
		claimRef = objectInput.readUTF();
		authorizationNumber = objectInput.readUTF();
		serviceFrom = objectInput.readUTF();
		serviceThru = objectInput.readUTF();
		provider = objectInput.readUTF();
		prioritizedBill = objectInput.readUTF();
		diagCodesCombined = objectInput.readUTF();
		providerState = objectInput.readUTF();
		tpmReceivedDate = objectInput.readUTF();

		claimTurnaround = objectInput.readLong();
		billType = objectInput.readUTF();
		providerNetwork = objectInput.readUTF();
		repricedNetwork = objectInput.readUTF();

		statusSortOrder = objectInput.readLong();
		paidDate = objectInput.readUTF();

		paidAmount = objectInput.readDouble();
		claimStatus = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingClaimId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalClaimId);

		if (claimRef == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimRef);
		}

		if (authorizationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorizationNumber);
		}

		if (serviceFrom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceFrom);
		}

		if (serviceThru == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceThru);
		}

		if (provider == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provider);
		}

		if (prioritizedBill == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prioritizedBill);
		}

		if (diagCodesCombined == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diagCodesCombined);
		}

		if (providerState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(providerState);
		}

		if (tpmReceivedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpmReceivedDate);
		}

		objectOutput.writeLong(claimTurnaround);

		if (billType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billType);
		}

		if (providerNetwork == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(providerNetwork);
		}

		if (repricedNetwork == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(repricedNetwork);
		}

		objectOutput.writeLong(statusSortOrder);

		if (paidDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paidDate);
		}

		objectOutput.writeDouble(paidAmount);

		if (claimStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimStatus);
		}

		if (externalModifiedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCreatedDate);
		}
	}

	public long stagingClaimId;
	public long createDate;
	public long modifiedDate;
	public long externalClaimId;
	public String claimRef;
	public String authorizationNumber;
	public String serviceFrom;
	public String serviceThru;
	public String provider;
	public String prioritizedBill;
	public String diagCodesCombined;
	public String providerState;
	public String tpmReceivedDate;
	public long claimTurnaround;
	public String billType;
	public String providerNetwork;
	public String repricedNetwork;
	public long statusSortOrder;
	public String paidDate;
	public double paidAmount;
	public String claimStatus;
	public String externalModifiedDate;
	public String externalCreatedDate;

}