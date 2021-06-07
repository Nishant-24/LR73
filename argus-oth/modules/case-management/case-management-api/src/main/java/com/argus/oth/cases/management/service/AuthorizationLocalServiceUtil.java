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
 * Provides the local service utility for Authorization. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.AuthorizationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationLocalService
 * @generated
 */
public class AuthorizationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.AuthorizationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the authorization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorization the authorization
	 * @return the authorization that was added
	 */
	public static com.argus.oth.cases.management.model.Authorization
		addAuthorization(
			com.argus.oth.cases.management.model.Authorization authorization) {

		return getService().addAuthorization(authorization);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AuthorizationLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>AuthorizationLocalServiceUtil</code>.
	 */
	public static void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		java.util.Date statusChangeDate, java.util.Date receivedDate,
		String authNumber, String category, String rtcAuthorizationType,
		String facility, String procedureCode, String comments,
		java.util.Date externalModifiedDate, java.util.Date effectiveFrom,
		java.util.Date effectiveThru, String randomString) {

		getService().addAuthorization(
			groupId, caseId, externalAuthorizationId, memberId, description,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, externalModifiedDate, effectiveFrom, effectiveThru,
			randomString);
	}

	public static void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		java.util.Date statusChangeDate, java.util.Date receivedDate,
		String authNumber, String category, String rtcAuthorizationType,
		String facility, String procedureCode, String comments,
		java.util.Date externalModifiedDate, java.util.Date effectiveFrom,
		java.util.Date effectiveThru, String processStatus,
		String failureDescription, String randomString) {

		getService().addAuthorization(
			groupId, caseId, externalAuthorizationId, memberId, description,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, externalModifiedDate, effectiveFrom, effectiveThru,
			processStatus, failureDescription, randomString);
	}

	/**
	 * Creates a new authorization with the primary key. Does not add the authorization to the database.
	 *
	 * @param authorizationId the primary key for the new authorization
	 * @return the new authorization
	 */
	public static com.argus.oth.cases.management.model.Authorization
		createAuthorization(long authorizationId) {

		return getService().createAuthorization(authorizationId);
	}

	/**
	 * Deletes the authorization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorization the authorization
	 * @return the authorization that was removed
	 */
	public static com.argus.oth.cases.management.model.Authorization
		deleteAuthorization(
			com.argus.oth.cases.management.model.Authorization authorization) {

		return getService().deleteAuthorization(authorization);
	}

	/**
	 * Deletes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Authorization
			deleteAuthorization(long authorizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAuthorization(authorizationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthorizationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthorizationModelImpl</code>.
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

	public static com.argus.oth.cases.management.model.Authorization
		fetchAuthorization(long authorizationId) {

		return getService().fetchAuthorization(authorizationId);
	}

	public static com.argus.oth.cases.management.model.Authorization
		fetchAuthorizationByExternalAuthorizationId(
			long externalAuthorizationId) {

		return getService().fetchAuthorizationByExternalAuthorizationId(
			externalAuthorizationId);
	}

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	public static com.argus.oth.cases.management.model.Authorization
		fetchAuthorizationByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAuthorizationByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the authorization with the primary key.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.Authorization
			getAuthorization(long authorizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAuthorization(authorizationId);
	}

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization
	 * @throws PortalException if a matching authorization could not be found
	 */
	public static com.argus.oth.cases.management.model.Authorization
			getAuthorizationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAuthorizationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of authorizations
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization> getAuthorizations(
			int start, int end) {

		return getService().getAuthorizations(start, end);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
			getAuthorizationsByAuthNumber(String authNumber) {

		return getService().getAuthorizationsByAuthNumber(authNumber);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
			getAuthorizationsByCaseId(long caseId) {

		return getService().getAuthorizationsByCaseId(caseId);
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
			getAuthorizationsByCaseId(long caseId, int start, int end) {

		return getService().getAuthorizationsByCaseId(caseId, start, end);
	}

	/**
	 * Returns all the authorizations matching the UUID and company.
	 *
	 * @param uuid the UUID of the authorizations
	 * @param companyId the primary key of the company
	 * @return the matching authorizations, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
			getAuthorizationsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAuthorizationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of authorizations matching the UUID and company.
	 *
	 * @param uuid the UUID of the authorizations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching authorizations, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
			getAuthorizationsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.argus.oth.cases.management.model.Authorization>
						orderByComparator) {

		return getService().getAuthorizationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	public static int getAuthorizationsCount() {
		return getService().getAuthorizationsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the authorization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorization the authorization
	 * @return the authorization that was updated
	 */
	public static com.argus.oth.cases.management.model.Authorization
		updateAuthorization(
			com.argus.oth.cases.management.model.Authorization authorization) {

		return getService().updateAuthorization(authorization);
	}

	public static com.argus.oth.cases.management.model.Authorization
		updateAuthorization(
			long authorizationId, long externalAuthorizationId, long memberId,
			String rtcAuthorizationStatus, String authStatus,
			java.util.Date statusChangeDate, java.util.Date receivedDate,
			String authNumber, String category, String rtcAuthorizationType,
			String facility, String procedureCode, String comments,
			java.util.Date externalModifiedDate, java.util.Date effectiveFrom,
			java.util.Date effectiveThru) {

		return getService().updateAuthorization(
			authorizationId, externalAuthorizationId, memberId,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, externalModifiedDate, effectiveFrom, effectiveThru);
	}

	public static com.argus.oth.cases.management.model.Authorization
		updateAuthorization(
			long authorizationId, long externalAuthorizationId,
			String processStatus, String failureDescription) {

		return getService().updateAuthorization(
			authorizationId, externalAuthorizationId, processStatus,
			failureDescription);
	}

	public static AuthorizationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuthorizationLocalService, AuthorizationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AuthorizationLocalService.class);

		ServiceTracker<AuthorizationLocalService, AuthorizationLocalService>
			serviceTracker =
				new ServiceTracker
					<AuthorizationLocalService, AuthorizationLocalService>(
						bundle.getBundleContext(),
						AuthorizationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}