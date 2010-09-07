/**
 * 
 */
package org.assembly.nornas.serviceImpl.user;

import java.util.List;

import org.assembly.dto.user.UserDTO;
import org.assembly.norna.common.util.transformer.DozerTransformer;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.repository.user.UserRepository;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.serviceImpl.BaseServiceImpl;
import org.assembly.nornas.synchronizer.Synchronizer;
import org.osoa.sca.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 * 
 *         Implementation of {@link UserService}
 * 
 */
@Service(UserService.class)
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	private UserRepository userDAO;

	public void setUserDAO(UserRepository userDAO) {
		this.userDAO = userDAO;
	}

	private Synchronizer<UserDTO, User> synchronizerUser;

	public void setSynchronizerUser(Synchronizer<UserDTO, User> synchronizerUser) {
		this.synchronizerUser = synchronizerUser;
	}

	@Transactional
	@Override
	public List<UserDTO> findAllUser() {
		List<User> users = userDAO.findAll();
		DozerTransformer<UserDTO, User> transformer = new DozerTransformer<UserDTO, User>(
				this.getDtoMapper(), UserDTO.class);
		return transformer.transformar(users, "User_UserDTO");
	}

	@Transactional
	@Override
	public UserDTO findUserById(Long id) {
		User user = this.userDAO.findBy(id);
		return (user == null) ? null : this.getDtoMapper().map(user, UserDTO.class, "User_UserDTO");
	}

	@Transactional
	@Override
	public void saveUser(UserDTO userDTO) {
		User user = this.synchronizerUser.synchronize(userDTO);
		this.userDAO.save(user);
		userDTO.setId(user.getId());
	}

}
