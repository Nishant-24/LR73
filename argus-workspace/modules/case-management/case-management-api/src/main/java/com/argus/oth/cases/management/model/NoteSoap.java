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

package com.argus.oth.cases.management.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.argus.oth.cases.management.service.http.NoteServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NoteSoap implements Serializable {

	public static NoteSoap toSoapModel(Note model) {
		NoteSoap soapModel = new NoteSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNoteId(model.getNoteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCaseId(model.getCaseId());
		soapModel.setExternalNoteId(model.getExternalNoteId());
		soapModel.setType(model.getType());
		soapModel.setNoteType(model.getNoteType());
		soapModel.setText(model.getText());
		soapModel.setNoteCreateDate(model.getNoteCreateDate());
		soapModel.setCaller(model.getCaller());
		soapModel.setCallee(model.getCallee());
		soapModel.setDirection(model.getDirection());
		soapModel.setCode(model.getCode());
		soapModel.setProcessStatus(model.getProcessStatus());
		soapModel.setFailureDescription(model.getFailureDescription());
		soapModel.setUserId(model.getUserId());
		soapModel.setNoteAuthor(model.getNoteAuthor());
		soapModel.setRowProcessed(model.getRowProcessed());

		return soapModel;
	}

	public static NoteSoap[] toSoapModels(Note[] models) {
		NoteSoap[] soapModels = new NoteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NoteSoap[][] toSoapModels(Note[][] models) {
		NoteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NoteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NoteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NoteSoap[] toSoapModels(List<Note> models) {
		List<NoteSoap> soapModels = new ArrayList<NoteSoap>(models.size());

		for (Note model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NoteSoap[soapModels.size()]);
	}

	public NoteSoap() {
	}

	public long getPrimaryKey() {
		return _noteId;
	}

	public void setPrimaryKey(long pk) {
		setNoteId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNoteId() {
		return _noteId;
	}

	public void setNoteId(long noteId) {
		_noteId = noteId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCaseId() {
		return _caseId;
	}

	public void setCaseId(long caseId) {
		_caseId = caseId;
	}

	public long getExternalNoteId() {
		return _externalNoteId;
	}

	public void setExternalNoteId(long externalNoteId) {
		_externalNoteId = externalNoteId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getNoteType() {
		return _noteType;
	}

	public void setNoteType(String noteType) {
		_noteType = noteType;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public Date getNoteCreateDate() {
		return _noteCreateDate;
	}

	public void setNoteCreateDate(Date noteCreateDate) {
		_noteCreateDate = noteCreateDate;
	}

	public String getCaller() {
		return _caller;
	}

	public void setCaller(String caller) {
		_caller = caller;
	}

	public String getCallee() {
		return _callee;
	}

	public void setCallee(String callee) {
		_callee = callee;
	}

	public String getDirection() {
		return _direction;
	}

	public void setDirection(String direction) {
		_direction = direction;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getProcessStatus() {
		return _processStatus;
	}

	public void setProcessStatus(String processStatus) {
		_processStatus = processStatus;
	}

	public String getFailureDescription() {
		return _failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		_failureDescription = failureDescription;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getNoteAuthor() {
		return _noteAuthor;
	}

	public void setNoteAuthor(String noteAuthor) {
		_noteAuthor = noteAuthor;
	}

	public String getRowProcessed() {
		return _rowProcessed;
	}

	public void setRowProcessed(String rowProcessed) {
		_rowProcessed = rowProcessed;
	}

	private String _uuid;
	private long _noteId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _caseId;
	private long _externalNoteId;
	private String _type;
	private String _noteType;
	private String _text;
	private Date _noteCreateDate;
	private String _caller;
	private String _callee;
	private String _direction;
	private String _code;
	private String _processStatus;
	private String _failureDescription;
	private long _userId;
	private String _noteAuthor;
	private String _rowProcessed;

}