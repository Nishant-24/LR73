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
 * Provides the local service utility for Claim. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.ClaimLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalService
 * @generated
 */
public class ClaimLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.ClaimLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the claim to the database. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was added
	 */
	public static com.argus.oth.cases.management.model.Claim addClaim(
		com.argus.oth.cases.management.model.Claim claim) {

		return getService().addClaim(claim);
	}

	public static com.argus.oth.cases.management.model.Claim addClaim(
		long groupId, long externalClaimId, String claimRef,
		String authorizationNumber, java.util.Date serviceFrom,
		java.util.Date serviceThru, String provider, String prioritizedBill,
		String diagCodesCombined, String providerState,
		java.util.Date tpmReceivedDate, long claimTurnaround, String billType,
		String providerNetwork, String repricedNetwork, long statusSortOrder,
		java.util.Date paidDate, double paidAmount, String claimStatus,
		java.util.Date modifiedDate, java.util.Date createdDate,
		String randomString) {

		return getService().addClaim(
			groupId, externalClaimId, claimRef, authorizationNumber,
			serviceFrom, serviceThru, provider, prioritizedBill,
			diagCodesCombined, providerState, tpmReceivedDate, claimTurnaround,
			billType, providerNetwork, repricedNetwork, statusSortOrder,
			paidDate, paidAmount, claimStatus, modifiedDate, createdDate,
			randomString);
	}

	/**
	 * Creates a new claim with the primary key. Does not add the claim to the database.
	 *
	 * @param claimId the primary key for the new claim
	 * @return the new claim
	 */
	public static com.argus.oth.cases.management.model.Claim createClaim(
		long claimId) {

		return getService().createClaim(claimId);
	}

	/**
	 * Deletes the claim from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was removed
	 */
	public static com.argus.oth.cases.management.model.Claim deleteClaim(
		com.argus.oth.cases.management.model.Claim claim) {

		return getService().deleteClaim(claim);
	}

	/**
	 * Deletes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim that was removed
	 * @throws PortalException if a claim with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Claim deleteClaim(
			long claimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteClaim(claimId);
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

	public static void deleteUnprocessed(String randomString) {
		getService().deleteUnprocessed(randomString);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.Claim fetchByClaimRef(
		String claimRef) {

		return getService().fetchByClaimRef(claimRef);
	}

	public static com.argus.oth.cases.management.model.Claim fetchClaim(
		long claimId) {

		return getService().fetchClaim(claimId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.argus.oth.cases.management.model.Claim>
		getByAuthorizationNumber(String authorizationNumber) {

		return getService().getByAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Returns the claim with the primary key.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim
	 * @throws PortalException if a claim with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Claim getClaim(
			long claimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaim(claimId);
	}

	/**
	 * Returns a range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of claims
	 */
	public static java.util.List<com.argus.oth.cases.management.model.Claim>
		getClaims(int start, int end) {

		return getService().getClaims(start, end);
	}

	/**
	 * Returns the number of claims.
	 *
	 * @return the number of claims
	 */
	public static int getClaimsCount() {
		return getService().getClaimsCount();
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
	 * Updates the claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was updated
	 */
	public static com.argus.oth.cases.management.model.Claim updateClaim(
		com.argus.oth.cases.management.model.Claim claim) {

		return getService().updateClaim(claim);
	}

	public static ClaimLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClaimLocalService, ClaimLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimLocalService.class);

		ServiceTracker<ClaimLocalService, ClaimLocalService> serviceTracker =
			new ServiceTracker<ClaimLocalService, ClaimLocalService>(
				bundle.getBundleContext(), ClaimLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}