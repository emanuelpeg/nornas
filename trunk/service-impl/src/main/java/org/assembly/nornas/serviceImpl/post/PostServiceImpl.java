/**
 * 
 */
package org.assembly.nornas.serviceImpl.post;

import java.util.List;

import org.assembly.dto.post.PostDTO;
import org.assembly.dto.tag.TagDTO;
import org.assembly.norna.common.util.transformer.DozerTransformer;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.repository.post.PostRepository;
import org.assembly.nornas.repository.tag.TagRepository;
import org.assembly.nornas.service.post.PostService;
import org.assembly.nornas.serviceImpl.BaseServiceImpl;
import org.osoa.sca.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

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

	private TagRepository tagDAO;
	
	public void setTagDAO(TagRepository tagDAO) {
		this.tagDAO = tagDAO;
	}

	@Override
	@Transactional
	public List<PostDTO> findPostsPublishedByBlogId(Long blogId, Integer from,
			Integer sizes, String tag) {
		
		List<Post> posts = postDAO.findPostsPublishedByBlogId(blogId, from, sizes, tag);
		
		DozerTransformer<PostDTO, Post> transformer = new DozerTransformer<PostDTO, Post>(this.getDtoMapper(), PostDTO.class);
		
		return transformer.transformar(posts, "post_postDTO");
	}

	@Override
	@Transactional
	public Long countPostsPublishedByBlogId(Long blogId, String tag) {
		return postDAO.countPostsPublishedByBlogId(blogId, tag);
	}

	@Override
	public List<TagDTO> getTagsByBlogId(Long blogId) {
		List<Tag> tags = tagDAO.findByBlogId(blogId);
		
		DozerTransformer<TagDTO, Tag> transformer = new DozerTransformer<TagDTO, Tag>(this.getDtoMapper(), TagDTO.class);
		
		return transformer.transformar(tags, "tag_tagDTO");
	}


}
