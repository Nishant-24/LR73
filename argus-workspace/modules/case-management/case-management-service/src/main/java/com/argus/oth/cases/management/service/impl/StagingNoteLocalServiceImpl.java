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

import com.argus.oth.cases.management.model.StagingNote;
import com.argus.oth.cases.management.model.impl.StagingNoteModelImpl;
import com.argus.oth.cases.management.service.base.StagingNoteLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging note local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingNoteLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingNoteLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.StagingNote", service = AopService.class)
public class StagingNoteLocalServiceImpl extends StagingNoteLocalServiceBaseImpl {

	public void addStagingNote(
		long caseNoteId, long caseId, String callee, String caller, String code, String direction, String noteText,
		String type, String noteType, String externalCreateDate, String externalModifiedDate, String noteCreateDate,
		String noteAuthor) {

		long id = counterLocalService.increment(StagingNote.class.getName());

		StagingNote stagingNote = createStagingNote(id);

		stagingNote.setCaseNoteID(caseNoteId);
		stagingNote.setExternalCaseId(caseId);
		stagingNote.setCallee(callee);
		stagingNote.setCaller(caller);
		stagingNote.setCode(code);
		stagingNote.setDirection(direction);
		stagingNote.setExternalCreateDate(externalCreateDate);
		stagingNote.setExternalModifiedDate(externalModifiedDate);
		stagingNote.setNoteText(noteText);
		stagingNote.setType(type);
		stagingNote.setNoteType(noteType);
		stagingNote.setNoteCreateDate(noteCreateDate);
		stagingNote.setNoteAuthor(noteAuthor);

		stagingNote.setCreateDate(new Date());

		addStagingNote(stagingNote);
	}

	public void deleteAllStagingNotes() {
		BulkHelper.bulkDeleteAll(stagingNotePersistence.getCurrentSession(), StagingNoteModelImpl.TABLE_NAME);
	}

}