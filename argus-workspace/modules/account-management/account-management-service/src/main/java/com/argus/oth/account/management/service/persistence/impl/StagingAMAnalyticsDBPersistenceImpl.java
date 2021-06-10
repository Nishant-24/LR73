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

import com.argus.oth.account.management.exception.NoSuchStagingAMAnalyticsDBException;
import com.argus.oth.account.management.model.StagingAMAnalyticsDB;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsDBImpl;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsDBModelImpl;
import com.argus.oth.account.management.service.persistence.StagingAMAnalyticsDBPersistence;
import com.argus.oth.account.management.service.persistence.impl.constants.OTH_AccountPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the staging am analytics db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingAMAnalyticsDBPersistence.class)
public class StagingAMAnalyticsDBPersistenceImpl
	extends BasePersistenceImpl<StagingAMAnalyticsDB>
	implements StagingAMAnalyticsDBPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingAMAnalyticsDBUtil</code> to access the staging am analytics db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingAMAnalyticsDBImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingAMAnalyticsDBPersistenceImpl() {
		setModelClass(StagingAMAnalyticsDB.class);

		setModelImplClass(StagingAMAnalyticsDBImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging am analytics db in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 */
	@Override
	public void cacheResult(StagingAMAnalyticsDB stagingAMAnalyticsDB) {
		entityCache.putResult(
			entityCacheEnabled, StagingAMAnalyticsDBImpl.class,
			stagingAMAnalyticsDB.getPrimaryKey(), stagingAMAnalyticsDB);

		stagingAMAnalyticsDB.resetOriginalValues();
	}

	/**
	 * Caches the staging am analytics dbs in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsDBs the staging am analytics dbs
	 */
	@Override
	public void cacheResult(List<StagingAMAnalyticsDB> stagingAMAnalyticsDBs) {
		for (StagingAMAnalyticsDB stagingAMAnalyticsDB :
				stagingAMAnalyticsDBs) {

			if (entityCache.getResult(
					entityCacheEnabled, StagingAMAnalyticsDBImpl.class,
					stagingAMAnalyticsDB.getPrimaryKey()) == null) {

				cacheResult(stagingAMAnalyticsDB);
			}
			else {
				stagingAMAnalyticsDB.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging am analytics dbs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingAMAnalyticsDBImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging am analytics db.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingAMAnalyticsDB stagingAMAnalyticsDB) {
		entityCache.removeResult(
			entityCacheEnabled, StagingAMAnalyticsDBImpl.class,
			stagingAMAnalyticsDB.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingAMAnalyticsDB> stagingAMAnalyticsDBs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingAMAnalyticsDB stagingAMAnalyticsDB :
				stagingAMAnalyticsDBs) {

			entityCache.removeResult(
				entityCacheEnabled, StagingAMAnalyticsDBImpl.class,
				stagingAMAnalyticsDB.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingAMAnalyticsDBImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging am analytics db with the primary key. Does not add the staging am analytics db to the database.
	 *
	 * @param stagingAMAnalyticsDbId the primary key for the new staging am analytics db
	 * @return the new staging am analytics db
	 */
	@Override
	public StagingAMAnalyticsDB create(long stagingAMAnalyticsDbId) {
		StagingAMAnalyticsDB stagingAMAnalyticsDB =
			new StagingAMAnalyticsDBImpl();

		stagingAMAnalyticsDB.setNew(true);
		stagingAMAnalyticsDB.setPrimaryKey(stagingAMAnalyticsDbId);

		return stagingAMAnalyticsDB;
	}

	/**
	 * Removes the staging am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db that was removed
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsDB remove(long stagingAMAnalyticsDbId)
		throws NoSuchStagingAMAnalyticsDBException {

		return remove((Serializable)stagingAMAnalyticsDbId);
	}

	/**
	 * Removes the staging am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging am analytics db
	 * @return the staging am analytics db that was removed
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsDB remove(Serializable primaryKey)
		throws NoSuchStagingAMAnalyticsDBException {

		Session session = null;

		try {
			session = openSession();

			StagingAMAnalyticsDB stagingAMAnalyticsDB =
				(StagingAMAnalyticsDB)session.get(
					StagingAMAnalyticsDBImpl.class, primaryKey);

			if (stagingAMAnalyticsDB == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingAMAnalyticsDBException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingAMAnalyticsDB);
		}
		catch (NoSuchStagingAMAnalyticsDBException noSuchEntityException) {
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
	protected StagingAMAnalyticsDB removeImpl(
		StagingAMAnalyticsDB stagingAMAnalyticsDB) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingAMAnalyticsDB)) {
				stagingAMAnalyticsDB = (StagingAMAnalyticsDB)session.get(
					StagingAMAnalyticsDBImpl.class,
					stagingAMAnalyticsDB.getPrimaryKeyObj());
			}

			if (stagingAMAnalyticsDB != null) {
				session.delete(stagingAMAnalyticsDB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingAMAnalyticsDB != null) {
			clearCache(stagingAMAnalyticsDB);
		}

		return stagingAMAnalyticsDB;
	}

	@Override
	public StagingAMAnalyticsDB updateImpl(
		StagingAMAnalyticsDB stagingAMAnalyticsDB) {

		boolean isNew = stagingAMAnalyticsDB.isNew();

		if (!(stagingAMAnalyticsDB instanceof StagingAMAnalyticsDBModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingAMAnalyticsDB.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingAMAnalyticsDB);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingAMAnalyticsDB proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingAMAnalyticsDB implementation " +
					stagingAMAnalyticsDB.getClass());
		}

		StagingAMAnalyticsDBModelImpl stagingAMAnalyticsDBModelImpl =
			(StagingAMAnalyticsDBModelImpl)stagingAMAnalyticsDB;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingAMAnalyticsDB.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingAMAnalyticsDB.setCreateDate(now);
			}
			else {
				stagingAMAnalyticsDB.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingAMAnalyticsDBModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingAMAnalyticsDB.setModifiedDate(now);
			}
			else {
				stagingAMAnalyticsDB.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingAMAnalyticsDB);

				stagingAMAnalyticsDB.setNew(false);
			}
			else {
				stagingAMAnalyticsDB = (StagingAMAnalyticsDB)session.merge(
					stagingAMAnalyticsDB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, StagingAMAnalyticsDBImpl.class,
			stagingAMAnalyticsDB.getPrimaryKey(), stagingAMAnalyticsDB, false);

		stagingAMAnalyticsDB.resetOriginalValues();

		return stagingAMAnalyticsDB;
	}

	/**
	 * Returns the staging am analytics db with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging am analytics db
	 * @return the staging am analytics db
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsDB findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingAMAnalyticsDBException {

		StagingAMAnalyticsDB stagingAMAnalyticsDB = fetchByPrimaryKey(
			primaryKey);

		if (stagingAMAnalyticsDB == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingAMAnalyticsDBException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingAMAnalyticsDB;
	}

	/**
	 * Returns the staging am analytics db with the primary key or throws a <code>NoSuchStagingAMAnalyticsDBException</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db
	 * @throws NoSuchStagingAMAnalyticsDBException if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsDB findByPrimaryKey(long stagingAMAnalyticsDbId)
		throws NoSuchStagingAMAnalyticsDBException {

		return findByPrimaryKey((Serializable)stagingAMAnalyticsDbId);
	}

	/**
	 * Returns the staging am analytics db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db, or <code>null</code> if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsDB fetchByPrimaryKey(long stagingAMAnalyticsDbId) {
		return fetchByPrimaryKey((Serializable)stagingAMAnalyticsDbId);
	}

	/**
	 * Returns all the staging am analytics dbs.
	 *
	 * @return the staging am analytics dbs
	 */
	@Override
	public List<StagingAMAnalyticsDB> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @return the range of staging am analytics dbs
	 */
	@Override
	public List<StagingAMAnalyticsDB> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging am analytics dbs
	 */
	@Override
	public List<StagingAMAnalyticsDB> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsDB> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging am analytics dbs
	 */
	@Override
	public List<StagingAMAnalyticsDB> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsDB> orderByComparator,
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

		List<StagingAMAnalyticsDB> list = null;

		if (useFinderCache) {
			list = (List<StagingAMAnalyticsDB>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGAMANALYTICSDB);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGAMANALYTICSDB;

				sql = sql.concat(StagingAMAnalyticsDBModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingAMAnalyticsDB>)QueryUtil.list(
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
	 * Removes all the staging am analytics dbs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingAMAnalyticsDB stagingAMAnalyticsDB : findAll()) {
			remove(stagingAMAnalyticsDB);
		}
	}

	/**
	 * Returns the number of staging am analytics dbs.
	 *
	 * @return the number of staging am analytics dbs
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
					_SQL_COUNT_STAGINGAMANALYTICSDB);

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
		return "stagingAMAnalyticsDbId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGAMANALYTICSDB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingAMAnalyticsDBModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging am analytics db persistence.
	 */
	@Activate
	public void activate() {
		StagingAMAnalyticsDBModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingAMAnalyticsDBModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAMAnalyticsDBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAMAnalyticsDBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingAMAnalyticsDBImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.account.management.model.StagingAMAnalyticsDB"),
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

	private static final String _SQL_SELECT_STAGINGAMANALYTICSDB =
		"SELECT stagingAMAnalyticsDB FROM StagingAMAnalyticsDB stagingAMAnalyticsDB";

	private static final String _SQL_COUNT_STAGINGAMANALYTICSDB =
		"SELECT COUNT(stagingAMAnalyticsDB) FROM StagingAMAnalyticsDB stagingAMAnalyticsDB";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stagingAMAnalyticsDB.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingAMAnalyticsDB exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingAMAnalyticsDBPersistenceImpl.class);

}