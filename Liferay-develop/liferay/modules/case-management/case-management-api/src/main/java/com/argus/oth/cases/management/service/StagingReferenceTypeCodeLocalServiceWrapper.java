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
 * Provides a wrapper for {@link StagingReferenceTypeCodeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingReferenceTypeCodeLocalService
 * @generated
 */
public class StagingReferenceTypeCodeLocalServiceWrapper
	implements ServiceWrapper<StagingReferenceTypeCodeLocalService>,
			   StagingReferenceTypeCodeLocalService {

	public StagingReferenceTypeCodeLocalServiceWrapper(
		StagingReferenceTypeCodeLocalService
			stagingReferenceTypeCodeLocalService) {

		_stagingReferenceTypeCodeLocalService =
			stagingReferenceTypeCodeLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingReferenceTypeCodeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingReferenceTypeCodeLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
		addStagingReferenceTypeCode(
			long externalReferenceTypeCodeId, String type, String key,
			String description, String modifiedDate, String createdDate) {

		return _stagingReferenceTypeCodeLocalService.
			addStagingReferenceTypeCode(
				externalReferenceTypeCodeId, type, key, description,
				modifiedDate, createdDate);
	}

	/**
	 * Adds the staging reference type code to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCode the staging reference type code
	 * @return the staging reference type code that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
		addStagingReferenceTypeCode(
			com.argus.oth.cases.management.model.StagingReferenceTypeCode
				stagingReferenceTypeCode) {

		return _stagingReferenceTypeCodeLocalService.
			addStagingReferenceTypeCode(stagingReferenceTypeCode);
	}

	/**
	 * Creates a new staging reference type code with the primary key. Does not add the staging reference type code to the database.
	 *
	 * @param stagingReferenceTypeCodeId the primary key for the new staging reference type code
	 * @return the new staging reference type code
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
		createStagingReferenceTypeCode(long stagingReferenceTypeCodeId) {

		return _stagingReferenceTypeCodeLocalService.
			createStagingReferenceTypeCode(stagingReferenceTypeCodeId);
	}

	@Override
	public void deleteAll() {
		_stagingReferenceTypeCodeLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingReferenceTypeCodeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code that was removed
	 * @throws PortalException if a staging reference type code with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
			deleteStagingReferenceTypeCode(long stagingReferenceTypeCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingReferenceTypeCodeLocalService.
			deleteStagingReferenceTypeCode(stagingReferenceTypeCodeId);
	}

	/**
	 * Deletes the staging reference type code from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCode the staging reference type code
	 * @return the staging reference type code that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
		deleteStagingReferenceTypeCode(
			com.argus.oth.cases.management.model.StagingReferenceTypeCode
				stagingReferenceTypeCode) {

		return _stagingReferenceTypeCodeLocalService.
			deleteStagingReferenceTypeCode(stagingReferenceTypeCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingReferenceTypeCodeLocalService.dynamicQuery();
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

		return _stagingReferenceTypeCodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeModelImpl</code>.
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

		return _stagingReferenceTypeCodeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeModelImpl</code>.
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

		return _stagingReferenceTypeCodeLocalService.dynamicQuery(
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

		return _stagingReferenceTypeCodeLocalService.dynamicQueryCount(
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

		return _stagingReferenceTypeCodeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
		fetchStagingReferenceTypeCode(long stagingReferenceTypeCodeId) {

		return _stagingReferenceTypeCodeLocalService.
			fetchStagingReferenceTypeCode(stagingReferenceTypeCodeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingReferenceTypeCodeLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingReferenceTypeCodeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingReferenceTypeCodeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingReferenceTypeCodeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the staging reference type code with the primary key.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code
	 * @throws PortalException if a staging reference type code with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
			getStagingReferenceTypeCode(long stagingReferenceTypeCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingReferenceTypeCodeLocalService.
			getStagingReferenceTypeCode(stagingReferenceTypeCodeId);
	}

	/**
	 * Returns a range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @return the range of staging reference type codes
	 */
	@Override
	public java.util.List
		<com.argus.oth.cases.management.model.StagingReferenceTypeCode>
			getStagingReferenceTypeCodes(int start, int end) {

		return _stagingReferenceTypeCodeLocalService.
			getStagingReferenceTypeCodes(start, end);
	}

	/**
	 * Returns the number of staging reference type codes.
	 *
	 * @return the number of staging reference type codes
	 */
	@Override
	public int getStagingReferenceTypeCodesCount() {
		return _stagingReferenceTypeCodeLocalService.
			getStagingReferenceTypeCodesCount();
	}

	/**
	 * Updates the staging reference type code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCode the staging reference type code
	 * @return the staging reference type code that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingReferenceTypeCode
		updateStagingReferenceTypeCode(
			com.argus.oth.cases.management.model.StagingReferenceTypeCode
				stagingReferenceTypeCode) {

		return _stagingReferenceTypeCodeLocalService.
			updateStagingReferenceTypeCode(stagingReferenceTypeCode);
	}

	@Override
	public StagingReferenceTypeCodeLocalService getWrappedService() {
		return _stagingReferenceTypeCodeLocalService;
	}

	@Override
	public void setWrappedService(
		StagingReferenceTypeCodeLocalService
			stagingReferenceTypeCodeLocalService) {

		_stagingReferenceTypeCodeLocalService =
			stagingReferenceTypeCodeLocalService;
	}

	private StagingReferenceTypeCodeLocalService
		_stagingReferenceTypeCodeLocalService;

}