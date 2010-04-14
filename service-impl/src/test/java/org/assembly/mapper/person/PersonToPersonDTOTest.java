/**
 * 
 */
package org.assembly.mapper.person;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.person.PersonDTO;
import org.assembly.mapper.DozerTest;
import org.assembly.nornas.model.person.Person;
import org.assembly.nornas.model.person.fixture.PersonFixture;
import org.dozer.DozerBeanMapper;
import org.junit.Test;

/**
 * @author emanuel
 * 
 * Test of Dozer's mapping by Person
 *
 */
public class PersonToPersonDTOTest extends DozerTest {
	
	@Resource
	private DozerBeanMapper dtoMapper;
	
	@Test
	public void map() {
		Person person = PersonFixture.createPedro();
		PersonDTO personDTO = this.dtoMapper.map(person, PersonDTO.class, "Person_PersonDTO");
		
		verifyPerson(personDTO, person);
	}
	
	
	private void verifyPerson(PersonDTO dto, Person person) {
		assertEquals(dto.getName(), person.getName());
		assertEquals(dto.getNick(), person.getNick());
		assertEquals(dto.getBirthDate(), person.getBirthDate());
		assertEquals(dto.getEmail(), person.getEmail());		
	}

}
