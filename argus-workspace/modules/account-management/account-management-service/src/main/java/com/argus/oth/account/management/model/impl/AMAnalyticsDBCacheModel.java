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

import com.argus.oth.account.management.model.AMAnalyticsDB;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMAnalyticsDB in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMAnalyticsDBCacheModel
	implements CacheModel<AMAnalyticsDB>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AMAnalyticsDBCacheModel)) {
			return false;
		}

		AMAnalyticsDBCacheModel amAnalyticsDBCacheModel =
			(AMAnalyticsDBCacheModel)object;

		if (amAnalyticsDbId == amAnalyticsDBCacheModel.amAnalyticsDbId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amAnalyticsDbId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{amAnalyticsDbId=");
		sb.append(amAnalyticsDbId);
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
		sb.append(", savingsPercent=");
		sb.append(savingsPercent);
		sb.append(", chargedAmount=");
		sb.append(chargedAmount);
		sb.append(", repricedAmount=");
		sb.append(repricedAmount);
		sb.append(", avgDownTime=");
		sb.append(avgDownTime);
		sb.append(", avgSpeedOfAnswer=");
		sb.append(avgSpeedOfAnswer);
		sb.append(", abandonmentRate=");
		sb.append(abandonmentRate);
		sb.append(", claimsTurnaround=");
		sb.append(claimsTurnaround);
		sb.append(", downTimeGoal=");
		sb.append(downTimeGoal);
		sb.append(", speedOfAnswerGoal=");
		sb.append(speedOfAnswerGoal);
		sb.append(", abandonmentRateGoal=");
		sb.append(abandonmentRateGoal);
		sb.append(", claimsTurnaroundGoal=");
		sb.append(claimsTurnaroundGoal);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMAnalyticsDB toEntityModel() {
		AMAnalyticsDBImpl amAnalyticsDBImpl = new AMAnalyticsDBImpl();

		amAnalyticsDBImpl.setAmAnalyticsDbId(amAnalyticsDbId);
		amAnalyticsDBImpl.setGroupId(groupId);
		amAnalyticsDBImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			amAnalyticsDBImpl.setCreateDate(null);
		}
		else {
			amAnalyticsDBImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amAnalyticsDBImpl.setModifiedDate(null);
		}
		else {
			amAnalyticsDBImpl.setModifiedDate(new Date(modifiedDate));
		}

		amAnalyticsDBImpl.setClientId(clientId);
		amAnalyticsDBImpl.setSavingsPercent(savingsPercent);
		amAnalyticsDBImpl.setChargedAmount(chargedAmount);
		amAnalyticsDBImpl.setRepricedAmount(repricedAmount);
		amAnalyticsDBImpl.setAvgDownTime(avgDownTime);
		amAnalyticsDBImpl.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		amAnalyticsDBImpl.setAbandonmentRate(abandonmentRate);
		amAnalyticsDBImpl.setClaimsTurnaround(claimsTurnaround);
		amAnalyticsDBImpl.setDownTimeGoal(downTimeGoal);
		amAnalyticsDBImpl.setSpeedOfAnswerGoal(speedOfAnswerGoal);
		amAnalyticsDBImpl.setAbandonmentRateGoal(abandonmentRateGoal);
		amAnalyticsDBImpl.setClaimsTurnaroundGoal(claimsTurnaroundGoal);

		amAnalyticsDBImpl.resetOriginalValues();

		return amAnalyticsDBImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amAnalyticsDbId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		clientId = objectInput.readLong();

		savingsPercent = objectInput.readDouble();

		chargedAmount = objectInput.readDouble();

		repricedAmount = objectInput.readDouble();

		avgDownTime = objectInput.readDouble();

		avgSpeedOfAnswer = objectInput.readDouble();

		abandonmentRate = objectInput.readDouble();

		claimsTurnaround = objectInput.readLong();

		downTimeGoal = objectInput.readDouble();

		speedOfAnswerGoal = objectInput.readDouble();

		abandonmentRateGoal = objectInput.readDouble();

		claimsTurnaroundGoal = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(amAnalyticsDbId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(clientId);

		objectOutput.writeDouble(savingsPercent);

		objectOutput.writeDouble(chargedAmount);

		objectOutput.writeDouble(repricedAmount);

		objectOutput.writeDouble(avgDownTime);

		objectOutput.writeDouble(avgSpeedOfAnswer);

		objectOutput.writeDouble(abandonmentRate);

		objectOutput.writeLong(claimsTurnaround);

		objectOutput.writeDouble(downTimeGoal);

		objectOutput.writeDouble(speedOfAnswerGoal);

		objectOutput.writeDouble(abandonmentRateGoal);

		objectOutput.writeDouble(claimsTurnaroundGoal);
	}

	public long amAnalyticsDbId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long clientId;
	public double savingsPercent;
	public double chargedAmount;
	public double repricedAmount;
	public double avgDownTime;
	public double avgSpeedOfAnswer;
	public double abandonmentRate;
	public long claimsTurnaround;
	public double downTimeGoal;
	public double speedOfAnswerGoal;
	public double abandonmentRateGoal;
	public double claimsTurnaroundGoal;

}