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

import com.argus.oth.cases.management.exception.NoSuchAuthProcedureException;
import com.argus.oth.cases.management.model.AuthProcedure;
import com.argus.oth.cases.management.model.impl.AuthProcedureImpl;
import com.argus.oth.cases.management.model.impl.AuthProcedureModelImpl;
import com.argus.oth.cases.management.service.persistence.AuthProcedurePersistence;
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
 * The persistence implementation for the auth procedure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuthProcedurePersistence.class)
public class AuthProcedurePersistenceImpl
	extends BasePersistenceImpl<AuthProcedure>
	implements AuthProcedurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuthProcedureUtil</code> to access the auth procedure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuthProcedureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAuthNumber;
	private FinderPath _finderPathWithoutPaginationFindByAuthNumber;
	private FinderPath _finderPathCountByAuthNumber;

	/**
	 * Returns all the auth procedures where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByAuthNumber(String authNumber) {
		return findByAuthNumber(
			authNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end) {

		return findByAuthNumber(authNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return findByAuthNumber(
			authNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator,
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

		List<AuthProcedure> list = null;

		if (useFinderCache) {
			list = (List<AuthProcedure>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuthProcedure authProcedure : list) {
					if (!authNumber.equals(authProcedure.getAuthNumber())) {
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

			sb.append(_SQL_SELECT_AUTHPROCEDURE_WHERE);

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
				sb.append(AuthProcedureModelImpl.ORDER_BY_JPQL);
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

				list = (List<AuthProcedure>)QueryUtil.list(
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
	 * Returns the first auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure findByAuthNumber_First(
			String authNumber,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = fetchByAuthNumber_First(
			authNumber, orderByComparator);

		if (authProcedure != null) {
			return authProcedure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authNumber=");
		sb.append(authNumber);

		sb.append("}");

		throw new NoSuchAuthProcedureException(sb.toString());
	}

	/**
	 * Returns the first auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure fetchByAuthNumber_First(
		String authNumber, OrderByComparator<AuthProcedure> orderByComparator) {

		List<AuthProcedure> list = findByAuthNumber(
			authNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure findByAuthNumber_Last(
			String authNumber,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = fetchByAuthNumber_Last(
			authNumber, orderByComparator);

		if (authProcedure != null) {
			return authProcedure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authNumber=");
		sb.append(authNumber);

		sb.append("}");

		throw new NoSuchAuthProcedureException(sb.toString());
	}

	/**
	 * Returns the last auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure fetchByAuthNumber_Last(
		String authNumber, OrderByComparator<AuthProcedure> orderByComparator) {

		int count = countByAuthNumber(authNumber);

		if (count == 0) {
			return null;
		}

		List<AuthProcedure> list = findByAuthNumber(
			authNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auth procedures before and after the current auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authProcedureId the primary key of the current auth procedure
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure[] findByAuthNumber_PrevAndNext(
			long authProcedureId, String authNumber,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws NoSuchAuthProcedureException {

		authNumber = Objects.toString(authNumber, "");

		AuthProcedure authProcedure = findByPrimaryKey(authProcedureId);

		Session session = null;

		try {
			session = openSession();

			AuthProcedure[] array = new AuthProcedureImpl[3];

			array[0] = getByAuthNumber_PrevAndNext(
				session, authProcedure, authNumber, orderByComparator, true);

			array[1] = authProcedure;

			array[2] = getByAuthNumber_PrevAndNext(
				session, authProcedure, authNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuthProcedure getByAuthNumber_PrevAndNext(
		Session session, AuthProcedure authProcedure, String authNumber,
		OrderByComparator<AuthProcedure> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHPROCEDURE_WHERE);

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
			sb.append(AuthProcedureModelImpl.ORDER_BY_JPQL);
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
						authProcedure)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuthProcedure> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auth procedures where authNumber = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 */
	@Override
	public void removeByAuthNumber(String authNumber) {
		for (AuthProcedure authProcedure :
				findByAuthNumber(
					authNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(authProcedure);
		}
	}

	/**
	 * Returns the number of auth procedures where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the number of matching auth procedures
	 */
	@Override
	public int countByAuthNumber(String authNumber) {
		authNumber = Objects.toString(authNumber, "");

		FinderPath finderPath = _finderPathCountByAuthNumber;

		Object[] finderArgs = new Object[] {authNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHPROCEDURE_WHERE);

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
		"authProcedure.authNumber = ?";

	private static final String _FINDER_COLUMN_AUTHNUMBER_AUTHNUMBER_3 =
		"(authProcedure.authNumber IS NULL OR authProcedure.authNumber = '')";

	private FinderPath _finderPathWithPaginationFindByExtAuthorizationId;
	private FinderPath _finderPathWithoutPaginationFindByExtAuthorizationId;
	private FinderPath _finderPathCountByExtAuthorizationId;

	/**
	 * Returns all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId) {

		return findByExtAuthorizationId(
			externalAuthorizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end) {

		return findByExtAuthorizationId(
			externalAuthorizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return findByExtAuthorizationId(
			externalAuthorizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auth procedures
	 */
	@Override
	public List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByExtAuthorizationId;
				finderArgs = new Object[] {externalAuthorizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExtAuthorizationId;
			finderArgs = new Object[] {
				externalAuthorizationId, start, end, orderByComparator
			};
		}

		List<AuthProcedure> list = null;

		if (useFinderCache) {
			list = (List<AuthProcedure>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuthProcedure authProcedure : list) {
					if (externalAuthorizationId !=
							authProcedure.getExternalAuthorizationId()) {

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

			sb.append(_SQL_SELECT_AUTHPROCEDURE_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthProcedureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalAuthorizationId);

				list = (List<AuthProcedure>)QueryUtil.list(
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
	 * Returns the first auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure findByExtAuthorizationId_First(
			long externalAuthorizationId,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = fetchByExtAuthorizationId_First(
			externalAuthorizationId, orderByComparator);

		if (authProcedure != null) {
			return authProcedure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalAuthorizationId=");
		sb.append(externalAuthorizationId);

		sb.append("}");

		throw new NoSuchAuthProcedureException(sb.toString());
	}

	/**
	 * Returns the first auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure fetchByExtAuthorizationId_First(
		long externalAuthorizationId,
		OrderByComparator<AuthProcedure> orderByComparator) {

		List<AuthProcedure> list = findByExtAuthorizationId(
			externalAuthorizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure findByExtAuthorizationId_Last(
			long externalAuthorizationId,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = fetchByExtAuthorizationId_Last(
			externalAuthorizationId, orderByComparator);

		if (authProcedure != null) {
			return authProcedure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalAuthorizationId=");
		sb.append(externalAuthorizationId);

		sb.append("}");

		throw new NoSuchAuthProcedureException(sb.toString());
	}

	/**
	 * Returns the last auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure fetchByExtAuthorizationId_Last(
		long externalAuthorizationId,
		OrderByComparator<AuthProcedure> orderByComparator) {

		int count = countByExtAuthorizationId(externalAuthorizationId);

		if (count == 0) {
			return null;
		}

		List<AuthProcedure> list = findByExtAuthorizationId(
			externalAuthorizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auth procedures before and after the current auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param authProcedureId the primary key of the current auth procedure
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure[] findByExtAuthorizationId_PrevAndNext(
			long authProcedureId, long externalAuthorizationId,
			OrderByComparator<AuthProcedure> orderByComparator)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = findByPrimaryKey(authProcedureId);

		Session session = null;

		try {
			session = openSession();

			AuthProcedure[] array = new AuthProcedureImpl[3];

			array[0] = getByExtAuthorizationId_PrevAndNext(
				session, authProcedure, externalAuthorizationId,
				orderByComparator, true);

			array[1] = authProcedure;

			array[2] = getByExtAuthorizationId_PrevAndNext(
				session, authProcedure, externalAuthorizationId,
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

	protected AuthProcedure getByExtAuthorizationId_PrevAndNext(
		Session session, AuthProcedure authProcedure,
		long externalAuthorizationId,
		OrderByComparator<AuthProcedure> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHPROCEDURE_WHERE);

		sb.append(_FINDER_COLUMN_EXTAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2);

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
			sb.append(AuthProcedureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(externalAuthorizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						authProcedure)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuthProcedure> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auth procedures where externalAuthorizationId = &#63; from the database.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 */
	@Override
	public void removeByExtAuthorizationId(long externalAuthorizationId) {
		for (AuthProcedure authProcedure :
				findByExtAuthorizationId(
					externalAuthorizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(authProcedure);
		}
	}

	/**
	 * Returns the number of auth procedures where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the number of matching auth procedures
	 */
	@Override
	public int countByExtAuthorizationId(long externalAuthorizationId) {
		FinderPath finderPath = _finderPathCountByExtAuthorizationId;

		Object[] finderArgs = new Object[] {externalAuthorizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHPROCEDURE_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2);

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
		_FINDER_COLUMN_EXTAUTHORIZATIONID_EXTERNALAUTHORIZATIONID_2 =
			"authProcedure.externalAuthorizationId = ?";

	private FinderPath _finderPathFetchByA_M;
	private FinderPath _finderPathCountByA_M;

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or throws a <code>NoSuchAuthProcedureException</code> if it could not be found.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure findByA_M(String authNumber, String medicalCodeId)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = fetchByA_M(authNumber, medicalCodeId);

		if (authProcedure == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("authNumber=");
			sb.append(authNumber);

			sb.append(", medicalCodeId=");
			sb.append(medicalCodeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAuthProcedureException(sb.toString());
		}

		return authProcedure;
	}

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure fetchByA_M(String authNumber, String medicalCodeId) {
		return fetchByA_M(authNumber, medicalCodeId, true);
	}

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	@Override
	public AuthProcedure fetchByA_M(
		String authNumber, String medicalCodeId, boolean useFinderCache) {

		authNumber = Objects.toString(authNumber, "");
		medicalCodeId = Objects.toString(medicalCodeId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {authNumber, medicalCodeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByA_M, finderArgs, this);
		}

		if (result instanceof AuthProcedure) {
			AuthProcedure authProcedure = (AuthProcedure)result;

			if (!Objects.equals(authNumber, authProcedure.getAuthNumber()) ||
				!Objects.equals(
					medicalCodeId, authProcedure.getMedicalCodeId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AUTHPROCEDURE_WHERE);

			boolean bindAuthNumber = false;

			if (authNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_A_M_AUTHNUMBER_3);
			}
			else {
				bindAuthNumber = true;

				sb.append(_FINDER_COLUMN_A_M_AUTHNUMBER_2);
			}

			boolean bindMedicalCodeId = false;

			if (medicalCodeId.isEmpty()) {
				sb.append(_FINDER_COLUMN_A_M_MEDICALCODEID_3);
			}
			else {
				bindMedicalCodeId = true;

				sb.append(_FINDER_COLUMN_A_M_MEDICALCODEID_2);
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

				if (bindMedicalCodeId) {
					queryPos.add(medicalCodeId);
				}

				List<AuthProcedure> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByA_M, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									authNumber, medicalCodeId
								};
							}

							_log.warn(
								"AuthProcedurePersistenceImpl.fetchByA_M(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AuthProcedure authProcedure = list.get(0);

					result = authProcedure;

					cacheResult(authProcedure);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByA_M, finderArgs);
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
			return (AuthProcedure)result;
		}
	}

	/**
	 * Removes the auth procedure where authNumber = &#63; and medicalCodeId = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the auth procedure that was removed
	 */
	@Override
	public AuthProcedure removeByA_M(String authNumber, String medicalCodeId)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = findByA_M(authNumber, medicalCodeId);

		return remove(authProcedure);
	}

	/**
	 * Returns the number of auth procedures where authNumber = &#63; and medicalCodeId = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the number of matching auth procedures
	 */
	@Override
	public int countByA_M(String authNumber, String medicalCodeId) {
		authNumber = Objects.toString(authNumber, "");
		medicalCodeId = Objects.toString(medicalCodeId, "");

		FinderPath finderPath = _finderPathCountByA_M;

		Object[] finderArgs = new Object[] {authNumber, medicalCodeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUTHPROCEDURE_WHERE);

			boolean bindAuthNumber = false;

			if (authNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_A_M_AUTHNUMBER_3);
			}
			else {
				bindAuthNumber = true;

				sb.append(_FINDER_COLUMN_A_M_AUTHNUMBER_2);
			}

			boolean bindMedicalCodeId = false;

			if (medicalCodeId.isEmpty()) {
				sb.append(_FINDER_COLUMN_A_M_MEDICALCODEID_3);
			}
			else {
				bindMedicalCodeId = true;

				sb.append(_FINDER_COLUMN_A_M_MEDICALCODEID_2);
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

				if (bindMedicalCodeId) {
					queryPos.add(medicalCodeId);
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

	private static final String _FINDER_COLUMN_A_M_AUTHNUMBER_2 =
		"authProcedure.authNumber = ? AND ";

	private static final String _FINDER_COLUMN_A_M_AUTHNUMBER_3 =
		"(authProcedure.authNumber IS NULL OR authProcedure.authNumber = '') AND ";

	private static final String _FINDER_COLUMN_A_M_MEDICALCODEID_2 =
		"authProcedure.medicalCodeId = ?";

	private static final String _FINDER_COLUMN_A_M_MEDICALCODEID_3 =
		"(authProcedure.medicalCodeId IS NULL OR authProcedure.medicalCodeId = '')";

	public AuthProcedurePersistenceImpl() {
		setModelClass(AuthProcedure.class);

		setModelImplClass(AuthProcedureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the auth procedure in the entity cache if it is enabled.
	 *
	 * @param authProcedure the auth procedure
	 */
	@Override
	public void cacheResult(AuthProcedure authProcedure) {
		entityCache.putResult(
			entityCacheEnabled, AuthProcedureImpl.class,
			authProcedure.getPrimaryKey(), authProcedure);

		finderCache.putResult(
			_finderPathFetchByA_M,
			new Object[] {
				authProcedure.getAuthNumber(), authProcedure.getMedicalCodeId()
			},
			authProcedure);

		authProcedure.resetOriginalValues();
	}

	/**
	 * Caches the auth procedures in the entity cache if it is enabled.
	 *
	 * @param authProcedures the auth procedures
	 */
	@Override
	public void cacheResult(List<AuthProcedure> authProcedures) {
		for (AuthProcedure authProcedure : authProcedures) {
			if (entityCache.getResult(
					entityCacheEnabled, AuthProcedureImpl.class,
					authProcedure.getPrimaryKey()) == null) {

				cacheResult(authProcedure);
			}
			else {
				authProcedure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auth procedures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuthProcedureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auth procedure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuthProcedure authProcedure) {
		entityCache.removeResult(
			entityCacheEnabled, AuthProcedureImpl.class,
			authProcedure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AuthProcedureModelImpl)authProcedure, true);
	}

	@Override
	public void clearCache(List<AuthProcedure> authProcedures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuthProcedure authProcedure : authProcedures) {
			entityCache.removeResult(
				entityCacheEnabled, AuthProcedureImpl.class,
				authProcedure.getPrimaryKey());

			clearUniqueFindersCache(
				(AuthProcedureModelImpl)authProcedure, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AuthProcedureImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AuthProcedureModelImpl authProcedureModelImpl) {

		Object[] args = new Object[] {
			authProcedureModelImpl.getAuthNumber(),
			authProcedureModelImpl.getMedicalCodeId()
		};

		finderCache.putResult(
			_finderPathCountByA_M, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByA_M, args, authProcedureModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AuthProcedureModelImpl authProcedureModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				authProcedureModelImpl.getAuthNumber(),
				authProcedureModelImpl.getMedicalCodeId()
			};

			finderCache.removeResult(_finderPathCountByA_M, args);
			finderCache.removeResult(_finderPathFetchByA_M, args);
		}

		if ((authProcedureModelImpl.getColumnBitmask() &
			 _finderPathFetchByA_M.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				authProcedureModelImpl.getOriginalAuthNumber(),
				authProcedureModelImpl.getOriginalMedicalCodeId()
			};

			finderCache.removeResult(_finderPathCountByA_M, args);
			finderCache.removeResult(_finderPathFetchByA_M, args);
		}
	}

	/**
	 * Creates a new auth procedure with the primary key. Does not add the auth procedure to the database.
	 *
	 * @param authProcedureId the primary key for the new auth procedure
	 * @return the new auth procedure
	 */
	@Override
	public AuthProcedure create(long authProcedureId) {
		AuthProcedure authProcedure = new AuthProcedureImpl();

		authProcedure.setNew(true);
		authProcedure.setPrimaryKey(authProcedureId);

		return authProcedure;
	}

	/**
	 * Removes the auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure that was removed
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure remove(long authProcedureId)
		throws NoSuchAuthProcedureException {

		return remove((Serializable)authProcedureId);
	}

	/**
	 * Removes the auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auth procedure
	 * @return the auth procedure that was removed
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure remove(Serializable primaryKey)
		throws NoSuchAuthProcedureException {

		Session session = null;

		try {
			session = openSession();

			AuthProcedure authProcedure = (AuthProcedure)session.get(
				AuthProcedureImpl.class, primaryKey);

			if (authProcedure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthProcedureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(authProcedure);
		}
		catch (NoSuchAuthProcedureException noSuchEntityException) {
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
	protected AuthProcedure removeImpl(AuthProcedure authProcedure) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(authProcedure)) {
				authProcedure = (AuthProcedure)session.get(
					AuthProcedureImpl.class, authProcedure.getPrimaryKeyObj());
			}

			if (authProcedure != null) {
				session.delete(authProcedure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (authProcedure != null) {
			clearCache(authProcedure);
		}

		return authProcedure;
	}

	@Override
	public AuthProcedure updateImpl(AuthProcedure authProcedure) {
		boolean isNew = authProcedure.isNew();

		if (!(authProcedure instanceof AuthProcedureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(authProcedure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					authProcedure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in authProcedure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AuthProcedure implementation " +
					authProcedure.getClass());
		}

		AuthProcedureModelImpl authProcedureModelImpl =
			(AuthProcedureModelImpl)authProcedure;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (authProcedure.getCreateDate() == null)) {
			if (serviceContext == null) {
				authProcedure.setCreateDate(now);
			}
			else {
				authProcedure.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!authProcedureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				authProcedure.setModifiedDate(now);
			}
			else {
				authProcedure.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(authProcedure);

				authProcedure.setNew(false);
			}
			else {
				authProcedure = (AuthProcedure)session.merge(authProcedure);
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
				authProcedureModelImpl.getAuthNumber()
			};

			finderCache.removeResult(_finderPathCountByAuthNumber, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAuthNumber, args);

			args = new Object[] {
				authProcedureModelImpl.getExternalAuthorizationId()
			};

			finderCache.removeResult(
				_finderPathCountByExtAuthorizationId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByExtAuthorizationId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((authProcedureModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAuthNumber.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					authProcedureModelImpl.getOriginalAuthNumber()
				};

				finderCache.removeResult(_finderPathCountByAuthNumber, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuthNumber, args);

				args = new Object[] {authProcedureModelImpl.getAuthNumber()};

				finderCache.removeResult(_finderPathCountByAuthNumber, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuthNumber, args);
			}

			if ((authProcedureModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByExtAuthorizationId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					authProcedureModelImpl.getOriginalExternalAuthorizationId()
				};

				finderCache.removeResult(
					_finderPathCountByExtAuthorizationId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExtAuthorizationId, args);

				args = new Object[] {
					authProcedureModelImpl.getExternalAuthorizationId()
				};

				finderCache.removeResult(
					_finderPathCountByExtAuthorizationId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExtAuthorizationId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AuthProcedureImpl.class,
			authProcedure.getPrimaryKey(), authProcedure, false);

		clearUniqueFindersCache(authProcedureModelImpl, false);
		cacheUniqueFindersCache(authProcedureModelImpl);

		authProcedure.resetOriginalValues();

		return authProcedure;
	}

	/**
	 * Returns the auth procedure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auth procedure
	 * @return the auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthProcedureException {

		AuthProcedure authProcedure = fetchByPrimaryKey(primaryKey);

		if (authProcedure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthProcedureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return authProcedure;
	}

	/**
	 * Returns the auth procedure with the primary key or throws a <code>NoSuchAuthProcedureException</code> if it could not be found.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure findByPrimaryKey(long authProcedureId)
		throws NoSuchAuthProcedureException {

		return findByPrimaryKey((Serializable)authProcedureId);
	}

	/**
	 * Returns the auth procedure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure, or <code>null</code> if a auth procedure with the primary key could not be found
	 */
	@Override
	public AuthProcedure fetchByPrimaryKey(long authProcedureId) {
		return fetchByPrimaryKey((Serializable)authProcedureId);
	}

	/**
	 * Returns all the auth procedures.
	 *
	 * @return the auth procedures
	 */
	@Override
	public List<AuthProcedure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of auth procedures
	 */
	@Override
	public List<AuthProcedure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auth procedures
	 */
	@Override
	public List<AuthProcedure> findAll(
		int start, int end,
		OrderByComparator<AuthProcedure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auth procedures
	 */
	@Override
	public List<AuthProcedure> findAll(
		int start, int end, OrderByComparator<AuthProcedure> orderByComparator,
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

		List<AuthProcedure> list = null;

		if (useFinderCache) {
			list = (List<AuthProcedure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUTHPROCEDURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHPROCEDURE;

				sql = sql.concat(AuthProcedureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AuthProcedure>)QueryUtil.list(
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
	 * Removes all the auth procedures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AuthProcedure authProcedure : findAll()) {
			remove(authProcedure);
		}
	}

	/**
	 * Returns the number of auth procedures.
	 *
	 * @return the number of auth procedures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUTHPROCEDURE);

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
		return "authProcedureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUTHPROCEDURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuthProcedureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the auth procedure persistence.
	 */
	@Activate
	public void activate() {
		AuthProcedureModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AuthProcedureModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByAuthNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAuthNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthNumber",
			new String[] {String.class.getName()},
			AuthProcedureModelImpl.AUTHNUMBER_COLUMN_BITMASK);

		_finderPathCountByAuthNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthNumber",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByExtAuthorizationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExtAuthorizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByExtAuthorizationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByExtAuthorizationId", new String[] {Long.class.getName()},
			AuthProcedureModelImpl.EXTERNALAUTHORIZATIONID_COLUMN_BITMASK);

		_finderPathCountByExtAuthorizationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExtAuthorizationId", new String[] {Long.class.getName()});

		_finderPathFetchByA_M = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AuthProcedureImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_M",
			new String[] {String.class.getName(), String.class.getName()},
			AuthProcedureModelImpl.AUTHNUMBER_COLUMN_BITMASK |
			AuthProcedureModelImpl.MEDICALCODEID_COLUMN_BITMASK);

		_finderPathCountByA_M = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_M",
			new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AuthProcedureImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.AuthProcedure"),
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

	private static final String _SQL_SELECT_AUTHPROCEDURE =
		"SELECT authProcedure FROM AuthProcedure authProcedure";

	private static final String _SQL_SELECT_AUTHPROCEDURE_WHERE =
		"SELECT authProcedure FROM AuthProcedure authProcedure WHERE ";

	private static final String _SQL_COUNT_AUTHPROCEDURE =
		"SELECT COUNT(authProcedure) FROM AuthProcedure authProcedure";

	private static final String _SQL_COUNT_AUTHPROCEDURE_WHERE =
		"SELECT COUNT(authProcedure) FROM AuthProcedure authProcedure WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "authProcedure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AuthProcedure exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AuthProcedure exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuthProcedurePersistenceImpl.class);

}