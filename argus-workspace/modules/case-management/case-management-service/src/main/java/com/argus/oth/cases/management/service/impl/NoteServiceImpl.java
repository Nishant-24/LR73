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

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.base.NoteServiceBaseImpl;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.enums.DataRequestType;
import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.common.invoker.ThresholdInvoker;
import com.argus.oth.integration.mulesoft.CaseNoteMuleSoftIntegration;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import io.swagger.client.model.CaseNote;
import io.swagger.client.model.Type3;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the note remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.NoteService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteServiceBaseImpl
 */
@Component(
	property = {"json.web.service.context.name=oth", "json.web.service.context.path=Note"}, service = AopService.class
)
public class NoteServiceImpl extends NoteServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.argus.oth.cases.management.service.NoteServiceUtil</code> to access the note remote service.
	 */
	public JSONObject addNote(
			String uuid, long groupId, long caseId, String callee, String caller, String code, String direction,
			long externalNoteId, Date noteCreateDate, String noteType, String type, String text, String processStatus,
			String failureDescription, long userId, String noteAuthor)
		throws Exception {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Note.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), OTHConstants.ADD_NOTE)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, Note.class.getName(), 0, OTHConstants.ADD_NOTE);
		}

		String noteText = StringUtil.replace(text, StringPool.NEW_LINE, OTHConstants.HTML_NEW_LINE);

		noteLocalService.addNote(
			uuid, groupId, caseId, callee, caller, code, direction, externalNoteId, noteCreateDate, noteType, type,
			_othCommonHelper.processNewLines(noteText), processStatus, failureDescription, userId, noteAuthor,
			PwdGenerator.getPassword(8));

		// Mulesoft integration call

		Cases cases = _casesLocalService.getCases(caseId);

		User user = userLocalService.getUser(userId);

		JSONObject notesResponse = _caseNoteMuleSoftIntegration.postCaseNotes(
			PortalUUIDUtil.generate(), uuid, cases.getExternalCaseId(), user.getFirstName(), user.getLastName(),
			user.getEmailAddress(), text);

		_dataRequestLocalService.setDataRequestLastUpdatedDate(
			cases.getClientId(), caseId, cases.getExternalCaseId(), DataRequestType.NOTE.name());

		return notesResponse;
	}

	public int countNotesByCaseId(long caseId) throws Exception {
		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Note.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), ActionKeys.VIEW)) {

			_log.warn(
				"User does not have permission to view case with id " + caseId + " and external case id " +
					_getExternalCaseId(caseId));

			return 0;
		}

		return noteLocalService.countNotesByC_NotP(caseId, ProcessStatusType.FAILURE.name());
	}

	public List<Note> getNotesByCaseId(long caseId, int start, int end) throws Exception {
		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Note.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), ActionKeys.VIEW)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, Note.class.getName(), 0, ActionKeys.VIEW);
		}

		long externalCaseId = _getExternalCaseId(caseId);

		if (externalCaseId == 0) {
			throw new Exception("Cases with caseId " + caseId + " not found");
		}

		_thresholdInvoker.invokeByCase(
			caseId, DataRequestType.NOTE, _getIntegrationFunction(externalCaseId),
			response -> _processNoteUpdates(caseId, response));

		return noteLocalService.getNotesByC_NotP(caseId, ProcessStatusType.FAILURE.name(), start, end);
	}

	private long _getExternalCaseId(long caseId) {
		Cases cases = _casesLocalService.fetchCases(caseId);

		if (Objects.isNull(cases)) {
			return 0;
		}

		return cases.getExternalCaseId();
	}

	private Function<String, List<CaseNote>> _getIntegrationFunction(long externalCaseId) {
		return lastUpdatedDateString -> {
			try {
				return _caseNoteMuleSoftIntegration.getCaseNotes(
					PortalUUIDUtil.generate(), externalCaseId, lastUpdatedDateString);
			}
			catch (Exception exception) {
				if (_log.isErrorEnabled()) {
					_log.error("Failed to get notes from MuleSoft", exception);
				}

				return new ArrayList<>();
			}
		};
	}

	private void _processNoteUpdates(long caseId, List<CaseNote> caseNotes) {
		for (CaseNote caseNote : caseNotes) {
			BigDecimal noteIdBigDecimal = caseNote.getNoteId();

			long externalNoteId = noteIdBigDecimal.longValue();

			Note note = noteLocalService.fetchNoteByExternalNoteId(externalNoteId);

			String callee = caseNote.getCallee();
			String caller = caseNote.getCaller();
			String code = caseNote.getCode();
			String direction = caseNote.getDirection();

			Date noteCreatedDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseNote.getNoteCreatedDate());

			Type3 noteType = caseNote.getNoteType();

			String noteTypeDescription = StringPool.BLANK;

			if (Objects.nonNull(noteType)) {
				noteTypeDescription = noteType.getDescription();
			}

			String noteAuthor = caseNote.getNoteAuthor();

			String type = caseNote.getType();

			String noteText = StringUtil.replace(caseNote.getNote(), StringPool.NEW_LINE, OTHConstants.HTML_NEW_LINE);

			String processStatus = ProcessStatusType.SUCCESS.name();

			if (Objects.isNull(note)) {
				noteLocalService.addNote(
					StringPool.BLANK, _othCommonHelper.getOTHPortalGroupId(), caseId, callee, caller, code, direction,
					externalNoteId, noteCreatedDate, noteTypeDescription, type, noteText, processStatus,
					StringPool.BLANK, 0, noteAuthor, PwdGenerator.getPassword(8));

				continue;
			}

			noteLocalService.updateNote(
				note.getNoteId(), StringPool.BLANK, _othCommonHelper.getOTHPortalGroupId(), caseId, callee, caller,
				code, direction, externalNoteId, noteCreatedDate, noteTypeDescription, type, noteText, processStatus,
				StringPool.BLANK, noteAuthor);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(NoteServiceImpl.class);

	@Reference
	private CaseNoteMuleSoftIntegration _caseNoteMuleSoftIntegration;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private DataRequestLocalService _dataRequestLocalService;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private ThresholdInvoker<CaseNote> _thresholdInvoker;

}