/**
 * 
 */
package org.assembly.dto.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.assembly.dto.comment.CommentDTO;
import org.assembly.dto.tag.TagDTO;

/**
 * @author emanuel
 * 
 *         class represents a post's DTO
 * 
 */
@XmlRootElement(name="post")
public class PostDTO implements Serializable {

	private static final long serialVersionUID = -6319037835355763839L;

	private Long id;

	private String title;

	private String content;

	private Date publishDate;
	
	private Date creationDate;

	private String author;
	
	private Boolean commentAllow = Boolean.FALSE;
	
	private List<TagDTO> tags = new ArrayList<TagDTO>();

	private List<CommentDTO> comments = new ArrayList<CommentDTO>();
	

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getCommentAllow() {
		return commentAllow;
	}

	public void setCommentAllow(Boolean commentAllow) {
		this.commentAllow = commentAllow;
	}

	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	

}
