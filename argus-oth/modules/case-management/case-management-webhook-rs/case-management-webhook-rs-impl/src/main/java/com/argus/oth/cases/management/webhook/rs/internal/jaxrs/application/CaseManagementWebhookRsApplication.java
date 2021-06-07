package com.argus.oth.cases.management.webhook.rs.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Davy
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/case-management-webhook-rs",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=CaseManagementWebhookRs"
	},
	service = Application.class
)
@Generated("")
public class CaseManagementWebhookRsApplication extends Application {
}