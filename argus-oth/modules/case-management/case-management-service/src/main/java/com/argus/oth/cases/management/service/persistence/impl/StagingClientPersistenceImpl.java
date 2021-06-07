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

import com.argus.oth.cases.management.exception.NoSuchStagingClientException;
import com.argus.oth.cases.management.model.StagingClient;
import com.argus.oth.cases.management.model.impl.StagingClientImpl;
import com.argus.oth.cases.management.model.impl.StagingClientModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingClientPersistence;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the staging client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingClientPersistence.class)
public class StagingClientPersistenceImpl
	extends BasePersistenceImpl<StagingClient>
	implements StagingClientPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingClientUtil</code> to access the staging client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingClientImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByClientId;
	private FinderPath _finderPathWithoutPaginationFindByClientId;
	private FinderPath _finderPathCountByClientId;

	/**
	 * Returns all the staging clients where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching staging clients
	 */
	@Override
	public List<StagingClient> findByClientId(String clientId) {
		return findByClientId(
			clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StagingClient> findByClientId(
		String clientId, int start, int end) {

		return findByClientId(clientId, start, end, null);
	}

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
	@Override
	public List<StagingClient> findByClientId(
		String clientId, int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return findByClientId(clientId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StagingClient> findByClientId(
		String clientId, int start, int end,
		OrderByComparator<StagingClient> orderByComparator,
		boolean useFinderCache) {

		clientId = Objects.toString(clientId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByClientId;
				finderArgs = new Object[] {clientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByClientId;
			finderArgs = new Object[] {clientId, start, end, orderByComparator};
		}

		List<StagingClient> list = null;

		if (useFinderCache) {
			list = (List<StagingClient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StagingClient stagingClient : list) {
					if (!clientId.equals(stagingClient.getClientId())) {
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

			sb.append(_SQL_SELECT_STAGINGCLIENT_WHERE);

			boolean bindClientId = false;

			if (clientId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_3);
			}
			else {
				bindClientId = true;

				sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StagingClientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClientId) {
					queryPos.add(clientId);
				}

				list = (List<StagingClient>)QueryUtil.list(
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
	 * Returns the first staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	@Override
	public StagingClient findByClientId_First(
			String clientId, OrderByComparator<StagingClient> orderByComparator)
		throws NoSuchStagingClientException {

		StagingClient stagingClient = fetchByClientId_First(
			clientId, orderByComparator);

		if (stagingClient != null) {
			return stagingClient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("clientId=");
		sb.append(clientId);

		sb.append("}");

		throw new NoSuchStagingClientException(sb.toString());
	}

	/**
	 * Returns the first staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	@Override
	public StagingClient fetchByClientId_First(
		String clientId, OrderByComparator<StagingClient> orderByComparator) {

		List<StagingClient> list = findByClientId(
			clientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	@Override
	public StagingClient findByClientId_Last(
			String clientId, OrderByComparator<StagingClient> orderByComparator)
		throws NoSuchStagingClientException {

		StagingClient stagingClient = fetchByClientId_Last(
			clientId, orderByComparator);

		if (stagingClient != null) {
			return stagingClient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("clientId=");
		sb.append(clientId);

		sb.append("}");

		throw new NoSuchStagingClientException(sb.toString());
	}

	/**
	 * Returns the last staging client in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	@Override
	public StagingClient fetchByClientId_Last(
		String clientId, OrderByComparator<StagingClient> orderByComparator) {

		int count = countByClientId(clientId);

		if (count == 0) {
			return null;
		}

		List<StagingClient> list = findByClientId(
			clientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staging clients before and after the current staging client in the ordered set where clientId = &#63;.
	 *
	 * @param stagingClientId the primary key of the current staging client
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient[] findByClientId_PrevAndNext(
			long stagingClientId, String clientId,
			OrderByComparator<StagingClient> orderByComparator)
		throws NoSuchStagingClientException {

		clientId = Objects.toString(clientId, "");

		StagingClient stagingClient = findByPrimaryKey(stagingClientId);

		Session session = null;

		try {
			session = openSession();

			StagingClient[] array = new StagingClientImpl[3];

			array[0] = getByClientId_PrevAndNext(
				session, stagingClient, clientId, orderByComparator, true);

			array[1] = stagingClient;

			array[2] = getByClientId_PrevAndNext(
				session, stagingClient, clientId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StagingClient getByClientId_PrevAndNext(
		Session session, StagingClient stagingClient, String clientId,
		OrderByComparator<StagingClient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAGINGCLIENT_WHERE);

		boolean bindClientId = false;

		if (clientId.isEmpty()) {
			sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_3);
		}
		else {
			bindClientId = true;

			sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);
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
			sb.append(StagingClientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindClientId) {
			queryPos.add(clientId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stagingClient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StagingClient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staging clients where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	@Override
	public void removeByClientId(String clientId) {
		for (StagingClient stagingClient :
				findByClientId(
					clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stagingClient);
		}
	}

	/**
	 * Returns the number of staging clients where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching staging clients
	 */
	@Override
	public int countByClientId(String clientId) {
		clientId = Objects.toString(clientId, "");

		FinderPath finderPath = _finderPathCountByClientId;

		Object[] finderArgs = new Object[] {clientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGCLIENT_WHERE);

			boolean bindClientId = false;

			if (clientId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_3);
			}
			else {
				bindClientId = true;

				sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClientId) {
					queryPos.add(clientId);
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

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_2 =
		"stagingClient.clientId = ?";

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_3 =
		"(stagingClient.clientId IS NULL OR stagingClient.clientId = '')";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithoutPaginationFindByRowProcessed;
	private FinderPath _finderPathCountByRowProcessed;

	/**
	 * Returns all the staging clients where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching staging clients
	 */
	@Override
	public List<StagingClient> findByRowProcessed(boolean rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

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
	@Override
	public List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StagingClient> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingClient> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRowProcessed;
				finderArgs = new Object[] {rowProcessed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRowProcessed;
			finderArgs = new Object[] {
				rowProcessed, start, end, orderByComparator
			};
		}

		List<StagingClient> list = null;

		if (useFinderCache) {
			list = (List<StagingClient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StagingClient stagingClient : list) {
					if (rowProcessed != stagingClient.isRowProcessed()) {
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

			sb.append(_SQL_SELECT_STAGINGCLIENT_WHERE);

			sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StagingClientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rowProcessed);

				list = (List<StagingClient>)QueryUtil.list(
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
	 * Returns the first staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	@Override
	public StagingClient findByRowProcessed_First(
			boolean rowProcessed,
			OrderByComparator<StagingClient> orderByComparator)
		throws NoSuchStagingClientException {

		StagingClient stagingClient = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (stagingClient != null) {
			return stagingClient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchStagingClientException(sb.toString());
	}

	/**
	 * Returns the first staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	@Override
	public StagingClient fetchByRowProcessed_First(
		boolean rowProcessed,
		OrderByComparator<StagingClient> orderByComparator) {

		List<StagingClient> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client
	 * @throws NoSuchStagingClientException if a matching staging client could not be found
	 */
	@Override
	public StagingClient findByRowProcessed_Last(
			boolean rowProcessed,
			OrderByComparator<StagingClient> orderByComparator)
		throws NoSuchStagingClientException {

		StagingClient stagingClient = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (stagingClient != null) {
			return stagingClient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchStagingClientException(sb.toString());
	}

	/**
	 * Returns the last staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging client, or <code>null</code> if a matching staging client could not be found
	 */
	@Override
	public StagingClient fetchByRowProcessed_Last(
		boolean rowProcessed,
		OrderByComparator<StagingClient> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<StagingClient> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staging clients before and after the current staging client in the ordered set where rowProcessed = &#63;.
	 *
	 * @param stagingClientId the primary key of the current staging client
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient[] findByRowProcessed_PrevAndNext(
			long stagingClientId, boolean rowProcessed,
			OrderByComparator<StagingClient> orderByComparator)
		throws NoSuchStagingClientException {

		StagingClient stagingClient = findByPrimaryKey(stagingClientId);

		Session session = null;

		try {
			session = openSession();

			StagingClient[] array = new StagingClientImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, stagingClient, rowProcessed, orderByComparator, true);

			array[1] = stagingClient;

			array[2] = getByRowProcessed_PrevAndNext(
				session, stagingClient, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StagingClient getByRowProcessed_PrevAndNext(
		Session session, StagingClient stagingClient, boolean rowProcessed,
		OrderByComparator<StagingClient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAGINGCLIENT_WHERE);

		sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);

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
			sb.append(StagingClientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rowProcessed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stagingClient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StagingClient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staging clients where rowProcessed = &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(boolean rowProcessed) {
		for (StagingClient stagingClient :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stagingClient);
		}
	}

	/**
	 * Returns the number of staging clients where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching staging clients
	 */
	@Override
	public int countByRowProcessed(boolean rowProcessed) {
		FinderPath finderPath = _finderPathCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGCLIENT_WHERE);

			sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rowProcessed);

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
		"stagingClient.rowProcessed = ?";

	public StagingClientPersistenceImpl() {
		setModelClass(StagingClient.class);

		setModelImplClass(StagingClientImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging client in the entity cache if it is enabled.
	 *
	 * @param stagingClient the staging client
	 */
	@Override
	public void cacheResult(StagingClient stagingClient) {
		entityCache.putResult(
			entityCacheEnabled, StagingClientImpl.class,
			stagingClient.getPrimaryKey(), stagingClient);

		stagingClient.resetOriginalValues();
	}

	/**
	 * Caches the staging clients in the entity cache if it is enabled.
	 *
	 * @param stagingClients the staging clients
	 */
	@Override
	public void cacheResult(List<StagingClient> stagingClients) {
		for (StagingClient stagingClient : stagingClients) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingClientImpl.class,
					stagingClient.getPrimaryKey()) == null) {

				cacheResult(stagingClient);
			}
			else {
				stagingClient.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging clients.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingClientImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging client.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingClient stagingClient) {
		entityCache.removeResult(
			entityCacheEnabled, StagingClientImpl.class,
			stagingClient.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingClient> stagingClients) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingClient stagingClient : stagingClients) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClientImpl.class,
				stagingClient.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClientImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging client with the primary key. Does not add the staging client to the database.
	 *
	 * @param stagingClientId the primary key for the new staging client
	 * @return the new staging client
	 */
	@Override
	public StagingClient create(long stagingClientId) {
		StagingClient stagingClient = new StagingClientImpl();

		stagingClient.setNew(true);
		stagingClient.setPrimaryKey(stagingClientId);

		return stagingClient;
	}

	/**
	 * Removes the staging client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client that was removed
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient remove(long stagingClientId)
		throws NoSuchStagingClientException {

		return remove((Serializable)stagingClientId);
	}

	/**
	 * Removes the staging client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging client
	 * @return the staging client that was removed
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient remove(Serializable primaryKey)
		throws NoSuchStagingClientException {

		Session session = null;

		try {
			session = openSession();

			StagingClient stagingClient = (StagingClient)session.get(
				StagingClientImpl.class, primaryKey);

			if (stagingClient == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingClientException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingClient);
		}
		catch (NoSuchStagingClientException noSuchEntityException) {
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
	protected StagingClient removeImpl(StagingClient stagingClient) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingClient)) {
				stagingClient = (StagingClient)session.get(
					StagingClientImpl.class, stagingClient.getPrimaryKeyObj());
			}

			if (stagingClient != null) {
				session.delete(stagingClient);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingClient != null) {
			clearCache(stagingClient);
		}

		return stagingClient;
	}

	@Override
	public StagingClient updateImpl(StagingClient stagingClient) {
		boolean isNew = stagingClient.isNew();

		if (!(stagingClient instanceof StagingClientModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingClient.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingClient);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingClient proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingClient implementation " +
					stagingClient.getClass());
		}

		StagingClientModelImpl stagingClientModelImpl =
			(StagingClientModelImpl)stagingClient;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingClient.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingClient.setCreateDate(now);
			}
			else {
				stagingClient.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!stagingClientModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingClient.setModifiedDate(now);
			}
			else {
				stagingClient.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingClient);

				stagingClient.setNew(false);
			}
			else {
				stagingClient = (StagingClient)session.merge(stagingClient);
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
			Object[] args = new Object[] {stagingClientModelImpl.getClientId()};

			finderCache.removeResult(_finderPathCountByClientId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClientId, args);

			args = new Object[] {stagingClientModelImpl.isRowProcessed()};

			finderCache.removeResult(_finderPathCountByRowProcessed, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRowProcessed, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stagingClientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClientId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stagingClientModelImpl.getOriginalClientId()
				};

				finderCache.removeResult(_finderPathCountByClientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClientId, args);

				args = new Object[] {stagingClientModelImpl.getClientId()};

				finderCache.removeResult(_finderPathCountByClientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClientId, args);
			}

			if ((stagingClientModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRowProcessed.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stagingClientModelImpl.getOriginalRowProcessed()
				};

				finderCache.removeResult(_finderPathCountByRowProcessed, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRowProcessed, args);

				args = new Object[] {stagingClientModelImpl.isRowProcessed()};

				finderCache.removeResult(_finderPathCountByRowProcessed, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRowProcessed, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StagingClientImpl.class,
			stagingClient.getPrimaryKey(), stagingClient, false);

		stagingClient.resetOriginalValues();

		return stagingClient;
	}

	/**
	 * Returns the staging client with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging client
	 * @return the staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingClientException {

		StagingClient stagingClient = fetchByPrimaryKey(primaryKey);

		if (stagingClient == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingClientException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingClient;
	}

	/**
	 * Returns the staging client with the primary key or throws a <code>NoSuchStagingClientException</code> if it could not be found.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client
	 * @throws NoSuchStagingClientException if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient findByPrimaryKey(long stagingClientId)
		throws NoSuchStagingClientException {

		return findByPrimaryKey((Serializable)stagingClientId);
	}

	/**
	 * Returns the staging client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClientId the primary key of the staging client
	 * @return the staging client, or <code>null</code> if a staging client with the primary key could not be found
	 */
	@Override
	public StagingClient fetchByPrimaryKey(long stagingClientId) {
		return fetchByPrimaryKey((Serializable)stagingClientId);
	}

	/**
	 * Returns all the staging clients.
	 *
	 * @return the staging clients
	 */
	@Override
	public List<StagingClient> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StagingClient> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StagingClient> findAll(
		int start, int end,
		OrderByComparator<StagingClient> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<StagingClient> findAll(
		int start, int end, OrderByComparator<StagingClient> orderByComparator,
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

		List<StagingClient> list = null;

		if (useFinderCache) {
			list = (List<StagingClient>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGCLIENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGCLIENT;

				sql = sql.concat(StagingClientModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingClient>)QueryUtil.list(
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
	 * Removes all the staging clients from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingClient stagingClient : findAll()) {
			remove(stagingClient);
		}
	}

	/**
	 * Returns the number of staging clients.
	 *
	 * @return the number of staging clients
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGINGCLIENT);

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
		return "stagingClientId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGCLIENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingClientModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging client persistence.
	 */
	@Activate
	public void activate() {
		StagingClientModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingClientModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClientId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClientId",
			new String[] {String.class.getName()},
			StagingClientModelImpl.CLIENTID_COLUMN_BITMASK);

		_finderPathCountByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientId",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRowProcessed",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRowProcessed",
			new String[] {Boolean.class.getName()},
			StagingClientModelImpl.ROWPROCESSED_COLUMN_BITMASK);

		_finderPathCountByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRowProcessed",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingClientImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingClient"),
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

	private static final String _SQL_SELECT_STAGINGCLIENT =
		"SELECT stagingClient FROM StagingClient stagingClient";

	private static final String _SQL_SELECT_STAGINGCLIENT_WHERE =
		"SELECT stagingClient FROM StagingClient stagingClient WHERE ";

	private static final String _SQL_COUNT_STAGINGCLIENT =
		"SELECT COUNT(stagingClient) FROM StagingClient stagingClient";

	private static final String _SQL_COUNT_STAGINGCLIENT_WHERE =
		"SELECT COUNT(stagingClient) FROM StagingClient stagingClient WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingClient.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingClient exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StagingClient exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingClientPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}