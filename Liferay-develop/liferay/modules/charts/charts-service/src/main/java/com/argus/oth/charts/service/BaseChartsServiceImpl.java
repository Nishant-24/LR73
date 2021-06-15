package com.argus.oth.charts.service;

import com.argus.oth.charts.ChartsService;
import com.argus.oth.common.CompactNumberFormatter;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.DayFormatter;
import com.argus.oth.common.OTHConstants;

import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.aggregation.Aggregation;
import com.liferay.portal.search.aggregation.Aggregations;
import com.liferay.portal.search.aggregation.bucket.TermsAggregation;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;
import com.liferay.portal.search.sort.FieldSort;
import com.liferay.portal.search.sort.Sort;
import com.liferay.portal.search.sort.SortBuilder;
import com.liferay.portal.search.sort.SortBuilderFactory;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.sort.Sorts;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy
 */
public abstract class BaseChartsServiceImpl implements ChartsService {

	@Override
	public DateRange getDateRange(Date startDate, Date endDate, TimeZone timeZone) {
		endDate = setEndDate(endDate, timeZone, dateFormatter);

		startDate = dateFormatter.getStartDate(startDate, endDate);
		endDate = dateFormatter.getEndDate(endDate);

		return new DateRange(startDate, endDate);
	}

	protected SearchRequest buildClaimStatusSearchRequest(
		Class<?> clazz, long clientId, String status, Date startDate, Date endDate, int start, int end, Sort sort,
		Map<String, Serializable> searchContextAttributes, Aggregation... aggregation) {

		if (Objects.isNull(searchContextAttributes)) {
			searchContextAttributes = new HashMap<>();
		}

		searchContextAttributes.put(OTHConstants.FIELD_CLAIM_STATUS, status.toLowerCase());
		searchContextAttributes.put(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, clientId);

		return buildSearchRequest(
			clazz, startDate.getTime(), endDate.getTime(), searchContextAttributes, sort, start, end, aggregation);
	}

	protected SearchRequest buildSearchRequest(
		Class<?> clazz, long startDateInMillis, long endDateInMillis, Map<String, Serializable> searchContextAttributes,
		Sort sort, int start, int end, Aggregation... aggregation) {

		SearchRequestBuilder searchRequestBuilder = searchRequestBuilderFactory.builder();

		if (Objects.nonNull(aggregation)) {
			Arrays.asList(
				aggregation
			).forEach(
				searchRequestBuilder::addAggregation
			);
		}

		if (Objects.nonNull(sort)) {
			searchRequestBuilder.sorts(sort);
		}

		return searchRequestBuilder.entryClassNames(
			clazz.getName()
		).modelIndexerClasses(
			clazz
		).withSearchContext(
			searchContext -> setSearchContext(
				searchContext, startDateInMillis, endDateInMillis, searchContextAttributes, start, end)
		).build();
	}

	protected SearchRequest buildSearchRequest(
		Class<?> clazz, long clientId, String status, Date startDate, Date endDate, Sort sort, int start, int end,
		TermsAggregation... sumAggregation) {

		Map<String, Serializable> searchContextAttributes = new HashMap<>();

		searchContextAttributes.put(OTHConstants.FIELD_CLAIM_STATUS, status.toLowerCase());
		searchContextAttributes.put(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, clientId);

		return buildSearchRequest(
			clazz, startDate.getTime(), endDate.getTime(), searchContextAttributes, sort, start, end, sumAggregation);
	}

	protected FieldSort buildSort(String fieldName, SortOrder sortOrder) {
		SortBuilder sortBuilder = sortBuilderFactory.getSortBuilder();

		return (FieldSort)sortBuilder.field(
			fieldName
		).sortOrder(
			sortOrder
		).build();
	}

	protected SearchResponse search(
		Class<?> clazz, ObjectValuePair<Long, Long> dateRangeInMillis,
		Map<String, Serializable> searchContextAttributes, Sort sort, int start, int end, Aggregation... aggregations) {

		SearchRequest searchRequest = buildSearchRequest(
			clazz, dateRangeInMillis.getKey(), dateRangeInMillis.getValue(), searchContextAttributes, sort, start, end,
			aggregations);

		return searcher.search(searchRequest);
	}

	protected Date setEndDate(Date endDate, TimeZone timeZone, DateFormatter dateFormatter) {
		if (Objects.nonNull(endDate)) {
			return endDate;
		}

		if (Objects.nonNull(timeZone)) {
			return dateFormatter.convertToTimeZone(new Date(), timeZone);
		}

		return dateFormatter.convertToUTC(new Date());
	}

	protected void setSearchContext(
		SearchContext searchContext, long startDateInMillis, long endDateInMillis,
		Map<String, Serializable> searchContextAttributes, int start, int end) {

		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		searchContext.setAttribute(OTHConstants.FIELD_START_DATE, startDateInMillis);
		searchContext.setAttribute(OTHConstants.FIELD_END_DATE, endDateInMillis);
		searchContext.setStart(start);
		searchContext.setEnd(end);

		if (Objects.nonNull(searchContextAttributes)) {
			for (Map.Entry<String, Serializable> attribute : searchContextAttributes.entrySet()) {
				searchContext.setAttribute(attribute.getKey(), attribute.getValue());
			}
		}
	}

	@Reference
	protected Aggregations aggregations;

	@Reference
	protected CompactNumberFormatter compactNumberFormatter;

	@Reference
	protected DateFormatter dateFormatter;

	@Reference
	protected DayFormatter dayFormatter;

	@Reference
	protected JSONFactory jsonFactory;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

	@Reference
	protected SortBuilderFactory sortBuilderFactory;

	@Reference
	protected Sorts sorts;

}