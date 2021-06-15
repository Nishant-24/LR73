/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.model.impl.NoteModelImpl;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.base.NoteLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the note local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.NoteLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Note", service = AopService.class)
public class NoteLocalServiceImpl extends NoteLocalServiceBaseImpl {

	public void addNote(
		long groupId, long caseId, String callee, String caller, String code, String direction, long externalNoteId,
		Date noteCreateDate, String noteType, String type, String text, long userId, String noteAuthor,
		String randomString) {

		addNote(
			null, groupId, caseId, callee, caller, code, direction, externalNoteId, noteCreateDate, noteType, type,
			text, ProcessStatusType.SUCCESS.toString(), StringPool.BLANK, userId, noteAuthor, randomString);
	}

	public Note addNote(
		String uuid, long groupId, long caseId, String callee, String caller, String code, String direction,
		long externalNoteId, Date noteCreateDate, String noteType, String type, String text, String processStatus,
		String failureDescription, long userId, String noteAuthor, String randomString) {

		long id = counterLocalService.increment(Note.class.getName());

		Note note = createNote(id);

		if (!Validator.isBlank(uuid)) {
			note.setUuid(uuid);
		}

		if (Validator.isNull(noteAuthor) && (userId > 0)) {
			User user = userLocalService.fetchUser(userId);

			if (Objects.nonNull(user)) {
				String firstName = user.getFirstName();
				String lastName = user.getLastName();
				String emailAddress = user.getEmailAddress();

				noteAuthor = firstName + StringPool.SPACE + lastName + " - " + emailAddress;
			}
		}

		Group group = groupLocalService.fetchGroup(groupId);

		if (Objects.nonNull(group)) {
			note.setCompanyId(group.getCompanyId());
		}

		note.setGroupId(groupId);
		note.setCaseId(caseId);
		note.setCallee(callee);
		note.setCaller(caller);
		note.setCode(code);
		note.setCreateDate(new Date());
		note.setDirection(direction);
		note.setExternalNoteId(externalNoteId);
		note.setNoteCreateDate(noteCreateDate);
		note.setNoteType(noteType);
		note.setType(type);
		note.setText(text);
		note.setProcessStatus(processStatus);
		note.setFailureDescription(failureDescription);
		note.setUserId(userId);
		note.setNoteAuthor(noteAuthor);
		note.setRowProcessed(randomString);

		note = addNote(note);

		try {
			User dataAdminUser = _userLocalService.fetchUserByScreenName(
				note.getCompanyId(), OTHConstants.DATA_ADMIN_USER_SCREEN_NAME);

			resourceLocalService.addResources(
				note.getCompanyId(), note.getGroupId(), dataAdminUser.getUserId(), Note.class.getName(), id, false,
				true, true);
		}
		catch (Exception e) {
			_log.error(e);
		}

		return note;
	}

	@Override
	public int countNotesByC_NotP(long caseId, String processStatus) {
		return notePersistence.countByC_NotP(caseId, processStatus);
	}

	@Override
	public Note deleteNote(long noteId) throws PortalException {
		Note note = notePersistence.fetchByPrimaryKey(noteId);

		return deleteNote(note);
	}

	@Override
	public Note deleteNote(Note note) {
		if (Objects.nonNull(note)) {
			_removeResources(note);
		}

		return super.deleteNote(note);
	}

	public void deleteUnprocessed(String randomString) {
		BulkHelper.bulkDelete(
			notePersistence.getCurrentSession(), NoteModelImpl.TABLE_NAME, randomString,
			ProcessStatusType.FAILURE.name());
	}

	public Note fetchNoteByExternalNoteId(long externalNoteId) {
		return notePersistence.fetchByExternalNoteId(externalNoteId);
	}

	public List<Note> getNotesByC_NotP(long caseId, String processStatus, int start, int end) {
		if ((start == 0) && (end == 0)) {
			return notePersistence.findByC_NotP(caseId, processStatus);
		}

		return notePersistence.findByC_NotP(caseId, processStatus, start, end);
	}

	public List<Note> getNotesByE_P(long externalNoteId, String processStatus) {
		return notePersistence.findByE_P(externalNoteId, processStatus);
	}

	public Note updateNote(
		long noteId, long externalNoteId, String type, String processStatus, String failureDescription) {

		Note note = notePersistence.fetchByPrimaryKey(noteId);

		if (Objects.isNull(note)) {
			return null;
		}

		note.setExternalNoteId(externalNoteId);
		note.setProcessStatus(processStatus);
		note.setFailureDescription(failureDescription);
		note.setRowProcessed(PwdGenerator.getPassword(8));

		if (Validator.isNotNull(type)) {
			note.setType(type);
		}

		return notePersistence.update(note);
	}

	public Note updateNote(
		long noteId, String uuid, long groupId, long caseId, String callee, String caller, String code,
		String direction, long externalNoteId, Date noteCreateDate, String noteType, String type, String text,
		String processStatus, String failureDescription, String noteAuthor) {

		Note note = notePersistence.fetchByPrimaryKey(noteId);

		String randomString = PwdGenerator.getPassword(8);

		if (Objects.isNull(note)) {
			return addNote(
				uuid, groupId, caseId, callee, caller, code, direction, externalNoteId, noteCreateDate, noteType, type,
				text, processStatus, failureDescription, 0, noteAuthor, randomString);
		}

		note.setUuid(uuid);
		note.setGroupId(groupId);
		note.setCaseId(caseId);
		note.setCallee(callee);
		note.setCaller(caller);
		note.setCode(code);
		note.setDirection(direction);
		note.setExternalNoteId(externalNoteId);
		note.setNoteCreateDate(noteCreateDate);
		note.setNoteType(noteType);
		note.setType(type);
		note.setText(text);
		note.setProcessStatus(processStatus);
		note.setFailureDescription(failureDescription);
		note.setNoteAuthor(noteAuthor);
		note.setRowProcessed(randomString);

		return notePersistence.update(note);
	}

	private void _removeResources(Note note) {
		try {
			resourceLocalService.deleteResource(
				note.getCompanyId(), Note.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, note.getNoteId());
		}
		catch (PortalException pe) {
			_log.warn(pe.getMessage(), pe);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(NoteLocalServiceImpl.class);

	@Reference
	private UserLocalService _userLocalService;

}