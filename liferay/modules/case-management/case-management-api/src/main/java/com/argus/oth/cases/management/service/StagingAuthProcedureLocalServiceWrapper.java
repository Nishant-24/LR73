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
 * Provides a wrapper for {@link StagingAuthProcedureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAuthProcedureLocalService
 * @generated
 */
public class StagingAuthProcedureLocalServiceWrapper
	implements ServiceWrapper<StagingAuthProcedureLocalService>,
			   StagingAuthProcedureLocalService {

	public StagingAuthProcedureLocalServiceWrapper(
		StagingAuthProcedureLocalService stagingAuthProcedureLocalService) {

		_stagingAuthProcedureLocalService = stagingAuthProcedureLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAuthProcedureLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAuthProcedureLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
		addStagingAuthProcedure(
			long externalAuthorizationId, String authNumber,
			String medicalCodeId, String description,
			String externalModifiedDate, String externalCreatedDate) {

		return _stagingAuthProcedureLocalService.addStagingAuthProcedure(
			externalAuthorizationId, authNumber, medicalCodeId, description,
			externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Adds the staging auth procedure to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 * @return the staging auth procedure that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
		addStagingAuthProcedure(
			com.argus.oth.cases.management.model.StagingAuthProcedure
				stagingAuthProcedure) {

		return _stagingAuthProcedureLocalService.addStagingAuthProcedure(
			stagingAuthProcedure);
	}

	/**
	 * Creates a new staging auth procedure with the primary key. Does not add the staging auth procedure to the database.
	 *
	 * @param stagingAuthProcedureId the primary key for the new staging auth procedure
	 * @return the new staging auth procedure
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
		createStagingAuthProcedure(long stagingAuthProcedureId) {

		return _stagingAuthProcedureLocalService.createStagingAuthProcedure(
			stagingAuthProcedureId);
	}

	@Override
	public void deleteAll() {
		_stagingAuthProcedureLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthProcedureLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure that was removed
	 * @throws PortalException if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
			deleteStagingAuthProcedure(long stagingAuthProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthProcedureLocalService.deleteStagingAuthProcedure(
			stagingAuthProcedureId);
	}

	/**
	 * Deletes the staging auth procedure from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 * @return the staging auth procedure that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
		deleteStagingAuthProcedure(
			com.argus.oth.cases.management.model.StagingAuthProcedure
				stagingAuthProcedure) {

		return _stagingAuthProcedureLocalService.deleteStagingAuthProcedure(
			stagingAuthProcedure);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingAuthProcedureLocalService.dynamicQuery();
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

		return _stagingAuthProcedureLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stagingAuthProcedureLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stagingAuthProcedureLocalService.dynamicQuery(
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

		return _stagingAuthProcedureLocalService.dynamicQueryCount(
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

		return _stagingAuthProcedureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
		fetchStagingAuthProcedure(long stagingAuthProcedureId) {

		return _stagingAuthProcedureLocalService.fetchStagingAuthProcedure(
			stagingAuthProcedureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingAuthProcedureLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingAuthProcedureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingAuthProcedureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthProcedureLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the staging auth procedure with the primary key.
	 *
	 * @param stagingAuthProcedureId the primary key of the staging auth procedure
	 * @return the staging auth procedure
	 * @throws PortalException if a staging auth procedure with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
			getStagingAuthProcedure(long stagingAuthProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAuthProcedureLocalService.getStagingAuthProcedure(
			stagingAuthProcedureId);
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
	@Override
	public java.util.List
		<com.argus.oth.cases.management.model.StagingAuthProcedure>
			getStagingAuthProcedures(int start, int end) {

		return _stagingAuthProcedureLocalService.getStagingAuthProcedures(
			start, end);
	}

	/**
	 * Returns the number of staging auth procedures.
	 *
	 * @return the number of staging auth procedures
	 */
	@Override
	public int getStagingAuthProceduresCount() {
		return _stagingAuthProcedureLocalService.
			getStagingAuthProceduresCount();
	}

	/**
	 * Updates the staging auth procedure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAuthProcedure the staging auth procedure
	 * @return the staging auth procedure that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingAuthProcedure
		updateStagingAuthProcedure(
			com.argus.oth.cases.management.model.StagingAuthProcedure
				stagingAuthProcedure) {

		return _stagingAuthProcedureLocalService.updateStagingAuthProcedure(
			stagingAuthProcedure);
	}

	@Override
	public StagingAuthProcedureLocalService getWrappedService() {
		return _stagingAuthProcedureLocalService;
	}

	@Override
	public void setWrappedService(
		StagingAuthProcedureLocalService stagingAuthProcedureLocalService) {

		_stagingAuthProcedureLocalService = stagingAuthProcedureLocalService;
	}

	private StagingAuthProcedureLocalService _stagingAuthProcedureLocalService;

}