/**
 * 
 */
package org.assembly.nornas.service.person;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

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
@WebService
public interface PersonService {
	
	@WebMethod(operationName="findAllPerson")
	List<PersonDTO> findAllPerson();

	PersonDTO findPersonById(Long id);
	
	void savePerson(PersonDTO personDTO);	
	
}
