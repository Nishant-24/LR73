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

package com.argus.oth.cases.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CasesService}.
 *
 * @author Brian Wing Shun Chan
 * @see CasesService
 * @generated
 */
public class CasesServiceWrapper
	implements CasesService, ServiceWrapper<CasesService> {

	public CasesServiceWrapper(CasesService casesService) {
		_casesService = casesService;
	}

	@Override
	public com.argus.oth.cases.management.model.Cases fetchCaseByCaseId(
			long caseId)
		throws Exception {

		return _casesService.fetchCaseByCaseId(caseId);
	}

	@Override
	public com.argus.oth.cases.management.model.Cases fetchCaseByExternalCaseId(
		long externalCaseId) {

		return _casesService.fetchCaseByExternalCaseId(externalCaseId);
	}

	@Override
	public com.argus.oth.cases.management.model.Cases fetchCases(long caseId) {
		return _casesService.fetchCases(caseId);
	}

	@Override
	public java.util.List<com.argus.oth.cases.management.model.Cases>
			getCasesByG_C(long groupId, long clientId)
		throws Exception {

		return _casesService.getCasesByG_C(groupId, clientId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _casesService.getOSGiServiceIdentifier();
	}

	@Override
	public CasesService getWrappedService() {
		return _casesService;
	}

	@Override
	public void setWrappedService(CasesService casesService) {
		_casesService = casesService;
	}

	private CasesService _casesService;

}