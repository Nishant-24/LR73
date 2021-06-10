package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.account.management.model.StagingAMATelephony;
import com.argus.oth.account.management.service.StagingAMATelephonyLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = AMATelephonyFileLoadStagingService.class)
public class AMATelephonyFileLoadStagingService extends BaseFileLoadStagingService<StagingAMATelephony> {

	@Override
	public void cleanup() {
		_stagingAMATelephonyLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "AMAnalyticsTelephony";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClientID"
		).put(
			1, "Date"
		).put(
			2, "AvgDownTime"
		).put(
			3, "AvgSpeedofAnswer"
		).put(
			4, "AbandonmentRate"
		).put(
			5, "DownTimeGoal"
		).put(
			6, "SpeedAnswerGoal"
		).put(
			7, "AbandonmentRateGoal"
		).put(
			8, "OverallAvgDownTime"
		).put(
			9, "OverallAvgSpeedofAnswer"
		).put(
			getMaxFieldArrayPosition(), "OverallAvgAbandonmentRate"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 11;
	}

	@Override
	protected StagingAMATelephony getStagingModel(String[] fields) {
		StagingAMATelephony stagingAMATelephony = _stagingAMATelephonyLocalService.createStagingAMATelephony(0);

		stagingAMATelephony.setClientId(GetterUtil.getLong(fields[0]));
		stagingAMATelephony.setAmAnalyticsTelephonyDate(fields[1]);
		stagingAMATelephony.setAvgDownTime(GetterUtil.getDouble(fields[2]));
		stagingAMATelephony.setAvgSpeedOfAnswer(GetterUtil.getDouble(fields[3]));
		stagingAMATelephony.setAbandonmentRate(GetterUtil.getDouble(fields[4]));
		stagingAMATelephony.setDownTimeGoal(GetterUtil.getDouble(fields[5]));
		stagingAMATelephony.setSpeedAnswerGoal(GetterUtil.getDouble(fields[6]));
		stagingAMATelephony.setAbandonmentRateGoal(GetterUtil.getDouble(fields[7]));
		stagingAMATelephony.setOverallAvgDownTime(GetterUtil.getDouble(fields[8]));
		stagingAMATelephony.setOverallAvgSpeedOfAnswer(GetterUtil.getDouble(fields[9]));
		stagingAMATelephony.setOverallAvgAbandonmentRate(GetterUtil.getDouble(fields[10]));

		return stagingAMATelephony;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingAMATelephony.class.getName();
	}

	@Override
	protected void insert(StagingAMATelephony stagingAMATelephony) {
		_stagingAMATelephonyLocalService.add(
			stagingAMATelephony.getClientId(), stagingAMATelephony.getAmAnalyticsTelephonyDate(),
			stagingAMATelephony.getAvgDownTime(), stagingAMATelephony.getAvgSpeedOfAnswer(),
			stagingAMATelephony.getAbandonmentRate(), stagingAMATelephony.getDownTimeGoal(),
			stagingAMATelephony.getSpeedAnswerGoal(), stagingAMATelephony.getAbandonmentRateGoal(),
			stagingAMATelephony.getOverallAvgDownTime(), stagingAMATelephony.getOverallAvgSpeedOfAnswer(),
			stagingAMATelephony.getOverallAvgAbandonmentRate());
	}

	@Reference
	private StagingAMATelephonyLocalService _stagingAMATelephonyLocalService;

}