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
		
		assertEquals(aPerson, personSaved);
		
		aPerson.active();
		userDAO.save(aPerson);
		personSaved = userDAO.findBy(aPerson.getId());
		
		assertEquals(aPerson, personSaved);
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
