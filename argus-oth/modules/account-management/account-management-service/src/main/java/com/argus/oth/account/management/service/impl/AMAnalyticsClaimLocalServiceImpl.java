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

import com.argus.oth.account.management.model.AMAnalyticsClaim;
import com.argus.oth.account.management.service.base.AMAnalyticsClaimLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;

import java.util.Date;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the am analytics claim local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.account.management.service.AMAnalyticsClaimLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsClaimLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.account.management.model.AMAnalyticsClaim", service = AopService.class
)
public class AMAnalyticsClaimLocalServiceImpl extends AMAnalyticsClaimLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.account.management.service.AMAnalyticsClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.account.management.service.AMAnalyticsClaimLocalServiceUtil</code>.
	 */
	public AMAnalyticsClaim add(
		long groupId, long clientId, Date amAnalyticsClaimDate, int avgClaimTurnAround, int minClaimTurnAround,
		int maxClaimTurnAround, int claimTurnAroundGoal, double overallAvgClaimTurnAround) {

		long amAnalyticsClaimId = counterLocalService.increment(AMAnalyticsClaim.class.getName());

		AMAnalyticsClaim amAnalyticsClaim = amAnalyticsClaimPersistence.create(amAnalyticsClaimId);

		amAnalyticsClaim.setGroupId(groupId);
		amAnalyticsClaim.setClientId(clientId);
		amAnalyticsClaim.setAmAnalyticsClaimDate(amAnalyticsClaimDate);
		amAnalyticsClaim.setAvgClaimTurnAround(avgClaimTurnAround);
		amAnalyticsClaim.setMinClaimTurnAround(minClaimTurnAround);
		amAnalyticsClaim.setMaxClaimTurnAround(maxClaimTurnAround);
		amAnalyticsClaim.setClaimTurnAroundGoal(claimTurnAroundGoal);
		amAnalyticsClaim.setOverallAvgClaimTurnAround(overallAvgClaimTurnAround);

		return addAMAnalyticsClaim(amAnalyticsClaim);
	}

	public void deleteAll() {
		for (AMAnalyticsClaim amAnalyticsClaim : amAnalyticsClaimPersistence.findAll()) {
			deleteAMAnalyticsClaim(amAnalyticsClaim);
		}
	}

	public void reindex() throws SearchException {
		Indexer<AMAnalyticsClaim> amAnalyticsClaimIndexer = _indexerRegistry.getIndexer(
			AMAnalyticsClaim.class.getName());

		if (Objects.nonNull(amAnalyticsClaimIndexer)) {
			amAnalyticsClaimIndexer.reindex(amAnalyticsClaimPersistence.findAll());
		}
	}

	public void reindex(long companyId) throws SearchException {
		Indexer<AMAnalyticsClaim> amAnalyticsClaimIndexer = _indexerRegistry.getIndexer(
				AMAnalyticsClaim.class.getName());

		if (Objects.nonNull(amAnalyticsClaimIndexer)) {
			amAnalyticsClaimIndexer.reindex(new String[] { String.valueOf(companyId) });
		}
	}

	@Reference
	private IndexerRegistry _indexerRegistry;

}