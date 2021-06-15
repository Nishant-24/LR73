package com.argus.oth.integration.auth0.background.task.configuration;

import com.argus.oth.integration.auth0.configuration.Auth0IntegrationConfiguration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Ricky Pan
 */
@Component(
	configurationPid = "com.argus.oth.integration.auth0.configuration.Auth0IntegrationConfiguration", immediate = true,
	service = Auth0Configurator.class
)
public class Auth0Configurator {

	public String getAudience() {
		return _auth0IntegrationConfiguration.audience();
	}

	public String getClientId() {
		return _auth0IntegrationConfiguration.clientId();
	}

	public String getClientSecret() {
		return _auth0IntegrationConfiguration.clientSecret();
	}

	public String getConnection() {
		return _auth0IntegrationConfiguration.connection();
	}

	public String getDomain() {
		return _auth0IntegrationConfiguration.domain();
	}

	public String getExecutionUser() {
		return _auth0IntegrationConfiguration.executionUser();
	}

	public String getLogoutReturnURL() {
		return _auth0IntegrationConfiguration.logoutReturnURL();
	}

	public String getScope() {
		return _auth0IntegrationConfiguration.scope();
	}

	public boolean isIntegrationEnabled() {
		return _auth0IntegrationConfiguration.isIntegrationEnabled();
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		_auth0IntegrationConfiguration = ConfigurableUtil.createConfigurable(
			Auth0IntegrationConfiguration.class, properties);
	}

	private Auth0IntegrationConfiguration _auth0IntegrationConfiguration;

}