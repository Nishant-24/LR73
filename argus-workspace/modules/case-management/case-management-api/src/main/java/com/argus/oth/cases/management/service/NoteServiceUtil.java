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

import com.argus.oth.cases.management.model.Note;

import java.util.List;

/**
 * Provides the remote service utility for Note. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.NoteServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NoteService
 * @generated
 */
public class NoteServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.NoteServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>NoteServiceUtil</code> to access the note remote service.
	 */
	public static com.liferay.portal.kernel.json.JSONObject addNote(
			String uuid, long groupId, long caseId, String callee,
			String caller, String code, String direction, long externalNoteId,
			java.util.Date noteCreateDate, String noteType, String type,
			String text, String processStatus, String failureDescription,
			long userId, String noteAuthor)
		throws Exception {

		return getService().addNote(
			uuid, groupId, caseId, callee, caller, code, direction,
			externalNoteId, noteCreateDate, noteType, type, text, processStatus,
			failureDescription, userId, noteAuthor);
	}

	public static int countNotesByCaseId(long caseId) throws Exception {
		return getService().countNotesByCaseId(caseId);
	}

	public static List<Note> getNotesByCaseId(long caseId, int start, int end)
		throws Exception {

		return getService().getNotesByCaseId(caseId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static NoteService getService() {
		return _service;
	}

	private static volatile NoteService _service;

}