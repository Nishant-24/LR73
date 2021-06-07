package com.argus.oth.account.management.ws;

import com.argus.oth.account.management.model.AMAnalyticsClaim;
import com.argus.oth.account.management.model.AMAnalyticsDB;
import com.argus.oth.account.management.model.AMAnalyticsTelephony;
import com.argus.oth.account.management.service.AMAnalyticsDBLocalService;
import com.argus.oth.account.management.ws.serializer.AMAClaimSerializer;
import com.argus.oth.account.management.ws.serializer.AMATelephonySerializer;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.charts.ChartsService;
import com.argus.oth.charts.model.AddResponseFieldsParameters;
import com.argus.oth.common.CompactNumberFormatter;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.DayFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.PercentageFormatter;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Eric Chin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/account-management",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=AccountManagement.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class AccountManagementApplication extends BaseWsApplication {

	@GET
	@Path("/claim-stats")
	public Response getClaimStats(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@QueryParam("averageField") String averageField, @QueryParam("overallAvgField") String overallAvgField,
		@QueryParam("goalField") String goalField, @QueryParam("start") @DefaultValue("0") Integer start,
		@QueryParam("end") @DefaultValue("100") Integer end, @Context HttpServletRequest httpServletRequest) {

		try {
			_validateSLAChartParameters(averageField, overallAvgField, goalField);

			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			JSONObject responseObj = _chartsService.getAreaChartData(
				AMAnalyticsClaim.class, currentUser.getTimeZone(), client.getExternalClientId(), startDate, endDate, start, end,
				_amaClaimSerializer::serialize, averageField, OTHConstants.FIELD_AM_ANALYTICS_CLAIM_DATE,
				overallAvgField, goalField, this::_addClaimStatsFields);

			return success(responseObj);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	@GET
	@Path("/date-range")
	public Response getDateRange(@Context HttpServletRequest httpServletRequest) {
		try {
			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			DateRange dateRange = _chartsService.getDateRange(null, null, currentUser.getTimeZone());

			String formattedDateRange = _dateFormatter.getFormattedDateRange(
				dateRange.getStartDate(), dateRange.getEndDate());

			JSONObject response = _jsonFactory.createJSONObject();

			response.put(OTHConstants.VALUE, formattedDateRange);

			return success(response);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/homepage-stats")
	public Response getHomepageStats(@Context HttpServletRequest httpServletRequest) {
		Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

		AMAnalyticsDB amAnalyticsDB = _amAnalyticsDBLocalService.fetchByClientId(client.getExternalClientId());

		if (Objects.isNull(amAnalyticsDB)) {
			return failure("Unable to find AMAnalyticsDB for client");
		}

		JSONObject response = _jsonFactory.createJSONObject();

		response.put(OTHConstants.FIELD_ABANDONMENT_RATE, amAnalyticsDB.getAbandonmentRate());
		response.put(OTHConstants.FIELD_AVG_DOWN_TIME, amAnalyticsDB.getAvgDownTime());
		response.put(OTHConstants.FIELD_AVG_SPEED_OF_ANSWER, amAnalyticsDB.getAvgSpeedOfAnswer());
		response.put(OTHConstants.FIELD_CHARGED_AMOUNT, amAnalyticsDB.getChargedAmount());
		response.put(
			OTHConstants.FIELD_CHARGED_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_compactNumberFormatter.format(amAnalyticsDB.getChargedAmount()));

		Long claimsTurnaroundTime = amAnalyticsDB.getClaimsTurnaround();

		response.put(_CLAIMS_TURNAROUND_TIME, claimsTurnaroundTime);

		response.put(OTHConstants.FIELD_REPRICED_AMOUNT, amAnalyticsDB.getRepricedAmount());
		response.put(
			OTHConstants.FIELD_REPRICED_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_compactNumberFormatter.format(amAnalyticsDB.getRepricedAmount()));
		response.put(OTHConstants.FIELD_SAVINGS_PERCENT, amAnalyticsDB.getSavingsPercent());

		response.put(OTHConstants.FIELD_ABANDONMENT_RATE_GOAL, amAnalyticsDB.getAbandonmentRateGoal());
		response.put(OTHConstants.FIELD_CLAIMS_TURNAROUND_GOAL, amAnalyticsDB.getClaimsTurnaroundGoal());
		response.put(OTHConstants.FIELD_DOWN_TIME_GOAL, amAnalyticsDB.getDownTimeGoal());
		response.put(OTHConstants.FIELD_SPEED_OF_ANSWER_GOAL, amAnalyticsDB.getSpeedOfAnswerGoal());

		response.put(
			OTHConstants.FIELD_AVG_DOWN_TIME + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_percentageFormatter.formatDecimalForDisplay(
				amAnalyticsDB.getAvgDownTime(), OTHConstants.FORMAT_ONE_DECIMAL_PLACE, true));

		response.put(
			OTHConstants.FIELD_AVG_SPEED_OF_ANSWER + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_dateFormatter.getFormattedSeconds(
				amAnalyticsDB.getAvgSpeedOfAnswer(), OTHConstants.FORMAT_ONE_DECIMAL_PLACE, false));

		response.put(
			OTHConstants.FIELD_ABANDONMENT_RATE + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_percentageFormatter.formatDecimalForDisplay(
				amAnalyticsDB.getAbandonmentRate(), OTHConstants.FORMAT_ONE_DECIMAL_PLACE, true));

		response.put(
			_CLAIMS_TURNAROUND_TIME + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_dayFormatter.formatDays(claimsTurnaroundTime));

		return success(response);
	}

	@GET
	@Path("/phone-stats")
	public Response getPhoneStats(
			@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
			@QueryParam("averageField") String averageField, @QueryParam("overallAvgField") String overallAvgField,
			@QueryParam("goalField") String goalField, @QueryParam("start") @DefaultValue("0") Integer start,
			@QueryParam("end") @DefaultValue("100") Integer end, @Context HttpServletRequest httpServletRequest) {

		try {
			_validateSLAChartParameters(averageField, overallAvgField, goalField);

			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			JSONObject responseObj = _chartsService.getAreaChartData(
				AMAnalyticsTelephony.class, currentUser.getTimeZone(), client.getExternalClientId(), startDate, endDate, start, end,
				_amaTelephonySerializer::serialize, averageField, OTHConstants.FIELD_AM_ANALYTICS_TELEPHONY_DATE,
				overallAvgField, goalField, this::_addPhoneStatsFields);

			return success(responseObj);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	private void _addClaimStatsFields(AddResponseFieldsParameters addResponseFieldsParameters) {
		JSONObject dataResponse = addResponseFieldsParameters.getResponseObject();

		dataResponse.put(
			OTHConstants.AVERAGE,
			_getFirstItemDoubleField(dataResponse, addResponseFieldsParameters.getOverallAvgFieldName()));

		String averageFormatted = _getFirstItemStringField(
			dataResponse, addResponseFieldsParameters.getOverallAvgFieldName() + OTHConstants.FIELD_FORMATTED_SUFFIX);

		dataResponse.put(OTHConstants.AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX, averageFormatted);

		BigDecimal total = addResponseFieldsParameters.getTotal();

		dataResponse.put(OTHConstants.TOTAL, new Long(total.longValue()));

		dataResponse.put(
			OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX, _dayFormatter.formatDays(total.doubleValue()));

		dataResponse.put(
			OTHConstants.GOAL, _getFirstItemDoubleField(dataResponse, addResponseFieldsParameters.getGoalFieldName()));

		String goalFormatted = _getFirstItemStringField(
			dataResponse, addResponseFieldsParameters.getGoalFieldName() + OTHConstants.FIELD_FORMATTED_SUFFIX);

		dataResponse.put(OTHConstants.GOAL + OTHConstants.FIELD_FORMATTED_SUFFIX, goalFormatted);
	}

	private void _addPhoneStatsFields(AddResponseFieldsParameters addResponseFieldsParameters) {
		JSONObject dataResponse = addResponseFieldsParameters.getResponseObject();

		String overallAvgFieldName = addResponseFieldsParameters.getOverallAvgFieldName();

		dataResponse.put(OTHConstants.AVERAGE, _getFirstItemDoubleField(dataResponse, overallAvgFieldName));

		String averageFormatted = _getFirstItemStringField(
			dataResponse, addResponseFieldsParameters.getOverallAvgFieldName() + OTHConstants.FIELD_FORMATTED_SUFFIX);

		dataResponse.put(OTHConstants.AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX, averageFormatted);

		BigDecimal total = addResponseFieldsParameters.getTotal();

		dataResponse.put(
			OTHConstants.TOTAL,
			_percentageFormatter.formatNumber(total.doubleValue(), OTHConstants.FORMAT_ONE_DECIMAL_PLACE));

		boolean formatSeconds = StringUtil.equalsIgnoreCase(
			overallAvgFieldName, OTHConstants.FIELD_OVERALL_AVG_SPEED_OF_ANSWER);

		String formattedTotal;

		if (formatSeconds) {
			formattedTotal = _dateFormatter.getFormattedSeconds(
				total.doubleValue(), OTHConstants.FORMAT_ONE_DECIMAL_PLACE);
		}
		else {
			formattedTotal = _percentageFormatter.formatDecimalForDisplay(
				total.doubleValue(), OTHConstants.FORMAT_ONE_DECIMAL_PLACE, true);
		}

		dataResponse.put(OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX, formattedTotal);

		dataResponse.put(
			OTHConstants.GOAL, _getFirstItemDoubleField(dataResponse, addResponseFieldsParameters.getGoalFieldName()));

		String goalFormatted = _getFirstItemStringField(
			dataResponse, addResponseFieldsParameters.getGoalFieldName() + OTHConstants.FIELD_FORMATTED_SUFFIX);

		dataResponse.put(OTHConstants.GOAL + OTHConstants.FIELD_FORMATTED_SUFFIX, goalFormatted);
	}

	private double _getFirstItemDoubleField(JSONObject dataResponse, String fieldName) {
		JSONObject firstItem = _getFirstItemInDataArray(dataResponse.getJSONArray(OTHConstants.DATA));

		if (Objects.nonNull(firstItem) && firstItem.has(fieldName)) {
			return firstItem.getDouble(fieldName);
		}

		return 0;
	}

	private JSONObject _getFirstItemInDataArray(JSONArray dataArray) {
		if (Objects.nonNull(dataArray) && (dataArray.length() > 0)) {
			return dataArray.getJSONObject(0);
		}

		return null;
	}

	private String _getFirstItemStringField(JSONObject dataResponse, String fieldName) {
		JSONObject firstItem = _getFirstItemInDataArray(dataResponse.getJSONArray(OTHConstants.DATA));

		if (Objects.nonNull(firstItem) && firstItem.has(fieldName)) {
			return firstItem.getString(fieldName);
		}

		return StringPool.BLANK;
	}

	private void _validateSLAChartParameters(String averageField, String overallAvgField, String goalField) {
		if (Validator.isBlank(averageField)) {
			throw new BadRequestException("averageField parameter is required");
		}

		if (Validator.isBlank(overallAvgField)) {
			throw new BadRequestException("overallAvgField parameter is required");
		}

		if (Validator.isBlank(goalField)) {
			throw new BadRequestException("goalField parameter is required");
		}
	}

	private static final String _CLAIMS_TURNAROUND_TIME = "claimsTurnaroundTime";

	@Reference
	private AMAClaimSerializer _amaClaimSerializer;

	@Reference
	private AMAnalyticsDBLocalService _amAnalyticsDBLocalService;

	@Reference
	private AMATelephonySerializer _amaTelephonySerializer;

	@Reference
	private ChartsService _chartsService;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private CompactNumberFormatter _compactNumberFormatter;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private DayFormatter _dayFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private PercentageFormatter _percentageFormatter;

	@Reference
	private UserLocalService _userLocalService;

}