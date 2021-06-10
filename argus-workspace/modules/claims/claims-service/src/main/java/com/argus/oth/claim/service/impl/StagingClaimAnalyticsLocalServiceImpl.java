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

package com.argus.oth.claim.service.impl;

import com.argus.oth.claim.model.StagingClaimAnalytics;
import com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl;
import com.argus.oth.claim.service.base.StagingClaimAnalyticsLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging claim analytics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.claim.service.StagingClaimAnalyticsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimAnalyticsLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.claim.model.StagingClaimAnalytics", service = AopService.class)
public class StagingClaimAnalyticsLocalServiceImpl extends StagingClaimAnalyticsLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.claim.service.StagingClaimAnalyticsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.claim.service.StagingClaimAnalyticsLocalServiceUtil</code>.
	 */
	public StagingClaimAnalytics addStagingClaimAnalytics(
		long externalClientId, String clientName, String claimNumber, long externalCaseId, String claimStatus,
		String receivedDate, String serviceDate, String paidDate, long externalMemberId, String memberName,
		String providerName, String billType, String primaryDiagnosis, double chargedAmount, double paidAmount,
		double repricedAmount, double savingsAmount, double chargedPercent, double repricedPercent,
		double savingsPercent, String chargedRange, String paidRange, String repricedRange, String savingsRange,
		long claimAging, String procedureCodes, String resultCodes, String diagnosisCodes, String country, String state,
		double financialExposure, String repricedNetwork, String clientGroupName) {

		long stagingClaimAnalyticsId = counterLocalService.increment(StagingClaimAnalytics.class.getName());

		StagingClaimAnalytics stagingClaimAnalytics = stagingClaimAnalyticsPersistence.create(stagingClaimAnalyticsId);

		stagingClaimAnalytics.setExternalClientId(externalClientId);
		stagingClaimAnalytics.setClientName(clientName);
		stagingClaimAnalytics.setClaimNumber(claimNumber);
		stagingClaimAnalytics.setExternalCaseId(externalCaseId);
		stagingClaimAnalytics.setClaimStatus(claimStatus);
		stagingClaimAnalytics.setReceivedDate(receivedDate);
		stagingClaimAnalytics.setServiceDate(serviceDate);
		stagingClaimAnalytics.setPaidDate(paidDate);
		stagingClaimAnalytics.setExternalMemberId(externalMemberId);
		stagingClaimAnalytics.setMemberName(memberName);
		stagingClaimAnalytics.setProviderName(providerName);
		stagingClaimAnalytics.setBillType(billType);
		stagingClaimAnalytics.setPrimaryDiagnosis(primaryDiagnosis);
		stagingClaimAnalytics.setChargedAmount(chargedAmount);
		stagingClaimAnalytics.setPaidAmount(paidAmount);
		stagingClaimAnalytics.setRepricedAmount(repricedAmount);
		stagingClaimAnalytics.setSavingsAmount(savingsAmount);
		stagingClaimAnalytics.setChargedPercent(chargedPercent);
		stagingClaimAnalytics.setRepricedPercent(repricedPercent);
		stagingClaimAnalytics.setSavingsPercent(savingsPercent);
		stagingClaimAnalytics.setChargedRange(chargedRange);
		stagingClaimAnalytics.setPaidRange(paidRange);
		stagingClaimAnalytics.setRepricedRange(repricedRange);
		stagingClaimAnalytics.setSavingsRange(savingsRange);
		stagingClaimAnalytics.setClaimAging(claimAging);
		stagingClaimAnalytics.setProcedureCodes(procedureCodes);
		stagingClaimAnalytics.setResultCodes(resultCodes);
		stagingClaimAnalytics.setDiagnosisCodes(diagnosisCodes);
		stagingClaimAnalytics.setCountry(country);
		stagingClaimAnalytics.setState(state);
		stagingClaimAnalytics.setFinancialExposure(financialExposure);
		stagingClaimAnalytics.setRepricedNetwork(repricedNetwork);
		stagingClaimAnalytics.setClientGroupName(clientGroupName);

		return addStagingClaimAnalytics(stagingClaimAnalytics);
	}

	public void deleteAll() {
		BulkHelper.bulkDeleteAll(
			stagingClaimAnalyticsPersistence.getCurrentSession(), StagingClaimAnalyticsModelImpl.TABLE_NAME);
	}

}