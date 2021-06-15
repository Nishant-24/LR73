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

import com.argus.oth.account.management.model.StagingAMATelephony;
import com.argus.oth.account.management.service.base.StagingAMATelephonyLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging ama telephony local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.account.management.service.StagingAMATelephonyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMATelephonyLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.account.management.model.StagingAMATelephony", service = AopService.class
)
public class StagingAMATelephonyLocalServiceImpl extends StagingAMATelephonyLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.account.management.service.StagingAMATelephonyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.account.management.service.StagingAMATelephonyLocalServiceUtil</code>.
	 */
	public StagingAMATelephony add(
		long clientId, String amAnalyticsTelephonyDate, double avgDownTime, double avgSpeedOfAnswer,
		double abandonmentRate, double downTimeGoal, double speedAnswerGoal, double abandonmentRateGoal,
		double overallAvgDownTime, double overallAvgSpeedOfAnswer, double overallAvgAbandonmentRate) {

		long stagingAMATelephonyId = counterLocalService.increment(StagingAMATelephony.class.getName());

		StagingAMATelephony stagingAMATelephony = stagingAMATelephonyPersistence.create(stagingAMATelephonyId);

		stagingAMATelephony.setClientId(clientId);
		stagingAMATelephony.setAmAnalyticsTelephonyDate(amAnalyticsTelephonyDate);
		stagingAMATelephony.setAvgDownTime(avgDownTime);
		stagingAMATelephony.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		stagingAMATelephony.setAbandonmentRate(abandonmentRate);
		stagingAMATelephony.setDownTimeGoal(downTimeGoal);
		stagingAMATelephony.setSpeedAnswerGoal(speedAnswerGoal);
		stagingAMATelephony.setAbandonmentRateGoal(abandonmentRateGoal);
		stagingAMATelephony.setOverallAvgDownTime(overallAvgDownTime);
		stagingAMATelephony.setOverallAvgSpeedOfAnswer(overallAvgSpeedOfAnswer);
		stagingAMATelephony.setOverallAvgAbandonmentRate(overallAvgAbandonmentRate);

		return addStagingAMATelephony(stagingAMATelephony);
	}

	public void deleteAll() {
		for (StagingAMATelephony stagingAMATelephony : stagingAMATelephonyPersistence.findAll()) {
			deleteStagingAMATelephony(stagingAMATelephony);
		}
	}

}