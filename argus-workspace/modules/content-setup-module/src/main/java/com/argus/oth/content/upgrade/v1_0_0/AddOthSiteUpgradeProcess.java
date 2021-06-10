package com.argus.oth.content.upgrade.v1_0_0;

import com.argus.oth.common.OTHConstants;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.AccountManagementPage;
import com.argus.oth.content.upgrade.util.BookmarksPage;
import com.argus.oth.content.upgrade.util.CasesPage;
import com.argus.oth.content.upgrade.util.ClaimsPage;
import com.argus.oth.content.upgrade.util.ClosedClaimsPage;
import com.argus.oth.content.upgrade.util.HomePage;
import com.argus.oth.content.upgrade.util.InProcessClaimsPage;
import com.argus.oth.content.upgrade.util.LoginPage;
import com.argus.oth.content.upgrade.util.ProcessedClaimsPage;
import com.argus.oth.content.upgrade.util.RecentlyViewedPage;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kevin Cruz
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class AddOthSiteUpgradeProcess extends UpgradeProcess {

	public AddOthSiteUpgradeProcess() {
	}

	protected Group addGroup(long companyId, String name, String description, int type, String friendlyURL)
			throws PortalException {

		ServiceContext serviceContext = getDefaultServiceContext(companyId);

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), name);

		Map<Locale, String> descriptionMap = new HashMap<>();

		descriptionMap.put(LocaleUtil.getDefault(), description);

		return _groupLocalService.addGroup(_userLocalService.getDefaultUserId(companyId),
				GroupConstants.DEFAULT_PARENT_GROUP_ID, null, 0, 0, nameMap, descriptionMap, type, true,
				GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, true, true, serviceContext);
	}

	protected long addPortalSite(long companyId, String groupName, int siteType) throws PortalException {
		Group group = addGroup(companyId, groupName, StringPool.BLANK, siteType, ContentSetupKeys.OTH_PORTAL_FURL);

		return group.getGroupId();
	}

	protected void doUpgrade() throws Exception {
		long companyId = PortalUtil.getDefaultCompanyId();

		long groupId = addPortalSite(companyId, OTHConstants.OTH_PORTAL_GROUP_NAME, GroupConstants.TYPE_SITE_PRIVATE);

		_addPrivatePages(companyId, groupId);

		_addPublicPages(companyId, groupId);

		_addDefaultContent(groupId);

		_setTheme(groupId);

		_setVirtualHost(groupId);
	}

	protected ServiceContext getDefaultServiceContext(long companyId) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);
		serviceContext.setUserId(_userLocalService.getDefaultUserId(companyId));

		return serviceContext;
	}

	private void _addDefaultContent(long groupId) throws Exception {
	}

	private void _addPrivatePages(long companyId, long groupId) throws Exception {
		long userId = _userLocalService.getDefaultUserId(companyId);

		_homePage.addPage(userId, groupId);

		long claimsLayoutId = _claimsPage.addPage(userId, groupId);

		_inProcessClaimsPage.addPage(userId, groupId, claimsLayoutId);

		_processedClaimsPage.addPage(userId, groupId, claimsLayoutId);

		_closedClaimsPage.addPage(userId, groupId, claimsLayoutId);

		long casesLayoutId = _casesPage.addPage(userId, groupId);

		_recentlyViewedPage.addPage(userId, groupId, casesLayoutId);

		_bookmarksPage.addPage(userId, groupId, casesLayoutId);

		_accountManagementPage.addPage(userId, groupId);
	}

	private void _addPublicPages(long companyId, long groupId) throws Exception {
		long userId = _userLocalService.getDefaultUserId(companyId);

		_loginPage.addPage(userId, groupId);
	}

	private void _setTheme(long groupId) throws PortalException {
		_layoutSetLocalService.updateLookAndFeel(groupId, _OTH_PORTAL_THEME_ID, StringPool.BLANK, StringPool.BLANK);
	}

	private void _setVirtualHost(long groupId) throws PortalException {
		String virtualHostName = PropsUtil.get(_VIRTUAL_HOST_NAME);

		if (Validator.isNull(virtualHostName)) {
			return;
		}

		_layoutSetLocalService.updateVirtualHost(groupId, true, virtualHostName);
	}

	private static final String _OTH_PORTAL_THEME_ID = "othportaltheme_WAR_othportaltheme";

	private static final String _VIRTUAL_HOST_NAME = "virtual.host.name";

	private static final Log _log = LogFactoryUtil.getLog(AddOthSiteUpgradeProcess.class);

	@Reference
	private AccountManagementPage _accountManagementPage;

	@Reference
	private BookmarksPage _bookmarksPage;

	// keep so that instanceable portlet instance is available when adding this
	// portlet to pages
	@Reference(target = "(javax.portlet.name=" + ContentSetupKeys.CASES_PORTLET + ")")
	private Portlet _caseManagementJsWebPortlet;

	@Reference
	private CasesPage _casesPage;

	@Reference
	private ClaimsPage _claimsPage;

	@Reference
	private ClosedClaimsPage _closedClaimsPage;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private HomePage _homePage;

	@Reference
	private InProcessClaimsPage _inProcessClaimsPage;

	@Reference
	private LayoutSetLocalService _layoutSetLocalService;

	@Reference
	private LoginPage _loginPage;

	@Reference
	private ProcessedClaimsPage _processedClaimsPage;

	@Reference
	private RecentlyViewedPage _recentlyViewedPage;

	@Reference
	private UserLocalService _userLocalService;

}