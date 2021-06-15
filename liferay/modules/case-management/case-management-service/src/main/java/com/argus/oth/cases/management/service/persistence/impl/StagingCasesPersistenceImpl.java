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

import com.argus.oth.cases.management.exception.NoSuchStagingCasesException;
import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.model.impl.StagingCasesImpl;
import com.argus.oth.cases.management.model.impl.StagingCasesModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingCasesPersistence;
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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the staging cases service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingCasesPersistence.class)
public class StagingCasesPersistenceImpl
	extends BasePersistenceImpl<StagingCases>
	implements StagingCasesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingCasesUtil</code> to access the staging cases persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingCasesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByExternalCaseId;
	private FinderPath _finderPathCountByExternalCaseId;

	/**
	 * Returns the staging cases where externalCaseId = &#63; or throws a <code>NoSuchStagingCasesException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	@Override
	public StagingCases findByExternalCaseId(String externalCaseId)
		throws NoSuchStagingCasesException {

		StagingCases stagingCases = fetchByExternalCaseId(externalCaseId);

		if (stagingCases == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalCaseId=");
			sb.append(externalCaseId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStagingCasesException(sb.toString());
		}

		return stagingCases;
	}

	/**
	 * Returns the staging cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	@Override
	public StagingCases fetchByExternalCaseId(String externalCaseId) {
		return fetchByExternalCaseId(externalCaseId, true);
	}

	/**
	 * Returns the staging cases where externalCaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	@Override
	public StagingCases fetchByExternalCaseId(
		String externalCaseId, boolean useFinderCache) {

		externalCaseId = Objects.toString(externalCaseId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalCaseId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalCaseId, finderArgs, this);
		}

		if (result instanceof StagingCases) {
			StagingCases stagingCases = (StagingCases)result;

			if (!Objects.equals(
					externalCaseId, stagingCases.getExternalCaseId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STAGINGCASES_WHERE);

			boolean bindExternalCaseId = false;

			if (externalCaseId.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_3);
			}
			else {
				bindExternalCaseId = true;

				sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalCaseId) {
					queryPos.add(externalCaseId);
				}

				List<StagingCases> list = query.list();

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
								"StagingCasesPersistenceImpl.fetchByExternalCaseId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StagingCases stagingCases = list.get(0);

					result = stagingCases;

					cacheResult(stagingCases);
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
			return (StagingCases)result;
		}
	}

	/**
	 * Removes the staging cases where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @return the staging cases that was removed
	 */
	@Override
	public StagingCases removeByExternalCaseId(String externalCaseId)
		throws NoSuchStagingCasesException {

		StagingCases stagingCases = findByExternalCaseId(externalCaseId);

		return remove(stagingCases);
	}

	/**
	 * Returns the number of staging caseses where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching staging caseses
	 */
	@Override
	public int countByExternalCaseId(String externalCaseId) {
		externalCaseId = Objects.toString(externalCaseId, "");

		FinderPath finderPath = _finderPathCountByExternalCaseId;

		Object[] finderArgs = new Object[] {externalCaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGCASES_WHERE);

			boolean bindExternalCaseId = false;

			if (externalCaseId.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_3);
			}
			else {
				bindExternalCaseId = true;

				sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalCaseId) {
					queryPos.add(externalCaseId);
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

	private static final String _FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2 =
		"stagingCases.externalCaseId = ?";

	private static final String _FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_3 =
		"(stagingCases.externalCaseId IS NULL OR stagingCases.externalCaseId = '')";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithoutPaginationFindByRowProcessed;
	private FinderPath _finderPathCountByRowProcessed;

	/**
	 * Returns all the staging caseses where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching staging caseses
	 */
	@Override
	public List<StagingCases> findByRowProcessed(boolean rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of matching staging caseses
	 */
	@Override
	public List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging caseses
	 */
	@Override
	public List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingCases> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging caseses where rowProcessed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging caseses
	 */
	@Override
	public List<StagingCases> findByRowProcessed(
		boolean rowProcessed, int start, int end,
		OrderByComparator<StagingCases> orderByComparator,
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

		List<StagingCases> list = null;

		if (useFinderCache) {
			list = (List<StagingCases>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StagingCases stagingCases : list) {
					if (rowProcessed != stagingCases.isRowProcessed()) {
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

			sb.append(_SQL_SELECT_STAGINGCASES_WHERE);

			sb.append(_FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StagingCasesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rowProcessed);

				list = (List<StagingCases>)QueryUtil.list(
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
	 * Returns the first staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	@Override
	public StagingCases findByRowProcessed_First(
			boolean rowProcessed,
			OrderByComparator<StagingCases> orderByComparator)
		throws NoSuchStagingCasesException {

		StagingCases stagingCases = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (stagingCases != null) {
			return stagingCases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchStagingCasesException(sb.toString());
	}

	/**
	 * Returns the first staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	@Override
	public StagingCases fetchByRowProcessed_First(
		boolean rowProcessed,
		OrderByComparator<StagingCases> orderByComparator) {

		List<StagingCases> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging cases
	 * @throws NoSuchStagingCasesException if a matching staging cases could not be found
	 */
	@Override
	public StagingCases findByRowProcessed_Last(
			boolean rowProcessed,
			OrderByComparator<StagingCases> orderByComparator)
		throws NoSuchStagingCasesException {

		StagingCases stagingCases = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (stagingCases != null) {
			return stagingCases;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchStagingCasesException(sb.toString());
	}

	/**
	 * Returns the last staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging cases, or <code>null</code> if a matching staging cases could not be found
	 */
	@Override
	public StagingCases fetchByRowProcessed_Last(
		boolean rowProcessed,
		OrderByComparator<StagingCases> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<StagingCases> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staging caseses before and after the current staging cases in the ordered set where rowProcessed = &#63;.
	 *
	 * @param stagingCaseId the primary key of the current staging cases
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	@Override
	public StagingCases[] findByRowProcessed_PrevAndNext(
			long stagingCaseId, boolean rowProcessed,
			OrderByComparator<StagingCases> orderByComparator)
		throws NoSuchStagingCasesException {

		StagingCases stagingCases = findByPrimaryKey(stagingCaseId);

		Session session = null;

		try {
			session = openSession();

			StagingCases[] array = new StagingCasesImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, stagingCases, rowProcessed, orderByComparator, true);

			array[1] = stagingCases;

			array[2] = getByRowProcessed_PrevAndNext(
				session, stagingCases, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StagingCases getByRowProcessed_PrevAndNext(
		Session session, StagingCases stagingCases, boolean rowProcessed,
		OrderByComparator<StagingCases> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAGINGCASES_WHERE);

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
			sb.append(StagingCasesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rowProcessed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stagingCases)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StagingCases> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staging caseses where rowProcessed = &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(boolean rowProcessed) {
		for (StagingCases stagingCases :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stagingCases);
		}
	}

	/**
	 * Returns the number of staging caseses where rowProcessed = &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching staging caseses
	 */
	@Override
	public int countByRowProcessed(boolean rowProcessed) {
		FinderPath finderPath = _finderPathCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGCASES_WHERE);

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
		"stagingCases.rowProcessed = ?";

	public StagingCasesPersistenceImpl() {
		setModelClass(StagingCases.class);

		setModelImplClass(StagingCasesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging cases in the entity cache if it is enabled.
	 *
	 * @param stagingCases the staging cases
	 */
	@Override
	public void cacheResult(StagingCases stagingCases) {
		entityCache.putResult(
			entityCacheEnabled, StagingCasesImpl.class,
			stagingCases.getPrimaryKey(), stagingCases);

		finderCache.putResult(
			_finderPathFetchByExternalCaseId,
			new Object[] {stagingCases.getExternalCaseId()}, stagingCases);

		stagingCases.resetOriginalValues();
	}

	/**
	 * Caches the staging caseses in the entity cache if it is enabled.
	 *
	 * @param stagingCaseses the staging caseses
	 */
	@Override
	public void cacheResult(List<StagingCases> stagingCaseses) {
		for (StagingCases stagingCases : stagingCaseses) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingCasesImpl.class,
					stagingCases.getPrimaryKey()) == null) {

				cacheResult(stagingCases);
			}
			else {
				stagingCases.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging caseses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingCasesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging cases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingCases stagingCases) {
		entityCache.removeResult(
			entityCacheEnabled, StagingCasesImpl.class,
			stagingCases.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StagingCasesModelImpl)stagingCases, true);
	}

	@Override
	public void clearCache(List<StagingCases> stagingCaseses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingCases stagingCases : stagingCaseses) {
			entityCache.removeResult(
				entityCacheEnabled, StagingCasesImpl.class,
				stagingCases.getPrimaryKey());

			clearUniqueFindersCache((StagingCasesModelImpl)stagingCases, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingCasesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StagingCasesModelImpl stagingCasesModelImpl) {

		Object[] args = new Object[] {
			stagingCasesModelImpl.getExternalCaseId()
		};

		finderCache.putResult(
			_finderPathCountByExternalCaseId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalCaseId, args, stagingCasesModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		StagingCasesModelImpl stagingCasesModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				stagingCasesModelImpl.getExternalCaseId()
			};

			finderCache.removeResult(_finderPathCountByExternalCaseId, args);
			finderCache.removeResult(_finderPathFetchByExternalCaseId, args);
		}

		if ((stagingCasesModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalCaseId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				stagingCasesModelImpl.getOriginalExternalCaseId()
			};

			finderCache.removeResult(_finderPathCountByExternalCaseId, args);
			finderCache.removeResult(_finderPathFetchByExternalCaseId, args);
		}
	}

	/**
	 * Creates a new staging cases with the primary key. Does not add the staging cases to the database.
	 *
	 * @param stagingCaseId the primary key for the new staging cases
	 * @return the new staging cases
	 */
	@Override
	public StagingCases create(long stagingCaseId) {
		StagingCases stagingCases = new StagingCasesImpl();

		stagingCases.setNew(true);
		stagingCases.setPrimaryKey(stagingCaseId);

		return stagingCases;
	}

	/**
	 * Removes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	@Override
	public StagingCases remove(long stagingCaseId)
		throws NoSuchStagingCasesException {

		return remove((Serializable)stagingCaseId);
	}

	/**
	 * Removes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	@Override
	public StagingCases remove(Serializable primaryKey)
		throws NoSuchStagingCasesException {

		Session session = null;

		try {
			session = openSession();

			StagingCases stagingCases = (StagingCases)session.get(
				StagingCasesImpl.class, primaryKey);

			if (stagingCases == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingCasesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingCases);
		}
		catch (NoSuchStagingCasesException noSuchEntityException) {
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
	protected StagingCases removeImpl(StagingCases stagingCases) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingCases)) {
				stagingCases = (StagingCases)session.get(
					StagingCasesImpl.class, stagingCases.getPrimaryKeyObj());
			}

			if (stagingCases != null) {
				session.delete(stagingCases);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingCases != null) {
			clearCache(stagingCases);
		}

		return stagingCases;
	}

	@Override
	public StagingCases updateImpl(StagingCases stagingCases) {
		boolean isNew = stagingCases.isNew();

		if (!(stagingCases instanceof StagingCasesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingCases.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingCases);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingCases proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingCases implementation " +
					stagingCases.getClass());
		}

		StagingCasesModelImpl stagingCasesModelImpl =
			(StagingCasesModelImpl)stagingCases;

		Session session = null;

		try {
			session = openSession();

			if (stagingCases.isNew()) {
				session.save(stagingCases);

				stagingCases.setNew(false);
			}
			else {
				stagingCases = (StagingCases)session.merge(stagingCases);
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
				stagingCasesModelImpl.isRowProcessed()
			};

			finderCache.removeResult(_finderPathCountByRowProcessed, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRowProcessed, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stagingCasesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRowProcessed.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stagingCasesModelImpl.getOriginalRowProcessed()
				};

				finderCache.removeResult(_finderPathCountByRowProcessed, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRowProcessed, args);

				args = new Object[] {stagingCasesModelImpl.isRowProcessed()};

				finderCache.removeResult(_finderPathCountByRowProcessed, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRowProcessed, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StagingCasesImpl.class,
			stagingCases.getPrimaryKey(), stagingCases, false);

		clearUniqueFindersCache(stagingCasesModelImpl, false);
		cacheUniqueFindersCache(stagingCasesModelImpl);

		stagingCases.resetOriginalValues();

		return stagingCases;
	}

	/**
	 * Returns the staging cases with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging cases
	 * @return the staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	@Override
	public StagingCases findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingCasesException {

		StagingCases stagingCases = fetchByPrimaryKey(primaryKey);

		if (stagingCases == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingCasesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingCases;
	}

	/**
	 * Returns the staging cases with the primary key or throws a <code>NoSuchStagingCasesException</code> if it could not be found.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases
	 * @throws NoSuchStagingCasesException if a staging cases with the primary key could not be found
	 */
	@Override
	public StagingCases findByPrimaryKey(long stagingCaseId)
		throws NoSuchStagingCasesException {

		return findByPrimaryKey((Serializable)stagingCaseId);
	}

	/**
	 * Returns the staging cases with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases, or <code>null</code> if a staging cases with the primary key could not be found
	 */
	@Override
	public StagingCases fetchByPrimaryKey(long stagingCaseId) {
		return fetchByPrimaryKey((Serializable)stagingCaseId);
	}

	/**
	 * Returns all the staging caseses.
	 *
	 * @return the staging caseses
	 */
	@Override
	public List<StagingCases> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of staging caseses
	 */
	@Override
	public List<StagingCases> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging caseses
	 */
	@Override
	public List<StagingCases> findAll(
		int start, int end, OrderByComparator<StagingCases> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging caseses
	 */
	@Override
	public List<StagingCases> findAll(
		int start, int end, OrderByComparator<StagingCases> orderByComparator,
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

		List<StagingCases> list = null;

		if (useFinderCache) {
			list = (List<StagingCases>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGCASES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGCASES;

				sql = sql.concat(StagingCasesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingCases>)QueryUtil.list(
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
	 * Removes all the staging caseses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingCases stagingCases : findAll()) {
			remove(stagingCases);
		}
	}

	/**
	 * Returns the number of staging caseses.
	 *
	 * @return the number of staging caseses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGINGCASES);

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
		return "stagingCaseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGCASES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingCasesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging cases persistence.
	 */
	@Activate
	public void activate() {
		StagingCasesModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingCasesModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingCasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingCasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingCasesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalCaseId",
			new String[] {String.class.getName()},
			StagingCasesModelImpl.EXTERNALCASEID_COLUMN_BITMASK);

		_finderPathCountByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExternalCaseId",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingCasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRowProcessed",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingCasesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRowProcessed",
			new String[] {Boolean.class.getName()},
			StagingCasesModelImpl.ROWPROCESSED_COLUMN_BITMASK |
			StagingCasesModelImpl.LASTUPDATED_COLUMN_BITMASK);

		_finderPathCountByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRowProcessed",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingCasesImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingCases"),
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

	private static final String _SQL_SELECT_STAGINGCASES =
		"SELECT stagingCases FROM StagingCases stagingCases";

	private static final String _SQL_SELECT_STAGINGCASES_WHERE =
		"SELECT stagingCases FROM StagingCases stagingCases WHERE ";

	private static final String _SQL_COUNT_STAGINGCASES =
		"SELECT COUNT(stagingCases) FROM StagingCases stagingCases";

	private static final String _SQL_COUNT_STAGINGCASES_WHERE =
		"SELECT COUNT(stagingCases) FROM StagingCases stagingCases WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingCases.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingCases exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StagingCases exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingCasesPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}