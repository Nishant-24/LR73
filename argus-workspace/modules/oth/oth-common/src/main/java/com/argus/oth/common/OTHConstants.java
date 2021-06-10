package com.argus.oth.common;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

public class OTHConstants {

	public static final String ADD_NOTE = "ADD_NOTE";

	public static final String ADD_TASK = "ADD_TASK";

	public static final int AGG_MAX_COUNT_BUCKET_SIZE = 10000;

	public static final String AGGREGATION_FINANCIAL_EXPOSURE_SUM = OTHSearchHelper.getAggregationFieldName(
		"financial_exposure_sum");

	public static final String AGGREGATION_PROVIDERS = OTHSearchHelper.getAggregationFieldName(
		OTHConstants.FIELD_PROVIDER_NAME);

	public static final String AGGREGATION_SAVINGS_SUM = OTHSearchHelper.getAggregationFieldName("savings_sum");

	public static final String AUTHORIZATION_APPROVED_STATUS_KEY = "068:Waiting";

	public static final String AUTHORIZATION_DENIED_STATUS_KEY = "068:Denied";

	public static final String AUTHORIZATION_PENDING_STATUS_KEY = "068:Pend";

	public static final String AUTHORIZE = "AUTHORIZE";

	public static final String AVERAGE = "average";

	public static final String AVERAGE_FORMATTED = AVERAGE + OTHConstants.FIELD_FORMATTED_SUFFIX;

	public static final String AVERAGE_SUFFIX = StringPool.UNDERLINE + AVERAGE;

	public static final String AVG_DAYS_MAP = "avgDaysMap";

	public static final String AVG_SAVINGS_PCT_MAP = "avgSavingsPctMap";

	public static final String CASE_GROUP_TYPE_BOOKMARK = "bookmark";

	public static final String CASE_GROUP_TYPE_RECENTLY_VIEWED = "recently-viewed";

	public static final String CASE_ID = "caseId";

	public static final String CASE_TOTALS = "caseTotals";

	public static final String CHARACTER_BROKEN_VERTICAL_BAR = "¦";

	public static final String CHARACTER_NEW_LINE = "‡";

	public static final String CHARACTER_TAB = "†";

	public static final String CHARGED_AMOUNT_AGG = OTHSearchHelper.getAggregationFieldName(
		OTHConstants.FIELD_CHARGED_AMOUNT);

	public static final String CHARGED_RANGE_AGG = OTHSearchHelper.getAggregationFieldName(
		OTHConstants.FIELD_CHARGED_RANGE);

	public static final String CHARSET_WINDOWS_1252 = "windows-1252";

	public static final String CLAIM_AGING_AGG = OTHSearchHelper.getAggregationFieldName(
		OTHConstants.FIELD_CLAIM_AGING);

	public static final String CLAIM_AGING_AVG_AGG = OTHSearchHelper.getAggregationFieldName(
		OTHConstants.FIELD_CLAIM_AGING + AVERAGE_SUFFIX);

	public static final String CLAIM_AGING_SORTABLE = Field.getSortableFieldName(OTHConstants.FIELD_CLAIM_AGING);

	public static final String CLAIM_STATUS_AGG = OTHSearchHelper.getAggregationFieldName(
		OTHConstants.FIELD_CLAIM_STATUS);

	public static final String[] CLAIM_STATUSES = {"In Process", "Processed", "Closed"};

	public static final String COUNT = "count";

	public static final String COUNT_MAP = "countMap";

	public static final String CURRENCY_FORMAT_CODE = "[$$-409]#,##0.00;-[$$-409]#,##0.00";

	public static final String DATA = "data";

	public static final String DATA_ADMIN_USER_SCREEN_NAME = "admin-data";

	public static final String DATA_MAP = "dataMap";

	public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	public static final String DATE_PATTERN_DEFAULT = "EEE MMM dd kk:mm:ss zzz yyyy";

