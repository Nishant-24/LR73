package com.argus.oth.content.upgrade.common;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.util.HomePage;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class HomePageUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		long groupId = _othCommonHelper.getOTHPortalGroupId();
		long companyId = _portal.getDefaultCompanyId();
		long userId = _userLocalService.getDefaultUserId(companyId);

		_homePage.clearTypeSettings(groupId);
		_homePage.addPortletsToPage(groupId, userId);
	}

	private static final Log _log = LogFactoryUtil.getLog(HomePageUpgradeProcess.class);

	@Reference
	private HomePage _homePage;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}