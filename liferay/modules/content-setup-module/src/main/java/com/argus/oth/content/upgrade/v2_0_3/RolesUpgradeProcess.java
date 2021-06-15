package com.argus.oth.content.upgrade.v2_0_3;

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.common.OTHConstants;
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

		_updatePortalAdministratorPermissions(companyId);
	}

	private void _updateAuthorizationPermissions(Role role) {
		String[] authorizationActionIds = {ActionKeys.VIEW, OTHConstants.AUTHORIZE};

		updatePermissions(role, Authorization.class.getCanonicalName(), authorizationActionIds, true);
	}

	private void _updateCarrierAccountManagerPermissions(long companyId) {
		Role carrierAccountManager = getCarrierAccountManagerRole(companyId);

		_updateAuthorizationPermissions(carrierAccountManager);
	}

	private void _updateCarrierCaseManagerPermissions(long companyId) {
		Role carrierCaseManager = getCarrierCaseManagerRole(companyId);

		_updateAuthorizationPermissions(carrierCaseManager);
	}

	private void _updatePortalAdministratorPermissions(long companyId) {
		Role portalAdmin = getPortalAdminRole(companyId);

		_updateAuthorizationPermissions(portalAdmin);
	}

}