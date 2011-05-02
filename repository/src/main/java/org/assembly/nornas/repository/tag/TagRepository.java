package org.assembly.nornas.repository.tag;

import java.io.Serializable;
import java.util.List;

import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 *
 * Interface represents a repository of Person 
 * 
 */
public interface TagRepository {
	
	void save(Tag tag);
	
	Tag findBy(Serializable id);
	
	List<Tag> findAll();

	Tag findByName(String name);

}
