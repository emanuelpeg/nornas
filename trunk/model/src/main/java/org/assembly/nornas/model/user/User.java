/**
 * 
 */
package org.assembly.nornas.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;

/**
 * @author emanuel
 * 
 *         class represents a user
 * 
 */
public class User extends PersistenEntity {

	private String name;

	private String nick;

	private Date birthDate;

	private List<String> emails = new ArrayList<String>();
	
	private String password;


	public User(String nick, String email, String password) {
		this.nick = nick;
		this.emails.add(email);
		this.password = password;
	}

	public User(String name, String nick, Date birthDate, String email, String password) {
		this(nick, email, password);
		this.name = name;
		this.birthDate = birthDate;
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
	
	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		User otherPerson = (User) obj;

		return new EqualsBuilder()
				.append(this.getNick(), otherPerson.getNick()).append(
						this.getEmails(), otherPerson.getEmails()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getNick()).append(
				this.getEmails()).hashCode();
	}

	// is used by Hibernate.
	public User() {
	}

}
