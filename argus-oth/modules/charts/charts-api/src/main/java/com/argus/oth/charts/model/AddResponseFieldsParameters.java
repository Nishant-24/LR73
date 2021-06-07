package com.argus.oth.charts.model;

import com.liferay.portal.kernel.json.JSONObject;

import java.math.BigDecimal;

/**
 * @author Jaclyn Ong
 */
public interface AddResponseFieldsParameters {

	public String getGoalFieldName();

	public String getOverallAvgFieldName();

	public JSONObject getResponseObject();

	public BigDecimal getTotal();

	public BigDecimal getTotalCount();

	public void setGoalFieldName(String goalFieldName);

	public void setOverallAvgFieldName(String overallAvgFieldName);

	public void setResponseObject(JSONObject responseObject);

	public void setTotal(BigDecimal total);

	public void setTotalCount(BigDecimal totalCount);

}