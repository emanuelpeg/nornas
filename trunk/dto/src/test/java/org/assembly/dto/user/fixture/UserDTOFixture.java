/**
 * 
 */
package org.assembly.dto.user.fixture;

import java.util.ArrayList;
import java.util.List;

import org.assembly.dto.user.UserDTO;
import org.assembly.norna.common.util.date.DateUtils;

/**
 * @author emanuel
 * 
 * Fixture of person.
 *
 */
public class UserDTOFixture {

	public static UserDTO createEmanuel() {
		UserDTO aPerson = new UserDTO("Emanuel", "peg", DateUtils.createDate(1983, 1, 18), "emanuelpeg@yahoo.com.ar", "secret");
		return aPerson;
	}
	
	public static UserDTO createJose() {
		UserDTO aPerson = new UserDTO("Jose", "pepe", DateUtils.createDate(1980, 2, 14), "pepe@yahoo.com.ar", "secret");
		return aPerson;
	}
	
	public static UserDTO createPedro() {
		UserDTO aPerson = new UserDTO("Pedro", "coco", DateUtils.createDate(1980, 3, 14), "coco@yahoo.com.ar", "secret");
		return aPerson;
	}
	
	public static UserDTO createJustina() {
		UserDTO aPerson = new UserDTO("Justina", "jus", DateUtils.createDate(1980, 3, 14), "justina@yahoo.com.ar", "secret");
		return aPerson;
	}

	public static List<UserDTO> createFourPersons() {
		List<UserDTO> persons = new ArrayList<UserDTO>();
		
		persons.add(createEmanuel());
		persons.add(createJose());
		persons.add(createPedro());
		persons.add(createJustina());
		
		return persons;
	}

}
