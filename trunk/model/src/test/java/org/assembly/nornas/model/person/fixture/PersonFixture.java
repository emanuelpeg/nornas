/**
 * 
 */
package org.assembly.nornas.model.person.fixture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assembly.nornas.model.person.Person;

/**
 * @author emanuel
 * 
 * Fixture of person.
 *
 */
public class PersonFixture {

	public static Person createEmanuel() {
		Person aPerson = new Person("Emanuel", "peg", new Date(18-01-1983), "emanuelpeg@yahoo.com.ar");
		return aPerson;
	}
	
	public static Person createJose() {
		Person aPerson = new Person("Jose", "pepe", new Date(18-02-1980), "pepe@yahoo.com.ar");
		return aPerson;
	}
	
	public static Person createPedro() {
		Person aPerson = new Person("Pedro", "coco", new Date(28-03-1993), "coco@yahoo.com.ar");
		return aPerson;
	}
	
	public static Person createJustina() {
		Person aPerson = new Person("Justina", "jus", new Date(14-03-1980), "justina@yahoo.com.ar");
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
