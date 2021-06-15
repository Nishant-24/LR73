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
 * Provides the local service utility for AuthProcedure. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.AuthProcedureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuthProcedureLocalService
 * @generated
 */
public class AuthProcedureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.AuthProcedureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the auth procedure to the database. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedure the auth procedure
	 * @return the auth procedure that was added
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
		addAuthProcedure(
			com.argus.oth.cases.management.model.AuthProcedure authProcedure) {

		return getService().addAuthProcedure(authProcedure);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AuthProcedureLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>AuthProcedureLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
		addAuthProcedure(
			long externalAuthorizationId, String authNumber,
			String medicalCodeId, String description,
			java.util.Date externalModifiedDate,
			java.util.Date externalCreatedDate) {

		return getService().addAuthProcedure(
			externalAuthorizationId, authNumber, medicalCodeId, description,
			externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Creates a new auth procedure with the primary key. Does not add the auth procedure to the database.
	 *
	 * @param authProcedureId the primary key for the new auth procedure
	 * @return the new auth procedure
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
		createAuthProcedure(long authProcedureId) {

		return getService().createAuthProcedure(authProcedureId);
	}

	public static void deleteAll() {
		getService().deleteAll();
	}

	/**
	 * Deletes the auth procedure from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedure the auth procedure
	 * @return the auth procedure that was removed
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
		deleteAuthProcedure(
			com.argus.oth.cases.management.model.AuthProcedure authProcedure) {

		return getService().deleteAuthProcedure(authProcedure);
	}

	/**
	 * Deletes the auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure that was removed
	 * @throws PortalException if a auth procedure with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
			deleteAuthProcedure(long authProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAuthProcedure(authProcedureId);
	}

	public static void deleteByAuthNumber(String authNumber) {
		getService().deleteByAuthNumber(authNumber);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthProcedureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthProcedureModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.AuthProcedure
		fetchAuthProcedure(long authProcedureId) {

		return getService().fetchAuthProcedure(authProcedureId);
	}

	public static com.argus.oth.cases.management.model.AuthProcedure
		fetchAuthProcedureByA_M(String authNumber, String medicalCodeId) {

		return getService().fetchAuthProcedureByA_M(authNumber, medicalCodeId);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.AuthProcedure>
			fetchAuthProceduresByAuthNumber(String authNumber) {

		return getService().fetchAuthProceduresByAuthNumber(authNumber);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the auth procedure with the primary key.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure
	 * @throws PortalException if a auth procedure with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
			getAuthProcedure(long authProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAuthProcedure(authProcedureId);
	}

	/**
	 * Returns a range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of auth procedures
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.AuthProcedure> getAuthProcedures(
			int start, int end) {

		return getService().getAuthProcedures(start, end);
	}

	/**
	 * Returns the number of auth procedures.
	 *
	 * @return the number of auth procedures
	 */
	public static int getAuthProceduresCount() {
		return getService().getAuthProceduresCount();
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
	 * Updates the auth procedure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedure the auth procedure
	 * @return the auth procedure that was updated
	 */
	public static com.argus.oth.cases.management.model.AuthProcedure
		updateAuthProcedure(
			com.argus.oth.cases.management.model.AuthProcedure authProcedure) {

		return getService().updateAuthProcedure(authProcedure);
	}

	public static AuthProcedureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuthProcedureLocalService, AuthProcedureLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AuthProcedureLocalService.class);

		ServiceTracker<AuthProcedureLocalService, AuthProcedureLocalService>
			serviceTracker =
				new ServiceTracker
					<AuthProcedureLocalService, AuthProcedureLocalService>(
						bundle.getBundleContext(),
						AuthProcedureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}