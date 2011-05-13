/**
 * 
 */
package org.assembly.serviceImpl.blog;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.blog.fixture.BlogDTOFixture;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.serviceImpl.user.UserServiceImpl;
import org.assembly.serviceImpl.BaseServiceTest;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 * 
 *         Test of BlogServiceImpl
 * 
 */
public class BlogServiceImplTest extends BaseServiceTest {

	@Resource(name="service.blog")
	private BlogService blogService;
	
	@Resource(name="service.user")
	private UserServiceImpl userService;
	
	@Test
	public void findByUrl() {
		BlogDTO blogDTOOfPedro = BlogDTOFixture.createBlogOfPedro();
		
		blogDTOOfPedro.getAdmin().setId(userService.saveUser(blogDTOOfPedro.getAdmin()));
		
		blogDTOOfPedro.setId(blogService.saveBlog(blogDTOOfPedro));

		BlogDTO blogDTOOfPedroFromDataBase = blogService.findBlogByUrl(blogDTOOfPedro.getUrl());
		
		verifyBlog(blogDTOOfPedro, blogDTOOfPedroFromDataBase);
	}
	
	private void verifyBlog(BlogDTO blogDTO, BlogDTO blogDTOFromDataBase) {
		
		assertEquals(blogDTOFromDataBase.getId(), blogDTO.getId());
		assertEquals(blogDTOFromDataBase.getSubTitle(), blogDTO.getSubTitle());
		assertEquals(blogDTOFromDataBase.getTitle(), blogDTO.getTitle());
		assertEquals(blogDTOFromDataBase.getUrl(), blogDTO.getUrl());
		
		assertEquals(blogDTOFromDataBase.getStyle().getCss(), blogDTO.getStyle().getCss());
		
		verifyPerson(blogDTO.getAdmin(), blogDTOFromDataBase.getAdmin());		
	}
	
	private void verifyPerson(UserDTO dto, UserDTO userFromDataBase) {
		assertEquals(dto.getName(), userFromDataBase.getName());
		assertEquals(dto.getNick(), userFromDataBase.getNick());
		assertEquals(dto.getBirthDate(), userFromDataBase.getBirthDate());
		assertEquals(dto.getEmails(), userFromDataBase.getEmails());	
	}

}