	public static final String DATE_PATTERN_H_MM_AA = "h:mm aa";

	public static final String DATE_PATTERN_MMM_DD = "MMM dd";

	public static final String DATE_PATTERN_MMM_DD_YYYY = "MMM dd, yyyy";

	public static final String DATE_PATTERN_YYYY_DD_MM = "yyyy-MM-dd";

	public static final long DAY_IN_MILLIS = 86400000L;

	public static final int DEFAULT_DELTA = 10;

	public static final long DEFAULT_GROUP_ID = 0;

	public static final String DELETE_LOG_STRING_FORMAT = "Deleting %s (external ID %d, internal PK %d)";

	public static final String DESCRIPTION_KEY = "descriptionKey";

	public static final String EM_DASH = "\u2014";

	public static final String FIELD_ABANDONMENT_RATE = "abandonmentRate";

	public static final String FIELD_ABANDONMENT_RATE_GOAL = "abandonmentRateGoal";

	public static final String FIELD_AM_ANALYTICS_CLAIM_DATE = "amAnalyticsClaimDate";

	public static final String FIELD_AM_ANALYTICS_CLAIM_DATE_MMM_DD = FIELD_AM_ANALYTICS_CLAIM_DATE + "_mmm_dd";

	public static final String FIELD_AM_ANALYTICS_CLAIM_DATE_MMM_DD_YYYY =
		FIELD_AM_ANALYTICS_CLAIM_DATE_MMM_DD + "_yyyy";

	public static final String FIELD_AM_ANALYTICS_TELEPHONY_DATE = "amAnalyticsTelephonyDate";

	public static final String FIELD_AM_ANALYTICS_TELEPHONY_DATE_MMM_DD = FIELD_AM_ANALYTICS_TELEPHONY_DATE + "_mmm_dd";

	public static final String FIELD_AM_ANALYTICS_TELEPHONY_DATE_MMM_DD_YYYY =
		FIELD_AM_ANALYTICS_TELEPHONY_DATE_MMM_DD + "_yyyy";

	public static final String FIELD_AVG_CLAIM_TURNAROUND = "avgClaimTurnAround";

	public static final String FIELD_AVG_DOWN_TIME = "avgDownTime";

	public static final String FIELD_AVG_SPEED_OF_ANSWER = "avgSpeedOfAnswer";

	public static final String FIELD_BILL_TYPE = "billType";

	public static final String FIELD_CASE_END_DATE = "caseEndDate";

	public static final String FIELD_CASE_ID = "caseId";

	public static final String FIELD_CASE_MANAGER = "caseManager";

	public static final String FIELD_CASE_NUMBER = "caseNumber";

	public static final String FIELD_CASE_START_DATE = "caseStartDate";

	public static final String FIELD_CHARGED_AMOUNT = "chargedAmount";

	public static final String FIELD_CHARGED_PERCENT = "chargedPercent";

	public static final String FIELD_CHARGED_RANGE = "chargedRange";

	public static final String FIELD_CLAIM_AGING = "claimAging";

	public static final String FIELD_CLAIM_NUMBER = "claimNumber";

	public static final String FIELD_CLAIM_STATUS = "claimStatus";

	public static final String FIELD_CLAIM_TURN_AROUND_GOAL = "claimTurnAroundGoal";

	public static final String FIELD_CLAIMS_TURNAROUND_GOAL = "claimsTurnaroundGoal";

	public static final String FIELD_CLIENT_GROUP_ID = "clientGroupId";

	public static final String FIELD_CLIENT_GROUP_NAME = "clientGroupName";

	public static final String FIELD_CLIENT_ID = "clientId";

	public static final String FIELD_CLIENT_NAME = "clientName";

	public static final String FIELD_COMPANY_ID = "companyId";

	public static final String FIELD_CONSENT_RECEIVED_DATE = "consentReceivedDate";

	public static final String FIELD_COST_ESTIMATE = "costEstimate";

	public static final String FIELD_COUNTRY = "country";

