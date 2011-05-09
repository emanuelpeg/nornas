package org.assembly.nornas.repository.style;

import java.io.Serializable;

import org.assembly.nornas.model.style.Style;

/**
 * @author emanuel
 *
 * Interface represents a repository of Style 
 * 
 */
public interface StyleRepository {
	
	Style findBy(Serializable id);

}
