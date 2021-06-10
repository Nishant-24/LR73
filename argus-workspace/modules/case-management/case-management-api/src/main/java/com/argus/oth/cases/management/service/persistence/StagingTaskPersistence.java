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

import com.argus.oth.cases.management.exception.NoSuchStagingTaskException;
import com.argus.oth.cases.management.model.StagingTask;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingTaskUtil
 * @generated
 */
@ProviderType
public interface StagingTaskPersistence extends BasePersistence<StagingTask> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingTaskUtil} to access the staging task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging task in the entity cache if it is enabled.
	 *
	 * @param stagingTask the staging task
	 */
	public void cacheResult(StagingTask stagingTask);

	/**
	 * Caches the staging tasks in the entity cache if it is enabled.
	 *
	 * @param stagingTasks the staging tasks
	 */
	public void cacheResult(java.util.List<StagingTask> stagingTasks);

	/**
	 * Creates a new staging task with the primary key. Does not add the staging task to the database.
	 *
	 * @param taskId the primary key for the new staging task
	 * @return the new staging task
	 */
	public StagingTask create(long taskId);

	/**
	 * Removes the staging task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task that was removed
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	public StagingTask remove(long taskId) throws NoSuchStagingTaskException;

	public StagingTask updateImpl(StagingTask stagingTask);

	/**
	 * Returns the staging task with the primary key or throws a <code>NoSuchStagingTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task
	 * @throws NoSuchStagingTaskException if a staging task with the primary key could not be found
	 */
	public StagingTask findByPrimaryKey(long taskId)
		throws NoSuchStagingTaskException;

	/**
	 * Returns the staging task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the staging task
	 * @return the staging task, or <code>null</code> if a staging task with the primary key could not be found
	 */
	public StagingTask fetchByPrimaryKey(long taskId);

	/**
	 * Returns all the staging tasks.
	 *
	 * @return the staging tasks
	 */
	public java.util.List<StagingTask> findAll();

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
	public java.util.List<StagingTask> findAll(int start, int end);

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
	public java.util.List<StagingTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingTask>
			orderByComparator);

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
	public java.util.List<StagingTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StagingTask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging tasks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging tasks.
	 *
	 * @return the number of staging tasks
	 */
	public int countAll();

}