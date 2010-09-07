package org.assembly.nornas.repository.user;

import java.io.Serializable;
import java.util.List;

import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 *
 * Interface represents a repository of Person 
 * 
 */
public interface UserRepository {
	
	void save(User person);
	
	User findBy(Serializable id);
	
	List<User> findAll();

}
