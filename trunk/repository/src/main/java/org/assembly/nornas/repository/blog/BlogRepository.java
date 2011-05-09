package org.assembly.nornas.repository.blog;

import java.io.Serializable;
import java.util.List;

import org.assembly.nornas.model.blog.Blog;

/**
 * @author emanuel
 *
 * Interface represents a repository of Person 
 * 
 */
public interface BlogRepository {
	
	void save(Blog blog);
	
	Blog findBy(Serializable id);
	
	List<Blog> findAll();

	Blog findBlogByUrl(String url);


}
