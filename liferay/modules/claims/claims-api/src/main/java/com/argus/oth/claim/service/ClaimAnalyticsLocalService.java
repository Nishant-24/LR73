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

import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.common.report.ReportRetrievalParameters;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ClaimAnalytics. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalyticsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ClaimAnalyticsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimAnalyticsLocalServiceUtil} to access the claim analytics local service. Add custom service methods to <code>com.argus.oth.claim.service.impl.ClaimAnalyticsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the claim analytics to the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalytics the claim analytics
	 * @return the claim analytics that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ClaimAnalytics addClaimAnalytics(ClaimAnalytics claimAnalytics);

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>ClaimAnalyticsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ClaimAnalyticsLocalServiceUtil</code>.
	 */
	public ClaimAnalytics addClaimAnalytics(
		long groupId, long externalClientId, String clientName,
		String claimNumber, long externalCaseId, String claimStatus,
		Date receivedDate, Date serviceDate, Date paidDate,
		long externalMemberId, String memberName, String providerName,
		String billType, String primaryDiagnosis, double chargedAmount,
		double paidAmount, double repricedAmount, double savingsAmount,
		double chargedPercent, double repricedPercent, double savingsPercent,
		String chargedRange, String paidRange, String repricedRange,
		String savingsRange, long claimAging, String procedureCodes,
		String resultCodes, String diagnosisCodes, String country, String state,
		double financialExposure, String repricedNetwork,
		String clientGroupName);

	/**
	 * Creates a new claim analytics with the primary key. Does not add the claim analytics to the database.
	 *
	 * @param claimAnalyticsId the primary key for the new claim analytics
	 * @return the new claim analytics
	 */
	@Transactional(enabled = false)
	public ClaimAnalytics createClaimAnalytics(long claimAnalyticsId);

	public void deleteAll();

	/**
	 * Deletes the claim analytics from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalytics the claim analytics
	 * @return the claim analytics that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ClaimAnalytics deleteClaimAnalytics(ClaimAnalytics claimAnalytics);

	/**
	 * Deletes the claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics that was removed
	 * @throws PortalException if a claim analytics with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ClaimAnalytics deleteClaimAnalytics(long claimAnalyticsId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClaimAnalytics fetchClaimAnalytics(long claimAnalyticsId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimAnalytics> getByE_C(
		long externalClientId, String claimStatus);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimAnalytics> getByExternalClientId(long externalClientId);

	/**
	 * Returns the claim analytics with the primary key.
	 *
	 * @param claimAnalyticsId the primary key of the claim analytics
	 * @return the claim analytics
	 * @throws PortalException if a claim analytics with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClaimAnalytics getClaimAnalytics(long claimAnalyticsId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimAnalytics> getClaimAnalyticses(int start, int end);

	/**
	 * Returns the number of claim analyticses.
	 *
	 * @return the number of claim analyticses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getClaimAnalyticsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Document> getClaimReportSearchDocuments(
		ReportRetrievalParameters reportRetrievalParameters);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void reindex() throws SearchException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void reindex(long companyId) throws SearchException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimAnalytics> search(SearchContext searchContext)
		throws SearchException;

	/**
	 * Updates the claim analytics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param claimAnalytics the claim analytics
	 * @return the claim analytics that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ClaimAnalytics updateClaimAnalytics(ClaimAnalytics claimAnalytics);

}