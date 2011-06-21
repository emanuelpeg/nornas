package org.assembly.nornas.persistence.post;

import java.util.List;

import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.post.StatePost;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.post.PostRepository;
import org.hibernate.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findPostsPublishedByBlogId(Long blogId, Integer from, Integer sizes) {
		String hql = "select p from "+Blog.class.getCanonicalName() + " as b "+
		                     " inner join b.posts as p "+
		                     "where b.id = :id " +
		                     "  and p.state = :state " + 
		                     "order by p.publishDate desc,  p.id desc ";
		Query query = this.getSession().createQuery(hql);
		
		query.setLong("id", blogId);
		query.setString("state", StatePost.PUBLISHED.name());
		query.setFirstResult(from);
		query.setMaxResults(sizes);
		
		return query.list();
	}
	

}
