package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingClaimDetail;
import com.argus.oth.cases.management.service.StagingClaimDetailLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ClaimDetailFileLoadStagingService.class)
public class ClaimDetailFileLoadStagingService extends BaseFileLoadStagingService<StagingClaimDetail> {

	@Override
	public void cleanup() {
		_stagingClaimDetailLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "ClaimDetail";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "LineID"
		).put(
			1, "ClaimID"
		).put(
			2, "ServiceFrom"
		).put(
			3, "ProcedureCode"
		).put(
			4, "ChargedAmount"
		).put(
			5, "PaidAmount"
		).put(
			6, "ClaimAmount"
		).put(
			7, "RepricedAmount"
		).put(
			8, "SavingsAmount"
		).put(
			10, "LineStatus"
		).put(
			11, "ModifiedDate"
		).put(
			12, "CreatedDate"
		).put(
			13, "ResultCodes"
		).put(
			14, "Units"
		).put(
			15, "Coverage"
		).put(
			16, "PaidDate"
		).put(
			18, "RevCode"
		).put(
			getMaxFieldArrayPosition(), "ServiceThru"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 20;
	}

	@Override
	protected StagingClaimDetail getStagingModel(String[] fields) {
		StagingClaimDetail stagingClaimDetail = _stagingClaimDetailLocalService.createStagingClaimDetail(0);

		stagingClaimDetail.setLineId(GetterUtil.getLong(fields[0]));
		stagingClaimDetail.setExternalClaimId(GetterUtil.getLong(fields[1]));
		stagingClaimDetail.setServiceFrom(fields[2]);
		stagingClaimDetail.setServiceThru(fields[19]);
		stagingClaimDetail.setResultCodes(fields[13]);
		stagingClaimDetail.setProcedureCode(fields[3]);
		stagingClaimDetail.setChargedAmount(GetterUtil.getDouble(fields[4]));
		stagingClaimDetail.setRepricedAmount(GetterUtil.getDouble(fields[7]));
		stagingClaimDetail.setClaimAmount(GetterUtil.getDouble(fields[6]));
		stagingClaimDetail.setPaidDate(fields[16]);
		stagingClaimDetail.setPaidAmount(GetterUtil.getDouble(fields[5]));
		stagingClaimDetail.setSavingsAmount(GetterUtil.getDouble(fields[8]));
		stagingClaimDetail.setUnits(GetterUtil.getInteger(fields[14]));
		stagingClaimDetail.setCoverage(fields[15]);
		stagingClaimDetail.setLineStatus(fields[10]);
		stagingClaimDetail.setRevCode(fields[18]);
		stagingClaimDetail.setExternalModifiedDate(fields[11]);
		stagingClaimDetail.setExternalCreatedDate(fields[12]);

		return stagingClaimDetail;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingClaimDetail.class.getName();
	}

	@Override
	protected void insert(StagingClaimDetail stagingClaimDetail) {
		_stagingClaimDetailLocalService.addStagingClaimDetail(
			stagingClaimDetail.getLineId(), stagingClaimDetail.getExternalClaimId(),
			stagingClaimDetail.getServiceFrom(), stagingClaimDetail.getServiceThru(),
			stagingClaimDetail.getResultCodes(), stagingClaimDetail.getProcedureCode(),
			stagingClaimDetail.getChargedAmount(), stagingClaimDetail.getRepricedAmount(),
			stagingClaimDetail.getClaimAmount(), stagingClaimDetail.getPaidDate(), stagingClaimDetail.getPaidAmount(),
			stagingClaimDetail.getSavingsAmount(), stagingClaimDetail.getUnits(), stagingClaimDetail.getCoverage(),
			stagingClaimDetail.getLineStatus(), stagingClaimDetail.getRevCode(),
			stagingClaimDetail.getExternalModifiedDate(), stagingClaimDetail.getExternalCreatedDate());
	}

	@Reference
	private StagingClaimDetailLocalService _stagingClaimDetailLocalService;

}