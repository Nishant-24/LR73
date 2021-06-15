package com.argus.oth.charts.service;

import com.argus.oth.charts.ChartsService;
import com.argus.oth.charts.model.AddResponseFieldsParameters;
import com.argus.oth.charts.model.AddResponseFieldsParametersImpl;
import com.argus.oth.charts.service.helper.ChartDateObjBuilder;
import com.argus.oth.charts.service.helper.ChartResponseBuilder;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.common.CompactNumberFormatter;
import com.argus.oth.common.DayFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.OTHSearchHelper;
import com.argus.oth.common.PercentageFormatter;
import com.argus.oth.common.helper.OTHCommonHelper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.aggregation.Aggregation;
import com.liferay.portal.search.aggregation.AggregationResult;
import com.liferay.portal.search.aggregation.bucket.Bucket;
import com.liferay.portal.search.aggregation.bucket.DateHistogramAggregation;
import com.liferay.portal.search.aggregation.bucket.DateHistogramAggregationResult;
import com.liferay.portal.search.aggregation.bucket.Order;
import com.liferay.portal.search.aggregation.bucket.TermsAggregation;
import com.liferay.portal.search.aggregation.bucket.TermsAggregationResult;
import com.liferay.portal.search.aggregation.metrics.AvgAggregation;
import com.liferay.portal.search.aggregation.metrics.AvgAggregationResult;
import com.liferay.portal.search.aggregation.metrics.SumAggregation;
import com.liferay.portal.search.aggregation.metrics.SumAggregationResult;
import com.liferay.portal.search.aggregation.pipeline.BucketSortPipelineAggregation;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.sort.FieldSort;
import com.liferay.portal.search.sort.SortBuilder;
import com.liferay.portal.search.sort.SortOrder;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.function.Consumer;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ChartsService.class)
public class ChartsServiceImpl extends BaseChartsServiceImpl implements AopService, ChartsService {

