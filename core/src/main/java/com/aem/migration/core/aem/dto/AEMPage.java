package com.aem.migration.core.aem.dto;

import com.aem.migration.core.wordpress.dto.WordPressPage;

/**
 * The Class AEMPage.
 */
public class AEMPage {

	/** The jcr primary type. */
	private String jcr_primaryType;
	
	/** The jcr created by. */
	private String jcr_createdBy;
	
	/** The jcr content. */
	private JCRContent jcrContent;
	
	public JCRContent getJcrContent() {
		return jcrContent;
	}

	/**
	 * Instantiates a new AEM page.
	 *
	 * @param wpPage the wp page
	 */
	public AEMPage(WordPressPage wpPage) {

		this.jcr_primaryType = "cq:Page";
		this.jcr_createdBy = wpPage.getAuthor();
		this.jcrContent = new JCRContent(wpPage);
	}
	
	/**
	 * Gets the jcr primary type.
	 *
	 * @return the jcr primary type
	 */
	public String getJcr_primaryType() {
		return jcr_primaryType;
	}

	/**
	 * Gets the jcr created by.
	 *
	 * @return the jcr created by
	 */
	public String getJcr_createdBy() {
		return jcr_createdBy;
	}

}
