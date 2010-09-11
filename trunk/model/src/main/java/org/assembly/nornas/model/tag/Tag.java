/**
 * 
 */
package org.assembly.nornas.model.tag;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;

/**
 * @author emanuel
 * 
 * 			 class represents a Tag
 *
 */
public class Tag extends PersistenEntity {
	
	private String name;

	public Tag(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		
		String otherTag = obj.toString();
		
		return this.name.equals(otherTag); 
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
	}
	
	@Override
	public String toString() {
		return this.name.toString();
	}

	// it is used by hibernate
	public Tag() {
	}
	
	
}
