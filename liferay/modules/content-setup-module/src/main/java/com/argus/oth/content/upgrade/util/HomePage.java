package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author kevinccruz
 */
@Component(immediate = true, service = HomePage.class)
public class HomePage extends LayoutUpgradeProcess {

	public void addPage(long userId, long groupId) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		Layout layout = _layoutLocalService.addLayout(
			userId, groupId, true, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, _HOME_PAGE_NAME, _HOME_PAGE_NAME,
			StringPool.BLANK, LayoutConstants.TYPE_PORTLET, false, ContentSetupKeys.HOME_FURL, serviceContext);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, ContentSetupKeys.LAYOUT_3_COLUMNS, false);

		UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

		_layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), typeSettingsProperties.toString());

		// Removes VIEW permissions from the Site Member Role on private pages

		Role siteMember = _roleLocalService.fetchRole(layout.getCompanyId(), RoleConstants.SITE_MEMBER);

		_resourcePermissionLocalService.setResourcePermissions(
			layout.getCompanyId(), Layout.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			String.valueOf(layout.getPlid()), siteMember.getRoleId(), new String[0]);
	}

	public void addPortletsToPage(long groupId, long userId) throws Exception {
		addPortletToPage(
			groupId, userId, ContentSetupKeys.HOME_FURL, ContentSetupKeys.HOMEPAGE_PORTLET, null, "1_column",
			"column-1");
	}

	public void clearTypeSettings(long groupId) throws Exception {
		clearTypeSettings(groupId, ContentSetupKeys.HOME_FURL);
	}

	@Override
	protected void doUpgrade() throws Exception {
	}

	private static final String _HOME_PAGE_NAME = "Home";

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private ResourcePermissionLocalService _resourcePermissionLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

}