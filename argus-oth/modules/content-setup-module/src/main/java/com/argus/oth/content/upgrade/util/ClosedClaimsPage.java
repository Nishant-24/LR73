package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ClosedClaimsPage.class)
public class ClosedClaimsPage extends BaseClaimsPage {

	public void addClaimsPortletToPage(long userId, long groupId) throws Exception {
		addPortletToPage(
			userId, groupId, ContentSetupKeys.CLOSED_CLAIMS_FURL, ContentSetupKeys.CLAIMS_PORTLET,
			ContentSetupKeys.CLAIMS_VIEW_TYPE_CLOSED);
	}

	public long addPage(long userId, long groupId, long parentLayoutId) throws PortalException {
		return addPage(
			userId, groupId, ContentSetupKeys.CLOSED_CLAIMS_PAGE_NAME, ContentSetupKeys.CLOSED_CLAIMS_PAGE_NAME,
			ContentSetupKeys.CLOSED_CLAIMS_FURL, parentLayoutId);
	}

	@Override
	protected void doUpgrade() {
	}

}