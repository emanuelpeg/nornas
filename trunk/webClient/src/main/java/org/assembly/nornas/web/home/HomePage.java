/**
 * 
 */
package org.assembly.nornas.web.home;



import java.text.ParseException;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.apache.click.control.Form;
import org.apache.click.control.PasswordField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;
import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.apache.click.extras.control.EmailField;
import org.apache.click.util.Bindable;
import org.apache.cxf.binding.soap.SoapFault;
import org.assembly.dto.user.UserDTO;
import org.assembly.norna.common.util.date.DateUtils;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.web.error.MessageErrorPage;
import org.assembly.nornas.web.template.Template;
import org.assembly.nornas.web.user.NewUserPage;
import org.assembly.nornas.web.welcomeUser.WelcomeUserPage;

/**
 * Home Page
 * 
 * @author emanuel
 *
 */
public class HomePage extends Template {

	private static final long serialVersionUID = -2868696724309671438L;
	
	@InjectBean
	private UserService userService;
	
	@Bindable
	private Form newUserForm = new Form("newUserForm");
	
	@Bindable
	private Form loginUserForm = new Form("loginUserForm");
	
	public HomePage() {
		createNewUserForm();
		createLoginUserForm();
		getContext().getSession().invalidate();
	}
	
	@Override
	public void onInit() {
		super.onInit();
		addModel("newUser", new UserDTO());
	}
	
	@Override
	public List<Element> getHeadElements() {
		List<Element> elements = super.getHeadElements();
		
		JsImport jsImport = new JsImport("home.js");
		
		elements.add(jsImport);
		return elements;
	}
	
	private void createNewUserForm() {
	
		newUserForm.setJavaScriptValidation(false);
		newUserForm.setMethod("GET");
		newUserForm.add(new TextField("userName", true));
		newUserForm.add(new TextField("userNick", true));
		newUserForm.add(new TextField("userBirthDate"));
		newUserForm.add(new EmailField("userEmail", true));
		newUserForm.add(new PasswordField("userPassword", true));
		
		newUserForm.add(new Submit("createUser", getMessage("create.user"), this, "onSubmitNewUserForm"));
		
		addControl(newUserForm);
	}
	
	private void createLoginUserForm() {
		loginUserForm.setJavaScriptValidation(false);
		loginUserForm.setMethod("GET");
		loginUserForm.add(new TextField("userName", true));
		loginUserForm.add(new PasswordField("userPassword", true));
		
		loginUserForm.add(new Submit("login", getMessage("login.user"), this, "onSubmitLoginForm"));
		
		addControl(loginUserForm);
	}
	
	public boolean onSubmitNewUserForm() {
		if (newUserForm.isValid()) {
			UserDTO user = getUser();
			Long id = null;
			try {
				id = userService.saveUser(user);
			} catch (WebServiceException e) {
				e.printStackTrace();
				SoapFault fault = (SoapFault) e.getCause();
				String error = fault.getMessage();
				String url = getContext().getPagePath(MessageErrorPage.class) + "?error=" + error;
				setRedirect(url);
				return true;
			}
			String url = getContext().getPagePath(NewUserPage.class) + "?userId=" + id.toString();
			setRedirect(url);
			return false;
		}
		return true;
	}

	public boolean onSubmitLoginForm() {
		if (newUserForm.isValid()) {
			String userName = loginUserForm.getFieldValue("userName");
			String userPassword = loginUserForm.getFieldValue("userPassword");
			try {
			    UserDTO user = userService.login(userName, userPassword);
			    if (user != null) {
			    	getContext().setCookie("userName", user.getNick(), 1000000);
			    	getContext().setCookie("userPassword", user.getPassword(), 1000000);
					setRedirect(WelcomeUserPage.class);
			    	return true;
			    }
			} catch (WebServiceException e) {
				e.printStackTrace();
				SoapFault fault = (SoapFault) e.getCause();
				String error = fault.getMessage();
				String url = getContext().getPagePath(MessageErrorPage.class) + "?error=" + error;
				setRedirect(url);
				return true;
			}	
			return false;
		}
		return false;
	}
	
	public UserDTO getUser() {
		UserDTO user = new UserDTO();
		user.setName(newUserForm.getFieldValue("userName"));
		user.setNick(newUserForm.getFieldValue("userNick"));
		user.getEmails().add(newUserForm.getFieldValue("userEmail"));
		user.setPassword(newUserForm.getFieldValue("userPassword"));
		try {
			if (newUserForm.getFieldValue("userBirthDate") != null) {
				user.setBirthDate(DateUtils.toDate(newUserForm.getFieldValue("userBirthDate"), getMessage("dateFromatJava")));			
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return user;		
	}


}
