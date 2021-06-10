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

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.impl.CasesModelImpl;
import com.argus.oth.cases.management.service.base.CasesLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PwdGenerator;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the cases local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.CasesLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Cases", service = AopService.class)
public class CasesLocalServiceImpl extends CasesLocalServiceBaseImpl {

	public Cases addCase(
		long groupId, long externalCaseId, long clientId, String clientName, long clientGroupId, String caseNumber,
		Date caseStartDate, Date caseEndDate, long memberId, String primaryDiagCode, String primaryCode, String status,
		Date estimateEntryDate, String caseManager, Date consentReceivedDate, String medicalPlan, String costEstimate,
		Date lastUpdated, Date externalCreateDate, double chargedAmount, double paidAmount, double repricedAmount,
		double savingsAmount, double savingsPercent, String treatingPhysician, String primaryFacility,
		String randomString) {

		Group group = groupLocalService.fetchGroup(groupId);

		Cases cases = createCases(externalCaseId);

		if (group != null) {
			cases.setCompanyId(group.getCompanyId());
		}

		cases.setGroupId(groupId);
		cases.setModifiedDate(new Date());
		cases.setCreateDate(new Date());

		cases.setExternalCaseId(externalCaseId);
		cases.setClientId(clientId);
		cases.setClientName(clientName);
		cases.setClientGroupId(clientGroupId);
		cases.setCaseNumber(caseNumber);
		cases.setCaseStartDate(caseStartDate);
		cases.setCaseEndDate(caseEndDate);
		cases.setMemberId(memberId);
		cases.setPrimaryDiagCode(primaryDiagCode);
		cases.setPrimaryCode(primaryCode);
		cases.setStatus(status);
		cases.setEstimateEntryDate(estimateEntryDate);
		cases.setCaseManager(caseManager);
		cases.setConsentReceivedDate(consentReceivedDate);
		cases.setMedicalPlan(medicalPlan);
		cases.setCostEstimate(costEstimate);
		cases.setLastUpdated(lastUpdated);
		cases.setExternalCreatedDate(externalCreateDate);
		cases.setChargedAmount(chargedAmount);
		cases.setPaidAmount(paidAmount);
		cases.setRepricedAmount(repricedAmount);
		cases.setSavingsAmount(savingsAmount);
		cases.setSavingsPercent(savingsPercent);
		cases.setTreatingPhysician(treatingPhysician);
		cases.setPrimaryFacility(primaryFacility);
		cases.setRowProcessed(randomString);

		try {
			User dataAdminUser = _userLocalService.fetchUserByScreenName(
				cases.getCompanyId(), OTHConstants.DATA_ADMIN_USER_SCREEN_NAME);

			resourceLocalService.addResources(
				cases.getCompanyId(), cases.getGroupId(), dataAdminUser.getUserId(), Cases.class.getName(),
				externalCaseId, false, true, true);
		}
		catch (Exception e) {
			_log.error(e);
		}

		return addCases(cases);
	}

	public void deleteAllCases() {
		for (Cases cases : casesPersistence.findAll()) {
			deleteCases(cases);
		}
	}

	public void deleteUnprocessed(String randomString) {
		BulkHelper.bulkDelete(casesPersistence.getCurrentSession(), CasesModelImpl.TABLE_NAME, randomString);
	}

	public Cases fetchCaseByExternalCaseId(long externalCaseId) {
		return casesPersistence.fetchByExternalCaseId(externalCaseId);
	}

	@Override
	public List<Cases> fetchCasesBy(String primaryDiagCode, String number) {
		DynamicQuery query = dynamicQuery();

		query = query.add(RestrictionsFactoryUtil.eq("caseNumber", number));

		if (primaryDiagCode != null) {
			query = query.add(RestrictionsFactoryUtil.eq("primaryDiagCode", primaryDiagCode));
		}

		return dynamicQuery(query);
	}

	public List<Cases> getCasesByClientId(long clientId) {
		return casesPersistence.findByClientId(clientId);
	}

	public List<Cases> getCasesByG_C(long groupId, long clientId) {
		return casesPersistence.findByG_C(groupId, clientId);
	}

	public void reindex() throws SearchException {
		Indexer<Cases> casesIndexer = _indexerRegistry.getIndexer(Cases.class.getName());

		if (Objects.nonNull(casesIndexer)) {
			casesIndexer.reindex(casesPersistence.findAll());
		}
	}

	public void reindex(long companyId) throws SearchException {
		Indexer<Cases> casesIndexer = _indexerRegistry.getIndexer(Cases.class.getName());

		if (Objects.nonNull(casesIndexer)) {
			casesIndexer.reindex(new String[] {String.valueOf(companyId)});
		}
	}

	public Cases updateCases(
		long casesId, long clientId, String clientName, long clientGroupId, String caseNumber, Date caseStartDate,
		Date caseEndDate, long memberId, String primaryDiagCode, String primaryCode, String status,
		Date estimateEntryDate, String caseManager, Date consentReceivedDate, String medicalPlan, String costEstimate,
		Date lastUpdated, Date externalCreateDate, double chargedAmount, double paidAmount, double repricedAmount,
		double savingsAmount, double savingsPercent, String treatingPhysician, String primaryFacility) {

		Cases cases = casesPersistence.fetchByPrimaryKey(casesId);

		cases.setClientId(clientId);
		cases.setClientName(clientName);
		cases.setClientGroupId(clientGroupId);
		cases.setCaseNumber(caseNumber);
		cases.setCaseStartDate(caseStartDate);
		cases.setCaseEndDate(caseEndDate);
		cases.setMemberId(memberId);
		cases.setPrimaryDiagCode(primaryDiagCode);
		cases.setPrimaryCode(primaryCode);
		cases.setStatus(status);
		cases.setEstimateEntryDate(estimateEntryDate);
		cases.setCaseManager(caseManager);
		cases.setConsentReceivedDate(consentReceivedDate);
		cases.setMedicalPlan(medicalPlan);
		cases.setCostEstimate(costEstimate);
		cases.setLastUpdated(lastUpdated);
		cases.setExternalCreatedDate(externalCreateDate);
		cases.setChargedAmount(chargedAmount);
		cases.setPaidAmount(paidAmount);
		cases.setRepricedAmount(repricedAmount);
		cases.setSavingsAmount(savingsAmount);
		cases.setSavingsPercent(savingsPercent);
		cases.setTreatingPhysician(treatingPhysician);
		cases.setPrimaryFacility(primaryFacility);
		cases.setRowProcessed(PwdGenerator.getPassword(8));

		return casesPersistence.update(cases);
	}

	private static final Log _log = LogFactoryUtil.getLog(CasesLocalServiceImpl.class);

	@Reference
	private IndexerRegistry _indexerRegistry;

	@Reference
	private UserLocalService _userLocalService;

}