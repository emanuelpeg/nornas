/**
 * 
 */
package org.assembly.nornas.web.post;

import java.util.ArrayList;
import java.util.List;

import org.apache.click.control.Form;
import org.apache.click.control.HiddenField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextArea;
import org.apache.click.control.TextField;
import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.extras.control.PageSubmit;
import org.apache.click.util.Bindable;
import org.assembly.dto.post.PostDTO;
import org.assembly.dto.tag.TagDTO;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.service.post.PostService;
import org.assembly.nornas.web.error.MessageErrorPage;
import org.assembly.nornas.web.security.SecurityPage;
import org.assembly.nornas.web.welcomeUser.WelcomeUserPage;

/**
 * @author emanuel
 *
 */
public class EditPostPage extends SecurityPage {
	
	private static final long serialVersionUID = 5038825388433636129L;
	
	@InjectBean
	private PostService postService;
	
	@Bindable
	private Long blogId;
	
	@Bindable
	private Long postId;
	
	private PostDTO post;
	
	private Form postForm = new Form("postForm");
	
	public EditPostPage() {
		super();
	}
	
    @Override
    public void onInit() {
    	super.onInit();
		createPostForm();
    }

    private void createPostForm() {
    	
    	postForm.setJavaScriptValidation(true);
    	postForm.setMethod("POST");
    	
    	TextField title = new TextField("title", true);
    	TextArea content = new TextArea("content", true);
    	content.setCols(100);
    	content.setRows(10);
    	TextField tags = new TextField("tags");
    	
    	String postIdStr = this.getContext().getRequestParameter("postId");
    	
    	if (postIdStr != null) {
    		HiddenField hiddenPostId = new HiddenField("postId", postIdStr);
    		postForm.add(hiddenPostId);
    		
    		PostDTO post = postService.get(Long.parseLong(postIdStr));
    		
    		title.setValue(post.getTitle());
    		content.setValue(post.getContent());
    		tags.setValue(post.getTagsToStr());
    	} else {
    		String blogIdStr = this.getContext().getRequestParameter("blogId");
        	HiddenField hiddenBlogId = new HiddenField("blogId", blogIdStr);
        	postForm.add(hiddenBlogId);
    	}
    	
    	postForm.add(title);
    	postForm.add(content);
    	postForm.add(tags);
    	
    	postForm.add(new Submit("save", getMessage("post.save"), this, "onSubmitEditForm"));
		
    	Submit cancel = new PageSubmit("cancel", WelcomeUserPage.class);
        cancel.setCancelJavaScriptValidation(true);
        postForm.add(cancel);

    	
		addControl(postForm);
	}
    
    public boolean onSubmitEditForm() {
    	if (postForm.isValid()) {
    		String title = postForm.getFieldValue("title");
			String content = postForm.getFieldValue("content");
			String tags = postForm.getFieldValue("tags");
			
			String postIdStr = this.getContext().getRequestParameter("postId");
			String blogIdStr = this.getContext().getRequestParameter("blogId");
			
			List<TagDTO> tagsDTO = new ArrayList<TagDTO>();
			
			for (String tag : tags.split(",")) {
				tagsDTO.add(new TagDTO(tag.trim()));
			}
			
			if (post == null) {
				post = new PostDTO();
			}
			
			post.setTags(tagsDTO);
			post.setContent(content);
			post.setTitle(title);
			
			UserDTO user = this.getUser();
			
			post.setAuthor(user.getNick());
			
			if (blogIdStr != null) {
				post.setBlogId(Long.parseLong(blogIdStr));				
			} 
			
			if (postIdStr != null) {
				post.setId(Long.parseLong(postIdStr));				
			} 
			
			postService.save(post);
			
			String url = getContext().getPagePath(WelcomeUserPage.class);
			setRedirect(url);
			return true;
    	}
    	return false;
    }
    
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}
	

}
