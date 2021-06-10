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
 * Provides a wrapper for {@link AuthProcedureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuthProcedureLocalService
 * @generated
 */
public class AuthProcedureLocalServiceWrapper
	implements AuthProcedureLocalService,
			   ServiceWrapper<AuthProcedureLocalService> {

	public AuthProcedureLocalServiceWrapper(
		AuthProcedureLocalService authProcedureLocalService) {

		_authProcedureLocalService = authProcedureLocalService;
	}

	/**
	 * Adds the auth procedure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authProcedure the auth procedure
	 * @return the auth procedure that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure addAuthProcedure(
		com.argus.oth.cases.management.model.AuthProcedure authProcedure) {

		return _authProcedureLocalService.addAuthProcedure(authProcedure);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AuthProcedureLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AuthProcedureLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure addAuthProcedure(
		long externalAuthorizationId, String authNumber, String medicalCodeId,
		String description, java.util.Date externalModifiedDate,
		java.util.Date externalCreatedDate) {

		return _authProcedureLocalService.addAuthProcedure(
			externalAuthorizationId, authNumber, medicalCodeId, description,
			externalModifiedDate, externalCreatedDate);
	}

	/**
	 * Creates a new auth procedure with the primary key. Does not add the auth procedure to the database.
	 *
	 * @param authProcedureId the primary key for the new auth procedure
	 * @return the new auth procedure
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure
		createAuthProcedure(long authProcedureId) {

		return _authProcedureLocalService.createAuthProcedure(authProcedureId);
	}

	@Override
	public void deleteAll() {
		_authProcedureLocalService.deleteAll();
	}

	/**
	 * Deletes the auth procedure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authProcedure the auth procedure
	 * @return the auth procedure that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure
		deleteAuthProcedure(
			com.argus.oth.cases.management.model.AuthProcedure authProcedure) {

		return _authProcedureLocalService.deleteAuthProcedure(authProcedure);
	}

	/**
	 * Deletes the auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure that was removed
	 * @throws PortalException if a auth procedure with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure
			deleteAuthProcedure(long authProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authProcedureLocalService.deleteAuthProcedure(authProcedureId);
	}

	@Override
	public void deleteByAuthNumber(String authNumber) {
		_authProcedureLocalService.deleteByAuthNumber(authNumber);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authProcedureLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authProcedureLocalService.dynamicQuery();
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

		return _authProcedureLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _authProcedureLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _authProcedureLocalService.dynamicQuery(
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

		return _authProcedureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _authProcedureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.AuthProcedure
		fetchAuthProcedure(long authProcedureId) {

		return _authProcedureLocalService.fetchAuthProcedure(authProcedureId);
	}

	@Override
	public com.argus.oth.cases.management.model.AuthProcedure
		fetchAuthProcedureByA_M(String authNumber, String medicalCodeId) {

		return _authProcedureLocalService.fetchAuthProcedureByA_M(
			authNumber, medicalCodeId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.AuthProcedure>
		fetchAuthProceduresByAuthNumber(String authNumber) {

		return _authProcedureLocalService.fetchAuthProceduresByAuthNumber(
			authNumber);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _authProcedureLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the auth procedure with the primary key.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure
	 * @throws PortalException if a auth procedure with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure getAuthProcedure(
			long authProcedureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authProcedureLocalService.getAuthProcedure(authProcedureId);
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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.AuthProcedure>
		getAuthProcedures(int start, int end) {

		return _authProcedureLocalService.getAuthProcedures(start, end);
	}

	/**
	 * Returns the number of auth procedures.
	 *
	 * @return the number of auth procedures
	 */
	@Override
	public int getAuthProceduresCount() {
		return _authProcedureLocalService.getAuthProceduresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _authProcedureLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _authProcedureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authProcedureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the auth procedure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthProcedureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authProcedure the auth procedure
	 * @return the auth procedure that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.AuthProcedure
		updateAuthProcedure(
			com.argus.oth.cases.management.model.AuthProcedure authProcedure) {

		return _authProcedureLocalService.updateAuthProcedure(authProcedure);
	}

	@Override
	public AuthProcedureLocalService getWrappedService() {
		return _authProcedureLocalService;
	}

	@Override
	public void setWrappedService(
		AuthProcedureLocalService authProcedureLocalService) {

		_authProcedureLocalService = authProcedureLocalService;
	}

	private AuthProcedureLocalService _authProcedureLocalService;

}