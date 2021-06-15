package com.argus.oth.content.upgrade.v6_0_2;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.BaseUpdateRole;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RolesUpgradeProcess extends BaseUpdateRole {

	@Override
	protected void doUpgrade() {
		long companyId = PortalUtil.getDefaultCompanyId();

		_updateCarrierAccountManagerPermissions(companyId);

		_updateCarrierCaseManagerPermissions(companyId);
	}

	private void _addCasesPermissions(Role role) {
		String[] casesActionIds = {ActionKeys.VIEW};

		updatePermissions(role, ContentSetupKeys.CASES_MODEL_NAME, casesActionIds, true);
	}

	private void _updateCarrierAccountManagerPermissions(long companyId) {
		Role carrierAccountManager = _roleLocalService.fetchRole(companyId, ContentSetupKeys.CARRIER_ACCOUNT_MANAGER);

		_addCasesPermissions(carrierAccountManager);
	}

	private void _updateCarrierCaseManagerPermissions(long companyId) {
		Role carrierCaseManager = _roleLocalService.fetchRole(companyId, ContentSetupKeys.CARRIER_CASE_MANAGER);

		_addCasesPermissions(carrierCaseManager);
	}

}