/**
 * 
 */
package org.assembly.nornas.synchronizerTest.blog;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.blog.fixture.BlogDTOFixture;
import org.assembly.dto.user.UserDTO;
import org.assembly.dto.user.fixture.UserDTOFixture;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.model.user.fixture.UserFixture;
import org.assembly.nornas.repository.blog.BlogRepository;
import org.assembly.nornas.repository.user.UserRepository;
import org.assembly.nornas.synchronizer.blog.SynchronizerBlog;
import org.assembly.nornas.synchronizerTest.SynchronizerTestBase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 *
 *	Test of SynchronizerPerson
 *
 */
public class SynchronizerBlogTest extends SynchronizerTestBase {

	@Resource
	private SynchronizerBlog synchronizerBlog;
	
	@Resource
	private BlogRepository blogDAO;
	
	@Resource
	private UserRepository userDAO;
	
	@Test
	public void synchronizerUnsavedBlog() {
		BlogDTO dto = BlogDTOFixture.createBlogOfPedro();
		Blog blog = this.synchronizerBlog.synchronize(dto);
		
		verifyBlog(dto, blog);
		// the creation date of DTO is null, but the creation date of blog is not null.
		verifyPerson(dto.getAdmin(), blog.getAdmin());	
	}

	@Transactional
	@Test
	public void synchronizerSavedPerson() {
		Blog blog = BlogFixture.createBlogOfPedro();
		this.userDAO.save(blog.getAdmin());
		this.blogDAO.save(blog);
		
		BlogDTO dto = BlogDTOFixture.createBlogOfEmanuel();
		dto.setId(blog.getId());
		
		Blog otherBlog = this.synchronizerBlog.synchronize(dto);
		
		verifyBlog(dto, otherBlog);
		assertEquals(otherBlog.getCreationDate(), dto.getCreationDate());
		//A syncronize don't change admin of Blog.
	}
	
	
	private void verifyBlog(BlogDTO blogDTO, Blog blog) {
		
		assertEquals(blog.getId(), blogDTO.getId());
		assertEquals(blog.getSubTitle(), blogDTO.getSubTitle());
		assertEquals(blog.getTitle(), blogDTO.getTitle());
		assertEquals(blog.getUrl(), blogDTO.getUrl());
		
		assertEquals(blog.getStyle().getCss(), blogDTO.getStyle().getCss());
		
	}
	
	private void verifyPerson(UserDTO dto, User user) {
		assertEquals(dto.getName(), user.getName());
		assertEquals(dto.getNick(), user.getNick());
		assertEquals(dto.getBirthDate(), user.getBirthDate());
		assertEquals(dto.getEmails(), user.getEmails());	
	}
	
}
