package com.argus.oth.charts.service.helper;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.math.BigDecimal;

/**
 * @author Jaclyn Ong
 */
public class ChartResponseBuilder {

	public ChartResponseBuilder(JSONObject jsonObject) {
		_responseObj = jsonObject;
	}

	public ChartResponseBuilder addToCountMap(String key, Object value) {
		_countMap.put(key, value);

		return this;
	}

	public ChartResponseBuilder addToDataArray(JSONObject jsonObject) {
		_dataArray.put(jsonObject);

		return this;
	}

	public ChartResponseBuilder addToDataMap(String key, Object value) {
		_dataMap.put(key, value);

		return this;
	}

	public ChartResponseBuilder addToSavingsMap(String key, Object value) {
		_savingsMap.put(key, value);

		return this;
	}

	public BigDecimal getAverage() {
		return _average;
	}

	public int getCountAverage() {
		return _countAverage;
	}

	public JSONObject getCountMap() {
		return _countMap;
	}

	public JSONArray getDataArray() {
		return _dataArray;
	}

	public JSONObject getDataMap() {
		return _dataMap;
	}

	public String getFormattedAverage() {
		return _formattedAverage;
	}

	public Double getLegendDoubleValue(String key) {
		return _legendMap.getDouble(key);
	}

	public Long getLegendLongValue(String key) {
		return _legendMap.getLong(key);
	}

	public JSONObject getLegendMap() {
		return _legendMap;
	}

	public JSONObject getResponseObj() {
		return _responseObj;
	}

	public JSONObject getSavingsMap() {
		return _savingsMap;
	}

	public BigDecimal getSavingsTotal() {
		return _savingsTotal;
	}

	public BigDecimal getTotal() {
		return _total;
	}

	public int getTotalCount() {
		return _totalCount;
	}

	public boolean legendHas(String key) {
		return _legendMap.has(key);
	}

	public ChartResponseBuilder setAverage(BigDecimal average) {
		_average = average;

		return this;
	}

	public ChartResponseBuilder setCountAverage(int countAverage) {
		_countAverage = countAverage;

		return this;
	}

	public ChartResponseBuilder setCountMap(JSONObject countMap) {
		_countMap = countMap;

		return this;
	}

	public ChartResponseBuilder setDataArray(JSONArray dataArray) {
		_dataArray = dataArray;

		return this;
	}

	public ChartResponseBuilder setDataMap(JSONObject dataMap) {
		_dataMap = dataMap;

		return this;
	}

	public ChartResponseBuilder setFormattedAverage(String formattedAverage) {
		_formattedAverage = formattedAverage;

		return this;
	}

	public ChartResponseBuilder setLegendMap(JSONObject legendMap) {
		_legendMap = legendMap;

		return this;
	}

	public ChartResponseBuilder setSavingsMap(JSONObject savingsMap) {
		_savingsMap = savingsMap;

		return this;
	}

	public ChartResponseBuilder setSavingsTotal(BigDecimal savingsTotal) {
		_savingsTotal = savingsTotal;

		return this;
	}

	public ChartResponseBuilder setTotal(BigDecimal total) {
		_total = total;

		return this;
	}

	public ChartResponseBuilder setTotalCount(int totalCount) {
		_totalCount = totalCount;

		return this;
	}

	public ChartResponseBuilder updateLegendMap(String key, Object value) {
		_legendMap.put(key, value);

		return this;
	}

	public ChartResponseBuilder updateResponseObj(String key, Object value) {
		_responseObj.put(key, value);

		return this;
	}

	private BigDecimal _average;
	private int _countAverage;
	private JSONObject _countMap;
	private JSONArray _dataArray;
	private JSONObject _dataMap;
	private String _formattedAverage;
	private JSONObject _legendMap;
	private final JSONObject _responseObj;
	private JSONObject _savingsMap;
	private BigDecimal _savingsTotal;
	private BigDecimal _total;
	private int _totalCount;

}