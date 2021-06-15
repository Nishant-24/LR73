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

package com.argus.oth.cases.management.service.persistence;

import com.argus.oth.cases.management.model.Note;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the note service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.NotePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotePersistence
 * @generated
 */
public class NoteUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Note note) {
		getPersistence().clearCache(note);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Note> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Note> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Note> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Note update(Note note) {
		return getPersistence().update(note);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Note update(Note note, ServiceContext serviceContext) {
		return getPersistence().update(note, serviceContext);
	}

	/**
	 * Returns all the notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notes
	 */
	public static List<Note> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public static List<Note> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_First(
			String uuid, OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_First(
		String uuid, OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_Last(
			String uuid, OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_Last(
		String uuid, OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note[] findByUuid_PrevAndNext(
			long noteId, String uuid, OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUuid_PrevAndNext(
			noteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUUID_G(String uuid, long groupId)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the note that was removed
	 */
	public static Note removeByUUID_G(String uuid, long groupId)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notes
	 */
	public static List<Note> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public static List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note[] findByUuid_C_PrevAndNext(
			long noteId, String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			noteId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @return the matching notes
	 */
	public static List<Note> findByC_NotP(long caseId, String processStatus) {
		return getPersistence().findByC_NotP(caseId, processStatus);
	}

	/**
	 * Returns a range of all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public static List<Note> findByC_NotP(
		long caseId, String processStatus, int start, int end) {

		return getPersistence().findByC_NotP(caseId, processStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByC_NotP(
		long caseId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByC_NotP(
			caseId, processStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByC_NotP(
		long caseId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_NotP(
			caseId, processStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByC_NotP_First(
			long caseId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByC_NotP_First(
			caseId, processStatus, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByC_NotP_First(
		long caseId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByC_NotP_First(
			caseId, processStatus, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByC_NotP_Last(
			long caseId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByC_NotP_Last(
			caseId, processStatus, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByC_NotP_Last(
		long caseId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByC_NotP_Last(
			caseId, processStatus, orderByComparator);
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note[] findByC_NotP_PrevAndNext(
			long noteId, long caseId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByC_NotP_PrevAndNext(
			noteId, caseId, processStatus, orderByComparator);
	}

	/**
	 * Removes all the notes where caseId = &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 */
	public static void removeByC_NotP(long caseId, String processStatus) {
		getPersistence().removeByC_NotP(caseId, processStatus);
	}

	/**
	 * Returns the number of notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @return the number of matching notes
	 */
	public static int countByC_NotP(long caseId, String processStatus) {
		return getPersistence().countByC_NotP(caseId, processStatus);
	}

	/**
	 * Returns the note where externalNoteId = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param externalNoteId the external note ID
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByExternalNoteId(long externalNoteId)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByExternalNoteId(externalNoteId);
	}

	/**
	 * Returns the note where externalNoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalNoteId the external note ID
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByExternalNoteId(long externalNoteId) {
		return getPersistence().fetchByExternalNoteId(externalNoteId);
	}

	/**
	 * Returns the note where externalNoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalNoteId the external note ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByExternalNoteId(
		long externalNoteId, boolean useFinderCache) {

		return getPersistence().fetchByExternalNoteId(
			externalNoteId, useFinderCache);
	}

	/**
	 * Removes the note where externalNoteId = &#63; from the database.
	 *
	 * @param externalNoteId the external note ID
	 * @return the note that was removed
	 */
	public static Note removeByExternalNoteId(long externalNoteId)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().removeByExternalNoteId(externalNoteId);
	}

	/**
	 * Returns the number of notes where externalNoteId = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @return the number of matching notes
	 */
	public static int countByExternalNoteId(long externalNoteId) {
		return getPersistence().countByExternalNoteId(externalNoteId);
	}

	/**
	 * Returns all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @return the matching notes
	 */
	public static List<Note> findByE_P(
		long externalNoteId, String processStatus) {

		return getPersistence().findByE_P(externalNoteId, processStatus);
	}

	/**
	 * Returns a range of all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public static List<Note> findByE_P(
		long externalNoteId, String processStatus, int start, int end) {

		return getPersistence().findByE_P(
			externalNoteId, processStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByE_P(
		long externalNoteId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByE_P(
			externalNoteId, processStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByE_P(
		long externalNoteId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByE_P(
			externalNoteId, processStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByE_P_First(
			long externalNoteId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByE_P_First(
			externalNoteId, processStatus, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByE_P_First(
		long externalNoteId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByE_P_First(
			externalNoteId, processStatus, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByE_P_Last(
			long externalNoteId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByE_P_Last(
			externalNoteId, processStatus, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByE_P_Last(
		long externalNoteId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByE_P_Last(
			externalNoteId, processStatus, orderByComparator);
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note[] findByE_P_PrevAndNext(
			long noteId, long externalNoteId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByE_P_PrevAndNext(
			noteId, externalNoteId, processStatus, orderByComparator);
	}

	/**
	 * Removes all the notes where externalNoteId = &#63; and processStatus = &#63; from the database.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 */
	public static void removeByE_P(long externalNoteId, String processStatus) {
		getPersistence().removeByE_P(externalNoteId, processStatus);
	}

	/**
	 * Returns the number of notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @return the number of matching notes
	 */
	public static int countByE_P(long externalNoteId, String processStatus) {
		return getPersistence().countByE_P(externalNoteId, processStatus);
	}

	/**
	 * Returns all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the matching notes
	 */
	public static List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);
	}

	/**
	 * Returns a range of all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public static List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public static List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByRowProcessed_ProcessStatus_First(
			String rowProcessed, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByRowProcessed_ProcessStatus_First(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByRowProcessed_ProcessStatus_First(
		String rowProcessed, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByRowProcessed_ProcessStatus_First(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByRowProcessed_ProcessStatus_Last(
			String rowProcessed, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByRowProcessed_ProcessStatus_Last(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByRowProcessed_ProcessStatus_Last(
		String rowProcessed, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByRowProcessed_ProcessStatus_Last(
			rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note[] findByRowProcessed_ProcessStatus_PrevAndNext(
			long noteId, String rowProcessed, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByRowProcessed_ProcessStatus_PrevAndNext(
			noteId, rowProcessed, processStatus, orderByComparator);
	}

	/**
	 * Removes all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 */
	public static void removeByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		getPersistence().removeByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);
	}

	/**
	 * Returns the number of notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the number of matching notes
	 */
	public static int countByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		return getPersistence().countByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);
	}

	/**
	 * Caches the note in the entity cache if it is enabled.
	 *
	 * @param note the note
	 */
	public static void cacheResult(Note note) {
		getPersistence().cacheResult(note);
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	public static void cacheResult(List<Note> notes) {
		getPersistence().cacheResult(notes);
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	public static Note create(long noteId) {
		return getPersistence().create(noteId);
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note remove(long noteId)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().remove(noteId);
	}

	public static Note updateImpl(Note note) {
		return getPersistence().updateImpl(note);
	}

	/**
	 * Returns the note with the primary key or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note findByPrimaryKey(long noteId)
		throws com.argus.oth.cases.management.exception.NoSuchNoteException {

		return getPersistence().findByPrimaryKey(noteId);
	}

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 */
	public static Note fetchByPrimaryKey(long noteId) {
		return getPersistence().fetchByPrimaryKey(noteId);
	}

	/**
	 * Returns all the notes.
	 *
	 * @return the notes
	 */
	public static List<Note> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of notes
	 */
	public static List<Note> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notes
	 */
	public static List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notes
	 */
	public static List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the notes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotePersistence, NotePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotePersistence.class);

		ServiceTracker<NotePersistence, NotePersistence> serviceTracker =
			new ServiceTracker<NotePersistence, NotePersistence>(
				bundle.getBundleContext(), NotePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}