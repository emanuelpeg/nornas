/**
 * 
 */
package org.assembly.nornas.service.blog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.assembly.dto.blog.BlogDTO;
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
public interface BlogService {
	
	@WebMethod(operationName="saveBlog")
	Long saveBlog(@WebParam BlogDTO blog);
	
	@WebMethod(operationName="findBlogByUrl")
	BlogDTO findBlogByUrl(@WebParam String url);
	
	
}
