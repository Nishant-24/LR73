package com.argus.oth.charts.model;

import com.liferay.portal.kernel.json.JSONObject;

import java.math.BigDecimal;

/**
 * @author Jaclyn Ong
 */
public class AddResponseFieldsParametersImpl implements AddResponseFieldsParameters {

	public String getGoalFieldName() {
		return _goalFieldName;
	}

	public String getOverallAvgFieldName() {
		return _overallAvgFieldName;
	}

	public JSONObject getResponseObject() {
		return _responseObject;
	}

	public BigDecimal getTotal() {
		return _total;
	}

	public BigDecimal getTotalCount() {
		return _totalCount;
	}

	public void setGoalFieldName(String goalFieldName) {
		_goalFieldName = goalFieldName;
	}

	public void setOverallAvgFieldName(String overallAvgFieldName) {
		_overallAvgFieldName = overallAvgFieldName;
	}

	public void setResponseObject(JSONObject responseObject) {
		_responseObject = responseObject;
	}

	public void setTotal(BigDecimal total) {
		_total = total;
	}

	public void setTotalCount(BigDecimal totalCount) {
		_totalCount = totalCount;
	}

	private String _goalFieldName;
	private String _overallAvgFieldName;
	private JSONObject _responseObject;
	private BigDecimal _total;
	private BigDecimal _totalCount;

}