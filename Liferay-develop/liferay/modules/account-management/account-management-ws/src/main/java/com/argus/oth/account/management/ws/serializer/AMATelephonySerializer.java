package com.argus.oth.account.management.ws.serializer;

import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.PercentageFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.search.document.Document;

import java.text.ParseException;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = AMATelephonySerializer.class)
public class AMATelephonySerializer extends BaseSerializer {

	public JSONObject serialize(Document document) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		String amAnalyticsTelephonyDateIsoString = document.getDate(OTHConstants.FIELD_AM_ANALYTICS_TELEPHONY_DATE);
		String amAnalyticsTelephonyDateMmmDd = StringPool.BLANK;
		String amAnalyticsTelephonyDateMmmDdYyyy = StringPool.BLANK;

		try {
			Date amAnalyticsTelephonyDate = _dateFormatter.parseDateFormat(
				amAnalyticsTelephonyDateIsoString, OTHConstants.INDEX_DATE_FORMAT_PATTERN);

			amAnalyticsTelephonyDateIsoString = _dateFormatter.getISODateString(amAnalyticsTelephonyDate);

			amAnalyticsTelephonyDateMmmDd = _dateFormatter.getFormattedDay(amAnalyticsTelephonyDate, StringPool.BLANK);

			amAnalyticsTelephonyDateMmmDdYyyy = _dateFormatter.getFormattedDate(
				amAnalyticsTelephonyDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK);
		}
		catch (ParseException pe) {
			_log.error("Failed to parse date " + amAnalyticsTelephonyDateIsoString);

			amAnalyticsTelephonyDateIsoString = StringPool.BLANK;
		}

		jsonObject.put(OTHConstants.FIELD_AM_ANALYTICS_TELEPHONY_DATE, amAnalyticsTelephonyDateIsoString);

		jsonObject.put(OTHConstants.FIELD_AM_ANALYTICS_TELEPHONY_DATE_MMM_DD, amAnalyticsTelephonyDateMmmDd);

		jsonObject.put(OTHConstants.FIELD_AM_ANALYTICS_TELEPHONY_DATE_MMM_DD_YYYY, amAnalyticsTelephonyDateMmmDdYyyy);

		_addPercentField(jsonObject, document, OTHConstants.FIELD_AVG_DOWN_TIME, true);
		_addSecondsField(jsonObject, document, OTHConstants.FIELD_AVG_SPEED_OF_ANSWER);
		_addPercentField(jsonObject, document, OTHConstants.FIELD_ABANDONMENT_RATE, true);
		_addPercentField(jsonObject, document, OTHConstants.FIELD_DOWN_TIME_GOAL, true);
		_addSecondsField(jsonObject, document, OTHConstants.FIELD_SPEED_ANSWER_GOAL);
		_addPercentField(jsonObject, document, OTHConstants.FIELD_ABANDONMENT_RATE_GOAL, true);
		_addPercentField(jsonObject, document, OTHConstants.FIELD_OVERALL_AVG_DOWNTIME, true);
		_addSecondsField(jsonObject, document, OTHConstants.FIELD_OVERALL_AVG_SPEED_OF_ANSWER);
		_addPercentField(jsonObject, document, OTHConstants.FIELD_OVERALL_AVG_ABANDONMENT_RATE, true);

		return jsonObject;
	}

	private void _addPercentField(JSONObject jsonObject, Document document, String fieldName, boolean multiply) {
		double value = document.getDouble(fieldName);

		jsonObject.put(fieldName, _percentageFormatter.formatNumber(value, OTHConstants.FORMAT_THREE_DECIMAL_PLACES));

		jsonObject.put(
			fieldName + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_percentageFormatter.formatDecimalForDisplay(value, OTHConstants.FORMAT_ONE_DECIMAL_PLACE, multiply));
	}

	private void _addSecondsField(JSONObject jsonObject, Document document, String fieldName) {
		double value = document.getDouble(fieldName);

		jsonObject.put(fieldName, value);

		jsonObject.put(
			fieldName + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_dateFormatter.getFormattedSeconds(value, OTHConstants.FORMAT_ONE_DECIMAL_PLACE));
	}

	private static final Log _log = LogFactoryUtil.getLog(AMATelephonySerializer.class);

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private PercentageFormatter _percentageFormatter;

}