package com.argus.oth.common;

import com.ibm.icu.text.CompactDecimalFormat;
import com.ibm.icu.util.CurrencyAmount;

import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = CompactNumberFormatter.class)
public class CompactNumberFormatter {

	public String format(double number) {
		return format(number, null, null);
	}

	public String format(double number, Integer minimumFractionDigits, Integer maximumFractionDigits) {
		CompactDecimalFormat cdFormat = CompactDecimalFormat.getInstance(
			Locale.US, CompactDecimalFormat.CompactStyle.SHORT);

		if (Objects.nonNull(minimumFractionDigits)) {
			cdFormat.setMinimumFractionDigits(minimumFractionDigits);
		}

		if (Objects.nonNull(maximumFractionDigits)) {
			cdFormat.setMaximumFractionDigits(maximumFractionDigits);
		}

		Currency currency = Currency.getInstance(Locale.US);

		CurrencyAmount amount = new CurrencyAmount(number, currency);

		return cdFormat.format(amount);
	}

}