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

import com.argus.oth.cases.management.exception.NoSuchStagingTaskException;
import com.argus.oth.cases.management.model.StagingTask;
import com.argus.oth.cases.management.model.impl.StagingTaskImpl;
import com.argus.oth.cases.management.model.impl.StagingTaskModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingTaskPersistence;
import com.argus.oth.cases.management.service.persistence.impl.constants.OTHPersistenceConstants;

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
 * The persistence implementation for the staging task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingTaskPersistence.class)
public class StagingTaskPersistenceImpl
	extends BasePersistenceImpl<StagingTask> implements StagingTaskPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingTaskUtil</code> to access the staging task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingTaskImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingTaskPersistenceImpl() {
		setModelClass(StagingTask.class);

		setModelImplClass(StagingTaskImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging task in the entity cache if it is enabled.
	 *
	 * @param stagingTask the staging task
	 */
	@Override
	public void cacheResult(StagingTask stagingTask) {
		entityCache.putResult(
			entityCacheEnabled, StagingTaskImpl.class,
			stagingTask.getPrimaryKey(), stagingTask);

		stagingTask.resetOriginalValues();
	}

	/**
	 * Caches the staging tasks in the entity cache if it is enabled.
	 *
	 * @param stagingTasks the staging tasks
	 */
	@Override
	public void cacheResult(List<StagingTask> stagingTasks) {
		for (StagingTask stagingTask : stagingTasks) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingTaskImpl.class,
					stagingTask.getPrimaryKey()) == null) {

				cacheResult(stagingTask);
			}
			else {
				stagingTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging tasks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingTaskImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging task.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingTask stagingTask) {
		entityCache.removeResult(
			entityCacheEnabled, StagingTaskImpl.class,
			stagingTask.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingTask> stagingTasks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingTask stagingTask : stagingTasks) {
			entityCache.removeResult(
				entityCacheEnabled, StagingTaskImpl.class,
				stagingTask.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingTaskImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging task with the primary key. Does not add the staging task to the database.
	 *
	 * @param taskId the primary key for the new staging task
	 * @return the new staging task
	 */
	@Override
	public StagingTask create(long taskId) {
		StagingTask stagingTask = new StagingTaskImpl();

		stagingTask.setNew(true);
		stagingTask.setPrimaryKey(taskId);

		return stagingTask;
	}

	/**
	 * Removes the staging task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task that was removed
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	@Override
	public StagingTask remove(long taskId) throws NoSuchStagingTaskException {
		return remove((Serializable)taskId);
	}

	/**
	 * Removes the staging task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging task
	 * @return the staging task that was removed
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	@Override
	public StagingTask remove(Serializable primaryKey)
		throws NoSuchStagingTaskException {

		Session session = null;

		try {
			session = openSession();

			StagingTask stagingTask = (StagingTask)session.get(
				StagingTaskImpl.class, primaryKey);

			if (stagingTask == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingTaskException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingTask);
		}
		catch (NoSuchStagingTaskException noSuchEntityException) {
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
	protected StagingTask removeImpl(StagingTask stagingTask) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingTask)) {
				stagingTask = (StagingTask)session.get(
					StagingTaskImpl.class, stagingTask.getPrimaryKeyObj());
			}

			if (stagingTask != null) {
				session.delete(stagingTask);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingTask != null) {
			clearCache(stagingTask);
		}

		return stagingTask;
	}

	@Override
	public StagingTask updateImpl(StagingTask stagingTask) {
		boolean isNew = stagingTask.isNew();

		if (!(stagingTask instanceof StagingTaskModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingTask.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stagingTask);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingTask proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingTask implementation " +
					stagingTask.getClass());
		}

		StagingTaskModelImpl stagingTaskModelImpl =
			(StagingTaskModelImpl)stagingTask;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingTask.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingTask.setCreateDate(now);
			}
			else {
				stagingTask.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!stagingTaskModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingTask.setModifiedDate(now);
			}
			else {
				stagingTask.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (stagingTask.isNew()) {
				session.save(stagingTask);

				stagingTask.setNew(false);
			}
			else {
				stagingTask = (StagingTask)session.merge(stagingTask);
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
			entityCacheEnabled, StagingTaskImpl.class,
			stagingTask.getPrimaryKey(), stagingTask, false);

		stagingTask.resetOriginalValues();

		return stagingTask;
	}

	/**
	 * Returns the staging task with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging task
	 * @return the staging task
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	@Override
	public StagingTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingTaskException {

		StagingTask stagingTask = fetchByPrimaryKey(primaryKey);

		if (stagingTask == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingTaskException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingTask;
	}

	/**
	 * Returns the staging task with the primary key or throws a <code>NoSuchStagingTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	@Override
	public StagingTask findByPrimaryKey(long taskId)
		throws NoSuchStagingTaskException {

		return findByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns the staging task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task, or <code>null</code> if a staging task with the primary key could not be found
	 */
	@Override
	public StagingTask fetchByPrimaryKey(long taskId) {
		return fetchByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns all the staging tasks.
	 *
	 * @return the staging tasks
	 */
	@Override
	public List<StagingTask> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @return the range of staging tasks
	 */
	@Override
	public List<StagingTask> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging tasks
	 */
	@Override
	public List<StagingTask> findAll(
		int start, int end, OrderByComparator<StagingTask> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging tasks
	 */
	@Override
	public List<StagingTask> findAll(
		int start, int end, OrderByComparator<StagingTask> orderByComparator,
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

		List<StagingTask> list = null;

		if (useFinderCache) {
			list = (List<StagingTask>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGTASK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGTASK;

				sql = sql.concat(StagingTaskModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingTask>)QueryUtil.list(
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
	 * Removes all the staging tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingTask stagingTask : findAll()) {
			remove(stagingTask);
		}
	}

	/**
	 * Returns the number of staging tasks.
	 *
	 * @return the number of staging tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGINGTASK);

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
		return "taskId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGTASK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingTaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging task persistence.
	 */
	@Activate
	public void activate() {
		StagingTaskModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingTaskModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingTaskImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingTask"),
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

	private static final String _SQL_SELECT_STAGINGTASK =
		"SELECT stagingTask FROM StagingTask stagingTask";

	private static final String _SQL_COUNT_STAGINGTASK =
		"SELECT COUNT(stagingTask) FROM StagingTask stagingTask";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingTask.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingTask exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingTaskPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}