package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ProcessedClaimsPage.class)
public class ProcessedClaimsPage extends BaseClaimsPage {

	public void addClaimsPortletToPage(long userId, long groupId) throws Exception {
		addPortletToPage(
			userId, groupId, ContentSetupKeys.PROCESSED_CLAIMS_FURL, ContentSetupKeys.CLAIMS_PORTLET,
			ContentSetupKeys.CLAIMS_VIEW_TYPE_PROCESSED);
	}

	public long addPage(long userId, long groupId, long parentLayoutId) throws PortalException {
		return addPage(
			userId, groupId, ContentSetupKeys.PROCESSED_CLAIMS_PAGE_NAME, ContentSetupKeys.PROCESSED_CLAIMS_PAGE_NAME,
			ContentSetupKeys.PROCESSED_CLAIMS_FURL, parentLayoutId);
	}

	@Override
	protected void doUpgrade() {
	}

}