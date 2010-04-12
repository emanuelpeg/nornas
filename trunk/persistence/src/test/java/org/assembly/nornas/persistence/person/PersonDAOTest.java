/**
 * 
 */
package org.assembly.nornas.persistence.person;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.assembly.nornas.model.person.Person;
import org.assembly.nornas.model.person.fixture.PersonFixture;
import org.assembly.nornas.persistence.DaoTestBase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao's test of person
 * 
 * @author emanuel
 *
 */
public class PersonDAOTest extends DaoTestBase{

	@Resource
	private PersonDAO personDAO;
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	
	@Test
	@Transactional
	public void testFindById() {
		Person aPerson = PersonFixture.createEmanuel();
		personDAO.save(aPerson);
		Person personSaved = personDAO.findBy(aPerson.getId());
		
		assertEquals(aPerson, personSaved);		
	}
	
	@Test
	@Transactional
	public void testFindByAll() {
		List<Person> persons = PersonFixture.createFourPersons();
		for (Person aPerson : persons) {
			personDAO.save(aPerson);			
		}
		
		List<Person> personsSaved = personDAO.findAll();
		
		assertEquals(persons.size(), personsSaved.size());
		
		
	}
	
}
