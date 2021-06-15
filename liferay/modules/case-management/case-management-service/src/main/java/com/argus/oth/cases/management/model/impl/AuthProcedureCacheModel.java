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

import com.argus.oth.cases.management.model.AuthProcedure;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuthProcedure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuthProcedureCacheModel
	implements CacheModel<AuthProcedure>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthProcedureCacheModel)) {
			return false;
		}

		AuthProcedureCacheModel authProcedureCacheModel =
			(AuthProcedureCacheModel)obj;

		if (authProcedureId == authProcedureCacheModel.authProcedureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, authProcedureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{authProcedureId=");
		sb.append(authProcedureId);
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
	public AuthProcedure toEntityModel() {
		AuthProcedureImpl authProcedureImpl = new AuthProcedureImpl();

		authProcedureImpl.setAuthProcedureId(authProcedureId);

		if (createDate == Long.MIN_VALUE) {
			authProcedureImpl.setCreateDate(null);
		}
		else {
			authProcedureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			authProcedureImpl.setModifiedDate(null);
		}
		else {
			authProcedureImpl.setModifiedDate(new Date(modifiedDate));
		}

		authProcedureImpl.setExternalAuthorizationId(externalAuthorizationId);

		if (authNumber == null) {
			authProcedureImpl.setAuthNumber("");
		}
		else {
			authProcedureImpl.setAuthNumber(authNumber);
		}

		if (medicalCodeId == null) {
			authProcedureImpl.setMedicalCodeId("");
		}
		else {
			authProcedureImpl.setMedicalCodeId(medicalCodeId);
		}

		if (description == null) {
			authProcedureImpl.setDescription("");
		}
		else {
			authProcedureImpl.setDescription(description);
		}

		if (externalModifiedDate == Long.MIN_VALUE) {
			authProcedureImpl.setExternalModifiedDate(null);
		}
		else {
			authProcedureImpl.setExternalModifiedDate(
				new Date(externalModifiedDate));
		}

		if (externalCreatedDate == Long.MIN_VALUE) {
			authProcedureImpl.setExternalCreatedDate(null);
		}
		else {
			authProcedureImpl.setExternalCreatedDate(
				new Date(externalCreatedDate));
		}

		authProcedureImpl.resetOriginalValues();

		return authProcedureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authProcedureId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalAuthorizationId = objectInput.readLong();
		authNumber = objectInput.readUTF();
		medicalCodeId = objectInput.readUTF();
		description = objectInput.readUTF();
		externalModifiedDate = objectInput.readLong();
		externalCreatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(authProcedureId);
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

		objectOutput.writeLong(externalModifiedDate);
		objectOutput.writeLong(externalCreatedDate);
	}

	public long authProcedureId;
	public long createDate;
	public long modifiedDate;
	public long externalAuthorizationId;
	public String authNumber;
	public String medicalCodeId;
	public String description;
	public long externalModifiedDate;
	public long externalCreatedDate;

}