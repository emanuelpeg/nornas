package org.assembly.nornas.repository.author;

import java.io.Serializable;
import java.util.List;

import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 *
 * Interface represents a repository of Person 
 * 
 */
public interface AuthorRepository {
	
	void save(Author author);
	
	Author findBy(Serializable id);
	
	List<Author> findAll();

	Author findByUser(User user);

}
