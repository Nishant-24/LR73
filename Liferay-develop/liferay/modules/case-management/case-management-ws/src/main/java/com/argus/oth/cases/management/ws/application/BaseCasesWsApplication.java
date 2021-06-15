package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.CasesService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
public abstract class BaseCasesWsApplication extends BaseWsApplication {

	protected Cases getCases(long caseId) {
		Cases cases = casesService.fetchCases(caseId);

		if (Objects.isNull(cases)) {
			throw new IllegalStateException("Case with caseId " + caseId + " cannot be found");
		}

		return cases;
	}

	protected User getValidCurrentUser(HttpServletRequest httpServletRequest) {
		User currentUser = getCurrentUser(httpServletRequest, userLocalService);

		if (Objects.isNull(currentUser)) {
			throw new IllegalStateException("Current user cannot be found");
		}

		return currentUser;
	}

	protected static final String DEFAULT_PROCESS_STATUS = ProcessStatusType.PENDING.toString();

	@Reference
	protected CasesService casesService;

	@Reference
	protected UserLocalService userLocalService;

}