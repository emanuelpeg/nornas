/**
 * 
 */
package org.assembly.nornas.service.post;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.assembly.dto.post.PostDTO;
import org.assembly.dto.post.PostHistoryDTO;
import org.assembly.dto.post.PostsHistoryRoot;
import org.assembly.dto.tag.TagDTO;
import org.osoa.sca.annotations.Remotable;

/**
 * 
 * @author emanuel
 * 
 *         Interface represents services of Blog
 * 
 */
@Remotable
@WebService
public interface PostService {

	@WebMethod(operationName = "findPostsByBlogId")
	List<PostDTO> findPostsPublishedByBlogId(@WebParam Long blogId,
			@WebParam Integer from, @WebParam Integer sizes,
			@WebParam String tag);

	@WebMethod(operationName = "countPostsPublishedByBlogId")
	Long countPostsPublishedByBlogId(@WebParam Long blogId, @WebParam String tag);

	@WebMethod(operationName = "getTagsByBlogId")
	List<TagDTO> getTagsByBlogId(@WebParam Long blogId);

	@WebMethod(operationName = "getHistoryByBlogId")
	PostsHistoryRoot getHistoryByBlogId(Long blogId);

	@WebMethod(operationName = "addComment")
	void addComment(@WebParam Long postId, @WebParam String comment);

}
