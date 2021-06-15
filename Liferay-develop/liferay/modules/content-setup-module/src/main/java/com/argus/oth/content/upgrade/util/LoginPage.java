package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = LoginPage.class)
public class LoginPage extends UpgradeProcess {

	public void addPage(long userId, long groupId) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		serviceContext.setAddGuestPermissions(true);

		Layout layout = _layoutLocalService.addLayout(
			userId, groupId, false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, _LOGIN_PAGE_NAME, _LOGIN_PAGE_NAME,
			StringPool.BLANK, LayoutConstants.TYPE_PORTLET, true, ContentSetupKeys.LOGIN_FURL, serviceContext);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, "1_column", false);

		layoutTypePortlet.addPortletId(userId, _LOGIN_PORTLET, false);

		UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

		_layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), typeSettingsProperties.toString());
	}

	@Override
	protected void doUpgrade() throws Exception {
	}

	private static final String _LOGIN_PAGE_NAME = "Login";

	private static final String _LOGIN_PORTLET = "com_liferay_login_web_portlet_LoginPortlet";

	@Reference
	private LayoutLocalService _layoutLocalService;

}