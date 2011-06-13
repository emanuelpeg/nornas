/**
 * 
 */
package org.assembly.nornas.model.post.fixture;

import java.util.ArrayList;
import java.util.List;

import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.blog.fixture.BlogFixture;
import org.assembly.nornas.model.comment.CommentFixture;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.post.StatePost;
import org.assembly.nornas.model.tag.Tag;


/**
 * @author emanuel
 * 
 * Fixture of author
 *
 */
public class PostFixture {

	public static List<Post> createPosts(Blog blog) {
		List<Post> posts = new ArrayList<Post>();
		posts.add(PostFixture.createPostsPublished("titulo1","contenido1", blog));
		posts.add(PostFixture.createPostsDraft("titulo2","contenido2", blog));
		posts.add(PostFixture.createPostsPublished("titulo3","contenido3", blog));
		posts.add(PostFixture.createPostsPublished("titulo4","contenido4", blog));
		posts.add(PostFixture.createPostsDraft("titulo5","contenido5", blog));
		posts.add(PostFixture.createPostsPublished("titulo6","contenido6", blog));
		posts.add(PostFixture.createPostsPublished("titulo7","contenido7", blog));
		posts.add(PostFixture.createPostsPublished("titulo8","contenido8", blog));
		posts.add(PostFixture.createPostsDraft("titulo9","contenido9", blog));
		posts.add(PostFixture.createPostsPublished("titulo10","contenido10", blog));
		posts.add(PostFixture.createPostsPublished("titulo11","contenido11", blog));
		posts.add(PostFixture.createPostsPublished("titulo12","contenido12", blog));
		posts.add(PostFixture.createPostsPublished("titulo13","contenido13", blog));
		posts.add(PostFixture.createPostsPublished("titulo14","contenido14", blog));
		return posts;
	}

	public static Post createPostsPublished(String title, String content, Blog blog) {
		Post post = new Post(title, content, blog.getAuthors().iterator().next());
		post.setState(StatePost.PUBLISHED);
		return post;
	}

	public static Post createPostsDraft(String title, String content, Blog blog) {
		Post post = new Post(title, content, blog.getAuthors().iterator().next());
		post.setState(StatePost.DRAFT);
		return post;
	}

	public static Post createPost() {
		Blog blog = BlogFixture.createBlogOfEmanuel();
		Post post = new Post("titulo", "content", new Author(blog.getAdmin(),blog));
		post.setState(StatePost.PUBLISHED);
		post.setComments(CommentFixture.createComments(post));
		post.setTags(createTags());
		return post;
	}

	private static List<Tag> createTags() {
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(new Tag("trabajo"));
		tags.add(new Tag("ocio"));
		tags.add(new Tag("vacas"));
		tags.add(new Tag("toros"));
		return tags;
	}
	
}
