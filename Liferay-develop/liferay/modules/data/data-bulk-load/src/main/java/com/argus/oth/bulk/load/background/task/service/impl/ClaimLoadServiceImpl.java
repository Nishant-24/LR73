package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.StagingClaim;
import com.argus.oth.cases.management.service.StagingClaimLocalService;
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
		"model.name=com.argus.oth.cases.management.model.Claim",
		"staging.model.name=com.argus.oth.cases.management.model.StagingClaim"
	},
	service = AopService.class
)
public class ClaimLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingClaim> {

	@Override
	public boolean validate(StagingClaim stagingClaim) {
		long claimId = stagingClaim.getExternalClaimId();

		if ((claimId == 0L) || blankNullOrNullString(stagingClaim.getClaimRef())) {
			logError("Missing required field for " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date serviceFrom = parseDate_yyyyMMddHHmmsss(stagingClaim.getServiceFrom());

		if (dateParseFailed(serviceFrom)) {
			logError("Error parsing serviceFrom, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date serviceThru = parseDate_yyyyMMddHHmmsss(stagingClaim.getServiceThru());

		if (dateParseFailed(serviceThru)) {
			logError("Error parsing serviceThru, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date tpmReceivedDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getTpmReceivedDate());

		if (dateParseFailed(tpmReceivedDate)) {
			logError("Error parsing tpmReceivedDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date paidDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getPaidDate());

		if (dateParseFailed(paidDate)) {
			logError("Error parsing paidDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getExternalModifiedDate());

		if (dateParseFailed(modifiedDate)) {
			logError("Error parsing modifiedDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getExternalCreatedDate());

		if (dateParseFailed(createdDate)) {
			logError("Error parsing createdDate, " + getEntityName() + " ID " + claimId + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "Claim";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) throws Exception {
		_load(randomString);

		return true;
	}

	private void _load(String randomString) throws Exception {
		int count = _stagingClaimLocalService.getStagingClaimsCount();

		int pages = count / OTHConstants.LIST_MAX_SIZE;

		logInfo("Loading " + pages + " pages of " + OTHConstants.LIST_MAX_SIZE);

		try (Connection connection = DataAccess.getConnection();
			PreparedStatement ps = connection.prepareStatement(BulkHelper.SQL_INSERT_CLAIMS)) {

			for (int i = 0; i <= pages; i++) {
				int start = i * OTHConstants.LIST_MAX_SIZE;

				int end = start + OTHConstants.LIST_MAX_SIZE;

				List<StagingClaim> stagingClaims = _stagingClaimLocalService.getStagingClaims(start, end);

				for (StagingClaim stagingClaim : stagingClaims) {
					_upsertClaim(stagingClaim, randomString, ps);
				}

				ps.executeBatch();

				logInfo(end + " records loaded");
			}
		}
		finally {
			CacheRegistryUtil.clear();
		}
	}

	private void _upsertClaim(StagingClaim stagingClaim, String randomString, PreparedStatement ps) throws Exception {
		long externalClaimId = stagingClaim.getExternalClaimId();

		logDebug("Upserting " + getEntityName() + " (ID: " + externalClaimId + ")");

		Date serviceFrom = parseDate_yyyyMMddHHmmsss(stagingClaim.getServiceFrom());
		Date serviceThru = parseDate_yyyyMMddHHmmsss(stagingClaim.getServiceThru());
		Date tpmReceivedDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getTpmReceivedDate());
		Date paidDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getPaidDate());
		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getExternalModifiedDate());
		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingClaim.getExternalCreatedDate());

		if (!validate(stagingClaim)) {
			logError(getEntityName() + " ID " + externalClaimId + " invalid, skipping upsert");

			return;
		}

		ps.setLong(1, stagingClaim.getExternalClaimId());
		ps.setLong(2, getGroupId());
		ps.setLong(3, PortalUtil.getDefaultCompanyId());
		ps.setDate(4, BulkHelper.getSQLDate(createdDate));
		ps.setDate(5, BulkHelper.getSQLDate(modifiedDate));
		ps.setLong(6, stagingClaim.getExternalClaimId());
		ps.setString(7, stagingClaim.getClaimRef());
		ps.setString(8, stagingClaim.getAuthorizationNumber());
		ps.setDate(9, BulkHelper.getSQLDate(serviceFrom));
		ps.setDate(10, BulkHelper.getSQLDate(serviceThru));
		ps.setString(11, stagingClaim.getProvider());
		ps.setString(12, stagingClaim.getPrioritizedBill());
		ps.setString(13, stagingClaim.getDiagCodesCombined());
		ps.setString(14, stagingClaim.getProviderState());
		ps.setDate(15, BulkHelper.getSQLDate(tpmReceivedDate));
		ps.setLong(16, stagingClaim.getClaimTurnaround());
		ps.setString(17, stagingClaim.getBillType());
		ps.setString(18, stagingClaim.getProviderNetwork());
		ps.setString(19, stagingClaim.getRepricedNetwork());
		ps.setLong(20, stagingClaim.getStatusSortOrder());
		ps.setDate(21, BulkHelper.getSQLDate(paidDate));
		ps.setDouble(22, stagingClaim.getPaidAmount());
		ps.setString(23, stagingClaim.getClaimStatus());
		ps.setString(24, randomString);

		ps.addBatch();
	}

	@Reference
	private StagingClaimLocalService _stagingClaimLocalService;

}