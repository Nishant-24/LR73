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

import com.argus.oth.account.management.model.AMAnalyticsClaim;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AMAnalyticsClaim. This utility wraps
 * <code>com.argus.oth.account.management.service.impl.AMAnalyticsClaimLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsClaimLocalService
 * @generated
 */
public class AMAnalyticsClaimLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.account.management.service.impl.AMAnalyticsClaimLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AMAnalyticsClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AMAnalyticsClaimLocalServiceUtil</code>.
	 */
	public static AMAnalyticsClaim add(
		long groupId, long clientId, java.util.Date amAnalyticsClaimDate,
		int avgClaimTurnAround, int minClaimTurnAround, int maxClaimTurnAround,
		int claimTurnAroundGoal, double overallAvgClaimTurnAround) {

		return getService().add(
			groupId, clientId, amAnalyticsClaimDate, avgClaimTurnAround,
			minClaimTurnAround, maxClaimTurnAround, claimTurnAroundGoal,
			overallAvgClaimTurnAround);
	}

	/**
	 * Adds the am analytics claim to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 * @return the am analytics claim that was added
	 */
	public static AMAnalyticsClaim addAMAnalyticsClaim(
		AMAnalyticsClaim amAnalyticsClaim) {

		return getService().addAMAnalyticsClaim(amAnalyticsClaim);
	}

	/**
	 * Creates a new am analytics claim with the primary key. Does not add the am analytics claim to the database.
	 *
	 * @param amAnalyticsClaimId the primary key for the new am analytics claim
	 * @return the new am analytics claim
	 */
	public static AMAnalyticsClaim createAMAnalyticsClaim(
		long amAnalyticsClaimId) {

		return getService().createAMAnalyticsClaim(amAnalyticsClaimId);
	}

	public static void deleteAll() {
		getService().deleteAll();
	}

	/**
	 * Deletes the am analytics claim from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 * @return the am analytics claim that was removed
	 */
	public static AMAnalyticsClaim deleteAMAnalyticsClaim(
		AMAnalyticsClaim amAnalyticsClaim) {

		return getService().deleteAMAnalyticsClaim(amAnalyticsClaim);
	}

	/**
	 * Deletes the am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim that was removed
	 * @throws PortalException if a am analytics claim with the primary key could not be found
	 */
	public static AMAnalyticsClaim deleteAMAnalyticsClaim(
			long amAnalyticsClaimId)
		throws PortalException {

		return getService().deleteAMAnalyticsClaim(amAnalyticsClaimId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
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
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AMAnalyticsClaim fetchAMAnalyticsClaim(
		long amAnalyticsClaimId) {

		return getService().fetchAMAnalyticsClaim(amAnalyticsClaimId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the am analytics claim with the primary key.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim
	 * @throws PortalException if a am analytics claim with the primary key could not be found
	 */
	public static AMAnalyticsClaim getAMAnalyticsClaim(long amAnalyticsClaimId)
		throws PortalException {

		return getService().getAMAnalyticsClaim(amAnalyticsClaimId);
	}

	/**
	 * Returns a range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @return the range of am analytics claims
	 */
	public static List<AMAnalyticsClaim> getAMAnalyticsClaims(
		int start, int end) {

		return getService().getAMAnalyticsClaims(start, end);
	}

	/**
	 * Returns the number of am analytics claims.
	 *
	 * @return the number of am analytics claims
	 */
	public static int getAMAnalyticsClaimsCount() {
		return getService().getAMAnalyticsClaimsCount();
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindex();
	}

	public static void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindex(companyId);
	}

	/**
	 * Updates the am analytics claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 * @return the am analytics claim that was updated
	 */
	public static AMAnalyticsClaim updateAMAnalyticsClaim(
		AMAnalyticsClaim amAnalyticsClaim) {

		return getService().updateAMAnalyticsClaim(amAnalyticsClaim);
	}

	public static AMAnalyticsClaimLocalService getService() {
		return _service;
	}

	private static volatile AMAnalyticsClaimLocalService _service;

}