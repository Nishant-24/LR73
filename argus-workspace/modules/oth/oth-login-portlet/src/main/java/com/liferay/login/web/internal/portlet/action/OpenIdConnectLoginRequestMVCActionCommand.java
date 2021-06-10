package com.liferay.login.web.internal.portlet.action;

import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnect;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectServiceException;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectServiceHandler;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author STPL
 * Overriden liferay's default OpenIdConnectLoginRequestMVCActionCommand 
 * and change javax.portlet.name to our portlet keys
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"mvc.command.name="
				+ OpenIdConnectWebKeys.OPEN_ID_CONNECT_REQUEST_ACTION_NAME }, service = MVCActionCommand.class)
public class OpenIdConnectLoginRequestMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {
			String openIdConnectProviderName = ParamUtil.getString(actionRequest,
					OpenIdConnectWebKeys.OPEN_ID_CONNECT_PROVIDER_NAME);

			HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(actionRequest);

			httpServletRequest = _portal.getOriginalServletRequest(httpServletRequest);

			HttpServletResponse httpServletResponse = _portal.getHttpServletResponse(actionResponse);

			HttpSession session = httpServletRequest.getSession();

			LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(actionResponse);

			ActionURL actionURL = liferayPortletResponse.createActionURL();

			actionURL.setParameter(ActionRequest.ACTION_NAME,
					OpenIdConnectWebKeys.OPEN_ID_CONNECT_RESPONSE_ACTION_NAME);
			actionURL.setParameter("saveLastPath", Boolean.FALSE.toString());

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			if (Validator.isNotNull(redirect)) {
				actionURL.setParameter("redirect", redirect);
			}

			session.setAttribute(OpenIdConnectWebKeys.OPEN_ID_CONNECT_ACTION_URL, actionURL.toString());

			_openIdConnectServiceHandler.requestAuthentication(openIdConnectProviderName, httpServletRequest,
					httpServletResponse);
		} catch (Exception exception) {
			actionResponse.setRenderParameter("mvcRenderCommandName",
					OpenIdConnectWebKeys.OPEN_ID_CONNECT_REQUEST_ACTION_NAME);

			if (exception instanceof OpenIdConnectServiceException) {
				String message = "Unable to communicate with OpenID Connect provider: " + exception.getMessage();

				if (_log.isDebugEnabled()) {
					_log.debug(message, exception);
				}

				if (_log.isWarnEnabled()) {
					_log.warn(message);
				}

				SessionErrors.add(actionRequest, exception.getClass());
			} else if (exception instanceof UserEmailAddressException.MustNotBeDuplicate) {

				if (_log.isDebugEnabled()) {
					_log.debug(exception, exception);
				}

				SessionErrors.add(actionRequest, exception.getClass());
			} else {
				_log.error("Unable to process the OpenID Connect login: " + exception.getMessage(), exception);

				_portal.sendError(exception, actionRequest, actionResponse);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(OpenIdConnectLoginRequestMVCActionCommand.class);

	@Reference
	private OpenIdConnect _openIdConnect;

	@Reference
	private OpenIdConnectServiceHandler _openIdConnectServiceHandler;

	@Reference
	private Portal _portal;

}