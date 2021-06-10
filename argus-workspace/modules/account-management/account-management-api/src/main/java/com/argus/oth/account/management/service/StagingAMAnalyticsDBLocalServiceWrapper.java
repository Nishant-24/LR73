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

package com.argus.oth.account.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StagingAMAnalyticsDBLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsDBLocalService
 * @generated
 */
public class StagingAMAnalyticsDBLocalServiceWrapper
	implements ServiceWrapper<StagingAMAnalyticsDBLocalService>,
			   StagingAMAnalyticsDBLocalService {

	public StagingAMAnalyticsDBLocalServiceWrapper(
		StagingAMAnalyticsDBLocalService stagingAMAnalyticsDBLocalService) {

		_stagingAMAnalyticsDBLocalService = stagingAMAnalyticsDBLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMAnalyticsDBLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAMAnalyticsDBLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB add(
		long clientId, double savingsPercent, double chargedAmount,
		double repricedAmount, double avgDownTime, double avgSpeedOfAnswer,
		double abandonmentRate, long claimsTurnaround, double downTimeGoal,
		double speedOfAnswerGoal, double abandonmentRateGoal,
		double claimsTurnaroundGoal) {

		return _stagingAMAnalyticsDBLocalService.add(
			clientId, savingsPercent, chargedAmount, repricedAmount,
			avgDownTime, avgSpeedOfAnswer, abandonmentRate, claimsTurnaround,
			downTimeGoal, speedOfAnswerGoal, abandonmentRateGoal,
			claimsTurnaroundGoal);
	}

	/**
	 * Adds the staging am analytics db to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 * @return the staging am analytics db that was added
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
		addStagingAMAnalyticsDB(
			com.argus.oth.account.management.model.StagingAMAnalyticsDB
				stagingAMAnalyticsDB) {

		return _stagingAMAnalyticsDBLocalService.addStagingAMAnalyticsDB(
			stagingAMAnalyticsDB);
	}

	/**
	 * Creates a new staging am analytics db with the primary key. Does not add the staging am analytics db to the database.
	 *
	 * @param stagingAMAnalyticsDbId the primary key for the new staging am analytics db
	 * @return the new staging am analytics db
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
		createStagingAMAnalyticsDB(long stagingAMAnalyticsDbId) {

		return _stagingAMAnalyticsDBLocalService.createStagingAMAnalyticsDB(
			stagingAMAnalyticsDbId);
	}

	@Override
	public void deleteAll() {
		_stagingAMAnalyticsDBLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsDBLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db that was removed
	 * @throws PortalException if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
			deleteStagingAMAnalyticsDB(long stagingAMAnalyticsDbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsDBLocalService.deleteStagingAMAnalyticsDB(
			stagingAMAnalyticsDbId);
	}

	/**
	 * Deletes the staging am analytics db from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 * @return the staging am analytics db that was removed
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
		deleteStagingAMAnalyticsDB(
			com.argus.oth.account.management.model.StagingAMAnalyticsDB
				stagingAMAnalyticsDB) {

		return _stagingAMAnalyticsDBLocalService.deleteStagingAMAnalyticsDB(
			stagingAMAnalyticsDB);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingAMAnalyticsDBLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingAMAnalyticsDBLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stagingAMAnalyticsDBLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stagingAMAnalyticsDBLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingAMAnalyticsDBLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stagingAMAnalyticsDBLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
		fetchStagingAMAnalyticsDB(long stagingAMAnalyticsDbId) {

		return _stagingAMAnalyticsDBLocalService.fetchStagingAMAnalyticsDB(
			stagingAMAnalyticsDbId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingAMAnalyticsDBLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingAMAnalyticsDBLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingAMAnalyticsDBLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsDBLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the staging am analytics db with the primary key.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db
	 * @throws PortalException if a staging am analytics db with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
			getStagingAMAnalyticsDB(long stagingAMAnalyticsDbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsDBLocalService.getStagingAMAnalyticsDB(
			stagingAMAnalyticsDbId);
	}

	/**
	 * Returns a range of all the staging am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics dbs
	 * @param end the upper bound of the range of staging am analytics dbs (not inclusive)
	 * @return the range of staging am analytics dbs
	 */
	@Override
	public java.util.List
		<com.argus.oth.account.management.model.StagingAMAnalyticsDB>
			getStagingAMAnalyticsDBs(int start, int end) {

		return _stagingAMAnalyticsDBLocalService.getStagingAMAnalyticsDBs(
			start, end);
	}

	/**
	 * Returns the number of staging am analytics dbs.
	 *
	 * @return the number of staging am analytics dbs
	 */
	@Override
	public int getStagingAMAnalyticsDBsCount() {
		return _stagingAMAnalyticsDBLocalService.
			getStagingAMAnalyticsDBsCount();
	}

	/**
	 * Updates the staging am analytics db in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 * @return the staging am analytics db that was updated
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsDB
		updateStagingAMAnalyticsDB(
			com.argus.oth.account.management.model.StagingAMAnalyticsDB
				stagingAMAnalyticsDB) {

		return _stagingAMAnalyticsDBLocalService.updateStagingAMAnalyticsDB(
			stagingAMAnalyticsDB);
	}

	@Override
	public StagingAMAnalyticsDBLocalService getWrappedService() {
		return _stagingAMAnalyticsDBLocalService;
	}

	@Override
	public void setWrappedService(
		StagingAMAnalyticsDBLocalService stagingAMAnalyticsDBLocalService) {

		_stagingAMAnalyticsDBLocalService = stagingAMAnalyticsDBLocalService;
	}

	private StagingAMAnalyticsDBLocalService _stagingAMAnalyticsDBLocalService;

}