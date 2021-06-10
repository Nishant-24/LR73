package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.claim.model.StagingClaimAnalytics;
import com.argus.oth.claim.service.ClaimAnalyticsLocalService;
import com.argus.oth.claim.service.StagingClaimAnalyticsLocalService;
import com.argus.oth.common.OTHConstants;

import com.argus.oth.common.helper.BulkHelper;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.search.IndexStatusManagerThreadLocal;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.PortalUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.claim.model.ClaimAnalytics",
		"staging.model.name=com.argus.oth.claim.model.StagingClaimAnalytics"
	},
	service = AopService.class
)
public class ClaimAnalyticsLoadServiceImpl extends BaseLoadService
	implements AopService, LoadService<StagingClaimAnalytics> {

	@Override
	public boolean validate(StagingClaimAnalytics stagingClaimAnalytics) {
		String claimNumber = stagingClaimAnalytics.getClaimNumber();

		if (blankNullOrNullString(claimNumber)) {
			logError("Missing required field ClaimNumber for " + getEntityName() + ", skipping upsert");

			return false;
		}

		Date receivedDate = parseDate_yyyyMMddHHmmsss(stagingClaimAnalytics.getReceivedDate());

		if (dateParseFailed(receivedDate)) {
			logError(
				"Error parsing receivedDate, " + getEntityName() + " ClaimNumber " + claimNumber + ", skipping upsert");

			return false;
		}

		Date serviceDate = parseDate_yyyyMMddHHmmsss(stagingClaimAnalytics.getServiceDate());

		if (dateParseFailed(serviceDate)) {
			logError(
				"Error parsing serviceDate, " + getEntityName() + " ClaimNumber " + claimNumber + ", skipping upsert");

			return false;
		}

		Date paidDate = parseDate_yyyyMMddHHmmsss(stagingClaimAnalytics.getPaidDate());

		if (dateParseFailed(paidDate)) {
			logError(
				"Error parsing paidDate, " + getEntityName() + " ClaimNumber " + claimNumber + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityClassName() {
		return ClaimAnalytics.class.getName();
	}

	@Override
	protected String getEntityName() {
		return "ClaimAnalytics";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) throws Exception {
		_deleteMain();

		IndexStatusManagerThreadLocal.setIndexReadOnly(true);

		_load();

		IndexStatusManagerThreadLocal.setIndexReadOnly(false);

		try {
			long companyId = PortalUtil.getDefaultCompanyId();

			_claimAnalyticsLocalService.reindex(companyId);
		}
		catch (SearchException se) {
			logError("Failed to reindex " + getEntityName(), se);
		}

		return true;
	}

	@Override
	protected boolean reIndexOnLoad() {
		return true;
	}

	private void _addClaimAnalytics(
			StagingClaimAnalytics stagingClaimAnalytics, PreparedStatement ps, AtomicLong counter)
		throws Exception {

		String claimNumber = stagingClaimAnalytics.getClaimNumber();

		logDebug("Upserting " + getEntityName() + " (ClaimNumber: " + claimNumber + ")");

		Date receivedDate = parseDate_yyyyMMddHHmmsss(stagingClaimAnalytics.getReceivedDate());
		Date serviceDate = parseDate_yyyyMMddHHmmsss(stagingClaimAnalytics.getServiceDate());
		Date paidDate = parseDate_yyyyMMddHHmmsss(stagingClaimAnalytics.getPaidDate());

		if (!validate(stagingClaimAnalytics)) {
			logError(getEntityName() + " ClaimNumber " + claimNumber + " invalid, skipping upsert");

			return;
		}

		Date date = new Date();

		java.sql.Date now = new java.sql.Date(date.getTime());

		ps.setLong(1, counter.incrementAndGet());
		ps.setLong(2, getGroupId());
		ps.setLong(3, PortalUtil.getDefaultCompanyId());
		ps.setDate(4, now);
		ps.setDate(5, now);
		ps.setLong(6, stagingClaimAnalytics.getExternalClientId());
		ps.setString(7, stagingClaimAnalytics.getClientName());
		ps.setString(8, stagingClaimAnalytics.getClaimNumber());
		ps.setLong(9, stagingClaimAnalytics.getExternalCaseId());
		ps.setString(10, stagingClaimAnalytics.getClaimStatus());
		ps.setDate(11, BulkHelper.getSQLDate(receivedDate));
		ps.setDate(12, BulkHelper.getSQLDate(serviceDate));
		ps.setDate(13, BulkHelper.getSQLDate(paidDate));
		ps.setLong(14, stagingClaimAnalytics.getExternalMemberId());
		ps.setString(15, stagingClaimAnalytics.getMemberName());
		ps.setString(16, stagingClaimAnalytics.getProviderName());
		ps.setString(17, stagingClaimAnalytics.getBillType());
		ps.setString(18, stagingClaimAnalytics.getPrimaryDiagnosis());
		ps.setDouble(19, stagingClaimAnalytics.getChargedAmount());
		ps.setDouble(20, stagingClaimAnalytics.getPaidAmount());
		ps.setDouble(21, stagingClaimAnalytics.getRepricedAmount());
		ps.setDouble(22, stagingClaimAnalytics.getSavingsAmount());
		ps.setDouble(23, stagingClaimAnalytics.getChargedPercent());
		ps.setDouble(24, stagingClaimAnalytics.getRepricedPercent());
		ps.setDouble(25, stagingClaimAnalytics.getSavingsPercent());
		ps.setString(26, stagingClaimAnalytics.getChargedRange());
		ps.setString(27, stagingClaimAnalytics.getPaidRange());
		ps.setString(28, stagingClaimAnalytics.getRepricedRange());
		ps.setString(29, stagingClaimAnalytics.getSavingsRange());
		ps.setLong(30, stagingClaimAnalytics.getClaimAging());
		ps.setString(31, stagingClaimAnalytics.getProcedureCodes());
		ps.setString(32, stagingClaimAnalytics.getResultCodes());
		ps.setString(33, stagingClaimAnalytics.getDiagnosisCodes());
		ps.setString(34, stagingClaimAnalytics.getCountry());
		ps.setString(35, stagingClaimAnalytics.getState());
		ps.setDouble(36, stagingClaimAnalytics.getFinancialExposure());
		ps.setString(37, stagingClaimAnalytics.getRepricedNetwork());
		ps.setString(38, stagingClaimAnalytics.getClientGroupName());

		ps.addBatch();
	}

	private void _deleteMain() {
		_claimAnalyticsLocalService.deleteAll();
	}

	private void _load() throws Exception {
		int count = _stagingClaimAnalyticsLocalService.getStagingClaimAnalyticsesCount();

		int pages = count / OTHConstants.LIST_MAX_SIZE;

		logInfo("Loading " + pages + " pages of " + OTHConstants.LIST_MAX_SIZE);

		try (Connection connection = DataAccess.getConnection();
			PreparedStatement ps = connection.prepareStatement(BulkHelper.SQL_INSERT_CLAIM_ANALYTICS)) {

			AtomicLong counter = new AtomicLong(1);

			for (int i = 0; i <= pages; i++) {
				int start = i * OTHConstants.LIST_MAX_SIZE;

				int end = start + OTHConstants.LIST_MAX_SIZE;

				List<StagingClaimAnalytics> stagingClaimAnalyticsList =
					_stagingClaimAnalyticsLocalService.getStagingClaimAnalyticses(start, end);

				for (StagingClaimAnalytics stagingClaimAnalytics : stagingClaimAnalyticsList) {
					_addClaimAnalytics(stagingClaimAnalytics, ps, counter);
				}

				ps.executeBatch();

				logInfo(end + " records loaded");
			}
		}
		finally {
			CacheRegistryUtil.clear();
		}
	}

	@Reference
	private ClaimAnalyticsLocalService _claimAnalyticsLocalService;

	@Reference
	private StagingClaimAnalyticsLocalService _stagingClaimAnalyticsLocalService;

}