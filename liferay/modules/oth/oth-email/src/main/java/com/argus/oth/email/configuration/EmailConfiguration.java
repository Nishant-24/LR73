package com.argus.oth.email.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Jaclyn Ong
 */
@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.email.configuration.EmailConfiguration", localization = "content/Language",
	name = "email-alert-configuration-name"
)
public interface EmailConfiguration {

	@Meta.AD(deflt = "no-reply@argus.bm", required = false, type = Meta.Type.String)
	public String emailAlertFromAddress();

	@Meta.AD(deflt = "", required = false, type = Meta.Type.String)
	public String emailAlertFromName();

	@Meta.AD(deflt = "LiferayMonitor@argus.bm", required = false, type = Meta.Type.String)
	public String emailAlertToAddress();

}