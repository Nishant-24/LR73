package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.ReferenceTypeCode;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ReferenceTypeCodeSerializer.class)
public class ReferenceTypeCodeSerializer {

	public JSONArray serialize(List<ReferenceTypeCode> referenceTypeCodes) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (ReferenceTypeCode referenceTypeCode : referenceTypeCodes) {
			JSONObject obj = _serialize(referenceTypeCode);

			result.put(obj);
		}

		return result;
	}

	private JSONObject _serialize(ReferenceTypeCode referenceTypeCode) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("description", referenceTypeCode.getDescription());
		jsonObject.put("externalReferenceTypeCodeId", referenceTypeCode.getExternalReferenceTypeCodeId());
		jsonObject.put("key", referenceTypeCode.getKey());
		jsonObject.put("type", referenceTypeCode.getType());

		return jsonObject;
	}

	@Reference
	private JSONFactory _jsonFactory;

}