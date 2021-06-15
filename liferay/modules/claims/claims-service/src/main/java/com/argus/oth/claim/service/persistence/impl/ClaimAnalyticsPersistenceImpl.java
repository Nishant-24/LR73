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

package com.argus.oth.claim.service.persistence.impl;

import com.argus.oth.claim.exception.NoSuchClaimAnalyticsException;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.claim.model.impl.ClaimAnalyticsImpl;
import com.argus.oth.claim.model.impl.ClaimAnalyticsModelImpl;
import com.argus.oth.claim.service.persistence.ClaimAnalyticsPersistence;
import com.argus.oth.claim.service.persistence.impl.constants.OTH_ClaimPersistenceConstants;

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
 * The persistence implementation for the claim analytics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimAnalyticsPersistence.class)
public class ClaimAnalyticsPersistenceImpl
	extends BasePersistenceImpl<ClaimAnalytics>
	implements ClaimAnalyticsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimAnalyticsUtil</code> to access the claim analytics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimAnalyticsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByExternalClientId;
	private FinderPath _finderPathWithoutPaginationFindByExternalClientId;
	private FinderPath _finderPathCountByExternalClientId;

	/**
	 * Returns all the claim analyticses where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByExternalClientId(long externalClientId) {
		return findByExternalClientId(
			externalClientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim analyticses where externalClientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end) {

		return findByExternalClientId(externalClientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return findByExternalClientId(
			externalClientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByExternalClientId(
		long externalClientId, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByExternalClientId;
				finderArgs = new Object[] {externalClientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExternalClientId;
			finderArgs = new Object[] {
				externalClientId, start, end, orderByComparator
			};
		}

		List<ClaimAnalytics> list = null;

		if (useFinderCache) {
			list = (List<ClaimAnalytics>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimAnalytics claimAnalytics : list) {
					if (externalClientId !=
							claimAnalytics.getExternalClientId()) {

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

			sb.append(_SQL_SELECT_CLAIMANALYTICS_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCLIENTID_EXTERNALCLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimAnalyticsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientId);

				list = (List<ClaimAnalytics>)QueryUtil.list(
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
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics findByExternalClientId_First(
			long externalClientId,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws NoSuchClaimAnalyticsException {

		ClaimAnalytics claimAnalytics = fetchByExternalClientId_First(
			externalClientId, orderByComparator);

		if (claimAnalytics != null) {
			return claimAnalytics;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalClientId=");
		sb.append(externalClientId);

		sb.append("}");

		throw new NoSuchClaimAnalyticsException(sb.toString());
	}

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics fetchByExternalClientId_First(
		long externalClientId,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		List<ClaimAnalytics> list = findByExternalClientId(
			externalClientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics findByExternalClientId_Last(
			long externalClientId,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws NoSuchClaimAnalyticsException {

		ClaimAnalytics claimAnalytics = fetchByExternalClientId_Last(
			externalClientId, orderByComparator);

		if (claimAnalytics != null) {
			return claimAnalytics;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalClientId=");
		sb.append(externalClientId);

		sb.append("}");

		throw new NoSuchClaimAnalyticsException(sb.toString());
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics fetchByExternalClientId_Last(
		long externalClientId,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		int count = countByExternalClientId(externalClientId);

		if (count == 0) {
			return null;
		}

		List<ClaimAnalytics> list = findByExternalClientId(
			externalClientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim analyticses before and after the current claim analytics in the ordered set where externalClientId = &#63;.
	 *
	 * @param claimAnalyticsId the primary key of the current claim analytics
	 * @param externalClientId the external client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics[] findByExternalClientId_PrevAndNext(
			long claimAnalyticsId, long externalClientId,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws NoSuchClaimAnalyticsException {

		ClaimAnalytics claimAnalytics = findByPrimaryKey(claimAnalyticsId);

		Session session = null;

		try {
			session = openSession();

			ClaimAnalytics[] array = new ClaimAnalyticsImpl[3];

			array[0] = getByExternalClientId_PrevAndNext(
				session, claimAnalytics, externalClientId, orderByComparator,
				true);

			array[1] = claimAnalytics;

			array[2] = getByExternalClientId_PrevAndNext(
				session, claimAnalytics, externalClientId, orderByComparator,
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

	protected ClaimAnalytics getByExternalClientId_PrevAndNext(
		Session session, ClaimAnalytics claimAnalytics, long externalClientId,
		OrderByComparator<ClaimAnalytics> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIMANALYTICS_WHERE);

		sb.append(_FINDER_COLUMN_EXTERNALCLIENTID_EXTERNALCLIENTID_2);

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
			sb.append(ClaimAnalyticsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(externalClientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						claimAnalytics)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimAnalytics> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim analyticses where externalClientId = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 */
	@Override
	public void removeByExternalClientId(long externalClientId) {
		for (ClaimAnalytics claimAnalytics :
				findByExternalClientId(
					externalClientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(claimAnalytics);
		}
	}

	/**
	 * Returns the number of claim analyticses where externalClientId = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @return the number of matching claim analyticses
	 */
	@Override
	public int countByExternalClientId(long externalClientId) {
		FinderPath finderPath = _finderPathCountByExternalClientId;

		Object[] finderArgs = new Object[] {externalClientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMANALYTICS_WHERE);

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
			"claimAnalytics.externalClientId = ?";

	private FinderPath _finderPathWithPaginationFindByE_C;
	private FinderPath _finderPathWithoutPaginationFindByE_C;
	private FinderPath _finderPathCountByE_C;

	/**
	 * Returns all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @return the matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus) {

		return findByE_C(
			externalClientId, claimStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end) {

		return findByE_C(externalClientId, claimStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return findByE_C(
			externalClientId, claimStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findByE_C(
		long externalClientId, String claimStatus, int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator,
		boolean useFinderCache) {

		claimStatus = Objects.toString(claimStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByE_C;
				finderArgs = new Object[] {externalClientId, claimStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByE_C;
			finderArgs = new Object[] {
				externalClientId, claimStatus, start, end, orderByComparator
			};
		}

		List<ClaimAnalytics> list = null;

		if (useFinderCache) {
			list = (List<ClaimAnalytics>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimAnalytics claimAnalytics : list) {
					if ((externalClientId !=
							claimAnalytics.getExternalClientId()) ||
						!claimStatus.equals(claimAnalytics.getClaimStatus())) {

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

			sb.append(_SQL_SELECT_CLAIMANALYTICS_WHERE);

			sb.append(_FINDER_COLUMN_E_C_EXTERNALCLIENTID_2);

			boolean bindClaimStatus = false;

			if (claimStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_C_CLAIMSTATUS_3);
			}
			else {
				bindClaimStatus = true;

				sb.append(_FINDER_COLUMN_E_C_CLAIMSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimAnalyticsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientId);

				if (bindClaimStatus) {
					queryPos.add(claimStatus);
				}

				list = (List<ClaimAnalytics>)QueryUtil.list(
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
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics findByE_C_First(
			long externalClientId, String claimStatus,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws NoSuchClaimAnalyticsException {

		ClaimAnalytics claimAnalytics = fetchByE_C_First(
			externalClientId, claimStatus, orderByComparator);

		if (claimAnalytics != null) {
			return claimAnalytics;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalClientId=");
		sb.append(externalClientId);

		sb.append(", claimStatus=");
		sb.append(claimStatus);

		sb.append("}");

		throw new NoSuchClaimAnalyticsException(sb.toString());
	}

	/**
	 * Returns the first claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics fetchByE_C_First(
		long externalClientId, String claimStatus,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		List<ClaimAnalytics> list = findByE_C(
			externalClientId, claimStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics
	 * @throws NoSuchClaimAnalyticsException if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics findByE_C_Last(
			long externalClientId, String claimStatus,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws NoSuchClaimAnalyticsException {

		ClaimAnalytics claimAnalytics = fetchByE_C_Last(
			externalClientId, claimStatus, orderByComparator);

		if (claimAnalytics != null) {
			return claimAnalytics;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalClientId=");
		sb.append(externalClientId);

		sb.append(", claimStatus=");
		sb.append(claimStatus);

		sb.append("}");

		throw new NoSuchClaimAnalyticsException(sb.toString());
	}

	/**
	 * Returns the last claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim analytics, or <code>null</code> if a matching claim analytics could not be found
	 */
	@Override
	public ClaimAnalytics fetchByE_C_Last(
		long externalClientId, String claimStatus,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		int count = countByE_C(externalClientId, claimStatus);

		if (count == 0) {
			return null;
		}

		List<ClaimAnalytics> list = findByE_C(
			externalClientId, claimStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim analyticses before and after the current claim analytics in the ordered set where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param claimAnalyticsId the primary key of the current claim analytics
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics[] findByE_C_PrevAndNext(
			long claimAnalyticsId, long externalClientId, String claimStatus,
			OrderByComparator<ClaimAnalytics> orderByComparator)
		throws NoSuchClaimAnalyticsException {

		claimStatus = Objects.toString(claimStatus, "");

		ClaimAnalytics claimAnalytics = findByPrimaryKey(claimAnalyticsId);

		Session session = null;

		try {
			session = openSession();

			ClaimAnalytics[] array = new ClaimAnalyticsImpl[3];

			array[0] = getByE_C_PrevAndNext(
				session, claimAnalytics, externalClientId, claimStatus,
				orderByComparator, true);

			array[1] = claimAnalytics;

			array[2] = getByE_C_PrevAndNext(
				session, claimAnalytics, externalClientId, claimStatus,
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

	protected ClaimAnalytics getByE_C_PrevAndNext(
		Session session, ClaimAnalytics claimAnalytics, long externalClientId,
		String claimStatus, OrderByComparator<ClaimAnalytics> orderByComparator,
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

		sb.append(_SQL_SELECT_CLAIMANALYTICS_WHERE);

		sb.append(_FINDER_COLUMN_E_C_EXTERNALCLIENTID_2);

		boolean bindClaimStatus = false;

		if (claimStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_E_C_CLAIMSTATUS_3);
		}
		else {
			bindClaimStatus = true;

			sb.append(_FINDER_COLUMN_E_C_CLAIMSTATUS_2);
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
			sb.append(ClaimAnalyticsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(externalClientId);

		if (bindClaimStatus) {
			queryPos.add(claimStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						claimAnalytics)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimAnalytics> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim analyticses where externalClientId = &#63; and claimStatus = &#63; from the database.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 */
	@Override
	public void removeByE_C(long externalClientId, String claimStatus) {
		for (ClaimAnalytics claimAnalytics :
				findByE_C(
					externalClientId, claimStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(claimAnalytics);
		}
	}

	/**
	 * Returns the number of claim analyticses where externalClientId = &#63; and claimStatus = &#63;.
	 *
	 * @param externalClientId the external client ID
	 * @param claimStatus the claim status
	 * @return the number of matching claim analyticses
	 */
	@Override
	public int countByE_C(long externalClientId, String claimStatus) {
		claimStatus = Objects.toString(claimStatus, "");

		FinderPath finderPath = _finderPathCountByE_C;

		Object[] finderArgs = new Object[] {externalClientId, claimStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLAIMANALYTICS_WHERE);

			sb.append(_FINDER_COLUMN_E_C_EXTERNALCLIENTID_2);

			boolean bindClaimStatus = false;

			if (claimStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_C_CLAIMSTATUS_3);
			}
			else {
				bindClaimStatus = true;

				sb.append(_FINDER_COLUMN_E_C_CLAIMSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientId);

				if (bindClaimStatus) {
					queryPos.add(claimStatus);
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

	private static final String _FINDER_COLUMN_E_C_EXTERNALCLIENTID_2 =
		"claimAnalytics.externalClientId = ? AND ";

	private static final String _FINDER_COLUMN_E_C_CLAIMSTATUS_2 =
		"claimAnalytics.claimStatus = ?";

	private static final String _FINDER_COLUMN_E_C_CLAIMSTATUS_3 =
		"(claimAnalytics.claimStatus IS NULL OR claimAnalytics.claimStatus = '')";

	public ClaimAnalyticsPersistenceImpl() {
		setModelClass(ClaimAnalytics.class);

		setModelImplClass(ClaimAnalyticsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the claim analytics in the entity cache if it is enabled.
	 *
	 * @param claimAnalytics the claim analytics
	 */
	@Override
	public void cacheResult(ClaimAnalytics claimAnalytics) {
		entityCache.putResult(
			entityCacheEnabled, ClaimAnalyticsImpl.class,
			claimAnalytics.getPrimaryKey(), claimAnalytics);

		claimAnalytics.resetOriginalValues();
	}

	/**
	 * Caches the claim analyticses in the entity cache if it is enabled.
	 *
	 * @param claimAnalyticses the claim analyticses
	 */
	@Override
	public void cacheResult(List<ClaimAnalytics> claimAnalyticses) {
		for (ClaimAnalytics claimAnalytics : claimAnalyticses) {
			if (entityCache.getResult(
					entityCacheEnabled, ClaimAnalyticsImpl.class,
					claimAnalytics.getPrimaryKey()) == null) {

				cacheResult(claimAnalytics);
			}
			else {
				claimAnalytics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all claim analyticses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClaimAnalyticsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim analytics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimAnalytics claimAnalytics) {
		entityCache.removeResult(
			entityCacheEnabled, ClaimAnalyticsImpl.class,
			claimAnalytics.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ClaimAnalytics> claimAnalyticses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClaimAnalytics claimAnalytics : claimAnalyticses) {
			entityCache.removeResult(
				entityCacheEnabled, ClaimAnalyticsImpl.class,
				claimAnalytics.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ClaimAnalyticsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new claim analytics with the primary key. Does not add the claim analytics to the database.
	 *
	 * @param claimAnalyticsId the primary key for the new claim analytics
	 * @return the new claim analytics
	 */
	@Override
	public ClaimAnalytics create(long claimAnalyticsId) {
		ClaimAnalytics claimAnalytics = new ClaimAnalyticsImpl();

		claimAnalytics.setNew(true);
		claimAnalytics.setPrimaryKey(claimAnalyticsId);

		claimAnalytics.setCompanyId(CompanyThreadLocal.getCompanyId());

		return claimAnalytics;
	}

	/**
	 * Removes the claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics that was removed
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics remove(long claimAnalyticsId)
		throws NoSuchClaimAnalyticsException {

		return remove((Serializable)claimAnalyticsId);
	}

	/**
	 * Removes the claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim analytics
	 * @return the claim analytics that was removed
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics remove(Serializable primaryKey)
		throws NoSuchClaimAnalyticsException {

		Session session = null;

		try {
			session = openSession();

			ClaimAnalytics claimAnalytics = (ClaimAnalytics)session.get(
				ClaimAnalyticsImpl.class, primaryKey);

			if (claimAnalytics == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimAnalyticsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimAnalytics);
		}
		catch (NoSuchClaimAnalyticsException noSuchEntityException) {
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
	protected ClaimAnalytics removeImpl(ClaimAnalytics claimAnalytics) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimAnalytics)) {
				claimAnalytics = (ClaimAnalytics)session.get(
					ClaimAnalyticsImpl.class,
					claimAnalytics.getPrimaryKeyObj());
			}

			if (claimAnalytics != null) {
				session.delete(claimAnalytics);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimAnalytics != null) {
			clearCache(claimAnalytics);
		}

		return claimAnalytics;
	}

	@Override
	public ClaimAnalytics updateImpl(ClaimAnalytics claimAnalytics) {
		boolean isNew = claimAnalytics.isNew();

		if (!(claimAnalytics instanceof ClaimAnalyticsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(claimAnalytics.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					claimAnalytics);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in claimAnalytics proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClaimAnalytics implementation " +
					claimAnalytics.getClass());
		}

		ClaimAnalyticsModelImpl claimAnalyticsModelImpl =
			(ClaimAnalyticsModelImpl)claimAnalytics;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (claimAnalytics.getCreateDate() == null)) {
			if (serviceContext == null) {
				claimAnalytics.setCreateDate(now);
			}
			else {
				claimAnalytics.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!claimAnalyticsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				claimAnalytics.setModifiedDate(now);
			}
			else {
				claimAnalytics.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (claimAnalytics.isNew()) {
				session.save(claimAnalytics);

				claimAnalytics.setNew(false);
			}
			else {
				claimAnalytics = (ClaimAnalytics)session.merge(claimAnalytics);
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
				claimAnalyticsModelImpl.getExternalClientId()
			};

			finderCache.removeResult(_finderPathCountByExternalClientId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByExternalClientId, args);

			args = new Object[] {
				claimAnalyticsModelImpl.getExternalClientId(),
				claimAnalyticsModelImpl.getClaimStatus()
			};

			finderCache.removeResult(_finderPathCountByE_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByE_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((claimAnalyticsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByExternalClientId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					claimAnalyticsModelImpl.getOriginalExternalClientId()
				};

				finderCache.removeResult(
					_finderPathCountByExternalClientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExternalClientId, args);

				args = new Object[] {
					claimAnalyticsModelImpl.getExternalClientId()
				};

				finderCache.removeResult(
					_finderPathCountByExternalClientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExternalClientId, args);
			}

			if ((claimAnalyticsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByE_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					claimAnalyticsModelImpl.getOriginalExternalClientId(),
					claimAnalyticsModelImpl.getOriginalClaimStatus()
				};

				finderCache.removeResult(_finderPathCountByE_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByE_C, args);

				args = new Object[] {
					claimAnalyticsModelImpl.getExternalClientId(),
					claimAnalyticsModelImpl.getClaimStatus()
				};

				finderCache.removeResult(_finderPathCountByE_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByE_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ClaimAnalyticsImpl.class,
			claimAnalytics.getPrimaryKey(), claimAnalytics, false);

		claimAnalytics.resetOriginalValues();

		return claimAnalytics;
	}

	/**
	 * Returns the claim analytics with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim analytics
	 * @return the claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimAnalyticsException {

		ClaimAnalytics claimAnalytics = fetchByPrimaryKey(primaryKey);

		if (claimAnalytics == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimAnalyticsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimAnalytics;
	}

	/**
	 * Returns the claim analytics with the primary key or throws a <code>NoSuchClaimAnalyticsException</code> if it could not be found.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics
	 * @throws NoSuchClaimAnalyticsException if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics findByPrimaryKey(long claimAnalyticsId)
		throws NoSuchClaimAnalyticsException {

		return findByPrimaryKey((Serializable)claimAnalyticsId);
	}

	/**
	 * Returns the claim analytics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics, or <code>null</code> if a claim analytics with the primary key could not be found
	 */
	@Override
	public ClaimAnalytics fetchByPrimaryKey(long claimAnalyticsId) {
		return fetchByPrimaryKey((Serializable)claimAnalyticsId);
	}

	/**
	 * Returns all the claim analyticses.
	 *
	 * @return the claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findAll(
		int start, int end,
		OrderByComparator<ClaimAnalytics> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim analyticses
	 */
	@Override
	public List<ClaimAnalytics> findAll(
		int start, int end, OrderByComparator<ClaimAnalytics> orderByComparator,
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

		List<ClaimAnalytics> list = null;

		if (useFinderCache) {
			list = (List<ClaimAnalytics>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMANALYTICS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMANALYTICS;

				sql = sql.concat(ClaimAnalyticsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimAnalytics>)QueryUtil.list(
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
	 * Removes all the claim analyticses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimAnalytics claimAnalytics : findAll()) {
			remove(claimAnalytics);
		}
	}

	/**
	 * Returns the number of claim analyticses.
	 *
	 * @return the number of claim analyticses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIMANALYTICS);

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
		return "claimAnalyticsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMANALYTICS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimAnalyticsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim analytics persistence.
	 */
	@Activate
	public void activate() {
		ClaimAnalyticsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClaimAnalyticsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByExternalClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExternalClientId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByExternalClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExternalClientId",
			new String[] {Long.class.getName()},
			ClaimAnalyticsModelImpl.EXTERNALCLIENTID_COLUMN_BITMASK);

		_finderPathCountByExternalClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalClientId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByE_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByE_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByE_C",
			new String[] {Long.class.getName(), String.class.getName()},
			ClaimAnalyticsModelImpl.EXTERNALCLIENTID_COLUMN_BITMASK |
			ClaimAnalyticsModelImpl.CLAIMSTATUS_COLUMN_BITMASK);

		_finderPathCountByE_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_C",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ClaimAnalyticsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = OTH_ClaimPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.argus.oth.claim.model.ClaimAnalytics"),
			true);
	}

	@Override
	@Reference(
		target = OTH_ClaimPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OTH_ClaimPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CLAIMANALYTICS =
		"SELECT claimAnalytics FROM ClaimAnalytics claimAnalytics";

	private static final String _SQL_SELECT_CLAIMANALYTICS_WHERE =
		"SELECT claimAnalytics FROM ClaimAnalytics claimAnalytics WHERE ";

	private static final String _SQL_COUNT_CLAIMANALYTICS =
		"SELECT COUNT(claimAnalytics) FROM ClaimAnalytics claimAnalytics";

	private static final String _SQL_COUNT_CLAIMANALYTICS_WHERE =
		"SELECT COUNT(claimAnalytics) FROM ClaimAnalytics claimAnalytics WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimAnalytics.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimAnalytics exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClaimAnalytics exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimAnalyticsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"state"});

	static {
		try {
			Class.forName(OTH_ClaimPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}