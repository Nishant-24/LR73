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

package com.argus.oth.account.management.model.impl;

import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingAMAnalyticsClaim in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingAMAnalyticsClaimCacheModel
	implements CacheModel<StagingAMAnalyticsClaim>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingAMAnalyticsClaimCacheModel)) {
			return false;
		}

		StagingAMAnalyticsClaimCacheModel stagingAMAnalyticsClaimCacheModel =
			(StagingAMAnalyticsClaimCacheModel)object;

		if (stagingAMAnalyticsClaimId ==
				stagingAMAnalyticsClaimCacheModel.stagingAMAnalyticsClaimId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingAMAnalyticsClaimId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stagingAMAnalyticsClaimId=");
		sb.append(stagingAMAnalyticsClaimId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", amAnalyticsClaimDate=");
		sb.append(amAnalyticsClaimDate);
		sb.append(", avgClaimTurnAround=");
		sb.append(avgClaimTurnAround);
		sb.append(", minClaimTurnAround=");
		sb.append(minClaimTurnAround);
		sb.append(", maxClaimTurnAround=");
		sb.append(maxClaimTurnAround);
		sb.append(", claimTurnAroundGoal=");
		sb.append(claimTurnAroundGoal);
		sb.append(", overallAvgClaimTurnAround=");
		sb.append(overallAvgClaimTurnAround);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingAMAnalyticsClaim toEntityModel() {
		StagingAMAnalyticsClaimImpl stagingAMAnalyticsClaimImpl =
			new StagingAMAnalyticsClaimImpl();

		stagingAMAnalyticsClaimImpl.setStagingAMAnalyticsClaimId(
			stagingAMAnalyticsClaimId);

		if (createDate == Long.MIN_VALUE) {
			stagingAMAnalyticsClaimImpl.setCreateDate(null);
		}
		else {
			stagingAMAnalyticsClaimImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingAMAnalyticsClaimImpl.setModifiedDate(null);
		}
		else {
			stagingAMAnalyticsClaimImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingAMAnalyticsClaimImpl.setClientId(clientId);

		if (amAnalyticsClaimDate == null) {
			stagingAMAnalyticsClaimImpl.setAmAnalyticsClaimDate("");
		}
		else {
			stagingAMAnalyticsClaimImpl.setAmAnalyticsClaimDate(
				amAnalyticsClaimDate);
		}

		stagingAMAnalyticsClaimImpl.setAvgClaimTurnAround(avgClaimTurnAround);
		stagingAMAnalyticsClaimImpl.setMinClaimTurnAround(minClaimTurnAround);
		stagingAMAnalyticsClaimImpl.setMaxClaimTurnAround(maxClaimTurnAround);
		stagingAMAnalyticsClaimImpl.setClaimTurnAroundGoal(claimTurnAroundGoal);
		stagingAMAnalyticsClaimImpl.setOverallAvgClaimTurnAround(
			overallAvgClaimTurnAround);

		stagingAMAnalyticsClaimImpl.resetOriginalValues();

		return stagingAMAnalyticsClaimImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingAMAnalyticsClaimId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		clientId = objectInput.readLong();
		amAnalyticsClaimDate = objectInput.readUTF();

		avgClaimTurnAround = objectInput.readInt();

		minClaimTurnAround = objectInput.readInt();

		maxClaimTurnAround = objectInput.readInt();

		claimTurnAroundGoal = objectInput.readInt();

		overallAvgClaimTurnAround = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingAMAnalyticsClaimId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(clientId);

		if (amAnalyticsClaimDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(amAnalyticsClaimDate);
		}

		objectOutput.writeInt(avgClaimTurnAround);

		objectOutput.writeInt(minClaimTurnAround);

		objectOutput.writeInt(maxClaimTurnAround);

		objectOutput.writeInt(claimTurnAroundGoal);

		objectOutput.writeDouble(overallAvgClaimTurnAround);
	}

	public long stagingAMAnalyticsClaimId;
	public long createDate;
	public long modifiedDate;
	public long clientId;
	public String amAnalyticsClaimDate;
	public int avgClaimTurnAround;
	public int minClaimTurnAround;
	public int maxClaimTurnAround;
	public int claimTurnAroundGoal;
	public double overallAvgClaimTurnAround;

}