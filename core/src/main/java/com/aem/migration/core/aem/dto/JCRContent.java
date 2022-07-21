package com.aem.migration.core.aem.dto;

import com.aem.migration.core.wordpress.dto.WordPressPage;

/**
 * The Class JCRContent.
 */
public class JCRContent {
	
	/** The jcr primary type. */
	private String jcr_primaryType;
	
	/** The jcr created by. */
	private String jcr_createdBy;
	
	/** The jcr title. */
	private String jcr_title;

	/** The cq template. */
	private String cq_template;

	/** The jcr created. */
	private String jcr_created;

	/** The cq last modified. */
	private String cq_lastModified;

	/** The sling resource type. */
	private String sling_resourceType;

	/** The cq last modified by. */
	private String cq_lastModifiedBy;

	/** The root node. */
	private RootNode rootNode;

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
	
	/**
	 * Gets the jcr title.
	 *
	 * @return the jcr title
	 */
	public String getJcr_title() {
		return jcr_title;
	}
	
	/**
	 * Gets the cq template.
	 *
	 * @return the cq template
	 */
	public String getCq_template() {
		return cq_template;
	}
	
	/**
	 * Gets the jcr created.
	 *
	 * @return the jcr created
	 */
	public String getJcr_created() {
		return jcr_created;
	}
	
	/**
	 * Gets the cq last modified.
	 *
	 * @return the cq last modified
	 */
	public String getCq_lastModified() {
		return cq_lastModified;
	}
	
	/**
	 * Gets the sling resource type.
	 *
	 * @return the sling resource type
	 */
	public String getSling_resourceType() {
		return sling_resourceType;
	}
	
	/**
	 * Gets the cq last modified by.
	 *
	 * @return the cq last modified by
	 */
	public String getCq_lastModifiedBy() {
		return cq_lastModifiedBy;
	}

	/**
	 * Gets the root node.
	 *
	 * @return the root node
	 */
	public RootNode getRootNode() {
		return rootNode;
	}
	
	/**
	 * Instantiates a new JCR content.
	 *
	 * @param wpPage the wp page
	 */
	public JCRContent(WordPressPage wpPage) {

		this.jcr_title = wpPage.getTitle().getRendered();
		this.jcr_primaryType = "cq:PageContent";
		this.cq_template = "/conf/migration/settings/wcm/templates/page-content";
		this.sling_resourceType = "migration/components/page";
		this.cq_lastModifiedBy = wpPage.getAuthor();
		this.rootNode = new RootNode(wpPage);
	}

}
