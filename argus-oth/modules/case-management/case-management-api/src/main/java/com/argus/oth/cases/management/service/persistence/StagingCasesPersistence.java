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

import com.argus.oth.cases.management.exception.NoSuchStagingCasesException;
import com.argus.oth.cases.management.model.StagingCases;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging cases service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingCasesUtil
 * @generated
 */
@ProviderType
public interface StagingCasesPersistence extends BasePersistence<StagingCases> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingCasesUtil} to access the staging cases persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the staging cases where externalCaseId = &#63; or throws a <code>NoSuchStagingCasesException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	public StagingCases findByExternalCaseId(String externalCaseId)
		throws NoSuchStagingCasesException;

	/**
	 * Returns the staging cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public StagingCases fetchByExternalCaseId(String externalCaseId);

	/**
	 * Returns the staging cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public StagingCases fetchByExternalCaseId(
		String externalCaseId, boolean useFinderCache);

	/**
	 * Removes the staging cases where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @return the staging cases that was removed
	 */
	public StagingCases removeByExternalCaseId(String externalCaseId)
		throws NoSuchStagingCasesException;

	/**
	 * Returns the number of staging caseses where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching staging caseses
	 */
	public int countByExternalCaseId(String externalCaseId);

	/**
	 * Returns all the staging caseses where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching staging caseses
	 */
	public java.util.List<StagingCases> findByRowProcessed(
		boolean rowProcessed);

	/**
	 * Returns a range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of matching staging caseses
	 */
	public java.util.List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end);

	/**
	 * Returns an ordered range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging caseses
	 */
	public java.util.List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging caseses
	 */
	public java.util.List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	public StagingCases findByRowProcessed_First(
			boolean rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
				orderByComparator)
		throws NoSuchStagingCasesException;

	/**
	 * Returns the first staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public StagingCases fetchByRowProcessed_First(
		boolean rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
			orderByComparator);

	/**
	 * Returns the last staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	public StagingCases findByRowProcessed_Last(
			boolean rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
				orderByComparator)
		throws NoSuchStagingCasesException;

	/**
	 * Returns the last staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	public StagingCases fetchByRowProcessed_Last(
		boolean rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
			orderByComparator);

	/**
	 * Returns the staging caseses before and after the current staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param stagingCaseId the primary key of the current staging cases
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	public StagingCases[] findByRowProcessed_PrevAndNext(
			long stagingCaseId, boolean rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
				orderByComparator)
		throws NoSuchStagingCasesException;

	/**
	 * Removes all the staging caseses where rowProcessed = &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(boolean rowProcessed);

	/**
	 * Returns the number of staging caseses where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching staging caseses
	 */
	public int countByRowProcessed(boolean rowProcessed);

	/**
	 * Caches the staging cases in the entity cache if it is enabled.
	 *
	 * @param stagingCases the staging cases
	 */
	public void cacheResult(StagingCases stagingCases);

	/**
	 * Caches the staging caseses in the entity cache if it is enabled.
	 *
	 * @param stagingCaseses the staging caseses
	 */
	public void cacheResult(java.util.List<StagingCases> stagingCaseses);

	/**
	 * Creates a new staging cases with the primary key. Does not add the staging cases to the database.
	 *
	 * @param stagingCaseId the primary key for the new staging cases
	 * @return the new staging cases
	 */
	public StagingCases create(long stagingCaseId);

	/**
	 * Removes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	public StagingCases remove(long stagingCaseId)
		throws NoSuchStagingCasesException;

	public StagingCases updateImpl(StagingCases stagingCases);

	/**
	 * Returns the staging cases with the primary key or throws a <code>NoSuchStagingCasesException</code> if it could not be found.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	public StagingCases findByPrimaryKey(long stagingCaseId)
		throws NoSuchStagingCasesException;

	/**
	 * Returns the staging cases with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases, or <code>null</code> if a staging cases with the primary key could not be found
	 */
	public StagingCases fetchByPrimaryKey(long stagingCaseId);

	/**
	 * Returns all the staging caseses.
	 *
	 * @return the staging caseses
	 */
	public java.util.List<StagingCases> findAll();

	/**
	 * Returns a range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of staging caseses
	 */
	public java.util.List<StagingCases> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging caseses
	 */
	public java.util.List<StagingCases> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging caseses
	 */
	public java.util.List<StagingCases> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingCases>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging caseses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging caseses.
	 *
	 * @return the number of staging caseses
	 */
	public int countAll();

}