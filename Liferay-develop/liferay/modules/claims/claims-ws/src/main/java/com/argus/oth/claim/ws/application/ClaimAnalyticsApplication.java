package com.argus.oth.claim.ws.application;

import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.charts.ChartsService;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.claim.service.ClaimAnalyticsLocalService;
import com.argus.oth.claim.ws.application.serializer.ClaimAnalyticsSerializer;
import com.argus.oth.common.CompactNumberFormatter;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.DayFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.OTHSearchHelper;
import com.argus.oth.common.PercentageFormatter;
import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.aggregation.Aggregations;
import com.liferay.portal.search.aggregation.bucket.Bucket;
import com.liferay.portal.search.aggregation.bucket.TermsAggregation;
import com.liferay.portal.search.aggregation.bucket.TermsAggregationResult;
import com.liferay.portal.search.aggregation.metrics.SumAggregation;
import com.liferay.portal.search.aggregation.metrics.SumAggregationResult;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
 * @author Jaclyn Ong
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/claim-analytics",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=ClaimAnalytics.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class ClaimAnalyticsApplication extends BaseWsApplication {

	@GET
	@Path("/chart-claims-aging")
	public Response getClaimAging(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate, @QueryParam("min") long min,
		@QueryParam("max") long max, @DefaultValue("0") @QueryParam("start") Integer start,
		@DefaultValue("0") @QueryParam("end") Integer end, @Context HttpServletRequest httpServletRequest) {

		try {
			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			JSONObject response = _chartsService.getClaimAging(
				currentUser.getTimeZone(), startDate, endDate, start, end, client.getExternalClientPk(), min);

			return success(response);
		}
		catch (IllegalStateException ise) {
			return failure(ise.getMessage());
		}
	}

	@GET
	@Path("/chart-claim-breakout-avg/closed")
	public Response getClaimAmountBreakoutBySavings(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@DefaultValue("0") @QueryParam("start") Integer start, @DefaultValue("0") @QueryParam("end") Integer end,
		@Context HttpServletRequest httpServletRequest) {

		Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

		User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

		try {
			return success(
				_chartsService.getClaimAmountBreakoutBySavings(
					currentUser.getTimeZone(), client.getExternalClientPk(), startDate, endDate, start, end));
		}
		catch (Exception ex) {
			return handleError(ex);
		}
	}

	@GET
	@Path("/status/{status:[a-zA-Z\\s]*}")
	public Response getClaimAnalyticsByStatus(
		@PathParam("status") String status, @QueryParam("startDate") Date startDate,
		@QueryParam("endDate") Date endDate, @DefaultValue("0") @QueryParam("start") Integer start,
		@DefaultValue("0") @QueryParam("end") Integer end, @Context HttpServletRequest httpServletRequest) {

		try {
			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			DateRange dateRange = _chartsService.getDateRange(startDate, endDate, currentUser.getTimeZone());

			Date convertedStartDate = dateRange.getStartDate();
			Date convertedEndDate = dateRange.getEndDate();

			SearchContext searchContext = new SearchContext();

			_setMinimalSearchContextFields(
				searchContext, convertedStartDate.getTime(), convertedEndDate.getTime(), client.getExternalClientPk());

			searchContext.setAttribute(OTHConstants.FIELD_CLAIM_STATUS, status);

			if ((start == 0) && (end == 0)) {
				searchContext.setStart(QueryUtil.ALL_POS);
				searchContext.setEnd(QueryUtil.ALL_POS);
			}

			JSONArray response = _claimAnalyticsSerializer.serialize(_claimAnalyticsLocalService.search(searchContext));

			return success(response);
		}
		catch (IllegalStateException ise) {
			return failure(ise.getMessage());
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/chart-claim-area")
	public Response getClaimAreaChartData(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@DefaultValue("0") @QueryParam("start") Integer start, @DefaultValue("0") @QueryParam("end") Integer end,
		@QueryParam("status") String status, @QueryParam("overallAvgField") String overallAvgField,
		@Context HttpServletRequest httpServletRequest) {

		try {
			if (Validator.isBlank(status)) {
				return failure("status is required");
			}

			if (Validator.isBlank(overallAvgField)) {
				return failure("overallAvgField is required");
			}

			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			Map<String, Function<Double, String>> sumFieldMap = new HashMap<>();

			sumFieldMap.put(OTHConstants.FIELD_CHARGED_AMOUNT, this::_formatAmountForClaimAreaChart);
			sumFieldMap.put(OTHConstants.FIELD_CLAIM_AGING, _dayFormatter::formatDays);
			sumFieldMap.put(OTHConstants.FIELD_FINANCIAL_EXPOSURE, this::_formatAmountForClaimAreaChart);
			sumFieldMap.put(OTHConstants.FIELD_SAVINGS_PERCENT, this::_formatPercentForClaimAreaChart);

			JSONObject responseObj = _chartsService.getClaimAreaChartData(
				ClaimAnalytics.class, currentUser.getTimeZone(), client.getExternalClientPk(), startDate, endDate,
				start, end, status, OTHConstants.ONE_DAY_INTERVAL, OTHSearchHelper::getCalcFieldActualValue, sumFieldMap,
				_othCommonHelper::formatClaims, OTHConstants.FIELD_RECEIVED_DATE, overallAvgField);

			return success(responseObj);
		}
		catch (IllegalStateException ise) {
			return failure(ise.getMessage());
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/chart-claim-breakout")
	public Response getClaimBreakoutData(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@DefaultValue("0") @QueryParam("start") Integer start, @DefaultValue("0") @QueryParam("end") Integer end,
		@QueryParam("status") String status, @QueryParam("sum") String sum, @QueryParam("term") String term,
		@Context HttpServletRequest httpServletRequest) {

		try {
			if (Validator.isBlank(status)) {
				return failure("status is required");
			}

			if (Validator.isBlank(sum)) {
				return failure("sum is required");
			}

			if (Validator.isBlank(term)) {
				return failure("term is required");
			}

			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			JSONObject responseObj;

			if (sum.equalsIgnoreCase(OTHConstants.FIELD_CLAIM_AGING)) {
				responseObj = _chartsService.getClaimBreakoutChartData(
					ClaimAnalytics.class, currentUser.getTimeZone(), client.getExternalClientPk(), status, startDate,
					endDate, start, end, sum, term, null, _dayFormatter::formatDays,
					this::_addToolTipFieldsForClaimAging);
			}
			else {
				responseObj = _chartsService.getClaimBreakoutChartData(
					ClaimAnalytics.class, currentUser.getTimeZone(), client.getExternalClientPk(), status, startDate,
					endDate, start, end, sum, term, OTHSearchHelper::getCalcFieldActualValue,
					_compactNumberFormatter::format, this::_addToolTipFieldsForClaimAmount);
			}

			return success(responseObj);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	@GET
	@Path("/chart-claim-stacked-area")
	public Response getClaimStackedAreaChartData(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@DefaultValue("0") @QueryParam("start") Integer start, @DefaultValue("0") @QueryParam("end") Integer end,
		@QueryParam("volume") boolean volume, @Context HttpServletRequest httpServletRequest) {

		try {
			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			JSONObject responseObj = _chartsService.getStackedAreaChartData(
				ClaimAnalytics.class, currentUser.getTimeZone(), client.getExternalClientPk(), startDate, endDate,
				start, end, OTHConstants.FIELD_FINANCIAL_EXPOSURE, OTHConstants.FIELD_RECEIVED_DATE,
				OTHConstants.ONE_DAY_INTERVAL, this::_formatAmountForClaimAreaChart, _othCommonHelper::formatClaims, volume);

			return success(responseObj);
		}
		catch (IllegalStateException ise) {
			return failure(ise.getMessage());
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	@GET
	@Path("/chart-providers-claims")
	public Response getProvidersClaims(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@DefaultValue("0") @QueryParam("start") Integer start, @DefaultValue("0") @QueryParam("end") Integer end,
		@QueryParam("field") String field, @Context HttpServletRequest httpServletRequest) {

		try {
			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			String aggregationName = OTHConstants.AGGREGATION_FINANCIAL_EXPOSURE_SUM;

			if (StringUtil.equals(field, OTHConstants.FIELD_SAVINGS_AMOUNT)) {
				aggregationName = OTHConstants.AGGREGATION_SAVINGS_SUM;
			}

			return success(
				_chartsService.getProvidersChartData(
					client.getExternalClientPk(), aggregationName, startDate, endDate, currentUser.getTimeZone(), start,
					end));
		}
		catch (IllegalStateException ise) {
			return failure(ise.getMessage());
		}
	}

	@GET
	@Path("/chart-recent-claims")
	public Response getRecentClaimsData(
		@Context HttpServletRequest httpServletRequest, @QueryParam("pastWeeksDifference") String pastWeeksDifference) {

		try {
			Client client = getClient(httpServletRequest, _userLocalService, _clientLocalService);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			SearchRequest searchRequest = _buildRecentClaimsSearchRequest(
				client.getExternalClientPk(), pastWeeksDifference, currentUser.getTimeZone());

			SearchResponse searchResponse = _searcher.search(searchRequest);

			JSONObject dataResponse = _buildRecentClaimsResponse(searchResponse);

			return success(dataResponse);
		}
		catch (IllegalStateException ise) {
			return failure(ise.getMessage());
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	private void _addToolTipFieldsForClaim(JSONObject dataResponse, JSONObject dataObject) {
		dataObject.put(
			OTHConstants.FIELD_DATE_RANGE,
			String.format(
				"%s - %s", dataResponse.getString(OTHConstants.FIELD_START_DATE),
				dataResponse.getString(OTHConstants.FIELD_END_DATE)));
		dataObject.put(
			OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX,
			dataResponse.get(OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX));
		dataObject.put(OTHConstants.TOTAL_COUNT, dataResponse.get(OTHConstants.TOTAL_COUNT));
	}

	private void _addToolTipFieldsForClaimAging(JSONObject dataResponse) {
		JSONArray dataArray = dataResponse.getJSONArray(OTHConstants.DATA);

		for (int i = 0; i < dataArray.length(); ++i) {
			JSONObject dataObject = dataArray.getJSONObject(i);

			_addToolTipFieldsForClaim(dataResponse, dataObject);

			dataObject.put(
				OTHConstants.AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX,
				dataResponse.get(OTHConstants.AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX));
		}
	}

	private void _addToolTipFieldsForClaimAmount(JSONObject dataResponse) {
		JSONArray dataArray = dataResponse.getJSONArray(OTHConstants.DATA);

		for (int i = 0; i < dataArray.length(); ++i) {
			JSONObject dataObject = dataArray.getJSONObject(i);

			_addToolTipFieldsForClaim(dataResponse, dataObject);
		}
	}

	private JSONObject _buildRecentClaimsResponse(SearchResponse searchResponse) {
		TermsAggregationResult termsAggregationResult = (TermsAggregationResult)searchResponse.getAggregationResult(
			_AGG_NAME_STATUS);

		JSONObject dataResponse = _jsonFactory.createJSONObject();

		if (Objects.isNull(termsAggregationResult)) {
			return dataResponse;
		}

		JSONArray dataArray = _jsonFactory.createJSONArray();
		JSONObject totalsObj = _jsonFactory.createJSONObject();

		double total = 0;

		for (String status : OTHConstants.CLAIM_STATUSES) {
			Bucket bucket = termsAggregationResult.getBucket(status);

			double value = 0;

			if (Objects.nonNull(bucket)) {
				SumAggregationResult sumAggregationResult = (SumAggregationResult)bucket.getChildAggregationResult(
					_AGG_NAME_SUM);

				if (Objects.nonNull(sumAggregationResult)) {
					value = OTHSearchHelper.getCalcFieldActualValue(sumAggregationResult.getValue());

					total += value;
				}
			}

			totalsObj.put(status, _compactNumberFormatter.format(value));

			JSONObject dataPointObj = _jsonFactory.createJSONObject();

			dataPointObj.put("name", status);
			dataPointObj.put("value", value);

			dataArray.put(dataPointObj);
		}

		dataResponse.put("claimTotals", totalsObj);
		dataResponse.put("data", dataArray);
		dataResponse.put("total", _compactNumberFormatter.format(total));

		return dataResponse;
	}

	private SearchRequest _buildRecentClaimsSearchRequest(
		long externalClientPk, String pastWeeksDifference, TimeZone timeZone) {

		SearchRequestBuilder searchRequestBuilder = _searchRequestBuilderFactory.builder();

		return searchRequestBuilder.addAggregation(
			_getStatusTermsAggregation()
		).entryClassNames(
			ClaimAnalytics.class.getName()
		).modelIndexerClasses(
			ClaimAnalytics.class
		).withSearchContext(
			searchContext -> _setRecentClaimsSearchContext(
				searchContext, externalClientPk, pastWeeksDifference, timeZone)
		).build();
	}

	private String _formatAmountForClaimAreaChart(double number) {
		return _compactNumberFormatter.format(number, 2, 2);
	}

	private String _formatPercentForClaimAreaChart(double number) {
		return _percentageFormatter.formatWholeNumberForDisplay(number, false);
	}

	private TermsAggregation _getStatusTermsAggregation() {
		SumAggregation sumAggregation = _aggregations.sum(
			_AGG_NAME_SUM, Field.getSortableFieldName(OTHConstants.FIELD_FINANCIAL_EXPOSURE));

		TermsAggregation termsAggregation = _aggregations.terms(
			_AGG_NAME_STATUS, OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_CLAIM_STATUS));

		termsAggregation.addChildAggregation(sumAggregation);

		return termsAggregation;
	}

	private void _setMinimalSearchContextFields(
		SearchContext searchContext, long startDate, long endDate, long externalClientPk) {

		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		searchContext.setStart(0);
		searchContext.setEnd(0);
		searchContext.setAttribute(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, String.valueOf(externalClientPk));
		searchContext.setAttribute(OTHConstants.FIELD_START_DATE, startDate);
		searchContext.setAttribute(OTHConstants.FIELD_END_DATE, endDate);
	}

	private void _setRecentClaimsSearchContext(
		SearchContext searchContext, long externalClientPk, String pastWeeksDifference, TimeZone timeZone) {

		Date now = new Date();

		Date nowInTimeZone = _dateFormatter.convertToTimeZone(now, timeZone);

		Calendar calendar = CalendarFactoryUtil.getCalendar(nowInTimeZone.getTime());

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		long endDate = calendar.getTimeInMillis();

		int pastWeeksDifferenceInt = GetterUtil.getInteger(pastWeeksDifference, _DEFAULT_PAST_WEEKS_DIFFERENCE);

		if (pastWeeksDifferenceInt > 0) {
			pastWeeksDifferenceInt *= -1;
		}

		calendar.add(Calendar.DAY_OF_YEAR, (pastWeeksDifferenceInt * _DAYS_PER_WEEK) + 1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		long startDate = calendar.getTimeInMillis();

		_setMinimalSearchContextFields(searchContext, startDate, endDate, externalClientPk);
	}

	private static final String _AGG_NAME_STATUS = "status_agg";

	private static final String _AGG_NAME_SUM = "sum_agg";

	private static final int _DAYS_PER_WEEK = 7;

	private static final int _DEFAULT_PAST_WEEKS_DIFFERENCE = 4;

	@Reference
	private Aggregations _aggregations;

	@Reference
	private ChartsService _chartsService;

	@Reference
	private ClaimAnalyticsLocalService _claimAnalyticsLocalService;

	@Reference
	private ClaimAnalyticsSerializer _claimAnalyticsSerializer;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private CompactNumberFormatter _compactNumberFormatter;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private DayFormatter _dayFormatter;

	@Reference
	private IndexerRegistry _indexerRegistry;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private PercentageFormatter _percentageFormatter;

	@Reference
	private Searcher _searcher;

	@Reference
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;

	@Reference
	private UserLocalService _userLocalService;

}