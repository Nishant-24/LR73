package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.CasesGroupItem;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.CaseAnalyticsService;
import com.argus.oth.cases.management.service.CasesGroupItemLocalService;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.ws.application.serializer.CasesGroupItemSerializer;
import com.argus.oth.cases.management.ws.application.serializer.CasesSerializer;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.integration.mulesoft.background.task.GetCasesTask;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author Jaclyn Ong
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/case-management",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=CaseManagement.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class CaseManagementApplication extends BaseCasesWsApplication {

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/case/{caseId}/bookmark/add")
	@POST
	public Response addBookmark(@PathParam("caseId") long caseId, @Context HttpServletRequest httpServletRequest) {
		return _upsertCaseGroupItem(caseId, httpServletRequest, OTHConstants.CASE_GROUP_TYPE_BOOKMARK);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/case/{caseId}/recentlyViewed/")
	@POST
	public Response addRecentlyViewed(
		@PathParam("caseId") long caseId, @Context HttpServletRequest httpServletRequest) {

		return _upsertCaseGroupItem(caseId, httpServletRequest, OTHConstants.CASE_GROUP_TYPE_RECENTLY_VIEWED);
	}

	@GET
	@Path("/group/{groupId}/bookmarks/")
	public Response getBookmarks(@PathParam("groupId") long groupId, @Context HttpServletRequest httpServletRequest) {
		try {
			User currentUser = getValidCurrentUser(httpServletRequest);

			List<CasesGroupItem> bookmarks = _casesGroupItemLocalService.getCasesGroupItemsByG_U_T(
				groupId, currentUser.getUserId(), OTHConstants.CASE_GROUP_TYPE_BOOKMARK, QueryUtil.ALL_POS);

			JSONArray response = _casesGroupItemSerializer.serializeBookmarks(
				_getFilteredCasesGroupItems(bookmarks, currentUser), currentUser.getTimeZone());

			return success(response);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/case/{caseId}")
	public Response getCase(@PathParam("caseId") long caseId, @Context HttpServletRequest httpServletRequest) {
		try {
			Cases cases = casesService.fetchCaseByCaseId(caseId);

			if (Objects.isNull(cases)) {
				return notFound();
			}

			User currentUser = getCurrentUser(httpServletRequest, userLocalService);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			JSONObject responseObj = _jsonFactory.createJSONObject();

			responseObj.put("case", _casesSerializer.serialize(cases, currentUser.getUserId()));

			_upsertCaseGroupItem(caseId, httpServletRequest, OTHConstants.CASE_GROUP_TYPE_RECENTLY_VIEWED);

			return success(responseObj);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/group/{groupId}")
	public Response getCasesList(@PathParam("groupId") long groupId, @Context HttpServletRequest httpServletRequest) {
		try {
			User currentUser = getCurrentUser(httpServletRequest, userLocalService);

			long clientId = getClientId(currentUser);

			List<Cases> casesList = casesService.getCasesByG_C(groupId, clientId);

			JSONArray response = _casesSerializer.serialize(casesList, currentUser.getUserId());

			Map<String, Serializable> taskContextMap = new HashMap<>();

			taskContextMap.put(GetCasesTask.CLIENT_ID, clientId);

			_backgroundTaskLocalService.addBackgroundTask(
				currentUser.getUserId(), groupId, StringPool.BLANK, GetCasesTask.class.getName(), taskContextMap,
				new ServiceContext());

			return success(response);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	@GET
	@Path("/group/{groupId}/chart-recent-cases")
	public Response getRecentCasesData(
		@PathParam("groupId") long groupId, @QueryParam("startDate") Date startDate,
		@QueryParam("endDate") Date endDate, @QueryParam("interval") String interval,
		@Context HttpServletRequest httpServletRequest) {

		try {
			User currentUser = getValidCurrentUser(httpServletRequest);

			long clientId = getClientId(currentUser);

			Client client = _clientLocalService.fetchClientByExternalClientId(clientId);

			if (Objects.isNull(client)) {
				return failure("Client with clientId " + clientId + " cannot be found");
			}

			JSONObject responseObj = _caseAnalyticsService.getRecentCasesData(
				groupId, clientId, startDate, endDate, interval, currentUser.getTimeZone());

			return success(responseObj);
		}
		catch (Exception pe) {
			return handleError(pe);
		}
	}

	@GET
	@Path("/group/{groupId}/recentlyViewed/")
	public Response getRecentlyViewed(
		@PathParam("groupId") long groupId, @QueryParam("rowLimit") int rowLimit,
		@Context HttpServletRequest httpServletRequest) {

		try {
			User currentUser = getValidCurrentUser(httpServletRequest);

			if (rowLimit < 1) {
				rowLimit = QueryUtil.ALL_POS;
			}

			List<CasesGroupItem> recentlyViewedCases = _casesGroupItemLocalService.getCasesGroupItemsByG_U_T(
				groupId, currentUser.getUserId(), OTHConstants.CASE_GROUP_TYPE_RECENTLY_VIEWED, rowLimit);

			JSONArray response = _casesGroupItemSerializer.serializeRecentlyViewedList(
				_getFilteredCasesGroupItems(recentlyViewedCases, currentUser), currentUser.getTimeZone(),
				currentUser.getUserId());

			return success(response);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/case/{caseId}/bookmark/remove")
	@POST
	public Response removeBookmark(@PathParam("caseId") long caseId, @Context HttpServletRequest httpServletRequest) {
		try {
			Cases cases = getCases(caseId);

			User currentUser = getValidCurrentUser(httpServletRequest);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			CasesGroupItem bookmark = _casesGroupItemLocalService.fetchCasesGroupItemByE_U_T(
				cases.getExternalCaseId(), currentUser.getUserId(), OTHConstants.CASE_GROUP_TYPE_BOOKMARK);

			if (Objects.isNull(bookmark)) {
				return failure(
					"No bookmark found for Case with caseId " + caseId + " and User with userId " +
						currentUser.getUserId());
			}

			_casesGroupItemLocalService.deleteCasesGroupItem(bookmark);

			return success(_jsonFactory.createJSONObject());
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	private List<CasesGroupItem> _getFilteredCasesGroupItems(List<CasesGroupItem> casesGroupItems, User currentUser) {
		List<CasesGroupItem> bookmarksToReturn = new ArrayList<>();

		if (casesGroupItems.isEmpty()) {
			return bookmarksToReturn;
		}

		long clientIdFromUser = getClientId(currentUser);

		for (CasesGroupItem casesGroupItem : casesGroupItems) {
			Cases cases = casesService.fetchCaseByExternalCaseId(casesGroupItem.getExternalCaseId());

			if (!Objects.isNull(cases) && validateClientId(clientIdFromUser, cases.getClientId())) {
				bookmarksToReturn.add(casesGroupItem);
			}
		}

		return bookmarksToReturn;
	}

	private Response _upsertCaseGroupItem(long caseId, HttpServletRequest httpServletRequest, String type) {
		try {
			Cases cases = getCases(caseId);

			User currentUser = getValidCurrentUser(httpServletRequest);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			long externalCaseId = cases.getExternalCaseId();

			CasesGroupItem casesGroupItem = _casesGroupItemLocalService.fetchCasesGroupItemByE_U_T(
				externalCaseId, currentUser.getUserId(), type);

			if (Objects.isNull(casesGroupItem)) {
				_casesGroupItemLocalService.addCasesGroupItem(
					cases.getGroupId(), currentUser.getUserId(), externalCaseId, type);
			}
			else {
				_casesGroupItemLocalService.setModifiedDate(casesGroupItem.getCasesGroupItemId());
			}

			return success(_jsonFactory.createJSONObject());
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@Reference
	private BackgroundTaskLocalService _backgroundTaskLocalService;

	@Reference
	private CaseAnalyticsService _caseAnalyticsService;

	@Reference
	private CasesGroupItemLocalService _casesGroupItemLocalService;

	@Reference
	private CasesGroupItemSerializer _casesGroupItemSerializer;

	@Reference
	private CasesSerializer _casesSerializer;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private JSONFactory _jsonFactory;

}