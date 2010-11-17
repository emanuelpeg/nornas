/**
 * 
 */
package org.assembly.nornas.service.user;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.assembly.dto.user.UserDTO;
import org.assembly.norna.common.type.exceptions.user.DuplicateDataUsersException;
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
	UserDTO findUserById(@WebParam Long id);
	
	@WebMethod(operationName="saveUser")
	Long saveUser(@WebParam UserDTO personDTO) throws DuplicateDataUsersException;	
	
}
