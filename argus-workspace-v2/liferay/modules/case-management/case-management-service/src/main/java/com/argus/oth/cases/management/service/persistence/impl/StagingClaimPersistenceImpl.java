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

import com.argus.oth.cases.management.exception.NoSuchStagingClaimException;
import com.argus.oth.cases.management.model.StagingClaim;
import com.argus.oth.cases.management.model.impl.StagingClaimImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingClaimPersistence;
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
 * The persistence implementation for the staging claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingClaimPersistence.class)
public class StagingClaimPersistenceImpl
	extends BasePersistenceImpl<StagingClaim>
	implements StagingClaimPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingClaimUtil</code> to access the staging claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingClaimImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingClaimPersistenceImpl() {
		setModelClass(StagingClaim.class);

		setModelImplClass(StagingClaimImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging claim in the entity cache if it is enabled.
	 *
	 * @param stagingClaim the staging claim
	 */
	@Override
	public void cacheResult(StagingClaim stagingClaim) {
		entityCache.putResult(
			entityCacheEnabled, StagingClaimImpl.class,
			stagingClaim.getPrimaryKey(), stagingClaim);

		stagingClaim.resetOriginalValues();
	}

	/**
	 * Caches the staging claims in the entity cache if it is enabled.
	 *
	 * @param stagingClaims the staging claims
	 */
	@Override
	public void cacheResult(List<StagingClaim> stagingClaims) {
		for (StagingClaim stagingClaim : stagingClaims) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingClaimImpl.class,
					stagingClaim.getPrimaryKey()) == null) {

				cacheResult(stagingClaim);
			}
			else {
				stagingClaim.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging claims.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingClaimImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging claim.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingClaim stagingClaim) {
		entityCache.removeResult(
			entityCacheEnabled, StagingClaimImpl.class,
			stagingClaim.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingClaim> stagingClaims) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingClaim stagingClaim : stagingClaims) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClaimImpl.class,
				stagingClaim.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClaimImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging claim with the primary key. Does not add the staging claim to the database.
	 *
	 * @param stagingClaimId the primary key for the new staging claim
	 * @return the new staging claim
	 */
	@Override
	public StagingClaim create(long stagingClaimId) {
		StagingClaim stagingClaim = new StagingClaimImpl();

		stagingClaim.setNew(true);
		stagingClaim.setPrimaryKey(stagingClaimId);

		return stagingClaim;
	}

	/**
	 * Removes the staging claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim that was removed
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	@Override
	public StagingClaim remove(long stagingClaimId)
		throws NoSuchStagingClaimException {

		return remove((Serializable)stagingClaimId);
	}

	/**
	 * Removes the staging claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging claim
	 * @return the staging claim that was removed
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	@Override
	public StagingClaim remove(Serializable primaryKey)
		throws NoSuchStagingClaimException {

		Session session = null;

		try {
			session = openSession();

			StagingClaim stagingClaim = (StagingClaim)session.get(
				StagingClaimImpl.class, primaryKey);

			if (stagingClaim == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingClaimException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingClaim);
		}
		catch (NoSuchStagingClaimException noSuchEntityException) {
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
	protected StagingClaim removeImpl(StagingClaim stagingClaim) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingClaim)) {
				stagingClaim = (StagingClaim)session.get(
					StagingClaimImpl.class, stagingClaim.getPrimaryKeyObj());
			}

			if (stagingClaim != null) {
				session.delete(stagingClaim);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingClaim != null) {
			clearCache(stagingClaim);
		}

		return stagingClaim;
	}

	@Override
	public StagingClaim updateImpl(StagingClaim stagingClaim) {
		boolean isNew = stagingClaim.isNew();

		if (!(stagingClaim instanceof StagingClaimModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingClaim.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingClaim);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingClaim proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingClaim implementation " +
					stagingClaim.getClass());
		}

		StagingClaimModelImpl stagingClaimModelImpl =
			(StagingClaimModelImpl)stagingClaim;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingClaim.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingClaim.setCreateDate(now);
			}
			else {
				stagingClaim.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!stagingClaimModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingClaim.setModifiedDate(now);
			}
			else {
				stagingClaim.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (stagingClaim.isNew()) {
				session.save(stagingClaim);

				stagingClaim.setNew(false);
			}
			else {
				stagingClaim = (StagingClaim)session.merge(stagingClaim);
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
			entityCacheEnabled, StagingClaimImpl.class,
			stagingClaim.getPrimaryKey(), stagingClaim, false);

		stagingClaim.resetOriginalValues();

		return stagingClaim;
	}

	/**
	 * Returns the staging claim with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging claim
	 * @return the staging claim
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	@Override
	public StagingClaim findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingClaimException {

		StagingClaim stagingClaim = fetchByPrimaryKey(primaryKey);

		if (stagingClaim == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingClaimException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingClaim;
	}

	/**
	 * Returns the staging claim with the primary key or throws a <code>NoSuchStagingClaimException</code> if it could not be found.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim
	 * @throws NoSuchStagingClaimException if a staging claim with the primary key could not be found
	 */
	@Override
	public StagingClaim findByPrimaryKey(long stagingClaimId)
		throws NoSuchStagingClaimException {

		return findByPrimaryKey((Serializable)stagingClaimId);
	}

	/**
	 * Returns the staging claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim, or <code>null</code> if a staging claim with the primary key could not be found
	 */
	@Override
	public StagingClaim fetchByPrimaryKey(long stagingClaimId) {
		return fetchByPrimaryKey((Serializable)stagingClaimId);
	}

	/**
	 * Returns all the staging claims.
	 *
	 * @return the staging claims
	 */
	@Override
	public List<StagingClaim> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @return the range of staging claims
	 */
	@Override
	public List<StagingClaim> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claims
	 */
	@Override
	public List<StagingClaim> findAll(
		int start, int end, OrderByComparator<StagingClaim> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claims
	 */
	@Override
	public List<StagingClaim> findAll(
		int start, int end, OrderByComparator<StagingClaim> orderByComparator,
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

		List<StagingClaim> list = null;

		if (useFinderCache) {
			list = (List<StagingClaim>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGCLAIM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGCLAIM;

				sql = sql.concat(StagingClaimModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingClaim>)QueryUtil.list(
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
	 * Removes all the staging claims from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingClaim stagingClaim : findAll()) {
			remove(stagingClaim);
		}
	}

	/**
	 * Returns the number of staging claims.
	 *
	 * @return the number of staging claims
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGINGCLAIM);

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
		return "stagingClaimId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGCLAIM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingClaimModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging claim persistence.
	 */
	@Activate
	public void activate() {
		StagingClaimModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingClaimModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingClaimImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingClaim"),
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

	private static final String _SQL_SELECT_STAGINGCLAIM =
		"SELECT stagingClaim FROM StagingClaim stagingClaim";

	private static final String _SQL_COUNT_STAGINGCLAIM =
		"SELECT COUNT(stagingClaim) FROM StagingClaim stagingClaim";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingClaim.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingClaim exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingClaimPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}