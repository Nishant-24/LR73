package com.argus.oth.integration.mulesoft;

import io.swagger.client.model.ModelCase;

import java.util.List;

/**
 * @author Jaclyn Ong
 */
public interface CasesMuleSoftIntegration {

	public List<ModelCase> getCases(String correlationId, String clientId, String requestedDateTime) throws Exception;

}