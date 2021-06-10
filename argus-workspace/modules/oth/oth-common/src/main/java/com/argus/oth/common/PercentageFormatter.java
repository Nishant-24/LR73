package com.argus.oth.common;

import com.liferay.portal.kernel.util.GetterUtil;

import java.math.RoundingMode;

import java.text.DecimalFormat;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = PercentageFormatter.class)
public class PercentageFormatter {

	public String formatDecimalForDisplay(double percentage, String decimalFormat, boolean multiply) {
		if (multiply) {
			percentage *= _MULTIPLIER;
		}

		return String.format(OTHConstants.PERCENT_FORMAT, formatNumber(percentage, decimalFormat));
	}

	public double formatNumber(double percentage, String decimalFormat) {
		DecimalFormat df = new DecimalFormat(decimalFormat);

		df.setRoundingMode(RoundingMode.HALF_UP);

		return GetterUtil.getDouble(df.format(percentage));
	}

	public String formatWholeNumberForDisplay(double percentage, boolean multiply) {
		if (multiply) {
			percentage *= _MULTIPLIER;
		}

		return String.format(OTHConstants.WHOLE_PERCENT_FORMAT, Math.round(percentage));
	}

	private static final int _MULTIPLIER = 100;

}