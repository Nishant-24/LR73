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

import com.argus.oth.cases.management.exception.NoSuchClaimDetailException;
import com.argus.oth.cases.management.model.ClaimDetail;
import com.argus.oth.cases.management.model.impl.ClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.ClaimDetailModelImpl;
import com.argus.oth.cases.management.service.persistence.ClaimDetailPersistence;
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
 * The persistence implementation for the claim detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimDetailPersistence.class)
public class ClaimDetailPersistenceImpl
	extends BasePersistenceImpl<ClaimDetail> implements ClaimDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimDetailUtil</code> to access the claim detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLineId;
	private FinderPath _finderPathCountByLineId;

	/**
	 * Returns the claim detail where lineId = &#63; or throws a <code>NoSuchClaimDetailException</code> if it could not be found.
	 *
	 * @param lineId the line ID
	 * @return the matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail findByLineId(long lineId)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = fetchByLineId(lineId);

		if (claimDetail == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("lineId=");
			sb.append(lineId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClaimDetailException(sb.toString());
		}

		return claimDetail;
	}

	/**
	 * Returns the claim detail where lineId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lineId the line ID
	 * @return the matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail fetchByLineId(long lineId) {
		return fetchByLineId(lineId, true);
	}

	/**
	 * Returns the claim detail where lineId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lineId the line ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail fetchByLineId(long lineId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {lineId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLineId, finderArgs, this);
		}

		if (result instanceof ClaimDetail) {
			ClaimDetail claimDetail = (ClaimDetail)result;

			if (lineId != claimDetail.getLineId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLAIMDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_LINEID_LINEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lineId);

				List<ClaimDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLineId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {lineId};
							}

							_log.warn(
								"ClaimDetailPersistenceImpl.fetchByLineId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ClaimDetail claimDetail = list.get(0);

					result = claimDetail;

					cacheResult(claimDetail);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByLineId, finderArgs);
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
			return (ClaimDetail)result;
		}
	}

	/**
	 * Removes the claim detail where lineId = &#63; from the database.
	 *
	 * @param lineId the line ID
	 * @return the claim detail that was removed
	 */
	@Override
	public ClaimDetail removeByLineId(long lineId)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = findByLineId(lineId);

		return remove(claimDetail);
	}

	/**
	 * Returns the number of claim details where lineId = &#63;.
	 *
	 * @param lineId the line ID
	 * @return the number of matching claim details
	 */
	@Override
	public int countByLineId(long lineId) {
		FinderPath finderPath = _finderPathCountByLineId;

		Object[] finderArgs = new Object[] {lineId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_LINEID_LINEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lineId);

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

	private static final String _FINDER_COLUMN_LINEID_LINEID_2 =
		"claimDetail.lineId = ?";

	private FinderPath _finderPathWithPaginationFindByExternalClaimId;
	private FinderPath _finderPathWithoutPaginationFindByExternalClaimId;
	private FinderPath _finderPathCountByExternalClaimId;

	/**
	 * Returns all the claim details where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @return the matching claim details
	 */
	@Override
	public List<ClaimDetail> findByExternalClaimId(long externalClaimId) {
		return findByExternalClaimId(
			externalClaimId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim details where externalClaimId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param externalClaimId the external claim ID
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of matching claim details
	 */
	@Override
	public List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end) {

		return findByExternalClaimId(externalClaimId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim details where externalClaimId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param externalClaimId the external claim ID
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim details
	 */
	@Override
	public List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return findByExternalClaimId(
			externalClaimId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim details where externalClaimId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param externalClaimId the external claim ID
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim details
	 */
	@Override
	public List<ClaimDetail> findByExternalClaimId(
		long externalClaimId, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByExternalClaimId;
				finderArgs = new Object[] {externalClaimId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExternalClaimId;
			finderArgs = new Object[] {
				externalClaimId, start, end, orderByComparator
			};
		}

		List<ClaimDetail> list = null;

		if (useFinderCache) {
			list = (List<ClaimDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimDetail claimDetail : list) {
					if (externalClaimId != claimDetail.getExternalClaimId()) {
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

			sb.append(_SQL_SELECT_CLAIMDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLAIMID_EXTERNALCLAIMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClaimId);

				list = (List<ClaimDetail>)QueryUtil.list(
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
	 * Returns the first claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail findByExternalClaimId_First(
			long externalClaimId,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = fetchByExternalClaimId_First(
			externalClaimId, orderByComparator);

		if (claimDetail != null) {
			return claimDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalClaimId=");
		sb.append(externalClaimId);

		sb.append("}");

		throw new NoSuchClaimDetailException(sb.toString());
	}

	/**
	 * Returns the first claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail fetchByExternalClaimId_First(
		long externalClaimId,
		OrderByComparator<ClaimDetail> orderByComparator) {

		List<ClaimDetail> list = findByExternalClaimId(
			externalClaimId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail findByExternalClaimId_Last(
			long externalClaimId,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = fetchByExternalClaimId_Last(
			externalClaimId, orderByComparator);

		if (claimDetail != null) {
			return claimDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalClaimId=");
		sb.append(externalClaimId);

		sb.append("}");

		throw new NoSuchClaimDetailException(sb.toString());
	}

	/**
	 * Returns the last claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail fetchByExternalClaimId_Last(
		long externalClaimId,
		OrderByComparator<ClaimDetail> orderByComparator) {

		int count = countByExternalClaimId(externalClaimId);

		if (count == 0) {
			return null;
		}

		List<ClaimDetail> list = findByExternalClaimId(
			externalClaimId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim details before and after the current claim detail in the ordered set where externalClaimId = &#63;.
	 *
	 * @param claimDetailId the primary key of the current claim detail
	 * @param externalClaimId the external claim ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail[] findByExternalClaimId_PrevAndNext(
			long claimDetailId, long externalClaimId,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = findByPrimaryKey(claimDetailId);

		Session session = null;

		try {
			session = openSession();

			ClaimDetail[] array = new ClaimDetailImpl[3];

			array[0] = getByExternalClaimId_PrevAndNext(
				session, claimDetail, externalClaimId, orderByComparator, true);

			array[1] = claimDetail;

			array[2] = getByExternalClaimId_PrevAndNext(
				session, claimDetail, externalClaimId, orderByComparator,
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

	protected ClaimDetail getByExternalClaimId_PrevAndNext(
		Session session, ClaimDetail claimDetail, long externalClaimId,
		OrderByComparator<ClaimDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIMDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_EXTERNALCLAIMID_EXTERNALCLAIMID_2);

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
			sb.append(ClaimDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(externalClaimId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(claimDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim details where externalClaimId = &#63; from the database.
	 *
	 * @param externalClaimId the external claim ID
	 */
	@Override
	public void removeByExternalClaimId(long externalClaimId) {
		for (ClaimDetail claimDetail :
				findByExternalClaimId(
					externalClaimId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(claimDetail);
		}
	}

	/**
	 * Returns the number of claim details where externalClaimId = &#63;.
	 *
	 * @param externalClaimId the external claim ID
	 * @return the number of matching claim details
	 */
	@Override
	public int countByExternalClaimId(long externalClaimId) {
		FinderPath finderPath = _finderPathCountByExternalClaimId;

		Object[] finderArgs = new Object[] {externalClaimId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLAIMID_EXTERNALCLAIMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClaimId);

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
		_FINDER_COLUMN_EXTERNALCLAIMID_EXTERNALCLAIMID_2 =
			"claimDetail.externalClaimId = ?";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the claim details where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching claim details
	 */
	@Override
	public List<ClaimDetail> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim details where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of matching claim details
	 */
	@Override
	public List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim details where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim details
	 */
	@Override
	public List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim details where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim details
	 */
	@Override
	public List<ClaimDetail> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<ClaimDetail> orderByComparator,
		boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<ClaimDetail> list = null;

		if (useFinderCache) {
			list = (List<ClaimDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimDetail claimDetail : list) {
					if (rowProcessed.equals(claimDetail.getRowProcessed())) {
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

			sb.append(_SQL_SELECT_CLAIMDETAIL_WHERE);

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
				sb.append(ClaimDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<ClaimDetail>)QueryUtil.list(
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
	 * Returns the first claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail findByRowProcessed_First(
			String rowProcessed,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (claimDetail != null) {
			return claimDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClaimDetailException(sb.toString());
	}

	/**
	 * Returns the first claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<ClaimDetail> orderByComparator) {

		List<ClaimDetail> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail
	 * @throws NoSuchClaimDetailException if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail findByRowProcessed_Last(
			String rowProcessed,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (claimDetail != null) {
			return claimDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClaimDetailException(sb.toString());
	}

	/**
	 * Returns the last claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim detail, or <code>null</code> if a matching claim detail could not be found
	 */
	@Override
	public ClaimDetail fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<ClaimDetail> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<ClaimDetail> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim details before and after the current claim detail in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param claimDetailId the primary key of the current claim detail
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail[] findByRowProcessed_PrevAndNext(
			long claimDetailId, String rowProcessed,
			OrderByComparator<ClaimDetail> orderByComparator)
		throws NoSuchClaimDetailException {

		rowProcessed = Objects.toString(rowProcessed, "");

		ClaimDetail claimDetail = findByPrimaryKey(claimDetailId);

		Session session = null;

		try {
			session = openSession();

			ClaimDetail[] array = new ClaimDetailImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, claimDetail, rowProcessed, orderByComparator, true);

			array[1] = claimDetail;

			array[2] = getByRowProcessed_PrevAndNext(
				session, claimDetail, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClaimDetail getByRowProcessed_PrevAndNext(
		Session session, ClaimDetail claimDetail, String rowProcessed,
		OrderByComparator<ClaimDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIMDETAIL_WHERE);

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
			sb.append(ClaimDetailModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(claimDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim details where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (ClaimDetail claimDetail :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(claimDetail);
		}
	}

	/**
	 * Returns the number of claim details where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching claim details
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMDETAIL_WHERE);

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
		"claimDetail.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(claimDetail.rowProcessed IS NULL OR claimDetail.rowProcessed != '')";

	public ClaimDetailPersistenceImpl() {
		setModelClass(ClaimDetail.class);

		setModelImplClass(ClaimDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the claim detail in the entity cache if it is enabled.
	 *
	 * @param claimDetail the claim detail
	 */
	@Override
	public void cacheResult(ClaimDetail claimDetail) {
		entityCache.putResult(
			entityCacheEnabled, ClaimDetailImpl.class,
			claimDetail.getPrimaryKey(), claimDetail);

		finderCache.putResult(
			_finderPathFetchByLineId, new Object[] {claimDetail.getLineId()},
			claimDetail);

		claimDetail.resetOriginalValues();
	}

	/**
	 * Caches the claim details in the entity cache if it is enabled.
	 *
	 * @param claimDetails the claim details
	 */
	@Override
	public void cacheResult(List<ClaimDetail> claimDetails) {
		for (ClaimDetail claimDetail : claimDetails) {
			if (entityCache.getResult(
					entityCacheEnabled, ClaimDetailImpl.class,
					claimDetail.getPrimaryKey()) == null) {

				cacheResult(claimDetail);
			}
			else {
				claimDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all claim details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClaimDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimDetail claimDetail) {
		entityCache.removeResult(
			entityCacheEnabled, ClaimDetailImpl.class,
			claimDetail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ClaimDetailModelImpl)claimDetail, true);
	}

	@Override
	public void clearCache(List<ClaimDetail> claimDetails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClaimDetail claimDetail : claimDetails) {
			entityCache.removeResult(
				entityCacheEnabled, ClaimDetailImpl.class,
				claimDetail.getPrimaryKey());

			clearUniqueFindersCache((ClaimDetailModelImpl)claimDetail, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ClaimDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ClaimDetailModelImpl claimDetailModelImpl) {

		Object[] args = new Object[] {claimDetailModelImpl.getLineId()};

		finderCache.putResult(
			_finderPathCountByLineId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLineId, args, claimDetailModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ClaimDetailModelImpl claimDetailModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {claimDetailModelImpl.getLineId()};

			finderCache.removeResult(_finderPathCountByLineId, args);
			finderCache.removeResult(_finderPathFetchByLineId, args);
		}

		if ((claimDetailModelImpl.getColumnBitmask() &
			 _finderPathFetchByLineId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				claimDetailModelImpl.getOriginalLineId()
			};

			finderCache.removeResult(_finderPathCountByLineId, args);
			finderCache.removeResult(_finderPathFetchByLineId, args);
		}
	}

	/**
	 * Creates a new claim detail with the primary key. Does not add the claim detail to the database.
	 *
	 * @param claimDetailId the primary key for the new claim detail
	 * @return the new claim detail
	 */
	@Override
	public ClaimDetail create(long claimDetailId) {
		ClaimDetail claimDetail = new ClaimDetailImpl();

		claimDetail.setNew(true);
		claimDetail.setPrimaryKey(claimDetailId);

		claimDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return claimDetail;
	}

	/**
	 * Removes the claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail that was removed
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail remove(long claimDetailId)
		throws NoSuchClaimDetailException {

		return remove((Serializable)claimDetailId);
	}

	/**
	 * Removes the claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim detail
	 * @return the claim detail that was removed
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail remove(Serializable primaryKey)
		throws NoSuchClaimDetailException {

		Session session = null;

		try {
			session = openSession();

			ClaimDetail claimDetail = (ClaimDetail)session.get(
				ClaimDetailImpl.class, primaryKey);

			if (claimDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimDetail);
		}
		catch (NoSuchClaimDetailException noSuchEntityException) {
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
	protected ClaimDetail removeImpl(ClaimDetail claimDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimDetail)) {
				claimDetail = (ClaimDetail)session.get(
					ClaimDetailImpl.class, claimDetail.getPrimaryKeyObj());
			}

			if (claimDetail != null) {
				session.delete(claimDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimDetail != null) {
			clearCache(claimDetail);
		}

		return claimDetail;
	}

	@Override
	public ClaimDetail updateImpl(ClaimDetail claimDetail) {
		boolean isNew = claimDetail.isNew();

		if (!(claimDetail instanceof ClaimDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(claimDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(claimDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in claimDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClaimDetail implementation " +
					claimDetail.getClass());
		}

		ClaimDetailModelImpl claimDetailModelImpl =
			(ClaimDetailModelImpl)claimDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (claimDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				claimDetail.setCreateDate(now);
			}
			else {
				claimDetail.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!claimDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				claimDetail.setModifiedDate(now);
			}
			else {
				claimDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claimDetail);

				claimDetail.setNew(false);
			}
			else {
				claimDetail = (ClaimDetail)session.merge(claimDetail);
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
				claimDetailModelImpl.getExternalClaimId()
			};

			finderCache.removeResult(_finderPathCountByExternalClaimId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByExternalClaimId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((claimDetailModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByExternalClaimId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					claimDetailModelImpl.getOriginalExternalClaimId()
				};

				finderCache.removeResult(
					_finderPathCountByExternalClaimId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExternalClaimId, args);

				args = new Object[] {claimDetailModelImpl.getExternalClaimId()};

				finderCache.removeResult(
					_finderPathCountByExternalClaimId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExternalClaimId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ClaimDetailImpl.class,
			claimDetail.getPrimaryKey(), claimDetail, false);

		clearUniqueFindersCache(claimDetailModelImpl, false);
		cacheUniqueFindersCache(claimDetailModelImpl);

		claimDetail.resetOriginalValues();

		return claimDetail;
	}

	/**
	 * Returns the claim detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim detail
	 * @return the claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimDetailException {

		ClaimDetail claimDetail = fetchByPrimaryKey(primaryKey);

		if (claimDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimDetail;
	}

	/**
	 * Returns the claim detail with the primary key or throws a <code>NoSuchClaimDetailException</code> if it could not be found.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail
	 * @throws NoSuchClaimDetailException if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail findByPrimaryKey(long claimDetailId)
		throws NoSuchClaimDetailException {

		return findByPrimaryKey((Serializable)claimDetailId);
	}

	/**
	 * Returns the claim detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail, or <code>null</code> if a claim detail with the primary key could not be found
	 */
	@Override
	public ClaimDetail fetchByPrimaryKey(long claimDetailId) {
		return fetchByPrimaryKey((Serializable)claimDetailId);
	}

	/**
	 * Returns all the claim details.
	 *
	 * @return the claim details
	 */
	@Override
	public List<ClaimDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of claim details
	 */
	@Override
	public List<ClaimDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim details
	 */
	@Override
	public List<ClaimDetail> findAll(
		int start, int end, OrderByComparator<ClaimDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim details
	 */
	@Override
	public List<ClaimDetail> findAll(
		int start, int end, OrderByComparator<ClaimDetail> orderByComparator,
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

		List<ClaimDetail> list = null;

		if (useFinderCache) {
			list = (List<ClaimDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMDETAIL;

				sql = sql.concat(ClaimDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimDetail>)QueryUtil.list(
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
	 * Removes all the claim details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimDetail claimDetail : findAll()) {
			remove(claimDetail);
		}
	}

	/**
	 * Returns the number of claim details.
	 *
	 * @return the number of claim details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIMDETAIL);

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
		return "claimDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim detail persistence.
	 */
	@Activate
	public void activate() {
		ClaimDetailModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClaimDetailModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByLineId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimDetailImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLineId",
			new String[] {Long.class.getName()},
			ClaimDetailModelImpl.LINEID_COLUMN_BITMASK);

		_finderPathCountByLineId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLineId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByExternalClaimId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExternalClaimId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByExternalClaimId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExternalClaimId",
			new String[] {Long.class.getName()},
			ClaimDetailModelImpl.EXTERNALCLAIMID_COLUMN_BITMASK |
			ClaimDetailModelImpl.LINEID_COLUMN_BITMASK);

		_finderPathCountByExternalClaimId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExternalClaimId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimDetailImpl.class,
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
		entityCache.removeCache(ClaimDetailImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.ClaimDetail"),
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

	private static final String _SQL_SELECT_CLAIMDETAIL =
		"SELECT claimDetail FROM ClaimDetail claimDetail";

	private static final String _SQL_SELECT_CLAIMDETAIL_WHERE =
		"SELECT claimDetail FROM ClaimDetail claimDetail WHERE ";

	private static final String _SQL_COUNT_CLAIMDETAIL =
		"SELECT COUNT(claimDetail) FROM ClaimDetail claimDetail";

	private static final String _SQL_COUNT_CLAIMDETAIL_WHERE =
		"SELECT COUNT(claimDetail) FROM ClaimDetail claimDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClaimDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimDetailPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}