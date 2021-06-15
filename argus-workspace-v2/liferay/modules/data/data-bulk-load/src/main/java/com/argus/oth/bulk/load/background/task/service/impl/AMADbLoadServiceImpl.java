package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.account.management.model.AMAnalyticsDB;
import com.argus.oth.account.management.model.StagingAMAnalyticsDB;
import com.argus.oth.account.management.service.AMAnalyticsDBLocalService;
import com.argus.oth.account.management.service.StagingAMAnalyticsDBLocalService;
import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.account.management.model.AMAnalyticsDB",
		"staging.model.name=com.argus.oth.account.management.model.StagingAMAnalyticsDB"
	},
	service = AopService.class
)
public class AMADbLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingAMAnalyticsDB> {

	@Override
	public boolean validate(StagingAMAnalyticsDB stagingAMAnalyticsDB) {
		return true;
	}

	@Override
	protected String getEntityName() {
		return "AMAnalyticsDB";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingAMAnalyticsDB> stagingAMAnalyticsDBList =
			_stagingAMAnalyticsDBLocalService.getStagingAMAnalyticsDBs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		_deleteMain();

		_counterLocalService.reset(AMAnalyticsDB.class.getName());

		for (StagingAMAnalyticsDB stagingAMAnalyticsDB : stagingAMAnalyticsDBList) {
			_add(stagingAMAnalyticsDB);
		}

		return true;
	}

	private void _add(StagingAMAnalyticsDB stagingAMAnalyticsDB) {
		Client client = _getClient(stagingAMAnalyticsDB.getClientId());

		if (client == null) {
			logError(
				"Unable to look up Client ID based on External Client PK " + stagingAMAnalyticsDB.getClientId() +
					", skipping upsert");

			return;
		}

		_amAnalyticsDbLocalService.add(
			getGroupId(), client.getExternalClientId(), stagingAMAnalyticsDB.getSavingsPercent(),
			stagingAMAnalyticsDB.getChargedAmount(), stagingAMAnalyticsDB.getRepricedAmount(),
			stagingAMAnalyticsDB.getAvgDownTime(), stagingAMAnalyticsDB.getAvgSpeedOfAnswer(),
			stagingAMAnalyticsDB.getAbandonmentRate(), stagingAMAnalyticsDB.getClaimsTurnaround(),
			stagingAMAnalyticsDB.getDownTimeGoal(), stagingAMAnalyticsDB.getSpeedOfAnswerGoal(),
			stagingAMAnalyticsDB.getAbandonmentRateGoal(), stagingAMAnalyticsDB.getClaimsTurnaroundGoal());
	}

	private void _deleteMain() {
		_amAnalyticsDbLocalService.deleteAll();
	}

	private Client _getClient(long externalClientPk) {
		return _clientLocalService.fetchClientByExternalClientPk(externalClientPk);
	}

	@Reference
	private AMAnalyticsDBLocalService _amAnalyticsDbLocalService;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private StagingAMAnalyticsDBLocalService _stagingAMAnalyticsDBLocalService;

}