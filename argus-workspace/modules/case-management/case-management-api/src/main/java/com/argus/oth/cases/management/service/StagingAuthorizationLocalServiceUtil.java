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

import com.argus.oth.cases.management.model.StagingAuthorization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StagingAuthorization. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingAuthorizationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthorizationLocalService
 * @generated
 */
public class StagingAuthorizationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingAuthorizationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAuthorizationLocalServiceUtil</code>.
	 */
	public static void addStagingAuthorization(
		long stagingAuthorizationId, long caseId, long externalMemberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		String statusChangeDate, String receivedDate, String authNumber,
		String category, String rtcAuthorizationType, String facility,
		String procedureCode, String comments, String effectiveFrom,
		String effectiveThru, String externalCreateDate,
		String externalModifiedDate) {

		getService().addStagingAuthorization(
			stagingAuthorizationId, caseId, externalMemberId, description,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, effectiveFrom, effectiveThru, externalCreateDate,
			externalModifiedDate);
	}

	/**
	 * Adds the staging authorization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthorization the staging authorization
	 * @return the staging authorization that was added
	 */
	public static StagingAuthorization addStagingAuthorization(
		StagingAuthorization stagingAuthorization) {

		return getService().addStagingAuthorization(stagingAuthorization);
	}

	/**
	 * Creates a new staging authorization with the primary key. Does not add the staging authorization to the database.
	 *
	 * @param stagingAuthorizationId the primary key for the new staging authorization
	 * @return the new staging authorization
	 */
	public static StagingAuthorization createStagingAuthorization(
		long stagingAuthorizationId) {

		return getService().createStagingAuthorization(stagingAuthorizationId);
	}

	public static void deleteAllStagingAuthorizations() {
		getService().deleteAllStagingAuthorizations();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization that was removed
	 * @throws PortalException if a staging authorization with the primary key could not be found
	 */
	public static StagingAuthorization deleteStagingAuthorization(
			long stagingAuthorizationId)
		throws PortalException {

		return getService().deleteStagingAuthorization(stagingAuthorizationId);
	}

	/**
	 * Deletes the staging authorization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthorization the staging authorization
	 * @return the staging authorization that was removed
	 */
	public static StagingAuthorization deleteStagingAuthorization(
		StagingAuthorization stagingAuthorization) {

		return getService().deleteStagingAuthorization(stagingAuthorization);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingAuthorizationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingAuthorizationModelImpl</code>.
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

	public static StagingAuthorization fetchStagingAuthorization(
		long stagingAuthorizationId) {

		return getService().fetchStagingAuthorization(stagingAuthorizationId);
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging authorization with the primary key.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization
	 * @throws PortalException if a staging authorization with the primary key could not be found
	 */
	public static StagingAuthorization getStagingAuthorization(
			long stagingAuthorizationId)
		throws PortalException {

		return getService().getStagingAuthorization(stagingAuthorizationId);
	}

	/**
	 * Returns a range of all the staging authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingAuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging authorizations
	 * @param end the upper bound of the range of staging authorizations (not inclusive)
	 * @return the range of staging authorizations
	 */
	public static List<StagingAuthorization> getStagingAuthorizations(
		int start, int end) {

		return getService().getStagingAuthorizations(start, end);
	}

	/**
	 * Returns the number of staging authorizations.
	 *
	 * @return the number of staging authorizations
	 */
	public static int getStagingAuthorizationsCount() {
		return getService().getStagingAuthorizationsCount();
	}

	/**
	 * Updates the staging authorization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAuthorization the staging authorization
	 * @return the staging authorization that was updated
	 */
	public static StagingAuthorization updateStagingAuthorization(
		StagingAuthorization stagingAuthorization) {

		return getService().updateStagingAuthorization(stagingAuthorization);
	}

	public static StagingAuthorizationLocalService getService() {
		return _service;
	}

	private static volatile StagingAuthorizationLocalService _service;

}