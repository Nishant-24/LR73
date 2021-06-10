package com.argus.oth.cases.management.webhook.rs.internal.resource.v1_0;

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.model.Task;
import com.argus.oth.cases.management.service.AuthorizationLocalService;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.cases.management.service.NoteLocalService;
import com.argus.oth.cases.management.service.TaskLocalService;
import com.argus.oth.cases.management.webhook.rs.constants.WebhookStatus;
import com.argus.oth.cases.management.webhook.rs.dto.v1_0.ProcessEvent;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.enums.DataRequestType;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.resource.OpenAPIResource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.servlet.ServletConfig;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy
 * @generated
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/openapi.properties",
	service = OpenAPIResourceImpl.class
)
@Generated("")
@OpenAPIDefinition(
	info = @Info(description = "OpenAPI definition for OTH's headless APIs", title = "OTH OpenAPI", version = "v1.0")
)
@Path("/v1.0")
public class OpenAPIResourceImpl {

	@GET
	@Path("/openapi.{type:json|yaml}")
	@Produces({MediaType.APPLICATION_JSON, "application/yaml"})
	public Response getOpenAPI(
			@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo,
			@PathParam("type") String type)
		throws Exception {

		return _openAPIResource.getOpenAPI(
			_application, httpHeaders, _resourceClasses, _servletConfig, type,
			uriInfo);
	}

	@PATCH
	@Path("/authorization/{UUID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patchAuthorization(
		@PathParam("UUID") String uuid, ProcessEvent processEvent, @Context UriInfo uriInfo) {

		WebhookStatus webhookStatus = WebhookStatus.getWebhookStatusByCode(processEvent.getStatusCode());

		long primKey = GetterUtil.getLong(processEvent.getPrimaryKey());

		Authorization authorization = _authorizationLocalService.fetchAuthorizationByUuidAndGroupId(
			uuid, _getOTHPortalGroupId());

		if (_validate(authorization, processEvent, uriInfo)) {
			_authorizationLocalService.updateAuthorization(
				authorization.getAuthorizationId(), primKey, webhookStatus.name(), _getStatusDescription(processEvent));

			_updateLastUpdated(authorization.getCaseId(), DataRequestType.AUTHORIZATION.name());
		}

		return Response.ok().build();
	}

	@PATCH
	@Path("/note/{UUID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patchNote(
		@PathParam("UUID") String uuid, ProcessEvent processEvent, @Context UriInfo uriInfo) {

		WebhookStatus webhookStatus = WebhookStatus.getWebhookStatusByCode(processEvent.getStatusCode());

		long primKey = GetterUtil.getLong(processEvent.getPrimaryKey());

		Note note = _noteLocalService.fetchNoteByUuidAndGroupId(uuid, _getOTHPortalGroupId());

		if (_validate(note, processEvent, uriInfo)) {
			_noteLocalService.updateNote(
				note.getNoteId(), primKey, processEvent.getType(), webhookStatus.name(),
				_getStatusDescription(processEvent));

			_updateLastUpdated(note.getCaseId(), DataRequestType.NOTE.name());
		}

		return Response.ok().build();
	}

	@PATCH
	@Path("/task/{UUID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response patchTask(
		@PathParam("UUID") String uuid, ProcessEvent processEvent, @Context UriInfo uriInfo) {

		WebhookStatus webhookStatus = WebhookStatus.getWebhookStatusByCode(processEvent.getStatusCode());

		long primKey = GetterUtil.getLong(processEvent.getPrimaryKey());

		Task task = _taskLocalService.fetchTaskByUuidAndGroupId(uuid, _getOTHPortalGroupId());

		if (_validate(task, processEvent, uriInfo)) {
			_taskLocalService.updateTask(
				task.getTaskId(), primKey, webhookStatus.name(), _getStatusDescription(processEvent));

			_updateLastUpdated(task.getCaseId(), DataRequestType.TASK.name());
		}

		return Response.ok().build();
	}

	private long _getOTHPortalGroupId() {
		long companyId = _portal.getDefaultCompanyId();

		Group group = _groupLocalService.fetchGroup(companyId, OTHConstants.OTH_PORTAL_GROUP_NAME);

		if (Objects.isNull(group)) {
			return OTHConstants.DEFAULT_GROUP_ID;
		}

		return group.getGroupId();
	}

	private String _getStatusDescription(ProcessEvent processEvent) {
		String statusDescription = StringPool.BLANK;

		if (Validator.isNotNull(processEvent.getStatusDescription())) {
			statusDescription = processEvent.getStatusDescription();
		}

		return statusDescription;
	}

	private void _logDebug(String path, ProcessEvent processEvent) {
		if (_log.isDebugEnabled()) {
			_log.debug("Processing " + path + " with data :: " + processEvent.toString());
		}
	}

	private void _updateLastUpdated(long caseId, String type) {
		Cases cases = _casesLocalService.fetchCases(caseId);

		if (Objects.isNull(cases)) {
			_log.warn("Unable to find cases with caseId " + caseId);

			return;
		}

		Calendar calendar = CalendarFactoryUtil.getCalendar();

		calendar.add(Calendar.HOUR_OF_DAY, _HOURS_DIFFERENCE);

		_dataRequestLocalService.updateDataRequest(
			cases.getClientId(), cases.getCaseId(), cases.getExternalCaseId(), type, calendar.getTime());
	}

	private boolean _validate(Object obj, ProcessEvent processEvent, UriInfo uriInfo) {
		long primKey = GetterUtil.getLong(processEvent.getPrimaryKey());
		String path = uriInfo.getPath();

		if (Objects.nonNull(obj) && (primKey != 0)) {
			_logDebug(path, processEvent);

			return true;
		}

		_log.warn("Unable to process " + path + " with data :: " + processEvent.toString());

		return false;
	}

	@Context
	private Application _application;

	@Reference
	private AuthorizationLocalService _authorizationLocalService;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private DataRequestLocalService _dataRequestLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private NoteLocalService _noteLocalService;

	@Reference
	private OpenAPIResource _openAPIResource;

	@Reference
	private Portal _portal;

	private final Set<Class<?>> _resourceClasses = new HashSet<Class<?>>() {
		{
			add(OpenAPIResourceImpl.class);
		}
	};

	@Context
	private ServletConfig _servletConfig;

	@Reference
	private TaskLocalService _taskLocalService;

	private static final int _HOURS_DIFFERENCE = -8;

	private static final Log _log = LogFactoryUtil.getLog(OpenAPIResourceImpl.class);

}