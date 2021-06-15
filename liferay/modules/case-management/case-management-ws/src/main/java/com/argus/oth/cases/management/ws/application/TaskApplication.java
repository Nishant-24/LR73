package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Task;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.TaskService;
import com.argus.oth.cases.management.service.TaskStatusType;
import com.argus.oth.cases.management.ws.application.serializer.TaskSerializer;
import com.argus.oth.common.OTHConstants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import io.swagger.client.ApiException;

import java.text.DateFormat;
import java.text.ParseException;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.Consumes;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/case-task",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Task.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class TaskApplication extends BaseCasesWsApplication {

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/group/{groupId}/task/")
	@POST
	public Response createTask(
		@PathParam("groupId") long groupId, String taskJSON, @Context HttpServletRequest httpServletRequest) {

		try {
			JSONObject task = _jsonFactory.createJSONObject(taskJSON);

			String validationError = _validate(task);

			if (!Validator.isBlank(validationError)) {
				return failure(LanguageUtil.get(httpServletRequest, validationError));
			}

			long caseId = task.getLong(OTHConstants.CASE_ID);

			Cases cases = _casesLocalService.fetchCases(caseId);

			if (Objects.isNull(cases)) {
				return failure("Case with caseId " + caseId + " cannot be found");
			}

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			String taskUUID = getUUID();

			JSONObject jsonObjectResponse = _taskService.addTask(
				taskUUID, groupId, task.getLong(OTHConstants.CASE_ID), task.getString(OTHConstants.DESCRIPTION_KEY),
				task.getString(_START_DATE), null, null, 0, task.getString(OTHConstants.PRIORITY_KEY),
				_DEFAULT_TASK_STATUS, DEFAULT_PROCESS_STATUS, StringPool.BLANK, currentUser.getUserId());

			return success(jsonObjectResponse);
		}
		catch (ApiException apie) {
			if (_log.isErrorEnabled()) {
				_log.error(apie.getResponseBody());
			}

			return handleError(apie, Response.Status.fromStatusCode(apie.getCode()));
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@GET
	@Path("/group/{groupId}/task/")
	public Response getTasksByCaseId(
		@PathParam("groupId") long groupId, @QueryParam("caseId") long caseId, @QueryParam("start") int start,
		@QueryParam("end") int end, @Context HttpServletRequest httpServletRequest) {

		try {
			List<Task> tasks = _taskService.getTasksByCaseId(caseId, start, end);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			Cases cases = _casesLocalService.fetchCases(caseId);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			JSONArray response = _taskSerializer.serialize(tasks);

			return success(response);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	private Date _parseStartDate(String startDate) throws ParseException {
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(OTHConstants.DATE_PATTERN_YYYY_DD_MM);

		return dateFormat.parse(startDate);
	}

	private String _validate(JSONObject taskJSONObject) {
		if (Validator.isBlank(taskJSONObject.getString(OTHConstants.CASE_ID))) {
			return OTHConstants.CASE_ID + "is required.";
		}

		if (Validator.isBlank(taskJSONObject.getString(_DESCRIPTION_KEY))) {
			return _DESCRIPTION_KEY + " is required";
		}

		if (Validator.isBlank(taskJSONObject.getString(_PRIORITY_KEY))) {
			return _PRIORITY_KEY + " is required";
		}

		String startDateString = taskJSONObject.getString(_START_DATE);

		if (Validator.isBlank(startDateString)) {
			return _START_DATE + " is required";
		}

		try {
			_parseStartDate(startDateString);
		}
		catch (Exception e) {
			if (_log.isErrorEnabled()) {
				_log.error(e, e);
			}

			return "please-enter-the-correct-format-yyyy-mm-dd";
		}

		return StringPool.BLANK;
	}

	private static final String _DEFAULT_TASK_STATUS = TaskStatusType.NEW.getStatusText();

	private static final String _DESCRIPTION_KEY = "descriptionKey";

	private static final String _PRIORITY_KEY = "priorityKey";

	private static final String _START_DATE = "startDate";

	private static final Log _log = LogFactoryUtil.getLog(TaskApplication.class);

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private TaskSerializer _taskSerializer;

	@Reference
	private TaskService _taskService;

	@Reference
	private UserLocalService _userLocalService;

}