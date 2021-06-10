package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.cases.management.service.StagingCasesLocalService;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.enums.DataRequestType;

import com.argus.oth.common.helper.BulkHelper;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.IndexStatusManagerThreadLocal;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

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
		"model.name=com.argus.oth.cases.management.model.Cases",
		"staging.model.name=com.argus.oth.cases.management.model.StagingCases"
	},
	service = AopService.class
)
public class CasesLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingCases> {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean load(String randomString) throws Exception {
		Long groupId = getGroupId();

		if (groupId == null) {
			return false;
		}

		IndexStatusManagerThreadLocal.setIndexReadOnly(true);

		_load(randomString, groupId);

		IndexStatusManagerThreadLocal.setIndexReadOnly(false);

		List<Client> clients = _clientLocalService.getClients(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Client client : clients) {
			_dataRequestLocalService.setDataRequestLastUpdatedDate(
				client.getExternalClientId(), 0, 0, DataRequestType.CASES.name());
		}

		try {
			long companyId = PortalUtil.getDefaultCompanyId();

			logInfo("Reindexing Cases");

			_casesLocalService.reindex(companyId);

			logInfo("Reindexing complete");
		}
		catch (SearchException se) {
			logError("Failed to reindex " + getEntityName(), se);
		}

		return true;
	}

	@Override
	public boolean validate(StagingCases stagingCase) {
		Long externalCaseId = parseLong(stagingCase.getExternalCaseId());
		Long externalClientPk = parseLong(stagingCase.getExternalClientPk());
		Long clientGroupId = parseLong(stagingCase.getClientGroupId());
		Date caseStartDate = parseDate_yyyyMMddHHmmsss(stagingCase.getCaseStartDate());
		Long memberId = parseLong(stagingCase.getMemberId());
		Date lastUpdated = parseDate_yyyyMMddHHmmsss(stagingCase.getLastUpdated());
		Date externalCreateDate = parseDate_yyyyMMddHHmmsss(stagingCase.getExternalCreatedDate());
		Double chargedAmount = parseDouble(stagingCase.getChargedAmount());
		Double paidAmount = parseDouble(stagingCase.getPaidAmount());
		Double repricedAmount = parseDouble(stagingCase.getRepricedAmount());
		Double savingsAmount = parseDouble(stagingCase.getSavingsAmount());
		Double savingsPercent = parseDouble(stagingCase.getSavingsPercent());

		return _validateKeys(
			externalCaseId, externalClientPk, clientGroupId, caseStartDate, memberId, lastUpdated, externalCreateDate,
			chargedAmount, paidAmount, repricedAmount, savingsAmount, savingsPercent);
	}

	@Override
	protected String getEntityClassName() {
		return Cases.class.getName();
	}

	@Override
	protected String getEntityName() {
		return "Case";
	}

	@Override
	protected boolean reIndexOnLoad() {
		return true;
	}

	private Client _getClient(long externalClientPk) {
		return _clientLocalService.fetchClientByExternalClientPk(externalClientPk);
	}

	private void _load(String randomString, Long groupId) throws Exception {
		int count = _stagingCasesLocalService.getStagingCasesesCount();

		int pages = count / OTHConstants.LIST_MAX_SIZE;

		logInfo("Loading " + pages + " pages of " + OTHConstants.LIST_MAX_SIZE);

		try (Connection connection = DataAccess.getConnection();
			PreparedStatement ps = connection.prepareStatement(BulkHelper.SQL_INSERT_CASES)) {

			for (int i = 0; i <= pages; i++) {
				int start = i * OTHConstants.LIST_MAX_SIZE;

				int end = start + OTHConstants.LIST_MAX_SIZE;

				List<StagingCases> stagingCasesList = _stagingCasesLocalService.getStagingCasesByRowProcessed(
					false, start, end);

				for (StagingCases stagingCase : stagingCasesList) {
					_upsertCase(groupId, stagingCase, randomString, ps);
				}

				long startTime = System.currentTimeMillis();

				ps.executeBatch();

				long endTime = System.currentTimeMillis();

				logInfo(end + " records loaded; Execute batch " + (endTime - startTime) + " ms");
			}
		}
		finally {
			CacheRegistryUtil.clear();
		}

		_stagingCasesLocalService.updateProcessedStagingCases();
	}

