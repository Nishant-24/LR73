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

import com.argus.oth.cases.management.model.StagingAuthorization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingAuthorization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingAuthorizationCacheModel
	implements CacheModel<StagingAuthorization>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingAuthorizationCacheModel)) {
			return false;
		}

		StagingAuthorizationCacheModel stagingAuthorizationCacheModel =
			(StagingAuthorizationCacheModel)object;

		if (stagingAuthorizationId ==
				stagingAuthorizationCacheModel.stagingAuthorizationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingAuthorizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{stagingAuthorizationId=");
		sb.append(stagingAuthorizationId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", externalAuthorizationId=");
		sb.append(externalAuthorizationId);
		sb.append(", externalMemberId=");
		sb.append(externalMemberId);
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
		sb.append(", effectiveFrom=");
		sb.append(effectiveFrom);
		sb.append(", effectiveThru=");
		sb.append(effectiveThru);
		sb.append(", externalCreateDate=");
		sb.append(externalCreateDate);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingAuthorization toEntityModel() {
		StagingAuthorizationImpl stagingAuthorizationImpl =
			new StagingAuthorizationImpl();

		stagingAuthorizationImpl.setStagingAuthorizationId(
			stagingAuthorizationId);

		if (createDate == Long.MIN_VALUE) {
			stagingAuthorizationImpl.setCreateDate(null);
		}
		else {
			stagingAuthorizationImpl.setCreateDate(new Date(createDate));
		}

		stagingAuthorizationImpl.setExternalCaseId(externalCaseId);
		stagingAuthorizationImpl.setExternalAuthorizationId(
			externalAuthorizationId);
		stagingAuthorizationImpl.setExternalMemberId(externalMemberId);

		if (description == null) {
			stagingAuthorizationImpl.setDescription("");
		}
		else {
			stagingAuthorizationImpl.setDescription(description);
		}

		if (rtcAuthorizationStatus == null) {
			stagingAuthorizationImpl.setRtcAuthorizationStatus("");
		}
		else {
			stagingAuthorizationImpl.setRtcAuthorizationStatus(
				rtcAuthorizationStatus);
		}

		if (authStatus == null) {
			stagingAuthorizationImpl.setAuthStatus("");
		}
		else {
			stagingAuthorizationImpl.setAuthStatus(authStatus);
		}

		if (statusChangeDate == null) {
			stagingAuthorizationImpl.setStatusChangeDate("");
		}
		else {
			stagingAuthorizationImpl.setStatusChangeDate(statusChangeDate);
		}

		if (receivedDate == null) {
			stagingAuthorizationImpl.setReceivedDate("");
		}
		else {
			stagingAuthorizationImpl.setReceivedDate(receivedDate);
		}

		if (authNumber == null) {
			stagingAuthorizationImpl.setAuthNumber("");
		}
		else {
			stagingAuthorizationImpl.setAuthNumber(authNumber);
		}

		if (category == null) {
			stagingAuthorizationImpl.setCategory("");
		}
		else {
			stagingAuthorizationImpl.setCategory(category);
		}

		if (rtcAuthorizationType == null) {
			stagingAuthorizationImpl.setRtcAuthorizationType("");
		}
		else {
			stagingAuthorizationImpl.setRtcAuthorizationType(
				rtcAuthorizationType);
		}

		if (facility == null) {
			stagingAuthorizationImpl.setFacility("");
		}
		else {
			stagingAuthorizationImpl.setFacility(facility);
		}

		if (procedureCode == null) {
			stagingAuthorizationImpl.setProcedureCode("");
		}
		else {
			stagingAuthorizationImpl.setProcedureCode(procedureCode);
		}

		if (comments == null) {
			stagingAuthorizationImpl.setComments("");
		}
		else {
			stagingAuthorizationImpl.setComments(comments);
		}

		if (effectiveFrom == null) {
			stagingAuthorizationImpl.setEffectiveFrom("");
		}
		else {
			stagingAuthorizationImpl.setEffectiveFrom(effectiveFrom);
		}

		if (effectiveThru == null) {
			stagingAuthorizationImpl.setEffectiveThru("");
		}
		else {
			stagingAuthorizationImpl.setEffectiveThru(effectiveThru);
		}

		if (externalCreateDate == null) {
			stagingAuthorizationImpl.setExternalCreateDate("");
		}
		else {
			stagingAuthorizationImpl.setExternalCreateDate(externalCreateDate);
		}

		if (externalModifiedDate == null) {
			stagingAuthorizationImpl.setExternalModifiedDate("");
		}
		else {
			stagingAuthorizationImpl.setExternalModifiedDate(
				externalModifiedDate);
		}

		stagingAuthorizationImpl.resetOriginalValues();

		return stagingAuthorizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingAuthorizationId = objectInput.readLong();
		createDate = objectInput.readLong();

		externalCaseId = objectInput.readLong();

		externalAuthorizationId = objectInput.readLong();

		externalMemberId = objectInput.readLong();
		description = objectInput.readUTF();
		rtcAuthorizationStatus = objectInput.readUTF();
		authStatus = objectInput.readUTF();
		statusChangeDate = objectInput.readUTF();
		receivedDate = objectInput.readUTF();
		authNumber = objectInput.readUTF();
		category = objectInput.readUTF();
		rtcAuthorizationType = objectInput.readUTF();
		facility = objectInput.readUTF();
		procedureCode = objectInput.readUTF();
		comments = objectInput.readUTF();
		effectiveFrom = objectInput.readUTF();
		effectiveThru = objectInput.readUTF();
		externalCreateDate = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingAuthorizationId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(externalCaseId);

		objectOutput.writeLong(externalAuthorizationId);

		objectOutput.writeLong(externalMemberId);

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

		if (statusChangeDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusChangeDate);
		}

		if (receivedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivedDate);
		}

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

		if (effectiveFrom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(effectiveFrom);
		}

		if (effectiveThru == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(effectiveThru);
		}

		if (externalCreateDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCreateDate);
		}

		if (externalModifiedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalModifiedDate);
		}
	}

	public long stagingAuthorizationId;
	public long createDate;
	public long externalCaseId;
	public long externalAuthorizationId;
	public long externalMemberId;
	public String description;
	public String rtcAuthorizationStatus;
	public String authStatus;
	public String statusChangeDate;
	public String receivedDate;
	public String authNumber;
	public String category;
	public String rtcAuthorizationType;
	public String facility;
	public String procedureCode;
	public String comments;
	public String effectiveFrom;
	public String effectiveThru;
	public String externalCreateDate;
	public String externalModifiedDate;

}