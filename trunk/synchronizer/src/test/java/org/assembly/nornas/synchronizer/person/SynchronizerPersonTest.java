/**
 * 
 */
package org.assembly.nornas.synchronizer.person;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.user.UserDTO;
import org.assembly.dto.user.fixture.UserDTOFixture;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.model.user.fixture.UserFixture;
import org.assembly.nornas.repository.user.UserRepository;
import org.assembly.nornas.synchronizer.SynchronizerTestBase;
import org.assembly.nornas.synchronizer.user.SynchronizerUser;
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
	private SynchronizerUser synchronizerUser;
	
	@Resource
	private UserRepository userDAO;
	
	@Test
	public void synchronizerUnsavedPerson() {
		UserDTO dto = UserDTOFixture.createEmanuel();
		User person = this.synchronizerUser.synchronize(dto);
		
		verifyPerson(dto, person);
	}

	@Transactional
	@Test
	public void synchronizerSavedPerson() {
		User user = UserFixture.createJose();
		this.userDAO.save(user);
		
		UserDTO dto = UserDTOFixture.createEmanuel();
		dto.setId(user.getId());
		User otherUser = this.synchronizerUser.synchronize(dto);
		
		verifyPerson(dto, otherUser);
	}
	
	
	private void verifyPerson(UserDTO dto, User person) {
		assertEquals(dto.getName(), person.getName());
		assertEquals(dto.getNick(), person.getNick());
		assertEquals(dto.getBirthDate(), person.getBirthDate());
		assertEquals(dto.getEmail(), person.getEmail());
		
	}
	
}
