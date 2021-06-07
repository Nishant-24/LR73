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

import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.model.impl.ClaimModelImpl;
import com.argus.oth.cases.management.service.base.ClaimLocalServiceBaseImpl;
import com.argus.oth.common.helper.BulkHelper;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the claim local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.ClaimLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.Claim", service = AopService.class)
public class ClaimLocalServiceImpl extends ClaimLocalServiceBaseImpl {

	public Claim addClaim(
		long groupId, long externalClaimId, String claimRef, String authorizationNumber, Date serviceFrom,
		Date serviceThru, String provider, String prioritizedBill, String diagCodesCombined, String providerState,
		Date tpmReceivedDate, long claimTurnaround, String billType, String providerNetwork, String repricedNetwork,
		long statusSortOrder, Date paidDate, double paidAmount, String claimStatus, Date modifiedDate, Date createdDate,
		String randomString) {

		long claimId = counterLocalService.increment(Claim.class.getName());

		Claim claim = claimPersistence.create(claimId);

		claim.setGroupId(groupId);
		claim.setExternalClaimId(externalClaimId);
		claim.setClaimRef(claimRef);
		claim.setAuthorizationNumber(authorizationNumber);
		claim.setServiceFrom(serviceFrom);
		claim.setServiceThru(serviceThru);
		claim.setProvider(provider);
		claim.setPrioritizedBill(prioritizedBill);
		claim.setDiagCodesCombined(diagCodesCombined);
		claim.setProviderState(providerState);
		claim.setTpmReceivedDate(tpmReceivedDate);
		claim.setClaimTurnaround(claimTurnaround);
		claim.setBillType(billType);
		claim.setProviderNetwork(providerNetwork);
		claim.setRepricedNetwork(repricedNetwork);
		claim.setStatusSortOrder(statusSortOrder);
		claim.setPaidDate(paidDate);
		claim.setPaidAmount(paidAmount);
		claim.setClaimStatus(claimStatus);
		claim.setModifiedDate(modifiedDate);
		claim.setCreateDate(createdDate);
		claim.setRowProcessed(randomString);

		return addClaim(claim);
	}

	public void deleteUnprocessed(String randomString) {
		BulkHelper.bulkDelete(claimPersistence.getCurrentSession(), ClaimModelImpl.TABLE_NAME, randomString);
	}

	public Claim fetchByClaimRef(String claimRef) {
		return claimPersistence.fetchByClaimRef(claimRef);
	}

	public List<Claim> getByAuthorizationNumber(String authorizationNumber) {
		return claimPersistence.findByAuthorizationNumber(authorizationNumber);
	}

}