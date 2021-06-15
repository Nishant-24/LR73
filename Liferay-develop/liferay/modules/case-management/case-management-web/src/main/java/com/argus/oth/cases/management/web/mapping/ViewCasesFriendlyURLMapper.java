package com.argus.oth.cases.management.web.mapping;

import com.argus.oth.cases.management.web.constants.CasesPortletKeys;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ricky Pan
 */
@Component(
	property = {
		"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/edit-routes.xml",
		"javax.portlet.name=" + CasesPortletKeys.CASES_PORTLET
	},
	service = FriendlyURLMapper.class
)
public class ViewCasesFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return "cases";
	}

}