	public static final String FIELD_DATE_RANGE = "dateRange";

	public static final String FIELD_DIAGNOSIS_CODES = "diagnosisCodes";

	public static final String FIELD_DOWN_TIME_GOAL = "downTimeGoal";

	public static final String FIELD_END_CLAIM_AGING = "endClaimAging";

	public static final String FIELD_END_DATE = "endDate";

	public static final String FIELD_ESTIMATE_ENTRY_DATE = "estimateEntryDate";

	public static final String FIELD_EXTERNAL_CASE_ID = "externalCaseId";

	public static final String FIELD_EXTERNAL_CLIENT_ID = "externalClientId";

	public static final String FIELD_EXTERNAL_CREATED_DATE = "externalCreatedDate";

	public static final String FIELD_EXTERNAL_MEMBER_ID = "externalMemberId";

	public static final String FIELD_FINANCIAL_EXPOSURE = "financialExposure";

	public static final String FIELD_FORMATTED_SUFFIX = "_formatted";

	public static final String FIELD_GROUP_ID = "groupId";

	public static final String FIELD_LAST_UPDATED = "lastUpdated";

	public static final String FIELD_MAX_CLAIM_TURNAROUND = "maxClaimTurnAround";

	public static final String FIELD_MEDICAL_PLAN = "medicalPlan";

	public static final String FIELD_MEMBER_ID = "memberId";

	public static final String FIELD_MEMBER_NAME = "memberName";

	public static final String FIELD_MEMBER_NUMBER = "memberNumber";

	public static final String FIELD_MIN_CLAIM_TURNAROUND = "minClaimTurnAround";

	public static final String FIELD_OVERALL_AVG_ABANDONMENT_RATE = "overallAvgAbandonmentRate";

	public static final String FIELD_OVERALL_AVG_CLAIM_TURNAROUND = "overallAvgClaimTurnAround";

	public static final String FIELD_OVERALL_AVG_DOWNTIME = "overallAvgDownTime";

	public static final String FIELD_OVERALL_AVG_SPEED_OF_ANSWER = "overallAvgSpeedOfAnswer";

	public static final String FIELD_PAID_AMOUNT = "paidAmount";

	public static final String FIELD_PAID_DATE = "paidDate";

	public static final String FIELD_PAID_RANGE = "paidRange";

	public static final String FIELD_PRIMARY_CODE = "primaryCode";

	public static final String FIELD_PRIMARY_DIAG_CODE = "primaryDiagCode";

	public static final String FIELD_PRIMARY_DIAGNOSIS = "primaryDiagnosis";

	public static final String FIELD_PRIMARY_FACILITY = "primaryFacility";

	public static final String FIELD_PROCEDURE_CODES = "procedureCodes";

	public static final String FIELD_PROVIDER_NAME = "providerName";

	public static final String FIELD_RECEIVED_DATE = "receivedDate";

	public static final String FIELD_REPRICED_AMOUNT = "repricedAmount";

	public static final String FIELD_REPRICED_NETWORK = "repricedNetwork";

	public static final String FIELD_REPRICED_PERCENT = "repricedPercent";

	public static final String FIELD_REPRICED_RANGE = "repricedRange";

	public static final String FIELD_RESULT_CODES = "resultCodes";

	public static final String FIELD_SAVINGS_AMOUNT = "savingsAmount";

	public static final String FIELD_SAVINGS_PERCENT = "savingsPercent";

	public static final String FIELD_SAVINGS_RANGE = "savingsRange";

	public static final String FIELD_SCOPE_GROUP_ID = "scopeGroupId";

	public static final String FIELD_SERVICE_DATE = "serviceDate";

	public static final String FIELD_SPEED_ANSWER_GOAL = "speedAnswerGoal";

	public static final String FIELD_SPEED_OF_ANSWER_GOAL = "speedOfAnswerGoal";

	public static final String FIELD_START_CLAIM_AGING = "startClaimAging";

