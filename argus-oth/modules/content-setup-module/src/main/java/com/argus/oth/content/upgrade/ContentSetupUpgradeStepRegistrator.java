package com.argus.oth.content.upgrade;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author kevincruz
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0", _addOthSiteUpgradeProcess, _addRolesUpgradeProcess, _addUsersUpgradeProcess,
			_addCustomFieldsUpgradeProcess);

		registry.register("1.0.0", "2.0.0", _deleteOldClientUpgradeProcess);

		registry.register("2.0.0", "2.0.1", _rolesUpgradeProcess);

		registry.register("2.0.1", "2.0.2", _rolesUpgradeProcess_v2_0_2);

		registry.register("2.0.2", "2.0.3", _rolesUpgradeProcess_v2_0_3);

		registry.register("2.0.3", "2.0.4", _rolesUpgradeProcess_v2_0_4);

		registry.register("2.0.4", "2.0.5", _updateCustomFieldsUpgradeProcess);

		registry.register("2.0.5", "2.0.6", _pagesUpgradeProcess, _rolesUpgradeProcess_v2_0_6);

		registry.register("2.0.6", "6.0.0", _claimsPagesUpgradeProcess, _accountManagementPageUpgradeProcess);

		registry.register("6.0.0", "6.0.1", new DummyUpgradeStep());

		registry.register("6.0.1", "6.0.2", _rolesUpgradeProcess_v6_0_2);

		registry.register("6.0.2", "6.0.3", _dataAdminUserUpgradeProcess);

		registry.register("6.0.3", "6.0.4", _homePageUpgradeProcess);

		registry.register("6.0.4", "6.0.5", _renameClaimsDashboardUpgradeProcess);
	}

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v6_0_0.AccountManagementPageUpgradeProcess)")
	private UpgradeProcess _accountManagementPageUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v1_0_0.AddCustomFieldsUpgradeProcess)")
	private UpgradeProcess _addCustomFieldsUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v1_0_0.AddOthSiteUpgradeProcess)")
	private UpgradeProcess _addOthSiteUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v1_0_0.AddRolesUpgradeProcess)")
	private UpgradeProcess _addRolesUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v1_0_0.AddUsersUpgradeProcess)")
	private UpgradeProcess _addUsersUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v6_0_0.ClaimsPagesUpgradeProcess)")
	private UpgradeProcess _claimsPagesUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v6_0_3.DataAdminUserUpgradeProcess)")
	private UpgradeProcess _dataAdminUserUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_0.DeleteOldClientUpgradeProcess)")
	private UpgradeProcess _deleteOldClientUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.common.HomePageUpgradeProcess)")
	private UpgradeProcess _homePageUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_6.PagesUpgradeProcess)")
	private UpgradeProcess _pagesUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v6_0_5.RenameClaimsDashboardUpgradeProcess)")
	private UpgradeProcess _renameClaimsDashboardUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_1.RolesUpgradeProcess)")
	private UpgradeProcess _rolesUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_2.RolesUpgradeProcess)")
	private UpgradeProcess _rolesUpgradeProcess_v2_0_2;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_3.RolesUpgradeProcess)")
	private UpgradeProcess _rolesUpgradeProcess_v2_0_3;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_4.RolesUpgradeProcess)")
	private UpgradeProcess _rolesUpgradeProcess_v2_0_4;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_6.RolesUpgradeProcess)")
	private UpgradeProcess _rolesUpgradeProcess_v2_0_6;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v6_0_2.RolesUpgradeProcess)")
	private UpgradeProcess _rolesUpgradeProcess_v6_0_2;

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.v2_0_5.UpdateCustomFieldsUpgradeProcess)")
	private UpgradeProcess _updateCustomFieldsUpgradeProcess;

	@Reference(target = "(javax.portlet.name=" + ContentSetupKeys.USERS_ADMIN_PORTLET + ")")
	private Portlet _usersAdminWebPortlet;

}