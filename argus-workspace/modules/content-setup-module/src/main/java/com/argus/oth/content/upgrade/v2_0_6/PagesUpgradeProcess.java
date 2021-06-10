package com.argus.oth.content.upgrade.v2_0_6;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.ClosedClaimsPage;
import com.argus.oth.content.upgrade.util.InProcessClaimsPage;
import com.argus.oth.content.upgrade.util.ProcessedClaimsPage;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class PagesUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		long groupId = _othCommonHelper.getOTHPortalGroupId();

		Layout claimsPage = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, true, ContentSetupKeys.CLAIMS_FURL);

		_renameClaimsTitle(claimsPage);

		long companyId = PortalUtil.getDefaultCompanyId();

		long userId = _userLocalService.getDefaultUserId(companyId);

		_addChildClaimsPages(userId, groupId, claimsPage);

		_updateHomeColumnLayout(groupId, userId);

		_renameAccountManagementTitle(groupId);
	}

	private void _addChildClaimsPages(long userId, long groupId, Layout claimsPage) throws PortalException {
		_inProcessClaimsPage.addPage(userId, groupId, claimsPage.getLayoutId());

		_processedClaimsPage.addPage(userId, groupId, claimsPage.getLayoutId());

		_closedClaimsPage.addPage(userId, groupId, claimsPage.getLayoutId());
	}

	private void _renameAccountManagementTitle(long groupId) throws PortalException {
		Layout accountManagementPage = _layoutLocalService.fetchLayoutByFriendlyURL(
			groupId, true, ContentSetupKeys.ACCOUNT_MANAGEMENT_FURL);

		accountManagementPage.setTitle(ContentSetupKeys.ACCOUNT_MANAGEMENT_PAGE_TITLE);

		_layoutLocalService.updateLayout(accountManagementPage);
	}

	private void _renameClaimsTitle(Layout claimsPage) throws PortalException {
		claimsPage.setTitle(ContentSetupKeys.CLAIMS_PAGE_TITLE);

		_layoutLocalService.updateLayout(claimsPage);
	}

	private void _updateHomeColumnLayout(long groupId, long userId) throws PortalException {
		Layout homePage = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, true, ContentSetupKeys.HOME_FURL);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)homePage.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, ContentSetupKeys.LAYOUT_3_COLUMNS, false);

		_layoutLocalService.updateLayout(homePage);
	}

	@Reference
	private ClosedClaimsPage _closedClaimsPage;

	@Reference
	private InProcessClaimsPage _inProcessClaimsPage;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private ProcessedClaimsPage _processedClaimsPage;

	@Reference
	private UserLocalService _userLocalService;

}