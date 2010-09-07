package org.assembly.nornas.persistence.user;

import org.assembly.nornas.model.user.User;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.user.UserRepository;

/**
 * @author emanuel
 *
 * class represents a DAO of Person 
 * 
 */
public class UserDAO extends BaseDao<User> implements UserRepository {

	@Override
	protected Class<User> getClase() {
		return User.class;
	}


}
