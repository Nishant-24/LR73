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

import com.argus.oth.cases.management.model.DataRequest;
import com.argus.oth.cases.management.service.base.DataRequestLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.DataRequestLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataRequestLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.argus.oth.cases.management.model.DataRequest", service = AopService.class)
public class DataRequestLocalServiceImpl extends DataRequestLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.DataRequestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.DataRequestLocalServiceUtil</code>.
	 */
	public DataRequest addDataRequest(
		long clientId, long caseId, long externalCaseId, String type, Date lastUpdatedDate) {

		long dataRequestId = counterLocalService.increment(DataRequest.class.getName());

		DataRequest dataRequest = dataRequestPersistence.create(dataRequestId);

		dataRequest.setClientId(clientId);
		dataRequest.setCaseId(caseId);
		dataRequest.setExternalCaseId(externalCaseId);
		dataRequest.setType(type);

		Date date = new Date();
		Date minDate = new Date(0);

		if (Objects.isNull(lastUpdatedDate) || (minDate.compareTo(lastUpdatedDate) == 0)) {
			lastUpdatedDate = date;
		}

		dataRequest.setLastUpdatedDate(lastUpdatedDate);

		return dataRequestPersistence.update(dataRequest);
	}

	public DataRequest fetchByClientId_Type(long clientId, String type) {
		return dataRequestPersistence.fetchByClientId_Type(clientId, type);
	}

	public DataRequest fetchByExternalCaseId_Type(long externalCaseId, String type) {
		return dataRequestPersistence.fetchByExtCaseId_Type(externalCaseId, type);
	}

	public DataRequest setDataRequestLastUpdatedDate(long clientId, long caseId, long externalCaseId, String type) {
		return updateDataRequest(clientId, caseId, externalCaseId, type, null);
	}

	public DataRequest updateDataRequest(
		long clientId, long caseId, long externalCaseId, String type, Date lastUpdatedDate) {

		DataRequest dataRequest;

		if (externalCaseId > 0) {
			dataRequest = fetchByExternalCaseId_Type(externalCaseId, type);
		}
		else {
			dataRequest = fetchByClientId_Type(clientId, type);
		}

		if (Objects.isNull(dataRequest)) {
			return addDataRequest(clientId, caseId, externalCaseId, type, lastUpdatedDate);
		}

		if (Objects.isNull(lastUpdatedDate)) {
			lastUpdatedDate = new Date();
		}

		dataRequest.setLastUpdatedDate(lastUpdatedDate);

		return dataRequestPersistence.update(dataRequest);
	}

}