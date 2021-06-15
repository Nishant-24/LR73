package com.argus.oth.content.upgrade.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactory;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
public abstract class LayoutUpgradeProcess extends UpgradeProcess {

	public void addPortletToPage(long groupId, long userId, String friendlyURL, String portletKey, String viewType)
		throws Exception {

		addPortletToPage(groupId, userId, friendlyURL, portletKey, viewType, "1_column", null);
	}

	public void addPortletToPage(
			long groupId, long userId, String friendlyURL, String portletKey, String viewType,
			String newLayoutTemplateId, String columnId)
		throws Exception {

		Layout layout = layoutLocalService.fetchLayoutByFriendlyURL(groupId, true, friendlyURL);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, newLayoutTemplateId, false);

		String portletId;

		if (!Validator.isBlank(columnId)) {
			portletId = layoutTypePortlet.addPortletId(userId, portletKey, columnId, -1, false);
		}
		else {
			portletId = layoutTypePortlet.addPortletId(userId, portletKey, false);
		}

		layout = layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), layout.getTypeSettings());

		if (Validator.isNotNull(viewType)) {
			_setPagePortletPreferences(layout, portletId, viewType);
		}
	}

	public void clearTypeSettings(long groupId, String friendlyURL) throws Exception {
		Layout layout = layoutLocalService.fetchLayoutByFriendlyURL(groupId, true, friendlyURL);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

		UnicodeProperties properties = layoutTypePortlet.getTypeSettingsProperties();

		properties.clear();
		properties.setProperty("privateLayout", "true");

		layout.setTypeSettingsProperties(properties);

		layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), layout.getTypeSettings());
	}

	@Reference
	protected LayoutLocalService layoutLocalService;

	@Reference
	protected PortletPreferencesFactory portletPreferencesFactory;

	private void _setPagePortletPreferences(Layout layout, String portletId, String viewType) throws Exception {
		PortletPreferences portletPreferences = portletPreferencesFactory.getPortletSetup(
			layout, portletId, StringPool.BLANK);

		portletPreferences.setValue("view", viewType);

		portletPreferences.store();
	}

}