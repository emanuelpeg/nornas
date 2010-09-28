/**
 * 
 */
package org.assembly.norna.common.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @author emanuel
 * 
 *         Class Util with responsibility of encrypt
 * 
 */
public class EncryptUtil {


	private static final String UTF_8 = "UTF-8";
	private static final String SHA = "SHA";

	/**
	 * encrypt a value new one is created
	 * 
	 */
	public static String encrypt(String value) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(SHA); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			md.update(value.getBytes(UTF_8)); 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte raw[] = md.digest(); 
		String hash = (new BASE64Encoder()).encode(raw); 
		return hash; 
	}

}
