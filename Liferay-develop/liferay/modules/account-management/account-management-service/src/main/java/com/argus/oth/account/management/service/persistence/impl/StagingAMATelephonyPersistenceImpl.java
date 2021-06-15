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

import com.argus.oth.account.management.exception.NoSuchStagingAMATelephonyException;
import com.argus.oth.account.management.model.StagingAMATelephony;
import com.argus.oth.account.management.model.impl.StagingAMATelephonyImpl;
import com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl;
import com.argus.oth.account.management.service.persistence.StagingAMATelephonyPersistence;
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
 * The persistence implementation for the staging ama telephony service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingAMATelephonyPersistence.class)
public class StagingAMATelephonyPersistenceImpl
	extends BasePersistenceImpl<StagingAMATelephony>
	implements StagingAMATelephonyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingAMATelephonyUtil</code> to access the staging ama telephony persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingAMATelephonyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingAMATelephonyPersistenceImpl() {
		setModelClass(StagingAMATelephony.class);

		setModelImplClass(StagingAMATelephonyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging ama telephony in the entity cache if it is enabled.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 */
	@Override
	public void cacheResult(StagingAMATelephony stagingAMATelephony) {
		entityCache.putResult(
			entityCacheEnabled, StagingAMATelephonyImpl.class,
			stagingAMATelephony.getPrimaryKey(), stagingAMATelephony);

		stagingAMATelephony.resetOriginalValues();
	}

	/**
	 * Caches the staging ama telephonies in the entity cache if it is enabled.
	 *
	 * @param stagingAMATelephonies the staging ama telephonies
	 */
	@Override
	public void cacheResult(List<StagingAMATelephony> stagingAMATelephonies) {
		for (StagingAMATelephony stagingAMATelephony : stagingAMATelephonies) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingAMATelephonyImpl.class,
					stagingAMATelephony.getPrimaryKey()) == null) {

				cacheResult(stagingAMATelephony);
			}
			else {
				stagingAMATelephony.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging ama telephonies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingAMATelephonyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging ama telephony.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingAMATelephony stagingAMATelephony) {
		entityCache.removeResult(
			entityCacheEnabled, StagingAMATelephonyImpl.class,
			stagingAMATelephony.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingAMATelephony> stagingAMATelephonies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingAMATelephony stagingAMATelephony : stagingAMATelephonies) {
			entityCache.removeResult(
				entityCacheEnabled, StagingAMATelephonyImpl.class,
				stagingAMATelephony.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingAMATelephonyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging ama telephony with the primary key. Does not add the staging ama telephony to the database.
	 *
	 * @param stagingAMATelephonyId the primary key for the new staging ama telephony
	 * @return the new staging ama telephony
	 */
	@Override
	public StagingAMATelephony create(long stagingAMATelephonyId) {
		StagingAMATelephony stagingAMATelephony = new StagingAMATelephonyImpl();

		stagingAMATelephony.setNew(true);
		stagingAMATelephony.setPrimaryKey(stagingAMATelephonyId);

		return stagingAMATelephony;
	}

	/**
	 * Removes the staging ama telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony that was removed
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public StagingAMATelephony remove(long stagingAMATelephonyId)
		throws NoSuchStagingAMATelephonyException {

		return remove((Serializable)stagingAMATelephonyId);
	}

	/**
	 * Removes the staging ama telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging ama telephony
	 * @return the staging ama telephony that was removed
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public StagingAMATelephony remove(Serializable primaryKey)
		throws NoSuchStagingAMATelephonyException {

		Session session = null;

		try {
			session = openSession();

			StagingAMATelephony stagingAMATelephony =
				(StagingAMATelephony)session.get(
					StagingAMATelephonyImpl.class, primaryKey);

			if (stagingAMATelephony == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingAMATelephonyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingAMATelephony);
		}
		catch (NoSuchStagingAMATelephonyException noSuchEntityException) {
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
	protected StagingAMATelephony removeImpl(
		StagingAMATelephony stagingAMATelephony) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingAMATelephony)) {
				stagingAMATelephony = (StagingAMATelephony)session.get(
					StagingAMATelephonyImpl.class,
					stagingAMATelephony.getPrimaryKeyObj());
			}

			if (stagingAMATelephony != null) {
				session.delete(stagingAMATelephony);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingAMATelephony != null) {
			clearCache(stagingAMATelephony);
		}

		return stagingAMATelephony;
	}

	@Override
	public StagingAMATelephony updateImpl(
		StagingAMATelephony stagingAMATelephony) {

		boolean isNew = stagingAMATelephony.isNew();

		if (!(stagingAMATelephony instanceof StagingAMATelephonyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingAMATelephony.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingAMATelephony);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingAMATelephony proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingAMATelephony implementation " +
					stagingAMATelephony.getClass());
		}

		StagingAMATelephonyModelImpl stagingAMATelephonyModelImpl =
			(StagingAMATelephonyModelImpl)stagingAMATelephony;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingAMATelephony.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingAMATelephony.setCreateDate(now);
			}
			else {
				stagingAMATelephony.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingAMATelephonyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingAMATelephony.setModifiedDate(now);
			}
			else {
				stagingAMATelephony.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (stagingAMATelephony.isNew()) {
				session.save(stagingAMATelephony);

				stagingAMATelephony.setNew(false);
			}
			else {
				stagingAMATelephony = (StagingAMATelephony)session.merge(
					stagingAMATelephony);
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
			entityCacheEnabled, StagingAMATelephonyImpl.class,
			stagingAMATelephony.getPrimaryKey(), stagingAMATelephony, false);

		stagingAMATelephony.resetOriginalValues();

		return stagingAMATelephony;
	}

	/**
	 * Returns the staging ama telephony with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging ama telephony
	 * @return the staging ama telephony
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public StagingAMATelephony findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingAMATelephonyException {

		StagingAMATelephony stagingAMATelephony = fetchByPrimaryKey(primaryKey);

		if (stagingAMATelephony == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingAMATelephonyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingAMATelephony;
	}

	/**
	 * Returns the staging ama telephony with the primary key or throws a <code>NoSuchStagingAMATelephonyException</code> if it could not be found.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony
	 * @throws NoSuchStagingAMATelephonyException if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public StagingAMATelephony findByPrimaryKey(long stagingAMATelephonyId)
		throws NoSuchStagingAMATelephonyException {

		return findByPrimaryKey((Serializable)stagingAMATelephonyId);
	}

	/**
	 * Returns the staging ama telephony with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony, or <code>null</code> if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public StagingAMATelephony fetchByPrimaryKey(long stagingAMATelephonyId) {
		return fetchByPrimaryKey((Serializable)stagingAMATelephonyId);
	}

	/**
	 * Returns all the staging ama telephonies.
	 *
	 * @return the staging ama telephonies
	 */
	@Override
	public List<StagingAMATelephony> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @return the range of staging ama telephonies
	 */
	@Override
	public List<StagingAMATelephony> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging ama telephonies
	 */
	@Override
	public List<StagingAMATelephony> findAll(
		int start, int end,
		OrderByComparator<StagingAMATelephony> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging ama telephonies
	 */
	@Override
	public List<StagingAMATelephony> findAll(
		int start, int end,
		OrderByComparator<StagingAMATelephony> orderByComparator,
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

		List<StagingAMATelephony> list = null;

		if (useFinderCache) {
			list = (List<StagingAMATelephony>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGAMATELEPHONY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGAMATELEPHONY;

				sql = sql.concat(StagingAMATelephonyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingAMATelephony>)QueryUtil.list(
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
	 * Removes all the staging ama telephonies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingAMATelephony stagingAMATelephony : findAll()) {
			remove(stagingAMATelephony);
		}
	}

	/**
	 * Returns the number of staging ama telephonies.
	 *
	 * @return the number of staging ama telephonies
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
					_SQL_COUNT_STAGINGAMATELEPHONY);

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
		return "stagingAMATelephonyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGAMATELEPHONY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingAMATelephonyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging ama telephony persistence.
	 */
	@Activate
	public void activate() {
		StagingAMATelephonyModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingAMATelephonyModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAMATelephonyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAMATelephonyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingAMATelephonyImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.account.management.model.StagingAMATelephony"),
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

	private static final String _SQL_SELECT_STAGINGAMATELEPHONY =
		"SELECT stagingAMATelephony FROM StagingAMATelephony stagingAMATelephony";

	private static final String _SQL_COUNT_STAGINGAMATELEPHONY =
		"SELECT COUNT(stagingAMATelephony) FROM StagingAMATelephony stagingAMATelephony";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingAMATelephony.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingAMATelephony exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingAMATelephonyPersistenceImpl.class);

	static {
		try {
			Class.forName(OTH_AccountPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}