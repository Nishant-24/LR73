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

import com.argus.oth.cases.management.exception.NoSuchStagingAuthorizationException;
import com.argus.oth.cases.management.model.StagingAuthorization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging authorization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthorizationUtil
 * @generated
 */
@ProviderType
public interface StagingAuthorizationPersistence
	extends BasePersistence<StagingAuthorization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingAuthorizationUtil} to access the staging authorization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the staging authorizations where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging authorizations
	 */
	public java.util.List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId);

	/**
	 * Returns a range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of matching staging authorizations
	 */
	public java.util.List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end);

	/**
	 * Returns an ordered range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging authorizations
	 */
	public java.util.List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthorization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging authorizations
	 */
	public java.util.List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging authorization
	 * @throws NoSuchStagingAuthorizationException if a matching staging authorization could not be found
	 */
	public StagingAuthorization findByExternalCaseId_First(
			long externalCaseId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StagingAuthorization> orderByComparator)
		throws NoSuchStagingAuthorizationException;

	/**
	 * Returns the first staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging authorization, or <code>null</code> if a matching staging authorization could not be found
	 */
	public StagingAuthorization fetchByExternalCaseId_First(
		long externalCaseId,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthorization>
			orderByComparator);

	/**
	 * Returns the last staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging authorization
	 * @throws NoSuchStagingAuthorizationException if a matching staging authorization could not be found
	 */
	public StagingAuthorization findByExternalCaseId_Last(
			long externalCaseId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StagingAuthorization> orderByComparator)
		throws NoSuchStagingAuthorizationException;

	/**
	 * Returns the last staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging authorization, or <code>null</code> if a matching staging authorization could not be found
	 */
	public StagingAuthorization fetchByExternalCaseId_Last(
		long externalCaseId,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthorization>
			orderByComparator);

	/**
	 * Returns the staging authorizations before and after the current staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param stagingAuthorizationId the primary key of the current staging authorization
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	public StagingAuthorization[] findByExternalCaseId_PrevAndNext(
			long stagingAuthorizationId, long externalCaseId,
			com.liferay.portal.kernel.util.OrderByComparator
				<StagingAuthorization> orderByComparator)
		throws NoSuchStagingAuthorizationException;

	/**
	 * Removes all the staging authorizations where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 */
	public void removeByExternalCaseId(long externalCaseId);

	/**
	 * Returns the number of staging authorizations where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching staging authorizations
	 */
	public int countByExternalCaseId(long externalCaseId);

	/**
	 * Caches the staging authorization in the entity cache if it is enabled.
	 *
	 * @param stagingAuthorization the staging authorization
	 */
	public void cacheResult(StagingAuthorization stagingAuthorization);

	/**
	 * Caches the staging authorizations in the entity cache if it is enabled.
	 *
	 * @param stagingAuthorizations the staging authorizations
	 */
	public void cacheResult(
		java.util.List<StagingAuthorization> stagingAuthorizations);

	/**
	 * Creates a new staging authorization with the primary key. Does not add the staging authorization to the database.
	 *
	 * @param stagingAuthorizationId the primary key for the new staging authorization
	 * @return the new staging authorization
	 */
	public StagingAuthorization create(long stagingAuthorizationId);

	/**
	 * Removes the staging authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization that was removed
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	public StagingAuthorization remove(long stagingAuthorizationId)
		throws NoSuchStagingAuthorizationException;

	public StagingAuthorization updateImpl(
		StagingAuthorization stagingAuthorization);

	/**
	 * Returns the staging authorization with the primary key or throws a <code>NoSuchStagingAuthorizationException</code> if it could not be found.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	public StagingAuthorization findByPrimaryKey(long stagingAuthorizationId)
		throws NoSuchStagingAuthorizationException;

	/**
	 * Returns the staging authorization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization, or <code>null</code> if a staging authorization with the primary key could not be found
	 */
	public StagingAuthorization fetchByPrimaryKey(long stagingAuthorizationId);

	/**
	 * Returns all the staging authorizations.
	 *
	 * @return the staging authorizations
	 */
	public java.util.List<StagingAuthorization> findAll();

	/**
	 * Returns a range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of staging authorizations
	 */
	public java.util.List<StagingAuthorization> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging authorizations
	 */
	public java.util.List<StagingAuthorization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthorization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging authorizations
	 */
	public java.util.List<StagingAuthorization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingAuthorization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging authorizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging authorizations.
	 *
	 * @return the number of staging authorizations
	 */
	public int countAll();

}