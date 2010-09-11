/**
 * 
 */
package org.assembly.nornas.synchronizer.user;

import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.repository.user.UserRepository;
import org.assembly.nornas.synchronizer.Synchronizer;

/**
 * @author emanuel
 * 
 *  class responsible of synchronize person with personDTO
 *
 */
public class SynchronizerUser implements Synchronizer<UserDTO, User>{
	
	private UserRepository userDAO;
	
	public void setUserDAO(UserRepository userDAO) {
		this.userDAO = userDAO;
	}


	public User synchronize(UserDTO dto) {
		User aPerson =  null;
		
		if (dto.getId() == null) {
			aPerson = new User(dto.getName(), dto.getNick(), dto.getBirthDate(), dto.getEmails(), dto.getPassword());
		} else {
			aPerson = this.userDAO.findBy(dto.getId());
			aPerson.setName(dto.getName());
			aPerson.setNick(dto.getNick());
			aPerson.setEmails(dto.getEmails());
			aPerson.setBirthDate(dto.getBirthDate());
		}
		
		return aPerson;
	}

}
