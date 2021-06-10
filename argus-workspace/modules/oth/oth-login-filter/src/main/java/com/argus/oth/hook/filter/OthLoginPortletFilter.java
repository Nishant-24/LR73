package com.argus.oth.hook.filter;

import com.argus.oth.hook.filter.configuration.OthLoginFilterConfigurator;
import com.liferay.login.web.internal.constants.LoginPortletKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(
	immediate = true, property = {"javax.portlet.name=" + LoginPortletKeys.LOGIN, "service.ranking:Integer=100"},
	service = PortletFilter.class
)
public class OthLoginPortletFilter implements RenderFilter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
		throws IOException, PortletException {

		request.setAttribute("adminProviderName", _othLoginFilterConfigurator.getAdminProviderName());
		request.setAttribute("openIdProviderName", _othLoginFilterConfigurator.getOpenIdConnectProviderName());

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
	}

	@Reference
	private OthLoginFilterConfigurator _othLoginFilterConfigurator;

}