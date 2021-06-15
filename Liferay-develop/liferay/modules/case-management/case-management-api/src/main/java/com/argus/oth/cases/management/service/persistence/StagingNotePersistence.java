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

import com.argus.oth.cases.management.exception.NoSuchStagingNoteException;
import com.argus.oth.cases.management.model.StagingNote;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingNoteUtil
 * @generated
 */
@ProviderType
public interface StagingNotePersistence extends BasePersistence<StagingNote> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingNoteUtil} to access the staging note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging note in the entity cache if it is enabled.
	 *
	 * @param stagingNote the staging note
	 */
	public void cacheResult(StagingNote stagingNote);

	/**
	 * Caches the staging notes in the entity cache if it is enabled.
	 *
	 * @param stagingNotes the staging notes
	 */
	public void cacheResult(java.util.List<StagingNote> stagingNotes);

	/**
	 * Creates a new staging note with the primary key. Does not add the staging note to the database.
	 *
	 * @param noteId the primary key for the new staging note
	 * @return the new staging note
	 */
	public StagingNote create(long noteId);

	/**
	 * Removes the staging note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note that was removed
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	public StagingNote remove(long noteId) throws NoSuchStagingNoteException;

	public StagingNote updateImpl(StagingNote stagingNote);

	/**
	 * Returns the staging note with the primary key or throws a <code>NoSuchStagingNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	public StagingNote findByPrimaryKey(long noteId)
		throws NoSuchStagingNoteException;

	/**
	 * Returns the staging note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note, or <code>null</code> if a staging note with the primary key could not be found
	 */
	public StagingNote fetchByPrimaryKey(long noteId);

	/**
	 * Returns all the staging notes.
	 *
	 * @return the staging notes
	 */
	public java.util.List<StagingNote> findAll();

	/**
	 * Returns a range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @return the range of staging notes
	 */
	public java.util.List<StagingNote> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging notes
	 */
	public java.util.List<StagingNote> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingNote>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging notes
	 */
	public java.util.List<StagingNote> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingNote>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging notes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging notes.
	 *
	 * @return the number of staging notes
	 */
	public int countAll();

}