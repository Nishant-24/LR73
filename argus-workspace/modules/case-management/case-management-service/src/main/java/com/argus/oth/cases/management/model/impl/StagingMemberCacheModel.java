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

import com.argus.oth.cases.management.model.StagingMember;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingMember in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingMemberCacheModel
	implements CacheModel<StagingMember>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingMemberCacheModel)) {
			return false;
		}

		StagingMemberCacheModel stagingMemberCacheModel =
			(StagingMemberCacheModel)object;

		if (stagingMemberId == stagingMemberCacheModel.stagingMemberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingMemberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{stagingMemberId=");
		sb.append(stagingMemberId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingMember toEntityModel() {
		StagingMemberImpl stagingMemberImpl = new StagingMemberImpl();

		stagingMemberImpl.setStagingMemberId(stagingMemberId);

		if (createDate == Long.MIN_VALUE) {
			stagingMemberImpl.setCreateDate(null);
		}
		else {
			stagingMemberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingMemberImpl.setModifiedDate(null);
		}
		else {
			stagingMemberImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingMemberImpl.setExternalMemberId(externalMemberId);
		stagingMemberImpl.setClientId(clientId);
		stagingMemberImpl.setClientGroupId(clientGroupId);

		if (memberNumber == null) {
			stagingMemberImpl.setMemberNumber("");
		}
		else {
			stagingMemberImpl.setMemberNumber(memberNumber);
		}

		if (memberFirstName == null) {
			stagingMemberImpl.setMemberFirstName("");
		}
		else {
			stagingMemberImpl.setMemberFirstName(memberFirstName);
		}

		if (memberLastName == null) {
			stagingMemberImpl.setMemberLastName("");
		}
		else {
			stagingMemberImpl.setMemberLastName(memberLastName);
		}

		if (memberDOB == null) {
			stagingMemberImpl.setMemberDOB("");
		}
		else {
			stagingMemberImpl.setMemberDOB(memberDOB);
		}

		if (certificationNumber == null) {
			stagingMemberImpl.setCertificationNumber("");
		}
		else {
			stagingMemberImpl.setCertificationNumber(certificationNumber);
		}

		if (rxNumber == null) {
			stagingMemberImpl.setRxNumber("");
		}
		else {
			stagingMemberImpl.setRxNumber(rxNumber);
		}

		if (externalModifiedDate == null) {
			stagingMemberImpl.setExternalModifiedDate("");
		}
		else {
			stagingMemberImpl.setExternalModifiedDate(externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingMemberImpl.setExternalCreatedDate("");
		}
		else {
			stagingMemberImpl.setExternalCreatedDate(externalCreatedDate);
		}

		stagingMemberImpl.resetOriginalValues();

		return stagingMemberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingMemberId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalMemberId = objectInput.readLong();

		clientId = objectInput.readLong();

		clientGroupId = objectInput.readLong();
		memberNumber = objectInput.readUTF();
		memberFirstName = objectInput.readUTF();
		memberLastName = objectInput.readUTF();
		memberDOB = objectInput.readUTF();
		certificationNumber = objectInput.readUTF();
		rxNumber = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingMemberId);
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

		if (memberDOB == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberDOB);
		}

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

		if (externalModifiedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCreatedDate);
		}
	}

	public long stagingMemberId;
	public long createDate;
	public long modifiedDate;
	public long externalMemberId;
	public long clientId;
	public long clientGroupId;
	public String memberNumber;
	public String memberFirstName;
	public String memberLastName;
	public String memberDOB;
	public String certificationNumber;
	public String rxNumber;
	public String externalModifiedDate;
	public String externalCreatedDate;

}