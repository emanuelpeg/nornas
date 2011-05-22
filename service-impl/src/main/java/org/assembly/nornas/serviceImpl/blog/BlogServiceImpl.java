/**
 * 
 */
package org.assembly.nornas.serviceImpl.blog;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.repository.blog.BlogRepository;
import org.assembly.nornas.service.blog.BlogService;
import org.assembly.nornas.serviceImpl.BaseServiceImpl;
import org.assembly.nornas.synchronizer.Synchronizer;
import org.osoa.sca.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author emanuel
 * 
 *         Implementation of {@link BlogService}
 *
 */
@Service(BlogService.class)
public class BlogServiceImpl extends BaseServiceImpl implements BlogService {

	
	private BlogRepository blogDAO;
	
	public void setBlogDAO(BlogRepository blogDAO) {
		this.blogDAO = blogDAO;
	}

	private Synchronizer<BlogDTO, Blog> synchronizerBlog;
	
	public void setSynchronizerBlog(Synchronizer<BlogDTO, Blog> synchronizerBlog) {
		this.synchronizerBlog = synchronizerBlog;
	}

	/**
	 * @see org.assembly.nornas.service.blog.BlogService#saveBlog(org.assembly.dto.blog.BlogDTO)
	 */
	@Transactional
	@Override
	public Long saveBlog(BlogDTO blogDTO) {
		Blog blog = this.synchronizerBlog.synchronize(blogDTO);
		blogDAO.save(blog);
		
		return blog.getId();
	}

	/**
	 * @see org.assembly.nornas.service.blog.BlogService#findBlogByUrl(java.lang.String)
	 */
	@Transactional
	@Override
	public BlogDTO findBlogByUrl(String url) {
		
		Blog blog = this.blogDAO.findBlogByUrl(url);
		
		if (blog == null) {
			return null;
		}
		
		return this.getDtoMapper().map(blog, BlogDTO.class, "blog_blogDTO");
	}


}
