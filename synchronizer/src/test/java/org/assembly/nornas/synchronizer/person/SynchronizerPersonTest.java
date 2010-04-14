/**
 * 
 */
package org.assembly.nornas.synchronizer.person;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.person.PersonDTO;
import org.assembly.dto.person.fixture.PersonDTOFixture;
import org.assembly.nornas.model.person.Person;
import org.assembly.nornas.model.person.fixture.PersonFixture;
import org.assembly.nornas.repository.person.PersonRepository;
import org.assembly.nornas.synchronizer.SynchronizerTestBase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 *
 *	Test of SynchronizerPerson
 *
 */
public class SynchronizerPersonTest extends SynchronizerTestBase {

	@Resource
	private SynchronizerPerson synchronizerPerson;
	
	@Resource
	private PersonRepository personDAO;
	
	@Test
	public void synchronizerUnsavedPerson() {
		PersonDTO dto = PersonDTOFixture.createEmanuel();
		Person person = this.synchronizerPerson.synchronize(dto);
		
		verifyPerson(dto, person);
	}

	@Transactional
	@Test
	public void synchronizerSavedPerson() {
		Person person = PersonFixture.createJose();
		this.personDAO.save(person);
		
		PersonDTO dto = PersonDTOFixture.createEmanuel();
		dto.setId(person.getId());
		Person otherPerson = this.synchronizerPerson.synchronize(dto);
		
		verifyPerson(dto, otherPerson);
	}
	
	
	private void verifyPerson(PersonDTO dto, Person person) {
		assertEquals(dto.getName(), person.getName());
		assertEquals(dto.getNick(), person.getNick());
		assertEquals(dto.getBirthDate(), person.getBirthDate());
		assertEquals(dto.getEmail(), person.getEmail());
		
	}
	
}
