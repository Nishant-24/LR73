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

import com.argus.oth.cases.management.exception.NoSuchClientException;
import com.argus.oth.cases.management.model.Client;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientUtil
 * @generated
 */
@ProviderType
public interface ClientPersistence extends BasePersistence<Client> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientUtil} to access the client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the client where externalClientPk = &#63; or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param externalClientPk the external client pk
	 * @return the matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public Client findByExternalClientPk(long externalClientPk)
		throws NoSuchClientException;

	/**
	 * Returns the client where externalClientPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientPk the external client pk
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public Client fetchByExternalClientPk(long externalClientPk);

	/**
	 * Returns the client where externalClientPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientPk the external client pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public Client fetchByExternalClientPk(
		long externalClientPk, boolean useFinderCache);

	/**
	 * Removes the client where externalClientPk = &#63; from the database.
	 *
	 * @param externalClientPk the external client pk
	 * @return the client that was removed
	 */
	public Client removeByExternalClientPk(long externalClientPk)
		throws NoSuchClientException;

	/**
	 * Returns the number of clients where externalClientPk = &#63;.
	 *
	 * @param externalClientPk the external client pk
	 * @return the number of matching clients
	 */
	public int countByExternalClientPk(long externalClientPk);

	/**
	 * Returns the client where externalClientId = &#63; or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public Client findByExternalClientId(long externalClientId)
		throws NoSuchClientException;

	/**
	 * Returns the client where externalClientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public Client fetchByExternalClientId(long externalClientId);

	/**
	 * Returns the client where externalClientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientId the external client ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	public Client fetchByExternalClientId(
		long externalClientId, boolean useFinderCache);

	/**
	 * Removes the client where externalClientId = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 * @return the client that was removed
	 */
	public Client removeByExternalClientId(long externalClientId)
		throws NoSuchClientException;

	/**
	 * Returns the number of clients where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the number of matching clients
	 */
	public int countByExternalClientId(long externalClientId);

	/**
	 * Returns all the clients where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching clients
	 */
	public java.util.List<Client> findByRowProcessed(String rowProcessed);

	/**
	 * Returns a range of all the clients where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @return the range of matching clients
	 */
	public java.util.List<Client> findByRowProcessed(
		String rowProcessed, int start, int end);

	/**
	 * Returns an ordered range of all the clients where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clients
	 */
	public java.util.List<Client> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client>
			orderByComparator);

	/**
	 * Returns an ordered range of all the clients where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clients
	 */
	public java.util.List<Client> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public Client findByRowProcessed_First(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Client>
				orderByComparator)
		throws NoSuchClientException;

	/**
	 * Returns the first client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client, or <code>null</code> if a matching client could not be found
	 */
	public Client fetchByRowProcessed_First(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<Client>
			orderByComparator);

	/**
	 * Returns the last client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	public Client findByRowProcessed_Last(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Client>
				orderByComparator)
		throws NoSuchClientException;

	/**
	 * Returns the last client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client, or <code>null</code> if a matching client could not be found
	 */
	public Client fetchByRowProcessed_Last(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<Client>
			orderByComparator);

	/**
	 * Returns the clients before and after the current client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param clientId the primary key of the current client
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	public Client[] findByRowProcessed_PrevAndNext(
			long clientId, String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<Client>
				orderByComparator)
		throws NoSuchClientException;

	/**
	 * Removes all the clients where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(String rowProcessed);

	/**
	 * Returns the number of clients where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching clients
	 */
	public int countByRowProcessed(String rowProcessed);

	/**
	 * Caches the client in the entity cache if it is enabled.
	 *
	 * @param client the client
	 */
	public void cacheResult(Client client);

	/**
	 * Caches the clients in the entity cache if it is enabled.
	 *
	 * @param clients the clients
	 */
	public void cacheResult(java.util.List<Client> clients);

	/**
	 * Creates a new client with the primary key. Does not add the client to the database.
	 *
	 * @param clientId the primary key for the new client
	 * @return the new client
	 */
	public Client create(long clientId);

	/**
	 * Removes the client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client
	 * @return the client that was removed
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	public Client remove(long clientId) throws NoSuchClientException;

	public Client updateImpl(Client client);

	/**
	 * Returns the client with the primary key or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client
	 * @return the client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	public Client findByPrimaryKey(long clientId) throws NoSuchClientException;

	/**
	 * Returns the client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client
	 * @return the client, or <code>null</code> if a client with the primary key could not be found
	 */
	public Client fetchByPrimaryKey(long clientId);

	/**
	 * Returns all the clients.
	 *
	 * @return the clients
	 */
	public java.util.List<Client> findAll();

	/**
	 * Returns a range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @return the range of clients
	 */
	public java.util.List<Client> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clients
	 */
	public java.util.List<Client> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client>
			orderByComparator);

	/**
	 * Returns an ordered range of all the clients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clients
	 * @param end the upper bound of the range of clients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clients
	 */
	public java.util.List<Client> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clients from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clients.
	 *
	 * @return the number of clients
	 */
	public int countAll();

}