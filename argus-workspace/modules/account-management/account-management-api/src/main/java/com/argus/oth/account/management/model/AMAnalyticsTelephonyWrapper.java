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

package com.argus.oth.account.management.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AMAnalyticsTelephony}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsTelephony
 * @generated
 */
public class AMAnalyticsTelephonyWrapper
	extends BaseModelWrapper<AMAnalyticsTelephony>
	implements AMAnalyticsTelephony, ModelWrapper<AMAnalyticsTelephony> {

	public AMAnalyticsTelephonyWrapper(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		super(amAnalyticsTelephony);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("amAnalyticsTelephonyId", getAmAnalyticsTelephonyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("clientId", getClientId());
		attributes.put(
			"amAnalyticsTelephonyDate", getAmAnalyticsTelephonyDate());
		attributes.put("avgDownTime", getAvgDownTime());
		attributes.put("avgSpeedOfAnswer", getAvgSpeedOfAnswer());
		attributes.put("abandonmentRate", getAbandonmentRate());
		attributes.put("downTimeGoal", getDownTimeGoal());
		attributes.put("speedAnswerGoal", getSpeedAnswerGoal());
		attributes.put("abandonmentRateGoal", getAbandonmentRateGoal());
		attributes.put("overallAvgDownTime", getOverallAvgDownTime());
		attributes.put("overallAvgSpeedOfAnswer", getOverallAvgSpeedOfAnswer());
		attributes.put(
			"overallAvgAbandonmentRate", getOverallAvgAbandonmentRate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long amAnalyticsTelephonyId = (Long)attributes.get(
			"amAnalyticsTelephonyId");

		if (amAnalyticsTelephonyId != null) {
			setAmAnalyticsTelephonyId(amAnalyticsTelephonyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Date amAnalyticsTelephonyDate = (Date)attributes.get(
			"amAnalyticsTelephonyDate");

		if (amAnalyticsTelephonyDate != null) {
			setAmAnalyticsTelephonyDate(amAnalyticsTelephonyDate);
		}

		Double avgDownTime = (Double)attributes.get("avgDownTime");

		if (avgDownTime != null) {
			setAvgDownTime(avgDownTime);
		}

		Double avgSpeedOfAnswer = (Double)attributes.get("avgSpeedOfAnswer");

		if (avgSpeedOfAnswer != null) {
			setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		}

		Double abandonmentRate = (Double)attributes.get("abandonmentRate");

		if (abandonmentRate != null) {
			setAbandonmentRate(abandonmentRate);
		}

		Double downTimeGoal = (Double)attributes.get("downTimeGoal");

		if (downTimeGoal != null) {
			setDownTimeGoal(downTimeGoal);
		}

		Double speedAnswerGoal = (Double)attributes.get("speedAnswerGoal");

		if (speedAnswerGoal != null) {
			setSpeedAnswerGoal(speedAnswerGoal);
		}

		Double abandonmentRateGoal = (Double)attributes.get(
			"abandonmentRateGoal");

		if (abandonmentRateGoal != null) {
			setAbandonmentRateGoal(abandonmentRateGoal);
		}

		Double overallAvgDownTime = (Double)attributes.get(
			"overallAvgDownTime");

		if (overallAvgDownTime != null) {
			setOverallAvgDownTime(overallAvgDownTime);
		}

		Double overallAvgSpeedOfAnswer = (Double)attributes.get(
			"overallAvgSpeedOfAnswer");

		if (overallAvgSpeedOfAnswer != null) {
			setOverallAvgSpeedOfAnswer(overallAvgSpeedOfAnswer);
		}

		Double overallAvgAbandonmentRate = (Double)attributes.get(
			"overallAvgAbandonmentRate");

		if (overallAvgAbandonmentRate != null) {
			setOverallAvgAbandonmentRate(overallAvgAbandonmentRate);
		}
	}

	/**
	 * Returns the abandonment rate of this am analytics telephony.
	 *
	 * @return the abandonment rate of this am analytics telephony
	 */
	@Override
	public double getAbandonmentRate() {
		return model.getAbandonmentRate();
	}

	/**
	 * Returns the abandonment rate goal of this am analytics telephony.
	 *
	 * @return the abandonment rate goal of this am analytics telephony
	 */
	@Override
	public double getAbandonmentRateGoal() {
		return model.getAbandonmentRateGoal();
	}

	/**
	 * Returns the am analytics telephony date of this am analytics telephony.
	 *
	 * @return the am analytics telephony date of this am analytics telephony
	 */
	@Override
	public Date getAmAnalyticsTelephonyDate() {
		return model.getAmAnalyticsTelephonyDate();
	}

	/**
	 * Returns the am analytics telephony ID of this am analytics telephony.
	 *
	 * @return the am analytics telephony ID of this am analytics telephony
	 */
	@Override
	public long getAmAnalyticsTelephonyId() {
		return model.getAmAnalyticsTelephonyId();
	}

	/**
	 * Returns the avg down time of this am analytics telephony.
	 *
	 * @return the avg down time of this am analytics telephony
	 */
	@Override
	public double getAvgDownTime() {
		return model.getAvgDownTime();
	}

	/**
	 * Returns the avg speed of answer of this am analytics telephony.
	 *
	 * @return the avg speed of answer of this am analytics telephony
	 */
	@Override
	public double getAvgSpeedOfAnswer() {
		return model.getAvgSpeedOfAnswer();
	}

	/**
	 * Returns the client ID of this am analytics telephony.
	 *
	 * @return the client ID of this am analytics telephony
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the company ID of this am analytics telephony.
	 *
	 * @return the company ID of this am analytics telephony
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this am analytics telephony.
	 *
	 * @return the create date of this am analytics telephony
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the down time goal of this am analytics telephony.
	 *
	 * @return the down time goal of this am analytics telephony
	 */
	@Override
	public double getDownTimeGoal() {
		return model.getDownTimeGoal();
	}

	/**
	 * Returns the group ID of this am analytics telephony.
	 *
	 * @return the group ID of this am analytics telephony
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this am analytics telephony.
	 *
	 * @return the modified date of this am analytics telephony
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the overall avg abandonment rate of this am analytics telephony.
	 *
	 * @return the overall avg abandonment rate of this am analytics telephony
	 */
	@Override
	public double getOverallAvgAbandonmentRate() {
		return model.getOverallAvgAbandonmentRate();
	}

	/**
	 * Returns the overall avg down time of this am analytics telephony.
	 *
	 * @return the overall avg down time of this am analytics telephony
	 */
	@Override
	public double getOverallAvgDownTime() {
		return model.getOverallAvgDownTime();
	}

	/**
	 * Returns the overall avg speed of answer of this am analytics telephony.
	 *
	 * @return the overall avg speed of answer of this am analytics telephony
	 */
	@Override
	public double getOverallAvgSpeedOfAnswer() {
		return model.getOverallAvgSpeedOfAnswer();
	}

	/**
	 * Returns the primary key of this am analytics telephony.
	 *
	 * @return the primary key of this am analytics telephony
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the speed answer goal of this am analytics telephony.
	 *
	 * @return the speed answer goal of this am analytics telephony
	 */
	@Override
	public double getSpeedAnswerGoal() {
		return model.getSpeedAnswerGoal();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the abandonment rate of this am analytics telephony.
	 *
	 * @param abandonmentRate the abandonment rate of this am analytics telephony
	 */
	@Override
	public void setAbandonmentRate(double abandonmentRate) {
		model.setAbandonmentRate(abandonmentRate);
	}

	/**
	 * Sets the abandonment rate goal of this am analytics telephony.
	 *
	 * @param abandonmentRateGoal the abandonment rate goal of this am analytics telephony
	 */
	@Override
	public void setAbandonmentRateGoal(double abandonmentRateGoal) {
		model.setAbandonmentRateGoal(abandonmentRateGoal);
	}

	/**
	 * Sets the am analytics telephony date of this am analytics telephony.
	 *
	 * @param amAnalyticsTelephonyDate the am analytics telephony date of this am analytics telephony
	 */
	@Override
	public void setAmAnalyticsTelephonyDate(Date amAnalyticsTelephonyDate) {
		model.setAmAnalyticsTelephonyDate(amAnalyticsTelephonyDate);
	}

	/**
	 * Sets the am analytics telephony ID of this am analytics telephony.
	 *
	 * @param amAnalyticsTelephonyId the am analytics telephony ID of this am analytics telephony
	 */
	@Override
	public void setAmAnalyticsTelephonyId(long amAnalyticsTelephonyId) {
		model.setAmAnalyticsTelephonyId(amAnalyticsTelephonyId);
	}

	/**
	 * Sets the avg down time of this am analytics telephony.
	 *
	 * @param avgDownTime the avg down time of this am analytics telephony
	 */
	@Override
	public void setAvgDownTime(double avgDownTime) {
		model.setAvgDownTime(avgDownTime);
	}

	/**
	 * Sets the avg speed of answer of this am analytics telephony.
	 *
	 * @param avgSpeedOfAnswer the avg speed of answer of this am analytics telephony
	 */
	@Override
	public void setAvgSpeedOfAnswer(double avgSpeedOfAnswer) {
		model.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
	}

	/**
	 * Sets the client ID of this am analytics telephony.
	 *
	 * @param clientId the client ID of this am analytics telephony
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the company ID of this am analytics telephony.
	 *
	 * @param companyId the company ID of this am analytics telephony
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this am analytics telephony.
	 *
	 * @param createDate the create date of this am analytics telephony
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the down time goal of this am analytics telephony.
	 *
	 * @param downTimeGoal the down time goal of this am analytics telephony
	 */
	@Override
	public void setDownTimeGoal(double downTimeGoal) {
		model.setDownTimeGoal(downTimeGoal);
	}

	/**
	 * Sets the group ID of this am analytics telephony.
	 *
	 * @param groupId the group ID of this am analytics telephony
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this am analytics telephony.
	 *
	 * @param modifiedDate the modified date of this am analytics telephony
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the overall avg abandonment rate of this am analytics telephony.
	 *
	 * @param overallAvgAbandonmentRate the overall avg abandonment rate of this am analytics telephony
	 */
	@Override
	public void setOverallAvgAbandonmentRate(double overallAvgAbandonmentRate) {
		model.setOverallAvgAbandonmentRate(overallAvgAbandonmentRate);
	}

	/**
	 * Sets the overall avg down time of this am analytics telephony.
	 *
	 * @param overallAvgDownTime the overall avg down time of this am analytics telephony
	 */
	@Override
	public void setOverallAvgDownTime(double overallAvgDownTime) {
		model.setOverallAvgDownTime(overallAvgDownTime);
	}

	/**
	 * Sets the overall avg speed of answer of this am analytics telephony.
	 *
	 * @param overallAvgSpeedOfAnswer the overall avg speed of answer of this am analytics telephony
	 */
	@Override
	public void setOverallAvgSpeedOfAnswer(double overallAvgSpeedOfAnswer) {
		model.setOverallAvgSpeedOfAnswer(overallAvgSpeedOfAnswer);
	}

	/**
	 * Sets the primary key of this am analytics telephony.
	 *
	 * @param primaryKey the primary key of this am analytics telephony
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the speed answer goal of this am analytics telephony.
	 *
	 * @param speedAnswerGoal the speed answer goal of this am analytics telephony
	 */
	@Override
	public void setSpeedAnswerGoal(double speedAnswerGoal) {
		model.setSpeedAnswerGoal(speedAnswerGoal);
	}

	@Override
	protected AMAnalyticsTelephonyWrapper wrap(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		return new AMAnalyticsTelephonyWrapper(amAnalyticsTelephony);
	}

}