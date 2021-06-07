package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.CaseAnalyticsService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.OTHSearchHelper;
import com.argus.oth.common.enums.CaseStatus;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.aggregation.Aggregation;
import com.liferay.portal.search.aggregation.AggregationResult;
import com.liferay.portal.search.aggregation.Aggregations;
import com.liferay.portal.search.aggregation.bucket.Bucket;
import com.liferay.portal.search.aggregation.bucket.DateHistogramAggregation;
import com.liferay.portal.search.aggregation.bucket.DateHistogramAggregationResult;
import com.liferay.portal.search.aggregation.bucket.TermsAggregation;
import com.liferay.portal.search.aggregation.bucket.TermsAggregationResult;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = CaseAnalyticsService.class)
public class CaseAnalyticsServiceImpl implements CaseAnalyticsService {

	@Override
	public JSONObject getRecentCasesData(
		long groupId, long clientId, Date startDate, Date endDate, String interval, TimeZone timeZone) {

		try {
			if (Objects.isNull(endDate)) {
				if (Objects.nonNull(timeZone)) {
					endDate = _dateFormatter.convertToTimeZone(new Date(), timeZone);
				}
				else {
					endDate = _dateFormatter.convertToUTC(new Date());
				}
			}

			SearchRequest searchRequest = _buildRecentCasesSearchRequest(
				groupId, clientId, startDate, endDate, interval);

			SearchResponse searchResponse = _searcher.search(searchRequest);

			return _buildRecentCasesResponse(searchResponse, startDate, endDate);
		}
		catch (Exception pe) {
			_log.error("Failed to get Cases analytics data", pe);

			return _jsonFactory.createJSONObject();
		}
	}

	private JSONObject _buildAggregatedTerms(AggregationResult aggregationResult) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		if (Objects.isNull(aggregationResult) || !(aggregationResult instanceof TermsAggregationResult)) {
			return jsonObject;
		}

		TermsAggregationResult termsAggregationResult = (TermsAggregationResult)aggregationResult;

		Collection<Bucket> buckets = termsAggregationResult.getBuckets();

		for (Bucket bucket : buckets) {
			jsonObject.put(bucket.getKey(), new Long(bucket.getDocCount()));
		}

