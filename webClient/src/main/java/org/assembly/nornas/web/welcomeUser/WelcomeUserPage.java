/**
 * 
 */
package org.assembly.nornas.web.welcomeUser;

import java.util.List;

import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.assembly.nornas.web.security.SecurityPage;

/**
 * @author emanuel
 *
 */
public class WelcomeUserPage extends SecurityPage {

	private static final long serialVersionUID = -8230205828264933601L;

	@Override
	public void onInit() {
		super.onInit();
		
	}
	
	@Override
	public List<Element> getHeadElements() {
		List<Element> elements = super.getHeadElements();
		
		JsImport jsImport = new JsImport("welcomeUser.js");
		
		elements.add(jsImport);
		return elements;
	}
	
}
