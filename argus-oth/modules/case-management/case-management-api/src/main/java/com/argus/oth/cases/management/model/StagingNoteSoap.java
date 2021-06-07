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
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StagingNoteSoap implements Serializable {

	public static StagingNoteSoap toSoapModel(StagingNote model) {
		StagingNoteSoap soapModel = new StagingNoteSoap();

		soapModel.setNoteId(model.getNoteId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalCaseId(model.getExternalCaseId());
		soapModel.setCaseNoteID(model.getCaseNoteID());
		soapModel.setType(model.getType());
		soapModel.setNoteType(model.getNoteType());
		soapModel.setNoteText(model.getNoteText());
		soapModel.setNoteCreateDate(model.getNoteCreateDate());
		soapModel.setDirection(model.getDirection());
		soapModel.setCode(model.getCode());
		soapModel.setCaller(model.getCaller());
		soapModel.setCallee(model.getCallee());
		soapModel.setExternalCreateDate(model.getExternalCreateDate());
		soapModel.setExternalModifiedDate(model.getExternalModifiedDate());
		soapModel.setNoteAuthor(model.getNoteAuthor());

		return soapModel;
	}

	public static StagingNoteSoap[] toSoapModels(StagingNote[] models) {
		StagingNoteSoap[] soapModels = new StagingNoteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StagingNoteSoap[][] toSoapModels(StagingNote[][] models) {
		StagingNoteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StagingNoteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StagingNoteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StagingNoteSoap[] toSoapModels(List<StagingNote> models) {
		List<StagingNoteSoap> soapModels = new ArrayList<StagingNoteSoap>(
			models.size());

		for (StagingNote model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StagingNoteSoap[soapModels.size()]);
	}

	public StagingNoteSoap() {
	}

	public long getPrimaryKey() {
		return _noteId;
	}

	public void setPrimaryKey(long pk) {
		setNoteId(pk);
	}

	public long getNoteId() {
		return _noteId;
	}

	public void setNoteId(long noteId) {
		_noteId = noteId;
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

	public long getExternalCaseId() {
		return _externalCaseId;
	}

	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	public long getCaseNoteID() {
		return _caseNoteID;
	}

	public void setCaseNoteID(long caseNoteID) {
		_caseNoteID = caseNoteID;
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

	public String getNoteText() {
		return _noteText;
	}

	public void setNoteText(String noteText) {
		_noteText = noteText;
	}

	public String getNoteCreateDate() {
		return _noteCreateDate;
	}

	public void setNoteCreateDate(String noteCreateDate) {
		_noteCreateDate = noteCreateDate;
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

	public String getExternalCreateDate() {
		return _externalCreateDate;
	}

	public void setExternalCreateDate(String externalCreateDate) {
		_externalCreateDate = externalCreateDate;
	}

	public String getExternalModifiedDate() {
		return _externalModifiedDate;
	}

	public void setExternalModifiedDate(String externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	public String getNoteAuthor() {
		return _noteAuthor;
	}

	public void setNoteAuthor(String noteAuthor) {
		_noteAuthor = noteAuthor;
	}

	private long _noteId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalCaseId;
	private long _caseNoteID;
	private String _type;
	private String _noteType;
	private String _noteText;
	private String _noteCreateDate;
	private String _direction;
	private String _code;
	private String _caller;
	private String _callee;
	private String _externalCreateDate;
	private String _externalModifiedDate;
	private String _noteAuthor;

}