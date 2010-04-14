/**
 * 
 */
package org.assembly.nornas.service.person;

import java.util.List;

import org.assembly.dto.person.PersonDTO;
import org.osoa.sca.annotations.Remotable;

/**
 * 
 * @author emanuel
 * 
 *   Interface represents services of Person
 *
 */
@Remotable
public interface PersonService {
	
	List<PersonDTO> findAllPerson();

	PersonDTO findPersonById(Long id);
	
	void savePerson(PersonDTO personDTO);	
	
}
