package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Member;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = MemberSerializer.class)
public class MemberSerializer extends BaseSerializer {

	public JSONObject serialize(Member member) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("certificationNumber", member.getCertificationNumber());
		jsonObject.put("clientGroupId", member.getClientGroupId());
		jsonObject.put("clientId", member.getClientId());
		jsonObject.put("companyId", member.getCompanyId());
		jsonObject.put("externalMemberId", member.getExternalMemberId());
		jsonObject.put("groupId", member.getGroupId());
		jsonObject.put("memberDOB", _dateFormatter.getISODateString(member.getMemberDOB()));
		jsonObject.put("memberFirstName", member.getMemberFirstName());
		jsonObject.put("memberId", member.getMemberId());
		jsonObject.put("memberLastName", member.getMemberLastName());

		String memberName = member.getMemberFirstName() + StringPool.SPACE + member.getMemberLastName();

		jsonObject.put("memberName", memberName);

		jsonObject.put("memberNumber", member.getMemberNumber());
		jsonObject.put("rxNumber", member.getRxNumber());

		return jsonObject;
	}

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

}