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

import com.argus.oth.cases.management.exception.NoSuchDataRequestException;
import com.argus.oth.cases.management.model.DataRequest;
import com.argus.oth.cases.management.model.impl.DataRequestImpl;
import com.argus.oth.cases.management.model.impl.DataRequestModelImpl;
import com.argus.oth.cases.management.service.persistence.DataRequestPersistence;
import com.argus.oth.cases.management.service.persistence.impl.constants.OTHPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the data request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DataRequestPersistence.class)
public class DataRequestPersistenceImpl
	extends BasePersistenceImpl<DataRequest> implements DataRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataRequestUtil</code> to access the data request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataRequestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByClientId_Type;
	private FinderPath _finderPathCountByClientId_Type;

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the matching data request
	 * @throws NoSuchDataRequestException if a matching data request could not be found
	 */
	@Override
	public DataRequest findByClientId_Type(long clientId, String type)
		throws NoSuchDataRequestException {

		DataRequest dataRequest = fetchByClientId_Type(clientId, type);

		if (dataRequest == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("clientId=");
			sb.append(clientId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataRequestException(sb.toString());
		}

		return dataRequest;
	}

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	@Override
	public DataRequest fetchByClientId_Type(long clientId, String type) {
		return fetchByClientId_Type(clientId, type, true);
	}

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	@Override
	public DataRequest fetchByClientId_Type(
		long clientId, String type, boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {clientId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByClientId_Type, finderArgs, this);
		}

		if (result instanceof DataRequest) {
			DataRequest dataRequest = (DataRequest)result;

			if ((clientId != dataRequest.getClientId()) ||
				!Objects.equals(type, dataRequest.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATAREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTID_TYPE_CLIENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLIENTID_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_CLIENTID_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientId);

				if (bindType) {
					queryPos.add(type);
				}

				List<DataRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByClientId_Type, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {clientId, type};
							}

							_log.warn(
								"DataRequestPersistenceImpl.fetchByClientId_Type(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataRequest dataRequest = list.get(0);

					result = dataRequest;

					cacheResult(dataRequest);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByClientId_Type, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DataRequest)result;
		}
	}

	/**
	 * Removes the data request where clientId = &#63; and type = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the data request that was removed
	 */
	@Override
	public DataRequest removeByClientId_Type(long clientId, String type)
		throws NoSuchDataRequestException {

		DataRequest dataRequest = findByClientId_Type(clientId, type);

		return remove(dataRequest);
	}

	/**
	 * Returns the number of data requests where clientId = &#63; and type = &#63;.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the number of matching data requests
	 */
	@Override
	public int countByClientId_Type(long clientId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByClientId_Type;

		Object[] finderArgs = new Object[] {clientId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATAREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTID_TYPE_CLIENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLIENTID_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_CLIENTID_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientId);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLIENTID_TYPE_CLIENTID_2 =
		"dataRequest.clientId = ? AND ";

	private static final String _FINDER_COLUMN_CLIENTID_TYPE_TYPE_2 =
		"dataRequest.type = ?";

	private static final String _FINDER_COLUMN_CLIENTID_TYPE_TYPE_3 =
		"(dataRequest.type IS NULL OR dataRequest.type = '')";

	private FinderPath _finderPathFetchByExtCaseId_Type;
	private FinderPath _finderPathCountByExtCaseId_Type;

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the matching data request
	 * @throws NoSuchDataRequestException if a matching data request could not be found
	 */
	@Override
	public DataRequest findByExtCaseId_Type(long externalCaseId, String type)
		throws NoSuchDataRequestException {

		DataRequest dataRequest = fetchByExtCaseId_Type(externalCaseId, type);

		if (dataRequest == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalCaseId=");
			sb.append(externalCaseId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataRequestException(sb.toString());
		}

		return dataRequest;
	}

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	@Override
	public DataRequest fetchByExtCaseId_Type(long externalCaseId, String type) {
		return fetchByExtCaseId_Type(externalCaseId, type, true);
	}

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	@Override
	public DataRequest fetchByExtCaseId_Type(
		long externalCaseId, String type, boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalCaseId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExtCaseId_Type, finderArgs, this);
		}

		if (result instanceof DataRequest) {
			DataRequest dataRequest = (DataRequest)result;

			if ((externalCaseId != dataRequest.getExternalCaseId()) ||
				!Objects.equals(type, dataRequest.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATAREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EXTCASEID_TYPE_EXTERNALCASEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTCASEID_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_EXTCASEID_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

				if (bindType) {
					queryPos.add(type);
				}

				List<DataRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExtCaseId_Type, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									externalCaseId, type
								};
							}

							_log.warn(
								"DataRequestPersistenceImpl.fetchByExtCaseId_Type(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataRequest dataRequest = list.get(0);

					result = dataRequest;

					cacheResult(dataRequest);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExtCaseId_Type, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DataRequest)result;
		}
	}

	/**
	 * Removes the data request where externalCaseId = &#63; and type = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the data request that was removed
	 */
	@Override
	public DataRequest removeByExtCaseId_Type(long externalCaseId, String type)
		throws NoSuchDataRequestException {

		DataRequest dataRequest = findByExtCaseId_Type(externalCaseId, type);

		return remove(dataRequest);
	}

	/**
	 * Returns the number of data requests where externalCaseId = &#63; and type = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the number of matching data requests
	 */
	@Override
	public int countByExtCaseId_Type(long externalCaseId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByExtCaseId_Type;

		Object[] finderArgs = new Object[] {externalCaseId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATAREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EXTCASEID_TYPE_EXTERNALCASEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTCASEID_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_EXTCASEID_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXTCASEID_TYPE_EXTERNALCASEID_2 =
		"dataRequest.externalCaseId = ? AND ";

	private static final String _FINDER_COLUMN_EXTCASEID_TYPE_TYPE_2 =
		"dataRequest.type = ?";

	private static final String _FINDER_COLUMN_EXTCASEID_TYPE_TYPE_3 =
		"(dataRequest.type IS NULL OR dataRequest.type = '')";

	public DataRequestPersistenceImpl() {
		setModelClass(DataRequest.class);

		setModelImplClass(DataRequestImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the data request in the entity cache if it is enabled.
	 *
	 * @param dataRequest the data request
	 */
	@Override
	public void cacheResult(DataRequest dataRequest) {
		entityCache.putResult(
			entityCacheEnabled, DataRequestImpl.class,
			dataRequest.getPrimaryKey(), dataRequest);

		finderCache.putResult(
			_finderPathFetchByClientId_Type,
			new Object[] {dataRequest.getClientId(), dataRequest.getType()},
			dataRequest);

		finderCache.putResult(
			_finderPathFetchByExtCaseId_Type,
			new Object[] {
				dataRequest.getExternalCaseId(), dataRequest.getType()
			},
			dataRequest);

		dataRequest.resetOriginalValues();
	}

	/**
	 * Caches the data requests in the entity cache if it is enabled.
	 *
	 * @param dataRequests the data requests
	 */
	@Override
	public void cacheResult(List<DataRequest> dataRequests) {
		for (DataRequest dataRequest : dataRequests) {
			if (entityCache.getResult(
					entityCacheEnabled, DataRequestImpl.class,
					dataRequest.getPrimaryKey()) == null) {

				cacheResult(dataRequest);
			}
			else {
				dataRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataRequest dataRequest) {
		entityCache.removeResult(
			entityCacheEnabled, DataRequestImpl.class,
			dataRequest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DataRequestModelImpl)dataRequest, true);
	}

	@Override
	public void clearCache(List<DataRequest> dataRequests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataRequest dataRequest : dataRequests) {
			entityCache.removeResult(
				entityCacheEnabled, DataRequestImpl.class,
				dataRequest.getPrimaryKey());

			clearUniqueFindersCache((DataRequestModelImpl)dataRequest, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DataRequestModelImpl dataRequestModelImpl) {

		Object[] args = new Object[] {
			dataRequestModelImpl.getClientId(), dataRequestModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByClientId_Type, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByClientId_Type, args, dataRequestModelImpl, false);

		args = new Object[] {
			dataRequestModelImpl.getExternalCaseId(),
			dataRequestModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByExtCaseId_Type, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExtCaseId_Type, args, dataRequestModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		DataRequestModelImpl dataRequestModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataRequestModelImpl.getClientId(),
				dataRequestModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByClientId_Type, args);
			finderCache.removeResult(_finderPathFetchByClientId_Type, args);
		}

		if ((dataRequestModelImpl.getColumnBitmask() &
			 _finderPathFetchByClientId_Type.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataRequestModelImpl.getOriginalClientId(),
				dataRequestModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByClientId_Type, args);
			finderCache.removeResult(_finderPathFetchByClientId_Type, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataRequestModelImpl.getExternalCaseId(),
				dataRequestModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByExtCaseId_Type, args);
			finderCache.removeResult(_finderPathFetchByExtCaseId_Type, args);
		}

		if ((dataRequestModelImpl.getColumnBitmask() &
			 _finderPathFetchByExtCaseId_Type.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataRequestModelImpl.getOriginalExternalCaseId(),
				dataRequestModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByExtCaseId_Type, args);
			finderCache.removeResult(_finderPathFetchByExtCaseId_Type, args);
		}
	}

	/**
	 * Creates a new data request with the primary key. Does not add the data request to the database.
	 *
	 * @param dataRequestId the primary key for the new data request
	 * @return the new data request
	 */
	@Override
	public DataRequest create(long dataRequestId) {
		DataRequest dataRequest = new DataRequestImpl();

		dataRequest.setNew(true);
		dataRequest.setPrimaryKey(dataRequestId);

		return dataRequest;
	}

	/**
	 * Removes the data request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request that was removed
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	@Override
	public DataRequest remove(long dataRequestId)
		throws NoSuchDataRequestException {

		return remove((Serializable)dataRequestId);
	}

	/**
	 * Removes the data request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data request
	 * @return the data request that was removed
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	@Override
	public DataRequest remove(Serializable primaryKey)
		throws NoSuchDataRequestException {

		Session session = null;

		try {
			session = openSession();

			DataRequest dataRequest = (DataRequest)session.get(
				DataRequestImpl.class, primaryKey);

			if (dataRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataRequest);
		}
		catch (NoSuchDataRequestException noSuchEntityException) {
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
	protected DataRequest removeImpl(DataRequest dataRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataRequest)) {
				dataRequest = (DataRequest)session.get(
					DataRequestImpl.class, dataRequest.getPrimaryKeyObj());
			}

			if (dataRequest != null) {
				session.delete(dataRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataRequest != null) {
			clearCache(dataRequest);
		}

		return dataRequest;
	}

	@Override
	public DataRequest updateImpl(DataRequest dataRequest) {
		boolean isNew = dataRequest.isNew();

		if (!(dataRequest instanceof DataRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dataRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataRequest implementation " +
					dataRequest.getClass());
		}

		DataRequestModelImpl dataRequestModelImpl =
			(DataRequestModelImpl)dataRequest;

		Session session = null;

		try {
			session = openSession();

			if (dataRequest.isNew()) {
				session.save(dataRequest);

				dataRequest.setNew(false);
			}
			else {
				dataRequest = (DataRequest)session.merge(dataRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, DataRequestImpl.class,
			dataRequest.getPrimaryKey(), dataRequest, false);

		clearUniqueFindersCache(dataRequestModelImpl, false);
		cacheUniqueFindersCache(dataRequestModelImpl);

		dataRequest.resetOriginalValues();

		return dataRequest;
	}

	/**
	 * Returns the data request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data request
	 * @return the data request
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	@Override
	public DataRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataRequestException {

		DataRequest dataRequest = fetchByPrimaryKey(primaryKey);

		if (dataRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataRequest;
	}

	/**
	 * Returns the data request with the primary key or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	@Override
	public DataRequest findByPrimaryKey(long dataRequestId)
		throws NoSuchDataRequestException {

		return findByPrimaryKey((Serializable)dataRequestId);
	}

	/**
	 * Returns the data request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request, or <code>null</code> if a data request with the primary key could not be found
	 */
	@Override
	public DataRequest fetchByPrimaryKey(long dataRequestId) {
		return fetchByPrimaryKey((Serializable)dataRequestId);
	}

	/**
	 * Returns all the data requests.
	 *
	 * @return the data requests
	 */
	@Override
	public List<DataRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @return the range of data requests
	 */
	@Override
	public List<DataRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data requests
	 */
	@Override
	public List<DataRequest> findAll(
		int start, int end, OrderByComparator<DataRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data requests
	 */
	@Override
	public List<DataRequest> findAll(
		int start, int end, OrderByComparator<DataRequest> orderByComparator,
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

		List<DataRequest> list = null;

		if (useFinderCache) {
			list = (List<DataRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATAREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATAREQUEST;

				sql = sql.concat(DataRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataRequest>)QueryUtil.list(
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
	 * Removes all the data requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataRequest dataRequest : findAll()) {
			remove(dataRequest);
		}
	}

	/**
	 * Returns the number of data requests.
	 *
	 * @return the number of data requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATAREQUEST);

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
		return "dataRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATAREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data request persistence.
	 */
	@Activate
	public void activate() {
		DataRequestModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataRequestModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByClientId_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataRequestImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByClientId_Type",
			new String[] {Long.class.getName(), String.class.getName()},
			DataRequestModelImpl.CLIENTID_COLUMN_BITMASK |
			DataRequestModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByClientId_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientId_Type",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByExtCaseId_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataRequestImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExtCaseId_Type",
			new String[] {Long.class.getName(), String.class.getName()},
			DataRequestModelImpl.EXTERNALCASEID_COLUMN_BITMASK |
			DataRequestModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByExtCaseId_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExtCaseId_Type",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataRequestImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.DataRequest"),
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

	private static final String _SQL_SELECT_DATAREQUEST =
		"SELECT dataRequest FROM DataRequest dataRequest";

	private static final String _SQL_SELECT_DATAREQUEST_WHERE =
		"SELECT dataRequest FROM DataRequest dataRequest WHERE ";

	private static final String _SQL_COUNT_DATAREQUEST =
		"SELECT COUNT(dataRequest) FROM DataRequest dataRequest";

	private static final String _SQL_COUNT_DATAREQUEST_WHERE =
		"SELECT COUNT(dataRequest) FROM DataRequest dataRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}