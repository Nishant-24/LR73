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
public class AMAnalyticsTelephonySoap implements Serializable {

	public static AMAnalyticsTelephonySoap toSoapModel(
		AMAnalyticsTelephony model) {

		AMAnalyticsTelephonySoap soapModel = new AMAnalyticsTelephonySoap();

		soapModel.setAmAnalyticsTelephonyId(model.getAmAnalyticsTelephonyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
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

	public static AMAnalyticsTelephonySoap[] toSoapModels(
		AMAnalyticsTelephony[] models) {

		AMAnalyticsTelephonySoap[] soapModels =
			new AMAnalyticsTelephonySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMAnalyticsTelephonySoap[][] toSoapModels(
		AMAnalyticsTelephony[][] models) {

		AMAnalyticsTelephonySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AMAnalyticsTelephonySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMAnalyticsTelephonySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMAnalyticsTelephonySoap[] toSoapModels(
		List<AMAnalyticsTelephony> models) {

		List<AMAnalyticsTelephonySoap> soapModels =
			new ArrayList<AMAnalyticsTelephonySoap>(models.size());

		for (AMAnalyticsTelephony model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AMAnalyticsTelephonySoap[soapModels.size()]);
	}

	public AMAnalyticsTelephonySoap() {
	}

	public long getPrimaryKey() {
		return _amAnalyticsTelephonyId;
	}

	public void setPrimaryKey(long pk) {
		setAmAnalyticsTelephonyId(pk);
	}

	public long getAmAnalyticsTelephonyId() {
		return _amAnalyticsTelephonyId;
	}

	public void setAmAnalyticsTelephonyId(long amAnalyticsTelephonyId) {
		_amAnalyticsTelephonyId = amAnalyticsTelephonyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public Date getAmAnalyticsTelephonyDate() {
		return _amAnalyticsTelephonyDate;
	}

	public void setAmAnalyticsTelephonyDate(Date amAnalyticsTelephonyDate) {
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

	private long _amAnalyticsTelephonyId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _clientId;
	private Date _amAnalyticsTelephonyDate;
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