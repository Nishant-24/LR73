package com.argus.oth.hook.logout.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Davy Duran
 */
@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.hook.logout.configuration.AzureADConfiguration", localization = "content/Language",
	name = "AzureAD"
)
public interface AzureADConfiguration {

	@Meta.AD(
		deflt = "https://login.microsoftonline.com/common/oauth2/v2.0/logout?" + "post_logout_redirect_uri=",
		required = false, type = Meta.Type.String
	)
    String logoutURL();

}