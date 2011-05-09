/**
 * 
 */
package org.assembly.nornas.persistence.blog;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import javax.annotation.Resource;

import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.persistence.DaoTestBase;
import org.assembly.nornas.persistence.user.UserDAO;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao's test of blog
 * 
 * @author emanuel
 *
 */
public class BlogDAOTest extends DaoTestBase{

	@Resource
	private BlogDAO blogDAO;
	
	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	
	@Resource
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Test
	@Transactional
	public void testFindById() {
		Blog blog = BlogFixture.createBlogOfPedro();
		this.userDAO.save(blog.getAdmin());
		this.blogDAO.save(blog);
		
		Blog blogFromDataBase = this.blogDAO.findBy(blog.getId());
		
		assertEqualsBlog(blog, blogFromDataBase);
	}
	

	@Test
	@Transactional
	public void testFindByUrl() {
		Blog blog = BlogFixture.createBlogOfPedro();
		this.userDAO.save(blog.getAdmin());
		this.blogDAO.save(blog);
		
		Blog blogFromDataBase = this.blogDAO.findBlogByUrl(blog.getUrl());
		
		assertEqualsBlog(blog, blogFromDataBase);		
	}
	
	private void assertEqualsBlog(Blog blog, Blog blogFromDataBase) {
		assertEquals(blog.getId(), blogFromDataBase.getId());
		assertEquals(blog.getSubTitle(), blogFromDataBase.getSubTitle());
		assertEquals(blog.getTitle(), blogFromDataBase.getTitle());
		assertEquals(blog.getCreationDate(), blogFromDataBase.getCreationDate());
		assertEquals(blog.getUrl(), blogFromDataBase.getUrl());
		
		assertEquals(blog.getStyle().getCss(), blogFromDataBase.getStyle().getCss());
		
		Iterator<Author> itAuthor = blog.getAuthors().iterator();
		Iterator<Author> itAuthorFromDataBase = blogFromDataBase.getAuthors().iterator();
		
		while (itAuthor.hasNext()) {
			Author author = itAuthor.next();
			Author authorFromDataBase = itAuthorFromDataBase.next();
			
			assertEqualsUsers(author.getUser(), authorFromDataBase.getUser());
		}
		
		assertEqualsUsers(blogFromDataBase.getAdmin(), blog.getAdmin());	
		
	}

	private void assertEqualsUsers(User aPerson, User personSaved) {
		assertEquals(aPerson, personSaved);
		assertEquals(aPerson.getEmails(), personSaved.getEmails());
		assertEquals(aPerson.getActive(), personSaved.getActive());
		assertEquals(aPerson.getBirthDate(), personSaved.getBirthDate());
		assertEquals(aPerson.getName(), personSaved.getName());
		assertEquals(aPerson.getPassword(), personSaved.getPassword());
	}
	
	
}
