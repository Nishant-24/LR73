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

import com.argus.oth.cases.management.exception.NoSuchReferenceTypeCodeException;
import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.model.impl.ReferenceTypeCodeImpl;
import com.argus.oth.cases.management.model.impl.ReferenceTypeCodeModelImpl;
import com.argus.oth.cases.management.service.persistence.ReferenceTypeCodePersistence;
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
 * The persistence implementation for the reference type code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ReferenceTypeCodePersistence.class)
public class ReferenceTypeCodePersistenceImpl
	extends BasePersistenceImpl<ReferenceTypeCode>
	implements ReferenceTypeCodePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReferenceTypeCodeUtil</code> to access the reference type code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReferenceTypeCodeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the reference type code where key = &#63; or throws a <code>NoSuchReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode findByKey(String key)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = fetchByKey(key);

		if (referenceTypeCode == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("key=");
			sb.append(key);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchReferenceTypeCodeException(sb.toString());
		}

		return referenceTypeCode;
	}

	/**
	 * Returns the reference type code where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByKey(String key) {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the reference type code where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByKey(String key, boolean useFinderCache) {
		key = Objects.toString(key, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {key};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByKey, finderArgs, this);
		}

		if (result instanceof ReferenceTypeCode) {
			ReferenceTypeCode referenceTypeCode = (ReferenceTypeCode)result;

			if (!Objects.equals(key, referenceTypeCode.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_REFERENCETYPECODE_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
				}

				List<ReferenceTypeCode> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByKey, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {key};
							}

							_log.warn(
								"ReferenceTypeCodePersistenceImpl.fetchByKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ReferenceTypeCode referenceTypeCode = list.get(0);

					result = referenceTypeCode;

					cacheResult(referenceTypeCode);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByKey, finderArgs);
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
			return (ReferenceTypeCode)result;
		}
	}

	/**
	 * Removes the reference type code where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the reference type code that was removed
	 */
	@Override
	public ReferenceTypeCode removeByKey(String key)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = findByKey(key);

		return remove(referenceTypeCode);
	}

	/**
	 * Returns the number of reference type codes where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching reference type codes
	 */
	@Override
	public int countByKey(String key) {
		key = Objects.toString(key, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {key};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REFERENCETYPECODE_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
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

	private static final String _FINDER_COLUMN_KEY_KEY_2 =
		"referenceTypeCode.key = ?";

	private static final String _FINDER_COLUMN_KEY_KEY_3 =
		"(referenceTypeCode.key IS NULL OR referenceTypeCode.key = '')";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<ReferenceTypeCode> list = null;

		if (useFinderCache) {
			list = (List<ReferenceTypeCode>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ReferenceTypeCode referenceTypeCode : list) {
					if (rowProcessed.equals(
							referenceTypeCode.getRowProcessed())) {

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

			sb.append(_SQL_SELECT_REFERENCETYPECODE_WHERE);

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
				sb.append(ReferenceTypeCodeModelImpl.ORDER_BY_JPQL);
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

				list = (List<ReferenceTypeCode>)QueryUtil.list(
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
	 * Returns the first reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode findByRowProcessed_First(
			String rowProcessed,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (referenceTypeCode != null) {
			return referenceTypeCode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchReferenceTypeCodeException(sb.toString());
	}

	/**
	 * Returns the first reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByRowProcessed_First(
		String rowProcessed,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		List<ReferenceTypeCode> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode findByRowProcessed_Last(
			String rowProcessed,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (referenceTypeCode != null) {
			return referenceTypeCode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchReferenceTypeCodeException(sb.toString());
	}

	/**
	 * Returns the last reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByRowProcessed_Last(
		String rowProcessed,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<ReferenceTypeCode> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reference type codes before and after the current reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param referenceTypeCodeId the primary key of the current reference type code
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode[] findByRowProcessed_PrevAndNext(
			long referenceTypeCodeId, String rowProcessed,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws NoSuchReferenceTypeCodeException {

		rowProcessed = Objects.toString(rowProcessed, "");

		ReferenceTypeCode referenceTypeCode = findByPrimaryKey(
			referenceTypeCodeId);

		Session session = null;

		try {
			session = openSession();

			ReferenceTypeCode[] array = new ReferenceTypeCodeImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, referenceTypeCode, rowProcessed, orderByComparator,
				true);

			array[1] = referenceTypeCode;

			array[2] = getByRowProcessed_PrevAndNext(
				session, referenceTypeCode, rowProcessed, orderByComparator,
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

	protected ReferenceTypeCode getByRowProcessed_PrevAndNext(
		Session session, ReferenceTypeCode referenceTypeCode,
		String rowProcessed,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REFERENCETYPECODE_WHERE);

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
			sb.append(ReferenceTypeCodeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						referenceTypeCode)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ReferenceTypeCode> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reference type codes where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (ReferenceTypeCode referenceTypeCode :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(referenceTypeCode);
		}
	}

	/**
	 * Returns the number of reference type codes where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching reference type codes
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REFERENCETYPECODE_WHERE);

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
		"referenceTypeCode.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(referenceTypeCode.rowProcessed IS NULL OR referenceTypeCode.rowProcessed != '')";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the reference type codes where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByType(String type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByType(String type, int start, int end) {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByType(
		String type, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return findByType(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findByType(
		String type, int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<ReferenceTypeCode> list = null;

		if (useFinderCache) {
			list = (List<ReferenceTypeCode>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ReferenceTypeCode referenceTypeCode : list) {
					if (!type.equals(referenceTypeCode.getType())) {
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

			sb.append(_SQL_SELECT_REFERENCETYPECODE_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ReferenceTypeCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<ReferenceTypeCode>)QueryUtil.list(
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
	 * Returns the first reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode findByType_First(
			String type, OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = fetchByType_First(
			type, orderByComparator);

		if (referenceTypeCode != null) {
			return referenceTypeCode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchReferenceTypeCodeException(sb.toString());
	}

	/**
	 * Returns the first reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByType_First(
		String type, OrderByComparator<ReferenceTypeCode> orderByComparator) {

		List<ReferenceTypeCode> list = findByType(
			type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode findByType_Last(
			String type, OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = fetchByType_Last(
			type, orderByComparator);

		if (referenceTypeCode != null) {
			return referenceTypeCode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchReferenceTypeCodeException(sb.toString());
	}

	/**
	 * Returns the last reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByType_Last(
		String type, OrderByComparator<ReferenceTypeCode> orderByComparator) {

		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<ReferenceTypeCode> list = findByType(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reference type codes before and after the current reference type code in the ordered set where type = &#63;.
	 *
	 * @param referenceTypeCodeId the primary key of the current reference type code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode[] findByType_PrevAndNext(
			long referenceTypeCodeId, String type,
			OrderByComparator<ReferenceTypeCode> orderByComparator)
		throws NoSuchReferenceTypeCodeException {

		type = Objects.toString(type, "");

		ReferenceTypeCode referenceTypeCode = findByPrimaryKey(
			referenceTypeCodeId);

		Session session = null;

		try {
			session = openSession();

			ReferenceTypeCode[] array = new ReferenceTypeCodeImpl[3];

			array[0] = getByType_PrevAndNext(
				session, referenceTypeCode, type, orderByComparator, true);

			array[1] = referenceTypeCode;

			array[2] = getByType_PrevAndNext(
				session, referenceTypeCode, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReferenceTypeCode getByType_PrevAndNext(
		Session session, ReferenceTypeCode referenceTypeCode, String type,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REFERENCETYPECODE_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
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
			sb.append(ReferenceTypeCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						referenceTypeCode)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ReferenceTypeCode> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reference type codes where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(String type) {
		for (ReferenceTypeCode referenceTypeCode :
				findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(referenceTypeCode);
		}
	}

	/**
	 * Returns the number of reference type codes where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching reference type codes
	 */
	@Override
	public int countByType(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REFERENCETYPECODE_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 =
		"referenceTypeCode.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(referenceTypeCode.type IS NULL OR referenceTypeCode.type = '')";

	public ReferenceTypeCodePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");
		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ReferenceTypeCode.class);

		setModelImplClass(ReferenceTypeCodeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the reference type code in the entity cache if it is enabled.
	 *
	 * @param referenceTypeCode the reference type code
	 */
	@Override
	public void cacheResult(ReferenceTypeCode referenceTypeCode) {
		entityCache.putResult(
			entityCacheEnabled, ReferenceTypeCodeImpl.class,
			referenceTypeCode.getPrimaryKey(), referenceTypeCode);

		finderCache.putResult(
			_finderPathFetchByKey, new Object[] {referenceTypeCode.getKey()},
			referenceTypeCode);

		referenceTypeCode.resetOriginalValues();
	}

	/**
	 * Caches the reference type codes in the entity cache if it is enabled.
	 *
	 * @param referenceTypeCodes the reference type codes
	 */
	@Override
	public void cacheResult(List<ReferenceTypeCode> referenceTypeCodes) {
		for (ReferenceTypeCode referenceTypeCode : referenceTypeCodes) {
			if (entityCache.getResult(
					entityCacheEnabled, ReferenceTypeCodeImpl.class,
					referenceTypeCode.getPrimaryKey()) == null) {

				cacheResult(referenceTypeCode);
			}
			else {
				referenceTypeCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reference type codes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReferenceTypeCodeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the reference type code.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReferenceTypeCode referenceTypeCode) {
		entityCache.removeResult(
			entityCacheEnabled, ReferenceTypeCodeImpl.class,
			referenceTypeCode.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ReferenceTypeCodeModelImpl)referenceTypeCode, true);
	}

	@Override
	public void clearCache(List<ReferenceTypeCode> referenceTypeCodes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReferenceTypeCode referenceTypeCode : referenceTypeCodes) {
			entityCache.removeResult(
				entityCacheEnabled, ReferenceTypeCodeImpl.class,
				referenceTypeCode.getPrimaryKey());

			clearUniqueFindersCache(
				(ReferenceTypeCodeModelImpl)referenceTypeCode, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ReferenceTypeCodeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ReferenceTypeCodeModelImpl referenceTypeCodeModelImpl) {

		Object[] args = new Object[] {referenceTypeCodeModelImpl.getKey()};

		finderCache.putResult(
			_finderPathCountByKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByKey, args, referenceTypeCodeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ReferenceTypeCodeModelImpl referenceTypeCodeModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {referenceTypeCodeModelImpl.getKey()};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}

		if ((referenceTypeCodeModelImpl.getColumnBitmask() &
			 _finderPathFetchByKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				referenceTypeCodeModelImpl.getOriginalKey()
			};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}
	}

	/**
	 * Creates a new reference type code with the primary key. Does not add the reference type code to the database.
	 *
	 * @param referenceTypeCodeId the primary key for the new reference type code
	 * @return the new reference type code
	 */
	@Override
	public ReferenceTypeCode create(long referenceTypeCodeId) {
		ReferenceTypeCode referenceTypeCode = new ReferenceTypeCodeImpl();

		referenceTypeCode.setNew(true);
		referenceTypeCode.setPrimaryKey(referenceTypeCodeId);

		referenceTypeCode.setCompanyId(CompanyThreadLocal.getCompanyId());

		return referenceTypeCode;
	}

	/**
	 * Removes the reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code that was removed
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode remove(long referenceTypeCodeId)
		throws NoSuchReferenceTypeCodeException {

		return remove((Serializable)referenceTypeCodeId);
	}

	/**
	 * Removes the reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reference type code
	 * @return the reference type code that was removed
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode remove(Serializable primaryKey)
		throws NoSuchReferenceTypeCodeException {

		Session session = null;

		try {
			session = openSession();

			ReferenceTypeCode referenceTypeCode =
				(ReferenceTypeCode)session.get(
					ReferenceTypeCodeImpl.class, primaryKey);

			if (referenceTypeCode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReferenceTypeCodeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(referenceTypeCode);
		}
		catch (NoSuchReferenceTypeCodeException noSuchEntityException) {
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
	protected ReferenceTypeCode removeImpl(
		ReferenceTypeCode referenceTypeCode) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(referenceTypeCode)) {
				referenceTypeCode = (ReferenceTypeCode)session.get(
					ReferenceTypeCodeImpl.class,
					referenceTypeCode.getPrimaryKeyObj());
			}

			if (referenceTypeCode != null) {
				session.delete(referenceTypeCode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (referenceTypeCode != null) {
			clearCache(referenceTypeCode);
		}

		return referenceTypeCode;
	}

	@Override
	public ReferenceTypeCode updateImpl(ReferenceTypeCode referenceTypeCode) {
		boolean isNew = referenceTypeCode.isNew();

		if (!(referenceTypeCode instanceof ReferenceTypeCodeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(referenceTypeCode.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					referenceTypeCode);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in referenceTypeCode proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ReferenceTypeCode implementation " +
					referenceTypeCode.getClass());
		}

		ReferenceTypeCodeModelImpl referenceTypeCodeModelImpl =
			(ReferenceTypeCodeModelImpl)referenceTypeCode;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (referenceTypeCode.getCreateDate() == null)) {
			if (serviceContext == null) {
				referenceTypeCode.setCreateDate(now);
			}
			else {
				referenceTypeCode.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!referenceTypeCodeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				referenceTypeCode.setModifiedDate(now);
			}
			else {
				referenceTypeCode.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(referenceTypeCode);

				referenceTypeCode.setNew(false);
			}
			else {
				referenceTypeCode = (ReferenceTypeCode)session.merge(
					referenceTypeCode);
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
			Object[] args = new Object[] {referenceTypeCodeModelImpl.getType()};

			finderCache.removeResult(_finderPathCountByType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((referenceTypeCodeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByType.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					referenceTypeCodeModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);

				args = new Object[] {referenceTypeCodeModelImpl.getType()};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ReferenceTypeCodeImpl.class,
			referenceTypeCode.getPrimaryKey(), referenceTypeCode, false);

		clearUniqueFindersCache(referenceTypeCodeModelImpl, false);
		cacheUniqueFindersCache(referenceTypeCodeModelImpl);

		referenceTypeCode.resetOriginalValues();

		return referenceTypeCode;
	}

	/**
	 * Returns the reference type code with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reference type code
	 * @return the reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReferenceTypeCodeException {

		ReferenceTypeCode referenceTypeCode = fetchByPrimaryKey(primaryKey);

		if (referenceTypeCode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReferenceTypeCodeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return referenceTypeCode;
	}

	/**
	 * Returns the reference type code with the primary key or throws a <code>NoSuchReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode findByPrimaryKey(long referenceTypeCodeId)
		throws NoSuchReferenceTypeCodeException {

		return findByPrimaryKey((Serializable)referenceTypeCodeId);
	}

	/**
	 * Returns the reference type code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code, or <code>null</code> if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode fetchByPrimaryKey(long referenceTypeCodeId) {
		return fetchByPrimaryKey((Serializable)referenceTypeCodeId);
	}

	/**
	 * Returns all the reference type codes.
	 *
	 * @return the reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reference type codes
	 */
	@Override
	public List<ReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<ReferenceTypeCode> orderByComparator,
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

		List<ReferenceTypeCode> list = null;

		if (useFinderCache) {
			list = (List<ReferenceTypeCode>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REFERENCETYPECODE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REFERENCETYPECODE;

				sql = sql.concat(ReferenceTypeCodeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ReferenceTypeCode>)QueryUtil.list(
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
	 * Removes all the reference type codes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ReferenceTypeCode referenceTypeCode : findAll()) {
			remove(referenceTypeCode);
		}
	}

	/**
	 * Returns the number of reference type codes.
	 *
	 * @return the number of reference type codes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REFERENCETYPECODE);

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
		return "referenceTypeCodeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REFERENCETYPECODE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReferenceTypeCodeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the reference type code persistence.
	 */
	@Activate
	public void activate() {
		ReferenceTypeCodeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ReferenceTypeCodeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] {String.class.getName()},
			ReferenceTypeCodeModelImpl.KEY_COLUMN_BITMASK);

		_finderPathCountByKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRowProcessed",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRowProcessed",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {String.class.getName()},
			ReferenceTypeCodeModelImpl.TYPE_COLUMN_BITMASK |
			ReferenceTypeCodeModelImpl.DESCRIPTION_COLUMN_BITMASK);

		_finderPathCountByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ReferenceTypeCodeImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.ReferenceTypeCode"),
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

	private static final String _SQL_SELECT_REFERENCETYPECODE =
		"SELECT referenceTypeCode FROM ReferenceTypeCode referenceTypeCode";

	private static final String _SQL_SELECT_REFERENCETYPECODE_WHERE =
		"SELECT referenceTypeCode FROM ReferenceTypeCode referenceTypeCode WHERE ";

	private static final String _SQL_COUNT_REFERENCETYPECODE =
		"SELECT COUNT(referenceTypeCode) FROM ReferenceTypeCode referenceTypeCode";

	private static final String _SQL_COUNT_REFERENCETYPECODE_WHERE =
		"SELECT COUNT(referenceTypeCode) FROM ReferenceTypeCode referenceTypeCode WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "referenceTypeCode.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ReferenceTypeCode exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ReferenceTypeCode exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReferenceTypeCodePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type", "key"});

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}