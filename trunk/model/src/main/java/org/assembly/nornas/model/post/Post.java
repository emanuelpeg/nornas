/**
 * 
 */
package org.assembly.nornas.model.post;

import java.util.Calendar;
import java.util.Date;

import org.assembly.nornas.model.person.Person;

/**
 * @author emanuel
 * 
 * class represents a post 
 *
 */
public class Post {
	
	private String title;
	
	private String content;
	
	private Date date = Calendar.getInstance().getTime();
	
	private StatePost estado = StatePost.DRAFT;
	
	private Person author;
	
	
	public Post(String title, String content, Person author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	

	public Post(String title, String content, Date date, StatePost estado,
			Person author) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.estado = estado;
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

	public StatePost getEstado() {
		return estado;
	}

	public void setEstado(StatePost estado) {
		this.estado = estado;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	} 
	
	// is used by Hibernate.
	public Post() { 	}
	
	
}
