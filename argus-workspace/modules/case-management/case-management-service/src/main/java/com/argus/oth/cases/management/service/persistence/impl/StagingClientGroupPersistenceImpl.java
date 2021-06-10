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

import com.argus.oth.cases.management.exception.NoSuchStagingClientGroupException;
import com.argus.oth.cases.management.model.StagingClientGroup;
import com.argus.oth.cases.management.model.impl.StagingClientGroupImpl;
import com.argus.oth.cases.management.model.impl.StagingClientGroupModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingClientGroupPersistence;
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
 * The persistence implementation for the staging client group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingClientGroupPersistence.class)
public class StagingClientGroupPersistenceImpl
	extends BasePersistenceImpl<StagingClientGroup>
	implements StagingClientGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingClientGroupUtil</code> to access the staging client group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingClientGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByExternalClientGroupId;
	private FinderPath _finderPathCountByExternalClientGroupId;

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or throws a <code>NoSuchStagingClientGroupException</code> if it could not be found.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching staging client group
	 * @throws NoSuchStagingClientGroupException if a matching staging client group could not be found
	 */
	@Override
	public StagingClientGroup findByExternalClientGroupId(
			long externalClientGroupId)
		throws NoSuchStagingClientGroupException {

		StagingClientGroup stagingClientGroup = fetchByExternalClientGroupId(
			externalClientGroupId);

		if (stagingClientGroup == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalClientGroupId=");
			sb.append(externalClientGroupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStagingClientGroupException(sb.toString());
		}

		return stagingClientGroup;
	}

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the matching staging client group, or <code>null</code> if a matching staging client group could not be found
	 */
	@Override
	public StagingClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId) {

		return fetchByExternalClientGroupId(externalClientGroupId, true);
	}

	/**
	 * Returns the staging client group where externalClientGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching staging client group, or <code>null</code> if a matching staging client group could not be found
	 */
	@Override
	public StagingClientGroup fetchByExternalClientGroupId(
		long externalClientGroupId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalClientGroupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalClientGroupId, finderArgs, this);
		}

		if (result instanceof StagingClientGroup) {
			StagingClientGroup stagingClientGroup = (StagingClientGroup)result;

			if (externalClientGroupId !=
					stagingClientGroup.getExternalClientGroupId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STAGINGCLIENTGROUP_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTERNALCLIENTGROUPID_EXTERNALCLIENTGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientGroupId);

				List<StagingClientGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalClientGroupId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									externalClientGroupId
								};
							}

							_log.warn(
								"StagingClientGroupPersistenceImpl.fetchByExternalClientGroupId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StagingClientGroup stagingClientGroup = list.get(0);

					result = stagingClientGroup;

					cacheResult(stagingClientGroup);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalClientGroupId, finderArgs);
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
			return (StagingClientGroup)result;
		}
	}

	/**
	 * Removes the staging client group where externalClientGroupId = &#63; from the database.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the staging client group that was removed
	 */
	@Override
	public StagingClientGroup removeByExternalClientGroupId(
			long externalClientGroupId)
		throws NoSuchStagingClientGroupException {

		StagingClientGroup stagingClientGroup = findByExternalClientGroupId(
			externalClientGroupId);

		return remove(stagingClientGroup);
	}

	/**
	 * Returns the number of staging client groups where externalClientGroupId = &#63;.
	 *
	 * @param externalClientGroupId the external client group ID
	 * @return the number of matching staging client groups
	 */
	@Override
	public int countByExternalClientGroupId(long externalClientGroupId) {
		FinderPath finderPath = _finderPathCountByExternalClientGroupId;

		Object[] finderArgs = new Object[] {externalClientGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGCLIENTGROUP_WHERE);

			sb.append(
				_FINDER_COLUMN_EXTERNALCLIENTGROUPID_EXTERNALCLIENTGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalClientGroupId);

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
		_FINDER_COLUMN_EXTERNALCLIENTGROUPID_EXTERNALCLIENTGROUPID_2 =
			"stagingClientGroup.externalClientGroupId = ?";

	public StagingClientGroupPersistenceImpl() {
		setModelClass(StagingClientGroup.class);

		setModelImplClass(StagingClientGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging client group in the entity cache if it is enabled.
	 *
	 * @param stagingClientGroup the staging client group
	 */
	@Override
	public void cacheResult(StagingClientGroup stagingClientGroup) {
		entityCache.putResult(
			entityCacheEnabled, StagingClientGroupImpl.class,
			stagingClientGroup.getPrimaryKey(), stagingClientGroup);

		finderCache.putResult(
			_finderPathFetchByExternalClientGroupId,
			new Object[] {stagingClientGroup.getExternalClientGroupId()},
			stagingClientGroup);

		stagingClientGroup.resetOriginalValues();
	}

	/**
	 * Caches the staging client groups in the entity cache if it is enabled.
	 *
	 * @param stagingClientGroups the staging client groups
	 */
	@Override
	public void cacheResult(List<StagingClientGroup> stagingClientGroups) {
		for (StagingClientGroup stagingClientGroup : stagingClientGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingClientGroupImpl.class,
					stagingClientGroup.getPrimaryKey()) == null) {

				cacheResult(stagingClientGroup);
			}
			else {
				stagingClientGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging client groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingClientGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging client group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingClientGroup stagingClientGroup) {
		entityCache.removeResult(
			entityCacheEnabled, StagingClientGroupImpl.class,
			stagingClientGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(StagingClientGroupModelImpl)stagingClientGroup, true);
	}

	@Override
	public void clearCache(List<StagingClientGroup> stagingClientGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingClientGroup stagingClientGroup : stagingClientGroups) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClientGroupImpl.class,
				stagingClientGroup.getPrimaryKey());

			clearUniqueFindersCache(
				(StagingClientGroupModelImpl)stagingClientGroup, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClientGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StagingClientGroupModelImpl stagingClientGroupModelImpl) {

		Object[] args = new Object[] {
			stagingClientGroupModelImpl.getExternalClientGroupId()
		};

		finderCache.putResult(
			_finderPathCountByExternalClientGroupId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByExternalClientGroupId, args,
			stagingClientGroupModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StagingClientGroupModelImpl stagingClientGroupModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				stagingClientGroupModelImpl.getExternalClientGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByExternalClientGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByExternalClientGroupId, args);
		}

		if ((stagingClientGroupModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalClientGroupId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				stagingClientGroupModelImpl.getOriginalExternalClientGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByExternalClientGroupId, args);
			finderCache.removeResult(
				_finderPathFetchByExternalClientGroupId, args);
		}
	}

	/**
	 * Creates a new staging client group with the primary key. Does not add the staging client group to the database.
	 *
	 * @param stagingClientGroupId the primary key for the new staging client group
	 * @return the new staging client group
	 */
	@Override
	public StagingClientGroup create(long stagingClientGroupId) {
		StagingClientGroup stagingClientGroup = new StagingClientGroupImpl();

		stagingClientGroup.setNew(true);
		stagingClientGroup.setPrimaryKey(stagingClientGroupId);

		return stagingClientGroup;
	}

	/**
	 * Removes the staging client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group that was removed
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	@Override
	public StagingClientGroup remove(long stagingClientGroupId)
		throws NoSuchStagingClientGroupException {

		return remove((Serializable)stagingClientGroupId);
	}

	/**
	 * Removes the staging client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging client group
	 * @return the staging client group that was removed
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	@Override
	public StagingClientGroup remove(Serializable primaryKey)
		throws NoSuchStagingClientGroupException {

		Session session = null;

		try {
			session = openSession();

			StagingClientGroup stagingClientGroup =
				(StagingClientGroup)session.get(
					StagingClientGroupImpl.class, primaryKey);

			if (stagingClientGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingClientGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingClientGroup);
		}
		catch (NoSuchStagingClientGroupException noSuchEntityException) {
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
	protected StagingClientGroup removeImpl(
		StagingClientGroup stagingClientGroup) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingClientGroup)) {
				stagingClientGroup = (StagingClientGroup)session.get(
					StagingClientGroupImpl.class,
					stagingClientGroup.getPrimaryKeyObj());
			}

			if (stagingClientGroup != null) {
				session.delete(stagingClientGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingClientGroup != null) {
			clearCache(stagingClientGroup);
		}

		return stagingClientGroup;
	}

	@Override
	public StagingClientGroup updateImpl(
		StagingClientGroup stagingClientGroup) {

		boolean isNew = stagingClientGroup.isNew();

		if (!(stagingClientGroup instanceof StagingClientGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingClientGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingClientGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingClientGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingClientGroup implementation " +
					stagingClientGroup.getClass());
		}

		StagingClientGroupModelImpl stagingClientGroupModelImpl =
			(StagingClientGroupModelImpl)stagingClientGroup;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingClientGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingClientGroup.setCreateDate(now);
			}
			else {
				stagingClientGroup.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingClientGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingClientGroup.setModifiedDate(now);
			}
			else {
				stagingClientGroup.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingClientGroup);

				stagingClientGroup.setNew(false);
			}
			else {
				stagingClientGroup = (StagingClientGroup)session.merge(
					stagingClientGroup);
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
			entityCacheEnabled, StagingClientGroupImpl.class,
			stagingClientGroup.getPrimaryKey(), stagingClientGroup, false);

		clearUniqueFindersCache(stagingClientGroupModelImpl, false);
		cacheUniqueFindersCache(stagingClientGroupModelImpl);

		stagingClientGroup.resetOriginalValues();

		return stagingClientGroup;
	}

	/**
	 * Returns the staging client group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging client group
	 * @return the staging client group
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	@Override
	public StagingClientGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingClientGroupException {

		StagingClientGroup stagingClientGroup = fetchByPrimaryKey(primaryKey);

		if (stagingClientGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingClientGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingClientGroup;
	}

	/**
	 * Returns the staging client group with the primary key or throws a <code>NoSuchStagingClientGroupException</code> if it could not be found.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group
	 * @throws NoSuchStagingClientGroupException if a staging client group with the primary key could not be found
	 */
	@Override
	public StagingClientGroup findByPrimaryKey(long stagingClientGroupId)
		throws NoSuchStagingClientGroupException {

		return findByPrimaryKey((Serializable)stagingClientGroupId);
	}

	/**
	 * Returns the staging client group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClientGroupId the primary key of the staging client group
	 * @return the staging client group, or <code>null</code> if a staging client group with the primary key could not be found
	 */
	@Override
	public StagingClientGroup fetchByPrimaryKey(long stagingClientGroupId) {
		return fetchByPrimaryKey((Serializable)stagingClientGroupId);
	}

	/**
	 * Returns all the staging client groups.
	 *
	 * @return the staging client groups
	 */
	@Override
	public List<StagingClientGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @return the range of staging client groups
	 */
	@Override
	public List<StagingClientGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging client groups
	 */
	@Override
	public List<StagingClientGroup> findAll(
		int start, int end,
		OrderByComparator<StagingClientGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging client groups
	 * @param end the upper bound of the range of staging client groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging client groups
	 */
	@Override
	public List<StagingClientGroup> findAll(
		int start, int end,
		OrderByComparator<StagingClientGroup> orderByComparator,
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

		List<StagingClientGroup> list = null;

		if (useFinderCache) {
			list = (List<StagingClientGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGCLIENTGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGCLIENTGROUP;

				sql = sql.concat(StagingClientGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingClientGroup>)QueryUtil.list(
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
	 * Removes all the staging client groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingClientGroup stagingClientGroup : findAll()) {
			remove(stagingClientGroup);
		}
	}

	/**
	 * Returns the number of staging client groups.
	 *
	 * @return the number of staging client groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_STAGINGCLIENTGROUP);

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
		return "stagingClientGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGCLIENTGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingClientGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging client group persistence.
	 */
	@Activate
	public void activate() {
		StagingClientGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingClientGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClientGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClientGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByExternalClientGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClientGroupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByExternalClientGroupId", new String[] {Long.class.getName()},
			StagingClientGroupModelImpl.EXTERNALCLIENTGROUPID_COLUMN_BITMASK);

		_finderPathCountByExternalClientGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExternalClientGroupId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingClientGroupImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingClientGroup"),
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

	private static final String _SQL_SELECT_STAGINGCLIENTGROUP =
		"SELECT stagingClientGroup FROM StagingClientGroup stagingClientGroup";

	private static final String _SQL_SELECT_STAGINGCLIENTGROUP_WHERE =
		"SELECT stagingClientGroup FROM StagingClientGroup stagingClientGroup WHERE ";

	private static final String _SQL_COUNT_STAGINGCLIENTGROUP =
		"SELECT COUNT(stagingClientGroup) FROM StagingClientGroup stagingClientGroup";

	private static final String _SQL_COUNT_STAGINGCLIENTGROUP_WHERE =
		"SELECT COUNT(stagingClientGroup) FROM StagingClientGroup stagingClientGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingClientGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingClientGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StagingClientGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingClientGroupPersistenceImpl.class);

}