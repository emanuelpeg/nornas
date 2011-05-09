package org.assembly.nornas.persistence.blog;

import java.util.List;

import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.blog.BlogRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public Blog findBlogByUrl(String url) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.eq("url", url));
		
		List<Blog> blogs = criteria.list();
		
		if(blogs.isEmpty()) {
			return null;
		}
		
		return blogs.get(0);
	}

}
