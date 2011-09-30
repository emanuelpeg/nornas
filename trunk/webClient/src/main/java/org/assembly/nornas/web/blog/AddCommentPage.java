/**
 * 
 */
package org.assembly.nornas.web.blog;

import org.apache.click.Page;
import org.apache.click.util.Bindable;

/**
 * @author emanuel
 *
 */
public class AddCommentPage extends Page {

	private static final long serialVersionUID = -7064160715639365942L;
	
	@Bindable
	private String postId;

	
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	} 
	

}
