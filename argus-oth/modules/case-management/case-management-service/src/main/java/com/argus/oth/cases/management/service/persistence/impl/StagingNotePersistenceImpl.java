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

import com.argus.oth.cases.management.exception.NoSuchStagingNoteException;
import com.argus.oth.cases.management.model.StagingNote;
import com.argus.oth.cases.management.model.impl.StagingNoteImpl;
import com.argus.oth.cases.management.model.impl.StagingNoteModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingNotePersistence;
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
 * The persistence implementation for the staging note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingNotePersistence.class)
public class StagingNotePersistenceImpl
	extends BasePersistenceImpl<StagingNote> implements StagingNotePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingNoteUtil</code> to access the staging note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingNoteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StagingNotePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StagingNote.class);

		setModelImplClass(StagingNoteImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging note in the entity cache if it is enabled.
	 *
	 * @param stagingNote the staging note
	 */
	@Override
	public void cacheResult(StagingNote stagingNote) {
		entityCache.putResult(
			entityCacheEnabled, StagingNoteImpl.class,
			stagingNote.getPrimaryKey(), stagingNote);

		stagingNote.resetOriginalValues();
	}

	/**
	 * Caches the staging notes in the entity cache if it is enabled.
	 *
	 * @param stagingNotes the staging notes
	 */
	@Override
	public void cacheResult(List<StagingNote> stagingNotes) {
		for (StagingNote stagingNote : stagingNotes) {
			if (entityCache.getResult(
					entityCacheEnabled, StagingNoteImpl.class,
					stagingNote.getPrimaryKey()) == null) {

				cacheResult(stagingNote);
			}
			else {
				stagingNote.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging notes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingNoteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging note.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingNote stagingNote) {
		entityCache.removeResult(
			entityCacheEnabled, StagingNoteImpl.class,
			stagingNote.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingNote> stagingNotes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingNote stagingNote : stagingNotes) {
			entityCache.removeResult(
				entityCacheEnabled, StagingNoteImpl.class,
				stagingNote.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingNoteImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging note with the primary key. Does not add the staging note to the database.
	 *
	 * @param noteId the primary key for the new staging note
	 * @return the new staging note
	 */
	@Override
	public StagingNote create(long noteId) {
		StagingNote stagingNote = new StagingNoteImpl();

		stagingNote.setNew(true);
		stagingNote.setPrimaryKey(noteId);

		return stagingNote;
	}

	/**
	 * Removes the staging note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note that was removed
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	@Override
	public StagingNote remove(long noteId) throws NoSuchStagingNoteException {
		return remove((Serializable)noteId);
	}

	/**
	 * Removes the staging note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging note
	 * @return the staging note that was removed
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	@Override
	public StagingNote remove(Serializable primaryKey)
		throws NoSuchStagingNoteException {

		Session session = null;

		try {
			session = openSession();

			StagingNote stagingNote = (StagingNote)session.get(
				StagingNoteImpl.class, primaryKey);

			if (stagingNote == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingNoteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingNote);
		}
		catch (NoSuchStagingNoteException noSuchEntityException) {
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
	protected StagingNote removeImpl(StagingNote stagingNote) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingNote)) {
				stagingNote = (StagingNote)session.get(
					StagingNoteImpl.class, stagingNote.getPrimaryKeyObj());
			}

			if (stagingNote != null) {
				session.delete(stagingNote);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingNote != null) {
			clearCache(stagingNote);
		}

		return stagingNote;
	}

	@Override
	public StagingNote updateImpl(StagingNote stagingNote) {
		boolean isNew = stagingNote.isNew();

		if (!(stagingNote instanceof StagingNoteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingNote.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stagingNote);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingNote proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingNote implementation " +
					stagingNote.getClass());
		}

		StagingNoteModelImpl stagingNoteModelImpl =
			(StagingNoteModelImpl)stagingNote;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (stagingNote.getCreateDate() == null)) {
			if (serviceContext == null) {
				stagingNote.setCreateDate(now);
			}
			else {
				stagingNote.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!stagingNoteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stagingNote.setModifiedDate(now);
			}
			else {
				stagingNote.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stagingNote);

				stagingNote.setNew(false);
			}
			else {
				stagingNote = (StagingNote)session.merge(stagingNote);
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
			entityCacheEnabled, StagingNoteImpl.class,
			stagingNote.getPrimaryKey(), stagingNote, false);

		stagingNote.resetOriginalValues();

		return stagingNote;
	}

	/**
	 * Returns the staging note with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging note
	 * @return the staging note
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	@Override
	public StagingNote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingNoteException {

		StagingNote stagingNote = fetchByPrimaryKey(primaryKey);

		if (stagingNote == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingNoteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingNote;
	}

	/**
	 * Returns the staging note with the primary key or throws a <code>NoSuchStagingNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note
	 * @throws NoSuchStagingNoteException if a staging note with the primary key could not be found
	 */
	@Override
	public StagingNote findByPrimaryKey(long noteId)
		throws NoSuchStagingNoteException {

		return findByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns the staging note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the staging note
	 * @return the staging note, or <code>null</code> if a staging note with the primary key could not be found
	 */
	@Override
	public StagingNote fetchByPrimaryKey(long noteId) {
		return fetchByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns all the staging notes.
	 *
	 * @return the staging notes
	 */
	@Override
	public List<StagingNote> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @return the range of staging notes
	 */
	@Override
	public List<StagingNote> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging notes
	 */
	@Override
	public List<StagingNote> findAll(
		int start, int end, OrderByComparator<StagingNote> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging notes
	 * @param end the upper bound of the range of staging notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging notes
	 */
	@Override
	public List<StagingNote> findAll(
		int start, int end, OrderByComparator<StagingNote> orderByComparator,
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

		List<StagingNote> list = null;

		if (useFinderCache) {
			list = (List<StagingNote>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGNOTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGNOTE;

				sql = sql.concat(StagingNoteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingNote>)QueryUtil.list(
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
	 * Removes all the staging notes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingNote stagingNote : findAll()) {
			remove(stagingNote);
		}
	}

	/**
	 * Returns the number of staging notes.
	 *
	 * @return the number of staging notes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGINGNOTE);

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
		return "noteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGNOTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingNoteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging note persistence.
	 */
	@Activate
	public void activate() {
		StagingNoteModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingNoteModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StagingNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingNoteImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingNote"),
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

	private static final String _SQL_SELECT_STAGINGNOTE =
		"SELECT stagingNote FROM StagingNote stagingNote";

	private static final String _SQL_COUNT_STAGINGNOTE =
		"SELECT COUNT(stagingNote) FROM StagingNote stagingNote";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stagingNote.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingNote exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingNotePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type", "code"});

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}