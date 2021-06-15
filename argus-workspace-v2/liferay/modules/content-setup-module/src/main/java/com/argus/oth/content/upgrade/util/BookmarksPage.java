package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = BookmarksPage.class)
public class BookmarksPage extends BaseCasesPage {

	public void addPage(long userId, long groupId, long parentLayoutId) throws Exception {
		addPage(
			userId, groupId, ContentSetupKeys.MY_BOOKMARKS_PAGE_NAME, ContentSetupKeys.MY_BOOKMARKS_PAGE_NAME,
			ContentSetupKeys.MY_BOOKMARKS_FURL, parentLayoutId, ContentSetupKeys.CASES_VIEW_TYPE_BOOKMARKS);
	}

	@Override
	protected void doUpgrade() throws Exception {
	}

}