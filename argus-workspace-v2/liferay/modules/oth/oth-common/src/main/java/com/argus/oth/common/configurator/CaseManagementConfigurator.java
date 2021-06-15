package com.argus.oth.common.configurator;

import com.argus.oth.integration.mulesoft.configuration.MuleSoftIntegrationConfiguration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Eric Chin
 */
@Component(
	configurationPid = "com.argus.oth.integration.mulesoft.configuration.MuleSoftIntegrationConfiguration",
	immediate = true, service = CaseManagementConfigurator.class
)
public class CaseManagementConfigurator {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_muleSoftIntegrationConfiguration = ConfigurableUtil.createConfigurable(
			MuleSoftIntegrationConfiguration.class, properties);
	}

	public int requestThreshold() {
		return _muleSoftIntegrationConfiguration.requestThreshold();
	}

	private MuleSoftIntegrationConfiguration _muleSoftIntegrationConfiguration;

}