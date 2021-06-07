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

import com.argus.oth.cases.management.exception.NoSuchStagingAuthProcedureException;
import com.argus.oth.cases.management.model.StagingAuthProcedure;
import com.argus.oth.cases.management.model.impl.StagingAuthProcedureImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthProcedureModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingAuthProcedurePersistence;
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
 * The persistence implementation for the staging auth procedure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingAuthProcedurePersistence.class)
public class StagingAuthProcedurePersistenceImpl
	extends BasePersistenceImpl<StagingAuthProcedure>
	implements StagingAuthProcedurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingAuthProcedureUtil</code> to access the staging auth procedure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingAuthProcedureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingAuthProcedurePersistenceImpl() {
		setModelClass(StagingAuthProcedure.class);

		setModelImplClass(StagingAuthProcedureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging auth procedure in the entity cache if it is enabled.
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 */
	@Override
	public void cacheResult(StagingAuthProcedure stagingAuthProcedure) {
		entityCache.putResult(
			entityCacheEnabled, StagingAuthProcedureImpl.class,
			stagingAuthProcedure.getPrimaryKey(), stagingAuthProcedure);

		stagingAuthProcedure.resetOriginalValues();
	}

	/**
	 * Caches the staging auth procedures in the entity cache if it is enabled.
	 *
	 * @param stagingAuthProcedures the staging auth procedures
	 */
	@Override
	public void cacheResult(List<StagingAuthProcedure> stagingAuthProcedures) {
		for (StagingAuthProcedure stagingAuthProcedure :
				stagingAuthProcedures) {

			if (entityCache.getResult(
					entityCacheEnabled, StagingAuthProcedureImpl.class,
					stagingAuthProcedure.getPrimaryKey()) == null) {

				cacheResult(stagingAuthProcedure);
			}
			else {
				stagingAuthProcedure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging auth procedures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingAuthProcedureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging auth procedure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingAuthProcedure stagingAuthProcedure) {
		entityCache.removeResult(
			entityCacheEnabled, StagingAuthProcedureImpl.class,
			stagingAuthProcedure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingAuthProcedure> stagingAuthProcedures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingAuthProcedure stagingAuthProcedure :
				stagingAuthProcedures) {

			entityCache.removeResult(
				entityCacheEnabled, StagingAuthProcedureImpl.class,
				stagingAuthProcedure.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingAuthProcedureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging auth procedure with the primary key. Does not add the staging auth procedure to the database.
	 *
	 * @param stagingAuthProcedureId the primary key for the new staging auth procedure
	 * @return the new staging auth procedure
	 */
	@Override
	public StagingAuthProcedure create(long stagingAuthProcedureId) {
		StagingAuthProcedure stagingAuthProcedure =
			new StagingAuthProcedureImpl();

		stagingAuthProcedure.setNew(true);
		stagingAuthProcedure.setPrimaryKey(stagingAuthProcedureId);

		return stagingAuthProcedure;
	}

	/**
	 * Removes the staging auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure that was removed
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public StagingAuthProcedure remove(long stagingAuthProcedureId)
		throws NoSuchStagingAuthProcedureException {

		return remove((Serializable)stagingAuthProcedureId);
	}

	/**
	 * Removes the staging auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging auth procedure
	 * @return the staging auth procedure that was removed
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public StagingAuthProcedure remove(Serializable primaryKey)
		throws NoSuchStagingAuthProcedureException {

		Session session = null;

		try {
			session = openSession();

			StagingAuthProcedure stagingAuthProcedure =
				(StagingAuthProcedure)session.get(
					StagingAuthProcedureImpl.class, primaryKey);

			if (stagingAuthProcedure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingAuthProcedureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingAuthProcedure);
		}
		catch (NoSuchStagingAuthProcedureException noSuchEntityException) {
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
	protected StagingAuthProcedure removeImpl(
		StagingAuthProcedure stagingAuthProcedure) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingAuthProcedure)) {
				stagingAuthProcedure = (StagingAuthProcedure)session.get(
					StagingAuthProcedureImpl.class,
					stagingAuthProcedure.getPrimaryKeyObj());
			}

			if (stagingAuthProcedure != null) {
				session.delete(stagingAuthProcedure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingAuthProcedure != null) {
			clearCache(stagingAuthProcedure);
		}

		return stagingAuthProcedure;
	}

	@Override
	public StagingAuthProcedure updateImpl(
		StagingAuthProcedure stagingAuthProcedure) {

		boolean isNew = stagingAuthProcedure.isNew();

		if (!(stagingAuthProcedure instanceof StagingAuthProcedureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingAuthProcedure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingAuthProcedure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingAuthProcedure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingAuthProcedure implementation " +
					stagingAuthProcedure.getClass());
		}

		StagingAuthProcedureModelImpl stagingAuthProcedureModelImpl =
			(StagingAuthProcedureModelImpl)stagingAuthProcedure;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingAuthProcedure.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingAuthProcedure.setCreateDate(now);
			}
			else {
				stagingAuthProcedure.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingAuthProcedureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingAuthProcedure.setModifiedDate(now);
			}
			else {
				stagingAuthProcedure.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingAuthProcedure);

				stagingAuthProcedure.setNew(false);
			}
			else {
				stagingAuthProcedure = (StagingAuthProcedure)session.merge(
					stagingAuthProcedure);
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
			entityCacheEnabled, StagingAuthProcedureImpl.class,
			stagingAuthProcedure.getPrimaryKey(), stagingAuthProcedure, false);

		stagingAuthProcedure.resetOriginalValues();

		return stagingAuthProcedure;
	}

	/**
	 * Returns the staging auth procedure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging auth procedure
	 * @return the staging auth procedure
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public StagingAuthProcedure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingAuthProcedureException {

		StagingAuthProcedure stagingAuthProcedure = fetchByPrimaryKey(
			primaryKey);

		if (stagingAuthProcedure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingAuthProcedureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingAuthProcedure;
	}

	/**
	 * Returns the staging auth procedure with the primary key or throws a <code>NoSuchStagingAuthProcedureException</code> if it could not be found.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure
	 * @throws NoSuchStagingAuthProcedureException if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public StagingAuthProcedure findByPrimaryKey(long stagingAuthProcedureId)
		throws NoSuchStagingAuthProcedureException {

		return findByPrimaryKey((Serializable)stagingAuthProcedureId);
	}

	/**
	 * Returns the staging auth procedure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure, or <code>null</code> if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public StagingAuthProcedure fetchByPrimaryKey(long stagingAuthProcedureId) {
		return fetchByPrimaryKey((Serializable)stagingAuthProcedureId);
	}

	/**
	 * Returns all the staging auth procedures.
	 *
	 * @return the staging auth procedures
	 */
	@Override
	public List<StagingAuthProcedure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @return the range of staging auth procedures
	 */
	@Override
	public List<StagingAuthProcedure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging auth procedures
	 */
	@Override
	public List<StagingAuthProcedure> findAll(
		int start, int end,
		OrderByComparator<StagingAuthProcedure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging auth procedures
	 */
	@Override
	public List<StagingAuthProcedure> findAll(
		int start, int end,
		OrderByComparator<StagingAuthProcedure> orderByComparator,
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

		List<StagingAuthProcedure> list = null;

		if (useFinderCache) {
			list = (List<StagingAuthProcedure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGAUTHPROCEDURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGAUTHPROCEDURE;

				sql = sql.concat(StagingAuthProcedureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingAuthProcedure>)QueryUtil.list(
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
	 * Removes all the staging auth procedures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingAuthProcedure stagingAuthProcedure : findAll()) {
			remove(stagingAuthProcedure);
		}
	}

	/**
	 * Returns the number of staging auth procedures.
	 *
	 * @return the number of staging auth procedures
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
					_SQL_COUNT_STAGINGAUTHPROCEDURE);

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
		return "stagingAuthProcedureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGAUTHPROCEDURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingAuthProcedureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging auth procedure persistence.
	 */
	@Activate
	public void activate() {
		StagingAuthProcedureModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingAuthProcedureModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAuthProcedureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingAuthProcedureImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingAuthProcedure"),
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

	private static final String _SQL_SELECT_STAGINGAUTHPROCEDURE =
		"SELECT stagingAuthProcedure FROM StagingAuthProcedure stagingAuthProcedure";

	private static final String _SQL_COUNT_STAGINGAUTHPROCEDURE =
		"SELECT COUNT(stagingAuthProcedure) FROM StagingAuthProcedure stagingAuthProcedure";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stagingAuthProcedure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingAuthProcedure exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingAuthProcedurePersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}