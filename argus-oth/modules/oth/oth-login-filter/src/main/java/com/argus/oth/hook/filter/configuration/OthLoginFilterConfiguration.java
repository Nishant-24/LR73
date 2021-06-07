package com.argus.oth.hook.filter.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.hook.filter.configuration.OthLoginFilterConfiguration",
	name = "oth-hook-filter-configuration-name"
)
public interface OthLoginFilterConfiguration {

	@Meta.AD(name = "redirect-external-user", required = false)
	public boolean redirectExternalUser();

	@Meta.AD(name = "open-id-connect-provider-name", required = false)
	public String openIdConnectProviderName();

	@Meta.AD(name = "admin-provider-name", required = false)
	public String adminProviderName();

	@Meta.AD(deflt = "admin", name = "admin-path-prefix", required = false)
	public String adminPathPrefix();

}