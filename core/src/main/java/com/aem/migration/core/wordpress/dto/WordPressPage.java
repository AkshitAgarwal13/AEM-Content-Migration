package com.aem.migration.core.wordpress.dto;

import java.util.List;

/**
 * The Class WordPressPage.
 */
public class WordPressPage {

	/** The id. */
	private String id;
	
	/** The date. */
	private String date;
	
	/** The gmt date. */
	private String gmt_date;
	
	/** The modified. */
	private String modified;
	
	/** The modified gmt. */
	private String modified_gmt;
	
	/** The slug. */
	private String slug;
	
	/** The status. */
	private String status;
	
	/** The type. */
	private String type;
	
	/** The link. */
	private String link;
	
	/** The title. */
	private PageTitle title;
	
	/** The content. */
	private PageContent content;
	
	/** The excerpt. */
	private PageExcerpt excerpt;
	
	/** The author. */
	private String author;
	
	/** The featured media. */
	private String featured_media;
	
	/** The parent. */
	private String parent;
	
	/** The comment status. */
	private String comment_status;
	
	/** The ping status. */
	private String ping_status;
	
	/** The template. */
	private String template;
	
	/** The wp components list. */
	private List<WPComponent> wpComponentsList;
	
	/**
	 * Gets the wp components list.
	 *
	 * @return the wp components list
	 */
	public List<WPComponent> getWpComponentsList() {
		return wpComponentsList;
	}

	/**
	 * Sets the wp components list.
	 *
	 * @param wpComponentsList the new wp components list
	 */
	public void setWpComponentsList(List<WPComponent> wpComponentsList) {
		this.wpComponentsList = wpComponentsList;
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Gets the gmt date.
	 *
	 * @return the gmt date
	 */
	public String getGmt_date() {
		return gmt_date;
	}
	
	/**
	 * Sets the gmt date.
	 *
	 * @param gmt_date the new gmt date
	 */
	public void setGmt_date(String gmt_date) {
		this.gmt_date = gmt_date;
	}
	
	/**
	 * Gets the modified.
	 *
	 * @return the modified
	 */
	public String getModified() {
		return modified;
	}
	
	/**
	 * Sets the modified.
	 *
	 * @param modified the new modified
	 */
	public void setModified(String modified) {
		this.modified = modified;
	}
	
	/**
	 * Gets the modified gmt.
	 *
	 * @return the modified gmt
	 */
	public String getModified_gmt() {
		return modified_gmt;
	}
	
	/**
	 * Sets the modified gmt.
	 *
	 * @param modified_gmt the new modified gmt
	 */
	public void setModified_gmt(String modified_gmt) {
		this.modified_gmt = modified_gmt;
	}
	
	/**
	 * Gets the slug.
	 *
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	
	/**
	 * Sets the slug.
	 *
	 * @param slug the new slug
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public PageTitle getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(PageTitle title) {
		this.title = title;
	}
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public PageContent getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(PageContent content) {
		this.content = content;
	}
	
	/**
	 * Gets the excerpt.
	 *
	 * @return the excerpt
	 */
	public PageExcerpt getExcerpt() {
		return excerpt;
	}
	
	/**
	 * Sets the excerpt.
	 *
	 * @param excerpt the new excerpt
	 */
	public void setExcerpt(PageExcerpt excerpt) {
		this.excerpt = excerpt;
	}
	
	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Gets the featured media.
	 *
	 * @return the featured media
	 */
	public String getFeatured_media() {
		return featured_media;
	}
	
	/**
	 * Sets the featured media.
	 *
	 * @param featured_media the new featured media
	 */
	public void setFeatured_media(String featured_media) {
		this.featured_media = featured_media;
	}
	
	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the comment status.
	 *
	 * @return the comment status
	 */
	public String getComment_status() {
		return comment_status;
	}
	
	/**
	 * Sets the comment status.
	 *
	 * @param comment_status the new comment status
	 */
	public void setComment_status(String comment_status) {
		this.comment_status = comment_status;
	}
	
	/**
	 * Gets the ping status.
	 *
	 * @return the ping status
	 */
	public String getPing_status() {
		return ping_status;
	}
	
	/**
	 * Sets the ping status.
	 *
	 * @param ping_status the new ping status
	 */
	public void setPing_status(String ping_status) {
		this.ping_status = ping_status;
	}
	
	/**
	 * Gets the template.
	 *
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}
	
	/**
	 * Sets the template.
	 *
	 * @param template the new template
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
}
