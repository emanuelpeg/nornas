/**
 * 
 */
package org.assembly.dto.tag;

import java.io.Serializable;


/**
 * @author emanuel
 * 
 * 			 class represents a Tag's DTO
 *
 */
public class TagDTO implements Serializable {
	
	private static final long serialVersionUID = -5778007578029086285L;
	
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}
