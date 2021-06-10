package com.argus.oth.common;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Calendar;

/**
 * @author Eric Chin
 */
public class OTHSearchHelper {

	public static final BigDecimal BIG_DECIMAL_100 = new BigDecimal(100);

	public static final String SUFFIX_AGG = "agg";

	public static String getAggregationFieldName(String fieldName) {
		if (Validator.isNull(fieldName)) {
			return fieldName;
		}

		return fieldName.concat(
			StringPool.UNDERLINE
		).concat(
			SUFFIX_AGG
		);
	}

	public static double getCalcFieldActualValue(double wholeNumber) {
		BigDecimal wholeNumberBD = BigDecimal.valueOf(wholeNumber);

		BigDecimal actualValue = wholeNumberBD.divide(BIG_DECIMAL_100, 2, RoundingMode.HALF_UP);

		return actualValue.doubleValue();
	}

	public static long getCalcFieldValue(double number) {
		BigDecimal numberBD = BigDecimal.valueOf(number);

		numberBD = numberBD.setScale(2, BigDecimal.ROUND_HALF_UP);

		BigDecimal wholeNumber = numberBD.multiply(BIG_DECIMAL_100);

		return wholeNumber.longValue();
	}

	public static long getDateOffset(long startDateInMillis) {
		Calendar calendar = CalendarFactoryUtil.getCalendar(startDateInMillis);

		long dayOfWeek = GetterUtil.getLong(calendar.get(Calendar.DAY_OF_WEEK));

		long offsetInDays;

		if (dayOfWeek > Calendar.MONDAY) {
			offsetInDays = dayOfWeek - 9;
		}
		else {
			offsetInDays = dayOfWeek - 2;
		}

		return offsetInDays * OTHConstants.DAY_IN_MILLIS;
	}

}