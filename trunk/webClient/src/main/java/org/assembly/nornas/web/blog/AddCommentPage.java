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

	@Bindable
	private String urlAddComment;
	
	@Bindable
	private String urlRefreshPost;
	
	@Bindable
	private String urlPost;
	
	@Bindable
	private Long blogID;
	
	@Override
	public void onInit() {
		super.onInit();
		urlAddComment = this.getContext().getRequest().getContextPath() + "/blogRest/posts/addComment/" + postId + "/";
		urlRefreshPost = this.getContext().getRequest().getContextPath() + "/blogRest/posts/" + postId + "/";
		urlPost = this.getContext().getRequest().getContextPath() + "/blogRest/posts/";
	}
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUrlAddComment() {
		return urlAddComment;
	}

	public void setUrlAddComment(String urlAddComment) {
		this.urlAddComment = urlAddComment;
	}

	public String getUrlRefreshPost() {
		return urlRefreshPost;
	}

	public void setUrlRefreshPost(String urlRefreshPost) {
		this.urlRefreshPost = urlRefreshPost;
	}

	public String getUrlPost() {
		return urlPost;
	}

	public void setUrlPost(String urlPost) {
		this.urlPost = urlPost;
	}

	public Long getBlogID() {
		return blogID;
	}

	public void setBlogID(Long blogID) {
		this.blogID = blogID;
	} 
	
}
