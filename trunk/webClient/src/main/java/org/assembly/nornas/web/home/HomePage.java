/**
 * 
 */
package org.assembly.nornas.web.home;



import java.text.ParseException;
import java.util.List;

import org.apache.click.control.Form;
import org.apache.click.control.PasswordField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;
import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.apache.click.extras.control.EmailField;
import org.apache.click.util.Bindable;
import org.assembly.dto.user.UserDTO;
import org.assembly.norna.common.util.date.DateUtils;
import org.assembly.nornas.service.user.UserService;
import org.assembly.nornas.web.template.Template;
import org.assembly.nornas.web.user.NewUserPage;

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
	
	public HomePage() {
		createNewUserForm();
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
		
		newUserForm.add(new TextField("userName", true));
		newUserForm.add(new TextField("userNick", true));
		newUserForm.add(new TextField("userBirthDate"));
		newUserForm.add(new EmailField("userEmail", true));
		newUserForm.add(new PasswordField("userPassword", true));
		
		newUserForm.add(new Submit("createUser", getMessage("create.user"), this, "onSubmitNewUserForm"));
		
		addControl(newUserForm);
	}
	
	public boolean onSubmitNewUserForm() {
		if (newUserForm.isValid()) {
			UserDTO user = getUser();
			Long id = userService.saveUser(user);
			String url = getContext().getPagePath(NewUserPage.class) + "?userId=" + id.toString();
			setRedirect(url);
			return false;
		}
		return true;
	}

	public UserDTO getUser() {
		UserDTO user = new UserDTO();
		user.setName(newUserForm.getFieldValue("userName"));
		user.setNick(newUserForm.getFieldValue("userNick"));
		user.getEmails().add(newUserForm.getFieldValue("userEmail"));
		user.setPassword(newUserForm.getFieldValue("userPassword"));
		try {
			user.setBirthDate(DateUtils.toDate(newUserForm.getFieldValue("userBirthDate"), getMessage("dateFromatJava")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return user;		
	}


}
