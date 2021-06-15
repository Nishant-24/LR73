package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.claim.model.StagingClaimAnalytics;
import com.argus.oth.claim.service.StagingClaimAnalyticsLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ClaimAnalyticsFileLoadStagingService.class)
public class ClaimAnalyticsFileLoadStagingService extends BaseFileLoadStagingService<StagingClaimAnalytics> {

	@Override
	public void cleanup() {
		_stagingClaimAnalyticsLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "ClaimAnalytics";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClientId"
		).put(
			1, "ClientName"
		).put(
			2, "ClaimNumber"
		).put(
			3, "CaseId"
		).put(
			4, "ClaimStatus"
		).put(
			5, "ReceivedDate"
		).put(
			6, "ServiceDate"
		).put(
			7, "PaidDate"
		).put(
			8, "MemberId"
		).put(
			9, "MemberName"
		).put(
			10, "ProviderName"
		).put(
			11, "BillType"
		).put(
			12, "PrimaryDiagnosis"
		).put(
			13, "ChargedAmount"
		).put(
			14, "PaidAmount"
		).put(
			15, "RepricedAmount"
		).put(
			16, "SavingsAmount"
		).put(
			17, "ChargedPercent"
		).put(
			18, "RepricedPercent"
		).put(
			19, "SavingsPercent"
		).put(
			20, "ChargedRange"
		).put(
			21, "PaidRange"
		).put(
			22, "RepricedRange"
		).put(
			23, "SavingsRange"
		).put(
			24, "ClaimAging"
		).put(
			25, "ProcedureCodes"
		).put(
			26, "ResultCodes"
		).put(
			27, "DiagnosisCodes"
		).put(
			28, "Country"
		).put(
			29, "State"
		).put(
			30, "FinancialExposure"
		).put(
			31, "RepricedNetwork"
		).put(
			getMaxFieldArrayPosition(), "ClientGroupName"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 33;
	}

	@Override
	protected StagingClaimAnalytics getStagingModel(String[] fields) {
		StagingClaimAnalytics stagingClaimAnalytics = _stagingClaimAnalyticsLocalService.createStagingClaimAnalytics(0);

		stagingClaimAnalytics.setExternalClientId(GetterUtil.getLong(fields[0]));
		stagingClaimAnalytics.setClientName(fields[1]);
		stagingClaimAnalytics.setClaimNumber(fields[2]);
		stagingClaimAnalytics.setExternalCaseId(GetterUtil.getLong(fields[3]));
		stagingClaimAnalytics.setClaimStatus(fields[4]);
		stagingClaimAnalytics.setReceivedDate(fields[5]);
		stagingClaimAnalytics.setServiceDate(fields[6]);
		stagingClaimAnalytics.setPaidDate(fields[7]);
		stagingClaimAnalytics.setExternalMemberId(GetterUtil.getLong(fields[8]));
		stagingClaimAnalytics.setMemberName(fields[9]);
		stagingClaimAnalytics.setProviderName(fields[10]);
		stagingClaimAnalytics.setBillType(fields[11]);
		stagingClaimAnalytics.setPrimaryDiagnosis(fields[12]);
		stagingClaimAnalytics.setChargedAmount(GetterUtil.getDouble(fields[13]));
		stagingClaimAnalytics.setPaidAmount(GetterUtil.getDouble(fields[14]));
		stagingClaimAnalytics.setRepricedAmount(GetterUtil.getDouble(fields[15]));
		stagingClaimAnalytics.setSavingsAmount(GetterUtil.getDouble(fields[16]));
		stagingClaimAnalytics.setChargedPercent(GetterUtil.getDouble(fields[17]));
		stagingClaimAnalytics.setRepricedPercent(GetterUtil.getDouble(fields[18]));
		stagingClaimAnalytics.setSavingsPercent(GetterUtil.getDouble(fields[19]));
		stagingClaimAnalytics.setChargedRange(fields[20]);
		stagingClaimAnalytics.setPaidRange(fields[21]);
		stagingClaimAnalytics.setRepricedRange(fields[22]);
		stagingClaimAnalytics.setSavingsRange(fields[23]);
		stagingClaimAnalytics.setClaimAging(GetterUtil.getLong(fields[24]));
		stagingClaimAnalytics.setProcedureCodes(fields[25]);
		stagingClaimAnalytics.setResultCodes(fields[26]);
		stagingClaimAnalytics.setDiagnosisCodes(fields[27]);
		stagingClaimAnalytics.setCountry(fields[28]);
		stagingClaimAnalytics.setState(fields[29]);
		stagingClaimAnalytics.setFinancialExposure(GetterUtil.getDouble(fields[30]));
		stagingClaimAnalytics.setRepricedNetwork(fields[31]);
		stagingClaimAnalytics.setClientGroupName(fields[32]);

		return stagingClaimAnalytics;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingClaimAnalytics.class.getName();
	}

	@Override
	protected void insert(StagingClaimAnalytics stagingClaimAnalytics) {
		_stagingClaimAnalyticsLocalService.addStagingClaimAnalytics(
			stagingClaimAnalytics.getExternalClientId(), stagingClaimAnalytics.getClientName(),
			stagingClaimAnalytics.getClaimNumber(), stagingClaimAnalytics.getExternalCaseId(),
			stagingClaimAnalytics.getClaimStatus(), stagingClaimAnalytics.getReceivedDate(),
			stagingClaimAnalytics.getServiceDate(), stagingClaimAnalytics.getPaidDate(),
			stagingClaimAnalytics.getExternalMemberId(), stagingClaimAnalytics.getMemberName(),
			stagingClaimAnalytics.getProviderName(), stagingClaimAnalytics.getBillType(),
			stagingClaimAnalytics.getPrimaryDiagnosis(), stagingClaimAnalytics.getChargedAmount(),
			stagingClaimAnalytics.getPaidAmount(), stagingClaimAnalytics.getRepricedAmount(),
			stagingClaimAnalytics.getSavingsAmount(), stagingClaimAnalytics.getChargedPercent(),
			stagingClaimAnalytics.getRepricedPercent(), stagingClaimAnalytics.getSavingsPercent(),
			stagingClaimAnalytics.getChargedRange(), stagingClaimAnalytics.getPaidRange(),
			stagingClaimAnalytics.getRepricedRange(), stagingClaimAnalytics.getSavingsRange(),
			stagingClaimAnalytics.getClaimAging(), stagingClaimAnalytics.getProcedureCodes(),
			stagingClaimAnalytics.getResultCodes(), stagingClaimAnalytics.getDiagnosisCodes(),
			stagingClaimAnalytics.getCountry(), stagingClaimAnalytics.getState(),
			stagingClaimAnalytics.getFinancialExposure(), stagingClaimAnalytics.getRepricedNetwork(),
			stagingClaimAnalytics.getClientGroupName());
	}

	@Reference
	private StagingClaimAnalyticsLocalService _stagingClaimAnalyticsLocalService;

}