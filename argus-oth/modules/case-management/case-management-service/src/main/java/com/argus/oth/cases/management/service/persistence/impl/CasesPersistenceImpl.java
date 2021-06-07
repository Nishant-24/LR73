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

import com.argus.oth.cases.management.exception.NoSuchCasesException;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.impl.CasesImpl;
import com.argus.oth.cases.management.model.impl.CasesModelImpl;
import com.argus.oth.cases.management.service.persistence.CasesPersistence;
import com.argus.oth.cases.management.service.persistence.impl.constants.OTHPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
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
 * The persistence implementation for the cases service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CasesPersistence.class)
public class CasesPersistenceImpl
	extends BasePersistenceImpl<Cases> implements CasesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CasesUtil</code> to access the cases persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CasesImpl.class.getName();

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
	 * Returns all the caseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching caseses
	 */
	@Override
	public List<Cases> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	@Override
	public List<Cases> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

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

		List<Cases> list = null;

		if (useFinderCache) {
			list = (List<Cases>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Cases cases : list) {
					if (!uuid.equals(cases.getUuid())) {
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

			sb.append(_SQL_SELECT_CASES_WHERE);

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
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
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

				list = (List<Cases>)QueryUtil.list(
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
	 * Returns the first cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByUuid_First(
			String uuid, OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByUuid_First(uuid, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the first cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByUuid_First(
		String uuid, OrderByComparator<Cases> orderByComparator) {

		List<Cases> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByUuid_Last(
			String uuid, OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByUuid_Last(uuid, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByUuid_Last(
		String uuid, OrderByComparator<Cases> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Cases> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		uuid = Objects.toString(uuid, "");

		Cases cases = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Cases[] array = new CasesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cases, uuid, orderByComparator, true);

			array[1] = cases;

			array[2] = getByUuid_PrevAndNext(
				session, cases, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cases getByUuid_PrevAndNext(
		Session session, Cases cases, String uuid,
		OrderByComparator<Cases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CASES_WHERE);

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
			sb.append(CasesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cases> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the caseses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Cases cases :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cases);
		}
	}

	/**
	 * Returns the number of caseses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching caseses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cases.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cases.uuid IS NULL OR cases.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByUUID_G(String uuid, long groupId)
		throws NoSuchCasesException {

		Cases cases = fetchByUUID_G(uuid, groupId);

		if (cases == null) {
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

			throw new NoSuchCasesException(sb.toString());
		}

		return cases;
	}

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the cases where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByUUID_G(
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

		if (result instanceof Cases) {
			Cases cases = (Cases)result;

			if (!Objects.equals(uuid, cases.getUuid()) ||
				(groupId != cases.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CASES_WHERE);

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

				List<Cases> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Cases cases = list.get(0);

					result = cases;

					cacheResult(cases);
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
			return (Cases)result;
		}
	}

	/**
	 * Removes the cases where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cases that was removed
	 */
	@Override
	public Cases removeByUUID_G(String uuid, long groupId)
		throws NoSuchCasesException {

		Cases cases = findByUUID_G(uuid, groupId);

		return remove(cases);
	}

	/**
	 * Returns the number of caseses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching caseses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASES_WHERE);

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
		"cases.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(cases.uuid IS NULL OR cases.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"cases.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching caseses
	 */
	@Override
	public List<Cases> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	@Override
	public List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

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

		List<Cases> list = null;

		if (useFinderCache) {
			list = (List<Cases>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Cases cases : list) {
					if (!uuid.equals(cases.getUuid()) ||
						(companyId != cases.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CASES_WHERE);

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
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
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

				list = (List<Cases>)QueryUtil.list(
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
	 * Returns the first cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the first cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Cases> orderByComparator) {

		List<Cases> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the last cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Cases> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Cases> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		uuid = Objects.toString(uuid, "");

		Cases cases = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Cases[] array = new CasesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, cases, uuid, companyId, orderByComparator, true);

			array[1] = cases;

			array[2] = getByUuid_C_PrevAndNext(
				session, cases, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cases getByUuid_C_PrevAndNext(
		Session session, Cases cases, String uuid, long companyId,
		OrderByComparator<Cases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CASES_WHERE);

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
			sb.append(CasesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cases> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the caseses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Cases cases :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cases);
		}
	}

	/**
	 * Returns the number of caseses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching caseses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASES_WHERE);

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
		"cases.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(cases.uuid IS NULL OR cases.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"cases.companyId = ?";

	private FinderPath _finderPathFetchByExternalCaseId;
	private FinderPath _finderPathCountByExternalCaseId;

	/**
	 * Returns the cases where externalCaseId = &#63; or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByExternalCaseId(long externalCaseId)
		throws NoSuchCasesException {

		Cases cases = fetchByExternalCaseId(externalCaseId);

		if (cases == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalCaseId=");
			sb.append(externalCaseId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCasesException(sb.toString());
		}

		return cases;
	}

	/**
	 * Returns the cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByExternalCaseId(long externalCaseId) {
		return fetchByExternalCaseId(externalCaseId, true);
	}

	/**
	 * Returns the cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByExternalCaseId(
		long externalCaseId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalCaseId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalCaseId, finderArgs, this);
		}

		if (result instanceof Cases) {
			Cases cases = (Cases)result;

			if (externalCaseId != cases.getExternalCaseId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CASES_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

				List<Cases> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalCaseId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {externalCaseId};
							}

							_log.warn(
								"CasesPersistenceImpl.fetchByExternalCaseId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Cases cases = list.get(0);

					result = cases;

					cacheResult(cases);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalCaseId, finderArgs);
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
			return (Cases)result;
		}
	}

	/**
	 * Removes the cases where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @return the cases that was removed
	 */
	@Override
	public Cases removeByExternalCaseId(long externalCaseId)
		throws NoSuchCasesException {

		Cases cases = findByExternalCaseId(externalCaseId);

		return remove(cases);
	}

	/**
	 * Returns the number of caseses where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching caseses
	 */
	@Override
	public int countByExternalCaseId(long externalCaseId) {
		FinderPath finderPath = _finderPathCountByExternalCaseId;

		Object[] finderArgs = new Object[] {externalCaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASES_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

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

	private static final String _FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2 =
		"cases.externalCaseId = ?";

	private FinderPath _finderPathWithPaginationFindByClientId;
	private FinderPath _finderPathWithoutPaginationFindByClientId;
	private FinderPath _finderPathCountByClientId;

	/**
	 * Returns all the caseses where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching caseses
	 */
	@Override
	public List<Cases> findByClientId(long clientId) {
		return findByClientId(
			clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	@Override
	public List<Cases> findByClientId(long clientId, int start, int end) {
		return findByClientId(clientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByClientId(
		long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return findByClientId(clientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caseses where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByClientId(
		long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

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

		List<Cases> list = null;

		if (useFinderCache) {
			list = (List<Cases>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Cases cases : list) {
					if (clientId != cases.getClientId()) {
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

			sb.append(_SQL_SELECT_CASES_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientId);

				list = (List<Cases>)QueryUtil.list(
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
	 * Returns the first cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByClientId_First(
			long clientId, OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByClientId_First(clientId, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("clientId=");
		sb.append(clientId);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the first cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByClientId_First(
		long clientId, OrderByComparator<Cases> orderByComparator) {

		List<Cases> list = findByClientId(clientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByClientId_Last(
			long clientId, OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByClientId_Last(clientId, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("clientId=");
		sb.append(clientId);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the last cases in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByClientId_Last(
		long clientId, OrderByComparator<Cases> orderByComparator) {

		int count = countByClientId(clientId);

		if (count == 0) {
			return null;
		}

		List<Cases> list = findByClientId(
			clientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases[] findByClientId_PrevAndNext(
			long caseId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Cases[] array = new CasesImpl[3];

			array[0] = getByClientId_PrevAndNext(
				session, cases, clientId, orderByComparator, true);

			array[1] = cases;

			array[2] = getByClientId_PrevAndNext(
				session, cases, clientId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cases getByClientId_PrevAndNext(
		Session session, Cases cases, long clientId,
		OrderByComparator<Cases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CASES_WHERE);

		sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

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
			sb.append(CasesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(clientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cases> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the caseses where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	@Override
	public void removeByClientId(long clientId) {
		for (Cases cases :
				findByClientId(
					clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cases);
		}
	}

	/**
	 * Returns the number of caseses where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching caseses
	 */
	@Override
	public int countByClientId(long clientId) {
		FinderPath finderPath = _finderPathCountByClientId;

		Object[] finderArgs = new Object[] {clientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASES_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientId);

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
		"cases.clientId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C;
	private FinderPath _finderPathWithoutPaginationFindByG_C;
	private FinderPath _finderPathCountByG_C;

	/**
	 * Returns all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the matching caseses
	 */
	@Override
	public List<Cases> findByG_C(long groupId, long clientId) {
		return findByG_C(
			groupId, clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	@Override
	public List<Cases> findByG_C(
		long groupId, long clientId, int start, int end) {

		return findByG_C(groupId, clientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByG_C(
		long groupId, long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return findByG_C(
			groupId, clientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByG_C(
		long groupId, long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C;
				finderArgs = new Object[] {groupId, clientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C;
			finderArgs = new Object[] {
				groupId, clientId, start, end, orderByComparator
			};
		}

		List<Cases> list = null;

		if (useFinderCache) {
			list = (List<Cases>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Cases cases : list) {
					if ((groupId != cases.getGroupId()) ||
						(clientId != cases.getClientId())) {

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

			sb.append(_SQL_SELECT_CASES_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(clientId);

				list = (List<Cases>)QueryUtil.list(
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
	 * Returns the first cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByG_C_First(
			long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByG_C_First(groupId, clientId, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", clientId=");
		sb.append(clientId);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the first cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByG_C_First(
		long groupId, long clientId,
		OrderByComparator<Cases> orderByComparator) {

		List<Cases> list = findByG_C(
			groupId, clientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByG_C_Last(
			long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByG_C_Last(groupId, clientId, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", clientId=");
		sb.append(clientId);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the last cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByG_C_Last(
		long groupId, long clientId,
		OrderByComparator<Cases> orderByComparator) {

		int count = countByG_C(groupId, clientId);

		if (count == 0) {
			return null;
		}

		List<Cases> list = findByG_C(
			groupId, clientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where groupId = &#63; and clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases[] findByG_C_PrevAndNext(
			long caseId, long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Cases[] array = new CasesImpl[3];

			array[0] = getByG_C_PrevAndNext(
				session, cases, groupId, clientId, orderByComparator, true);

			array[1] = cases;

			array[2] = getByG_C_PrevAndNext(
				session, cases, groupId, clientId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cases getByG_C_PrevAndNext(
		Session session, Cases cases, long groupId, long clientId,
		OrderByComparator<Cases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CASES_WHERE);

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CLIENTID_2);

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
			sb.append(CasesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(clientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cases> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the matching caseses that the user has permission to view
	 */
	@Override
	public List<Cases> filterFindByG_C(long groupId, long clientId) {
		return filterFindByG_C(
			groupId, clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses that the user has permission to view
	 */
	@Override
	public List<Cases> filterFindByG_C(
		long groupId, long clientId, int start, int end) {

		return filterFindByG_C(groupId, clientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses that the user has permissions to view where groupId = &#63; and clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses that the user has permission to view
	 */
	@Override
	public List<Cases> filterFindByG_C(
		long groupId, long clientId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C(groupId, clientId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CASES_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CASES_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CLIENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CASES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CasesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Cases.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CasesImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CasesImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(clientId);

			return (List<Cases>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set of caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases[] filterFindByG_C_PrevAndNext(
			long caseId, long groupId, long clientId,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_PrevAndNext(
				caseId, groupId, clientId, orderByComparator);
		}

		Cases cases = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Cases[] array = new CasesImpl[3];

			array[0] = filterGetByG_C_PrevAndNext(
				session, cases, groupId, clientId, orderByComparator, true);

			array[1] = cases;

			array[2] = filterGetByG_C_PrevAndNext(
				session, cases, groupId, clientId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cases filterGetByG_C_PrevAndNext(
		Session session, Cases cases, long groupId, long clientId,
		OrderByComparator<Cases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CASES_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_CASES_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CLIENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_CASES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(CasesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Cases.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, CasesImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, CasesImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(clientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cases> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the caseses where groupId = &#63; and clientId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 */
	@Override
	public void removeByG_C(long groupId, long clientId) {
		for (Cases cases :
				findByG_C(
					groupId, clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cases);
		}
	}

	/**
	 * Returns the number of caseses where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the number of matching caseses
	 */
	@Override
	public int countByG_C(long groupId, long clientId) {
		FinderPath finderPath = _finderPathCountByG_C;

		Object[] finderArgs = new Object[] {groupId, clientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASES_WHERE);

			sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_C_CLIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(clientId);

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

	/**
	 * Returns the number of caseses that the user has permission to view where groupId = &#63; and clientId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clientId the client ID
	 * @return the number of matching caseses that the user has permission to view
	 */
	@Override
	public int filterCountByG_C(long groupId, long clientId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C(groupId, clientId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_CASES_WHERE);

		sb.append(_FINDER_COLUMN_G_C_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_C_CLIENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Cases.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(clientId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 =
		"cases.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_CLIENTID_2 =
		"cases.clientId = ?";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the caseses where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching caseses
	 */
	@Override
	public List<Cases> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of matching caseses
	 */
	@Override
	public List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caseses where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caseses
	 */
	@Override
	public List<Cases> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Cases> orderByComparator, boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<Cases> list = null;

		if (useFinderCache) {
			list = (List<Cases>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Cases cases : list) {
					if (rowProcessed.equals(cases.getRowProcessed())) {
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

			sb.append(_SQL_SELECT_CASES_WHERE);

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
				sb.append(CasesModelImpl.ORDER_BY_JPQL);
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

				list = (List<Cases>)QueryUtil.list(
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
	 * Returns the first cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the first cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Cases> orderByComparator) {

		List<Cases> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases
	 * @throws NoSuchCasesException if a matching cases could not be found
	 */
	@Override
	public Cases findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		Cases cases = fetchByRowProcessed_Last(rowProcessed, orderByComparator);

		if (cases != null) {
			return cases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchCasesException(sb.toString());
	}

	/**
	 * Returns the last cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Cases> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<Cases> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the caseses before and after the current cases in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param caseId the primary key of the current cases
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases[] findByRowProcessed_PrevAndNext(
			long caseId, String rowProcessed,
			OrderByComparator<Cases> orderByComparator)
		throws NoSuchCasesException {

		rowProcessed = Objects.toString(rowProcessed, "");

		Cases cases = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Cases[] array = new CasesImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, cases, rowProcessed, orderByComparator, true);

			array[1] = cases;

			array[2] = getByRowProcessed_PrevAndNext(
				session, cases, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cases getByRowProcessed_PrevAndNext(
		Session session, Cases cases, String rowProcessed,
		OrderByComparator<Cases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CASES_WHERE);

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
			sb.append(CasesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cases> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the caseses where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (Cases cases :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cases);
		}
	}

	/**
	 * Returns the number of caseses where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching caseses
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASES_WHERE);

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
		"cases.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(cases.rowProcessed IS NULL OR cases.rowProcessed != '')";

	public CasesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Cases.class);

		setModelImplClass(CasesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cases in the entity cache if it is enabled.
	 *
	 * @param cases the cases
	 */
	@Override
	public void cacheResult(Cases cases) {
		entityCache.putResult(
			entityCacheEnabled, CasesImpl.class, cases.getPrimaryKey(), cases);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {cases.getUuid(), cases.getGroupId()}, cases);

		finderCache.putResult(
			_finderPathFetchByExternalCaseId,
			new Object[] {cases.getExternalCaseId()}, cases);

		cases.resetOriginalValues();
	}

	/**
	 * Caches the caseses in the entity cache if it is enabled.
	 *
	 * @param caseses the caseses
	 */
	@Override
	public void cacheResult(List<Cases> caseses) {
		for (Cases cases : caseses) {
			if (entityCache.getResult(
					entityCacheEnabled, CasesImpl.class,
					cases.getPrimaryKey()) == null) {

				cacheResult(cases);
			}
			else {
				cases.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all caseses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CasesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cases cases) {
		entityCache.removeResult(
			entityCacheEnabled, CasesImpl.class, cases.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CasesModelImpl)cases, true);
	}

	@Override
	public void clearCache(List<Cases> caseses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cases cases : caseses) {
			entityCache.removeResult(
				entityCacheEnabled, CasesImpl.class, cases.getPrimaryKey());

			clearUniqueFindersCache((CasesModelImpl)cases, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CasesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(CasesModelImpl casesModelImpl) {
		Object[] args = new Object[] {
			casesModelImpl.getUuid(), casesModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, casesModelImpl, false);

		args = new Object[] {casesModelImpl.getExternalCaseId()};

		finderCache.putResult(
			_finderPathCountByExternalCaseId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalCaseId, args, casesModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CasesModelImpl casesModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				casesModelImpl.getUuid(), casesModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((casesModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				casesModelImpl.getOriginalUuid(),
				casesModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {casesModelImpl.getExternalCaseId()};

			finderCache.removeResult(_finderPathCountByExternalCaseId, args);
			finderCache.removeResult(_finderPathFetchByExternalCaseId, args);
		}

		if ((casesModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalCaseId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				casesModelImpl.getOriginalExternalCaseId()
			};

			finderCache.removeResult(_finderPathCountByExternalCaseId, args);
			finderCache.removeResult(_finderPathFetchByExternalCaseId, args);
		}
	}

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	@Override
	public Cases create(long caseId) {
		Cases cases = new CasesImpl();

		cases.setNew(true);
		cases.setPrimaryKey(caseId);

		String uuid = PortalUUIDUtil.generate();

		cases.setUuid(uuid);

		cases.setCompanyId(CompanyThreadLocal.getCompanyId());

		return cases;
	}

	/**
	 * Removes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases that was removed
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases remove(long caseId) throws NoSuchCasesException {
		return remove((Serializable)caseId);
	}

	/**
	 * Removes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cases
	 * @return the cases that was removed
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases remove(Serializable primaryKey) throws NoSuchCasesException {
		Session session = null;

		try {
			session = openSession();

			Cases cases = (Cases)session.get(CasesImpl.class, primaryKey);

			if (cases == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCasesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cases);
		}
		catch (NoSuchCasesException noSuchEntityException) {
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
	protected Cases removeImpl(Cases cases) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cases)) {
				cases = (Cases)session.get(
					CasesImpl.class, cases.getPrimaryKeyObj());
			}

			if (cases != null) {
				session.delete(cases);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cases != null) {
			clearCache(cases);
		}

		return cases;
	}

	@Override
	public Cases updateImpl(Cases cases) {
		boolean isNew = cases.isNew();

		if (!(cases instanceof CasesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cases.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cases);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cases proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Cases implementation " +
					cases.getClass());
		}

		CasesModelImpl casesModelImpl = (CasesModelImpl)cases;

		if (Validator.isNull(cases.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cases.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cases.getCreateDate() == null)) {
			if (serviceContext == null) {
				cases.setCreateDate(now);
			}
			else {
				cases.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!casesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cases.setModifiedDate(now);
			}
			else {
				cases.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cases);

				cases.setNew(false);
			}
			else {
				cases = (Cases)session.merge(cases);
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
			Object[] args = new Object[] {casesModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				casesModelImpl.getUuid(), casesModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {casesModelImpl.getClientId()};

			finderCache.removeResult(_finderPathCountByClientId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClientId, args);

			args = new Object[] {
				casesModelImpl.getGroupId(), casesModelImpl.getClientId()
			};

			finderCache.removeResult(_finderPathCountByG_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((casesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {casesModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {casesModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((casesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					casesModelImpl.getOriginalUuid(),
					casesModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					casesModelImpl.getUuid(), casesModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((casesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClientId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					casesModelImpl.getOriginalClientId()
				};

				finderCache.removeResult(_finderPathCountByClientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClientId, args);

				args = new Object[] {casesModelImpl.getClientId()};

				finderCache.removeResult(_finderPathCountByClientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClientId, args);
			}

			if ((casesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					casesModelImpl.getOriginalGroupId(),
					casesModelImpl.getOriginalClientId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);

				args = new Object[] {
					casesModelImpl.getGroupId(), casesModelImpl.getClientId()
				};

				finderCache.removeResult(_finderPathCountByG_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CasesImpl.class, cases.getPrimaryKey(), cases,
			false);

		clearUniqueFindersCache(casesModelImpl, false);
		cacheUniqueFindersCache(casesModelImpl);

		cases.resetOriginalValues();

		return cases;
	}

	/**
	 * Returns the cases with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cases
	 * @return the cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCasesException {

		Cases cases = fetchByPrimaryKey(primaryKey);

		if (cases == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCasesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cases;
	}

	/**
	 * Returns the cases with the primary key or throws a <code>NoSuchCasesException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws NoSuchCasesException if a cases with the primary key could not be found
	 */
	@Override
	public Cases findByPrimaryKey(long caseId) throws NoSuchCasesException {
		return findByPrimaryKey((Serializable)caseId);
	}

	/**
	 * Returns the cases with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases, or <code>null</code> if a cases with the primary key could not be found
	 */
	@Override
	public Cases fetchByPrimaryKey(long caseId) {
		return fetchByPrimaryKey((Serializable)caseId);
	}

	/**
	 * Returns all the caseses.
	 *
	 * @return the caseses
	 */
	@Override
	public List<Cases> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of caseses
	 */
	@Override
	public List<Cases> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of caseses
	 */
	@Override
	public List<Cases> findAll(
		int start, int end, OrderByComparator<Cases> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of caseses
	 */
	@Override
	public List<Cases> findAll(
		int start, int end, OrderByComparator<Cases> orderByComparator,
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

		List<Cases> list = null;

		if (useFinderCache) {
			list = (List<Cases>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CASES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CASES;

				sql = sql.concat(CasesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Cases>)QueryUtil.list(
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
	 * Removes all the caseses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Cases cases : findAll()) {
			remove(cases);
		}
	}

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CASES);

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
		return "caseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CASES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CasesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cases persistence.
	 */
	@Activate
	public void activate() {
		CasesModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CasesModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CasesModelImpl.UUID_COLUMN_BITMASK |
			CasesModelImpl.LASTUPDATED_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CasesModelImpl.UUID_COLUMN_BITMASK |
			CasesModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CasesModelImpl.UUID_COLUMN_BITMASK |
			CasesModelImpl.COMPANYID_COLUMN_BITMASK |
			CasesModelImpl.LASTUPDATED_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalCaseId",
			new String[] {Long.class.getName()},
			CasesModelImpl.EXTERNALCASEID_COLUMN_BITMASK);

		_finderPathCountByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExternalCaseId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClientId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClientId",
			new String[] {Long.class.getName()},
			CasesModelImpl.CLIENTID_COLUMN_BITMASK |
			CasesModelImpl.LASTUPDATED_COLUMN_BITMASK);

		_finderPathCountByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CasesModelImpl.GROUPID_COLUMN_BITMASK |
			CasesModelImpl.CLIENTID_COLUMN_BITMASK |
			CasesModelImpl.LASTUPDATED_COLUMN_BITMASK);

		_finderPathCountByG_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesImpl.class,
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
		entityCache.removeCache(CasesImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.Cases"),
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

	private static final String _SQL_SELECT_CASES =
		"SELECT cases FROM Cases cases";

	private static final String _SQL_SELECT_CASES_WHERE =
		"SELECT cases FROM Cases cases WHERE ";

	private static final String _SQL_COUNT_CASES =
		"SELECT COUNT(cases) FROM Cases cases";

	private static final String _SQL_COUNT_CASES_WHERE =
		"SELECT COUNT(cases) FROM Cases cases WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"cases.caseId";

	private static final String _FILTER_SQL_SELECT_CASES_WHERE =
		"SELECT DISTINCT {cases.*} FROM OTH_Cases cases WHERE ";

	private static final String
		_FILTER_SQL_SELECT_CASES_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {OTH_Cases.*} FROM (SELECT DISTINCT cases.caseId FROM OTH_Cases cases WHERE ";

	private static final String
		_FILTER_SQL_SELECT_CASES_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN OTH_Cases ON TEMP_TABLE.caseId = OTH_Cases.caseId";

	private static final String _FILTER_SQL_COUNT_CASES_WHERE =
		"SELECT COUNT(DISTINCT cases.caseId) AS COUNT_VALUE FROM OTH_Cases cases WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "cases";

	private static final String _FILTER_ENTITY_TABLE = "OTH_Cases";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cases.";

	private static final String _ORDER_BY_ENTITY_TABLE = "OTH_Cases.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Cases exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Cases exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CasesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}