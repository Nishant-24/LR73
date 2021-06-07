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

import com.argus.oth.account.management.model.AMAnalyticsTelephony;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMAnalyticsTelephony in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMAnalyticsTelephonyCacheModel
	implements CacheModel<AMAnalyticsTelephony>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMAnalyticsTelephonyCacheModel)) {
			return false;
		}

		AMAnalyticsTelephonyCacheModel amAnalyticsTelephonyCacheModel =
			(AMAnalyticsTelephonyCacheModel)obj;

		if (amAnalyticsTelephonyId ==
				amAnalyticsTelephonyCacheModel.amAnalyticsTelephonyId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amAnalyticsTelephonyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{amAnalyticsTelephonyId=");
		sb.append(amAnalyticsTelephonyId);
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
	public AMAnalyticsTelephony toEntityModel() {
		AMAnalyticsTelephonyImpl amAnalyticsTelephonyImpl =
			new AMAnalyticsTelephonyImpl();

		amAnalyticsTelephonyImpl.setAmAnalyticsTelephonyId(
			amAnalyticsTelephonyId);
		amAnalyticsTelephonyImpl.setGroupId(groupId);
		amAnalyticsTelephonyImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			amAnalyticsTelephonyImpl.setCreateDate(null);
		}
		else {
			amAnalyticsTelephonyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amAnalyticsTelephonyImpl.setModifiedDate(null);
		}
		else {
			amAnalyticsTelephonyImpl.setModifiedDate(new Date(modifiedDate));
		}

		amAnalyticsTelephonyImpl.setClientId(clientId);

		if (amAnalyticsTelephonyDate == Long.MIN_VALUE) {
			amAnalyticsTelephonyImpl.setAmAnalyticsTelephonyDate(null);
		}
		else {
			amAnalyticsTelephonyImpl.setAmAnalyticsTelephonyDate(
				new Date(amAnalyticsTelephonyDate));
		}

		amAnalyticsTelephonyImpl.setAvgDownTime(avgDownTime);
		amAnalyticsTelephonyImpl.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		amAnalyticsTelephonyImpl.setAbandonmentRate(abandonmentRate);
		amAnalyticsTelephonyImpl.setDownTimeGoal(downTimeGoal);
		amAnalyticsTelephonyImpl.setSpeedAnswerGoal(speedAnswerGoal);
		amAnalyticsTelephonyImpl.setAbandonmentRateGoal(abandonmentRateGoal);
		amAnalyticsTelephonyImpl.setOverallAvgDownTime(overallAvgDownTime);
		amAnalyticsTelephonyImpl.setOverallAvgSpeedOfAnswer(
			overallAvgSpeedOfAnswer);
		amAnalyticsTelephonyImpl.setOverallAvgAbandonmentRate(
			overallAvgAbandonmentRate);

		amAnalyticsTelephonyImpl.resetOriginalValues();

		return amAnalyticsTelephonyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amAnalyticsTelephonyId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		clientId = objectInput.readLong();
		amAnalyticsTelephonyDate = objectInput.readLong();

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
		objectOutput.writeLong(amAnalyticsTelephonyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(clientId);
		objectOutput.writeLong(amAnalyticsTelephonyDate);

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

	public long amAnalyticsTelephonyId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long clientId;
	public long amAnalyticsTelephonyDate;
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