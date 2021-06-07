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

import com.argus.oth.account.management.model.StagingAMAnalyticsClaim;

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
 * Provides the local service interface for StagingAMAnalyticsClaim. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMAnalyticsClaimLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StagingAMAnalyticsClaimLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingAMAnalyticsClaimLocalServiceUtil} to access the staging am analytics claim local service. Add custom service methods to <code>com.argus.oth.account.management.service.impl.StagingAMAnalyticsClaimLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMAnalyticsClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAMAnalyticsClaimLocalServiceUtil</code>.
	 */
	public StagingAMAnalyticsClaim add(
		long clientId, String amAnalyticsClaimDate, int avgClaimTurnAround,
		int minClaimTurnAround, int maxClaimTurnAround, int claimTurnAroundGoal,
		double overallAvgClaimTurnAround);

	/**
	 * Adds the staging am analytics claim to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingAMAnalyticsClaim addStagingAMAnalyticsClaim(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim);

	/**
	 * Creates a new staging am analytics claim with the primary key. Does not add the staging am analytics claim to the database.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key for the new staging am analytics claim
	 * @return the new staging am analytics claim
	 */
	@Transactional(enabled = false)
	public StagingAMAnalyticsClaim createStagingAMAnalyticsClaim(
		long stagingAMAnalyticsClaimId);

	public void deleteAll();

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the staging am analytics claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 * @throws PortalException if a staging am analytics claim with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingAMAnalyticsClaim deleteStagingAMAnalyticsClaim(
			long stagingAMAnalyticsClaimId)
		throws PortalException;

	/**
	 * Deletes the staging am analytics claim from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingAMAnalyticsClaim deleteStagingAMAnalyticsClaim(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl</code>.
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
	public StagingAMAnalyticsClaim fetchStagingAMAnalyticsClaim(
		long stagingAMAnalyticsClaimId);

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
	 * Returns the staging am analytics claim with the primary key.
	 *
	 * @param stagingAMAnalyticsClaimId the primary key of the staging am analytics claim
	 * @return the staging am analytics claim
	 * @throws PortalException if a staging am analytics claim with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StagingAMAnalyticsClaim getStagingAMAnalyticsClaim(
			long stagingAMAnalyticsClaimId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StagingAMAnalyticsClaim> getStagingAMAnalyticsClaims(
		int start, int end);

	/**
	 * Returns the number of staging am analytics claims.
	 *
	 * @return the number of staging am analytics claims
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStagingAMAnalyticsClaimsCount();

	/**
	 * Updates the staging am analytics claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMAnalyticsClaim the staging am analytics claim
	 * @return the staging am analytics claim that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingAMAnalyticsClaim updateStagingAMAnalyticsClaim(
		StagingAMAnalyticsClaim stagingAMAnalyticsClaim);

}