/**
 * 
 */
package org.assembly.nornas.model.style;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;

/**
 * @author emanuel
 * 
 *         class represents a Style
 * 
 */

public class Style extends PersistenEntity {

	private String css;

	public Style(String css) {
		super();
		this.css = css;
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

		Style otherStyle = (Style) obj;

		return new EqualsBuilder().append(this.css, otherStyle.getCss())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.css).toHashCode();
	}
	
	// is used by Hibernat
	public Style() {
	}

}
