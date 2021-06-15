/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.StagingClaimDetail;
import com.argus.oth.cases.management.model.impl.StagingClaimDetailModelImpl;
import com.argus.oth.cases.management.service.base.StagingClaimDetailLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging claim detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingClaimDetailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see StagingClaimDetailLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.StagingClaimDetail", service = AopService.class
)
public class StagingClaimDetailLocalServiceImpl extends StagingClaimDetailLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingClaimDetailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingClaimDetailLocalServiceUtil</code>.
	 */
	public StagingClaimDetail addStagingClaimDetail(
		long lineId, long externalClaimId, String serviceFrom, String serviceThru, String resultCodes,
		String procedureCode, double chargedAmount, double repricedAmount, double claimAmount, String paidDate,
		double paidAmount, double savingsAmount, int units, String coverage, String lineStatus, String revCode,
		String modifiedDate, String createdDate) {

		long stagingClaimDetailId = counterLocalService.increment(StagingClaimDetail.class.getName());

		StagingClaimDetail stagingClaimDetail = stagingClaimDetailPersistence.create(stagingClaimDetailId);

		stagingClaimDetail.setLineId(lineId);
		stagingClaimDetail.setExternalClaimId(externalClaimId);
		stagingClaimDetail.setServiceFrom(serviceFrom);
		stagingClaimDetail.setServiceThru(serviceThru);
		stagingClaimDetail.setResultCodes(resultCodes);
		stagingClaimDetail.setProcedureCode(procedureCode);
		stagingClaimDetail.setChargedAmount(chargedAmount);
		stagingClaimDetail.setRepricedAmount(repricedAmount);
		stagingClaimDetail.setClaimAmount(claimAmount);
		stagingClaimDetail.setPaidDate(paidDate);
		stagingClaimDetail.setPaidAmount(paidAmount);
		stagingClaimDetail.setSavingsAmount(savingsAmount);
		stagingClaimDetail.setUnits(units);
		stagingClaimDetail.setCoverage(coverage);
		stagingClaimDetail.setLineStatus(lineStatus);
		stagingClaimDetail.setRevCode(revCode);
		stagingClaimDetail.setExternalModifiedDate(modifiedDate);
		stagingClaimDetail.setExternalCreatedDate(createdDate);

		return addStagingClaimDetail(stagingClaimDetail);
	}

	public void deleteAll() {
		BulkHelper.bulkDeleteAll(
			stagingClaimDetailPersistence.getCurrentSession(), StagingClaimDetailModelImpl.TABLE_NAME);
	}

}