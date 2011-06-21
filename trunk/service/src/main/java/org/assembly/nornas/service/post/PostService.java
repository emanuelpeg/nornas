/**
 * 
 */
package org.assembly.nornas.service.post;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.assembly.dto.post.PostDTO;
import org.osoa.sca.annotations.Remotable;

/**
 * 
 * @author emanuel
 * 
 *   Interface represents services of Blog
 *
 */
@Remotable
@WebService
public interface PostService {
	
	@WebMethod(operationName="findPostsByBlogId")
	List<PostDTO> findPostsPublishedByBlogId(@WebParam Long blogId, @WebParam Integer from, @WebParam Integer sizes);
	
	
}
