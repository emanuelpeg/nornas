package org.assembly.nornas.persistence.blog;

import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.blog.BlogRepository;

/**
 * @author emanuel
 *
 * class represents a DAO of Blog 
 * 
 */
public class BlogDAO extends BaseDao<Blog> implements BlogRepository {

	@Override
	protected Class<Blog> getClase() {
		return Blog.class;
	}

}
