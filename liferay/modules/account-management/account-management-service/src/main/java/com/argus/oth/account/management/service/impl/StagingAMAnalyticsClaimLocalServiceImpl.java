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

package com.argus.oth.account.management.service.impl;

import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl;
import com.argus.oth.account.management.service.base.StagingAMAnalyticsClaimLocalServiceBaseImpl;

import com.argus.oth.common.helper.BulkHelper;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging am analytics claim local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.account.management.service.StagingAMAnalyticsClaimLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsClaimLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.account.management.model.StagingAMAnalyticsClaim",
	service = AopService.class
)
public class StagingAMAnalyticsClaimLocalServiceImpl extends StagingAMAnalyticsClaimLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.account.management.service.StagingAMAnalyticsClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.account.management.service.StagingAMAnalyticsClaimLocalServiceUtil</code>.
	 */
	public StagingAMAnalyticsClaim add(
		long clientId, String amAnalyticsClaimDate, int avgClaimTurnAround, int minClaimTurnAround,
		int maxClaimTurnAround, int claimTurnAroundGoal, double overallAvgClaimTurnAround) {

		long stagingAMAnalyticsClaimId = counterLocalService.increment(StagingAMAnalyticsClaim.class.getName());

		StagingAMAnalyticsClaim stagingAMAnalyticsClaim = stagingAMAnalyticsClaimPersistence.create(
			stagingAMAnalyticsClaimId);

		stagingAMAnalyticsClaim.setClientId(clientId);
		stagingAMAnalyticsClaim.setAmAnalyticsClaimDate(amAnalyticsClaimDate);
		stagingAMAnalyticsClaim.setAvgClaimTurnAround(avgClaimTurnAround);
		stagingAMAnalyticsClaim.setMinClaimTurnAround(minClaimTurnAround);
		stagingAMAnalyticsClaim.setMaxClaimTurnAround(maxClaimTurnAround);
		stagingAMAnalyticsClaim.setClaimTurnAroundGoal(claimTurnAroundGoal);
		stagingAMAnalyticsClaim.setOverallAvgClaimTurnAround(overallAvgClaimTurnAround);

		return addStagingAMAnalyticsClaim(stagingAMAnalyticsClaim);
	}

	public void deleteAll() {
		BulkHelper.bulkDeleteAll(stagingAMAnalyticsClaimPersistence.getCurrentSession(), StagingAMAnalyticsClaimModelImpl.TABLE_NAME);
	}

}