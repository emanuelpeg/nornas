/**
 * 
 */
package org.assembly.nornas.web.blog;

import org.apache.click.util.Bindable;
import org.apache.commons.lang.WordUtils;
import org.assembly.nornas.web.template.BlogTemplate;

/**
 * Home Page
 * 
 * @author emanuel
 *
 */
public class IndexPage extends BlogTemplate {

	private static final long serialVersionUID = -2868696724309671438L;
	
	
	@Bindable
	private String name;
	
	@Bindable
	private String titlePage;
	
	public IndexPage() {
		super();
	}
	
	@Override
	public void onInit() {
		super.onInit();
		name = WordUtils.capitalize(name);
		titlePage = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitlePage() {
		return titlePage;
	}

	public void setTitlePage(String titlePage) {
		this.titlePage = titlePage;
	}

	
	
}
