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
 * This class is a wrapper for {@link StagingAMAnalyticsDB}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsDB
 * @generated
 */
public class StagingAMAnalyticsDBWrapper
	extends BaseModelWrapper<StagingAMAnalyticsDB>
	implements ModelWrapper<StagingAMAnalyticsDB>, StagingAMAnalyticsDB {

	public StagingAMAnalyticsDBWrapper(
		StagingAMAnalyticsDB stagingAMAnalyticsDB) {

		super(stagingAMAnalyticsDB);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stagingAMAnalyticsDbId", getStagingAMAnalyticsDbId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("clientId", getClientId());
		attributes.put("savingsPercent", getSavingsPercent());
		attributes.put("chargedAmount", getChargedAmount());
		attributes.put("repricedAmount", getRepricedAmount());
		attributes.put("avgDownTime", getAvgDownTime());
		attributes.put("avgSpeedOfAnswer", getAvgSpeedOfAnswer());
		attributes.put("abandonmentRate", getAbandonmentRate());
		attributes.put("claimsTurnaround", getClaimsTurnaround());
		attributes.put("downTimeGoal", getDownTimeGoal());
		attributes.put("speedOfAnswerGoal", getSpeedOfAnswerGoal());
		attributes.put("abandonmentRateGoal", getAbandonmentRateGoal());
		attributes.put("claimsTurnaroundGoal", getClaimsTurnaroundGoal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stagingAMAnalyticsDbId = (Long)attributes.get(
			"stagingAMAnalyticsDbId");

		if (stagingAMAnalyticsDbId != null) {
			setStagingAMAnalyticsDbId(stagingAMAnalyticsDbId);
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

		Double savingsPercent = (Double)attributes.get("savingsPercent");

		if (savingsPercent != null) {
			setSavingsPercent(savingsPercent);
		}

		Double chargedAmount = (Double)attributes.get("chargedAmount");

		if (chargedAmount != null) {
			setChargedAmount(chargedAmount);
		}

		Double repricedAmount = (Double)attributes.get("repricedAmount");

		if (repricedAmount != null) {
			setRepricedAmount(repricedAmount);
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

		Long claimsTurnaround = (Long)attributes.get("claimsTurnaround");

		if (claimsTurnaround != null) {
			setClaimsTurnaround(claimsTurnaround);
		}

		Double downTimeGoal = (Double)attributes.get("downTimeGoal");

		if (downTimeGoal != null) {
			setDownTimeGoal(downTimeGoal);
		}

		Double speedOfAnswerGoal = (Double)attributes.get("speedOfAnswerGoal");

		if (speedOfAnswerGoal != null) {
			setSpeedOfAnswerGoal(speedOfAnswerGoal);
		}

		Double abandonmentRateGoal = (Double)attributes.get(
			"abandonmentRateGoal");

		if (abandonmentRateGoal != null) {
			setAbandonmentRateGoal(abandonmentRateGoal);
		}

		Double claimsTurnaroundGoal = (Double)attributes.get(
			"claimsTurnaroundGoal");

		if (claimsTurnaroundGoal != null) {
			setClaimsTurnaroundGoal(claimsTurnaroundGoal);
		}
	}

	/**
	 * Returns the abandonment rate of this staging am analytics db.
	 *
	 * @return the abandonment rate of this staging am analytics db
	 */
	@Override
	public double getAbandonmentRate() {
		return model.getAbandonmentRate();
	}

	/**
	 * Returns the abandonment rate goal of this staging am analytics db.
	 *
	 * @return the abandonment rate goal of this staging am analytics db
	 */
	@Override
	public double getAbandonmentRateGoal() {
		return model.getAbandonmentRateGoal();
	}

	/**
	 * Returns the avg down time of this staging am analytics db.
	 *
	 * @return the avg down time of this staging am analytics db
	 */
	@Override
	public double getAvgDownTime() {
		return model.getAvgDownTime();
	}

	/**
	 * Returns the avg speed of answer of this staging am analytics db.
	 *
	 * @return the avg speed of answer of this staging am analytics db
	 */
	@Override
	public double getAvgSpeedOfAnswer() {
		return model.getAvgSpeedOfAnswer();
	}

	/**
	 * Returns the charged amount of this staging am analytics db.
	 *
	 * @return the charged amount of this staging am analytics db
	 */
	@Override
	public double getChargedAmount() {
		return model.getChargedAmount();
	}

	/**
	 * Returns the claims turnaround of this staging am analytics db.
	 *
	 * @return the claims turnaround of this staging am analytics db
	 */
	@Override
	public long getClaimsTurnaround() {
		return model.getClaimsTurnaround();
	}

	/**
	 * Returns the claims turnaround goal of this staging am analytics db.
	 *
	 * @return the claims turnaround goal of this staging am analytics db
	 */
	@Override
	public double getClaimsTurnaroundGoal() {
		return model.getClaimsTurnaroundGoal();
	}

	/**
	 * Returns the client ID of this staging am analytics db.
	 *
	 * @return the client ID of this staging am analytics db
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the create date of this staging am analytics db.
	 *
	 * @return the create date of this staging am analytics db
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the down time goal of this staging am analytics db.
	 *
	 * @return the down time goal of this staging am analytics db
	 */
	@Override
	public double getDownTimeGoal() {
		return model.getDownTimeGoal();
	}

	/**
	 * Returns the modified date of this staging am analytics db.
	 *
	 * @return the modified date of this staging am analytics db
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this staging am analytics db.
	 *
	 * @return the primary key of this staging am analytics db
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the repriced amount of this staging am analytics db.
	 *
	 * @return the repriced amount of this staging am analytics db
	 */
	@Override
	public double getRepricedAmount() {
		return model.getRepricedAmount();
	}

	/**
	 * Returns the savings percent of this staging am analytics db.
	 *
	 * @return the savings percent of this staging am analytics db
	 */
	@Override
	public double getSavingsPercent() {
		return model.getSavingsPercent();
	}

	/**
	 * Returns the speed of answer goal of this staging am analytics db.
	 *
	 * @return the speed of answer goal of this staging am analytics db
	 */
	@Override
	public double getSpeedOfAnswerGoal() {
		return model.getSpeedOfAnswerGoal();
	}

	/**
	 * Returns the staging am analytics db ID of this staging am analytics db.
	 *
	 * @return the staging am analytics db ID of this staging am analytics db
	 */
	@Override
	public long getStagingAMAnalyticsDbId() {
		return model.getStagingAMAnalyticsDbId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the abandonment rate of this staging am analytics db.
	 *
	 * @param abandonmentRate the abandonment rate of this staging am analytics db
	 */
	@Override
	public void setAbandonmentRate(double abandonmentRate) {
		model.setAbandonmentRate(abandonmentRate);
	}

	/**
	 * Sets the abandonment rate goal of this staging am analytics db.
	 *
	 * @param abandonmentRateGoal the abandonment rate goal of this staging am analytics db
	 */
	@Override
	public void setAbandonmentRateGoal(double abandonmentRateGoal) {
		model.setAbandonmentRateGoal(abandonmentRateGoal);
	}

	/**
	 * Sets the avg down time of this staging am analytics db.
	 *
	 * @param avgDownTime the avg down time of this staging am analytics db
	 */
	@Override
	public void setAvgDownTime(double avgDownTime) {
		model.setAvgDownTime(avgDownTime);
	}

	/**
	 * Sets the avg speed of answer of this staging am analytics db.
	 *
	 * @param avgSpeedOfAnswer the avg speed of answer of this staging am analytics db
	 */
	@Override
	public void setAvgSpeedOfAnswer(double avgSpeedOfAnswer) {
		model.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
	}

	/**
	 * Sets the charged amount of this staging am analytics db.
	 *
	 * @param chargedAmount the charged amount of this staging am analytics db
	 */
	@Override
	public void setChargedAmount(double chargedAmount) {
		model.setChargedAmount(chargedAmount);
	}

	/**
	 * Sets the claims turnaround of this staging am analytics db.
	 *
	 * @param claimsTurnaround the claims turnaround of this staging am analytics db
	 */
	@Override
	public void setClaimsTurnaround(long claimsTurnaround) {
		model.setClaimsTurnaround(claimsTurnaround);
	}

	/**
	 * Sets the claims turnaround goal of this staging am analytics db.
	 *
	 * @param claimsTurnaroundGoal the claims turnaround goal of this staging am analytics db
	 */
	@Override
	public void setClaimsTurnaroundGoal(double claimsTurnaroundGoal) {
		model.setClaimsTurnaroundGoal(claimsTurnaroundGoal);
	}

	/**
	 * Sets the client ID of this staging am analytics db.
	 *
	 * @param clientId the client ID of this staging am analytics db
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the create date of this staging am analytics db.
	 *
	 * @param createDate the create date of this staging am analytics db
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the down time goal of this staging am analytics db.
	 *
	 * @param downTimeGoal the down time goal of this staging am analytics db
	 */
	@Override
	public void setDownTimeGoal(double downTimeGoal) {
		model.setDownTimeGoal(downTimeGoal);
	}

	/**
	 * Sets the modified date of this staging am analytics db.
	 *
	 * @param modifiedDate the modified date of this staging am analytics db
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this staging am analytics db.
	 *
	 * @param primaryKey the primary key of this staging am analytics db
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the repriced amount of this staging am analytics db.
	 *
	 * @param repricedAmount the repriced amount of this staging am analytics db
	 */
	@Override
	public void setRepricedAmount(double repricedAmount) {
		model.setRepricedAmount(repricedAmount);
	}

	/**
	 * Sets the savings percent of this staging am analytics db.
	 *
	 * @param savingsPercent the savings percent of this staging am analytics db
	 */
	@Override
	public void setSavingsPercent(double savingsPercent) {
		model.setSavingsPercent(savingsPercent);
	}

	/**
	 * Sets the speed of answer goal of this staging am analytics db.
	 *
	 * @param speedOfAnswerGoal the speed of answer goal of this staging am analytics db
	 */
	@Override
	public void setSpeedOfAnswerGoal(double speedOfAnswerGoal) {
		model.setSpeedOfAnswerGoal(speedOfAnswerGoal);
	}

	/**
	 * Sets the staging am analytics db ID of this staging am analytics db.
	 *
	 * @param stagingAMAnalyticsDbId the staging am analytics db ID of this staging am analytics db
	 */
	@Override
	public void setStagingAMAnalyticsDbId(long stagingAMAnalyticsDbId) {
		model.setStagingAMAnalyticsDbId(stagingAMAnalyticsDbId);
	}

	@Override
	protected StagingAMAnalyticsDBWrapper wrap(
		StagingAMAnalyticsDB stagingAMAnalyticsDB) {

		return new StagingAMAnalyticsDBWrapper(stagingAMAnalyticsDB);
	}

}