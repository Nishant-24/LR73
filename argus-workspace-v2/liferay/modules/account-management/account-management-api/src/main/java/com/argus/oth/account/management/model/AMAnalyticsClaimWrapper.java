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
 * This class is a wrapper for {@link AMAnalyticsClaim}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsClaim
 * @generated
 */
public class AMAnalyticsClaimWrapper
	extends BaseModelWrapper<AMAnalyticsClaim>
	implements AMAnalyticsClaim, ModelWrapper<AMAnalyticsClaim> {

	public AMAnalyticsClaimWrapper(AMAnalyticsClaim amAnalyticsClaim) {
		super(amAnalyticsClaim);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("amAnalyticsClaimId", getAmAnalyticsClaimId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("clientId", getClientId());
		attributes.put("amAnalyticsClaimDate", getAmAnalyticsClaimDate());
		attributes.put("avgClaimTurnAround", getAvgClaimTurnAround());
		attributes.put("minClaimTurnAround", getMinClaimTurnAround());
		attributes.put("maxClaimTurnAround", getMaxClaimTurnAround());
		attributes.put("claimTurnAroundGoal", getClaimTurnAroundGoal());
		attributes.put(
			"overallAvgClaimTurnAround", getOverallAvgClaimTurnAround());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long amAnalyticsClaimId = (Long)attributes.get("amAnalyticsClaimId");

		if (amAnalyticsClaimId != null) {
			setAmAnalyticsClaimId(amAnalyticsClaimId);
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

		Date amAnalyticsClaimDate = (Date)attributes.get(
			"amAnalyticsClaimDate");

		if (amAnalyticsClaimDate != null) {
			setAmAnalyticsClaimDate(amAnalyticsClaimDate);
		}

		Integer avgClaimTurnAround = (Integer)attributes.get(
			"avgClaimTurnAround");

		if (avgClaimTurnAround != null) {
			setAvgClaimTurnAround(avgClaimTurnAround);
		}

		Integer minClaimTurnAround = (Integer)attributes.get(
			"minClaimTurnAround");

		if (minClaimTurnAround != null) {
			setMinClaimTurnAround(minClaimTurnAround);
		}

		Integer maxClaimTurnAround = (Integer)attributes.get(
			"maxClaimTurnAround");

		if (maxClaimTurnAround != null) {
			setMaxClaimTurnAround(maxClaimTurnAround);
		}

		Integer claimTurnAroundGoal = (Integer)attributes.get(
			"claimTurnAroundGoal");

		if (claimTurnAroundGoal != null) {
			setClaimTurnAroundGoal(claimTurnAroundGoal);
		}

		Double overallAvgClaimTurnAround = (Double)attributes.get(
			"overallAvgClaimTurnAround");

		if (overallAvgClaimTurnAround != null) {
			setOverallAvgClaimTurnAround(overallAvgClaimTurnAround);
		}
	}

	/**
	 * Returns the am analytics claim date of this am analytics claim.
	 *
	 * @return the am analytics claim date of this am analytics claim
	 */
	@Override
	public Date getAmAnalyticsClaimDate() {
		return model.getAmAnalyticsClaimDate();
	}

	/**
	 * Returns the am analytics claim ID of this am analytics claim.
	 *
	 * @return the am analytics claim ID of this am analytics claim
	 */
	@Override
	public long getAmAnalyticsClaimId() {
		return model.getAmAnalyticsClaimId();
	}

	/**
	 * Returns the avg claim turn around of this am analytics claim.
	 *
	 * @return the avg claim turn around of this am analytics claim
	 */
	@Override
	public int getAvgClaimTurnAround() {
		return model.getAvgClaimTurnAround();
	}

	/**
	 * Returns the claim turn around goal of this am analytics claim.
	 *
	 * @return the claim turn around goal of this am analytics claim
	 */
	@Override
	public int getClaimTurnAroundGoal() {
		return model.getClaimTurnAroundGoal();
	}

	/**
	 * Returns the client ID of this am analytics claim.
	 *
	 * @return the client ID of this am analytics claim
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the company ID of this am analytics claim.
	 *
	 * @return the company ID of this am analytics claim
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this am analytics claim.
	 *
	 * @return the create date of this am analytics claim
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this am analytics claim.
	 *
	 * @return the group ID of this am analytics claim
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the max claim turn around of this am analytics claim.
	 *
	 * @return the max claim turn around of this am analytics claim
	 */
	@Override
	public int getMaxClaimTurnAround() {
		return model.getMaxClaimTurnAround();
	}

	/**
	 * Returns the min claim turn around of this am analytics claim.
	 *
	 * @return the min claim turn around of this am analytics claim
	 */
	@Override
	public int getMinClaimTurnAround() {
		return model.getMinClaimTurnAround();
	}

	/**
	 * Returns the modified date of this am analytics claim.
	 *
	 * @return the modified date of this am analytics claim
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the overall avg claim turn around of this am analytics claim.
	 *
	 * @return the overall avg claim turn around of this am analytics claim
	 */
	@Override
	public double getOverallAvgClaimTurnAround() {
		return model.getOverallAvgClaimTurnAround();
	}

	/**
	 * Returns the primary key of this am analytics claim.
	 *
	 * @return the primary key of this am analytics claim
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the am analytics claim date of this am analytics claim.
	 *
	 * @param amAnalyticsClaimDate the am analytics claim date of this am analytics claim
	 */
	@Override
	public void setAmAnalyticsClaimDate(Date amAnalyticsClaimDate) {
		model.setAmAnalyticsClaimDate(amAnalyticsClaimDate);
	}

	/**
	 * Sets the am analytics claim ID of this am analytics claim.
	 *
	 * @param amAnalyticsClaimId the am analytics claim ID of this am analytics claim
	 */
	@Override
	public void setAmAnalyticsClaimId(long amAnalyticsClaimId) {
		model.setAmAnalyticsClaimId(amAnalyticsClaimId);
	}

	/**
	 * Sets the avg claim turn around of this am analytics claim.
	 *
	 * @param avgClaimTurnAround the avg claim turn around of this am analytics claim
	 */
	@Override
	public void setAvgClaimTurnAround(int avgClaimTurnAround) {
		model.setAvgClaimTurnAround(avgClaimTurnAround);
	}

	/**
	 * Sets the claim turn around goal of this am analytics claim.
	 *
	 * @param claimTurnAroundGoal the claim turn around goal of this am analytics claim
	 */
	@Override
	public void setClaimTurnAroundGoal(int claimTurnAroundGoal) {
		model.setClaimTurnAroundGoal(claimTurnAroundGoal);
	}

	/**
	 * Sets the client ID of this am analytics claim.
	 *
	 * @param clientId the client ID of this am analytics claim
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the company ID of this am analytics claim.
	 *
	 * @param companyId the company ID of this am analytics claim
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this am analytics claim.
	 *
	 * @param createDate the create date of this am analytics claim
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this am analytics claim.
	 *
	 * @param groupId the group ID of this am analytics claim
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the max claim turn around of this am analytics claim.
	 *
	 * @param maxClaimTurnAround the max claim turn around of this am analytics claim
	 */
	@Override
	public void setMaxClaimTurnAround(int maxClaimTurnAround) {
		model.setMaxClaimTurnAround(maxClaimTurnAround);
	}

	/**
	 * Sets the min claim turn around of this am analytics claim.
	 *
	 * @param minClaimTurnAround the min claim turn around of this am analytics claim
	 */
	@Override
	public void setMinClaimTurnAround(int minClaimTurnAround) {
		model.setMinClaimTurnAround(minClaimTurnAround);
	}

	/**
	 * Sets the modified date of this am analytics claim.
	 *
	 * @param modifiedDate the modified date of this am analytics claim
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the overall avg claim turn around of this am analytics claim.
	 *
	 * @param overallAvgClaimTurnAround the overall avg claim turn around of this am analytics claim
	 */
	@Override
	public void setOverallAvgClaimTurnAround(double overallAvgClaimTurnAround) {
		model.setOverallAvgClaimTurnAround(overallAvgClaimTurnAround);
	}

	/**
	 * Sets the primary key of this am analytics claim.
	 *
	 * @param primaryKey the primary key of this am analytics claim
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AMAnalyticsClaimWrapper wrap(AMAnalyticsClaim amAnalyticsClaim) {
		return new AMAnalyticsClaimWrapper(amAnalyticsClaim);
	}

}