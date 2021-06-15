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

import com.argus.oth.account.management.model.AMAnalyticsClaim;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMAnalyticsClaim in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMAnalyticsClaimCacheModel
	implements CacheModel<AMAnalyticsClaim>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMAnalyticsClaimCacheModel)) {
			return false;
		}

		AMAnalyticsClaimCacheModel amAnalyticsClaimCacheModel =
			(AMAnalyticsClaimCacheModel)obj;

		if (amAnalyticsClaimId ==
				amAnalyticsClaimCacheModel.amAnalyticsClaimId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amAnalyticsClaimId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{amAnalyticsClaimId=");
		sb.append(amAnalyticsClaimId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
	public AMAnalyticsClaim toEntityModel() {
		AMAnalyticsClaimImpl amAnalyticsClaimImpl = new AMAnalyticsClaimImpl();

		amAnalyticsClaimImpl.setAmAnalyticsClaimId(amAnalyticsClaimId);
		amAnalyticsClaimImpl.setGroupId(groupId);
		amAnalyticsClaimImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			amAnalyticsClaimImpl.setCreateDate(null);
		}
		else {
			amAnalyticsClaimImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amAnalyticsClaimImpl.setModifiedDate(null);
		}
		else {
			amAnalyticsClaimImpl.setModifiedDate(new Date(modifiedDate));
		}

		amAnalyticsClaimImpl.setClientId(clientId);

		if (amAnalyticsClaimDate == Long.MIN_VALUE) {
			amAnalyticsClaimImpl.setAmAnalyticsClaimDate(null);
		}
		else {
			amAnalyticsClaimImpl.setAmAnalyticsClaimDate(
				new Date(amAnalyticsClaimDate));
		}

		amAnalyticsClaimImpl.setAvgClaimTurnAround(avgClaimTurnAround);
		amAnalyticsClaimImpl.setMinClaimTurnAround(minClaimTurnAround);
		amAnalyticsClaimImpl.setMaxClaimTurnAround(maxClaimTurnAround);
		amAnalyticsClaimImpl.setClaimTurnAroundGoal(claimTurnAroundGoal);
		amAnalyticsClaimImpl.setOverallAvgClaimTurnAround(
			overallAvgClaimTurnAround);

		amAnalyticsClaimImpl.resetOriginalValues();

		return amAnalyticsClaimImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amAnalyticsClaimId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		clientId = objectInput.readLong();
		amAnalyticsClaimDate = objectInput.readLong();

		avgClaimTurnAround = objectInput.readInt();

		minClaimTurnAround = objectInput.readInt();

		maxClaimTurnAround = objectInput.readInt();

		claimTurnAroundGoal = objectInput.readInt();

		overallAvgClaimTurnAround = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(amAnalyticsClaimId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(clientId);
		objectOutput.writeLong(amAnalyticsClaimDate);

		objectOutput.writeInt(avgClaimTurnAround);

		objectOutput.writeInt(minClaimTurnAround);

		objectOutput.writeInt(maxClaimTurnAround);

		objectOutput.writeInt(claimTurnAroundGoal);

		objectOutput.writeDouble(overallAvgClaimTurnAround);
	}

	public long amAnalyticsClaimId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long clientId;
	public long amAnalyticsClaimDate;
	public int avgClaimTurnAround;
	public int minClaimTurnAround;
	public int maxClaimTurnAround;
	public int claimTurnAroundGoal;
	public double overallAvgClaimTurnAround;

}