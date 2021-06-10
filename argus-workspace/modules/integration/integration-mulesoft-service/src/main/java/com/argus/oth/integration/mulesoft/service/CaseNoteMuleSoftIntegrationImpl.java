package com.argus.oth.integration.mulesoft.service;

import com.argus.oth.common.OTHConstants;
import com.argus.oth.integration.mulesoft.CaseNoteMuleSoftIntegration;
import com.argus.oth.integration.mulesoft.service.configuration.MuleSoftConfigurator;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import io.swagger.client.ApiResponse;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CaseNote;
import io.swagger.client.model.CaseNotePost;

import java.math.BigDecimal;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = AopService.class)
public class CaseNoteMuleSoftIntegrationImpl
	extends BaseMuleSoftIntegrationImpl implements AopService, CaseNoteMuleSoftIntegration {

	public List<CaseNote> getCaseNotes(String correlationId, long caseId, String requestedDateTime) throws Exception {
		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		return defaultApi.v1CasesCaseIdNotesGet(
			new BigDecimal(caseId), _muleSoftConfigurator.getClientId(), _muleSoftConfigurator.getClientSecret(),
			_muleSoftConfigurator.getForwardedForHeader(), correlationId, requestedDateTime, null, null);
	}

	public JSONObject postCaseNotes(
			String correlationId, String noteUuid, long caseId, String authorFirstName, String authorLastName,
			String authorEmail, String note)
		throws Exception {

		String formattedNote = _getFormattedNote(authorFirstName, authorLastName, authorEmail, note);

		DefaultApi defaultApi = getClient(_muleSoftConfigurator.getCaseBaseAPIURL());

		CaseNotePost caseNotes = new CaseNotePost();

		caseNotes.setNote(formattedNote);
		caseNotes.setType(OTHConstants.NOTE_TYPE_CARRIER_KEY);
		caseNotes.setUuid(noteUuid);

		ApiResponse<Object> response = defaultApi.v1CasesCaseIdNotesPostWithHttpInfo(
			new BigDecimal(caseId), _muleSoftConfigurator.getClientId(), _muleSoftConfigurator.getClientSecret(),
			_muleSoftConfigurator.getForwardedForHeader(), correlationId, caseNotes);

		return JSONUtil.put("statusCode", response.getStatusCode());
	}

	protected MuleSoftConfigurator getMuleSoftConfigurator() {
		return _muleSoftConfigurator;
	}

	private String _getFormattedNote(String authorFirstName, String authorLastName, String authorEmail, String note) {
		return String.format(
			"|~| %s %s - %s |~|%s%s", authorFirstName, authorLastName, authorEmail, StringPool.NEW_LINE, note);
	}

	@Reference
	private MuleSoftConfigurator _muleSoftConfigurator;

}