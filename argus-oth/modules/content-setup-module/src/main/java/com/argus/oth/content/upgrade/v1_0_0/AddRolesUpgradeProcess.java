package com.argus.oth.content.upgrade.v1_0_0;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.BaseUpdateRole;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeProcess.class)
public class AddRolesUpgradeProcess extends BaseUpdateRole {

	@Override
	protected void doUpgrade() throws Exception {

		// Regular Roles

		String[] groupResourceActionIds = {ActionKeys.VIEW};

		Role carrierCaseManager = addRole(
			ContentSetupKeys.CARRIER_CASE_MANAGER, ContentSetupKeys.CARRIER_CASE_MANAGER_DESC,
			RoleConstants.TYPE_REGULAR, Role.class);

		Role carrierAccountManager = addRole(
			ContentSetupKeys.CARRIER_ACCOUNT_MANAGER, ContentSetupKeys.CARRIER_ACCOUNT_MANAGER_DESC,
			RoleConstants.TYPE_REGULAR, Role.class);

		addRole(
			ContentSetupKeys.PORTAL_ADMIN, ContentSetupKeys.PORTAL_ADMIN_DESC, RoleConstants.TYPE_REGULAR, Role.class);

		Role othUserAdministrator = addRole(
			ContentSetupKeys.OTH_USER_ADMIN, ContentSetupKeys.OTH_USER_ADMIN_DESC, RoleConstants.TYPE_REGULAR,
			Role.class);

		Role dataAdministrator = addRole(
			ContentSetupKeys.DATA_ADMIN, ContentSetupKeys.DATA_ADMIN_DESC, RoleConstants.TYPE_REGULAR, Role.class);

		Role[] regularRoles = {carrierCaseManager, carrierAccountManager, othUserAdministrator, dataAdministrator};

		addResourcePermission(
			regularRoles, groupResourceActionIds, ContentSetupKeys.GROUP_MODEL_RESOURCE_NAME,
			ResourceConstants.SCOPE_COMPANY, GroupConstants.DEFAULT_PARENT_GROUP_ID);

		// Site Roles

		String[] siteResourceActionIds = {ActionKeys.VIEW};

		Role contentCreatorRole = addRole(
			ContentSetupKeys.CONTENT_CREATOR, ContentSetupKeys.CONTENT_CREATOR_DESC, RoleConstants.TYPE_SITE,
			Role.class);

		Role[] siteRoles = {contentCreatorRole};

		addResourcePermission(
			siteRoles, siteResourceActionIds, ContentSetupKeys.GROUP_MODEL_RESOURCE_NAME,
			ResourceConstants.SCOPE_GROUP_TEMPLATE, GroupConstants.DEFAULT_PARENT_GROUP_ID);

		// Add Permissions to Roles

		Group othPortalGroup = _fetchOTHPortalGroup(carrierAccountManager.getCompanyId());

		_addCarrierCaseManagerPermissions(othPortalGroup, carrierCaseManager);
		_addCarrierAccountManagerPermissions(othPortalGroup, carrierAccountManager);
		_addOthUserAdministratorPermissions(othUserAdministrator);
	}

	private void _addCarrierAccountManagerPermissions(Group group, Role carrierAccountManager) throws PortalException {
		_addViewPermissionsToCasesPages(group, carrierAccountManager);

		_addViewPermissionsToDashboardPage(group, carrierAccountManager);

		addViewPermissionsToClaimsPages(group, carrierAccountManager);

		addViewPermissionsToAccountManagementPage(group, carrierAccountManager);
	}

	private void _addCarrierCaseManagerPermissions(Group group, Role carrierCaseManager) throws PortalException {
		_addViewPermissionsToCasesPages(group, carrierCaseManager);

		_addViewPermissionsToDashboardPage(group, carrierCaseManager);

		addViewPermissionsToClaimsPages(group, carrierCaseManager);

		addViewPermissionsToAccountManagementPage(group, carrierCaseManager);
	}

	private void _addOthUserAdministratorPermissions(Role othUserAdministrator) throws Exception {

		// Portal

		String[] portalActionIds = {ActionKeys.ADD_USER, ActionKeys.VIEW_CONTROL_PANEL};

		updatePermissions(othUserAdministrator, ContentSetupKeys.PORTAL, portalActionIds, true);

		// Roles

		String[] rolesAdminActionIds = {ActionKeys.VIEW};

		updatePermissions(othUserAdministrator, ContentSetupKeys.ROLES_ADMIN_PORTLET, rolesAdminActionIds, true);

		String[] roleActionIds = {ActionKeys.VIEW, ActionKeys.ASSIGN_MEMBERS};

		updatePermissions(othUserAdministrator, ContentSetupKeys.ROLE_MODEL_NAME, roleActionIds, true);

		// Settings

		String[] sitePermissions = {
			ActionKeys.ASSIGN_MEMBERS, ActionKeys.ASSIGN_USER_ROLES, ActionKeys.VIEW, ActionKeys.VIEW_MEMBERS
		};

		updatePermissions(othUserAdministrator, Group.class.getName(), sitePermissions, true);

		// Users and Organizations

		String[] usersAdminActionIds = {ActionKeys.VIEW, ActionKeys.ACCESS_IN_CONTROL_PANEL};

		updatePermissions(othUserAdministrator, ContentSetupKeys.USERS_ADMIN_PORTLET, usersAdminActionIds, true);

		String[] usersActionIds = {
			ActionKeys.VIEW, ActionKeys.DELETE, ActionKeys.IMPERSONATE, ActionKeys.PERMISSIONS, ActionKeys.UPDATE
		};

		updatePermissions(othUserAdministrator, ContentSetupKeys.USERS_MODEL_NAME, usersActionIds, true);
	}

	private void _addViewPermissionsToCasesPages(Group group, Role role) throws PortalException {
		Layout casesPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.CASES_FURL);

		addViewPermissionToPage(casesPage, role);

		Layout myBookmarksPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.MY_BOOKMARKS_FURL);

		addViewPermissionToPage(myBookmarksPage, role);

		Layout recentlyViewedPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.RECENTLY_VIEWED_FURL);

		addViewPermissionToPage(recentlyViewedPage, role);
	}

	private void _addViewPermissionsToDashboardPage(Group group, Role role) throws PortalException {
		Layout dashboardPage = layoutLocalService.fetchLayoutByFriendlyURL(
			group.getGroupId(), true, ContentSetupKeys.HOME_FURL);

		addViewPermissionToPage(dashboardPage, role);
	}

	private Group _fetchOTHPortalGroup(long companyId) {
		return _groupLocalService.fetchFriendlyURLGroup(companyId, ContentSetupKeys.OTH_PORTAL_FURL);
	}

	@Reference
	private GroupLocalService _groupLocalService;

}