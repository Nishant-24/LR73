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
public class AMAnalyticsClaimSoap implements Serializable {

	public static AMAnalyticsClaimSoap toSoapModel(AMAnalyticsClaim model) {
		AMAnalyticsClaimSoap soapModel = new AMAnalyticsClaimSoap();

		soapModel.setAmAnalyticsClaimId(model.getAmAnalyticsClaimId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
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

	public static AMAnalyticsClaimSoap[] toSoapModels(
		AMAnalyticsClaim[] models) {

		AMAnalyticsClaimSoap[] soapModels =
			new AMAnalyticsClaimSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMAnalyticsClaimSoap[][] toSoapModels(
		AMAnalyticsClaim[][] models) {

		AMAnalyticsClaimSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AMAnalyticsClaimSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMAnalyticsClaimSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMAnalyticsClaimSoap[] toSoapModels(
		List<AMAnalyticsClaim> models) {

		List<AMAnalyticsClaimSoap> soapModels =
			new ArrayList<AMAnalyticsClaimSoap>(models.size());

		for (AMAnalyticsClaim model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMAnalyticsClaimSoap[soapModels.size()]);
	}

	public AMAnalyticsClaimSoap() {
	}

	public long getPrimaryKey() {
		return _amAnalyticsClaimId;
	}

	public void setPrimaryKey(long pk) {
		setAmAnalyticsClaimId(pk);
	}

	public long getAmAnalyticsClaimId() {
		return _amAnalyticsClaimId;
	}

	public void setAmAnalyticsClaimId(long amAnalyticsClaimId) {
		_amAnalyticsClaimId = amAnalyticsClaimId;
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

	public Date getAmAnalyticsClaimDate() {
		return _amAnalyticsClaimDate;
	}

	public void setAmAnalyticsClaimDate(Date amAnalyticsClaimDate) {
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

	private long _amAnalyticsClaimId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _clientId;
	private Date _amAnalyticsClaimDate;
	private int _avgClaimTurnAround;
	private int _minClaimTurnAround;
	private int _maxClaimTurnAround;
	private int _claimTurnAroundGoal;
	private double _overallAvgClaimTurnAround;

}