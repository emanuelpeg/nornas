/**
 * 
 */
package org.assembly.nornas.web.home;

import org.assembly.nornas.web.template.Template;

/**
 * Home Page
 * 
 * @author emanuel
 *
 */
public class HomePage extends Template {

	private static final long serialVersionUID = -2868696724309671438L;
	
	@Override
	public void onInit() {
		this.title = "WELCOME TO OUR WEBSITE";
		this.titlePage = "Home";
	}

}
