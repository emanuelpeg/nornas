/**
 * 
 */
package org.assembly.serviceImpl.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.assembly.dto.person.PersonDTO;
import org.assembly.dto.person.fixture.PersonDTOFixture;
import org.assembly.nornas.serviceImpl.person.PersonServiceImpl;
import org.assembly.serviceImpl.BaseServiceTest;
import org.junit.Test;

/**
 * @author emanuel
 * 
 * Test of PersonServiceImpl
 *
 */
public class PersonServiceImplTest extends BaseServiceTest {
	
	@Resource(name="service.person")
	private PersonServiceImpl personService;
	
	@Test
	public void findById() {
		PersonDTO personDTO = PersonDTOFixture.createJustina();
		personService.savePerson(personDTO);
		
		PersonDTO personDTOSaved = personService.findPersonById(personDTO.getId());
		
		assertNotNull(personDTOSaved);
		verifyPerson(personDTO, personDTOSaved);
	}
	
	@Test
	public void findAll() {
		PersonDTO personDTO = PersonDTOFixture.createJustina();
		personService.savePerson(personDTO);
		
		List<PersonDTO> personDTOs = personService.findAllPerson();
		
		assertNotNull(personDTOs);
		assertEquals(1, personDTOs.size());
		
		PersonDTO personDTOSaved = personDTOs.get(0);
		
		verifyPerson(personDTO, personDTOSaved);
	}

	private void verifyPerson(PersonDTO personDTO, PersonDTO otherPersonDTO) {
		assertEquals(personDTO.getName(), otherPersonDTO.getName());
		assertEquals(personDTO.getNick(), otherPersonDTO.getNick());
		assertEquals(personDTO.getBirthDate(), otherPersonDTO.getBirthDate());
		assertEquals(personDTO.getEmail(), otherPersonDTO.getEmail());		
	}
	
}
