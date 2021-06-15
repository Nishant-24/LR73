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

import com.argus.oth.cases.management.model.StagingClaimDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingClaimDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingClaimDetailCacheModel
	implements CacheModel<StagingClaimDetail>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StagingClaimDetailCacheModel)) {
			return false;
		}

		StagingClaimDetailCacheModel stagingClaimDetailCacheModel =
			(StagingClaimDetailCacheModel)obj;

		if (stagingClaimDetailId ==
				stagingClaimDetailCacheModel.stagingClaimDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingClaimDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{stagingClaimDetailId=");
		sb.append(stagingClaimDetailId);
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
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", externalCreatedDate=");
		sb.append(externalCreatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingClaimDetail toEntityModel() {
		StagingClaimDetailImpl stagingClaimDetailImpl =
			new StagingClaimDetailImpl();

		stagingClaimDetailImpl.setStagingClaimDetailId(stagingClaimDetailId);

		if (createDate == Long.MIN_VALUE) {
			stagingClaimDetailImpl.setCreateDate(null);
		}
		else {
			stagingClaimDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingClaimDetailImpl.setModifiedDate(null);
		}
		else {
			stagingClaimDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingClaimDetailImpl.setLineId(lineId);
		stagingClaimDetailImpl.setExternalClaimId(externalClaimId);

		if (serviceFrom == null) {
			stagingClaimDetailImpl.setServiceFrom("");
		}
		else {
			stagingClaimDetailImpl.setServiceFrom(serviceFrom);
		}

		if (serviceThru == null) {
			stagingClaimDetailImpl.setServiceThru("");
		}
		else {
			stagingClaimDetailImpl.setServiceThru(serviceThru);
		}

		if (resultCodes == null) {
			stagingClaimDetailImpl.setResultCodes("");
		}
		else {
			stagingClaimDetailImpl.setResultCodes(resultCodes);
		}

		if (procedureCode == null) {
			stagingClaimDetailImpl.setProcedureCode("");
		}
		else {
			stagingClaimDetailImpl.setProcedureCode(procedureCode);
		}

		stagingClaimDetailImpl.setChargedAmount(chargedAmount);
		stagingClaimDetailImpl.setRepricedAmount(repricedAmount);
		stagingClaimDetailImpl.setClaimAmount(claimAmount);

		if (paidDate == null) {
			stagingClaimDetailImpl.setPaidDate("");
		}
		else {
			stagingClaimDetailImpl.setPaidDate(paidDate);
		}

		stagingClaimDetailImpl.setPaidAmount(paidAmount);
		stagingClaimDetailImpl.setSavingsAmount(savingsAmount);
		stagingClaimDetailImpl.setUnits(units);

		if (coverage == null) {
			stagingClaimDetailImpl.setCoverage("");
		}
		else {
			stagingClaimDetailImpl.setCoverage(coverage);
		}

		if (lineStatus == null) {
			stagingClaimDetailImpl.setLineStatus("");
		}
		else {
			stagingClaimDetailImpl.setLineStatus(lineStatus);
		}

		if (revCode == null) {
			stagingClaimDetailImpl.setRevCode("");
		}
		else {
			stagingClaimDetailImpl.setRevCode(revCode);
		}

		if (externalModifiedDate == null) {
			stagingClaimDetailImpl.setExternalModifiedDate("");
		}
		else {
			stagingClaimDetailImpl.setExternalModifiedDate(
				externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingClaimDetailImpl.setExternalCreatedDate("");
		}
		else {
			stagingClaimDetailImpl.setExternalCreatedDate(externalCreatedDate);
		}

		stagingClaimDetailImpl.resetOriginalValues();

		return stagingClaimDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingClaimDetailId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		lineId = objectInput.readLong();

		externalClaimId = objectInput.readLong();
		serviceFrom = objectInput.readUTF();
		serviceThru = objectInput.readUTF();
		resultCodes = objectInput.readUTF();
		procedureCode = objectInput.readUTF();

		chargedAmount = objectInput.readDouble();

		repricedAmount = objectInput.readDouble();

		claimAmount = objectInput.readDouble();
		paidDate = objectInput.readUTF();

		paidAmount = objectInput.readDouble();

		savingsAmount = objectInput.readDouble();

		units = objectInput.readInt();
		coverage = objectInput.readUTF();
		lineStatus = objectInput.readUTF();
		revCode = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingClaimDetailId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(lineId);

		objectOutput.writeLong(externalClaimId);

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

		if (paidDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paidDate);
		}

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

	public long stagingClaimDetailId;
	public long createDate;
	public long modifiedDate;
	public long lineId;
	public long externalClaimId;
	public String serviceFrom;
	public String serviceThru;
	public String resultCodes;
	public String procedureCode;
	public double chargedAmount;
	public double repricedAmount;
	public double claimAmount;
	public String paidDate;
	public double paidAmount;
	public double savingsAmount;
	public int units;
	public String coverage;
	public String lineStatus;
	public String revCode;
	public String externalModifiedDate;
	public String externalCreatedDate;

}