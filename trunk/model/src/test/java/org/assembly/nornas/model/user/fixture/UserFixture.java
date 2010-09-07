/**
 * 
 */
package org.assembly.nornas.model.user.fixture;

import java.util.ArrayList;
import java.util.List;

import org.assembly.norna.common.util.date.DateUtils;
import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 * 
 * Fixture of person.
 *
 */
public class UserFixture {

	public static User createEmanuel() {
		User aUser = new User("Emanuel", "peg", DateUtils.createDate(1983, 1, 18), "emanuelpeg@yahoo.com.ar", "secreto");
		return aUser;
	}
	
	public static User createJose() {
		User aUser = new User("Jose", "pepe", DateUtils.createDate(1982, 6, 14), "pepe@yahoo.com.ar", "secreto");
		return aUser;
	}
	
	public static User createPedro() {
		User aUser = new User("Pedro", "coco", DateUtils.createDate(1985, 5, 14), "coco@yahoo.com.ar", "secreto");
		return aUser;
	}
	
	public static User createJustina() {
		User aUser = new User("Justina", "jus", DateUtils.createDate(1980, 3, 14), "justina@yahoo.com.ar", "secreto");
		return aUser;
	}

	public static List<User> createFourPersons() {
		List<User> persons = new ArrayList<User>();
		
		persons.add(createEmanuel());
		persons.add(createJose());
		persons.add(createPedro());
		persons.add(createJustina());
		
		return persons;
	}

}
