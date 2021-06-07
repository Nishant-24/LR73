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
 * Provides the local service utility for StagingAuthProcedure. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingAuthProcedureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthProcedureLocalService
 * @generated
 */
public class StagingAuthProcedureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingAuthProcedureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAuthProcedureLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>StagingAuthProcedureLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
		addStagingAuthProcedure(
			long externalAuthorizationId, String authNumber,
			String medicalCodeId, String description,
			String externalModifiedDate, String externalCreatedDate) {

		return getService().addStagingAuthProcedure(
			externalAuthorizationId, authNumber, medicalCodeId, description,
			externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Adds the staging auth procedure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 * @return the staging auth procedure that was added
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
		addStagingAuthProcedure(
			com.argus.oth.cases.management.model.StagingAuthProcedure
				stagingAuthProcedure) {

		return getService().addStagingAuthProcedure(stagingAuthProcedure);
	}

	/**
	 * Creates a new staging auth procedure with the primary key. Does not add the staging auth procedure to the database.
	 *
	 * @param stagingAuthProcedureId the primary key for the new staging auth procedure
	 * @return the new staging auth procedure
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
		createStagingAuthProcedure(long stagingAuthProcedureId) {

		return getService().createStagingAuthProcedure(stagingAuthProcedureId);
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
	 * Deletes the staging auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure that was removed
	 * @throws PortalException if a staging auth procedure with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
			deleteStagingAuthProcedure(long stagingAuthProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStagingAuthProcedure(stagingAuthProcedureId);
	}

	/**
	 * Deletes the staging auth procedure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 * @return the staging auth procedure that was removed
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
		deleteStagingAuthProcedure(
			com.argus.oth.cases.management.model.StagingAuthProcedure
				stagingAuthProcedure) {

		return getService().deleteStagingAuthProcedure(stagingAuthProcedure);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingAuthProcedureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingAuthProcedureModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.StagingAuthProcedure
		fetchStagingAuthProcedure(long stagingAuthProcedureId) {

		return getService().fetchStagingAuthProcedure(stagingAuthProcedureId);
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
	 * Returns the staging auth procedure with the primary key.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure
	 * @throws PortalException if a staging auth procedure with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
			getStagingAuthProcedure(long stagingAuthProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStagingAuthProcedure(stagingAuthProcedureId);
	}

	/**
	 * Returns a range of all the staging auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingAuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging auth procedures
	 * @param end the upper bound of the range of staging auth procedures (not inclusive)
	 * @return the range of staging auth procedures
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.StagingAuthProcedure>
			getStagingAuthProcedures(int start, int end) {

		return getService().getStagingAuthProcedures(start, end);
	}

	/**
	 * Returns the number of staging auth procedures.
	 *
	 * @return the number of staging auth procedures
	 */
	public static int getStagingAuthProceduresCount() {
		return getService().getStagingAuthProceduresCount();
	}

	/**
	 * Updates the staging auth procedure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 * @return the staging auth procedure that was updated
	 */
	public static com.argus.oth.cases.management.model.StagingAuthProcedure
		updateStagingAuthProcedure(
			com.argus.oth.cases.management.model.StagingAuthProcedure
				stagingAuthProcedure) {

		return getService().updateStagingAuthProcedure(stagingAuthProcedure);
	}

	public static StagingAuthProcedureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StagingAuthProcedureLocalService, StagingAuthProcedureLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StagingAuthProcedureLocalService.class);

		ServiceTracker
			<StagingAuthProcedureLocalService, StagingAuthProcedureLocalService>
				serviceTracker =
					new ServiceTracker
						<StagingAuthProcedureLocalService,
						 StagingAuthProcedureLocalService>(
							 bundle.getBundleContext(),
							 StagingAuthProcedureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}