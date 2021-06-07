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

import com.argus.oth.cases.management.model.StagingCases;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingCases in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingCasesCacheModel
	implements CacheModel<StagingCases>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingCasesCacheModel)) {
			return false;
		}

		StagingCasesCacheModel stagingCasesCacheModel =
			(StagingCasesCacheModel)object;

		if (stagingCaseId == stagingCasesCacheModel.stagingCaseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingCaseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{stagingCaseId=");
		sb.append(stagingCaseId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", externalClientPk=");
		sb.append(externalClientPk);
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
	public StagingCases toEntityModel() {
		StagingCasesImpl stagingCasesImpl = new StagingCasesImpl();

		stagingCasesImpl.setStagingCaseId(stagingCaseId);

		if (createDate == Long.MIN_VALUE) {
			stagingCasesImpl.setCreateDate(null);
		}
		else {
			stagingCasesImpl.setCreateDate(new Date(createDate));
		}

		if (externalCaseId == null) {
			stagingCasesImpl.setExternalCaseId("");
		}
		else {
			stagingCasesImpl.setExternalCaseId(externalCaseId);
		}

		if (externalClientPk == null) {
			stagingCasesImpl.setExternalClientPk("");
		}
		else {
			stagingCasesImpl.setExternalClientPk(externalClientPk);
		}

		if (clientGroupId == null) {
			stagingCasesImpl.setClientGroupId("");
		}
		else {
			stagingCasesImpl.setClientGroupId(clientGroupId);
		}

		if (caseNumber == null) {
			stagingCasesImpl.setCaseNumber("");
		}
		else {
			stagingCasesImpl.setCaseNumber(caseNumber);
		}

		if (caseStartDate == null) {
			stagingCasesImpl.setCaseStartDate("");
		}
		else {
			stagingCasesImpl.setCaseStartDate(caseStartDate);
		}

		if (caseEndDate == null) {
			stagingCasesImpl.setCaseEndDate("");
		}
		else {
			stagingCasesImpl.setCaseEndDate(caseEndDate);
		}

		if (memberId == null) {
			stagingCasesImpl.setMemberId("");
		}
		else {
			stagingCasesImpl.setMemberId(memberId);
		}

		if (primaryDiagCode == null) {
			stagingCasesImpl.setPrimaryDiagCode("");
		}
		else {
			stagingCasesImpl.setPrimaryDiagCode(primaryDiagCode);
		}

		if (primaryCode == null) {
			stagingCasesImpl.setPrimaryCode("");
		}
		else {
			stagingCasesImpl.setPrimaryCode(primaryCode);
		}

		if (status == null) {
			stagingCasesImpl.setStatus("");
		}
		else {
			stagingCasesImpl.setStatus(status);
		}

		if (estimateEntryDate == null) {
			stagingCasesImpl.setEstimateEntryDate("");
		}
		else {
			stagingCasesImpl.setEstimateEntryDate(estimateEntryDate);
		}

		if (caseManager == null) {
			stagingCasesImpl.setCaseManager("");
		}
		else {
			stagingCasesImpl.setCaseManager(caseManager);
		}

		if (consentReceivedDate == null) {
			stagingCasesImpl.setConsentReceivedDate("");
		}
		else {
			stagingCasesImpl.setConsentReceivedDate(consentReceivedDate);
		}

		if (medicalPlan == null) {
			stagingCasesImpl.setMedicalPlan("");
		}
		else {
			stagingCasesImpl.setMedicalPlan(medicalPlan);
		}

		if (costEstimate == null) {
			stagingCasesImpl.setCostEstimate("");
		}
		else {
			stagingCasesImpl.setCostEstimate(costEstimate);
		}

		if (lastUpdated == null) {
			stagingCasesImpl.setLastUpdated("");
		}
		else {
			stagingCasesImpl.setLastUpdated(lastUpdated);
		}

		if (externalCreatedDate == null) {
			stagingCasesImpl.setExternalCreatedDate("");
		}
		else {
			stagingCasesImpl.setExternalCreatedDate(externalCreatedDate);
		}

		if (chargedAmount == null) {
			stagingCasesImpl.setChargedAmount("");
		}
		else {
			stagingCasesImpl.setChargedAmount(chargedAmount);
		}

		if (paidAmount == null) {
			stagingCasesImpl.setPaidAmount("");
		}
		else {
			stagingCasesImpl.setPaidAmount(paidAmount);
		}

		if (repricedAmount == null) {
			stagingCasesImpl.setRepricedAmount("");
		}
		else {
			stagingCasesImpl.setRepricedAmount(repricedAmount);
		}

		if (savingsAmount == null) {
			stagingCasesImpl.setSavingsAmount("");
		}
		else {
			stagingCasesImpl.setSavingsAmount(savingsAmount);
		}

		if (savingsPercent == null) {
			stagingCasesImpl.setSavingsPercent("");
		}
		else {
			stagingCasesImpl.setSavingsPercent(savingsPercent);
		}

		if (treatingPhysician == null) {
			stagingCasesImpl.setTreatingPhysician("");
		}
		else {
			stagingCasesImpl.setTreatingPhysician(treatingPhysician);
		}

		if (primaryFacility == null) {
			stagingCasesImpl.setPrimaryFacility("");
		}
		else {
			stagingCasesImpl.setPrimaryFacility(primaryFacility);
		}

		stagingCasesImpl.setRowProcessed(rowProcessed);

		stagingCasesImpl.resetOriginalValues();

		return stagingCasesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingCaseId = objectInput.readLong();
		createDate = objectInput.readLong();
		externalCaseId = objectInput.readUTF();
		externalClientPk = objectInput.readUTF();
		clientGroupId = objectInput.readUTF();
		caseNumber = objectInput.readUTF();
		caseStartDate = objectInput.readUTF();
		caseEndDate = objectInput.readUTF();
		memberId = objectInput.readUTF();
		primaryDiagCode = objectInput.readUTF();
		primaryCode = objectInput.readUTF();
		status = objectInput.readUTF();
		estimateEntryDate = objectInput.readUTF();
		caseManager = objectInput.readUTF();
		consentReceivedDate = objectInput.readUTF();
		medicalPlan = objectInput.readUTF();
		costEstimate = objectInput.readUTF();
		lastUpdated = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
		chargedAmount = objectInput.readUTF();
		paidAmount = objectInput.readUTF();
		repricedAmount = objectInput.readUTF();
		savingsAmount = objectInput.readUTF();
		savingsPercent = objectInput.readUTF();
		treatingPhysician = objectInput.readUTF();
		primaryFacility = objectInput.readUTF();

		rowProcessed = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingCaseId);
		objectOutput.writeLong(createDate);

		if (externalCaseId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCaseId);
		}

		if (externalClientPk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalClientPk);
		}

		if (clientGroupId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientGroupId);
		}

		if (caseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseNumber);
		}

		if (caseStartDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseStartDate);
		}

		if (caseEndDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseEndDate);
		}

		if (memberId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberId);
		}

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

		if (estimateEntryDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(estimateEntryDate);
		}

		if (caseManager == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseManager);
		}

		if (consentReceivedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consentReceivedDate);
		}

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

		if (lastUpdated == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastUpdated);
		}

		if (externalCreatedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCreatedDate);
		}

		if (chargedAmount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chargedAmount);
		}

		if (paidAmount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paidAmount);
		}

		if (repricedAmount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(repricedAmount);
		}

		if (savingsAmount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(savingsAmount);
		}

		if (savingsPercent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(savingsPercent);
		}

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

		objectOutput.writeBoolean(rowProcessed);
	}

	public long stagingCaseId;
	public long createDate;
	public String externalCaseId;
	public String externalClientPk;
	public String clientGroupId;
	public String caseNumber;
	public String caseStartDate;
	public String caseEndDate;
	public String memberId;
	public String primaryDiagCode;
	public String primaryCode;
	public String status;
	public String estimateEntryDate;
	public String caseManager;
	public String consentReceivedDate;
	public String medicalPlan;
	public String costEstimate;
	public String lastUpdated;
	public String externalCreatedDate;
	public String chargedAmount;
	public String paidAmount;
	public String repricedAmount;
	public String savingsAmount;
	public String savingsPercent;
	public String treatingPhysician;
	public String primaryFacility;
	public boolean rowProcessed;

}