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

import com.argus.oth.cases.management.model.StagingClaim;
import com.argus.oth.cases.management.model.impl.StagingClaimModelImpl;
import com.argus.oth.cases.management.service.base.StagingClaimLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging claim local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingClaimLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.StagingClaim", service = AopService.class)
public class StagingClaimLocalServiceImpl extends StagingClaimLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingClaimLocalServiceUtil</code>.
	 */
	public StagingClaim addStagingClaim(
		long externalClaimId, String claimRef, String authorizationNumber, String serviceFrom, String serviceThru,
		String provider, String prioritizedBill, String diagCodesCombined, String providerState, String tpmReceivedDate,
		long claimTurnaround, String billType, String providerNetwork, String repricedNetwork, long statusSortOrder,
		String paidDate, double paidAmount, String claimStatus, String modifiedDate, String createdDate) {

		long stagingClaimId = counterLocalService.increment(StagingClaim.class.getName());

		StagingClaim stagingClaim = stagingClaimPersistence.create(stagingClaimId);

		stagingClaim.setExternalClaimId(externalClaimId);
		stagingClaim.setClaimRef(claimRef);
		stagingClaim.setAuthorizationNumber(authorizationNumber);
		stagingClaim.setServiceFrom(serviceFrom);
		stagingClaim.setServiceThru(serviceThru);
		stagingClaim.setProvider(provider);
		stagingClaim.setPrioritizedBill(prioritizedBill);
		stagingClaim.setDiagCodesCombined(diagCodesCombined);
		stagingClaim.setProviderState(providerState);
		stagingClaim.setTpmReceivedDate(tpmReceivedDate);
		stagingClaim.setClaimTurnaround(claimTurnaround);
		stagingClaim.setBillType(billType);
		stagingClaim.setProviderNetwork(providerNetwork);
		stagingClaim.setRepricedNetwork(repricedNetwork);
		stagingClaim.setStatusSortOrder(statusSortOrder);
		stagingClaim.setPaidDate(paidDate);
		stagingClaim.setPaidAmount(paidAmount);
		stagingClaim.setClaimStatus(claimStatus);
		stagingClaim.setExternalModifiedDate(modifiedDate);
		stagingClaim.setExternalCreatedDate(createdDate);

		return addStagingClaim(stagingClaim);
	}

	public void deleteAll() {
		BulkHelper.bulkDeleteAll(stagingClaimPersistence.getCurrentSession(), StagingClaimModelImpl.TABLE_NAME);
	}

}