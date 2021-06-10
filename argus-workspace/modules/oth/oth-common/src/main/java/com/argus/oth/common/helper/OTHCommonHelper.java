package com.argus.oth.common.helper;

import com.argus.oth.common.CompactNumberFormatter;
import com.argus.oth.common.ExpandoConstants;
import com.argus.oth.common.OTHConstants;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = OTHCommonHelper.class)
public class OTHCommonHelper {

	public String formatAmountByStatus(
		double amount, String status, Integer minimumFractionDigits, Integer maximumFractionDigits) {

		String label = StringPool.BLANK;

		switch (status) {
			case "In Process":
				label = LanguageUtil.get(Locale.getDefault(), "charged");

				break;
			case "Processed":
				label = LanguageUtil.get(Locale.getDefault(), "repriced");

				break;
			case "Closed":
				label = LanguageUtil.get(Locale.getDefault(), "paid");

				break;
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_compactNumberFormatter.format(amount, minimumFractionDigits, maximumFractionDigits));
		sb.append(StringPool.SPACE);
		sb.append(label);

		return sb.toString();
	}

	public String formatClaims(long count) {
		String claimCountKey = "x-claims";

		if (count == 1) {
			claimCountKey = "x-claim";
		}

		DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance(Locale.US);

		return LanguageUtil.format(Locale.getDefault(), claimCountKey, formatter.format(count));
	}

	public String formatDate_yyyyMMddHHmmssZ(Date date) {
		if (Objects.isNull(date)) {
			return null;
		}

		DateFormat dateFormat = getDateFormat_yyyyMMddHHmmssZ();

		return dateFormat.format(date);
	}

	public DateFormat getDateFormat_yyyyMMddHHmmssZ() {
		return DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	public Group getOTHPortalGroup() {
		return _groupLocalService.fetchGroup(_portal.getDefaultCompanyId(), OTHConstants.OTH_PORTAL_GROUP_NAME);
	}

	public long getOTHPortalGroupId() {
		Group group = getOTHPortalGroup();

		if (Objects.isNull(group)) {
			return OTHConstants.DEFAULT_GROUP_ID;
		}

		return group.getGroupId();
	}

	public Date parseDate(String dateString) throws ParseException {
		return DateUtil.parseDate(OTHConstants.DATE_PATTERN, dateString, Locale.getDefault());
	}

	public Date parseDate(String string, String datePattern) {
		if (blankNullOrNullString(string)) {
			return null;
		}

		try {
			return DateUtil.parseDate(datePattern, string, Locale.getDefault());
		}
		catch (ParseException pe) {
			_log.error("Failed to parse " + string + " to Date");

			return new Date(0);
		}
	}

	public Date parseDate_yyyyMMddHHmmsss(String string) {
		return parseDate(string, "yyyy-MM-dd'T'HH:mm:sss");
	}

	public String processNewLines(String text) {
		return StringUtil.replace(text, StringPool.NEW_LINE, OTHConstants.HTML_NEW_LINE);
	}

	public void setUserClientId(User user, String clientId) {
		ExpandoBridge expandoBridge = user.getExpandoBridge();

		if (!expandoBridge.hasAttribute(ExpandoConstants.CLIENT_ID)) {
			return;
		}

		expandoBridge.setAttribute(ExpandoConstants.CLIENT_ID, clientId, false);
	}

	protected boolean blankNullOrNullString(String string) {
		return Validator.isBlank(string) || (string.compareToIgnoreCase(_NULL) == 0) || string.matches(_ZEROS_REGEX);
	}

	private static final String _NULL = "NULL";

	private static final String _ZEROS_REGEX = "0+";

	private static final Log _log = LogFactoryUtil.getLog(OTHCommonHelper.class);

	@Reference
	private CompactNumberFormatter _compactNumberFormatter;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private Portal _portal;

}