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

import com.argus.oth.cases.management.model.Claim;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Claim in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimCacheModel implements CacheModel<Claim>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimCacheModel)) {
			return false;
		}

		ClaimCacheModel claimCacheModel = (ClaimCacheModel)object;

		if (claimId == claimCacheModel.claimId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{claimId=");
		sb.append(claimId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Claim toEntityModel() {
		ClaimImpl claimImpl = new ClaimImpl();

		claimImpl.setClaimId(claimId);
		claimImpl.setGroupId(groupId);
		claimImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			claimImpl.setCreateDate(null);
		}
		else {
			claimImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			claimImpl.setModifiedDate(null);
		}
		else {
			claimImpl.setModifiedDate(new Date(modifiedDate));
		}

		claimImpl.setExternalClaimId(externalClaimId);

		if (claimRef == null) {
			claimImpl.setClaimRef("");
		}
		else {
			claimImpl.setClaimRef(claimRef);
		}

		if (authorizationNumber == null) {
			claimImpl.setAuthorizationNumber("");
		}
		else {
			claimImpl.setAuthorizationNumber(authorizationNumber);
		}

		if (serviceFrom == Long.MIN_VALUE) {
			claimImpl.setServiceFrom(null);
		}
		else {
			claimImpl.setServiceFrom(new Date(serviceFrom));
		}

		if (serviceThru == Long.MIN_VALUE) {
			claimImpl.setServiceThru(null);
		}
		else {
			claimImpl.setServiceThru(new Date(serviceThru));
		}

		if (provider == null) {
			claimImpl.setProvider("");
		}
		else {
			claimImpl.setProvider(provider);
		}

		if (prioritizedBill == null) {
			claimImpl.setPrioritizedBill("");
		}
		else {
			claimImpl.setPrioritizedBill(prioritizedBill);
		}

		if (diagCodesCombined == null) {
			claimImpl.setDiagCodesCombined("");
		}
		else {
			claimImpl.setDiagCodesCombined(diagCodesCombined);
		}

		if (providerState == null) {
			claimImpl.setProviderState("");
		}
		else {
			claimImpl.setProviderState(providerState);
		}

		if (tpmReceivedDate == Long.MIN_VALUE) {
			claimImpl.setTpmReceivedDate(null);
		}
		else {
			claimImpl.setTpmReceivedDate(new Date(tpmReceivedDate));
		}

		claimImpl.setClaimTurnaround(claimTurnaround);

		if (billType == null) {
			claimImpl.setBillType("");
		}
		else {
			claimImpl.setBillType(billType);
		}

		if (providerNetwork == null) {
			claimImpl.setProviderNetwork("");
		}
		else {
			claimImpl.setProviderNetwork(providerNetwork);
		}

		if (repricedNetwork == null) {
			claimImpl.setRepricedNetwork("");
		}
		else {
			claimImpl.setRepricedNetwork(repricedNetwork);
		}

		claimImpl.setStatusSortOrder(statusSortOrder);

		if (paidDate == Long.MIN_VALUE) {
			claimImpl.setPaidDate(null);
		}
		else {
			claimImpl.setPaidDate(new Date(paidDate));
		}

		claimImpl.setPaidAmount(paidAmount);

		if (claimStatus == null) {
			claimImpl.setClaimStatus("");
		}
		else {
			claimImpl.setClaimStatus(claimStatus);
		}

		if (rowProcessed == null) {
			claimImpl.setRowProcessed("");
		}
		else {
			claimImpl.setRowProcessed(rowProcessed);
		}

		claimImpl.resetOriginalValues();

		return claimImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		claimId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClaimId = objectInput.readLong();
		claimRef = objectInput.readUTF();
		authorizationNumber = objectInput.readUTF();
		serviceFrom = objectInput.readLong();
		serviceThru = objectInput.readLong();
		provider = objectInput.readUTF();
		prioritizedBill = objectInput.readUTF();
		diagCodesCombined = objectInput.readUTF();
		providerState = objectInput.readUTF();
		tpmReceivedDate = objectInput.readLong();

		claimTurnaround = objectInput.readLong();
		billType = objectInput.readUTF();
		providerNetwork = objectInput.readUTF();
		repricedNetwork = objectInput.readUTF();

		statusSortOrder = objectInput.readLong();
		paidDate = objectInput.readLong();

		paidAmount = objectInput.readDouble();
		claimStatus = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(claimId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
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

		objectOutput.writeLong(serviceFrom);
		objectOutput.writeLong(serviceThru);

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

		objectOutput.writeLong(tpmReceivedDate);

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
		objectOutput.writeLong(paidDate);

		objectOutput.writeDouble(paidAmount);

		if (claimStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimStatus);
		}

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public long claimId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalClaimId;
	public String claimRef;
	public String authorizationNumber;
	public long serviceFrom;
	public long serviceThru;
	public String provider;
	public String prioritizedBill;
	public String diagCodesCombined;
	public String providerState;
	public long tpmReceivedDate;
	public long claimTurnaround;
	public String billType;
	public String providerNetwork;
	public String repricedNetwork;
	public long statusSortOrder;
	public long paidDate;
	public double paidAmount;
	public String claimStatus;
	public String rowProcessed;

}