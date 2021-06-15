package com.argus.oth.content.upgrade.v2_0_4;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RolesUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws PortalException {
		long companyId = _portal.getDefaultCompanyId();

		_dropPortalAdministratorRole(companyId);

		_setAdministratorRoleTitle(companyId);
	}

	private void _dropPortalAdministratorRole(long companyId) throws PortalException {
		Role role = _roleLocalService.fetchRole(companyId, ContentSetupKeys.PORTAL_ADMIN);

		if (Objects.isNull(role)) {
			return;
		}

		_roleLocalService.deleteRole(role);
	}

	private void _setAdministratorRoleTitle(long companyId) {
		Role role = _roleLocalService.fetchRole(companyId, RoleConstants.ADMINISTRATOR);

		if (Objects.isNull(role)) {
			return;
		}

		role.setTitle(ContentSetupKeys.PORTAL_ADMIN);

		_roleLocalService.updateRole(role);
	}

	@Reference
	private Portal _portal;

	@Reference
	private RoleLocalService _roleLocalService;

}