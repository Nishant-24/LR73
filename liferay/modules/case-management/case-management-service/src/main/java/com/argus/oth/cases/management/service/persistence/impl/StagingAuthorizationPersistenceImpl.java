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

import com.argus.oth.cases.management.exception.NoSuchStagingAuthorizationException;
import com.argus.oth.cases.management.model.StagingAuthorization;
import com.argus.oth.cases.management.model.impl.StagingAuthorizationImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthorizationModelImpl;
import com.argus.oth.cases.management.service.persistence.StagingAuthorizationPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the staging authorization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StagingAuthorizationPersistence.class)
public class StagingAuthorizationPersistenceImpl
	extends BasePersistenceImpl<StagingAuthorization>
	implements StagingAuthorizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StagingAuthorizationUtil</code> to access the staging authorization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StagingAuthorizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByExternalCaseId;
	private FinderPath _finderPathWithoutPaginationFindByExternalCaseId;
	private FinderPath _finderPathCountByExternalCaseId;

	/**
	 * Returns all the staging authorizations where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the matching staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId) {

		return findByExternalCaseId(
			externalCaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of matching staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end) {

		return findByExternalCaseId(externalCaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return findByExternalCaseId(
			externalCaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging authorizations where externalCaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param externalCaseId the external case ID
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findByExternalCaseId(
		long externalCaseId, int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByExternalCaseId;
				finderArgs = new Object[] {externalCaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExternalCaseId;
			finderArgs = new Object[] {
				externalCaseId, start, end, orderByComparator
			};
		}

		List<StagingAuthorization> list = null;

		if (useFinderCache) {
			list = (List<StagingAuthorization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StagingAuthorization stagingAuthorization : list) {
					if (externalCaseId !=
							stagingAuthorization.getExternalCaseId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STAGINGAUTHORIZATION_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StagingAuthorizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

				list = (List<StagingAuthorization>)QueryUtil.list(
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
	 * Returns the first staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging authorization
	 * @throws NoSuchStagingAuthorizationException if a matching staging authorization could not be found
	 */
	@Override
	public StagingAuthorization findByExternalCaseId_First(
			long externalCaseId,
			OrderByComparator<StagingAuthorization> orderByComparator)
		throws NoSuchStagingAuthorizationException {

		StagingAuthorization stagingAuthorization = fetchByExternalCaseId_First(
			externalCaseId, orderByComparator);

		if (stagingAuthorization != null) {
			return stagingAuthorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalCaseId=");
		sb.append(externalCaseId);

		sb.append("}");

		throw new NoSuchStagingAuthorizationException(sb.toString());
	}

	/**
	 * Returns the first staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staging authorization, or <code>null</code> if a matching staging authorization could not be found
	 */
	@Override
	public StagingAuthorization fetchByExternalCaseId_First(
		long externalCaseId,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		List<StagingAuthorization> list = findByExternalCaseId(
			externalCaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging authorization
	 * @throws NoSuchStagingAuthorizationException if a matching staging authorization could not be found
	 */
	@Override
	public StagingAuthorization findByExternalCaseId_Last(
			long externalCaseId,
			OrderByComparator<StagingAuthorization> orderByComparator)
		throws NoSuchStagingAuthorizationException {

		StagingAuthorization stagingAuthorization = fetchByExternalCaseId_Last(
			externalCaseId, orderByComparator);

		if (stagingAuthorization != null) {
			return stagingAuthorization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalCaseId=");
		sb.append(externalCaseId);

		sb.append("}");

		throw new NoSuchStagingAuthorizationException(sb.toString());
	}

	/**
	 * Returns the last staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staging authorization, or <code>null</code> if a matching staging authorization could not be found
	 */
	@Override
	public StagingAuthorization fetchByExternalCaseId_Last(
		long externalCaseId,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		int count = countByExternalCaseId(externalCaseId);

		if (count == 0) {
			return null;
		}

		List<StagingAuthorization> list = findByExternalCaseId(
			externalCaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staging authorizations before and after the current staging authorization in the ordered set where externalCaseId = &#63;.
	 *
	 * @param stagingAuthorizationId the primary key of the current staging authorization
	 * @param externalCaseId the external case ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	@Override
	public StagingAuthorization[] findByExternalCaseId_PrevAndNext(
			long stagingAuthorizationId, long externalCaseId,
			OrderByComparator<StagingAuthorization> orderByComparator)
		throws NoSuchStagingAuthorizationException {

		StagingAuthorization stagingAuthorization = findByPrimaryKey(
			stagingAuthorizationId);

		Session session = null;

		try {
			session = openSession();

			StagingAuthorization[] array = new StagingAuthorizationImpl[3];

			array[0] = getByExternalCaseId_PrevAndNext(
				session, stagingAuthorization, externalCaseId,
				orderByComparator, true);

			array[1] = stagingAuthorization;

			array[2] = getByExternalCaseId_PrevAndNext(
				session, stagingAuthorization, externalCaseId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StagingAuthorization getByExternalCaseId_PrevAndNext(
		Session session, StagingAuthorization stagingAuthorization,
		long externalCaseId,
		OrderByComparator<StagingAuthorization> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAGINGAUTHORIZATION_WHERE);

		sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StagingAuthorizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(externalCaseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						stagingAuthorization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StagingAuthorization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the staging authorizations where externalCaseId = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 */
	@Override
	public void removeByExternalCaseId(long externalCaseId) {
		for (StagingAuthorization stagingAuthorization :
				findByExternalCaseId(
					externalCaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(stagingAuthorization);
		}
	}

	/**
	 * Returns the number of staging authorizations where externalCaseId = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @return the number of matching staging authorizations
	 */
	@Override
	public int countByExternalCaseId(long externalCaseId) {
		FinderPath finderPath = _finderPathCountByExternalCaseId;

		Object[] finderArgs = new Object[] {externalCaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGINGAUTHORIZATION_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalCaseId);

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

	private static final String _FINDER_COLUMN_EXTERNALCASEID_EXTERNALCASEID_2 =
		"stagingAuthorization.externalCaseId = ?";

	public StagingAuthorizationPersistenceImpl() {
		setModelClass(StagingAuthorization.class);

		setModelImplClass(StagingAuthorizationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the staging authorization in the entity cache if it is enabled.
	 *
	 * @param stagingAuthorization the staging authorization
	 */
	@Override
	public void cacheResult(StagingAuthorization stagingAuthorization) {
		entityCache.putResult(
			entityCacheEnabled, StagingAuthorizationImpl.class,
			stagingAuthorization.getPrimaryKey(), stagingAuthorization);

		stagingAuthorization.resetOriginalValues();
	}

	/**
	 * Caches the staging authorizations in the entity cache if it is enabled.
	 *
	 * @param stagingAuthorizations the staging authorizations
	 */
	@Override
	public void cacheResult(List<StagingAuthorization> stagingAuthorizations) {
		for (StagingAuthorization stagingAuthorization :
				stagingAuthorizations) {

			if (entityCache.getResult(
					entityCacheEnabled, StagingAuthorizationImpl.class,
					stagingAuthorization.getPrimaryKey()) == null) {

				cacheResult(stagingAuthorization);
			}
			else {
				stagingAuthorization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staging authorizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StagingAuthorizationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staging authorization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StagingAuthorization stagingAuthorization) {
		entityCache.removeResult(
			entityCacheEnabled, StagingAuthorizationImpl.class,
			stagingAuthorization.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StagingAuthorization> stagingAuthorizations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StagingAuthorization stagingAuthorization :
				stagingAuthorizations) {

			entityCache.removeResult(
				entityCacheEnabled, StagingAuthorizationImpl.class,
				stagingAuthorization.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StagingAuthorizationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new staging authorization with the primary key. Does not add the staging authorization to the database.
	 *
	 * @param stagingAuthorizationId the primary key for the new staging authorization
	 * @return the new staging authorization
	 */
	@Override
	public StagingAuthorization create(long stagingAuthorizationId) {
		StagingAuthorization stagingAuthorization =
			new StagingAuthorizationImpl();

		stagingAuthorization.setNew(true);
		stagingAuthorization.setPrimaryKey(stagingAuthorizationId);

		return stagingAuthorization;
	}

	/**
	 * Removes the staging authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization that was removed
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	@Override
	public StagingAuthorization remove(long stagingAuthorizationId)
		throws NoSuchStagingAuthorizationException {

		return remove((Serializable)stagingAuthorizationId);
	}

	/**
	 * Removes the staging authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staging authorization
	 * @return the staging authorization that was removed
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	@Override
	public StagingAuthorization remove(Serializable primaryKey)
		throws NoSuchStagingAuthorizationException {

		Session session = null;

		try {
			session = openSession();

			StagingAuthorization stagingAuthorization =
				(StagingAuthorization)session.get(
					StagingAuthorizationImpl.class, primaryKey);

			if (stagingAuthorization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStagingAuthorizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stagingAuthorization);
		}
		catch (NoSuchStagingAuthorizationException noSuchEntityException) {
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
	protected StagingAuthorization removeImpl(
		StagingAuthorization stagingAuthorization) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stagingAuthorization)) {
				stagingAuthorization = (StagingAuthorization)session.get(
					StagingAuthorizationImpl.class,
					stagingAuthorization.getPrimaryKeyObj());
			}

			if (stagingAuthorization != null) {
				session.delete(stagingAuthorization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stagingAuthorization != null) {
			clearCache(stagingAuthorization);
		}

		return stagingAuthorization;
	}

	@Override
	public StagingAuthorization updateImpl(
		StagingAuthorization stagingAuthorization) {

		boolean isNew = stagingAuthorization.isNew();

		if (!(stagingAuthorization instanceof StagingAuthorizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stagingAuthorization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					stagingAuthorization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stagingAuthorization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StagingAuthorization implementation " +
					stagingAuthorization.getClass());
		}

		StagingAuthorizationModelImpl stagingAuthorizationModelImpl =
			(StagingAuthorizationModelImpl)stagingAuthorization;

		Session session = null;

		try {
			session = openSession();

			if (stagingAuthorization.isNew()) {
				session.save(stagingAuthorization);

				stagingAuthorization.setNew(false);
			}
			else {
				stagingAuthorization = (StagingAuthorization)session.merge(
					stagingAuthorization);
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
			Object[] args = new Object[] {
				stagingAuthorizationModelImpl.getExternalCaseId()
			};

			finderCache.removeResult(_finderPathCountByExternalCaseId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByExternalCaseId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stagingAuthorizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByExternalCaseId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stagingAuthorizationModelImpl.getOriginalExternalCaseId()
				};

				finderCache.removeResult(
					_finderPathCountByExternalCaseId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExternalCaseId, args);

				args = new Object[] {
					stagingAuthorizationModelImpl.getExternalCaseId()
				};

				finderCache.removeResult(
					_finderPathCountByExternalCaseId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExternalCaseId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StagingAuthorizationImpl.class,
			stagingAuthorization.getPrimaryKey(), stagingAuthorization, false);

		stagingAuthorization.resetOriginalValues();

		return stagingAuthorization;
	}

	/**
	 * Returns the staging authorization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staging authorization
	 * @return the staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	@Override
	public StagingAuthorization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStagingAuthorizationException {

		StagingAuthorization stagingAuthorization = fetchByPrimaryKey(
			primaryKey);

		if (stagingAuthorization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStagingAuthorizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stagingAuthorization;
	}

	/**
	 * Returns the staging authorization with the primary key or throws a <code>NoSuchStagingAuthorizationException</code> if it could not be found.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization
	 * @throws NoSuchStagingAuthorizationException if a staging authorization with the primary key could not be found
	 */
	@Override
	public StagingAuthorization findByPrimaryKey(long stagingAuthorizationId)
		throws NoSuchStagingAuthorizationException {

		return findByPrimaryKey((Serializable)stagingAuthorizationId);
	}

	/**
	 * Returns the staging authorization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization, or <code>null</code> if a staging authorization with the primary key could not be found
	 */
	@Override
	public StagingAuthorization fetchByPrimaryKey(long stagingAuthorizationId) {
		return fetchByPrimaryKey((Serializable)stagingAuthorizationId);
	}

	/**
	 * Returns all the staging authorizations.
	 *
	 * @return the staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findAll(
		int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging authorizations
	 */
	@Override
	public List<StagingAuthorization> findAll(
		int start, int end,
		OrderByComparator<StagingAuthorization> orderByComparator,
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

		List<StagingAuthorization> list = null;

		if (useFinderCache) {
			list = (List<StagingAuthorization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGINGAUTHORIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGINGAUTHORIZATION;

				sql = sql.concat(StagingAuthorizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StagingAuthorization>)QueryUtil.list(
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
	 * Removes all the staging authorizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StagingAuthorization stagingAuthorization : findAll()) {
			remove(stagingAuthorization);
		}
	}

	/**
	 * Returns the number of staging authorizations.
	 *
	 * @return the number of staging authorizations
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
					_SQL_COUNT_STAGINGAUTHORIZATION);

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
		return "stagingAuthorizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGINGAUTHORIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StagingAuthorizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the staging authorization persistence.
	 */
	@Activate
	public void activate() {
		StagingAuthorizationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StagingAuthorizationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExternalCaseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StagingAuthorizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExternalCaseId",
			new String[] {Long.class.getName()},
			StagingAuthorizationModelImpl.EXTERNALCASEID_COLUMN_BITMASK |
			StagingAuthorizationModelImpl.RECEIVEDDATE_COLUMN_BITMASK);

		_finderPathCountByExternalCaseId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExternalCaseId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StagingAuthorizationImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.StagingAuthorization"),
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

	private static final String _SQL_SELECT_STAGINGAUTHORIZATION =
		"SELECT stagingAuthorization FROM StagingAuthorization stagingAuthorization";

	private static final String _SQL_SELECT_STAGINGAUTHORIZATION_WHERE =
		"SELECT stagingAuthorization FROM StagingAuthorization stagingAuthorization WHERE ";

	private static final String _SQL_COUNT_STAGINGAUTHORIZATION =
		"SELECT COUNT(stagingAuthorization) FROM StagingAuthorization stagingAuthorization";

	private static final String _SQL_COUNT_STAGINGAUTHORIZATION_WHERE =
		"SELECT COUNT(stagingAuthorization) FROM StagingAuthorization stagingAuthorization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"stagingAuthorization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StagingAuthorization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StagingAuthorization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StagingAuthorizationPersistenceImpl.class);

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}