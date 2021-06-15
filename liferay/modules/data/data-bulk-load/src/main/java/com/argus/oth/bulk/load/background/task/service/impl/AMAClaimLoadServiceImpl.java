package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.account.management.model.AMAnalyticsClaim;
import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;
import com.argus.oth.account.management.service.AMAnalyticsClaimLocalService;
import com.argus.oth.account.management.service.StagingAMAnalyticsClaimLocalService;
import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.IndexStatusManagerThreadLocal;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.PortalUtil;

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
		"model.name=com.argus.oth.account.management.model.AMAnalyticsClaim",
		"staging.model.name=com.argus.oth.account.management.model.StagingAMAnalyticsClaim"
	},
	service = AopService.class
)
public class AMAClaimLoadServiceImpl
	extends BaseLoadService implements AopService, LoadService<StagingAMAnalyticsClaim> {

	@Override
	public boolean validate(StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {
		Date amAnalyticsClaimDate = parseDate_yyyyMMddHHmmsss(stagingAMAnalyticsClaim.getAmAnalyticsClaimDate());

		if (dateParseFailed(amAnalyticsClaimDate)) {
			logError(
				"Error parsing amAnalyticsClaimDate, " + getEntityName() + " ID " +
					stagingAMAnalyticsClaim.getStagingAMAnalyticsClaimId() + ", skipping upsert");

			return false;
		}

		return true;
	}

	protected String getEntityClassName() {
		return AMAnalyticsClaim.class.getName();
	}

	@Override
	protected String getEntityName() {
		return "AMAnalyticsClaim";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingAMAnalyticsClaim> stagingAMAnalyticsClaims =
			_stagingAMAnalyticsClaimLocalService.getStagingAMAnalyticsClaims(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		_deleteMain();

		_counterLocalService.reset(AMAnalyticsClaim.class.getName());

		IndexStatusManagerThreadLocal.setIndexReadOnly(true);

		for (StagingAMAnalyticsClaim stagingAMAnalyticsClaim : stagingAMAnalyticsClaims) {
			_add(stagingAMAnalyticsClaim);
		}

		IndexStatusManagerThreadLocal.setIndexReadOnly(false);

		try {
			long companyId = PortalUtil.getDefaultCompanyId();

			_amAnalyticsClaimLocalService.reindex(companyId);
		}
		catch (SearchException se) {
			logError("Failed to reindex" + getEntityName(), se);
		}

		return true;
	}

	@Override
	protected boolean reIndexOnLoad() {
		return true;
	}

	private void _add(StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {
		Date amAnalyticsClaimDate = parseDate_yyyyMMddHHmmsss(stagingAMAnalyticsClaim.getAmAnalyticsClaimDate());

		if (!validate(stagingAMAnalyticsClaim)) {
			logError(
				getEntityName() + " ID " + stagingAMAnalyticsClaim.getStagingAMAnalyticsClaimId() +
					" invalid, skipping upsert");

			return;
		}

		Client client = _getClient(stagingAMAnalyticsClaim.getClientId());

		if (client == null) {
			logError(
				"Unable to look up Client ID based on External Client PK " + stagingAMAnalyticsClaim.getClientId() +
					", skipping upsert");

			return;
		}

		_amAnalyticsClaimLocalService.add(
			getGroupId(), client.getExternalClientId(), amAnalyticsClaimDate,
			stagingAMAnalyticsClaim.getAvgClaimTurnAround(), stagingAMAnalyticsClaim.getMinClaimTurnAround(),
			stagingAMAnalyticsClaim.getMaxClaimTurnAround(), stagingAMAnalyticsClaim.getClaimTurnAroundGoal(),
			stagingAMAnalyticsClaim.getOverallAvgClaimTurnAround());
	}

	private void _deleteMain() {
		_amAnalyticsClaimLocalService.deleteAll();
	}

	private Client _getClient(long externalClientPk) {
		return _clientLocalService.fetchClientByExternalClientPk(externalClientPk);
	}

	@Reference
	private AMAnalyticsClaimLocalService _amAnalyticsClaimLocalService;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private StagingAMAnalyticsClaimLocalService _stagingAMAnalyticsClaimLocalService;

}