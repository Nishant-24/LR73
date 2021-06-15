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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StagingAuthorizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthorizationLocalService
 * @generated
 */
public class StagingAuthorizationLocalServiceWrapper
	implements ServiceWrapper<StagingAuthorizationLocalService>,
			   StagingAuthorizationLocalService {

	public StagingAuthorizationLocalServiceWrapper(
		StagingAuthorizationLocalService stagingAuthorizationLocalService) {

		_stagingAuthorizationLocalService = stagingAuthorizationLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAuthorizationLocalServiceUtil</code>.
	 */
	@Override
	public void addStagingAuthorization(
		long stagingAuthorizationId, long caseId, long externalMemberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		String statusChangeDate, String receivedDate, String authNumber,
		String category, String rtcAuthorizationType, String facility,
		String procedureCode, String comments, String effectiveFrom,
		String effectiveThru, String externalCreateDate,
		String externalModifiedDate) {

		_stagingAuthorizationLocalService.addStagingAuthorization(
			stagingAuthorizationId, caseId, externalMemberId, description,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, effectiveFrom, effectiveThru, externalCreateDate,
			externalModifiedDate);
	}

	/**
	 * Adds the staging authorization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorization the staging authorization
	 * @return the staging authorization that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
		addStagingAuthorization(
			com.argus.oth.cases.management.model.StagingAuthorization
				stagingAuthorization) {

		return _stagingAuthorizationLocalService.addStagingAuthorization(
			stagingAuthorization);
	}

	/**
	 * Creates a new staging authorization with the primary key. Does not add the staging authorization to the database.
	 *
	 * @param stagingAuthorizationId the primary key for the new staging authorization
	 * @return the new staging authorization
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
		createStagingAuthorization(long stagingAuthorizationId) {

		return _stagingAuthorizationLocalService.createStagingAuthorization(
			stagingAuthorizationId);
	}

	@Override
	public void deleteAllStagingAuthorizations() {
		_stagingAuthorizationLocalService.deleteAllStagingAuthorizations();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthorizationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization that was removed
	 * @throws PortalException if a staging authorization with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
			deleteStagingAuthorization(long stagingAuthorizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthorizationLocalService.deleteStagingAuthorization(
			stagingAuthorizationId);
	}

	/**
	 * Deletes the staging authorization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorization the staging authorization
	 * @return the staging authorization that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
		deleteStagingAuthorization(
			com.argus.oth.cases.management.model.StagingAuthorization
				stagingAuthorization) {

		return _stagingAuthorizationLocalService.deleteStagingAuthorization(
			stagingAuthorization);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingAuthorizationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingAuthorizationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stagingAuthorizationLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stagingAuthorizationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stagingAuthorizationLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stagingAuthorizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
		fetchStagingAuthorization(long stagingAuthorizationId) {

		return _stagingAuthorizationLocalService.fetchStagingAuthorization(
			stagingAuthorizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingAuthorizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingAuthorizationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingAuthorizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthorizationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the staging authorization with the primary key.
	 *
	 * @param stagingAuthorizationId the primary key of the staging authorization
	 * @return the staging authorization
	 * @throws PortalException if a staging authorization with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
			getStagingAuthorization(long stagingAuthorizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthorizationLocalService.getStagingAuthorization(
			stagingAuthorizationId);
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
	@Override
	public java.util.List
		<com.argus.oth.cases.management.model.StagingAuthorization>
			getStagingAuthorizations(int start, int end) {

		return _stagingAuthorizationLocalService.getStagingAuthorizations(
			start, end);
	}

	/**
	 * Returns the number of staging authorizations.
	 *
	 * @return the number of staging authorizations
	 */
	@Override
	public int getStagingAuthorizationsCount() {
		return _stagingAuthorizationLocalService.
			getStagingAuthorizationsCount();
	}

	/**
	 * Updates the staging authorization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthorization the staging authorization
	 * @return the staging authorization that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthorization
		updateStagingAuthorization(
			com.argus.oth.cases.management.model.StagingAuthorization
				stagingAuthorization) {

		return _stagingAuthorizationLocalService.updateStagingAuthorization(
			stagingAuthorization);
	}

	@Override
	public StagingAuthorizationLocalService getWrappedService() {
		return _stagingAuthorizationLocalService;
	}

	@Override
	public void setWrappedService(
		StagingAuthorizationLocalService stagingAuthorizationLocalService) {

		_stagingAuthorizationLocalService = stagingAuthorizationLocalService;
	}

	private StagingAuthorizationLocalService _stagingAuthorizationLocalService;

}