/**
 * 
 */
package org.assembly.dto.person.fixture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assembly.dto.person.PersonDTO;
import org.assembly.norna.common.util.date.DateUtils;

/**
 * @author emanuel
 * 
 * Fixture of person.
 *
 */
public class PersonDTOFixture {

	public static PersonDTO createEmanuel() {
		PersonDTO aPerson = new PersonDTO("Emanuel", "peg", DateUtils.createDate(1983, 1, 18), "emanuelpeg@yahoo.com.ar");
		return aPerson;
	}
	
	public static PersonDTO createJose() {
		PersonDTO aPerson = new PersonDTO("Jose", "pepe", DateUtils.createDate(1980, 2, 14), "pepe@yahoo.com.ar");
		return aPerson;
	}
	
	public static PersonDTO createPedro() {
		PersonDTO aPerson = new PersonDTO("Pedro", "coco", DateUtils.createDate(1980, 3, 14), "coco@yahoo.com.ar");
		return aPerson;
	}
	
	public static PersonDTO createJustina() {
		PersonDTO aPerson = new PersonDTO("Justina", "jus", DateUtils.createDate(1980, 3, 14), "justina@yahoo.com.ar");
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
