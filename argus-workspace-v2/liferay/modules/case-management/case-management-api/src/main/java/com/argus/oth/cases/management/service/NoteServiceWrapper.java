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

package com.argus.oth.cases.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NoteService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoteService
 * @generated
 */
public class NoteServiceWrapper
	implements NoteService, ServiceWrapper<NoteService> {

	public NoteServiceWrapper(NoteService noteService) {
		_noteService = noteService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>NoteServiceUtil</code> to access the note remote service.
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject addNote(
			String uuid, long groupId, long caseId, String callee,
			String caller, String code, String direction, long externalNoteId,
			java.util.Date noteCreateDate, String noteType, String type,
			String text, String processStatus, String failureDescription,
			long userId, String noteAuthor)
		throws Exception {

		return _noteService.addNote(
			uuid, groupId, caseId, callee, caller, code, direction,
			externalNoteId, noteCreateDate, noteType, type, text, processStatus,
			failureDescription, userId, noteAuthor);
	}

	@Override
	public int countNotesByCaseId(long caseId) throws Exception {
		return _noteService.countNotesByCaseId(caseId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Note>
			getNotesByCaseId(long caseId, int start, int end)
		throws Exception {

		return _noteService.getNotesByCaseId(caseId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noteService.getOSGiServiceIdentifier();
	}

	@Override
	public NoteService getWrappedService() {
		return _noteService;
	}

	@Override
	public void setWrappedService(NoteService noteService) {
		_noteService = noteService;
	}

	private NoteService _noteService;

}