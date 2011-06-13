/**
 * 
 */
package org.assembly.nornas.web.blog;

import java.util.List;

import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.apache.click.util.Bindable;
import org.apache.commons.lang.WordUtils;
import org.assembly.dto.blog.BlogDTO;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.web.error.BlogErrorPage;
import org.assembly.nornas.web.template.BlogTemplate;
import org.assembly.nornas.web.user.NewUserPage;

/**
 * Home Page
 * 
 * @author emanuel
 *
 */
public class IndexPage extends BlogTemplate {

	private static final long serialVersionUID = -2868696724309671438L;
	
	@InjectBean
	private BlogService blogService;
	
	@Bindable
	private String url;
	
	@Bindable
	private String titlePage;
	
	@Bindable
	private String subTitlePage;
	
	public IndexPage() {
		super();
	}
	
	@Override
	public List<Element> getHeadElements() {
		List<Element> elements = super.getHeadElements();
		
		JsImport jsImport = new JsImport("index.js");
		
		elements.add(jsImport);
		return elements;
	}
	
	@Override
	public void onInit() {
		super.onInit();
		BlogDTO blog = blogService.findBlogByUrl(url);
		
		if (blog == null) {
			String error = getMessage("error.blog.not.found");
			String url = getContext().getPagePath(BlogErrorPage.class)+ "?error=" + error;
			setRedirect(url);
			return;
		}
		
		titlePage = blog.getTitle();
		subTitlePage = blog.getSubTitle();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitlePage() {
		return titlePage;
	}

	public void setTitlePage(String titlePage) {
		this.titlePage = titlePage;
	}

	public String getSubTitlePage() {
		return subTitlePage;
	}

	public void setSubTitlePage(String subTitlePage) {
		this.subTitlePage = subTitlePage;
	}

}
