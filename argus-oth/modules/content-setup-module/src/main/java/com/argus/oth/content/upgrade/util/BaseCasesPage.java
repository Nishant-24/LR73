package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
public abstract class BaseCasesPage extends LayoutUpgradeProcess {

	protected long addPage(
			long userId, long groupId, String name, String title, String friendlyURL, long parentLayoutId,
			String viewType)
		throws Exception {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		Layout layout = layoutLocalService.addLayout(
			userId, groupId, true, parentLayoutId, name, title, StringPool.BLANK, LayoutConstants.TYPE_PORTLET, false,
			friendlyURL, serviceContext);

		addPortletToPage(groupId, userId, friendlyURL, ContentSetupKeys.CASES_PORTLET, viewType);

		// Removes VIEW permissions from the Site Member Role on private pages

		Role siteMember = roleLocalService.fetchRole(layout.getCompanyId(), RoleConstants.SITE_MEMBER);

		resourcePermissionLocalService.setResourcePermissions(
			layout.getCompanyId(), Layout.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			String.valueOf(layout.getPlid()), siteMember.getRoleId(), new String[0]);

		return layout.getLayoutId();
	}

	@Reference
	protected ResourcePermissionLocalService resourcePermissionLocalService;

	@Reference
	protected RoleLocalService roleLocalService;

}