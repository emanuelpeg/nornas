/**
 * 
 */
package org.assembly.mapper.blog;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.user.UserDTO;

import org.assembly.mapper.DozerTest;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.user.User;
import org.dozer.DozerBeanMapper;
import org.junit.Test;

/**
 * @author emanuel
 * 
 * Test of Dozer's mapping by Person
 *
 */
public class BlogToBlogDTOTest extends DozerTest {
	
	@Resource
	private DozerBeanMapper dtoMapper;
	
	@Test
	public void map() {
		Blog blog = BlogFixture.createBlogOfPedro();
		BlogDTO blogDTO = this.dtoMapper.map(blog, BlogDTO.class, "blog_blogDTO");
		
		verifyBlog(blogDTO, blog);
	}

	private void verifyBlog(BlogDTO blogDTO, Blog blog) {
		
		assertEquals(blog.getId(), blogDTO.getId());
		assertEquals(blog.getSubTitle(), blogDTO.getSubTitle());
		assertEquals(blog.getTitle(), blogDTO.getTitle());
		assertEquals(blog.getCreationDate(), blogDTO.getCreationDate());
		assertEquals(blog.getUrl(), blogDTO.getUrl());
		
		assertEquals(blog.getStyle().getCss(), blogDTO.getStyle().getCss());
		
		verifyPerson(blogDTO.getAdmin(), blog.getAdmin());		
	}
	
	private void verifyPerson(UserDTO dto, User user) {
		assertEquals(dto.getName(), user.getName());
		assertEquals(dto.getNick(), user.getNick());
		assertEquals(dto.getBirthDate(), user.getBirthDate());
		assertEquals(dto.getEmails(), user.getEmails());	
	}

}
