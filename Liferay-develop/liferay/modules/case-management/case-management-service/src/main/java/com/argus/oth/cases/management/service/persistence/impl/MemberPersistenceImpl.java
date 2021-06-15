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

import com.argus.oth.cases.management.exception.NoSuchMemberException;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.model.impl.MemberImpl;
import com.argus.oth.cases.management.model.impl.MemberModelImpl;
import com.argus.oth.cases.management.service.persistence.MemberPersistence;
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
 * The persistence implementation for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MemberPersistence.class)
public class MemberPersistenceImpl
	extends BasePersistenceImpl<Member> implements MemberPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MemberUtil</code> to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MemberImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByExternalMemberId;
	private FinderPath _finderPathCountByExternalMemberId;

	/**
	 * Returns the member where externalMemberId = &#63; or throws a <code>NoSuchMemberException</code> if it could not be found.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	@Override
	public Member findByExternalMemberId(long externalMemberId)
		throws NoSuchMemberException {

		Member member = fetchByExternalMemberId(externalMemberId);

		if (member == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalMemberId=");
			sb.append(externalMemberId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMemberException(sb.toString());
		}

		return member;
	}

	/**
	 * Returns the member where externalMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public Member fetchByExternalMemberId(long externalMemberId) {
		return fetchByExternalMemberId(externalMemberId, true);
	}

	/**
	 * Returns the member where externalMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public Member fetchByExternalMemberId(
		long externalMemberId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalMemberId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalMemberId, finderArgs, this);
		}

		if (result instanceof Member) {
			Member member = (Member)result;

			if (externalMemberId != member.getExternalMemberId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MEMBER__WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALMEMBERID_EXTERNALMEMBERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalMemberId);

				List<Member> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalMemberId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {externalMemberId};
							}

							_log.warn(
								"MemberPersistenceImpl.fetchByExternalMemberId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Member member = list.get(0);

					result = member;

					cacheResult(member);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalMemberId, finderArgs);
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
			return (Member)result;
		}
	}

	/**
	 * Removes the member where externalMemberId = &#63; from the database.
	 *
	 * @param externalMemberId the external member ID
	 * @return the member that was removed
	 */
	@Override
	public Member removeByExternalMemberId(long externalMemberId)
		throws NoSuchMemberException {

		Member member = findByExternalMemberId(externalMemberId);

		return remove(member);
	}

	/**
	 * Returns the number of members where externalMemberId = &#63;.
	 *
	 * @param externalMemberId the external member ID
	 * @return the number of matching members
	 */
	@Override
	public int countByExternalMemberId(long externalMemberId) {
		FinderPath finderPath = _finderPathCountByExternalMemberId;

		Object[] finderArgs = new Object[] {externalMemberId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEMBER__WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALMEMBERID_EXTERNALMEMBERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalMemberId);

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
		_FINDER_COLUMN_EXTERNALMEMBERID_EXTERNALMEMBERID_2 =
			"member_.externalMemberId = ?";

	private FinderPath _finderPathWithPaginationFindByRowProcessed;
	private FinderPath _finderPathWithPaginationCountByRowProcessed;

	/**
	 * Returns all the members where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching members
	 */
	@Override
	public List<Member> findByRowProcessed(String rowProcessed) {
		return findByRowProcessed(
			rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	@Override
	public List<Member> findByRowProcessed(
		String rowProcessed, int start, int end) {

		return findByRowProcessed(rowProcessed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the members where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	@Override
	public List<Member> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Member> orderByComparator) {

		return findByRowProcessed(
			rowProcessed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the members where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	@Override
	public List<Member> findByRowProcessed(
		String rowProcessed, int start, int end,
		OrderByComparator<Member> orderByComparator, boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed;
		finderArgs = new Object[] {rowProcessed, start, end, orderByComparator};

		List<Member> list = null;

		if (useFinderCache) {
			list = (List<Member>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Member member : list) {
					if (rowProcessed.equals(member.getRowProcessed())) {
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

			sb.append(_SQL_SELECT_MEMBER__WHERE);

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
				sb.append(MemberModelImpl.ORDER_BY_JPQL);
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

				list = (List<Member>)QueryUtil.list(
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
	 * Returns the first member in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	@Override
	public Member findByRowProcessed_First(
			String rowProcessed, OrderByComparator<Member> orderByComparator)
		throws NoSuchMemberException {

		Member member = fetchByRowProcessed_First(
			rowProcessed, orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchMemberException(sb.toString());
	}

	/**
	 * Returns the first member in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public Member fetchByRowProcessed_First(
		String rowProcessed, OrderByComparator<Member> orderByComparator) {

		List<Member> list = findByRowProcessed(
			rowProcessed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last member in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	@Override
	public Member findByRowProcessed_Last(
			String rowProcessed, OrderByComparator<Member> orderByComparator)
		throws NoSuchMemberException {

		Member member = fetchByRowProcessed_Last(
			rowProcessed, orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append("}");

		throw new NoSuchMemberException(sb.toString());
	}

	/**
	 * Returns the last member in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public Member fetchByRowProcessed_Last(
		String rowProcessed, OrderByComparator<Member> orderByComparator) {

		int count = countByRowProcessed(rowProcessed);

		if (count == 0) {
			return null;
		}

		List<Member> list = findByRowProcessed(
			rowProcessed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the members before and after the current member in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member[] findByRowProcessed_PrevAndNext(
			long memberId, String rowProcessed,
			OrderByComparator<Member> orderByComparator)
		throws NoSuchMemberException {

		rowProcessed = Objects.toString(rowProcessed, "");

		Member member = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			Member[] array = new MemberImpl[3];

			array[0] = getByRowProcessed_PrevAndNext(
				session, member, rowProcessed, orderByComparator, true);

			array[1] = member;

			array[2] = getByRowProcessed_PrevAndNext(
				session, member, rowProcessed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Member getByRowProcessed_PrevAndNext(
		Session session, Member member, String rowProcessed,
		OrderByComparator<Member> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEMBER__WHERE);

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
			sb.append(MemberModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(member)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Member> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the members where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	@Override
	public void removeByRowProcessed(String rowProcessed) {
		for (Member member :
				findByRowProcessed(
					rowProcessed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(member);
		}
	}

	/**
	 * Returns the number of members where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching members
	 */
	@Override
	public int countByRowProcessed(String rowProcessed) {
		rowProcessed = Objects.toString(rowProcessed, "");

		FinderPath finderPath = _finderPathWithPaginationCountByRowProcessed;

		Object[] finderArgs = new Object[] {rowProcessed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEMBER__WHERE);

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
		"member_.rowProcessed != ?";

	private static final String _FINDER_COLUMN_ROWPROCESSED_ROWPROCESSED_3 =
		"(member_.rowProcessed IS NULL OR member_.rowProcessed != '')";

	public MemberPersistenceImpl() {
		setModelClass(Member.class);

		setModelImplClass(MemberImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	@Override
	public void cacheResult(Member member) {
		entityCache.putResult(
			entityCacheEnabled, MemberImpl.class, member.getPrimaryKey(),
			member);

		finderCache.putResult(
			_finderPathFetchByExternalMemberId,
			new Object[] {member.getExternalMemberId()}, member);

		member.resetOriginalValues();
	}

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	@Override
	public void cacheResult(List<Member> members) {
		for (Member member : members) {
			if (entityCache.getResult(
					entityCacheEnabled, MemberImpl.class,
					member.getPrimaryKey()) == null) {

				cacheResult(member);
			}
			else {
				member.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all members.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MemberImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Member member) {
		entityCache.removeResult(
			entityCacheEnabled, MemberImpl.class, member.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MemberModelImpl)member, true);
	}

	@Override
	public void clearCache(List<Member> members) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Member member : members) {
			entityCache.removeResult(
				entityCacheEnabled, MemberImpl.class, member.getPrimaryKey());

			clearUniqueFindersCache((MemberModelImpl)member, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, MemberImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(MemberModelImpl memberModelImpl) {
		Object[] args = new Object[] {memberModelImpl.getExternalMemberId()};

		finderCache.putResult(
			_finderPathCountByExternalMemberId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalMemberId, args, memberModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MemberModelImpl memberModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				memberModelImpl.getExternalMemberId()
			};

			finderCache.removeResult(_finderPathCountByExternalMemberId, args);
			finderCache.removeResult(_finderPathFetchByExternalMemberId, args);
		}

		if ((memberModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalMemberId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				memberModelImpl.getOriginalExternalMemberId()
			};

			finderCache.removeResult(_finderPathCountByExternalMemberId, args);
			finderCache.removeResult(_finderPathFetchByExternalMemberId, args);
		}
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	@Override
	public Member create(long memberId) {
		Member member = new MemberImpl();

		member.setNew(true);
		member.setPrimaryKey(memberId);

		member.setCompanyId(CompanyThreadLocal.getCompanyId());

		return member;
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member remove(long memberId) throws NoSuchMemberException {
		return remove((Serializable)memberId);
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member remove(Serializable primaryKey) throws NoSuchMemberException {
		Session session = null;

		try {
			session = openSession();

			Member member = (Member)session.get(MemberImpl.class, primaryKey);

			if (member == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(member);
		}
		catch (NoSuchMemberException noSuchEntityException) {
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
	protected Member removeImpl(Member member) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(member)) {
				member = (Member)session.get(
					MemberImpl.class, member.getPrimaryKeyObj());
			}

			if (member != null) {
				session.delete(member);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (member != null) {
			clearCache(member);
		}

		return member;
	}

	@Override
	public Member updateImpl(Member member) {
		boolean isNew = member.isNew();

		if (!(member instanceof MemberModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(member.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(member);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in member proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Member implementation " +
					member.getClass());
		}

		MemberModelImpl memberModelImpl = (MemberModelImpl)member;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (member.getCreateDate() == null)) {
			if (serviceContext == null) {
				member.setCreateDate(now);
			}
			else {
				member.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!memberModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				member.setModifiedDate(now);
			}
			else {
				member.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (member.isNew()) {
				session.save(member);

				member.setNew(false);
			}
			else {
				member = (Member)session.merge(member);
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
			entityCacheEnabled, MemberImpl.class, member.getPrimaryKey(),
			member, false);

		clearUniqueFindersCache(memberModelImpl, false);
		cacheUniqueFindersCache(memberModelImpl);

		member.resetOriginalValues();

		return member;
	}

	/**
	 * Returns the member with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMemberException {

		Member member = fetchByPrimaryKey(primaryKey);

		if (member == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMemberException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return member;
	}

	/**
	 * Returns the member with the primary key or throws a <code>NoSuchMemberException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member findByPrimaryKey(long memberId) throws NoSuchMemberException {
		return findByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 */
	@Override
	public Member fetchByPrimaryKey(long memberId) {
		return fetchByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 */
	@Override
	public List<Member> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 */
	@Override
	public List<Member> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of members
	 */
	@Override
	public List<Member> findAll(
		int start, int end, OrderByComparator<Member> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of members
	 */
	@Override
	public List<Member> findAll(
		int start, int end, OrderByComparator<Member> orderByComparator,
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

		List<Member> list = null;

		if (useFinderCache) {
			list = (List<Member>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MEMBER_);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBER_;

				sql = sql.concat(MemberModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Member>)QueryUtil.list(
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
	 * Removes all the members from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Member member : findAll()) {
			remove(member);
		}
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MEMBER_);

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
		return "memberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MEMBER_;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MemberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the member persistence.
	 */
	@Activate
	public void activate() {
		MemberModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MemberModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByExternalMemberId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MemberImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalMemberId",
			new String[] {Long.class.getName()},
			MemberModelImpl.EXTERNALMEMBERID_COLUMN_BITMASK);

		_finderPathCountByExternalMemberId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalMemberId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRowProcessed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MemberImpl.class,
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
		entityCache.removeCache(MemberImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.Member"),
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

	private static final String _SQL_SELECT_MEMBER_ =
		"SELECT member_ FROM Member member_";

	private static final String _SQL_SELECT_MEMBER__WHERE =
		"SELECT member_ FROM Member member_ WHERE ";

	private static final String _SQL_COUNT_MEMBER_ =
		"SELECT COUNT(member_) FROM Member member_";

	private static final String _SQL_COUNT_MEMBER__WHERE =
		"SELECT COUNT(member_) FROM Member member_ WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "member_.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Member exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Member exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MemberPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}