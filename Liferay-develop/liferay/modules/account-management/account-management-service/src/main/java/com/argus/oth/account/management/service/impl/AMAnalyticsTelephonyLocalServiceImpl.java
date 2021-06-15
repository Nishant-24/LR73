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

import com.argus.oth.account.management.model.AMAnalyticsTelephony;
import com.argus.oth.account.management.service.base.AMAnalyticsTelephonyLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;

import java.util.Date;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the am analytics telephony local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.account.management.service.AMAnalyticsTelephonyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsTelephonyLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.account.management.model.AMAnalyticsTelephony",
	service = AopService.class
)
public class AMAnalyticsTelephonyLocalServiceImpl extends AMAnalyticsTelephonyLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.account.management.service.AMAnalyticsTelephonyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.account.management.service.AMAnalyticsTelephonyLocalServiceUtil</code>.
	 */
	public AMAnalyticsTelephony add(
		long groupId, long clientId, Date amAnalyticsTelephonyDate, double avgDownTime, double avgSpeedOfAnswer,
		double abandonmentRate, double downTimeGoal, double speedAnswerGoal, double abandonmentRateGoal,
		double overallAvgDownTime, double overallAvgSpeedOfAnswer, double overallAvgAbandonmentRate) {

		long amAnalyticsTelephonyId = counterLocalService.increment(AMAnalyticsTelephony.class.getName());

		AMAnalyticsTelephony amAnalyticsTelephony = amAnalyticsTelephonyPersistence.create(amAnalyticsTelephonyId);

		amAnalyticsTelephony.setGroupId(groupId);
		amAnalyticsTelephony.setClientId(clientId);
		amAnalyticsTelephony.setAmAnalyticsTelephonyDate(amAnalyticsTelephonyDate);
		amAnalyticsTelephony.setAvgDownTime(avgDownTime);
		amAnalyticsTelephony.setAvgSpeedOfAnswer(avgSpeedOfAnswer);
		amAnalyticsTelephony.setAbandonmentRate(abandonmentRate);
		amAnalyticsTelephony.setDownTimeGoal(downTimeGoal);
		amAnalyticsTelephony.setSpeedAnswerGoal(speedAnswerGoal);
		amAnalyticsTelephony.setAbandonmentRateGoal(abandonmentRateGoal);
		amAnalyticsTelephony.setOverallAvgDownTime(overallAvgDownTime);
		amAnalyticsTelephony.setOverallAvgSpeedOfAnswer(overallAvgSpeedOfAnswer);
		amAnalyticsTelephony.setOverallAvgAbandonmentRate(overallAvgAbandonmentRate);

		return addAMAnalyticsTelephony(amAnalyticsTelephony);
	}

	public void deleteAll() {
		for (AMAnalyticsTelephony amAnalyticsTelephony : amAnalyticsTelephonyPersistence.findAll()) {
			deleteAMAnalyticsTelephony(amAnalyticsTelephony);
		}
	}

	public void reindex() throws SearchException {
		Indexer<AMAnalyticsTelephony> amAnalyticsTelephonyIndexer = _indexerRegistry.getIndexer(
			AMAnalyticsTelephony.class.getName());

		if (Objects.nonNull(amAnalyticsTelephonyIndexer)) {
			amAnalyticsTelephonyIndexer.reindex(amAnalyticsTelephonyPersistence.findAll());
		}
	}

	public void reindex(long companyId) throws SearchException {

		Indexer<AMAnalyticsTelephony> amAnalyticsTelephonyIndexer = _indexerRegistry.getIndexer(
				AMAnalyticsTelephony.class.getName());

		if (Objects.nonNull(amAnalyticsTelephonyIndexer)) {
			amAnalyticsTelephonyIndexer.reindex(new String[] { String.valueOf(companyId) });
		}
	}

	@Reference
	private IndexerRegistry _indexerRegistry;

}