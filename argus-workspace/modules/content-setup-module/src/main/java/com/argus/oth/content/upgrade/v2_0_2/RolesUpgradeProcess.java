package com.argus.oth.content.upgrade.v2_0_2;

import com.argus.oth.common.OTHConstants;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.BaseUpdateRole;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeProcess.class)
public class RolesUpgradeProcess extends BaseUpdateRole {

	@Override
	protected void doUpgrade() {
		long companyId = PortalUtil.getDefaultCompanyId();

		_updateCarrierAccountManagerPermissions(companyId);
		_updateCarrierCaseManagerPermissions(companyId);
		_updatePortalAdministratorPermissions(companyId);
	}

	private void _updateCarrierAccountManagerPermissions(long companyId) {
		Role carrierAccountManager = _roleLocalService.fetchRole(companyId, ContentSetupKeys.CARRIER_ACCOUNT_MANAGER);

		String[] noteActionIds = {ActionKeys.VIEW, OTHConstants.ADD_NOTE};

		updatePermissions(carrierAccountManager, ContentSetupKeys.NOTE_MODEL_NAME, noteActionIds, true);

		String[] taskActionIds = {ActionKeys.VIEW, OTHConstants.ADD_TASK};

		updatePermissions(carrierAccountManager, ContentSetupKeys.TASK_MODEL_NAME, taskActionIds, true);

		String[] customFieldActionIds = {ActionKeys.VIEW};

		updatePermissions(
			carrierAccountManager, ContentSetupKeys.EXPANDO_COLUMN_MODEL_NAME, customFieldActionIds, true);
	}

	private void _updateCarrierCaseManagerPermissions(long companyId) {
		Role carrierCaseManager = _roleLocalService.fetchRole(companyId, ContentSetupKeys.CARRIER_CASE_MANAGER);

		String[] customFieldActionIds = {ActionKeys.VIEW};

		updatePermissions(carrierCaseManager, ContentSetupKeys.EXPANDO_COLUMN_MODEL_NAME, customFieldActionIds, true);
	}

	private void _updatePortalAdministratorPermissions(long companyId) {
		Role portalAdministrator = _roleLocalService.fetchRole(companyId, ContentSetupKeys.PORTAL_ADMIN);

		String[] noteActionIds = {ActionKeys.VIEW, OTHConstants.ADD_NOTE};

		updatePermissions(portalAdministrator, ContentSetupKeys.NOTE_MODEL_NAME, noteActionIds, true);

		String[] taskActionIds = {ActionKeys.VIEW, OTHConstants.ADD_TASK};

		updatePermissions(portalAdministrator, ContentSetupKeys.TASK_MODEL_NAME, taskActionIds, true);

		String[] customFieldActionIds = {ActionKeys.VIEW};

		updatePermissions(portalAdministrator, ContentSetupKeys.EXPANDO_COLUMN_MODEL_NAME, customFieldActionIds, true);
	}

}