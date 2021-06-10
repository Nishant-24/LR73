package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.model.StagingNote;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.NoteLocalService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.StagingCasesLocalService;
import com.argus.oth.cases.management.service.StagingNoteLocalService;
import com.argus.oth.common.enums.DataRequestType;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.Note",
		"staging.model.name=com.argus.oth.cases.management.model.StagingNote"
	},
	service = AopService.class
)
public class NoteLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingNote> {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean load(String randomString) {
		List<StagingNote> stagingNoteList = _stagingNoteLocalService.getStagingNotes(-1, -1);

		for (StagingNote stagingNote : stagingNoteList) {
			_upsertNote(stagingNote, randomString);
		}

		_updateFailedNotes();

		return true;
	}

	@Override
	public boolean validate(StagingNote stagingNote) {
		long externalNoteId = stagingNote.getCaseNoteID();

		String type = stagingNote.getType();

		StagingCases cases = _stagingCasesLocalService.getStagingCasesByExternalCaseId(
			String.valueOf(stagingNote.getExternalCaseId()));

		if ((cases == null) || blankNullOrNullString(type)) {
			logError("Missing required field for Note ID " + externalNoteId + ", skipping upsert");

			return false;
		}

		Date noteCreateDate = parseDate_yyyyMMddHHmmsss(stagingNote.getNoteCreateDate());

		if (dateParseFailed(noteCreateDate)) {
			logError("Error parsing noteCreateDate, Note ID " + externalNoteId + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "Note";
	}

	private void _updateFailedNotes() {
		List<Note> pendingNotes = _noteLocalService.getNotesByE_P(0L, ProcessStatusType.PENDING.toString());

		for (Note note : pendingNotes) {
			note.setProcessStatus(ProcessStatusType.FAILURE.toString());

			_noteLocalService.updateNote(note);
		}
	}

	private void _upsertNote(
		long caseId, String callee, String caller, String code, String direction, long externalNoteId,
		Date noteCreateDate, String noteType, String type, String text, String noteAuthor, String randomString) {

		Note note = _noteLocalService.fetchNoteByExternalNoteId(externalNoteId);

		long groupId = getGroupId();

		String processedText = processText(text);

		if (note == null) {
			_noteLocalService.addNote(
				groupId, caseId, callee, caller, code, direction, externalNoteId, noteCreateDate, noteType, type,
				processedText, 0, noteAuthor, randomString);
		}
		else {
			note.setGroupId(groupId);
			note.setCaseId(caseId);
			note.setCallee(callee);
			note.setCaller(caller);
			note.setCode(code);
			note.setDirection(direction);
			note.setExternalNoteId(externalNoteId);
			note.setNoteCreateDate(noteCreateDate);
			note.setModifiedDate(new Date());
			note.setNoteType(noteType);
			note.setType(type);
			note.setText(processedText);
			note.setUserId(0);
			note.setNoteAuthor(noteAuthor);
			note.setRowProcessed(randomString);

			_noteLocalService.updateNote(note);
		}
	}

	private void _upsertNote(StagingNote stagingNote, String randomString) {
		long caseNoteID = stagingNote.getCaseNoteID();
		Date noteCreateDate = parseDate_yyyyMMddHHmmsss(stagingNote.getNoteCreateDate());
		String type = stagingNote.getType();

		long externalCaseId = stagingNote.getExternalCaseId();

		logDebug("Upserting note (ID: " + caseNoteID + "; external case ID: " + externalCaseId + ")");

		if (!validate(stagingNote)) {
			logError("Note " + caseNoteID + ", invalid skipping upsert");

			return;
		}

		Cases cases = _casesLocalService.fetchCaseByExternalCaseId(externalCaseId);

		_upsertNote(
			cases.getCaseId(), stagingNote.getCallee(), stagingNote.getCaller(), stagingNote.getCode(),
			stagingNote.getDirection(), caseNoteID, noteCreateDate, stagingNote.getNoteType(), type,
			stagingNote.getNoteText(), stagingNote.getNoteAuthor(), randomString);

		setDataRequestLastUpdatedDate(
			cases.getClientId(), cases.getCaseId(), cases.getExternalCaseId(), DataRequestType.NOTE);
	}

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private NoteLocalService _noteLocalService;

	@Reference
	private StagingCasesLocalService _stagingCasesLocalService;

	@Reference
	private StagingNoteLocalService _stagingNoteLocalService;

}