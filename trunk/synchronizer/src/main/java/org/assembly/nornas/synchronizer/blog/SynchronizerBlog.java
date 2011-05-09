/**
 * 
 */
package org.assembly.nornas.synchronizer.blog;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.style.StyleDTO;
import org.assembly.dto.user.UserDTO;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.style.Style;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.repository.blog.BlogRepository;
import org.assembly.nornas.synchronizer.Synchronizer;

/**
 * @author emanuel
 * 
 *  class responsible of synchronize person with personDTO
 *
 */
public class SynchronizerBlog implements Synchronizer<BlogDTO, Blog>{
	
	private BlogRepository blogDAO;
	
	public void setBlogDAO(BlogRepository blogDAO) {
		this.blogDAO = blogDAO;
	}
	
	
	private Synchronizer<UserDTO, User> userSynchronizer;
	
	public void setUserSynchronizer(Synchronizer<UserDTO, User> userSynchronizer) {
		this.userSynchronizer = userSynchronizer;
	}

	
	private Synchronizer<StyleDTO, Style> styleSynchronizer;
	
	public void setStyleSynchronizer(Synchronizer<StyleDTO, Style> styleSynchronizer) {
		this.styleSynchronizer = styleSynchronizer;
	}


	public Blog synchronize(BlogDTO dto) {
		Blog aBlog = null;
		
		if (dto.getId() != null) {
			aBlog = this.blogDAO.findBy(dto.getId());
			
			aBlog.setUrl(dto.getUrl());
			aBlog.setTitle(dto.getTitle());
			aBlog.setSubTitle(dto.getSubTitle());
			aBlog.setCreationDate(dto.getCreationDate());
		} else {
			User admin = this.userSynchronizer.synchronize(dto.getAdmin());
			aBlog = new Blog(dto.getUrl(), dto.getTitle(), dto.getSubTitle(), admin);
		}
		
		Style style = this.styleSynchronizer.synchronize(dto.getStyle());
		aBlog.setStyle(style);
		
		return aBlog;
	}

}
