package com.argus.oth.hook.filter;

import com.argus.oth.hook.filter.configuration.OthLoginFilterConfigurator;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnect;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectServiceHandler;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author kevincruz
 */
@Component(
	immediate = true,
	property = {
		"dispatcher=FORWARD", "dispatcher=REQUEST", "servlet-context-name=", "servlet-filter-name=OTH Login Filter",
		"servlet-filter-impl=com.argus.oth.hook.filter.OthLoginFilter", "url-pattern=/*"
	},
	service = Filter.class
)
public class OthLoginFilter extends BaseFilter {

	@Override
	public boolean isFilterEnabled(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String currentURL = (String)httpServletRequest.getAttribute(WebKeys.CURRENT_URL);

		if (currentURL.startsWith("/c") || currentURL.startsWith("/o")) {
			return false;
		}

		String ppid = httpServletRequest.getParameter("p_p_id");
		String state = httpServletRequest.getParameter("p_p_state");

		if ((Objects.equals(ppid, PortletKeys.LOGIN) || Objects.equals(ppid, PortletKeys.FAST_LOGIN)) &&
			Objects.equals(state, LiferayWindowState.MAXIMIZED.toString())) {

			return false;
		}

		return true;
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	@Override
	protected void processFilter(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
		throws Exception {

		boolean openIdConnectEnabled = _openIdConnect.isEnabled(_portal.getCompanyId(httpServletRequest));

		if (!openIdConnectEnabled) {
			filterChain.doFilter(httpServletRequest, httpServletResponse);

			return;
		}

		User currentUser = _portal.getUser(httpServletRequest);

		boolean shouldRedirect = _othLoginFilterConfigurator.shouldRedirectExternalUser();

		String currentURL = (String)httpServletRequest.getAttribute(WebKeys.CURRENT_URL);
		String providerName = _othLoginFilterConfigurator.getOpenIdConnectProviderName();
		String adminPathPrefix = _othLoginFilterConfigurator.getAdminPathPrefix();

		if (Validator.isNotNull(adminPathPrefix) && currentURL.startsWith(_getAdminPath())) {
			providerName = _othLoginFilterConfigurator.getAdminProviderName();

			shouldRedirect = true;
		}

		if (shouldRedirect && (currentUser == null) && Validator.isNotNull(providerName)) {
			_setRedirect(httpServletRequest, currentURL);

			_openIdConnectServiceHandler.requestAuthentication(providerName, httpServletRequest, httpServletResponse);

			return;
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	private String _getAdminPath() {
		String adminPath = _othLoginFilterConfigurator.getAdminPathPrefix();

		if (Validator.isNull(adminPath)) {
			return StringPool.FORWARD_SLASH;
		}

		return StringPool.FORWARD_SLASH + adminPath;
	}

	private void _setRedirect(HttpServletRequest httpServletRequest, String redirect) {
		httpServletRequest = _portal.getOriginalServletRequest(httpServletRequest);

		HttpSession session = httpServletRequest.getSession();

		if (Validator.isNull(redirect) || redirect.startsWith(_getAdminPath())) {
			redirect = StringPool.FORWARD_SLASH;
		}

		session.setAttribute(OpenIdConnectWebKeys.OPEN_ID_CONNECT_ACTION_URL, redirect);
	}

	private static final Log _log = LogFactoryUtil.getLog(OthLoginFilter.class);

	@Reference
	private OpenIdConnect _openIdConnect;

	@Reference
	private OpenIdConnectServiceHandler _openIdConnectServiceHandler;

	@Reference
	private OthLoginFilterConfigurator _othLoginFilterConfigurator;

	@Reference
	private Portal _portal;

}