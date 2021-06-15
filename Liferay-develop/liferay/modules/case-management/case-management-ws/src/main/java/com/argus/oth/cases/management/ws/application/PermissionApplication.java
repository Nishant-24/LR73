package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.model.Task;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Jaclyn Ong
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/permission",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Permission.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class PermissionApplication extends BaseWsApplication {

	@GET
	@Path("/permission")
	public Response getPermissions(@Context HttpServletRequest httpServletRequest) {
		try {
			JSONObject responseObj = _jsonFactory.createJSONObject();

			boolean hasAddNotePermission = _hasPermission(
				Note.class.getCanonicalName(), httpServletRequest, OTHConstants.ADD_NOTE);

			responseObj.put(OTHConstants.ADD_NOTE, hasAddNotePermission);

			boolean hasAddTaskPermission = _hasPermission(
				Task.class.getCanonicalName(), httpServletRequest, OTHConstants.ADD_TASK);

			responseObj.put(OTHConstants.ADD_TASK, hasAddTaskPermission);

			boolean hasAuthorizePermission = _hasPermission(
				Authorization.class.getCanonicalName(), httpServletRequest, OTHConstants.AUTHORIZE);

			responseObj.put(OTHConstants.AUTHORIZE, hasAuthorizePermission);

			return success(responseObj);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	private boolean _hasPermission(String className, HttpServletRequest httpServletRequest, String actionId)
		throws PortalException {

		PermissionChecker permissionChecker = getPermissionChecker(
			_userLocalService, getCurrentUserId(httpServletRequest));

		return permissionChecker.hasPermission(null, className, _portal.getCompanyId(httpServletRequest), actionId);
	}

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}