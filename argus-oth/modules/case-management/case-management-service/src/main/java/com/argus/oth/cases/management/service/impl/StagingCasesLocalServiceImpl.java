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

import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.model.impl.StagingCasesModelImpl;
import com.argus.oth.cases.management.service.base.StagingCasesLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging cases local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingCasesLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see StagingCasesLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.StagingCases", service = AopService.class)
public class StagingCasesLocalServiceImpl extends StagingCasesLocalServiceBaseImpl {

	public void addStagingCase(
		String externalCaseId, String externalClientPk, String clientGroupId, String caseNumber, String caseStartDate,
		String caseEndDate, String memberId, String primaryDiagCode, String primaryCode, String status,
		String estimateEntryDate, String caseManager, String consentReceivedDate, String medicalPlan,
		String costEstimate, String lastUpdated, String externalCreateDate, String chargedAmount, String paidAmount,
		String repricedAmount, String savingsAmount, String savingsPercent, String treatingPhysician,
		String primaryFacility) {

		long id = counterLocalService.increment(StagingCases.class.getName());

		StagingCases stagingCases = createStagingCases(id);

		stagingCases.setCreateDate(new Date());

		stagingCases.setExternalCaseId(externalCaseId);
		stagingCases.setExternalClientPk(externalClientPk);
		stagingCases.setClientGroupId(clientGroupId);
		stagingCases.setCaseNumber(caseNumber);
		stagingCases.setCaseStartDate(caseStartDate);
		stagingCases.setCaseEndDate(caseEndDate);
		stagingCases.setMemberId(memberId);
		stagingCases.setPrimaryDiagCode(primaryDiagCode);
		stagingCases.setPrimaryCode(primaryCode);
		stagingCases.setStatus(status);
		stagingCases.setEstimateEntryDate(estimateEntryDate);
		stagingCases.setCaseManager(caseManager);
		stagingCases.setConsentReceivedDate(consentReceivedDate);
		stagingCases.setMedicalPlan(medicalPlan);
		stagingCases.setCostEstimate(costEstimate);
		stagingCases.setLastUpdated(lastUpdated);
		stagingCases.setExternalCreatedDate(externalCreateDate);
		stagingCases.setChargedAmount(chargedAmount);
		stagingCases.setPaidAmount(paidAmount);
		stagingCases.setRepricedAmount(repricedAmount);
		stagingCases.setSavingsAmount(savingsAmount);
		stagingCases.setSavingsPercent(savingsPercent);
		stagingCases.setTreatingPhysician(treatingPhysician);
		stagingCases.setPrimaryFacility(primaryFacility);
		stagingCases.setRowProcessed(false);

		addStagingCases(stagingCases);
	}

	public void deleteAllStagingCases() {
		BulkHelper.bulkDeleteAll(stagingCasesPersistence.getCurrentSession(), StagingCasesModelImpl.TABLE_NAME);
	}

	public StagingCases getStagingCasesByExternalCaseId(String externalCaseId) {
		return stagingCasesPersistence.fetchByExternalCaseId(externalCaseId);
	}

	public List<StagingCases> getStagingCasesByRowProcessed(boolean rowProcessed) {
		return stagingCasesPersistence.findByRowProcessed(rowProcessed);
	}

	public List<StagingCases> getStagingCasesByRowProcessed(boolean rowProcessed, int start, int end) {
		return stagingCasesPersistence.findByRowProcessed(rowProcessed, start, end, null, false);
	}

	public int updateProcessedStagingCases() {
		return BulkHelper.bulkUpdateProcessed(
			stagingCasesPersistence.getCurrentSession(), StagingCasesModelImpl.TABLE_NAME, true, false);
	}

}