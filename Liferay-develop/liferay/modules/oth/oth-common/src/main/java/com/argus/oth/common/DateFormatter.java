package com.argus.oth.common;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.math.RoundingMode;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.Instant;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = DateFormatter.class)
public class DateFormatter {

	public Date convertToTimeZone(Date date, TimeZone timeZone) {
		return _convertDate(date, timeZone);
	}

	public Date convertToUTC(Date date) {
		return _convertDate(date, TimeZone.getTimeZone(StringPool.UTC));
	}

	public DateFormat getDefaultDateFormatter() {
		return DateFormatFactoryUtil.getSimpleDateFormat(OTHConstants.DATE_PATTERN_DEFAULT);
	}

	public Date getEndDate(Date endDate) {
		Calendar endDateCalendar = CalendarFactoryUtil.getCalendar();

		endDateCalendar.setTime(endDate);

		endDateCalendar.set(Calendar.HOUR_OF_DAY, 23);
		endDateCalendar.set(Calendar.MINUTE, 59);
		endDateCalendar.set(Calendar.SECOND, 59);
		endDateCalendar.set(Calendar.MILLISECOND, 999);

		return endDateCalendar.getTime();
	}

	public String getFormattedDate(Date date, String pattern, String blankValue) {
		if (Objects.isNull(date)) {
			return blankValue;
		}

		DateFormat dateFormatter = new SimpleDateFormat(pattern);

		return dateFormatter.format(date);
	}

	public String getFormattedDateRange(Date startDate, Date endDate) {
		StringBundler dateRangeSB = new StringBundler();

		dateRangeSB.append(getFormattedDate(startDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK));
		dateRangeSB.append(StringPool.SPACE);
		dateRangeSB.append(StringPool.DASH);
		dateRangeSB.append(StringPool.SPACE);
		dateRangeSB.append(getFormattedDate(endDate, OTHConstants.DATE_PATTERN_MMM_DD_YYYY, StringPool.BLANK));

		return dateRangeSB.toString();
	}

	public String getFormattedDateTime(Date date, TimeZone timeZone, String blankValue) {
		if (Objects.isNull(date)) {
			return blankValue;
		}

		StringBundler dateSB = new StringBundler();

		dateSB.append(_getFormattedDate(date, timeZone, blankValue));

		dateSB.append(StringPool.SPACE);
		dateSB.append(StringPool.AT);
		dateSB.append(StringPool.SPACE);

		dateSB.append(_getFormattedTime(date.getTime(), timeZone));

		dateSB.append(StringPool.SPACE);
		dateSB.append(getTimeZoneDisplay(date, timeZone));

		return dateSB.toString();
	}

	public String getFormattedDay(Date date, String blankValue) {
		if (Objects.isNull(date)) {
			return blankValue;
		}

		DateFormat dateFormatter = new SimpleDateFormat(OTHConstants.DATE_PATTERN_MMM_DD);

		return dateFormatter.format(date);
	}

	public String getFormattedDefaultDate(Date date) {
		return getDefaultDateFormatter().format(date);
	}

	public String getFormattedSeconds(double number, String decimalFormat) {
		return getFormattedSeconds(number, decimalFormat, true);
	}

	public String getFormattedSeconds(double number, String decimalFormat, boolean simpleFormat) {
		DecimalFormat df = new DecimalFormat(decimalFormat);

		df.setRoundingMode(RoundingMode.HALF_UP);

		String formatLanguageKey = _SECONDS_UNIT_COUNT_KEY;

		if (!simpleFormat) {
			formatLanguageKey = _SECONDS_COUNT_KEY;
		}

		return LanguageUtil.format(Locale.getDefault(), formatLanguageKey, df.format(number));
	}

	public String getISODateString(Date date) {
		if (Objects.isNull(date)) {
			return null;
		}

		Instant instant = date.toInstant();

		return instant.toString();
	}

	public Date getStartDate(Date startDate, Date endDate) {
		Calendar startDateCalendar = CalendarFactoryUtil.getCalendar();

		if (Objects.isNull(startDate)) {
			startDateCalendar.setTime(endDate);

			startDateCalendar.add(Calendar.DAY_OF_YEAR, -1 * ((_DEFAULT_PAST_WEEKS_DIFFERENCE * _DAYS_PER_WEEK) - 1));
		}
		else {
			startDateCalendar.setTime(startDate);
		}

		startDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
		startDateCalendar.set(Calendar.MINUTE, 0);
		startDateCalendar.set(Calendar.SECOND, 0);
		startDateCalendar.set(Calendar.MILLISECOND, 0);

		return startDateCalendar.getTime();
	}

	public String getTimeZoneDisplay(Date date, TimeZone timeZone) {
		if (Objects.isNull(timeZone)) {
			return StringPool.BLANK;
		}

		boolean inDaylightTime = timeZone.inDaylightTime(date);

		return timeZone.getDisplayName(inDaylightTime, TimeZone.SHORT);
	}

	public Date parseDateFormat(String dateString, String dateFormatString) throws ParseException {
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(dateFormatString);

		return dateFormat.parse(dateString);
	}

	public Date parseDefaultDateFormat(String dateString) throws ParseException {
		return getDefaultDateFormatter().parse(dateString);
	}

	private Date _convertDate(Date date, TimeZone timeZone) {
		if (Objects.isNull(date)) {
			return null;
		}

		DateTime dateTime = new DateTime(date);

		DateTime convertedDateTime = dateTime.withZone(DateTimeZone.forTimeZone(timeZone));

		return convertedDateTime.toLocalDateTime(
		).toDate();
	}

	private DateFormat _getDateFormatter(TimeZone timeZone) {
		DateFormat dateFormatter = new SimpleDateFormat(OTHConstants.DATE_PATTERN_MMM_DD_YYYY);

		if (!Objects.isNull(timeZone)) {
			dateFormatter.setTimeZone(timeZone);
		}

		return dateFormatter;
	}

	private String _getFormattedDate(Date date, TimeZone timeZone, String blankValue) {
		if (Objects.isNull(date)) {
			return blankValue;
		}

		DateFormat dateFormatter = _getDateFormatter(timeZone);

		return dateFormatter.format(date);
	}

	private String _getFormattedTime(long time, TimeZone timeZone) {
		DateFormat timeFormatter = new SimpleDateFormat(OTHConstants.DATE_PATTERN_H_MM_AA);

		timeFormatter.setTimeZone(timeZone);

		return timeFormatter.format(time);
	}

	private static final int _DAYS_PER_WEEK = 7;

	private static final int _DEFAULT_PAST_WEEKS_DIFFERENCE = 4;

	private static final String _SECONDS_COUNT_KEY = "x-seconds";

	private static final String _SECONDS_UNIT_COUNT_KEY = "x-s";

}