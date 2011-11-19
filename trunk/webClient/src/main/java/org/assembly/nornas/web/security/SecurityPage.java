/**
 * 
 */
package org.assembly.nornas.web.security;

import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.web.home.HomePage;
import org.assembly.nornas.web.template.Template;
import org.assembly.nornas.web.user.NewUserPage;

/**
 * @author emanuel
 *
 */
public class SecurityPage extends Template {

	private static final long serialVersionUID = -7957933531257152528L;

	@InjectBean
	private UserService userService;	
	
	private UserDTO user;
	
	public boolean onSecurityCheck() {
		String userNick = getContext().getCookieValue("userName");
		String userPassword = getContext().getCookieValue("userPassword");

		user = userService.getUser(userNick, userPassword);
	    if (user != null) {
			return true;
	    } else {
            setRedirect(HomePage.class);
            return false;
        }
    }
	
	protected void logout() {
		getContext().getSession().invalidate();
		getContext().setCookie("userName", null, 0);
		getContext().setCookie("userPassword", null, 0);
	}

	
}
