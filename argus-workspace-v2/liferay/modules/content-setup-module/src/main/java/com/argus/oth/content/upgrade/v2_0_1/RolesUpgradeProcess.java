package com.argus.oth.content.upgrade.v2_0_1;

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

		_updateCarrierCaseManagerPermissions(companyId);
		_updateOthUserAdministratorPermissions(companyId);
	}

	private void _updateCarrierCaseManagerPermissions(long companyId) {
		Role carrierCaseManager = _roleLocalService.fetchRole(companyId, ContentSetupKeys.CARRIER_CASE_MANAGER);

		String[] noteActionIds = {ActionKeys.VIEW, OTHConstants.ADD_NOTE};

		updatePermissions(carrierCaseManager, ContentSetupKeys.NOTE_MODEL_NAME, noteActionIds, true);

		String[] taskActionIds = {ActionKeys.VIEW, OTHConstants.ADD_TASK};

		updatePermissions(carrierCaseManager, ContentSetupKeys.TASK_MODEL_NAME, taskActionIds, true);
	}

	private void _updateOthUserAdministratorPermissions(long companyId) {
		Role othUserAdministrator = _roleLocalService.fetchRole(companyId, ContentSetupKeys.OTH_USER_ADMIN);

		// Custom Fields

		String[] customFieldsActionIds = {ActionKeys.VIEW, ActionKeys.UPDATE};

		updatePermissions(
			othUserAdministrator, ContentSetupKeys.EXPANDO_COLUMN_MODEL_NAME, customFieldsActionIds, true);
	}

}