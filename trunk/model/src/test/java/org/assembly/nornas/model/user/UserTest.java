/**
 * 
 */
package org.assembly.nornas.model.user;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author emanuel
 *
 */
public class UserTest {

	/**
	 * Test method for {@link org.assembly.nornas.model.user.User#isPasword(java.lang.String)}.
	 */
	@Test
	public void isPasword() {
		User user = new User("emanuelpeg", "emanuelpeg@yahoo.com.ar", "password");
		
		assertTrue(user.isPasword("password"));
		assertFalse(user.isPasword("otroPassword"));		
	}

}
