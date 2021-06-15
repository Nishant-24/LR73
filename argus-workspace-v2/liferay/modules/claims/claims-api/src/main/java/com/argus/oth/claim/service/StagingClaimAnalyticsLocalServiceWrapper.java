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

package com.argus.oth.claim.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StagingClaimAnalyticsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimAnalyticsLocalService
 * @generated
 */
public class StagingClaimAnalyticsLocalServiceWrapper
	implements ServiceWrapper<StagingClaimAnalyticsLocalService>,
			   StagingClaimAnalyticsLocalService {

	public StagingClaimAnalyticsLocalServiceWrapper(
		StagingClaimAnalyticsLocalService stagingClaimAnalyticsLocalService) {

		_stagingClaimAnalyticsLocalService = stagingClaimAnalyticsLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimAnalyticsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingClaimAnalyticsLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
		addStagingClaimAnalytics(
			long externalClientId, String clientName, String claimNumber,
			long externalCaseId, String claimStatus, String receivedDate,
			String serviceDate, String paidDate, long externalMemberId,
			String memberName, String providerName, String billType,
			String primaryDiagnosis, double chargedAmount, double paidAmount,
			double repricedAmount, double savingsAmount, double chargedPercent,
			double repricedPercent, double savingsPercent, String chargedRange,
			String paidRange, String repricedRange, String savingsRange,
			long claimAging, String procedureCodes, String resultCodes,
			String diagnosisCodes, String country, String state,
			double financialExposure, String repricedNetwork,
			String clientGroupName) {

		return _stagingClaimAnalyticsLocalService.addStagingClaimAnalytics(
			externalClientId, clientName, claimNumber, externalCaseId,
			claimStatus, receivedDate, serviceDate, paidDate, externalMemberId,
			memberName, providerName, billType, primaryDiagnosis, chargedAmount,
			paidAmount, repricedAmount, savingsAmount, chargedPercent,
			repricedPercent, savingsPercent, chargedRange, paidRange,
			repricedRange, savingsRange, claimAging, procedureCodes,
			resultCodes, diagnosisCodes, country, state, financialExposure,
			repricedNetwork, clientGroupName);
	}

	/**
	 * Adds the staging claim analytics to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was added
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
		addStagingClaimAnalytics(
			com.argus.oth.claim.model.StagingClaimAnalytics
				stagingClaimAnalytics) {

		return _stagingClaimAnalyticsLocalService.addStagingClaimAnalytics(
			stagingClaimAnalytics);
	}

	/**
	 * Creates a new staging claim analytics with the primary key. Does not add the staging claim analytics to the database.
	 *
	 * @param stagingClaimAnalyticsId the primary key for the new staging claim analytics
	 * @return the new staging claim analytics
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
		createStagingClaimAnalytics(long stagingClaimAnalyticsId) {

		return _stagingClaimAnalyticsLocalService.createStagingClaimAnalytics(
			stagingClaimAnalyticsId);
	}

	@Override
	public void deleteAll() {
		_stagingClaimAnalyticsLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimAnalyticsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws PortalException if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
			deleteStagingClaimAnalytics(long stagingClaimAnalyticsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimAnalyticsLocalService.deleteStagingClaimAnalytics(
			stagingClaimAnalyticsId);
	}

	/**
	 * Deletes the staging claim analytics from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was removed
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
		deleteStagingClaimAnalytics(
			com.argus.oth.claim.model.StagingClaimAnalytics
				stagingClaimAnalytics) {

		return _stagingClaimAnalyticsLocalService.deleteStagingClaimAnalytics(
			stagingClaimAnalytics);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingClaimAnalyticsLocalService.dynamicQuery();
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

		return _stagingClaimAnalyticsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
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

		return _stagingClaimAnalyticsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
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

		return _stagingClaimAnalyticsLocalService.dynamicQuery(
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

		return _stagingClaimAnalyticsLocalService.dynamicQueryCount(
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

		return _stagingClaimAnalyticsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
		fetchStagingClaimAnalytics(long stagingClaimAnalyticsId) {

		return _stagingClaimAnalyticsLocalService.fetchStagingClaimAnalytics(
			stagingClaimAnalyticsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingClaimAnalyticsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingClaimAnalyticsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingClaimAnalyticsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimAnalyticsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the staging claim analytics with the primary key.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws PortalException if a staging claim analytics with the primary key could not be found
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
			getStagingClaimAnalytics(long stagingClaimAnalyticsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingClaimAnalyticsLocalService.getStagingClaimAnalytics(
			stagingClaimAnalyticsId);
	}

	/**
	 * Returns a range of all the staging claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging claim analyticses
	 * @param end the upper bound of the range of staging claim analyticses (not inclusive)
	 * @return the range of staging claim analyticses
	 */
	@Override
	public java.util.List<com.argus.oth.claim.model.StagingClaimAnalytics>
		getStagingClaimAnalyticses(int start, int end) {

		return _stagingClaimAnalyticsLocalService.getStagingClaimAnalyticses(
			start, end);
	}

	/**
	 * Returns the number of staging claim analyticses.
	 *
	 * @return the number of staging claim analyticses
	 */
	@Override
	public int getStagingClaimAnalyticsesCount() {
		return _stagingClaimAnalyticsLocalService.
			getStagingClaimAnalyticsesCount();
	}

	/**
	 * Updates the staging claim analytics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was updated
	 */
	@Override
	public com.argus.oth.claim.model.StagingClaimAnalytics
		updateStagingClaimAnalytics(
			com.argus.oth.claim.model.StagingClaimAnalytics
				stagingClaimAnalytics) {

		return _stagingClaimAnalyticsLocalService.updateStagingClaimAnalytics(
			stagingClaimAnalytics);
	}

	@Override
	public StagingClaimAnalyticsLocalService getWrappedService() {
		return _stagingClaimAnalyticsLocalService;
	}

	@Override
	public void setWrappedService(
		StagingClaimAnalyticsLocalService stagingClaimAnalyticsLocalService) {

		_stagingClaimAnalyticsLocalService = stagingClaimAnalyticsLocalService;
	}

	private StagingClaimAnalyticsLocalService
		_stagingClaimAnalyticsLocalService;

}