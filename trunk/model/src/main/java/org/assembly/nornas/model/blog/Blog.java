/**
 * 
 */
package org.assembly.nornas.model.blog;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;
import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.style.Style;
import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 * 
 *         class represents a Blog
 * 
 */

public class Blog extends PersistenEntity {

	private String url;

	private String title;

	private String subTitle;

	private User admin;

	private Date creationDate;

	private List<Post> posts;

	private Set<Author> authors;
	
	private Style style;

	public Blog(String url, String title, String subTitle, User admin) {
		super();
		this.url = url;
		this.title = title;
		this.subTitle = subTitle;
		this.admin = admin;
		this.creationDate = Calendar.getInstance().getTime();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		Blog otherBlog = (Blog) obj;

		return new EqualsBuilder().append(this.url, otherBlog.getUrl()).append(
				this.title, otherBlog.getTitle()).append(this.subTitle,
				otherBlog.getSubTitle()).append(this.admin,
				otherBlog.getAdmin()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.url).append(this.title)
				.append(this.subTitle).append(this.admin).toHashCode();
	}
	
	// is used by hibernate
	public Blog() {	}

}
