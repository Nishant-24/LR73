package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.service.AuthorizationLocalService;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.ClaimLocalService;
import com.argus.oth.cases.management.ws.application.serializer.ClaimSerializer;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/claim-management",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Claim.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class ClaimApplication extends BaseWsApplication {

	@GET
	@Path("/claim/{claimId}")
	public Response getClaim(@PathParam("claimId") long claimId, @Context HttpServletRequest httpServletRequest) {
		try {
			Claim claim = _claimLocalService.fetchClaim(claimId);

			if (Objects.isNull(claim)) {
				return notFound();
			}

			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			if (!Validator.isBlank(claim.getAuthorizationNumber())) {
				List<Authorization> authorizations = _authorizationLocalService.getAuthorizationsByAuthNumber(
					claim.getAuthorizationNumber());

				if (!authorizations.isEmpty()) {
					Authorization authorization = authorizations.get(0);

					Cases cases = _casesLocalService.fetchCases(authorization.getCaseId());

					if (!validateClientId(currentUser, cases.getClientId())) {
						return notFound();
					}
				}
			}

			JSONObject responseObj = _jsonFactory.createJSONObject();

			responseObj.put("claim", _claimSerializer.serialize(claim));

			return success(responseObj);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@GET
	@Path("/group/{groupId}/claims")
	public Response getClaimsByCaseId(
		@PathParam("groupId") long groupId, @QueryParam("caseId") long caseId,
		@QueryParam("claimNumber") String claimNumber, @Context HttpServletRequest httpServletRequest) {

		try {
			User currentUser = getCurrentUser(httpServletRequest, _userLocalService);

			Cases cases = _casesLocalService.fetchCases(caseId);

			if (!validateClientId(currentUser, cases.getClientId())) {
				return notFound();
			}

			List<Authorization> authorizations = _authorizationLocalService.getAuthorizationsByCaseId(caseId);

			List<Claim> caseClaims = new ArrayList<>();

			for (Authorization authorization : authorizations) {
				if (!Validator.isBlank(authorization.getAuthNumber())) {
					List<Claim> caseClaim = _claimLocalService.getByAuthorizationNumber(authorization.getAuthNumber());

					caseClaims.addAll(caseClaim);
				}
			}

			List<Claim> claimsList = _getSortedClaims(caseClaims);

			int index = _getClaimIndex(claimsList, claimNumber);

			int page = (index / OTHConstants.DEFAULT_DELTA) + 1;

			JSONObject responseObj = _jsonFactory.createJSONObject();

			responseObj.put("claims", _claimSerializer.serialize(claimsList));
			responseObj.put("index", index);
			responseObj.put("page", page);

			return success(responseObj);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	private int _getClaimIndex(List<Claim> claimList, String claimNumber) {
		if (Validator.isNull(claimNumber)) {
			return 0;
		}

		IntStream intStream = IntStream.range(0, claimList.size());

		OptionalInt integerOptional = intStream.filter(
			index -> {
				Claim claim = claimList.get(index);

				return StringUtil.equals(claimNumber, claim.getClaimRef());
			}
		).findFirst();

		return integerOptional.orElse(0);
	}

	private List<Claim> _getSortedClaims(List<Claim> claimsList) {
		Stream<Claim> claimStream = claimsList.stream();

		return claimStream.sorted(
			(claim1, claim2) -> {
				String claim1Status = claim1.getClaimStatus();
				String claim2Status = claim2.getClaimStatus();

				int claim1StatusSortOrder = _claimStatusSortOrder.getOrDefault(claim1Status, 0);
				int claim2StatusSortOrder = _claimStatusSortOrder.getOrDefault(claim2Status, 0);

				return claim1StatusSortOrder - claim2StatusSortOrder;
			}
		).collect(
			Collectors.toList()
		);
	}

	private static final HashMap<String, Integer> _claimStatusSortOrder;

	static {
		_claimStatusSortOrder = HashMapBuilder.put(
			"Closed", 2
		).put(
			"In Process", 0
		).put(
			"Processed", 1
		).build();
	}

	@Reference
	private AuthorizationLocalService _authorizationLocalService;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private ClaimLocalService _claimLocalService;

	@Reference
	private ClaimSerializer _claimSerializer;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private UserLocalService _userLocalService;

}