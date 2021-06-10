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

package com.argus.oth.account.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StagingAMAnalyticsClaimLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsClaimLocalService
 * @generated
 */
public class StagingAMAnalyticsClaimLocalServiceWrapper
	implements ServiceWrapper<StagingAMAnalyticsClaimLocalService>,
			   StagingAMAnalyticsClaimLocalService {

	public StagingAMAnalyticsClaimLocalServiceWrapper(
		StagingAMAnalyticsClaimLocalService
			stagingAMAnalyticsClaimLocalService) {

		_stagingAMAnalyticsClaimLocalService =
			stagingAMAnalyticsClaimLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMAnalyticsClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAMAnalyticsClaimLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim add(
		long clientId, String amAnalyticsClaimDate, int avgClaimTurnAround,
		int minClaimTurnAround, int maxClaimTurnAround, int claimTurnAroundGoal,
		double overallAvgClaimTurnAround) {

		return _stagingAMAnalyticsClaimLocalService.add(
			clientId, amAnalyticsClaimDate, avgClaimTurnAround,
			minClaimTurnAround, maxClaimTurnAround, claimTurnAroundGoal,
			overallAvgClaimTurnAround);
	}

	/**
	 * Adds the staging am analytics claim to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was added
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		addStagingAMAnalyticsClaim(
			com.argus.oth.account.management.model.StagingAMAnalyticsClaim
				stagingAMAnalyticsClaim) {

		return _stagingAMAnalyticsClaimLocalService.addStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaim);
	}

	/**
	 * Creates a new staging am analytics claim with the primary key. Does not add the staging am analytics claim to the database.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key for the new staging am analytics claim
	 * @return the new staging am analytics claim
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		createStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId) {

		return _stagingAMAnalyticsClaimLocalService.
			createStagingAMAnalyticsClaim(stagingAMAnalyticsClaimId);
	}

	@Override
	public void deleteAll() {
		_stagingAMAnalyticsClaimLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsClaimLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws PortalException if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
			deleteStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsClaimLocalService.
			deleteStagingAMAnalyticsClaim(stagingAMAnalyticsClaimId);
	}

	/**
	 * Deletes the staging am analytics claim from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		deleteStagingAMAnalyticsClaim(
			com.argus.oth.account.management.model.StagingAMAnalyticsClaim
				stagingAMAnalyticsClaim) {

		return _stagingAMAnalyticsClaimLocalService.
			deleteStagingAMAnalyticsClaim(stagingAMAnalyticsClaim);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingAMAnalyticsClaimLocalService.dynamicQuery();
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

		return _stagingAMAnalyticsClaimLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
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

		return _stagingAMAnalyticsClaimLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
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

		return _stagingAMAnalyticsClaimLocalService.dynamicQuery(
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

		return _stagingAMAnalyticsClaimLocalService.dynamicQueryCount(
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

		return _stagingAMAnalyticsClaimLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		fetchStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId) {

		return _stagingAMAnalyticsClaimLocalService.
			fetchStagingAMAnalyticsClaim(stagingAMAnalyticsClaimId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingAMAnalyticsClaimLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingAMAnalyticsClaimLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingAMAnalyticsClaimLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsClaimLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the staging am analytics claim with the primary key.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws PortalException if a staging am analytics claim with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
			getStagingAMAnalyticsClaim(long stagingAMAnalyticsClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMAnalyticsClaimLocalService.getStagingAMAnalyticsClaim(
			stagingAMAnalyticsClaimId);
	}

	/**
	 * Returns a range of all the staging am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging am analytics claims
	 * @param end the upper bound of the range of staging am analytics claims (not inclusive)
	 * @return the range of staging am analytics claims
	 */
	@Override
	public java.util.List
		<com.argus.oth.account.management.model.StagingAMAnalyticsClaim>
			getStagingAMAnalyticsClaims(int start, int end) {

		return _stagingAMAnalyticsClaimLocalService.getStagingAMAnalyticsClaims(
			start, end);
	}

	/**
	 * Returns the number of staging am analytics claims.
	 *
	 * @return the number of staging am analytics claims
	 */
	@Override
	public int getStagingAMAnalyticsClaimsCount() {
		return _stagingAMAnalyticsClaimLocalService.
			getStagingAMAnalyticsClaimsCount();
	}

	/**
	 * Updates the staging am analytics claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingAMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was updated
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMAnalyticsClaim
		updateStagingAMAnalyticsClaim(
			com.argus.oth.account.management.model.StagingAMAnalyticsClaim
				stagingAMAnalyticsClaim) {

		return _stagingAMAnalyticsClaimLocalService.
			updateStagingAMAnalyticsClaim(stagingAMAnalyticsClaim);
	}

	@Override
	public StagingAMAnalyticsClaimLocalService getWrappedService() {
		return _stagingAMAnalyticsClaimLocalService;
	}

	@Override
	public void setWrappedService(
		StagingAMAnalyticsClaimLocalService
			stagingAMAnalyticsClaimLocalService) {

		_stagingAMAnalyticsClaimLocalService =
			stagingAMAnalyticsClaimLocalService;
	}

	private StagingAMAnalyticsClaimLocalService
		_stagingAMAnalyticsClaimLocalService;

}