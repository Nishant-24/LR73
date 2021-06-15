package com.argus.oth.content.upgrade.v2_0_6;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.util.BaseUpdateRole;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RolesUpgradeProcess extends BaseUpdateRole {

	@Override
	protected void doUpgrade() throws Exception {
		long companyId = PortalUtil.getDefaultCompanyId();

		Group group = _othCommonHelper.getOTHPortalGroup();

		_updateCarrierAccountManagerPermissions(companyId, group);

		_updateCarrierCaseManagerPermissions(companyId, group);
	}

	private void _updateCarrierAccountManagerPermissions(long companyId, Group group) throws PortalException {
		Role carrierAccountManager = getCarrierAccountManagerRole(companyId);

		addViewPermissionsToClaimsPages(group, carrierAccountManager);

		addViewPermissionsToAccountManagementPage(group, carrierAccountManager);
	}

	private void _updateCarrierCaseManagerPermissions(long companyId, Group group) throws PortalException {
		Role carrierCaseManager = getCarrierCaseManagerRole(companyId);

		addViewPermissionsToClaimsPages(group, carrierCaseManager);

		addViewPermissionsToAccountManagementPage(group, carrierCaseManager);
	}

	@Reference
	private OTHCommonHelper _othCommonHelper;

}