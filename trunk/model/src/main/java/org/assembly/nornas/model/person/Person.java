/**
 * 
 */
package org.assembly.nornas.model.person;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;

/**
 * @author emanuel
 * 
 *         class represents a person
 * 
 */
public class Person extends PersistenEntity {

	private String name;

	private String nick;

	private Date birthDate;

	private String email;

	public Person(String email) {
		super();
		this.email = email;
	}

	public Person(String nick, String email) {
		super();
		this.nick = nick;
		this.email = email;
	}

	public Person(String name, String nick, Date birthDate, String email) {
		super();
		this.name = name;
		this.nick = nick;
		this.birthDate = birthDate;
		this.email = email;
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

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		Person otherPerson = (Person) obj;

		return new EqualsBuilder()
				.append(this.getNick(), otherPerson.getNick()).append(
						this.getEmail(), otherPerson.getEmail()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getNick()).append(
				this.getEmail()).hashCode();
	}

	// is used by Hibernate.
	public Person() {
	}

}
