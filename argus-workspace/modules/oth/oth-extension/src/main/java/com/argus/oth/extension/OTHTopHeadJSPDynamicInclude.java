package com.argus.oth.extension;

import com.argus.oth.charts.ChartsService;
import com.argus.oth.common.DateFormatter;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.taglib.BaseJSPDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = DynamicInclude.class)
public class OTHTopHeadJSPDynamicInclude extends BaseJSPDynamicInclude {

	@Override
	public void include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String key)
		throws IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String script = StringUtil.replace(
			_TMPL_CONTENT, _KEY_LAYOUT_SET_FRIENDLY_URL,
			_getLayoutSetFriendlyURL(themeDisplay.getLayoutSet(), themeDisplay, httpServletRequest));

		User user = _userLocalService.fetchUser(themeDisplay.getUserId());

		script = StringUtil.replace(script, _KEY_DEFAULT_DATE_RANGE, _getDateRange(user));
		script = StringUtil.replace(script, _KEY_USER_CURRENT_DATE, _getUserCurrentDate(user));

		PrintWriter printWriter = httpServletResponse.getWriter();

		printWriter.write(script);
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register("/html/common/themes/top_js.jspf#resources");
	}

	@Override
	protected String getJspPath() {
		return null;
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private String _getDateRange(User user) {
		if (Objects.isNull(user)) {
			return StringPool.BLANK;
		}

		DateRange dateRange = _chartsService.getDateRange(null, null, user.getTimeZone());

		return _dateFormatter.getFormattedDateRange(dateRange.getStartDate(), dateRange.getEndDate());
	}

	private String _getLayoutSetFriendlyURL(
		LayoutSet layoutSet, ThemeDisplay themeDisplay, HttpServletRequest httpServletRequest) {

		String url = StringPool.BLANK;

		try {
			url = _portal.getLayoutSetFriendlyURL(layoutSet, themeDisplay);

			if (StringUtil.startsWith(url, StringPool.SLASH)) {
				String host = _portal.getPortalURL(httpServletRequest);

				url = host + url;
			}
		}
		catch (PortalException pe) {
			_log.error(pe, pe);
		}

		return url;
	}

	private String _getUserCurrentDate(User user) {
		Date date = new Date();
		Date timezoneDate = _dateFormatter.convertToTimeZone(date, user.getTimeZone());

		return _dateFormatter.getISODateString(timezoneDate);
	}

	private static final String _KEY_DEFAULT_DATE_RANGE = "[$DEFAULT_DATE_RANGE$]";

	private static final String _KEY_LAYOUT_SET_FRIENDLY_URL = "[$LAYOUT_SET_FRIENDLY_URL$]";

	private static final String _KEY_USER_CURRENT_DATE = "[$USER_CURRENT_DATE$]";

	private static final String _TMPL_CONTENT = StringUtil.read(
		OTHTopHeadJSPDynamicInclude.class, "/META-INF/resources/layout_script.tmpl");

	private static final Log _log = LogFactoryUtil.getLog(OTHTopHeadJSPDynamicInclude.class);

	@Reference
	private ChartsService _chartsService;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}