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

import com.argus.oth.cases.management.model.StagingAuthProcedure;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingAuthProcedure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingAuthProcedureCacheModel
	implements CacheModel<StagingAuthProcedure>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StagingAuthProcedureCacheModel)) {
			return false;
		}

		StagingAuthProcedureCacheModel stagingAuthProcedureCacheModel =
			(StagingAuthProcedureCacheModel)obj;

		if (stagingAuthProcedureId ==
				stagingAuthProcedureCacheModel.stagingAuthProcedureId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingAuthProcedureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{stagingAuthProcedureId=");
		sb.append(stagingAuthProcedureId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalAuthorizationId=");
		sb.append(externalAuthorizationId);
		sb.append(", authNumber=");
		sb.append(authNumber);
		sb.append(", medicalCodeId=");
		sb.append(medicalCodeId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", externalCreatedDate=");
		sb.append(externalCreatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingAuthProcedure toEntityModel() {
		StagingAuthProcedureImpl stagingAuthProcedureImpl =
			new StagingAuthProcedureImpl();

		stagingAuthProcedureImpl.setStagingAuthProcedureId(
			stagingAuthProcedureId);

		if (createDate == Long.MIN_VALUE) {
			stagingAuthProcedureImpl.setCreateDate(null);
		}
		else {
			stagingAuthProcedureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingAuthProcedureImpl.setModifiedDate(null);
		}
		else {
			stagingAuthProcedureImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingAuthProcedureImpl.setExternalAuthorizationId(
			externalAuthorizationId);

		if (authNumber == null) {
			stagingAuthProcedureImpl.setAuthNumber("");
		}
		else {
			stagingAuthProcedureImpl.setAuthNumber(authNumber);
		}

		if (medicalCodeId == null) {
			stagingAuthProcedureImpl.setMedicalCodeId("");
		}
		else {
			stagingAuthProcedureImpl.setMedicalCodeId(medicalCodeId);
		}

		if (description == null) {
			stagingAuthProcedureImpl.setDescription("");
		}
		else {
			stagingAuthProcedureImpl.setDescription(description);
		}

		if (externalModifiedDate == null) {
			stagingAuthProcedureImpl.setExternalModifiedDate("");
		}
		else {
			stagingAuthProcedureImpl.setExternalModifiedDate(
				externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingAuthProcedureImpl.setExternalCreatedDate("");
		}
		else {
			stagingAuthProcedureImpl.setExternalCreatedDate(
				externalCreatedDate);
		}

		stagingAuthProcedureImpl.resetOriginalValues();

		return stagingAuthProcedureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingAuthProcedureId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalAuthorizationId = objectInput.readLong();
		authNumber = objectInput.readUTF();
		medicalCodeId = objectInput.readUTF();
		description = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingAuthProcedureId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalAuthorizationId);

		if (authNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authNumber);
		}

		if (medicalCodeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(medicalCodeId);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
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

	public long stagingAuthProcedureId;
	public long createDate;
	public long modifiedDate;
	public long externalAuthorizationId;
	public String authNumber;
	public String medicalCodeId;
	public String description;
	public String externalModifiedDate;
	public String externalCreatedDate;

}