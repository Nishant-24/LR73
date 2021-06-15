package com.argus.oth.content.upgrade.util;

import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.model.LayoutConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = CasesPage.class)
public class CasesPage extends BaseCasesPage {

	public long addPage(long userId, long groupId) throws Exception {
		return addPage(
			userId, groupId, ContentSetupKeys.CASES_PAGE_NAME, ContentSetupKeys.CASES_PAGE_TITLE,
			ContentSetupKeys.CASES_FURL, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
			ContentSetupKeys.CASES_VIEW_TYPE_ALL);
	}

	@Override
	protected void doUpgrade() throws Exception {
	}

}