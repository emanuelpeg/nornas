/**
 * 
 */
package org.assembly.mapper.person;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.user.UserDTO;
import org.assembly.mapper.DozerTest;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.model.user.fixture.UserFixture;
import org.dozer.DozerBeanMapper;
import org.junit.Test;

/**
 * @author emanuel
 * 
 * Test of Dozer's mapping by Person
 *
 */
public class UserToUserDTOTest extends DozerTest {
	
	@Resource
	private DozerBeanMapper dtoMapper;
	
	@Test
	public void map() {
		User user = UserFixture.createPedro();
		UserDTO userDTO = this.dtoMapper.map(user, UserDTO.class, "User_UserDTO");
		
		verifyPerson(userDTO, user);
	}
	
	
	private void verifyPerson(UserDTO dto, User user) {
		assertEquals(dto.getName(), user.getName());
		assertEquals(dto.getNick(), user.getNick());
		assertEquals(dto.getBirthDate(), user.getBirthDate());
		assertEquals(dto.getEmails(), user.getEmails());		
	}

}
