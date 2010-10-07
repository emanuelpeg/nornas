/**
 * 
 */
package org.assembly.serviceImpl.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.assembly.dto.user.UserDTO;
import org.assembly.dto.user.fixture.UserDTOFixture;
import org.assembly.nornas.serviceImpl.user.UserServiceImpl;
import org.assembly.serviceImpl.BaseServiceTest;
import org.junit.Test;

/**
 * @author emanuel
 * 
 * Test of PersonServiceImpl
 *
 */
public class UserServiceImplTest extends BaseServiceTest {
	
	@Resource(name="service.user")
	private UserServiceImpl userService;
	
	@Test
	public void findById() {
		UserDTO personDTO = UserDTOFixture.createJustina();
		Long id = userService.saveUser(personDTO);
		
		UserDTO personDTOSaved = userService.findUserById(id);
		
		assertNotNull(personDTOSaved);
		verifyPerson(personDTO, personDTOSaved);
	}
	
	@Test
	public void findAll() {
		UserDTO personDTO = UserDTOFixture.createJustina();
		userService.saveUser(personDTO);
		
		List<UserDTO> personDTOs = userService.findAllUser();
		
		assertNotNull(personDTOs);
		assertEquals(1, personDTOs.size());
		
		UserDTO personDTOSaved = personDTOs.get(0);
		
		verifyPerson(personDTO, personDTOSaved);
	}

	private void verifyPerson(UserDTO personDTO, UserDTO otherPersonDTO) {
		assertEquals(personDTO.getName(), otherPersonDTO.getName());
		assertEquals(personDTO.getNick(), otherPersonDTO.getNick());
		assertEquals(personDTO.getBirthDate(), otherPersonDTO.getBirthDate());
		assertEquals(personDTO.getEmails(), otherPersonDTO.getEmails());		
	}
	
}
