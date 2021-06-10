package com.argus.oth.cases.management.service;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.Date;
import java.util.TimeZone;

/**
 * @author Jaclyn Ong
 */
public interface CaseAnalyticsService {

	public JSONObject getRecentCasesData(
		long groupId, long clientId, Date startDate, Date endDate, String interval, TimeZone timeZone);

}