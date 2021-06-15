package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.service.StagingCasesLocalService;

import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = CasesFileLoadStagingService.class)
public class CasesFileLoadStagingService extends BaseFileLoadStagingService<StagingCases> {

	@Override
	public void cleanup() {
		_stagingCasesLocalService.deleteAllStagingCases();
	}

	@Override
	public String getEntityName() {
		return "Case";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "CaseID"
		).put(
			1, "ClientID"
		).put(
			2, "ClientGroupID"
		).put(
			3, "CaseNumber"
		).put(
			4, "CaseStartDate"
		).put(
			5, "CaseEndDate"
		).put(
			6, "MemberID"
		).put(
			7, "Primary_DiagCodeDescr"
		).put(
			8, "Primary_code"
		).put(
			9, "CaseStatus"
		).put(
			10, "EstimateEntryDate"
		).put(
			11, "CaseManager"
		).put(
			12, "ConsentReceiveDate"
		).put(
			13, "MedicalPlan"
		).put(
			14, "CostEstimate"
		).put(
			15, "ModifiedDate"
		).put(
			16, "CreatedDate"
		).put(
			17, "ChargeAmount"
		).put(
			18, "PaidAmount"
		).put(
			19, "RepricedAmount"
		).put(
			20, "SavingsAmount"
		).put(
			21, "SavingsPercent"
		).put(
			23, "TreatingPhysician"
		).put(
			getMaxFieldArrayPosition(), "PrimaryFacility"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 25;
	}

	@Override
	protected StagingCases getStagingModel(String[] fields) {
		StagingCases stagingCases = _stagingCasesLocalService.createStagingCases(0);

		stagingCases.setExternalCaseId(fields[0]);
		stagingCases.setExternalClientPk(fields[1]);
		stagingCases.setClientGroupId(fields[2]);
		stagingCases.setCaseNumber(fields[3]);
		stagingCases.setCaseStartDate(fields[4]);
		stagingCases.setCaseEndDate(fields[5]);
		stagingCases.setMemberId(fields[6]);
		stagingCases.setPrimaryDiagCode(fields[7]);
		stagingCases.setPrimaryCode(fields[8]);
		stagingCases.setStatus(fields[9]);
		stagingCases.setEstimateEntryDate(fields[10]);
		stagingCases.setCaseManager(fields[11]);
		stagingCases.setConsentReceivedDate(fields[12]);
		stagingCases.setMedicalPlan(fields[13]);
		stagingCases.setCostEstimate(fields[14]);
		stagingCases.setLastUpdated(fields[15]);
		stagingCases.setExternalCreatedDate(fields[16]);
		stagingCases.setChargedAmount(fields[17]);
		stagingCases.setPaidAmount(fields[18]);
		stagingCases.setRepricedAmount(fields[19]);
		stagingCases.setSavingsAmount(fields[20]);
		stagingCases.setSavingsPercent(fields[21]);
		stagingCases.setTreatingPhysician(fields[23]);
		stagingCases.setPrimaryFacility(fields[24]);

		return stagingCases;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingCases.class.getName();
	}

	@Override
	protected void insert(StagingCases stagingCases) {
		_stagingCasesLocalService.addStagingCase(
			stagingCases.getExternalCaseId(), stagingCases.getExternalClientPk(), stagingCases.getClientGroupId(),
			stagingCases.getCaseNumber(), stagingCases.getCaseStartDate(), stagingCases.getCaseEndDate(),
			stagingCases.getMemberId(), stagingCases.getPrimaryDiagCode(), stagingCases.getPrimaryCode(),
			stagingCases.getStatus(), stagingCases.getEstimateEntryDate(), stagingCases.getCaseManager(),
			stagingCases.getConsentReceivedDate(), stagingCases.getMedicalPlan(), stagingCases.getCostEstimate(),
			stagingCases.getLastUpdated(), stagingCases.getExternalCreatedDate(), stagingCases.getChargedAmount(),
			stagingCases.getPaidAmount(), stagingCases.getRepricedAmount(), stagingCases.getSavingsAmount(),
			stagingCases.getSavingsPercent(), stagingCases.getTreatingPhysician(), stagingCases.getPrimaryFacility());
	}

	@Reference
	private StagingCasesLocalService _stagingCasesLocalService;

}