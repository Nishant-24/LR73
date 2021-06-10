package com.argus.oth.cases.management.ws.application;

import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.cases.management.ws.application.serializer.ReferenceTypeCodeSerializer;
import com.argus.oth.common.ws.base.BaseWsApplication;

import com.liferay.portal.kernel.json.JSONArray;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/reference-type-code",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=ReferenceTypeCode.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class ReferenceTypeCodeApplication extends BaseWsApplication {

	@GET
	@Path("/group/{groupId}/type/{type}")
	public Response getReferenceTypeCodesByType(@PathParam("type") String type) {
		try {
			List<ReferenceTypeCode> referenceTypeCodes = _referenceTypeCodeLocalService.getByType(type);

			JSONArray response = _referenceTypeCodeSerializer.serialize(referenceTypeCodes);

			return success(response);
		}
		catch (Exception e) {
			return handleError(e);
		}
	}

	@Reference
	private ReferenceTypeCodeLocalService _referenceTypeCodeLocalService;

	@Reference
	private ReferenceTypeCodeSerializer _referenceTypeCodeSerializer;

}