	@Override
	public JSONObject getAreaChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end,
		Function<Document, JSONObject> serializeFunction, String fieldName, String dateFieldName,
		String overallAvgFieldName, String goalFieldName, Consumer<AddResponseFieldsParameters> addResponseFields) {

		try {
			DateRange dateRange = getDateRange(startDate, endDate, timeZone);

			ObjectValuePair<Long, Long> dateRangeInMillis = _getDateRange(dateRange);

			Map<String, Serializable> searchContextAttributes = new HashMap<>();

			searchContextAttributes.put(OTHConstants.FIELD_CLIENT_ID, clientId);

			SearchResponse searchResponse = search(
				clazz, dateRangeInMillis, searchContextAttributes,
				sorts.field(Field.getSortableFieldName(dateFieldName), SortOrder.ASC), start, end);

			return _buildAreaChartResponse(
				searchResponse, serializeFunction, fieldName, overallAvgFieldName, goalFieldName, addResponseFields);
		}
		catch (Exception pe) {
			_log.error("Failed to get area chart data for " + clazz.getName(), pe);

			return jsonFactory.createJSONObject();
		}
	}

	@Override
	public JSONObject getClaimAging(
		TimeZone timeZone, Date startDate, Date endDate, int start, int end, long externalClientPk, long min) {

		DateRange dateRange = getDateRange(startDate, endDate, timeZone);

		SearchRequest request = _buildClaimsAgingSearchRequest(
			dateRange.getStartDate(), dateRange.getEndDate(), externalClientPk, start, end);

		SearchResponse response = searcher.search(request);

		return _buildClaimsAgingResponse(response, dateRange.getStartDate(), dateRange.getEndDate(), min);
	}

	@Override
	public JSONObject getClaimAmountBreakoutBySavings(
		TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end) {

		DateRange dateRange = getDateRange(startDate, endDate, timeZone);

		ObjectValuePair<Long, Long> dateRangeInMillis = _getDateRange(dateRange);

		TermsAggregation avgAggregation = _getAvgAggregation(
			OTHConstants.FIELD_SAVINGS_PERCENT, OTHConstants.FIELD_CHARGED_RANGE, SortOrder.DESC);

		SumAggregation sumAggregation = aggregations.sum(
			OTHConstants.FIELD_SAVINGS_AMOUNT, OTHConstants.SAVINGS_AMOUNT_SORTABLE);

		AvgAggregation savingsPctAvgAggregation = aggregations.avg(
			OTHConstants.SAVINGS_PERCENT_AVG_AGG, OTHConstants.SAVINGS_PERCENT_SORTABLE);

		avgAggregation.addChildAggregation(sumAggregation);

		TermsAggregation countAggregation = _getTermsAggregation(OTHConstants.FIELD_SAVINGS_PERCENT, true);

		countAggregation.addOrders(Order.key(true));

		countAggregation.setSize(OTHConstants.AGG_MAX_COUNT_BUCKET_SIZE);

		_addSumAggregations(countAggregation, OTHConstants.FIELD_SAVINGS_AMOUNT);

		DateHistogramAggregation dateHistogramAggregation = _getDateHistogramAggregation(
			OTHConstants.FIELD_RECEIVED_DATE, dateRangeInMillis.getKey(), dateRangeInMillis.getValue(),
			OTHConstants.ONE_DAY_INTERVAL);

		SearchRequest searchRequest = buildClaimStatusSearchRequest(
			ClaimAnalytics.class, clientId, OTHConstants.STATUS_CLOSED, dateRange.getStartDate(),
			dateRange.getEndDate(), start, end, null, null, avgAggregation, countAggregation, sumAggregation,
			savingsPctAvgAggregation, dateHistogramAggregation);

		SearchResponse searchResponse = searcher.search(searchRequest);

		return _buildClaimAmountBreakoutBySavings(searchResponse, dateRange.getStartDate(), dateRange.getEndDate());
	}

	@Override
	public JSONObject getClaimAreaChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end,
		String status, String interval, Function<Double, Double> parseValueFunction,
		Map<String, Function<Double, String>> sumFieldMap, Function<Long, String> formatCountFunction, String termField,
		String overallAvgFieldName) {

		try {
			DateRange dateRange = getDateRange(startDate, endDate, timeZone);

			ObjectValuePair<Long, Long> dateRangeInMillis = _getDateRange(dateRange);

			DateHistogramAggregation dateHistogramAggregation = _getDateHistogramAggregation(
				termField, dateRangeInMillis.getKey(), dateRangeInMillis.getValue(), interval);

			SumAggregation financialExposureAggregation = aggregations.sum(
				overallAvgFieldName, Field.getSortableFieldName(overallAvgFieldName));

			Set<String> keys = sumFieldMap.keySet();

			_addSumAggregations(dateHistogramAggregation, keys.toArray(new String[sumFieldMap.size()]));

			SearchResponse searchResponse = search(
				clazz, dateRangeInMillis, _getClaimSearchContextAttributes(clientId, status.toLowerCase()), null, start,
				end, dateHistogramAggregation, financialExposureAggregation);

			return _buildAreaChartSumAggregateResponse(
				searchResponse, termField, overallAvgFieldName, dateRange.getStartDate(), dateRange.getEndDate(),
				parseValueFunction, formatCountFunction, sumFieldMap);
		}
		catch (Exception pe) {
			_log.error("Failed to get area chart data for " + clazz.getName(), pe);

			return jsonFactory.createJSONObject();
		}
	}

	@Override
	public JSONObject getClaimBreakoutChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, String status, Date startDate, Date endDate, int start,
		int end, String sumFieldName, String termFieldName, Function<Double, Double> parseValueFunction,
		Function<Double, String> formatValueFunction, Consumer<JSONObject> addToolTipFieldsConsumer) {

		try {
			DateRange dateRange = getDateRange(startDate, endDate, timeZone);

			ObjectValuePair<Long, Long> dateRangeInMillis = _getDateRange(dateRange);

			TermsAggregation sumAggregation = _getSumAggregation(termFieldName, sumFieldName);

			if (StringUtil.equals(status, OTHConstants.STATUS_IN_PROGRESS)) {
				AvgAggregation claimAgingAvgAggregation = aggregations.avg(
					OTHConstants.CLAIM_AGING_AVG_AGG, OTHConstants.CLAIM_AGING_SORTABLE);

				sumAggregation.addChildAggregation(claimAgingAvgAggregation);
			}
			else if (StringUtil.equals(status, OTHConstants.STATUS_CLOSED)) {
				AvgAggregation savingsAmtAvgAggregation = aggregations.avg(
					OTHConstants.SAVINGS_PERCENT_AVG_AGG, OTHConstants.SAVINGS_PERCENT_SORTABLE);

				sumAggregation.addChildAggregation(savingsAmtAvgAggregation);
			}

			SearchResponse searchResponse = search(
				clazz, dateRangeInMillis, _getClaimSearchContextAttributes(clientId, status.toLowerCase()), null, start,
				end, sumAggregation);

			return _buildSumAggregateResponse(
				searchResponse, sumFieldName, termFieldName, _CURRENCY_RANGES, parseValueFunction, formatValueFunction,
				addToolTipFieldsConsumer, dateRange.getStartDate(), dateRange.getEndDate());
		}
		catch (Exception pe) {
			_log.error("Failed to get donut chart data for " + clazz.getName(), pe);

			return jsonFactory.createJSONObject();
		}
	}

	@Override
	public JSONObject getProvidersChartData(
		long externalClientPk, String aggregationName, Date startDate, Date endDate, TimeZone timeZone, int start,
		int end) {

		try {
			DateRange dateRange = getDateRange(startDate, endDate, timeZone);

			ObjectValuePair<Long, Long> dateRangeInMillis = _getDateRange(dateRange);

			SearchResponse response = search(
				ClaimAnalytics.class, dateRangeInMillis, _getClaimSearchContextAttributes(externalClientPk, null), null,
				start, end, _getProvidersClaimsAggregation(aggregationName));

			return _buildProvidersClaimsResponse(response, dateRange.getStartDate(), dateRange.getEndDate());
		}
		catch (Exception pe) {
			_log.error("Failed to get provider donut chart data for " + ClaimAnalytics.class.getName(), pe);

			return jsonFactory.createJSONObject();
		}
	}

	public JSONObject getStackedAreaChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end,
		String fieldName, String dateFieldName, String interval, Function<Double, String> formatValueFunction,
		Function<Long, String> formatCountFunction, boolean volume) {

		try {
			DateRange dateRange = getDateRange(startDate, endDate, timeZone);

			ObjectValuePair<Long, Long> dateRangeInMillis = _getDateRange(dateRange);

			Map<String, Serializable> searchContextAttributes = new HashMap<>();

			searchContextAttributes.put(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, clientId);

			SearchResponse searchResponse = search(
				clazz, dateRangeInMillis, searchContextAttributes, null, start, end,
				_getStackedAreaChartAggregation(fieldName, dateFieldName, dateRangeInMillis, interval));

			return _buildStackedAreaChartResponse(
				searchResponse, fieldName, dateFieldName, formatValueFunction, formatCountFunction, volume);
		}
		catch (Exception pe) {
			_log.error("Failed to get stacked area chart data for " + clazz.getName(), pe);

			return jsonFactory.createJSONObject();
		}
	}

	private void _addClaimAgingNode(
		ArrayList<JSONObject> dataArray, Integer index, Long count, Long claimAge, double chargedAmount) {

		JSONObject agingNode = jsonFactory.createJSONObject();

		agingNode.put(_CLAIM_AGE, claimAge);
		agingNode.put(_CLAIM_AGE + OTHConstants.FIELD_FORMATTED_SUFFIX, _dayFormatter.formatDays(claimAge));
		agingNode.put(OTHConstants.COUNT, count);
		agingNode.put(OTHConstants.COUNT + OTHConstants.FIELD_FORMATTED_SUFFIX, _othCommonHelper.formatClaims(count));
		agingNode.put(
			OTHConstants.FIELD_CHARGED_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			compactNumberFormatter.format(chargedAmount, 2, 2));

		if (Objects.nonNull(index)) {
			dataArray.add(index, agingNode);

			return;
		}

		dataArray.add(agingNode);
	}

	private void _addClaimAreaChartDateObjFields(
		BigDecimal average, double value, String key, Function<Double, String> formatValueFunction,
		Bucket dateHistogramBucket, ChartDateObjBuilder chartDateObjBuilder) {

		String formattedAverage;

		if (StringUtil.equalsIgnoreCase(key, OTHConstants.FIELD_CLAIM_AGING)) {
			formattedAverage = dayFormatter.formatDays(average.doubleValue(), false);
		}
		else {
			formattedAverage = formatValueFunction.apply(average.doubleValue());
		}

		chartDateObjBuilder.updateDateObj(
			key, value
		).updateDateObj(
			key + OTHConstants.FIELD_FORMATTED_SUFFIX, formatValueFunction.apply(value)
		).updateDateObj(
			key + OTHConstants.AVERAGE_SUFFIX, average
		).updateDateObj(
			key + OTHConstants.AVERAGE_SUFFIX + OTHConstants.FIELD_FORMATTED_SUFFIX, formattedAverage
		).setDateBucketCount(
			dateHistogramBucket.getDocCount()
		);
	}

	private void _addClaimAreaChartOverallAvgFields(
		double total, int count, Function<Double, String> formatValueFunction, String overallAvgFieldName,
		ChartResponseBuilder chartResponseBuilder) {

		double average = total / count;

		chartResponseBuilder.updateResponseObj(OTHConstants.AVERAGE, average);

		if (StringUtil.equalsIgnoreCase(overallAvgFieldName, OTHConstants.FIELD_CLAIM_AGING)) {
			chartResponseBuilder.updateResponseObj(
				OTHConstants.AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX, dayFormatter.formatDays(average, true));
		}
		else {
			chartResponseBuilder.updateResponseObj(
				OTHConstants.AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX, formatValueFunction.apply(average));
		}
	}

	private void _addClaimSavingsNode(
		ArrayList<JSONObject> dataArray, Integer index, Long count, double savingsPercent, double savingsAmount) {

		JSONObject claimSavingsNode = jsonFactory.createJSONObject();

		claimSavingsNode.put(_SAVINGS_PERCENTAGE, savingsPercent);
		claimSavingsNode.put(
			_SAVINGS_PERCENTAGE + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_percentageFormatter.formatWholeNumberForDisplay(savingsPercent, false));
		claimSavingsNode.put(OTHConstants.COUNT, count);
		claimSavingsNode.put(
			OTHConstants.COUNT + OTHConstants.FIELD_FORMATTED_SUFFIX, _othCommonHelper.formatClaims(count));
		claimSavingsNode.put(
			OTHConstants.FIELD_SAVINGS_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			compactNumberFormatter.format(savingsAmount, 2, 2));

		if (Objects.nonNull(index)) {
			dataArray.add(index, claimSavingsNode);

			return;
		}

		dataArray.add(claimSavingsNode);
	}

	private void _addResponseFields(
		JSONObject dataResponse, String overallAvgFieldName, String goalFieldName, BigDecimal total,
		BigDecimal totalCount, Consumer<AddResponseFieldsParameters> addResponseFields) {

		if (Objects.isNull(addResponseFields)) {
			return;
		}

		AddResponseFieldsParametersImpl addResponseFieldsParameters = new AddResponseFieldsParametersImpl();

		addResponseFieldsParameters.setResponseObject(dataResponse);
		addResponseFieldsParameters.setOverallAvgFieldName(overallAvgFieldName);
		addResponseFieldsParameters.setTotal(total);
		addResponseFieldsParameters.setGoalFieldName(goalFieldName);
		addResponseFieldsParameters.setTotalCount(totalCount);

		addResponseFields.accept(addResponseFieldsParameters);
	}

	private void _addSumAggregations(Aggregation aggregation, String... sumFieldNames) {
		for (String sumFieldName : sumFieldNames) {
			SumAggregation sumAggregation = aggregations.sum(
				OTHSearchHelper.getAggregationFieldName(sumFieldName), Field.getSortableFieldName(sumFieldName));

			aggregation.addChildAggregation(sumAggregation);
		}
	}

	private void _buildAreaChartDateObj(
		String dateFieldName, long dateInMillis, Function<Long, String> formatCountFunction,
		ChartDateObjBuilder chartDateObjBuilder) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(dateInMillis);

		chartDateObjBuilder.updateDateObj(
			dateFieldName, dateFormatter.getISODateString(calendar.getTime())
		).updateDateObj(
			dateFieldName + OTHConstants.MMM_DD_SUFFIX,
			dateFormatter.getFormattedDate(calendar.getTime(), OTHConstants.DATE_PATTERN_MMM_DD, StringPool.BLANK)
		).updateDateObj(
			dateFieldName + OTHConstants.MMM_DD_YYYY_SUFFIX,
			dateFormatter.getFormattedDate(calendar.getTime(), OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK)
		).updateDateObj(
			OTHConstants.COUNT, chartDateObjBuilder.getDateBucketCount()
		).updateDateObj(
			OTHConstants.COUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			formatCountFunction.apply(chartDateObjBuilder.getDateBucketCount())
		);
	}

	private ChartDateObjBuilder _buildAreaChartDateObjSumFields(
		Bucket dateHistogramBucket, long dateInMillis, String termFieldName,
		Function<Double, Double> parseValueFunction, Function<Long, String> formatCountFunction,
		Map<String, Function<Double, String>> sumFieldMap) {

		ChartDateObjBuilder chartDateObjBuilder = new ChartDateObjBuilder(
			jsonFactory.createJSONObject()
		).setDateBucketCount(
			0L
		);

		for (Map.Entry<String, Function<Double, String>> sumField : sumFieldMap.entrySet()) {
			_processClaimAreaChartSumResult(sumField, dateHistogramBucket, parseValueFunction, chartDateObjBuilder);
		}

		_buildAreaChartDateObj(termFieldName, dateInMillis, formatCountFunction, chartDateObjBuilder);

		return chartDateObjBuilder;
	}

	private JSONObject _buildAreaChartResponse(
		SearchResponse searchResponse, Function<Document, JSONObject> serializeFunction, String fieldName,
		String overallAvgFieldName, String goalFieldName, Consumer<AddResponseFieldsParameters> addResponseFields) {

		JSONObject dataResponse = jsonFactory.createJSONObject();

		SearchHits searchHits = searchResponse.getSearchHits();

		if (Objects.isNull(searchHits)) {
			return dataResponse;
		}

		JSONArray dataPointsArray = jsonFactory.createJSONArray();

		BigDecimal total = BigDecimal.ZERO;

		for (SearchHit searchHit : searchHits.getSearchHits()) {
			Document document = searchHit.getDocument();

			if (Objects.isNull(document)) {
				continue;
			}

			Map<String, com.liferay.portal.search.document.Field> fields = document.getFields();

			if (fields.containsKey(fieldName)) {
				total = total.add(new BigDecimal(document.getDouble(fieldName)));
			}

			JSONObject jsonObject = serializeFunction.apply(document);

			dataPointsArray.put(jsonObject);
		}

		dataResponse.put(OTHConstants.DATA, dataPointsArray);

		_addResponseFields(dataResponse, overallAvgFieldName, goalFieldName, total, null, addResponseFields);

		return dataResponse;
	}

	private JSONObject _buildAreaChartSumAggregateResponse(
		SearchResponse searchResponse, String termFieldName, String overallAvgFieldName, Date startDate, Date endDate,
		Function<Double, Double> parseValueFunction, Function<Long, String> formatCountFunction,
		Map<String, Function<Double, String>> sumFieldMap) {

		DateHistogramAggregationResult dateHistogramAggregationResult =
			(DateHistogramAggregationResult)searchResponse.getAggregationResult(
				OTHSearchHelper.getAggregationFieldName(termFieldName));

		JSONObject dataResponse = jsonFactory.createJSONObject();

		if (Objects.isNull(dateHistogramAggregationResult)) {
			return dataResponse;
		}

		Collection<Bucket> dateHistogramBuckets = dateHistogramAggregationResult.getBuckets();

		ChartResponseBuilder chartResponseBuilder = new ChartResponseBuilder(
			dataResponse
		).setDataArray(
			jsonFactory.createJSONArray()
		).setAverage(
			BigDecimal.ZERO
		).setCountAverage(
			(int)Math.round((double)searchResponse.getCount() / dateHistogramBuckets.size())
		).setTotalCount(
			GetterUtil.getInteger(searchResponse.getCount())
		);

		for (Bucket dateHistogramBucket : dateHistogramBuckets) {
			ChartDateObjBuilder chartDateObjBuilder = _buildAreaChartDateObjSumFields(
				dateHistogramBucket, GetterUtil.getLong(dateHistogramBucket.getKey()), termFieldName,
				parseValueFunction, formatCountFunction, sumFieldMap);

			chartResponseBuilder.addToDataArray(chartDateObjBuilder.getDateObj());
		}

		chartResponseBuilder.updateResponseObj(
			OTHConstants.DATA, chartResponseBuilder.getDataArray()
		).updateResponseObj(
			OTHConstants.COUNT + OTHConstants.AVERAGE_SUFFIX, chartResponseBuilder.getCountAverage()
		).updateResponseObj(
			OTHConstants.COUNT, chartResponseBuilder.getTotalCount()
		).updateResponseObj(
			OTHConstants.FIELD_DATE_RANGE, dateFormatter.getFormattedDateRange(startDate, endDate)
		);

		SumAggregationResult sumAggregationResult = (SumAggregationResult)searchResponse.getAggregationResult(
			overallAvgFieldName);

		if (Objects.nonNull(sumAggregationResult)) {
			double value = parseValueFunction.apply(sumAggregationResult.getValue());

			Function<Double, String> formatSumFieldFunction = sumFieldMap.get(overallAvgFieldName);

			chartResponseBuilder.updateResponseObj(
				OTHConstants.TOTAL, value
			).updateResponseObj(
				OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX, formatSumFieldFunction.apply(value)
			);

			_addClaimAreaChartOverallAvgFields(
				value, dateHistogramBuckets.size(), formatSumFieldFunction, overallAvgFieldName, chartResponseBuilder);
		}

		return chartResponseBuilder.getResponseObj();
	}

	private JSONObject _buildClaimAmountBreakoutBySavings(SearchResponse searchResponse, Date startDate, Date endDate) {
		TermsAggregationResult chargedRangeAgg = (TermsAggregationResult)searchResponse.getAggregationResult(
			OTHConstants.CHARGED_RANGE_AGG);

		TermsAggregationResult savingsAgg = (TermsAggregationResult)searchResponse.getAggregationResult(
			OTHConstants.SAVINGS_PERCENT_AGG);

		JSONObject dataResponse = jsonFactory.createJSONObject();

		if (Objects.isNull(chargedRangeAgg) || Objects.isNull(savingsAgg)) {
			return dataResponse;
		}

		JSONObject data = jsonFactory.createJSONObject();

		data.put(OTHConstants.FIELD_DATE_RANGE, dateFormatter.getFormattedDateRange(startDate, endDate));

		JSONArray chargedRanges = _getChargedRanges(chargedRangeAgg);

		data.put(_CHARGED_RANGES, chargedRanges);

		JSONArray savingRanges = jsonFactory.createJSONArray();

		Collection<Bucket> buckets = savingsAgg.getBuckets();

		ArrayList<JSONObject> claimSavingNodes = new ArrayList<>();

		_putClaimSavingsNodes(searchResponse, buckets, claimSavingNodes, data);

		double avgXValue = 0;

		if (!buckets.isEmpty()) {
			AvgAggregationResult savingsPctAvgAggregationResult =
				(AvgAggregationResult)searchResponse.getAggregationResult(OTHConstants.SAVINGS_PERCENT_AVG_AGG);

			avgXValue = OTHSearchHelper.getCalcFieldActualValue(savingsPctAvgAggregationResult.getValue());
		}

		data.put(_AVERAGE_X, avgXValue);

		data.put(
			_AVERAGE_X + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_percentageFormatter.formatWholeNumberForDisplay(avgXValue, false));

		data.put(
			OTHConstants.FIELD_SAVINGS_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			_getClaimAmountBreakoutTotalSavings(searchResponse));

		for (JSONObject claimSavingNode : claimSavingNodes) {
			savingRanges.put(claimSavingNode);
		}

		data.put(_SAVING_RANGES, savingRanges);

		dataResponse.put(OTHConstants.DATA, data);

		return dataResponse;
	}

	private JSONObject _buildClaimsAgingResponse(SearchResponse response, Date startDate, Date endDate, long min) {
		TermsAggregationResult aggregationResult = (TermsAggregationResult)response.getAggregationResult(
			OTHConstants.CLAIM_AGING_AGG);

		JSONObject dataResponse = jsonFactory.createJSONObject();

		if (Objects.isNull(aggregationResult)) {
			return dataResponse;
		}

		JSONArray agingArray = jsonFactory.createJSONArray();

		Long totalClaims = 0L;

		boolean hasBeginningNode = false;

		Collection<Bucket> buckets = aggregationResult.getBuckets();

		ArrayList<JSONObject> agingNodes = new ArrayList<>();

		for (Bucket b : buckets) {
			Long keyLong = GetterUtil.get(b.getKey(), 0L);

			if (!hasBeginningNode) {
				hasBeginningNode = keyLong == min;
			}

			AggregationResult aggregationResultSum = b.getChildAggregationResult(OTHConstants.CHARGED_AMOUNT_AGG);

			SumAggregationResult sumAggregationResult = (SumAggregationResult)aggregationResultSum;

			double chargedAmount = 0;

			if (Objects.nonNull(aggregationResultSum)) {
				chargedAmount = OTHSearchHelper.getCalcFieldActualValue(sumAggregationResult.getValue());
			}

			_addClaimAgingNode(agingNodes, null, b.getDocCount(), keyLong, chargedAmount);

			totalClaims += b.getDocCount();
		}

		if (!hasBeginningNode) {
			_addClaimAgingNode(agingNodes, 0, 0L, min, 0);
		}

		for (JSONObject agingNode : agingNodes) {
			agingArray.put(agingNode);
		}

		BigDecimal avgYBigDecimal = BigDecimal.ZERO;
		BigDecimal avgXBigDecimal = BigDecimal.ZERO;

		if (!buckets.isEmpty()) {
			BigDecimal totalClaimsBigDecimal = new BigDecimal(totalClaims);

			DateHistogramAggregationResult dateHistogramAggregationResult =
				(DateHistogramAggregationResult)response.getAggregationResult(OTHConstants.RECEIVED_DATE_AGG);

			if (Objects.nonNull(dateHistogramAggregationResult) &&
				Objects.nonNull(dateHistogramAggregationResult.getBuckets())) {

				avgYBigDecimal = totalClaimsBigDecimal.divide(
					new BigDecimal(
						dateHistogramAggregationResult.getBuckets(
						).size()),
					BigDecimal.ROUND_HALF_UP);
			}

			AvgAggregationResult avgAggregationResult = (AvgAggregationResult)response.getAggregationResult(
				OTHConstants.CLAIM_AGING_AVG_AGG);

			avgXBigDecimal = BigDecimal.valueOf(
				avgAggregationResult.getValue()
			).setScale(
				0, RoundingMode.HALF_UP
			);
		}

		dataResponse.put(_AVERAGE_X, avgXBigDecimal.doubleValue());
		dataResponse.put(_AVERAGE_Y, avgYBigDecimal.doubleValue());
		dataResponse.put(OTHConstants.DATA, agingArray);
		dataResponse.put(OTHConstants.FIELD_DATE_RANGE, dateFormatter.getFormattedDateRange(startDate, endDate));

		return dataResponse;
	}

	private SearchRequest _buildClaimsAgingSearchRequest(
		Date startDate, Date endDate, long externalClientPk, int start, int end) {

		TermsAggregation aggregation = aggregations.terms(
			OTHConstants.CLAIM_AGING_AGG, OTHConstants.CLAIM_AGING_SORTABLE);

		aggregation.addOrders(Order.key(true));

		aggregation.setSize(OTHConstants.AGG_MAX_COUNT_BUCKET_SIZE);

		_addSumAggregations(aggregation, OTHConstants.FIELD_CHARGED_AMOUNT);

		AvgAggregation avgAggregation = aggregations.avg(
			OTHConstants.CLAIM_AGING_AVG_AGG, OTHConstants.CLAIM_AGING_SORTABLE);

		DateHistogramAggregation dateHistogramAggregation = _getDateHistogramAggregation(
			OTHConstants.FIELD_RECEIVED_DATE, startDate.getTime(), endDate.getTime(), OTHConstants.ONE_DAY_INTERVAL);

		Map<String, Serializable> searchContextAttributes = new HashMap<>();

		return buildClaimStatusSearchRequest(
			ClaimAnalytics.class, externalClientPk, OTHConstants.STATUS_IN_PROGRESS, startDate, endDate, start, end,
			null, searchContextAttributes, aggregation, avgAggregation, dateHistogramAggregation);
	}

	private JSONObject _buildProvidersClaimsResponse(SearchResponse response, Date startDate, Date endDate) {
		TermsAggregationResult termsAggregationResult = (TermsAggregationResult)response.getAggregationResult(
			OTHConstants.AGGREGATION_PROVIDERS);

		JSONObject dataResponse = jsonFactory.createJSONObject();

		if (Objects.isNull(termsAggregationResult)) {
			return dataResponse;
		}

		ChartResponseBuilder chartResponseBuilder = new ChartResponseBuilder(
			dataResponse
		).setTotal(
			BigDecimal.ZERO
		).setSavingsTotal(
			BigDecimal.ZERO
		).setTotalCount(
			0
		).setLegendMap(
			jsonFactory.createJSONObject()
		).setDataArray(
			jsonFactory.createJSONArray()
		).setCountMap(
			jsonFactory.createJSONObject()
		).setDataMap(
			jsonFactory.createJSONObject()
		).setSavingsMap(
			jsonFactory.createJSONObject()
		);

		for (Bucket bucket : termsAggregationResult.getBuckets()) {
			_processClaimProviderSumResult(bucket, chartResponseBuilder);
		}

		chartResponseBuilder.updateResponseObj(
			OTHConstants.DATA, chartResponseBuilder.getDataArray()
		).updateResponseObj(
			OTHConstants.COUNT_MAP, chartResponseBuilder.getCountMap()
		).updateResponseObj(
			OTHConstants.DATA_MAP, chartResponseBuilder.getDataMap()
		).updateResponseObj(
			OTHConstants.SAVINGS_MAP, chartResponseBuilder.getSavingsMap()
		).updateResponseObj(
			OTHConstants.SAVINGS_TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX,
			compactNumberFormatter.format(
				chartResponseBuilder.getSavingsTotal(
				).doubleValue())
		).updateResponseObj(
			OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX,
			compactNumberFormatter.format(
				chartResponseBuilder.getTotal(
				).doubleValue())
		).updateResponseObj(
			OTHConstants.TOTAL_COUNT, chartResponseBuilder.getTotalCount()
		).updateResponseObj(
			OTHConstants.FIELD_START_DATE,
			dateFormatter.getFormattedDate(startDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK)
		).updateResponseObj(
			OTHConstants.FIELD_END_DATE,
			dateFormatter.getFormattedDate(endDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK)
		);

		return chartResponseBuilder.getResponseObj();
	}

	private void _buildStackedAreaChartDateObj(
		String fieldName, String dateFieldName, long dateInMillis, Bucket dateHistogramBucket,
		Function<Double, String> formatValueFunction, Function<Long, String> formatCountFunction, boolean volume,
		ChartResponseBuilder chartResponseBuilder, ChartDateObjBuilder chartDateObjBuilder) {

		AggregationResult aggregationResultTerms = dateHistogramBucket.getChildAggregationResult(
			OTHConstants.CLAIM_STATUS_AGG);

		if (Objects.nonNull(aggregationResultTerms) && (aggregationResultTerms instanceof TermsAggregationResult)) {
			TermsAggregationResult termsAggregationResult = (TermsAggregationResult)aggregationResultTerms;

			for (String status : OTHConstants.CLAIM_STATUSES) {
				_buildStackedAreaChartDateObjStatusFields(
					status, fieldName, termsAggregationResult, formatValueFunction, formatCountFunction, volume,
					chartResponseBuilder, chartDateObjBuilder);
			}
		}

		_buildAreaChartDateObj(dateFieldName, dateInMillis, formatCountFunction, chartDateObjBuilder);

		chartDateObjBuilder.updateDateObj(
			OTHConstants.TOTAL, chartDateObjBuilder.getDateBucketTotal()
		).updateDateObj(
			OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX,
			formatValueFunction.apply(
				chartDateObjBuilder.getDateBucketTotal(
				).doubleValue())
		).updateDateObj(
			OTHConstants.COUNT_MAP, chartDateObjBuilder.getCountMap()
		).updateDateObj(
			OTHConstants.VALUE_MAP, chartDateObjBuilder.getValueMap()
		);
	}

	private void _buildStackedAreaChartDateObjStatusFields(
		String status, String fieldName, TermsAggregationResult termsAggregationResult,
		Function<Double, String> formatValueFunction, Function<Long, String> formatCountFunction, boolean volume,
		ChartResponseBuilder chartResponseBuilder, ChartDateObjBuilder chartDateObjBuilder) {

		Bucket termBucket = termsAggregationResult.getBucket(status);

		Long termBucketDocCount = 0L;

		if (Objects.nonNull(termBucket)) {
			termBucketDocCount = termBucket.getDocCount();
		}

		if (!chartResponseBuilder.legendHas(status)) {
			chartResponseBuilder.updateLegendMap(status, BigDecimal.ZERO);
		}

		if (volume) {
			chartDateObjBuilder.updateDateObj(status, termBucketDocCount);

			chartResponseBuilder.updateLegendMap(
				status, chartResponseBuilder.getLegendLongValue(status) + termBucketDocCount);
		}

		chartDateObjBuilder.setDateBucketCount(chartDateObjBuilder.getDateBucketCount() + termBucketDocCount);
		chartDateObjBuilder.updateCountMap(status, formatCountFunction.apply(termBucketDocCount));

		if (Objects.nonNull(termBucket)) {
			AggregationResult aggregationResultSum = termBucket.getChildAggregationResult(
				OTHSearchHelper.getAggregationFieldName(fieldName));

			_buildStackedAreaChartValueFields(
				aggregationResultSum, chartDateObjBuilder, chartResponseBuilder, status, volume, formatValueFunction);
		}
		else {
			if (!volume) {
				chartDateObjBuilder.updateDateObj(status, 0);
			}

			chartDateObjBuilder.updateCountMap(status, formatCountFunction.apply(0L));
			chartDateObjBuilder.updateValueMap(status, formatValueFunction.apply(0D));
		}
	}

	private JSONObject _buildStackedAreaChartResponse(
		SearchResponse searchResponse, String fieldName, String dateFieldName,
		Function<Double, String> formatValueFunction, Function<Long, String> formatCountFunction, boolean volume) {

		DateHistogramAggregationResult dateHistogramAggregationResult =
			(DateHistogramAggregationResult)searchResponse.getAggregationResult(
				OTHSearchHelper.getAggregationFieldName(dateFieldName));

		JSONObject dataResponse = jsonFactory.createJSONObject();

		if (Objects.isNull(dateHistogramAggregationResult)) {
			return dataResponse;
		}

		ChartResponseBuilder chartResponseBuilder = new ChartResponseBuilder(
			dataResponse
		).setTotal(
			BigDecimal.ZERO
		).setTotalCount(
			GetterUtil.getInteger(searchResponse.getCount())
		).setLegendMap(
			jsonFactory.createJSONObject()
		).setDataArray(
			jsonFactory.createJSONArray()
		);

		_buildStackedAreaChartResponse(
			fieldName, dateFieldName, formatValueFunction, formatCountFunction, volume, dateHistogramAggregationResult,
			chartResponseBuilder);

		JSONObject legendMap = chartResponseBuilder.getLegendMap();

		JSONObject formattedLegendMap = jsonFactory.createJSONObject();

		for (String key : legendMap.keySet()) {
			String formattedValue;

			if (volume) {
				long amount = legendMap.getLong(key);

				formattedValue = _othCommonHelper.formatClaims(amount);
			}
			else {
				double amount = legendMap.getDouble(key);

				formattedValue = _othCommonHelper.formatAmountByStatus(amount, key, 2, 2);
			}

			formattedLegendMap.put(key, formattedValue);
		}

		chartResponseBuilder.updateResponseObj(
			OTHConstants.LEGEND_MAP + OTHConstants.FIELD_FORMATTED_SUFFIX, formattedLegendMap);

		return chartResponseBuilder.getResponseObj();
	}

	private void _buildStackedAreaChartResponse(
		String fieldName, String dateFieldName, Function<Double, String> formatValueFunction,
		Function<Long, String> formatCountFunction, boolean volume,
		DateHistogramAggregationResult dateHistogramAggregationResult, ChartResponseBuilder chartResponseBuilder) {

		Collection<Bucket> dateHistogramBuckets = dateHistogramAggregationResult.getBuckets();

		for (Bucket dateHistogramBucket : dateHistogramBuckets) {
			ChartDateObjBuilder chartDateObjBuilder = new ChartDateObjBuilder(
				jsonFactory.createJSONObject()
			).setCountMap(
				jsonFactory.createJSONObject()
			).setValueMap(
				jsonFactory.createJSONObject()
			).setDateBucketTotal(
				BigDecimal.ZERO
			).setDateBucketCount(
				0L
			);

			_buildStackedAreaChartDateObj(
				fieldName, dateFieldName, GetterUtil.getLong(dateHistogramBucket.getKey()), dateHistogramBucket,
				formatValueFunction, formatCountFunction, volume, chartResponseBuilder, chartDateObjBuilder);

			chartResponseBuilder.addToDataArray(chartDateObjBuilder.getDateObj());
		}

		chartResponseBuilder.updateResponseObj(
			OTHConstants.DATA, chartResponseBuilder.getDataArray()
		).updateResponseObj(
			OTHConstants.TOTAL + OTHConstants.FIELD_FORMATTED_SUFFIX,
			formatValueFunction.apply(
				chartResponseBuilder.getTotal(
				).doubleValue())
		).updateResponseObj(
			OTHConstants.COUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
			formatCountFunction.apply((long)chartResponseBuilder.getTotalCount())
		).updateResponseObj(
			OTHConstants.LEGEND_MAP, chartResponseBuilder.getLegendMap()
		);
	}

	private void _buildStackedAreaChartValueFields(
		AggregationResult aggregationResult, ChartDateObjBuilder chartDateObjBuilder,
		ChartResponseBuilder chartResponseBuilder, String status, boolean volume,
		Function<Double, String> formatValueFunction) {

		if (Objects.isNull(aggregationResult)) {
			return;
		}

		SumAggregationResult sumAggregationResult = (SumAggregationResult)aggregationResult;

		double parsedValue = OTHSearchHelper.getCalcFieldActualValue(sumAggregationResult.getValue());

		if (!volume) {
			chartDateObjBuilder.updateDateObj(status, parsedValue);

			chartResponseBuilder.updateLegendMap(
				status, chartResponseBuilder.getLegendDoubleValue(status) + parsedValue);
		}

		chartDateObjBuilder.updateValueMap(status, formatValueFunction.apply(parsedValue));

		chartResponseBuilder.setTotal(
			chartResponseBuilder.getTotal(
			).add(
				BigDecimal.valueOf(parsedValue)
			));

		chartDateObjBuilder.setDateBucketTotal(
			chartDateObjBuilder.getDateBucketTotal(
			).add(
				BigDecimal.valueOf(parsedValue)
			));
	}

	private JSONObject _buildSumAggregateResponse(
		SearchResponse searchResponse, String sumFieldName, String termFieldName, String[] terms,
		Function<Double, Double> parseValueFunction, Function<Double, String> formatValueFunction,
		Consumer<JSONObject> addToolTipFieldsConsumer, Date startDate, Date endDate) {

		TermsAggregationResult termsAggregationResult = (TermsAggregationResult)searchResponse.getAggregationResult(
			OTHSearchHelper.getAggregationFieldName(termFieldName));

		JSONObject dataResponse = jsonFactory.createJSONObject();

		if (Objects.isNull(termsAggregationResult)) {
			return dataResponse;
		}

		JSONArray dataArray = jsonFactory.createJSONArray();
		JSONArray totalsArray = jsonFactory.createJSONArray();
		JSONObject valueMapObj = jsonFactory.createJSONObject();
		JSONObject countMapObj = jsonFactory.createJSONObject();
		JSONObject avgDaysMapObj = jsonFactory.createJSONObject();
		JSONObject avgSavingsPctMapObj = jsonFactory.createJSONObject();

		_putSumAggregateDataPoints(
			sumFieldName, terms, parseValueFunction, formatValueFunction, termsAggregationResult, totalsArray,
			dataArray, valueMapObj, countMapObj, avgDaysMapObj, avgSavingsPctMapObj, dataResponse);

		dataResponse.put(OTHConstants.AVG_DAYS_MAP, avgDaysMapObj);
		dataResponse.put(OTHConstants.AVG_SAVINGS_PCT_MAP, avgSavingsPctMapObj);
		dataResponse.put(OTHConstants.COUNT_MAP, countMapObj);
		dataResponse.put(OTHConstants.DATA, dataArray);
		dataResponse.put(
			OTHConstants.FIELD_END_DATE,
			dateFormatter.getFormattedDate(endDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK));
		dataResponse.put(
			OTHConstants.FIELD_START_DATE,
			dateFormatter.getFormattedDate(startDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK));
		dataResponse.put(OTHConstants.TOTALS, totalsArray);
		dataResponse.put(OTHConstants.VALUE_MAP, valueMapObj);

		if (Objects.nonNull(addToolTipFieldsConsumer)) {
			addToolTipFieldsConsumer.accept(dataResponse);
		}

		return dataResponse;
	}

	private TermsAggregation _getAvgAggregation(String fieldName, String termFieldName, SortOrder sortOrder) {
		AvgAggregation aggregation = aggregations.avg(
			OTHSearchHelper.getAggregationFieldName(fieldName), Field.getSortableFieldName(fieldName));

		BucketSortPipelineAggregation bucketSort = aggregations.bucketSort(_BUCKET_SORT);

		bucketSort.addSortFields(buildSort(OTHSearchHelper.getAggregationFieldName(fieldName), sortOrder));

		TermsAggregation termsAggregation = _getTermsAggregation(termFieldName);

		termsAggregation.addChildAggregation(aggregation);
		termsAggregation.addPipelineAggregation(bucketSort);
		termsAggregation.setSize(OTHConstants.AGG_MAX_COUNT_BUCKET_SIZE);

		return termsAggregation;
	}

	private JSONArray _getChargedRanges(TermsAggregationResult chargedRangeAgg) {
		JSONArray chargedRanges = jsonFactory.createJSONArray();

		for (int i = _CURRENCY_RANGES.length - 1; i >= 0; i--) {
			String range = _CURRENCY_RANGES[i];

			Bucket bucket = chargedRangeAgg.getBucket(range);

			JSONObject chargedRange = jsonFactory.createJSONObject();

			if (Objects.isNull(bucket)) {
				chargedRange.put(_SAVINGS_PERCENTAGE, 0D);
				chargedRange.put(
					_SAVINGS_PERCENTAGE_FORMATTED, _percentageFormatter.formatWholeNumberForDisplay(0, false));
				chargedRange.put(OTHConstants.FIELD_CHARGED_RANGE, range);
				chargedRange.put(OTHConstants.FIELD_SAVINGS_AMOUNT, 0D);
				chargedRange.put(
					OTHConstants.FIELD_SAVINGS_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
					compactNumberFormatter.format(0));
			}
			else {
				AvgAggregationResult savingsAgg = (AvgAggregationResult)bucket.getChildAggregationResult(
					OTHConstants.SAVINGS_PERCENT_AGG);

				SumAggregationResult sumAgg = (SumAggregationResult)bucket.getChildAggregationResult(
					OTHConstants.FIELD_SAVINGS_AMOUNT);

				double savingsPercentage = 0;
				double savingsAmount = 0;

				if (Objects.nonNull(savingsAgg)) {
					savingsPercentage = OTHSearchHelper.getCalcFieldActualValue(savingsAgg.getValue());
				}

				if (Objects.nonNull(sumAgg)) {
					savingsAmount = OTHSearchHelper.getCalcFieldActualValue(sumAgg.getValue());
				}

				chargedRange.put(_SAVINGS_PERCENTAGE, savingsPercentage);
				chargedRange.put(
					_SAVINGS_PERCENTAGE_FORMATTED,
					_percentageFormatter.formatWholeNumberForDisplay(savingsPercentage, false));
				chargedRange.put(OTHConstants.FIELD_CHARGED_RANGE, range);
				chargedRange.put(OTHConstants.FIELD_SAVINGS_AMOUNT, savingsAmount);
				chargedRange.put(
					OTHConstants.FIELD_SAVINGS_AMOUNT + OTHConstants.FIELD_FORMATTED_SUFFIX,
					compactNumberFormatter.format(savingsAmount));
			}

			chargedRanges.put(chargedRange);
		}

		return chargedRanges;
	}

	private String _getClaimAmountBreakoutTotalSavings(SearchResponse searchResponse) {
		SumAggregationResult sumAggregationResult = (SumAggregationResult)searchResponse.getAggregationResult(
			OTHConstants.FIELD_SAVINGS_AMOUNT);

		double value = 0;

		if (Objects.nonNull(sumAggregationResult)) {
			value = OTHSearchHelper.getCalcFieldActualValue(sumAggregationResult.getValue());
		}

		return _compactNumberFormatter.format(value, null, 0);
	}

	private Map<String, Serializable> _getClaimSearchContextAttributes(long clientId, String status) {
		Map<String, Serializable> searchContextAttributes = new HashMap<>();

		searchContextAttributes.put(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, clientId);

		if (!Validator.isBlank(status)) {
			searchContextAttributes.put(OTHConstants.FIELD_CLAIM_STATUS, status.toLowerCase());
		}

		return searchContextAttributes;
	}

	private DateHistogramAggregation _getDateHistogramAggregation(
		String dateFieldName, long startDateInMillis, long endDateInMillis, String interval) {

		DateHistogramAggregation dateHistogramAggregation = aggregations.dateHistogram(
			OTHSearchHelper.getAggregationFieldName(dateFieldName), Field.getSortableFieldName(dateFieldName));

		dateHistogramAggregation.setDateHistogramInterval(interval);
		dateHistogramAggregation.setBounds(startDateInMillis, endDateInMillis);

		return dateHistogramAggregation;
	}

	private ObjectValuePair<Long, Long> _getDateRange(DateRange dateRange) {
		Date startDate = dateRange.getStartDate();
		Date endDate = dateRange.getEndDate();

		return new ObjectValuePair<>(startDate.getTime(), endDate.getTime());
	}

	private TermsAggregation _getProvidersClaimsAggregation(String aggregationName) {
		BucketSortPipelineAggregation bucketSort = aggregations.bucketSort(_BUCKET_SORT);

		SortBuilder sortBuilder = sortBuilderFactory.getSortBuilder();

		FieldSort fieldSort = (FieldSort)sortBuilder.field(
			aggregationName
		).sortOrder(
			SortOrder.DESC
		).build();

		bucketSort.addSortFields(fieldSort);

		bucketSort.setSize(7);

		SumAggregation topProvidersFinancialExposure = aggregations.sum(
			OTHConstants.AGGREGATION_FINANCIAL_EXPOSURE_SUM, OTHConstants.FINANCIAL_EXPOSURE_SORTABLE);

		SumAggregation topProvidersSavings = aggregations.sum(
			OTHConstants.AGGREGATION_SAVINGS_SUM, OTHConstants.SAVINGS_AMOUNT_SORTABLE);

		TermsAggregation providersAgg = aggregations.terms(
			OTHConstants.AGGREGATION_PROVIDERS, OTHConstants.AGGREGATION_PROVIDERS);

		providersAgg.addChildAggregation(topProvidersFinancialExposure);
		providersAgg.addChildAggregation(topProvidersSavings);
		providersAgg.addPipelineAggregation(bucketSort);
		providersAgg.setSize(OTHConstants.AGG_MAX_COUNT_BUCKET_SIZE);

		return providersAgg;
	}

	private Aggregation _getStackedAreaChartAggregation(
		String fieldName, String dateFieldName, ObjectValuePair<Long, Long> dateRangeInMillis, String interval) {

		DateHistogramAggregation dateHistogramAggregation = _getDateHistogramAggregation(
			dateFieldName, dateRangeInMillis.getKey(), dateRangeInMillis.getValue(), interval);

		TermsAggregation sumAggregation = _getSumAggregation(OTHConstants.FIELD_CLAIM_STATUS, fieldName);

		dateHistogramAggregation.addChildAggregation(sumAggregation);

		return dateHistogramAggregation;
	}

	private TermsAggregation _getSumAggregation(String termFieldName, String... sumFieldNames) {
		TermsAggregation termsAggregation = _getTermsAggregation(termFieldName);

		_addSumAggregations(termsAggregation, sumFieldNames);

		return termsAggregation;
	}

	private TermsAggregation _getTermsAggregation(String termFieldName) {
		return _getTermsAggregation(termFieldName, false);
	}

	private TermsAggregation _getTermsAggregation(String termFieldName, boolean sortable) {
		String termAggregationFieldName = OTHSearchHelper.getAggregationFieldName(termFieldName);

		String field = termAggregationFieldName;

		if (sortable) {
			field = Field.getSortableFieldName(termFieldName);
		}

		return aggregations.terms(termAggregationFieldName, field);
	}

	private void _processClaimAreaChartSumResult(
		Map.Entry<String, Function<Double, String>> sumField, Bucket dateHistogramBucket,
		Function<Double, Double> parseValueFunction, ChartDateObjBuilder chartDateObjBuilder) {

		SumAggregationResult sumAggregationResult = (SumAggregationResult)dateHistogramBucket.getChildAggregationResult(
			OTHSearchHelper.getAggregationFieldName(sumField.getKey()));

		if (Objects.isNull(sumAggregationResult)) {
			return;
		}

		Function<Double, String> formatValueFunction = sumField.getValue();

		String key = sumField.getKey();

		double value;

		if (StringUtil.equals(key, OTHConstants.FIELD_CLAIM_AGING)) {
			value = sumAggregationResult.getValue();
		}
		else {
			value = parseValueFunction.apply(sumAggregationResult.getValue());
		}

		BigDecimal average = BigDecimal.ZERO;

		if (dateHistogramBucket.getDocCount() > 0) {
			BigDecimal valueBD = BigDecimal.valueOf(value);
			BigDecimal countBD = BigDecimal.valueOf(dateHistogramBucket.getDocCount());

			average = valueBD.setScale(
				2, RoundingMode.HALF_UP
			).divide(
				countBD, RoundingMode.HALF_UP
			);
		}

		_addClaimAreaChartDateObjFields(
			average, value, key, formatValueFunction, dateHistogramBucket, chartDateObjBuilder);
	}

	private void _processClaimProviderSumResult(Bucket bucket, ChartResponseBuilder chartResponseBuilder) {
		SumAggregationResult financialExposureAggregationResult =
			(SumAggregationResult)bucket.getChildAggregationResult(OTHConstants.AGGREGATION_FINANCIAL_EXPOSURE_SUM);

		double financialExposure = OTHSearchHelper.getCalcFieldActualValue(
			financialExposureAggregationResult.getValue());

		SumAggregationResult savingsAggregationResult = (SumAggregationResult)bucket.getChildAggregationResult(
			OTHConstants.AGGREGATION_SAVINGS_SUM);

		double savings = OTHSearchHelper.getCalcFieldActualValue(savingsAggregationResult.getValue());

		JSONObject provider = jsonFactory.createJSONObject();

		provider.put(OTHConstants.FIELD_FINANCIAL_EXPOSURE, financialExposure);
		provider.put(OTHConstants.NAME, bucket.getKey());
		provider.put(OTHConstants.SAVINGS, savings);
		provider.put(OTHConstants.TOTAL, new Long(bucket.getDocCount()));

		chartResponseBuilder.addToDataArray(
			provider
		).addToCountMap(
			bucket.getKey(), _othCommonHelper.formatClaims(bucket.getDocCount())
		).addToDataMap(
			bucket.getKey(), compactNumberFormatter.format(financialExposure)
		).addToSavingsMap(
			bucket.getKey(), compactNumberFormatter.format(savings)
		).setTotal(
			chartResponseBuilder.getTotal(
			).add(
				BigDecimal.valueOf(financialExposure)
			)
		).setSavingsTotal(
			chartResponseBuilder.getSavingsTotal(
			).add(
				BigDecimal.valueOf(savings)
			)
		).setTotalCount(
			chartResponseBuilder.getTotalCount() + (int)bucket.getDocCount()
		);
	}

	private void _putClaimSavingsAvgY(SearchResponse searchResponse, long avgY, JSONObject data) {
		DateHistogramAggregationResult dateHistogramAggregationResult =
			(DateHistogramAggregationResult)searchResponse.getAggregationResult(OTHConstants.RECEIVED_DATE_AGG);

		BigDecimal avgYBigDecimal = new BigDecimal(avgY);

		if (Objects.nonNull(dateHistogramAggregationResult) &&
			Objects.nonNull(dateHistogramAggregationResult.getBuckets())) {

			avgYBigDecimal = avgYBigDecimal.setScale(
				0, RoundingMode.HALF_UP
			).divide(
				new BigDecimal(
					dateHistogramAggregationResult.getBuckets(
					).size()),
				BigDecimal.ROUND_HALF_UP
			);
		}

		double avgYValue = avgYBigDecimal.doubleValue();

		data.put(_AVERAGE_Y, avgYValue);
	}

	private void _putClaimSavingsNodes(
		SearchResponse searchResponse, Collection<Bucket> buckets, ArrayList<JSONObject> claimSavingNodes,
		JSONObject data) {

		boolean hasBeginningNode = false;
		boolean hasEndNode = false;

		long avgY = 0;

		for (Bucket b : buckets) {
			Double savingsPercent = OTHSearchHelper.getCalcFieldActualValue(new Double(b.getKey()));

			if (!hasBeginningNode) {
				hasBeginningNode = savingsPercent == 0;
			}

			if (!hasEndNode) {
				hasEndNode = savingsPercent == _PERCENT_END_RANGE;
			}

			AggregationResult aggregationResultSum = b.getChildAggregationResult(OTHConstants.SAVINGS_AMOUNT_AGG);

			SumAggregationResult sumAggregationResult = (SumAggregationResult)aggregationResultSum;

			double savingsAmount = 0;

			if (Objects.nonNull(aggregationResultSum)) {
				savingsAmount = OTHSearchHelper.getCalcFieldActualValue(sumAggregationResult.getValue());
			}

			_addClaimSavingsNode(claimSavingNodes, null, b.getDocCount(), savingsPercent, savingsAmount);

			avgY += b.getDocCount();
		}

		if (!hasBeginningNode) {
			_addClaimSavingsNode(claimSavingNodes, 0, 0L, 0L, 0);
		}

		if (!hasEndNode) {
			_addClaimSavingsNode(claimSavingNodes, null, 0L, _PERCENT_END_RANGE, 0);
		}

		_putClaimSavingsAvgY(searchResponse, avgY, data);
	}

	private void _putPieChartAverages(
		Bucket bucket, String term, JSONObject avgDaysMapObj, JSONObject avgSavingsPctMapObj) {

		double avgDays = 0;
		double avgSavingsPct = 0;

		if (Objects.nonNull(bucket)) {
			AvgAggregationResult avgAggregationResult = (AvgAggregationResult)bucket.getChildAggregationResult(
				OTHConstants.CLAIM_AGING_AVG_AGG);

			if (Objects.nonNull(avgAggregationResult)) {
				avgDays = avgAggregationResult.getValue();
			}

			AvgAggregationResult avgSavingsPctAggregationResult =
				(AvgAggregationResult)bucket.getChildAggregationResult(OTHConstants.SAVINGS_PERCENT_AVG_AGG);

			if (Objects.nonNull(avgSavingsPctAggregationResult)) {
				avgSavingsPct = avgSavingsPctAggregationResult.getValue();
			}
		}

		avgDaysMapObj.put(term, _dayFormatter.formatAvgDays(avgDays, true));

		String savingsPctAvgFormatted = String.format(
			OTHConstants.SAVINGS_PCT_AVG_FORMATTED,
			_percentageFormatter.formatWholeNumberForDisplay(
				OTHSearchHelper.getCalcFieldActualValue(avgSavingsPct), false));

		avgSavingsPctMapObj.put(term, savingsPctAvgFormatted);
	}

	private void _putSumAggregateDataPoints(
		String sumFieldName, String[] terms, Function<Double, Double> parseValueFunction,
		Function<Double, String> formatValueFunction, TermsAggregationResult termsAggregationResult,
		JSONArray totalsArray, JSONArray dataArray, JSONObject valueMapObj, JSONObject countMapObj,
		JSONObject avgDaysMapObj, JSONObject avgSavingsPctMapObj, JSONObject dataResponse) {

		double total = 0;
		long totalCount = 0;

		for (String term : terms) {
			Bucket bucket = termsAggregationResult.getBucket(term);

			double value = 0;
			long docCount = 0;

			if (Objects.nonNull(bucket)) {
				docCount = bucket.getDocCount();

				totalCount += docCount;

				SumAggregationResult sumAggregationResult = (SumAggregationResult)bucket.getChildAggregationResult(
					OTHSearchHelper.getAggregationFieldName(sumFieldName));

				if (Objects.nonNull(sumAggregationResult)) {
					if (Objects.nonNull(parseValueFunction)) {
						value = parseValueFunction.apply(sumAggregationResult.getValue());
					}
					else {
						value = sumAggregationResult.getValue();
					}

					total += value;
				}
			}

			String formattedValue = formatValueFunction.apply(value);

			totalsArray.put(formattedValue);

			JSONObject dataPointObj = jsonFactory.createJSONObject();

			dataPointObj.put(OTHConstants.COUNT, new Long(docCount));
			dataPointObj.put(OTHConstants.NAME, term);
			dataPointObj.put(OTHConstants.VALUE, value);
			dataPointObj.put(OTHConstants.VALUE_FORMATTED, formattedValue);

			dataArray.put(dataPointObj);

			valueMapObj.put(term, formattedValue);

			countMapObj.put(term, _othCommonHelper.formatClaims(docCount));

			_putPieChartAverages(bucket, term, avgDaysMapObj, avgSavingsPctMapObj);
		}

		dataResponse.put(OTHConstants.TOTAL, total);
		dataResponse.put(OTHConstants.TOTAL_COUNT, new Long(totalCount));
		dataResponse.put(OTHConstants.TOTAL_FORMATTED, formatValueFunction.apply(total));

		double average = 0;

		if (totalCount > 0) {
			average = total / totalCount;
		}

		dataResponse.put(OTHConstants.AVERAGE, average);
		dataResponse.put(OTHConstants.AVERAGE_FORMATTED, formatValueFunction.apply(average));
	}

	private static final String _AVERAGE_X = "averageX";

	private static final String _AVERAGE_Y = "averageY";

	private static final String _BUCKET_SORT = "bucket_sort";

	private static final String _CHARGED_RANGES = "chargedRanges";

	private static final String _CLAIM_AGE = "claimAge";

	private static final String[] _CURRENCY_RANGES = {
		"$1 - $1K", "$1K - $5K", "$5K - $10K", "$10K - $20K", "$20K - $50K", "$50K - $100K", "$100K - $500K"
	};

	private static final long _PERCENT_END_RANGE = 100;

	private static final String _SAVING_RANGES = "savingRanges";

	private static final String _SAVINGS_PERCENTAGE = "savingsPercentage";

	private static final String _SAVINGS_PERCENTAGE_FORMATTED =
		_SAVINGS_PERCENTAGE + OTHConstants.FIELD_FORMATTED_SUFFIX;

	private static final Log _log = LogFactoryUtil.getLog(ChartsServiceImpl.class);

	@Reference
	private CompactNumberFormatter _compactNumberFormatter;

	@Reference
	private DayFormatter _dayFormatter;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private PercentageFormatter _percentageFormatter;

}