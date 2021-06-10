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

import com.argus.oth.claim.model.StagingClaimAnalytics;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for StagingClaimAnalytics. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimAnalyticsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StagingClaimAnalyticsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.argus.oth.claim.service.impl.StagingClaimAnalyticsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the staging claim analytics local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link StagingClaimAnalyticsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimAnalyticsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingClaimAnalyticsLocalServiceUtil</code>.
	 */
	public StagingClaimAnalytics addStagingClaimAnalytics(
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
		String clientGroupName);

	/**
	 * Adds the staging claim analytics to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingClaimAnalytics addStagingClaimAnalytics(
		StagingClaimAnalytics stagingClaimAnalytics);

	/**
	 * Creates a new staging claim analytics with the primary key. Does not add the staging claim analytics to the database.
	 *
	 * @param stagingClaimAnalyticsId the primary key for the new staging claim analytics
	 * @return the new staging claim analytics
	 */
	@Transactional(enabled = false)
	public StagingClaimAnalytics createStagingClaimAnalytics(
		long stagingClaimAnalyticsId);

	public void deleteAll();

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the staging claim analytics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics that was removed
	 * @throws PortalException if a staging claim analytics with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingClaimAnalytics deleteStagingClaimAnalytics(
			long stagingClaimAnalyticsId)
		throws PortalException;

	/**
	 * Deletes the staging claim analytics from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingClaimAnalytics deleteStagingClaimAnalytics(
		StagingClaimAnalytics stagingClaimAnalytics);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl</code>.
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
	public StagingClaimAnalytics fetchStagingClaimAnalytics(
		long stagingClaimAnalyticsId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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

	/**
	 * Returns the staging claim analytics with the primary key.
	 *
	 * @param stagingClaimAnalyticsId the primary key of the staging claim analytics
	 * @return the staging claim analytics
	 * @throws PortalException if a staging claim analytics with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StagingClaimAnalytics getStagingClaimAnalytics(
			long stagingClaimAnalyticsId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StagingClaimAnalytics> getStagingClaimAnalyticses(
		int start, int end);

	/**
	 * Returns the number of staging claim analyticses.
	 *
	 * @return the number of staging claim analyticses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStagingClaimAnalyticsesCount();

	/**
	 * Updates the staging claim analytics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingClaimAnalyticsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingClaimAnalytics the staging claim analytics
	 * @return the staging claim analytics that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingClaimAnalytics updateStagingClaimAnalytics(
		StagingClaimAnalytics stagingClaimAnalytics);

}