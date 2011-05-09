package org.assembly.nornas.persistence.style;

import org.assembly.nornas.model.style.Style;
import org.assembly.nornas.persistence.BaseDao;
import org.assembly.nornas.repository.style.StyleRepository;

/**
 * @author emanuel
 *
 * class represents a DAO of Style
 * 
 */
public class StyleDAO extends BaseDao<Style> implements StyleRepository {

	@Override
	protected Class<Style> getClase() {
		return Style.class;
	}


}
