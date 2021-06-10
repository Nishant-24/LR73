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

package com.argus.oth.cases.management.service.persistence.impl;

import com.argus.oth.cases.management.exception.NoSuchClientException;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.model.impl.ClientImpl;
import com.argus.oth.cases.management.model.impl.ClientModelImpl;
import com.argus.oth.cases.management.service.persistence.ClientPersistence;
import com.argus.oth.cases.management.service.persistence.impl.constants.OTHPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClientPersistence.class)
public class ClientPersistenceImpl
	extends BasePersistenceImpl<Client> implements ClientPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClientUtil</code> to access the client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClientImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByExternalClientPk;
	private FinderPath _finderPathCountByExternalClientPk;

	/**
	 * Returns the client where externalClientPk = &#63; or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param externalClientPk the external client pk
	 * @return the matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	@Override
	public Client findByExternalClientPk(long externalClientPk)
		throws NoSuchClientException {

		Client client = fetchByExternalClientPk(externalClientPk);

		if (client == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalClientPk=");
			sb.append(externalClientPk);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClientException(sb.toString());
		}

		return client;
	}

	/**
	 * Returns the client where externalClientPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientPk the external client pk
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	@Override
	public Client fetchByExternalClientPk(long externalClientPk) {
		return fetchByExternalClientPk(externalClientPk, true);
	}

	/**
	 * Returns the client where externalClientPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientPk the external client pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	@Override
	public Client fetchByExternalClientPk(
		long externalClientPk, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalClientPk};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalClientPk, finderArgs, this);
		}

		if (result instanceof Client) {
			Client client = (Client)result;

			if (externalClientPk != client.getExternalClientPk()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLIENT_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLIENTPK_EXTERNALCLIENTPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientPk);

				List<Client> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalClientPk, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {externalClientPk};
							}

							_log.warn(
								"ClientPersistenceImpl.fetchByExternalClientPk(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Client client = list.get(0);

					result = client;

					cacheResult(client);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalClientPk, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Client)result;
		}
	}

	/**
	 * Removes the client where externalClientPk = &#63; from the database.
	 *
	 * @param externalClientPk the external client pk
	 * @return the client that was removed
	 */
	@Override
	public Client removeByExternalClientPk(long externalClientPk)
		throws NoSuchClientException {

		Client client = findByExternalClientPk(externalClientPk);

		return remove(client);
	}

	/**
	 * Returns the number of clients where externalClientPk = &#63;.
	 *
	 * @param externalClientPk the external client pk
	 * @return the number of matching clients
	 */
	@Override
	public int countByExternalClientPk(long externalClientPk) {
		FinderPath finderPath = _finderPathCountByExternalClientPk;

		Object[] finderArgs = new Object[] {externalClientPk};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENT_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLIENTPK_EXTERNALCLIENTPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientPk);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_EXTERNALCLIENTPK_EXTERNALCLIENTPK_2 =
			"client.externalClientPk = ?";

	private FinderPath _finderPathFetchByExternalClientId;
	private FinderPath _finderPathCountByExternalClientId;

	/**
	 * Returns the client where externalClientId = &#63; or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	@Override
	public Client findByExternalClientId(long externalClientId)
		throws NoSuchClientException {

		Client client = fetchByExternalClientId(externalClientId);

		if (client == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalClientId=");
			sb.append(externalClientId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClientException(sb.toString());
		}

		return client;
	}

	/**
	 * Returns the client where externalClientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	@Override
	public Client fetchByExternalClientId(long externalClientId) {
		return fetchByExternalClientId(externalClientId, true);
	}

	/**
	 * Returns the client where externalClientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientId the external client ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client, or <code>null</code> if a matching client could not be found
	 */
	@Override
	public Client fetchByExternalClientId(
		long externalClientId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalClientId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalClientId, finderArgs, this);
		}

		if (result instanceof Client) {
			Client client = (Client)result;

			if (externalClientId != client.getExternalClientId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLIENT_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLIENTID_EXTERNALCLIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientId);

				List<Client> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalClientId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {externalClientId};
							}

							_log.warn(
								"ClientPersistenceImpl.fetchByExternalClientId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Client client = list.get(0);

					result = client;

					cacheResult(client);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalClientId, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Client)result;
		}
	}

	/**
	 * Removes the client where externalClientId = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 * @return the client that was removed
	 */
	@Override
	public Client removeByExternalClientId(long externalClientId)
		throws NoSuchClientException {

		Client client = findByExternalClientId(externalClientId);

		return remove(client);
	}

	/**
	 * Returns the number of clients where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the number of matching clients
	 */
	@Override
	public int countByExternalClientId(long externalClientId) {
		FinderPath finderPath = _finderPathCountByExternalClientId;

		Object[] finderArgs = new Object[] {externalClientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENT_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLIENTID_EXTERNALCLIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_EXTERNALCLIENTID_EXTERNALCLIENTID_2 =
			"client.externalClientId = ?";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the clients where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching clients
	 */
	@Override
	public List<Client> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Client> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

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
	@Override
	public List<Client> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Client> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Client> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Client> orderByComparator, boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<Client> list = null;

		if (useFinderCache) {
			list = (List<Client>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Client client : list) {
					if (rowProcessed.equals(client.getRowProcessed())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLIENT_WHERE);

			boolean bindRowProcessed = false;

			if (rowProcessed.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3);
			}
			else {
				bindRowProcessed = true;

				sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRowProcessed) {
					queryPos.add(rowProcessed);
				}

				list = (List<Client>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	@Override
	public Client findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException {

		Client client = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (client != null) {
			return client;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClientException(sb.toString());
	}

	/**
	 * Returns the first client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client, or <code>null</code> if a matching client could not be found
	 */
	@Override
	public Client fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Client> orderByComparator) {

		List<Client> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client
	 * @throws NoSuchClientException if a matching client could not be found
	 */
	@Override
	public Client findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException {

		Client client = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (client != null) {
			return client;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClientException(sb.toString());
	}

	/**
	 * Returns the last client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client, or <code>null</code> if a matching client could not be found
	 */
	@Override
	public Client fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Client> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<Client> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clients before and after the current client in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param clientId the primary key of the current client
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	@Override
	public Client[] findByRowProcessed_PrevAndNext(
			long clientId, String rowProcessed,
			OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException {

		rowProcessed = Objects.toString(rowProcessed, "");

		Client client = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			Client[] array = new ClientImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, client, rowProcessed, orderByComparator, true);

			array[1] = client;

			array[2] = getByRowProcessed_PrevAndNext(
				session, client, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Client getByRowProcessed_PrevAndNext(
		Session session, Client client, String rowProcessed,
		OrderByComparator<Client> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENT_WHERE);

		boolean bindRowProcessed = false;

		if (rowProcessed.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3);
		}
		else {
			bindRowProcessed = true;

			sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRowProcessed) {
			queryPos.add(rowProcessed);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(client)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Client> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clients where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (Client client :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(client);
		}
	}

	/**
	 * Returns the number of clients where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching clients
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENT_WHERE);

			boolean bindRowProcessed = false;

			if (rowProcessed.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3);
			}
			else {
				bindRowProcessed = true;

				sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRowProcessed) {
					queryPos.add(rowProcessed);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2 =
		"client.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(client.rowProcessed IS NULL OR client.rowProcessed != '')";

	public ClientPersistenceImpl() {
		setModelClass(Client.class);

		setModelImplClass(ClientImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the client in the entity cache if it is enabled.
	 *
	 * @param client the client
	 */
	@Override
	public void cacheResult(Client client) {
		entityCache.putResult(
			entityCacheEnabled, ClientImpl.class, client.getPrimaryKey(),
			client);

		finderCache.putResult(
			_finderPathFetchByExternalClientPk,
			new Object[] {client.getExternalClientPk()}, client);

		finderCache.putResult(
			_finderPathFetchByExternalClientId,
			new Object[] {client.getExternalClientId()}, client);

		client.resetOriginalValues();
	}

	/**
	 * Caches the clients in the entity cache if it is enabled.
	 *
	 * @param clients the clients
	 */
	@Override
	public void cacheResult(List<Client> clients) {
		for (Client client : clients) {
			if (entityCache.getResult(
					entityCacheEnabled, ClientImpl.class,
					client.getPrimaryKey()) == null) {

				cacheResult(client);
			}
			else {
				client.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all clients.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClientImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the client.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Client client) {
		entityCache.removeResult(
			entityCacheEnabled, ClientImpl.class, client.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ClientModelImpl)client, true);
	}

	@Override
	public void clearCache(List<Client> clients) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Client client : clients) {
			entityCache.removeResult(
				entityCacheEnabled, ClientImpl.class, client.getPrimaryKey());

			clearUniqueFindersCache((ClientModelImpl)client, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ClientImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ClientModelImpl clientModelImpl) {
		Object[] args = new Object[] {clientModelImpl.getExternalClientPk()};

		finderCache.putResult(
			_finderPathCountByExternalClientPk, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalClientPk, args, clientModelImpl, false);

		args = new Object[] {clientModelImpl.getExternalClientId()};

		finderCache.putResult(
			_finderPathCountByExternalClientId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalClientId, args, clientModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ClientModelImpl clientModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				clientModelImpl.getExternalClientPk()
			};

			finderCache.removeResult(_finderPathCountByExternalClientPk, args);
			finderCache.removeResult(_finderPathFetchByExternalClientPk, args);
		}

		if ((clientModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalClientPk.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				clientModelImpl.getOriginalExternalClientPk()
			};

			finderCache.removeResult(_finderPathCountByExternalClientPk, args);
			finderCache.removeResult(_finderPathFetchByExternalClientPk, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				clientModelImpl.getExternalClientId()
			};

			finderCache.removeResult(_finderPathCountByExternalClientId, args);
			finderCache.removeResult(_finderPathFetchByExternalClientId, args);
		}

		if ((clientModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalClientId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				clientModelImpl.getOriginalExternalClientId()
			};

			finderCache.removeResult(_finderPathCountByExternalClientId, args);
			finderCache.removeResult(_finderPathFetchByExternalClientId, args);
		}
	}

	/**
	 * Creates a new client with the primary key. Does not add the client to the database.
	 *
	 * @param clientId the primary key for the new client
	 * @return the new client
	 */
	@Override
	public Client create(long clientId) {
		Client client = new ClientImpl();

		client.setNew(true);
		client.setPrimaryKey(clientId);

		client.setCompanyId(CompanyThreadLocal.getCompanyId());

		return client;
	}

	/**
	 * Removes the client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client
	 * @return the client that was removed
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	@Override
	public Client remove(long clientId) throws NoSuchClientException {
		return remove((Serializable)clientId);
	}

	/**
	 * Removes the client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the client
	 * @return the client that was removed
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	@Override
	public Client remove(Serializable primaryKey) throws NoSuchClientException {
		Session session = null;

		try {
			session = openSession();

			Client client = (Client)session.get(ClientImpl.class, primaryKey);

			if (client == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(client);
		}
		catch (NoSuchClientException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Client removeImpl(Client client) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(client)) {
				client = (Client)session.get(
					ClientImpl.class, client.getPrimaryKeyObj());
			}

			if (client != null) {
				session.delete(client);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (client != null) {
			clearCache(client);
		}

		return client;
	}

	@Override
	public Client updateImpl(Client client) {
		boolean isNew = client.isNew();

		if (!(client instanceof ClientModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(client.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(client);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in client proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Client implementation " +
					client.getClass());
		}

		ClientModelImpl clientModelImpl = (ClientModelImpl)client;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (client.getCreateDate() == null)) {
			if (serviceContext == null) {
				client.setCreateDate(now);
			}
			else {
				client.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!clientModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				client.setModifiedDate(now);
			}
			else {
				client.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(client);

				client.setNew(false);
			}
			else {
				client = (Client)session.merge(client);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, ClientImpl.class, client.getPrimaryKey(),
			client, false);

		clearUniqueFindersCache(clientModelImpl, false);
		cacheUniqueFindersCache(clientModelImpl);

		client.resetOriginalValues();

		return client;
	}

	/**
	 * Returns the client with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the client
	 * @return the client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	@Override
	public Client findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientException {

		Client client = fetchByPrimaryKey(primaryKey);

		if (client == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return client;
	}

	/**
	 * Returns the client with the primary key or throws a <code>NoSuchClientException</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client
	 * @return the client
	 * @throws NoSuchClientException if a client with the primary key could not be found
	 */
	@Override
	public Client findByPrimaryKey(long clientId) throws NoSuchClientException {
		return findByPrimaryKey((Serializable)clientId);
	}

	/**
	 * Returns the client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client
	 * @return the client, or <code>null</code> if a client with the primary key could not be found
	 */
	@Override
	public Client fetchByPrimaryKey(long clientId) {
		return fetchByPrimaryKey((Serializable)clientId);
	}

	/**
	 * Returns all the clients.
	 *
	 * @return the clients
	 */
	@Override
	public List<Client> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Client> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Client> findAll(
		int start, int end, OrderByComparator<Client> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Client> findAll(
		int start, int end, OrderByComparator<Client> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Client> list = null;

		if (useFinderCache) {
			list = (List<Client>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLIENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENT;

				sql = sql.concat(ClientModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Client>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the clients from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Client client : findAll()) {
			remove(client);
		}
	}

	/**
	 * Returns the number of clients.
	 *
	 * @return the number of clients
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLIENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "clientId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLIENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClientModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the client persistence.
	 */
	@Activate
	public void activate() {
		ClientModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClientModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByExternalClientPk = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalClientPk",
			new String[] {Long.class.getName()},
			ClientModelImpl.EXTERNALCLIENTPK_COLUMN_BITMASK);

		_finderPathCountByExternalClientPk = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalClientPk", new String[] {Long.class.getName()});

		_finderPathFetchByExternalClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalClientId",
			new String[] {Long.class.getName()},
			ClientModelImpl.EXTERNALCLIENTID_COLUMN_BITMASK);

		_finderPathCountByExternalClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalClientId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRowProcessed",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRowProcessed",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ClientImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = OTHPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.Client"),
			true);
	}

	@Override
	@Reference(
		target = OTHPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OTHPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CLIENT =
		"SELECT client FROM Client client";

	private static final String _SQL_SELECT_CLIENT_WHERE =
		"SELECT client FROM Client client WHERE ";

	private static final String _SQL_COUNT_CLIENT =
		"SELECT COUNT(client) FROM Client client";

	private static final String _SQL_COUNT_CLIENT_WHERE =
		"SELECT COUNT(client) FROM Client client WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "client.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Client exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Client exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClientPersistenceImpl.class);

}