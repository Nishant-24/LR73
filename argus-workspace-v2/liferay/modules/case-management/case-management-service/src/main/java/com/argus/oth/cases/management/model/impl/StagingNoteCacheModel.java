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

import com.argus.oth.cases.management.model.StagingNote;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StagingNote in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingNoteCacheModel
	implements CacheModel<StagingNote>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StagingNoteCacheModel)) {
			return false;
		}

		StagingNoteCacheModel stagingNoteCacheModel =
			(StagingNoteCacheModel)obj;

		if (noteId == stagingNoteCacheModel.noteId) {
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
		StringBundler sb = new StringBundler(33);

		sb.append("{noteId=");
		sb.append(noteId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalCaseId=");
		sb.append(externalCaseId);
		sb.append(", caseNoteID=");
		sb.append(caseNoteID);
		sb.append(", type=");
		sb.append(type);
		sb.append(", noteType=");
		sb.append(noteType);
		sb.append(", noteText=");
		sb.append(noteText);
		sb.append(", noteCreateDate=");
		sb.append(noteCreateDate);
		sb.append(", direction=");
		sb.append(direction);
		sb.append(", code=");
		sb.append(code);
		sb.append(", caller=");
		sb.append(caller);
		sb.append(", callee=");
		sb.append(callee);
		sb.append(", externalCreateDate=");
		sb.append(externalCreateDate);
		sb.append(", externalModifiedDate=");
		sb.append(externalModifiedDate);
		sb.append(", noteAuthor=");
		sb.append(noteAuthor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StagingNote toEntityModel() {
		StagingNoteImpl stagingNoteImpl = new StagingNoteImpl();

		stagingNoteImpl.setNoteId(noteId);

		if (createDate == Long.MIN_VALUE) {
			stagingNoteImpl.setCreateDate(null);
		}
		else {
			stagingNoteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stagingNoteImpl.setModifiedDate(null);
		}
		else {
			stagingNoteImpl.setModifiedDate(new Date(modifiedDate));
		}

		stagingNoteImpl.setExternalCaseId(externalCaseId);
		stagingNoteImpl.setCaseNoteID(caseNoteID);

		if (type == null) {
			stagingNoteImpl.setType("");
		}
		else {
			stagingNoteImpl.setType(type);
		}

		if (noteType == null) {
			stagingNoteImpl.setNoteType("");
		}
		else {
			stagingNoteImpl.setNoteType(noteType);
		}

		if (noteText == null) {
			stagingNoteImpl.setNoteText("");
		}
		else {
			stagingNoteImpl.setNoteText(noteText);
		}

		if (noteCreateDate == null) {
			stagingNoteImpl.setNoteCreateDate("");
		}
		else {
			stagingNoteImpl.setNoteCreateDate(noteCreateDate);
		}

		if (direction == null) {
			stagingNoteImpl.setDirection("");
		}
		else {
			stagingNoteImpl.setDirection(direction);
		}

		if (code == null) {
			stagingNoteImpl.setCode("");
		}
		else {
			stagingNoteImpl.setCode(code);
		}

		if (caller == null) {
			stagingNoteImpl.setCaller("");
		}
		else {
			stagingNoteImpl.setCaller(caller);
		}

		if (callee == null) {
			stagingNoteImpl.setCallee("");
		}
		else {
			stagingNoteImpl.setCallee(callee);
		}

		if (externalCreateDate == null) {
			stagingNoteImpl.setExternalCreateDate("");
		}
		else {
			stagingNoteImpl.setExternalCreateDate(externalCreateDate);
		}

		if (externalModifiedDate == null) {
			stagingNoteImpl.setExternalModifiedDate("");
		}
		else {
			stagingNoteImpl.setExternalModifiedDate(externalModifiedDate);
		}

		if (noteAuthor == null) {
			stagingNoteImpl.setNoteAuthor("");
		}
		else {
			stagingNoteImpl.setNoteAuthor(noteAuthor);
		}

		stagingNoteImpl.resetOriginalValues();

		return stagingNoteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		noteId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		externalCaseId = objectInput.readLong();

		caseNoteID = objectInput.readLong();
		type = objectInput.readUTF();
		noteType = objectInput.readUTF();
		noteText = objectInput.readUTF();
		noteCreateDate = objectInput.readUTF();
		direction = objectInput.readUTF();
		code = objectInput.readUTF();
		caller = objectInput.readUTF();
		callee = objectInput.readUTF();
		externalCreateDate = objectInput.readUTF();
		externalModifiedDate = objectInput.readUTF();
		noteAuthor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(noteId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(externalCaseId);

		objectOutput.writeLong(caseNoteID);

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

		if (noteText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteText);
		}

		if (noteCreateDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteCreateDate);
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

		if (externalCreateDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCreateDate);
		}

		if (externalModifiedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalModifiedDate);
		}

		if (noteAuthor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteAuthor);
		}
	}

	public long noteId;
	public long createDate;
	public long modifiedDate;
	public long externalCaseId;
	public long caseNoteID;
	public String type;
	public String noteType;
	public String noteText;
	public String noteCreateDate;
	public String direction;
	public String code;
	public String caller;
	public String callee;
	public String externalCreateDate;
	public String externalModifiedDate;
	public String noteAuthor;

}