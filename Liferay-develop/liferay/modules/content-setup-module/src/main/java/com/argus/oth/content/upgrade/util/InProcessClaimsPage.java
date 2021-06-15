package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = InProcessClaimsPage.class)
public class InProcessClaimsPage extends BaseClaimsPage {

	public void addClaimsPortletToPage(long userId, long groupId) throws Exception {
		addPortletToPage(
			userId, groupId, ContentSetupKeys.IN_PROCESS_CLAIMS_FURL, ContentSetupKeys.CLAIMS_PORTLET,
			ContentSetupKeys.CLAIMS_VIEW_TYPE_IN_PROCESS);
	}

	public long addPage(long userId, long groupId, long parentLayoutId) throws PortalException {
		return addPage(
			userId, groupId, ContentSetupKeys.IN_PROCESS_CLAIMS_PAGE_NAME, ContentSetupKeys.IN_PROCESS_CLAIMS_PAGE_NAME,
			ContentSetupKeys.IN_PROCESS_CLAIMS_FURL, parentLayoutId);
	}

	@Override
	protected void doUpgrade() {
	}

}