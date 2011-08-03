/**
 * 
 */
package org.assembly.nornas.web.rest.post;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.assembly.dto.post.PostDTO;
import org.assembly.dto.tag.TagDTO;
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
	public List<PostDTO> findPostsPublishedByBlogId(@PathParam("blogId") Long blogId, @PathParam("from") Integer from,  @DefaultValue(StringUtils.EMPTY) @QueryParam("tag") String tag) {
		List<PostDTO> posts = this.postService.findPostsPublishedByBlogId(blogId, from * NUMBER_OF_POST, NUMBER_OF_POST, tag);
		return posts;
	}


	@GET
	@Path("/count/{blogId}")
	@Produces("application/json")
	public Long countPostsPublishedByBlogId(@PathParam("blogId") Long blogId, @DefaultValue(StringUtils.EMPTY) @QueryParam("tag") String tag) {
		return this.postService.countPostsPublishedByBlogId(blogId, tag);
	}
	
	@GET
	@Path("/tags/{blogId}")
	@Produces("application/json")
	public List<TagDTO> getTagsByBlogId(@PathParam("blogId") Long blogId) {
		return this.postService.getTagsByBlogId(blogId);
	}
	
}
