package com.argus.oth.common;

import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = DayFormatter.class)
public class DayFormatter {

	public String formatAvgDays(double days, boolean forceSingular) {
		long daysRounded = Math.round(days);

		String daysCountKey = "x-days-avg";

		if (forceSingular || (daysRounded == 1)) {
			daysCountKey = "x-day-avg";
		}

		return LanguageUtil.format(Locale.getDefault(), daysCountKey, daysRounded);
	}

	public String formatDays(Double days) {
		return formatDays(days, false);
	}

	public String formatDays(Double days, boolean forceSingular) {
		long daysRounded = Math.round(days);

		return formatDays(daysRounded, forceSingular);
	}

	public String formatDays(long days) {
		return formatDays(days, false);
	}

	public String formatDays(long days, boolean forceSingular) {
		String daysCountKey = "x-days";

		if (forceSingular || (days == 1)) {
			daysCountKey = "x-day";
		}

		return LanguageUtil.format(Locale.getDefault(), daysCountKey, days);
	}

}