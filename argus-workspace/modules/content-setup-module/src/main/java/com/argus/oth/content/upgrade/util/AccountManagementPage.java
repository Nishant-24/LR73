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
@Component(immediate = true, service = AccountManagementPage.class)
public class AccountManagementPage extends LayoutUpgradeProcess {

	public void addPage(long userId, long groupId) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		Layout layout = layoutLocalService.addLayout(
			userId, groupId, true, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
			ContentSetupKeys.ACCOUNT_MANAGEMENT_PAGE_NAME, ContentSetupKeys.ACCOUNT_MANAGEMENT_PAGE_TITLE,
			StringPool.BLANK, LayoutConstants.TYPE_PORTLET, false, ContentSetupKeys.ACCOUNT_MANAGEMENT_FURL,
			serviceContext);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, "1_column", false);

		UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

		layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), typeSettingsProperties.toString());

		// Removes VIEW permissions from the Site Member Role on private pages

		Role siteMember = _roleLocalService.fetchRole(layout.getCompanyId(), RoleConstants.SITE_MEMBER);

		_resourcePermissionLocalService.setResourcePermissions(
			layout.getCompanyId(), Layout.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			String.valueOf(layout.getPlid()), siteMember.getRoleId(), new String[0]);
	}

	public void addPortletToPage(long userId, long groupId) throws Exception {
		addPortletToPage(
			userId, groupId, ContentSetupKeys.ACCOUNT_MANAGEMENT_FURL, ContentSetupKeys.ACCOUNT_MANAGEMENT_PORTLET,
			ContentSetupKeys.ACCOUNT_MANAGEMENT_VIEW_TYPE_OPERATIONAL_SLAS);
	}

	@Override
	protected void doUpgrade() throws Exception {
	}

	@Reference
	private ResourcePermissionLocalService _resourcePermissionLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

}