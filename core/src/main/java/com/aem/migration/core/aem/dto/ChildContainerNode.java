package com.aem.migration.core.aem.dto;

import java.util.List;

import com.aem.migration.core.aem.dto.components.AEMComponent;
import com.aem.migration.core.utils.MigrationUtil;
import com.aem.migration.core.wordpress.dto.WordPressPage;

public class ChildContainerNode {

	/** The jcr primary type. */
	private String jcr_primaryType = "nt:unstructured";

	/** The sling resource type. */
	private String sling_resourceType = "migration/components/container";
	
	private List<AEMComponent> componentsList;

	/**
	 * Gets the jcr primary type.
	 *
	 * @return the jcr primary type
	 */
	public String getJcr_primaryType() {
		return jcr_primaryType;
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
	 * Gets the components list.
	 *
	 * @return the components list
	 */
	public List<AEMComponent> getComponentsList() {
		return componentsList;
	}
	/**
	 * Instantiates a new child container node.
	 *
	 * @param wpPage the wp page
	 */
	public ChildContainerNode(WordPressPage wpPage) {
		this.jcr_primaryType = "nt:unstructured";
		this.sling_resourceType = "migration/components/container";
		this.componentsList = MigrationUtil.getAEMComponentsList(wpPage);
	}
}
