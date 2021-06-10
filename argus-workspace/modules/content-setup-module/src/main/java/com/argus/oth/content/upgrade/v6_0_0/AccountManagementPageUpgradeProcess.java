package com.argus.oth.content.upgrade.v6_0_0;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.AccountManagementPage;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class AccountManagementPageUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		long groupId = _othCommonHelper.getOTHPortalGroupId();
		long companyId = _portal.getDefaultCompanyId();
		long userId = _userLocalService.getDefaultUserId(companyId);

		_accountManagementPage.addPortletToPage(groupId, userId);
	}

	@Reference(target = "(javax.portlet.name=" + ContentSetupKeys.ACCOUNT_MANAGEMENT_PORTLET + ")")
	private Portlet _accountManagementJsWeb;

	@Reference
	private AccountManagementPage _accountManagementPage;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}