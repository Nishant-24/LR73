package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.model.ClaimDetail;
import com.argus.oth.cases.management.service.ClaimDetailLocalService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = ClaimSerializer.class)
public class ClaimSerializer extends BaseSerializer {

	public JSONObject serialize(Claim claim) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("billType", claim.getBillType());
		jsonObject.put("claimId", claim.getClaimId());
		jsonObject.put("claimNumber", claim.getClaimRef());
		jsonObject.put("externalClaimId", claim.getExternalClaimId());
		jsonObject.put("network", claim.getRepricedNetwork());
		jsonObject.put("paidDate", _dateFormatter.getISODateString(claim.getPaidDate()));
		jsonObject.put("providerName", claim.getProvider());
		jsonObject.put("serviceFrom", _dateFormatter.getISODateString(claim.getServiceFrom()));
		jsonObject.put("serviceTo", _dateFormatter.getISODateString(claim.getServiceThru()));
		jsonObject.put("status", claim.getClaimStatus());

		// use pass-by-reference on DTO to track sums while serializing

		ClaimPaymentDTO claimPaymentDTO = new ClaimPaymentDTO();

		JSONArray claimDetails = _serializeClaimDetails(claim, claimPaymentDTO);

		jsonObject.put("claimDetails", claimDetails);

		String coverage = StringPool.BLANK;

		if (claimDetails.length() > 0) {
			JSONObject claimDetail = claimDetails.getJSONObject(0);

			coverage = claimDetail.getString("coverage", StringPool.BLANK);
		}

		jsonObject.put("balance", claimPaymentDTO.getBalance());
		jsonObject.put("billedAmount", claimPaymentDTO.getChargedAmount());
		jsonObject.put("coverage", coverage);
		jsonObject.put("paidAmount", claimPaymentDTO.getPaidAmount());
		jsonObject.put("repricedAmount", claimPaymentDTO.getRepricedAmount());
		jsonObject.put("savingsAmount", claimPaymentDTO.getSavingsAmount());

		return jsonObject;
	}

	public JSONArray serialize(List<Claim> claims) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (Claim claim : claims) {
			JSONObject obj = serialize(claim);

			result.put(obj);
		}

		return result;
	}

	private JSONArray _serializeClaimDetails(Claim claim, ClaimPaymentDTO claimPaymentDTO) {
		List<ClaimDetail> claimDetails = _claimDetailLocalService.getByExternalClaimId(claim.getExternalClaimId());

		return _claimDetailSerializer.serialize(claimDetails, claim, claimPaymentDTO);
	}

	@Reference
	private ClaimDetailLocalService _claimDetailLocalService;

	@Reference
	private ClaimDetailSerializer _claimDetailSerializer;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

}