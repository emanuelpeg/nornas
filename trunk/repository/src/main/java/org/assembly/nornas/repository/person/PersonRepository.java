package org.assembly.nornas.repository.person;

import java.io.Serializable;
import java.util.List;

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
	
	List<Person> findAll();

}
