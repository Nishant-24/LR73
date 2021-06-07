package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.CasesGroupItem;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.service.CasesService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = CasesGroupItemSerializer.class)
public class CasesGroupItemSerializer extends BaseSerializer {

	public JSONObject serializeBookmark(CasesGroupItem casesGroupItem, TimeZone timeZone) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put(
			"createDate",
			_dateFormatter.getISODateString(
				_dateFormatter.convertToTimeZone(casesGroupItem.getCreateDate(), timeZone)));

		Cases cases = _casesService.fetchCaseByExternalCaseId(casesGroupItem.getExternalCaseId());

		if (Objects.nonNull(cases)) {
			jsonObject.put("caseId", cases.getCaseId());
			jsonObject.put("caseNumber", cases.getCaseNumber());
			jsonObject.put("diagnosis", cases.getPrimaryDiagCode());
			jsonObject.put("estimate", cases.getCostEstimate());
			jsonObject.put("externalCaseId", cases.getExternalCaseId());
			jsonObject.put("lastUpdated", _dateFormatter.getFormattedDefaultDate(cases.getLastUpdated()));
			jsonObject.put("primaryCode", cases.getPrimaryCode());
			jsonObject.put("status", cases.getStatus());

			Member member = _memberLocalService.fetchByExternalMemberId(cases.getMemberId());

			if (Objects.nonNull(member)) {
				jsonObject.put("memberId", member.getMemberNumber());
				jsonObject.put(
					"memberName",
					StringBundler.concat(member.getMemberFirstName(), StringPool.SPACE, member.getMemberLastName()));
			}
			else {
				_log.error("Missing member for CasesGroupItem ID " + casesGroupItem.getCasesGroupItemId());
			}
		}
		else {
			_log.error("Missing cases for CasesGroupItem ID " + casesGroupItem.getCasesGroupItemId());
		}

		return jsonObject;
	}

	public JSONArray serializeBookmarks(List<CasesGroupItem> casesGroupItems, TimeZone timeZone) {
		JSONArray result = _jsonFactory.createJSONArray();

		Stream<CasesGroupItem> casesGroupItemStream = casesGroupItems.stream();

		casesGroupItemStream.map(
			casesGroupItem -> serializeBookmark(casesGroupItem, timeZone)
		).sorted(
			(obj1, obj2) -> {
				try {
					Date date1 = _dateFormatter.parseDefaultDateFormat(obj1.getString("lastUpdated"));
					Date date2 = _dateFormatter.parseDefaultDateFormat(obj2.getString("lastUpdated"));

					return date2.compareTo(date1);
				}
				catch (Exception e) {
					if (_log.isErrorEnabled()) {
						_log.error("Exception occurred while parsing lastUpdated date", e);
					}

					return 0;
				}
			}
		).forEachOrdered(
			result::put
		);

		return result;
	}

	public JSONArray serializeRecentlyViewedList(
		List<CasesGroupItem> casesGroupItemList, TimeZone timeZone, long userId) {

		JSONArray result = _jsonFactory.createJSONArray();

		for (CasesGroupItem casesGroupItem : casesGroupItemList) {
			Cases cases = _casesService.fetchCaseByExternalCaseId(casesGroupItem.getExternalCaseId());

			if (Objects.isNull(cases)) {
				continue;
			}

			JSONObject obj = _casesSerializer.serialize(cases, _BLANK_VALUE, userId);

			obj.put("casesGroupItem", _serializeRecentlyViewed(casesGroupItem, timeZone));

			result.put(obj);
		}

		return result;
	}

	private JSONObject _serializeRecentlyViewed(CasesGroupItem casesGroupItem, TimeZone timeZone) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("casesGroupItemId", casesGroupItem.getCasesGroupItemId());
		jsonObject.put(
			"createDate",
			_dateFormatter.getISODateString(
				_dateFormatter.convertToTimeZone(casesGroupItem.getCreateDate(), timeZone)));
		jsonObject.put("externalCaseId", casesGroupItem.getExternalCaseId());
		jsonObject.put(
			"modifiedDate",
			_dateFormatter.getISODateString(
				_dateFormatter.convertToTimeZone(casesGroupItem.getModifiedDate(), timeZone)));
		jsonObject.put("type", casesGroupItem.getType());

		return jsonObject;
	}

	private static final String _BLANK_VALUE = OTHConstants.EM_DASH;

	private static final Log _log = LogFactoryUtil.getLog(CasesGroupItemSerializer.class);

	@Reference
	private CasesSerializer _casesSerializer;

	@Reference
	private CasesService _casesService;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private MemberLocalService _memberLocalService;

}