package com.argus.oth.charts;

import com.argus.oth.charts.model.AddResponseFieldsParameters;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.search.document.Document;

import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Jaclyn Ong
 */
public interface ChartsService {

	public JSONObject getAreaChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end,
		Function<Document, JSONObject> serializeFunction, String fieldName, String dateFieldName,
		String overallAvgFieldName, String goalFieldName, Consumer<AddResponseFieldsParameters> addResponseFields);

	public JSONObject getClaimAging(
		TimeZone timeZone, Date startDate, Date endDate, int start, int end, long clientId, long min);

	public JSONObject getClaimAmountBreakoutBySavings(
		TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end);

	public JSONObject getClaimAreaChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end,
		String status, String interval, Function<Double, Double> parseValueFunction,
		Map<String, Function<Double, String>> sumFieldMap, Function<Long, String> formatCountFunction, String termField,
		String overallAvgFieldName);

	public JSONObject getClaimBreakoutChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, String status, Date startDate, Date endDate, int start,
		int end, String sumFieldName, String termFieldName, Function<Double, Double> parseValueFunction,
		Function<Double, String> formatValueFunction, Consumer<JSONObject> addToolTipFieldsConsumer);

	public DateRange getDateRange(Date startDate, Date endDate, TimeZone timeZone);

	public JSONObject getProvidersChartData(
		long externalClientPk, String aggregationName, Date startDate, Date endDate, TimeZone timeZone, int start,
		int end);

	public JSONObject getStackedAreaChartData(
		Class<?> clazz, TimeZone timeZone, long clientId, Date startDate, Date endDate, int start, int end,
		String fieldName, String dateFieldName, String interval, Function<Double, String> formatValueFunction,
		Function<Long, String> formatCountFunction, boolean volume);

}