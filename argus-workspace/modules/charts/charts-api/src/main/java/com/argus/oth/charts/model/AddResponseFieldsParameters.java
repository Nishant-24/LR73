package com.argus.oth.charts.model;

import com.liferay.portal.kernel.json.JSONObject;

import java.math.BigDecimal;

/**
 * @author Jaclyn Ong
 */
public interface AddResponseFieldsParameters {

	String getGoalFieldName();

	String getOverallAvgFieldName();

	JSONObject getResponseObject();

	BigDecimal getTotal();

	BigDecimal getTotalCount();

	void setGoalFieldName(String goalFieldName);

	void setOverallAvgFieldName(String overallAvgFieldName);

	void setResponseObject(JSONObject responseObject);

	void setTotal(BigDecimal total);

	void setTotalCount(BigDecimal totalCount);

}