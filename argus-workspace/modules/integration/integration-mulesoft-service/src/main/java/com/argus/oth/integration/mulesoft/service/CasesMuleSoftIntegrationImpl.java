package com.argus.oth.integration.mulesoft.service;

import com.argus.oth.integration.mulesoft.CasesMuleSoftIntegration;
import com.argus.oth.integration.mulesoft.service.configuration.MuleSoftConfigurator;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.GetterUtil;

import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.ModelCase;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = AopService.class)
public class CasesMuleSoftIntegrationImpl
	extends BaseMuleSoftIntegrationImpl implements AopService, CasesMuleSoftIntegration {

	@Override
	public List<ModelCase> getCases(String correlationId, String clientId, String requestedDateTime) throws Exception {
		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		return defaultApi.v1CasesGet(
			GetterUtil.getInteger(clientId), _muleSoftConfigurator.getClientId(),
			_muleSoftConfigurator.getClientSecret(), _muleSoftConfigurator.getForwardedForHeader(), correlationId,
			requestedDateTime, null, null);
	}

	protected MuleSoftConfigurator getMuleSoftConfigurator() {
		return _muleSoftConfigurator;
	}

	@Reference
	private MuleSoftConfigurator _muleSoftConfigurator;

}