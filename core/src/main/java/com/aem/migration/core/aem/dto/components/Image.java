package com.aem.migration.core.aem.dto.components;

import com.aem.migration.core.wordpress.dto.WPComponent;

/**
 * The Class Image.
 */
public class Image {

	/** The jcr primary type. */
	private String jcr_primaryType;
	
	/** The node name. */
	private String nodeName;

	/** The jcr title. */
	private String jcr_title;

	/** The file reference. */
	private String fileReference;

	/** The id. */
	private String id;

	/** The alt. */
	private String alt;

	/** The link URL. */
	private String linkURL;

	/** The display popup title. */
	private String displayPopupTitle;

	/** The title value from DAM. */
	private String titleValueFromDAM;

	/** The sling resource type. */
	private String sling_resourceType;

	/** The is decorative. */
	private String isDecorative;

	/** The alt value from DAM. */
	private String altValueFromDAM;

	/** The height. */
	private String height;

	/** The width. */
	private String width;

	/**
	 * Gets the jcr primary type.
	 *
	 * @return the jcr primary type
	 */
	public String getJcr_primaryType() {
		return jcr_primaryType;
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
	 * Gets the file reference.
	 *
	 * @return the file reference
	 */
	public String getFileReference() {
		return fileReference;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the alt.
	 *
	 * @return the alt
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * Gets the link URL.
	 *
	 * @return the link URL
	 */
	public String getLinkURL() {
		return linkURL;
	}

	/**
	 * Gets the display popup title.
	 *
	 * @return the display popup title
	 */
	public String getDisplayPopupTitle() {
		return displayPopupTitle;
	}

	/**
	 * Gets the title value from DAM.
	 *
	 * @return the title value from DAM
	 */
	public String getTitleValueFromDAM() {
		return titleValueFromDAM;
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
	 * Gets the checks if is decorative.
	 *
	 * @return the checks if is decorative
	 */
	public String getIsDecorative() {
		return isDecorative;
	}

	/**
	 * Gets the alt value from DAM.
	 *
	 * @return the alt value from DAM
	 */
	public String getAltValueFromDAM() {
		return altValueFromDAM;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Gets the node name.
	 *
	 * @return the node name
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * Instantiates a new image.
	 *
	 * @param wpImage the wp image
	 */
	public Image(WPComponent wpImage, int componentCounter) {

		this.jcr_primaryType = "nt:unstructured";
		this.jcr_title = wpImage.getImgCaption();
		this.fileReference = wpImage.getImgSrc();
		this.id = null;
		this.alt = wpImage.getAlt();
		this.linkURL = wpImage.getSrc();
		this.displayPopupTitle = "false";
		this.titleValueFromDAM = "false";
		this.sling_resourceType = "migration/components/image";
		this.isDecorative = "false";
		this.altValueFromDAM = "false";
		this.nodeName = "image_" + componentCounter;
		
	}
}
