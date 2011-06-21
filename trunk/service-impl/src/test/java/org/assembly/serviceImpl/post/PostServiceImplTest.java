/**
 * 
 */
package org.assembly.serviceImpl.post;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.blog.fixture.BlogDTOFixture;
import org.assembly.dto.post.PostDTO;
import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.post.fixture.PostFixture;
import org.assembly.nornas.persistence.author.AuthorDAO;
import org.assembly.nornas.persistence.blog.BlogDAO;
import org.assembly.nornas.persistence.post.PostDAO;
import org.assembly.nornas.persistence.user.UserDAO;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.service.post.PostService;
import org.assembly.nornas.serviceImpl.user.UserServiceImpl;
import org.assembly.serviceImpl.BaseServiceTest;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 * 
 *         Test of PostServiceImpl
 * 
 */
public class PostServiceImplTest extends BaseServiceTest {

	@Resource(name="service.post")
	private PostService postService;
	
	@Resource
	private PostDAO postDAO;

	@Resource
	private BlogDAO blogDAO;

	@Resource
	private UserDAO userDAO;
	
	@Resource
	private AuthorDAO authorDAO;
	
	@Test
	@Transactional //transaccional test because this use daos
	public void findPostsPublishedByBlogId() {
		Blog blog = BlogFixture.createBlogOfEmanuel();
		
		userDAO.save(blog.getAdmin());
		blogDAO.save(blog);
		
		Author author = blog.getAuthors().iterator().next();
		authorDAO.save(author);
		
		blog.setPosts(PostFixture.createPosts(blog));
		blogDAO.save(blog);
		
		Blog blogSaved = blogDAO.findBy(blog.getId());
		assertEquals(blogSaved.getPosts().size(), 14);
		
		List<PostDTO> posts =postService.findPostsPublishedByBlogId(blogSaved.getId(), 0, 28);
		assertEquals(posts.size(), 11);
		
		posts =postService.findPostsPublishedByBlogId(blogSaved.getId(), 0, 10);
		assertEquals(posts.size(), 10);
		
		posts =postService.findPostsPublishedByBlogId(blogSaved.getId(), 4, 10);
		assertEquals(posts.size(), 7);
		
		posts =postService.findPostsPublishedByBlogId(blogSaved.getId(), 5, 10);
		assertEquals(posts.size(), 6);
		
	}

}
