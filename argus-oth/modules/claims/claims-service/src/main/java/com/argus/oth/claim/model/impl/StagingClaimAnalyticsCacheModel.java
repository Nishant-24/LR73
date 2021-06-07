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

import com.argus.oth.claim.model.StagingClaimAnalytics;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingClaimAnalytics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingClaimAnalyticsCacheModel
	implements CacheModel<StagingClaimAnalytics>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingClaimAnalyticsCacheModel)) {
			return false;
		}

		StagingClaimAnalyticsCacheModel stagingClaimAnalyticsCacheModel =
			(StagingClaimAnalyticsCacheModel)object;

		if (stagingClaimAnalyticsId ==
				stagingClaimAnalyticsCacheModel.stagingClaimAnalyticsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingClaimAnalyticsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{stagingClaimAnalyticsId=");
		sb.append(stagingClaimAnalyticsId);
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
	public StagingClaimAnalytics toEntityModel() {
		StagingClaimAnalyticsImpl stagingClaimAnalyticsImpl =
			new StagingClaimAnalyticsImpl();

		stagingClaimAnalyticsImpl.setStagingClaimAnalyticsId(
			stagingClaimAnalyticsId);

		if (createDate == Long.MIN_VALUE) {
			stagingClaimAnalyticsImpl.setCreateDate(null);
		}
		else {
			stagingClaimAnalyticsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingClaimAnalyticsImpl.setModifiedDate(null);
		}
		else {
			stagingClaimAnalyticsImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingClaimAnalyticsImpl.setExternalClientId(externalClientId);

		if (clientName == null) {
			stagingClaimAnalyticsImpl.setClientName("");
		}
		else {
			stagingClaimAnalyticsImpl.setClientName(clientName);
		}

		if (claimNumber == null) {
			stagingClaimAnalyticsImpl.setClaimNumber("");
		}
		else {
			stagingClaimAnalyticsImpl.setClaimNumber(claimNumber);
		}

		stagingClaimAnalyticsImpl.setExternalCaseId(externalCaseId);

		if (claimStatus == null) {
			stagingClaimAnalyticsImpl.setClaimStatus("");
		}
		else {
			stagingClaimAnalyticsImpl.setClaimStatus(claimStatus);
		}

		if (receivedDate == null) {
			stagingClaimAnalyticsImpl.setReceivedDate("");
		}
		else {
			stagingClaimAnalyticsImpl.setReceivedDate(receivedDate);
		}

		if (serviceDate == null) {
			stagingClaimAnalyticsImpl.setServiceDate("");
		}
		else {
			stagingClaimAnalyticsImpl.setServiceDate(serviceDate);
		}

		if (paidDate == null) {
			stagingClaimAnalyticsImpl.setPaidDate("");
		}
		else {
			stagingClaimAnalyticsImpl.setPaidDate(paidDate);
		}

		stagingClaimAnalyticsImpl.setExternalMemberId(externalMemberId);

		if (memberName == null) {
			stagingClaimAnalyticsImpl.setMemberName("");
		}
		else {
			stagingClaimAnalyticsImpl.setMemberName(memberName);
		}

		if (providerName == null) {
			stagingClaimAnalyticsImpl.setProviderName("");
		}
		else {
			stagingClaimAnalyticsImpl.setProviderName(providerName);
		}

		if (billType == null) {
			stagingClaimAnalyticsImpl.setBillType("");
		}
		else {
			stagingClaimAnalyticsImpl.setBillType(billType);
		}

		if (primaryDiagnosis == null) {
			stagingClaimAnalyticsImpl.setPrimaryDiagnosis("");
		}
		else {
			stagingClaimAnalyticsImpl.setPrimaryDiagnosis(primaryDiagnosis);
		}

		stagingClaimAnalyticsImpl.setChargedAmount(chargedAmount);
		stagingClaimAnalyticsImpl.setPaidAmount(paidAmount);
		stagingClaimAnalyticsImpl.setRepricedAmount(repricedAmount);
		stagingClaimAnalyticsImpl.setSavingsAmount(savingsAmount);
		stagingClaimAnalyticsImpl.setChargedPercent(chargedPercent);
		stagingClaimAnalyticsImpl.setRepricedPercent(repricedPercent);
		stagingClaimAnalyticsImpl.setSavingsPercent(savingsPercent);

		if (chargedRange == null) {
			stagingClaimAnalyticsImpl.setChargedRange("");
		}
		else {
			stagingClaimAnalyticsImpl.setChargedRange(chargedRange);
		}

		if (paidRange == null) {
			stagingClaimAnalyticsImpl.setPaidRange("");
		}
		else {
			stagingClaimAnalyticsImpl.setPaidRange(paidRange);
		}

		if (repricedRange == null) {
			stagingClaimAnalyticsImpl.setRepricedRange("");
		}
		else {
			stagingClaimAnalyticsImpl.setRepricedRange(repricedRange);
		}

		if (savingsRange == null) {
			stagingClaimAnalyticsImpl.setSavingsRange("");
		}
		else {
			stagingClaimAnalyticsImpl.setSavingsRange(savingsRange);
		}

		stagingClaimAnalyticsImpl.setClaimAging(claimAging);

		if (procedureCodes == null) {
			stagingClaimAnalyticsImpl.setProcedureCodes("");
		}
		else {
			stagingClaimAnalyticsImpl.setProcedureCodes(procedureCodes);
		}

		if (resultCodes == null) {
			stagingClaimAnalyticsImpl.setResultCodes("");
		}
		else {
			stagingClaimAnalyticsImpl.setResultCodes(resultCodes);
		}

		if (diagnosisCodes == null) {
			stagingClaimAnalyticsImpl.setDiagnosisCodes("");
		}
		else {
			stagingClaimAnalyticsImpl.setDiagnosisCodes(diagnosisCodes);
		}

		if (country == null) {
			stagingClaimAnalyticsImpl.setCountry("");
		}
		else {
			stagingClaimAnalyticsImpl.setCountry(country);
		}

		if (state == null) {
			stagingClaimAnalyticsImpl.setState("");
		}
		else {
			stagingClaimAnalyticsImpl.setState(state);
		}

		stagingClaimAnalyticsImpl.setFinancialExposure(financialExposure);

		if (repricedNetwork == null) {
			stagingClaimAnalyticsImpl.setRepricedNetwork("");
		}
		else {
			stagingClaimAnalyticsImpl.setRepricedNetwork(repricedNetwork);
		}

		if (clientGroupName == null) {
			stagingClaimAnalyticsImpl.setClientGroupName("");
		}
		else {
			stagingClaimAnalyticsImpl.setClientGroupName(clientGroupName);
		}

		stagingClaimAnalyticsImpl.resetOriginalValues();

		return stagingClaimAnalyticsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingClaimAnalyticsId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClientId = objectInput.readLong();
		clientName = objectInput.readUTF();
		claimNumber = objectInput.readUTF();

		externalCaseId = objectInput.readLong();
		claimStatus = objectInput.readUTF();
		receivedDate = objectInput.readUTF();
		serviceDate = objectInput.readUTF();
		paidDate = objectInput.readUTF();

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
		objectOutput.writeLong(stagingClaimAnalyticsId);
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

		if (receivedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivedDate);
		}

		if (serviceDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceDate);
		}

		if (paidDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paidDate);
		}

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

	public long stagingClaimAnalyticsId;
	public long createDate;
	public long modifiedDate;
	public long externalClientId;
	public String clientName;
	public String claimNumber;
	public long externalCaseId;
	public String claimStatus;
	public String receivedDate;
	public String serviceDate;
	public String paidDate;
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