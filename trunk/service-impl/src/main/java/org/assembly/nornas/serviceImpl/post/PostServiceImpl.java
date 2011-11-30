/**
 * 
 */
package org.assembly.nornas.serviceImpl.post;

import java.util.Calendar;
import java.util.List;

import org.assembly.dto.post.PostDTO;
import org.assembly.dto.post.PostHistoryDTO;
import org.assembly.dto.post.PostsHistoryMonth;
import org.assembly.dto.post.PostsHistoryRoot;
import org.assembly.dto.post.PostsHistoryYear;
import org.assembly.dto.tag.TagDTO;
import org.assembly.norna.common.util.transformer.DozerTransformer;
import org.assembly.nornas.model.comment.Comment;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.post.StatePost;
import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.repository.post.PostRepository;
import org.assembly.nornas.repository.tag.TagRepository;
import org.assembly.nornas.repository.user.UserRepository;
import org.assembly.nornas.service.post.PostService;
import org.assembly.nornas.serviceImpl.BaseServiceImpl;
import org.assembly.nornas.synchronizer.post.SynchronizerPost;
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
	
	private SynchronizerPost synchronizerPost;
	
	public void setSynchronizerPost(SynchronizerPost synchronizerPost) {
		this.synchronizerPost = synchronizerPost;
	}

	private TagRepository tagDAO;
	
	public void setTagDAO(TagRepository tagDAO) {
		this.tagDAO = tagDAO;
	}

	private UserRepository userDAO;
	
	public void setUserDAO(UserRepository userDAO) {
		this.userDAO = userDAO;
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
	@Transactional
	public List<TagDTO> getTagsByBlogId(Long blogId) {
		List<Tag> tags = tagDAO.findByBlogId(blogId);
		
		DozerTransformer<TagDTO, Tag> transformer = new DozerTransformer<TagDTO, Tag>(this.getDtoMapper(), TagDTO.class);
		
		return transformer.transformar(tags, "tag_tagDTO");
	}

	@Override
	@Transactional
	public PostsHistoryRoot getHistoryByBlogId(Long blogId) {
		List<Post> posts = postDAO.findPostsPublished();

		DozerTransformer<PostHistoryDTO, Post> transformer = new DozerTransformer<PostHistoryDTO, Post>(this.getDtoMapper(), PostHistoryDTO.class);
		
		List<PostHistoryDTO> postsDTO = transformer.transformar(posts, "post_postHistoryDTO");
		
		return createTree(postsDTO);
	}

	private PostsHistoryRoot createTree(List<PostHistoryDTO> postsDTO) {
		PostsHistoryRoot root = new PostsHistoryRoot();
		
		PostsHistoryYear postYear = null;
		PostsHistoryMonth postMonth = null;
		
		for (PostHistoryDTO post : postsDTO) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(post.getPublishDate());
			Integer year = calendar.get(Calendar.YEAR);
			Integer month = calendar.get(Calendar.MONTH) + 1;
			
			if (postYear == null || !postYear.getYear().equals(year)) {
				postYear = new PostsHistoryYear(year);
				root.getYears().add(postYear);
			}
			
			if (postMonth == null || !postMonth.getMonth().equals(month)) {
				postMonth = new PostsHistoryMonth(month);
				postYear.getMonths().add(postMonth);
			}
			
			postMonth.getPosts().add(post);
			
		}

		return root;
	}

	@Override
	@Transactional
	public void addComment(Long postId, String comment) {
		Post post = this.postDAO.findBy(postId);
		User author = this.userDAO.findAll().get(0); 
		post.getComments().add(new Comment(post, comment, author));
		this.postDAO.save(post);
	}

	@Override
	@Transactional
	public PostDTO get(Long postId) {
		Post post = this.postDAO.findBy(postId);
		return this.getDtoMapper().map(post, PostDTO.class, "post_postDTO");
	}

	@Override
	public void save(PostDTO postDTO) {
		Post post = synchronizerPost.synchronize(postDTO);
		post.setPublishDate(Calendar.getInstance().getTime());
		post.setState(StatePost.PUBLISHED);
		this.postDAO.save(post);
	}


}
