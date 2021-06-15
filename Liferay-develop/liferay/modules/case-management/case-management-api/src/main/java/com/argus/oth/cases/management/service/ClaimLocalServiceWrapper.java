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
 * Provides a wrapper for {@link ClaimLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalService
 * @generated
 */
public class ClaimLocalServiceWrapper
	implements ClaimLocalService, ServiceWrapper<ClaimLocalService> {

	public ClaimLocalServiceWrapper(ClaimLocalService claimLocalService) {
		_claimLocalService = claimLocalService;
	}

	/**
	 * Adds the claim to the database. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.Claim addClaim(
		com.argus.oth.cases.management.model.Claim claim) {

		return _claimLocalService.addClaim(claim);
	}

	@Override
	public com.argus.oth.cases.management.model.Claim addClaim(
		long groupId, long externalClaimId, String claimRef,
		String authorizationNumber, java.util.Date serviceFrom,
		java.util.Date serviceThru, String provider, String prioritizedBill,
		String diagCodesCombined, String providerState,
		java.util.Date tpmReceivedDate, long claimTurnaround, String billType,
		String providerNetwork, String repricedNetwork, long statusSortOrder,
		java.util.Date paidDate, double paidAmount, String claimStatus,
		java.util.Date modifiedDate, java.util.Date createdDate,
		String randomString) {

		return _claimLocalService.addClaim(
			groupId, externalClaimId, claimRef, authorizationNumber,
			serviceFrom, serviceThru, provider, prioritizedBill,
			diagCodesCombined, providerState, tpmReceivedDate, claimTurnaround,
			billType, providerNetwork, repricedNetwork, statusSortOrder,
			paidDate, paidAmount, claimStatus, modifiedDate, createdDate,
			randomString);
	}

	/**
	 * Creates a new claim with the primary key. Does not add the claim to the database.
	 *
	 * @param claimId the primary key for the new claim
	 * @return the new claim
	 */
	@Override
	public com.argus.oth.cases.management.model.Claim createClaim(
		long claimId) {

		return _claimLocalService.createClaim(claimId);
	}

	/**
	 * Deletes the claim from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.Claim deleteClaim(
		com.argus.oth.cases.management.model.Claim claim) {

		return _claimLocalService.deleteClaim(claim);
	}

	/**
	 * Deletes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim that was removed
	 * @throws PortalException if a claim with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Claim deleteClaim(long claimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.deleteClaim(claimId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteUnprocessed(String randomString) {
		_claimLocalService.deleteUnprocessed(randomString);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _claimLocalService.dynamicQuery();
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

		return _claimLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
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

		return _claimLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
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

		return _claimLocalService.dynamicQuery(
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

		return _claimLocalService.dynamicQueryCount(dynamicQuery);
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

		return _claimLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.Claim fetchByClaimRef(
		String claimRef) {

		return _claimLocalService.fetchByClaimRef(claimRef);
	}

	@Override
	public com.argus.oth.cases.management.model.Claim fetchClaim(long claimId) {
		return _claimLocalService.fetchClaim(claimId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _claimLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Claim>
		getByAuthorizationNumber(String authorizationNumber) {

		return _claimLocalService.getByAuthorizationNumber(authorizationNumber);
	}

	/**
	 * Returns the claim with the primary key.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim
	 * @throws PortalException if a claim with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Claim getClaim(long claimId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaim(claimId);
	}

	/**
	 * Returns a range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of claims
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Claim> getClaims(
		int start, int end) {

		return _claimLocalService.getClaims(start, end);
	}

	/**
	 * Returns the number of claims.
	 *
	 * @return the number of claims
	 */
	@Override
	public int getClaimsCount() {
		return _claimLocalService.getClaimsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _claimLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.Claim updateClaim(
		com.argus.oth.cases.management.model.Claim claim) {

		return _claimLocalService.updateClaim(claim);
	}

	@Override
	public ClaimLocalService getWrappedService() {
		return _claimLocalService;
	}

	@Override
	public void setWrappedService(ClaimLocalService claimLocalService) {
		_claimLocalService = claimLocalService;
	}

	private ClaimLocalService _claimLocalService;

}