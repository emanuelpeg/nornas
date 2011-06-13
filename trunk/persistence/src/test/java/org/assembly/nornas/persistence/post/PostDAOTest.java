/**
 * 
 */
package org.assembly.nornas.persistence.post;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.post.fixture.PostFixture;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.persistence.DaoTestBase;
import org.assembly.nornas.persistence.author.AuthorDAO;
import org.assembly.nornas.persistence.blog.BlogDAO;
import org.assembly.nornas.persistence.user.UserDAO;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao's test of blog
 * 
 * @author emanuel
 *
 */
public class PostDAOTest extends DaoTestBase{

	@Resource
	private PostDAO postDAO;

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
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
	
	@Resource
	private AuthorDAO authorDAO;
	
	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}
	
	@Test
	@Transactional
	public void findPostsByBlogId() {
		Blog blog = BlogFixture.createBlogOfEmanuel();
				
		userDAO.save(blog.getAdmin());
		blogDAO.save(blog);
		
		Author author = new Author(blog.getAdmin(), blog);
		authorDAO.save(author);
		
		blog.getAuthors().add(author);
		blog.setPosts(PostFixture.createPosts(blog));
		blogDAO.save(blog);
		
		Blog blogSaved = blogDAO.findBy(blog.getId());
		assertEquals(blogSaved.getPosts().size(), 14);
		
		List<Post> posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 0, 28);
		assertEquals(posts.size(), 11);
		
		posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 0, 10);
		assertEquals(posts.size(), 10);
		
		posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 4, 10);
		assertEquals(posts.size(), 7);
		
		posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 5, 10);
		assertEquals(posts.size(), 6);
	}
	
	
}
