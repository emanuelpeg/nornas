package org.assembly.nornas.persistence.tag;

import java.util.List;

import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.tag.TagRepository;
import org.hibernate.Criteria;
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

}