	private void _upsertCase(
			long groupId, StagingCases stagingCase, Long externalCaseId, Long clientId, String clientName,
			Long clientGroupId, Date caseStartDate, Date caseEndDate, Long memberId, Date estimateEntryDate,
			Date consentReceivedDate, String costEstimate, Date lastUpdated, Date externalCreateDate,
			Double chargedAmount, Double paidAmount, Double repricedAmount, Double savingsAmount, Double savingsPercent,
			String treatingPhysician, String primaryFacility, String randomString, PreparedStatement ps)
		throws Exception {

		String uuid = PortalUUIDUtil.generate();

		Date now = new Date();

		java.sql.Date date = new java.sql.Date(now.getTime());

		ps.setString(1, uuid);
		ps.setLong(2, externalCaseId);
		ps.setLong(3, groupId);
		ps.setLong(4, PortalUtil.getDefaultCompanyId());
		ps.setDate(5, date);
		ps.setDate(6, date);
		ps.setLong(7, externalCaseId);
		ps.setLong(8, clientId);
		ps.setString(9, clientName);
		ps.setLong(10, clientGroupId);
		ps.setString(11, stagingCase.getCaseNumber());
		ps.setDate(12, BulkHelper.getSQLDate(caseStartDate));
		ps.setDate(13, BulkHelper.getSQLDate(caseEndDate));
		ps.setLong(14, memberId);
		ps.setString(15, stagingCase.getPrimaryDiagCode());
		ps.setString(16, stagingCase.getPrimaryCode());
		ps.setString(17, stagingCase.getStatus());
		ps.setDate(18, BulkHelper.getSQLDate(estimateEntryDate));
		ps.setString(19, stagingCase.getCaseManager());
		ps.setDate(20, BulkHelper.getSQLDate(consentReceivedDate));
		ps.setString(21, stagingCase.getMedicalPlan());
		ps.setString(22, costEstimate);
		ps.setDate(23, BulkHelper.getSQLDate(lastUpdated));
		ps.setDate(24, BulkHelper.getSQLDate(externalCreateDate));
		ps.setDouble(25, chargedAmount);
		ps.setDouble(26, paidAmount);
		ps.setDouble(27, repricedAmount);
		ps.setDouble(28, savingsAmount);
		ps.setDouble(29, savingsPercent);
		ps.setString(30, treatingPhysician);
		ps.setString(31, primaryFacility);
		ps.setString(32, randomString);

		ps.addBatch();
	}

	private void _upsertCase(long groupId, StagingCases stagingCase, String randomString, PreparedStatement ps)
		throws Exception {

		logDebug(
			"Upserting Case (staging case ID: " + stagingCase.getStagingCaseId() + "; external case ID: " +
				stagingCase.getExternalCaseId() + "; case number: " + stagingCase.getCaseNumber() + ")");

		Long externalCaseId = parseLong(stagingCase.getExternalCaseId());
		Long externalClientPk = parseLong(stagingCase.getExternalClientPk());
		Long clientGroupId = parseLong(stagingCase.getClientGroupId());
		Date caseStartDate = parseDate_yyyyMMddHHmmsss(stagingCase.getCaseStartDate());
		Date caseEndDate = parseDate_yyyyMMddHHmmsss(stagingCase.getCaseEndDate());
		Long memberId = parseLong(stagingCase.getMemberId());
		Date estimateEntryDate = parseDate_yyyyMMddHHmmsss(stagingCase.getEstimateEntryDate());
		Date consentReceivedDate = parseDate_yyyyMMddHHmmsss(stagingCase.getConsentReceivedDate());
		Date lastUpdated = parseDate_yyyyMMddHHmmsss(stagingCase.getLastUpdated());
		Date externalCreateDate = parseDate_yyyyMMddHHmmsss(stagingCase.getExternalCreatedDate());
		Double chargedAmount = parseDouble(stagingCase.getChargedAmount());
		Double paidAmount = parseDouble(stagingCase.getPaidAmount());
		Double repricedAmount = parseDouble(stagingCase.getRepricedAmount());
		Double savingsAmount = parseDouble(stagingCase.getSavingsAmount());
		Double savingsPercent = parseDouble(stagingCase.getSavingsPercent());

		if (!_validateKeys(
				externalCaseId, externalClientPk, clientGroupId, caseStartDate, memberId, lastUpdated,
				externalCreateDate, chargedAmount, paidAmount, repricedAmount, savingsAmount, savingsPercent)) {

			return;
		}

		Client client = _getClient(externalClientPk);

		if (client == null) {
			logError(
				"Unable to look up Client ID and Client Name based on External Client PK " + externalClientPk +
					", skipping upsert");

			return;
		}

		_upsertCase(
			groupId, stagingCase, externalCaseId, client.getExternalClientId(), client.getClientName(), clientGroupId,
			caseStartDate, caseEndDate, memberId, estimateEntryDate, consentReceivedDate, stagingCase.getCostEstimate(),
			lastUpdated, externalCreateDate, chargedAmount, paidAmount, repricedAmount, savingsAmount, savingsPercent,
			stagingCase.getTreatingPhysician(), stagingCase.getPrimaryFacility(), randomString, ps);

		setDataRequestLastUpdatedDate(
			client.getExternalClientId(), externalCaseId, externalCaseId, DataRequestType.CASE);
	}

	private boolean _validateKeys(
		Long externalCaseId, Long externalClientPk, Long clientGroupId, Date caseStartDate, Long memberId,
		Date lastUpdated, Date externalCreateDate, Double chargedAmount, Double paidAmount, Double repricedAmount,
		Double savingsAmount, Double savingsPercent) {

		if ((externalCaseId == null) || (externalClientPk == null) || (clientGroupId == null) ||
			((caseStartDate != null) && (caseStartDate.compareTo(minDate) == 0)) || (memberId == null) ||
			((lastUpdated != null) && (lastUpdated.compareTo(minDate) == 0)) ||
			((externalCreateDate != null) && (externalCreateDate.compareTo(minDate) == 0)) || (chargedAmount == null) ||
			(paidAmount == null) || (repricedAmount == null) || (savingsAmount == null) || (savingsPercent == null)) {

			logError("Failed to parse Case, skipping upsert");

			return false;
		}

		if ((externalCaseId == 0L) || (externalClientPk == 0L) || (memberId == 0L)) {
			logError("Missing required field for Case, skipping upsert");

			return false;
		}

		return true;
	}

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private DataRequestLocalService _dataRequestLocalService;

	@Reference
	private StagingCasesLocalService _stagingCasesLocalService;

}