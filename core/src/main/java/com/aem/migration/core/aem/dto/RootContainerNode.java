package com.aem.migration.core.aem.dto;

import com.aem.migration.core.wordpress.dto.WordPressPage;

/**
 * The Class RootNode.
 */
public class RootContainerNode {

	/** The jcr primary type. */
	private String jcr_primaryType;
	
	/** The layout. */
	private String layout;
	
	/** The sling resource type. */
	private String sling_resourceType;
	
	/** The child container node. */
	private ChildContainerNode childContainerNode;
	
	/**
	 * Gets the jcr primary type.
	 *
	 * @return the jcr primary type
	 */
	public String getJcr_primaryType() {
		return jcr_primaryType;
	}

	/**
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public String getLayout() {
		return layout;
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
	 * Gets the child container node.
	 *
	 * @return the child container node
	 */
	public ChildContainerNode getChildContainerNode() {
		return childContainerNode;
	}

	/**
	 * Instantiates a new root node.
	 *
	 * @param wpPage the wp page
	 */
	public RootContainerNode(WordPressPage wpPage) {

		this.jcr_primaryType = "nt:unstructured";
		this.layout = "responsiveGrid";
		this.sling_resourceType = "migration/components/container";
		this.childContainerNode = new ChildContainerNode(wpPage);
	}
}
