package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.StagingClaimDetail;
import com.argus.oth.cases.management.service.StagingClaimDetailLocalService;
import com.argus.oth.common.OTHConstants;

import com.argus.oth.common.helper.BulkHelper;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.PortalUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.ClaimDetail",
		"staging.model.name=com.argus.oth.cases.management.model.StagingClaimDetail"
	},
	service = AopService.class
)
public class ClaimDetailLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingClaimDetail> {

	@Override
	public boolean validate(StagingClaimDetail stagingClaimDetail) {
		long lineId = stagingClaimDetail.getLineId();
		long claimId = stagingClaimDetail.getExternalClaimId();

		logDebug("Upserting " + getEntityName() + " (ID: " + lineId + ")");

		if ((lineId == 0L) || (claimId == 0L)) {
			logError("Missing required field for " + getEntityName() + " ID " + lineId + ", skipping upsert");

			return false;
		}

		Date serviceFrom = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getServiceFrom());

		if (dateParseFailed(serviceFrom)) {
			logError("Error parsing serviceFrom, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date serviceThru = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getServiceThru());

		if (dateParseFailed(serviceThru)) {
			logError("Error parsing serviceThru, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date paidDate = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getPaidDate());

		if (dateParseFailed(paidDate)) {
			logError("Error parsing paidDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getExternalModifiedDate());

		if (dateParseFailed(modifiedDate)) {
			logError("Error parsing modifiedDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getExternalCreatedDate());

		if (dateParseFailed(createdDate)) {
			logError("Error parsing createdDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "ClaimDetail";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) throws Exception {
		_load(randomString);

		return true;
	}

	private void _load(String randomString) throws Exception {
		int count = _stagingClaimDetailLocalService.getStagingClaimDetailsCount();

		int pages = count / OTHConstants.LIST_MAX_SIZE;

		logInfo("Loading " + pages + " pages of " + OTHConstants.LIST_MAX_SIZE);

		try (Connection connection = DataAccess.getConnection();
			PreparedStatement ps = connection.prepareStatement(BulkHelper.SQL_INSERT_CLAIM_DETAIL)) {

			for (int i = 0; i <= pages; i++) {
				int start = i * OTHConstants.LIST_MAX_SIZE;

				int end = start + OTHConstants.LIST_MAX_SIZE;

				List<StagingClaimDetail> stagingClaimDetails = _stagingClaimDetailLocalService.getStagingClaimDetails(
					start, end);

				for (StagingClaimDetail stagingClaimDetail : stagingClaimDetails) {
					_upsertClaimDetail(stagingClaimDetail, ps, randomString);
				}

				ps.executeBatch();

				logInfo(end + " records loaded");
			}
		}
		finally {
			CacheRegistryUtil.clear();
		}
	}

	private void _upsertClaimDetail(StagingClaimDetail stagingClaimDetail, PreparedStatement ps, String randomString)
		throws Exception {

		long lineId = stagingClaimDetail.getLineId();

		logDebug("Upserting " + getEntityName() + " (ID: " + lineId + ")");

		Date serviceFrom = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getServiceFrom());
		Date serviceThru = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getServiceThru());
		Date paidDate = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getPaidDate());
		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getExternalModifiedDate());
		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingClaimDetail.getExternalCreatedDate());

		ps.setLong(1, stagingClaimDetail.getLineId());
		ps.setLong(2, getGroupId());
		ps.setLong(3, PortalUtil.getDefaultCompanyId());
		ps.setDate(4, BulkHelper.getSQLDate(createdDate));
		ps.setDate(5, BulkHelper.getSQLDate(modifiedDate));
		ps.setLong(6, stagingClaimDetail.getLineId());
		ps.setLong(7, stagingClaimDetail.getExternalClaimId());
		ps.setDate(8, BulkHelper.getSQLDate(serviceFrom));
		ps.setDate(9, BulkHelper.getSQLDate(serviceThru));
		ps.setString(10, stagingClaimDetail.getResultCodes());
		ps.setString(11, stagingClaimDetail.getProcedureCode());
		ps.setDouble(12, stagingClaimDetail.getChargedAmount());
		ps.setDouble(13, stagingClaimDetail.getRepricedAmount());
		ps.setDouble(14, stagingClaimDetail.getClaimAmount());
		ps.setDate(15, BulkHelper.getSQLDate(paidDate));
		ps.setDouble(16, stagingClaimDetail.getPaidAmount());
		ps.setDouble(17, stagingClaimDetail.getSavingsAmount());
		ps.setInt(18, stagingClaimDetail.getUnits());
		ps.setString(19, stagingClaimDetail.getCoverage());
		ps.setString(20, stagingClaimDetail.getLineStatus());
		ps.setString(21, stagingClaimDetail.getRevCode());
		ps.setString(22, randomString);

		ps.addBatch();
	}

	@Reference
	private StagingClaimDetailLocalService _stagingClaimDetailLocalService;

}