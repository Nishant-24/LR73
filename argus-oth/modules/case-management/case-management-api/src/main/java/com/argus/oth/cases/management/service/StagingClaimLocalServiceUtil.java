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

package com.argus.oth.cases.management.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StagingClaim. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingClaimLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimLocalService
 * @generated
 */
public class StagingClaimLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingClaimLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingClaimLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
		addStagingClaim(
			long externalClaimId, String claimRef, String authorizationNumber,
			String serviceFrom, String serviceThru, String provider,
			String prioritizedBill, String diagCodesCombined,
			String providerState, String tpmReceivedDate, long claimTurnaround,
			String billType, String providerNetwork, String repricedNetwork,
			long statusSortOrder, String paidDate, double paidAmount,
			String claimStatus, String modifiedDate, String createdDate) {

		return getService().addStagingClaim(
			externalClaimId, claimRef, authorizationNumber, serviceFrom,
			serviceThru, provider, prioritizedBill, diagCodesCombined,
			providerState, tpmReceivedDate, claimTurnaround, billType,
			providerNetwork, repricedNetwork, statusSortOrder, paidDate,
			paidAmount, claimStatus, modifiedDate, createdDate);
	}

	/**
	 * Adds the staging claim to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaim the staging claim
	 * @return the staging claim that was added
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
		addStagingClaim(
			com.argus.oth.cases.management.model.StagingClaim stagingClaim) {

		return getService().addStagingClaim(stagingClaim);
	}

	/**
	 * Creates a new staging claim with the primary key. Does not add the staging claim to the database.
	 *
	 * @param stagingClaimId the primary key for the new staging claim
	 * @return the new staging claim
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
		createStagingClaim(long stagingClaimId) {

		return getService().createStagingClaim(stagingClaimId);
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
	 * Deletes the staging claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim that was removed
	 * @throws PortalException if a staging claim with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
			deleteStagingClaim(long stagingClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingClaim(stagingClaimId);
	}

	/**
	 * Deletes the staging claim from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaim the staging claim
	 * @return the staging claim that was removed
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
		deleteStagingClaim(
			com.argus.oth.cases.management.model.StagingClaim stagingClaim) {

		return getService().deleteStagingClaim(stagingClaim);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.StagingClaim
		fetchStagingClaim(long stagingClaimId) {

		return getService().fetchStagingClaim(stagingClaimId);
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
	 * Returns the staging claim with the primary key.
	 *
	 * @param stagingClaimId the primary key of the staging claim
	 * @return the staging claim
	 * @throws PortalException if a staging claim with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
			getStagingClaim(long stagingClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingClaim(stagingClaimId);
	}

	/**
	 * Returns a range of all the staging claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claims
	 * @param end the upper bound of the range of staging claims (not inclusive)
	 * @return the range of staging claims
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.StagingClaim> getStagingClaims(
			int start, int end) {

		return getService().getStagingClaims(start, end);
	}

	/**
	 * Returns the number of staging claims.
	 *
	 * @return the number of staging claims
	 */
	public static int getStagingClaimsCount() {
		return getService().getStagingClaimsCount();
	}

	/**
	 * Updates the staging claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaim the staging claim
	 * @return the staging claim that was updated
	 */
	public static com.argus.oth.cases.management.model.StagingClaim
		updateStagingClaim(
			com.argus.oth.cases.management.model.StagingClaim stagingClaim) {

		return getService().updateStagingClaim(stagingClaim);
	}

	public static StagingClaimLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClaimLocalService, StagingClaimLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagingClaimLocalService.class);

		ServiceTracker<StagingClaimLocalService, StagingClaimLocalService>
			serviceTracker =
				new ServiceTracker
					<StagingClaimLocalService, StagingClaimLocalService>(
						bundle.getBundleContext(),
						StagingClaimLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}