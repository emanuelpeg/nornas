/**
 * 
 */
package org.assembly.nornas.web.post;

import java.util.ArrayList;
import java.util.List;

import org.apache.click.control.Form;
import org.apache.click.control.Submit;
import org.apache.click.control.TextArea;
import org.apache.click.control.TextField;
import org.apache.click.doubleclick.inject.annotation.InjectBean;
import org.apache.click.extras.control.PageSubmit;
import org.apache.click.util.Bindable;
import org.assembly.dto.post.PostDTO;
import org.assembly.dto.tag.TagDTO;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.service.post.PostService;
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
		createPostForm();
	}
	
    @Override
    public void onInit() {
    	super.onInit();
    }

    private void createPostForm() {
    	
    	postForm.setJavaScriptValidation(true);
    	postForm.setMethod("POST");
    	
    	TextField title = new TextField("title", true);
    	TextArea content = new TextArea("content", true);
    	content.setCols(100);
    	content.setRows(10);
    	TextField tags = new TextField("tags");
    	
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
			
			List<TagDTO> tagsDTO = new ArrayList<TagDTO>();
			
			for (String tag : tags.split(",")) {
				tagsDTO.add(new TagDTO(tag));
			}
			
			if (post == null) {
				post = new PostDTO();
			}
			
			post.setTags(tagsDTO);
			post.setContent(content);
			post.setTitle(title);
			
			UserDTO user = this.getUser();
			
			post.setAuthor(user.getNick());
			
			postService.save(post);
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
