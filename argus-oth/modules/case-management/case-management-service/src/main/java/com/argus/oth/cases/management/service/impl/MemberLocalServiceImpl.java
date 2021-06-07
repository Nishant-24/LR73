/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.service.base.MemberLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.helper.OTHCommonHelper;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PwdGenerator;

import io.swagger.client.model.Type2;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.MemberLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Member", service = AopService.class)
public class MemberLocalServiceImpl extends MemberLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.MemberLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.MemberLocalServiceUtil</code>.
	 */
	public Member addMember(
		long groupId, long externalMemberId, long clientId, long clientGroupId, String memberNumber,
		String memberFirstName, String memberLastName, Date memberDOB, String certificationNumber, String rxNumber,
		Date externalModifiedDate, Date externalCreatedDate, String randomString) {

		long memberId = counterLocalService.increment(Member.class.getName());

		Member member = memberPersistence.create(memberId);

		member.setGroupId(groupId);
		member.setExternalMemberId(externalMemberId);
		member.setClientId(clientId);
		member.setClientGroupId(clientGroupId);
		member.setMemberNumber(memberNumber);
		member.setMemberFirstName(memberFirstName);
		member.setMemberLastName(memberLastName);
		member.setMemberDOB(memberDOB);
		member.setCertificationNumber(certificationNumber);
		member.setRxNumber(rxNumber);
		member.setExternalModifiedDate(externalModifiedDate);
		member.setExternalCreatedDate(externalCreatedDate);
		member.setRowProcessed(randomString);

		member.setCreateDate(new Date());

		return addMember(member);
	}

	public void deleteUnprocessed(String randomString) {
		for (Member member : memberPersistence.findByRowProcessed(randomString)) {
			_log.info(
				String.format(
					OTHConstants.DELETE_LOG_STRING_FORMAT, Member.class.getSimpleName(), member.getExternalMemberId(),
					member.getMemberId()));

			deleteMember(member);
		}
	}

	public Member fetchByExternalMemberId(long externalMemberId) {
		return memberPersistence.fetchByExternalMemberId(externalMemberId);
	}

	public Member upsertMember(long groupId, long clientId, long clientGroupId, Type2 member) {
		BigDecimal externalMemberIdBigDecimal = member.getMemberId();

		long externalMemberId = externalMemberIdBigDecimal.longValue();

		Member existingMember = fetchByExternalMemberId(externalMemberId);

		Date memberDOB = _othCommonHelper.parseDate_yyyyMMddHHmmsss(member.getMemberDOB());

		if (Objects.isNull(existingMember)) {
			return addMember(
				groupId, externalMemberId, clientId, clientGroupId, null, member.getMemberFirstName(),
				member.getMemberLastName(), memberDOB, null, null, null, null, PwdGenerator.getPassword(8));
		}

		existingMember.setMemberFirstName(member.getMemberFirstName());
		existingMember.setMemberLastName(member.getMemberLastName());
		existingMember.setMemberDOB(memberDOB);

		updateMember(existingMember);

		return existingMember;
	}

	private static final Log _log = LogFactoryUtil.getLog(MemberLocalServiceImpl.class);

	@Reference
	private OTHCommonHelper _othCommonHelper;

}