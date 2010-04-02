/**
 * 
 */
package org.assembly.nornas.model;

/**
 * @author emanuel
 * 
 * class represents a entity persist 
 *
 */
public class PersistenEntity {
	
	private Long id;
	
	private Long version  = -1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
}
