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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StagingNote}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingNote
 * @generated
 */
public class StagingNoteWrapper
	extends BaseModelWrapper<StagingNote>
	implements ModelWrapper<StagingNote>, StagingNote {

	public StagingNoteWrapper(StagingNote stagingNote) {
		super(stagingNote);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("noteId", getNoteId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalCaseId", getExternalCaseId());
		attributes.put("caseNoteID", getCaseNoteID());
		attributes.put("type", getType());
		attributes.put("noteType", getNoteType());
		attributes.put("noteText", getNoteText());
		attributes.put("noteCreateDate", getNoteCreateDate());
		attributes.put("direction", getDirection());
		attributes.put("code", getCode());
		attributes.put("caller", getCaller());
		attributes.put("callee", getCallee());
		attributes.put("externalCreateDate", getExternalCreateDate());
		attributes.put("externalModifiedDate", getExternalModifiedDate());
		attributes.put("noteAuthor", getNoteAuthor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalCaseId = (Long)attributes.get("externalCaseId");

		if (externalCaseId != null) {
			setExternalCaseId(externalCaseId);
		}

		Long caseNoteID = (Long)attributes.get("caseNoteID");

		if (caseNoteID != null) {
			setCaseNoteID(caseNoteID);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String noteType = (String)attributes.get("noteType");

		if (noteType != null) {
			setNoteType(noteType);
		}

		String noteText = (String)attributes.get("noteText");

		if (noteText != null) {
			setNoteText(noteText);
		}

		String noteCreateDate = (String)attributes.get("noteCreateDate");

		if (noteCreateDate != null) {
			setNoteCreateDate(noteCreateDate);
		}

		String direction = (String)attributes.get("direction");

		if (direction != null) {
			setDirection(direction);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String caller = (String)attributes.get("caller");

		if (caller != null) {
			setCaller(caller);
		}

		String callee = (String)attributes.get("callee");

		if (callee != null) {
			setCallee(callee);
		}

		String externalCreateDate = (String)attributes.get(
			"externalCreateDate");

		if (externalCreateDate != null) {
			setExternalCreateDate(externalCreateDate);
		}

		String externalModifiedDate = (String)attributes.get(
			"externalModifiedDate");

		if (externalModifiedDate != null) {
			setExternalModifiedDate(externalModifiedDate);
		}

		String noteAuthor = (String)attributes.get("noteAuthor");

		if (noteAuthor != null) {
			setNoteAuthor(noteAuthor);
		}
	}

	/**
	 * Returns the callee of this staging note.
	 *
	 * @return the callee of this staging note
	 */
	@Override
	public String getCallee() {
		return model.getCallee();
	}

	/**
	 * Returns the caller of this staging note.
	 *
	 * @return the caller of this staging note
	 */
	@Override
	public String getCaller() {
		return model.getCaller();
	}

	/**
	 * Returns the case note ID of this staging note.
	 *
	 * @return the case note ID of this staging note
	 */
	@Override
	public long getCaseNoteID() {
		return model.getCaseNoteID();
	}

	/**
	 * Returns the code of this staging note.
	 *
	 * @return the code of this staging note
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the create date of this staging note.
	 *
	 * @return the create date of this staging note
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the direction of this staging note.
	 *
	 * @return the direction of this staging note
	 */
	@Override
	public String getDirection() {
		return model.getDirection();
	}

	/**
	 * Returns the external case ID of this staging note.
	 *
	 * @return the external case ID of this staging note
	 */
	@Override
	public long getExternalCaseId() {
		return model.getExternalCaseId();
	}

	/**
	 * Returns the external create date of this staging note.
	 *
	 * @return the external create date of this staging note
	 */
	@Override
	public String getExternalCreateDate() {
		return model.getExternalCreateDate();
	}

	/**
	 * Returns the external modified date of this staging note.
	 *
	 * @return the external modified date of this staging note
	 */
	@Override
	public String getExternalModifiedDate() {
		return model.getExternalModifiedDate();
	}

	/**
	 * Returns the modified date of this staging note.
	 *
	 * @return the modified date of this staging note
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note author of this staging note.
	 *
	 * @return the note author of this staging note
	 */
	@Override
	public String getNoteAuthor() {
		return model.getNoteAuthor();
	}

	/**
	 * Returns the note create date of this staging note.
	 *
	 * @return the note create date of this staging note
	 */
	@Override
	public String getNoteCreateDate() {
		return model.getNoteCreateDate();
	}

	/**
	 * Returns the note ID of this staging note.
	 *
	 * @return the note ID of this staging note
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the note text of this staging note.
	 *
	 * @return the note text of this staging note
	 */
	@Override
	public String getNoteText() {
		return model.getNoteText();
	}

	/**
	 * Returns the note type of this staging note.
	 *
	 * @return the note type of this staging note
	 */
	@Override
	public String getNoteType() {
		return model.getNoteType();
	}

	/**
	 * Returns the primary key of this staging note.
	 *
	 * @return the primary key of this staging note
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this staging note.
	 *
	 * @return the type of this staging note
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the callee of this staging note.
	 *
	 * @param callee the callee of this staging note
	 */
	@Override
	public void setCallee(String callee) {
		model.setCallee(callee);
	}

	/**
	 * Sets the caller of this staging note.
	 *
	 * @param caller the caller of this staging note
	 */
	@Override
	public void setCaller(String caller) {
		model.setCaller(caller);
	}

	/**
	 * Sets the case note ID of this staging note.
	 *
	 * @param caseNoteID the case note ID of this staging note
	 */
	@Override
	public void setCaseNoteID(long caseNoteID) {
		model.setCaseNoteID(caseNoteID);
	}

	/**
	 * Sets the code of this staging note.
	 *
	 * @param code the code of this staging note
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the create date of this staging note.
	 *
	 * @param createDate the create date of this staging note
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the direction of this staging note.
	 *
	 * @param direction the direction of this staging note
	 */
	@Override
	public void setDirection(String direction) {
		model.setDirection(direction);
	}

	/**
	 * Sets the external case ID of this staging note.
	 *
	 * @param externalCaseId the external case ID of this staging note
	 */
	@Override
	public void setExternalCaseId(long externalCaseId) {
		model.setExternalCaseId(externalCaseId);
	}

	/**
	 * Sets the external create date of this staging note.
	 *
	 * @param externalCreateDate the external create date of this staging note
	 */
	@Override
	public void setExternalCreateDate(String externalCreateDate) {
		model.setExternalCreateDate(externalCreateDate);
	}

	/**
	 * Sets the external modified date of this staging note.
	 *
	 * @param externalModifiedDate the external modified date of this staging note
	 */
	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		model.setExternalModifiedDate(externalModifiedDate);
	}

	/**
	 * Sets the modified date of this staging note.
	 *
	 * @param modifiedDate the modified date of this staging note
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note author of this staging note.
	 *
	 * @param noteAuthor the note author of this staging note
	 */
	@Override
	public void setNoteAuthor(String noteAuthor) {
		model.setNoteAuthor(noteAuthor);
	}

	/**
	 * Sets the note create date of this staging note.
	 *
	 * @param noteCreateDate the note create date of this staging note
	 */
	@Override
	public void setNoteCreateDate(String noteCreateDate) {
		model.setNoteCreateDate(noteCreateDate);
	}

	/**
	 * Sets the note ID of this staging note.
	 *
	 * @param noteId the note ID of this staging note
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the note text of this staging note.
	 *
	 * @param noteText the note text of this staging note
	 */
	@Override
	public void setNoteText(String noteText) {
		model.setNoteText(noteText);
	}

	/**
	 * Sets the note type of this staging note.
	 *
	 * @param noteType the note type of this staging note
	 */
	@Override
	public void setNoteType(String noteType) {
		model.setNoteType(noteType);
	}

	/**
	 * Sets the primary key of this staging note.
	 *
	 * @param primaryKey the primary key of this staging note
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this staging note.
	 *
	 * @param type the type of this staging note
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected StagingNoteWrapper wrap(StagingNote stagingNote) {
		return new StagingNoteWrapper(stagingNote);
	}

}