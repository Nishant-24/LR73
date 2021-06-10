package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingNote;
import com.argus.oth.cases.management.service.StagingNoteLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(immediate = true, service = NoteFileLoadStagingService.class)
public class NoteFileLoadStagingService extends BaseFileLoadStagingService<StagingNote> {

	@Override
	public void cleanup() {
		_stagingNoteLocalService.deleteAllStagingNotes();
	}

	@Override
	public String getEntityName() {
		return "Note";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "CaseNoteID"
		).put(
			1, "CaseID"
		).put(
			2, "Type"
		).put(
			3, "NoteType"
		).put(
			4, "NoteText"
		).put(
			5, "NoteCreatedDate"
		).put(
			6, "Direction"
		).put(
			7, "Code"
		).put(
			8, "Caller"
		).put(
			9, "Callee"
		).put(
			10, "ModifiedDate"
		).put(
			11, "CreatedDate"
		).put(
			getMaxFieldArrayPosition(), "NoteAuthor"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 13;
	}

	@Override
	protected StagingNote getStagingModel(String[] fields) {
		StagingNote stagingNote = _stagingNoteLocalService.createStagingNote(0);

		stagingNote.setCaseNoteID(GetterUtil.getLong(fields[0]));
		stagingNote.setExternalCaseId(GetterUtil.getLong(fields[1]));
		stagingNote.setCallee(fields[9]);
		stagingNote.setCaller(fields[8]);
		stagingNote.setCode(fields[7]);
		stagingNote.setDirection(fields[6]);
		stagingNote.setNoteText(fields[4]);
		stagingNote.setType(fields[2]);
		stagingNote.setNoteType(fields[3]);
		stagingNote.setExternalCreateDate(fields[11]);
		stagingNote.setExternalModifiedDate(fields[10]);
		stagingNote.setNoteCreateDate(fields[5]);
		stagingNote.setNoteAuthor(fields[12]);

		return stagingNote;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingNote.class.getName();
	}

	@Override
	protected void insert(StagingNote stagingNote) {
		_stagingNoteLocalService.addStagingNote(
			stagingNote.getCaseNoteID(), stagingNote.getExternalCaseId(), stagingNote.getCallee(),
			stagingNote.getCaller(), stagingNote.getCode(), stagingNote.getDirection(), stagingNote.getNoteText(),
			stagingNote.getType(), stagingNote.getNoteType(), stagingNote.getExternalCreateDate(),
			stagingNote.getExternalModifiedDate(), stagingNote.getNoteCreateDate(), stagingNote.getNoteAuthor());
	}

	@Reference
	private StagingNoteLocalService _stagingNoteLocalService;

}