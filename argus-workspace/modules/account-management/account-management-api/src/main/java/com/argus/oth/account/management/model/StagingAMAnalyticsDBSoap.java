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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingAMAnalyticsDBSoap implements Serializable {

	public static StagingAMAnalyticsDBSoap toSoapModel(
		StagingAMAnalyticsDB model) {

		StagingAMAnalyticsDBSoap soapModel = new StagingAMAnalyticsDBSoap();

		soapModel.setStagingAMAnalyticsDbId(model.getStagingAMAnalyticsDbId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClientId(model.getClientId());
		soapModel.setSavingsPercent(model.getSavingsPercent());
		soapModel.setChargedAmount(model.getChargedAmount());
		soapModel.setRepricedAmount(model.getRepricedAmount());
		soapModel.setAvgDownTime(model.getAvgDownTime());
		soapModel.setAvgSpeedOfAnswer(model.getAvgSpeedOfAnswer());
		soapModel.setAbandonmentRate(model.getAbandonmentRate());
		soapModel.setClaimsTurnaround(model.getClaimsTurnaround());
		soapModel.setDownTimeGoal(model.getDownTimeGoal());
		soapModel.setSpeedOfAnswerGoal(model.getSpeedOfAnswerGoal());
		soapModel.setAbandonmentRateGoal(model.getAbandonmentRateGoal());
		soapModel.setClaimsTurnaroundGoal(model.getClaimsTurnaroundGoal());

		return soapModel;
	}

	public static StagingAMAnalyticsDBSoap[] toSoapModels(
		StagingAMAnalyticsDB[] models) {

		StagingAMAnalyticsDBSoap[] soapModels =
			new StagingAMAnalyticsDBSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingAMAnalyticsDBSoap[][] toSoapModels(
		StagingAMAnalyticsDB[][] models) {

		StagingAMAnalyticsDBSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingAMAnalyticsDBSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingAMAnalyticsDBSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingAMAnalyticsDBSoap[] toSoapModels(
		List<StagingAMAnalyticsDB> models) {

		List<StagingAMAnalyticsDBSoap> soapModels =
			new ArrayList<StagingAMAnalyticsDBSoap>(models.size());

		for (StagingAMAnalyticsDB model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingAMAnalyticsDBSoap[soapModels.size()]);
	}

	public StagingAMAnalyticsDBSoap() {
	}

	public long getPrimaryKey() {
		return _stagingAMAnalyticsDbId;
	}

	public void setPrimaryKey(long pk) {
		setStagingAMAnalyticsDbId(pk);
	}

	public long getStagingAMAnalyticsDbId() {
		return _stagingAMAnalyticsDbId;
	}

	public void setStagingAMAnalyticsDbId(long stagingAMAnalyticsDbId) {
		_stagingAMAnalyticsDbId = stagingAMAnalyticsDbId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public double getSavingsPercent() {
		return _savingsPercent;
	}

	public void setSavingsPercent(double savingsPercent) {
		_savingsPercent = savingsPercent;
	}

	public double getChargedAmount() {
		return _chargedAmount;
	}

	public void setChargedAmount(double chargedAmount) {
		_chargedAmount = chargedAmount;
	}

	public double getRepricedAmount() {
		return _repricedAmount;
	}

	public void setRepricedAmount(double repricedAmount) {
		_repricedAmount = repricedAmount;
	}

	public double getAvgDownTime() {
		return _avgDownTime;
	}

	public void setAvgDownTime(double avgDownTime) {
		_avgDownTime = avgDownTime;
	}

	public double getAvgSpeedOfAnswer() {
		return _avgSpeedOfAnswer;
	}

	public void setAvgSpeedOfAnswer(double avgSpeedOfAnswer) {
		_avgSpeedOfAnswer = avgSpeedOfAnswer;
	}

	public double getAbandonmentRate() {
		return _abandonmentRate;
	}

	public void setAbandonmentRate(double abandonmentRate) {
		_abandonmentRate = abandonmentRate;
	}

	public long getClaimsTurnaround() {
		return _claimsTurnaround;
	}

	public void setClaimsTurnaround(long claimsTurnaround) {
		_claimsTurnaround = claimsTurnaround;
	}

	public double getDownTimeGoal() {
		return _downTimeGoal;
	}

	public void setDownTimeGoal(double downTimeGoal) {
		_downTimeGoal = downTimeGoal;
	}

	public double getSpeedOfAnswerGoal() {
		return _speedOfAnswerGoal;
	}

	public void setSpeedOfAnswerGoal(double speedOfAnswerGoal) {
		_speedOfAnswerGoal = speedOfAnswerGoal;
	}

	public double getAbandonmentRateGoal() {
		return _abandonmentRateGoal;
	}

	public void setAbandonmentRateGoal(double abandonmentRateGoal) {
		_abandonmentRateGoal = abandonmentRateGoal;
	}

	public double getClaimsTurnaroundGoal() {
		return _claimsTurnaroundGoal;
	}

	public void setClaimsTurnaroundGoal(double claimsTurnaroundGoal) {
		_claimsTurnaroundGoal = claimsTurnaroundGoal;
	}

	private long _stagingAMAnalyticsDbId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _clientId;
	private double _savingsPercent;
	private double _chargedAmount;
	private double _repricedAmount;
	private double _avgDownTime;
	private double _avgSpeedOfAnswer;
	private double _abandonmentRate;
	private long _claimsTurnaround;
	private double _downTimeGoal;
	private double _speedOfAnswerGoal;
	private double _abandonmentRateGoal;
	private double _claimsTurnaroundGoal;

}