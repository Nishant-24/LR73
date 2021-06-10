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

import com.argus.oth.account.management.model.StagingAMAnalyticsDB;
import com.argus.oth.account.management.service.base.StagingAMAnalyticsDBLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging am analytics db local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.account.management.service.StagingAMAnalyticsDBLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsDBLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.account.management.model.StagingAMAnalyticsDB",
	service = AopService.class
)
public class StagingAMAnalyticsDBLocalServiceImpl extends StagingAMAnalyticsDBLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.account.management.service.StagingAMAnalyticsDBLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.account.management.service.StagingAMAnalyticsDBLocalServiceUtil</code>.
	 */
	public StagingAMAnalyticsDB add(
		long clientId, double savingsPercent, double chargedAmount, double repricedAmount, double avgDownTime,
		double avgSpeedOfAnswer, double abandonmentRate, long claimsTurnaround, double downTimeGoal,
		double speedOfAnswerGoal, double abandonmentRateGoal, double claimsTurnaroundGoal) {

		long stagingAMAnalyticsDbId = counterLocalService.increment(StagingAMAnalyticsDB.class.getName());

		StagingAMAnalyticsDB stagingAMAnalyticsDb = stagingAMAnalyticsDBPersistence.create(stagingAMAnalyticsDbId);

		stagingAMAnalyticsDb.setClientId(clientId);
		stagingAMAnalyticsDb.setSavingsPercent(savingsPercent);
		stagingAMAnalyticsDb.setChargedAmount(chargedAmount);
		stagingAMAnalyticsDb.setRepricedAmount(repricedAmount);
		stagingAMAnalyticsDb.setAvgDownTime(avgDownTime);
		stagingAMAnalyticsDb.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		stagingAMAnalyticsDb.setAbandonmentRate(abandonmentRate);
		stagingAMAnalyticsDb.setClaimsTurnaround(claimsTurnaround);
		stagingAMAnalyticsDb.setDownTimeGoal(downTimeGoal);
		stagingAMAnalyticsDb.setSpeedOfAnswerGoal(speedOfAnswerGoal);
		stagingAMAnalyticsDb.setAbandonmentRateGoal(abandonmentRateGoal);
		stagingAMAnalyticsDb.setClaimsTurnaroundGoal(claimsTurnaroundGoal);

		return addStagingAMAnalyticsDB(stagingAMAnalyticsDb);
	}

	public void deleteAll() {
		for (StagingAMAnalyticsDB stagingAMAnalyticsDb : stagingAMAnalyticsDBPersistence.findAll()) {
			deleteStagingAMAnalyticsDB(stagingAMAnalyticsDb);
		}
	}

}