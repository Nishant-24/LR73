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

import com.argus.oth.cases.management.model.Cases;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Cases. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.CasesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CasesLocalService
 * @generated
 */
public class CasesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.CasesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Cases addCase(
		long groupId, long externalCaseId, long clientId, String clientName,
		long clientGroupId, String caseNumber, java.util.Date caseStartDate,
		java.util.Date caseEndDate, long memberId, String primaryDiagCode,
		String primaryCode, String status, java.util.Date estimateEntryDate,
		String caseManager, java.util.Date consentReceivedDate,
		String medicalPlan, String costEstimate, java.util.Date lastUpdated,
		java.util.Date externalCreateDate, double chargedAmount,
		double paidAmount, double repricedAmount, double savingsAmount,
		double savingsPercent, String treatingPhysician, String primaryFacility,
		String randomString) {

		return getService().addCase(
			groupId, externalCaseId, clientId, clientName, clientGroupId,
			caseNumber, caseStartDate, caseEndDate, memberId, primaryDiagCode,
			primaryCode, status, estimateEntryDate, caseManager,
			consentReceivedDate, medicalPlan, costEstimate, lastUpdated,
			externalCreateDate, chargedAmount, paidAmount, repricedAmount,
			savingsAmount, savingsPercent, treatingPhysician, primaryFacility,
			randomString);
	}

	/**
	 * Adds the cases to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cases the cases
	 * @return the cases that was added
	 */
	public static Cases addCases(Cases cases) {
		return getService().addCases(cases);
	}

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	public static Cases createCases(long caseId) {
		return getService().createCases(caseId);
	}

	public static void deleteAllCases() {
		getService().deleteAllCases();
	}

	/**
	 * Deletes the cases from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cases the cases
	 * @return the cases that was removed
	 */
	public static Cases deleteCases(Cases cases) {
		return getService().deleteCases(cases);
	}

	/**
	 * Deletes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases that was removed
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	public static Cases deleteCases(long caseId) throws PortalException {
		return getService().deleteCases(caseId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteUnprocessed(String randomString) {
		getService().deleteUnprocessed(randomString);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
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

	public static Cases fetchCaseByExternalCaseId(long externalCaseId) {
		return getService().fetchCaseByExternalCaseId(externalCaseId);
	}

	public static Cases fetchCases(long caseId) {
		return getService().fetchCases(caseId);
	}

	public static List<Cases> fetchCasesBy(
		String primaryDiagCode, String number) {

		return getService().fetchCasesBy(primaryDiagCode, number);
	}

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	public static Cases fetchCasesByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchCasesByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cases with the primary key.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	public static Cases getCases(long caseId) throws PortalException {
		return getService().getCases(caseId);
	}

	public static List<Cases> getCasesByClientId(long clientId) {
		return getService().getCasesByClientId(clientId);
	}

	public static List<Cases> getCasesByG_C(long groupId, long clientId) {
		return getService().getCasesByG_C(groupId, clientId);
	}

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases
	 * @throws PortalException if a matching cases could not be found
	 */
	public static Cases getCasesByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCasesByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of caseses
	 */
	public static List<Cases> getCaseses(int start, int end) {
		return getService().getCaseses(start, end);
	}

	/**
	 * Returns all the caseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the caseses
	 * @param companyId the primary key of the company
	 * @return the matching caseses, or an empty list if no matches were found
	 */
	public static List<Cases> getCasesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCasesesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of caseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the caseses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching caseses, or an empty list if no matches were found
	 */
	public static List<Cases> getCasesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return getService().getCasesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	public static int getCasesesCount() {
		return getService().getCasesesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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

	public static void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindex();
	}

	public static void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindex(companyId);
	}

	/**
	 * Updates the cases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cases the cases
	 * @return the cases that was updated
	 */
	public static Cases updateCases(Cases cases) {
		return getService().updateCases(cases);
	}

	public static Cases updateCases(
		long casesId, long clientId, String clientName, long clientGroupId,
		String caseNumber, java.util.Date caseStartDate,
		java.util.Date caseEndDate, long memberId, String primaryDiagCode,
		String primaryCode, String status, java.util.Date estimateEntryDate,
		String caseManager, java.util.Date consentReceivedDate,
		String medicalPlan, String costEstimate, java.util.Date lastUpdated,
		java.util.Date externalCreateDate, double chargedAmount,
		double paidAmount, double repricedAmount, double savingsAmount,
		double savingsPercent, String treatingPhysician,
		String primaryFacility) {

		return getService().updateCases(
			casesId, clientId, clientName, clientGroupId, caseNumber,
			caseStartDate, caseEndDate, memberId, primaryDiagCode, primaryCode,
			status, estimateEntryDate, caseManager, consentReceivedDate,
			medicalPlan, costEstimate, lastUpdated, externalCreateDate,
			chargedAmount, paidAmount, repricedAmount, savingsAmount,
			savingsPercent, treatingPhysician, primaryFacility);
	}

	public static CasesLocalService getService() {
		return _service;
	}

	private static volatile CasesLocalService _service;

}