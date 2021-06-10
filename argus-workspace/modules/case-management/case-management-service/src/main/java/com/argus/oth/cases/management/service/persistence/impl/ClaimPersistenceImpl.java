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

import com.argus.oth.cases.management.exception.NoSuchClaimException;
import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.model.impl.ClaimImpl;
import com.argus.oth.cases.management.model.impl.ClaimModelImpl;
import com.argus.oth.cases.management.service.persistence.ClaimPersistence;
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
 * The persistence implementation for the claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimPersistence.class)
public class ClaimPersistenceImpl
	extends BasePersistenceImpl<Claim> implements ClaimPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimUtil</code> to access the claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByClaimRef;
	private FinderPath _finderPathCountByClaimRef;

	/**
	 * Returns the claim where claimRef = &#63; or throws a <code>NoSuchClaimException</code> if it could not be found.
	 *
	 * @param claimRef the claim ref
	 * @return the matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	@Override
	public Claim findByClaimRef(String claimRef) throws NoSuchClaimException {
		Claim claim = fetchByClaimRef(claimRef);

		if (claim == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("claimRef=");
			sb.append(claimRef);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClaimException(sb.toString());
		}

		return claim;
	}

	/**
	 * Returns the claim where claimRef = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimRef the claim ref
	 * @return the matching claim, or <code>null</code> if a matching claim could not be found
	 */
	@Override
	public Claim fetchByClaimRef(String claimRef) {
		return fetchByClaimRef(claimRef, true);
	}

	/**
	 * Returns the claim where claimRef = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimRef the claim ref
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching claim, or <code>null</code> if a matching claim could not be found
	 */
	@Override
	public Claim fetchByClaimRef(String claimRef, boolean useFinderCache) {
		claimRef = Objects.toString(claimRef, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {claimRef};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByClaimRef, finderArgs, this);
		}

		if (result instanceof Claim) {
			Claim claim = (Claim)result;

			if (!Objects.equals(claimRef, claim.getClaimRef())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLAIM_WHERE);

			boolean bindClaimRef = false;

			if (claimRef.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMREF_CLAIMREF_3);
			}
			else {
				bindClaimRef = true;

				sb.append(_FINDER_COLUMN_CLAIMREF_CLAIMREF_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimRef) {
					queryPos.add(claimRef);
				}

				List<Claim> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByClaimRef, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {claimRef};
							}

							_log.warn(
								"ClaimPersistenceImpl.fetchByClaimRef(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Claim claim = list.get(0);

					result = claim;

					cacheResult(claim);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByClaimRef, finderArgs);
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
			return (Claim)result;
		}
	}

	/**
	 * Removes the claim where claimRef = &#63; from the database.
	 *
	 * @param claimRef the claim ref
	 * @return the claim that was removed
	 */
	@Override
	public Claim removeByClaimRef(String claimRef) throws NoSuchClaimException {
		Claim claim = findByClaimRef(claimRef);

		return remove(claim);
	}

	/**
	 * Returns the number of claims where claimRef = &#63;.
	 *
	 * @param claimRef the claim ref
	 * @return the number of matching claims
	 */
	@Override
	public int countByClaimRef(String claimRef) {
		claimRef = Objects.toString(claimRef, "");

		FinderPath finderPath = _finderPathCountByClaimRef;

		Object[] finderArgs = new Object[] {claimRef};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIM_WHERE);

			boolean bindClaimRef = false;

			if (claimRef.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMREF_CLAIMREF_3);
			}
			else {
				bindClaimRef = true;

				sb.append(_FINDER_COLUMN_CLAIMREF_CLAIMREF_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimRef) {
					queryPos.add(claimRef);
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

	private static final String _FINDER_COLUMN_CLAIMREF_CLAIMREF_2 =
		"claim.claimRef = ?";

	private static final String _FINDER_COLUMN_CLAIMREF_CLAIMREF_3 =
		"(claim.claimRef IS NULL OR claim.claimRef = '')";

	private FinderPath _finderPathWithPaginationFindByAuthorizationNumber;
	private FinderPath _finderPathWithoutPaginationFindByAuthorizationNumber;
	private FinderPath _finderPathCountByAuthorizationNumber;

	/**
	 * Returns all the claims where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @return the matching claims
	 */
	@Override
	public List<Claim> findByAuthorizationNumber(String authorizationNumber) {
		return findByAuthorizationNumber(
			authorizationNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claims where authorizationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param authorizationNumber the authorization number
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of matching claims
	 */
	@Override
	public List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end) {

		return findByAuthorizationNumber(authorizationNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claims where authorizationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param authorizationNumber the authorization number
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claims
	 */
	@Override
	public List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end,
		OrderByComparator<Claim> orderByComparator) {

		return findByAuthorizationNumber(
			authorizationNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claims where authorizationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param authorizationNumber the authorization number
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claims
	 */
	@Override
	public List<Claim> findByAuthorizationNumber(
		String authorizationNumber, int start, int end,
		OrderByComparator<Claim> orderByComparator, boolean useFinderCache) {

		authorizationNumber = Objects.toString(authorizationNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAuthorizationNumber;
				finderArgs = new Object[] {authorizationNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAuthorizationNumber;
			finderArgs = new Object[] {
				authorizationNumber, start, end, orderByComparator
			};
		}

		List<Claim> list = null;

		if (useFinderCache) {
			list = (List<Claim>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Claim claim : list) {
					if (!authorizationNumber.equals(
							claim.getAuthorizationNumber())) {

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

			sb.append(_SQL_SELECT_CLAIM_WHERE);

			boolean bindAuthorizationNumber = false;

			if (authorizationNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_3);
			}
			else {
				bindAuthorizationNumber = true;

				sb.append(
					_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAuthorizationNumber) {
					queryPos.add(authorizationNumber);
				}

				list = (List<Claim>)QueryUtil.list(
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
	 * Returns the first claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	@Override
	public Claim findByAuthorizationNumber_First(
			String authorizationNumber,
			OrderByComparator<Claim> orderByComparator)
		throws NoSuchClaimException {

		Claim claim = fetchByAuthorizationNumber_First(
			authorizationNumber, orderByComparator);

		if (claim != null) {
			return claim;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authorizationNumber=");
		sb.append(authorizationNumber);

		sb.append("}");

		throw new NoSuchClaimException(sb.toString());
	}

	/**
	 * Returns the first claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim, or <code>null</code> if a matching claim could not be found
	 */
	@Override
	public Claim fetchByAuthorizationNumber_First(
		String authorizationNumber,
		OrderByComparator<Claim> orderByComparator) {

		List<Claim> list = findByAuthorizationNumber(
			authorizationNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	@Override
	public Claim findByAuthorizationNumber_Last(
			String authorizationNumber,
			OrderByComparator<Claim> orderByComparator)
		throws NoSuchClaimException {

		Claim claim = fetchByAuthorizationNumber_Last(
			authorizationNumber, orderByComparator);

		if (claim != null) {
			return claim;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authorizationNumber=");
		sb.append(authorizationNumber);

		sb.append("}");

		throw new NoSuchClaimException(sb.toString());
	}

	/**
	 * Returns the last claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim, or <code>null</code> if a matching claim could not be found
	 */
	@Override
	public Claim fetchByAuthorizationNumber_Last(
		String authorizationNumber,
		OrderByComparator<Claim> orderByComparator) {

		int count = countByAuthorizationNumber(authorizationNumber);

		if (count == 0) {
			return null;
		}

		List<Claim> list = findByAuthorizationNumber(
			authorizationNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claims before and after the current claim in the ordered set where authorizationNumber = &#63;.
	 *
	 * @param claimId the primary key of the current claim
	 * @param authorizationNumber the authorization number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	@Override
	public Claim[] findByAuthorizationNumber_PrevAndNext(
			long claimId, String authorizationNumber,
			OrderByComparator<Claim> orderByComparator)
		throws NoSuchClaimException {

		authorizationNumber = Objects.toString(authorizationNumber, "");

		Claim claim = findByPrimaryKey(claimId);

		Session session = null;

		try {
			session = openSession();

			Claim[] array = new ClaimImpl[3];

			array[0] = getByAuthorizationNumber_PrevAndNext(
				session, claim, authorizationNumber, orderByComparator, true);

			array[1] = claim;

			array[2] = getByAuthorizationNumber_PrevAndNext(
				session, claim, authorizationNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Claim getByAuthorizationNumber_PrevAndNext(
		Session session, Claim claim, String authorizationNumber,
		OrderByComparator<Claim> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIM_WHERE);

		boolean bindAuthorizationNumber = false;

		if (authorizationNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_3);
		}
		else {
			bindAuthorizationNumber = true;

			sb.append(_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_2);
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
			sb.append(ClaimModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAuthorizationNumber) {
			queryPos.add(authorizationNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(claim)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Claim> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claims where authorizationNumber = &#63; from the database.
	 *
	 * @param authorizationNumber the authorization number
	 */
	@Override
	public void removeByAuthorizationNumber(String authorizationNumber) {
		for (Claim claim :
				findByAuthorizationNumber(
					authorizationNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(claim);
		}
	}

	/**
	 * Returns the number of claims where authorizationNumber = &#63;.
	 *
	 * @param authorizationNumber the authorization number
	 * @return the number of matching claims
	 */
	@Override
	public int countByAuthorizationNumber(String authorizationNumber) {
		authorizationNumber = Objects.toString(authorizationNumber, "");

		FinderPath finderPath = _finderPathCountByAuthorizationNumber;

		Object[] finderArgs = new Object[] {authorizationNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIM_WHERE);

			boolean bindAuthorizationNumber = false;

			if (authorizationNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_3);
			}
			else {
				bindAuthorizationNumber = true;

				sb.append(
					_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAuthorizationNumber) {
					queryPos.add(authorizationNumber);
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
		_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_2 =
			"claim.authorizationNumber = ?";

	private static final String
		_FINDER_COLUMN_AUTHORIZATIONNUMBER_AUTHORIZATIONNUMBER_3 =
			"(claim.authorizationNumber IS NULL OR claim.authorizationNumber = '')";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the claims where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching claims
	 */
	@Override
	public List<Claim> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claims where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of matching claims
	 */
	@Override
	public List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claims where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claims
	 */
	@Override
	public List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Claim> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claims where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claims
	 */
	@Override
	public List<Claim> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Claim> orderByComparator, boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<Claim> list = null;

		if (useFinderCache) {
			list = (List<Claim>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Claim claim : list) {
					if (rowProcessed.equals(claim.getRowProcessed())) {
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

			sb.append(_SQL_SELECT_CLAIM_WHERE);

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
				sb.append(ClaimModelImpl.ORDER_BY_JPQL);
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

				list = (List<Claim>)QueryUtil.list(
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
	 * Returns the first claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	@Override
	public Claim findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Claim> orderByComparator)
		throws NoSuchClaimException {

		Claim claim = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (claim != null) {
			return claim;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClaimException(sb.toString());
	}

	/**
	 * Returns the first claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim, or <code>null</code> if a matching claim could not be found
	 */
	@Override
	public Claim fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Claim> orderByComparator) {

		List<Claim> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim
	 * @throws NoSuchClaimException if a matching claim could not be found
	 */
	@Override
	public Claim findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Claim> orderByComparator)
		throws NoSuchClaimException {

		Claim claim = fetchByRowProcessed_Last(rowProcessed, orderByComparator);

		if (claim != null) {
			return claim;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchClaimException(sb.toString());
	}

	/**
	 * Returns the last claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim, or <code>null</code> if a matching claim could not be found
	 */
	@Override
	public Claim fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Claim> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<Claim> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claims before and after the current claim in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param claimId the primary key of the current claim
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	@Override
	public Claim[] findByRowProcessed_PrevAndNext(
			long claimId, String rowProcessed,
			OrderByComparator<Claim> orderByComparator)
		throws NoSuchClaimException {

		rowProcessed = Objects.toString(rowProcessed, "");

		Claim claim = findByPrimaryKey(claimId);

		Session session = null;

		try {
			session = openSession();

			Claim[] array = new ClaimImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, claim, rowProcessed, orderByComparator, true);

			array[1] = claim;

			array[2] = getByRowProcessed_PrevAndNext(
				session, claim, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Claim getByRowProcessed_PrevAndNext(
		Session session, Claim claim, String rowProcessed,
		OrderByComparator<Claim> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIM_WHERE);

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
			sb.append(ClaimModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(claim)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Claim> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claims where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (Claim claim :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(claim);
		}
	}

	/**
	 * Returns the number of claims where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching claims
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIM_WHERE);

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
		"claim.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(claim.rowProcessed IS NULL OR claim.rowProcessed != '')";

	public ClaimPersistenceImpl() {
		setModelClass(Claim.class);

		setModelImplClass(ClaimImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the claim in the entity cache if it is enabled.
	 *
	 * @param claim the claim
	 */
	@Override
	public void cacheResult(Claim claim) {
		entityCache.putResult(
			entityCacheEnabled, ClaimImpl.class, claim.getPrimaryKey(), claim);

		finderCache.putResult(
			_finderPathFetchByClaimRef, new Object[] {claim.getClaimRef()},
			claim);

		claim.resetOriginalValues();
	}

	/**
	 * Caches the claims in the entity cache if it is enabled.
	 *
	 * @param claims the claims
	 */
	@Override
	public void cacheResult(List<Claim> claims) {
		for (Claim claim : claims) {
			if (entityCache.getResult(
					entityCacheEnabled, ClaimImpl.class,
					claim.getPrimaryKey()) == null) {

				cacheResult(claim);
			}
			else {
				claim.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all claims.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClaimImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Claim claim) {
		entityCache.removeResult(
			entityCacheEnabled, ClaimImpl.class, claim.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ClaimModelImpl)claim, true);
	}

	@Override
	public void clearCache(List<Claim> claims) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Claim claim : claims) {
			entityCache.removeResult(
				entityCacheEnabled, ClaimImpl.class, claim.getPrimaryKey());

			clearUniqueFindersCache((ClaimModelImpl)claim, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ClaimImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ClaimModelImpl claimModelImpl) {
		Object[] args = new Object[] {claimModelImpl.getClaimRef()};

		finderCache.putResult(
			_finderPathCountByClaimRef, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByClaimRef, args, claimModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ClaimModelImpl claimModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {claimModelImpl.getClaimRef()};

			finderCache.removeResult(_finderPathCountByClaimRef, args);
			finderCache.removeResult(_finderPathFetchByClaimRef, args);
		}

		if ((claimModelImpl.getColumnBitmask() &
			 _finderPathFetchByClaimRef.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {claimModelImpl.getOriginalClaimRef()};

			finderCache.removeResult(_finderPathCountByClaimRef, args);
			finderCache.removeResult(_finderPathFetchByClaimRef, args);
		}
	}

	/**
	 * Creates a new claim with the primary key. Does not add the claim to the database.
	 *
	 * @param claimId the primary key for the new claim
	 * @return the new claim
	 */
	@Override
	public Claim create(long claimId) {
		Claim claim = new ClaimImpl();

		claim.setNew(true);
		claim.setPrimaryKey(claimId);

		claim.setCompanyId(CompanyThreadLocal.getCompanyId());

		return claim;
	}

	/**
	 * Removes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim that was removed
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	@Override
	public Claim remove(long claimId) throws NoSuchClaimException {
		return remove((Serializable)claimId);
	}

	/**
	 * Removes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim
	 * @return the claim that was removed
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	@Override
	public Claim remove(Serializable primaryKey) throws NoSuchClaimException {
		Session session = null;

		try {
			session = openSession();

			Claim claim = (Claim)session.get(ClaimImpl.class, primaryKey);

			if (claim == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claim);
		}
		catch (NoSuchClaimException noSuchEntityException) {
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
	protected Claim removeImpl(Claim claim) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claim)) {
				claim = (Claim)session.get(
					ClaimImpl.class, claim.getPrimaryKeyObj());
			}

			if (claim != null) {
				session.delete(claim);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claim != null) {
			clearCache(claim);
		}

		return claim;
	}

	@Override
	public Claim updateImpl(Claim claim) {
		boolean isNew = claim.isNew();

		if (!(claim instanceof ClaimModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(claim.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(claim);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in claim proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Claim implementation " +
					claim.getClass());
		}

		ClaimModelImpl claimModelImpl = (ClaimModelImpl)claim;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (claim.getCreateDate() == null)) {
			if (serviceContext == null) {
				claim.setCreateDate(now);
			}
			else {
				claim.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!claimModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				claim.setModifiedDate(now);
			}
			else {
				claim.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claim);

				claim.setNew(false);
			}
			else {
				claim = (Claim)session.merge(claim);
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
				claimModelImpl.getAuthorizationNumber()
			};

			finderCache.removeResult(
				_finderPathCountByAuthorizationNumber, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAuthorizationNumber, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((claimModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAuthorizationNumber.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					claimModelImpl.getOriginalAuthorizationNumber()
				};

				finderCache.removeResult(
					_finderPathCountByAuthorizationNumber, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuthorizationNumber,
					args);

				args = new Object[] {claimModelImpl.getAuthorizationNumber()};

				finderCache.removeResult(
					_finderPathCountByAuthorizationNumber, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuthorizationNumber,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ClaimImpl.class, claim.getPrimaryKey(), claim,
			false);

		clearUniqueFindersCache(claimModelImpl, false);
		cacheUniqueFindersCache(claimModelImpl);

		claim.resetOriginalValues();

		return claim;
	}

	/**
	 * Returns the claim with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim
	 * @return the claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	@Override
	public Claim findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimException {

		Claim claim = fetchByPrimaryKey(primaryKey);

		if (claim == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claim;
	}

	/**
	 * Returns the claim with the primary key or throws a <code>NoSuchClaimException</code> if it could not be found.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim
	 * @throws NoSuchClaimException if a claim with the primary key could not be found
	 */
	@Override
	public Claim findByPrimaryKey(long claimId) throws NoSuchClaimException {
		return findByPrimaryKey((Serializable)claimId);
	}

	/**
	 * Returns the claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim, or <code>null</code> if a claim with the primary key could not be found
	 */
	@Override
	public Claim fetchByPrimaryKey(long claimId) {
		return fetchByPrimaryKey((Serializable)claimId);
	}

	/**
	 * Returns all the claims.
	 *
	 * @return the claims
	 */
	@Override
	public List<Claim> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of claims
	 */
	@Override
	public List<Claim> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claims
	 */
	@Override
	public List<Claim> findAll(
		int start, int end, OrderByComparator<Claim> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claims
	 */
	@Override
	public List<Claim> findAll(
		int start, int end, OrderByComparator<Claim> orderByComparator,
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

		List<Claim> list = null;

		if (useFinderCache) {
			list = (List<Claim>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIM;

				sql = sql.concat(ClaimModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Claim>)QueryUtil.list(
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
	 * Removes all the claims from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Claim claim : findAll()) {
			remove(claim);
		}
	}

	/**
	 * Returns the number of claims.
	 *
	 * @return the number of claims
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIM);

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
		return "claimId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim persistence.
	 */
	@Activate
	public void activate() {
		ClaimModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClaimModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByClaimRef = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByClaimRef",
			new String[] {String.class.getName()},
			ClaimModelImpl.CLAIMREF_COLUMN_BITMASK);

		_finderPathCountByClaimRef = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClaimRef",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByAuthorizationNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorizationNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAuthorizationNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAuthorizationNumber", new String[] {String.class.getName()},
			ClaimModelImpl.AUTHORIZATIONNUMBER_COLUMN_BITMASK |
			ClaimModelImpl.STATUSSORTORDER_COLUMN_BITMASK);

		_finderPathCountByAuthorizationNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAuthorizationNumber",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClaimImpl.class,
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
		entityCache.removeCache(ClaimImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.Claim"),
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

	private static final String _SQL_SELECT_CLAIM =
		"SELECT claim FROM Claim claim";

	private static final String _SQL_SELECT_CLAIM_WHERE =
		"SELECT claim FROM Claim claim WHERE ";

	private static final String _SQL_COUNT_CLAIM =
		"SELECT COUNT(claim) FROM Claim claim";

	private static final String _SQL_COUNT_CLAIM_WHERE =
		"SELECT COUNT(claim) FROM Claim claim WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claim.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Claim exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Claim exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimPersistenceImpl.class);

}