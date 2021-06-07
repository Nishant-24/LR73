package com.argus.oth.cases.management.ws.application;

import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.time.Instant;

import java.util.Date;
import java.util.Objects;

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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/user",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=User.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class UserApplication extends BaseWsApplication {

	@GET
	@Path("/now")
	public Response getNow(@Context HttpServletRequest httpServletRequest) {
		try {
			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			if (Objects.isNull(currentUser.getTimeZone())) {
				return failure("Time zone not found for user.");
			}

			Date nowInUserTimeZone = _dateFormatter.convertToTimeZone(new Date(), currentUser.getTimeZone());

			Instant nowInstant = nowInUserTimeZone.toInstant();

			String nowIsoDateString = nowInstant.toString();

			JSONObject responseObj = JSONUtil.put("now", nowIsoDateString);

			return success(responseObj);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private UserLocalService _userLocalService;

}