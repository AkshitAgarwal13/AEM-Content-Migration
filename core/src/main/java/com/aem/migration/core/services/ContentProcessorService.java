package com.aem.migration.core.services;

import java.io.BufferedReader;

import com.aem.migration.core.aem.dto.AEMPage;
import com.aem.migration.core.wordpress.dto.WordPressPage;

/**
 * The Interface ContentProcessorService.
 */
public interface ContentProcessorService {
	
	/**
	 * Gets the source content extract file path.
	 *
	 * @return the source content extract file path
	 */
	public String getSourceContentExtractFilePath();

	
	/**
	 * Gets the source content extract.
	 *
	 * @return the source content extract
	 */
	public BufferedReader getSourceContentExtract();
	
	/**
	 * Gets the WP page object.
	 *
	 * @return the WP page object
	 */
	public WordPressPage getWPPageObject();
	
	/**
	 * Extract WP page components.
	 *
	 * @param wpPage the wp page
	 */
	public void extractWPPageComponents(WordPressPage wpPage);
	
	/**
	 * Gets the AEM page create script.
	 *
	 * @param aemPage the aem page
	 * @return the AEM page create script
	 */
	public String getAEMPageCreateScript(AEMPage aemPage);
	
}
