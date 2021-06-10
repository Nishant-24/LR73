package com.argus.oth.integration.auth0.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Eric Chin
 */
@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.integration.auth0.configuration.Auth0IntegrationConfiguration",
	localization = "content/Language", name = "auth0-integration-configuration-name"
)
public interface Auth0IntegrationConfiguration {

	@Meta.AD(description = "", name = "audience", required = false)
	public String audience();

	@Meta.AD(description = "", name = "client-id", required = false)
	public String clientId();

	@Meta.AD(name = "client-secret", required = false)
	public String clientSecret();

	@Meta.AD(name = "connection", required = false)
	public String connection();

	@Meta.AD(name = "domain", required = false)
	public String domain();

	@Meta.AD(deflt = "admin-liferay@argus.bm", required = false, type = Meta.Type.String)
	public String executionUser();

	@Meta.AD(deflt = "false", name = "integration-enabled", required = false, type = Meta.Type.Boolean)
	public Boolean isIntegrationEnabled();

	@Meta.AD(deflt = "create:users", name = "scope", required = false)
	public String scope();

	@Meta.AD(deflt = "https://carrier-dev.oneteamhealth.com", name = "logoutReturnURL", required = false)
	public String logoutReturnURL();

}