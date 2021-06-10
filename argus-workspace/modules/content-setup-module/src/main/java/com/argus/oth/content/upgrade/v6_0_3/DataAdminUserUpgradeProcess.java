package com.argus.oth.content.upgrade.v6_0_3;

import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class DataAdminUserUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		long companyId = PortalUtil.getDefaultCompanyId();
		long groupId = _othCommonHelper.getOTHPortalGroupId();

		User dataAdmin = _userLocalService.fetchUserByScreenName(companyId, OTHConstants.DATA_ADMIN_USER_SCREEN_NAME);

		_groupLocalService.addUserGroups(dataAdmin.getUserId(), new long[] {groupId});

		_roleLocalService.addUserRole(
			dataAdmin.getUserId(),
			_roleLocalService.fetchRole(PortalUtil.getDefaultCompanyId(), ContentSetupKeys.CARRIER_CASE_MANAGER));

		_othCommonHelper.setUserClientId(dataAdmin, ContentSetupKeys.DATA_ADMIN_DEFAULT_CLIENT_ID);
	}

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserLocalService _userLocalService;

}