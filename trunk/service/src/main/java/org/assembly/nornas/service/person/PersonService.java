/**
 * 
 */
package org.assembly.nornas.service.person;

import java.util.List;

import org.assembly.dto.person.PersonDTO;

/**
 * 
 * @author emanuel
 * 
 *   Interface represents services of Person
 *
 */
public interface PersonService {

	void savePerson(PersonDTO person);
	
	PersonDTO findPersonById(Long id);
	
	List<PersonDTO> findAllPerson();
	
}
