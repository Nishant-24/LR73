package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = RecentlyViewedPage.class)
public class RecentlyViewedPage extends BaseCasesPage {

	public void addPage(long userId, long groupId, long parentLayoutId) throws Exception {
		addPage(
			userId, groupId, ContentSetupKeys.RECENTLY_VIEWED_PAGE_NAME, ContentSetupKeys.RECENTLY_VIEWED_PAGE_NAME,
			ContentSetupKeys.RECENTLY_VIEWED_FURL, parentLayoutId, ContentSetupKeys.CASES_VIEW_TYPE_RECENT);
	}

	@Override
	protected void doUpgrade() throws Exception {
	}

}