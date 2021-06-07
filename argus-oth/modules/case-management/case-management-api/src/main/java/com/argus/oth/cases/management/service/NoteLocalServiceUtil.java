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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Note. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.NoteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NoteLocalService
 * @generated
 */
public class NoteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.NoteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addNote(
		long groupId, long caseId, String callee, String caller, String code,
		String direction, long externalNoteId, java.util.Date noteCreateDate,
		String noteType, String type, String text, long userId,
		String noteAuthor, String randomString) {

		getService().addNote(
			groupId, caseId, callee, caller, code, direction, externalNoteId,
			noteCreateDate, noteType, type, text, userId, noteAuthor,
			randomString);
	}

	/**
	 * Adds the note to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param note the note
	 * @return the note that was added
	 */
	public static com.argus.oth.cases.management.model.Note addNote(
		com.argus.oth.cases.management.model.Note note) {

		return getService().addNote(note);
	}

	public static com.argus.oth.cases.management.model.Note addNote(
		String uuid, long groupId, long caseId, String callee, String caller,
		String code, String direction, long externalNoteId,
		java.util.Date noteCreateDate, String noteType, String type,
		String text, String processStatus, String failureDescription,
		long userId, String noteAuthor, String randomString) {

		return getService().addNote(
			uuid, groupId, caseId, callee, caller, code, direction,
			externalNoteId, noteCreateDate, noteType, type, text, processStatus,
			failureDescription, userId, noteAuthor, randomString);
	}

	public static int countNotesByC_NotP(long caseId, String processStatus) {
		return getService().countNotesByC_NotP(caseId, processStatus);
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	public static com.argus.oth.cases.management.model.Note createNote(
		long noteId) {

		return getService().createNote(noteId);
	}

	/**
	 * Deletes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws PortalException if a note with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Note deleteNote(
			long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNote(noteId);
	}

	/**
	 * Deletes the note from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param note the note
	 * @return the note that was removed
	 */
	public static com.argus.oth.cases.management.model.Note deleteNote(
		com.argus.oth.cases.management.model.Note note) {

		return getService().deleteNote(note);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteUnprocessed(String randomString) {
		getService().deleteUnprocessed(randomString);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.NoteModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.NoteModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.argus.oth.cases.management.model.Note fetchNote(
		long noteId) {

		return getService().fetchNote(noteId);
	}

	public static com.argus.oth.cases.management.model.Note
		fetchNoteByExternalNoteId(long externalNoteId) {

		return getService().fetchNoteByExternalNoteId(externalNoteId);
	}

	/**
	 * Returns the note matching the UUID and group.
	 *
	 * @param uuid the note's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static com.argus.oth.cases.management.model.Note
		fetchNoteByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchNoteByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the note with the primary key.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws PortalException if a note with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Note getNote(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNote(noteId);
	}

	/**
	 * Returns the note matching the UUID and group.
	 *
	 * @param uuid the note's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note
	 * @throws PortalException if a matching note could not be found
	 */
	public static com.argus.oth.cases.management.model.Note
			getNoteByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of notes
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Note>
		getNotes(int start, int end) {

		return getService().getNotes(start, end);
	}

	public static java.util.List<com.argus.oth.cases.management.model.Note>
		getNotesByC_NotP(
			long caseId, String processStatus, int start, int end) {

		return getService().getNotesByC_NotP(caseId, processStatus, start, end);
	}

	public static java.util.List<com.argus.oth.cases.management.model.Note>
		getNotesByE_P(long externalNoteId, String processStatus) {

		return getService().getNotesByE_P(externalNoteId, processStatus);
	}

	/**
	 * Returns all the notes matching the UUID and company.
	 *
	 * @param uuid the UUID of the notes
	 * @param companyId the primary key of the company
	 * @return the matching notes, or an empty list if no matches were found
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Note>
		getNotesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getNotesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of notes matching the UUID and company.
	 *
	 * @param uuid the UUID of the notes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching notes, or an empty list if no matches were found
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Note>
		getNotesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.argus.oth.cases.management.model.Note> orderByComparator) {

		return getService().getNotesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	public static int getNotesCount() {
		return getService().getNotesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.argus.oth.cases.management.model.Note updateNote(
		long noteId, long externalNoteId, String type, String processStatus,
		String failureDescription) {

		return getService().updateNote(
			noteId, externalNoteId, type, processStatus, failureDescription);
	}

	public static com.argus.oth.cases.management.model.Note updateNote(
		long noteId, String uuid, long groupId, long caseId, String callee,
		String caller, String code, String direction, long externalNoteId,
		java.util.Date noteCreateDate, String noteType, String type,
		String text, String processStatus, String failureDescription,
		String noteAuthor) {

		return getService().updateNote(
			noteId, uuid, groupId, caseId, callee, caller, code, direction,
			externalNoteId, noteCreateDate, noteType, type, text, processStatus,
			failureDescription, noteAuthor);
	}

	/**
	 * Updates the note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param note the note
	 * @return the note that was updated
	 */
	public static com.argus.oth.cases.management.model.Note updateNote(
		com.argus.oth.cases.management.model.Note note) {

		return getService().updateNote(note);
	}

	public static NoteLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NoteLocalService, NoteLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NoteLocalService.class);

		ServiceTracker<NoteLocalService, NoteLocalService> serviceTracker =
			new ServiceTracker<NoteLocalService, NoteLocalService>(
				bundle.getBundleContext(), NoteLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}