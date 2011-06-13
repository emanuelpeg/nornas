/**
 * 
 */
package org.assembly.nornas.serviceImpl.post;

import java.util.List;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.post.PostDTO;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.repository.blog.BlogRepository;
import org.assembly.nornas.repository.post.PostRepository;
import org.assembly.nornas.service.post.PostService;
import org.assembly.nornas.serviceImpl.BaseServiceImpl;
import org.assembly.nornas.synchronizer.Synchronizer;
import org.osoa.sca.annotations.Service;

/**
 * @author emanuel
 * 
 *         Implementation of {@link PostService}
 *
 */
@Service(PostService.class)
public class PostServiceImpl extends BaseServiceImpl implements PostService {

	
	private PostRepository postDAO;
	
	public void setPostDAO(PostRepository postDAO) {
		this.postDAO = postDAO;
	}

	@Override
	public List<PostDTO> findPostsByBlogId(Long blogId, Integer from,
			Integer sizes) {
		
		List<Post> posts = postDAO.findPostsPublishedByBlogId(blogId, from, sizes);
		
		return null;
	}

	
	
	
	



}
