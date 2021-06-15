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

package com.argus.oth.claim.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StagingClaimAnalytics. This utility wraps
 * <code>com.argus.oth.claim.service.impl.StagingClaimAnalyticsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimAnalyticsLocalService
 * @generated
 */
public class StagingClaimAnalyticsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.claim.service.impl.StagingClaimAnalyticsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimAnalyticsLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingClaimAnalyticsLocalServiceUtil</code>.
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
		addStagingClaimAnalytics(
			long externalClientId, String clientName, String claimNumber,
			long externalCaseId, String claimStatus, String receivedDate,
			String serviceDate, String paidDate, long externalMemberId,
			String memberName, String providerName, String billType,
			String primaryDiagnosis, double chargedAmount, double paidAmount,
			double repricedAmount, double savingsAmount, double chargedPercent,
			double repricedPercent, double savingsPercent, String chargedRange,
			String paidRange, String repricedRange, String savingsRange,
			long claimAging, String procedureCodes, String resultCodes,
			String diagnosisCodes, String country, String state,
			double financialExposure, String repricedNetwork,
			String clientGroupName) {

		return getService().addStagingClaimAnalytics(
			externalClientId, clientName, claimNumber, externalCaseId,
			claimStatus, receivedDate, serviceDate, paidDate, externalMemberId,
			memberName, providerName, billType, primaryDiagnosis, chargedAmount,
			paidAmount, repricedAmount, savingsAmount, chargedPercent,
			repricedPercent, savingsPercent, chargedRange, paidRange,
			repricedRange, savingsRange, claimAging, procedureCodes,
			resultCodes, diagnosisCodes, country, state, financialExposure,
			repricedNetwork, clientGroupName);
	}

	/**
	 * Adds the staging claim analytics to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was added
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
		addStagingClaimAnalytics(
			com.argus.oth.claim.model.StagingClaimAnalytics
				stagingClaimAnalytics) {

		return getService().addStagingClaimAnalytics(stagingClaimAnalytics);
	}

	/**
	 * Creates a new staging claim analytics with the primary key. Does not add the staging claim analytics to the database.
	 *
	 * @param stagingClaimAnalyticsId the primary key for the new staging claim analytics
	 * @return the new staging claim analytics
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
		createStagingClaimAnalytics(long stagingClaimAnalyticsId) {

		return getService().createStagingClaimAnalytics(
			stagingClaimAnalyticsId);
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
	 * Deletes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws PortalException if a staging claim analytics with the primary key could not be found
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
			deleteStagingClaimAnalytics(long stagingClaimAnalyticsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingClaimAnalytics(
			stagingClaimAnalyticsId);
	}

	/**
	 * Deletes the staging claim analytics from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was removed
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
		deleteStagingClaimAnalytics(
			com.argus.oth.claim.model.StagingClaimAnalytics
				stagingClaimAnalytics) {

		return getService().deleteStagingClaimAnalytics(stagingClaimAnalytics);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
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

	public static com.argus.oth.claim.model.StagingClaimAnalytics
		fetchStagingClaimAnalytics(long stagingClaimAnalyticsId) {

		return getService().fetchStagingClaimAnalytics(stagingClaimAnalyticsId);
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
	 * Returns the staging claim analytics with the primary key.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws PortalException if a staging claim analytics with the primary key could not be found
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
			getStagingClaimAnalytics(long stagingClaimAnalyticsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingClaimAnalytics(stagingClaimAnalyticsId);
	}

	/**
	 * Returns a range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @return the range of staging claim analyticses
	 */
	public static java.util.List
		<com.argus.oth.claim.model.StagingClaimAnalytics>
			getStagingClaimAnalyticses(int start, int end) {

		return getService().getStagingClaimAnalyticses(start, end);
	}

	/**
	 * Returns the number of staging claim analyticses.
	 *
	 * @return the number of staging claim analyticses
	 */
	public static int getStagingClaimAnalyticsesCount() {
		return getService().getStagingClaimAnalyticsesCount();
	}

	/**
	 * Updates the staging claim analytics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was updated
	 */
	public static com.argus.oth.claim.model.StagingClaimAnalytics
		updateStagingClaimAnalytics(
			com.argus.oth.claim.model.StagingClaimAnalytics
				stagingClaimAnalytics) {

		return getService().updateStagingClaimAnalytics(stagingClaimAnalytics);
	}

	public static StagingClaimAnalyticsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClaimAnalyticsLocalService, StagingClaimAnalyticsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingClaimAnalyticsLocalService.class);

		ServiceTracker
			<StagingClaimAnalyticsLocalService,
			 StagingClaimAnalyticsLocalService> serviceTracker =
				new ServiceTracker
					<StagingClaimAnalyticsLocalService,
					 StagingClaimAnalyticsLocalService>(
						 bundle.getBundleContext(),
						 StagingClaimAnalyticsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}