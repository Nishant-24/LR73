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

import com.argus.oth.account.management.model.StagingAMATelephony;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingAMATelephony in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingAMATelephonyCacheModel
	implements CacheModel<StagingAMATelephony>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingAMATelephonyCacheModel)) {
			return false;
		}

		StagingAMATelephonyCacheModel stagingAMATelephonyCacheModel =
			(StagingAMATelephonyCacheModel)object;

		if (stagingAMATelephonyId ==
				stagingAMATelephonyCacheModel.stagingAMATelephonyId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingAMATelephonyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{stagingAMATelephonyId=");
		sb.append(stagingAMATelephonyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", amAnalyticsTelephonyDate=");
		sb.append(amAnalyticsTelephonyDate);
		sb.append(", avgDownTime=");
		sb.append(avgDownTime);
		sb.append(", avgSpeedOfAnswer=");
		sb.append(avgSpeedOfAnswer);
		sb.append(", abandonmentRate=");
		sb.append(abandonmentRate);
		sb.append(", downTimeGoal=");
		sb.append(downTimeGoal);
		sb.append(", speedAnswerGoal=");
		sb.append(speedAnswerGoal);
		sb.append(", abandonmentRateGoal=");
		sb.append(abandonmentRateGoal);
		sb.append(", overallAvgDownTime=");
		sb.append(overallAvgDownTime);
		sb.append(", overallAvgSpeedOfAnswer=");
		sb.append(overallAvgSpeedOfAnswer);
		sb.append(", overallAvgAbandonmentRate=");
		sb.append(overallAvgAbandonmentRate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingAMATelephony toEntityModel() {
		StagingAMATelephonyImpl stagingAMATelephonyImpl =
			new StagingAMATelephonyImpl();

		stagingAMATelephonyImpl.setStagingAMATelephonyId(stagingAMATelephonyId);

		if (createDate == Long.MIN_VALUE) {
			stagingAMATelephonyImpl.setCreateDate(null);
		}
		else {
			stagingAMATelephonyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingAMATelephonyImpl.setModifiedDate(null);
		}
		else {
			stagingAMATelephonyImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingAMATelephonyImpl.setClientId(clientId);

		if (amAnalyticsTelephonyDate == null) {
			stagingAMATelephonyImpl.setAmAnalyticsTelephonyDate("");
		}
		else {
			stagingAMATelephonyImpl.setAmAnalyticsTelephonyDate(
				amAnalyticsTelephonyDate);
		}

		stagingAMATelephonyImpl.setAvgDownTime(avgDownTime);
		stagingAMATelephonyImpl.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		stagingAMATelephonyImpl.setAbandonmentRate(abandonmentRate);
		stagingAMATelephonyImpl.setDownTimeGoal(downTimeGoal);
		stagingAMATelephonyImpl.setSpeedAnswerGoal(speedAnswerGoal);
		stagingAMATelephonyImpl.setAbandonmentRateGoal(abandonmentRateGoal);
		stagingAMATelephonyImpl.setOverallAvgDownTime(overallAvgDownTime);
		stagingAMATelephonyImpl.setOverallAvgSpeedOfAnswer(
			overallAvgSpeedOfAnswer);
		stagingAMATelephonyImpl.setOverallAvgAbandonmentRate(
			overallAvgAbandonmentRate);

		stagingAMATelephonyImpl.resetOriginalValues();

		return stagingAMATelephonyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingAMATelephonyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		clientId = objectInput.readLong();
		amAnalyticsTelephonyDate = objectInput.readUTF();

		avgDownTime = objectInput.readDouble();

		avgSpeedOfAnswer = objectInput.readDouble();

		abandonmentRate = objectInput.readDouble();

		downTimeGoal = objectInput.readDouble();

		speedAnswerGoal = objectInput.readDouble();

		abandonmentRateGoal = objectInput.readDouble();

		overallAvgDownTime = objectInput.readDouble();

		overallAvgSpeedOfAnswer = objectInput.readDouble();

		overallAvgAbandonmentRate = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingAMATelephonyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(clientId);

		if (amAnalyticsTelephonyDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(amAnalyticsTelephonyDate);
		}

		objectOutput.writeDouble(avgDownTime);

		objectOutput.writeDouble(avgSpeedOfAnswer);

		objectOutput.writeDouble(abandonmentRate);

		objectOutput.writeDouble(downTimeGoal);

		objectOutput.writeDouble(speedAnswerGoal);

		objectOutput.writeDouble(abandonmentRateGoal);

		objectOutput.writeDouble(overallAvgDownTime);

		objectOutput.writeDouble(overallAvgSpeedOfAnswer);

		objectOutput.writeDouble(overallAvgAbandonmentRate);
	}

	public long stagingAMATelephonyId;
	public long createDate;
	public long modifiedDate;
	public long clientId;
	public String amAnalyticsTelephonyDate;
	public double avgDownTime;
	public double avgSpeedOfAnswer;
	public double abandonmentRate;
	public double downTimeGoal;
	public double speedAnswerGoal;
	public double abandonmentRateGoal;
	public double overallAvgDownTime;
	public double overallAvgSpeedOfAnswer;
	public double overallAvgAbandonmentRate;

}