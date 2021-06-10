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

import com.argus.oth.account.management.model.StagingAMAnalyticsDB;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingAMAnalyticsDB in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingAMAnalyticsDBCacheModel
	implements CacheModel<StagingAMAnalyticsDB>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingAMAnalyticsDBCacheModel)) {
			return false;
		}

		StagingAMAnalyticsDBCacheModel stagingAMAnalyticsDBCacheModel =
			(StagingAMAnalyticsDBCacheModel)object;

		if (stagingAMAnalyticsDbId ==
				stagingAMAnalyticsDBCacheModel.stagingAMAnalyticsDbId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingAMAnalyticsDbId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{stagingAMAnalyticsDbId=");
		sb.append(stagingAMAnalyticsDbId);
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
	public StagingAMAnalyticsDB toEntityModel() {
		StagingAMAnalyticsDBImpl stagingAMAnalyticsDBImpl =
			new StagingAMAnalyticsDBImpl();

		stagingAMAnalyticsDBImpl.setStagingAMAnalyticsDbId(
			stagingAMAnalyticsDbId);

		if (createDate == Long.MIN_VALUE) {
			stagingAMAnalyticsDBImpl.setCreateDate(null);
		}
		else {
			stagingAMAnalyticsDBImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingAMAnalyticsDBImpl.setModifiedDate(null);
		}
		else {
			stagingAMAnalyticsDBImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingAMAnalyticsDBImpl.setClientId(clientId);
		stagingAMAnalyticsDBImpl.setSavingsPercent(savingsPercent);
		stagingAMAnalyticsDBImpl.setChargedAmount(chargedAmount);
		stagingAMAnalyticsDBImpl.setRepricedAmount(repricedAmount);
		stagingAMAnalyticsDBImpl.setAvgDownTime(avgDownTime);
		stagingAMAnalyticsDBImpl.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		stagingAMAnalyticsDBImpl.setAbandonmentRate(abandonmentRate);
		stagingAMAnalyticsDBImpl.setClaimsTurnaround(claimsTurnaround);
		stagingAMAnalyticsDBImpl.setDownTimeGoal(downTimeGoal);
		stagingAMAnalyticsDBImpl.setSpeedOfAnswerGoal(speedOfAnswerGoal);
		stagingAMAnalyticsDBImpl.setAbandonmentRateGoal(abandonmentRateGoal);
		stagingAMAnalyticsDBImpl.setClaimsTurnaroundGoal(claimsTurnaroundGoal);

		stagingAMAnalyticsDBImpl.resetOriginalValues();

		return stagingAMAnalyticsDBImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingAMAnalyticsDbId = objectInput.readLong();
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
		objectOutput.writeLong(stagingAMAnalyticsDbId);
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

	public long stagingAMAnalyticsDbId;
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