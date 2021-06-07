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

import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.claim.model.ClaimsReportRetrievalParametersImpl;
import com.argus.oth.claim.model.impl.ClaimAnalyticsModelImpl;
import com.argus.oth.claim.service.base.ClaimAnalyticsLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.helper.BulkHelper;
import com.argus.oth.common.report.ReportRetrievalParameters;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the claim analytics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.claim.service.ClaimAnalyticsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalyticsLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.claim.model.ClaimAnalytics", service = AopService.class)
public class ClaimAnalyticsLocalServiceImpl extends ClaimAnalyticsLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.claim.service.ClaimAnalyticsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.claim.service.ClaimAnalyticsLocalServiceUtil</code>.
	 */
	public ClaimAnalytics addClaimAnalytics(
		long groupId, long externalClientId, String clientName, String claimNumber, long externalCaseId,
		String claimStatus, Date receivedDate, Date serviceDate, Date paidDate, long externalMemberId,
		String memberName, String providerName, String billType, String primaryDiagnosis, double chargedAmount,
		double paidAmount, double repricedAmount, double savingsAmount, double chargedPercent, double repricedPercent,
		double savingsPercent, String chargedRange, String paidRange, String repricedRange, String savingsRange,
		long claimAging, String procedureCodes, String resultCodes, String diagnosisCodes, String country, String state,
		double financialExposure, String repricedNetwork, String clientGroupName) {

		long claimAnalyticsId = counterLocalService.increment(ClaimAnalytics.class.getName());

		Group group = groupLocalService.fetchGroup(groupId);

		ClaimAnalytics claimAnalytics = claimAnalyticsPersistence.create(claimAnalyticsId);

		if (Objects.nonNull(group)) {
			claimAnalytics.setCompanyId(group.getCompanyId());
		}

		claimAnalytics.setGroupId(groupId);
		claimAnalytics.setExternalClientId(externalClientId);
		claimAnalytics.setClientName(clientName);
		claimAnalytics.setClaimNumber(claimNumber);
		claimAnalytics.setExternalCaseId(externalCaseId);
		claimAnalytics.setClaimStatus(claimStatus);
		claimAnalytics.setReceivedDate(receivedDate);
		claimAnalytics.setServiceDate(serviceDate);
		claimAnalytics.setPaidDate(paidDate);
		claimAnalytics.setExternalMemberId(externalMemberId);
		claimAnalytics.setMemberName(memberName);
		claimAnalytics.setProviderName(providerName);
		claimAnalytics.setBillType(billType);
		claimAnalytics.setPrimaryDiagnosis(primaryDiagnosis);
		claimAnalytics.setChargedAmount(chargedAmount);
		claimAnalytics.setPaidAmount(paidAmount);
		claimAnalytics.setRepricedAmount(repricedAmount);
		claimAnalytics.setSavingsAmount(savingsAmount);
		claimAnalytics.setChargedPercent(chargedPercent);
		claimAnalytics.setRepricedPercent(repricedPercent);
		claimAnalytics.setSavingsPercent(savingsPercent);
		claimAnalytics.setChargedRange(chargedRange);
		claimAnalytics.setPaidRange(paidRange);
		claimAnalytics.setRepricedRange(repricedRange);
		claimAnalytics.setSavingsRange(savingsRange);
		claimAnalytics.setClaimAging(claimAging);
		claimAnalytics.setProcedureCodes(procedureCodes);
		claimAnalytics.setResultCodes(resultCodes);
		claimAnalytics.setDiagnosisCodes(diagnosisCodes);
		claimAnalytics.setCountry(country);
		claimAnalytics.setState(state);
		claimAnalytics.setFinancialExposure(financialExposure);
		claimAnalytics.setRepricedNetwork(repricedNetwork);
		claimAnalytics.setClientGroupName(clientGroupName);

		return addClaimAnalytics(claimAnalytics);
	}

	public void deleteAll() {
		BulkHelper.bulkDeleteAll(claimAnalyticsPersistence.getCurrentSession(), ClaimAnalyticsModelImpl.TABLE_NAME);
	}

	public List<ClaimAnalytics> getByE_C(long externalClientId, String claimStatus) {
		return claimAnalyticsPersistence.findByE_C(externalClientId, claimStatus);
	}

	public List<ClaimAnalytics> getByExternalClientId(long externalClientId) {
		return claimAnalyticsPersistence.findByExternalClientId(externalClientId);
	}

	public List<Document> getClaimReportSearchDocuments(ReportRetrievalParameters reportRetrievalParameters) {
		try {
			Indexer<ClaimAnalytics> claimAnalyticsIndexer = IndexerRegistryUtil.getIndexer(
				ClaimAnalytics.class.getName());

			SearchContext searchContext = new SearchContext();

			searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());

			ClaimsReportRetrievalParametersImpl claimsReportRetrievalParameters =
				(ClaimsReportRetrievalParametersImpl)reportRetrievalParameters;

			DateRange dateRange = claimsReportRetrievalParameters.getDateRange();

			searchContext.setAttribute(
				OTHConstants.FIELD_EXTERNAL_CLIENT_ID, claimsReportRetrievalParameters.getExternalClientId());

			if (Objects.nonNull(dateRange.getStartDate())) {
				Date startDate = dateRange.getStartDate();

				searchContext.setAttribute(OTHConstants.FIELD_START_DATE, startDate.getTime());
			}

			if (Objects.nonNull(dateRange.getEndDate())) {
				Date endDate = dateRange.getEndDate();

				searchContext.setAttribute(OTHConstants.FIELD_END_DATE, endDate.getTime());
			}

			searchContext.setStart(reportRetrievalParameters.getStart());
			searchContext.setEnd(reportRetrievalParameters.getEnd());

			Hits hits = claimAnalyticsIndexer.search(searchContext);

			return hits.toList();
		}
		catch (PortalException pe) {
			_log.error("Failed to get ClaimAnalytics data for report", pe);

			return new ArrayList<>();
		}
	}

	public void reindex() throws SearchException {
		Indexer<ClaimAnalytics> claimAnalyticsIndexer = IndexerRegistryUtil.getIndexer(ClaimAnalytics.class.getName());

		if (Objects.nonNull(claimAnalyticsIndexer)) {
			claimAnalyticsIndexer.reindex(claimAnalyticsPersistence.findAll());
		}
	}

	public void reindex(long companyId) throws SearchException {
		Indexer<ClaimAnalytics> claimAnalyticsIndexer = IndexerRegistryUtil.getIndexer(ClaimAnalytics.class.getName());

		if (Objects.nonNull(claimAnalyticsIndexer)) {
			claimAnalyticsIndexer.reindex(new String[] {String.valueOf(companyId)});
		}
	}

	public List<ClaimAnalytics> search(SearchContext searchContext) throws SearchException {
		Indexer<ClaimAnalytics> claimAnalyticsIndexer = _indexerRegistry.getIndexer(ClaimAnalytics.class);

		Hits hits = claimAnalyticsIndexer.search(searchContext);

		Document[] documents = hits.getDocs();

		List<ClaimAnalytics> claimAnalyticsList = new ArrayList<>();

		for (Document document : documents) {
			long entryClassPK = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

			ClaimAnalytics claimAnalytics = fetchClaimAnalytics(entryClassPK);

			if (Objects.nonNull(claimAnalytics)) {
				claimAnalyticsList.add(claimAnalytics);
			}
		}

		return claimAnalyticsList;
	}

	private static final Log _log = LogFactoryUtil.getLog(ClaimAnalyticsLocalServiceImpl.class);

	@Reference
	private IndexerRegistry _indexerRegistry;

}