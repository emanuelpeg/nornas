/**
 * 
 */
package org.assembly.dto.style;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author emanuel
 * 
 *         DTO of Style
 * 
 */

public class StyleDTO implements Serializable {

	private static final long serialVersionUID = 3333330797512370546L;

	private Long id;
	
	private String css;

	public StyleDTO() {
	}
	
	public StyleDTO(String css) {
		super();
		this.css = css;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		StyleDTO otherStyle = (StyleDTO) obj;

		return new EqualsBuilder().append(this.css, otherStyle.getCss())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.css).toHashCode();
	}
	

}
