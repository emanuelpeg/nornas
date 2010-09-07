/**
 * 
 */
package org.assembly.nornas.web.example;

import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.util.Bindable;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.web.template.Template;

/**
 * @author emanuel
 *
 */
public class UserPage extends Template {

	private static final long serialVersionUID = 2163449704468426341L;
	
	@InjectBean
	private UserService userService;

	@Bindable
	private UserDTO user;
	
	@Override
	public void onInit() {
		this.title = "Example";
		this.titlePage = "Example";
		this.user = userService.findAllUser().get(0);
	}

}
