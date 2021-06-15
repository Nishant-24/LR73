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

import com.argus.oth.cases.management.exception.NoSuchCasesGroupItemException;
import com.argus.oth.cases.management.model.CasesGroupItem;
import com.argus.oth.cases.management.model.impl.CasesGroupItemImpl;
import com.argus.oth.cases.management.model.impl.CasesGroupItemModelImpl;
import com.argus.oth.cases.management.service.persistence.CasesGroupItemPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the cases group item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CasesGroupItemPersistence.class)
public class CasesGroupItemPersistenceImpl
	extends BasePersistenceImpl<CasesGroupItem>
	implements CasesGroupItemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CasesGroupItemUtil</code> to access the cases group item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CasesGroupItemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByE_U_T;
	private FinderPath _finderPathCountByE_U_T;

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or throws a <code>NoSuchCasesGroupItemException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem findByE_U_T(
			long externalCaseId, long userId, String type)
		throws NoSuchCasesGroupItemException {

		CasesGroupItem casesGroupItem = fetchByE_U_T(
			externalCaseId, userId, type);

		if (casesGroupItem == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalCaseId=");
			sb.append(externalCaseId);

			sb.append(", userId=");
			sb.append(userId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCasesGroupItemException(sb.toString());
		}

		return casesGroupItem;
	}

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem fetchByE_U_T(
		long externalCaseId, long userId, String type) {

		return fetchByE_U_T(externalCaseId, userId, type, true);
	}

	/**
	 * Returns the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem fetchByE_U_T(
		long externalCaseId, long userId, String type, boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalCaseId, userId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByE_U_T, finderArgs, this);
		}

		if (result instanceof CasesGroupItem) {
			CasesGroupItem casesGroupItem = (CasesGroupItem)result;

			if ((externalCaseId != casesGroupItem.getExternalCaseId()) ||
				(userId != casesGroupItem.getUserId()) ||
				!Objects.equals(type, casesGroupItem.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_CASESGROUPITEM_WHERE);

			sb.append(_FINDER_COLUMN_E_U_T_EXTERNALCASEID_2);

			sb.append(_FINDER_COLUMN_E_U_T_USERID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_U_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_E_U_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

				queryPos.add(userId);

				if (bindType) {
					queryPos.add(type);
				}

				List<CasesGroupItem> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByE_U_T, finderArgs, list);
					}
				}
				else {
					CasesGroupItem casesGroupItem = list.get(0);

					result = casesGroupItem;

					cacheResult(casesGroupItem);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByE_U_T, finderArgs);
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
			return (CasesGroupItem)result;
		}
	}

	/**
	 * Removes the cases group item where externalCaseId = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the cases group item that was removed
	 */
	@Override
	public CasesGroupItem removeByE_U_T(
			long externalCaseId, long userId, String type)
		throws NoSuchCasesGroupItemException {

		CasesGroupItem casesGroupItem = findByE_U_T(
			externalCaseId, userId, type);

		return remove(casesGroupItem);
	}

	/**
	 * Returns the number of cases group items where externalCaseId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching cases group items
	 */
	@Override
	public int countByE_U_T(long externalCaseId, long userId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByE_U_T;

		Object[] finderArgs = new Object[] {externalCaseId, userId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CASESGROUPITEM_WHERE);

			sb.append(_FINDER_COLUMN_E_U_T_EXTERNALCASEID_2);

			sb.append(_FINDER_COLUMN_E_U_T_USERID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_U_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_E_U_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

				queryPos.add(userId);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_E_U_T_EXTERNALCASEID_2 =
		"casesGroupItem.externalCaseId = ? AND ";

	private static final String _FINDER_COLUMN_E_U_T_USERID_2 =
		"casesGroupItem.userId = ? AND ";

	private static final String _FINDER_COLUMN_E_U_T_TYPE_2 =
		"casesGroupItem.type = ?";

	private static final String _FINDER_COLUMN_E_U_T_TYPE_3 =
		"(casesGroupItem.type IS NULL OR casesGroupItem.type = '')";

	private FinderPath _finderPathWithPaginationFindByG_U_T;
	private FinderPath _finderPathWithoutPaginationFindByG_U_T;
	private FinderPath _finderPathCountByG_U_T;

	/**
	 * Returns all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching cases group items
	 */
	@Override
	public List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type) {

		return findByG_U_T(
			groupId, userId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @return the range of matching cases group items
	 */
	@Override
	public List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end) {

		return findByG_U_T(groupId, userId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cases group items
	 */
	@Override
	public List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return findByG_U_T(
			groupId, userId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cases group items
	 */
	@Override
	public List<CasesGroupItem> findByG_U_T(
		long groupId, long userId, String type, int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U_T;
				finderArgs = new Object[] {groupId, userId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U_T;
			finderArgs = new Object[] {
				groupId, userId, type, start, end, orderByComparator
			};
		}

		List<CasesGroupItem> list = null;

		if (useFinderCache) {
			list = (List<CasesGroupItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CasesGroupItem casesGroupItem : list) {
					if ((groupId != casesGroupItem.getGroupId()) ||
						(userId != casesGroupItem.getUserId()) ||
						!type.equals(casesGroupItem.getType())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CASESGROUPITEM_WHERE);

			sb.append(_FINDER_COLUMN_G_U_T_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_T_USERID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_U_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_G_U_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CasesGroupItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<CasesGroupItem>)QueryUtil.list(
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
	 * Returns the first cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem findByG_U_T_First(
			long groupId, long userId, String type,
			OrderByComparator<CasesGroupItem> orderByComparator)
		throws NoSuchCasesGroupItemException {

		CasesGroupItem casesGroupItem = fetchByG_U_T_First(
			groupId, userId, type, orderByComparator);

		if (casesGroupItem != null) {
			return casesGroupItem;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCasesGroupItemException(sb.toString());
	}

	/**
	 * Returns the first cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem fetchByG_U_T_First(
		long groupId, long userId, String type,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		List<CasesGroupItem> list = findByG_U_T(
			groupId, userId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases group item
	 * @throws NoSuchCasesGroupItemException if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem findByG_U_T_Last(
			long groupId, long userId, String type,
			OrderByComparator<CasesGroupItem> orderByComparator)
		throws NoSuchCasesGroupItemException {

		CasesGroupItem casesGroupItem = fetchByG_U_T_Last(
			groupId, userId, type, orderByComparator);

		if (casesGroupItem != null) {
			return casesGroupItem;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCasesGroupItemException(sb.toString());
	}

	/**
	 * Returns the last cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cases group item, or <code>null</code> if a matching cases group item could not be found
	 */
	@Override
	public CasesGroupItem fetchByG_U_T_Last(
		long groupId, long userId, String type,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		int count = countByG_U_T(groupId, userId, type);

		if (count == 0) {
			return null;
		}

		List<CasesGroupItem> list = findByG_U_T(
			groupId, userId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cases group items before and after the current cases group item in the ordered set where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param casesGroupItemId the primary key of the current cases group item
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cases group item
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	@Override
	public CasesGroupItem[] findByG_U_T_PrevAndNext(
			long casesGroupItemId, long groupId, long userId, String type,
			OrderByComparator<CasesGroupItem> orderByComparator)
		throws NoSuchCasesGroupItemException {

		type = Objects.toString(type, "");

		CasesGroupItem casesGroupItem = findByPrimaryKey(casesGroupItemId);

		Session session = null;

		try {
			session = openSession();

			CasesGroupItem[] array = new CasesGroupItemImpl[3];

			array[0] = getByG_U_T_PrevAndNext(
				session, casesGroupItem, groupId, userId, type,
				orderByComparator, true);

			array[1] = casesGroupItem;

			array[2] = getByG_U_T_PrevAndNext(
				session, casesGroupItem, groupId, userId, type,
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

	protected CasesGroupItem getByG_U_T_PrevAndNext(
		Session session, CasesGroupItem casesGroupItem, long groupId,
		long userId, String type,
		OrderByComparator<CasesGroupItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CASESGROUPITEM_WHERE);

		sb.append(_FINDER_COLUMN_G_U_T_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_T_USERID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_U_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_G_U_T_TYPE_2);
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
			sb.append(CasesGroupItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						casesGroupItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CasesGroupItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cases group items where groupId = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 */
	@Override
	public void removeByG_U_T(long groupId, long userId, String type) {
		for (CasesGroupItem casesGroupItem :
				findByG_U_T(
					groupId, userId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(casesGroupItem);
		}
	}

	/**
	 * Returns the number of cases group items where groupId = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching cases group items
	 */
	@Override
	public int countByG_U_T(long groupId, long userId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByG_U_T;

		Object[] finderArgs = new Object[] {groupId, userId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CASESGROUPITEM_WHERE);

			sb.append(_FINDER_COLUMN_G_U_T_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_T_USERID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_U_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_G_U_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_G_U_T_GROUPID_2 =
		"casesGroupItem.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_T_USERID_2 =
		"casesGroupItem.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_T_TYPE_2 =
		"casesGroupItem.type = ?";

	private static final String _FINDER_COLUMN_G_U_T_TYPE_3 =
		"(casesGroupItem.type IS NULL OR casesGroupItem.type = '')";

	public CasesGroupItemPersistenceImpl() {
		setModelClass(CasesGroupItem.class);

		setModelImplClass(CasesGroupItemImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cases group item in the entity cache if it is enabled.
	 *
	 * @param casesGroupItem the cases group item
	 */
	@Override
	public void cacheResult(CasesGroupItem casesGroupItem) {
		entityCache.putResult(
			entityCacheEnabled, CasesGroupItemImpl.class,
			casesGroupItem.getPrimaryKey(), casesGroupItem);

		finderCache.putResult(
			_finderPathFetchByE_U_T,
			new Object[] {
				casesGroupItem.getExternalCaseId(), casesGroupItem.getUserId(),
				casesGroupItem.getType()
			},
			casesGroupItem);

		casesGroupItem.resetOriginalValues();
	}

	/**
	 * Caches the cases group items in the entity cache if it is enabled.
	 *
	 * @param casesGroupItems the cases group items
	 */
	@Override
	public void cacheResult(List<CasesGroupItem> casesGroupItems) {
		for (CasesGroupItem casesGroupItem : casesGroupItems) {
			if (entityCache.getResult(
					entityCacheEnabled, CasesGroupItemImpl.class,
					casesGroupItem.getPrimaryKey()) == null) {

				cacheResult(casesGroupItem);
			}
			else {
				casesGroupItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cases group items.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CasesGroupItemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cases group item.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CasesGroupItem casesGroupItem) {
		entityCache.removeResult(
			entityCacheEnabled, CasesGroupItemImpl.class,
			casesGroupItem.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CasesGroupItemModelImpl)casesGroupItem, true);
	}

	@Override
	public void clearCache(List<CasesGroupItem> casesGroupItems) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CasesGroupItem casesGroupItem : casesGroupItems) {
			entityCache.removeResult(
				entityCacheEnabled, CasesGroupItemImpl.class,
				casesGroupItem.getPrimaryKey());

			clearUniqueFindersCache(
				(CasesGroupItemModelImpl)casesGroupItem, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CasesGroupItemImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CasesGroupItemModelImpl casesGroupItemModelImpl) {

		Object[] args = new Object[] {
			casesGroupItemModelImpl.getExternalCaseId(),
			casesGroupItemModelImpl.getUserId(),
			casesGroupItemModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByE_U_T, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByE_U_T, args, casesGroupItemModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CasesGroupItemModelImpl casesGroupItemModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				casesGroupItemModelImpl.getExternalCaseId(),
				casesGroupItemModelImpl.getUserId(),
				casesGroupItemModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByE_U_T, args);
			finderCache.removeResult(_finderPathFetchByE_U_T, args);
		}

		if ((casesGroupItemModelImpl.getColumnBitmask() &
			 _finderPathFetchByE_U_T.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				casesGroupItemModelImpl.getOriginalExternalCaseId(),
				casesGroupItemModelImpl.getOriginalUserId(),
				casesGroupItemModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByE_U_T, args);
			finderCache.removeResult(_finderPathFetchByE_U_T, args);
		}
	}

	/**
	 * Creates a new cases group item with the primary key. Does not add the cases group item to the database.
	 *
	 * @param casesGroupItemId the primary key for the new cases group item
	 * @return the new cases group item
	 */
	@Override
	public CasesGroupItem create(long casesGroupItemId) {
		CasesGroupItem casesGroupItem = new CasesGroupItemImpl();

		casesGroupItem.setNew(true);
		casesGroupItem.setPrimaryKey(casesGroupItemId);

		casesGroupItem.setCompanyId(CompanyThreadLocal.getCompanyId());

		return casesGroupItem;
	}

	/**
	 * Removes the cases group item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item that was removed
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	@Override
	public CasesGroupItem remove(long casesGroupItemId)
		throws NoSuchCasesGroupItemException {

		return remove((Serializable)casesGroupItemId);
	}

	/**
	 * Removes the cases group item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cases group item
	 * @return the cases group item that was removed
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	@Override
	public CasesGroupItem remove(Serializable primaryKey)
		throws NoSuchCasesGroupItemException {

		Session session = null;

		try {
			session = openSession();

			CasesGroupItem casesGroupItem = (CasesGroupItem)session.get(
				CasesGroupItemImpl.class, primaryKey);

			if (casesGroupItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCasesGroupItemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(casesGroupItem);
		}
		catch (NoSuchCasesGroupItemException noSuchEntityException) {
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
	protected CasesGroupItem removeImpl(CasesGroupItem casesGroupItem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(casesGroupItem)) {
				casesGroupItem = (CasesGroupItem)session.get(
					CasesGroupItemImpl.class,
					casesGroupItem.getPrimaryKeyObj());
			}

			if (casesGroupItem != null) {
				session.delete(casesGroupItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (casesGroupItem != null) {
			clearCache(casesGroupItem);
		}

		return casesGroupItem;
	}

	@Override
	public CasesGroupItem updateImpl(CasesGroupItem casesGroupItem) {
		boolean isNew = casesGroupItem.isNew();

		if (!(casesGroupItem instanceof CasesGroupItemModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(casesGroupItem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					casesGroupItem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in casesGroupItem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CasesGroupItem implementation " +
					casesGroupItem.getClass());
		}

		CasesGroupItemModelImpl casesGroupItemModelImpl =
			(CasesGroupItemModelImpl)casesGroupItem;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (casesGroupItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				casesGroupItem.setCreateDate(now);
			}
			else {
				casesGroupItem.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!casesGroupItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				casesGroupItem.setModifiedDate(now);
			}
			else {
				casesGroupItem.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (casesGroupItem.isNew()) {
				session.save(casesGroupItem);

				casesGroupItem.setNew(false);
			}
			else {
				casesGroupItem = (CasesGroupItem)session.merge(casesGroupItem);
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
			Object[] args = new Object[] {
				casesGroupItemModelImpl.getGroupId(),
				casesGroupItemModelImpl.getUserId(),
				casesGroupItemModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByG_U_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U_T, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((casesGroupItemModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					casesGroupItemModelImpl.getOriginalGroupId(),
					casesGroupItemModelImpl.getOriginalUserId(),
					casesGroupItemModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByG_U_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_T, args);

				args = new Object[] {
					casesGroupItemModelImpl.getGroupId(),
					casesGroupItemModelImpl.getUserId(),
					casesGroupItemModelImpl.getType()
				};

				finderCache.removeResult(_finderPathCountByG_U_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_T, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CasesGroupItemImpl.class,
			casesGroupItem.getPrimaryKey(), casesGroupItem, false);

		clearUniqueFindersCache(casesGroupItemModelImpl, false);
		cacheUniqueFindersCache(casesGroupItemModelImpl);

		casesGroupItem.resetOriginalValues();

		return casesGroupItem;
	}

	/**
	 * Returns the cases group item with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cases group item
	 * @return the cases group item
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	@Override
	public CasesGroupItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCasesGroupItemException {

		CasesGroupItem casesGroupItem = fetchByPrimaryKey(primaryKey);

		if (casesGroupItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCasesGroupItemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return casesGroupItem;
	}

	/**
	 * Returns the cases group item with the primary key or throws a <code>NoSuchCasesGroupItemException</code> if it could not be found.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item
	 * @throws NoSuchCasesGroupItemException if a cases group item with the primary key could not be found
	 */
	@Override
	public CasesGroupItem findByPrimaryKey(long casesGroupItemId)
		throws NoSuchCasesGroupItemException {

		return findByPrimaryKey((Serializable)casesGroupItemId);
	}

	/**
	 * Returns the cases group item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item, or <code>null</code> if a cases group item with the primary key could not be found
	 */
	@Override
	public CasesGroupItem fetchByPrimaryKey(long casesGroupItemId) {
		return fetchByPrimaryKey((Serializable)casesGroupItemId);
	}

	/**
	 * Returns all the cases group items.
	 *
	 * @return the cases group items
	 */
	@Override
	public List<CasesGroupItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @return the range of cases group items
	 */
	@Override
	public List<CasesGroupItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cases group items
	 */
	@Override
	public List<CasesGroupItem> findAll(
		int start, int end,
		OrderByComparator<CasesGroupItem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cases group items
	 */
	@Override
	public List<CasesGroupItem> findAll(
		int start, int end, OrderByComparator<CasesGroupItem> orderByComparator,
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

		List<CasesGroupItem> list = null;

		if (useFinderCache) {
			list = (List<CasesGroupItem>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CASESGROUPITEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CASESGROUPITEM;

				sql = sql.concat(CasesGroupItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CasesGroupItem>)QueryUtil.list(
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
	 * Removes all the cases group items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CasesGroupItem casesGroupItem : findAll()) {
			remove(casesGroupItem);
		}
	}

	/**
	 * Returns the number of cases group items.
	 *
	 * @return the number of cases group items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CASESGROUPITEM);

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
		return "casesGroupItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CASESGROUPITEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CasesGroupItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cases group item persistence.
	 */
	@Activate
	public void activate() {
		CasesGroupItemModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CasesGroupItemModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesGroupItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesGroupItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByE_U_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesGroupItemImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByE_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CasesGroupItemModelImpl.EXTERNALCASEID_COLUMN_BITMASK |
			CasesGroupItemModelImpl.USERID_COLUMN_BITMASK |
			CasesGroupItemModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByE_U_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByG_U_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesGroupItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CasesGroupItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CasesGroupItemModelImpl.GROUPID_COLUMN_BITMASK |
			CasesGroupItemModelImpl.USERID_COLUMN_BITMASK |
			CasesGroupItemModelImpl.TYPE_COLUMN_BITMASK |
			CasesGroupItemModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_U_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CasesGroupItemImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.CasesGroupItem"),
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

	private static final String _SQL_SELECT_CASESGROUPITEM =
		"SELECT casesGroupItem FROM CasesGroupItem casesGroupItem";

	private static final String _SQL_SELECT_CASESGROUPITEM_WHERE =
		"SELECT casesGroupItem FROM CasesGroupItem casesGroupItem WHERE ";

	private static final String _SQL_COUNT_CASESGROUPITEM =
		"SELECT COUNT(casesGroupItem) FROM CasesGroupItem casesGroupItem";

	private static final String _SQL_COUNT_CASESGROUPITEM_WHERE =
		"SELECT COUNT(casesGroupItem) FROM CasesGroupItem casesGroupItem WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "casesGroupItem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CasesGroupItem exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CasesGroupItem exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CasesGroupItemPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}