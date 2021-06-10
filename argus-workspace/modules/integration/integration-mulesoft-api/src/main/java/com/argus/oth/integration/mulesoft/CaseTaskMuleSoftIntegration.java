package com.argus.oth.integration.mulesoft;

import com.liferay.portal.kernel.json.JSONObject;

import io.swagger.client.model.CaseTasks;

import java.util.List;

/**
 * @author Ricky Pan
 */
public interface CaseTaskMuleSoftIntegration {

	public List<CaseTasks> getCaseTasks(String correlationId, long caseId, String requestedDateTime) throws Exception;

	public JSONObject postCaseTasks(
			String correlationId, String taskUuid, long externalCaseId, String priorityKey, String startDate,
			String descriptionKey)
		throws Exception;

}