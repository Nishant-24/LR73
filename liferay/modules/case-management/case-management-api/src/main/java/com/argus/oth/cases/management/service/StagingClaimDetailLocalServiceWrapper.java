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
 * Provides a wrapper for {@link StagingClaimDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetailLocalService
 * @generated
 */
public class StagingClaimDetailLocalServiceWrapper
	implements ServiceWrapper<StagingClaimDetailLocalService>,
			   StagingClaimDetailLocalService {

	public StagingClaimDetailLocalServiceWrapper(
		StagingClaimDetailLocalService stagingClaimDetailLocalService) {

		_stagingClaimDetailLocalService = stagingClaimDetailLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimDetailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingClaimDetailLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
		addStagingClaimDetail(
			long lineId, long externalClaimId, String serviceFrom,
			String serviceThru, String resultCodes, String procedureCode,
			double chargedAmount, double repricedAmount, double claimAmount,
			String paidDate, double paidAmount, double savingsAmount, int units,
			String coverage, String lineStatus, String revCode,
			String modifiedDate, String createdDate) {

		return _stagingClaimDetailLocalService.addStagingClaimDetail(
			lineId, externalClaimId, serviceFrom, serviceThru, resultCodes,
			procedureCode, chargedAmount, repricedAmount, claimAmount, paidDate,
			paidAmount, savingsAmount, units, coverage, lineStatus, revCode,
			modifiedDate, createdDate);
	}

	/**
	 * Adds the staging claim detail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
		addStagingClaimDetail(
			com.argus.oth.cases.management.model.StagingClaimDetail
				stagingClaimDetail) {

		return _stagingClaimDetailLocalService.addStagingClaimDetail(
			stagingClaimDetail);
	}

	/**
	 * Creates a new staging claim detail with the primary key. Does not add the staging claim detail to the database.
	 *
	 * @param stagingClaimDetailId the primary key for the new staging claim detail
	 * @return the new staging claim detail
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
		createStagingClaimDetail(long stagingClaimDetailId) {

		return _stagingClaimDetailLocalService.createStagingClaimDetail(
			stagingClaimDetailId);
	}

	@Override
	public void deleteAll() {
		_stagingClaimDetailLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws PortalException if a staging claim detail with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
			deleteStagingClaimDetail(long stagingClaimDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimDetailLocalService.deleteStagingClaimDetail(
			stagingClaimDetailId);
	}

	/**
	 * Deletes the staging claim detail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
		deleteStagingClaimDetail(
			com.argus.oth.cases.management.model.StagingClaimDetail
				stagingClaimDetail) {

		return _stagingClaimDetailLocalService.deleteStagingClaimDetail(
			stagingClaimDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingClaimDetailLocalService.dynamicQuery();
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

		return _stagingClaimDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
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

		return _stagingClaimDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
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

		return _stagingClaimDetailLocalService.dynamicQuery(
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

		return _stagingClaimDetailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stagingClaimDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
		fetchStagingClaimDetail(long stagingClaimDetailId) {

		return _stagingClaimDetailLocalService.fetchStagingClaimDetail(
			stagingClaimDetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingClaimDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingClaimDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingClaimDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging claim detail with the primary key.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws PortalException if a staging claim detail with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
			getStagingClaimDetail(long stagingClaimDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimDetailLocalService.getStagingClaimDetail(
			stagingClaimDetailId);
	}

	/**
	 * Returns a range of all the staging claim details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim details
	 * @param end the upper bound of the range of staging claim details (not inclusive)
	 * @return the range of staging claim details
	 */
	@Override
	public java.util.List
		<com.argus.oth.cases.management.model.StagingClaimDetail>
			getStagingClaimDetails(int start, int end) {

		return _stagingClaimDetailLocalService.getStagingClaimDetails(
			start, end);
	}

	/**
	 * Returns the number of staging claim details.
	 *
	 * @return the number of staging claim details
	 */
	@Override
	public int getStagingClaimDetailsCount() {
		return _stagingClaimDetailLocalService.getStagingClaimDetailsCount();
	}

	/**
	 * Updates the staging claim detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingClaimDetail
		updateStagingClaimDetail(
			com.argus.oth.cases.management.model.StagingClaimDetail
				stagingClaimDetail) {

		return _stagingClaimDetailLocalService.updateStagingClaimDetail(
			stagingClaimDetail);
	}

	@Override
	public StagingClaimDetailLocalService getWrappedService() {
		return _stagingClaimDetailLocalService;
	}

	@Override
	public void setWrappedService(
		StagingClaimDetailLocalService stagingClaimDetailLocalService) {

		_stagingClaimDetailLocalService = stagingClaimDetailLocalService;
	}

	private StagingClaimDetailLocalService _stagingClaimDetailLocalService;

}