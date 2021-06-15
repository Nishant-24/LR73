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

import com.argus.oth.cases.management.exception.NoSuchStagingAuthProcedureException;
import com.argus.oth.cases.management.model.StagingAuthProcedure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging auth procedure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthProcedureUtil
 * @generated
 */
@ProviderType
public interface StagingAuthProcedurePersistence
	extends BasePersistence<StagingAuthProcedure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingAuthProcedureUtil} to access the staging auth procedure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging auth procedure in the entity cache if it is enabled.
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 */
	public void cacheResult(StagingAuthProcedure stagingAuthProcedure);

	/**
	 * Caches the staging auth procedures in the entity cache if it is enabled.
	 *
	 * @param stagingAuthProcedures the staging auth procedures
	 */
	public void cacheResult(
		java.util.List<StagingAuthProcedure> stagingAuthProcedures);

	/**
	 * Creates a new staging auth procedure with the primary key. Does not add the staging auth procedure to the database.
	 *
	 * @param stagingAuthProcedureId the primary key for the new staging auth procedure
	 * @return the new staging auth procedure
	 */
	public StagingAuthProcedure create(long stagingAuthProcedureId);

	/**
	 * Removes the staging auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure that was removed
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	public StagingAuthProcedure remove(long stagingAuthProcedureId)
		throws NoSuchStagingAuthProcedureException;

	public StagingAuthProcedure updateImpl(
		StagingAuthProcedure stagingAuthProcedure);

	/**
	 * Returns the staging auth procedure with the primary key or throws a <code>NoSuchStagingAuthProcedureException</code> if it could not be found.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	public StagingAuthProcedure findByPrimaryKey(long stagingAuthProcedureId)
		throws NoSuchStagingAuthProcedureException;

	/**
	 * Returns the staging auth procedure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure, or <code>null</code> if a staging auth procedure with the primary key could not be found
	 */
	public StagingAuthProcedure fetchByPrimaryKey(long stagingAuthProcedureId);

	/**
	 * Returns all the staging auth procedures.
	 *
	 * @return the staging auth procedures
	 */
	public java.util.List<StagingAuthProcedure> findAll();

	/**
	 * Returns a range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @return the range of staging auth procedures
	 */
	public java.util.List<StagingAuthProcedure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging auth procedures
	 */
	public java.util.List<StagingAuthProcedure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthProcedure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging auth procedures
	 */
	public java.util.List<StagingAuthProcedure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthProcedure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging auth procedures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging auth procedures.
	 *
	 * @return the number of staging auth procedures
	 */
	public int countAll();

}