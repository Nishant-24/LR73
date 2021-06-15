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

import com.argus.oth.cases.management.model.Client;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Client in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClientCacheModel implements CacheModel<Client>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientCacheModel)) {
			return false;
		}

		ClientCacheModel clientCacheModel = (ClientCacheModel)obj;

		if (clientId == clientCacheModel.clientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{clientId=");
		sb.append(clientId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalClientPk=");
		sb.append(externalClientPk);
		sb.append(", externalClientId=");
		sb.append(externalClientId);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", telephonyNumber=");
		sb.append(telephonyNumber);
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
	public Client toEntityModel() {
		ClientImpl clientImpl = new ClientImpl();

		clientImpl.setClientId(clientId);
		clientImpl.setGroupId(groupId);
		clientImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			clientImpl.setCreateDate(null);
		}
		else {
			clientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clientImpl.setModifiedDate(null);
		}
		else {
			clientImpl.setModifiedDate(new Date(modifiedDate));
		}

		clientImpl.setExternalClientPk(externalClientPk);
		clientImpl.setExternalClientId(externalClientId);

		if (clientName == null) {
			clientImpl.setClientName("");
		}
		else {
			clientImpl.setClientName(clientName);
		}

		if (telephonyNumber == null) {
			clientImpl.setTelephonyNumber("");
		}
		else {
			clientImpl.setTelephonyNumber(telephonyNumber);
		}

		if (externalModifiedDate == Long.MIN_VALUE) {
			clientImpl.setExternalModifiedDate(null);
		}
		else {
			clientImpl.setExternalModifiedDate(new Date(externalModifiedDate));
		}

		if (externalCreatedDate == Long.MIN_VALUE) {
			clientImpl.setExternalCreatedDate(null);
		}
		else {
			clientImpl.setExternalCreatedDate(new Date(externalCreatedDate));
		}

		if (rowProcessed == null) {
			clientImpl.setRowProcessed("");
		}
		else {
			clientImpl.setRowProcessed(rowProcessed);
		}

		clientImpl.resetOriginalValues();

		return clientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clientId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalClientPk = objectInput.readLong();

		externalClientId = objectInput.readLong();
		clientName = objectInput.readUTF();
		telephonyNumber = objectInput.readUTF();
		externalModifiedDate = objectInput.readLong();
		externalCreatedDate = objectInput.readLong();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(clientId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalClientPk);

		objectOutput.writeLong(externalClientId);

		if (clientName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		if (telephonyNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telephonyNumber);
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

	public long clientId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long externalClientPk;
	public long externalClientId;
	public String clientName;
	public String telephonyNumber;
	public long externalModifiedDate;
	public long externalCreatedDate;
	public String rowProcessed;

}