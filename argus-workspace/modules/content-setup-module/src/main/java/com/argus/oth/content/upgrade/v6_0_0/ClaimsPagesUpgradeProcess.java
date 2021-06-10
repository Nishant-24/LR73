package com.argus.oth.content.upgrade.v6_0_0;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.ClaimsPage;
import com.argus.oth.content.upgrade.util.ClosedClaimsPage;
import com.argus.oth.content.upgrade.util.InProcessClaimsPage;
import com.argus.oth.content.upgrade.util.ProcessedClaimsPage;

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
public class ClaimsPagesUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		long groupId = _othCommonHelper.getOTHPortalGroupId();
		long companyId = _portal.getDefaultCompanyId();
		long userId = _userLocalService.getDefaultUserId(companyId);

		_claimsPage.addClaimsPortletToPage(groupId, userId);
		_inProcessClaimsPage.addClaimsPortletToPage(groupId, userId);
		_processedClaimsPage.addClaimsPortletToPage(groupId, userId);
		_closedClaimsPage.addClaimsPortletToPage(groupId, userId);
	}

	@Reference(target = "(javax.portlet.name=" + ContentSetupKeys.CLAIMS_PORTLET + ")")
	private Portlet _claimsJsWebPortlet;

	@Reference
	private ClaimsPage _claimsPage;

	@Reference
	private ClosedClaimsPage _closedClaimsPage;

	@Reference
	private InProcessClaimsPage _inProcessClaimsPage;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private Portal _portal;

	@Reference
	private ProcessedClaimsPage _processedClaimsPage;

	@Reference
	private UserLocalService _userLocalService;

}