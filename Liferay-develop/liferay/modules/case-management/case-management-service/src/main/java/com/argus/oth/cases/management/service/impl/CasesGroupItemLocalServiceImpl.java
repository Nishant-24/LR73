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

import com.argus.oth.cases.management.model.CasesGroupItem;
import com.argus.oth.cases.management.service.base.CasesGroupItemLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the cases group item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.CasesGroupItemLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasesGroupItemLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.argus.oth.cases.management.model.CasesGroupItem", service = AopService.class
)
public class CasesGroupItemLocalServiceImpl extends CasesGroupItemLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.argus.oth.cases.management.service.CasesGroupItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.CasesGroupItemLocalServiceUtil</code>.
	 */
	public CasesGroupItem addCasesGroupItem(long groupId, long userId, long externalCaseId, String type) {
		long id = counterLocalService.increment(CasesGroupItem.class.getName());

		CasesGroupItem casesGroupItem = createCasesGroupItem(id);

		casesGroupItem.setGroupId(groupId);
		casesGroupItem.setCreateDate(new Date());
		casesGroupItem.setModifiedDate(new Date());
		casesGroupItem.setUserId(userId);
		casesGroupItem.setExternalCaseId(externalCaseId);
		casesGroupItem.setType(type);

		return addCasesGroupItem(casesGroupItem);
	}

	public CasesGroupItem fetchCasesGroupItemByE_U_T(long externalCaseId, long userId, String type) {
		return casesGroupItemPersistence.fetchByE_U_T(externalCaseId, userId, type);
	}

	public List<CasesGroupItem> getCasesGroupItemsByG_U_T(long groupId, long userId, String type, int rowLimit) {
		return casesGroupItemPersistence.findByG_U_T(groupId, userId, type, QueryUtil.ALL_POS, rowLimit);
	}

	public void setModifiedDate(long casesGroupItemId) {
		CasesGroupItem casesGroupItem = casesGroupItemPersistence.fetchByPrimaryKey(casesGroupItemId);

		casesGroupItem.setModifiedDate(new Date());

		casesGroupItemPersistence.update(casesGroupItem);
	}

}