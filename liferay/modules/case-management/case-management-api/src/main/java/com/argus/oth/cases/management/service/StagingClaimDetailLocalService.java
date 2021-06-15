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

import com.argus.oth.cases.management.model.StagingClaimDetail;

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
 * Provides the local service interface for StagingClaimDetail. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetailLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StagingClaimDetailLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingClaimDetailLocalServiceUtil} to access the staging claim detail local service. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingClaimDetailLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingClaimDetailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingClaimDetailLocalServiceUtil</code>.
	 */
	public StagingClaimDetail addStagingClaimDetail(
		long lineId, long externalClaimId, String serviceFrom,
		String serviceThru, String resultCodes, String procedureCode,
		double chargedAmount, double repricedAmount, double claimAmount,
		String paidDate, double paidAmount, double savingsAmount, int units,
		String coverage, String lineStatus, String revCode, String modifiedDate,
		String createdDate);

	/**
	 * Adds the staging claim detail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingClaimDetail addStagingClaimDetail(
		StagingClaimDetail stagingClaimDetail);

	/**
	 * Creates a new staging claim detail with the primary key. Does not add the staging claim detail to the database.
	 *
	 * @param stagingClaimDetailId the primary key for the new staging claim detail
	 * @return the new staging claim detail
	 */
	@Transactional(enabled = false)
	public StagingClaimDetail createStagingClaimDetail(
		long stagingClaimDetailId);

	public void deleteAll();

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the staging claim detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail that was removed
	 * @throws PortalException if a staging claim detail with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingClaimDetail deleteStagingClaimDetail(
			long stagingClaimDetailId)
		throws PortalException;

	/**
	 * Deletes the staging claim detail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingClaimDetail deleteStagingClaimDetail(
		StagingClaimDetail stagingClaimDetail);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl</code>.
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
	public StagingClaimDetail fetchStagingClaimDetail(
		long stagingClaimDetailId);

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
	 * Returns the staging claim detail with the primary key.
	 *
	 * @param stagingClaimDetailId the primary key of the staging claim detail
	 * @return the staging claim detail
	 * @throws PortalException if a staging claim detail with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StagingClaimDetail getStagingClaimDetail(long stagingClaimDetailId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StagingClaimDetail> getStagingClaimDetails(int start, int end);

	/**
	 * Returns the number of staging claim details.
	 *
	 * @return the number of staging claim details
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStagingClaimDetailsCount();

	/**
	 * Updates the staging claim detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingClaimDetail the staging claim detail
	 * @return the staging claim detail that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingClaimDetail updateStagingClaimDetail(
		StagingClaimDetail stagingClaimDetail);

}