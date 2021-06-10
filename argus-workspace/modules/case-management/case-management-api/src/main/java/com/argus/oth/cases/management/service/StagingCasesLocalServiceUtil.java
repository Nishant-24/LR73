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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StagingCases. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.StagingCasesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StagingCasesLocalService
 * @generated
 */
public class StagingCasesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.StagingCasesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addStagingCase(
		String externalCaseId, String externalClientPk, String clientGroupId,
		String caseNumber, String caseStartDate, String caseEndDate,
		String memberId, String primaryDiagCode, String primaryCode,
		String status, String estimateEntryDate, String caseManager,
		String consentReceivedDate, String medicalPlan, String costEstimate,
		String lastUpdated, String externalCreateDate, String chargedAmount,
		String paidAmount, String repricedAmount, String savingsAmount,
		String savingsPercent, String treatingPhysician,
		String primaryFacility) {

		getService().addStagingCase(
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
	 * <p>
	 * <strong>Important:</strong> Inspect StagingCasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was added
	 */
	public static StagingCases addStagingCases(StagingCases stagingCases) {
		return getService().addStagingCases(stagingCases);
	}

	/**
	 * Creates a new staging cases with the primary key. Does not add the staging cases to the database.
	 *
	 * @param stagingCaseId the primary key for the new staging cases
	 * @return the new staging cases
	 */
	public static StagingCases createStagingCases(long stagingCaseId) {
		return getService().createStagingCases(stagingCaseId);
	}

	public static void deleteAllStagingCases() {
		getService().deleteAllStagingCases();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the staging cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingCasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases that was removed
	 * @throws PortalException if a staging cases with the primary key could not be found
	 */
	public static StagingCases deleteStagingCases(long stagingCaseId)
		throws PortalException {

		return getService().deleteStagingCases(stagingCaseId);
	}

	/**
	 * Deletes the staging cases from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingCasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was removed
	 */
	public static StagingCases deleteStagingCases(StagingCases stagingCases) {
		return getService().deleteStagingCases(stagingCases);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static StagingCases fetchStagingCases(long stagingCaseId) {
		return getService().fetchStagingCases(stagingCaseId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the staging cases with the primary key.
	 *
	 * @param stagingCaseId the primary key of the staging cases
	 * @return the staging cases
	 * @throws PortalException if a staging cases with the primary key could not be found
	 */
	public static StagingCases getStagingCases(long stagingCaseId)
		throws PortalException {

		return getService().getStagingCases(stagingCaseId);
	}

	public static StagingCases getStagingCasesByExternalCaseId(
		String externalCaseId) {

		return getService().getStagingCasesByExternalCaseId(externalCaseId);
	}

	public static List<StagingCases> getStagingCasesByRowProcessed(
		boolean rowProcessed) {

		return getService().getStagingCasesByRowProcessed(rowProcessed);
	}

	public static List<StagingCases> getStagingCasesByRowProcessed(
		boolean rowProcessed, int start, int end) {

		return getService().getStagingCasesByRowProcessed(
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
	public static List<StagingCases> getStagingCaseses(int start, int end) {
		return getService().getStagingCaseses(start, end);
	}

	/**
	 * Returns the number of staging caseses.
	 *
	 * @return the number of staging caseses
	 */
	public static int getStagingCasesesCount() {
		return getService().getStagingCasesesCount();
	}

	public static int updateProcessedStagingCases() {
		return getService().updateProcessedStagingCases();
	}

	/**
	 * Updates the staging cases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StagingCasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stagingCases the staging cases
	 * @return the staging cases that was updated
	 */
	public static StagingCases updateStagingCases(StagingCases stagingCases) {
		return getService().updateStagingCases(stagingCases);
	}

	public static StagingCasesLocalService getService() {
		return _service;
	}

	private static volatile StagingCasesLocalService _service;

}