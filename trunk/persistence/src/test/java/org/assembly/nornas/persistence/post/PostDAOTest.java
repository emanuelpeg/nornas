/**
 * 
 */
package org.assembly.nornas.persistence.post;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.comment.Comment;
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
		
		Author author = blog.getAuthors().iterator().next();
		authorDAO.save(author);
		
		blog.setPosts(PostFixture.createPosts(blog));
		blogDAO.save(blog);
		
		Blog blogSaved = blogDAO.findBy(blog.getId());
		assertEquals(blogSaved.getPosts().size(), 14);
		
		List<Post> posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 0, 28, StringUtils.EMPTY);
		assertEquals(posts.size(), 11);
		
		posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 0, 10, StringUtils.EMPTY);
		assertEquals(posts.size(), 10);
		
		posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 4, 10, StringUtils.EMPTY);
		assertEquals(posts.size(), 7);
		
		posts =postDAO.findPostsPublishedByBlogId(blog.getId(), 5, 10, StringUtils.EMPTY);
		assertEquals(posts.size(), 6);
	}
	
	@Test
	@Transactional
	public void countPostsByBlogId() {
		Blog blog = BlogFixture.createBlogOfEmanuel();
				
		userDAO.save(blog.getAdmin());
		blogDAO.save(blog);
		
		Author author = blog.getAuthors().iterator().next();
		authorDAO.save(author);
		
		blog.setPosts(PostFixture.createPosts(blog));
		blogDAO.save(blog);
		
		Blog blogSaved = blogDAO.findBy(blog.getId());
		assertEquals(14, blogSaved.getPosts().size());
		assertEquals(new Long(11), postDAO.countPostsPublishedByBlogId(blogSaved.getId(), StringUtils.EMPTY));
	}
	
	@Test
	@Transactional
	public void findPostsWithComment() {
		Blog blog = BlogFixture.createBlogOfEmanuel();
				
		userDAO.save(blog.getAdmin());
		blogDAO.save(blog);
		
		Author author = blog.getAuthors().iterator().next();
		authorDAO.save(author);
		
		blog.setPosts(PostFixture.createPosts(blog));
		blogDAO.save(blog);
		
		Post post = blog.getPosts().get(0);
		post.getComments().add(new Comment(post, "Muy bueno", author.getUser()));
		
		postDAO.save(post);
		
		Post postSaved = postDAO.findBy(post.getId());
		assertEquals(1, postSaved.getComments().size());
	}
	
}
