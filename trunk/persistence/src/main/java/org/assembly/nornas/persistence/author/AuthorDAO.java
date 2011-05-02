package org.assembly.nornas.persistence.author;

import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.author.AuthorRepository;

/**
 * @author emanuel
 *
 * class represents a DAO of Author 
 * 
 */
public class AuthorDAO extends BaseDao<Author> implements AuthorRepository {

	@Override
	protected Class<Author> getClase() {
		return Author.class;
	}

	@Override
	public Author findByUser(User user) {
		return this.findBy(user.getId());
	}


}
