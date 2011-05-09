/**
 * 
 */
package org.assembly.dto.blog;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.dto.style.StyleDTO;
import org.assembly.dto.user.UserDTO;


/**
 * @author emanuel
 * 
 *         DTO of Blog
 * 
 */

public class BlogDTO implements Serializable {

	private static final long serialVersionUID = 55008293279477652L;
	
	private Long id;

	private String url;

	private String title;

	private String subTitle;

	private UserDTO admin;

	private Date creationDate;
	
	private StyleDTO style;
	
	public BlogDTO() {	}

	public BlogDTO(String url, String title, String subTitle, UserDTO admin) {
		super();
		this.url = url;
		this.title = title;
		this.subTitle = subTitle;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserDTO getAdmin() {
		return admin;
	}

	public void setAdmin(UserDTO admin) {
		this.admin = admin;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public StyleDTO getStyle() {
		return style;
	}

	public void setStyle(StyleDTO style) {
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

		BlogDTO otherBlog = (BlogDTO) obj;

		return new EqualsBuilder().append(this.url, otherBlog.getUrl()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.url).toHashCode();
	}
	
}
