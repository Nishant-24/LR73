package com.argus.oth.integration.auth0;

import com.argus.oth.integration.auth0.dto.Auth0Response;

/**
 * @author Eric Chin
 */
public interface Auth0Integration {

	public Auth0Response createUser(String firstName, String lastName, String email, String password) throws Exception;

	public String getLogoutURL();

}