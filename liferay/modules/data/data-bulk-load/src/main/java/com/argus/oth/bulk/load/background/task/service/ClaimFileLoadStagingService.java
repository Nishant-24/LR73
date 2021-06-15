package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingClaim;
import com.argus.oth.cases.management.service.StagingClaimLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ClaimFileLoadStagingService.class)
public class ClaimFileLoadStagingService extends BaseFileLoadStagingService<StagingClaim> {

	@Override
	public void cleanup() {
		_stagingClaimLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "Claim";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "ClaimID"
		).put(
			4, "Claim"
		).put(
			5, "ServiceFrom"
		).put(
			6, "ServiceThru"
		).put(
			8, "TPMReceivedDate"
		).put(
			9, "AuthorizationNr"
		).put(
			11, "DiagCodesCombined"
		).put(
			12, "Provider"
		).put(
			14, "providerstate"
		).put(
			16, "ClaimStatus"
		).put(
			17, "ClaimTurnaround"
		).put(
			21, "ProviderNetwork"
		).put(
			22, "ModifiedDate"
		).put(
			23, "CreatedDate"
		).put(
			24, "PrioritizedBill"
		).put(
			25, "BillType"
		).put(
			26, "PaidDate"
		).put(
			getMaxFieldArrayPosition(), "RepricedNetwork"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 29;
	}

	@Override
	protected StagingClaim getStagingModel(String[] fields) {
		StagingClaim stagingClaim = _stagingClaimLocalService.createStagingClaim(0);

		//todo: get statusSortOrder once Argus adds it to ClaimHeader
		long statusSortOrder = 0L;
		//todo: get paidAmount in case Argus adds it to ClaimHeader
		long paidAmount = 0L;

		stagingClaim.setExternalClaimId(GetterUtil.getLong(fields[0]));
		stagingClaim.setClaimRef(fields[4]);
		stagingClaim.setAuthorizationNumber(fields[9]);
		stagingClaim.setServiceFrom(fields[5]);
		stagingClaim.setServiceThru(fields[6]);
		stagingClaim.setProvider(fields[12]);
		stagingClaim.setPrioritizedBill(fields[24]);
		stagingClaim.setDiagCodesCombined(fields[11]);
		stagingClaim.setProviderState(fields[14]);
		stagingClaim.setTpmReceivedDate(fields[8]);
		stagingClaim.setClaimTurnaround(GetterUtil.getLong(fields[17]));
		stagingClaim.setBillType(fields[25]);
		stagingClaim.setProviderNetwork(fields[21]);
		stagingClaim.setRepricedNetwork(fields[28]);
		stagingClaim.setStatusSortOrder(statusSortOrder);
		stagingClaim.setPaidDate(fields[26]);
		stagingClaim.setPaidAmount(paidAmount);
		stagingClaim.setClaimStatus(fields[16]);
		stagingClaim.setExternalModifiedDate(fields[22]);
		stagingClaim.setExternalCreatedDate(fields[23]);

		return stagingClaim;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingClaim.class.getName();
	}

	@Override
	protected void insert(StagingClaim stagingClaim) {
		_stagingClaimLocalService.addStagingClaim(
			stagingClaim.getExternalClaimId(), stagingClaim.getClaimRef(), stagingClaim.getAuthorizationNumber(),
			stagingClaim.getServiceFrom(), stagingClaim.getServiceThru(), stagingClaim.getProvider(),
			stagingClaim.getPrioritizedBill(), stagingClaim.getDiagCodesCombined(), stagingClaim.getProviderState(),
			stagingClaim.getTpmReceivedDate(), stagingClaim.getClaimTurnaround(), stagingClaim.getBillType(),
			stagingClaim.getProviderNetwork(), stagingClaim.getRepricedNetwork(), stagingClaim.getStatusSortOrder(),
			stagingClaim.getPaidDate(), stagingClaim.getPaidAmount(), stagingClaim.getClaimStatus(),
			stagingClaim.getExternalModifiedDate(), stagingClaim.getExternalCreatedDate());
	}

	@Reference
	private StagingClaimLocalService _stagingClaimLocalService;

}