package org.assembly.nornas.repository.person;

import java.io.Serializable;

import org.assembly.nornas.model.person.Person;

/**
 * @author emanuel
 *
 * Interface represents a repository of Person 
 * 
 */
public interface PersonRepository {
	
	void save(Person person);
	
	Person findBy(Serializable id);

}
