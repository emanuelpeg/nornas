package org.assembly.nornas.persistence.tag;

import java.util.List;

import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.tag.TagRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * @author emanuel
 *
 * class represents a DAO of Tag 
 * 
 */
public class TagDAO extends BaseDao<Tag> implements TagRepository {

	@Override
	protected Class<Tag> getClase() {
		return Tag.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tag findByName(String name) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.eq("name", name));
		
		List<Tag> result = criteria.list();
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> findByBlogId(Long blogId) {
		String hql = "select distinct t from "+ Blog.class.getCanonicalName() +" b inner join b.posts p inner join p.tags t " +
				"             where b.id = :blogId ";
		
		Query query = this.getSession().createQuery(hql);
		query.setLong("blogId", blogId);
		
		return query.list();
	}

}
