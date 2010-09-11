/**
 * 
 */
package org.assembly.nornas.model.comment;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 * 
 *         class represents a Comment
 * 
 */

public class Comment extends PersistenEntity {

	private String content;

	private User author;

	private Date creationDate;

	private boolean authorized;

	private Post post;

	public Comment(Post post, String content, User author) {
		super();
		this.post = post;
		this.content = content;
		this.author = author;
		this.creationDate = Calendar.getInstance().getTime();
		this.authorized = false;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		Comment otherComment = (Comment) obj;

		return new EqualsBuilder().append(this.post, otherComment.getPost())
				.append(this.content, otherComment.getContent()).append(
						this.author, otherComment.getAuthor()).append(
						this.creationDate, this.getCreationDate()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.post).append(this.content)
				.append(this.author).append(this.creationDate).toHashCode();
	}

	// it is used by hibernate
	public Comment() {
	}

}
