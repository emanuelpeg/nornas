/**
 * 
 */
package org.assembly.nornas.model.post;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;
import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.comment.Comment;
import org.assembly.nornas.model.tag.Tag;

/**
 * @author emanuel
 * 
 *         class represents a post
 * 
 */
public class Post extends PersistenEntity {

	private String title;

	private String content;

	private Date publishDate;
	
	private Date creationDate;

	private StatePost state = StatePost.DRAFT;

	private Author author;
	
	private Boolean commentAllow = Boolean.FALSE;
	
	private List<Tag> tags = new ArrayList<Tag>();

	private List<Comment> comments = new ArrayList<Comment>();
	
	public Post(String title, String content, Author author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate = Calendar.getInstance().getTime();
	}

	public Post(String title, String content, StatePost state,
			Author author) {
		this(title, content, author);
		this.state = state;
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

	public StatePost getState() {
		return state;
	}

	public void setState(StatePost state) {
		this.state = state;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Boolean getCommentAllow() {
		return commentAllow;
	}

	public Boolean isCommentAllow() {
		return commentAllow;
	}

	public void setCommentAllow(Boolean commentAllow) {
		this.commentAllow = commentAllow;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		Post otherPost = (Post) obj;

		return new EqualsBuilder()
				.append(this.getTitle(), otherPost.getTitle()).append(
						this.getAuthor(), otherPost.getAuthor()).append(
						this.getCreationDate(), otherPost.getCreationDate()).append(
						this.getState(), otherPost.getState()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getTitle()).append(
				this.getAuthor()).append(this.getCreationDate())
				.append(this.getState()).toHashCode();
	}

	// is used by Hibernate.
	public Post() {
	}

}
