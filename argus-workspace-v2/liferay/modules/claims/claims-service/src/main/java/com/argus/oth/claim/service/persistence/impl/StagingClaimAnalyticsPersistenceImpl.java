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

import com.argus.oth.claim.exception.NoSuchStagingClaimAnalyticsException;
import com.argus.oth.claim.model.StagingClaimAnalytics;
import com.argus.oth.claim.model.impl.StagingClaimAnalyticsImpl;
import com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl;
import com.argus.oth.claim.service.persistence.StagingClaimAnalyticsPersistence;
import com.argus.oth.claim.service.persistence.impl.constants.OTH_ClaimPersistenceConstants;

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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the staging claim analytics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingClaimAnalyticsPersistence.class)
public class StagingClaimAnalyticsPersistenceImpl
	extends BasePersistenceImpl<StagingClaimAnalytics>
	implements StagingClaimAnalyticsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingClaimAnalyticsUtil</code> to access the staging claim analytics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingClaimAnalyticsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingClaimAnalyticsPersistenceImpl() {
		setModelClass(StagingClaimAnalytics.class);

		setModelImplClass(StagingClaimAnalyticsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the staging claim analytics in the entity cache if it is enabled.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 */
	@Override
	public void cacheResult(StagingClaimAnalytics stagingClaimAnalytics) {
		entityCache.putResult(
			entityCacheEnabled, StagingClaimAnalyticsImpl.class,
			stagingClaimAnalytics.getPrimaryKey(), stagingClaimAnalytics);

		stagingClaimAnalytics.resetOriginalValues();
	}

	/**
	 * Caches the staging claim analyticses in the entity cache if it is enabled.
	 *
	 * @param stagingClaimAnalyticses the staging claim analyticses
	 */
	@Override
	public void cacheResult(
		List<StagingClaimAnalytics> stagingClaimAnalyticses) {

		for (StagingClaimAnalytics stagingClaimAnalytics :
				stagingClaimAnalyticses) {

			if (entityCache.getResult(
					entityCacheEnabled, StagingClaimAnalyticsImpl.class,
					stagingClaimAnalytics.getPrimaryKey()) == null) {

				cacheResult(stagingClaimAnalytics);
			}
			else {
				stagingClaimAnalytics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging claim analyticses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingClaimAnalyticsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging claim analytics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingClaimAnalytics stagingClaimAnalytics) {
		entityCache.removeResult(
			entityCacheEnabled, StagingClaimAnalyticsImpl.class,
			stagingClaimAnalytics.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StagingClaimAnalytics> stagingClaimAnalyticses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingClaimAnalytics stagingClaimAnalytics :
				stagingClaimAnalyticses) {

			entityCache.removeResult(
				entityCacheEnabled, StagingClaimAnalyticsImpl.class,
				stagingClaimAnalytics.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClaimAnalyticsImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new staging claim analytics with the primary key. Does not add the staging claim analytics to the database.
	 *
	 * @param stagingClaimAnalyticsId the primary key for the new staging claim analytics
	 * @return the new staging claim analytics
	 */
	@Override
	public StagingClaimAnalytics create(long stagingClaimAnalyticsId) {
		StagingClaimAnalytics stagingClaimAnalytics =
			new StagingClaimAnalyticsImpl();

		stagingClaimAnalytics.setNew(true);
		stagingClaimAnalytics.setPrimaryKey(stagingClaimAnalyticsId);

		return stagingClaimAnalytics;
	}

	/**
	 * Removes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public StagingClaimAnalytics remove(long stagingClaimAnalyticsId)
		throws NoSuchStagingClaimAnalyticsException {

		return remove((Serializable)stagingClaimAnalyticsId);
	}

	/**
	 * Removes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public StagingClaimAnalytics remove(Serializable primaryKey)
		throws NoSuchStagingClaimAnalyticsException {

		Session session = null;

		try {
			session = openSession();

			StagingClaimAnalytics stagingClaimAnalytics =
				(StagingClaimAnalytics)session.get(
					StagingClaimAnalyticsImpl.class, primaryKey);

			if (stagingClaimAnalytics == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingClaimAnalyticsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingClaimAnalytics);
		}
		catch (NoSuchStagingClaimAnalyticsException noSuchEntityException) {
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
	protected StagingClaimAnalytics removeImpl(
		StagingClaimAnalytics stagingClaimAnalytics) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingClaimAnalytics)) {
				stagingClaimAnalytics = (StagingClaimAnalytics)session.get(
					StagingClaimAnalyticsImpl.class,
					stagingClaimAnalytics.getPrimaryKeyObj());
			}

			if (stagingClaimAnalytics != null) {
				session.delete(stagingClaimAnalytics);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingClaimAnalytics != null) {
			clearCache(stagingClaimAnalytics);
		}

		return stagingClaimAnalytics;
	}

	@Override
	public StagingClaimAnalytics updateImpl(
		StagingClaimAnalytics stagingClaimAnalytics) {

		boolean isNew = stagingClaimAnalytics.isNew();

		if (!(stagingClaimAnalytics instanceof
				StagingClaimAnalyticsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingClaimAnalytics.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingClaimAnalytics);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingClaimAnalytics proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingClaimAnalytics implementation " +
					stagingClaimAnalytics.getClass());
		}

		StagingClaimAnalyticsModelImpl stagingClaimAnalyticsModelImpl =
			(StagingClaimAnalyticsModelImpl)stagingClaimAnalytics;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingClaimAnalytics.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingClaimAnalytics.setCreateDate(now);
			}
			else {
				stagingClaimAnalytics.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingClaimAnalyticsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingClaimAnalytics.setModifiedDate(now);
			}
			else {
				stagingClaimAnalytics.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (stagingClaimAnalytics.isNew()) {
				session.save(stagingClaimAnalytics);

				stagingClaimAnalytics.setNew(false);
			}
			else {
				stagingClaimAnalytics = (StagingClaimAnalytics)session.merge(
					stagingClaimAnalytics);
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
			entityCacheEnabled, StagingClaimAnalyticsImpl.class,
			stagingClaimAnalytics.getPrimaryKey(), stagingClaimAnalytics,
			false);

		stagingClaimAnalytics.resetOriginalValues();

		return stagingClaimAnalytics;
	}

	/**
	 * Returns the staging claim analytics with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public StagingClaimAnalytics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingClaimAnalyticsException {

		StagingClaimAnalytics stagingClaimAnalytics = fetchByPrimaryKey(
			primaryKey);

		if (stagingClaimAnalytics == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingClaimAnalyticsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingClaimAnalytics;
	}

	/**
	 * Returns the staging claim analytics with the primary key or throws a <code>NoSuchStagingClaimAnalyticsException</code> if it could not be found.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws NoSuchStagingClaimAnalyticsException if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public StagingClaimAnalytics findByPrimaryKey(long stagingClaimAnalyticsId)
		throws NoSuchStagingClaimAnalyticsException {

		return findByPrimaryKey((Serializable)stagingClaimAnalyticsId);
	}

	/**
	 * Returns the staging claim analytics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics, or <code>null</code> if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public StagingClaimAnalytics fetchByPrimaryKey(
		long stagingClaimAnalyticsId) {

		return fetchByPrimaryKey((Serializable)stagingClaimAnalyticsId);
	}

	/**
	 * Returns all the staging claim analyticses.
	 *
	 * @return the staging claim analyticses
	 */
	@Override
	public List<StagingClaimAnalytics> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @return the range of staging claim analyticses
	 */
	@Override
	public List<StagingClaimAnalytics> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claim analyticses
	 */
	@Override
	public List<StagingClaimAnalytics> findAll(
		int start, int end,
		OrderByComparator<StagingClaimAnalytics> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claim analyticses
	 */
	@Override
	public List<StagingClaimAnalytics> findAll(
		int start, int end,
		OrderByComparator<StagingClaimAnalytics> orderByComparator,
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

		List<StagingClaimAnalytics> list = null;

		if (useFinderCache) {
			list = (List<StagingClaimAnalytics>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGCLAIMANALYTICS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGCLAIMANALYTICS;

				sql = sql.concat(StagingClaimAnalyticsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingClaimAnalytics>)QueryUtil.list(
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
	 * Removes all the staging claim analyticses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingClaimAnalytics stagingClaimAnalytics : findAll()) {
			remove(stagingClaimAnalytics);
		}
	}

	/**
	 * Returns the number of staging claim analyticses.
	 *
	 * @return the number of staging claim analyticses
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
					_SQL_COUNT_STAGINGCLAIMANALYTICS);

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
		return "stagingClaimAnalyticsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGCLAIMANALYTICS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingClaimAnalyticsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging claim analytics persistence.
	 */
	@Activate
	public void activate() {
		StagingClaimAnalyticsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		StagingClaimAnalyticsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClaimAnalyticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingClaimAnalyticsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.claim.model.StagingClaimAnalytics"),
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

	private static final String _SQL_SELECT_STAGINGCLAIMANALYTICS =
		"SELECT stagingClaimAnalytics FROM StagingClaimAnalytics stagingClaimAnalytics";

	private static final String _SQL_COUNT_STAGINGCLAIMANALYTICS =
		"SELECT COUNT(stagingClaimAnalytics) FROM StagingClaimAnalytics stagingClaimAnalytics";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stagingClaimAnalytics.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingClaimAnalytics exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingClaimAnalyticsPersistenceImpl.class);

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