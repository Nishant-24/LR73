package com.argus.oth.integration.mulesoft.service.configuration;

import com.argus.oth.integration.mulesoft.configuration.MuleSoftIntegrationConfiguration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Jaclyn Ong
 */
@Component(
	configurationPid = "com.argus.oth.integration.mulesoft.configuration.MuleSoftIntegrationConfiguration",
	immediate = true, service = MuleSoftConfigurator.class
)
public class MuleSoftConfigurator {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_muleSoftIntegrationConfiguration = ConfigurableUtil.createConfigurable(
			MuleSoftIntegrationConfiguration.class, properties);
	}

	public String getCaseAuthorizationsURL() {
		return _muleSoftIntegrationConfiguration.caseAuthorizationsURL();
	}

	public String getCaseBaseAPIURL() {
		return _muleSoftIntegrationConfiguration.caseBaseURL() + "/api";
	}

	public String getCaseBaseURL() {
		return _muleSoftIntegrationConfiguration.caseBaseURL();
	}

	public String getCaseNotesURL() {
		return _muleSoftIntegrationConfiguration.caseNotesURL();
	}

	public String getCaseTasksURL() {
		return _muleSoftIntegrationConfiguration.caseTasksURL();
	}

	public String getClientId() {
		return _muleSoftIntegrationConfiguration.clientId();
	}

	public String getClientSecret() {
		return _muleSoftIntegrationConfiguration.clientSecret();
	}

	public String getForwardedForHeader() {
		return _muleSoftIntegrationConfiguration.forwardedForHeader();
	}

	public int getRequestThreshold() {
		return _muleSoftIntegrationConfiguration.requestThreshold();
	}

	public int getTimeout() {
		return _muleSoftIntegrationConfiguration.timeout();
	}

	private MuleSoftIntegrationConfiguration _muleSoftIntegrationConfiguration;

}