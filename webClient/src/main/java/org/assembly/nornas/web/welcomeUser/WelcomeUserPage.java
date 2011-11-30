/**
 * 
 */
package org.assembly.nornas.web.welcomeUser;

import java.util.List;

import org.apache.click.Context;
import org.apache.click.control.Column;
import org.apache.click.control.Decorator;
import org.apache.click.control.PageLink;
import org.apache.click.control.Table;
import org.apache.click.dataprovider.DataProvider;
import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.web.post.EditPostPage;
import org.assembly.nornas.web.security.SecurityPage;

/**
 * @author emanuel
 *
 */
public class WelcomeUserPage extends SecurityPage {

	private static final long serialVersionUID = -8230205828264933601L;
	
	private Table tableBlogs;
	private PageLink addPostLink = new PageLink("add", EditPostPage.class);

	@InjectBean
	private BlogService blogService;
	
	@Override
	public void onInit() {
		super.onInit();
		
		UserDTO user = this.getUser();
		final List<BlogDTO> blogs = blogService.findBlogByUser(user);
		
		tableBlogs = new Table("tableBlogs");
		
		addControl(tableBlogs);
		tableBlogs.setClass(Table.CLASS_ORANGE1);
		
		Column column = new Column("title");
        column.setWidth("160px;");
        tableBlogs.addColumn(column);
        
        Column columnAddPost = new Column("Add Post");
        columnAddPost.setWidth("100px;");
        
        columnAddPost.setDecorator(new Decorator() {
            public String render(Object row, Context context) {
            	BlogDTO blog = (BlogDTO) row;
                String id = String.valueOf(blog.getId());

                addPostLink.setParameter("blogId", id);

                return addPostLink.toString();
            }
        });

        
        tableBlogs.addColumn(columnAddPost);
        
        tableBlogs.setDataProvider(new DataProvider<BlogDTO>() {
            public List<BlogDTO> getData() {
                return blogs;
            }
        });
	

	}
	
	@Override
	public List<Element> getHeadElements() {
		List<Element> elements = super.getHeadElements();
		
		JsImport jsImport = new JsImport("welcomeUser.js");
		
		elements.add(jsImport);
		return elements;
	}


	
}
