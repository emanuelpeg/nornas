/**
 * 
 */
package org.assembly.nornas.web.example;

import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.util.Bindable;
import org.assembly.dto.person.PersonDTO;
import org.assembly.nornas.service.person.PersonService;
import org.assembly.nornas.web.template.Template;

/**
 * @author emanuel
 *
 */
public class PersonPage extends Template {

	private static final long serialVersionUID = 2163449704468426341L;
	
	@InjectBean
	private PersonService personService;

	@Bindable
	private PersonDTO person;
	
	@Override
	public void onInit() {
		this.title = "Example";
		this.titlePage = "Example";
		this.person = personService.findAllPerson().get(0);
	}

}
