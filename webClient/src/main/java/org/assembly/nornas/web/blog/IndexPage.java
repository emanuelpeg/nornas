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
import org.assembly.nornas.web.error.MessageErrorPage;
import org.assembly.nornas.web.rest.post.PostsRest;
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
	private Long blogID;
	
	@Bindable
	private String titlePage;
	
	@Bindable
	private String subTitlePage;
		
	@Bindable
	private String urlPost = "";
	
	@Bindable
	private String urlTags = "";
	
	@Bindable
	private String tag = "";
	
	@Bindable
	private Long initPost = 0l;
	
	@Bindable
	private Long countPost = new Long(PostsRest.NUMBER_OF_POST);
	
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
		
		blogID = blog.getId();
		titlePage = blog.getTitle();
		subTitlePage = blog.getSubTitle();
		urlPost = this.getContext().getRequest().getContextPath() + "/blogRest/posts/";
		urlTags = this.getContext().getRequest().getContextPath() + "/blogRest/posts/tags/";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getBlogID() {
		return blogID;
	}

	public void setBlogID(Long blogID) {
		this.blogID = blogID;
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

	public String getUrlPost() {
		return urlPost;
	}

	public void setUrlPost(String urlPost) {
		this.urlPost = urlPost;
	}

	public String getUrlTags() {
		return urlTags;
	}

	public void setUrlTags(String urlTags) {
		this.urlTags = urlTags;
	}

	public Long getInitPost() {
		return initPost;
	}

	public void setInitPost(Long initPost) {
		this.initPost = initPost;
	}

	public Long getCountPost() {
		return countPost;
	}

	public void setCountPost(Long countPost) {
		this.countPost = countPost;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
