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

import com.argus.oth.cases.management.exception.NoSuchStagingClaimDetailException;
import com.argus.oth.cases.management.model.StagingClaimDetail;
import com.argus.oth.cases.management.model.impl.StagingClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingClaimDetailPersistence;
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
 * The persistence implementation for the staging claim detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingClaimDetailPersistence.class)
public class StagingClaimDetailPersistenceImpl
	extends BasePersistenceImpl<StagingClaimDetail>
	implements StagingClaimDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingClaimDetailUtil</code> to access the staging claim detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingClaimDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingClaimDetailPersistenceImpl() {
		setModelClass(StagingClaimDetail.class);

		setModelImplClass(StagingClaimDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging claim detail in the entity cache if it is enabled.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 */
	@Override
	public void cacheResult(StagingClaimDetail stagingClaimDetail) {
		entityCache.putResult(
			entityCacheEnabled, StagingClaimDetailImpl.class,
			stagingClaimDetail.getPrimaryKey(), stagingClaimDetail);

		stagingClaimDetail.resetOriginalValues();
	}

	/**
	 * Caches the staging claim details in the entity cache if it is enabled.
	 *
	 * @param stagingClaimDetails the staging claim details
	 */
	@Override
	public void cacheResult(List<StagingClaimDetail> stagingClaimDetails) {
		for (StagingClaimDetail stagingClaimDetail : stagingClaimDetails) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingClaimDetailImpl.class,
					stagingClaimDetail.getPrimaryKey()) == null) {

				cacheResult(stagingClaimDetail);
			}
			else {
				stagingClaimDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging claim details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingClaimDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging claim detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingClaimDetail stagingClaimDetail) {
		entityCache.removeResult(
			entityCacheEnabled, StagingClaimDetailImpl.class,
			stagingClaimDetail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingClaimDetail> stagingClaimDetails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingClaimDetail stagingClaimDetail : stagingClaimDetails) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClaimDetailImpl.class,
				stagingClaimDetail.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingClaimDetailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging claim detail with the primary key. Does not add the staging claim detail to the database.
	 *
	 * @param stagingClaimDetailId the primary key for the new staging claim detail
	 * @return the new staging claim detail
	 */
	@Override
	public StagingClaimDetail create(long stagingClaimDetailId) {
		StagingClaimDetail stagingClaimDetail = new StagingClaimDetailImpl();

		stagingClaimDetail.setNew(true);
		stagingClaimDetail.setPrimaryKey(stagingClaimDetailId);

		return stagingClaimDetail;
	}

	/**
	 * Removes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	@Override
	public StagingClaimDetail remove(long stagingClaimDetailId)
		throws NoSuchStagingClaimDetailException {

		return remove((Serializable)stagingClaimDetailId);
	}

	/**
	 * Removes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	@Override
	public StagingClaimDetail remove(Serializable primaryKey)
		throws NoSuchStagingClaimDetailException {

		Session session = null;

		try {
			session = openSession();

			StagingClaimDetail stagingClaimDetail =
				(StagingClaimDetail)session.get(
					StagingClaimDetailImpl.class, primaryKey);

			if (stagingClaimDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingClaimDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingClaimDetail);
		}
		catch (NoSuchStagingClaimDetailException noSuchEntityException) {
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
	protected StagingClaimDetail removeImpl(
		StagingClaimDetail stagingClaimDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingClaimDetail)) {
				stagingClaimDetail = (StagingClaimDetail)session.get(
					StagingClaimDetailImpl.class,
					stagingClaimDetail.getPrimaryKeyObj());
			}

			if (stagingClaimDetail != null) {
				session.delete(stagingClaimDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingClaimDetail != null) {
			clearCache(stagingClaimDetail);
		}

		return stagingClaimDetail;
	}

	@Override
	public StagingClaimDetail updateImpl(
		StagingClaimDetail stagingClaimDetail) {

		boolean isNew = stagingClaimDetail.isNew();

		if (!(stagingClaimDetail instanceof StagingClaimDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingClaimDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingClaimDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingClaimDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingClaimDetail implementation " +
					stagingClaimDetail.getClass());
		}

		StagingClaimDetailModelImpl stagingClaimDetailModelImpl =
			(StagingClaimDetailModelImpl)stagingClaimDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingClaimDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingClaimDetail.setCreateDate(now);
			}
			else {
				stagingClaimDetail.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingClaimDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingClaimDetail.setModifiedDate(now);
			}
			else {
				stagingClaimDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingClaimDetail);

				stagingClaimDetail.setNew(false);
			}
			else {
				stagingClaimDetail = (StagingClaimDetail)session.merge(
					stagingClaimDetail);
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
			entityCacheEnabled, StagingClaimDetailImpl.class,
			stagingClaimDetail.getPrimaryKey(), stagingClaimDetail, false);

		stagingClaimDetail.resetOriginalValues();

		return stagingClaimDetail;
	}

	/**
	 * Returns the staging claim detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	@Override
	public StagingClaimDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingClaimDetailException {

		StagingClaimDetail stagingClaimDetail = fetchByPrimaryKey(primaryKey);

		if (stagingClaimDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingClaimDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingClaimDetail;
	}

	/**
	 * Returns the staging claim detail with the primary key or throws a <code>NoSuchStagingClaimDetailException</code> if it could not be found.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws NoSuchStagingClaimDetailException if a staging claim detail with the primary key could not be found
	 */
	@Override
	public StagingClaimDetail findByPrimaryKey(long stagingClaimDetailId)
		throws NoSuchStagingClaimDetailException {

		return findByPrimaryKey((Serializable)stagingClaimDetailId);
	}

	/**
	 * Returns the staging claim detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail, or <code>null</code> if a staging claim detail with the primary key could not be found
	 */
	@Override
	public StagingClaimDetail fetchByPrimaryKey(long stagingClaimDetailId) {
		return fetchByPrimaryKey((Serializable)stagingClaimDetailId);
	}

	/**
	 * Returns all the staging claim details.
	 *
	 * @return the staging claim details
	 */
	@Override
	public List<StagingClaimDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @return the range of staging claim details
	 */
	@Override
	public List<StagingClaimDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging claim details
	 */
	@Override
	public List<StagingClaimDetail> findAll(
		int start, int end,
		OrderByComparator<StagingClaimDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging claim details
	 */
	@Override
	public List<StagingClaimDetail> findAll(
		int start, int end,
		OrderByComparator<StagingClaimDetail> orderByComparator,
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

		List<StagingClaimDetail> list = null;

		if (useFinderCache) {
			list = (List<StagingClaimDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGCLAIMDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGCLAIMDETAIL;

				sql = sql.concat(StagingClaimDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingClaimDetail>)QueryUtil.list(
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
	 * Removes all the staging claim details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingClaimDetail stagingClaimDetail : findAll()) {
			remove(stagingClaimDetail);
		}
	}

	/**
	 * Returns the number of staging claim details.
	 *
	 * @return the number of staging claim details
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
					_SQL_COUNT_STAGINGCLAIMDETAIL);

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
		return "stagingClaimDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGCLAIMDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingClaimDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging claim detail persistence.
	 */
	@Activate
	public void activate() {
		StagingClaimDetailModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingClaimDetailModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClaimDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingClaimDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingClaimDetailImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingClaimDetail"),
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

	private static final String _SQL_SELECT_STAGINGCLAIMDETAIL =
		"SELECT stagingClaimDetail FROM StagingClaimDetail stagingClaimDetail";

	private static final String _SQL_COUNT_STAGINGCLAIMDETAIL =
		"SELECT COUNT(stagingClaimDetail) FROM StagingClaimDetail stagingClaimDetail";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingClaimDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingClaimDetail exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingClaimDetailPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}