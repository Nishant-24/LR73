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

import com.argus.oth.cases.management.model.StagingCases;

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
 * Provides the local service interface for StagingCases. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingCasesLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StagingCasesLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingCasesLocalServiceUtil} to access the staging cases local service. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingCasesLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addStagingCase(
		String externalCaseId, String externalClientPk, String clientGroupId,
		String caseNumber, String caseStartDate, String caseEndDate,
		String memberId, String primaryDiagCode, String primaryCode,
		String status, String estimateEntryDate, String caseManager,
		String consentReceivedDate, String medicalPlan, String costEstimate,
		String lastUpdated, String externalCreateDate, String chargedAmount,
		String paidAmount, String repricedAmount, String savingsAmount,
		String savingsPercent, String treatingPhysician,
		String primaryFacility);

	/**
	 * Adds the staging cases to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingCases addStagingCases(StagingCases stagingCases);

	/**
	 * Creates a new staging cases with the primary key. Does not add the staging cases to the database.
	 *
	 * @param stagingCaseId the primary key for the new staging cases
	 * @return the new staging cases
	 */
	@Transactional(enabled = false)
	public StagingCases createStagingCases(long stagingCaseId);

	public void deleteAllStagingCases();

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws PortalException if a staging cases with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingCases deleteStagingCases(long stagingCaseId)
		throws PortalException;

	/**
	 * Deletes the staging cases from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public StagingCases deleteStagingCases(StagingCases stagingCases);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingCasesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingCasesModelImpl</code>.
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
	public StagingCases fetchStagingCases(long stagingCaseId);

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
	 * Returns the staging cases with the primary key.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases
	 * @throws PortalException if a staging cases with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StagingCases getStagingCases(long stagingCaseId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StagingCases getStagingCasesByExternalCaseId(String externalCaseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StagingCases> getStagingCasesByRowProcessed(
		boolean rowProcessed);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StagingCases> getStagingCasesByRowProcessed(
		boolean rowProcessed, int start, int end);

	/**
	 * Returns a range of all the staging caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.StagingCasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging caseses
	 * @param end the upper bound of the range of staging caseses (not inclusive)
	 * @return the range of staging caseses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StagingCases> getStagingCaseses(int start, int end);

	/**
	 * Returns the number of staging caseses.
	 *
	 * @return the number of staging caseses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStagingCasesesCount();

	public int updateProcessedStagingCases();

	/**
	 * Updates the staging cases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StagingCases updateStagingCases(StagingCases stagingCases);

}