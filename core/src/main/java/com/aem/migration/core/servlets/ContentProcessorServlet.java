package com.aem.migration.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.migration.core.aem.dto.AEMPage;
import com.aem.migration.core.services.ContentProcessorService;
import com.aem.migration.core.wordpress.dto.WordPressPage;
import com.google.gson.Gson;

@Component(service = { Servlet.class }, property = { "sling.servlet.methods=get",
		"sling.servlet.paths=/bin/migrate-content" })
public class ContentProcessorServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	@Reference
	ContentProcessorService contentProcessor;

	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {

		WordPressPage wpPage = contentProcessor.getWPPageObject();
		AEMPage aemPage = new AEMPage(wpPage);

		Gson gson = new Gson();
		String aemPageJSON = gson.toJson(aemPage).replace("jcr_", "jcr:").replace("cq_", "cq:")
				.replace("sling_", "sling:").replace("jcrContent", "jcr:content").replace("rootNode", "root")
				.replace("rootContainer", "container").replace("childContainerNode", "container");

		String curlScript = contentProcessor.getAEMPageCreateScript(aemPage);

		if (StringUtils.equalsIgnoreCase(request.getParameter("showAEMPageJSON"), "true")) {
			response.setContentType("application/json");
			response.getWriter().write(aemPageJSON);
		} else {
			response.setContentType("text/html");
			response.getWriter().write(curlScript);
		}
	}
}
