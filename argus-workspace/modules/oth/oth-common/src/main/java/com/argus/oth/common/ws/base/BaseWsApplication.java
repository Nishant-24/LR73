package com.argus.oth.common.ws.base;

import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.common.ExpandoConstants;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.security.Principal;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class BaseWsApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	protected Response failure(String message) {
		log.error(message);

		return _getErrorResponse(message);
	}

	protected Client getClient(
			HttpServletRequest httpServletRequest, UserLocalService userLocalService,
			ClientLocalService clientLocalService)
		throws IllegalStateException {

		User currentUser = getCurrentUser(httpServletRequest, userLocalService);

		if (Objects.isNull(currentUser)) {
			throw new IllegalStateException("Current user cannot be found");
		}

		long clientId = getClientId(currentUser);

		Client client = clientLocalService.fetchClientByExternalClientId(clientId);

		if (Objects.isNull(client)) {
			throw new IllegalStateException("Client with clientId " + clientId + " cannot be found");
		}

		return client;
	}

	protected long getClientId(User user) {
		ExpandoBridge expandoBridge = user.getExpandoBridge();

		if (expandoBridge.hasAttribute(ExpandoConstants.CLIENT_ID)) {
			return GetterUtil.getLong(expandoBridge.getAttribute(ExpandoConstants.CLIENT_ID, false));
		}

		return 0L;
	}

	protected User getCurrentUser(HttpServletRequest httpServletRequest, UserLocalService userLocalService) {
		long currentUserId = getCurrentUserId(httpServletRequest);

		if (currentUserId < 1) {
			return null;
		}

		return userLocalService.fetchUser(currentUserId);
	}

	protected long getCurrentUserId(HttpServletRequest httpServletRequest) {
		if (httpServletRequest != null) {
			Principal userPrincipal = httpServletRequest.getUserPrincipal();

			if (userPrincipal != null) {
				return GetterUtil.getLong(userPrincipal.getName());
			}
		}

		return 0L;
	}

	protected PermissionChecker getPermissionChecker(UserLocalService userLocalService, long userId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		PermissionCheckerFactory permissionCheckerFactory = PermissionCheckerFactoryUtil.getPermissionCheckerFactory();

		return permissionCheckerFactory.create(user);
	}

	protected String getUUID() {
		return PortalUUIDUtil.generate();
	}

	protected Response handleError(Exception e) {
		return handleError(e, Response.Status.INTERNAL_SERVER_ERROR);
	}

	protected Response handleError(Exception e, Response.Status status) {
		log.error(e);

		return _getErrorResponse(e.getMessage(), status);
	}

	protected Response notFound() {
		return Response.status(
			Response.Status.NOT_FOUND
		).build();
	}

	protected Response success(JSONArray array) {
		return Response.status(
			Response.Status.OK
		).entity(
			array.toJSONString()
		).build();
	}

	protected Response success(JSONObject object) {
		return Response.status(
			Response.Status.OK
		).entity(
			object.toJSONString()
		).build();
	}

	protected boolean validateClientId(long clientIdFromUser, long clientIdFromEntity) {
		return clientIdFromUser == clientIdFromEntity;
	}

	protected boolean validateClientId(User user, long clientIdFromEntity) {
		return validateClientId(getClientId(user), clientIdFromEntity);
	}

	protected static final Log log = LogFactoryUtil.getLog(BaseWsApplication.class);

	private Response _getErrorResponse(String message) {
		return _getErrorResponse(message, Response.Status.INTERNAL_SERVER_ERROR);
	}

	private Response _getErrorResponse(String message, Response.Status status) {
		JSONObject jsonObject = JSONUtil.put("message", message);

		return Response.status(
			status
		).entity(
			jsonObject.toString()
		).build();
	}

}