package com.argus.oth.integration.mulesoft.service;

import com.argus.oth.integration.mulesoft.CaseAuthorizationMuleSoftIntegration;
import com.argus.oth.integration.mulesoft.service.configuration.MuleSoftConfigurator;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import io.swagger.client.ApiResponse;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CaseAuthorization;
import io.swagger.client.model.CaseAuthorizationUpdate;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = AopService.class)
public class CaseAuthorizationMuleSoftIntegrationImpl
	extends BaseMuleSoftIntegrationImpl implements AopService, CaseAuthorizationMuleSoftIntegration {

	@Override
	public List<CaseAuthorization> getCaseAuthorizations(
			String correlationId, long externalCaseId, String requestedDateTime)
		throws Exception {

		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		return defaultApi.v1CasesCaseIdAuthorizationsGet(
			new BigDecimal(externalCaseId), _muleSoftConfigurator.getClientId(),
			_muleSoftConfigurator.getClientSecret(), _muleSoftConfigurator.getForwardedForHeader(), correlationId,
			requestedDateTime, null, null);
	}

	@Override
	public JSONObject patchCaseAuthorizations(
			String correlationId, long externalAuthorizationId, long externalCaseId, String authorizationUuid,
			String status, String formattedNewComment, long modifiedUserId, Date statusChangeDate)
		throws Exception {

		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		CaseAuthorizationUpdate caseAuthorization = new CaseAuthorizationUpdate();

		caseAuthorization.setStatus(status);
		caseAuthorization.setComment(formattedNewComment);
		caseAuthorization.setUuid(authorizationUuid);

		ApiResponse<Object> response = defaultApi.v1CasesCaseIdAuthorizationsAuthorizationIdPatchWithHttpInfo(
			new BigDecimal(externalCaseId), new BigDecimal(externalAuthorizationId),
			_muleSoftConfigurator.getClientId(), _muleSoftConfigurator.getClientSecret(),
			_muleSoftConfigurator.getForwardedForHeader(), correlationId, caseAuthorization);

		return JSONUtil.put("statusCode", response.getStatusCode());
	}

	protected MuleSoftConfigurator getMuleSoftConfigurator() {
		return _muleSoftConfigurator;
	}

	@Reference
	private MuleSoftConfigurator _muleSoftConfigurator;

}