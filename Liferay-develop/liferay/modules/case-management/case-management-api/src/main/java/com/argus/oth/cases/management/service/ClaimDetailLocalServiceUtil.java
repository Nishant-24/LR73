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
 * Provides the local service utility for ClaimDetail. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.ClaimDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimDetailLocalService
 * @generated
 */
public class ClaimDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.ClaimDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the claim detail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetail the claim detail
	 * @return the claim detail that was added
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
		addClaimDetail(
			com.argus.oth.cases.management.model.ClaimDetail claimDetail) {

		return getService().addClaimDetail(claimDetail);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>ClaimDetailLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>ClaimDetailLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
		addClaimDetail(
			long groupId, long lineId, long externalClaimId,
			java.util.Date serviceFrom, java.util.Date serviceThru,
			String resultCodes, String procedureCode, double chargedAmount,
			double repricedAmount, double claimAmount, java.util.Date paidDate,
			double paidAmount, double savingsAmount, int units, String coverage,
			String lineStatus, String revCode, java.util.Date modifiedDate,
			java.util.Date createdDate, String randomString) {

		return getService().addClaimDetail(
			groupId, lineId, externalClaimId, serviceFrom, serviceThru,
			resultCodes, procedureCode, chargedAmount, repricedAmount,
			claimAmount, paidDate, paidAmount, savingsAmount, units, coverage,
			lineStatus, revCode, modifiedDate, createdDate, randomString);
	}

	/**
	 * Creates a new claim detail with the primary key. Does not add the claim detail to the database.
	 *
	 * @param claimDetailId the primary key for the new claim detail
	 * @return the new claim detail
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
		createClaimDetail(long claimDetailId) {

		return getService().createClaimDetail(claimDetailId);
	}

	/**
	 * Deletes the claim detail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetail the claim detail
	 * @return the claim detail that was removed
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
		deleteClaimDetail(
			com.argus.oth.cases.management.model.ClaimDetail claimDetail) {

		return getService().deleteClaimDetail(claimDetail);
	}

	/**
	 * Deletes the claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail that was removed
	 * @throws PortalException if a claim detail with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
			deleteClaimDetail(long claimDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteClaimDetail(claimDetailId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimDetailModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.ClaimDetail
		fetchByLineId(long lineid) {

		return getService().fetchByLineId(lineid);
	}

	public static com.argus.oth.cases.management.model.ClaimDetail
		fetchClaimDetail(long claimDetailId) {

		return getService().fetchClaimDetail(claimDetailId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.ClaimDetail> getByExternalClaimId(
			long externalClaimId) {

		return getService().getByExternalClaimId(externalClaimId);
	}

	/**
	 * Returns the claim detail with the primary key.
	 *
	 * @param claimDetailId the primary key of the claim detail
	 * @return the claim detail
	 * @throws PortalException if a claim detail with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
			getClaimDetail(long claimDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimDetail(claimDetailId);
	}

	/**
	 * Returns a range of all the claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim details
	 * @param end the upper bound of the range of claim details (not inclusive)
	 * @return the range of claim details
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.ClaimDetail> getClaimDetails(
			int start, int end) {

		return getService().getClaimDetails(start, end);
	}

	/**
	 * Returns the number of claim details.
	 *
	 * @return the number of claim details
	 */
	public static int getClaimDetailsCount() {
		return getService().getClaimDetailsCount();
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
	 * Updates the claim detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param claimDetail the claim detail
	 * @return the claim detail that was updated
	 */
	public static com.argus.oth.cases.management.model.ClaimDetail
		updateClaimDetail(
			com.argus.oth.cases.management.model.ClaimDetail claimDetail) {

		return getService().updateClaimDetail(claimDetail);
	}

	public static ClaimDetailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimDetailLocalService, ClaimDetailLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimDetailLocalService.class);

		ServiceTracker<ClaimDetailLocalService, ClaimDetailLocalService>
			serviceTracker =
				new ServiceTracker
					<ClaimDetailLocalService, ClaimDetailLocalService>(
						bundle.getBundleContext(),
						ClaimDetailLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}