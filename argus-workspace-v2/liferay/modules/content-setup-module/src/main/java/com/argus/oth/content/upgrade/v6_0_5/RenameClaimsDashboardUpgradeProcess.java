package com.argus.oth.content.upgrade.v6_0_5;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;
import com.argus.oth.content.upgrade.util.ClaimsPage;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RenameClaimsDashboardUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		long groupId = _othCommonHelper.getOTHPortalGroupId();

		_claimsPage.updateLayoutTitle(groupId, ContentSetupKeys.CLAIMS_FURL, ContentSetupKeys.CLAIMS_PAGE_TITLE);
	}

	@Reference
	private ClaimsPage _claimsPage;

	@Reference
	private OTHCommonHelper _othCommonHelper;

}