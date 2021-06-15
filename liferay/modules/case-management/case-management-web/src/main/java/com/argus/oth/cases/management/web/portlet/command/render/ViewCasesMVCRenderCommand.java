package com.argus.oth.cases.management.web.portlet.command.render;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.web.constants.CasesPortletKeys;

import com.argus.oth.data.export.BatchEngineExportTaskExecutor;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(
	immediate = true, property = {"javax.portlet.name=" + CasesPortletKeys.CASES_PORTLET, "mvc.command.name=/"},
	service = MVCRenderCommand.class
)
public class ViewCasesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_buildSearchContainer(renderRequest);

		return "/view.jsp";
	}

	private SearchContainer _buildSearchContainer(RenderRequest renderRequest) {
		PortletURL iteratorURL = PortletURLFactoryUtil.create(
			renderRequest, CasesPortletKeys.CASES_PORTLET, PortletRequest.RENDER_PHASE);

		String emptyResultsMessage = LanguageUtil.get(Locale.getDefault(), "no-cases-available");

		List<String> headerNames = new ArrayList<>();

		headerNames.add("last-updated");
		headerNames.add("case-id");
		headerNames.add("client-name");
		headerNames.add("diag-code");
		headerNames.add("charged-amount");
		headerNames.add("reprice-amount");
		headerNames.add("paid-amount");
		headerNames.add("savings-percent");
		headerNames.add("status");

		SearchContainer<Cases> searchContainer = new SearchContainer<>(
			renderRequest, iteratorURL, headerNames, emptyResultsMessage);

		List<Cases> cases = _casesLocalService.getCaseses(searchContainer.getStart(), searchContainer.getEnd());

		searchContainer.setResults(cases);

		searchContainer.setTotal(_casesLocalService.getCasesesCount());

		renderRequest.setAttribute("casesSearchContainer", searchContainer);

		return searchContainer;
	}

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private BatchEngineExportTaskExecutor _batchEngineExportTaskExecutor;

}