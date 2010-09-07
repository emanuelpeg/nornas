/**
 * 
 */
package org.assembly.nornas.service.user;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.assembly.dto.user.UserDTO;
import org.osoa.sca.annotations.Remotable;

/**
 * 
 * @author emanuel
 * 
 *   Interface represents services of Person
 *
 */
@Remotable
@WebService
public interface UserService {
	
	@WebMethod(operationName="findAllPerson")
	List<UserDTO> findAllUser();

	@WebMethod(operationName="findUserById")
	UserDTO findUserById(Long id);
	
	@WebMethod(operationName="saveUser")
	void saveUser(UserDTO personDTO);	
	
}
