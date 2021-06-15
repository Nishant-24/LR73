package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Reference;

public abstract class BaseUpdateRole extends UpgradeProcess {

	protected void addResourcePermission(Role[] roles, String[] actionIds, String resourceName, int scope, long primKey)
		throws Exception {

		long companyId = PortalUtil.getDefaultCompanyId();

		if (ArrayUtil.isNotEmpty(roles)) {
			for (Role role : roles) {
				if (role != null) {
					for (String actionId : actionIds) {
						_resourcePermissionLocalService.addResourcePermission(
							companyId, resourceName, scope, String.valueOf(primKey), role.getRoleId(), actionId);

						if (_log.isInfoEnabled()) {
							_log.info(
								"Added Permission: " + primKey + " to Role: " + role.getName() + " for Resource: " +
									resourceName + " and Action: " + actionId);
						}
					}
				}
			}
		}
	}

	protected Role addRole(String roleName, String description, int roleType, Class<?> clazz) throws Exception {
		long companyId = PortalUtil.getDefaultCompanyId();

		User user = _userLocalService.getDefaultUser(companyId);

		ServiceContext serviceContext = new ServiceContext();

		Map<Locale, String> titleMap = new HashMap<>();

		titleMap.put(LocaleUtil.getDefault(), roleName);

		Map<Locale, String> descriptionMap = new HashMap<>();

		descriptionMap.put(LocaleUtil.getDefault(), description);

		String className = (clazz != null) ? clazz.getName() : null;
		String subtype = null; // subtype is optional, and unused
		long classPK = 0; // Use default class private key
		long userId = user.getUserId();

		Role role = _roleLocalService.fetchRole(companyId, roleName);

		if (Objects.isNull(role)) {
			role = _roleLocalService.addRole(
				userId, className, classPK, roleName, titleMap, descriptionMap, roleType, subtype, serviceContext);

			if (_log.isInfoEnabled()) {
				_log.info("Added role : " + role.getName());
			}
		}

		return role;
	}

	protected void addViewPermissionsToAccountManagementPage(Group group, Role role) throws PortalException {
		Layout accountManagementPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.ACCOUNT_MANAGEMENT_FURL);

		addViewPermissionToPage(accountManagementPage, role);
	}

	protected void addViewPermissionsToClaimsPages(Group group, Role role) throws PortalException {
		Layout claimsPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.CLAIMS_FURL);

		addViewPermissionToPage(claimsPage, role);

		Layout inProcessClaimsPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.IN_PROCESS_CLAIMS_FURL);

		addViewPermissionToPage(inProcessClaimsPage, role);

		Layout processedClaimsPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.PROCESSED_CLAIMS_FURL);

		addViewPermissionToPage(processedClaimsPage, role);

		Layout closedClaimsPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.CLOSED_CLAIMS_FURL);

		addViewPermissionToPage(closedClaimsPage, role);
	}

	protected void addViewPermissionToPage(Layout layout, Role role) throws PortalException {
		_resourcePermissionLocalService.setResourcePermissions(
			layout.getCompanyId(), Layout.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			String.valueOf(layout.getPlid()), role.getRoleId(), new String[] {ActionKeys.VIEW});
	}

	protected Role getCarrierAccountManagerRole(long companyId) {
		return _getRole(companyId, ContentSetupKeys.CARRIER_ACCOUNT_MANAGER);
	}

	protected Role getCarrierCaseManagerRole(long companyId) {
		return _getRole(companyId, ContentSetupKeys.CARRIER_CASE_MANAGER);
	}

	protected Role getPortalAdminRole(long companyId) {
		return _getRole(companyId, ContentSetupKeys.PORTAL_ADMIN);
	}

	protected void updatePermissions(Role role, String resourceName, String[] actionIds, boolean add) {
		long companyId = role.getCompanyId();

		int scope = ResourceConstants.SCOPE_COMPANY;

		if ((role.getType() == RoleConstants.TYPE_ORGANIZATION) || (role.getType() == RoleConstants.TYPE_SITE)) {
			scope = ResourceConstants.SCOPE_GROUP_TEMPLATE;
		}

		for (String actionId : actionIds) {
			try {
				if (add) {
					if (scope == ResourceConstants.SCOPE_COMPANY) {
						_resourcePermissionLocalService.addResourcePermission(
							companyId, resourceName, scope, String.valueOf(role.getCompanyId()), role.getRoleId(),
							actionId);
					}
					else if (scope == ResourceConstants.SCOPE_GROUP_TEMPLATE) {
						_resourcePermissionLocalService.addResourcePermission(
							companyId, resourceName, scope, String.valueOf(GroupConstants.DEFAULT_PARENT_GROUP_ID),
							role.getRoleId(), actionId);
					}
				}
				else {
					_resourcePermissionLocalService.removeResourcePermissions(
						companyId, resourceName, scope, role.getRoleId(), actionId);
				}
			}
			catch (Exception e) {
				StringBundler sb = new StringBundler(7);

				sb.append("unable to update role ");
				sb.append(role.getName());
				sb.append(" with {resourceName:");
				sb.append(resourceName);
				sb.append(", actionId:");
				sb.append(actionId);
				sb.append("}");

				_log.warn(sb.toString());

				if (_log.isDebugEnabled()) {
					_log.error(e);
				}
			}
		}
	}

	@Reference
	protected ResourcePermissionLocalService _resourcePermissionLocalService;

	@Reference
	protected RoleLocalService _roleLocalService;

	@Reference
	protected UserLocalService _userLocalService;

	@Reference
	protected LayoutLocalService layoutLocalService;

	private Role _getRole(long companyId, String name) {
		return _roleLocalService.fetchRole(companyId, name);
	}

	private static Log _log = LogFactoryUtil.getLog(BaseUpdateRole.class);

}