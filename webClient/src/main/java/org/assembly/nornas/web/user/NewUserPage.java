/**
 * 
 */
package org.assembly.nornas.web.user;

import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.util.Bindable;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.web.template.Template;

/**
 * @author emanuel
 * 
 * 		new user's page
 *
 */
public class NewUserPage extends Template {

	private static final long serialVersionUID = -5984186602065679027L;
	
	@InjectBean
	private UserService userService;

	@Bindable 
	private String email;
	
	
	public NewUserPage() {
		super();
	}
	
	@Override
	public void onInit() {
		super.onInit();
		String userId = getContext().getRequestParameter("userId");
		if (userId!=null) {
			Long id = new Long(userId);
			UserDTO user = userService.findUserById(id);
			if (user != null) {
				email = user.getEmails().get(0);
			}
		}
	}
	
}
