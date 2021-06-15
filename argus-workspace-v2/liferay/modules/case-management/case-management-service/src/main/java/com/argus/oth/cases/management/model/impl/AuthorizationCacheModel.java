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

import com.argus.oth.cases.management.model.Authorization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Authorization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuthorizationCacheModel
	implements CacheModel<Authorization>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorizationCacheModel)) {
			return false;
		}

		AuthorizationCacheModel authorizationCacheModel =
			(AuthorizationCacheModel)obj;

		if (authorizationId == authorizationCacheModel.authorizationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, authorizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", authorizationId=");
		sb.append(authorizationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", caseId=");
		sb.append(caseId);
		sb.append(", externalAuthorizationId=");
		sb.append(externalAuthorizationId);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", rtcAuthorizationStatus=");
		sb.append(rtcAuthorizationStatus);
		sb.append(", authStatus=");
		sb.append(authStatus);
		sb.append(", statusChangeDate=");
		sb.append(statusChangeDate);
		sb.append(", receivedDate=");
		sb.append(receivedDate);
		sb.append(", authNumber=");
		sb.append(authNumber);
		sb.append(", category=");
		sb.append(category);
		sb.append(", rtcAuthorizationType=");
		sb.append(rtcAuthorizationType);
		sb.append(", facility=");
		sb.append(facility);
		sb.append(", procedureCode=");
		sb.append(procedureCode);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", effectiveFrom=");
		sb.append(effectiveFrom);
		sb.append(", effectiveThru=");
		sb.append(effectiveThru);
		sb.append(", processStatus=");
		sb.append(processStatus);
		sb.append(", failureDescription=");
		sb.append(failureDescription);
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Authorization toEntityModel() {
		AuthorizationImpl authorizationImpl = new AuthorizationImpl();

		if (uuid == null) {
			authorizationImpl.setUuid("");
		}
		else {
			authorizationImpl.setUuid(uuid);
		}

		authorizationImpl.setAuthorizationId(authorizationId);
		authorizationImpl.setGroupId(groupId);
		authorizationImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			authorizationImpl.setCreateDate(null);
		}
		else {
			authorizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			authorizationImpl.setModifiedDate(null);
		}
		else {
			authorizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		authorizationImpl.setModifiedUserId(modifiedUserId);
		authorizationImpl.setCaseId(caseId);
		authorizationImpl.setExternalAuthorizationId(externalAuthorizationId);
		authorizationImpl.setMemberId(memberId);

		if (description == null) {
			authorizationImpl.setDescription("");
		}
		else {
			authorizationImpl.setDescription(description);
		}

		if (rtcAuthorizationStatus == null) {
			authorizationImpl.setRtcAuthorizationStatus("");
		}
		else {
			authorizationImpl.setRtcAuthorizationStatus(rtcAuthorizationStatus);
		}

		if (authStatus == null) {
			authorizationImpl.setAuthStatus("");
		}
		else {
			authorizationImpl.setAuthStatus(authStatus);
		}

		if (statusChangeDate == Long.MIN_VALUE) {
			authorizationImpl.setStatusChangeDate(null);
		}
		else {
			authorizationImpl.setStatusChangeDate(new Date(statusChangeDate));
		}

		if (receivedDate == Long.MIN_VALUE) {
			authorizationImpl.setReceivedDate(null);
		}
		else {
			authorizationImpl.setReceivedDate(new Date(receivedDate));
		}

		if (authNumber == null) {
			authorizationImpl.setAuthNumber("");
		}
		else {
			authorizationImpl.setAuthNumber(authNumber);
		}

		if (category == null) {
			authorizationImpl.setCategory("");
		}
		else {
			authorizationImpl.setCategory(category);
		}

		if (rtcAuthorizationType == null) {
			authorizationImpl.setRtcAuthorizationType("");
		}
		else {
			authorizationImpl.setRtcAuthorizationType(rtcAuthorizationType);
		}

		if (facility == null) {
			authorizationImpl.setFacility("");
		}
		else {
			authorizationImpl.setFacility(facility);
		}

		if (procedureCode == null) {
			authorizationImpl.setProcedureCode("");
		}
		else {
			authorizationImpl.setProcedureCode(procedureCode);
		}

		if (comments == null) {
			authorizationImpl.setComments("");
		}
		else {
			authorizationImpl.setComments(comments);
		}

		if (externalModifiedDate == Long.MIN_VALUE) {
			authorizationImpl.setExternalModifiedDate(null);
		}
		else {
			authorizationImpl.setExternalModifiedDate(
				new Date(externalModifiedDate));
		}

		if (effectiveFrom == Long.MIN_VALUE) {
			authorizationImpl.setEffectiveFrom(null);
		}
		else {
			authorizationImpl.setEffectiveFrom(new Date(effectiveFrom));
		}

		if (effectiveThru == Long.MIN_VALUE) {
			authorizationImpl.setEffectiveThru(null);
		}
		else {
			authorizationImpl.setEffectiveThru(new Date(effectiveThru));
		}

		if (processStatus == null) {
			authorizationImpl.setProcessStatus("");
		}
		else {
			authorizationImpl.setProcessStatus(processStatus);
		}

		if (failureDescription == null) {
			authorizationImpl.setFailureDescription("");
		}
		else {
			authorizationImpl.setFailureDescription(failureDescription);
		}

		if (rowProcessed == null) {
			authorizationImpl.setRowProcessed("");
		}
		else {
			authorizationImpl.setRowProcessed(rowProcessed);
		}

		authorizationImpl.resetOriginalValues();

		return authorizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		authorizationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedUserId = objectInput.readLong();

		caseId = objectInput.readLong();

		externalAuthorizationId = objectInput.readLong();

		memberId = objectInput.readLong();
		description = objectInput.readUTF();
		rtcAuthorizationStatus = objectInput.readUTF();
		authStatus = objectInput.readUTF();
		statusChangeDate = objectInput.readLong();
		receivedDate = objectInput.readLong();
		authNumber = objectInput.readUTF();
		category = objectInput.readUTF();
		rtcAuthorizationType = objectInput.readUTF();
		facility = objectInput.readUTF();
		procedureCode = objectInput.readUTF();
		comments = objectInput.readUTF();
		externalModifiedDate = objectInput.readLong();
		effectiveFrom = objectInput.readLong();
		effectiveThru = objectInput.readLong();
		processStatus = objectInput.readUTF();
		failureDescription = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(authorizationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedUserId);

		objectOutput.writeLong(caseId);

		objectOutput.writeLong(externalAuthorizationId);

		objectOutput.writeLong(memberId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (rtcAuthorizationStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rtcAuthorizationStatus);
		}

		if (authStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authStatus);
		}

		objectOutput.writeLong(statusChangeDate);
		objectOutput.writeLong(receivedDate);

		if (authNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authNumber);
		}

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (rtcAuthorizationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rtcAuthorizationType);
		}

		if (facility == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facility);
		}

		if (procedureCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procedureCode);
		}

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(externalModifiedDate);
		objectOutput.writeLong(effectiveFrom);
		objectOutput.writeLong(effectiveThru);

		if (processStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processStatus);
		}

		if (failureDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(failureDescription);
		}

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public String uuid;
	public long authorizationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long modifiedUserId;
	public long caseId;
	public long externalAuthorizationId;
	public long memberId;
	public String description;
	public String rtcAuthorizationStatus;
	public String authStatus;
	public long statusChangeDate;
	public long receivedDate;
	public String authNumber;
	public String category;
	public String rtcAuthorizationType;
	public String facility;
	public String procedureCode;
	public String comments;
	public long externalModifiedDate;
	public long effectiveFrom;
	public long effectiveThru;
	public String processStatus;
	public String failureDescription;
	public String rowProcessed;

}