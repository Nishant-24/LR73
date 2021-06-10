package com.argus.oth.content.upgrade.util;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
public abstract class BaseClaimsPage extends LayoutUpgradeProcess {

	protected long addPage(
			long userId, long groupId, String name, String title, String friendlyURL, long parentLayoutId)
		throws PortalException {

		Layout page = layoutLocalService.fetchLayoutByFriendlyURL(groupId, true, friendlyURL);

		if (Objects.nonNull(page)) {
			return page.getLayoutId();
		}

		Layout layout = layoutLocalService.addLayout(
			userId, groupId, true, parentLayoutId, name, title, StringPool.BLANK, LayoutConstants.TYPE_PORTLET, false,
			friendlyURL, _getServiceContext());

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, "1_column", false);

		UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

		layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), typeSettingsProperties.toString());

		// Removes VIEW permissions from the Site Member Role on private pages

		Role siteMember = roleLocalService.fetchRole(layout.getCompanyId(), RoleConstants.SITE_MEMBER);

		resourcePermissionLocalService.setResourcePermissions(
			layout.getCompanyId(), Layout.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			String.valueOf(layout.getPlid()), siteMember.getRoleId(), new String[0]);

		return layout.getLayoutId();
	}

	protected long updateLayoutTitle(long groupId, String friendlyURL, String newLayoutName) throws PortalException {
		Layout layout = layoutLocalService.fetchLayoutByFriendlyURL(groupId, true, friendlyURL);

		Map<Locale, String> titleMap = layout.getTitleMap();

		titleMap.put(LocaleUtil.fromLanguageId(layout.getDefaultLanguageId()), newLayoutName);

		layoutLocalService.updateLayout(
			groupId, layout.getPrivateLayout(), layout.getLayoutId(), layout.getParentLayoutId(), layout.getNameMap(),
			titleMap, layout.getDescriptionMap(), layout.getKeywordsMap(), layout.getRobotsMap(), layout.getType(),
			layout.getHidden(), layout.getFriendlyURLMap(), layout.isIconImage(), new byte[0], _getServiceContext());

		return layout.getLayoutId();
	}

	@Reference
	protected ResourcePermissionLocalService resourcePermissionLocalService;

	@Reference
	protected RoleLocalService roleLocalService;

	private ServiceContext _getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		return serviceContext;
	}

}