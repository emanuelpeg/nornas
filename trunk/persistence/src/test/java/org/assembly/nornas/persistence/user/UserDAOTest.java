/**
 * 
 */
package org.assembly.nornas.persistence.user;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.assembly.nornas.model.user.User;
import org.assembly.nornas.model.user.fixture.UserFixture;
import org.assembly.nornas.persistence.DaoTestBase;
import org.assembly.nornas.persistence.user.UserDAO;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao's test of person
 * 
 * @author emanuel
 *
 */
public class UserDAOTest extends DaoTestBase{

	@Resource
	private UserDAO userDAO;
	
	public void setPersonDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	@Test
	@Transactional
	public void testFindById() {
		User aPerson = UserFixture.createEmanuel();
		userDAO.save(aPerson);
		User personSaved = userDAO.findBy(aPerson.getId());
		
		assertEqualsUsers(aPerson, personSaved);
		
		aPerson.active();
		userDAO.save(aPerson);
		personSaved = userDAO.findBy(aPerson.getId());
		
		assertEqualsUsers(aPerson, personSaved);
	}
	
	@Test
	@Transactional
	public void testFindByNick() {
		User aPerson = UserFixture.createEmanuel();
		userDAO.save(aPerson);
		User personSaved = userDAO.findByNick(aPerson.getNick());
		
		assertEqualsUsers(aPerson, personSaved);
		
		aPerson.active();
		userDAO.save(aPerson);
		personSaved = userDAO.findByNick(aPerson.getNick());
		
		assertEqualsUsers(aPerson, personSaved);
		
		aPerson.getEmails().add("test@test.com");
		userDAO.save(aPerson);
		personSaved = userDAO.findByNick(aPerson.getNick());
		
		assertEqualsUsers(aPerson, personSaved);
		
	}


	private void assertEqualsUsers(User aPerson, User personSaved) {
		assertEquals(aPerson, personSaved);
		assertEquals(aPerson.getEmails(), personSaved.getEmails());
		assertEquals(aPerson.getActive(), personSaved.getActive());
		assertEquals(aPerson.getBirthDate(), personSaved.getBirthDate());
		assertEquals(aPerson.getName(), personSaved.getName());
		assertEquals(aPerson.getPassword(), personSaved.getPassword());
	}
	
	@Test
	@Transactional
	public void testFindByEmail() {
		User aPerson = UserFixture.createEmanuel();
		userDAO.save(aPerson);
		User personSaved = userDAO.findByEmail(aPerson.getEmail());
		
		assertEqualsUsers(aPerson, personSaved);
	}
	
	@Test
	@Transactional
	public void testFindByAll() {
		List<User> persons = UserFixture.createFourPersons();
		for (User aPerson : persons) {
			userDAO.save(aPerson);			
		}
		
		List<User> personsSaved = userDAO.findAll();
		
		assertEquals(persons.size(), personsSaved.size());
		
		
	}
	
}
