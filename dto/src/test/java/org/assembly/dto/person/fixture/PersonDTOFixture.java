/**
 * 
 */
package org.assembly.dto.person.fixture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assembly.dto.person.PersonDTO;

/**
 * @author emanuel
 * 
 * Fixture of person.
 *
 */
public class PersonDTOFixture {

	public static PersonDTO createEmanuel() {
		PersonDTO aPerson = new PersonDTO("Emanuel", "peg", new Date(18-01-1983), "emanuelpeg@yahoo.com.ar");
		return aPerson;
	}
	
	public static PersonDTO createJose() {
		PersonDTO aPerson = new PersonDTO("Jose", "pepe", new Date(18-02-1980), "pepe@yahoo.com.ar");
		return aPerson;
	}
	
	public static PersonDTO createPedro() {
		PersonDTO aPerson = new PersonDTO("Pedro", "coco", new Date(28-03-1993), "coco@yahoo.com.ar");
		return aPerson;
	}
	
	public static PersonDTO createJustina() {
		PersonDTO aPerson = new PersonDTO("Justina", "jus", new Date(14-03-1980), "justina@yahoo.com.ar");
		return aPerson;
	}

	public static List<PersonDTO> createFourPersons() {
		List<PersonDTO> persons = new ArrayList<PersonDTO>();
		
		persons.add(createEmanuel());
		persons.add(createJose());
		persons.add(createPedro());
		persons.add(createJustina());
		
		return persons;
	}

}
