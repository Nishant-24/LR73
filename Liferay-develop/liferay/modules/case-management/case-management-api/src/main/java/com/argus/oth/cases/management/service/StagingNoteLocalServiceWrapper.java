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
 * Provides a wrapper for {@link StagingNoteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingNoteLocalService
 * @generated
 */
public class StagingNoteLocalServiceWrapper
	implements ServiceWrapper<StagingNoteLocalService>,
			   StagingNoteLocalService {

	public StagingNoteLocalServiceWrapper(
		StagingNoteLocalService stagingNoteLocalService) {

		_stagingNoteLocalService = stagingNoteLocalService;
	}

	@Override
	public void addStagingNote(
		long caseNoteId, long caseId, String callee, String caller, String code,
		String direction, String noteText, String type, String noteType,
		String externalCreateDate, String externalModifiedDate,
		String noteCreateDate, String noteAuthor) {

		_stagingNoteLocalService.addStagingNote(
			caseNoteId, caseId, callee, caller, code, direction, noteText, type,
			noteType, externalCreateDate, externalModifiedDate, noteCreateDate,
			noteAuthor);
	}

	/**
	 * Adds the staging note to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingNote the staging note
	 * @return the staging note that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingNote addStagingNote(
		com.argus.oth.cases.management.model.StagingNote stagingNote) {

		return _stagingNoteLocalService.addStagingNote(stagingNote);
	}

	/**
	 * Creates a new staging note with the primary key. Does not add the staging note to the database.
	 *
	 * @param noteId the primary key for the new staging note
	 * @return the new staging note
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingNote createStagingNote(
		long noteId) {

		return _stagingNoteLocalService.createStagingNote(noteId);
	}

	@Override
	public void deleteAllStagingNotes() {
		_stagingNoteLocalService.deleteAllStagingNotes();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingNoteLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note that was removed
	 * @throws PortalException if a staging note with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingNote deleteStagingNote(
			long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingNoteLocalService.deleteStagingNote(noteId);
	}

	/**
	 * Deletes the staging note from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingNote the staging note
	 * @return the staging note that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingNote deleteStagingNote(
		com.argus.oth.cases.management.model.StagingNote stagingNote) {

		return _stagingNoteLocalService.deleteStagingNote(stagingNote);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingNoteLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingNoteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stagingNoteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stagingNoteLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingNoteLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stagingNoteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingNote fetchStagingNote(
		long noteId) {

		return _stagingNoteLocalService.fetchStagingNote(noteId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingNoteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingNoteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingNoteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingNoteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging note with the primary key.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note
	 * @throws PortalException if a staging note with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingNote getStagingNote(
			long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingNoteLocalService.getStagingNote(noteId);
	}

	/**
	 * Returns a range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @return the range of staging notes
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.StagingNote>
		getStagingNotes(int start, int end) {

		return _stagingNoteLocalService.getStagingNotes(start, end);
	}

	/**
	 * Returns the number of staging notes.
	 *
	 * @return the number of staging notes
	 */
	@Override
	public int getStagingNotesCount() {
		return _stagingNoteLocalService.getStagingNotesCount();
	}

	/**
	 * Updates the staging note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingNote the staging note
	 * @return the staging note that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingNote updateStagingNote(
		com.argus.oth.cases.management.model.StagingNote stagingNote) {

		return _stagingNoteLocalService.updateStagingNote(stagingNote);
	}

	@Override
	public StagingNoteLocalService getWrappedService() {
		return _stagingNoteLocalService;
	}

	@Override
	public void setWrappedService(
		StagingNoteLocalService stagingNoteLocalService) {

		_stagingNoteLocalService = stagingNoteLocalService;
	}

	private StagingNoteLocalService _stagingNoteLocalService;

}