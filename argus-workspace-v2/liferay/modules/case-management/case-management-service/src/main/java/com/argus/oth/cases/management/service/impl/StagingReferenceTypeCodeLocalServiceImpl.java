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

import com.argus.oth.cases.management.model.StagingReferenceTypeCode;
import com.argus.oth.cases.management.service.base.StagingReferenceTypeCodeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the staging reference type code local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.StagingReferenceTypeCodeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see StagingReferenceTypeCodeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.StagingReferenceTypeCode",
	service = AopService.class
)
public class StagingReferenceTypeCodeLocalServiceImpl extends StagingReferenceTypeCodeLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.StagingReferenceTypeCodeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.StagingReferenceTypeCodeLocalServiceUtil</code>.
	 */
	public StagingReferenceTypeCode addStagingReferenceTypeCode(
		long externalReferenceTypeCodeId, String type, String key, String description, String modifiedDate,
		String createdDate) {

		long stagingReferenceTypeCodeId = counterLocalService.increment(StagingReferenceTypeCode.class.getName());

		StagingReferenceTypeCode stagingReferenceTypeCode = stagingReferenceTypeCodePersistence.create(
			stagingReferenceTypeCodeId);

		stagingReferenceTypeCode.setExternalReferenceTypeCodeId(externalReferenceTypeCodeId);
		stagingReferenceTypeCode.setType(type);
		stagingReferenceTypeCode.setKey(key);
		stagingReferenceTypeCode.setDescription(description);
		stagingReferenceTypeCode.setExternalModifiedDate(modifiedDate);
		stagingReferenceTypeCode.setExternalCreatedDate(createdDate);

		return addStagingReferenceTypeCode(stagingReferenceTypeCode);
	}

	public void deleteAll() {
		for (StagingReferenceTypeCode stagingReferenceTypeCode : stagingReferenceTypeCodePersistence.findAll()) {
			deleteStagingReferenceTypeCode(stagingReferenceTypeCode);
		}
	}

}