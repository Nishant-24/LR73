package com.argus.oth.integration.mulesoft;

import com.liferay.portal.kernel.json.JSONObject;

import io.swagger.client.model.CaseAuthorization;

import java.util.Date;
import java.util.List;

/**
 * @author Ricky Pan
 */
public interface CaseAuthorizationMuleSoftIntegration {

	public List<CaseAuthorization> getCaseAuthorizations(
			String correlationId, long externalCaseId, String requestedDateTime)
		throws Exception;

	public JSONObject patchCaseAuthorizations(
			String correlationId, long externalAuthorizationId, long externalCaseId, String authorizationUuid,
			String status, String formattedNewComment, long modifiedUserId, Date statusChangeDate)
		throws Exception;

}