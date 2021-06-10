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

package com.argus.oth.cases.management.service.persistence;

import com.argus.oth.cases.management.model.StagingTask;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the staging task service. This utility wraps <code>com.argus.oth.cases.management.service.persistence.impl.StagingTaskPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingTaskPersistence
 * @generated
 */
public class StagingTaskUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StagingTask stagingTask) {
		getPersistence().clearCache(stagingTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StagingTask> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StagingTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StagingTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StagingTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StagingTask> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StagingTask update(StagingTask stagingTask) {
		return getPersistence().update(stagingTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StagingTask update(
		StagingTask stagingTask, ServiceContext serviceContext) {

		return getPersistence().update(stagingTask, serviceContext);
	}

	/**
	 * Caches the staging task in the entity cache if it is enabled.
	 *
	 * @param stagingTask the staging task
	 */
	public static void cacheResult(StagingTask stagingTask) {
		getPersistence().cacheResult(stagingTask);
	}

	/**
	 * Caches the staging tasks in the entity cache if it is enabled.
	 *
	 * @param stagingTasks the staging tasks
	 */
	public static void cacheResult(List<StagingTask> stagingTasks) {
		getPersistence().cacheResult(stagingTasks);
	}

	/**
	 * Creates a new staging task with the primary key. Does not add the staging task to the database.
	 *
	 * @param taskId the primary key for the new staging task
	 * @return the new staging task
	 */
	public static StagingTask create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	 * Removes the staging task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task that was removed
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	public static StagingTask remove(long taskId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingTaskException {

		return getPersistence().remove(taskId);
	}

	public static StagingTask updateImpl(StagingTask stagingTask) {
		return getPersistence().updateImpl(stagingTask);
	}

	/**
	 * Returns the staging task with the primary key or throws a <code>NoSuchStagingTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	public static StagingTask findByPrimaryKey(long taskId)
		throws com.argus.oth.cases.management.exception.
			NoSuchStagingTaskException {

		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	 * Returns the staging task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task, or <code>null</code> if a staging task with the primary key could not be found
	 */
	public static StagingTask fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	 * Returns all the staging tasks.
	 *
	 * @return the staging tasks
	 */
	public static List<StagingTask> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @return the range of staging tasks
	 */
	public static List<StagingTask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging tasks
	 */
	public static List<StagingTask> findAll(
		int start, int end, OrderByComparator<StagingTask> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staging tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging tasks
	 * @param end the upper bound of the range of staging tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging tasks
	 */
	public static List<StagingTask> findAll(
		int start, int end, OrderByComparator<StagingTask> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staging tasks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staging tasks.
	 *
	 * @return the number of staging tasks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagingTaskPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingTaskPersistence, StagingTaskPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingTaskPersistence.class);

		ServiceTracker<StagingTaskPersistence, StagingTaskPersistence>
			serviceTracker =
				new ServiceTracker
					<StagingTaskPersistence, StagingTaskPersistence>(
						bundle.getBundleContext(), StagingTaskPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}