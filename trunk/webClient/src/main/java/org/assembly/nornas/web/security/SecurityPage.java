/**
 * 
 */
package org.assembly.nornas.web.security;

import org.apache.click.Page;
import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.util.Bindable;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.web.home.HomePage;

/**
 * @author emanuel
 *
 */
public class SecurityPage extends Page {

	private static final long serialVersionUID = -7957933531257152528L;

	@Bindable
	private String logoutURL;
	
	@InjectBean
	protected UserService userService;	
	
	private UserDTO user;
	
	@Override
	public void onInit() {
		super.onInit();
		logoutURL = getContext().getRequest().getContextPath() + getContext().getPagePath(HomePage.class);		
	}
	
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
	
	@Override
	public String getTemplate() {
		return "/template/securityTemplate.htm";
	}
	
	public String getLogoutURL() {
		return logoutURL;
	}

	public void setLogoutURL(String logoutURL) {
		this.logoutURL = logoutURL;
	}

	protected UserDTO getUser() {
		return user;
	}
	
}
