package com.argus.oth.hook.logout;

import com.argus.oth.hook.logout.configuration.AzureADConfigurator;
import com.argus.oth.integration.auth0.Auth0Integration;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnect;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectServiceHandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(immediate = true, property = "key=logout.events.post", service = LifecycleAction.class)
public class LogoutPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		HttpServletRequest request = lifecycleEvent.getRequest();

		boolean openIdConnectEnabled = _openIdConnect.isEnabled(_portal.getCompanyId(request));

		if (openIdConnectEnabled) {
			try {
				User user = _portal.getUser(request);

				ExpandoBridge expandoBridge = user.getExpandoBridge();

				boolean externalUser = GetterUtil.getBoolean(expandoBridge.getAttribute("external-user", false), true);

				String logoutUrl = null;

				if (externalUser) {
					logoutUrl = _getAuth0LogoutURL();
				}
				else {
					logoutUrl = _getAzureADLogoutURL();
				}

				lifecycleEvent.getResponse(
				).sendRedirect(
					logoutUrl
				);
			}
			catch (IOException | PortalException e) {
				if (_log.isWarnEnabled()) {
					_log.warn("External logout not executed", e);
				}
			}
		}
	}

	private String _getAuth0LogoutURL() {
		return _auth0Integration.getLogoutURL();
	}

	private String _getAzureADLogoutURL() {
		return _azureADConfigurator.logoutURL();
	}

	private static final Log _log = LogFactoryUtil.getLog(LogoutPostAction.class);

	@Reference
	private Auth0Integration _auth0Integration;

	@Reference
	private AzureADConfigurator _azureADConfigurator;

	@Reference
	private OpenIdConnect _openIdConnect;

	@Reference
	private OpenIdConnectServiceHandler _openIdConnectServiceHandler;

	@Reference
	private Portal _portal;
}