/**
 * 
 */
package org.assembly.nornas.serviceImpl.user;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPException;

import org.assembly.dto.user.UserDTO;
import org.assembly.norna.common.type.exceptions.user.DuplicateDataUsersException;
import org.assembly.norna.common.util.transformer.DozerTransformer;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.persistence.author.AuthorDAO;
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

	private static final String NICK = "nick";
	private static final String EMAIL = "email";
	
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
	public Long saveUser(UserDTO userDTO) throws DuplicateDataUsersException {
		User user = this.synchronizerUser.synchronize(userDTO);
		List<String> userDataDuplicate = dataDuplicate(user);
		if (!userDataDuplicate.isEmpty()) {
			try {
				throw new DuplicateDataUsersException(userDataDuplicate,new Exception());
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}
		this.userDAO.save(user);
		return user.getId();
	}

	private List<String> dataDuplicate(User user) {
		List<String> datas = new ArrayList<String>();
		
		if (this.userDAO.findByEmail(user.getEmail())!= null) {
			datas.add(EMAIL);
		}
		
		if (this.userDAO.findByNick(user.getNick())!= null) {
			datas.add(NICK);
		}
		return datas;
	}

	@Transactional
	@Override
	public UserDTO login(String userName, String userPassword) {
		User user = this.userDAO.findByNick(userName);
		
		if (user != null) {
			if (user.isPasword(userPassword)) {
				return this.getDtoMapper().map(user, UserDTO.class, "User_UserDTO");
			}
		}
		
		return null;
	}

	@Transactional
	@Override
	public UserDTO getUser(String userNick, String userPassword) {
		User user = this.userDAO.findByNickAndPassword(userNick, userPassword);
		
		if (user != null) {
			return this.getDtoMapper().map(user, UserDTO.class, "User_UserDTO");
		}
		
		return null;
	}

}
