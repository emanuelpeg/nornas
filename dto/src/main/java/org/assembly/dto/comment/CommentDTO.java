/**
 * 
 */
package org.assembly.dto.comment;

import java.io.Serializable;
import java.util.Date;

import org.assembly.dto.user.UserDTO;

/**
 * @author emanuel
 * 
 *         class represents a Comment's DTO
 * 
 */

public class CommentDTO implements Serializable {
	
	private static final long serialVersionUID = -6769562220809754974L;

	private Long id;
	
	private String content;

	private UserDTO author;

	private Date creationDate;

	private Boolean authorized = Boolean.FALSE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getAuthorized() {
		return authorized;
	}

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}

	
}
