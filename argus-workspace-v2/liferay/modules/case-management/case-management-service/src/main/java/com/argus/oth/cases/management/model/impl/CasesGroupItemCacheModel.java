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

import com.argus.oth.cases.management.model.CasesGroupItem;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CasesGroupItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CasesGroupItemCacheModel
	implements CacheModel<CasesGroupItem>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CasesGroupItemCacheModel)) {
			return false;
		}

		CasesGroupItemCacheModel casesGroupItemCacheModel =
			(CasesGroupItemCacheModel)obj;

		if (casesGroupItemId == casesGroupItemCacheModel.casesGroupItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, casesGroupItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{casesGroupItemId=");
		sb.append(casesGroupItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CasesGroupItem toEntityModel() {
		CasesGroupItemImpl casesGroupItemImpl = new CasesGroupItemImpl();

		casesGroupItemImpl.setCasesGroupItemId(casesGroupItemId);
		casesGroupItemImpl.setGroupId(groupId);
		casesGroupItemImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			casesGroupItemImpl.setCreateDate(null);
		}
		else {
			casesGroupItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			casesGroupItemImpl.setModifiedDate(null);
		}
		else {
			casesGroupItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		casesGroupItemImpl.setUserId(userId);
		casesGroupItemImpl.setExternalCaseId(externalCaseId);

		if (type == null) {
			casesGroupItemImpl.setType("");
		}
		else {
			casesGroupItemImpl.setType(type);
		}

		casesGroupItemImpl.resetOriginalValues();

		return casesGroupItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		casesGroupItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userId = objectInput.readLong();

		externalCaseId = objectInput.readLong();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(casesGroupItemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(externalCaseId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long casesGroupItemId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long externalCaseId;
	public String type;

}