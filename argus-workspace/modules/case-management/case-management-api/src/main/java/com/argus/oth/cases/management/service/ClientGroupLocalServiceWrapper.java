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
 * Provides a wrapper for {@link ClientGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientGroupLocalService
 * @generated
 */
public class ClientGroupLocalServiceWrapper
	implements ClientGroupLocalService,
			   ServiceWrapper<ClientGroupLocalService> {

	public ClientGroupLocalServiceWrapper(
		ClientGroupLocalService clientGroupLocalService) {

		_clientGroupLocalService = clientGroupLocalService;
	}

	/**
	 * Adds the client group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientGroup the client group
	 * @return the client group that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup addClientGroup(
		com.argus.oth.cases.management.model.ClientGroup clientGroup) {

		return _clientGroupLocalService.addClientGroup(clientGroup);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>ClientGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ClientGroupLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup addClientGroup(
		long groupId, long externalClientGroupId, long clientId,
		String clientGroup, String clientGroupName, java.util.Date modifiedDate,
		java.util.Date createdDate, String randomString) {

		return _clientGroupLocalService.addClientGroup(
			groupId, externalClientGroupId, clientId, clientGroup,
			clientGroupName, modifiedDate, createdDate, randomString);
	}

	/**
	 * Creates a new client group with the primary key. Does not add the client group to the database.
	 *
	 * @param clientGroupId the primary key for the new client group
	 * @return the new client group
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup createClientGroup(
		long clientGroupId) {

		return _clientGroupLocalService.createClientGroup(clientGroupId);
	}

	/**
	 * Deletes the client group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientGroup the client group
	 * @return the client group that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup deleteClientGroup(
		com.argus.oth.cases.management.model.ClientGroup clientGroup) {

		return _clientGroupLocalService.deleteClientGroup(clientGroup);
	}

	/**
	 * Deletes the client group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group that was removed
	 * @throws PortalException if a client group with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup deleteClientGroup(
			long clientGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientGroupLocalService.deleteClientGroup(clientGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientGroupLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteUnprocessed(String randomString) {
		_clientGroupLocalService.deleteUnprocessed(randomString);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clientGroupLocalService.dynamicQuery();
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

		return _clientGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClientGroupModelImpl</code>.
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

		return _clientGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClientGroupModelImpl</code>.
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

		return _clientGroupLocalService.dynamicQuery(
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

		return _clientGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clientGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.ClientGroup
		fetchByExternalClientGroupId(long externalClientGroupId) {

		return _clientGroupLocalService.fetchByExternalClientGroupId(
			externalClientGroupId);
	}

	@Override
	public com.argus.oth.cases.management.model.ClientGroup fetchClientGroup(
		long clientGroupId) {

		return _clientGroupLocalService.fetchClientGroup(clientGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clientGroupLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the client group with the primary key.
	 *
	 * @param clientGroupId the primary key of the client group
	 * @return the client group
	 * @throws PortalException if a client group with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup getClientGroup(
			long clientGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientGroupLocalService.getClientGroup(clientGroupId);
	}

	/**
	 * Returns a range of all the client groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClientGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of client groups
	 * @param end the upper bound of the range of client groups (not inclusive)
	 * @return the range of client groups
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.ClientGroup>
		getClientGroups(int start, int end) {

		return _clientGroupLocalService.getClientGroups(start, end);
	}

	/**
	 * Returns the number of client groups.
	 *
	 * @return the number of client groups
	 */
	@Override
	public int getClientGroupsCount() {
		return _clientGroupLocalService.getClientGroupsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clientGroupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the client group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientGroup the client group
	 * @return the client group that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.ClientGroup updateClientGroup(
		com.argus.oth.cases.management.model.ClientGroup clientGroup) {

		return _clientGroupLocalService.updateClientGroup(clientGroup);
	}

	@Override
	public ClientGroupLocalService getWrappedService() {
		return _clientGroupLocalService;
	}

	@Override
	public void setWrappedService(
		ClientGroupLocalService clientGroupLocalService) {

		_clientGroupLocalService = clientGroupLocalService;
	}

	private ClientGroupLocalService _clientGroupLocalService;

}