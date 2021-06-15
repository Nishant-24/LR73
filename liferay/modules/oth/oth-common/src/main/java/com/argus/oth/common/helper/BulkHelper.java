package com.argus.oth.common.helper;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Date;
import java.util.Objects;

/**
 * @author Davy
 */
public abstract class BulkHelper {

	public static final String SQL_INSERT_CASES =
		"REPLACE INTO OTH_Cases " + "(uuid_, caseId, groupId, companyId, createDate, modifiedDate, externalCaseId, " +
			"clientId, clientName, clientGroupId, caseNumber, caseStartDate, caseEndDate, memberId, " +
			"primaryDiagCode, primaryCode, status, estimateEntryDate, caseManager, consentReceivedDate, medicalPlan, " +
			"costEstimate, lastUpdated, externalCreatedDate, chargedAmount, paidAmount, repricedAmount, " +
			"savingsAmount, savingsPercent, treatingPhysician, primaryFacility, rowProcessed) " +
			"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String SQL_INSERT_CLAIM_ANALYTICS =
		"INSERT INTO OTH_ClaimAnalytics (claimAnalyticsId, " +
			"groupId, companyId, createDate, modifiedDate, externalClientId, clientName, claimNumber, externalCaseId, " +
			"claimStatus, receivedDate, serviceDate, paidDate, externalMemberId, memberName, providerName, billType, " +
			"primaryDiagnosis, chargedAmount, paidAmount, repricedAmount, savingsAmount, chargedPercent, " +
			"repricedPercent, savingsPercent, chargedRange, paidRange, repricedRange, savingsRange, claimAging, " +
			"procedureCodes, resultCodes, diagnosisCodes, country, state_, financialExposure, repricedNetwork, " +
			"clientGroupName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String SQL_INSERT_CLAIM_DETAIL =
		"REPLACE INTO OTH_ClaimDetail (claimDetailId, groupId, " +
			"companyId, createDate, modifiedDate, lineId, externalClaimId, serviceFrom, serviceThru, resultCodes, " +
			"procedureCode, chargedAmount, repricedAmount, claimAmount, paidDate, paidAmount, savingsAmount, units, " +
			"coverage, lineStatus, revCode, rowProcessed) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String SQL_INSERT_CLAIMS =
		"REPLACE INTO OTH_Claim (claimId, groupId, companyId, createDate, " +
			"modifiedDate, externalClaimId, claimRef, authorizationNumber, serviceFrom, serviceThru, provider, " +
			"prioritizedBill, diagCodesCombined, providerState, tpmReceivedDate, claimTurnaround, billType, " +
			"providerNetwork, repricedNetwork, statusSortOrder, paidDate, paidAmount, claimStatus, rowProcessed) VALUES " +
			"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static int bulkUpdateProcessed(Session session, String table, boolean value, boolean criteria) {
		SQLQuery query = session.createSQLQuery(String.format(_UPDATE_SQL, table));
		query.setBoolean(0, value);
		query.setBoolean(1, criteria);

		int rows = query.executeUpdate();

		if (_log.isInfoEnabled()) {
			_log.info(rows + " rows updated from " + table);
		}

		return rows;
	}

	public static int bulkDelete(Session session, String table, String criteria) {
		return _bulkDelete(session, String.format(_DELETE_SQL_ROW_PROCESSED, table), table, criteria);
	}

	public static int bulkDelete(Session session, String table, String rowProcessed, String status) {
		return _bulkDelete(session, String.format(_DELETE_SQL_STATUS, table), table, rowProcessed, status);
	}

	public static int bulkDeleteAll(Session session, String table) {
		return _bulkDelete(session, String.format(_TRUNCATE_SQL, table), table);
	}

	public static Date getSQLDate(java.util.Date date) {
		Date sqlDate = null;

		if (Objects.nonNull(date)) {
			sqlDate = new Date(date.getTime());
		}

		return sqlDate;
	}

	private static int _bulkDelete(Session session, String sql, String tableName, String... criteria) {
		SQLQuery query = session.createSQLQuery(sql);

		int pos = 0;

		for (String c : criteria) {
			query.setString(pos++, c);
		}

		int rows = query.executeUpdate();

		if (_log.isInfoEnabled()) {
			_log.info(rows + " rows deleted from " + tableName);
		}

		return rows;
	}

	private static final String _TRUNCATE_SQL = "TRUNCATE TABLE %s ";

	private static final String _UPDATE_SQL = "UPDATE %s SET rowProcessed = ? WHERE rowProcessed = ?";

	private static final String _DELETE_SQL = "DELETE FROM %s";

	private static final String _DELETE_SQL_ROW_PROCESSED = _DELETE_SQL + " WHERE rowProcessed != ?";

	private static final String _DELETE_SQL_STATUS = _DELETE_SQL_ROW_PROCESSED + " and processStatus != ?";

	private static final Log _log = LogFactoryUtil.getLog(BulkHelper.class);

}