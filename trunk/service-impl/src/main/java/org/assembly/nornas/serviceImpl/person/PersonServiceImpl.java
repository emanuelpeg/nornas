/**
 * 
 */
package org.assembly.nornas.serviceImpl.person;

import java.util.List;

import org.assembly.dto.person.PersonDTO;
import org.assembly.norna.common.util.transformer.DozerTransformer;
import org.assembly.nornas.model.person.Person;
import org.assembly.nornas.repository.person.PersonRepository;
import org.assembly.nornas.service.person.PersonService;
import org.assembly.nornas.serviceImpl.BaseServiceImpl;
import org.assembly.nornas.synchronizer.Synchronizer;
import org.osoa.sca.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 * 
 *         Implementation of {@link PersonService}
 * 
 */
@Service(PersonService.class)
public class PersonServiceImpl extends BaseServiceImpl implements PersonService {

	private PersonRepository personDAO;

	public void setPersonDAO(PersonRepository personDAO) {
		this.personDAO = personDAO;
	}
	
	
	private Synchronizer<PersonDTO, Person> synchronizerPerson;

	public void setSynchronizerPerson(
			Synchronizer<PersonDTO, Person> synchronizerPerson) {
		this.synchronizerPerson = synchronizerPerson;
	}

	@Transactional
	@Override
	public List<PersonDTO> findAllPerson() {
		List<Person> persons = personDAO.findAll();
		DozerTransformer<PersonDTO, Person> transformer = new DozerTransformer<PersonDTO, Person>(
				this.getDtoMapper(), PersonDTO.class);
		return transformer.transformar(persons, "Person_PersonDTO");
	}

	@Transactional
	@Override
	public PersonDTO findPersonById(Long id) {
		Person person = this.personDAO.findBy(id);
		return (person == null) ? null : this.getDtoMapper().map(person, PersonDTO.class, "Person_PersonDTO");
	}

	@Transactional
	@Override
	public void savePerson(PersonDTO personDTO) {
		Person person = this.synchronizerPerson.synchronize(personDTO);
		this.personDAO.save(person);
		personDTO.setId(person.getId());
	}

}
