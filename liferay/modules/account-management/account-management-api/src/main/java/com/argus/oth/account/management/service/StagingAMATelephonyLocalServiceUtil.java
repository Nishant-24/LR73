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
 * Provides the local service utility for StagingAMATelephony. This utility wraps
 * <code>com.argus.oth.account.management.service.impl.StagingAMATelephonyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMATelephonyLocalService
 * @generated
 */
public class StagingAMATelephonyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.account.management.service.impl.StagingAMATelephonyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMATelephonyLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingAMATelephonyLocalServiceUtil</code>.
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
		add(
			long clientId, String amAnalyticsTelephonyDate, double avgDownTime,
			double avgSpeedOfAnswer, double abandonmentRate,
			double downTimeGoal, double speedAnswerGoal,
			double abandonmentRateGoal, double overallAvgDownTime,
			double overallAvgSpeedOfAnswer, double overallAvgAbandonmentRate) {

		return getService().add(
			clientId, amAnalyticsTelephonyDate, avgDownTime, avgSpeedOfAnswer,
			abandonmentRate, downTimeGoal, speedAnswerGoal, abandonmentRateGoal,
			overallAvgDownTime, overallAvgSpeedOfAnswer,
			overallAvgAbandonmentRate);
	}

	/**
	 * Adds the staging ama telephony to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 * @return the staging ama telephony that was added
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
		addStagingAMATelephony(
			com.argus.oth.account.management.model.StagingAMATelephony
				stagingAMATelephony) {

		return getService().addStagingAMATelephony(stagingAMATelephony);
	}

	/**
	 * Creates a new staging ama telephony with the primary key. Does not add the staging ama telephony to the database.
	 *
	 * @param stagingAMATelephonyId the primary key for the new staging ama telephony
	 * @return the new staging ama telephony
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
		createStagingAMATelephony(long stagingAMATelephonyId) {

		return getService().createStagingAMATelephony(stagingAMATelephonyId);
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
	 * Deletes the staging ama telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony that was removed
	 * @throws PortalException if a staging ama telephony with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
			deleteStagingAMATelephony(long stagingAMATelephonyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingAMATelephony(stagingAMATelephonyId);
	}

	/**
	 * Deletes the staging ama telephony from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 * @return the staging ama telephony that was removed
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
		deleteStagingAMATelephony(
			com.argus.oth.account.management.model.StagingAMATelephony
				stagingAMATelephony) {

		return getService().deleteStagingAMATelephony(stagingAMATelephony);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl</code>.
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

	public static com.argus.oth.account.management.model.StagingAMATelephony
		fetchStagingAMATelephony(long stagingAMATelephonyId) {

		return getService().fetchStagingAMATelephony(stagingAMATelephonyId);
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
	 * Returns a range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @return the range of staging ama telephonies
	 */
	public static java.util.List
		<com.argus.oth.account.management.model.StagingAMATelephony>
			getStagingAMATelephonies(int start, int end) {

		return getService().getStagingAMATelephonies(start, end);
	}

	/**
	 * Returns the number of staging ama telephonies.
	 *
	 * @return the number of staging ama telephonies
	 */
	public static int getStagingAMATelephoniesCount() {
		return getService().getStagingAMATelephoniesCount();
	}

	/**
	 * Returns the staging ama telephony with the primary key.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony
	 * @throws PortalException if a staging ama telephony with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
			getStagingAMATelephony(long stagingAMATelephonyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingAMATelephony(stagingAMATelephonyId);
	}

	/**
	 * Updates the staging ama telephony in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 * @return the staging ama telephony that was updated
	 */
	public static com.argus.oth.account.management.model.StagingAMATelephony
		updateStagingAMATelephony(
			com.argus.oth.account.management.model.StagingAMATelephony
				stagingAMATelephony) {

		return getService().updateStagingAMATelephony(stagingAMATelephony);
	}

	public static StagingAMATelephonyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAMATelephonyLocalService, StagingAMATelephonyLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAMATelephonyLocalService.class);

		ServiceTracker
			<StagingAMATelephonyLocalService, StagingAMATelephonyLocalService>
				serviceTracker =
					new ServiceTracker
						<StagingAMATelephonyLocalService,
						 StagingAMATelephonyLocalService>(
							 bundle.getBundleContext(),
							 StagingAMATelephonyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}