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
 * Provides the local service utility for AMAnalyticsDB. This utility wraps
 * <code>com.argus.oth.account.management.service.impl.AMAnalyticsDBLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsDBLocalService
 * @generated
 */
public class AMAnalyticsDBLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.account.management.service.impl.AMAnalyticsDBLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AMAnalyticsDBLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>AMAnalyticsDBLocalServiceUtil</code>.
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB add(
		long groupId, long clientId, double savingsPercent,
		double chargedAmount, double repricedAmount, double avgDownTime,
		double avgSpeedOfAnswer, double abandonmentRate, long claimsTurnaround,
		double downTimeGoal, double speedOfAnswerGoal,
		double abandonmentRateGoal, double claimsTurnaroundGoal) {

		return getService().add(
			groupId, clientId, savingsPercent, chargedAmount, repricedAmount,
			avgDownTime, avgSpeedOfAnswer, abandonmentRate, claimsTurnaround,
			downTimeGoal, speedOfAnswerGoal, abandonmentRateGoal,
			claimsTurnaroundGoal);
	}

	/**
	 * Adds the am analytics db to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDB the am analytics db
	 * @return the am analytics db that was added
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB
		addAMAnalyticsDB(
			com.argus.oth.account.management.model.AMAnalyticsDB
				amAnalyticsDB) {

		return getService().addAMAnalyticsDB(amAnalyticsDB);
	}

	/**
	 * Creates a new am analytics db with the primary key. Does not add the am analytics db to the database.
	 *
	 * @param amAnalyticsDbId the primary key for the new am analytics db
	 * @return the new am analytics db
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB
		createAMAnalyticsDB(long amAnalyticsDbId) {

		return getService().createAMAnalyticsDB(amAnalyticsDbId);
	}

	public static void deleteAll() {
		getService().deleteAll();
	}

	/**
	 * Deletes the am analytics db from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDB the am analytics db
	 * @return the am analytics db that was removed
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB
		deleteAMAnalyticsDB(
			com.argus.oth.account.management.model.AMAnalyticsDB
				amAnalyticsDB) {

		return getService().deleteAMAnalyticsDB(amAnalyticsDB);
	}

	/**
	 * Deletes the am analytics db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db that was removed
	 * @throws PortalException if a am analytics db with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB
			deleteAMAnalyticsDB(long amAnalyticsDbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMAnalyticsDB(amAnalyticsDbId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsDBModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsDBModelImpl</code>.
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

	public static com.argus.oth.account.management.model.AMAnalyticsDB
		fetchAMAnalyticsDB(long amAnalyticsDbId) {

		return getService().fetchAMAnalyticsDB(amAnalyticsDbId);
	}

	public static com.argus.oth.account.management.model.AMAnalyticsDB
		fetchByClientId(long clientId) {

		return getService().fetchByClientId(clientId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the am analytics db with the primary key.
	 *
	 * @param amAnalyticsDbId the primary key of the am analytics db
	 * @return the am analytics db
	 * @throws PortalException if a am analytics db with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB
			getAMAnalyticsDB(long amAnalyticsDbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMAnalyticsDB(amAnalyticsDbId);
	}

	/**
	 * Returns a range of all the am analytics dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics dbs
	 * @param end the upper bound of the range of am analytics dbs (not inclusive)
	 * @return the range of am analytics dbs
	 */
	public static java.util.List
		<com.argus.oth.account.management.model.AMAnalyticsDB>
			getAMAnalyticsDBs(int start, int end) {

		return getService().getAMAnalyticsDBs(start, end);
	}

	/**
	 * Returns the number of am analytics dbs.
	 *
	 * @return the number of am analytics dbs
	 */
	public static int getAMAnalyticsDBsCount() {
		return getService().getAMAnalyticsDBsCount();
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
	 * Updates the am analytics db in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amAnalyticsDB the am analytics db
	 * @return the am analytics db that was updated
	 */
	public static com.argus.oth.account.management.model.AMAnalyticsDB
		updateAMAnalyticsDB(
			com.argus.oth.account.management.model.AMAnalyticsDB
				amAnalyticsDB) {

		return getService().updateAMAnalyticsDB(amAnalyticsDB);
	}

	public static AMAnalyticsDBLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AMAnalyticsDBLocalService, AMAnalyticsDBLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AMAnalyticsDBLocalService.class);

		ServiceTracker<AMAnalyticsDBLocalService, AMAnalyticsDBLocalService>
			serviceTracker =
				new ServiceTracker
					<AMAnalyticsDBLocalService, AMAnalyticsDBLocalService>(
						bundle.getBundleContext(),
						AMAnalyticsDBLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}