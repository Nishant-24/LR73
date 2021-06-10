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
public class StagingAMATelephonySoap implements Serializable {

	public static StagingAMATelephonySoap toSoapModel(
		StagingAMATelephony model) {

		StagingAMATelephonySoap soapModel = new StagingAMATelephonySoap();

		soapModel.setStagingAMATelephonyId(model.getStagingAMATelephonyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClientId(model.getClientId());
		soapModel.setAmAnalyticsTelephonyDate(
			model.getAmAnalyticsTelephonyDate());
		soapModel.setAvgDownTime(model.getAvgDownTime());
		soapModel.setAvgSpeedOfAnswer(model.getAvgSpeedOfAnswer());
		soapModel.setAbandonmentRate(model.getAbandonmentRate());
		soapModel.setDownTimeGoal(model.getDownTimeGoal());
		soapModel.setSpeedAnswerGoal(model.getSpeedAnswerGoal());
		soapModel.setAbandonmentRateGoal(model.getAbandonmentRateGoal());
		soapModel.setOverallAvgDownTime(model.getOverallAvgDownTime());
		soapModel.setOverallAvgSpeedOfAnswer(
			model.getOverallAvgSpeedOfAnswer());
		soapModel.setOverallAvgAbandonmentRate(
			model.getOverallAvgAbandonmentRate());

		return soapModel;
	}

	public static StagingAMATelephonySoap[] toSoapModels(
		StagingAMATelephony[] models) {

		StagingAMATelephonySoap[] soapModels =
			new StagingAMATelephonySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingAMATelephonySoap[][] toSoapModels(
		StagingAMATelephony[][] models) {

		StagingAMATelephonySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingAMATelephonySoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingAMATelephonySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingAMATelephonySoap[] toSoapModels(
		List<StagingAMATelephony> models) {

		List<StagingAMATelephonySoap> soapModels =
			new ArrayList<StagingAMATelephonySoap>(models.size());

		for (StagingAMATelephony model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingAMATelephonySoap[soapModels.size()]);
	}

	public StagingAMATelephonySoap() {
	}

	public long getPrimaryKey() {
		return _stagingAMATelephonyId;
	}

	public void setPrimaryKey(long pk) {
		setStagingAMATelephonyId(pk);
	}

	public long getStagingAMATelephonyId() {
		return _stagingAMATelephonyId;
	}

	public void setStagingAMATelephonyId(long stagingAMATelephonyId) {
		_stagingAMATelephonyId = stagingAMATelephonyId;
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

	public String getAmAnalyticsTelephonyDate() {
		return _amAnalyticsTelephonyDate;
	}

	public void setAmAnalyticsTelephonyDate(String amAnalyticsTelephonyDate) {
		_amAnalyticsTelephonyDate = amAnalyticsTelephonyDate;
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

	public double getDownTimeGoal() {
		return _downTimeGoal;
	}

	public void setDownTimeGoal(double downTimeGoal) {
		_downTimeGoal = downTimeGoal;
	}

	public double getSpeedAnswerGoal() {
		return _speedAnswerGoal;
	}

	public void setSpeedAnswerGoal(double speedAnswerGoal) {
		_speedAnswerGoal = speedAnswerGoal;
	}

	public double getAbandonmentRateGoal() {
		return _abandonmentRateGoal;
	}

	public void setAbandonmentRateGoal(double abandonmentRateGoal) {
		_abandonmentRateGoal = abandonmentRateGoal;
	}

	public double getOverallAvgDownTime() {
		return _overallAvgDownTime;
	}

	public void setOverallAvgDownTime(double overallAvgDownTime) {
		_overallAvgDownTime = overallAvgDownTime;
	}

	public double getOverallAvgSpeedOfAnswer() {
		return _overallAvgSpeedOfAnswer;
	}

	public void setOverallAvgSpeedOfAnswer(double overallAvgSpeedOfAnswer) {
		_overallAvgSpeedOfAnswer = overallAvgSpeedOfAnswer;
	}

	public double getOverallAvgAbandonmentRate() {
		return _overallAvgAbandonmentRate;
	}

	public void setOverallAvgAbandonmentRate(double overallAvgAbandonmentRate) {
		_overallAvgAbandonmentRate = overallAvgAbandonmentRate;
	}

	private long _stagingAMATelephonyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _clientId;
	private String _amAnalyticsTelephonyDate;
	private double _avgDownTime;
	private double _avgSpeedOfAnswer;
	private double _abandonmentRate;
	private double _downTimeGoal;
	private double _speedAnswerGoal;
	private double _abandonmentRateGoal;
	private double _overallAvgDownTime;
	private double _overallAvgSpeedOfAnswer;
	private double _overallAvgAbandonmentRate;

}