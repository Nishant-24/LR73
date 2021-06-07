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

import com.argus.oth.cases.management.model.ClaimDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClaimDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimDetailCacheModel
	implements CacheModel<ClaimDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimDetailCacheModel)) {
			return false;
		}

		ClaimDetailCacheModel claimDetailCacheModel =
			(ClaimDetailCacheModel)object;

		if (claimDetailId == claimDetailCacheModel.claimDetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{claimDetailId=");
		sb.append(claimDetailId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", lineId=");
		sb.append(lineId);
		sb.append(", externalClaimId=");
		sb.append(externalClaimId);
		sb.append(", serviceFrom=");
		sb.append(serviceFrom);
		sb.append(", serviceThru=");
		sb.append(serviceThru);
		sb.append(", resultCodes=");
		sb.append(resultCodes);
		sb.append(", procedureCode=");
		sb.append(procedureCode);
		sb.append(", chargedAmount=");
		sb.append(chargedAmount);
		sb.append(", repricedAmount=");
		sb.append(repricedAmount);
		sb.append(", claimAmount=");
		sb.append(claimAmount);
		sb.append(", paidDate=");
		sb.append(paidDate);
		sb.append(", paidAmount=");
		sb.append(paidAmount);
		sb.append(", savingsAmount=");
		sb.append(savingsAmount);
		sb.append(", units=");
		sb.append(units);
		sb.append(", coverage=");
		sb.append(coverage);
		sb.append(", lineStatus=");
		sb.append(lineStatus);
		sb.append(", revCode=");
		sb.append(revCode);
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClaimDetail toEntityModel() {
		ClaimDetailImpl claimDetailImpl = new ClaimDetailImpl();

		claimDetailImpl.setClaimDetailId(claimDetailId);
		claimDetailImpl.setGroupId(groupId);
		claimDetailImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			claimDetailImpl.setCreateDate(null);
		}
		else {
			claimDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			claimDetailImpl.setModifiedDate(null);
		}
		else {
			claimDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		claimDetailImpl.setLineId(lineId);
		claimDetailImpl.setExternalClaimId(externalClaimId);

		if (serviceFrom == Long.MIN_VALUE) {
			claimDetailImpl.setServiceFrom(null);
		}
		else {
			claimDetailImpl.setServiceFrom(new Date(serviceFrom));
		}

		if (serviceThru == Long.MIN_VALUE) {
			claimDetailImpl.setServiceThru(null);
		}
		else {
			claimDetailImpl.setServiceThru(new Date(serviceThru));
		}

		if (resultCodes == null) {
			claimDetailImpl.setResultCodes("");
		}
		else {
			claimDetailImpl.setResultCodes(resultCodes);
		}

		if (procedureCode == null) {
			claimDetailImpl.setProcedureCode("");
		}
		else {
			claimDetailImpl.setProcedureCode(procedureCode);
		}

		claimDetailImpl.setChargedAmount(chargedAmount);
		claimDetailImpl.setRepricedAmount(repricedAmount);
		claimDetailImpl.setClaimAmount(claimAmount);

		if (paidDate == Long.MIN_VALUE) {
			claimDetailImpl.setPaidDate(null);
		}
		else {
			claimDetailImpl.setPaidDate(new Date(paidDate));
		}

		claimDetailImpl.setPaidAmount(paidAmount);
		claimDetailImpl.setSavingsAmount(savingsAmount);
		claimDetailImpl.setUnits(units);

		if (coverage == null) {
			claimDetailImpl.setCoverage("");
		}
		else {
			claimDetailImpl.setCoverage(coverage);
		}

		if (lineStatus == null) {
			claimDetailImpl.setLineStatus("");
		}
		else {
			claimDetailImpl.setLineStatus(lineStatus);
		}

		if (revCode == null) {
			claimDetailImpl.setRevCode("");
		}
		else {
			claimDetailImpl.setRevCode(revCode);
		}

		if (rowProcessed == null) {
			claimDetailImpl.setRowProcessed("");
		}
		else {
			claimDetailImpl.setRowProcessed(rowProcessed);
		}

		claimDetailImpl.resetOriginalValues();

		return claimDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		claimDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		lineId = objectInput.readLong();

		externalClaimId = objectInput.readLong();
		serviceFrom = objectInput.readLong();
		serviceThru = objectInput.readLong();
		resultCodes = objectInput.readUTF();
		procedureCode = objectInput.readUTF();

		chargedAmount = objectInput.readDouble();

		repricedAmount = objectInput.readDouble();

		claimAmount = objectInput.readDouble();
		paidDate = objectInput.readLong();

		paidAmount = objectInput.readDouble();

		savingsAmount = objectInput.readDouble();

		units = objectInput.readInt();
		coverage = objectInput.readUTF();
		lineStatus = objectInput.readUTF();
		revCode = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(claimDetailId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(lineId);

		objectOutput.writeLong(externalClaimId);
		objectOutput.writeLong(serviceFrom);
		objectOutput.writeLong(serviceThru);

		if (resultCodes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resultCodes);
		}

		if (procedureCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procedureCode);
		}

		objectOutput.writeDouble(chargedAmount);

		objectOutput.writeDouble(repricedAmount);

		objectOutput.writeDouble(claimAmount);
		objectOutput.writeLong(paidDate);

		objectOutput.writeDouble(paidAmount);

		objectOutput.writeDouble(savingsAmount);

		objectOutput.writeInt(units);

		if (coverage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverage);
		}

		if (lineStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lineStatus);
		}

		if (revCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(revCode);
		}

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public long claimDetailId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long lineId;
	public long externalClaimId;
	public long serviceFrom;
	public long serviceThru;
	public String resultCodes;
	public String procedureCode;
	public double chargedAmount;
	public double repricedAmount;
	public double claimAmount;
	public long paidDate;
	public double paidAmount;
	public double savingsAmount;
	public int units;
	public String coverage;
	public String lineStatus;
	public String revCode;
	public String rowProcessed;

}