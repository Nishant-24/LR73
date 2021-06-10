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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Note}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Note
 * @generated
 */
public class NoteWrapper
	extends BaseModelWrapper<Note> implements ModelWrapper<Note>, Note {

	public NoteWrapper(Note note) {
		super(note);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("noteId", getNoteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("caseId", getCaseId());
		attributes.put("externalNoteId", getExternalNoteId());
		attributes.put("type", getType());
		attributes.put("noteType", getNoteType());
		attributes.put("text", getText());
		attributes.put("noteCreateDate", getNoteCreateDate());
		attributes.put("caller", getCaller());
		attributes.put("callee", getCallee());
		attributes.put("direction", getDirection());
		attributes.put("code", getCode());
		attributes.put("processStatus", getProcessStatus());
		attributes.put("failureDescription", getFailureDescription());
		attributes.put("userId", getUserId());
		attributes.put("noteAuthor", getNoteAuthor());
		attributes.put("rowProcessed", getRowProcessed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
		}

		Long externalNoteId = (Long)attributes.get("externalNoteId");

		if (externalNoteId != null) {
			setExternalNoteId(externalNoteId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String noteType = (String)attributes.get("noteType");

		if (noteType != null) {
			setNoteType(noteType);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		Date noteCreateDate = (Date)attributes.get("noteCreateDate");

		if (noteCreateDate != null) {
			setNoteCreateDate(noteCreateDate);
		}

		String caller = (String)attributes.get("caller");

		if (caller != null) {
			setCaller(caller);
		}

		String callee = (String)attributes.get("callee");

		if (callee != null) {
			setCallee(callee);
		}

		String direction = (String)attributes.get("direction");

		if (direction != null) {
			setDirection(direction);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String processStatus = (String)attributes.get("processStatus");

		if (processStatus != null) {
			setProcessStatus(processStatus);
		}

		String failureDescription = (String)attributes.get(
			"failureDescription");

		if (failureDescription != null) {
			setFailureDescription(failureDescription);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String noteAuthor = (String)attributes.get("noteAuthor");

		if (noteAuthor != null) {
			setNoteAuthor(noteAuthor);
		}

		String rowProcessed = (String)attributes.get("rowProcessed");

		if (rowProcessed != null) {
			setRowProcessed(rowProcessed);
		}
	}

	/**
	 * Returns the callee of this note.
	 *
	 * @return the callee of this note
	 */
	@Override
	public String getCallee() {
		return model.getCallee();
	}

	/**
	 * Returns the caller of this note.
	 *
	 * @return the caller of this note
	 */
	@Override
	public String getCaller() {
		return model.getCaller();
	}

	/**
	 * Returns the case ID of this note.
	 *
	 * @return the case ID of this note
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the code of this note.
	 *
	 * @return the code of this note
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this note.
	 *
	 * @return the company ID of this note
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this note.
	 *
	 * @return the create date of this note
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the direction of this note.
	 *
	 * @return the direction of this note
	 */
	@Override
	public String getDirection() {
		return model.getDirection();
	}

	/**
	 * Returns the external note ID of this note.
	 *
	 * @return the external note ID of this note
	 */
	@Override
	public long getExternalNoteId() {
		return model.getExternalNoteId();
	}

	/**
	 * Returns the failure description of this note.
	 *
	 * @return the failure description of this note
	 */
	@Override
	public String getFailureDescription() {
		return model.getFailureDescription();
	}

	/**
	 * Returns the group ID of this note.
	 *
	 * @return the group ID of this note
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this note.
	 *
	 * @return the modified date of this note
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note author of this note.
	 *
	 * @return the note author of this note
	 */
	@Override
	public String getNoteAuthor() {
		return model.getNoteAuthor();
	}

	/**
	 * Returns the note create date of this note.
	 *
	 * @return the note create date of this note
	 */
	@Override
	public Date getNoteCreateDate() {
		return model.getNoteCreateDate();
	}

	/**
	 * Returns the note ID of this note.
	 *
	 * @return the note ID of this note
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the note type of this note.
	 *
	 * @return the note type of this note
	 */
	@Override
	public String getNoteType() {
		return model.getNoteType();
	}

	/**
	 * Returns the primary key of this note.
	 *
	 * @return the primary key of this note
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the process status of this note.
	 *
	 * @return the process status of this note
	 */
	@Override
	public String getProcessStatus() {
		return model.getProcessStatus();
	}

	/**
	 * Returns the row processed of this note.
	 *
	 * @return the row processed of this note
	 */
	@Override
	public String getRowProcessed() {
		return model.getRowProcessed();
	}

	/**
	 * Returns the text of this note.
	 *
	 * @return the text of this note
	 */
	@Override
	public String getText() {
		return model.getText();
	}

	/**
	 * Returns the type of this note.
	 *
	 * @return the type of this note
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this note.
	 *
	 * @return the user ID of this note
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this note.
	 *
	 * @return the user uuid of this note
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this note.
	 *
	 * @return the uuid of this note
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the callee of this note.
	 *
	 * @param callee the callee of this note
	 */
	@Override
	public void setCallee(String callee) {
		model.setCallee(callee);
	}

	/**
	 * Sets the caller of this note.
	 *
	 * @param caller the caller of this note
	 */
	@Override
	public void setCaller(String caller) {
		model.setCaller(caller);
	}

	/**
	 * Sets the case ID of this note.
	 *
	 * @param caseId the case ID of this note
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the code of this note.
	 *
	 * @param code the code of this note
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this note.
	 *
	 * @param companyId the company ID of this note
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this note.
	 *
	 * @param createDate the create date of this note
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the direction of this note.
	 *
	 * @param direction the direction of this note
	 */
	@Override
	public void setDirection(String direction) {
		model.setDirection(direction);
	}

	/**
	 * Sets the external note ID of this note.
	 *
	 * @param externalNoteId the external note ID of this note
	 */
	@Override
	public void setExternalNoteId(long externalNoteId) {
		model.setExternalNoteId(externalNoteId);
	}

	/**
	 * Sets the failure description of this note.
	 *
	 * @param failureDescription the failure description of this note
	 */
	@Override
	public void setFailureDescription(String failureDescription) {
		model.setFailureDescription(failureDescription);
	}

	/**
	 * Sets the group ID of this note.
	 *
	 * @param groupId the group ID of this note
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this note.
	 *
	 * @param modifiedDate the modified date of this note
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note author of this note.
	 *
	 * @param noteAuthor the note author of this note
	 */
	@Override
	public void setNoteAuthor(String noteAuthor) {
		model.setNoteAuthor(noteAuthor);
	}

	/**
	 * Sets the note create date of this note.
	 *
	 * @param noteCreateDate the note create date of this note
	 */
	@Override
	public void setNoteCreateDate(Date noteCreateDate) {
		model.setNoteCreateDate(noteCreateDate);
	}

	/**
	 * Sets the note ID of this note.
	 *
	 * @param noteId the note ID of this note
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the note type of this note.
	 *
	 * @param noteType the note type of this note
	 */
	@Override
	public void setNoteType(String noteType) {
		model.setNoteType(noteType);
	}

	/**
	 * Sets the primary key of this note.
	 *
	 * @param primaryKey the primary key of this note
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the process status of this note.
	 *
	 * @param processStatus the process status of this note
	 */
	@Override
	public void setProcessStatus(String processStatus) {
		model.setProcessStatus(processStatus);
	}

	/**
	 * Sets the row processed of this note.
	 *
	 * @param rowProcessed the row processed of this note
	 */
	@Override
	public void setRowProcessed(String rowProcessed) {
		model.setRowProcessed(rowProcessed);
	}

	/**
	 * Sets the text of this note.
	 *
	 * @param text the text of this note
	 */
	@Override
	public void setText(String text) {
		model.setText(text);
	}

	/**
	 * Sets the type of this note.
	 *
	 * @param type the type of this note
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this note.
	 *
	 * @param userId the user ID of this note
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this note.
	 *
	 * @param userUuid the user uuid of this note
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this note.
	 *
	 * @param uuid the uuid of this note
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected NoteWrapper wrap(Note note) {
		return new NoteWrapper(note);
	}

}