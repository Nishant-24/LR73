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
 * Provides a wrapper for {@link AuthorizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationLocalService
 * @generated
 */
public class AuthorizationLocalServiceWrapper
	implements AuthorizationLocalService,
			   ServiceWrapper<AuthorizationLocalService> {

	public AuthorizationLocalServiceWrapper(
		AuthorizationLocalService authorizationLocalService) {

		_authorizationLocalService = authorizationLocalService;
	}

	/**
	 * Adds the authorization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorization the authorization
	 * @return the authorization that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization addAuthorization(
		com.argus.oth.cases.management.model.Authorization authorization) {

		return _authorizationLocalService.addAuthorization(authorization);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AuthorizationLocalServiceUtil</code>.
	 */
	@Override
	public void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		java.util.Date statusChangeDate, java.util.Date receivedDate,
		String authNumber, String category, String rtcAuthorizationType,
		String facility, String procedureCode, String comments,
		java.util.Date externalModifiedDate, java.util.Date effectiveFrom,
		java.util.Date effectiveThru, String randomString) {

		_authorizationLocalService.addAuthorization(
			groupId, caseId, externalAuthorizationId, memberId, description,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, externalModifiedDate, effectiveFrom, effectiveThru,
			randomString);
	}

	@Override
	public void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		java.util.Date statusChangeDate, java.util.Date receivedDate,
		String authNumber, String category, String rtcAuthorizationType,
		String facility, String procedureCode, String comments,
		java.util.Date externalModifiedDate, java.util.Date effectiveFrom,
		java.util.Date effectiveThru, String processStatus,
		String failureDescription, String randomString) {

		_authorizationLocalService.addAuthorization(
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
	@Override
	public com.argus.oth.cases.management.model.Authorization
		createAuthorization(long authorizationId) {

		return _authorizationLocalService.createAuthorization(authorizationId);
	}

	/**
	 * Deletes the authorization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorization the authorization
	 * @return the authorization that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization
		deleteAuthorization(
			com.argus.oth.cases.management.model.Authorization authorization) {

		return _authorizationLocalService.deleteAuthorization(authorization);
	}

	/**
	 * Deletes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization
			deleteAuthorization(long authorizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorizationLocalService.deleteAuthorization(authorizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorizationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteUnprocessed(String randomString) {
		_authorizationLocalService.deleteUnprocessed(randomString);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authorizationLocalService.dynamicQuery();
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

		return _authorizationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _authorizationLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _authorizationLocalService.dynamicQuery(
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

		return _authorizationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _authorizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.Authorization
		fetchAuthorization(long authorizationId) {

		return _authorizationLocalService.fetchAuthorization(authorizationId);
	}

	@Override
	public com.argus.oth.cases.management.model.Authorization
		fetchAuthorizationByExternalAuthorizationId(
			long externalAuthorizationId) {

		return _authorizationLocalService.
			fetchAuthorizationByExternalAuthorizationId(
				externalAuthorizationId);
	}

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization
		fetchAuthorizationByUuidAndGroupId(String uuid, long groupId) {

		return _authorizationLocalService.fetchAuthorizationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _authorizationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the authorization with the primary key.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization getAuthorization(
			long authorizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorizationLocalService.getAuthorization(authorizationId);
	}

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization
	 * @throws PortalException if a matching authorization could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization
			getAuthorizationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorizationLocalService.getAuthorizationByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
		getAuthorizations(int start, int end) {

		return _authorizationLocalService.getAuthorizations(start, end);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
		getAuthorizationsByAuthNumber(String authNumber) {

		return _authorizationLocalService.getAuthorizationsByAuthNumber(
			authNumber);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
		getAuthorizationsByCaseId(long caseId) {

		return _authorizationLocalService.getAuthorizationsByCaseId(caseId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
		getAuthorizationsByCaseId(long caseId, int start, int end) {

		return _authorizationLocalService.getAuthorizationsByCaseId(
			caseId, start, end);
	}

	/**
	 * Returns all the authorizations matching the UUID and company.
	 *
	 * @param uuid the UUID of the authorizations
	 * @param companyId the primary key of the company
	 * @return the matching authorizations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
		getAuthorizationsByUuidAndCompanyId(String uuid, long companyId) {

		return _authorizationLocalService.getAuthorizationsByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Authorization>
		getAuthorizationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.argus.oth.cases.management.model.Authorization>
					orderByComparator) {

		return _authorizationLocalService.getAuthorizationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	@Override
	public int getAuthorizationsCount() {
		return _authorizationLocalService.getAuthorizationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _authorizationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _authorizationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _authorizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _authorizationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the authorization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param authorization the authorization
	 * @return the authorization that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.Authorization
		updateAuthorization(
			com.argus.oth.cases.management.model.Authorization authorization) {

		return _authorizationLocalService.updateAuthorization(authorization);
	}

	@Override
	public com.argus.oth.cases.management.model.Authorization
		updateAuthorization(
			long authorizationId, long externalAuthorizationId, long memberId,
			String rtcAuthorizationStatus, String authStatus,
			java.util.Date statusChangeDate, java.util.Date receivedDate,
			String authNumber, String category, String rtcAuthorizationType,
			String facility, String procedureCode, String comments,
			java.util.Date externalModifiedDate, java.util.Date effectiveFrom,
			java.util.Date effectiveThru) {

		return _authorizationLocalService.updateAuthorization(
			authorizationId, externalAuthorizationId, memberId,
			rtcAuthorizationStatus, authStatus, statusChangeDate, receivedDate,
			authNumber, category, rtcAuthorizationType, facility, procedureCode,
			comments, externalModifiedDate, effectiveFrom, effectiveThru);
	}

	@Override
	public com.argus.oth.cases.management.model.Authorization
		updateAuthorization(
			long authorizationId, long externalAuthorizationId,
			String processStatus, String failureDescription) {

		return _authorizationLocalService.updateAuthorization(
			authorizationId, externalAuthorizationId, processStatus,
			failureDescription);
	}

	@Override
	public AuthorizationLocalService getWrappedService() {
		return _authorizationLocalService;
	}

	@Override
	public void setWrappedService(
		AuthorizationLocalService authorizationLocalService) {

		_authorizationLocalService = authorizationLocalService;
	}

	private AuthorizationLocalService _authorizationLocalService;

}