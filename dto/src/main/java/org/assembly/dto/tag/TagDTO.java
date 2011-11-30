/**
 * 
 */
package org.assembly.dto.tag;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author emanuel
 * 
 * 			 class represents a Tag's DTO
 *
 */
@XmlRootElement(name="tag")
public class TagDTO implements Serializable {
	
	private static final long serialVersionUID = -5778007578029086285L;
	
	private Long id;
	
	private String name;

	public TagDTO() {	}
	
	public TagDTO(String tag) {
		name = tag;
	}

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
