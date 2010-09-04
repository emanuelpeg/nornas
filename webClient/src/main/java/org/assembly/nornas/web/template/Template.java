/**
 * 
 */
package org.assembly.nornas.web.template;

import org.apache.click.Page;
import org.apache.click.util.Bindable;

/**
 * @author emanuel
 *
 */
public abstract class Template extends Page {

	private static final long serialVersionUID = 5522432061754148471L;
	
	@Bindable 
	protected String titlePage = "";

	@Bindable 
	protected String title = "";
	
	@Override
	public String getTemplate() {
		return "/template/template.htm";
	}
	

}
