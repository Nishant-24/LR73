package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.account.management.model.StagingAMAnalyticsDB;
import com.argus.oth.account.management.service.StagingAMAnalyticsDBLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = AMADbFileLoadStagingService.class)
public class AMADbFileLoadStagingService extends BaseFileLoadStagingService<StagingAMAnalyticsDB> {

	@Override
	public void cleanup() {
		_stagingAMAnalyticsDBLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "AMAnalyticsDB";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClientID"
		).put(
			1, "SavingsPercent"
		).put(
			2, "ChargedAmount"
		).put(
			3, "RepricedAmount"
		).put(
			4, "AvgDownTime"
		).put(
			5, "AvgSpeedofAnswer"
		).put(
			6, "AbandonmentRate"
		).put(
			7, "ClaimsTurnaround"
		).put(
			8, "DownTimeGoal"
		).put(
			9, "SpeedofAnswerGoal"
		).put(
			10, "AbandonmentRateGoal"
		).put(
			getMaxFieldArrayPosition(), "ClaimsTurnaroundGoal"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 12;
	}

	@Override
	protected StagingAMAnalyticsDB getStagingModel(String[] fields) {
		StagingAMAnalyticsDB stagingAMAnalyticsDb = _stagingAMAnalyticsDBLocalService.createStagingAMAnalyticsDB(0);

		stagingAMAnalyticsDb.setClientId(GetterUtil.getLong(fields[0]));
		stagingAMAnalyticsDb.setSavingsPercent(GetterUtil.getDouble(fields[1]));
		stagingAMAnalyticsDb.setChargedAmount(GetterUtil.getDouble(fields[2]));
		stagingAMAnalyticsDb.setRepricedAmount(GetterUtil.getDouble(fields[3]));
		stagingAMAnalyticsDb.setAvgDownTime(GetterUtil.getDouble(fields[4]));
		stagingAMAnalyticsDb.setAvgSpeedOfAnswer(GetterUtil.getDouble(fields[5]));
		stagingAMAnalyticsDb.setAbandonmentRate(GetterUtil.getDouble(fields[6]));
		stagingAMAnalyticsDb.setClaimsTurnaround(GetterUtil.getLong(fields[7]));
		stagingAMAnalyticsDb.setDownTimeGoal(GetterUtil.getDouble(fields[8]));
		stagingAMAnalyticsDb.setSpeedOfAnswerGoal(GetterUtil.getDouble(fields[9]));
		stagingAMAnalyticsDb.setAbandonmentRateGoal(GetterUtil.getDouble(fields[10]));
		stagingAMAnalyticsDb.setClaimsTurnaroundGoal(GetterUtil.getDouble(fields[11]));

		return stagingAMAnalyticsDb;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingAMAnalyticsDB.class.getName();
	}

	@Override
	protected void insert(StagingAMAnalyticsDB stagingAMAnalyticsDb) {
		_stagingAMAnalyticsDBLocalService.add(
			stagingAMAnalyticsDb.getClientId(), stagingAMAnalyticsDb.getSavingsPercent(),
			stagingAMAnalyticsDb.getChargedAmount(), stagingAMAnalyticsDb.getRepricedAmount(),
			stagingAMAnalyticsDb.getAvgDownTime(), stagingAMAnalyticsDb.getAvgSpeedOfAnswer(),
			stagingAMAnalyticsDb.getAbandonmentRate(), stagingAMAnalyticsDb.getClaimsTurnaround(),
			stagingAMAnalyticsDb.getDownTimeGoal(), stagingAMAnalyticsDb.getSpeedOfAnswerGoal(),
			stagingAMAnalyticsDb.getAbandonmentRateGoal(), stagingAMAnalyticsDb.getClaimsTurnaroundGoal());
	}

	@Reference
	private StagingAMAnalyticsDBLocalService _stagingAMAnalyticsDBLocalService;

}