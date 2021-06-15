package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.NoteService;
import com.argus.oth.cases.management.ws.application.serializer.NoteSerializer;
import com.argus.oth.common.OTHConstants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

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
 * @author Davy Duran
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/case-note",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Note.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class NoteApplication extends BaseCasesWsApplication {

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/group/{groupId}/note/")
	@POST
	public Response createNote(
		@PathParam("groupId") long groupId, String noteJSON, @Context HttpServletRequest httpServletRequest) {

		try {
			JSONObject note = _jsonFactory.createJSONObject(noteJSON);

			long caseId = note.getLong(OTHConstants.CASE_ID);

			Cases cases = _casesLocalService.fetchCases(caseId);

			if (Objects.isNull(cases)) {
				return failure("Case with caseId " + caseId + " cannot be found");
			}

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			if (Objects.isNull(currentUser)) {
				return failure("Current user cannot be found");
			}

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			String noteUUID = getUUID();
			String text = note.getString("text");

			JSONObject jsonObjectResponse = _noteService.addNote(
				noteUUID, groupId, caseId, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, 0,
				new Date(), OTHConstants.NOTE_TYPE_CARRIER, OTHConstants.NOTE, text, DEFAULT_PROCESS_STATUS,
				StringPool.BLANK, currentUser.getUserId(), StringPool.BLANK);

			return success(jsonObjectResponse);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/group/{groupId}/note/")
	public Response getNotesByCaseId(
		@PathParam("groupId") long groupId, @QueryParam("caseId") long caseId, @QueryParam("start") int start,
		@QueryParam("end") int end, @Context HttpServletRequest httpServletRequest) {

		try {
			Cases cases = _casesLocalService.fetchCases(caseId);

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			List<Note> notes = _noteService.getNotesByCaseId(caseId, start, end);

			JSONArray notesList = _noteSerializer.serialize(notes, currentUser.getTimeZone());

			JSONObject response = JSONUtil.put(
				"list", notesList
			).put(
				"total", _noteService.countNotesByCaseId(caseId)
			);

			return success(response);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private NoteSerializer _noteSerializer;

	@Reference
	private NoteService _noteService;

	@Reference
	private UserLocalService _userLocalService;

}