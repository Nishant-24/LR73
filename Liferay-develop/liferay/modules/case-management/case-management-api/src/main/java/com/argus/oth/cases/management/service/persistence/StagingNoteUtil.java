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

import com.argus.oth.cases.management.model.StagingNote;

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
 * The persistence utility for the staging note service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingNotePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingNotePersistence
 * @generated
 */
public class StagingNoteUtil {

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
	public static void clearCache(StagingNote stagingNote) {
		getPersistence().clearCache(stagingNote);
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
	public static Map<Serializable, StagingNote> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingNote> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingNote> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingNote> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingNote> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingNote update(StagingNote stagingNote) {
		return getPersistence().update(stagingNote);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingNote update(
		StagingNote stagingNote, ServiceContext serviceContext) {

		return getPersistence().update(stagingNote, serviceContext);
	}

	/**
	 * Caches the staging note in the entity cache if it is enabled.
	 *
	 * @param stagingNote the staging note
	 */
	public static void cacheResult(StagingNote stagingNote) {
		getPersistence().cacheResult(stagingNote);
	}

	/**
	 * Caches the staging notes in the entity cache if it is enabled.
	 *
	 * @param stagingNotes the staging notes
	 */
	public static void cacheResult(List<StagingNote> stagingNotes) {
		getPersistence().cacheResult(stagingNotes);
	}

	/**
	 * Creates a new staging note with the primary key. Does not add the staging note to the database.
	 *
	 * @param noteId the primary key for the new staging note
	 * @return the new staging note
	 */
	public static StagingNote create(long noteId) {
		return getPersistence().create(noteId);
	}

	/**
	 * Removes the staging note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note that was removed
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	public static StagingNote remove(long noteId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingNoteException {

		return getPersistence().remove(noteId);
	}

	public static StagingNote updateImpl(StagingNote stagingNote) {
		return getPersistence().updateImpl(stagingNote);
	}

	/**
	 * Returns the staging note with the primary key or throws a <code>NoSuchStagingNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	public static StagingNote findByPrimaryKey(long noteId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingNoteException {

		return getPersistence().findByPrimaryKey(noteId);
	}

	/**
	 * Returns the staging note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note, or <code>null</code> if a staging note with the primary key could not be found
	 */
	public static StagingNote fetchByPrimaryKey(long noteId) {
		return getPersistence().fetchByPrimaryKey(noteId);
	}

	/**
	 * Returns all the staging notes.
	 *
	 * @return the staging notes
	 */
	public static List<StagingNote> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<StagingNote> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<StagingNote> findAll(
		int start, int end, OrderByComparator<StagingNote> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<StagingNote> findAll(
		int start, int end, OrderByComparator<StagingNote> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging notes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging notes.
	 *
	 * @return the number of staging notes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingNotePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingNotePersistence, StagingNotePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingNotePersistence.class);

		ServiceTracker<StagingNotePersistence, StagingNotePersistence>
			serviceTracker =
				new ServiceTracker
					<StagingNotePersistence, StagingNotePersistence>(
						bundle.getBundleContext(), StagingNotePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}