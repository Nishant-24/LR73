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

import com.argus.oth.cases.management.model.StagingClientGroup;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingClientGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingClientGroupCacheModel
	implements CacheModel<StagingClientGroup>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingClientGroupCacheModel)) {
			return false;
		}

		StagingClientGroupCacheModel stagingClientGroupCacheModel =
			(StagingClientGroupCacheModel)object;

		if (stagingClientGroupId ==
				stagingClientGroupCacheModel.stagingClientGroupId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingClientGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{stagingClientGroupId=");
		sb.append(stagingClientGroupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalClientGroupId=");
		sb.append(externalClientGroupId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", clientGroup=");
		sb.append(clientGroup);
		sb.append(", clientGroupName=");
		sb.append(clientGroupName);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", externalCreatedDate=");
		sb.append(externalCreatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingClientGroup toEntityModel() {
		StagingClientGroupImpl stagingClientGroupImpl =
			new StagingClientGroupImpl();

		stagingClientGroupImpl.setStagingClientGroupId(stagingClientGroupId);

		if (createDate == Long.MIN_VALUE) {
			stagingClientGroupImpl.setCreateDate(null);
		}
		else {
			stagingClientGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingClientGroupImpl.setModifiedDate(null);
		}
		else {
			stagingClientGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingClientGroupImpl.setExternalClientGroupId(externalClientGroupId);
		stagingClientGroupImpl.setClientId(clientId);

		if (clientGroup == null) {
			stagingClientGroupImpl.setClientGroup("");
		}
		else {
			stagingClientGroupImpl.setClientGroup(clientGroup);
		}

		if (clientGroupName == null) {
			stagingClientGroupImpl.setClientGroupName("");
		}
		else {
			stagingClientGroupImpl.setClientGroupName(clientGroupName);
		}

		if (externalModifiedDate == null) {
			stagingClientGroupImpl.setExternalModifiedDate("");
		}
		else {
			stagingClientGroupImpl.setExternalModifiedDate(
				externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingClientGroupImpl.setExternalCreatedDate("");
		}
		else {
			stagingClientGroupImpl.setExternalCreatedDate(externalCreatedDate);
		}

		stagingClientGroupImpl.resetOriginalValues();

		return stagingClientGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingClientGroupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClientGroupId = objectInput.readLong();

		clientId = objectInput.readLong();
		clientGroup = objectInput.readUTF();
		clientGroupName = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingClientGroupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalClientGroupId);

		objectOutput.writeLong(clientId);

		if (clientGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientGroup);
		}

		if (clientGroupName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientGroupName);
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

	public long stagingClientGroupId;
	public long createDate;
	public long modifiedDate;
	public long externalClientGroupId;
	public long clientId;
	public String clientGroup;
	public String clientGroupName;
	public String externalModifiedDate;
	public String externalCreatedDate;

}