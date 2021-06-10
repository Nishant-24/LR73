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

import com.argus.oth.cases.management.model.ClientGroup;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClientGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClientGroupCacheModel
	implements CacheModel<ClientGroup>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClientGroupCacheModel)) {
			return false;
		}

		ClientGroupCacheModel clientGroupCacheModel =
			(ClientGroupCacheModel)object;

		if (clientGroupId == clientGroupCacheModel.clientGroupId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{clientGroupId=");
		sb.append(clientGroupId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClientGroup toEntityModel() {
		ClientGroupImpl clientGroupImpl = new ClientGroupImpl();

		clientGroupImpl.setClientGroupId(clientGroupId);
		clientGroupImpl.setGroupId(groupId);
		clientGroupImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			clientGroupImpl.setCreateDate(null);
		}
		else {
			clientGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clientGroupImpl.setModifiedDate(null);
		}
		else {
			clientGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		clientGroupImpl.setExternalClientGroupId(externalClientGroupId);
		clientGroupImpl.setClientId(clientId);

		if (clientGroup == null) {
			clientGroupImpl.setClientGroup("");
		}
		else {
			clientGroupImpl.setClientGroup(clientGroup);
		}

		if (clientGroupName == null) {
			clientGroupImpl.setClientGroupName("");
		}
		else {
			clientGroupImpl.setClientGroupName(clientGroupName);
		}

		if (rowProcessed == null) {
			clientGroupImpl.setRowProcessed("");
		}
		else {
			clientGroupImpl.setRowProcessed(rowProcessed);
		}

		clientGroupImpl.resetOriginalValues();

		return clientGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clientGroupId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClientGroupId = objectInput.readLong();

		clientId = objectInput.readLong();
		clientGroup = objectInput.readUTF();
		clientGroupName = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(clientGroupId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
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

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public long clientGroupId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalClientGroupId;
	public long clientId;
	public String clientGroup;
	public String clientGroupName;
	public String rowProcessed;

}