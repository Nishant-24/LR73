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

import com.argus.oth.cases.management.model.Cases;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cases in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CasesCacheModel implements CacheModel<Cases>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CasesCacheModel)) {
			return false;
		}

		CasesCacheModel casesCacheModel = (CasesCacheModel)obj;

		if (caseId == casesCacheModel.caseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, caseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", caseId=");
		sb.append(caseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", clientGroupId=");
		sb.append(clientGroupId);
		sb.append(", caseNumber=");
		sb.append(caseNumber);
		sb.append(", caseStartDate=");
		sb.append(caseStartDate);
		sb.append(", caseEndDate=");
		sb.append(caseEndDate);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", primaryDiagCode=");
		sb.append(primaryDiagCode);
		sb.append(", primaryCode=");
		sb.append(primaryCode);
		sb.append(", status=");
		sb.append(status);
		sb.append(", estimateEntryDate=");
		sb.append(estimateEntryDate);
		sb.append(", caseManager=");
		sb.append(caseManager);
		sb.append(", consentReceivedDate=");
		sb.append(consentReceivedDate);
		sb.append(", medicalPlan=");
		sb.append(medicalPlan);
		sb.append(", costEstimate=");
		sb.append(costEstimate);
		sb.append(", lastUpdated=");
		sb.append(lastUpdated);
		sb.append(", externalCreatedDate=");
		sb.append(externalCreatedDate);
		sb.append(", chargedAmount=");
		sb.append(chargedAmount);
		sb.append(", paidAmount=");
		sb.append(paidAmount);
		sb.append(", repricedAmount=");
		sb.append(repricedAmount);
		sb.append(", savingsAmount=");
		sb.append(savingsAmount);
		sb.append(", savingsPercent=");
		sb.append(savingsPercent);
		sb.append(", treatingPhysician=");
		sb.append(treatingPhysician);
		sb.append(", primaryFacility=");
		sb.append(primaryFacility);
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cases toEntityModel() {
		CasesImpl casesImpl = new CasesImpl();

		if (uuid == null) {
			casesImpl.setUuid("");
		}
		else {
			casesImpl.setUuid(uuid);
		}

		casesImpl.setCaseId(caseId);
		casesImpl.setGroupId(groupId);
		casesImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			casesImpl.setCreateDate(null);
		}
		else {
			casesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			casesImpl.setModifiedDate(null);
		}
		else {
			casesImpl.setModifiedDate(new Date(modifiedDate));
		}

		casesImpl.setExternalCaseId(externalCaseId);
		casesImpl.setClientId(clientId);

		if (clientName == null) {
			casesImpl.setClientName("");
		}
		else {
			casesImpl.setClientName(clientName);
		}

		casesImpl.setClientGroupId(clientGroupId);

		if (caseNumber == null) {
			casesImpl.setCaseNumber("");
		}
		else {
			casesImpl.setCaseNumber(caseNumber);
		}

		if (caseStartDate == Long.MIN_VALUE) {
			casesImpl.setCaseStartDate(null);
		}
		else {
			casesImpl.setCaseStartDate(new Date(caseStartDate));
		}

		if (caseEndDate == Long.MIN_VALUE) {
			casesImpl.setCaseEndDate(null);
		}
		else {
			casesImpl.setCaseEndDate(new Date(caseEndDate));
		}

		casesImpl.setMemberId(memberId);

		if (primaryDiagCode == null) {
			casesImpl.setPrimaryDiagCode("");
		}
		else {
			casesImpl.setPrimaryDiagCode(primaryDiagCode);
		}

		if (primaryCode == null) {
			casesImpl.setPrimaryCode("");
		}
		else {
			casesImpl.setPrimaryCode(primaryCode);
		}

		if (status == null) {
			casesImpl.setStatus("");
		}
		else {
			casesImpl.setStatus(status);
		}

		if (estimateEntryDate == Long.MIN_VALUE) {
			casesImpl.setEstimateEntryDate(null);
		}
		else {
			casesImpl.setEstimateEntryDate(new Date(estimateEntryDate));
		}

		if (caseManager == null) {
			casesImpl.setCaseManager("");
		}
		else {
			casesImpl.setCaseManager(caseManager);
		}

		if (consentReceivedDate == Long.MIN_VALUE) {
			casesImpl.setConsentReceivedDate(null);
		}
		else {
			casesImpl.setConsentReceivedDate(new Date(consentReceivedDate));
		}

		if (medicalPlan == null) {
			casesImpl.setMedicalPlan("");
		}
		else {
			casesImpl.setMedicalPlan(medicalPlan);
		}

		if (costEstimate == null) {
			casesImpl.setCostEstimate("");
		}
		else {
			casesImpl.setCostEstimate(costEstimate);
		}

		if (lastUpdated == Long.MIN_VALUE) {
			casesImpl.setLastUpdated(null);
		}
		else {
			casesImpl.setLastUpdated(new Date(lastUpdated));
		}

		if (externalCreatedDate == Long.MIN_VALUE) {
			casesImpl.setExternalCreatedDate(null);
		}
		else {
			casesImpl.setExternalCreatedDate(new Date(externalCreatedDate));
		}

		casesImpl.setChargedAmount(chargedAmount);
		casesImpl.setPaidAmount(paidAmount);
		casesImpl.setRepricedAmount(repricedAmount);
		casesImpl.setSavingsAmount(savingsAmount);
		casesImpl.setSavingsPercent(savingsPercent);

		if (treatingPhysician == null) {
			casesImpl.setTreatingPhysician("");
		}
		else {
			casesImpl.setTreatingPhysician(treatingPhysician);
		}

		if (primaryFacility == null) {
			casesImpl.setPrimaryFacility("");
		}
		else {
			casesImpl.setPrimaryFacility(primaryFacility);
		}

		if (rowProcessed == null) {
			casesImpl.setRowProcessed("");
		}
		else {
			casesImpl.setRowProcessed(rowProcessed);
		}

		casesImpl.resetOriginalValues();

		return casesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		caseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalCaseId = objectInput.readLong();

		clientId = objectInput.readLong();
		clientName = objectInput.readUTF();

		clientGroupId = objectInput.readLong();
		caseNumber = objectInput.readUTF();
		caseStartDate = objectInput.readLong();
		caseEndDate = objectInput.readLong();

		memberId = objectInput.readLong();
		primaryDiagCode = objectInput.readUTF();
		primaryCode = objectInput.readUTF();
		status = objectInput.readUTF();
		estimateEntryDate = objectInput.readLong();
		caseManager = objectInput.readUTF();
		consentReceivedDate = objectInput.readLong();
		medicalPlan = objectInput.readUTF();
		costEstimate = objectInput.readUTF();
		lastUpdated = objectInput.readLong();
		externalCreatedDate = objectInput.readLong();

		chargedAmount = objectInput.readDouble();

		paidAmount = objectInput.readDouble();

		repricedAmount = objectInput.readDouble();

		savingsAmount = objectInput.readDouble();

		savingsPercent = objectInput.readDouble();
		treatingPhysician = objectInput.readUTF();
		primaryFacility = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(caseId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalCaseId);

		objectOutput.writeLong(clientId);

		if (clientName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		objectOutput.writeLong(clientGroupId);

		if (caseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseNumber);
		}

		objectOutput.writeLong(caseStartDate);
		objectOutput.writeLong(caseEndDate);

		objectOutput.writeLong(memberId);

		if (primaryDiagCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryDiagCode);
		}

		if (primaryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryCode);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(estimateEntryDate);

		if (caseManager == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseManager);
		}

		objectOutput.writeLong(consentReceivedDate);

		if (medicalPlan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(medicalPlan);
		}

		if (costEstimate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(costEstimate);
		}

		objectOutput.writeLong(lastUpdated);
		objectOutput.writeLong(externalCreatedDate);

		objectOutput.writeDouble(chargedAmount);

		objectOutput.writeDouble(paidAmount);

		objectOutput.writeDouble(repricedAmount);

		objectOutput.writeDouble(savingsAmount);

		objectOutput.writeDouble(savingsPercent);

		if (treatingPhysician == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(treatingPhysician);
		}

		if (primaryFacility == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryFacility);
		}

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public String uuid;
	public long caseId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalCaseId;
	public long clientId;
	public String clientName;
	public long clientGroupId;
	public String caseNumber;
	public long caseStartDate;
	public long caseEndDate;
	public long memberId;
	public String primaryDiagCode;
	public String primaryCode;
	public String status;
	public long estimateEntryDate;
	public String caseManager;
	public long consentReceivedDate;
	public String medicalPlan;
	public String costEstimate;
	public long lastUpdated;
	public long externalCreatedDate;
	public double chargedAmount;
	public double paidAmount;
	public double repricedAmount;
	public double savingsAmount;
	public double savingsPercent;
	public String treatingPhysician;
	public String primaryFacility;
	public String rowProcessed;

}