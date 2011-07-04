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
	
	private PostService postService;
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	@GET
	@Path("/{blogId}/{from}")
	@Produces("application/json")
	public List<PostDTO> findPostsPublishedByBlogId(@PathParam("blogId") Long blogId, @PathParam("from") Integer from) {
		List<PostDTO> posts = this.postService.findPostsPublishedByBlogId(blogId, from, 10);
		return posts;
	}


}
