/**
 * 
 */
package org.assembly.nornas.web.template;

import org.apache.click.Page;

/**
 * @author emanuel
 *
 *	Class repesent the template, father of all pages.
 *
 */
public abstract class BlogTemplate extends Page {

	private static final long serialVersionUID = 5522432061754148471L;
	
	@Override
	public String getTemplate() {
		return "/template/blogTemplate.htm";
	}
	

}
