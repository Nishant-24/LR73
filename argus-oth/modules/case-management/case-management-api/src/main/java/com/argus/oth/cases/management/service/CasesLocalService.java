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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
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
 * Provides the local service interface for Cases. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CasesLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CasesLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.CasesLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the cases local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CasesLocalServiceUtil} if injection and service tracking are not available.
	 */
	public Cases addCase(
		long groupId, long externalCaseId, long clientId, String clientName,
		long clientGroupId, String caseNumber, Date caseStartDate,
		Date caseEndDate, long memberId, String primaryDiagCode,
		String primaryCode, String status, Date estimateEntryDate,
		String caseManager, Date consentReceivedDate, String medicalPlan,
		String costEstimate, Date lastUpdated, Date externalCreateDate,
		double chargedAmount, double paidAmount, double repricedAmount,
		double savingsAmount, double savingsPercent, String treatingPhysician,
		String primaryFacility, String randomString);

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
	@Indexable(type = IndexableType.REINDEX)
	public Cases addCases(Cases cases);

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	@Transactional(enabled = false)
	public Cases createCases(long caseId);

	public void deleteAllCases();

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
	@Indexable(type = IndexableType.DELETE)
	public Cases deleteCases(Cases cases);

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
	@Indexable(type = IndexableType.DELETE)
	public Cases deleteCases(long caseId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteUnprocessed(String randomString);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
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
	public Cases fetchCaseByExternalCaseId(long externalCaseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cases fetchCases(long caseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cases> fetchCasesBy(String primaryDiagCode, String number);

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cases fetchCasesByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the cases with the primary key.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cases getCases(long caseId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cases> getCasesByClientId(long clientId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cases> getCasesByG_C(long groupId, long clientId);

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases
	 * @throws PortalException if a matching cases could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cases getCasesByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cases> getCaseses(int start, int end);

	/**
	 * Returns all the caseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the caseses
	 * @param companyId the primary key of the company
	 * @return the matching caseses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cases> getCasesesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cases> getCasesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator);

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCasesesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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
	@Indexable(type = IndexableType.REINDEX)
	public Cases updateCases(Cases cases);

	public Cases updateCases(
		long casesId, long clientId, String clientName, long clientGroupId,
		String caseNumber, Date caseStartDate, Date caseEndDate, long memberId,
		String primaryDiagCode, String primaryCode, String status,
		Date estimateEntryDate, String caseManager, Date consentReceivedDate,
		String medicalPlan, String costEstimate, Date lastUpdated,
		Date externalCreateDate, double chargedAmount, double paidAmount,
		double repricedAmount, double savingsAmount, double savingsPercent,
		String treatingPhysician, String primaryFacility);

}