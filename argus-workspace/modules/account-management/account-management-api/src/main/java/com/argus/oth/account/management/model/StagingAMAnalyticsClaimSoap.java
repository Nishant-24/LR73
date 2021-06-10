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
public class StagingAMAnalyticsClaimSoap implements Serializable {

	public static StagingAMAnalyticsClaimSoap toSoapModel(
		StagingAMAnalyticsClaim model) {

		StagingAMAnalyticsClaimSoap soapModel =
			new StagingAMAnalyticsClaimSoap();

		soapModel.setStagingAMAnalyticsClaimId(
			model.getStagingAMAnalyticsClaimId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClientId(model.getClientId());
		soapModel.setAmAnalyticsClaimDate(model.getAmAnalyticsClaimDate());
		soapModel.setAvgClaimTurnAround(model.getAvgClaimTurnAround());
		soapModel.setMinClaimTurnAround(model.getMinClaimTurnAround());
		soapModel.setMaxClaimTurnAround(model.getMaxClaimTurnAround());
		soapModel.setClaimTurnAroundGoal(model.getClaimTurnAroundGoal());
		soapModel.setOverallAvgClaimTurnAround(
			model.getOverallAvgClaimTurnAround());

		return soapModel;
	}

	public static StagingAMAnalyticsClaimSoap[] toSoapModels(
		StagingAMAnalyticsClaim[] models) {

		StagingAMAnalyticsClaimSoap[] soapModels =
			new StagingAMAnalyticsClaimSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingAMAnalyticsClaimSoap[][] toSoapModels(
		StagingAMAnalyticsClaim[][] models) {

		StagingAMAnalyticsClaimSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StagingAMAnalyticsClaimSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new StagingAMAnalyticsClaimSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingAMAnalyticsClaimSoap[] toSoapModels(
		List<StagingAMAnalyticsClaim> models) {

		List<StagingAMAnalyticsClaimSoap> soapModels =
			new ArrayList<StagingAMAnalyticsClaimSoap>(models.size());

		for (StagingAMAnalyticsClaim model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StagingAMAnalyticsClaimSoap[soapModels.size()]);
	}

	public StagingAMAnalyticsClaimSoap() {
	}

	public long getPrimaryKey() {
		return _stagingAMAnalyticsClaimId;
	}

	public void setPrimaryKey(long pk) {
		setStagingAMAnalyticsClaimId(pk);
	}

	public long getStagingAMAnalyticsClaimId() {
		return _stagingAMAnalyticsClaimId;
	}

	public void setStagingAMAnalyticsClaimId(long stagingAMAnalyticsClaimId) {
		_stagingAMAnalyticsClaimId = stagingAMAnalyticsClaimId;
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

	public String getAmAnalyticsClaimDate() {
		return _amAnalyticsClaimDate;
	}

	public void setAmAnalyticsClaimDate(String amAnalyticsClaimDate) {
		_amAnalyticsClaimDate = amAnalyticsClaimDate;
	}

	public int getAvgClaimTurnAround() {
		return _avgClaimTurnAround;
	}

	public void setAvgClaimTurnAround(int avgClaimTurnAround) {
		_avgClaimTurnAround = avgClaimTurnAround;
	}

	public int getMinClaimTurnAround() {
		return _minClaimTurnAround;
	}

	public void setMinClaimTurnAround(int minClaimTurnAround) {
		_minClaimTurnAround = minClaimTurnAround;
	}

	public int getMaxClaimTurnAround() {
		return _maxClaimTurnAround;
	}

	public void setMaxClaimTurnAround(int maxClaimTurnAround) {
		_maxClaimTurnAround = maxClaimTurnAround;
	}

	public int getClaimTurnAroundGoal() {
		return _claimTurnAroundGoal;
	}

	public void setClaimTurnAroundGoal(int claimTurnAroundGoal) {
		_claimTurnAroundGoal = claimTurnAroundGoal;
	}

	public double getOverallAvgClaimTurnAround() {
		return _overallAvgClaimTurnAround;
	}

	public void setOverallAvgClaimTurnAround(double overallAvgClaimTurnAround) {
		_overallAvgClaimTurnAround = overallAvgClaimTurnAround;
	}

	private long _stagingAMAnalyticsClaimId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _clientId;
	private String _amAnalyticsClaimDate;
	private int _avgClaimTurnAround;
	private int _minClaimTurnAround;
	private int _maxClaimTurnAround;
	private int _claimTurnAroundGoal;
	private double _overallAvgClaimTurnAround;

}