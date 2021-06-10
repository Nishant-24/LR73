package com.argus.oth.claim.ws.application.exporter;

import com.argus.oth.claim.service.ClaimAnalyticsLocalService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.OTHSearchHelper;
import com.argus.oth.common.report.ReportRetrievalParameters;
import com.argus.oth.data.export.BatchEngineExportTaskExecutor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;

import java.io.File;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = ReportingExporter.class)
public class ReportingExporter {

	public File generateReport(ReportRetrievalParameters reportRetrievalParameters) {
		Function<Object, List<ObjectValuePair<Object, String>>> processingFunction = object -> {
			if (!(object instanceof Document)) {
				return new ArrayList<>();
			}

			Document claimAnalyticsDocument = (Document)object;

			List<ObjectValuePair<Object, String>> valueList = new ArrayList<>();

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_CLAIM_NUMBER), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_MEMBER_NAME), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_MEMBER_NUMBER), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_CLAIM_STATUS), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(
					_parseDate(claimAnalyticsDocument.get(OTHConstants.FIELD_RECEIVED_DATE)),
					OTHConstants.DATE_PATTERN_MMM_DD_YYYY));

			valueList.add(
				new ObjectValuePair<>(
					_parseDate(claimAnalyticsDocument.get(OTHConstants.FIELD_SERVICE_DATE)),
					OTHConstants.DATE_PATTERN_MMM_DD_YYYY));

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_COUNTRY), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_STATE), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(claimAnalyticsDocument.get(OTHConstants.FIELD_PROVIDER_NAME), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(
					claimAnalyticsDocument.get(OTHConstants.FIELD_CLIENT_GROUP_NAME), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(
					claimAnalyticsDocument.get(OTHConstants.FIELD_PRIMARY_DIAGNOSIS), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(
					claimAnalyticsDocument.get(OTHConstants.FIELD_DIAGNOSIS_CODES), StringPool.BLANK));

			valueList.add(
				new ObjectValuePair<>(
					claimAnalyticsDocument.get(OTHConstants.FIELD_PROCEDURE_CODES), StringPool.BLANK));

			double chargedAmount = GetterUtil.getDouble(claimAnalyticsDocument.get(OTHConstants.FIELD_CHARGED_AMOUNT));

			valueList.add(
				new ObjectValuePair<>(
					OTHSearchHelper.getCalcFieldActualValue(chargedAmount), OTHConstants.CURRENCY_FORMAT_CODE));

			double repricedAmount = GetterUtil.getDouble(
				claimAnalyticsDocument.get(OTHConstants.FIELD_REPRICED_AMOUNT));

			valueList.add(
				new ObjectValuePair<>(
					OTHSearchHelper.getCalcFieldActualValue(repricedAmount), OTHConstants.CURRENCY_FORMAT_CODE));

			double savingsPercent = OTHSearchHelper.getCalcFieldActualValue(
				GetterUtil.getDouble(claimAnalyticsDocument.get(OTHConstants.FIELD_SAVINGS_PERCENT)));

			valueList.add(new ObjectValuePair<>(_convertToPercent(savingsPercent), OTHConstants.PERCENT_FORMAT_CODE));

			valueList.add(
				new ObjectValuePair<>(
					claimAnalyticsDocument.get(OTHConstants.FIELD_REPRICED_NETWORK), StringPool.BLANK));

			return valueList;
		};

		return _batchEngineExportTaskExecutor.execute(
			_getColumnHeadings(), processingFunction, _claimAnalyticsLocalService::getClaimReportSearchDocuments,
			_claimAnalyticsLocalService.getClaimAnalyticsesCount(), reportRetrievalParameters);
	}

	private double _convertToPercent(double number) {
		return number / 100;
	}

	private List<String> _getColumnHeadings() {
		if (ListUtil.isNotEmpty(_columnHeadings)) {
			return _columnHeadings;
		}

		_columnHeadings = new ArrayList<>();

		_columnHeadings.add("Claim Number");
		_columnHeadings.add("Member Name");
		_columnHeadings.add("Member ID");
		_columnHeadings.add("Status");
		_columnHeadings.add("Received");
		_columnHeadings.add("Serviced");
		_columnHeadings.add("Country");
		_columnHeadings.add("State/Region");
		_columnHeadings.add("Provider Name");
		_columnHeadings.add("Client Name");
		_columnHeadings.add("Primary Diagnosis Code");
		_columnHeadings.add("Diagnosis Codes");
		_columnHeadings.add("Procedure Codes");
		_columnHeadings.add("Charged Amount");
		_columnHeadings.add("Repriced Amount");
		_columnHeadings.add("Savings %");
		_columnHeadings.add("Repriced Network");

		return _columnHeadings;
	}

	private Date _parseDate(String formattedDate) {
		try {
			Date date = _dateFormatter.parseDateFormat(formattedDate, OTHConstants.INDEX_DATE_FORMAT_PATTERN);

			Calendar calendar = CalendarFactoryUtil.getCalendar(date.getTime());

			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);

			return calendar.getTime();
		}
		catch (ParseException pe) {
			return null;
		}
	}

	@Reference
	private BatchEngineExportTaskExecutor _batchEngineExportTaskExecutor;

	@Reference
	private ClaimAnalyticsLocalService _claimAnalyticsLocalService;

	private List<String> _columnHeadings;

	@Reference
	private DateFormatter _dateFormatter;

}