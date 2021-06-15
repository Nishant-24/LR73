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

import com.argus.oth.cases.management.model.Note;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Note in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NoteCacheModel implements CacheModel<Note>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NoteCacheModel)) {
			return false;
		}

		NoteCacheModel noteCacheModel = (NoteCacheModel)obj;

		if (noteId == noteCacheModel.noteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, noteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", noteId=");
		sb.append(noteId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", caseId=");
		sb.append(caseId);
		sb.append(", externalNoteId=");
		sb.append(externalNoteId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", noteType=");
		sb.append(noteType);
		sb.append(", text=");
		sb.append(text);
		sb.append(", noteCreateDate=");
		sb.append(noteCreateDate);
		sb.append(", caller=");
		sb.append(caller);
		sb.append(", callee=");
		sb.append(callee);
		sb.append(", direction=");
		sb.append(direction);
		sb.append(", code=");
		sb.append(code);
		sb.append(", processStatus=");
		sb.append(processStatus);
		sb.append(", failureDescription=");
		sb.append(failureDescription);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", noteAuthor=");
		sb.append(noteAuthor);
		sb.append(", rowProcessed=");
		sb.append(rowProcessed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Note toEntityModel() {
		NoteImpl noteImpl = new NoteImpl();

		if (uuid == null) {
			noteImpl.setUuid("");
		}
		else {
			noteImpl.setUuid(uuid);
		}

		noteImpl.setNoteId(noteId);
		noteImpl.setGroupId(groupId);
		noteImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			noteImpl.setCreateDate(null);
		}
		else {
			noteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			noteImpl.setModifiedDate(null);
		}
		else {
			noteImpl.setModifiedDate(new Date(modifiedDate));
		}

		noteImpl.setCaseId(caseId);
		noteImpl.setExternalNoteId(externalNoteId);

		if (type == null) {
			noteImpl.setType("");
		}
		else {
			noteImpl.setType(type);
		}

		if (noteType == null) {
			noteImpl.setNoteType("");
		}
		else {
			noteImpl.setNoteType(noteType);
		}

		if (text == null) {
			noteImpl.setText("");
		}
		else {
			noteImpl.setText(text);
		}

		if (noteCreateDate == Long.MIN_VALUE) {
			noteImpl.setNoteCreateDate(null);
		}
		else {
			noteImpl.setNoteCreateDate(new Date(noteCreateDate));
		}

		if (caller == null) {
			noteImpl.setCaller("");
		}
		else {
			noteImpl.setCaller(caller);
		}

		if (callee == null) {
			noteImpl.setCallee("");
		}
		else {
			noteImpl.setCallee(callee);
		}

		if (direction == null) {
			noteImpl.setDirection("");
		}
		else {
			noteImpl.setDirection(direction);
		}

		if (code == null) {
			noteImpl.setCode("");
		}
		else {
			noteImpl.setCode(code);
		}

		if (processStatus == null) {
			noteImpl.setProcessStatus("");
		}
		else {
			noteImpl.setProcessStatus(processStatus);
		}

		if (failureDescription == null) {
			noteImpl.setFailureDescription("");
		}
		else {
			noteImpl.setFailureDescription(failureDescription);
		}

		noteImpl.setUserId(userId);

		if (noteAuthor == null) {
			noteImpl.setNoteAuthor("");
		}
		else {
			noteImpl.setNoteAuthor(noteAuthor);
		}

		if (rowProcessed == null) {
			noteImpl.setRowProcessed("");
		}
		else {
			noteImpl.setRowProcessed(rowProcessed);
		}

		noteImpl.resetOriginalValues();

		return noteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		noteId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		caseId = objectInput.readLong();

		externalNoteId = objectInput.readLong();
		type = objectInput.readUTF();
		noteType = objectInput.readUTF();
		text = objectInput.readUTF();
		noteCreateDate = objectInput.readLong();
		caller = objectInput.readUTF();
		callee = objectInput.readUTF();
		direction = objectInput.readUTF();
		code = objectInput.readUTF();
		processStatus = objectInput.readUTF();
		failureDescription = objectInput.readUTF();

		userId = objectInput.readLong();
		noteAuthor = objectInput.readUTF();
		rowProcessed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(noteId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(caseId);

		objectOutput.writeLong(externalNoteId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (noteType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteType);
		}

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}

		objectOutput.writeLong(noteCreateDate);

		if (caller == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caller);
		}

		if (callee == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(callee);
		}

		if (direction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(direction);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (processStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(processStatus);
		}

		if (failureDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(failureDescription);
		}

		objectOutput.writeLong(userId);

		if (noteAuthor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteAuthor);
		}

		if (rowProcessed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rowProcessed);
		}
	}

	public String uuid;
	public long noteId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long caseId;
	public long externalNoteId;
	public String type;
	public String noteType;
	public String text;
	public long noteCreateDate;
	public String caller;
	public String callee;
	public String direction;
	public String code;
	public String processStatus;
	public String failureDescription;
	public long userId;
	public String noteAuthor;
	public String rowProcessed;

}