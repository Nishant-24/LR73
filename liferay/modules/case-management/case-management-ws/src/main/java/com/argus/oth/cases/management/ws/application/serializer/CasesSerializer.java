package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.CasesGroupItem;
import com.argus.oth.cases.management.model.ClientGroup;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.service.CasesGroupItemLocalService;
import com.argus.oth.cases.management.service.ClientGroupLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = CasesSerializer.class)
public class CasesSerializer extends BaseSerializer {

	public JSONObject serialize(Cases cases, long userId) {
		return serialize(cases, StringPool.BLANK, userId);
	}

	public JSONObject serialize(Cases cases, String blankValue, long userId) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("caseEndDate", _dateFormatter.getISODateString(cases.getCaseEndDate()));
		jsonObject.put("caseId", cases.getCaseId());
		jsonObject.put("caseManager", getValue(cases.getCaseManager(), blankValue));
		jsonObject.put("caseNumber", getValue(cases.getCaseNumber(), blankValue));
		jsonObject.put("caseStartDate", _dateFormatter.getISODateString(cases.getCaseStartDate()));
		jsonObject.put("chargedAmount", cases.getChargedAmount());
		jsonObject.put("clientGroupId", cases.getClientGroupId());
		jsonObject.put("clientId", cases.getClientId());
		jsonObject.put("clientName", getValue(cases.getClientName(), blankValue));
		jsonObject.put("companyId", cases.getCompanyId());
		jsonObject.put("consentReceivedDate", _dateFormatter.getISODateString(cases.getConsentReceivedDate()));
		jsonObject.put("costEstimate", cases.getCostEstimate());
		jsonObject.put("createDate", _dateFormatter.getISODateString(cases.getCreateDate()));
		jsonObject.put("estimateEntryDate", _dateFormatter.getISODateString(cases.getEstimateEntryDate()));
		jsonObject.put("externalCaseId", cases.getExternalCaseId());
		jsonObject.put("externalCreatedDate", _dateFormatter.getISODateString(cases.getExternalCreatedDate()));
		jsonObject.put("groupId", cases.getGroupId());
		jsonObject.put("lastUpdated", _dateFormatter.getISODateString(cases.getLastUpdated()));
		jsonObject.put("medicalPlan", getValue(cases.getMedicalPlan(), blankValue));
		jsonObject.put("memberId", cases.getMemberId());
		jsonObject.put("modifiedDate", _dateFormatter.getISODateString(cases.getModifiedDate()));
		jsonObject.put("paidAmount", cases.getPaidAmount());
		jsonObject.put("primaryCode", getValue(cases.getPrimaryCode(), blankValue));
		jsonObject.put("primaryDiagCode", getValue(cases.getPrimaryDiagCode(), blankValue));
		jsonObject.put("primaryFacility", cases.getPrimaryFacility());
		jsonObject.put("repricedAmount", cases.getRepricedAmount());
		jsonObject.put("savingsAmount", cases.getSavingsAmount());
		jsonObject.put("savingsPercent", cases.getSavingsPercent());
		jsonObject.put("status", getValue(cases.getStatus(), blankValue));
		jsonObject.put("treatingPhysician", cases.getTreatingPhysician());

		CasesGroupItem bookmark = _casesGroupItemLocalService.fetchCasesGroupItemByE_U_T(
			cases.getExternalCaseId(), userId, OTHConstants.CASE_GROUP_TYPE_BOOKMARK);

		jsonObject.put("bookmarked", !Objects.isNull(bookmark));

		ClientGroup clientGroup = _clientGroupLocalService.fetchByExternalClientGroupId(cases.getClientGroupId());

		JSONObject clientGroupJSONObject = _jsonFactory.createJSONObject();

		if (Objects.nonNull(clientGroup)) {
			clientGroupJSONObject = _clientGroupSerializer.serialize(clientGroup);
		}

		jsonObject.put("clientGroup", clientGroupJSONObject);

		Member member = _memberLocalService.fetchByExternalMemberId(cases.getMemberId());

		JSONObject memberJSONObject = _jsonFactory.createJSONObject();

		if (Objects.nonNull(member)) {
			memberJSONObject = _memberSerializer.serialize(member);
		}

		jsonObject.put("member", memberJSONObject);

		return jsonObject;
	}

	public JSONArray serialize(List<Cases> casesList, long userId) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (Cases cases : casesList) {
			JSONObject obj = serialize(cases, userId);

			result.put(obj);
		}

		return result;
	}

	@Reference
	private CasesGroupItemLocalService _casesGroupItemLocalService;

	@Reference
	private ClientGroupLocalService _clientGroupLocalService;

	@Reference
	private ClientGroupSerializer _clientGroupSerializer;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private MemberLocalService _memberLocalService;

	@Reference
	private MemberSerializer _memberSerializer;

}