/**
 * 
 */
package org.assembly.nornas.model.post;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.assembly.nornas.model.person.Person;

/**
 * @author emanuel
 * 
 *         class represents a post
 * 
 */
public class Post {

	private String title;

	private String content;

	private Date date = Calendar.getInstance().getTime();

	private StatePost state = StatePost.DRAFT;

	private Person author;

	public Post(String title, String content, Person author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Post(String title, String content, Date date, StatePost state,
			Person author) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.state = state;
		this.author = author;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StatePost getState() {
		return state;
	}

	public void setState(StatePost state) {
		this.state = state;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
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
						this.getDate(), otherPost.getDate()).append(
						this.getState(), otherPost.getState()).isEquals();
	}

	// is used by Hibernate.
	public Post() {
	}

}
