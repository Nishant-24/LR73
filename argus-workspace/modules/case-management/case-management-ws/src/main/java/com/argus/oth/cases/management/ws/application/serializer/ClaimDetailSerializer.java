package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.model.ClaimDetail;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = ClaimDetailSerializer.class)
public class ClaimDetailSerializer extends BaseSerializer {

	public JSONObject serialize(ClaimDetail claimDetail, Claim claim) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		// PK Fields

		jsonObject.put("claimDetailId", claimDetail.getClaimDetailId());
		jsonObject.put("claimId", claim.getClaimId());
		jsonObject.put("externalClaimId", claimDetail.getExternalClaimId());

		// Claim header fields

		jsonObject.put("network", claim.getRepricedNetwork());

		// Claim detail fields

		jsonObject.put("balance", claimDetail.getClaimAmount());
		jsonObject.put("billedAmount", claimDetail.getChargedAmount());
		jsonObject.put("coverage", claimDetail.getCoverage());
		jsonObject.put("paidAmount", claimDetail.getPaidAmount());
		jsonObject.put("paidDate", _dateFormatter.getISODateString(claimDetail.getPaidDate()));
		jsonObject.put("pCode", claimDetail.getProcedureCode());
		jsonObject.put("repricedAmount", claimDetail.getRepricedAmount());
		jsonObject.put("revCode", claimDetail.getRevCode());
		jsonObject.put("savingsAmount", claimDetail.getSavingsAmount());
		jsonObject.put("serviceFrom", _dateFormatter.getISODateString(claimDetail.getServiceFrom()));
		jsonObject.put("serviceTo", _dateFormatter.getISODateString(claimDetail.getServiceThru()));
		jsonObject.put("status", claimDetail.getLineStatus());
		jsonObject.put("units", claimDetail.getUnits());

		return jsonObject;
	}

	public JSONArray serialize(List<ClaimDetail> claimDetails, Claim claim, ClaimPaymentDTO claimPaymentDTO) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (ClaimDetail claimDetail : claimDetails) {
			JSONObject obj = serialize(claimDetail, claim);

			claimPaymentDTO.addClaimDetails(claimDetail);

			result.put(obj);
		}

		return result;
	}

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

}