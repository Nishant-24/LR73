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
 * Provides a wrapper for {@link AMAnalyticsClaimLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsClaimLocalService
 * @generated
 */
public class AMAnalyticsClaimLocalServiceWrapper
	implements AMAnalyticsClaimLocalService,
			   ServiceWrapper<AMAnalyticsClaimLocalService> {

	public AMAnalyticsClaimLocalServiceWrapper(
		AMAnalyticsClaimLocalService amAnalyticsClaimLocalService) {

		_amAnalyticsClaimLocalService = amAnalyticsClaimLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AMAnalyticsClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AMAnalyticsClaimLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim add(
		long groupId, long clientId, java.util.Date amAnalyticsClaimDate,
		int avgClaimTurnAround, int minClaimTurnAround, int maxClaimTurnAround,
		int claimTurnAroundGoal, double overallAvgClaimTurnAround) {

		return _amAnalyticsClaimLocalService.add(
			groupId, clientId, amAnalyticsClaimDate, avgClaimTurnAround,
			minClaimTurnAround, maxClaimTurnAround, claimTurnAroundGoal,
			overallAvgClaimTurnAround);
	}

	/**
	 * Adds the am analytics claim to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 * @return the am analytics claim that was added
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
		addAMAnalyticsClaim(
			com.argus.oth.account.management.model.AMAnalyticsClaim
				amAnalyticsClaim) {

		return _amAnalyticsClaimLocalService.addAMAnalyticsClaim(
			amAnalyticsClaim);
	}

	/**
	 * Creates a new am analytics claim with the primary key. Does not add the am analytics claim to the database.
	 *
	 * @param amAnalyticsClaimId the primary key for the new am analytics claim
	 * @return the new am analytics claim
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
		createAMAnalyticsClaim(long amAnalyticsClaimId) {

		return _amAnalyticsClaimLocalService.createAMAnalyticsClaim(
			amAnalyticsClaimId);
	}

	@Override
	public void deleteAll() {
		_amAnalyticsClaimLocalService.deleteAll();
	}

	/**
	 * Deletes the am analytics claim from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 * @return the am analytics claim that was removed
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
		deleteAMAnalyticsClaim(
			com.argus.oth.account.management.model.AMAnalyticsClaim
				amAnalyticsClaim) {

		return _amAnalyticsClaimLocalService.deleteAMAnalyticsClaim(
			amAnalyticsClaim);
	}

	/**
	 * Deletes the am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim that was removed
	 * @throws PortalException if a am analytics claim with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
			deleteAMAnalyticsClaim(long amAnalyticsClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsClaimLocalService.deleteAMAnalyticsClaim(
			amAnalyticsClaimId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsClaimLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amAnalyticsClaimLocalService.dynamicQuery();
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

		return _amAnalyticsClaimLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl</code>.
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

		return _amAnalyticsClaimLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl</code>.
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

		return _amAnalyticsClaimLocalService.dynamicQuery(
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

		return _amAnalyticsClaimLocalService.dynamicQueryCount(dynamicQuery);
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

		return _amAnalyticsClaimLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
		fetchAMAnalyticsClaim(long amAnalyticsClaimId) {

		return _amAnalyticsClaimLocalService.fetchAMAnalyticsClaim(
			amAnalyticsClaimId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amAnalyticsClaimLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the am analytics claim with the primary key.
	 *
	 * @param amAnalyticsClaimId the primary key of the am analytics claim
	 * @return the am analytics claim
	 * @throws PortalException if a am analytics claim with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
			getAMAnalyticsClaim(long amAnalyticsClaimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsClaimLocalService.getAMAnalyticsClaim(
			amAnalyticsClaimId);
	}

	/**
	 * Returns a range of all the am analytics claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics claims
	 * @param end the upper bound of the range of am analytics claims (not inclusive)
	 * @return the range of am analytics claims
	 */
	@Override
	public java.util.List
		<com.argus.oth.account.management.model.AMAnalyticsClaim>
			getAMAnalyticsClaims(int start, int end) {

		return _amAnalyticsClaimLocalService.getAMAnalyticsClaims(start, end);
	}

	/**
	 * Returns the number of am analytics claims.
	 *
	 * @return the number of am analytics claims
	 */
	@Override
	public int getAMAnalyticsClaimsCount() {
		return _amAnalyticsClaimLocalService.getAMAnalyticsClaimsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amAnalyticsClaimLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amAnalyticsClaimLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsClaimLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		_amAnalyticsClaimLocalService.reindex();
	}

	@Override
	public void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		_amAnalyticsClaimLocalService.reindex(companyId);
	}

	/**
	 * Updates the am analytics claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsClaimLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsClaim the am analytics claim
	 * @return the am analytics claim that was updated
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsClaim
		updateAMAnalyticsClaim(
			com.argus.oth.account.management.model.AMAnalyticsClaim
				amAnalyticsClaim) {

		return _amAnalyticsClaimLocalService.updateAMAnalyticsClaim(
			amAnalyticsClaim);
	}

	@Override
	public AMAnalyticsClaimLocalService getWrappedService() {
		return _amAnalyticsClaimLocalService;
	}

	@Override
	public void setWrappedService(
		AMAnalyticsClaimLocalService amAnalyticsClaimLocalService) {

		_amAnalyticsClaimLocalService = amAnalyticsClaimLocalService;
	}

	private AMAnalyticsClaimLocalService _amAnalyticsClaimLocalService;

}