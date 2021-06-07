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

import com.argus.oth.account.management.exception.NoSuchAMAnalyticsTelephonyException;
import com.argus.oth.account.management.model.AMAnalyticsTelephony;
import com.argus.oth.account.management.model.impl.AMAnalyticsTelephonyImpl;
import com.argus.oth.account.management.model.impl.AMAnalyticsTelephonyModelImpl;
import com.argus.oth.account.management.service.persistence.AMAnalyticsTelephonyPersistence;
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
 * The persistence implementation for the am analytics telephony service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AMAnalyticsTelephonyPersistence.class)
public class AMAnalyticsTelephonyPersistenceImpl
	extends BasePersistenceImpl<AMAnalyticsTelephony>
	implements AMAnalyticsTelephonyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMAnalyticsTelephonyUtil</code> to access the am analytics telephony persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMAnalyticsTelephonyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AMAnalyticsTelephonyPersistenceImpl() {
		setModelClass(AMAnalyticsTelephony.class);

		setModelImplClass(AMAnalyticsTelephonyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the am analytics telephony in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsTelephony the am analytics telephony
	 */
	@Override
	public void cacheResult(AMAnalyticsTelephony amAnalyticsTelephony) {
		entityCache.putResult(
			entityCacheEnabled, AMAnalyticsTelephonyImpl.class,
			amAnalyticsTelephony.getPrimaryKey(), amAnalyticsTelephony);

		amAnalyticsTelephony.resetOriginalValues();
	}

	/**
	 * Caches the am analytics telephonies in the entity cache if it is enabled.
	 *
	 * @param amAnalyticsTelephonies the am analytics telephonies
	 */
	@Override
	public void cacheResult(List<AMAnalyticsTelephony> amAnalyticsTelephonies) {
		for (AMAnalyticsTelephony amAnalyticsTelephony :
				amAnalyticsTelephonies) {

			if (entityCache.getResult(
					entityCacheEnabled, AMAnalyticsTelephonyImpl.class,
					amAnalyticsTelephony.getPrimaryKey()) == null) {

				cacheResult(amAnalyticsTelephony);
			}
			else {
				amAnalyticsTelephony.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all am analytics telephonies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMAnalyticsTelephonyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the am analytics telephony.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMAnalyticsTelephony amAnalyticsTelephony) {
		entityCache.removeResult(
			entityCacheEnabled, AMAnalyticsTelephonyImpl.class,
			amAnalyticsTelephony.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMAnalyticsTelephony> amAnalyticsTelephonies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMAnalyticsTelephony amAnalyticsTelephony :
				amAnalyticsTelephonies) {

			entityCache.removeResult(
				entityCacheEnabled, AMAnalyticsTelephonyImpl.class,
				amAnalyticsTelephony.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, AMAnalyticsTelephonyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new am analytics telephony with the primary key. Does not add the am analytics telephony to the database.
	 *
	 * @param amAnalyticsTelephonyId the primary key for the new am analytics telephony
	 * @return the new am analytics telephony
	 */
	@Override
	public AMAnalyticsTelephony create(long amAnalyticsTelephonyId) {
		AMAnalyticsTelephony amAnalyticsTelephony =
			new AMAnalyticsTelephonyImpl();

		amAnalyticsTelephony.setNew(true);
		amAnalyticsTelephony.setPrimaryKey(amAnalyticsTelephonyId);

		amAnalyticsTelephony.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amAnalyticsTelephony;
	}

	/**
	 * Removes the am analytics telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony that was removed
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	@Override
	public AMAnalyticsTelephony remove(long amAnalyticsTelephonyId)
		throws NoSuchAMAnalyticsTelephonyException {

		return remove((Serializable)amAnalyticsTelephonyId);
	}

	/**
	 * Removes the am analytics telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the am analytics telephony
	 * @return the am analytics telephony that was removed
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	@Override
	public AMAnalyticsTelephony remove(Serializable primaryKey)
		throws NoSuchAMAnalyticsTelephonyException {

		Session session = null;

		try {
			session = openSession();

			AMAnalyticsTelephony amAnalyticsTelephony =
				(AMAnalyticsTelephony)session.get(
					AMAnalyticsTelephonyImpl.class, primaryKey);

			if (amAnalyticsTelephony == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMAnalyticsTelephonyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amAnalyticsTelephony);
		}
		catch (NoSuchAMAnalyticsTelephonyException noSuchEntityException) {
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
	protected AMAnalyticsTelephony removeImpl(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amAnalyticsTelephony)) {
				amAnalyticsTelephony = (AMAnalyticsTelephony)session.get(
					AMAnalyticsTelephonyImpl.class,
					amAnalyticsTelephony.getPrimaryKeyObj());
			}

			if (amAnalyticsTelephony != null) {
				session.delete(amAnalyticsTelephony);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amAnalyticsTelephony != null) {
			clearCache(amAnalyticsTelephony);
		}

		return amAnalyticsTelephony;
	}

	@Override
	public AMAnalyticsTelephony updateImpl(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		boolean isNew = amAnalyticsTelephony.isNew();

		if (!(amAnalyticsTelephony instanceof AMAnalyticsTelephonyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amAnalyticsTelephony.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					amAnalyticsTelephony);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amAnalyticsTelephony proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMAnalyticsTelephony implementation " +
					amAnalyticsTelephony.getClass());
		}

		AMAnalyticsTelephonyModelImpl amAnalyticsTelephonyModelImpl =
			(AMAnalyticsTelephonyModelImpl)amAnalyticsTelephony;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amAnalyticsTelephony.getCreateDate() == null)) {
			if (serviceContext == null) {
				amAnalyticsTelephony.setCreateDate(now);
			}
			else {
				amAnalyticsTelephony.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!amAnalyticsTelephonyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amAnalyticsTelephony.setModifiedDate(now);
			}
			else {
				amAnalyticsTelephony.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (amAnalyticsTelephony.isNew()) {
				session.save(amAnalyticsTelephony);

				amAnalyticsTelephony.setNew(false);
			}
			else {
				amAnalyticsTelephony = (AMAnalyticsTelephony)session.merge(
					amAnalyticsTelephony);
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
			entityCacheEnabled, AMAnalyticsTelephonyImpl.class,
			amAnalyticsTelephony.getPrimaryKey(), amAnalyticsTelephony, false);

		amAnalyticsTelephony.resetOriginalValues();

		return amAnalyticsTelephony;
	}

	/**
	 * Returns the am analytics telephony with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the am analytics telephony
	 * @return the am analytics telephony
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	@Override
	public AMAnalyticsTelephony findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAMAnalyticsTelephonyException {

		AMAnalyticsTelephony amAnalyticsTelephony = fetchByPrimaryKey(
			primaryKey);

		if (amAnalyticsTelephony == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAMAnalyticsTelephonyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amAnalyticsTelephony;
	}

	/**
	 * Returns the am analytics telephony with the primary key or throws a <code>NoSuchAMAnalyticsTelephonyException</code> if it could not be found.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony
	 * @throws NoSuchAMAnalyticsTelephonyException if a am analytics telephony with the primary key could not be found
	 */
	@Override
	public AMAnalyticsTelephony findByPrimaryKey(long amAnalyticsTelephonyId)
		throws NoSuchAMAnalyticsTelephonyException {

		return findByPrimaryKey((Serializable)amAnalyticsTelephonyId);
	}

	/**
	 * Returns the am analytics telephony with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony, or <code>null</code> if a am analytics telephony with the primary key could not be found
	 */
	@Override
	public AMAnalyticsTelephony fetchByPrimaryKey(long amAnalyticsTelephonyId) {
		return fetchByPrimaryKey((Serializable)amAnalyticsTelephonyId);
	}

	/**
	 * Returns all the am analytics telephonies.
	 *
	 * @return the am analytics telephonies
	 */
	@Override
	public List<AMAnalyticsTelephony> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @return the range of am analytics telephonies
	 */
	@Override
	public List<AMAnalyticsTelephony> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of am analytics telephonies
	 */
	@Override
	public List<AMAnalyticsTelephony> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsTelephony> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of am analytics telephonies
	 */
	@Override
	public List<AMAnalyticsTelephony> findAll(
		int start, int end,
		OrderByComparator<AMAnalyticsTelephony> orderByComparator,
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

		List<AMAnalyticsTelephony> list = null;

		if (useFinderCache) {
			list = (List<AMAnalyticsTelephony>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMANALYTICSTELEPHONY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMANALYTICSTELEPHONY;

				sql = sql.concat(AMAnalyticsTelephonyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AMAnalyticsTelephony>)QueryUtil.list(
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
	 * Removes all the am analytics telephonies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMAnalyticsTelephony amAnalyticsTelephony : findAll()) {
			remove(amAnalyticsTelephony);
		}
	}

	/**
	 * Returns the number of am analytics telephonies.
	 *
	 * @return the number of am analytics telephonies
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
					_SQL_COUNT_AMANALYTICSTELEPHONY);

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
		return "amAnalyticsTelephonyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMANALYTICSTELEPHONY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMAnalyticsTelephonyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the am analytics telephony persistence.
	 */
	@Activate
	public void activate() {
		AMAnalyticsTelephonyModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AMAnalyticsTelephonyModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AMAnalyticsTelephonyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			AMAnalyticsTelephonyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMAnalyticsTelephonyImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.account.management.model.AMAnalyticsTelephony"),
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

	private static final String _SQL_SELECT_AMANALYTICSTELEPHONY =
		"SELECT amAnalyticsTelephony FROM AMAnalyticsTelephony amAnalyticsTelephony";

	private static final String _SQL_COUNT_AMANALYTICSTELEPHONY =
		"SELECT COUNT(amAnalyticsTelephony) FROM AMAnalyticsTelephony amAnalyticsTelephony";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"amAnalyticsTelephony.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMAnalyticsTelephony exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AMAnalyticsTelephonyPersistenceImpl.class);

	static {
		try {
			Class.forName(OTH_AccountPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}