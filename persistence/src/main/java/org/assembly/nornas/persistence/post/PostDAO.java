package org.assembly.nornas.persistence.post;

import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.post.PostRepository;

/**
 * @author emanuel
 *
 * class represents a DAO of Post 
 * 
 */
public class PostDAO extends BaseDao<Post> implements PostRepository {

	@Override
	protected Class<Post> getClase() {
		return Post.class;
	}

}
