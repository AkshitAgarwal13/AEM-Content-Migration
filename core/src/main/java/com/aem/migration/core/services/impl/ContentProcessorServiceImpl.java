package com.aem.migration.core.services.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.migration.core.aem.dto.AEMPage;
import com.aem.migration.core.aem.dto.components.AEMComponent;
import com.aem.migration.core.services.ContentProcessorService;
import com.aem.migration.core.utils.MigrationUtil;
import com.aem.migration.core.wordpress.dto.WPComponent;
import com.aem.migration.core.wordpress.dto.WordPressPage;
import com.day.cq.dam.api.Asset;
import com.google.gson.Gson;

@Component(
	service = { ContentProcessorService.class }
)
@Designate(ocd = ContentProcessorServiceImpl.Config.class)
public class ContentProcessorServiceImpl implements ContentProcessorService {

	private static final Logger log = LoggerFactory.getLogger(ContentProcessorServiceImpl.class);

	@Reference
	private ResourceResolverFactory resolverFactory;

	@ObjectClassDefinition(
		name = "Migration - Configuration",
		description = "OSGi Service - Configuration to support migration process."
	)
	@interface Config {

		@AttributeDefinition(
			name = "Content Source File Path (in DAM)",
			description = "Path of the file having the content extract from source CMS."
		)
		String sourceContentExtractFilePath() default "/content/dam/migration/single-page-extract.json";
		
		@AttributeDefinition(
				name = "AEM Component Name and Properties",
				description = "A mapping of AEM components and associated properties(comma separated).",
				type = AttributeType.STRING
		)
		String[] aemComponentPropertyMapping();
		
		@AttributeDefinition(
				name = "Source CMS Component Name and Properties",
				description = "A mapping of source CMS components and associated properties(comma separated).",
				type = AttributeType.STRING
		)
		String[] sourceCMScomponentPropertyMapping();
	}

	/** The source content extract file path. */
	private String sourceContentExtractFilePath;
	
	/** The component aem property mapping. */
	private String[] aemComponentPropertyMapping;
	
	/** The component source CMS property mapping. */
	private String[] sourceCMScomponentPropertyMapping;

	/**
	 * Gets the source content extract file path.
	 *
	 * @return the source content extract file path
	 */
	public String getSourceContentExtractFilePath() {
	
		return sourceContentExtractFilePath;
	}
	
	/**
	 * Gets the component prperty mapping.
	 *
	 * @return the component prperty mapping
	 */
	public String[] getAEMComponentPropertyMapping() {
		
		return aemComponentPropertyMapping;
	}

	/**
	 * Gets the source CM scomponent property mapping.
	 *
	 * @return the source CM scomponent property mapping
	 */
	public String[] getSourceCMScomponentPropertyMapping() {
		
		return sourceCMScomponentPropertyMapping;
	}

	@Activate
	protected void activate(Config config) {

		this.sourceContentExtractFilePath = config.sourceContentExtractFilePath();
		this.aemComponentPropertyMapping = config.aemComponentPropertyMapping();

		log.info("File path of the source content extract is {}", this.sourceContentExtractFilePath);
	}

	@Deactivate
	protected void deactivate() {
		log.info("ActivitiesImpl has been deactivated!");
	}

	/**
	 * Gets the source content extract.
	 *
	 * @return the source content extract
	 */
	@Override
	public BufferedReader getSourceContentExtract() {

		/* Reading the JSON File from DAM. */
		Resource original;
		BufferedReader br = null;
		InputStream content = null;
		// Map<String, Object> param = new HashMap<>();
		// param.put(ResourceResolverFactory.SUBSERVICE, "readService"); //readService
		// is System User.
		try {

			ResourceResolver resolver = resolverFactory.getAdministrativeResourceResolver(null); // Change this to get resolver using service user.																				
			Resource resource = resolver.getResource(this.sourceContentExtractFilePath);
			Asset asset = resource.adaptTo(Asset.class);
			original = asset.getOriginal();
			content = original.adaptTo(InputStream.class);
			br = new BufferedReader(new InputStreamReader(content, StandardCharsets.UTF_8));
			return br;
		} catch (LoginException exc) {
			
			log.info("Exception while reading the source content file", exc);
		}
		return null;
	}

