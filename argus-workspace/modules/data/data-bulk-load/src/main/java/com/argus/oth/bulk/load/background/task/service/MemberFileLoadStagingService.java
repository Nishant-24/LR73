package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingMember;
import com.argus.oth.cases.management.service.StagingMemberLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = MemberFileLoadStagingService.class)
public class MemberFileLoadStagingService extends BaseFileLoadStagingService<StagingMember> {

	@Override
	public void cleanup() {
		_stagingMemberLocalService.deleteAllStagingMembers();
	}

	@Override
	public String getEntityName() {
		return "Member";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "MemberID"
		).put(
			1, "ClientID"
		).put(
			2, "ClientGroupID"
		).put(
			3, "Member"
		).put(
			4, "MemberFirstName"
		).put(
			5, "MemberLastName"
		).put(
			6, "MemberDOB"
		).put(
			7, "CertificationNr"
		).put(
			8, "RXNumber"
		).put(
			9, "ModifiedDate"
		).put(
			getMaxFieldArrayPosition(), "CreatedDate"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 11;
	}

	@Override
	protected StagingMember getStagingModel(String[] fields) {
		StagingMember stagingMember = _stagingMemberLocalService.createStagingMember(0);

		stagingMember.setExternalMemberId(GetterUtil.getLong(fields[0]));
		stagingMember.setClientId(GetterUtil.getLong(fields[1]));
		stagingMember.setClientGroupId(GetterUtil.getLong(fields[2]));
		stagingMember.setMemberNumber(fields[3]);
		stagingMember.setMemberFirstName(fields[4]);
		stagingMember.setMemberLastName(fields[5]);
		stagingMember.setMemberDOB(fields[6]);
		stagingMember.setCertificationNumber(fields[7]);
		stagingMember.setRxNumber(fields[8]);
		stagingMember.setExternalModifiedDate(fields[9]);
		stagingMember.setExternalCreatedDate(fields[10]);

		return stagingMember;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingMember.class.getName();
	}

	@Override
	protected void insert(StagingMember stagingMember) {
		_stagingMemberLocalService.addStagingMember(
			stagingMember.getExternalMemberId(), stagingMember.getClientId(), stagingMember.getClientGroupId(),
			stagingMember.getMemberNumber(), stagingMember.getMemberFirstName(), stagingMember.getMemberLastName(),
			stagingMember.getMemberDOB(), stagingMember.getCertificationNumber(), stagingMember.getRxNumber(),
			stagingMember.getExternalModifiedDate(), stagingMember.getExternalCreatedDate());
	}

	@Reference
	private StagingMemberLocalService _stagingMemberLocalService;

}