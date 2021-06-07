package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;
import com.argus.oth.account.management.service.StagingAMAnalyticsClaimLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = AMAClaimFileLoadStagingService.class)
public class AMAClaimFileLoadStagingService extends BaseFileLoadStagingService<StagingAMAnalyticsClaim> {

	@Override
	public void cleanup() {
		_stagingAMAnalyticsClaimLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "AMAnalyticsClaim";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClientID"
		).put(
			1, "Date"
		).put(
			2, "AvgClaimTurnAround"
		).put(
			3, "MinClaimTurnAround"
		).put(
			4, "MaxClaimTurnAround"
		).put(
			5, "ClaimTurnaroundGoal"
		).put(
			getMaxFieldArrayPosition(), "OverallAvgClaimTurnaround"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 7;
	}

	@Override
	protected StagingAMAnalyticsClaim getStagingModel(String[] fields) {
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim =
			_stagingAMAnalyticsClaimLocalService.createStagingAMAnalyticsClaim(0);

		stagingAMAnalyticsClaim.setClientId(GetterUtil.getLong(fields[0]));
		stagingAMAnalyticsClaim.setAmAnalyticsClaimDate(fields[1]);
		stagingAMAnalyticsClaim.setAvgClaimTurnAround(GetterUtil.getInteger(fields[2]));
		stagingAMAnalyticsClaim.setMinClaimTurnAround(GetterUtil.getInteger(fields[3]));
		stagingAMAnalyticsClaim.setMaxClaimTurnAround(GetterUtil.getInteger(fields[4]));
		stagingAMAnalyticsClaim.setClaimTurnAroundGoal(GetterUtil.getInteger(fields[5]));
		stagingAMAnalyticsClaim.setOverallAvgClaimTurnAround(GetterUtil.getDouble(fields[6]));

		return stagingAMAnalyticsClaim;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingAMAnalyticsClaim.class.getName();
	}

	@Override
	protected void insert(StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {
		_stagingAMAnalyticsClaimLocalService.add(
			stagingAMAnalyticsClaim.getClientId(), stagingAMAnalyticsClaim.getAmAnalyticsClaimDate(),
			stagingAMAnalyticsClaim.getAvgClaimTurnAround(), stagingAMAnalyticsClaim.getMinClaimTurnAround(),
			stagingAMAnalyticsClaim.getMaxClaimTurnAround(), stagingAMAnalyticsClaim.getClaimTurnAroundGoal(),
			stagingAMAnalyticsClaim.getOverallAvgClaimTurnAround());
	}

	@Reference
	private StagingAMAnalyticsClaimLocalService _stagingAMAnalyticsClaimLocalService;

}