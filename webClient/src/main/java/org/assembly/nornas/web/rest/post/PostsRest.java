/**
 * 
 */
package org.assembly.nornas.web.rest.post;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.assembly.dto.post.PostDTO;
import org.assembly.nornas.service.post.PostService;


/**
 * 
 * 
 * @author emanuel
 */
@Path("/posts")
public class PostsRest {
	
	public static final int NUMBER_OF_POST = 10;
	
	private PostService postService;
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	@GET
	@Path("/{blogId}/{from}")
	@Produces("application/json")
	public List<PostDTO> findPostsPublishedByBlogId(@PathParam("blogId") Long blogId, @PathParam("from") Integer from) {
		List<PostDTO> posts = this.postService.findPostsPublishedByBlogId(blogId, from, NUMBER_OF_POST);
		return posts;
	}


	@GET
	@Path("/count/{blogId}")
	@Produces("application/json")
	public Long countPostsPublishedByBlogId(@PathParam("blogId") Long blogId) {
		return this.postService.countPostsPublishedByBlogId(blogId);
	}
	
}
