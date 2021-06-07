package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.model.StagingMember;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.cases.management.service.StagingMemberLocalService;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.Member",
		"staging.model.name=com.argus.oth.cases.management.model.StagingMember"
	},
	service = AopService.class
)
public class MemberLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingMember> {

	@Override
	public boolean validate(StagingMember stagingMember) {
		long externalMemberId = stagingMember.getExternalMemberId();

		if (blankNullOrNullString(stagingMember.getMemberNumber())) {
			logError("Missing required field for Member ID " + externalMemberId + ", skipping upsert");

			return false;
		}

		Date memberDOB = parseDate_yyyyMMddHHmmsss(stagingMember.getMemberDOB());

		if (dateParseFailed(memberDOB)) {
			logError("Error parsing memberDOB, Member ID " + externalMemberId + ", skipping upsert");

			return false;
		}

		Date externalCreatedDate = parseDate_yyyyMMddHHmmsss(stagingMember.getExternalCreatedDate());

		if (dateParseFailed(externalCreatedDate)) {
			logError("Error parsing externalCreatedDate, Member ID " + externalMemberId + ", skipping upsert");

			return false;
		}

		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingMember.getExternalModifiedDate());

		if (dateParseFailed(externalModifiedDate)) {
			logError("Error parsing externalModifiedDate, Member ID " + externalMemberId + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "Member";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingMember> stagingMembers = _stagingMemberLocalService.getStagingMembers(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (StagingMember stagingMember : stagingMembers) {
			_upsertStagingMember(stagingMember, randomString);
		}

		return true;
	}

	private Client _getClient(long externalClientPk) {
		return _clientLocalService.fetchClientByExternalClientPk(externalClientPk);
	}

	private void _upsertStagingMember(StagingMember stagingMember, String randomString) {
		long externalMemberId = stagingMember.getExternalMemberId();

		logDebug("Upserting member (ID: " + externalMemberId + ")");

		Date memberDOB = parseDate_yyyyMMddHHmmsss(stagingMember.getMemberDOB());
		Date externalCreatedDate = parseDate_yyyyMMddHHmmsss(stagingMember.getExternalCreatedDate());
		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingMember.getExternalModifiedDate());

		long externalClientPK = stagingMember.getClientId();
		long clientGroupId = stagingMember.getClientGroupId();
		String memberNumber = stagingMember.getMemberNumber();

		if (!validate(stagingMember)) {
			logError("Member " + externalMemberId + ", invalid skipping upsert");

			return;
		}

		Client client = _getClient(externalClientPK);

		if (client == null) {
			logError(
				"Unable to look up Client ID based on External Client PK " + externalClientPK + ", skipping upsert");

			return;
		}

		long externalClientId = client.getExternalClientId();

		Member member = _memberLocalService.fetchByExternalMemberId(stagingMember.getExternalMemberId());

		long groupId = getGroupId();

		if (Objects.isNull(member)) {
			_memberLocalService.addMember(
				groupId, stagingMember.getExternalMemberId(), externalClientId, clientGroupId, memberNumber,
				stagingMember.getMemberFirstName(), stagingMember.getMemberLastName(), memberDOB,
				stagingMember.getCertificationNumber(), stagingMember.getRxNumber(), externalModifiedDate,
				externalCreatedDate, randomString);
		}
		else {
			member.setGroupId(groupId);
			member.setClientId(externalClientId);
			member.setClientGroupId(clientGroupId);
			member.setMemberNumber(memberNumber);
			member.setMemberFirstName(stagingMember.getMemberFirstName());
			member.setMemberLastName(stagingMember.getMemberLastName());
			member.setMemberDOB(memberDOB);
			member.setCertificationNumber(stagingMember.getCertificationNumber());
			member.setRxNumber(stagingMember.getRxNumber());
			member.setModifiedDate(externalModifiedDate);
			member.setCreateDate(externalCreatedDate);
			member.setRowProcessed(randomString);

			_memberLocalService.updateMember(member);
		}
	}

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private MemberLocalService _memberLocalService;

	@Reference
	private StagingMemberLocalService _stagingMemberLocalService;

}