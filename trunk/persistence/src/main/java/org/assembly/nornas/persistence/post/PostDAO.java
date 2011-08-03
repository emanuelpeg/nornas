package org.assembly.nornas.persistence.post;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.post.StatePost;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.post.PostRepository;
import org.hibernate.Query;

/**
 * @author emanuel
 * 
 *         class represents a DAO of Post
 * 
 */
public class PostDAO extends BaseDao<Post> implements PostRepository {

	@Override
	protected Class<Post> getClase() {
		return Post.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findPostsPublishedByBlogId(Long blogId, Integer from,
			Integer sizes, String tag) {

		String hql = "select p from " + Blog.class.getCanonicalName()
				+ "              as b inner join b.posts as p ";

		if (!StringUtils.isEmpty(tag)) {
			hql += "                   left join p.tags as t ";
		}

		hql += "   where b.id = :id " + "     and p.state = :state ";

		if (!StringUtils.isEmpty(tag)) {
			hql += "    and t.name = :name  ";
		}

		hql += "order by p.publishDate desc,  p.id desc ";

		Query query = this.getSession().createQuery(hql);

		query.setLong("id", blogId);
		query.setString("state", StatePost.PUBLISHED.name());

		if (!StringUtils.isEmpty(tag)) {
			query.setString("name", tag);
		}

		query.setFirstResult(from);
		query.setMaxResults(sizes);

		return query.list();
	}

	@Override
	public Long countPostsPublishedByBlogId(Long blogId, String tag) {
		String hql = "select count(p) from " + Blog.class.getCanonicalName()
				+ "       as b inner join b.posts as p ";

		if (!StringUtils.isEmpty(tag)) {
			hql += "            left join p.tags as t ";
		}
		hql += "  where b.id = :id " + "  and p.state = :state ";

		if (!StringUtils.isEmpty(tag)) {
			hql += "    and t.name = :name  ";
		}

		Query query = this.getSession().createQuery(hql);

		query.setLong("id", blogId);
		query.setString("state", StatePost.PUBLISHED.name());

		if (!StringUtils.isEmpty(tag)) {
			query.setString("name", tag);
		}

		return (Long) query.uniqueResult();
	}

}
