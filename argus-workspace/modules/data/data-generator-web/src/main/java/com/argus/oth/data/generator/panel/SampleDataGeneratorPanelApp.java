package com.argus.oth.data.generator.panel;

import com.argus.oth.data.generator.constants.SampleDataGeneratorPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
	},
	service = PanelApp.class
)
public class SampleDataGeneratorPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SampleDataGeneratorPortletKeys.SAMPLE_DATA_GENERATOR_PORTLET;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SampleDataGeneratorPortletKeys.SAMPLE_DATA_GENERATOR_PORTLET + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}