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
 * Provides a wrapper for {@link StagingCasesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingCasesLocalService
 * @generated
 */
public class StagingCasesLocalServiceWrapper
	implements ServiceWrapper<StagingCasesLocalService>,
			   StagingCasesLocalService {

	public StagingCasesLocalServiceWrapper(
		StagingCasesLocalService stagingCasesLocalService) {

		_stagingCasesLocalService = stagingCasesLocalService;
	}

	@Override
	public void addStagingCase(
		String externalCaseId, String externalClientPk, String clientGroupId,
		String caseNumber, String caseStartDate, String caseEndDate,
		String memberId, String primaryDiagCode, String primaryCode,
		String status, String estimateEntryDate, String caseManager,
		String consentReceivedDate, String medicalPlan, String costEstimate,
		String lastUpdated, String externalCreateDate, String chargedAmount,
		String paidAmount, String repricedAmount, String savingsAmount,
		String savingsPercent, String treatingPhysician,
		String primaryFacility) {

		_stagingCasesLocalService.addStagingCase(
			externalCaseId, externalClientPk, clientGroupId, caseNumber,
			caseStartDate, caseEndDate, memberId, primaryDiagCode, primaryCode,
			status, estimateEntryDate, caseManager, consentReceivedDate,
			medicalPlan, costEstimate, lastUpdated, externalCreateDate,
			chargedAmount, paidAmount, repricedAmount, savingsAmount,
			savingsPercent, treatingPhysician, primaryFacility);
	}

	/**
	 * Adds the staging cases to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingCases addStagingCases(
		com.argus.oth.cases.management.model.StagingCases stagingCases) {

		return _stagingCasesLocalService.addStagingCases(stagingCases);
	}

	/**
	 * Creates a new staging cases with the primary key. Does not add the staging cases to the database.
	 *
	 * @param stagingCaseId the primary key for the new staging cases
	 * @return the new staging cases
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingCases createStagingCases(
		long stagingCaseId) {

		return _stagingCasesLocalService.createStagingCases(stagingCaseId);
	}

	@Override
	public void deleteAllStagingCases() {
		_stagingCasesLocalService.deleteAllStagingCases();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingCasesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws PortalException if a staging cases with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingCases deleteStagingCases(
			long stagingCaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingCasesLocalService.deleteStagingCases(stagingCaseId);
	}

	/**
	 * Deletes the staging cases from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingCases deleteStagingCases(
		com.argus.oth.cases.management.model.StagingCases stagingCases) {

		return _stagingCasesLocalService.deleteStagingCases(stagingCases);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingCasesLocalService.dynamicQuery();
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

		return _stagingCasesLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stagingCasesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stagingCasesLocalService.dynamicQuery(
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

		return _stagingCasesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stagingCasesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingCases fetchStagingCases(
		long stagingCaseId) {

		return _stagingCasesLocalService.fetchStagingCases(stagingCaseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingCasesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingCasesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingCasesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingCasesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging cases with the primary key.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases
	 * @throws PortalException if a staging cases with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingCases getStagingCases(
			long stagingCaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingCasesLocalService.getStagingCases(stagingCaseId);
	}

	@Override
	public com.argus.oth.cases.management.model.StagingCases
		getStagingCasesByExternalCaseId(String externalCaseId) {

		return _stagingCasesLocalService.getStagingCasesByExternalCaseId(
			externalCaseId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.StagingCases>
		getStagingCasesByRowProcessed(boolean rowProcessed) {

		return _stagingCasesLocalService.getStagingCasesByRowProcessed(
			rowProcessed);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.StagingCases>
		getStagingCasesByRowProcessed(
			boolean rowProcessed, int start, int end) {

		return _stagingCasesLocalService.getStagingCasesByRowProcessed(
			rowProcessed, start, end);
	}

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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.StagingCases>
		getStagingCaseses(int start, int end) {

		return _stagingCasesLocalService.getStagingCaseses(start, end);
	}

	/**
	 * Returns the number of staging caseses.
	 *
	 * @return the number of staging caseses
	 */
	@Override
	public int getStagingCasesesCount() {
		return _stagingCasesLocalService.getStagingCasesesCount();
	}

	@Override
	public int updateProcessedStagingCases() {
		return _stagingCasesLocalService.updateProcessedStagingCases();
	}

	/**
	 * Updates the staging cases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.StagingCases updateStagingCases(
		com.argus.oth.cases.management.model.StagingCases stagingCases) {

		return _stagingCasesLocalService.updateStagingCases(stagingCases);
	}

	@Override
	public StagingCasesLocalService getWrappedService() {
		return _stagingCasesLocalService;
	}

	@Override
	public void setWrappedService(
		StagingCasesLocalService stagingCasesLocalService) {

		_stagingCasesLocalService = stagingCasesLocalService;
	}

	private StagingCasesLocalService _stagingCasesLocalService;

}