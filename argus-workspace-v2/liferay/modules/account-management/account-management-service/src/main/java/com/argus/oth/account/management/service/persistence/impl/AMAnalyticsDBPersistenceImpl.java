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

package com.argus.oth.account.management.service.persistence.impl;

import com.argus.oth.account.management.exception.NoSuchAMAnalyticsDBException;
import com.argus.oth.account.management.model.AMAnalyticsDB;
import com.argus.oth.account.management.model.impl.AMAnalyticsDBImpl;
import com.argus.oth.account.management.model.impl.AMAnalyticsDBModelImpl;
import com.argus.oth.account.management.service.persistence.AMAnalyticsDBPersistence;
import com.argus.oth.account.management.service.persistence.impl.constants.OTH_AccountPersistenceConstants;

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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the am analytics db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AMAnalyticsDBPersistence.class)
public class AMAnalyticsDBPersistenceImpl
	extends BasePersistenceImpl<AMAnalyticsDB>
	implements AMAnalyticsDBPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMAnalyticsDBUtil</code> to access the am analytics db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMAnalyticsDBImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByClientId;
	private FinderPath _finderPathCountByClientId;

	/**
	 * Returns the am analytics db where clientId = &#63; or throws a <code>NoSuchAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param clientId the client ID
	 * @return the matching am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a matching am analytics db could not be found
	 */
	@Override
	public AMAnalyticsDB findByClientId(long clientId)
		throws NoSuchAMAnalyticsDBException {

		AMAnalyticsDB amAnalyticsDB = fetchByClientId(clientId);

		if (amAnalyticsDB == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("clientId=");
			sb.append(clientId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAMAnalyticsDBException(sb.toString());
		}

		return amAnalyticsDB;
	}

	/**
	 * Returns the am analytics db where clientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientId the client ID
	 * @return the matching am analytics db, or <code>null</code> if a matching am analytics db could not be found
	 */
	@Override
	public AMAnalyticsDB fetchByClientId(long clientId) {
		return fetchByClientId(clientId, true);
	}

	/**
	 * Returns the am analytics db where clientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientId the client ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching am analytics db, or <code>null</code> if a matching am analytics db could not be found
	 */
	@Override
	public AMAnalyticsDB fetchByClientId(
		long clientId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {clientId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByClientId, finderArgs, this);
		}

		if (result instanceof AMAnalyticsDB) {
			AMAnalyticsDB amAnalyticsDB = (AMAnalyticsDB)result;

			if (clientId != amAnalyticsDB.getClientId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AMANALYTICSDB_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientId);

				List<AMAnalyticsDB> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByClientId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {clientId};
							}

							_log.warn(
								"AMAnalyticsDBPersistenceImpl.fetchByClientId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AMAnalyticsDB amAnalyticsDB = list.get(0);

					result = amAnalyticsDB;

					cacheResult(amAnalyticsDB);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByClientId, finderArgs);
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
			return (AMAnalyticsDB)result;
		}
	}

	/**
	 * Removes the am analytics db where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @return the am analytics db that was removed
	 */
	@Override
	public AMAnalyticsDB removeByClientId(long clientId)
		throws NoSuchAMAnalyticsDBException {

		AMAnalyticsDB amAnalyticsDB = findByClientId(clientId);

		return remove(amAnalyticsDB);
	}

	/**
	 * Returns the number of am analytics dbs where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching am analytics dbs
	 */
	@Override
	public int countByClientId(long clientId) {
		FinderPath finderPath = _finderPathCountByClientId;

		Object[] finderArgs = new Object[] {clientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMANALYTICSDB_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientId);

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

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_2 =
		"amAnalyticsDB.clientId = ?";

	public AMAnalyticsDBPersistenceImpl() {
		setModelClass(AMAnalyticsDB.class);

		setModelImplClass(AMAnalyticsDBImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the am analytics db in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsDB the am analytics db
	 */
	@Override
	public void cacheResult(AMAnalyticsDB amAnalyticsDB) {
		entityCache.putResult(
			entityCacheEnabled, AMAnalyticsDBImpl.class,
			amAnalyticsDB.getPrimaryKey(), amAnalyticsDB);

		finderCache.putResult(
			_finderPathFetchByClientId,
			new Object[] {amAnalyticsDB.getClientId()}, amAnalyticsDB);

		amAnalyticsDB.resetOriginalValues();
	}

	/**
	 * Caches the am analytics dbs in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsDBs the am analytics dbs
	 */
	@Override
	public void cacheResult(List<AMAnalyticsDB> amAnalyticsDBs) {
		for (AMAnalyticsDB amAnalyticsDB : amAnalyticsDBs) {
			if (entityCache.getResult(
					entityCacheEnabled, AMAnalyticsDBImpl.class,
					amAnalyticsDB.getPrimaryKey()) == null) {

				cacheResult(amAnalyticsDB);
			}
			else {
				amAnalyticsDB.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all am analytics dbs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMAnalyticsDBImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the am analytics db.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMAnalyticsDB amAnalyticsDB) {
		entityCache.removeResult(
			entityCacheEnabled, AMAnalyticsDBImpl.class,
			amAnalyticsDB.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AMAnalyticsDBModelImpl)amAnalyticsDB, true);
	}

	@Override
	public void clearCache(List<AMAnalyticsDB> amAnalyticsDBs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMAnalyticsDB amAnalyticsDB : amAnalyticsDBs) {
			entityCache.removeResult(
				entityCacheEnabled, AMAnalyticsDBImpl.class,
				amAnalyticsDB.getPrimaryKey());

			clearUniqueFindersCache(
				(AMAnalyticsDBModelImpl)amAnalyticsDB, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AMAnalyticsDBImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AMAnalyticsDBModelImpl amAnalyticsDBModelImpl) {

		Object[] args = new Object[] {amAnalyticsDBModelImpl.getClientId()};

		finderCache.putResult(
			_finderPathCountByClientId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByClientId, args, amAnalyticsDBModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AMAnalyticsDBModelImpl amAnalyticsDBModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {amAnalyticsDBModelImpl.getClientId()};

			finderCache.removeResult(_finderPathCountByClientId, args);
			finderCache.removeResult(_finderPathFetchByClientId, args);
		}

		if ((amAnalyticsDBModelImpl.getColumnBitmask() &
			 _finderPathFetchByClientId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				amAnalyticsDBModelImpl.getOriginalClientId()
			};

			finderCache.removeResult(_finderPathCountByClientId, args);
			finderCache.removeResult(_finderPathFetchByClientId, args);
		}
	}

	/**
	 * Creates a new am analytics db with the primary key. Does not add the am analytics db to the database.
	 *
	 * @param amAnalyticsDbId the primary key for the new am analytics db
	 * @return the new am analytics db
	 */
	@Override
	public AMAnalyticsDB create(long amAnalyticsDbId) {
		AMAnalyticsDB amAnalyticsDB = new AMAnalyticsDBImpl();

		amAnalyticsDB.setNew(true);
		amAnalyticsDB.setPrimaryKey(amAnalyticsDbId);

		amAnalyticsDB.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amAnalyticsDB;
	}

	/**
	 * Removes the am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db that was removed
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	@Override
	public AMAnalyticsDB remove(long amAnalyticsDbId)
		throws NoSuchAMAnalyticsDBException {

		return remove((Serializable)amAnalyticsDbId);
	}

	/**
	 * Removes the am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the am analytics db
	 * @return the am analytics db that was removed
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	@Override
	public AMAnalyticsDB remove(Serializable primaryKey)
		throws NoSuchAMAnalyticsDBException {

		Session session = null;

		try {
			session = openSession();

			AMAnalyticsDB amAnalyticsDB = (AMAnalyticsDB)session.get(
				AMAnalyticsDBImpl.class, primaryKey);

			if (amAnalyticsDB == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMAnalyticsDBException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amAnalyticsDB);
		}
		catch (NoSuchAMAnalyticsDBException noSuchEntityException) {
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
	protected AMAnalyticsDB removeImpl(AMAnalyticsDB amAnalyticsDB) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amAnalyticsDB)) {
				amAnalyticsDB = (AMAnalyticsDB)session.get(
					AMAnalyticsDBImpl.class, amAnalyticsDB.getPrimaryKeyObj());
			}

			if (amAnalyticsDB != null) {
				session.delete(amAnalyticsDB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amAnalyticsDB != null) {
			clearCache(amAnalyticsDB);
		}

		return amAnalyticsDB;
	}

	@Override
	public AMAnalyticsDB updateImpl(AMAnalyticsDB amAnalyticsDB) {
		boolean isNew = amAnalyticsDB.isNew();

		if (!(amAnalyticsDB instanceof AMAnalyticsDBModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amAnalyticsDB.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					amAnalyticsDB);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amAnalyticsDB proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMAnalyticsDB implementation " +
					amAnalyticsDB.getClass());
		}

		AMAnalyticsDBModelImpl amAnalyticsDBModelImpl =
			(AMAnalyticsDBModelImpl)amAnalyticsDB;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amAnalyticsDB.getCreateDate() == null)) {
			if (serviceContext == null) {
				amAnalyticsDB.setCreateDate(now);
			}
			else {
				amAnalyticsDB.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!amAnalyticsDBModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amAnalyticsDB.setModifiedDate(now);
			}
			else {
				amAnalyticsDB.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (amAnalyticsDB.isNew()) {
				session.save(amAnalyticsDB);

				amAnalyticsDB.setNew(false);
			}
			else {
				amAnalyticsDB = (AMAnalyticsDB)session.merge(amAnalyticsDB);
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
			entityCacheEnabled, AMAnalyticsDBImpl.class,
			amAnalyticsDB.getPrimaryKey(), amAnalyticsDB, false);

		clearUniqueFindersCache(amAnalyticsDBModelImpl, false);
		cacheUniqueFindersCache(amAnalyticsDBModelImpl);

		amAnalyticsDB.resetOriginalValues();

		return amAnalyticsDB;
	}

	/**
	 * Returns the am analytics db with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the am analytics db
	 * @return the am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	@Override
	public AMAnalyticsDB findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAMAnalyticsDBException {

		AMAnalyticsDB amAnalyticsDB = fetchByPrimaryKey(primaryKey);

		if (amAnalyticsDB == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAMAnalyticsDBException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amAnalyticsDB;
	}

	/**
	 * Returns the am analytics db with the primary key or throws a <code>NoSuchAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db
	 * @throws NoSuchAMAnalyticsDBException if a am analytics db with the primary key could not be found
	 */
	@Override
	public AMAnalyticsDB findByPrimaryKey(long amAnalyticsDbId)
		throws NoSuchAMAnalyticsDBException {

		return findByPrimaryKey((Serializable)amAnalyticsDbId);
	}

	/**
	 * Returns the am analytics db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db, or <code>null</code> if a am analytics db with the primary key could not be found
	 */
	@Override
	public AMAnalyticsDB fetchByPrimaryKey(long amAnalyticsDbId) {
		return fetchByPrimaryKey((Serializable)amAnalyticsDbId);
	}

	/**
	 * Returns all the am analytics dbs.
	 *
	 * @return the am analytics dbs
	 */
	@Override
	public List<AMAnalyticsDB> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @return the range of am analytics dbs
	 */
	@Override
	public List<AMAnalyticsDB> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics dbs
	 */
	@Override
	public List<AMAnalyticsDB> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsDB> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics dbs
	 */
	@Override
	public List<AMAnalyticsDB> findAll(
		int start, int end, OrderByComparator<AMAnalyticsDB> orderByComparator,
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

		List<AMAnalyticsDB> list = null;

		if (useFinderCache) {
			list = (List<AMAnalyticsDB>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMANALYTICSDB);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMANALYTICSDB;

				sql = sql.concat(AMAnalyticsDBModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AMAnalyticsDB>)QueryUtil.list(
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
	 * Removes all the am analytics dbs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMAnalyticsDB amAnalyticsDB : findAll()) {
			remove(amAnalyticsDB);
		}
	}

	/**
	 * Returns the number of am analytics dbs.
	 *
	 * @return the number of am analytics dbs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMANALYTICSDB);

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
		return "amAnalyticsDbId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMANALYTICSDB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMAnalyticsDBModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the am analytics db persistence.
	 */
	@Activate
	public void activate() {
		AMAnalyticsDBModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AMAnalyticsDBModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMAnalyticsDBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMAnalyticsDBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMAnalyticsDBImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByClientId",
			new String[] {Long.class.getName()},
			AMAnalyticsDBModelImpl.CLIENTID_COLUMN_BITMASK);

		_finderPathCountByClientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMAnalyticsDBImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = OTH_AccountPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.argus.oth.account.management.model.AMAnalyticsDB"),
			true);
	}

	@Override
	@Reference(
		target = OTH_AccountPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OTH_AccountPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_AMANALYTICSDB =
		"SELECT amAnalyticsDB FROM AMAnalyticsDB amAnalyticsDB";

	private static final String _SQL_SELECT_AMANALYTICSDB_WHERE =
		"SELECT amAnalyticsDB FROM AMAnalyticsDB amAnalyticsDB WHERE ";

	private static final String _SQL_COUNT_AMANALYTICSDB =
		"SELECT COUNT(amAnalyticsDB) FROM AMAnalyticsDB amAnalyticsDB";

	private static final String _SQL_COUNT_AMANALYTICSDB_WHERE =
		"SELECT COUNT(amAnalyticsDB) FROM AMAnalyticsDB amAnalyticsDB WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amAnalyticsDB.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMAnalyticsDB exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AMAnalyticsDB exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AMAnalyticsDBPersistenceImpl.class);

	static {
		try {
			Class.forName(OTH_AccountPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}