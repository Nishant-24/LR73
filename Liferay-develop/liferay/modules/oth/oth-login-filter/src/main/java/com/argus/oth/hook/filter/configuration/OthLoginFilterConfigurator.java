package com.argus.oth.hook.filter.configuration;

import aQute.bnd.annotation.metatype.Configurable;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Ricky Pan
 */
@Component(
	configurationPid = "com.argus.oth.hook.filter.configuration.OthLoginFilterConfiguration", immediate = true,
	service = OthLoginFilterConfigurator.class
)
public class OthLoginFilterConfigurator {

	public String getAdminPathPrefix() {
		return _othLoginFilterConfiguration.adminPathPrefix();
	}

	public String getAdminProviderName() {
		return _othLoginFilterConfiguration.adminProviderName();
	}

	public String getOpenIdConnectProviderName() {
		return _othLoginFilterConfiguration.openIdConnectProviderName();
	}

	public boolean shouldRedirectExternalUser() {
		return _othLoginFilterConfiguration.redirectExternalUser();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_othLoginFilterConfiguration = Configurable.createConfigurable(OthLoginFilterConfiguration.class, properties);
	}

	private OthLoginFilterConfiguration _othLoginFilterConfiguration;

}