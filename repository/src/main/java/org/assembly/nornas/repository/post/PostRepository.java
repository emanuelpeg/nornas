package org.assembly.nornas.repository.post;

import java.io.Serializable;
import java.util.List;

import org.assembly.nornas.model.post.Post;

/**
 * @author emanuel
 *
 * Interface represents a repository of Person 
 * 
 */
public interface PostRepository {
	
	void save(Post post);
	
	Post findBy(Serializable id);
	
	List<Post> findAll();


}
