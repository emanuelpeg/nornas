/**
 * 
 */
package org.assembly.nornas.web.error;

import org.apache.click.util.Bindable;
import org.assembly.nornas.web.home.HomePage;
import org.assembly.nornas.web.template.BlogTemplate;

/**
 * Home Page
 * 
 * @author emanuel
 *
 */
public class BlogErrorPage extends BlogTemplate {

	private static final long serialVersionUID = -5967693430016864275L;

	@Bindable
	private String error;

	@Bindable
	private String titlePage;
	
	@Bindable
	private String urlHome;
	
	@Override
	public void onInit() {
		super.onInit();
		titlePage = error;
		urlHome = ".." + getContext().getPagePath(HomePage.class);
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTitlePage() {
		return titlePage;
	}

	public void setTitlePage(String titlePage) {
		this.titlePage = titlePage;
	}

	public String getUrlHome() {
		return urlHome;
	}

	public void setUrlHome(String urlHome) {
		this.urlHome = urlHome;
	}	
	
	
}
