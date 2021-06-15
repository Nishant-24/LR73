package com.argus.oth.integration.mulesoft;

import com.liferay.portal.kernel.json.JSONObject;

import io.swagger.client.model.CaseNote;

import java.util.List;

/**
 * @author Jaclyn Ong
 */
public interface CaseNoteMuleSoftIntegration {

	public List<CaseNote> getCaseNotes(String correlationId, long caseId, String requestedDateTime) throws Exception;

	public JSONObject postCaseNotes(
			String correlationId, String noteUuid, long caseId, String authorFirstName, String authorLastName,
			String authorEmail, String note)
		throws Exception;

}