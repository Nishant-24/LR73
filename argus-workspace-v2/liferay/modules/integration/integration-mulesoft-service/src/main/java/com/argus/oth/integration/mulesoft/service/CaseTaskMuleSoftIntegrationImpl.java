package com.argus.oth.integration.mulesoft.service;

import com.argus.oth.integration.mulesoft.CaseTaskMuleSoftIntegration;
import com.argus.oth.integration.mulesoft.service.configuration.MuleSoftConfigurator;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import io.swagger.client.ApiResponse;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CaseTaskPost;
import io.swagger.client.model.CaseTasks;

import java.math.BigDecimal;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = AopService.class)
public class CaseTaskMuleSoftIntegrationImpl
	extends BaseMuleSoftIntegrationImpl implements AopService, CaseTaskMuleSoftIntegration {

	public List<CaseTasks> getCaseTasks(String correlationId, long externalCaseId, String requestedDateTime)
		throws Exception {

		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		return defaultApi.v1CasesCaseIdTasksGet(
			new BigDecimal(externalCaseId), _muleSoftConfigurator.getClientId(),
			_muleSoftConfigurator.getClientSecret(), _muleSoftConfigurator.getForwardedForHeader(), correlationId,
			requestedDateTime, null, null);
	}

	public JSONObject postCaseTasks(
			String correlationId, String taskUuid, long externalCaseId, String priorityKey, String startDate,
			String descriptionKey)
		throws Exception {

		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		CaseTaskPost caseTasks = new CaseTaskPost();

		caseTasks.setPriority(priorityKey);
		caseTasks.setStartDate(startDate);
		caseTasks.setType(descriptionKey);
		caseTasks.setUuid(taskUuid);

		ApiResponse<Object> response = defaultApi.v1CasesCaseIdTasksPostWithHttpInfo(
			new BigDecimal(externalCaseId), _muleSoftConfigurator.getClientId(),
			_muleSoftConfigurator.getClientSecret(), _muleSoftConfigurator.getForwardedForHeader(), correlationId,
			caseTasks);

		return JSONUtil.put("statusCode", response.getStatusCode());
	}

	protected MuleSoftConfigurator getMuleSoftConfigurator() {
		return _muleSoftConfigurator;
	}

	@Reference
	private MuleSoftConfigurator _muleSoftConfigurator;

}