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

import com.argus.oth.cases.management.exception.NoSuchStagingClientException;
import com.argus.oth.cases.management.model.StagingClient;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClientUtil
 * @generated
 */
@ProviderType
public interface StagingClientPersistence
	extends BasePersistence<StagingClient> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingClientUtil} to access the staging client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the staging clients where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching staging clients
	 */
	public java.util.List<StagingClient> findByClientId(String clientId);

	/**
	 * Returns a range of all the staging clients where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of matching staging clients
	 */
	public java.util.List<StagingClient> findByClientId(
		String clientId, int start, int end);

	/**
	 * Returns an ordered range of all the staging clients where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging clients
	 */
	public java.util.List<StagingClient> findByClientId(
		String clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging clients where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging clients
	 */
	public java.util.List<StagingClient> findByClientId(
		String clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public StagingClient findByClientId_First(
			String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
				orderByComparator)
		throws NoSuchStagingClientException;

	/**
	 * Returns the first staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public StagingClient fetchByClientId_First(
		String clientId,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns the last staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public StagingClient findByClientId_Last(
			String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
				orderByComparator)
		throws NoSuchStagingClientException;

	/**
	 * Returns the last staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public StagingClient fetchByClientId_Last(
		String clientId,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns the staging clients before and after the current staging client in the ordered set where clientId = &#63;.
	 *
	 * @param stagingClientId the primary key of the current staging client
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public StagingClient[] findByClientId_PrevAndNext(
			long stagingClientId, String clientId,
			com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
				orderByComparator)
		throws NoSuchStagingClientException;

	/**
	 * Removes all the staging clients where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	public void removeByClientId(String clientId);

	/**
	 * Returns the number of staging clients where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching staging clients
	 */
	public int countByClientId(String clientId);

	/**
	 * Returns all the staging clients where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching staging clients
	 */
	public java.util.List<StagingClient> findByRowProcessed(
		boolean rowProcessed);

	/**
	 * Returns a range of all the staging clients where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of matching staging clients
	 */
	public java.util.List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end);

	/**
	 * Returns an ordered range of all the staging clients where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging clients
	 */
	public java.util.List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging clients where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging clients
	 */
	public java.util.List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public StagingClient findByRowProcessed_First(
			boolean rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
				orderByComparator)
		throws NoSuchStagingClientException;

	/**
	 * Returns the first staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public StagingClient fetchByRowProcessed_First(
		boolean rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns the last staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	public StagingClient findByRowProcessed_Last(
			boolean rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
				orderByComparator)
		throws NoSuchStagingClientException;

	/**
	 * Returns the last staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	public StagingClient fetchByRowProcessed_Last(
		boolean rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns the staging clients before and after the current staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param stagingClientId the primary key of the current staging client
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public StagingClient[] findByRowProcessed_PrevAndNext(
			long stagingClientId, boolean rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
				orderByComparator)
		throws NoSuchStagingClientException;

	/**
	 * Removes all the staging clients where rowProcessed = &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(boolean rowProcessed);

	/**
	 * Returns the number of staging clients where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching staging clients
	 */
	public int countByRowProcessed(boolean rowProcessed);

	/**
	 * Caches the staging client in the entity cache if it is enabled.
	 *
	 * @param stagingClient the staging client
	 */
	public void cacheResult(StagingClient stagingClient);

	/**
	 * Caches the staging clients in the entity cache if it is enabled.
	 *
	 * @param stagingClients the staging clients
	 */
	public void cacheResult(java.util.List<StagingClient> stagingClients);

	/**
	 * Creates a new staging client with the primary key. Does not add the staging client to the database.
	 *
	 * @param stagingClientId the primary key for the new staging client
	 * @return the new staging client
	 */
	public StagingClient create(long stagingClientId);

	/**
	 * Removes the staging client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client that was removed
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public StagingClient remove(long stagingClientId)
		throws NoSuchStagingClientException;

	public StagingClient updateImpl(StagingClient stagingClient);

	/**
	 * Returns the staging client with the primary key or throws a <code>NoSuchStagingClientException</code> if it could not be found.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	public StagingClient findByPrimaryKey(long stagingClientId)
		throws NoSuchStagingClientException;

	/**
	 * Returns the staging client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client, or <code>null</code> if a staging client with the primary key could not be found
	 */
	public StagingClient fetchByPrimaryKey(long stagingClientId);

	/**
	 * Returns all the staging clients.
	 *
	 * @return the staging clients
	 */
	public java.util.List<StagingClient> findAll();

	/**
	 * Returns a range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @return the range of staging clients
	 */
	public java.util.List<StagingClient> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging clients
	 */
	public java.util.List<StagingClient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the staging clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging clients
	 * @param end the upper bound of the range of staging clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging clients
	 */
	public java.util.List<StagingClient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingClient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging clients from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging clients.
	 *
	 * @return the number of staging clients
	 */
	public int countAll();

}