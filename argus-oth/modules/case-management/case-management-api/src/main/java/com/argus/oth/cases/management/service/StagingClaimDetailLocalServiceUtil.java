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
 * Provides the local service utility for StagingClaimDetail. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingClaimDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetailLocalService
 * @generated
 */
public class StagingClaimDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingClaimDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimDetailLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingClaimDetailLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
		addStagingClaimDetail(
			long lineId, long externalClaimId, String serviceFrom,
			String serviceThru, String resultCodes, String procedureCode,
			double chargedAmount, double repricedAmount, double claimAmount,
			String paidDate, double paidAmount, double savingsAmount, int units,
			String coverage, String lineStatus, String revCode,
			String modifiedDate, String createdDate) {

		return getService().addStagingClaimDetail(
			lineId, externalClaimId, serviceFrom, serviceThru, resultCodes,
			procedureCode, chargedAmount, repricedAmount, claimAmount, paidDate,
			paidAmount, savingsAmount, units, coverage, lineStatus, revCode,
			modifiedDate, createdDate);
	}

	/**
	 * Adds the staging claim detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was added
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
		addStagingClaimDetail(
			com.argus.oth.cases.management.model.StagingClaimDetail
				stagingClaimDetail) {

		return getService().addStagingClaimDetail(stagingClaimDetail);
	}

	/**
	 * Creates a new staging claim detail with the primary key. Does not add the staging claim detail to the database.
	 *
	 * @param stagingClaimDetailId the primary key for the new staging claim detail
	 * @return the new staging claim detail
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
		createStagingClaimDetail(long stagingClaimDetailId) {

		return getService().createStagingClaimDetail(stagingClaimDetailId);
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
	 * Deletes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws PortalException if a staging claim detail with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
			deleteStagingClaimDetail(long stagingClaimDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingClaimDetail(stagingClaimDetailId);
	}

	/**
	 * Deletes the staging claim detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was removed
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
		deleteStagingClaimDetail(
			com.argus.oth.cases.management.model.StagingClaimDetail
				stagingClaimDetail) {

		return getService().deleteStagingClaimDetail(stagingClaimDetail);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.StagingClaimDetail
		fetchStagingClaimDetail(long stagingClaimDetailId) {

		return getService().fetchStagingClaimDetail(stagingClaimDetailId);
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
	 * Returns the staging claim detail with the primary key.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws PortalException if a staging claim detail with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
			getStagingClaimDetail(long stagingClaimDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingClaimDetail(stagingClaimDetailId);
	}

	/**
	 * Returns a range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @return the range of staging claim details
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.StagingClaimDetail>
			getStagingClaimDetails(int start, int end) {

		return getService().getStagingClaimDetails(start, end);
	}

	/**
	 * Returns the number of staging claim details.
	 *
	 * @return the number of staging claim details
	 */
	public static int getStagingClaimDetailsCount() {
		return getService().getStagingClaimDetailsCount();
	}

	/**
	 * Updates the staging claim detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was updated
	 */
	public static com.argus.oth.cases.management.model.StagingClaimDetail
		updateStagingClaimDetail(
			com.argus.oth.cases.management.model.StagingClaimDetail
				stagingClaimDetail) {

		return getService().updateStagingClaimDetail(stagingClaimDetail);
	}

	public static StagingClaimDetailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingClaimDetailLocalService, StagingClaimDetailLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingClaimDetailLocalService.class);

		ServiceTracker
			<StagingClaimDetailLocalService, StagingClaimDetailLocalService>
				serviceTracker =
					new ServiceTracker
						<StagingClaimDetailLocalService,
						 StagingClaimDetailLocalService>(
							 bundle.getBundleContext(),
							 StagingClaimDetailLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}