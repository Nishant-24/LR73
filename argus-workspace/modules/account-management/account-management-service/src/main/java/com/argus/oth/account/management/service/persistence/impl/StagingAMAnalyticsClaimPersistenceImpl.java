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

import com.argus.oth.account.management.exception.NoSuchStagingAMAnalyticsClaimException;
import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimImpl;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl;
import com.argus.oth.account.management.service.persistence.StagingAMAnalyticsClaimPersistence;
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
 * The persistence implementation for the staging am analytics claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingAMAnalyticsClaimPersistence.class)
public class StagingAMAnalyticsClaimPersistenceImpl
	extends BasePersistenceImpl<StagingAMAnalyticsClaim>
	implements StagingAMAnalyticsClaimPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingAMAnalyticsClaimUtil</code> to access the staging am analytics claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingAMAnalyticsClaimImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingAMAnalyticsClaimPersistenceImpl() {
		setModelClass(StagingAMAnalyticsClaim.class);

		setModelImplClass(StagingAMAnalyticsClaimImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging am analytics claim in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 */
	@Override
	public void cacheResult(StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {
		entityCache.putResult(
			entityCacheEnabled, StagingAMAnalyticsClaimImpl.class,
			stagingAMAnalyticsClaim.getPrimaryKey(), stagingAMAnalyticsClaim);

		stagingAMAnalyticsClaim.resetOriginalValues();
	}

	/**
	 * Caches the staging am analytics claims in the entity cache if it is enabled.
	 *
	 * @param stagingAMAnalyticsClaims the staging am analytics claims
	 */
	@Override
	public void cacheResult(
		List<StagingAMAnalyticsClaim> stagingAMAnalyticsClaims) {

		for (StagingAMAnalyticsClaim stagingAMAnalyticsClaim :
				stagingAMAnalyticsClaims) {

			if (entityCache.getResult(
					entityCacheEnabled, StagingAMAnalyticsClaimImpl.class,
					stagingAMAnalyticsClaim.getPrimaryKey()) == null) {

				cacheResult(stagingAMAnalyticsClaim);
			}
			else {
				stagingAMAnalyticsClaim.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging am analytics claims.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingAMAnalyticsClaimImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging am analytics claim.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {
		entityCache.removeResult(
			entityCacheEnabled, StagingAMAnalyticsClaimImpl.class,
			stagingAMAnalyticsClaim.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StagingAMAnalyticsClaim> stagingAMAnalyticsClaims) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingAMAnalyticsClaim stagingAMAnalyticsClaim :
				stagingAMAnalyticsClaims) {

			entityCache.removeResult(
				entityCacheEnabled, StagingAMAnalyticsClaimImpl.class,
				stagingAMAnalyticsClaim.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingAMAnalyticsClaimImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new staging am analytics claim with the primary key. Does not add the staging am analytics claim to the database.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key for the new staging am analytics claim
	 * @return the new staging am analytics claim
	 */
	@Override
	public StagingAMAnalyticsClaim create(long stagingAMAnalyticsClaimId) {
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim =
			new StagingAMAnalyticsClaimImpl();

		stagingAMAnalyticsClaim.setNew(true);
		stagingAMAnalyticsClaim.setPrimaryKey(stagingAMAnalyticsClaimId);

		return stagingAMAnalyticsClaim;
	}

	/**
	 * Removes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsClaim remove(long stagingAMAnalyticsClaimId)
		throws NoSuchStagingAMAnalyticsClaimException {

		return remove((Serializable)stagingAMAnalyticsClaimId);
	}

	/**
	 * Removes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsClaim remove(Serializable primaryKey)
		throws NoSuchStagingAMAnalyticsClaimException {

		Session session = null;

		try {
			session = openSession();

			StagingAMAnalyticsClaim stagingAMAnalyticsClaim =
				(StagingAMAnalyticsClaim)session.get(
					StagingAMAnalyticsClaimImpl.class, primaryKey);

			if (stagingAMAnalyticsClaim == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingAMAnalyticsClaimException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingAMAnalyticsClaim);
		}
		catch (NoSuchStagingAMAnalyticsClaimException noSuchEntityException) {
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
	protected StagingAMAnalyticsClaim removeImpl(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingAMAnalyticsClaim)) {
				stagingAMAnalyticsClaim = (StagingAMAnalyticsClaim)session.get(
					StagingAMAnalyticsClaimImpl.class,
					stagingAMAnalyticsClaim.getPrimaryKeyObj());
			}

			if (stagingAMAnalyticsClaim != null) {
				session.delete(stagingAMAnalyticsClaim);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingAMAnalyticsClaim != null) {
			clearCache(stagingAMAnalyticsClaim);
		}

		return stagingAMAnalyticsClaim;
	}

	@Override
	public StagingAMAnalyticsClaim updateImpl(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim) {

		boolean isNew = stagingAMAnalyticsClaim.isNew();

		if (!(stagingAMAnalyticsClaim instanceof
				StagingAMAnalyticsClaimModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingAMAnalyticsClaim.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingAMAnalyticsClaim);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingAMAnalyticsClaim proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingAMAnalyticsClaim implementation " +
					stagingAMAnalyticsClaim.getClass());
		}

		StagingAMAnalyticsClaimModelImpl stagingAMAnalyticsClaimModelImpl =
			(StagingAMAnalyticsClaimModelImpl)stagingAMAnalyticsClaim;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingAMAnalyticsClaim.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingAMAnalyticsClaim.setCreateDate(now);
			}
			else {
				stagingAMAnalyticsClaim.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingAMAnalyticsClaimModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingAMAnalyticsClaim.setModifiedDate(now);
			}
			else {
				stagingAMAnalyticsClaim.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingAMAnalyticsClaim);

				stagingAMAnalyticsClaim.setNew(false);
			}
			else {
				stagingAMAnalyticsClaim =
					(StagingAMAnalyticsClaim)session.merge(
						stagingAMAnalyticsClaim);
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
			entityCacheEnabled, StagingAMAnalyticsClaimImpl.class,
			stagingAMAnalyticsClaim.getPrimaryKey(), stagingAMAnalyticsClaim,
			false);

		stagingAMAnalyticsClaim.resetOriginalValues();

		return stagingAMAnalyticsClaim;
	}

	/**
	 * Returns the staging am analytics claim with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsClaim findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingAMAnalyticsClaimException {

		StagingAMAnalyticsClaim stagingAMAnalyticsClaim = fetchByPrimaryKey(
			primaryKey);

		if (stagingAMAnalyticsClaim == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingAMAnalyticsClaimException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingAMAnalyticsClaim;
	}

	/**
	 * Returns the staging am analytics claim with the primary key or throws a <code>NoSuchStagingAMAnalyticsClaimException</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws NoSuchStagingAMAnalyticsClaimException if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsClaim findByPrimaryKey(
			long stagingAMAnalyticsClaimId)
		throws NoSuchStagingAMAnalyticsClaimException {

		return findByPrimaryKey((Serializable)stagingAMAnalyticsClaimId);
	}

	/**
	 * Returns the staging am analytics claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim, or <code>null</code> if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public StagingAMAnalyticsClaim fetchByPrimaryKey(
		long stagingAMAnalyticsClaimId) {

		return fetchByPrimaryKey((Serializable)stagingAMAnalyticsClaimId);
	}

	/**
	 * Returns all the staging am analytics claims.
	 *
	 * @return the staging am analytics claims
	 */
	@Override
	public List<StagingAMAnalyticsClaim> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @return the range of staging am analytics claims
	 */
	@Override
	public List<StagingAMAnalyticsClaim> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging am analytics claims
	 */
	@Override
	public List<StagingAMAnalyticsClaim> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsClaim> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging am analytics claims
	 */
	@Override
	public List<StagingAMAnalyticsClaim> findAll(
		int start, int end,
		OrderByComparator<StagingAMAnalyticsClaim> orderByComparator,
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

		List<StagingAMAnalyticsClaim> list = null;

		if (useFinderCache) {
			list = (List<StagingAMAnalyticsClaim>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGAMANALYTICSCLAIM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGAMANALYTICSCLAIM;

				sql = sql.concat(
					StagingAMAnalyticsClaimModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingAMAnalyticsClaim>)QueryUtil.list(
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
	 * Removes all the staging am analytics claims from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingAMAnalyticsClaim stagingAMAnalyticsClaim : findAll()) {
			remove(stagingAMAnalyticsClaim);
		}
	}

	/**
	 * Returns the number of staging am analytics claims.
	 *
	 * @return the number of staging am analytics claims
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
					_SQL_COUNT_STAGINGAMANALYTICSCLAIM);

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
		return "stagingAMAnalyticsClaimId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGAMANALYTICSCLAIM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingAMAnalyticsClaimModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging am analytics claim persistence.
	 */
	@Activate
	public void activate() {
		StagingAMAnalyticsClaimModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		StagingAMAnalyticsClaimModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAMAnalyticsClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAMAnalyticsClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingAMAnalyticsClaimImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.account.management.model.StagingAMAnalyticsClaim"),
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

	private static final String _SQL_SELECT_STAGINGAMANALYTICSCLAIM =
		"SELECT stagingAMAnalyticsClaim FROM StagingAMAnalyticsClaim stagingAMAnalyticsClaim";

	private static final String _SQL_COUNT_STAGINGAMANALYTICSCLAIM =
		"SELECT COUNT(stagingAMAnalyticsClaim) FROM StagingAMAnalyticsClaim stagingAMAnalyticsClaim";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stagingAMAnalyticsClaim.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingAMAnalyticsClaim exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingAMAnalyticsClaimPersistenceImpl.class);

}