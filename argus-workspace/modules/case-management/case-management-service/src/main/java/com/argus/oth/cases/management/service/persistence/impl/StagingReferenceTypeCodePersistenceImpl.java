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

import com.argus.oth.cases.management.exception.NoSuchStagingReferenceTypeCodeException;
import com.argus.oth.cases.management.model.StagingReferenceTypeCode;
import com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeImpl;
import com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingReferenceTypeCodePersistence;
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
 * The persistence implementation for the staging reference type code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingReferenceTypeCodePersistence.class)
public class StagingReferenceTypeCodePersistenceImpl
	extends BasePersistenceImpl<StagingReferenceTypeCode>
	implements StagingReferenceTypeCodePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingReferenceTypeCodeUtil</code> to access the staging reference type code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingReferenceTypeCodeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingReferenceTypeCodePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");
		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StagingReferenceTypeCode.class);

		setModelImplClass(StagingReferenceTypeCodeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging reference type code in the entity cache if it is enabled.
	 *
	 * @param stagingReferenceTypeCode the staging reference type code
	 */
	@Override
	public void cacheResult(StagingReferenceTypeCode stagingReferenceTypeCode) {
		entityCache.putResult(
			entityCacheEnabled, StagingReferenceTypeCodeImpl.class,
			stagingReferenceTypeCode.getPrimaryKey(), stagingReferenceTypeCode);

		stagingReferenceTypeCode.resetOriginalValues();
	}

	/**
	 * Caches the staging reference type codes in the entity cache if it is enabled.
	 *
	 * @param stagingReferenceTypeCodes the staging reference type codes
	 */
	@Override
	public void cacheResult(
		List<StagingReferenceTypeCode> stagingReferenceTypeCodes) {

		for (StagingReferenceTypeCode stagingReferenceTypeCode :
				stagingReferenceTypeCodes) {

			if (entityCache.getResult(
					entityCacheEnabled, StagingReferenceTypeCodeImpl.class,
					stagingReferenceTypeCode.getPrimaryKey()) == null) {

				cacheResult(stagingReferenceTypeCode);
			}
			else {
				stagingReferenceTypeCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging reference type codes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingReferenceTypeCodeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging reference type code.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingReferenceTypeCode stagingReferenceTypeCode) {
		entityCache.removeResult(
			entityCacheEnabled, StagingReferenceTypeCodeImpl.class,
			stagingReferenceTypeCode.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StagingReferenceTypeCode> stagingReferenceTypeCodes) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingReferenceTypeCode stagingReferenceTypeCode :
				stagingReferenceTypeCodes) {

			entityCache.removeResult(
				entityCacheEnabled, StagingReferenceTypeCodeImpl.class,
				stagingReferenceTypeCode.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingReferenceTypeCodeImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new staging reference type code with the primary key. Does not add the staging reference type code to the database.
	 *
	 * @param stagingReferenceTypeCodeId the primary key for the new staging reference type code
	 * @return the new staging reference type code
	 */
	@Override
	public StagingReferenceTypeCode create(long stagingReferenceTypeCodeId) {
		StagingReferenceTypeCode stagingReferenceTypeCode =
			new StagingReferenceTypeCodeImpl();

		stagingReferenceTypeCode.setNew(true);
		stagingReferenceTypeCode.setPrimaryKey(stagingReferenceTypeCodeId);

		return stagingReferenceTypeCode;
	}

	/**
	 * Removes the staging reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code that was removed
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	@Override
	public StagingReferenceTypeCode remove(long stagingReferenceTypeCodeId)
		throws NoSuchStagingReferenceTypeCodeException {

		return remove((Serializable)stagingReferenceTypeCodeId);
	}

	/**
	 * Removes the staging reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging reference type code
	 * @return the staging reference type code that was removed
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	@Override
	public StagingReferenceTypeCode remove(Serializable primaryKey)
		throws NoSuchStagingReferenceTypeCodeException {

		Session session = null;

		try {
			session = openSession();

			StagingReferenceTypeCode stagingReferenceTypeCode =
				(StagingReferenceTypeCode)session.get(
					StagingReferenceTypeCodeImpl.class, primaryKey);

			if (stagingReferenceTypeCode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingReferenceTypeCodeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingReferenceTypeCode);
		}
		catch (NoSuchStagingReferenceTypeCodeException noSuchEntityException) {
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
	protected StagingReferenceTypeCode removeImpl(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingReferenceTypeCode)) {
				stagingReferenceTypeCode =
					(StagingReferenceTypeCode)session.get(
						StagingReferenceTypeCodeImpl.class,
						stagingReferenceTypeCode.getPrimaryKeyObj());
			}

			if (stagingReferenceTypeCode != null) {
				session.delete(stagingReferenceTypeCode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingReferenceTypeCode != null) {
			clearCache(stagingReferenceTypeCode);
		}

		return stagingReferenceTypeCode;
	}

	@Override
	public StagingReferenceTypeCode updateImpl(
		StagingReferenceTypeCode stagingReferenceTypeCode) {

		boolean isNew = stagingReferenceTypeCode.isNew();

		if (!(stagingReferenceTypeCode instanceof
				StagingReferenceTypeCodeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingReferenceTypeCode.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingReferenceTypeCode);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingReferenceTypeCode proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingReferenceTypeCode implementation " +
					stagingReferenceTypeCode.getClass());
		}

		StagingReferenceTypeCodeModelImpl stagingReferenceTypeCodeModelImpl =
			(StagingReferenceTypeCodeModelImpl)stagingReferenceTypeCode;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingReferenceTypeCode.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingReferenceTypeCode.setCreateDate(now);
			}
			else {
				stagingReferenceTypeCode.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!stagingReferenceTypeCodeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingReferenceTypeCode.setModifiedDate(now);
			}
			else {
				stagingReferenceTypeCode.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingReferenceTypeCode);

				stagingReferenceTypeCode.setNew(false);
			}
			else {
				stagingReferenceTypeCode =
					(StagingReferenceTypeCode)session.merge(
						stagingReferenceTypeCode);
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
			entityCacheEnabled, StagingReferenceTypeCodeImpl.class,
			stagingReferenceTypeCode.getPrimaryKey(), stagingReferenceTypeCode,
			false);

		stagingReferenceTypeCode.resetOriginalValues();

		return stagingReferenceTypeCode;
	}

	/**
	 * Returns the staging reference type code with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging reference type code
	 * @return the staging reference type code
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	@Override
	public StagingReferenceTypeCode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingReferenceTypeCodeException {

		StagingReferenceTypeCode stagingReferenceTypeCode = fetchByPrimaryKey(
			primaryKey);

		if (stagingReferenceTypeCode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingReferenceTypeCodeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingReferenceTypeCode;
	}

	/**
	 * Returns the staging reference type code with the primary key or throws a <code>NoSuchStagingReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	@Override
	public StagingReferenceTypeCode findByPrimaryKey(
			long stagingReferenceTypeCodeId)
		throws NoSuchStagingReferenceTypeCodeException {

		return findByPrimaryKey((Serializable)stagingReferenceTypeCodeId);
	}

	/**
	 * Returns the staging reference type code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code, or <code>null</code> if a staging reference type code with the primary key could not be found
	 */
	@Override
	public StagingReferenceTypeCode fetchByPrimaryKey(
		long stagingReferenceTypeCodeId) {

		return fetchByPrimaryKey((Serializable)stagingReferenceTypeCodeId);
	}

	/**
	 * Returns all the staging reference type codes.
	 *
	 * @return the staging reference type codes
	 */
	@Override
	public List<StagingReferenceTypeCode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @return the range of staging reference type codes
	 */
	@Override
	public List<StagingReferenceTypeCode> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging reference type codes
	 */
	@Override
	public List<StagingReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<StagingReferenceTypeCode> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging reference type codes
	 */
	@Override
	public List<StagingReferenceTypeCode> findAll(
		int start, int end,
		OrderByComparator<StagingReferenceTypeCode> orderByComparator,
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

		List<StagingReferenceTypeCode> list = null;

		if (useFinderCache) {
			list = (List<StagingReferenceTypeCode>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGREFERENCETYPECODE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGREFERENCETYPECODE;

				sql = sql.concat(
					StagingReferenceTypeCodeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingReferenceTypeCode>)QueryUtil.list(
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
	 * Removes all the staging reference type codes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingReferenceTypeCode stagingReferenceTypeCode : findAll()) {
			remove(stagingReferenceTypeCode);
		}
	}

	/**
	 * Returns the number of staging reference type codes.
	 *
	 * @return the number of staging reference type codes
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
					_SQL_COUNT_STAGINGREFERENCETYPECODE);

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
		return "stagingReferenceTypeCodeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGREFERENCETYPECODE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingReferenceTypeCodeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging reference type code persistence.
	 */
	@Activate
	public void activate() {
		StagingReferenceTypeCodeModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		StagingReferenceTypeCodeModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingReferenceTypeCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingReferenceTypeCodeImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingReferenceTypeCode"),
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

	private static final String _SQL_SELECT_STAGINGREFERENCETYPECODE =
		"SELECT stagingReferenceTypeCode FROM StagingReferenceTypeCode stagingReferenceTypeCode";

	private static final String _SQL_COUNT_STAGINGREFERENCETYPECODE =
		"SELECT COUNT(stagingReferenceTypeCode) FROM StagingReferenceTypeCode stagingReferenceTypeCode";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stagingReferenceTypeCode.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingReferenceTypeCode exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingReferenceTypeCodePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type", "key"});

}