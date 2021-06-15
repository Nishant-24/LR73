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

import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.service.base.ReferenceTypeCodeLocalServiceBaseImpl;
import com.argus.oth.common.OTHConstants;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the reference type code local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jaclyn Ong
 * @see ReferenceTypeCodeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.ReferenceTypeCode", service = AopService.class
)
public class ReferenceTypeCodeLocalServiceImpl extends ReferenceTypeCodeLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.ReferenceTypeCodeLocalServiceUtil</code>.
	 */
	public ReferenceTypeCode addReferenceTypeCode(
		long groupId, long externalReferenceTypeCode, String type, String key, String description, Date modifiedDate,
		Date createdDate, String randomString) {

		long referenceTypeCodeId = counterLocalService.increment(ReferenceTypeCode.class.getName());

		ReferenceTypeCode referenceTypeCode = referenceTypeCodePersistence.create(referenceTypeCodeId);

		referenceTypeCode.setGroupId(groupId);
		referenceTypeCode.setExternalReferenceTypeCodeId(externalReferenceTypeCode);
		referenceTypeCode.setType(type);
		referenceTypeCode.setKey(key);
		referenceTypeCode.setDescription(description);
		referenceTypeCode.setModifiedDate(modifiedDate);
		referenceTypeCode.setCreateDate(createdDate);
		referenceTypeCode.setRowProcessed(randomString);

		return addReferenceTypeCode(referenceTypeCode);
	}

	public void deleteUnprocessed(String randomString) {
		for (ReferenceTypeCode referenceTypeCode : referenceTypeCodePersistence.findByRowProcessed(randomString)) {
			_log.info(
				String.format(
					OTHConstants.DELETE_LOG_STRING_FORMAT, ReferenceTypeCode.class.getSimpleName(),
					referenceTypeCode.getExternalReferenceTypeCodeId(), referenceTypeCode.getReferenceTypeCodeId()));

			deleteReferenceTypeCode(referenceTypeCode);
		}
	}

	public ReferenceTypeCode fetchByKey(String key) {
		return referenceTypeCodePersistence.fetchByKey(key);
	}

	public List<ReferenceTypeCode> getByType(String type) {
		return referenceTypeCodePersistence.findByType(type);
	}

	private static final Log _log = LogFactoryUtil.getLog(ReferenceTypeCodeLocalServiceImpl.class);

}