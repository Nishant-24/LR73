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

import com.argus.oth.cases.management.model.DataRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataRequestCacheModel
	implements CacheModel<DataRequest>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataRequestCacheModel)) {
			return false;
		}

		DataRequestCacheModel dataRequestCacheModel =
			(DataRequestCacheModel)obj;

		if (dataRequestId == dataRequestCacheModel.dataRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{dataRequestId=");
		sb.append(dataRequestId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", caseId=");
		sb.append(caseId);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", lastUpdatedDate=");
		sb.append(lastUpdatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataRequest toEntityModel() {
		DataRequestImpl dataRequestImpl = new DataRequestImpl();

		dataRequestImpl.setDataRequestId(dataRequestId);
		dataRequestImpl.setClientId(clientId);
		dataRequestImpl.setCaseId(caseId);
		dataRequestImpl.setExternalCaseId(externalCaseId);

		if (type == null) {
			dataRequestImpl.setType("");
		}
		else {
			dataRequestImpl.setType(type);
		}

		if (lastUpdatedDate == Long.MIN_VALUE) {
			dataRequestImpl.setLastUpdatedDate(null);
		}
		else {
			dataRequestImpl.setLastUpdatedDate(new Date(lastUpdatedDate));
		}

		dataRequestImpl.resetOriginalValues();

		return dataRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataRequestId = objectInput.readLong();

		clientId = objectInput.readLong();

		caseId = objectInput.readLong();

		externalCaseId = objectInput.readLong();
		type = objectInput.readUTF();
		lastUpdatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataRequestId);

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(caseId);

		objectOutput.writeLong(externalCaseId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(lastUpdatedDate);
	}

	public long dataRequestId;
	public long clientId;
	public long caseId;
	public long externalCaseId;
	public String type;
	public long lastUpdatedDate;

}