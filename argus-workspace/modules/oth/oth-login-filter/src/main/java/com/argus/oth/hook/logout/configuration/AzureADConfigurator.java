package com.argus.oth.hook.logout.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Davy Duran
 */
@Component(
	configurationPid = "com.argus.oth.hook.logout.configuration.AzureADConfiguration", immediate = true,
	service = AzureADConfigurator.class
)
public class AzureADConfigurator {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_azureADConfiguration = ConfigurableUtil.createConfigurable(AzureADConfiguration.class, properties);
	}

	public String logoutURL() {
		return _azureADConfiguration.logoutURL();
	}

	private AzureADConfiguration _azureADConfiguration;

}