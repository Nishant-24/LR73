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

import com.argus.oth.cases.management.model.StagingReferenceTypeCode;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingReferenceTypeCode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingReferenceTypeCodeCacheModel
	implements CacheModel<StagingReferenceTypeCode>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingReferenceTypeCodeCacheModel)) {
			return false;
		}

		StagingReferenceTypeCodeCacheModel stagingReferenceTypeCodeCacheModel =
			(StagingReferenceTypeCodeCacheModel)object;

		if (stagingReferenceTypeCodeId ==
				stagingReferenceTypeCodeCacheModel.stagingReferenceTypeCodeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingReferenceTypeCodeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{stagingReferenceTypeCodeId=");
		sb.append(stagingReferenceTypeCodeId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalReferenceTypeCodeId=");
		sb.append(externalReferenceTypeCodeId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", key=");
		sb.append(key);
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
	public StagingReferenceTypeCode toEntityModel() {
		StagingReferenceTypeCodeImpl stagingReferenceTypeCodeImpl =
			new StagingReferenceTypeCodeImpl();

		stagingReferenceTypeCodeImpl.setStagingReferenceTypeCodeId(
			stagingReferenceTypeCodeId);

		if (createDate == Long.MIN_VALUE) {
			stagingReferenceTypeCodeImpl.setCreateDate(null);
		}
		else {
			stagingReferenceTypeCodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingReferenceTypeCodeImpl.setModifiedDate(null);
		}
		else {
			stagingReferenceTypeCodeImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		stagingReferenceTypeCodeImpl.setExternalReferenceTypeCodeId(
			externalReferenceTypeCodeId);

		if (type == null) {
			stagingReferenceTypeCodeImpl.setType("");
		}
		else {
			stagingReferenceTypeCodeImpl.setType(type);
		}

		if (key == null) {
			stagingReferenceTypeCodeImpl.setKey("");
		}
		else {
			stagingReferenceTypeCodeImpl.setKey(key);
		}

		if (description == null) {
			stagingReferenceTypeCodeImpl.setDescription("");
		}
		else {
			stagingReferenceTypeCodeImpl.setDescription(description);
		}

		if (externalModifiedDate == null) {
			stagingReferenceTypeCodeImpl.setExternalModifiedDate("");
		}
		else {
			stagingReferenceTypeCodeImpl.setExternalModifiedDate(
				externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingReferenceTypeCodeImpl.setExternalCreatedDate("");
		}
		else {
			stagingReferenceTypeCodeImpl.setExternalCreatedDate(
				externalCreatedDate);
		}

		stagingReferenceTypeCodeImpl.resetOriginalValues();

		return stagingReferenceTypeCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingReferenceTypeCodeId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalReferenceTypeCodeId = objectInput.readLong();
		type = objectInput.readUTF();
		key = objectInput.readUTF();
		description = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingReferenceTypeCodeId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalReferenceTypeCodeId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
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

	public long stagingReferenceTypeCodeId;
	public long createDate;
	public long modifiedDate;
	public long externalReferenceTypeCodeId;
	public String type;
	public String key;
	public String description;
	public String externalModifiedDate;
	public String externalCreatedDate;

}