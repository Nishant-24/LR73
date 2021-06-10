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

import com.argus.oth.account.management.model.AMAnalyticsDB;
import com.argus.oth.account.management.service.base.AMAnalyticsDBLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the am analytics db local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.account.management.service.AMAnalyticsDBLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsDBLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.account.management.model.AMAnalyticsDB", service = AopService.class
)
public class AMAnalyticsDBLocalServiceImpl extends AMAnalyticsDBLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.account.management.service.AMAnalyticsDBLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.account.management.service.AMAnalyticsDBLocalServiceUtil</code>.
	 */
	public AMAnalyticsDB add(
		long groupId, long clientId, double savingsPercent, double chargedAmount, double repricedAmount,
		double avgDownTime, double avgSpeedOfAnswer, double abandonmentRate, long claimsTurnaround, double downTimeGoal,
		double speedOfAnswerGoal, double abandonmentRateGoal, double claimsTurnaroundGoal) {

		long amAnalyticsDbId = counterLocalService.increment(AMAnalyticsDB.class.getName());

		AMAnalyticsDB amAnalyticsDB = amAnalyticsDBPersistence.create(amAnalyticsDbId);

		amAnalyticsDB.setGroupId(groupId);
		amAnalyticsDB.setClientId(clientId);
		amAnalyticsDB.setSavingsPercent(savingsPercent);
		amAnalyticsDB.setChargedAmount(chargedAmount);
		amAnalyticsDB.setRepricedAmount(repricedAmount);
		amAnalyticsDB.setAvgDownTime(avgDownTime);
		amAnalyticsDB.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		amAnalyticsDB.setAbandonmentRate(abandonmentRate);
		amAnalyticsDB.setClaimsTurnaround(claimsTurnaround);
		amAnalyticsDB.setDownTimeGoal(downTimeGoal);
		amAnalyticsDB.setSpeedOfAnswerGoal(speedOfAnswerGoal);
		amAnalyticsDB.setAbandonmentRateGoal(abandonmentRateGoal);
		amAnalyticsDB.setClaimsTurnaroundGoal(claimsTurnaroundGoal);

		return addAMAnalyticsDB(amAnalyticsDB);
	}

	public void deleteAll() {
		for (AMAnalyticsDB amAnalyticsDB : amAnalyticsDBPersistence.findAll()) {
			deleteAMAnalyticsDB(amAnalyticsDB);
		}
	}

	public AMAnalyticsDB fetchByClientId(long clientId) {
		return amAnalyticsDBPersistence.fetchByClientId(clientId);
	}

}