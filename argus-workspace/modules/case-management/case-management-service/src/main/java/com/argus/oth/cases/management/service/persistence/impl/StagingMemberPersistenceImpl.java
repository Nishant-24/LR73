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

import com.argus.oth.cases.management.exception.NoSuchStagingMemberException;
import com.argus.oth.cases.management.model.StagingMember;
import com.argus.oth.cases.management.model.impl.StagingMemberImpl;
import com.argus.oth.cases.management.model.impl.StagingMemberModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingMemberPersistence;
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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the staging member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingMemberPersistence.class)
public class StagingMemberPersistenceImpl
	extends BasePersistenceImpl<StagingMember>
	implements StagingMemberPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingMemberUtil</code> to access the staging member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingMemberImpl.class.getName();

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
	 * Returns the staging member where externalMemberId = &#63; or throws a <code>NoSuchStagingMemberException</code> if it could not be found.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching staging member
	 * @throws NoSuchStagingMemberException if a matching staging member could not be found
	 */
	@Override
	public StagingMember findByExternalMemberId(long externalMemberId)
		throws NoSuchStagingMemberException {

		StagingMember stagingMember = fetchByExternalMemberId(externalMemberId);

		if (stagingMember == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalMemberId=");
			sb.append(externalMemberId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStagingMemberException(sb.toString());
		}

		return stagingMember;
	}

	/**
	 * Returns the staging member where externalMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @return the matching staging member, or <code>null</code> if a matching staging member could not be found
	 */
	@Override
	public StagingMember fetchByExternalMemberId(long externalMemberId) {
		return fetchByExternalMemberId(externalMemberId, true);
	}

	/**
	 * Returns the staging member where externalMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalMemberId the external member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging member, or <code>null</code> if a matching staging member could not be found
	 */
	@Override
	public StagingMember fetchByExternalMemberId(
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

		if (result instanceof StagingMember) {
			StagingMember stagingMember = (StagingMember)result;

			if (externalMemberId != stagingMember.getExternalMemberId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STAGINGMEMBER_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALMEMBERID_EXTERNALMEMBERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalMemberId);

				List<StagingMember> list = query.list();

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
								"StagingMemberPersistenceImpl.fetchByExternalMemberId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StagingMember stagingMember = list.get(0);

					result = stagingMember;

					cacheResult(stagingMember);
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
			return (StagingMember)result;
		}
	}

	/**
	 * Removes the staging member where externalMemberId = &#63; from the database.
	 *
	 * @param externalMemberId the external member ID
	 * @return the staging member that was removed
	 */
	@Override
	public StagingMember removeByExternalMemberId(long externalMemberId)
		throws NoSuchStagingMemberException {

		StagingMember stagingMember = findByExternalMemberId(externalMemberId);

		return remove(stagingMember);
	}

	/**
	 * Returns the number of staging members where externalMemberId = &#63;.
	 *
	 * @param externalMemberId the external member ID
	 * @return the number of matching staging members
	 */
	@Override
	public int countByExternalMemberId(long externalMemberId) {
		FinderPath finderPath = _finderPathCountByExternalMemberId;

		Object[] finderArgs = new Object[] {externalMemberId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGMEMBER_WHERE);

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
			"stagingMember.externalMemberId = ?";

	public StagingMemberPersistenceImpl() {
		setModelClass(StagingMember.class);

		setModelImplClass(StagingMemberImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging member in the entity cache if it is enabled.
	 *
	 * @param stagingMember the staging member
	 */
	@Override
	public void cacheResult(StagingMember stagingMember) {
		entityCache.putResult(
			entityCacheEnabled, StagingMemberImpl.class,
			stagingMember.getPrimaryKey(), stagingMember);

		finderCache.putResult(
			_finderPathFetchByExternalMemberId,
			new Object[] {stagingMember.getExternalMemberId()}, stagingMember);

		stagingMember.resetOriginalValues();
	}

	/**
	 * Caches the staging members in the entity cache if it is enabled.
	 *
	 * @param stagingMembers the staging members
	 */
	@Override
	public void cacheResult(List<StagingMember> stagingMembers) {
		for (StagingMember stagingMember : stagingMembers) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingMemberImpl.class,
					stagingMember.getPrimaryKey()) == null) {

				cacheResult(stagingMember);
			}
			else {
				stagingMember.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging members.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingMemberImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging member.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingMember stagingMember) {
		entityCache.removeResult(
			entityCacheEnabled, StagingMemberImpl.class,
			stagingMember.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StagingMemberModelImpl)stagingMember, true);
	}

	@Override
	public void clearCache(List<StagingMember> stagingMembers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingMember stagingMember : stagingMembers) {
			entityCache.removeResult(
				entityCacheEnabled, StagingMemberImpl.class,
				stagingMember.getPrimaryKey());

			clearUniqueFindersCache(
				(StagingMemberModelImpl)stagingMember, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingMemberImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StagingMemberModelImpl stagingMemberModelImpl) {

		Object[] args = new Object[] {
			stagingMemberModelImpl.getExternalMemberId()
		};

		finderCache.putResult(
			_finderPathCountByExternalMemberId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalMemberId, args, stagingMemberModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		StagingMemberModelImpl stagingMemberModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				stagingMemberModelImpl.getExternalMemberId()
			};

			finderCache.removeResult(_finderPathCountByExternalMemberId, args);
			finderCache.removeResult(_finderPathFetchByExternalMemberId, args);
		}

		if ((stagingMemberModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalMemberId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				stagingMemberModelImpl.getOriginalExternalMemberId()
			};

			finderCache.removeResult(_finderPathCountByExternalMemberId, args);
			finderCache.removeResult(_finderPathFetchByExternalMemberId, args);
		}
	}

	/**
	 * Creates a new staging member with the primary key. Does not add the staging member to the database.
	 *
	 * @param stagingMemberId the primary key for the new staging member
	 * @return the new staging member
	 */
	@Override
	public StagingMember create(long stagingMemberId) {
		StagingMember stagingMember = new StagingMemberImpl();

		stagingMember.setNew(true);
		stagingMember.setPrimaryKey(stagingMemberId);

		return stagingMember;
	}

	/**
	 * Removes the staging member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member that was removed
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	@Override
	public StagingMember remove(long stagingMemberId)
		throws NoSuchStagingMemberException {

		return remove((Serializable)stagingMemberId);
	}

	/**
	 * Removes the staging member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging member
	 * @return the staging member that was removed
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	@Override
	public StagingMember remove(Serializable primaryKey)
		throws NoSuchStagingMemberException {

		Session session = null;

		try {
			session = openSession();

			StagingMember stagingMember = (StagingMember)session.get(
				StagingMemberImpl.class, primaryKey);

			if (stagingMember == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingMemberException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingMember);
		}
		catch (NoSuchStagingMemberException noSuchEntityException) {
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
	protected StagingMember removeImpl(StagingMember stagingMember) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingMember)) {
				stagingMember = (StagingMember)session.get(
					StagingMemberImpl.class, stagingMember.getPrimaryKeyObj());
			}

			if (stagingMember != null) {
				session.delete(stagingMember);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingMember != null) {
			clearCache(stagingMember);
		}

		return stagingMember;
	}

	@Override
	public StagingMember updateImpl(StagingMember stagingMember) {
		boolean isNew = stagingMember.isNew();

		if (!(stagingMember instanceof StagingMemberModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingMember.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingMember);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingMember proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingMember implementation " +
					stagingMember.getClass());
		}

		StagingMemberModelImpl stagingMemberModelImpl =
			(StagingMemberModelImpl)stagingMember;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingMember.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingMember.setCreateDate(now);
			}
			else {
				stagingMember.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!stagingMemberModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingMember.setModifiedDate(now);
			}
			else {
				stagingMember.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingMember);

				stagingMember.setNew(false);
			}
			else {
				stagingMember = (StagingMember)session.merge(stagingMember);
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
			entityCacheEnabled, StagingMemberImpl.class,
			stagingMember.getPrimaryKey(), stagingMember, false);

		clearUniqueFindersCache(stagingMemberModelImpl, false);
		cacheUniqueFindersCache(stagingMemberModelImpl);

		stagingMember.resetOriginalValues();

		return stagingMember;
	}

	/**
	 * Returns the staging member with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging member
	 * @return the staging member
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	@Override
	public StagingMember findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingMemberException {

		StagingMember stagingMember = fetchByPrimaryKey(primaryKey);

		if (stagingMember == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingMemberException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingMember;
	}

	/**
	 * Returns the staging member with the primary key or throws a <code>NoSuchStagingMemberException</code> if it could not be found.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member
	 * @throws NoSuchStagingMemberException if a staging member with the primary key could not be found
	 */
	@Override
	public StagingMember findByPrimaryKey(long stagingMemberId)
		throws NoSuchStagingMemberException {

		return findByPrimaryKey((Serializable)stagingMemberId);
	}

	/**
	 * Returns the staging member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingMemberId the primary key of the staging member
	 * @return the staging member, or <code>null</code> if a staging member with the primary key could not be found
	 */
	@Override
	public StagingMember fetchByPrimaryKey(long stagingMemberId) {
		return fetchByPrimaryKey((Serializable)stagingMemberId);
	}

	/**
	 * Returns all the staging members.
	 *
	 * @return the staging members
	 */
	@Override
	public List<StagingMember> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @return the range of staging members
	 */
	@Override
	public List<StagingMember> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging members
	 */
	@Override
	public List<StagingMember> findAll(
		int start, int end,
		OrderByComparator<StagingMember> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingMemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging members
	 * @param end the upper bound of the range of staging members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging members
	 */
	@Override
	public List<StagingMember> findAll(
		int start, int end, OrderByComparator<StagingMember> orderByComparator,
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

		List<StagingMember> list = null;

		if (useFinderCache) {
			list = (List<StagingMember>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGMEMBER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGMEMBER;

				sql = sql.concat(StagingMemberModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingMember>)QueryUtil.list(
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
	 * Removes all the staging members from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingMember stagingMember : findAll()) {
			remove(stagingMember);
		}
	}

	/**
	 * Returns the number of staging members.
	 *
	 * @return the number of staging members
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGINGMEMBER);

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
		return "stagingMemberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGMEMBER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingMemberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging member persistence.
	 */
	@Activate
	public void activate() {
		StagingMemberModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingMemberModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByExternalMemberId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingMemberImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalMemberId",
			new String[] {Long.class.getName()},
			StagingMemberModelImpl.EXTERNALMEMBERID_COLUMN_BITMASK);

		_finderPathCountByExternalMemberId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalMemberId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingMemberImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingMember"),
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

	private static final String _SQL_SELECT_STAGINGMEMBER =
		"SELECT stagingMember FROM StagingMember stagingMember";

	private static final String _SQL_SELECT_STAGINGMEMBER_WHERE =
		"SELECT stagingMember FROM StagingMember stagingMember WHERE ";

	private static final String _SQL_COUNT_STAGINGMEMBER =
		"SELECT COUNT(stagingMember) FROM StagingMember stagingMember";

	private static final String _SQL_COUNT_STAGINGMEMBER_WHERE =
		"SELECT COUNT(stagingMember) FROM StagingMember stagingMember WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingMember.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingMember exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StagingMember exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingMemberPersistenceImpl.class);

}