package com.argus.oth.charts.service.helper;

import com.liferay.portal.kernel.json.JSONObject;

import java.math.BigDecimal;

/**
 * @author Jaclyn Ong
 */
public class ChartDateObjBuilder {

	public ChartDateObjBuilder(JSONObject dateObj) {
		_dateObj = dateObj;
	}

	public JSONObject getCountMap() {
		return _countMap;
	}

	public Long getDateBucketCount() {
		return _dateBucketCount;
	}

	public BigDecimal getDateBucketTotal() {
		return _dateBucketTotal;
	}

	public JSONObject getDateObj() {
		return _dateObj;
	}

	public JSONObject getValueMap() {
		return _valueMap;
	}

	public ChartDateObjBuilder setCountMap(JSONObject countMap) {
		_countMap = countMap;

		return this;
	}

	public ChartDateObjBuilder setDateBucketCount(Long dateBucketCount) {
		_dateBucketCount = dateBucketCount;

		return this;
	}

	public ChartDateObjBuilder setDateBucketTotal(BigDecimal dateBucketTotal) {
		_dateBucketTotal = dateBucketTotal;

		return this;
	}

	public ChartDateObjBuilder setValueMap(JSONObject valueMap) {
		_valueMap = valueMap;

		return this;
	}

	public ChartDateObjBuilder updateCountMap(String key, Object value) {
		_countMap.put(key, value);

		return this;
	}

	public ChartDateObjBuilder updateDateObj(String key, Object value) {
		_dateObj.put(key, value);

		return this;
	}

	public ChartDateObjBuilder updateValueMap(String key, Object value) {
		_valueMap.put(key, value);

		return this;
	}

	private JSONObject _countMap;
	private Long _dateBucketCount;
	private BigDecimal _dateBucketTotal;
	private final JSONObject _dateObj;
	private JSONObject _valueMap;

}