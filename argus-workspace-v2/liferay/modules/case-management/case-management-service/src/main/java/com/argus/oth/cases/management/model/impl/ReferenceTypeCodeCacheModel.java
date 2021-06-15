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

import com.argus.oth.cases.management.model.ReferenceTypeCode;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReferenceTypeCode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReferenceTypeCodeCacheModel
	implements CacheModel<ReferenceTypeCode>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReferenceTypeCodeCacheModel)) {
			return false;
		}

		ReferenceTypeCodeCacheModel referenceTypeCodeCacheModel =
			(ReferenceTypeCodeCacheModel)obj;

		if (referenceTypeCodeId ==
				referenceTypeCodeCacheModel.referenceTypeCodeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, referenceTypeCodeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{referenceTypeCodeId=");
		sb.append(referenceTypeCodeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReferenceTypeCode toEntityModel() {
		ReferenceTypeCodeImpl referenceTypeCodeImpl =
			new ReferenceTypeCodeImpl();

		referenceTypeCodeImpl.setReferenceTypeCodeId(referenceTypeCodeId);
		referenceTypeCodeImpl.setGroupId(groupId);
		referenceTypeCodeImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			referenceTypeCodeImpl.setCreateDate(null);
		}
		else {
			referenceTypeCodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			referenceTypeCodeImpl.setModifiedDate(null);
		}
		else {
			referenceTypeCodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		referenceTypeCodeImpl.setExternalReferenceTypeCodeId(
			externalReferenceTypeCodeId);

		if (type == null) {
			referenceTypeCodeImpl.setType("");
		}
		else {
			referenceTypeCodeImpl.setType(type);
		}

		if (key == null) {
			referenceTypeCodeImpl.setKey("");
		}
		else {
			referenceTypeCodeImpl.setKey(key);
		}

		if (description == null) {
			referenceTypeCodeImpl.setDescription("");
		}
		else {
			referenceTypeCodeImpl.setDescription(description);
		}

		if (rowProcessed == null) {
			referenceTypeCodeImpl.setRowProcessed("");
		}
		else {
			referenceTypeCodeImpl.setRowProcessed(rowProcessed);
		}

		referenceTypeCodeImpl.resetOriginalValues();

		return referenceTypeCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		referenceTypeCodeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalReferenceTypeCodeId = objectInput.readLong();
		type = objectInput.readUTF();
		key = objectInput.readUTF();
		description = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(referenceTypeCodeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
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

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public long referenceTypeCodeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalReferenceTypeCodeId;
	public String type;
	public String key;
	public String description;
	public String rowProcessed;

}