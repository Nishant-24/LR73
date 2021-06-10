package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.account.management.model.AMAnalyticsTelephony;
import com.argus.oth.account.management.model.StagingAMATelephony;
import com.argus.oth.account.management.service.AMAnalyticsTelephonyLocalService;
import com.argus.oth.account.management.service.StagingAMATelephonyLocalService;
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
		"model.name=com.argus.oth.account.management.model.AMAnalyticsTelephony",
		"staging.model.name=com.argus.oth.account.management.model.StagingAMATelephony"
	},
	service = AopService.class
)
public class AMATelephonyLoadServiceImpl
	extends BaseLoadService implements AopService, LoadService<StagingAMATelephony> {

	@Override
	public boolean validate(StagingAMATelephony stagingAMATelephony) {
		Date amAnalyticsTelephonyDate = parseDate_yyyyMMddHHmmsss(stagingAMATelephony.getAmAnalyticsTelephonyDate());

		if (dateParseFailed(amAnalyticsTelephonyDate)) {
			logError(
				"Error parsing amAnalyticsTelephonyDate, " + getEntityName() + " ID " +
					stagingAMATelephony.getStagingAMATelephonyId() + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityClassName() {
		return AMAnalyticsTelephony.class.getName();
	}

	@Override
	protected String getEntityName() {
		return "AMAnalyticsTelephony";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingAMATelephony> stagingAMATelephonyList = _stagingAMATelephonyLocalService.getStagingAMATelephonies(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		_deleteMain();

		_counterLocalService.reset(AMAnalyticsTelephony.class.getName());

		IndexStatusManagerThreadLocal.setIndexReadOnly(true);

		for (StagingAMATelephony stagingAMATelephony : stagingAMATelephonyList) {
			_add(stagingAMATelephony);
		}

		IndexStatusManagerThreadLocal.setIndexReadOnly(false);

		try {
			long companyId = PortalUtil.getDefaultCompanyId();

			_amAnalyticsTelephonyLocalService.reindex(companyId);
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

	private void _add(StagingAMATelephony stagingAMATelephony) {
		Date amAnalyticsTelephonyDate = parseDate_yyyyMMddHHmmsss(stagingAMATelephony.getAmAnalyticsTelephonyDate());

		if (!validate(stagingAMATelephony)) {
			logError(
				getEntityName() + " ID " + stagingAMATelephony.getStagingAMATelephonyId() +
					" invalid, skipping upsert");

			return;
		}

		Client client = _getClient(stagingAMATelephony.getClientId());

		if (client == null) {
			logError(
				"Unable to look up Client ID based on External Client PK " + stagingAMATelephony.getClientId() +
					", skipping upsert");

			return;
		}

		_amAnalyticsTelephonyLocalService.add(
			getGroupId(), client.getExternalClientId(), amAnalyticsTelephonyDate, stagingAMATelephony.getAvgDownTime(),
			stagingAMATelephony.getAvgSpeedOfAnswer(), stagingAMATelephony.getAbandonmentRate(),
			stagingAMATelephony.getDownTimeGoal(), stagingAMATelephony.getSpeedAnswerGoal(),
			stagingAMATelephony.getAbandonmentRateGoal(), stagingAMATelephony.getOverallAvgDownTime(),
			stagingAMATelephony.getOverallAvgSpeedOfAnswer(), stagingAMATelephony.getOverallAvgAbandonmentRate());
	}

	private void _deleteMain() {
		_amAnalyticsTelephonyLocalService.deleteAll();
	}

	private Client _getClient(long externalClientPk) {
		return _clientLocalService.fetchClientByExternalClientPk(externalClientPk);
	}

	@Reference
	private AMAnalyticsTelephonyLocalService _amAnalyticsTelephonyLocalService;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private StagingAMATelephonyLocalService _stagingAMATelephonyLocalService;

}