package org.assembly.nornas.persistence.person;

import org.assembly.nornas.model.person.Person;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.person.PersonRepository;

/**
 * @author emanuel
 *
 * class represents a DAO of Person 
 * 
 */
public class PersonDAO extends BaseDao<Person> implements PersonRepository {

	@Override
	protected Class<Person> getClase() {
		return Person.class;
	}


}
