/**
 * 
 */
package org.assembly.nornas.web.welcomeUser;

import java.util.ArrayList;
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
import org.assembly.dto.post.PostDTO;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.service.post.PostService;
import org.assembly.nornas.web.post.EditPostPage;
import org.assembly.nornas.web.security.SecurityPage;

/**
 * @author emanuel
 *
 */
public class WelcomeUserPage extends SecurityPage {

	private static final long serialVersionUID = -8230205828264933601L;
	
	private Table tableBlogs;
	
	private Table tablePosts;
	
	private PageLink addPostLink = new PageLink("add", EditPostPage.class);
	private PageLink editPostLink = new PageLink("edit", EditPostPage.class);

	@InjectBean
	private BlogService blogService;
	
	@InjectBean
	private PostService postService;
	
	
	@Override
	public void onInit() {
		super.onInit();
		
		UserDTO user = this.getUser();
		final List<BlogDTO> blogs = blogService.findBlogByUser(user);
		
		createBlogTable(blogs);
	
		tablePosts = new Table("tablePosts");
		 

		addControl(tablePosts);
		tablePosts.setClass(Table.CLASS_ORANGE1);
		tablePosts.setPageSize(4);
		tablePosts.setShowBanner(true);
		tablePosts.setSortable(true);
		
		Column column = new Column("title");
        column.setWidth("160px;");
        tablePosts.addColumn(column);
        
        Column columnAuthor = new Column("author");
        column.setWidth("160px;");
        tablePosts.addColumn(columnAuthor);
        
        Column columnEditPost = new Column("Edit");
        columnEditPost.setWidth("100px;");
        
        columnEditPost.setDecorator(new Decorator() {
            public String render(Object row, Context context) {
            	PostDTO post = (PostDTO) row;
                String id = String.valueOf(post.getId());

                editPostLink.setParameter("postId", id);

                return editPostLink.toString();
            }
        });

        tablePosts.addColumn(columnEditPost);
        
        final List<PostDTO> posts = new ArrayList<PostDTO>();
        
        for(BlogDTO blog : blogs) {
        	List<PostDTO> allPost = postService.findPostsPublishedByBlogId(blog.getId(),0, Integer.MAX_VALUE, null);
        	posts.addAll(allPost);
        }
        
        tablePosts.setDataProvider(new DataProvider<PostDTO>() {

			private static final long serialVersionUID = -6650715084256938785L;

			public List<PostDTO> getData() {
                return posts;
            }
        });
		
	}

	private void createBlogTable(final List<BlogDTO> blogs) {
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
