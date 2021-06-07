package com.argus.oth.extension.theme;

import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.common.ExpandoConstants;
import com.argus.oth.common.OTHConstants;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true, property = "type=" + TemplateContextContributor.TYPE_THEME,
	service = TemplateContextContributor.class
)
public class OTHThemeTemplateContextContributor implements TemplateContextContributor {

	@Override
	public void prepare(Map<String, Object> contextObjects, HttpServletRequest httpServletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		User user = themeDisplay.getUser();

		ExpandoBridge expandoBridge = user.getExpandoBridge();

		boolean isExternalUser = false;

		if (expandoBridge.hasAttribute(ExpandoConstants.EXTERNAL_USER)) {
			isExternalUser = GetterUtil.getBoolean(expandoBridge.getAttribute(ExpandoConstants.EXTERNAL_USER, false));
		}

		String carrierName = LanguageUtil.get(httpServletRequest, OTHConstants.INTERNAL_CARRIER_NAME_KEY);

		if (isExternalUser && expandoBridge.hasAttribute(ExpandoConstants.CLIENT_ID)) {
			long clientId = GetterUtil.getLong(expandoBridge.getAttribute(ExpandoConstants.CLIENT_ID, false));

			Client client = _clientLocalService.fetchClientByExternalClientId(clientId);

			if (Objects.nonNull(client)) {
				carrierName = client.getClientName();
			}
		}

		contextObjects.put("carrierName", carrierName);
	}

	@Reference
	private ClientLocalService _clientLocalService;

}