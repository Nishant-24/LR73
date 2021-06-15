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

import com.argus.oth.cases.management.exception.NoSuchClientGroupException;
import com.argus.oth.cases.management.model.ClientGroup;
import com.argus.oth.cases.management.model.impl.ClientGroupImpl;
import com.argus.oth.cases.management.model.impl.ClientGroupModelImpl;
import com.argus.oth.cases.management.service.persistence.ClientGroupPersistence;
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
 * The persistence implementation for the client group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClientGroupPersistence.class)
public class ClientGroupPersistenceImpl
	extends BasePersistenceImpl<ClientGroup> implements ClientGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClientGroupUtil</code> to access the client group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClientGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByExternalClientGroupId;
	private FinderPath _finderPathCountByExternalClientGroupId;

	/**
	 * Returns the client group where externalClientGroupId = &#63; or throws a <code>NoSuchClientGroupException</code> if it could not be found.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	@Override
	public ClientGroup findByExternalClientGroupId(long externalClientGroupId)
		throws NoSuchClientGroupException {

		ClientGroup clientGroup = fetchByExternalClientGroupId(
			externalClientGroupId);

		if (clientGroup == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalClientGroupId=");
			sb.append(externalClientGroupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClientGroupException(sb.toString());
		}

		return clientGroup;
	}

	/**
	 * Returns the client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching client group, or <code>null</code> if a matching client group could not be found
	 */
	@Override
	public ClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId) {

		return fetchByExternalClientGroupId(externalClientGroupId, true);
	}

	/**
	 * Returns the client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching client group, or <code>null</code> if a matching client group could not be found
	 */
	@Override
	public ClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalClientGroupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalClientGroupId, finderArgs, this);
		}

		if (result instanceof ClientGroup) {
			ClientGroup clientGroup = (ClientGroup)result;

			if (externalClientGroupId !=
					clientGroup.getExternalClientGroupId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLIENTGROUP_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTERNALCLIENTGROUPID_EXTERNALCLIENTGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientGroupId);

				List<ClientGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalClientGroupId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									externalClientGroupId
								};
							}

							_log.warn(
								"ClientGroupPersistenceImpl.fetchByExternalClientGroupId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ClientGroup clientGroup = list.get(0);

					result = clientGroup;

					cacheResult(clientGroup);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalClientGroupId, finderArgs);
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
			return (ClientGroup)result;
		}
	}

	/**
	 * Removes the client group where externalClientGroupId = &#63; from the database.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the client group that was removed
	 */
	@Override
	public ClientGroup removeByExternalClientGroupId(long externalClientGroupId)
		throws NoSuchClientGroupException {

		ClientGroup clientGroup = findByExternalClientGroupId(
			externalClientGroupId);

		return remove(clientGroup);
	}

	/**
	 * Returns the number of client groups where externalClientGroupId = &#63;.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the number of matching client groups
	 */
	@Override
	public int countByExternalClientGroupId(long externalClientGroupId) {
		FinderPath finderPath = _finderPathCountByExternalClientGroupId;

		Object[] finderArgs = new Object[] {externalClientGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTGROUP_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTERNALCLIENTGROUPID_EXTERNALCLIENTGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientGroupId);

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
		_FINDER_COLUMN_EXTERNALCLIENTGROUPID_EXTERNALCLIENTGROUPID_2 =
			"clientGroup.externalClientGroupId = ?";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the client groups where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching client groups
	 */
	@Override
	public List<ClientGroup> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of matching client groups
	 */
	@Override
	public List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching client groups
	 */
	@Override
	public List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClientGroup> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the client groups where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching client groups
	 */
	@Override
	public List<ClientGroup> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClientGroup> orderByComparator,
		boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<ClientGroup> list = null;

		if (useFinderCache) {
			list = (List<ClientGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientGroup clientGroup : list) {
					if (rowProcessed.equals(clientGroup.getRowProcessed())) {
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

			sb.append(_SQL_SELECT_CLIENTGROUP_WHERE);

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
				sb.append(ClientGroupModelImpl.ORDER_BY_JPQL);
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

				list = (List<ClientGroup>)QueryUtil.list(
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
	 * Returns the first client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	@Override
	public ClientGroup findByRowProcessed_First(
			String rowProcessed,
			OrderByComparator<ClientGroup> orderByComparator)
		throws NoSuchClientGroupException {

		ClientGroup clientGroup = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (clientGroup != null) {
			return clientGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClientGroupException(sb.toString());
	}

	/**
	 * Returns the first client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching client group, or <code>null</code> if a matching client group could not be found
	 */
	@Override
	public ClientGroup fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<ClientGroup> orderByComparator) {

		List<ClientGroup> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client group
	 * @throws NoSuchClientGroupException if a matching client group could not be found
	 */
	@Override
	public ClientGroup findByRowProcessed_Last(
			String rowProcessed,
			OrderByComparator<ClientGroup> orderByComparator)
		throws NoSuchClientGroupException {

		ClientGroup clientGroup = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (clientGroup != null) {
			return clientGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClientGroupException(sb.toString());
	}

	/**
	 * Returns the last client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching client group, or <code>null</code> if a matching client group could not be found
	 */
	@Override
	public ClientGroup fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<ClientGroup> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<ClientGroup> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the client groups before and after the current client group in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param clientGroupId the primary key of the current client group
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	@Override
	public ClientGroup[] findByRowProcessed_PrevAndNext(
			long clientGroupId, String rowProcessed,
			OrderByComparator<ClientGroup> orderByComparator)
		throws NoSuchClientGroupException {

		rowProcessed = Objects.toString(rowProcessed, "");

		ClientGroup clientGroup = findByPrimaryKey(clientGroupId);

		Session session = null;

		try {
			session = openSession();

			ClientGroup[] array = new ClientGroupImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, clientGroup, rowProcessed, orderByComparator, true);

			array[1] = clientGroup;

			array[2] = getByRowProcessed_PrevAndNext(
				session, clientGroup, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientGroup getByRowProcessed_PrevAndNext(
		Session session, ClientGroup clientGroup, String rowProcessed,
		OrderByComparator<ClientGroup> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTGROUP_WHERE);

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
			sb.append(ClientGroupModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(clientGroup)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientGroup> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the client groups where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (ClientGroup clientGroup :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientGroup);
		}
	}

	/**
	 * Returns the number of client groups where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching client groups
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTGROUP_WHERE);

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
		"clientGroup.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(clientGroup.rowProcessed IS NULL OR clientGroup.rowProcessed != '')";

	public ClientGroupPersistenceImpl() {
		setModelClass(ClientGroup.class);

		setModelImplClass(ClientGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the client group in the entity cache if it is enabled.
	 *
	 * @param clientGroup the client group
	 */
	@Override
	public void cacheResult(ClientGroup clientGroup) {
		entityCache.putResult(
			entityCacheEnabled, ClientGroupImpl.class,
			clientGroup.getPrimaryKey(), clientGroup);

		finderCache.putResult(
			_finderPathFetchByExternalClientGroupId,
			new Object[] {clientGroup.getExternalClientGroupId()}, clientGroup);

		clientGroup.resetOriginalValues();
	}

	/**
	 * Caches the client groups in the entity cache if it is enabled.
	 *
	 * @param clientGroups the client groups
	 */
	@Override
	public void cacheResult(List<ClientGroup> clientGroups) {
		for (ClientGroup clientGroup : clientGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, ClientGroupImpl.class,
					clientGroup.getPrimaryKey()) == null) {

				cacheResult(clientGroup);
			}
			else {
				clientGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all client groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClientGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the client group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClientGroup clientGroup) {
		entityCache.removeResult(
			entityCacheEnabled, ClientGroupImpl.class,
			clientGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ClientGroupModelImpl)clientGroup, true);
	}

	@Override
	public void clearCache(List<ClientGroup> clientGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClientGroup clientGroup : clientGroups) {
			entityCache.removeResult(
				entityCacheEnabled, ClientGroupImpl.class,
				clientGroup.getPrimaryKey());

			clearUniqueFindersCache((ClientGroupModelImpl)clientGroup, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ClientGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ClientGroupModelImpl clientGroupModelImpl) {

		Object[] args = new Object[] {
			clientGroupModelImpl.getExternalClientGroupId()
		};

		finderCache.putResult(
			_finderPathCountByExternalClientGroupId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByExternalClientGroupId, args, clientGroupModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		ClientGroupModelImpl clientGroupModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				clientGroupModelImpl.getExternalClientGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByExternalClientGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByExternalClientGroupId, args);
		}

		if ((clientGroupModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalClientGroupId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				clientGroupModelImpl.getOriginalExternalClientGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByExternalClientGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByExternalClientGroupId, args);
		}
	}

	/**
	 * Creates a new client group with the primary key. Does not add the client group to the database.
	 *
	 * @param clientGroupId the primary key for the new client group
	 * @return the new client group
	 */
	@Override
	public ClientGroup create(long clientGroupId) {
		ClientGroup clientGroup = new ClientGroupImpl();

		clientGroup.setNew(true);
		clientGroup.setPrimaryKey(clientGroupId);

		clientGroup.setCompanyId(CompanyThreadLocal.getCompanyId());

		return clientGroup;
	}

	/**
	 * Removes the client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group that was removed
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	@Override
	public ClientGroup remove(long clientGroupId)
		throws NoSuchClientGroupException {

		return remove((Serializable)clientGroupId);
	}

	/**
	 * Removes the client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the client group
	 * @return the client group that was removed
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	@Override
	public ClientGroup remove(Serializable primaryKey)
		throws NoSuchClientGroupException {

		Session session = null;

		try {
			session = openSession();

			ClientGroup clientGroup = (ClientGroup)session.get(
				ClientGroupImpl.class, primaryKey);

			if (clientGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clientGroup);
		}
		catch (NoSuchClientGroupException noSuchEntityException) {
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
	protected ClientGroup removeImpl(ClientGroup clientGroup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clientGroup)) {
				clientGroup = (ClientGroup)session.get(
					ClientGroupImpl.class, clientGroup.getPrimaryKeyObj());
			}

			if (clientGroup != null) {
				session.delete(clientGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clientGroup != null) {
			clearCache(clientGroup);
		}

		return clientGroup;
	}

	@Override
	public ClientGroup updateImpl(ClientGroup clientGroup) {
		boolean isNew = clientGroup.isNew();

		if (!(clientGroup instanceof ClientGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clientGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(clientGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clientGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClientGroup implementation " +
					clientGroup.getClass());
		}

		ClientGroupModelImpl clientGroupModelImpl =
			(ClientGroupModelImpl)clientGroup;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (clientGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				clientGroup.setCreateDate(now);
			}
			else {
				clientGroup.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!clientGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				clientGroup.setModifiedDate(now);
			}
			else {
				clientGroup.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (clientGroup.isNew()) {
				session.save(clientGroup);

				clientGroup.setNew(false);
			}
			else {
				clientGroup = (ClientGroup)session.merge(clientGroup);
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
			entityCacheEnabled, ClientGroupImpl.class,
			clientGroup.getPrimaryKey(), clientGroup, false);

		clearUniqueFindersCache(clientGroupModelImpl, false);
		cacheUniqueFindersCache(clientGroupModelImpl);

		clientGroup.resetOriginalValues();

		return clientGroup;
	}

	/**
	 * Returns the client group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the client group
	 * @return the client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	@Override
	public ClientGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientGroupException {

		ClientGroup clientGroup = fetchByPrimaryKey(primaryKey);

		if (clientGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clientGroup;
	}

	/**
	 * Returns the client group with the primary key or throws a <code>NoSuchClientGroupException</code> if it could not be found.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group
	 * @throws NoSuchClientGroupException if a client group with the primary key could not be found
	 */
	@Override
	public ClientGroup findByPrimaryKey(long clientGroupId)
		throws NoSuchClientGroupException {

		return findByPrimaryKey((Serializable)clientGroupId);
	}

	/**
	 * Returns the client group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group, or <code>null</code> if a client group with the primary key could not be found
	 */
	@Override
	public ClientGroup fetchByPrimaryKey(long clientGroupId) {
		return fetchByPrimaryKey((Serializable)clientGroupId);
	}

	/**
	 * Returns all the client groups.
	 *
	 * @return the client groups
	 */
	@Override
	public List<ClientGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of client groups
	 */
	@Override
	public List<ClientGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of client groups
	 */
	@Override
	public List<ClientGroup> findAll(
		int start, int end, OrderByComparator<ClientGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of client groups
	 */
	@Override
	public List<ClientGroup> findAll(
		int start, int end, OrderByComparator<ClientGroup> orderByComparator,
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

		List<ClientGroup> list = null;

		if (useFinderCache) {
			list = (List<ClientGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLIENTGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTGROUP;

				sql = sql.concat(ClientGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClientGroup>)QueryUtil.list(
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
	 * Removes all the client groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClientGroup clientGroup : findAll()) {
			remove(clientGroup);
		}
	}

	/**
	 * Returns the number of client groups.
	 *
	 * @return the number of client groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLIENTGROUP);

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
		return "clientGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLIENTGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClientGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the client group persistence.
	 */
	@Activate
	public void activate() {
		ClientGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClientGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByExternalClientGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalClientGroupId",
			new String[] {Long.class.getName()},
			ClientGroupModelImpl.EXTERNALCLIENTGROUPID_COLUMN_BITMASK);

		_finderPathCountByExternalClientGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalClientGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClientGroupImpl.class,
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
		entityCache.removeCache(ClientGroupImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.ClientGroup"),
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

	private static final String _SQL_SELECT_CLIENTGROUP =
		"SELECT clientGroup FROM ClientGroup clientGroup";

	private static final String _SQL_SELECT_CLIENTGROUP_WHERE =
		"SELECT clientGroup FROM ClientGroup clientGroup WHERE ";

	private static final String _SQL_COUNT_CLIENTGROUP =
		"SELECT COUNT(clientGroup) FROM ClientGroup clientGroup";

	private static final String _SQL_COUNT_CLIENTGROUP_WHERE =
		"SELECT COUNT(clientGroup) FROM ClientGroup clientGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clientGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClientGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClientGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClientGroupPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}