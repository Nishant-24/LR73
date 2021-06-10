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

package com.argus.oth.cases.management.model.impl;

import com.argus.oth.cases.management.model.Member;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Member in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MemberCacheModel implements CacheModel<Member>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MemberCacheModel)) {
			return false;
		}

		MemberCacheModel memberCacheModel = (MemberCacheModel)object;

		if (memberId == memberCacheModel.memberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{memberId=");
		sb.append(memberId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalMemberId=");
		sb.append(externalMemberId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", clientGroupId=");
		sb.append(clientGroupId);
		sb.append(", memberNumber=");
		sb.append(memberNumber);
		sb.append(", memberFirstName=");
		sb.append(memberFirstName);
		sb.append(", memberLastName=");
		sb.append(memberLastName);
		sb.append(", memberDOB=");
		sb.append(memberDOB);
		sb.append(", certificationNumber=");
		sb.append(certificationNumber);
		sb.append(", rxNumber=");
		sb.append(rxNumber);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", externalCreatedDate=");
		sb.append(externalCreatedDate);
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Member toEntityModel() {
		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setMemberId(memberId);
		memberImpl.setGroupId(groupId);
		memberImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			memberImpl.setCreateDate(null);
		}
		else {
			memberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberImpl.setModifiedDate(null);
		}
		else {
			memberImpl.setModifiedDate(new Date(modifiedDate));
		}

		memberImpl.setExternalMemberId(externalMemberId);
		memberImpl.setClientId(clientId);
		memberImpl.setClientGroupId(clientGroupId);

		if (memberNumber == null) {
			memberImpl.setMemberNumber("");
		}
		else {
			memberImpl.setMemberNumber(memberNumber);
		}

		if (memberFirstName == null) {
			memberImpl.setMemberFirstName("");
		}
		else {
			memberImpl.setMemberFirstName(memberFirstName);
		}

		if (memberLastName == null) {
			memberImpl.setMemberLastName("");
		}
		else {
			memberImpl.setMemberLastName(memberLastName);
		}

		if (memberDOB == Long.MIN_VALUE) {
			memberImpl.setMemberDOB(null);
		}
		else {
			memberImpl.setMemberDOB(new Date(memberDOB));
		}

		if (certificationNumber == null) {
			memberImpl.setCertificationNumber("");
		}
		else {
			memberImpl.setCertificationNumber(certificationNumber);
		}

		if (rxNumber == null) {
			memberImpl.setRxNumber("");
		}
		else {
			memberImpl.setRxNumber(rxNumber);
		}

		if (externalModifiedDate == Long.MIN_VALUE) {
			memberImpl.setExternalModifiedDate(null);
		}
		else {
			memberImpl.setExternalModifiedDate(new Date(externalModifiedDate));
		}

		if (externalCreatedDate == Long.MIN_VALUE) {
			memberImpl.setExternalCreatedDate(null);
		}
		else {
			memberImpl.setExternalCreatedDate(new Date(externalCreatedDate));
		}

		if (rowProcessed == null) {
			memberImpl.setRowProcessed("");
		}
		else {
			memberImpl.setRowProcessed(rowProcessed);
		}

		memberImpl.resetOriginalValues();

		return memberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalMemberId = objectInput.readLong();

		clientId = objectInput.readLong();

		clientGroupId = objectInput.readLong();
		memberNumber = objectInput.readUTF();
		memberFirstName = objectInput.readUTF();
		memberLastName = objectInput.readUTF();
		memberDOB = objectInput.readLong();
		certificationNumber = objectInput.readUTF();
		rxNumber = objectInput.readUTF();
		externalModifiedDate = objectInput.readLong();
		externalCreatedDate = objectInput.readLong();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(memberId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalMemberId);

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(clientGroupId);

		if (memberNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberNumber);
		}

		if (memberFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberFirstName);
		}

		if (memberLastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberLastName);
		}

		objectOutput.writeLong(memberDOB);

		if (certificationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(certificationNumber);
		}

		if (rxNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rxNumber);
		}

		objectOutput.writeLong(externalModifiedDate);
		objectOutput.writeLong(externalCreatedDate);

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public long memberId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalMemberId;
	public long clientId;
	public long clientGroupId;
	public String memberNumber;
	public String memberFirstName;
	public String memberLastName;
	public long memberDOB;
	public String certificationNumber;
	public String rxNumber;
	public long externalModifiedDate;
	public long externalCreatedDate;
	public String rowProcessed;

}