		return jsonObject;
	}

	private JSONObject _buildRecentCasesResponse(SearchResponse searchResponse, Date startDate, Date endDate) {
		DateHistogramAggregationResult dateHistogramAggregationResult =
			(DateHistogramAggregationResult)searchResponse.getAggregationResult(_LAST_UPDATED_HISTOGRAM_AGG);

		JSONObject responseObj = _jsonFactory.createJSONObject();

		if (Objects.isNull(dateHistogramAggregationResult)) {
			return responseObj;
		}

		Collection<Bucket> dateHistogramBuckets = dateHistogramAggregationResult.getBuckets();

		BigDecimal caseCount = new BigDecimal(searchResponse.getTotalHits());

		JSONArray dataArr = _jsonFactory.createJSONArray();
		JSONObject totalsObj = _jsonFactory.createJSONObject();

		startDate = _dateFormatter.getStartDate(startDate, endDate);

		for (Bucket dateHistogramBucket : dateHistogramBuckets) {
			long dateInMillis = GetterUtil.getLong(dateHistogramBucket.getKey());

			if (dateInMillis < startDate.getTime()) {
				continue;
			}

			String formattedDay = _getFormattedDay(dateHistogramBucket.getKey());

			JSONObject dateObj = _buildAggregatedTerms(dateHistogramBucket.getChildAggregationResult(_STATUS_AGG));

			dateObj.put("name", formattedDay);

			dataArr.put(dateObj);

			for (CaseStatus caseStatus : CaseStatus.values()) {
				String status = caseStatus.getStatusText();

				if (dateObj.has(status)) {
					if (totalsObj.has(status)) {
						totalsObj.put(status, Long.sum(totalsObj.getLong(status), dateObj.getLong(status)));
					}
					else {
						totalsObj.put(status, dateObj.getLong(status));
					}
				}
			}
		}

		BigDecimal bucketCount = new BigDecimal(dataArr.length());

		responseObj.put("data", dataArr);

		int average = 0;

		if (bucketCount.longValue() > 0) {
			BigDecimal avgBD = caseCount.divide(bucketCount, BigDecimal.ROUND_HALF_UP);

			average = avgBD.intValue();
		}

		responseObj.put("average", average);

		responseObj.put(OTHConstants.CASE_TOTALS, totalsObj);

		return responseObj;
	}

	private SearchRequest _buildRecentCasesSearchRequest(
		long groupId, long clientId, Date startDate, Date endDate, String interval) {

		if (Validator.isBlank(interval)) {
			interval = _ONE_WEEK_INTERVAL;
		}

		SearchRequestBuilder searchRequestBuilder = _searchRequestBuilderFactory.builder();

		startDate = _dateFormatter.getStartDate(startDate, endDate);

		long startDateInMillis = startDate.getTime();

		endDate = _dateFormatter.getEndDate(endDate);

		long endDateInMillis = endDate.getTime();

		return searchRequestBuilder.addAggregation(
			_getAggregation(startDateInMillis, endDateInMillis, interval)
		).entryClassNames(
			Cases.class.getName()
		).modelIndexerClasses(
			Cases.class
		).withSearchContext(
			searchContext -> _setRecentCasesSearchContext(
				searchContext, groupId, clientId, startDateInMillis, endDateInMillis)
		).build();
	}

	private Aggregation _getAggregation(long startDateInMillis, long endDateInMillis, String interval) {
		DateHistogramAggregation dateHistogramAggregation = _aggregations.dateHistogram(
			_LAST_UPDATED_HISTOGRAM_AGG, Field.getSortableFieldName(OTHConstants.FIELD_LAST_UPDATED));

		dateHistogramAggregation.setOffset(OTHSearchHelper.getDateOffset(startDateInMillis));
		dateHistogramAggregation.setDateHistogramInterval(interval);
		dateHistogramAggregation.setBounds(startDateInMillis, endDateInMillis);

		TermsAggregation termsAggregation = _aggregations.terms(_STATUS_AGG, OTHConstants.FIELD_STATUS);

		dateHistogramAggregation.addChildAggregation(termsAggregation);

		return dateHistogramAggregation;
	}

	private String _getFormattedDay(String dateInMillis) {
		long dateInMillisLong = GetterUtil.getLong(dateInMillis);

		Calendar calendar = CalendarFactoryUtil.getCalendar();

		calendar.setTimeInMillis(dateInMillisLong);

		return _dateFormatter.getFormattedDay(calendar.getTime(), StringPool.BLANK);
	}

	private void _setRecentCasesSearchContext(
		SearchContext searchContext, long groupId, long clientId, long startDateInMillis, long endDateInMillis) {

		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		searchContext.setGroupIds(new long[] {groupId});

		searchContext.setAttribute(OTHConstants.FIELD_CLIENT_ID, clientId);

		searchContext.setStart(0);

		searchContext.setEnd(0);

		searchContext.setAttribute(OTHConstants.FIELD_START_DATE, startDateInMillis);

		searchContext.setAttribute(OTHConstants.FIELD_END_DATE, endDateInMillis);
	}

	private static final String _LAST_UPDATED_HISTOGRAM_AGG = "lastUpdatedHistogram_agg";

	private static final String _ONE_WEEK_INTERVAL = "1w";

	private static final String _STATUS_AGG = "status_agg";

	private static final Log _log = LogFactoryUtil.getLog(CaseAnalyticsServiceImpl.class);

	@Reference
	private Aggregations _aggregations;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private Searcher _searcher;

	@Reference
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;

}