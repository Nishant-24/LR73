package com.argus.oth.data.generator.command.render;

import com.argus.oth.data.generator.constants.SampleDataGeneratorCommandNames;
import com.argus.oth.data.generator.constants.SampleDataGeneratorPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleDataGeneratorPortletKeys.SAMPLE_DATA_GENERATOR_PORTLET,
		"mvc.command.name=" + SampleDataGeneratorCommandNames.RENDER_VIEW_INSURANCE_COMPANIES
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/view.jsp";
	}

}