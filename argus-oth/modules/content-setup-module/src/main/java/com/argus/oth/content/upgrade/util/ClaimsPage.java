package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author kevinccruz
 */
@Component(immediate = true, service = ClaimsPage.class)
public class ClaimsPage extends BaseClaimsPage {

	public void addClaimsPortletToPage(long groupId, long userId) throws Exception {
		addPortletToPage(
			groupId, userId, ContentSetupKeys.CLAIMS_FURL, ContentSetupKeys.CLAIMS_PORTLET,
			ContentSetupKeys.CLAIMS_VIEW_TYPE_DASHBOARD);
	}

	public long addPage(long userId, long groupId) throws PortalException {
		return addPage(
			userId, groupId, ContentSetupKeys.CLAIMS_PAGE_NAME, ContentSetupKeys.CLAIMS_PAGE_TITLE,
			ContentSetupKeys.CLAIMS_FURL, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
	}

	@Override
	public long updateLayoutTitle(long groupId, String friendlyURL, String newLayoutName) throws PortalException {
		return super.updateLayoutTitle(groupId, friendlyURL, newLayoutName);
	}

	@Override
	protected void doUpgrade() {
	}

}