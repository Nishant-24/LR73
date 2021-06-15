package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.AuthProcedure;
import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.service.AuthProcedureLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = AuthorizationSerializer.class)
public class AuthorizationSerializer extends BaseSerializer {

	public JSONObject serialize(Authorization authorization, TimeZone timeZone) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		String authNumber = authorization.getAuthNumber();

		jsonObject.put("authId", authorization.getAuthorizationId());
		jsonObject.put("authNumber", authNumber);
		jsonObject.put("authStatus", _getReferenceTypeAuthStatus(authorization.getRtcAuthorizationStatus()));
		jsonObject.put("authStatusRefTypeCode", authorization.getRtcAuthorizationStatus());
		jsonObject.put("authType", _getReferenceTypeDescription(authorization.getRtcAuthorizationType()));
		jsonObject.put("comments", authorization.getComments());
		jsonObject.put("description", authorization.getDescription());
		jsonObject.put("effectiveFrom", _dateFormatter.getISODateString(authorization.getEffectiveFrom()));
		jsonObject.put("effectiveThru", _dateFormatter.getISODateString(authorization.getEffectiveThru()));
		jsonObject.put("facility", authorization.getFacility());
		jsonObject.put("memberEligibility", authorization.getCategory());
		jsonObject.put("modifiedDate", _dateFormatter.getISODateString(authorization.getModifiedDate()));
		jsonObject.put("procedureCode", authorization.getProcedureCode());
		jsonObject.put(
			"receivedDate",
			_dateFormatter.getISODateString(
				_dateFormatter.convertToTimeZone(authorization.getReceivedDate(), timeZone)));
		jsonObject.put(
			"receivedDateTimeZone", _dateFormatter.getTimeZoneDisplay(authorization.getReceivedDate(), timeZone));
		jsonObject.put(
			"statusChangeDate",
			_dateFormatter.getISODateString(
				_dateFormatter.convertToTimeZone(authorization.getStatusChangeDate(), timeZone)));
		jsonObject.put(
			"statusChangeDateTimeZone",
			_dateFormatter.getTimeZoneDisplay(authorization.getStatusChangeDate(), timeZone));

		// Member fields

		long memberId = authorization.getMemberId();

		Member member = _memberLocalService.fetchMember(memberId);

		if (Objects.nonNull(member)) {
			jsonObject.put("memberId", memberId);
			jsonObject.put(
				"memberName",
				StringBundler.concat(member.getMemberFirstName(), StringPool.SPACE, member.getMemberLastName()));
		}
		else {
			_log.error("Missing member Id for Authorization ID " + authorization.getAuthorizationId());
		}

		// Procedure code fields

		JSONArray procedureCodesArray = _getProcedureCodesJSONArray(authNumber);

		jsonObject.put("procedureCodeCount", procedureCodesArray.length());
		jsonObject.put("procedureCodes", procedureCodesArray);

		String title = StringPool.BLANK;

		if (procedureCodesArray.length() > 0) {
			title = procedureCodesArray.get(
				0
			).toString();
		}

		jsonObject.put("title", title);

		return jsonObject;
	}

	public JSONArray serialize(List<Authorization> authorizations, TimeZone timeZone) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (Authorization authorization : authorizations) {
			JSONObject obj = serialize(authorization, timeZone);

			result.put(obj);
		}

		return result;
	}

	private JSONArray _getProcedureCodesJSONArray(String authNumber) {
		JSONArray jsonArray = _jsonFactory.createJSONArray();

		for (AuthProcedure authProcedure : _authProcedureLocalService.fetchAuthProceduresByAuthNumber(authNumber)) {
			String title = StringBundler.concat(
				authProcedure.getMedicalCodeId(), StringPool.SPACE, authProcedure.getDescription());

			jsonArray.put(title);
		}

		return jsonArray;
	}

	private String _getReferenceTypeAuthStatus(String rtcAuthorizationStatus) {
		ReferenceTypeCode rtc = _referenceTypeCodeLocalService.fetchByKey(rtcAuthorizationStatus);

		if (Objects.nonNull(rtc)) {
			return rtc.getDescription();
		}

		return null;
	}

	private String _getReferenceTypeDescription(String rtcAuthorizationType) {
		ReferenceTypeCode rtc = _referenceTypeCodeLocalService.fetchByKey(rtcAuthorizationType);

		if (Objects.nonNull(rtc)) {
			return rtc.getDescription();
		}

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(AuthorizationSerializer.class);

	@Reference
	private AuthProcedureLocalService _authProcedureLocalService;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private MemberLocalService _memberLocalService;

	@Reference
	private ReferenceTypeCodeLocalService _referenceTypeCodeLocalService;

}