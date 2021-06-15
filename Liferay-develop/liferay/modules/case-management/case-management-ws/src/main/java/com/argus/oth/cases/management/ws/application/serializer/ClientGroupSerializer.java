package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.ClientGroup;

import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = ClientGroupSerializer.class)
public class ClientGroupSerializer {

	public JSONObject serialize(ClientGroup clientGroup) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("clientGroup", clientGroup.getClientGroup());
		jsonObject.put("clientGroupId", clientGroup.getClientGroupId());
		jsonObject.put("clientGroupName", clientGroup.getClientGroupName());
		jsonObject.put("clientId", clientGroup.getClientId());
		jsonObject.put("companyId", clientGroup.getCompanyId());
		jsonObject.put("externalClientGroupId", clientGroup.getExternalClientGroupId());
		jsonObject.put("groupId", clientGroup.getGroupId());

		return jsonObject;
	}

	@Reference
	private JSONFactory _jsonFactory;

}