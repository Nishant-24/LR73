package com.argus.oth.claim.ws.application;

import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.claim.model.ClaimsReportRetrievalParametersImpl;
import com.argus.oth.claim.ws.application.exporter.ReportingExporter;
import com.argus.oth.common.ws.base.BaseWsApplication;
import com.argus.oth.data.export.configuration.BatchExportConfigurator;

import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.DateRange;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
 * @author Eric Chin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/reporting",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Reporting.Rest", "auth.verifier.guest.allowed=false"
	},
	service = Application.class
)
public class ReportingApplication extends BaseWsApplication {

	@GET
	@Path("/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadReport(
		@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate,
		@Context HttpServletRequest httpServletRequest) {

		Client client = null;

		try {
			client = getClient(httpServletRequest, _userLocalService, _clientLocalService);
		}
		catch (IllegalStateException ex) {
			return failure(ex.getMessage());
		}

		ClaimsReportRetrievalParametersImpl claimsReportRetrievalParameters = new ClaimsReportRetrievalParametersImpl();

		claimsReportRetrievalParameters.setExternalClientId(client.getExternalClientPk());

		claimsReportRetrievalParameters.setDateRange(new DateRange(_getStartDate(startDate), _getEndDate(endDate)));

		File file = _reportingExporter.generateReport(claimsReportRetrievalParameters);

		if (Objects.isNull(file)) {
			return Response.status(
				Response.Status.NOT_FOUND
			).build();
		}

		String outputFileName = _batchExportConfigurator.outputFileName();

		if (Validator.isNull(outputFileName)) {
			outputFileName = _DEFAULT_OUTPUT_FILE_NAME;
		}

		return Response.ok(
			file, MediaType.APPLICATION_OCTET_STREAM
		).header(
			"Content-Disposition", "attachment; filename=" + outputFileName
		).build();
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	private Date _getEndDate(Date endDate) {
		if (Objects.isNull(endDate)) {
			return null;
		}

		Calendar calendar = CalendarFactoryUtil.getCalendar(endDate.getTime());

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	private Date _getStartDate(Date startDate) {
		if (Objects.isNull(startDate)) {
			return null;
		}

		Calendar calendar = CalendarFactoryUtil.getCalendar(startDate.getTime());

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	private static final String _DEFAULT_OUTPUT_FILE_NAME = "report.xlsx";

	@Reference
	private BatchExportConfigurator _batchExportConfigurator;

	@Reference
	private ClientLocalService _clientLocalService;

	@Reference
	private ReportingExporter _reportingExporter;

	@Reference
	private UserLocalService _userLocalService;

}