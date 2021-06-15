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

import com.argus.oth.account.management.exception.NoSuchAMAnalyticsClaimException;
import com.argus.oth.account.management.model.AMAnalyticsClaim;
import com.argus.oth.account.management.model.impl.AMAnalyticsClaimImpl;
import com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl;
import com.argus.oth.account.management.service.persistence.AMAnalyticsClaimPersistence;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
 * The persistence implementation for the am analytics claim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AMAnalyticsClaimPersistence.class)
public class AMAnalyticsClaimPersistenceImpl
	extends BasePersistenceImpl<AMAnalyticsClaim>
	implements AMAnalyticsClaimPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMAnalyticsClaimUtil</code> to access the am analytics claim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMAnalyticsClaimImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AMAnalyticsClaimPersistenceImpl() {
		setModelClass(AMAnalyticsClaim.class);

		setModelImplClass(AMAnalyticsClaimImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the am analytics claim in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 */
	@Override
	public void cacheResult(AMAnalyticsClaim amAnalyticsClaim) {
		entityCache.putResult(
			entityCacheEnabled, AMAnalyticsClaimImpl.class,
			amAnalyticsClaim.getPrimaryKey(), amAnalyticsClaim);

		amAnalyticsClaim.resetOriginalValues();
	}

	/**
	 * Caches the am analytics claims in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsClaims the am analytics claims
	 */
	@Override
	public void cacheResult(List<AMAnalyticsClaim> amAnalyticsClaims) {
		for (AMAnalyticsClaim amAnalyticsClaim : amAnalyticsClaims) {
			if (entityCache.getResult(
					entityCacheEnabled, AMAnalyticsClaimImpl.class,
					amAnalyticsClaim.getPrimaryKey()) == null) {

				cacheResult(amAnalyticsClaim);
			}
			else {
				amAnalyticsClaim.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all am analytics claims.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMAnalyticsClaimImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the am analytics claim.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMAnalyticsClaim amAnalyticsClaim) {
		entityCache.removeResult(
			entityCacheEnabled, AMAnalyticsClaimImpl.class,
			amAnalyticsClaim.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMAnalyticsClaim> amAnalyticsClaims) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMAnalyticsClaim amAnalyticsClaim : amAnalyticsClaims) {
			entityCache.removeResult(
				entityCacheEnabled, AMAnalyticsClaimImpl.class,
				amAnalyticsClaim.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AMAnalyticsClaimImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new am analytics claim with the primary key. Does not add the am analytics claim to the database.
	 *
	 * @param amAnalyticsClaimId the primary key for the new am analytics claim
	 * @return the new am analytics claim
	 */
	@Override
	public AMAnalyticsClaim create(long amAnalyticsClaimId) {
		AMAnalyticsClaim amAnalyticsClaim = new AMAnalyticsClaimImpl();

		amAnalyticsClaim.setNew(true);
		amAnalyticsClaim.setPrimaryKey(amAnalyticsClaimId);

		amAnalyticsClaim.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amAnalyticsClaim;
	}

	/**
	 * Removes the am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim that was removed
	 * @throws NoSuchAMAnalyticsClaimException if a am analytics claim with the primary key could not be found
	 */
	@Override
	public AMAnalyticsClaim remove(long amAnalyticsClaimId)
		throws NoSuchAMAnalyticsClaimException {

		return remove((Serializable)amAnalyticsClaimId);
	}

	/**
	 * Removes the am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the am analytics claim
	 * @return the am analytics claim that was removed
	 * @throws NoSuchAMAnalyticsClaimException if a am analytics claim with the primary key could not be found
	 */
	@Override
	public AMAnalyticsClaim remove(Serializable primaryKey)
		throws NoSuchAMAnalyticsClaimException {

		Session session = null;

		try {
			session = openSession();

			AMAnalyticsClaim amAnalyticsClaim = (AMAnalyticsClaim)session.get(
				AMAnalyticsClaimImpl.class, primaryKey);

			if (amAnalyticsClaim == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMAnalyticsClaimException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amAnalyticsClaim);
		}
		catch (NoSuchAMAnalyticsClaimException noSuchEntityException) {
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
	protected AMAnalyticsClaim removeImpl(AMAnalyticsClaim amAnalyticsClaim) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amAnalyticsClaim)) {
				amAnalyticsClaim = (AMAnalyticsClaim)session.get(
					AMAnalyticsClaimImpl.class,
					amAnalyticsClaim.getPrimaryKeyObj());
			}

			if (amAnalyticsClaim != null) {
				session.delete(amAnalyticsClaim);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amAnalyticsClaim != null) {
			clearCache(amAnalyticsClaim);
		}

		return amAnalyticsClaim;
	}

	@Override
	public AMAnalyticsClaim updateImpl(AMAnalyticsClaim amAnalyticsClaim) {
		boolean isNew = amAnalyticsClaim.isNew();

		if (!(amAnalyticsClaim instanceof AMAnalyticsClaimModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amAnalyticsClaim.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					amAnalyticsClaim);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amAnalyticsClaim proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMAnalyticsClaim implementation " +
					amAnalyticsClaim.getClass());
		}

		AMAnalyticsClaimModelImpl amAnalyticsClaimModelImpl =
			(AMAnalyticsClaimModelImpl)amAnalyticsClaim;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amAnalyticsClaim.getCreateDate() == null)) {
			if (serviceContext == null) {
				amAnalyticsClaim.setCreateDate(now);
			}
			else {
				amAnalyticsClaim.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!amAnalyticsClaimModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amAnalyticsClaim.setModifiedDate(now);
			}
			else {
				amAnalyticsClaim.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (amAnalyticsClaim.isNew()) {
				session.save(amAnalyticsClaim);

				amAnalyticsClaim.setNew(false);
			}
			else {
				amAnalyticsClaim = (AMAnalyticsClaim)session.merge(
					amAnalyticsClaim);
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
			entityCacheEnabled, AMAnalyticsClaimImpl.class,
			amAnalyticsClaim.getPrimaryKey(), amAnalyticsClaim, false);

		amAnalyticsClaim.resetOriginalValues();

		return amAnalyticsClaim;
	}

	/**
	 * Returns the am analytics claim with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the am analytics claim
	 * @return the am analytics claim
	 * @throws NoSuchAMAnalyticsClaimException if a am analytics claim with the primary key could not be found
	 */
	@Override
	public AMAnalyticsClaim findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAMAnalyticsClaimException {

		AMAnalyticsClaim amAnalyticsClaim = fetchByPrimaryKey(primaryKey);

		if (amAnalyticsClaim == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAMAnalyticsClaimException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amAnalyticsClaim;
	}

	/**
	 * Returns the am analytics claim with the primary key or throws a <code>NoSuchAMAnalyticsClaimException</code> if it could not be found.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim
	 * @throws NoSuchAMAnalyticsClaimException if a am analytics claim with the primary key could not be found
	 */
	@Override
	public AMAnalyticsClaim findByPrimaryKey(long amAnalyticsClaimId)
		throws NoSuchAMAnalyticsClaimException {

		return findByPrimaryKey((Serializable)amAnalyticsClaimId);
	}

	/**
	 * Returns the am analytics claim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim, or <code>null</code> if a am analytics claim with the primary key could not be found
	 */
	@Override
	public AMAnalyticsClaim fetchByPrimaryKey(long amAnalyticsClaimId) {
		return fetchByPrimaryKey((Serializable)amAnalyticsClaimId);
	}

	/**
	 * Returns all the am analytics claims.
	 *
	 * @return the am analytics claims
	 */
	@Override
	public List<AMAnalyticsClaim> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @return the range of am analytics claims
	 */
	@Override
	public List<AMAnalyticsClaim> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics claims
	 */
	@Override
	public List<AMAnalyticsClaim> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsClaim> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics claims
	 */
	@Override
	public List<AMAnalyticsClaim> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsClaim> orderByComparator,
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

		List<AMAnalyticsClaim> list = null;

		if (useFinderCache) {
			list = (List<AMAnalyticsClaim>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMANALYTICSCLAIM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMANALYTICSCLAIM;

				sql = sql.concat(AMAnalyticsClaimModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AMAnalyticsClaim>)QueryUtil.list(
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
	 * Removes all the am analytics claims from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMAnalyticsClaim amAnalyticsClaim : findAll()) {
			remove(amAnalyticsClaim);
		}
	}

	/**
	 * Returns the number of am analytics claims.
	 *
	 * @return the number of am analytics claims
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMANALYTICSCLAIM);

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
		return "amAnalyticsClaimId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMANALYTICSCLAIM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMAnalyticsClaimModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the am analytics claim persistence.
	 */
	@Activate
	public void activate() {
		AMAnalyticsClaimModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AMAnalyticsClaimModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMAnalyticsClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMAnalyticsClaimImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMAnalyticsClaimImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.account.management.model.AMAnalyticsClaim"),
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

	private static final String _SQL_SELECT_AMANALYTICSCLAIM =
		"SELECT amAnalyticsClaim FROM AMAnalyticsClaim amAnalyticsClaim";

	private static final String _SQL_COUNT_AMANALYTICSCLAIM =
		"SELECT COUNT(amAnalyticsClaim) FROM AMAnalyticsClaim amAnalyticsClaim";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amAnalyticsClaim.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMAnalyticsClaim exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AMAnalyticsClaimPersistenceImpl.class);

	static {
		try {
			Class.forName(OTH_AccountPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}