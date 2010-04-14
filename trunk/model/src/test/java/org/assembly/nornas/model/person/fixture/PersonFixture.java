/**
 * 
 */
package org.assembly.nornas.model.person.fixture;

import java.util.ArrayList;
import java.util.List;

import org.assembly.norna.common.util.date.DateUtils;
import org.assembly.nornas.model.person.Person;

/**
 * @author emanuel
 * 
 * Fixture of person.
 *
 */
public class PersonFixture {

	public static Person createEmanuel() {
		Person aPerson = new Person("Emanuel", "peg", DateUtils.createDate(1983, 1, 18), "emanuelpeg@yahoo.com.ar");
		return aPerson;
	}
	
	public static Person createJose() {
		Person aPerson = new Person("Jose", "pepe", DateUtils.createDate(1982, 6, 14), "pepe@yahoo.com.ar");
		return aPerson;
	}
	
	public static Person createPedro() {
		Person aPerson = new Person("Pedro", "coco", DateUtils.createDate(1985, 5, 14), "coco@yahoo.com.ar");
		return aPerson;
	}
	
	public static Person createJustina() {
		Person aPerson = new Person("Justina", "jus", DateUtils.createDate(1980, 3, 14), "justina@yahoo.com.ar");
		return aPerson;
	}

	public static List<Person> createFourPersons() {
		List<Person> persons = new ArrayList<Person>();
		
		persons.add(createEmanuel());
		persons.add(createJose());
		persons.add(createPedro());
		persons.add(createJustina());
		
		return persons;
	}

}
