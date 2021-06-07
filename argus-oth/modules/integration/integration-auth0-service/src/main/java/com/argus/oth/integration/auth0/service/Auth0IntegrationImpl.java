package com.argus.oth.integration.auth0.service;

import com.argus.oth.integration.auth0.Auth0Integration;
import com.argus.oth.integration.auth0.background.task.configuration.Auth0Configurator;
import com.argus.oth.integration.auth0.dto.Auth0Response;

import com.auth0.client.auth.AuthAPI;
import com.auth0.client.mgmt.ManagementAPI;
import com.auth0.client.mgmt.UsersEntity;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import com.auth0.json.mgmt.users.User;
import com.auth0.net.AuthRequest;
import com.auth0.net.Request;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	configurationPid = "com.argus.oth.integration.auth0.configuration.Auth0IntegrationConfiguration", immediate = true,
	service = Auth0Integration.class
)
public class Auth0IntegrationImpl implements Auth0Integration {

	@Override
	public Auth0Response createUser(String firstName, String lastName, String email, String password) throws Exception {
		AuthAPI authAPI = _getAuthAPI();

		AuthRequest authRequest = authAPI.requestToken(_auth0Configurator.getAudience());

		authRequest.setScope(_auth0Configurator.getScope());
		authRequest.setAudience(_auth0Configurator.getAudience());

		TokenHolder holder = authRequest.execute();

		ManagementAPI mgmt = new ManagementAPI(_auth0Configurator.getDomain(), holder.getAccessToken());

		UsersEntity usersEntity = mgmt.users();

		User auth0User = new User();

		auth0User.setConnection(_auth0Configurator.getConnection());
		auth0User.setEmail(email);
		auth0User.setPassword(password.toCharArray());
		auth0User.setName(StringBundler.concat(firstName, StringPool.SPACE, lastName));
		auth0User.setGivenName(firstName);
		auth0User.setFamilyName(lastName);
		auth0User.setEmailVerified(true);

		Request<User> userRequest = usersEntity.create(auth0User);

		try {
			userRequest.execute();
		}
		catch (Auth0Exception exception) {
			_log.error(exception.getMessage(), exception);

			return new Auth0Response(exception.getMessage(), Auth0Response.Status.FAILURE);
		}

		return new Auth0Response(Auth0Response.Status.SUCCESS);
	}

	@Override
	public String getLogoutURL() {
		AuthAPI authAPI = _getAuthAPI();

		return authAPI.logoutUrl(
			_auth0Configurator.getLogoutReturnURL(), true
		).useFederated(
			true
		).build();
	}

	private AuthAPI _getAuthAPI() {
		return new AuthAPI(
			_auth0Configurator.getDomain(), _auth0Configurator.getClientId(), _auth0Configurator.getClientSecret());
	}

	private static final Log _log = LogFactoryUtil.getLog(Auth0IntegrationImpl.class);

	@Reference
	private Auth0Configurator _auth0Configurator;

}