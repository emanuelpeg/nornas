/**
 * 
 */
package org.assembly.nornas.synchronizer.person;

import org.assembly.dto.person.PersonDTO;
import org.assembly.nornas.model.person.Person;
import org.assembly.nornas.repository.person.PersonRepository;
import org.assembly.nornas.synchronizer.Synchronizer;

/**
 * @author emanuel
 * 
 *  class responsible of synchronize person with personDTO
 *
 */
public class SynchronizerPerson implements Synchronizer<PersonDTO, Person>{
	
	private PersonRepository personDAO;
	
	public void setPersonDAO(PersonRepository personDAO) {
		this.personDAO = personDAO;
	}



	public Person synchronize(PersonDTO dto) {
		Person aPerson =  null;
		
		if (dto.getId() == null) {
			aPerson = new Person(dto.getName(), dto.getNick(), dto.getBirthDate(), dto.getEmail());
		} else {
			aPerson = this.personDAO.findBy(dto.getId());
			aPerson.setName(dto.getName());
			aPerson.setNick(dto.getNick());
			aPerson.setEmail(dto.getEmail());
			aPerson.setBirthDate(dto.getBirthDate());
		}
		
		return aPerson;
	}

}
