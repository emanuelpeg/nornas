/**
 * 
 */
package org.assembly.dto.person;

import java.io.Serializable;
import java.util.Date;

/**
 * @author emanuel
 *
 *	DTO of Person
 *
 */
public class PersonDTO implements Serializable{
	
	private static final long serialVersionUID = -8849055479888319903L;

	private Long id;
	
	private String name;

	private String nick;

	private Date birthDate;

	private String email;
	
	public PersonDTO() { }

	public PersonDTO(String name, String nick, Date birthDate, String email) {
		super();
		this.name = name;
		this.nick = nick;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
