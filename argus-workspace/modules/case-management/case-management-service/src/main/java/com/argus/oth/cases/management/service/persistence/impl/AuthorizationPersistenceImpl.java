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

import com.argus.oth.cases.management.exception.NoSuchAuthorizationException;
import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.impl.AuthorizationImpl;
import com.argus.oth.cases.management.model.impl.AuthorizationModelImpl;
import com.argus.oth.cases.management.service.persistence.AuthorizationPersistence;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the authorization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuthorizationPersistence.class)
public class AuthorizationPersistenceImpl
	extends BasePersistenceImpl<Authorization>
	implements AuthorizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuthorizationUtil</code> to access the authorization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuthorizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the authorizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authorizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Authorization> list = null;

		if (useFinderCache) {
			list = (List<Authorization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Authorization authorization : list) {
					if (!uuid.equals(authorization.getUuid())) {
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

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Authorization>)QueryUtil.list(
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
	 * Returns the first authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByUuid_First(
			String uuid, OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByUuid_First(
			uuid, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByUuid_First(
		String uuid, OrderByComparator<Authorization> orderByComparator) {

		List<Authorization> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByUuid_Last(
			String uuid, OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByUuid_Last(uuid, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByUuid_Last(
		String uuid, OrderByComparator<Authorization> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Authorization> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where uuid = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization[] findByUuid_PrevAndNext(
			long authorizationId, String uuid,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		uuid = Objects.toString(uuid, "");

		Authorization authorization = findByPrimaryKey(authorizationId);

		Session session = null;

		try {
			session = openSession();

			Authorization[] array = new AuthorizationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, authorization, uuid, orderByComparator, true);

			array[1] = authorization;

			array[2] = getByUuid_PrevAndNext(
				session, authorization, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Authorization getByUuid_PrevAndNext(
		Session session, Authorization authorization, String uuid,
		OrderByComparator<Authorization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						authorization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Authorization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authorizations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Authorization authorization :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(authorization);
		}
	}

	/**
	 * Returns the number of authorizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"authorization.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(authorization.uuid IS NULL OR authorization.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByUUID_G(uuid, groupId);

		if (authorization == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAuthorizationException(sb.toString());
		}

		return authorization;
	}

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the authorization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Authorization) {
			Authorization authorization = (Authorization)result;

			if (!Objects.equals(uuid, authorization.getUuid()) ||
				(groupId != authorization.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Authorization> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Authorization authorization = list.get(0);

					result = authorization;

					cacheResult(authorization);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
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
			return (Authorization)result;
		}
	}

	/**
	 * Removes the authorization where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the authorization that was removed
	 */
	@Override
	public Authorization removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorizationException {

		Authorization authorization = findByUUID_G(uuid, groupId);

		return remove(authorization);
	}

	/**
	 * Returns the number of authorizations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"authorization.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(authorization.uuid IS NULL OR authorization.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"authorization.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Authorization> list = null;

		if (useFinderCache) {
			list = (List<Authorization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Authorization authorization : list) {
					if (!uuid.equals(authorization.getUuid()) ||
						(companyId != authorization.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Authorization>)QueryUtil.list(
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
	 * Returns the first authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the first authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Authorization> orderByComparator) {

		List<Authorization> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the last authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Authorization> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Authorization> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization[] findByUuid_C_PrevAndNext(
			long authorizationId, String uuid, long companyId,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		uuid = Objects.toString(uuid, "");

		Authorization authorization = findByPrimaryKey(authorizationId);

		Session session = null;

		try {
			session = openSession();

			Authorization[] array = new AuthorizationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, authorization, uuid, companyId, orderByComparator,
				true);

			array[1] = authorization;

			array[2] = getByUuid_C_PrevAndNext(
				session, authorization, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Authorization getByUuid_C_PrevAndNext(
		Session session, Authorization authorization, String uuid,
		long companyId, OrderByComparator<Authorization> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						authorization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Authorization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authorizations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Authorization authorization :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(authorization);
		}
	}

	/**
	 * Returns the number of authorizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"authorization.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(authorization.uuid IS NULL OR authorization.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"authorization.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAuthNumber;
	private FinderPath _finderPathWithoutPaginationFindByAuthNumber;
	private FinderPath _finderPathCountByAuthNumber;

	/**
	 * Returns all the authorizations where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the matching authorizations
	 */
	@Override
	public List<Authorization> findByAuthNumber(String authNumber) {
		return findByAuthNumber(
			authNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authorizations where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	@Override
	public List<Authorization> findByAuthNumber(
		String authNumber, int start, int end) {

		return findByAuthNumber(authNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authorizations where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return findByAuthNumber(
			authNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authorizations where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		authNumber = Objects.toString(authNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAuthNumber;
				finderArgs = new Object[] {authNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAuthNumber;
			finderArgs = new Object[] {
				authNumber, start, end, orderByComparator
			};
		}

		List<Authorization> list = null;

		if (useFinderCache) {
			list = (List<Authorization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Authorization authorization : list) {
					if (!authNumber.equals(authorization.getAuthNumber())) {
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

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			boolean bindAuthNumber = false;

			if (authNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_3);
			}
			else {
				bindAuthNumber = true;

				sb.append(_FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAuthNumber) {
					queryPos.add(authNumber);
				}

				list = (List<Authorization>)QueryUtil.list(
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
	 * Returns the first authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByAuthNumber_First(
			String authNumber,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByAuthNumber_First(
			authNumber, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authNumber=");
		sb.append(authNumber);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the first authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByAuthNumber_First(
		String authNumber, OrderByComparator<Authorization> orderByComparator) {

		List<Authorization> list = findByAuthNumber(
			authNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByAuthNumber_Last(
			String authNumber,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByAuthNumber_Last(
			authNumber, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authNumber=");
		sb.append(authNumber);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the last authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByAuthNumber_Last(
		String authNumber, OrderByComparator<Authorization> orderByComparator) {

		int count = countByAuthNumber(authNumber);

		if (count == 0) {
			return null;
		}

		List<Authorization> list = findByAuthNumber(
			authNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where authNumber = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization[] findByAuthNumber_PrevAndNext(
			long authorizationId, String authNumber,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		authNumber = Objects.toString(authNumber, "");

		Authorization authorization = findByPrimaryKey(authorizationId);

		Session session = null;

		try {
			session = openSession();

			Authorization[] array = new AuthorizationImpl[3];

			array[0] = getByAuthNumber_PrevAndNext(
				session, authorization, authNumber, orderByComparator, true);

			array[1] = authorization;

			array[2] = getByAuthNumber_PrevAndNext(
				session, authorization, authNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Authorization getByAuthNumber_PrevAndNext(
		Session session, Authorization authorization, String authNumber,
		OrderByComparator<Authorization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

		boolean bindAuthNumber = false;

		if (authNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_3);
		}
		else {
			bindAuthNumber = true;

			sb.append(_FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_2);
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
			sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAuthNumber) {
			queryPos.add(authNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						authorization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Authorization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authorizations where authNumber = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 */
	@Override
	public void removeByAuthNumber(String authNumber) {
		for (Authorization authorization :
				findByAuthNumber(
					authNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(authorization);
		}
	}

	/**
	 * Returns the number of authorizations where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByAuthNumber(String authNumber) {
		authNumber = Objects.toString(authNumber, "");

		FinderPath finderPath = _finderPathCountByAuthNumber;

		Object[] finderArgs = new Object[] {authNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			boolean bindAuthNumber = false;

			if (authNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_3);
			}
			else {
				bindAuthNumber = true;

				sb.append(_FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAuthNumber) {
					queryPos.add(authNumber);
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

	private static final String _FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_2 =
		"authorization.authNumber = ?";

	private static final String _FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_3 =
		"(authorization.authNumber IS NULL OR authorization.authNumber = '')";

	private FinderPath _finderPathWithPaginationFindByCaseId;
	private FinderPath _finderPathWithoutPaginationFindByCaseId;
	private FinderPath _finderPathCountByCaseId;

	/**
	 * Returns all the authorizations where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @return the matching authorizations
	 */
	@Override
	public List<Authorization> findByCaseId(long caseId) {
		return findByCaseId(caseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authorizations where caseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	@Override
	public List<Authorization> findByCaseId(long caseId, int start, int end) {
		return findByCaseId(caseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authorizations where caseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByCaseId(
		long caseId, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return findByCaseId(caseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authorizations where caseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByCaseId(
		long caseId, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCaseId;
				finderArgs = new Object[] {caseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCaseId;
			finderArgs = new Object[] {caseId, start, end, orderByComparator};
		}

		List<Authorization> list = null;

		if (useFinderCache) {
			list = (List<Authorization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Authorization authorization : list) {
					if (caseId != authorization.getCaseId()) {
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

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CASEID_CASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(caseId);

				list = (List<Authorization>)QueryUtil.list(
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
	 * Returns the first authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByCaseId_First(
			long caseId, OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByCaseId_First(
			caseId, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("caseId=");
		sb.append(caseId);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the first authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByCaseId_First(
		long caseId, OrderByComparator<Authorization> orderByComparator) {

		List<Authorization> list = findByCaseId(
			caseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByCaseId_Last(
			long caseId, OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByCaseId_Last(
			caseId, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("caseId=");
		sb.append(caseId);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the last authorization in the ordered set where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByCaseId_Last(
		long caseId, OrderByComparator<Authorization> orderByComparator) {

		int count = countByCaseId(caseId);

		if (count == 0) {
			return null;
		}

		List<Authorization> list = findByCaseId(
			caseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where caseId = &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param caseId the case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization[] findByCaseId_PrevAndNext(
			long authorizationId, long caseId,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = findByPrimaryKey(authorizationId);

		Session session = null;

		try {
			session = openSession();

			Authorization[] array = new AuthorizationImpl[3];

			array[0] = getByCaseId_PrevAndNext(
				session, authorization, caseId, orderByComparator, true);

			array[1] = authorization;

			array[2] = getByCaseId_PrevAndNext(
				session, authorization, caseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Authorization getByCaseId_PrevAndNext(
		Session session, Authorization authorization, long caseId,
		OrderByComparator<Authorization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

		sb.append(_FINDER_COLUMN_CASEID_CASEID_2);

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
			sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(caseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						authorization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Authorization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authorizations where caseId = &#63; from the database.
	 *
	 * @param caseId the case ID
	 */
	@Override
	public void removeByCaseId(long caseId) {
		for (Authorization authorization :
				findByCaseId(
					caseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(authorization);
		}
	}

	/**
	 * Returns the number of authorizations where caseId = &#63;.
	 *
	 * @param caseId the case ID
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByCaseId(long caseId) {
		FinderPath finderPath = _finderPathCountByCaseId;

		Object[] finderArgs = new Object[] {caseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CASEID_CASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(caseId);

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

	private static final String _FINDER_COLUMN_CASEID_CASEID_2 =
		"authorization.caseId = ?";

	private FinderPath _finderPathFetchByExternalAuthorizationId;
	private FinderPath _finderPathCountByExternalAuthorizationId;

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByExternalAuthorizationId(
			long externalAuthorizationId)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByExternalAuthorizationId(
			externalAuthorizationId);

		if (authorization == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalAuthorizationId=");
			sb.append(externalAuthorizationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAuthorizationException(sb.toString());
		}

		return authorization;
	}

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByExternalAuthorizationId(
		long externalAuthorizationId) {

		return fetchByExternalAuthorizationId(externalAuthorizationId, true);
	}

	/**
	 * Returns the authorization where externalAuthorizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByExternalAuthorizationId(
		long externalAuthorizationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalAuthorizationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalAuthorizationId, finderArgs, this);
		}

		if (result instanceof Authorization) {
			Authorization authorization = (Authorization)result;

			if (externalAuthorizationId !=
					authorization.getExternalAuthorizationId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTERNALAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalAuthorizationId);

				List<Authorization> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalAuthorizationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									externalAuthorizationId
								};
							}

							_log.warn(
								"AuthorizationPersistenceImpl.fetchByExternalAuthorizationId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Authorization authorization = list.get(0);

					result = authorization;

					cacheResult(authorization);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalAuthorizationId, finderArgs);
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
			return (Authorization)result;
		}
	}

	/**
	 * Removes the authorization where externalAuthorizationId = &#63; from the database.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the authorization that was removed
	 */
	@Override
	public Authorization removeByExternalAuthorizationId(
			long externalAuthorizationId)
		throws NoSuchAuthorizationException {

		Authorization authorization = findByExternalAuthorizationId(
			externalAuthorizationId);

		return remove(authorization);
	}

	/**
	 * Returns the number of authorizations where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByExternalAuthorizationId(long externalAuthorizationId) {
		FinderPath finderPath = _finderPathCountByExternalAuthorizationId;

		Object[] finderArgs = new Object[] {externalAuthorizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTERNALAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalAuthorizationId);

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
		_FINDER_COLUMN_EXTERNALAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2 =
			"authorization.externalAuthorizationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByRowProcessed_ProcessStatus;
	private FinderPath
		_finderPathWithPaginationCountByRowProcessed_ProcessStatus;

	/**
	 * Returns all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the matching authorizations
	 */
	@Override
	public List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		return findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of matching authorizations
	 */
	@Override
	public List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end) {

		return findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authorizations
	 */
	@Override
	public List<Authorization> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Authorization> orderByComparator,
		boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");
		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed_ProcessStatus;
		finderArgs = new Object[] {
			rowProcessed, processStatus, start, end, orderByComparator
		};

		List<Authorization> list = null;

		if (useFinderCache) {
			list = (List<Authorization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Authorization authorization : list) {
					if (rowProcessed.equals(authorization.getRowProcessed()) ||
						processStatus.equals(
							authorization.getProcessStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

			boolean bindRowProcessed = false;

			if (rowProcessed.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3);
			}
			else {
				bindRowProcessed = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2);
			}

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
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

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				list = (List<Authorization>)QueryUtil.list(
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
	 * Returns the first authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByRowProcessed_ProcessStatus_First(
			String rowProcessed, String processStatus,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByRowProcessed_ProcessStatus_First(
			rowProcessed, processStatus, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append(", processStatus!=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the first authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByRowProcessed_ProcessStatus_First(
		String rowProcessed, String processStatus,
		OrderByComparator<Authorization> orderByComparator) {

		List<Authorization> list = findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization
	 * @throws NoSuchAuthorizationException if a matching authorization could not be found
	 */
	@Override
	public Authorization findByRowProcessed_ProcessStatus_Last(
			String rowProcessed, String processStatus,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByRowProcessed_ProcessStatus_Last(
			rowProcessed, processStatus, orderByComparator);

		if (authorization != null) {
			return authorization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append(", processStatus!=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchAuthorizationException(sb.toString());
	}

	/**
	 * Returns the last authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchByRowProcessed_ProcessStatus_Last(
		String rowProcessed, String processStatus,
		OrderByComparator<Authorization> orderByComparator) {

		int count = countByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);

		if (count == 0) {
			return null;
		}

		List<Authorization> list = findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authorizations before and after the current authorization in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param authorizationId the primary key of the current authorization
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization[] findByRowProcessed_ProcessStatus_PrevAndNext(
			long authorizationId, String rowProcessed, String processStatus,
			OrderByComparator<Authorization> orderByComparator)
		throws NoSuchAuthorizationException {

		rowProcessed = Objects.toString(rowProcessed, "");
		processStatus = Objects.toString(processStatus, "");

		Authorization authorization = findByPrimaryKey(authorizationId);

		Session session = null;

		try {
			session = openSession();

			Authorization[] array = new AuthorizationImpl[3];

			array[0] = getByRowProcessed_ProcessStatus_PrevAndNext(
				session, authorization, rowProcessed, processStatus,
				orderByComparator, true);

			array[1] = authorization;

			array[2] = getByRowProcessed_ProcessStatus_PrevAndNext(
				session, authorization, rowProcessed, processStatus,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Authorization getByRowProcessed_ProcessStatus_PrevAndNext(
		Session session, Authorization authorization, String rowProcessed,
		String processStatus,
		OrderByComparator<Authorization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AUTHORIZATION_WHERE);

		boolean bindRowProcessed = false;

		if (rowProcessed.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3);
		}
		else {
			bindRowProcessed = true;

			sb.append(_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2);
		}

		boolean bindProcessStatus = false;

		if (processStatus.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3);
		}
		else {
			bindProcessStatus = true;

			sb.append(
				_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2);
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
			sb.append(AuthorizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRowProcessed) {
			queryPos.add(rowProcessed);
		}

		if (bindProcessStatus) {
			queryPos.add(processStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						authorization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Authorization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 */
	@Override
	public void removeByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		for (Authorization authorization :
				findByRowProcessed_ProcessStatus(
					rowProcessed, processStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(authorization);
		}
	}

	/**
	 * Returns the number of authorizations where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the number of matching authorizations
	 */
	@Override
	public int countByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		rowProcessed = Objects.toString(rowProcessed, "");
		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByRowProcessed_ProcessStatus;

		Object[] finderArgs = new Object[] {rowProcessed, processStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUTHORIZATION_WHERE);

			boolean bindRowProcessed = false;

			if (rowProcessed.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3);
			}
			else {
				bindRowProcessed = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2);
			}

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2);
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

				if (bindProcessStatus) {
					queryPos.add(processStatus);
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

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2 =
			"authorization.rowProcessed != ? AND ";

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3 =
			"(authorization.rowProcessed IS NULL OR authorization.rowProcessed != '') AND ";

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2 =
			"authorization.processStatus != ?";

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3 =
			"(authorization.processStatus IS NULL OR authorization.processStatus != '')";

	public AuthorizationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Authorization.class);

		setModelImplClass(AuthorizationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the authorization in the entity cache if it is enabled.
	 *
	 * @param authorization the authorization
	 */
	@Override
	public void cacheResult(Authorization authorization) {
		entityCache.putResult(
			entityCacheEnabled, AuthorizationImpl.class,
			authorization.getPrimaryKey(), authorization);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {authorization.getUuid(), authorization.getGroupId()},
			authorization);

		finderCache.putResult(
			_finderPathFetchByExternalAuthorizationId,
			new Object[] {authorization.getExternalAuthorizationId()},
			authorization);

		authorization.resetOriginalValues();
	}

	/**
	 * Caches the authorizations in the entity cache if it is enabled.
	 *
	 * @param authorizations the authorizations
	 */
	@Override
	public void cacheResult(List<Authorization> authorizations) {
		for (Authorization authorization : authorizations) {
			if (entityCache.getResult(
					entityCacheEnabled, AuthorizationImpl.class,
					authorization.getPrimaryKey()) == null) {

				cacheResult(authorization);
			}
			else {
				authorization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all authorizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuthorizationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the authorization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Authorization authorization) {
		entityCache.removeResult(
			entityCacheEnabled, AuthorizationImpl.class,
			authorization.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AuthorizationModelImpl)authorization, true);
	}

	@Override
	public void clearCache(List<Authorization> authorizations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Authorization authorization : authorizations) {
			entityCache.removeResult(
				entityCacheEnabled, AuthorizationImpl.class,
				authorization.getPrimaryKey());

			clearUniqueFindersCache(
				(AuthorizationModelImpl)authorization, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AuthorizationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AuthorizationModelImpl authorizationModelImpl) {

		Object[] args = new Object[] {
			authorizationModelImpl.getUuid(),
			authorizationModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, authorizationModelImpl, false);

		args = new Object[] {
			authorizationModelImpl.getExternalAuthorizationId()
		};

		finderCache.putResult(
			_finderPathCountByExternalAuthorizationId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByExternalAuthorizationId, args,
			authorizationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AuthorizationModelImpl authorizationModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				authorizationModelImpl.getUuid(),
				authorizationModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((authorizationModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				authorizationModelImpl.getOriginalUuid(),
				authorizationModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				authorizationModelImpl.getExternalAuthorizationId()
			};

			finderCache.removeResult(
				_finderPathCountByExternalAuthorizationId, args);
			finderCache.removeResult(
				_finderPathFetchByExternalAuthorizationId, args);
		}

		if ((authorizationModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalAuthorizationId.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				authorizationModelImpl.getOriginalExternalAuthorizationId()
			};

			finderCache.removeResult(
				_finderPathCountByExternalAuthorizationId, args);
			finderCache.removeResult(
				_finderPathFetchByExternalAuthorizationId, args);
		}
	}

	/**
	 * Creates a new authorization with the primary key. Does not add the authorization to the database.
	 *
	 * @param authorizationId the primary key for the new authorization
	 * @return the new authorization
	 */
	@Override
	public Authorization create(long authorizationId) {
		Authorization authorization = new AuthorizationImpl();

		authorization.setNew(true);
		authorization.setPrimaryKey(authorizationId);

		String uuid = PortalUUIDUtil.generate();

		authorization.setUuid(uuid);

		authorization.setCompanyId(CompanyThreadLocal.getCompanyId());

		return authorization;
	}

	/**
	 * Removes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization remove(long authorizationId)
		throws NoSuchAuthorizationException {

		return remove((Serializable)authorizationId);
	}

	/**
	 * Removes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization remove(Serializable primaryKey)
		throws NoSuchAuthorizationException {

		Session session = null;

		try {
			session = openSession();

			Authorization authorization = (Authorization)session.get(
				AuthorizationImpl.class, primaryKey);

			if (authorization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(authorization);
		}
		catch (NoSuchAuthorizationException noSuchEntityException) {
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
	protected Authorization removeImpl(Authorization authorization) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(authorization)) {
				authorization = (Authorization)session.get(
					AuthorizationImpl.class, authorization.getPrimaryKeyObj());
			}

			if (authorization != null) {
				session.delete(authorization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (authorization != null) {
			clearCache(authorization);
		}

		return authorization;
	}

	@Override
	public Authorization updateImpl(Authorization authorization) {
		boolean isNew = authorization.isNew();

		if (!(authorization instanceof AuthorizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(authorization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					authorization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in authorization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Authorization implementation " +
					authorization.getClass());
		}

		AuthorizationModelImpl authorizationModelImpl =
			(AuthorizationModelImpl)authorization;

		if (Validator.isNull(authorization.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			authorization.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (authorization.getCreateDate() == null)) {
			if (serviceContext == null) {
				authorization.setCreateDate(now);
			}
			else {
				authorization.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!authorizationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				authorization.setModifiedDate(now);
			}
			else {
				authorization.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(authorization);

				authorization.setNew(false);
			}
			else {
				authorization = (Authorization)session.merge(authorization);
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
			Object[] args = new Object[] {authorizationModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				authorizationModelImpl.getUuid(),
				authorizationModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {authorizationModelImpl.getAuthNumber()};

			finderCache.removeResult(_finderPathCountByAuthNumber, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAuthNumber, args);

			args = new Object[] {authorizationModelImpl.getCaseId()};

			finderCache.removeResult(_finderPathCountByCaseId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCaseId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((authorizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					authorizationModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {authorizationModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((authorizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					authorizationModelImpl.getOriginalUuid(),
					authorizationModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					authorizationModelImpl.getUuid(),
					authorizationModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((authorizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAuthNumber.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					authorizationModelImpl.getOriginalAuthNumber()
				};

				finderCache.removeResult(_finderPathCountByAuthNumber, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuthNumber, args);

				args = new Object[] {authorizationModelImpl.getAuthNumber()};

				finderCache.removeResult(_finderPathCountByAuthNumber, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuthNumber, args);
			}

			if ((authorizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCaseId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					authorizationModelImpl.getOriginalCaseId()
				};

				finderCache.removeResult(_finderPathCountByCaseId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCaseId, args);

				args = new Object[] {authorizationModelImpl.getCaseId()};

				finderCache.removeResult(_finderPathCountByCaseId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCaseId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AuthorizationImpl.class,
			authorization.getPrimaryKey(), authorization, false);

		clearUniqueFindersCache(authorizationModelImpl, false);
		cacheUniqueFindersCache(authorizationModelImpl);

		authorization.resetOriginalValues();

		return authorization;
	}

	/**
	 * Returns the authorization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the authorization
	 * @return the authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthorizationException {

		Authorization authorization = fetchByPrimaryKey(primaryKey);

		if (authorization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthorizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return authorization;
	}

	/**
	 * Returns the authorization with the primary key or throws a <code>NoSuchAuthorizationException</code> if it could not be found.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws NoSuchAuthorizationException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization findByPrimaryKey(long authorizationId)
		throws NoSuchAuthorizationException {

		return findByPrimaryKey((Serializable)authorizationId);
	}

	/**
	 * Returns the authorization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization, or <code>null</code> if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization fetchByPrimaryKey(long authorizationId) {
		return fetchByPrimaryKey((Serializable)authorizationId);
	}

	/**
	 * Returns all the authorizations.
	 *
	 * @return the authorizations
	 */
	@Override
	public List<Authorization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of authorizations
	 */
	@Override
	public List<Authorization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of authorizations
	 */
	@Override
	public List<Authorization> findAll(
		int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of authorizations
	 */
	@Override
	public List<Authorization> findAll(
		int start, int end, OrderByComparator<Authorization> orderByComparator,
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

		List<Authorization> list = null;

		if (useFinderCache) {
			list = (List<Authorization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUTHORIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHORIZATION;

				sql = sql.concat(AuthorizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Authorization>)QueryUtil.list(
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
	 * Removes all the authorizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Authorization authorization : findAll()) {
			remove(authorization);
		}
	}

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUTHORIZATION);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "authorizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUTHORIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuthorizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the authorization persistence.
	 */
	@Activate
	public void activate() {
		AuthorizationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AuthorizationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			AuthorizationModelImpl.UUID_COLUMN_BITMASK |
			AuthorizationModelImpl.RECEIVEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			AuthorizationModelImpl.UUID_COLUMN_BITMASK |
			AuthorizationModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			AuthorizationModelImpl.UUID_COLUMN_BITMASK |
			AuthorizationModelImpl.COMPANYID_COLUMN_BITMASK |
			AuthorizationModelImpl.RECEIVEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByAuthNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAuthNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthNumber",
			new String[] {String.class.getName()},
			AuthorizationModelImpl.AUTHNUMBER_COLUMN_BITMASK |
			AuthorizationModelImpl.RECEIVEDDATE_COLUMN_BITMASK);

		_finderPathCountByAuthNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthNumber",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCaseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCaseId",
			new String[] {Long.class.getName()},
			AuthorizationModelImpl.CASEID_COLUMN_BITMASK |
			AuthorizationModelImpl.RECEIVEDDATE_COLUMN_BITMASK);

		_finderPathCountByCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCaseId",
			new String[] {Long.class.getName()});

		_finderPathFetchByExternalAuthorizationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalAuthorizationId",
			new String[] {Long.class.getName()},
			AuthorizationModelImpl.EXTERNALAUTHORIZATIONID_COLUMN_BITMASK);

		_finderPathCountByExternalAuthorizationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalAuthorizationId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRowProcessed_ProcessStatus =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, AuthorizationImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRowProcessed_ProcessStatus",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithPaginationCountByRowProcessed_ProcessStatus =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, Long.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByRowProcessed_ProcessStatus",
				new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AuthorizationImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.Authorization"),
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

	private static final String _SQL_SELECT_AUTHORIZATION =
		"SELECT authorization FROM Authorization authorization";

	private static final String _SQL_SELECT_AUTHORIZATION_WHERE =
		"SELECT authorization FROM Authorization authorization WHERE ";

	private static final String _SQL_COUNT_AUTHORIZATION =
		"SELECT COUNT(authorization) FROM Authorization authorization";

	private static final String _SQL_COUNT_AUTHORIZATION_WHERE =
		"SELECT COUNT(authorization) FROM Authorization authorization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "authorization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Authorization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Authorization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuthorizationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}