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
 * Provides the local service utility for StagingAMAnalyticsClaim. This utility wraps
 * <code>com.argus.oth.account.management.service.impl.StagingAMAnalyticsClaimLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsClaimLocalService
 * @generated
 */
public class StagingAMAnalyticsClaimLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.account.management.service.impl.StagingAMAnalyticsClaimLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMAnalyticsClaimLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingAMAnalyticsClaimLocalServiceUtil</code>.
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		add(
			long clientId, String amAnalyticsClaimDate, int avgClaimTurnAround,
			int minClaimTurnAround, int maxClaimTurnAround,
			int claimTurnAroundGoal, double overallAvgClaimTurnAround) {

		return getService().add(
			clientId, amAnalyticsClaimDate, avgClaimTurnAround,
			minClaimTurnAround, maxClaimTurnAround, claimTurnAroundGoal,
			overallAvgClaimTurnAround);
	}

	/**
	 * Adds the staging am analytics claim to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was added
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		addStagingAMAnalyticsClaim(
			com.argus.oth.account.management.model.StagingAMAnalyticsClaim
				stagingAMAnalyticsClaim) {

		return getService().addStagingAMAnalyticsClaim(stagingAMAnalyticsClaim);
	}

	/**
	 * Creates a new staging am analytics claim with the primary key. Does not add the staging am analytics claim to the database.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key for the new staging am analytics claim
	 * @return the new staging am analytics claim
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		createStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId) {

		return getService().createStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaimId);
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
	 * Deletes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws PortalException if a staging am analytics claim with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
			deleteStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaimId);
	}

	/**
	 * Deletes the staging am analytics claim from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		deleteStagingAMAnalyticsClaim(
			com.argus.oth.account.management.model.StagingAMAnalyticsClaim
				stagingAMAnalyticsClaim) {

		return getService().deleteStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaim);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
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

	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		fetchStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId) {

		return getService().fetchStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaimId);
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
	 * Returns the staging am analytics claim with the primary key.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws PortalException if a staging am analytics claim with the primary key could not be found
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
			getStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaimId);
	}

	/**
	 * Returns a range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @return the range of staging am analytics claims
	 */
	public static java.util.List
		<com.argus.oth.account.management.model.StagingAMAnalyticsClaim>
			getStagingAMAnalyticsClaims(int start, int end) {

		return getService().getStagingAMAnalyticsClaims(start, end);
	}

	/**
	 * Returns the number of staging am analytics claims.
	 *
	 * @return the number of staging am analytics claims
	 */
	public static int getStagingAMAnalyticsClaimsCount() {
		return getService().getStagingAMAnalyticsClaimsCount();
	}

	/**
	 * Updates the staging am analytics claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was updated
	 */
	public static com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		updateStagingAMAnalyticsClaim(
			com.argus.oth.account.management.model.StagingAMAnalyticsClaim
				stagingAMAnalyticsClaim) {

		return getService().updateStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaim);
	}

	public static StagingAMAnalyticsClaimLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAMAnalyticsClaimLocalService,
		 StagingAMAnalyticsClaimLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAMAnalyticsClaimLocalService.class);

		ServiceTracker
			<StagingAMAnalyticsClaimLocalService,
			 StagingAMAnalyticsClaimLocalService> serviceTracker =
				new ServiceTracker
					<StagingAMAnalyticsClaimLocalService,
					 StagingAMAnalyticsClaimLocalService>(
						 bundle.getBundleContext(),
						 StagingAMAnalyticsClaimLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}