	/**
	 * Gets the WP page object.
	 *
	 * @return the WP page object
	 */
	@Override
	public WordPressPage getWPPageObject() {
		
		BufferedReader pageJSONReader = getSourceContentExtract();
		WordPressPage wpPage = null;
		
		if(pageJSONReader != null) {
			
			wpPage = deserializeResult(pageJSONReader, WordPressPage.class);
		}
		extractWPPageComponents(wpPage);
		return wpPage;
	}

	/**
	 * Deserialize result.
	 *
	 * @param <T>          the generic type
	 * @param pageContent the response body
	 * @param declaredType the declared type
	 * @return the t
	 */
	public <T extends Object> T deserializeResult(final BufferedReader pageContent, final Class<T> declaredType) {

		Gson gson = new Gson();
		return gson.fromJson(pageContent, declaredType);
	}

	/**
	 * Extract WP page components.
	 *
	 * @param wpPage the wp page
	 */
	@Override
	public void extractWPPageComponents(WordPressPage wpPage) {
		
		if(wpPage != null && StringUtils.isNotBlank(wpPage.getContent().getRendered())) {
		
			String pageHTML = wpPage.getContent().getRendered();
			Document html = Jsoup.parse(pageHTML);
			Elements elements = html.getAllElements();
			int counter = 0;
			List<WPComponent> componentsList = new ArrayList<>();
			for(Element element : elements) {

				if(element != null) {

					log.info("Element names are {}", element.nodeName());
					WPComponent component = MigrationUtil.getComponent(element);
					if(component != null) {

						componentsList.add(component);
						counter++;
					}
				}
			}
			log.info("Number of components {}", counter);
			wpPage.setWpComponentsList(componentsList);
		}
	}

	/**
	 * Gets the AEM page create script.
	 *
	 * @param aemPage the aem page
	 * @return the AEM page create script
	 */
	@Override
	public String getAEMPageCreateScript(AEMPage aemPage) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("curl -u admin:admin -F \"jcr:primaryType=");
		sb.append(aemPage.getJcr_primaryType() + "\"");
		sb.append(" -F \"jcr:content/jcr:primaryType=");
		sb.append(aemPage.getJcrContent().getJcr_primaryType() + "\"");
		sb.append(" -F \"jcr:content/jcr:title=");
		sb.append(aemPage.getJcrContent().getJcr_title() + "\"");
		sb.append(" -F \"jcr:content/sling:resourceType=migration/components/page\"");
		sb.append(" http://localhost:4502/content/migration/us/en/new-page-1");
		sb.append(" -F \"jcr:content/root/layout=responsiveGrid\"");
		sb.append(" -F \"jcr:content/root/sling:resourceType=migration/components/container\"");
		sb.append(" -F \"jcr:content/root/container/layout=responsiveGrid\"");
		sb.append(" -F \"jcr:content/root/container/sling:resourceType=migration/components/container\"");
		sb.append(" -F \"jcr:content/root/container/container/sling:resourceType=migration/components/container\"");

		List<AEMComponent> components = aemPage.getJcrContent().getRootNode().getContainer().getChildContainerNode().getComponentsList();
		Map<String, String[]> mapCompProp = MigrationUtil.getComponentJCRPropertiesMap(this.aemComponentPropertyMapping);
		if(MapUtils.isNotEmpty(mapCompProp)) {
		
			for(int count = 0; count < components.size(); count++) {
			
				AEMComponent aemComp =  components.get(count);
				sb.append(MigrationUtil.getComponentJCRProperties(aemComp, mapCompProp));
			}
		}

		return sb.toString();
	}

}