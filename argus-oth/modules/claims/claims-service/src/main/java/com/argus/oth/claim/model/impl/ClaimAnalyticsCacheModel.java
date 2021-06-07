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

package com.argus.oth.claim.model.impl;

import com.argus.oth.claim.model.ClaimAnalytics;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClaimAnalytics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimAnalyticsCacheModel
	implements CacheModel<ClaimAnalytics>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimAnalyticsCacheModel)) {
			return false;
		}

		ClaimAnalyticsCacheModel claimAnalyticsCacheModel =
			(ClaimAnalyticsCacheModel)object;

		if (claimAnalyticsId == claimAnalyticsCacheModel.claimAnalyticsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimAnalyticsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(77);

		sb.append("{claimAnalyticsId=");
		sb.append(claimAnalyticsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalClientId=");
		sb.append(externalClientId);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", claimNumber=");
		sb.append(claimNumber);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", claimStatus=");
		sb.append(claimStatus);
		sb.append(", receivedDate=");
		sb.append(receivedDate);
		sb.append(", serviceDate=");
		sb.append(serviceDate);
		sb.append(", paidDate=");
		sb.append(paidDate);
		sb.append(", externalMemberId=");
		sb.append(externalMemberId);
		sb.append(", memberName=");
		sb.append(memberName);
		sb.append(", providerName=");
		sb.append(providerName);
		sb.append(", billType=");
		sb.append(billType);
		sb.append(", primaryDiagnosis=");
		sb.append(primaryDiagnosis);
		sb.append(", chargedAmount=");
		sb.append(chargedAmount);
		sb.append(", paidAmount=");
		sb.append(paidAmount);
		sb.append(", repricedAmount=");
		sb.append(repricedAmount);
		sb.append(", savingsAmount=");
		sb.append(savingsAmount);
		sb.append(", chargedPercent=");
		sb.append(chargedPercent);
		sb.append(", repricedPercent=");
		sb.append(repricedPercent);
		sb.append(", savingsPercent=");
		sb.append(savingsPercent);
		sb.append(", chargedRange=");
		sb.append(chargedRange);
		sb.append(", paidRange=");
		sb.append(paidRange);
		sb.append(", repricedRange=");
		sb.append(repricedRange);
		sb.append(", savingsRange=");
		sb.append(savingsRange);
		sb.append(", claimAging=");
		sb.append(claimAging);
		sb.append(", procedureCodes=");
		sb.append(procedureCodes);
		sb.append(", resultCodes=");
		sb.append(resultCodes);
		sb.append(", diagnosisCodes=");
		sb.append(diagnosisCodes);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", financialExposure=");
		sb.append(financialExposure);
		sb.append(", repricedNetwork=");
		sb.append(repricedNetwork);
		sb.append(", clientGroupName=");
		sb.append(clientGroupName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClaimAnalytics toEntityModel() {
		ClaimAnalyticsImpl claimAnalyticsImpl = new ClaimAnalyticsImpl();

		claimAnalyticsImpl.setClaimAnalyticsId(claimAnalyticsId);
		claimAnalyticsImpl.setGroupId(groupId);
		claimAnalyticsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			claimAnalyticsImpl.setCreateDate(null);
		}
		else {
			claimAnalyticsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			claimAnalyticsImpl.setModifiedDate(null);
		}
		else {
			claimAnalyticsImpl.setModifiedDate(new Date(modifiedDate));
		}

		claimAnalyticsImpl.setExternalClientId(externalClientId);

		if (clientName == null) {
			claimAnalyticsImpl.setClientName("");
		}
		else {
			claimAnalyticsImpl.setClientName(clientName);
		}

		if (claimNumber == null) {
			claimAnalyticsImpl.setClaimNumber("");
		}
		else {
			claimAnalyticsImpl.setClaimNumber(claimNumber);
		}

		claimAnalyticsImpl.setExternalCaseId(externalCaseId);

		if (claimStatus == null) {
			claimAnalyticsImpl.setClaimStatus("");
		}
		else {
			claimAnalyticsImpl.setClaimStatus(claimStatus);
		}

		if (receivedDate == Long.MIN_VALUE) {
			claimAnalyticsImpl.setReceivedDate(null);
		}
		else {
			claimAnalyticsImpl.setReceivedDate(new Date(receivedDate));
		}

		if (serviceDate == Long.MIN_VALUE) {
			claimAnalyticsImpl.setServiceDate(null);
		}
		else {
			claimAnalyticsImpl.setServiceDate(new Date(serviceDate));
		}

		if (paidDate == Long.MIN_VALUE) {
			claimAnalyticsImpl.setPaidDate(null);
		}
		else {
			claimAnalyticsImpl.setPaidDate(new Date(paidDate));
		}

		claimAnalyticsImpl.setExternalMemberId(externalMemberId);

		if (memberName == null) {
			claimAnalyticsImpl.setMemberName("");
		}
		else {
			claimAnalyticsImpl.setMemberName(memberName);
		}

		if (providerName == null) {
			claimAnalyticsImpl.setProviderName("");
		}
		else {
			claimAnalyticsImpl.setProviderName(providerName);
		}

		if (billType == null) {
			claimAnalyticsImpl.setBillType("");
		}
		else {
			claimAnalyticsImpl.setBillType(billType);
		}

		if (primaryDiagnosis == null) {
			claimAnalyticsImpl.setPrimaryDiagnosis("");
		}
		else {
			claimAnalyticsImpl.setPrimaryDiagnosis(primaryDiagnosis);
		}

		claimAnalyticsImpl.setChargedAmount(chargedAmount);
		claimAnalyticsImpl.setPaidAmount(paidAmount);
		claimAnalyticsImpl.setRepricedAmount(repricedAmount);
		claimAnalyticsImpl.setSavingsAmount(savingsAmount);
		claimAnalyticsImpl.setChargedPercent(chargedPercent);
		claimAnalyticsImpl.setRepricedPercent(repricedPercent);
		claimAnalyticsImpl.setSavingsPercent(savingsPercent);

		if (chargedRange == null) {
			claimAnalyticsImpl.setChargedRange("");
		}
		else {
			claimAnalyticsImpl.setChargedRange(chargedRange);
		}

		if (paidRange == null) {
			claimAnalyticsImpl.setPaidRange("");
		}
		else {
			claimAnalyticsImpl.setPaidRange(paidRange);
		}

		if (repricedRange == null) {
			claimAnalyticsImpl.setRepricedRange("");
		}
		else {
			claimAnalyticsImpl.setRepricedRange(repricedRange);
		}

		if (savingsRange == null) {
			claimAnalyticsImpl.setSavingsRange("");
		}
		else {
			claimAnalyticsImpl.setSavingsRange(savingsRange);
		}

		claimAnalyticsImpl.setClaimAging(claimAging);

		if (procedureCodes == null) {
			claimAnalyticsImpl.setProcedureCodes("");
		}
		else {
			claimAnalyticsImpl.setProcedureCodes(procedureCodes);
		}

		if (resultCodes == null) {
			claimAnalyticsImpl.setResultCodes("");
		}
		else {
			claimAnalyticsImpl.setResultCodes(resultCodes);
		}

		if (diagnosisCodes == null) {
			claimAnalyticsImpl.setDiagnosisCodes("");
		}
		else {
			claimAnalyticsImpl.setDiagnosisCodes(diagnosisCodes);
		}

		if (country == null) {
			claimAnalyticsImpl.setCountry("");
		}
		else {
			claimAnalyticsImpl.setCountry(country);
		}

		if (state == null) {
			claimAnalyticsImpl.setState("");
		}
		else {
			claimAnalyticsImpl.setState(state);
		}

		claimAnalyticsImpl.setFinancialExposure(financialExposure);

		if (repricedNetwork == null) {
			claimAnalyticsImpl.setRepricedNetwork("");
		}
		else {
			claimAnalyticsImpl.setRepricedNetwork(repricedNetwork);
		}

		if (clientGroupName == null) {
			claimAnalyticsImpl.setClientGroupName("");
		}
		else {
			claimAnalyticsImpl.setClientGroupName(clientGroupName);
		}

		claimAnalyticsImpl.resetOriginalValues();

		return claimAnalyticsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		claimAnalyticsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClientId = objectInput.readLong();
		clientName = objectInput.readUTF();
		claimNumber = objectInput.readUTF();

		externalCaseId = objectInput.readLong();
		claimStatus = objectInput.readUTF();
		receivedDate = objectInput.readLong();
		serviceDate = objectInput.readLong();
		paidDate = objectInput.readLong();

		externalMemberId = objectInput.readLong();
		memberName = objectInput.readUTF();
		providerName = objectInput.readUTF();
		billType = objectInput.readUTF();
		primaryDiagnosis = objectInput.readUTF();

		chargedAmount = objectInput.readDouble();

		paidAmount = objectInput.readDouble();

		repricedAmount = objectInput.readDouble();

		savingsAmount = objectInput.readDouble();

		chargedPercent = objectInput.readDouble();

		repricedPercent = objectInput.readDouble();

		savingsPercent = objectInput.readDouble();
		chargedRange = objectInput.readUTF();
		paidRange = objectInput.readUTF();
		repricedRange = objectInput.readUTF();
		savingsRange = objectInput.readUTF();

		claimAging = objectInput.readLong();
		procedureCodes = objectInput.readUTF();
		resultCodes = objectInput.readUTF();
		diagnosisCodes = objectInput.readUTF();
		country = objectInput.readUTF();
		state = objectInput.readUTF();

		financialExposure = objectInput.readDouble();
		repricedNetwork = objectInput.readUTF();
		clientGroupName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(claimAnalyticsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalClientId);

		if (clientName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		if (claimNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimNumber);
		}

		objectOutput.writeLong(externalCaseId);

		if (claimStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimStatus);
		}

		objectOutput.writeLong(receivedDate);
		objectOutput.writeLong(serviceDate);
		objectOutput.writeLong(paidDate);

		objectOutput.writeLong(externalMemberId);

		if (memberName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberName);
		}

		if (providerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(providerName);
		}

		if (billType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billType);
		}

		if (primaryDiagnosis == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryDiagnosis);
		}

		objectOutput.writeDouble(chargedAmount);

		objectOutput.writeDouble(paidAmount);

		objectOutput.writeDouble(repricedAmount);

		objectOutput.writeDouble(savingsAmount);

		objectOutput.writeDouble(chargedPercent);

		objectOutput.writeDouble(repricedPercent);

		objectOutput.writeDouble(savingsPercent);

		if (chargedRange == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chargedRange);
		}

		if (paidRange == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paidRange);
		}

		if (repricedRange == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(repricedRange);
		}

		if (savingsRange == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(savingsRange);
		}

		objectOutput.writeLong(claimAging);

		if (procedureCodes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procedureCodes);
		}

		if (resultCodes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resultCodes);
		}

		if (diagnosisCodes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diagnosisCodes);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeDouble(financialExposure);

		if (repricedNetwork == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(repricedNetwork);
		}

		if (clientGroupName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientGroupName);
		}
	}

	public long claimAnalyticsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalClientId;
	public String clientName;
	public String claimNumber;
	public long externalCaseId;
	public String claimStatus;
	public long receivedDate;
	public long serviceDate;
	public long paidDate;
	public long externalMemberId;
	public String memberName;
	public String providerName;
	public String billType;
	public String primaryDiagnosis;
	public double chargedAmount;
	public double paidAmount;
	public double repricedAmount;
	public double savingsAmount;
	public double chargedPercent;
	public double repricedPercent;
	public double savingsPercent;
	public String chargedRange;
	public String paidRange;
	public String repricedRange;
	public String savingsRange;
	public long claimAging;
	public String procedureCodes;
	public String resultCodes;
	public String diagnosisCodes;
	public String country;
	public String state;
	public double financialExposure;
	public String repricedNetwork;
	public String clientGroupName;

}