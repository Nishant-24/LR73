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
 * Provides a wrapper for {@link ClaimAnalyticsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalyticsLocalService
 * @generated
 */
public class ClaimAnalyticsLocalServiceWrapper
	implements ClaimAnalyticsLocalService,
			   ServiceWrapper<ClaimAnalyticsLocalService> {

	public ClaimAnalyticsLocalServiceWrapper(
		ClaimAnalyticsLocalService claimAnalyticsLocalService) {

		_claimAnalyticsLocalService = claimAnalyticsLocalService;
	}

	/**
	 * Adds the claim analytics to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAnalytics the claim analytics
	 * @return the claim analytics that was added
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics addClaimAnalytics(
		com.argus.oth.claim.model.ClaimAnalytics claimAnalytics) {

		return _claimAnalyticsLocalService.addClaimAnalytics(claimAnalytics);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>ClaimAnalyticsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ClaimAnalyticsLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics addClaimAnalytics(
		long groupId, long externalClientId, String clientName,
		String claimNumber, long externalCaseId, String claimStatus,
		java.util.Date receivedDate, java.util.Date serviceDate,
		java.util.Date paidDate, long externalMemberId, String memberName,
		String providerName, String billType, String primaryDiagnosis,
		double chargedAmount, double paidAmount, double repricedAmount,
		double savingsAmount, double chargedPercent, double repricedPercent,
		double savingsPercent, String chargedRange, String paidRange,
		String repricedRange, String savingsRange, long claimAging,
		String procedureCodes, String resultCodes, String diagnosisCodes,
		String country, String state, double financialExposure,
		String repricedNetwork, String clientGroupName) {

		return _claimAnalyticsLocalService.addClaimAnalytics(
			groupId, externalClientId, clientName, claimNumber, externalCaseId,
			claimStatus, receivedDate, serviceDate, paidDate, externalMemberId,
			memberName, providerName, billType, primaryDiagnosis, chargedAmount,
			paidAmount, repricedAmount, savingsAmount, chargedPercent,
			repricedPercent, savingsPercent, chargedRange, paidRange,
			repricedRange, savingsRange, claimAging, procedureCodes,
			resultCodes, diagnosisCodes, country, state, financialExposure,
			repricedNetwork, clientGroupName);
	}

	/**
	 * Creates a new claim analytics with the primary key. Does not add the claim analytics to the database.
	 *
	 * @param claimAnalyticsId the primary key for the new claim analytics
	 * @return the new claim analytics
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics createClaimAnalytics(
		long claimAnalyticsId) {

		return _claimAnalyticsLocalService.createClaimAnalytics(
			claimAnalyticsId);
	}

	@Override
	public void deleteAll() {
		_claimAnalyticsLocalService.deleteAll();
	}

	/**
	 * Deletes the claim analytics from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAnalytics the claim analytics
	 * @return the claim analytics that was removed
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics deleteClaimAnalytics(
		com.argus.oth.claim.model.ClaimAnalytics claimAnalytics) {

		return _claimAnalyticsLocalService.deleteClaimAnalytics(claimAnalytics);
	}

	/**
	 * Deletes the claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics that was removed
	 * @throws PortalException if a claim analytics with the primary key could not be found
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics deleteClaimAnalytics(
			long claimAnalyticsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAnalyticsLocalService.deleteClaimAnalytics(
			claimAnalyticsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAnalyticsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _claimAnalyticsLocalService.dynamicQuery();
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

		return _claimAnalyticsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.ClaimAnalyticsModelImpl</code>.
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

		return _claimAnalyticsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.ClaimAnalyticsModelImpl</code>.
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

		return _claimAnalyticsLocalService.dynamicQuery(
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

		return _claimAnalyticsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _claimAnalyticsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.claim.model.ClaimAnalytics fetchClaimAnalytics(
		long claimAnalyticsId) {

		return _claimAnalyticsLocalService.fetchClaimAnalytics(
			claimAnalyticsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _claimAnalyticsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.argus.oth.claim.model.ClaimAnalytics> getByE_C(
		long externalClientId, String claimStatus) {

		return _claimAnalyticsLocalService.getByE_C(
			externalClientId, claimStatus);
	}

	@Override
	public java.util.List<com.argus.oth.claim.model.ClaimAnalytics>
		getByExternalClientId(long externalClientId) {

		return _claimAnalyticsLocalService.getByExternalClientId(
			externalClientId);
	}

	/**
	 * Returns the claim analytics with the primary key.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics
	 * @throws PortalException if a claim analytics with the primary key could not be found
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics getClaimAnalytics(
			long claimAnalyticsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAnalyticsLocalService.getClaimAnalytics(claimAnalyticsId);
	}

	/**
	 * Returns a range of all the claim analyticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.ClaimAnalyticsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim analyticses
	 * @param end the upper bound of the range of claim analyticses (not inclusive)
	 * @return the range of claim analyticses
	 */
	@Override
	public java.util.List<com.argus.oth.claim.model.ClaimAnalytics>
		getClaimAnalyticses(int start, int end) {

		return _claimAnalyticsLocalService.getClaimAnalyticses(start, end);
	}

	/**
	 * Returns the number of claim analyticses.
	 *
	 * @return the number of claim analyticses
	 */
	@Override
	public int getClaimAnalyticsesCount() {
		return _claimAnalyticsLocalService.getClaimAnalyticsesCount();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document>
		getClaimReportSearchDocuments(
			com.argus.oth.common.report.ReportRetrievalParameters
				reportRetrievalParameters) {

		return _claimAnalyticsLocalService.getClaimReportSearchDocuments(
			reportRetrievalParameters);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _claimAnalyticsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimAnalyticsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAnalyticsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		_claimAnalyticsLocalService.reindex();
	}

	@Override
	public void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		_claimAnalyticsLocalService.reindex(companyId);
	}

	@Override
	public java.util.List<com.argus.oth.claim.model.ClaimAnalytics> search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _claimAnalyticsLocalService.search(searchContext);
	}

	/**
	 * Updates the claim analytics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAnalytics the claim analytics
	 * @return the claim analytics that was updated
	 */
	@Override
	public com.argus.oth.claim.model.ClaimAnalytics updateClaimAnalytics(
		com.argus.oth.claim.model.ClaimAnalytics claimAnalytics) {

		return _claimAnalyticsLocalService.updateClaimAnalytics(claimAnalytics);
	}

	@Override
	public ClaimAnalyticsLocalService getWrappedService() {
		return _claimAnalyticsLocalService;
	}

	@Override
	public void setWrappedService(
		ClaimAnalyticsLocalService claimAnalyticsLocalService) {

		_claimAnalyticsLocalService = claimAnalyticsLocalService;
	}

	private ClaimAnalyticsLocalService _claimAnalyticsLocalService;

}