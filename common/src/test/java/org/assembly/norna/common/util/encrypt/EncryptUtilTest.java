/**
 * 
 */
package org.assembly.norna.common.util.encrypt;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author emanuel
 * 
 * 	      EncryptUtil's Test
 * 
 */
public class EncryptUtilTest {
	
	@Test
	public void encrypt() {
		String password = "pepelui";
		String passwordEncrypt = EncryptUtil.encrypt(password);
		
		String password2 = "pepelui";
		String passwordEncrypt2 = EncryptUtil.encrypt(password2);
		
		assertEquals(passwordEncrypt, passwordEncrypt2);
	}
	

}
