package com.argus.oth.account.management.ws.serializer;

import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.DayFormatter;
import com.argus.oth.common.OTHConstants;
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
@Component(immediate = true, service = AMAClaimSerializer.class)
public class AMAClaimSerializer extends BaseSerializer {

	public JSONObject serialize(Document document) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		String amAnalyticsClaimDateIsoString = document.getDate(OTHConstants.FIELD_AM_ANALYTICS_CLAIM_DATE);
		String amAnalyticsClaimDateMmmDd = StringPool.BLANK;
		String amAnalyticsClaimDateMmmDdYyyy = StringPool.BLANK;

		try {
			Date amAnalyticsClaimDate = _dateFormatter.parseDateFormat(
				amAnalyticsClaimDateIsoString, OTHConstants.INDEX_DATE_FORMAT_PATTERN);

			amAnalyticsClaimDateIsoString = _dateFormatter.getISODateString(amAnalyticsClaimDate);

			amAnalyticsClaimDateMmmDd = _dateFormatter.getFormattedDay(amAnalyticsClaimDate, StringPool.BLANK);

			amAnalyticsClaimDateMmmDdYyyy = _dateFormatter.getFormattedDate(
				amAnalyticsClaimDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK);
		}
		catch (ParseException pe) {
			_log.error("Failed to parse date " + amAnalyticsClaimDateIsoString);

			amAnalyticsClaimDateIsoString = StringPool.BLANK;
		}

		jsonObject.put(OTHConstants.FIELD_AM_ANALYTICS_CLAIM_DATE, amAnalyticsClaimDateIsoString);

		jsonObject.put(OTHConstants.FIELD_AM_ANALYTICS_CLAIM_DATE_MMM_DD, amAnalyticsClaimDateMmmDd);

		jsonObject.put(OTHConstants.FIELD_AM_ANALYTICS_CLAIM_DATE_MMM_DD_YYYY, amAnalyticsClaimDateMmmDdYyyy);

		_addTurnAroundIntField(jsonObject, document, OTHConstants.FIELD_AVG_CLAIM_TURNAROUND, false);
		_addTurnAroundIntField(jsonObject, document, OTHConstants.FIELD_MIN_CLAIM_TURNAROUND, false);
		_addTurnAroundIntField(jsonObject, document, OTHConstants.FIELD_MAX_CLAIM_TURNAROUND, false);
		_addTurnAroundIntField(jsonObject, document, OTHConstants.FIELD_CLAIM_TURN_AROUND_GOAL, true);
		_addTurnAroundDoubleField(jsonObject, document, OTHConstants.FIELD_OVERALL_AVG_CLAIM_TURNAROUND, true);

		return jsonObject;
	}

	private void _addTurnAroundDoubleField(
		JSONObject jsonObject, Document document, String fieldName, boolean forceSingular) {

		double value = document.getDouble(fieldName);

		int roundedValue = (int)Math.round(value);

		jsonObject.put(fieldName, roundedValue);

		jsonObject.put(fieldName + OTHConstants.FIELD_FORMATTED_SUFFIX, _dayFormatter.formatDays(value, forceSingular));
	}

	private void _addTurnAroundIntField(
		JSONObject jsonObject, Document document, String fieldName, boolean forceSingular) {

		int value = document.getInteger(fieldName);

		jsonObject.put(fieldName, value);

		jsonObject.put(fieldName + OTHConstants.FIELD_FORMATTED_SUFFIX, _dayFormatter.formatDays(value, forceSingular));
	}

	private static final Log _log = LogFactoryUtil.getLog(AMAClaimSerializer.class);

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private DayFormatter _dayFormatter;

	@Reference
	private JSONFactory _jsonFactory;

}