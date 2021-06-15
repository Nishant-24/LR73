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
 * Provides a wrapper for {@link CasesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CasesLocalService
 * @generated
 */
public class CasesLocalServiceWrapper
	implements CasesLocalService, ServiceWrapper<CasesLocalService> {

	public CasesLocalServiceWrapper(CasesLocalService casesLocalService) {
		_casesLocalService = casesLocalService;
	}

	@Override
	public com.argus.oth.cases.management.model.Cases addCase(
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

		return _casesLocalService.addCase(
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
	 * @param cases the cases
	 * @return the cases that was added
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases addCases(
		com.argus.oth.cases.management.model.Cases cases) {

		return _casesLocalService.addCases(cases);
	}

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases createCases(long caseId) {
		return _casesLocalService.createCases(caseId);
	}

	@Override
	public void deleteAllCases() {
		_casesLocalService.deleteAllCases();
	}

	/**
	 * Deletes the cases from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cases the cases
	 * @return the cases that was removed
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases deleteCases(
		com.argus.oth.cases.management.model.Cases cases) {

		return _casesLocalService.deleteCases(cases);
	}

	/**
	 * Deletes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases that was removed
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases deleteCases(long caseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casesLocalService.deleteCases(caseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteUnprocessed(String randomString) {
		_casesLocalService.deleteUnprocessed(randomString);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _casesLocalService.dynamicQuery();
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

		return _casesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _casesLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _casesLocalService.dynamicQuery(
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

		return _casesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _casesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.cases.management.model.Cases fetchCaseByExternalCaseId(
		long externalCaseId) {

		return _casesLocalService.fetchCaseByExternalCaseId(externalCaseId);
	}

	@Override
	public com.argus.oth.cases.management.model.Cases fetchCases(long caseId) {
		return _casesLocalService.fetchCases(caseId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
		fetchCasesBy(String primaryDiagCode, String number) {

		return _casesLocalService.fetchCasesBy(primaryDiagCode, number);
	}

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases
		fetchCasesByUuidAndGroupId(String uuid, long groupId) {

		return _casesLocalService.fetchCasesByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _casesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cases with the primary key.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases getCases(long caseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casesLocalService.getCases(caseId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
		getCasesByClientId(long clientId) {

		return _casesLocalService.getCasesByClientId(clientId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
		getCasesByG_C(long groupId, long clientId) {

		return _casesLocalService.getCasesByG_C(groupId, clientId);
	}

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases
	 * @throws PortalException if a matching cases could not be found
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases getCasesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casesLocalService.getCasesByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
		getCaseses(int start, int end) {

		return _casesLocalService.getCaseses(start, end);
	}

	/**
	 * Returns all the caseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the caseses
	 * @param companyId the primary key of the company
	 * @return the matching caseses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
		getCasesesByUuidAndCompanyId(String uuid, long companyId) {

		return _casesLocalService.getCasesesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
		getCasesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.argus.oth.cases.management.model.Cases>
					orderByComparator) {

		return _casesLocalService.getCasesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	@Override
	public int getCasesesCount() {
		return _casesLocalService.getCasesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _casesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _casesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _casesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _casesLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		_casesLocalService.reindex();
	}

	@Override
	public void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		_casesLocalService.reindex(companyId);
	}

	/**
	 * Updates the cases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cases the cases
	 * @return the cases that was updated
	 */
	@Override
	public com.argus.oth.cases.management.model.Cases updateCases(
		com.argus.oth.cases.management.model.Cases cases) {

		return _casesLocalService.updateCases(cases);
	}

	@Override
	public com.argus.oth.cases.management.model.Cases updateCases(
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

		return _casesLocalService.updateCases(
			casesId, clientId, clientName, clientGroupId, caseNumber,
			caseStartDate, caseEndDate, memberId, primaryDiagCode, primaryCode,
			status, estimateEntryDate, caseManager, consentReceivedDate,
			medicalPlan, costEstimate, lastUpdated, externalCreateDate,
			chargedAmount, paidAmount, repricedAmount, savingsAmount,
			savingsPercent, treatingPhysician, primaryFacility);
	}

	@Override
	public CasesLocalService getWrappedService() {
		return _casesLocalService;
	}

	@Override
	public void setWrappedService(CasesLocalService casesLocalService) {
		_casesLocalService = casesLocalService;
	}

	private CasesLocalService _casesLocalService;

}