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
    boolean redirectExternalUser();

	@Meta.AD(name = "open-id-connect-provider-name", required = false)
    String openIdConnectProviderName();

	@Meta.AD(name = "admin-provider-name", required = false)
    String adminProviderName();

	@Meta.AD(deflt = "admin", name = "admin-path-prefix", required = false)
    String adminPathPrefix();

}