package com.argus.oth.claim.ws.application.serializer;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.common.DateFormatter;
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
@Component(immediate = true, service = ClaimAnalyticsSerializer.class)
public class ClaimAnalyticsSerializer extends BaseSerializer {

	public JSONObject serialize(ClaimAnalytics claimAnalytics) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("agedDays", claimAnalytics.getClaimAging());
		jsonObject.put("billType", claimAnalytics.getBillType());
		jsonObject.put("chargedAmount", claimAnalytics.getChargedAmount());
		jsonObject.put("chargedPercent", claimAnalytics.getChargedPercent());
		jsonObject.put("chargedRange", claimAnalytics.getChargedRange());
		jsonObject.put("claimAnalyticsId", claimAnalytics.getClaimAnalyticsId());
		jsonObject.put("claimNumber", claimAnalytics.getClaimNumber());
		jsonObject.put("claimStatus", claimAnalytics.getClaimStatus());
		jsonObject.put("clientName", claimAnalytics.getClientName());
		jsonObject.put("companyId", claimAnalytics.getCompanyId());
		jsonObject.put("country", claimAnalytics.getCountry());
		jsonObject.put("diagnosisCodes", claimAnalytics.getDiagnosisCodes());

		Cases cases = _casesLocalService.fetchCaseByExternalCaseId(claimAnalytics.getExternalCaseId());

		long caseId = 0L;

		if (Objects.nonNull(cases)) {
			caseId = cases.getCaseId();
		}

		jsonObject.put("caseId", new Long(caseId));

		Member member = _memberLocalService.fetchByExternalMemberId(claimAnalytics.getExternalMemberId());

		String memberNumber = StringPool.BLANK;

		if (Objects.nonNull(member)) {
			memberNumber = member.getMemberNumber();
		}

		jsonObject.put("clientGroupName", claimAnalytics.getClientGroupName());
		jsonObject.put("financialExposure", claimAnalytics.getFinancialExposure());
		jsonObject.put("groupId", claimAnalytics.getGroupId());
		jsonObject.put("memberName", claimAnalytics.getMemberName());
		jsonObject.put("memberNumber", memberNumber);
		jsonObject.put("paidAmount", claimAnalytics.getPaidAmount());
		jsonObject.put("paidDate", _dateFormatter.getISODateString(claimAnalytics.getPaidDate()));
		jsonObject.put("paidDay", _dateFormatter.getFormattedDay(claimAnalytics.getPaidDate(), StringPool.BLANK));
		jsonObject.put("paidRange", claimAnalytics.getPaidRange());
		jsonObject.put("primaryDiagnosis", claimAnalytics.getPrimaryDiagnosis());
		jsonObject.put("procedureCodes", claimAnalytics.getProcedureCodes());
		jsonObject.put("providerName", claimAnalytics.getProviderName());
		jsonObject.put("receivedDate", _dateFormatter.getISODateString(claimAnalytics.getReceivedDate()));
		jsonObject.put(
			"receivedDay", _dateFormatter.getFormattedDay(claimAnalytics.getReceivedDate(), StringPool.BLANK));
		jsonObject.put("repricedAmount", claimAnalytics.getRepricedAmount());
		jsonObject.put("repricedNetwork", claimAnalytics.getRepricedNetwork());
		jsonObject.put("repricedPercent", claimAnalytics.getRepricedPercent());
		jsonObject.put("repricedRange", claimAnalytics.getRepricedRange());
		jsonObject.put("resultCodes", claimAnalytics.getResultCodes());
		jsonObject.put("savingsAmount", claimAnalytics.getSavingsAmount());
		jsonObject.put("savingsPercent", claimAnalytics.getSavingsPercent());
		jsonObject.put("savingsRange", claimAnalytics.getSavingsRange());
		jsonObject.put("serviceDate", _dateFormatter.getISODateString(claimAnalytics.getServiceDate()));
		jsonObject.put("serviceDay", _dateFormatter.getFormattedDay(claimAnalytics.getServiceDate(), StringPool.BLANK));
		jsonObject.put("state", claimAnalytics.getState());

		return jsonObject;
	}

	public JSONArray serialize(List<ClaimAnalytics> claimAnalyticsList) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (ClaimAnalytics claimAnalytics : claimAnalyticsList) {
			JSONObject obj = serialize(claimAnalytics);

			result.put(obj);
		}

		return result;
	}

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private MemberLocalService _memberLocalService;

}