	public static final String FIELD_START_DATE = "startDate";

	public static final String FIELD_STATE = "state";

	public static final String FIELD_STATUS = "status";

	public static final String FIELD_TREATING_PHYSICIAN = "treatingPhysician";

	public static final String FINANCIAL_EXPOSURE_SORTABLE = Field.getSortableFieldName(FIELD_FINANCIAL_EXPOSURE);

	public static final String FORMAT_NO_DECIMAL_PLACE = "###";

	public static final String FORMAT_ONE_DECIMAL_PLACE = "###.#";

	public static final String FORMAT_THREE_DECIMAL_PLACES = "###.###";

	public static final String FORMAT_TWO_DECIMAL_PLACES = "###.##";

	public static final String GOAL = "goal";

	public static final String HTML_NEW_LINE = "<br/>";

	public static final String INDEX_DATE_FORMAT_PATTERN = PropsUtil.get(PropsKeys.INDEX_DATE_FORMAT_PATTERN);

	public static final String INTERNAL_CARRIER_NAME_KEY = "the-argus-group";

	public static final String PROPS_KEY_LOGIN_BACKDOOR_ENABLED = "login.backdoor.enabled";

	public static final String LEGEND_MAP = "legendMap";

	public static final int LIST_MAX_SIZE = 10000;

	public static final String MMM_DD_SUFFIX = "_mmm_dd";

	public static final String MMM_DD_YYYY_SUFFIX = MMM_DD_SUFFIX + "_yyyy";

	public static final String NAME = "name";

	public static final String NOTE = "Note";

	public static final String NOTE_TYPE_CARRIER = "Carrier Note";

	public static final String NOTE_TYPE_CARRIER_KEY = "030:carrier";

	public static final String ONE_DAY_INTERVAL = "1d";

	public static final String OTH_PORTAL_GROUP_NAME = "OTH Portal";

	public static final String PERCENT_FORMAT = "%.1f%%";

	public static final String PERCENT_FORMAT_CODE = "0%";

	public static final String PRIORITY_KEY = "priorityKey";

	public static final String RECEIVED_DATE_AGG = OTHSearchHelper.getAggregationFieldName(FIELD_RECEIVED_DATE);

	public static final String SAVINGS = "savings";

	public static final String SAVINGS_AMOUNT_AGG = OTHSearchHelper.getAggregationFieldName(FIELD_SAVINGS_AMOUNT);

	public static final String SAVINGS_AMOUNT_SORTABLE = Field.getSortableFieldName(FIELD_SAVINGS_AMOUNT);

	public static final String SAVINGS_MAP = "savingsMap";

	public static final String SAVINGS_PCT_AVG_FORMATTED = "%s Savings";

	public static final String SAVINGS_PERCENT_AGG = OTHSearchHelper.getAggregationFieldName(FIELD_SAVINGS_PERCENT);

	public static final String SAVINGS_PERCENT_AVG_AGG = OTHSearchHelper.getAggregationFieldName(
		FIELD_SAVINGS_PERCENT + AVERAGE_SUFFIX);

	public static final String SAVINGS_PERCENT_SORTABLE = Field.getSortableFieldName(FIELD_SAVINGS_PERCENT);

	public static final String SAVINGS_TOTAL = "savingsTotal";

	public static final String STATUS_CLOSED = "Closed";

	public static final String STATUS_IN_PROGRESS = "In Process";

	public static final String TOTAL = "total";

	public static final String TOTAL_COUNT = "totalCount";

	public static final String TOTAL_FORMATTED = TOTAL + FIELD_FORMATTED_SUFFIX;

	public static final String TOTALS = "totals";

	public static final String VALUE = "value";

	public static final String VALUE_FORMATTED = VALUE + FIELD_FORMATTED_SUFFIX;

	public static final String VALUE_MAP = "valueMap";

	public static final String WHOLE_PERCENT_FORMAT = "%d%%";

}