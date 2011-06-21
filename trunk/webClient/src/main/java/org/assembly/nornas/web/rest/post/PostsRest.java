/**
 * 
 */
package org.assembly.nornas.web.rest.post;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


/**
 * 
 * 
 * @author emanuel
 */
@Path("/posts")
public class PostsRest {
	
	@GET
	public String getPosts() {
		return "posts";
	}


}
