/**
 * 
 */
package org.assembly.dto.post;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author emanuel
 * 
 *         class represents a post's DTO
 * 
 */
@XmlRootElement(name="postHistory")
public class PostHistoryDTO implements Serializable {

	private static final long serialVersionUID = -6319037835355763839L;

	private Long id;

	private String title;

	private Date publishDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
