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

import com.argus.oth.cases.management.model.StagingClient;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingClient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingClientCacheModel
	implements CacheModel<StagingClient>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StagingClientCacheModel)) {
			return false;
		}

		StagingClientCacheModel stagingClientCacheModel =
			(StagingClientCacheModel)obj;

		if (stagingClientId == stagingClientCacheModel.stagingClientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stagingClientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stagingClientId=");
		sb.append(stagingClientId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalClientPk=");
		sb.append(externalClientPk);
		sb.append(", clientId=");
		sb.append(clientId);
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
	public StagingClient toEntityModel() {
		StagingClientImpl stagingClientImpl = new StagingClientImpl();

		stagingClientImpl.setStagingClientId(stagingClientId);

		if (createDate == Long.MIN_VALUE) {
			stagingClientImpl.setCreateDate(null);
		}
		else {
			stagingClientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingClientImpl.setModifiedDate(null);
		}
		else {
			stagingClientImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (externalClientPk == null) {
			stagingClientImpl.setExternalClientPk("");
		}
		else {
			stagingClientImpl.setExternalClientPk(externalClientPk);
		}

		if (clientId == null) {
			stagingClientImpl.setClientId("");
		}
		else {
			stagingClientImpl.setClientId(clientId);
		}

		if (clientName == null) {
			stagingClientImpl.setClientName("");
		}
		else {
			stagingClientImpl.setClientName(clientName);
		}

		if (telephonyNumber == null) {
			stagingClientImpl.setTelephonyNumber("");
		}
		else {
			stagingClientImpl.setTelephonyNumber(telephonyNumber);
		}

		if (externalModifiedDate == null) {
			stagingClientImpl.setExternalModifiedDate("");
		}
		else {
			stagingClientImpl.setExternalModifiedDate(externalModifiedDate);
		}

		if (externalCreatedDate == null) {
			stagingClientImpl.setExternalCreatedDate("");
		}
		else {
			stagingClientImpl.setExternalCreatedDate(externalCreatedDate);
		}

		stagingClientImpl.setRowProcessed(rowProcessed);

		stagingClientImpl.resetOriginalValues();

		return stagingClientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stagingClientId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		externalClientPk = objectInput.readUTF();
		clientId = objectInput.readUTF();
		clientName = objectInput.readUTF();
		telephonyNumber = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		externalCreatedDate = objectInput.readUTF();

		rowProcessed = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(stagingClientId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (externalClientPk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalClientPk);
		}

		if (clientId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientId);
		}

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

		objectOutput.writeBoolean(rowProcessed);
	}

	public long stagingClientId;
	public long createDate;
	public long modifiedDate;
	public String externalClientPk;
	public String clientId;
	public String clientName;
	public String telephonyNumber;
	public String externalModifiedDate;
	public String externalCreatedDate;
	public boolean rowProcessed;

}