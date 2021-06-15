package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.AuthorizationLocalService;
import com.argus.oth.cases.management.service.AuthorizationService;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.ws.application.serializer.AuthorizationSerializer;
import com.argus.oth.common.OTHConstants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Ricky Pan
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/case-authorization",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Authorization.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorizationApplication extends BaseCasesWsApplication {

	@Path("/group/{groupId}/authorization/approve")
	@POST
	public Response approveAuthorization(
		@PathParam("groupId") long groupId, @QueryParam("authorizationId") long authorizationId,
		String authorizationJSON, @Context HttpServletRequest httpServletRequest) {

		return _updateAuthorizationStatus(
			authorizationId, OTHConstants.AUTHORIZATION_APPROVED_STATUS_KEY, authorizationJSON, httpServletRequest);
	}

	@Path("/group/{groupId}/authorization/deny")
	@POST
	public Response denyAuthorization(
		@PathParam("groupId") long groupId, @QueryParam("authorizationId") long authorizationId,
		String authorizationJSON, @Context HttpServletRequest httpServletRequest) {

		return _updateAuthorizationStatus(
			authorizationId, OTHConstants.AUTHORIZATION_DENIED_STATUS_KEY, authorizationJSON, httpServletRequest);
	}

	@GET
	@Path("/group/{groupId}/authorization/")
	public Response getAuthorizationsByCaseId(
		@PathParam("groupId") long groupId, @QueryParam("caseId") long caseId, @QueryParam("start") int start,
		@QueryParam("end") int end, @Context HttpServletRequest httpServletRequest) {

		try {
			Cases cases = _casesLocalService.fetchCases(caseId);

			if (Objects.isNull(cases)) {
				return failure("Case with caseId " + caseId + " cannot be found");
			}

			User user = getCurrentUser(httpServletRequest, _userLocalService);

			if (!validateClientId(user, cases.getClientId())) {
				return notFound();
			}

			List<Authorization> authorizations = _authorizationService.getAuthorizationsByCaseId(
				caseId, cases.getExternalCaseId(), start, end);

			JSONArray response = _authorizationSerializer.serialize(authorizations, user.getTimeZone());

			return success(response);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	private Response _updateAuthorizationStatus(
		long authorizationId, String rtcAuthorizationStatus, String authorizationJSON,
		HttpServletRequest httpServletRequest) {

		try {
			Authorization authorizationToUpdate = _authorizationLocalService.fetchAuthorization(authorizationId);

			if (Objects.isNull(authorizationToUpdate)) {
				return notFound();
			}

			Cases cases = _casesLocalService.getCases(authorizationToUpdate.getCaseId());

			if (Objects.isNull(cases)) {
				return failure("Case with caseId " + authorizationToUpdate.getCaseId() + " cannot be found");
			}

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			String validationError = _validate(authorizationToUpdate.getRtcAuthorizationStatus());

			if (!Validator.isBlank(validationError)) {
				return failure(validationError);
			}

			JSONObject authorizationJSONObject = _jsonFactory.createJSONObject(authorizationJSON);

			JSONObject jsonObjectResponse = _authorizationService.authorize(
				authorizationToUpdate, rtcAuthorizationStatus, DEFAULT_PROCESS_STATUS, currentUser.getUserId(),
				authorizationJSONObject.getString("comments"));

			if (Objects.isNull(jsonObjectResponse)) {
				return failure(
					"Failed to update authorization with external authorization ID " +
						authorizationToUpdate.getExternalAuthorizationId());
			}

			return success(jsonObjectResponse);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	private String _validate(String rtcAuthorizationStatus) {
		if (!rtcAuthorizationStatus.equalsIgnoreCase(OTHConstants.AUTHORIZATION_PENDING_STATUS_KEY)) {
			return "Authorization must be in Pending status to approve/deny.";
		}

		return StringPool.BLANK;
	}

	@Reference
	private AuthorizationLocalService _authorizationLocalService;

	@Reference
	private AuthorizationSerializer _authorizationSerializer;

	@Reference
	private AuthorizationService _authorizationService;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private UserLocalService _userLocalService;

}