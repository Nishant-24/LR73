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

import com.argus.oth.cases.management.model.ClaimDetail;
import com.argus.oth.cases.management.model.impl.ClaimDetailModelImpl;
import com.argus.oth.cases.management.service.base.ClaimDetailLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the claim detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.ClaimDetailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see ClaimDetailLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.ClaimDetail", service = AopService.class)
public class ClaimDetailLocalServiceImpl extends ClaimDetailLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.ClaimDetailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.ClaimDetailLocalServiceUtil</code>.
	 */
	public ClaimDetail addClaimDetail(
		long groupId, long lineId, long externalClaimId, Date serviceFrom, Date serviceThru, String resultCodes,
		String procedureCode, double chargedAmount, double repricedAmount, double claimAmount, Date paidDate,
		double paidAmount, double savingsAmount, int units, String coverage, String lineStatus, String revCode,
		Date modifiedDate, Date createdDate, String randomString) {

		long claimDetailId = counterLocalService.increment(ClaimDetail.class.getName());

		ClaimDetail claimDetail = claimDetailPersistence.create(claimDetailId);

		claimDetail.setGroupId(groupId);
		claimDetail.setLineId(lineId);
		claimDetail.setExternalClaimId(externalClaimId);
		claimDetail.setServiceFrom(serviceFrom);
		claimDetail.setServiceThru(serviceThru);
		claimDetail.setResultCodes(resultCodes);
		claimDetail.setProcedureCode(procedureCode);
		claimDetail.setChargedAmount(chargedAmount);
		claimDetail.setRepricedAmount(repricedAmount);
		claimDetail.setClaimAmount(claimAmount);
		claimDetail.setPaidDate(paidDate);
		claimDetail.setPaidAmount(paidAmount);
		claimDetail.setSavingsAmount(savingsAmount);
		claimDetail.setUnits(units);
		claimDetail.setCoverage(coverage);
		claimDetail.setLineStatus(lineStatus);
		claimDetail.setRevCode(revCode);
		claimDetail.setModifiedDate(modifiedDate);
		claimDetail.setCreateDate(createdDate);
		claimDetail.setRowProcessed(randomString);

		return addClaimDetail(claimDetail);
	}

	public void deleteUnprocessed(String randomString) {
		BulkHelper.bulkDelete(
			claimDetailPersistence.getCurrentSession(), ClaimDetailModelImpl.TABLE_NAME, randomString);
	}

	public ClaimDetail fetchByLineId(long lineid) {
		return claimDetailPersistence.fetchByLineId(lineid);
	}

	public List<ClaimDetail> getByExternalClaimId(long externalClaimId) {
		return claimDetailPersistence.findByExternalClaimId(externalClaimId);
	}

}