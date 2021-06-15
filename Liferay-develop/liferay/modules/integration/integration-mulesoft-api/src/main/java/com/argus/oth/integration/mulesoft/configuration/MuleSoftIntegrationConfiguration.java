package com.argus.oth.integration.mulesoft.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Jaclyn Ong
 */
@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.integration.mulesoft.configuration.MuleSoftIntegrationConfiguration",
	localization = "content/Language", name = "mulesoft-integration-configuration-name"
)
public interface MuleSoftIntegrationConfiguration {

	@Meta.AD(deflt = "/api/v1/cases/%s/authorizations", required = false, type = Meta.Type.String)
	public String caseAuthorizationsURL();

	@Meta.AD(deflt = "https://argus-case-eapi-dev.ca-c1.cloudhub.io", required = false, type = Meta.Type.String)
	public String caseBaseURL();

	@Meta.AD(deflt = "/api/v1/cases/%s/notes", required = false, type = Meta.Type.String)
	public String caseNotesURL();

	@Meta.AD(deflt = "/api/v1/cases/%s/tasks", required = false, type = Meta.Type.String)
	public String caseTasksURL();

	@Meta.AD(required = false, type = Meta.Type.String)
	public String clientId();

	@Meta.AD(deflt = "test", required = false, type = Meta.Type.Password)
	public String clientSecret();

	@Meta.AD(required = false, type = Meta.Type.String)
	public String forwardedForHeader();

	@Meta.AD(deflt = "30", description = "request-threshold-description", required = false, type = Meta.Type.Integer)
	public int requestThreshold();

	@Meta.AD(deflt = "30000", required = false, type = Meta.Type.Integer)
	public int timeout();

}