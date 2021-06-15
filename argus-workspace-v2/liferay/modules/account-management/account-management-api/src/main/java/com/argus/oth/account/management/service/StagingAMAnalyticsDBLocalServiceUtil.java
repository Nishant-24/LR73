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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StagingAMAnalyticsDB. This utility wraps
 * <code>com.argus.oth.account.management.service.impl.StagingAMAnalyticsDBLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsDBLocalService
 * @generated
 */
public class StagingAMAnalyticsDBLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.account.management.service.impl.StagingAMAnalyticsDBLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMAnalyticsDBLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingAMAnalyticsDBLocalServiceUtil</code>.
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
		add(
			long clientId, double savingsPercent, double chargedAmount,
			double repricedAmount, double avgDownTime, double avgSpeedOfAnswer,
			double abandonmentRate, long claimsTurnaround, double downTimeGoal,
			double speedOfAnswerGoal, double abandonmentRateGoal,
			double claimsTurnaroundGoal) {

		return getService().add(
			clientId, savingsPercent, chargedAmount, repricedAmount,
			avgDownTime, avgSpeedOfAnswer, abandonmentRate, claimsTurnaround,
			downTimeGoal, speedOfAnswerGoal, abandonmentRateGoal,
			claimsTurnaroundGoal);
	}

	/**
	 * Adds the staging am analytics db to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 * @return the staging am analytics db that was added
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
		addStagingAMAnalyticsDB(
			com.argus.oth.account.management.model.StagingAMAnalyticsDB
				stagingAMAnalyticsDB) {

		return getService().addStagingAMAnalyticsDB(stagingAMAnalyticsDB);
	}

	/**
	 * Creates a new staging am analytics db with the primary key. Does not add the staging am analytics db to the database.
	 *
	 * @param stagingAMAnalyticsDbId the primary key for the new staging am analytics db
	 * @return the new staging am analytics db
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
		createStagingAMAnalyticsDB(long stagingAMAnalyticsDbId) {

		return getService().createStagingAMAnalyticsDB(stagingAMAnalyticsDbId);
	}

	public static void deleteAll() {
		getService().deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db that was removed
	 * @throws PortalException if a staging am analytics db with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
			deleteStagingAMAnalyticsDB(long stagingAMAnalyticsDbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingAMAnalyticsDB(stagingAMAnalyticsDbId);
	}

	/**
	 * Deletes the staging am analytics db from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 * @return the staging am analytics db that was removed
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
		deleteStagingAMAnalyticsDB(
			com.argus.oth.account.management.model.StagingAMAnalyticsDB
				stagingAMAnalyticsDB) {

		return getService().deleteStagingAMAnalyticsDB(stagingAMAnalyticsDB);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
		fetchStagingAMAnalyticsDB(long stagingAMAnalyticsDbId) {

		return getService().fetchStagingAMAnalyticsDB(stagingAMAnalyticsDbId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging am analytics db with the primary key.
	 *
	 * @param stagingAMAnalyticsDbId the primary key of the staging am analytics db
	 * @return the staging am analytics db
	 * @throws PortalException if a staging am analytics db with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
			getStagingAMAnalyticsDB(long stagingAMAnalyticsDbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingAMAnalyticsDB(stagingAMAnalyticsDbId);
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
	public static java.util.List
		<com.argus.oth.account.management.model.StagingAMAnalyticsDB>
			getStagingAMAnalyticsDBs(int start, int end) {

		return getService().getStagingAMAnalyticsDBs(start, end);
	}

	/**
	 * Returns the number of staging am analytics dbs.
	 *
	 * @return the number of staging am analytics dbs
	 */
	public static int getStagingAMAnalyticsDBsCount() {
		return getService().getStagingAMAnalyticsDBsCount();
	}

	/**
	 * Updates the staging am analytics db in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsDB the staging am analytics db
	 * @return the staging am analytics db that was updated
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsDB
		updateStagingAMAnalyticsDB(
			com.argus.oth.account.management.model.StagingAMAnalyticsDB
				stagingAMAnalyticsDB) {

		return getService().updateStagingAMAnalyticsDB(stagingAMAnalyticsDB);
	}

	public static StagingAMAnalyticsDBLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAMAnalyticsDBLocalService, StagingAMAnalyticsDBLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAMAnalyticsDBLocalService.class);

		ServiceTracker
			<StagingAMAnalyticsDBLocalService, StagingAMAnalyticsDBLocalService>
				serviceTracker =
					new ServiceTracker
						<StagingAMAnalyticsDBLocalService,
						 StagingAMAnalyticsDBLocalService>(
							 bundle.getBundleContext(),
							 StagingAMAnalyticsDBLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}